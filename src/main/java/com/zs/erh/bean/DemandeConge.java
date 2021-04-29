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
public class DemandeConge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Collaborateur collaborateur;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    private String messageCollaborateur;
    private String commentaireValidateur;
    @ManyToOne
    private EtatDemandeConge etatDemandeConge;

    public Collaborateur getCollaborateur() {
        if (collaborateur == null) {
            collaborateur = new Collaborateur();
        }
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getMessageCollaborateur() {
        return messageCollaborateur;
    }

    public void setMessageCollaborateur(String messageCollaborateur) {
        this.messageCollaborateur = messageCollaborateur;
    }

    public String getCommentaireValidateur() {
        return commentaireValidateur;
    }

    public void setCommentaireValidateur(String commentaireValidateur) {
        this.commentaireValidateur = commentaireValidateur;
    }

    public EtatDemandeConge getEtatDemandeConge() {
        return etatDemandeConge;
    }

    public void setEtatDemandeConge(EtatDemandeConge etatDemandeConge) {
        this.etatDemandeConge = etatDemandeConge;
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
        if (!(object instanceof DemandeConge)) {
            return false;
        }
        DemandeConge other = (DemandeConge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telcom.rh.bean.DemandeConge[ id=" + id + " ]";
    }

}
