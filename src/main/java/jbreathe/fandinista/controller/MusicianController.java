package jbreathe.fandinista.controller;

import jbreathe.fandinista.controller.gen.CrudController;
import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/musicians")
public class MusicianController implements CrudController<Musician> {

    private MusicianService service;

    @Autowired
    public MusicianController(MusicianService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(method = GET)
    public ModelAndView index() {
        List<Musician> list = service.findAll();
        ModelAndView modelAndView = new ModelAndView("musicians/index");
        modelAndView.addObject("musicians", list);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/new", method = GET)
    public ModelAndView form() {
        return new ModelAndView("musicians/new");
    }

    @Override
    @RequestMapping(method = POST)
    public ModelAndView create(@ModelAttribute Musician dto, BindingResult bindingResult) {
        Musician saved = service.save(dto);
        ModelAndView modelAndView = new ModelAndView("redirect:/musicians/" + saved.getId());
        modelAndView.addObject("musician", saved);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = GET)
    public ModelAndView show(@PathVariable("id") Long id) {
        Musician dto = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("musicians/show");
        modelAndView.addObject("musician", dto);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}/edit", method = GET)
    public ModelAndView edit(@PathVariable("id") Long id) {
        Musician dto = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("musicians/edit");
        modelAndView.addObject("musician", dto);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = {PATCH, PUT})
    public ModelAndView update(
            @PathVariable("id") Long id,
            @ModelAttribute Musician dto,
            BindingResult bindingResult) {
        dto.setId(id);
        Musician updated = service.update(dto);
        ModelAndView modelAndView = new ModelAndView("redirect:/musicians/" + id);
        modelAndView.addObject("musician", updated);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        return new ModelAndView("redirect:/musicians");
    }
}
