package jbreathe.fandinista.mapper;

import jbreathe.fandinista.dto.*;
import jbreathe.fandinista.entity.*;
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

        mapperFactory.classMap(User.class, UserEntity.class)
                .byDefault()
                .customize(new CustomMapper<User, UserEntity>() {
                    @Override
                    public void mapAtoB(User user, UserEntity userEntity, MappingContext context) {
                        String passwordDigest = passwordEncoder.encode(user.getPassword());
                        userEntity.setPasswordDigest(passwordDigest);
                    }

                    @Override
                    public void mapBtoA(UserEntity userEntity, User user, MappingContext context) {
                        user.setPassword(userEntity.getPasswordDigest());
                    }
                })
                .register();
        mapperFactory.classMap(Fan.class, FanEntity.class)
                .use(User.class,UserEntity.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Musician.class, MusicianEntity.class)
                .use(User.class,UserEntity.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Place.class, PlaceEntity.class)
                .use(User.class,UserEntity.class)
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
