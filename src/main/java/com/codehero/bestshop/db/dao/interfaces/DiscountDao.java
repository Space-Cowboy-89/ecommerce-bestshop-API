package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.Discount;

import java.util.List;

public interface DiscountDao {

    /**
     * Retrieve record by active attr. (isAct var.)
     *
     * @param isAct
     * @return
     */
    public List<Discount> findByActTrueFalse( boolean isAct);

    public Discount findByDiscCode(String discCode);
    public List<Discount> findByDiscCodeList(List<String> discCodeList);
}
