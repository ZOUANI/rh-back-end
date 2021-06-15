package com.zs.erh.service.imple;

import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.facade.PaiementService;
import com.zs.erh.service.vo.FactureVO;
import com.zs.erh.service.vo.PaiementVO;
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
    @Autowired
    private PaiementService paiementService;


    public StatisticVO calcStatistiques(StatisticVO statisticVO) {
        StatisticVO result = new StatisticVO();
        result.getFacturesTotal().clear();
        result.getBudgetsTotal().clear();
        result.getPaiementsTotal().clear();
        statisticVO.Times();
        result.setTimes(statisticVO.getTimes());

        BudgetVO budgetVO;
        FactureVO factureVO;
        PaiementVO paiementVO;

        for (int i=0;i<statisticVO.getShowNumber();i++){
            budgetVO = new BudgetVO(result.getTimes().get(i),
                                    result.getTimes().get(i+1));

            factureVO = new FactureVO(result.getTimes().get(i),
                    result.getTimes().get(i+1),statisticVO.getChefAgenceLogin());

             paiementVO = new PaiementVO(result.getTimes().get(i),
                     result.getTimes().get(i+1),statisticVO.getChefAgenceLogin());

            budgetVO = budgetService.calcStatistiqueBudget(budgetVO);
            result.getBudgetsTotal().add(budgetVO.getTotalMontantBudget());

            factureVO = factureService.calcStatistiqueFacture(factureVO);
            result.getFacturesTotal().add(factureVO.getTotalMontantFacture());

            paiementVO = paiementService.calcStatistiquePaiement(paiementVO);
            result.getPaiementsTotal().add(paiementVO.getTotalMontantPaiement());
        }


        return result;
    }
}
