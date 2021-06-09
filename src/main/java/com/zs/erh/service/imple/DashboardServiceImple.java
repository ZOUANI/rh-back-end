package com.zs.erh.service.imple;

import com.zs.erh.service.vo.StatisticVO;
import com.zs.erh.service.vo.BudgetVO;

import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.facade.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImple implements DashboardService {
    @Autowired
    private BudgetService budgetService;


    public StatisticVO calcStatistiques(StatisticVO statisticVO) {
        StatisticVO result = new StatisticVO();

        statisticVO.Times();
        result.setTimes(statisticVO.getTimes());

        BudgetVO budgetVO;

        for (int i=0;i<statisticVO.getShowNumber();i++){
            budgetVO = new BudgetVO(result.getTimes().get(i+1),
                                    result.getTimes().get(i));
            System.out.println("3tina " + budgetVO);
            budgetVO = budgetService.calcStatistiqueBudget(budgetVO);
            System.out.println("rd lina " + budgetVO);

            result.getBudgetTotal().add(budgetVO.getTotalMontantBudget());
        }

        System.out.println("result = " + statisticVO);


        return result;
    }
}
