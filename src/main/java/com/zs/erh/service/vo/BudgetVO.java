package com.zs.erh.service.vo;



import java.math.BigDecimal;
import java.util.Date;

public class BudgetVO {
    private Date dateMin;
    private Date dateMax;

    private Long agenceId;
    private Long nbrBudget;
    private BigDecimal totalMontantBudget;


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

    public Long getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
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




}
