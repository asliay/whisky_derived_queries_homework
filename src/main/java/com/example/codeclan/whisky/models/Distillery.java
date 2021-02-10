package com.example.codeclan.whisky.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import sun.jvm.hotspot.memory.Generation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "distilleries")
public class Distillery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String region;

    @OneToMany(mappedBy = "distillery")
    @JsonIgnoreProperties({"distillery"})
    private List<Whisky> whiskys;

    public Distillery(String name, String region) {
        this.name = name;
        this.region = region;
        this.whiskys = whiskys;
    }

    public Distillery() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Whisky> getWhiskys() {
        return whiskys;
    }

    public void setWhiskys(List<Whisky> whiskys) {
        this.whiskys = whiskys;
    }
}
