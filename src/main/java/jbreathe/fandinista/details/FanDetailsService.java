package jbreathe.fandinista.details;

import jbreathe.fandinista.dao.FanDao;
import jbreathe.fandinista.entity.FanEntity;
import jbreathe.fandinista.role.FanRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FanDetailsService implements UserDetailsService {

    private FanDao fanDao;

    @Autowired
    public FanDetailsService(FanDao fanDao) {
        this.fanDao = fanDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        FanEntity fanEntity = fanDao.findByEmail(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(FanRoleEnum.USER.name()));
        return new User(fanEntity.getName(), fanEntity.getPasswordDigest(), roles);
    }
}
