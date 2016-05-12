package cn.edu.tongji.ranger.dao.impl;

import cn.edu.tongji.ranger.model.Account;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daidongyang on 5/5/16.
 */
public class AccountDaoImplTest {

    @Test
    public void create() throws Exception {
        Account account = new Account();
        account.setName("hello12");
        account.setPassword("111");
//        AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
//        accountDaoImpl.create(account);

    }

    @Test
    public void findByName() throws Exception {

    }
}