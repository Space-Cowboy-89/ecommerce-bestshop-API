package com.codehero.bestshop.db.repository;

import com.codehero.bestshop.db.entity.Discount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DiscountRepository extends CrudRepository<Discount,Integer> {
    public Optional<List<Discount>> findByActive(Boolean isActive);
    public Optional<Discount> findByDiscountCode(String discountCode);
    public Optional<List<Discount>> findByDiscountCodeIn(List<String> discountCode);
}
