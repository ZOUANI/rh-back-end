package com.zs.erh.service.vo;

import com.zs.erh.bean.Client;
import com.zs.erh.bean.Lot;
import com.zs.erh.bean.Projet;

public class GroupeTacheVO {
    private Long id;
    private String code;
    private String libelle;
    private String description;
    private Lot lot;
    private Projet projet;
    private Client client;

    public Projet getProjet() {
        if (this.projet == null){
            this.projet = new Projet();
        }
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Client getClient() {
        if (this.client == null){
            this.client = new Client();
        }
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Lot getLot() {
        if (this.lot== null){
            this.lot = new Lot();
        }
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
