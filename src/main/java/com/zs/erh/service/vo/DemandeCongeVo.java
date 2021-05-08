package com.zs.erh.service.vo;

import com.zs.erh.bean.Collaborateur;

import java.util.Date;

public class DemandeCongeVo {

    private Date dateDemarrageEffectiveMin;
    private Date dateDemarrageEffectiveMax;
    private Long nbrJour;
    private Collaborateur collaborateur;

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
