package com.zs.erh.service.vo;

import java.math.BigDecimal;
import java.util.Date;

public class FactureVO {

    private Long clientId;
    private String chefAgenceLogin;
    private Long etatFactureId;
    private Date dateMin;
    private Date dateMax;
    private  Long nbrFacture;
    private BigDecimal totalMontantFacture;

    public String getChefAgenceLogin() {
        return chefAgenceLogin;
    }

    public void setChefAgenceLogin(String chefAgenceLogin) {
        this.chefAgenceLogin = chefAgenceLogin;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getEtatFactureId() {
        return etatFactureId;
    }

    public void setEtatFactureId(Long etatFactureId) {
        this.etatFactureId = etatFactureId;
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

    public Long getNbrFacture() {
        return nbrFacture;
    }

    public void setNbrFacture(Long nbrFacture) {
        this.nbrFacture = nbrFacture;
    }

    public BigDecimal getTotalMontantFacture() {
        return totalMontantFacture;
    }

    public void setTotalMontantFacture(BigDecimal totalMontantFacture) {
        this.totalMontantFacture = totalMontantFacture;
    }

    public  FactureVO(BigDecimal totalMontantFacture, Long nbrFacture) {
        this.totalMontantFacture = totalMontantFacture;
        this.nbrFacture = nbrFacture;
    }

    public FactureVO(Date dateMin, Date dateMax,String chefAgenceLogin) {
        this.dateMin = dateMin;
        this.dateMax = dateMax;
        this.chefAgenceLogin = chefAgenceLogin;
    }
}
