package com.cryptowallet;

import com.cryptowallet.entities.User;
import com.cryptowallet.repositories.AddressRepository;
import com.cryptowallet.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void userRepositoryTest1() {
        User user = new User("login","pass","email",true);
        User out = entityManager.persist(user);
        entityManager.flush();
        User res = userRepository.findByEmail("email").get();
        Assert.assertSame(user,res);
    }

    @Test
    public void userRepositorySaveTest(){
        User user = new User("login","pass","email",true);
        userRepository.save(user);
        User res = userRepository.findByEmail("email").get();
        Assert.assertTrue(res.getEmail().equals(user.getEmail()));
    }
}