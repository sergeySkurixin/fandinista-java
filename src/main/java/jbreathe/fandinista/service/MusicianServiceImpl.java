package jbreathe.fandinista.service;

import jbreathe.fandinista.dao.MusicianDao;
import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.entity.MusicianEntity;
import jbreathe.fandinista.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicianServiceImpl implements MusicianService {

    private MusicianDao dao;
    private Mapper mapper;

    @Autowired
    public MusicianServiceImpl(MusicianDao dao, Mapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public Musician save(Musician dto) {
        MusicianEntity entity = mapper.map(dto, MusicianEntity.class);
        MusicianEntity savedEntity = dao.save(entity);
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
}
