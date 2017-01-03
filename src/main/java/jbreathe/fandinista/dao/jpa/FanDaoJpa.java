package jbreathe.fandinista.dao.jpa;

import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.dao.gen.GenericCrudDao;
import jbreathe.fandinista.entity.FanEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Jpa реализация {@link FanDao}.
 */
@Repository
public class FanDaoJpa extends GenericCrudDao<FanEntity> implements FanDao {

    @Override
    public FanEntity findByEmail(String email) {
        EntityManager entityManager = getEntityManager();
        TypedQuery<FanEntity> namedQuery = entityManager.createNamedQuery("Fans.findByEmail", FanEntity.class);
        namedQuery.setParameter("email", email);
        return namedQuery.getSingleResult();
    }
}
