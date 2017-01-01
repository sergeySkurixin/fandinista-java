package jbreathe.fandinista.dao.jpa;

import jbreathe.fandinista.dao.PlaceDao;
import jbreathe.fandinista.dao.gen.GenericCrudDao;
import jbreathe.fandinista.entity.PlaceEntity;
import org.springframework.stereotype.Repository;

/**
 * Jpa реализация {@link PlaceDao}.
 */
@Repository
public class PlaceDaoJpa extends GenericCrudDao<PlaceEntity> implements PlaceDao {
}
