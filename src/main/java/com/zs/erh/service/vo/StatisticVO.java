package com.zs.erh.service.vo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class StatisticVO implements Serializable {
    private Date dateMax;
    private Date dateMin;
    private Date currentDate;

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    private String chefAgenceLogin;
    private List<Date> times;
    private String showType;
    private Long showNumber;
    private List<BigDecimal> budgetsTotal;
    private List<BigDecimal> facturesTotal;
    private List<BigDecimal> paiementsTotal;

    private  BudgetVO budgetVO;

    public List<BigDecimal> getPaiementsTotal() {
        if(this.paiementsTotal == null){
            this.paiementsTotal = new ArrayList<BigDecimal>();
        }
        return paiementsTotal;
    }

    public void setPaiementsTotal(List<BigDecimal> paiementsTotal) {
        this.paiementsTotal = paiementsTotal;
    }

    public BudgetVO getBudgetVO() {
        return budgetVO;
    }

    public void setBudgetVO(BudgetVO budgetVO) {
        this.budgetVO = budgetVO;
    }

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

    public String getChefAgenceLogin() {
        return chefAgenceLogin;
    }

    public void setChefAgenceLogin(String chefAgenceLogin) {
        this.chefAgenceLogin = chefAgenceLogin;
    }

    public List<Date> getTimes() {
        if(this.times == null)
            this.times = new ArrayList<Date>();
        return times;
    }

    public void setTimes(List<Date> times) {
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

    public List<BigDecimal> getBudgetsTotal() {
        if (this.budgetsTotal == null)
            this.budgetsTotal = new ArrayList<BigDecimal>();
        return budgetsTotal;
    }

    public void setBudgetsTotal(List<BigDecimal> budgetTotal) {
        this.budgetsTotal = budgetTotal;
    }


    public List<BigDecimal> getFacturesTotal() {
        if (this.facturesTotal == null)
            this.facturesTotal = new ArrayList<BigDecimal>();
        return facturesTotal;
    }

    public void setFacturesTotal(List<BigDecimal> facturesTotal) {
        this.facturesTotal = facturesTotal;
    }

    public void Times (){
        this.getTimes().add(this.currentDate);
        int year = this.currentDate.getYear();
        int month = this.currentDate.getMonth();

        if (this.showType.equals("years")){
            month = 1;
            for (int i=0;i<this.showNumber;i++){
                this.times.add(new Date(year-i,month,1));
            }
            System.out.println(this.times);
        }

        else if(this.showType.equals("months")){
            for (int i=0;i<this.showNumber;i++){
                this.times.add(new Date(year,month-i,1));
                if (month == 1){
                    month = 12;
                    year -= 1;
                }
            }
        }

        Collections.reverse(times);
    }
}
