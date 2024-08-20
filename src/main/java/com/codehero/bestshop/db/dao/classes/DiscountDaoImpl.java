package com.codehero.bestshop.db.dao.classes;

import com.codehero.bestshop.db.dao.interfaces.DiscountDao;
import com.codehero.bestshop.db.entity.Discount;
import com.codehero.bestshop.db.repository.DiscountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountDaoImpl implements DiscountDao {
    @PersistenceContext()
    private EntityManager entityManager;

    //Repository interface
    private DiscountRepository discountRepo;

    //Constants
    private final Logger LOGGER;

    public DiscountDaoImpl(DiscountRepository discountRepo) {
        this.discountRepo = discountRepo;
        this.LOGGER = LoggerFactory.getLogger(DiscountDaoImpl.class);
    }

    @Override
    public List<Discount> findByActTrueFalse(boolean isAct) {
        return discountRepo.findByActive(isAct).get();
    }

    @Override
    public Discount findByDiscCode(String discCode) {
        return discountRepo.findByDiscountCode(discCode).orElse(null);
    }

    @Override
    public List<Discount> findByDiscCodeList(List<String> discCodeList) {
        return discountRepo.findByDiscountCodeIn(discCodeList).get();
    }
}
