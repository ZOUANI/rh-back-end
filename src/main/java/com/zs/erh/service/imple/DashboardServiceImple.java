package com.zs.erh.service.imple;

import com.zs.erh.service.facade.*;
import com.zs.erh.service.vo.*;

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
    @Autowired
    private TacheService tacheService;


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
                    result.getTimes().get(i+1),statisticVO.getChefAgencecId());

             paiementVO = new PaiementVO(result.getTimes().get(i),
                     result.getTimes().get(i+1),statisticVO.getChefAgencecId());

            budgetVO = budgetService.calcStatistiqueBudget(budgetVO);
            result.getBudgetsTotal().add(budgetVO.getTotalMontantBudget());


            factureVO = factureService.calcStatistiqueFacture(factureVO);
            result.getFacturesTotal().add(factureVO.getTotalMontantFacture());

            paiementVO = paiementService.calcStatistiquePaiement(paiementVO);
            result.getPaiementsTotal().add(paiementVO.getTotalMontantPaiement());
        }


        return result;
    }

    public StatisticVO calculStatisticTache( StatisticVO statisticVO){
        StatisticVO result = new StatisticVO();
        statisticVO.Times();
        result.setTimes(statisticVO.getTimes());
        TacheVo tacheVo;
        BigDecimal minresult;
        for (int i=0;i<statisticVO.getShowNumber();i++){
            tacheVo = new TacheVo();
            tacheVo.setDateDemarrageEffectiveMax(result.getTimes().get(i));
            tacheVo.setDateDemarrageEffectiveMin(result.getTimes().get(i));
            tacheVo.setChefAgenceId(result.getChefAgencecId());
            result.getNbrTache().add(tacheService.calculNbrTache(tacheVo));
        }
        return result;
    }
}