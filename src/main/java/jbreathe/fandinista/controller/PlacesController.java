package jbreathe.fandinista.controller;

import jbreathe.fandinista.controller.gen.CrudController;
import jbreathe.fandinista.dto.Place;
import jbreathe.fandinista.service.PlaceService;
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
@RequestMapping("/places")
public class PlacesController implements CrudController<Place> {

    private PlaceService service;

    @Autowired
    public PlacesController(PlaceService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(method = GET)
    public ModelAndView index() {
        List<Place> list = service.findAll();
        ModelAndView modelAndView = new ModelAndView("places/index");
        modelAndView.addObject("places", list);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/new", method = GET)
    public ModelAndView form() {
        return new ModelAndView("places/new");
    }

    @Override
    @RequestMapping(method = POST)
    public ModelAndView create(@ModelAttribute Place dto, BindingResult bindingResult) {
        Place saved = service.save(dto);
        ModelAndView modelAndView = new ModelAndView("redirect:/places/" + saved.getId());
        modelAndView.addObject("place", saved);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = GET)
    public ModelAndView show(@PathVariable("id") Long id) {
        Place dto = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("places/show");
        modelAndView.addObject("place", dto);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}/edit", method = GET)
    public ModelAndView edit(@PathVariable("id") Long id) {
        Place dto = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("places/edit");
        modelAndView.addObject("place", dto);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = {PATCH, PUT})
    public ModelAndView update(
            @PathVariable("id") Long id,
            @ModelAttribute Place dto,
            BindingResult bindingResult) {
        dto.setId(id);
        Place updated = service.update(dto);
        ModelAndView modelAndView = new ModelAndView("redirect:/places/" + id);
        modelAndView.addObject("place", updated);
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public ModelAndView delete(@PathVariable("id") Long id) {
        return new ModelAndView("redirect:/places");
    }
}
