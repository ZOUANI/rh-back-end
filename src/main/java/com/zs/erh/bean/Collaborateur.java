/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author MoulaYounes
 */
@Entity
@DiscriminatorValue("collaborateur")
public class Collaborateur extends User implements Serializable {


    @ManyToOne
    private Agence agence;
    @ManyToOne
    private MessageDetail messageDetail;

    @ManyToOne
    private CategorieCollaborateur categorieCollaborateur;


    public CategorieCollaborateur getCategorieCollaborateur() {
        return categorieCollaborateur;
    }

    public void setCategorieCollaborateur(CategorieCollaborateur categorieCollaborateur) {
        this.categorieCollaborateur = categorieCollaborateur;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Collaborateur() {
    }

    public Collaborateur(User user) {
        this.setNom(user.getNom());
        this.setPrenom(user.getPrenom());
        this.setCode(user.getCode());
        this.setLogin(user.getLogin());
        this.setPassword(user.getPassword());
        this.setNom(user.getNom());
        this.setNom(user.getNom());
        this.setPhone (user.getPhone());
        this.setEmail (user.getEmail());
        this.setNbrCnx (user.getNbrCnx());
        this.setBlocked (user.isBlocked());
        this.setMustChangePassword(user.isMustChangePassword());
    }

    @Override
    public String toString() {
        return getCode();
    }
}
