package jbreathe.fandinista;

import jbreathe.fandinista.config.FandinistaWebConfig;
import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.dao.MusicianDao;
import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.entity.MusicianEntity;
import jbreathe.fandinista.service.FanService;
import jbreathe.fandinista.service.MusicianService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = {FandinistaWebConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DaoTest {

    @Autowired
    private FanService fanService;

    @Autowired
    private MusicianService musicianService;

    @Autowired
    private MusicianDao musicianDao;

    @Autowired
    private FanDao fanDao;

    @Test
    @Transactional
    @Rollback//(false)
    public void fanServiceTest() {
        Fan fan = new Fan();
        fan.setName("some");
        fan.setEmail("some@mail.zone");
        fan.setPassword("some_pass");

        Musician musician1 = new Musician();
        musician1.setName("some1");
        musician1.setEmail("some1@mail.zone");
        musician1.setPassword("some_pass");
        Musician musician2 = new Musician();
        musician2.setName("some2");
        musician2.setEmail("some2@mail.zone");
        musician2.setPassword("some_pass");

        fan.setFavoriteMusicians(Arrays.asList(musician1, musician2));

        Fan saved = fanService.save(fan);

        Assert.notNull(saved.getId());
        List<Musician> favoriteMusicians = saved.getFavoriteMusicians();
        Assert.notNull(favoriteMusicians);
        Assert.notEmpty(favoriteMusicians);
    }

    @Test
    @Transactional
    @Rollback//(false)
    public void musicianServiceTest() {
        Musician musician = new Musician("asd", "asd", "123");
        musicianService.save(musician);
    }

    @Test
    @Transactional
    @Rollback//(false)
    public void followingTest() {
        Fan fan = fanService.findById(1L);
        Musician musician = musicianService.follow(fan.getEmail(), 2L);
        List<Fan> followers = musician.getFollowers();
        Assert.notNull(followers);
        Assert.notEmpty(followers);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void inverseJoinTest() {
        MusicianEntity musicianEntity = musicianDao.findById(135L);
        FanEntity fanEntity = fanDao.findById(134L);
        musicianEntity.getFollowers().add(fanEntity);
        fanEntity.getFavoriteMusicians().add(musicianEntity);
        fanDao.update(fanEntity); // work
//        musicianDao.update(musicianEntity); // ne work
    }
}
