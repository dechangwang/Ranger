package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Account;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface AccountDao {
    public void create(Account account);
    public List<Account> findByName(String name);
}

/*
public interface AccountDao extends GenericDAO <Account, Long> {
>>>>>>> e0ac926c0f5b28b46900fe40bf2da332c01c753c

public interface AccountDao {
    public Integer create(Account account);
    public Integer update(Account account);
    public List<Account> findByName(String name);

//    public void
}
<<<<<<< HEAD
/*public interface AccountDao extends GenericDAO <Account, Long> {

}*/
