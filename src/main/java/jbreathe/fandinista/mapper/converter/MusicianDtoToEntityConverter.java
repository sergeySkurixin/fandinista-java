package jbreathe.fandinista.mapper.converter;

import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.entity.MusicianEntity;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MusicianDtoToEntityConverter extends BidirectionalConverter<Musician, MusicianEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(MusicianDtoToEntityConverter.class);

    @Override
    public MusicianEntity convertTo(Musician musician, Type<MusicianEntity> type, MappingContext mappingContext) {
        MusicianEntity entity = new MusicianEntity();
        String password = musician.getPassword();
        LOG.info("Before {}", password);
        String passwordDigest = DigestUtils.md5Hex(password);
        LOG.info("After {}", passwordDigest);
        entity.setPasswordDigest(passwordDigest);
        return entity;
    }

    @Override
    public Musician convertFrom(MusicianEntity musicianEntity, Type<Musician> type, MappingContext mappingContext) {
        Musician dto = new Musician();
        String passwordDigest = musicianEntity.getPasswordDigest();
        LOG.info("Before {}", passwordDigest);
        String password = new String(DigestUtils.md5(passwordDigest));
        LOG.info("After {}", password);
        dto.setPassword(password);
        return dto;
    }
}
