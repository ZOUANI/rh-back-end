/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.bean;

import java.io.Serializable;
import java.util.Date;
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
public class Tache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;
    private String description;

    @ManyToOne
    private EtatTache etatTache;
    @ManyToOne
    private MembreEquipe membreEquipe;

    private Integer semaine;
    private Integer mois;
    private Integer annee;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDemarrageEffective;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinEffective;
    @ManyToOne
    private Periode periode;
    @ManyToOne
    private CategorieTache categorieTache;
    @ManyToOne
    private GroupeTache groupeTache;

    public Date getDateFinEffective() {
        return dateFinEffective;
    }

    public void setDateFinEffective(Date dateFinEffective) {
        this.dateFinEffective = dateFinEffective;
    }


    public GroupeTache getGroupeTache() {
        if (groupeTache == null) {
            groupeTache = new GroupeTache();
        }
        return groupeTache;
    }

    public void setGroupeTache(GroupeTache groupeTache) {
        this.groupeTache = groupeTache;
    }

    public CategorieTache getCategorieTache() {
        if (categorieTache == null) {
            categorieTache = new CategorieTache();
        }
        return categorieTache;
    }

    public void setCategorieTache(CategorieTache categorieTache) {
        this.categorieTache = categorieTache;
    }

    public Integer getSemaine() {
        return semaine;
    }

    public void setSemaine(Integer semaine) {
        this.semaine = semaine;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Periode getPeriode() {
        if (periode == null) {
            periode = new Periode();
        }
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
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

    public EtatTache getEtatTache() {
        if (etatTache == null) {
            etatTache = new EtatTache();
        }
        return etatTache;
    }

    public void setEtatTache(EtatTache etatTache) {
        this.etatTache = etatTache;
    }

    public Date getDateDemarrageEffective() {
        return dateDemarrageEffective;
    }

    public void setDateDemarrageEffective(Date dateDemarrageEffective) {
        this.dateDemarrageEffective = dateDemarrageEffective;
    }

    public MembreEquipe getMembreEquipe() {
        if (membreEquipe == null) {
            membreEquipe = new MembreEquipe();
        }
        return membreEquipe;
    }

    public void setMembreEquipe(MembreEquipe membreEquipe) {
        this.membreEquipe = membreEquipe;
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
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    
}
