package jbreathe.fandinista.dao;

import jbreathe.fandinista.dao.gen.SimplifiedCrudDao;
import jbreathe.fandinista.entity.MusicianEntity;

/**
 * Интерфейс для MusicianDao. Все CRUD операции + специфичные операции, типа "findByColumnName(Some value)".
 */
public interface MusicianDao extends SimplifiedCrudDao<MusicianEntity> {
}
