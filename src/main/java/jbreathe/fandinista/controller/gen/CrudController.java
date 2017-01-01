package jbreathe.fandinista.controller.gen;

import org.springframework.web.servlet.ModelAndView;

/**
 * Интерфейс с основными методами и основными маппингами.
 */
public interface CrudController<T> {

    /**
     * Главная страница контроллера.
     *
     * @return главную страницу контроллера со всеми сущностями, например
     */
    ModelAndView index();

    /**
     * Страница или форма для создания новой сущности.
     *
     * @return страницу или форму для создания новой сущности
     */
    ModelAndView form();

    /**
     * POST-запрос на создание новой сущности.
     *
     * @param dto dto
     * @return страницу с созданной сущностью
     */
    ModelAndView create(T dto);

    /**
     * Страница сущности.
     *
     * @param id id
     * @return страницу сущности
     */
    ModelAndView show(Long id);

    /**
     * Страница или форма для изменения существующей сущности.
     *
     * @param id id
     * @return страницу или форму для изменения существующей сущности
     */
    ModelAndView edit(Long id);

    /**
     * PATCH/PUT-запрос на изменение существующей сущности.
     *
     * @param id  id
     * @param dto dto
     * @return страницу с измененной сущностью
     */
    ModelAndView update(Long id, T dto);

    /**
     * DELETE-запрос на удаление сущности.
     *
     * @param id id
     * @return index страницу контроллера
     */
    ModelAndView delete(Long id);
}
