/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author MoulaYounes
 */
@Entity
public class MembreEquipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Collaborateur collaborateur;
    @ManyToOne
    private Equipe equipe;

    public Collaborateur getCollaborateur() {
        if (collaborateur == null) {
            collaborateur = new Collaborateur();
        }
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public Equipe getEquipe() {
        if (equipe == null) {
            equipe = new Equipe();
        }
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MembreEquipe)) {
            return false;
        }
        MembreEquipe other = (MembreEquipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MembreEquipe{" + "id=" + id + ", collaborateur=" + collaborateur.getLogin() + ", equipe=" + equipe.getLibelle() + '}';
    }

    
}
