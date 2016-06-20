package cn.edu.tongji.ranger.utils;

import java.io.*;

/**
 * Created by daidongyang on 6/7/16.
 */
public class FilePathUtil {
    private String imagesRoot;
    private static FilePathUtil filePathUtil;


    private static boolean setImageRootLater = false;

    public static void setSetImageRootLater(boolean setImageRootLater) {
        FilePathUtil.setImageRootLater = setImageRootLater;
    }

    public static FilePathUtil getInstance(){
        if(null == filePathUtil){
            synchronized (FilePathUtil.class){
                if(null == filePathUtil){
                    filePathUtil = new FilePathUtil();
                    if(!setImageRootLater){
                        try {
//                            System.out.println(System.getProperty("user.dir"));
//                            String configPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
//                                    + "imageroot.cfg";
                            String configPath = "imageroot.cfg";
                            BufferedReader bufferedReader = new BufferedReader(
                                    new InputStreamReader(FilePathUtil.class.getClassLoader()
                                            .getResourceAsStream(configPath)));
                            String imageRoot1 = bufferedReader.readLine();
                            filePathUtil.initImagePath(imageRoot1);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return filePathUtil;
    }


    public void initImagePath(String imagesRoot1){
        String tmp = convert(imagesRoot1);
        this.imagesRoot = tmp.endsWith(File.separator)?tmp:(tmp+File.separator);
    }

    public static String convert(String originPath){
        if(null == originPath){
            return null;
        }
        String resultPath = null;
        String replaceStr = File.separator;
        if(replaceStr.equals("\\")){
            replaceStr = "\\\\";
        }

        resultPath = originPath.replaceAll("\\\\{1,2}|/", "/");
        return resultPath;
    }

    public String getRealImagesPath(String relatativePath){
        return this.imagesRoot + convert(relatativePath);
    }

//    public static void main(String[] args){
//        String testStr = "images\\8-3f.jpg&images\\8-1350954016fUkwCk.jpg";
//        String result  = FilePathUtil.getInstance().getRealImagesPath(testStr);
//        System.out.println(result);
//    }

}
