package jbreathe.fandinista.dao.jpa;

import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.dao.gen.GenericCrudDao;
import jbreathe.fandinista.entity.FanEntity;
import org.springframework.stereotype.Repository;

/**
 * Jpa реализация {@link FanDao}.
 */
@Repository
public class FanDaoJpa extends GenericCrudDao<FanEntity> implements FanDao {
}
