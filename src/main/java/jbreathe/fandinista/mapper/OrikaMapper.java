package jbreathe.fandinista.mapper;

import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.dto.Place;
import jbreathe.fandinista.dto.Post;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.entity.MusicianEntity;
import jbreathe.fandinista.entity.PlaceEntity;
import jbreathe.fandinista.entity.PostEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrikaMapper implements Mapper {

    private PasswordEncoder passwordEncoder;
    private MapperFacade mapperFacade;

    @Autowired
    public OrikaMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        setupMapper();
    }

    private void setupMapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Fan.class, FanEntity.class)
                // customize it like this
                //.fieldMap("password", "passwordDigest").converter("fanDtoToEntity").mapNulls(true).mapNullsInReverse(true).add()
                // or like this
                .customize(new CustomMapper<Fan, FanEntity>() {
                    @Override
                    public void mapAtoB(Fan fan, FanEntity fanEntity, MappingContext context) {
                        String passwordDigest = passwordEncoder.encode(fan.getPassword());
                        fanEntity.setPasswordDigest(passwordDigest);
                    }
                })
                .byDefault()
                .register();
        mapperFactory.classMap(Musician.class, MusicianEntity.class)
                .customize(new CustomMapper<Musician, MusicianEntity>() {
                    @Override
                    public void mapAtoB(Musician musician, MusicianEntity musicianEntity, MappingContext context) {
                        String passwordDigest = passwordEncoder.encode(musician.getPassword());
                        musicianEntity.setPasswordDigest(passwordDigest);
                    }
                })
                .byDefault()
                .register();
        mapperFactory.classMap(Place.class, PlaceEntity.class)
                .customize(new CustomMapper<Place, PlaceEntity>() {
                    @Override
                    public void mapAtoB(Place place, PlaceEntity placeEntity, MappingContext context) {
                        String passwordDigest = passwordEncoder.encode(place.getPassword());
                        placeEntity.setPasswordDigest(passwordDigest);
                    }
                })
                .byDefault()
                .register();
        mapperFactory.classMap(Post.class, PostEntity.class)
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
