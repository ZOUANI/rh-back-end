package com.zs.erh.service.vo;



import java.math.BigDecimal;
import java.util.Date;

public class BudgetVO {
    private Date dateMin;
    private Date dateMax;

    private Long agenceId;
    private Integer nbrBudget;
    private BigDecimal total;

    public  BudgetVO( BigDecimal total,Integer nbrBudget){

        this.total = total;
        this.nbrBudget = nbrBudget;
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


    public Integer getNbrBudget() {
        return nbrBudget;
    }

    public void setNbrBudget(Integer nbrBudget) {
        this.nbrBudget = nbrBudget;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }



    public Long getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
    }
}
