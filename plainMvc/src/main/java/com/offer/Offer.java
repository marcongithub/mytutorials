package com.offer;


import javax.persistence.*;

@Entity
@Table(name="OFFER")
public class Offer {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFER_SEQ_GEN")
    @SequenceGenerator(name="OFFER_SEQ_GEN", sequenceName="OFFER_SEQ", allocationSize=100)
    private long id;


    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
