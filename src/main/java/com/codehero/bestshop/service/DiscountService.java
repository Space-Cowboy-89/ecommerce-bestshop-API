package com.codehero.bestshop.service;


import com.codehero.bestshop.db.dao.classes.DiscountDaoImpl;
import com.codehero.bestshop.db.entity.Discount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    private DiscountDaoImpl discountDao;

    //Constants
    private Logger LOGGER;

    public DiscountService(DiscountDaoImpl discountDao) {
        this.discountDao = discountDao;
        LOGGER = LoggerFactory.getLogger(DiscountService.class);
    }


    public List<Discount> findDiscountIsActive(boolean isAct) {
        return discountDao.findByActTrueFalse(isAct);
    }

    public Discount findByDiscountCode(String discountCode) {
        return discountDao.findByDiscCode(discountCode);
    }

    public List<Discount> findByDiscountCodeList(List<String> discountCodeList) {
        return discountDao.findByDiscCodeList(discountCodeList);
    }
}
