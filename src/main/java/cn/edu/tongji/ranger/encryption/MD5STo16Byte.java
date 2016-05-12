package cn.edu.tongji.ranger.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wangdechang on 2016/3/14.
 */
public class MD5STo16Byte {
    /**
     * 灏�16杩涘埗鑼冨洿鐨勫瓧姣嶆垨鏁板瓧鐨勫瓧绗﹁浆鎹㈡垚瀵瑰簲鐨勬暣鏁帮紝 0锛�9 a锛峟锝淎锛岶鍒欒浆鎹㈡垚10锛�15
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
     * 灏嗕袱涓瓧绗﹁浆鎹㈡垚涓�涓瓧鑺傝〃绀�
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
     * 灏�32闀垮害鐨勫瓧绗︽暟缁勫帇缂╃敓鎴愭爣鍑嗙殑16浣嶅瓧鑺傛暟缁勭殑MD5
     *
     * @param md5chs32len
     *            32闀垮害鐨凪D5瀛楃涓茬殑瀛楃鏁扮粍
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
     * 灏�16瀛楄妭鐨凪D5鏁扮粍杞崲鎴�32闀垮害鐨勫瓧绗︿覆
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
     * 灏嗘槑鏂囩敤MD5绠楁硶鍔犲瘑鍚庡苟鍘嬬缉鎴�16瀛楄妭鏁扮粍
     *
     * @param text
     *            鏄庢枃
     * @return 16瀛楄妭鏁扮粍
     * @author sunyiping 2011-10-13 涓嬪崍12:50:51
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
     * 鑾峰彇MD5鍔犲瘑鍚庣殑32浣嶅瓧绗︿覆
     *
     * @param str
     *            鏄庢枃
     * @return 杩斿洖MD5鍔犲瘑鍚庣殑32浣嶄覆
     * @author sunyiping 2011-10-13 涓嬪崍12:12:45
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
     * 鎶奲yte[]鏁扮粍杞崲鎴愬崄鍏繘鍒跺瓧绗︿覆琛ㄧず褰㈠紡
     *
     * @param tmp
     *            瑕佽浆鎹㈢殑byte[]
     * @return 鍗佸叚杩涘埗瀛楃涓茶〃绀哄舰寮�
     */
    private static String byteToHexString(byte[] tmp) {
        String s;
        // 鐢ㄥ瓧鑺傝〃绀哄氨鏄� 16 涓瓧鑺�
        char str[] = new char[16 * 2]; // 姣忎釜瀛楄妭鐢� 16 杩涘埗琛ㄧず鐨勮瘽锛屼娇鐢ㄤ袱涓瓧绗︼紝
        // 鎵�浠ヨ〃绀烘垚 16 杩涘埗闇�瑕� 32 涓瓧绗�
        int k = 0; // 琛ㄧず杞崲缁撴灉涓搴旂殑瀛楃浣嶇疆
        for (int i = 0; i < 16; i++) { // 浠庣涓�涓瓧鑺傚紑濮嬶紝瀵� MD5 鐨勬瘡涓�涓瓧鑺�
            // 杞崲鎴� 16 杩涘埗瀛楃鐨勮浆鎹�
            byte byte0 = tmp[i]; // 鍙栫 i 涓瓧鑺�
            str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 鍙栧瓧鑺備腑楂� 4 浣嶇殑鏁板瓧杞崲,
            // >>> 涓洪�昏緫鍙崇Щ锛屽皢绗﹀彿浣嶄竴璧峰彸绉�
            str[k++] = hexDigits[byte0 & 0xf]; // 鍙栧瓧鑺備腑浣� 4 浣嶇殑鏁板瓧杞崲
        }
        s = new String(str); // 鎹㈠悗鐨勭粨鏋滆浆鎹负瀛楃涓�
        return s;
    }
}