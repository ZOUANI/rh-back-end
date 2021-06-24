package com.zs.erh.service.vo;

import com.zs.erh.bean.Collaborateur;

import java.math.BigDecimal;
import java.util.Date;

public class CollaborateurVo {

    private Collaborateur collaborateur;
    private BigDecimal sommeJourTravail;
    private BigDecimal sommeJourConge;
    private BigDecimal sommeJourNonWeekEnd;
    private BigDecimal sommeJourDecalage;

    private Date dateDemarrageEffectiveMin;
    private Date dateDemarrageEffectiveMax;

    private Long chefAgenceId;
    private Long chefEquipeId;

    public CollaborateurVo(Collaborateur collaborateur, Long sommeDemiJournee) {
        this.collaborateur = collaborateur;
        this.sommeJourTravail = BigDecimal.valueOf(sommeDemiJournee).divide(new BigDecimal(2));
    }

    public CollaborateurVo() {
    }

    public Collaborateur getCollaborateur() {
        if (collaborateur == null) {
            collaborateur = new Collaborateur();
        }
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public BigDecimal getSommeJourTravail() {
        return sommeJourTravail;
    }

    public void setSommeJourTravail(BigDecimal sommeJourTravail) {
        this.sommeJourTravail = sommeJourTravail;
    }

    public BigDecimal getSommeJourConge() {
        return sommeJourConge;
    }

    public void setSommeJourConge(BigDecimal sommeJourConge) {
        this.sommeJourConge = sommeJourConge;
    }

    public BigDecimal getSommeJourNonWeekEnd() {
        return sommeJourNonWeekEnd;
    }

    public void setSommeJourNonWeekEnd(BigDecimal sommeJourNonWeekEnd) {
        this.sommeJourNonWeekEnd = sommeJourNonWeekEnd;
    }

    public BigDecimal getSommeJourDecalage() {
        return sommeJourDecalage;
    }

    public void setSommeJourDecalage(BigDecimal sommeJourDecalage) {
        this.sommeJourDecalage = sommeJourDecalage;
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

    public Long getChefAgenceId() {
        return chefAgenceId;
    }

    public void setChefAgenceId(Long chefAgenceId) {
        this.chefAgenceId = chefAgenceId;
    }

    public Long getChefEquipeId() {
        return chefEquipeId;
    }

    public void setChefEquipeId(Long chefEquipeId) {
        this.chefEquipeId = chefEquipeId;
    }
}
