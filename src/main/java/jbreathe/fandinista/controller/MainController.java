package jbreathe.fandinista.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Контроллер главной страницы приложения.
 */
@Controller
public class MainController {

    /**
     * Индекс метод показывает главную страницу.
     *
     * @return главную страницу
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
