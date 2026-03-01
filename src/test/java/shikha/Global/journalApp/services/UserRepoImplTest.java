package shikha.Global.journalApp.services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import shikha.Global.journalApp.Entity.User;
import shikha.Global.journalApp.Repository.UserRepoImpl;
@Disabled
@SpringBootTest
public class UserRepoImplTest {

    @Autowired
    UserRepoImpl userRepo;

    @Test
    void getUser(){

        userRepo.getUserForSA();
    }
}
