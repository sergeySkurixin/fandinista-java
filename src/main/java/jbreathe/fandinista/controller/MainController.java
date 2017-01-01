package jbreathe.fandinista.controller;

import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.entity.FanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Контроллер главной страницы приложения.
 */
@Controller
public class MainController {

    private FanDao fanDao;

    @Autowired
    public MainController(FanDao fanDao) {
        this.fanDao = fanDao;
    }

    /**
     * Индекс метод показывает главную страницу.
     *
     * @return главную страницу
     */
    @Transactional
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        FanEntity fanEntity = new FanEntity();
        fanEntity.setName("arte");
        fanEntity.setPasswordDigest("123");
        fanEntity.setRememberToken("123");
        fanDao.save(fanEntity);
        return "index";
    }
}
