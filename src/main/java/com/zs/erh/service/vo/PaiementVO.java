package com.zs.erh.service.vo;

import com.zs.erh.bean.Facture;

import java.math.BigDecimal;
import java.util.Date;

public class PaiementVO {

    private Long factureId;
    private String chefAgenceLogin;

    private Date dateMin;
    private Date dateMax;
    private Long nbrPaiement;
    private BigDecimal totalMontantPaiement;

    public String getChefAgenceLogin() {
        return chefAgenceLogin;
    }

    public void setChefAgenceLogin(String chefAgenceLogin) {
        this.chefAgenceLogin = chefAgenceLogin;
    }

    public Long getFactureId() {
        return factureId;
    }

    public void setFactureId(Long factureId) {
        this.factureId = factureId;
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

    public Long getNbrPaiement() {
        return nbrPaiement;
    }

    public void setNbrPaiement(Long nbrPaiement) {
        this.nbrPaiement = nbrPaiement;
    }

    public BigDecimal getTotalMontantPaiement() {
        return totalMontantPaiement;
    }

    public void setTotalMontantPaiement(BigDecimal totalMontantPaiement) {
        this.totalMontantPaiement = totalMontantPaiement;
    }

    public PaiementVO(BigDecimal totalMontantPaiement, Long nbrPaiement) {
        this.totalMontantPaiement = totalMontantPaiement;
        this.nbrPaiement = nbrPaiement;
    }
    public PaiementVO(Date dateMin, Date dateMax, String chefAgenceLogin) {
        this.dateMin = dateMin;
        this.dateMax = dateMax;
        this.chefAgenceLogin = chefAgenceLogin;
    }

}
