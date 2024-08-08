package com.codehero.bestshop.db.repository;

import com.codehero.bestshop.db.entity.Discount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiscountRepository extends CrudRepository<Discount,Integer> {
    public List<Discount> findByActive(Boolean isActive);
    public Discount findByDiscountCode(String discountCode);
    public List<Discount> findByDiscountCodeIn(List<String> discountCode);
}
