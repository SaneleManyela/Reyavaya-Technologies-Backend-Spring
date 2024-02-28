package com.reyavaya.Reyavaya.Technologies.model;

import jakarta.persistence.*;

@Entity
@Table(name="Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name="phasedOut")
    private String phasedOut;

    public Brand() {
    }

    public Brand(String name, String phasedOut) {
        this.name = name;
        this.phasedOut = phasedOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhasedOut() {
        return phasedOut;
    }

    public void setPhasedOut(String phasedOut) {
        this.phasedOut = phasedOut;
    }
}
