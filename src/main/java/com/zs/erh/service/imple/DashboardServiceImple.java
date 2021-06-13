package com.zs.erh.service.imple;

import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.vo.FactureVO;
import com.zs.erh.service.vo.StatisticVO;
import com.zs.erh.service.vo.BudgetVO;

import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.facade.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DashboardServiceImple implements DashboardService {
    @Autowired
    private BudgetService budgetService;

    @Autowired
    private FactureService factureService;


    public StatisticVO calcStatistiques(StatisticVO statisticVO) {
        StatisticVO result = new StatisticVO();
        result.getFacturesTotal().clear();
        result.getBudgetTotal().clear();
        statisticVO.Times();
        result.setTimes(statisticVO.getTimes());

        BudgetVO budgetVO;
        FactureVO factureVO;

        for (int i=0;i<statisticVO.getShowNumber();i++){
            budgetVO = new BudgetVO(result.getTimes().get(i),
                                    result.getTimes().get(i+1),statisticVO.getChefAgenceId());

            factureVO = new FactureVO(result.getTimes().get(i+1),
                    result.getTimes().get(i));


            budgetVO = budgetService.calcStatistiqueBudget(budgetVO);
            if(budgetVO.getTotalMontantBudget() == null){
                result.getBudgetTotal().add(BigDecimal.ZERO);
            }else{
                result.getBudgetTotal().add(budgetVO.getTotalMontantBudget());
            }

            factureVO = factureService.calcStatistiqueFacture(factureVO);
            result.getFacturesTotal().add(factureVO.getTotalMontantFacture());
        }


        return result;
    }
}
