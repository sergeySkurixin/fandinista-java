package jbreathe.fandinista.service;

import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.dao.PlaceDao;
import jbreathe.fandinista.dto.Place;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.entity.PlaceEntity;
import jbreathe.fandinista.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    private PlaceDao dao;
    private FanDao fanDao;
    private Mapper mapper;
    private SecurityService securityService;

    @Autowired
    public PlaceServiceImpl(
            PlaceDao dao, Mapper mapper, SecurityService securityService, FanDao fanDao) {
        this.dao = dao;
        this.mapper = mapper;
        this.securityService = securityService;
        this.fanDao = fanDao;
    }

    @Override
    public Place save(Place dto) {
        PlaceEntity entity = mapper.map(dto, PlaceEntity.class);
        PlaceEntity savedEntity = dao.save(entity);

        // auto login new user //
        securityService.autoLogin(dto.getEmail(), dto.getPassword());
        /////////////////////////

        return mapper.map(savedEntity, Place.class);
    }

    @Override
    public Place findById(Long aLong) {
        PlaceEntity entity = dao.findById(aLong);
        return mapper.map(entity, Place.class);
    }

    @Override
    public List<Place> findAll() {
        List<PlaceEntity> entities = dao.findAll();
        return mapper.mapAsList(entities, Place.class);
    }

    @Override
    public Place update(Place dto) {
        PlaceEntity entity = mapper.map(dto, PlaceEntity.class);
        PlaceEntity updatedEntity = dao.update(entity);
        return mapper.map(updatedEntity, Place.class);
    }

    @Override
    public void delete(Long aLong) {
        dao.delete(aLong);
    }

    @Override
    public Place follow(String loggedInUsername, Long idToFollow) {
        PlaceEntity placeEntity = dao.findById(idToFollow);
        if (loggedInUsername != null) {
            FanEntity fanEntity = fanDao.findByEmail(loggedInUsername);
            if (fanEntity != null) {
                fanEntity.getFavoritePlaces().add(placeEntity);
                fanDao.update(fanEntity);
            }
        }
        return mapper.map(placeEntity, Place.class);
    }
}
