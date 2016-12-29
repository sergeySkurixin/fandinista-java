package jbreathe.fandinista.dao.jpa;

import jbreathe.fandinista.dao.StageDao;
import jbreathe.fandinista.dao.gen.GenericCrudDao;
import jbreathe.fandinista.entity.StageEntity;
import org.springframework.stereotype.Repository;

/**
 * Jpa реализация {@link StageDao}.
 */
@Repository
public class StageDaoJpa extends GenericCrudDao<StageEntity> implements StageDao {
}