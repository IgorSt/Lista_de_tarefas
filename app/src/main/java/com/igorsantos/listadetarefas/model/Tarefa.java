package com.igorsantos.listadetarefas.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private Long id;
    private String nomeDaTarefa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaTarefa() {
        return nomeDaTarefa;
    }

    public void setNomeDaTarefa(String nomeDaTarefa) {
        this.nomeDaTarefa = nomeDaTarefa;
    }
}
