package com.offer;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OfferRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void create(Offer offer) {
        entityManager.persist(offer);
    }

    public Offer find(long id) {
        return entityManager.find(Offer.class, id);
    }

    @Transactional
    public Offer update(Offer offer){
        return entityManager.merge(offer);
    }


}
