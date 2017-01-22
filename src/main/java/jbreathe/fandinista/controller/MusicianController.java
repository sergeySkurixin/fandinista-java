package jbreathe.fandinista.controller;

import jbreathe.fandinista.controller.gen.CrudController;
import jbreathe.fandinista.controller.gen.FollowingController;
import jbreathe.fandinista.dto.Musician;
import jbreathe.fandinista.dto.Post;
import jbreathe.fandinista.service.MusicianService;
import jbreathe.fandinista.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/musicians")
public class MusicianController implements CrudController<Musician>, FollowingController<Musician> {

    public static final String RESOURCES_IMAGES_FORLDER = "/resources/images/";

    private MusicianService service;
    private PostService postService;

    @Autowired
    public MusicianController(MusicianService service, PostService postService) {
        this.service = service;
        this.postService = postService;
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
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        // auto logout
        return "redirect:/logout";
    }

    @Override
    @RequestMapping(value = "/{id}/follow")
    public ModelAndView follow(@PathVariable("id") Long idToFollow, Principal principal) {
        String loggedInUsername =
                principal.getName();
        Musician musician =
                service.follow(loggedInUsername, idToFollow);
        return new ModelAndView("redirect:/musicians");
    }

    @RequestMapping(value = "/{id}/posts", method = GET)
    public ModelAndView showPost(@PathVariable("id") Long id) {
        return new ModelAndView("posts/show");
    }

    @RequestMapping(value = "/{id}/posts", method = POST)
    public ModelAndView createPost(@ModelAttribute Post post, @PathVariable("id") Long id) {
        Post saved = postService.save(post);
        return new ModelAndView("redirect:/musicians/" + id);
    }

    @RequestMapping(value = "/{id}/posts/edit", method = GET)
    public ModelAndView showEditPost(@PathVariable("id") Long id) {
        return new ModelAndView("posts/edit");
    }

    @RequestMapping(value = "/{id}/posts", method = {PATCH, PUT})
    public ModelAndView editPost(@PathVariable("id") Long id) {
        return new ModelAndView("redirect:/musicians/" + id);
    }

    @RequestMapping(value = "/{id}/change-img", method = POST)
    public String changeImage(@PathVariable("id") Long id,
                              @RequestParam("avatar") MultipartFile image,
//                              @ModelAttribute("fan") Fan fan,
                              HttpServletRequest request) {

        try {
            byte[] bytes = image.getBytes();
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(bytes);
            String contentType = image.getContentType().split("/")[1];
            String directory = request.getServletContext()
                    .getRealPath(RESOURCES_IMAGES_FORLDER);
            File directoryFile = new File(directory);
            String path = directory + md5 + "." + contentType;

            File file = new File(path);
//            boolean exists = file.exists();
//            boolean newFile = file.createNewFile();
            image.transferTo(file);

            Musician musician = service.findById(id);
            musician.setAvatar(md5 + "." + contentType);
            service.update(musician);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/musicians/" + id;
    }
}
