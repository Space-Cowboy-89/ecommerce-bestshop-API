package com.codehero.bestshop.db.dao.classes;

import com.codehero.bestshop.db.dao.interfaces.DiscountDao;
import com.codehero.bestshop.db.entity.Discount;
import com.codehero.bestshop.db.repository.DiscountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountDaoImpl implements DiscountDao {
    @PersistenceContext()
    private EntityManager entityManager;
    private DiscountRepository discountRepo;

    private Logger LOGGER;


    @Override
    public List<Discount> findByActTrueFalse(boolean isAct) {
        return discountRepo.findByActive(isAct);
    }

    @Override
    public Discount findByDiscCode(String discCode) {
        return discountRepo.findByDiscountCode(discCode);
    }

    @Override
    public List<Discount> findByDiscCodeList(List<String> discCodeList) {
        return discountRepo.findByDiscountCodeIn(discCodeList);
    }
}
