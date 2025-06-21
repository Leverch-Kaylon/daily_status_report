package com.dsr;

import com.dsr.entity.Account;
import com.dsr.repositories.AccountRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepoTest {


    @Autowired
    AccountRepository accRepo;

    @Test
    void databaseTest() throws Exception {
        Account newAccount = new Account(229,"Test account",false, LocalDate.now(),"Jason", LocalDate.now(),"Jason");
        accRepo.save(newAccount);
        accRepo.save(newAccount);


        Optional<List<Account>> acc= Optional.of(accRepo.findAll());
        System.out.println("VAlues************* "+acc.get().get(0).getAccount_desc());
        assertTrue(acc.isPresent());
//        assertEquals(acc.get().getAccount_id(), newAccount.getAccount_id());
    }
}
