package cn.edu.tongji.ranger.utils;

import org.junit.Test;

import java.io.File;

/**
 * Created by daidongyang on 6/7/16.
 */
public class FilePathUtilTest {

    @Test
    public void testConvert(){
        String testStr = "images\\8-3f.jpg&images\\8-1350954016fUkwCk.jpg";
        System.out.println(File.separator);
        System.out.println("\\");

        String result  = FilePathUtil.getInstance().getRealImagesPath(testStr);
        System.out.println(result);
    }

}