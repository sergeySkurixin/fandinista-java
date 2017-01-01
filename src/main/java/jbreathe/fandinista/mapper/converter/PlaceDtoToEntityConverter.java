package jbreathe.fandinista.mapper.converter;

import jbreathe.fandinista.dto.Place;
import jbreathe.fandinista.entity.PlaceEntity;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaceDtoToEntityConverter extends BidirectionalConverter<Place, PlaceEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(PlaceDtoToEntityConverter.class);

    @Override
    public PlaceEntity convertTo(Place place, Type<PlaceEntity> type, MappingContext mappingContext) {
        PlaceEntity entity = new PlaceEntity();
        String password = place.getPassword();
        LOG.info("Before {}", password);
        String passwordDigest = DigestUtils.md5Hex(password);
        LOG.info("After {}", passwordDigest);
        entity.setPasswordDigest(passwordDigest);
        return entity;
    }

    @Override
    public Place convertFrom(PlaceEntity placeEntity, Type<Place> type, MappingContext mappingContext) {
        Place dto = new Place();
        String passwordDigest = placeEntity.getPasswordDigest();
        LOG.info("Before {}", passwordDigest);
        String password = new String(DigestUtils.md5(passwordDigest));
        LOG.info("After {}", password);
        dto.setPassword(password);
        return dto;
    }
}
