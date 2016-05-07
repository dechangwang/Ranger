package cn.edu.tongji.ranger.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wangdechang on 2016/3/14.
 */
public class MD5STo16Byte {
    /**
     * ��16���Ʒ�Χ����ĸ�����ֵ��ַ�ת���ɶ�Ӧ�������� 0��9 a��f��A��F��ת����10��15
     *
     * @param ch
     * @return
     */
    private static char char2Int(char ch) {
        if (ch >= '0' && ch <= '9')
            return (char) (ch - '0');
        if (ch >= 'a' && ch <= 'f')
            return (char) (ch - 'a' + 10);
        if (ch >= 'A' && ch <= 'F')
            return (char) (ch - 'A' + 10);
        return ' ';
    }

    /**
     * �������ַ�ת����һ���ֽڱ�ʾ
     *
     * @param str
     * @return
     */
    private static byte str2Bin(char[] str) {
        byte chn;
        char[] tempWord = new char[2];

        tempWord[0] = char2Int(str[0]); // make the B to 11 -- 00001011
        tempWord[1] = char2Int(str[1]); // make the 0 to 0 -- 00000000
//		System.out.println("tempWord[0]=" + tempWord[0] + " tempWord[1]=" + tempWord[1]);

        chn = (byte) ((tempWord[0] << 4) | tempWord[1]); // to change the BO to
        // 10110000

        return chn;
    }

    /**
     * ��32���ȵ��ַ�����ѹ�����ɱ�׼��16λ�ֽ������MD5
     *
     * @param md5chs32len
     *            32���ȵ�MD5�ַ������ַ�����
     * @return
     */
    public static byte[] compress(char[] md5chs32len) {
        char[] tem = new char[2];
        byte[] sDst = new byte[md5chs32len.length / 2];
        int j = 0;
        for (int i = 0; i + 1 < md5chs32len.length; i += 2) {
            tem[0] = md5chs32len[i];
            tem[1] = md5chs32len[i + 1];
            sDst[j++] = (byte) (str2Bin(tem));
//			System.out.println("tem[0]=" + (int)tem[0] + " tem[1]=" +(int)tem[1] + " sDst["+ (j-1) + "]=" + sDst[j-1]);
        }
        return sDst;
    }

    /**
     * ��16�ֽڵ�MD5����ת����32���ȵ��ַ���
     *
     * @param md5b16
     * @return
     */
    public static String unCompress(byte[] md5b16) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < md5b16.length; i++) {
            byte b = md5b16[i];
            sb.append(Integer.toHexString((b >> 4) & 0x0F));
            sb.append(Integer.toHexString(b & 0x0F));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * ��������MD5�㷨���ܺ�ѹ����16�ֽ�����
     *
     * @param text
     *            ����
     * @return 16�ֽ�����
     * @author sunyiping 2011-10-13 ����12:50:51
     */
    public static byte[] encrypt2MD5toByte16(String text) {
        String md5 = getMD5Str32(text);
//		System.out.println("md5=" + md5);
        if (md5 != null) {
            return compress(md5.toCharArray());
        }
        return null;
    }

    /**
     * ��ȡMD5���ܺ��32λ�ַ���
     *
     * @param str
     *            ����
     * @return ����MD5���ܺ��32λ��
     * @author sunyiping 2011-10-13 ����12:12:45
     */
    public static String getMD5Str32(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }

        return byteToHexString(messageDigest.digest());
    }

    static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    /**
     * ��byte[]����ת����ʮ�������ַ�����ʾ��ʽ
     *
     * @param tmp
     *            Ҫת����byte[]
     * @return ʮ�������ַ�����ʾ��ʽ
     */
    private static String byteToHexString(byte[] tmp) {
        String s;
        // ���ֽڱ�ʾ���� 16 ���ֽ�
        char str[] = new char[16 * 2]; // ÿ���ֽ��� 16 ���Ʊ�ʾ�Ļ���ʹ�������ַ���
        // ���Ա�ʾ�� 16 ������Ҫ 32 ���ַ�
        int k = 0; // ��ʾת������ж�Ӧ���ַ�λ��
        for (int i = 0; i < 16; i++) { // �ӵ�һ���ֽڿ�ʼ���� MD5 ��ÿһ���ֽ�
            // ת���� 16 �����ַ���ת��
            byte byte0 = tmp[i]; // ȡ�� i ���ֽ�
            str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // ȡ�ֽ��и� 4 λ������ת��,
            // >>> Ϊ�߼����ƣ�������λһ������
            str[k++] = hexDigits[byte0 & 0xf]; // ȡ�ֽ��е� 4 λ������ת��
        }
        s = new String(str); // ����Ľ��ת��Ϊ�ַ���
        return s;
    }
}