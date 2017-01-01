package jbreathe.fandinista.mapper;

import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.dto.Place;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.entity.MusicianEntity;
import jbreathe.fandinista.entity.PlaceEntity;
import jbreathe.fandinista.mapper.converter.FanDtoToEntityConverter;
import jbreathe.fandinista.mapper.converter.MusicianDtoToEntityConverter;
import jbreathe.fandinista.mapper.converter.PlaceDtoToEntityConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrikaMapper implements Mapper {

    private MapperFacade mapperFacade;

    public OrikaMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter(new FanDtoToEntityConverter());
        converterFactory.registerConverter(new MusicianDtoToEntityConverter());
        converterFactory.registerConverter(new PlaceDtoToEntityConverter());
        mapperFactory.classMap(Fan.class, FanEntity.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Musician.class, MusicianEntity.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Place.class, PlaceEntity.class)
                .byDefault()
                .register();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Override
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return mapperFacade.map(sourceObject, destinationClass);
    }

    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return mapperFacade.mapAsList(source, destinationClass);
    }
}
