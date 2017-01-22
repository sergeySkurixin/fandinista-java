package jbreathe.fandinista.controller;

import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.dto.Place;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
    public String index(Model model) {
        Fan fan = new Fan();
        Musician musician = new Musician();
        Place place = new Place();
        model.addAttribute("fan", fan);
        model.addAttribute("musician", musician);
        model.addAttribute("place", place);
        return "index";
    }
}
