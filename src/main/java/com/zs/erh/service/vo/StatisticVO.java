package com.zs.erh.service.vo;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StatisticVO {
    private Date dateMax;
    private Date dateMin;
    private Long chefAgenceId;
    private List<String> times;
    private String showType;
    private Long showNumber;
    private List<BigDecimal> budgetTotal;
    private  BudgetVO budgetVO;

    public BudgetVO getBudgetVO() {
        return budgetVO;
    }

    public void setBudgetVO(BudgetVO budgetVO) {
        this.budgetVO = budgetVO;
    }

   /* public StatisticVO (Date dateMax, String showType, Long showNumber) {
        this.dateMax = dateMax;
        this.showType = showType;
        this.showNumber = showNumber;
    }*/

    public Date getDateMax() {
        return dateMax;
    }

    public void setDateMax(Date dateMax) {
        this.dateMax = dateMax;
    }

    public Date getDateMin() {
        return dateMin;
    }

    public void setDateMin(Date dateMin) {
        this.dateMin = dateMin;
    }

    public Long getChefAgenceId() {
        return chefAgenceId;
    }

    public void setChefAgenceId(Long chefAgenceId) {
        this.chefAgenceId = chefAgenceId;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public Long getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(Long showNumber) {
        this.showNumber = showNumber;
    }

    public List<BigDecimal> getBudgetTotal() {
        return budgetTotal;
    }

    public void setBudgetTotal(List<BigDecimal> budgetTotal) {
        this.budgetTotal = budgetTotal;
    }
}
