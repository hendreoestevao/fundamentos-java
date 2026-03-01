package org.example.model.muitospramuitos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany
    private List<Sobrinho> sobrinhos  = new ArrayList<>();

    public Tio() {}

    public Tio(String name) {
        this.name = name;
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

    public List<Sobrinho> getSobrinhos() {
        return sobrinhos;
    }

    public void setSobrinhos(List<Sobrinho> sobrinhos) {
        this.sobrinhos = sobrinhos;
    }
}
