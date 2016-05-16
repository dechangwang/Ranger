package cn.edu.tongji.ranger.test;

import org.junit.Test;

import java.util.List;

/**
 * Created by daidongyang on 5/16/16.
 */
public class SimpleTest {
    @Test
    public void test(){
//        testSplit();
        testForeach();
    }

    public void testSplit(){
        String str = "hello    world";
        String[] results = str.split("\\s+");
        System.out.println(results.length);
    }

    public void testForeach(){
        List<Long> ls = null;
        for(Long l : ls){
            System.out.println(l);
        }
    }
}
