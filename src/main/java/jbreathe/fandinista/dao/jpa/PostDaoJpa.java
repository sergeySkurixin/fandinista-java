package jbreathe.fandinista.dao.jpa;

import jbreathe.fandinista.dao.PostDao;
import jbreathe.fandinista.dao.gen.GenericCrudDao;
import jbreathe.fandinista.entity.PostEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoJpa extends GenericCrudDao<PostEntity> implements PostDao {
}
