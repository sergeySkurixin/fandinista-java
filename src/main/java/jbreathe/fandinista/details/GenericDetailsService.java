package jbreathe.fandinista.details;

import jbreathe.fandinista.dao.UserDao;
import jbreathe.fandinista.entity.UserEntity;
import jbreathe.fandinista.role.RoleEnum;
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
public class GenericDetailsService implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public GenericDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.findByEmail(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(RoleEnum.USER.name()));
        return new User(userEntity.getEmail(), userEntity.getPasswordDigest(), roles);
    }
}
