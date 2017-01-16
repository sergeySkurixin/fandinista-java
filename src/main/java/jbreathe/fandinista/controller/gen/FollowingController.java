package jbreathe.fandinista.controller.gen;

import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

public interface FollowingController<T> {

    ModelAndView follow(Long idToFollow, Principal principal);
}
