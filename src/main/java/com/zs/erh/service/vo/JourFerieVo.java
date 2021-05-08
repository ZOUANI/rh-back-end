package com.zs.erh.service.vo;

import java.util.Date;

public class JourFerieVo {

    private Date dateDemarrageEffectiveMin;
    private Date dateDemarrageEffectiveMax;
    private Long nbrJour;

    public Date getDateDemarrageEffectiveMin() {
        return dateDemarrageEffectiveMin;
    }

    public void setDateDemarrageEffectiveMin(Date dateDemarrageEffectiveMin) {
        this.dateDemarrageEffectiveMin = dateDemarrageEffectiveMin;
    }

    public Date getDateDemarrageEffectiveMax() {
        return dateDemarrageEffectiveMax;
    }

    public void setDateDemarrageEffectiveMax(Date dateDemarrageEffectiveMax) {
        this.dateDemarrageEffectiveMax = dateDemarrageEffectiveMax;
    }

    public Long getNbrJour() {
        return nbrJour;
    }

    public void setNbrJour(Long nbrJour) {
        this.nbrJour = nbrJour;
    }

    public JourFerieVo() {
    }

    public JourFerieVo(Date dateDemarrageEffectiveMin, Date dateDemarrageEffectiveMax, Long nbrJour) {
        this.dateDemarrageEffectiveMin = dateDemarrageEffectiveMin;
        this.dateDemarrageEffectiveMax = dateDemarrageEffectiveMax;
        this.nbrJour = nbrJour;
    }

}
