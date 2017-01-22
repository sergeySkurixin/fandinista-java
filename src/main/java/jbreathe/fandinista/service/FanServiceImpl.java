package jbreathe.fandinista.service;

import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.mapper.Mapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FanServiceImpl implements FanService {

    private FanDao dao;
    private Mapper mapper;
    private SecurityService securityService;

    @Autowired
    public FanServiceImpl(FanDao dao, Mapper mapper, SecurityService securityService) {
        this.dao = dao;
        this.mapper = mapper;
        this.securityService = securityService;
    }

    @Override
    public Fan save(Fan dto) {
        FanEntity entity = mapper.map(dto, FanEntity.class);
        FanEntity savedEntity = dao.save(entity);

        // auto login new user //
//        securityService.autoLogin(dto.getEmail(), dto.getPassword());
        /////////////////////////

        return mapper.map(savedEntity, Fan.class);
    }

    @Override
    public Fan findById(Long aLong) {
        FanEntity entity = dao.findById(aLong);
        return mapper.map(entity, Fan.class);
    }

    @Override
    public List<Fan> findAll() {
        List<FanEntity> entities = dao.findAll();
        return mapper.mapAsList(entities, Fan.class);
    }

    @Override
    public Fan update(Fan dto) {
        FanEntity entity = mapper.map(dto, FanEntity.class);
        FanEntity updatedEntity = dao.update(entity);
        return mapper.map(updatedEntity, Fan.class);
    }

    @Override
    public void delete(Long aLong) {
        dao.delete(aLong);
    }
}
