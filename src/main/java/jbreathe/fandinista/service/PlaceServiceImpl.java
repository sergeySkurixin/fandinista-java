package jbreathe.fandinista.service;

import jbreathe.fandinista.dao.PlaceDao;
import jbreathe.fandinista.dto.Place;
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
    private Mapper mapper;

    @Autowired
    public PlaceServiceImpl(PlaceDao dao, Mapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public Place save(Place dto) {
        PlaceEntity entity = mapper.map(dto, PlaceEntity.class);
        PlaceEntity savedEntity = dao.save(entity);
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
}
