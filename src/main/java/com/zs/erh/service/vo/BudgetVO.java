package com.zs.erh.service.vo;



import java.math.BigDecimal;
import java.util.Date;

public class BudgetVO {
    private Date dateMin;
    private Date dateMax;
    private Date dateReponse;

    private Long chefAgenceId;
    private Long etatBudgetId;
    private Long nbrBudget;
    private BigDecimal totalMontantBudget;

    public Date getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(Date dateReponse) {
        this.dateReponse = dateReponse;
    }

    public Long getEtatBudgetId() {
        return etatBudgetId;
    }

    public void setEtatBudgetId(Long etatBudgetId) {
        this.etatBudgetId = etatBudgetId;
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

    public Long getChefAgenceId() {
        return chefAgenceId;
    }

    public void setChefAgenceId(Long agenceId) {
        this.chefAgenceId = agenceId;
    }

    public Long getNbrBudget() {
        return nbrBudget;
    }

    public void setNbrBudget(Long nbrBudget) {
        this.nbrBudget = nbrBudget;
    }

    public BigDecimal getTotalMontantBudget() {
        return totalMontantBudget;
    }

    public void setTotalMontantBudget(BigDecimal totalMontantBudget) {
        this.totalMontantBudget = totalMontantBudget;
    }


    public  BudgetVO(BigDecimal totalMontantBudget, Long nbrBudget) {
        this.totalMontantBudget = totalMontantBudget;
        this.nbrBudget = nbrBudget;
    }

    public BudgetVO(Date dateMin, Date dateMax,Long chefAgenceId) {
        this.dateMin = dateMin;
        this.dateMax = dateMax;
        this.chefAgenceId = chefAgenceId;
    }

    public BudgetVO() {
    }
}
