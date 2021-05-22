package com.zs.erh.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Agence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;

    @ManyToOne
    private ChefAgence chefAgence;

    @ManyToOne
    private EtatAgence etatAgence;

    @ManyToOne
    private Ville ville;

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

    public ChefAgence getChefAgence() {
        return chefAgence;
    }

    public void setChefAgence(ChefAgence chefAgence) {
        this.chefAgence = chefAgence;
    }

    public EtatAgence getEtatAgence() {
        return etatAgence;
    }

    public void setEtatAgence(EtatAgence etatAgence) {
        this.etatAgence = etatAgence;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
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
        if (!(object instanceof Agence)) {
            return false;
        }
        Agence other = (Agence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
