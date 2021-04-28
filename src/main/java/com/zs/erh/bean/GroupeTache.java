/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author MoulaYounes
 */
@Entity
public class GroupeTache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;
    private String description;
    @ManyToOne
    private EtatGroupeTache etatGroupeTache;
    private double avancement;
    private double poids;
    private double nombreJoureHommeRetard;
    private double nombreJoureHommePrevu;
    private double nombreJoureHommeEffectif;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDemarragePrevu;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDemarrageEffective;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinPrevu;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinEffective;
    @ManyToOne
    private Equipe equipe;
    @ManyToOne
    private Lot lot;
    @ManyToOne
    private CategorieGroupeTache categorieGroupeTache;

    public CategorieGroupeTache getCategorieGroupeTache() {
        if (categorieGroupeTache == null) {
            categorieGroupeTache = new CategorieGroupeTache();
        }
        return categorieGroupeTache;
    }

    public void setCategorieGroupeTache(CategorieGroupeTache categorieGroupeTache) {
        this.categorieGroupeTache = categorieGroupeTache;
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

    public EtatGroupeTache getEtatGroupeTache() {
        if (etatGroupeTache == null) {
            etatGroupeTache = new EtatGroupeTache();
        }
        return etatGroupeTache;
    }

    public void setEtatGroupeTache(EtatGroupeTache etatGroupeTache) {
        this.etatGroupeTache = etatGroupeTache;
    }

    public double getAvancement() {
        return avancement;
    }

    public void setAvancement(double avancement) {
        this.avancement = avancement;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getNombreJoureHommeRetard() {
        return nombreJoureHommeRetard;
    }

    public void setNombreJoureHommeRetard(double nombreJoureHommeRetard) {
        this.nombreJoureHommeRetard = nombreJoureHommeRetard;
    }

    public double getNombreJoureHommePrevu() {
        return nombreJoureHommePrevu;
    }

    public void setNombreJoureHommePrevu(double nombreJoureHommePrevu) {
        this.nombreJoureHommePrevu = nombreJoureHommePrevu;
    }

    public double getNombreJoureHommeEffectif() {
        return nombreJoureHommeEffectif;
    }

    public void setNombreJoureHommeEffectif(double nombreJoureHommeEffectif) {
        this.nombreJoureHommeEffectif = nombreJoureHommeEffectif;
    }

    public Date getDateDemarragePrevu() {
        return dateDemarragePrevu;
    }

    public void setDateDemarragePrevu(Date dateDemarragePrevu) {
        this.dateDemarragePrevu = dateDemarragePrevu;
    }

    public Date getDateDemarrageEffective() {
        return dateDemarrageEffective;
    }

    public void setDateDemarrageEffective(Date dateDemarrageEffective) {
        this.dateDemarrageEffective = dateDemarrageEffective;
    }

    public Date getDateFinPrevu() {
        return dateFinPrevu;
    }

    public void setDateFinPrevu(Date dateFinPrevu) {
        this.dateFinPrevu = dateFinPrevu;
    }

    public Date getDateFinEffective() {
        return dateFinEffective;
    }

    public void setDateFinEffective(Date dateFinEffective) {
        this.dateFinEffective = dateFinEffective;
    }

    public Lot getLot() {
        if (lot == null) {
            lot = new Lot();
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupeTache)) {
            return false;
        }
        GroupeTache other = (GroupeTache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcom.rh.bean.GroupeTache[ id=" + id + " ]";
    }

}
