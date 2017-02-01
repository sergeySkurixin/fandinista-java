package jbreathe.fandinista.controller;

import jbreathe.fandinista.controller.gen.CrudController;
import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.service.FanService;
import org.apache.commons.codec.digest.DigestUtils;
import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/fans")
public class FanController implements CrudController<Fan> {

    @Autowired
    private String resourcesImageFolder;

    private FanService service;

    @Autowired
    public FanController(FanService service) {
        this.service = service;
    }

    @Value("${S3_BUCKET}")
    private String s3bucket;

    @Autowired
    public S3Service s3Service;

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

    @RequestMapping(value = "/{id}/change-img", method = POST)
    public String changeImage(@PathVariable("id") Long id,
                              @RequestParam("avatar") MultipartFile image,
//                              @ModelAttribute("fan") Fan fan,
                              HttpServletRequest request) throws S3ServiceException {

        try {
            byte[] bytes = image.getBytes();
            String md5 = DigestUtils.md5Hex(bytes);
            String contentType = image.getContentType().split("/")[1];
            String imageName = md5 + "." + contentType;

            S3Object s3Object = new S3Object(imageName);
            s3Object.setDataInputStream(new ByteArrayInputStream(bytes));
            s3Object.setContentLength(bytes.length);
            s3Object.setContentType("image/gif");
            s3Service.putObject(s3bucket, s3Object);

            Fan fan = service.findById(id);
            fan.setAvatar(imageName);
            service.update(fan);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/fans/" + id;
    }

    // отлавливать javax.persistence.PersistenceException: org.hibernate.exception.ConstraintViolationException
    // + сделать нормальные конвертеры с айди, пассворд дайджестами, римэмба токенами ...
}
