package jbreathe.fandinista;

import jbreathe.fandinista.config.FandinistaWebConfig;
import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.mapper.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {FandinistaWebConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MapperTest {

    @Autowired
    private Mapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test() {
        Fan fan = new Fan();
        fan.setName("artem");
        fan.setPassword("123");
        FanEntity fanEntity = mapper.map(fan, FanEntity.class);
        boolean passwordMatches = passwordEncoder.matches("123", fanEntity.getPasswordDigest());
        Assert.assertTrue(passwordMatches);
    }
}
