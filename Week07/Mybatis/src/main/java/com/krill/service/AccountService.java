package com.krill.service;

import com.krill.dao.AccountDao;
import com.krill.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class AccountService {

    private AccountDao dao;
    private SqlSession session;

    public AccountService() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession(true);
        //4.使用SqlSession创建Dao接口的代理对象
        dao = session.getMapper(AccountDao.class);
    }

    // 1查询所有记录
    public List<Account> findAll() {
        return dao.findAll();
    }

    // 2通过id删除记录
    public void deleteByPrimaryKey(String id) {
        dao.deleteByPrimaryKey(id);
    }

    // 3插入记录
    public void insert(Account record) {
        dao.insert(record);
    }

    // 4通过id查找对象
    public Account selectByPrimaryKey(String id) {
        return dao.selectByPrimaryKey(id);
    }

    // 5更新Account
    public void updateByPrimaryKey(Account record) {
        dao.updateByPrimaryKey(record);
    }

    // 6转账功能 输入转出人id，转入人id，转账金额 实现转账
    public void transfer(String remitterId, String remitteeId, int money) {
        Account reminter = dao.selectByPrimaryKey(remitterId);
        Account remintee = dao.selectByPrimaryKey(remitteeId);

        reminter.setMoney(reminter.getMoney() - money);
        remintee.setMoney(remintee.getMoney() + money);

        dao.updateByPrimaryKey(reminter);
        dao.updateByPrimaryKey(remintee);
        session.commit();
    }

}
