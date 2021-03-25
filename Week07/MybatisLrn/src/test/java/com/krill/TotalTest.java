package com.krill;

import com.krill.domain.Account;
import com.krill.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class TotalTest {

    @Test
    public void testFindAll() throws IOException {
        AccountService service = new AccountService();

        service.insert(new Account("1", "Ash", 1000, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        service.insert(new Account("2", "比利王", 3000, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        service.insert(new Account("3", "野兽先辈", 114514, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));

        service.updateByPrimaryKey(new Account("2", "比利王", 100000, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        System.out.println(service.selectByPrimaryKey("2"));

        service.deleteByPrimaryKey("1");

        service.transfer("2", "3", 1000);

        List<Account> list = service.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
