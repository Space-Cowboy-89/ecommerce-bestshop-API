package com.codehero.bestshop.db.dao.classes;

import com.codehero.bestshop.utility.Constant.DbCrudConst;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralDaoImpl <T>   {
    @PersistenceContext()
    private EntityManager em;


    /**
     * Method does insert, update or delete query in batch way in a db table.
     *
     * @param recordList
     * @param dbOperation
     */
    public void dbCrudInBatch(List <T> recordList, DbCrudConst.DBOPERATION dbOperation) {
        int recordListSize = recordList.size();
        for (int i = 0; i < recordListSize; i++) {
            singleCrudOp(recordList.get(i), dbOperation);
            if (i % DbCrudConst.BATCHSIZE == 0 && i > 0) {
                em.flush();
                em.clear();
            }
        }

        em.flush();
        em.clear();
    }

    public void singleCrudOp(Object product, DbCrudConst.DBOPERATION dbOperation) {
        switch (dbOperation) {
            case insert -> {
                em.persist(product);
            }
            case update -> {
                em.merge(product);
            }
            case delete -> {
                em.remove(product);
            }
        }
    }
}
