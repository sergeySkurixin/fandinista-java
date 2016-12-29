package jbreathe.fandinista.dao.jpa;

import jbreathe.fandinista.dao.MusicianDao;
import jbreathe.fandinista.dao.gen.GenericCrudDao;
import jbreathe.fandinista.entity.MusicianEntity;
import org.springframework.stereotype.Repository;

/**
 * Jpa реализация {@link MusicianDao}.
 */
@Repository
public class MusicianDaoJpa extends GenericCrudDao<MusicianEntity> implements MusicianDao {
}
