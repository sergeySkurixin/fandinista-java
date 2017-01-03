package jbreathe.fandinista;

import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.mapper.Mapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MapperTest {

    @Autowired
    private Mapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test() {
        // test
        Fan fan = new Fan();
        fan.setName("artem");
        fan.setPassword("123");
        FanEntity fanEntity = mapper.map(fan, FanEntity.class);
        System.out.println(fanEntity);
        FanEntity fanEntity2 = mapper.map(fan, FanEntity.class);
        System.out.println(fanEntity2);
        boolean matches = passwordEncoder.matches("123", fanEntity.getPasswordDigest());
        System.out.println(matches);
    }
}
