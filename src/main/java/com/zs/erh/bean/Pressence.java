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
public class Pressence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Collaborateur collaborateur;
    @ManyToOne
    private EntiteAdministrative entiteAdministrative;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateEntree;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateSortie;
    private Integer minuteRetard;
    private Integer heureRetard;
    private Integer nombreHeureTravail;
    private Integer semaine;
    private Integer mois;
    private Integer annee;
    @ManyToOne
    private Periode periode;
    // add type pressence : deplacement ou agence

    public Integer getHeureRetard() {
        return heureRetard;
    }

    public void setHeureRetard(Integer heureRetard) {
        this.heureRetard = heureRetard;
    }

    
    public Collaborateur getCollaborateur() {
        if(collaborateur==null){
            collaborateur= new Collaborateur();
        }
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public EntiteAdministrative getEntiteAdministrative() {
         if(entiteAdministrative==null){
            entiteAdministrative= new EntiteAdministrative();
        }
        return entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative) {
        this.entiteAdministrative = entiteAdministrative;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Integer getMinuteRetard() {
        return minuteRetard;
    }

    public void setMinuteRetard(Integer minuteRetard) {
        this.minuteRetard = minuteRetard;
    }

    public Integer getNombreHeureTravail() {
        return nombreHeureTravail;
    }

    public void setNombreHeureTravail(Integer nombreHeureTravail) {
        this.nombreHeureTravail = nombreHeureTravail;
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
         if(periode==null){
            periode= new Periode();
        }
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pressence)) {
            return false;
        }
        Pressence other = (Pressence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+"" ;
    }

}
