package com.krill.service;

import com.krill.dao.AccountDao;
import com.krill.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("accountService")
public class AccountService {

    @Autowired
    private AccountDao dao;

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
    }

}
