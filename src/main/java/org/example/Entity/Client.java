package org.example.Entity;

import lombok.Data;


public class Client {
    private Long id;
    private String name;

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client() {

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


}
