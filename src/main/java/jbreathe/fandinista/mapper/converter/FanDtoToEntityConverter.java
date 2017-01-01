package jbreathe.fandinista.mapper.converter;

import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.entity.FanEntity;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FanDtoToEntityConverter extends BidirectionalConverter<Fan, FanEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(FanDtoToEntityConverter.class);

    @Override
    public FanEntity convertTo(Fan fan, Type<FanEntity> type, MappingContext mappingContext) {
        FanEntity entity = new FanEntity();
        entity.setId(fan.getId());
        entity.setName(fan.getName());
        entity.setRememberToken(fan.getRememberToken());
        String password = fan.getPassword();
        LOG.info("Before {}", password);
        String passwordDigest = DigestUtils.md5Hex(password);
        LOG.info("After {}", passwordDigest);
        entity.setPasswordDigest(passwordDigest);
        return entity;
    }

    @Override
    public Fan convertFrom(FanEntity fanEntity, Type<Fan> type, MappingContext mappingContext) {
        Fan dto = new Fan();
        dto.setId(fanEntity.getId());
        dto.setName(fanEntity.getName());
        dto.setRememberToken(fanEntity.getRememberToken());
        String passwordDigest = fanEntity.getPasswordDigest();
        LOG.info("Before {}", passwordDigest);
        String password = new String(DigestUtils.md5(passwordDigest));
        LOG.info("After {}", password);
        dto.setPassword(password);
        return dto;
    }
}
