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
    private Long sroId;
    private Long groupeTacheId;
    private Long nroId;

    private Long projetId;
    private Integer semaine;
    private Integer mois;
    private Integer annee;

    private Long periodeId;

    private Lot lot;
    private Long totalPeriode;
    private BigDecimal totalHeure;

    private Date dateDemarrageEffectiveMin;
    private Date dateDemarrageEffectiveMax;

    private Date dateDemarrageEffective;
    private Date dateFinEffective;

    private String code;

    public TacheVo(Date dateDemarrageEffectiveMin, Date dateDemarrageEffectiveMax, Long equipeId, Long membreEquipeId, Long lotId, Long clientId, Long sroId, Long projetId, Integer semaine, Integer mois, Integer annee) {
        this.dateDemarrageEffectiveMin = dateDemarrageEffectiveMin;
        this.dateDemarrageEffectiveMax = dateDemarrageEffectiveMax;
        this.equipeId = equipeId;
        this.membreEquipeId = membreEquipeId;
        this.lotId = lotId;
        this.clientId = clientId;
        this.sroId = sroId;
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

    public Long getSroId() {
        return sroId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSroId(Long sroId) {
        this.sroId = sroId;
    }

    public Long getNroId() {
        return nroId;
    }

    public void setNroId(Long nroId) {
        this.nroId = nroId;
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

    @Override
    public String toString() {
        return "TacheVo{" + "responsableId=" + responsableId + ", lotId=" + lotId + ", equipeId=" + equipeId + ", clientId=" + clientId + ", sroId=" + sroId + ", groupeTacheId=" + groupeTacheId + ", nroId=" + nroId + ", projetId=" + projetId + ", periodeId=" + periodeId + ", dateDemarrageEffective=" + dateDemarrageEffective + ", dateFinEffective=" + dateFinEffective + '}';
    }

}
