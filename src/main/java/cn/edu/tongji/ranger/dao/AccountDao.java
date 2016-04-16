package cn.edu.tongji.ranger.dao;

import cn.edu.tongji.ranger.model.Account;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountDao {
    public Integer create(Account account);
    public Integer update(Account account);
    public List<Account> findByName(String name);

//    public void
}
/*public interface AccountDao extends GenericDAO <Account, Long> {

}*/
