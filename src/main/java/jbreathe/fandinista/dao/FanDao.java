package jbreathe.fandinista.dao;

import jbreathe.fandinista.dao.gen.SimplifiedCrudDao;
import jbreathe.fandinista.entity.FanEntity;

/**
 * Интерфейс для FanDao. Все CRUD операции + специфичные операции, типа "findByColumnName(Some value)".
 */
public interface FanDao extends SimplifiedCrudDao<FanEntity> {

    FanEntity findByEmail(String email);
}
