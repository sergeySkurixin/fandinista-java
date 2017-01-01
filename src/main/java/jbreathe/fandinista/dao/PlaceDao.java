package jbreathe.fandinista.dao;

import jbreathe.fandinista.dao.gen.SimplifiedCrudDao;
import jbreathe.fandinista.entity.PlaceEntity;

/**
 * Интерфейс для PlaceDao. Все CRUD операции + специфичные операции, типа "findByColumnName(Some value)".
 */
public interface PlaceDao extends SimplifiedCrudDao<PlaceEntity> {
}
