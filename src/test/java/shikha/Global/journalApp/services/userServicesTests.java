package shikha.Global.journalApp.services;

import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertJProxySetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shikha.Global.journalApp.Entity.User;
import shikha.Global.journalApp.Repository.UserRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@Disabled
@SpringBootTest
public class userServicesTests {
//    @afterAll @afterEach
//    @BeforeEach @BeforeEach
    @Autowired
    UserRepo userRepo;
    @Disabled
    @Test
    void testAdd(){
        assertEquals(2+2,4);
        User user =  userRepo.findByUsername("Shikha");

    }
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2","2,2,5","3,3,6"
    })
    void test(int a, int b, int c){
        assertEquals(c,a+b);
    }


    @Disabled
    @ParameterizedTest
    @ValueSource(strings =  {
            "shikha","kido","sweetheart"
    })
    void test2(String username){
        assertNotNull(userRepo.findByUsername(username));
    }



}
