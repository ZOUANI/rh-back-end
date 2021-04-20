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
public class Projet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;
    private String description;

    @ManyToOne
    private EtatProjet etatProjet;
    private double avancement;
    private long nombreJoureHommeRetard;
    private long nombreJoureHommePrevu;
    private long nombreJoureHommeEffectif;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDemarragePrevu;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinPrevu;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDemarrageEffective;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinEffective;

    @ManyToOne
    private Collaborateur responsable;
    @ManyToOne
    private Nro nro;
    @ManyToOne
    private Equipe equipe;
    @ManyToOne
    private Client client;

    public Client getClient() {
        if (this.client == null) {
            this.client = new Client();
        }
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Equipe getEquipe() {
        if (this.equipe == null) {
            this.equipe = new Equipe();
        }
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Nro getNro() {
        if (this.nro == null) {
            this.nro = new Nro();
        }
        return nro;
    }

    public void setNro(Nro nro) {
        this.nro = nro;
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

    public EtatProjet getEtatProjet() {
        return etatProjet;
    }

    public void setEtatProjet(EtatProjet etatProjet) {
        this.etatProjet = etatProjet;
    }

    public double getAvancement() {
        return avancement;
    }

    public void setAvancement(double avancement) {
        this.avancement = avancement;
    }

    public long getNombreJoureHommeRetard() {
        return nombreJoureHommeRetard;
    }

    public void setNombreJoureHommeRetard(long nombreJoureHommeRetard) {
        this.nombreJoureHommeRetard = nombreJoureHommeRetard;
    }

    public long getNombreJoureHommePrevu() {
        return nombreJoureHommePrevu;
    }

    public void setNombreJoureHommePrevu(long nombreJoureHommePrevu) {
        this.nombreJoureHommePrevu = nombreJoureHommePrevu;
    }

    public long getNombreJoureHommeEffectif() {
        return nombreJoureHommeEffectif;
    }

    public void setNombreJoureHommeEffectif(long nombreJoureHommeEffectif) {
        this.nombreJoureHommeEffectif = nombreJoureHommeEffectif;
    }

    public Date getDateDemarragePrevu() {
        return dateDemarragePrevu;
    }

    public void setDateDemarragePrevu(Date dateDemarragePrevu) {
        this.dateDemarragePrevu = dateDemarragePrevu;
    }

    public Date getDateFinPrevu() {
        return dateFinPrevu;
    }

    public void setDateFinPrevu(Date dateFinPrevu) {
        this.dateFinPrevu = dateFinPrevu;
    }

    public Date getDateDemarrageEffective() {
        return dateDemarrageEffective;
    }

    public void setDateDemarrageEffective(Date dateDemarrageEffective) {
        this.dateDemarrageEffective = dateDemarrageEffective;
    }

    public Date getDateFinEffective() {
        return dateFinEffective;
    }

    public void setDateFinEffective(Date dateFinEffective) {
        this.dateFinEffective = dateFinEffective;
    }

    public Collaborateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Collaborateur responsable) {
        this.responsable = responsable;
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
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code;
    }

}
