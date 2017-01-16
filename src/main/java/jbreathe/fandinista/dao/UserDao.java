package jbreathe.fandinista.dao;

import jbreathe.fandinista.dao.gen.SimplifiedCrudDao;
import jbreathe.fandinista.entity.UserEntity;

public interface UserDao extends SimplifiedCrudDao<UserEntity> {

    UserEntity findByEmail(String email);
}
