package jbreathe.fandinista.dao.jpa;

import jbreathe.fandinista.dao.UserDao;
import jbreathe.fandinista.dao.gen.GenericCrudDao;
import jbreathe.fandinista.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class UserDaoJpa extends GenericCrudDao<UserEntity> implements UserDao {

    @Override
    public UserEntity findByEmail(String email) {
        EntityManager entityManager = getEntityManager();
        TypedQuery<UserEntity> namedQuery = entityManager.createNamedQuery("Users.findByEmail", UserEntity.class);
        namedQuery.setParameter("email", email);
        return namedQuery.getSingleResult();
    }
}
