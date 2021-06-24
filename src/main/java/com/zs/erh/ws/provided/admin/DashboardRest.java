package com.zs.erh.ws.provided.admin;

import com.zs.erh.service.facade.DashboardService;
import com.zs.erh.service.vo.StatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/maneo-rh/admin/dashboard")
public class DashboardRest {
    @Autowired
    private DashboardService dashboardService;

    @PostMapping("/")
    public StatisticVO calcStatistiques(@RequestBody StatisticVO statisticVO) {
        return dashboardService.calcStatistiques(statisticVO);
    }

    @PostMapping("/taches")
    public StatisticVO calculStatisticTache(@RequestBody StatisticVO statisticVO) {
        return dashboardService.calculStatisticTache(statisticVO);
    }
}
