package cn.edu.tongji.ranger.test;

import org.junit.Test;

/**
 * Created by daidongyang on 5/14/16.
 */
public class TestSwitch {
    @Test
    public void testSwitch(){
        int a = 3;
        switch(a){
            case 1: System.out.println(1);
                break;
            case 2: System.out.println(2);
                break;
            case 3: System.out.println(3);
                System.out.println(3);
                System.out.println(3);
                System.out.println(3);
        }
    }
}
