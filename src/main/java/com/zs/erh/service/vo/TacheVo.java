/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.vo;

import com.zs.erh.bean.Lot;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author MoulaYounes
 */
public class TacheVo {

    private Long responsableId;
    private Long membreEquipeId;
    private Long lotId;
    private Long equipeId;
    private Long clientId;
    private Long groupeTacheId;
    private Long chefAgenceId;

    private Long projetId;
    private Integer semaine;
    private Integer mois;
    private Integer annee;

    private Long periodeId;
    private Long etatTacheId;

    private Lot lot;
    private Long totalPeriode;
    private BigDecimal totalHeure;

    private Date dateDemarrageEffectiveMin;
    private Date dateDemarrageEffectiveMax;

    private Date dateDemarrageEffective;
    private Date dateFinEffective;

    private String code;
    private String libelle;


    public TacheVo(Date dateDemarrageEffectiveMin, Date dateDemarrageEffectiveMax, Long equipeId, Long membreEquipeId, Long lotId, Long clientId, Long projetId, Integer semaine, Integer mois, Integer annee) {
        this.dateDemarrageEffectiveMin = dateDemarrageEffectiveMin;
        this.dateDemarrageEffectiveMax = dateDemarrageEffectiveMax;
        this.equipeId = equipeId;
        this.membreEquipeId = membreEquipeId;
        this.lotId = lotId;
        this.clientId = clientId;
        this.projetId = projetId;
        this.semaine = semaine;
        this.mois = mois;
        this.annee = annee;
    }

    public TacheVo(Date dateDemarrageEffectiveMin, Date dateDemarrageEffectiveMax, Long equipeId, Long membreEquipeId, Long lotId, Long clientId, Long projetId) {
        this.dateDemarrageEffectiveMin = dateDemarrageEffectiveMin;
        this.dateDemarrageEffectiveMax = dateDemarrageEffectiveMax;
        this.equipeId = equipeId;
        this.membreEquipeId = membreEquipeId;
        this.lotId = lotId;
        this.clientId = clientId;
        this.projetId = projetId;
    }

    public Long getGroupeTacheId() {
        return groupeTacheId;
    }

    public void setGroupeTacheId(Long groupeTacheId) {
        this.groupeTacheId = groupeTacheId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() { return libelle; }

    public void setLibelle(String libelle) { this.libelle = libelle; }

    public Long getEtatTacheId() {
        return etatTacheId;
    }

    public void setEtatTacheId(Long etatTacheId) {
        this.etatTacheId = etatTacheId;
    }

    public TacheVo() {
    }

    public TacheVo(Lot lot, Long totalPeriode) {
        this.lot = lot;
        this.totalPeriode = totalPeriode;
        this.totalHeure = new BigDecimal(totalPeriode).multiply(BigDecimal.valueOf(4.4));
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Long getTotalPeriode() {
        return totalPeriode;
    }

    public void setTotalPeriode(Long totalPeriode) {
        this.totalPeriode = totalPeriode;
    }

    public BigDecimal getTotalHeure() {
        return totalHeure;
    }

    public void setTotalHeure(BigDecimal totalHeure) {
        this.totalHeure = totalHeure;
    }

    public Long getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Long responsableId) {
        this.responsableId = responsableId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProjetId() {
        return projetId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
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

    public Long getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(Long periodeId) {
        this.periodeId = periodeId;
    }

    public Long getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Long equipeId) {
        this.equipeId = equipeId;
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

    public Long getMembreEquipeId() {
        return membreEquipeId;
    }

    public void setMembreEquipeId(Long membreEquipeId) {
        this.membreEquipeId = membreEquipeId;
    }

    public Long getChefAgenceId() {
        return chefAgenceId;
    }

    public void setChefAgenceId(Long chefAgenceId) {
        this.chefAgenceId = chefAgenceId;
    }

    @Override
    public String toString() {
        return "TacheVo{" + "responsableId=" + responsableId + ", lotId=" + lotId + ", equipeId=" + equipeId + ", clientId=" + clientId + ", groupeTacheId=" + groupeTacheId + ", projetId=" + projetId + ", periodeId=" + periodeId + ", dateDemarrageEffective=" + dateDemarrageEffective + ", dateFinEffective=" + dateFinEffective + '}';
    }


    public TacheVo(Date dateMin, Date dateMax) {
        this.dateDemarrageEffectiveMin = dateMin;
        this.dateDemarrageEffectiveMax = dateMax;
    }

}

