package jbreathe.fandinista.controller;

import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.dto.Fan;
import jbreathe.fandinista.entity.FanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
public class AuthController {

    private PasswordEncoder passwordEncoder;
    private FanDao fanDao;

    @Autowired
    public AuthController(PasswordEncoder passwordEncoder, FanDao fanDao) {
        this.passwordEncoder = passwordEncoder;
        this.fanDao = fanDao;
    }

    public boolean authenticate(@Valid Fan fan) {
        FanEntity fanEntity = fanDao.findByEmail(fan.getEmail());
        return passwordEncoder.matches(fan.getPassword(), fanEntity.getPasswordDigest());
    }
}
