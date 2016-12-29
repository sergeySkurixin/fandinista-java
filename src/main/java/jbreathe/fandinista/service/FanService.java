package jbreathe.fandinista.service;

import jbreathe.fandinista.dao.FanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FanService {

    private FanDao fanDao;

    @Autowired
    public FanService(FanDao fanDao) {
        this.fanDao = fanDao;
    }
}
