package com.zs.erh.service.vo;

import com.zs.erh.bean.Collaborateur;

import java.util.Date;

public class DemandeCongeVo {

    private Date dateDemarrageEffectiveMin;
    private Date dateDemarrageEffectiveMax;
    private Long nbrJour;
    private Collaborateur collaborateur;
    private String nomCollaborateur;
    private Long collaborateurId;
    private Date dateMin;
    private Date dateMax;
    private Long etatDemandeCongeId;

    public Long getCollaborateurId() {
        return collaborateurId;
    }

    public void setCollaborateurId(Long collaborateurId) {
        this.collaborateurId = collaborateurId;
    }

    public Date getDateMin() {
        return dateMin;
    }

    public void setDateMin(Date dateMin) {
        this.dateMin = dateMin;
    }

    public Date getDateMax() {
        return dateMax;
    }

    public void setDateMax(Date dateMax) {
        this.dateMax = dateMax;
    }

    public Long getEtatDemandeCongeId() {
        return etatDemandeCongeId;
    }

    public void setEtatDemandeCongeId(Long etatDemandeCongeId) {
        this.etatDemandeCongeId = etatDemandeCongeId;
    }

    public String getNomCollaborateur() {
        return nomCollaborateur;
    }

    public void setNomCollaborateur(String nomCollaborateur) {
        this.nomCollaborateur = nomCollaborateur;
    }


    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public Date getDateDemarrageEffectiveMin() {
        return dateDemarrageEffectiveMin;
    }

    public void setDateDemarrageEffectiveMin(Date dateDemarrageEffectiveMin) {
        this.dateDemarrageEffectiveMin = dateDemarrageEffectiveMin;
    }

    public Date getDateDemarrageEffectiveMax() {
        return dateDemarrageEffectiveMax;
    }

    public void setDateDemarrageEffectiveMax(Date dateDemarrageEffectiveMax) {
        this.dateDemarrageEffectiveMax = dateDemarrageEffectiveMax;
    }

    public Long getNbrJour() {
        return nbrJour;
    }

    public void setNbrJour(Long nbrJour) {
        this.nbrJour = nbrJour;
    }

    public DemandeCongeVo() {
    }

    public DemandeCongeVo(Date dateDemarrageEffectiveMin, Date dateDemarrageEffectiveMax, Long nbrJour) {
        this.dateDemarrageEffectiveMin = dateDemarrageEffectiveMin;
        this.dateDemarrageEffectiveMax = dateDemarrageEffectiveMax;
        this.nbrJour = nbrJour;
    }

}
