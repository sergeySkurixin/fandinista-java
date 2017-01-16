package jbreathe.fandinista.controller;

import jbreathe.fandinista.controller.gen.CrudController;
import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/fans")
public class FanController implements CrudController<Fan> {

    private FanService service;

    @Autowired
    public FanController(FanService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(method = GET)
    public ModelAndView index() {
        List<Fan> list = service.findAll();
        ModelAndView modelAndView = new ModelAndView("fans/index");
        modelAndView.addObject("fans", list);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/new", method = GET)
    public ModelAndView form() {
        return new ModelAndView("fans/new");
    }

    @Override
    @RequestMapping(method = POST)
    public ModelAndView create(@ModelAttribute @Valid Fan dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // затычка
            return null;
        }
        Fan saved = service.save(dto);
        ModelAndView modelAndView = new ModelAndView("redirect:/fans/" + saved.getId());
        modelAndView.addObject("fan", saved);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = GET)
    public ModelAndView show(@PathVariable("id") Long id) {
        Fan dto = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("fans/show");
        modelAndView.addObject("fan", dto);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}/edit", method = GET)
    public ModelAndView edit(@PathVariable("id") Long id) {
        Fan dto = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("fans/edit");
        modelAndView.addObject("fan", dto);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = {PATCH, PUT})
    public ModelAndView update(
            @PathVariable("id") Long id,
            @ModelAttribute @Valid Fan dto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // затычка
            return null;
        }
        dto.setId(id);
        Fan updated = service.update(dto);
        ModelAndView modelAndView = new ModelAndView("redirect:/fans/" + id);
        modelAndView.addObject("fan", updated);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        // auto logout
        return "redirect:/logout";
    }

    // отлавливать javax.persistence.PersistenceException: org.hibernate.exception.ConstraintViolationException
    // + сделать нормальные конвертеры с айди, пассворд дайджестами, римэмба токенами ...
}
