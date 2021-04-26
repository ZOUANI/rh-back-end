/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author MoulaYounes
 */
@Entity
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;
    private String description;

    @ManyToOne
    private Collaborateur responsable;
    @ManyToOne
    private EtatEquipe etatEquipe;
    /*@OneToMany(mappedBy = "equipe")
    private List<MembreEquipe> membresEquipe; */


    public EtatEquipe getEtatEquipe() {
        if (etatEquipe == null) {
            etatEquipe = new EtatEquipe();
        }
        return etatEquipe;
    }

    public void setEtatEquipe(EtatEquipe etatEquipe) {
        this.etatEquipe = etatEquipe;
    }

    public Collaborateur getResponsable() {
        if (responsable == null) {
            responsable = new Collaborateur();
        }
        return responsable;
    }

    public void setResponsable(Collaborateur responsable) {
        this.responsable = responsable;
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
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcom.rh.bean.Equipe[ id=" + id + " ]";
    }

}
