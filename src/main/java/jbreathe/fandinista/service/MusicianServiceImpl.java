package jbreathe.fandinista.service;

import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.dao.MusicianDao;
import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.entity.MusicianEntity;
import jbreathe.fandinista.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class MusicianServiceImpl implements MusicianService {

    private MusicianDao dao;
    private FanDao fanDao;
    private Mapper mapper;
    private SecurityService securityService;

    @Autowired
    public MusicianServiceImpl(
            MusicianDao dao, Mapper mapper, SecurityService securityService, FanDao fanDao) {
        this.dao = dao;
        this.mapper = mapper;
        this.securityService = securityService;
        this.fanDao = fanDao;
    }

    @Override
    public Musician save(Musician dto) {
        MusicianEntity entity = mapper.map(dto, MusicianEntity.class);
        MusicianEntity savedEntity = dao.save(entity);

        // auto login new user //
        securityService.autoLogin(dto.getEmail(), dto.getPassword());
        /////////////////////////

        return mapper.map(savedEntity, Musician.class);
    }

    @Override
    public Musician findById(Long aLong) {
        MusicianEntity entity = dao.findById(aLong);
        return mapper.map(entity, Musician.class);
    }

    @Override
    public List<Musician> findAll() {
        List<MusicianEntity> entities = dao.findAll();
        return mapper.mapAsList(entities, Musician.class);
    }

    @Override
    public Musician update(Musician dto) {
        MusicianEntity entity = mapper.map(dto, MusicianEntity.class);
        MusicianEntity updatedEntity = dao.update(entity);
        return mapper.map(updatedEntity, Musician.class);
    }

    @Override
    public void delete(Long aLong) {
        dao.delete(aLong);
    }

    @Override
    public Musician follow(String loggedInUsername, Long idToFollow) {
        MusicianEntity musicianEntity = dao.findById(idToFollow);
        if (loggedInUsername != null) {
            FanEntity fanEntity = fanDao.findByEmail(loggedInUsername);
            if (fanEntity != null) {
                fanEntity.getFavoriteMusicians().add(musicianEntity);
                fanDao.update(fanEntity);
            }
        }
        return mapper.map(musicianEntity, Musician.class);
    }
}
