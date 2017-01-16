package jbreathe.fandinista.service.gen;

public interface FollowingService<T> {

    /**
     * Фалловинг.
     *
     * @param loggedInUsername залогиненный юзер
     * @param idToFollow       id сущности, которую собираемся фалловить
     * @return обновленную сущность с фалловером
     */
    T follow(String loggedInUsername, Long idToFollow);
}
