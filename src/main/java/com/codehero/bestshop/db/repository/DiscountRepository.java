package com.codehero.bestshop.db.repository;

import com.codehero.bestshop.db.entity.Discount;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepository extends CrudRepository<Discount,Integer> {
}
