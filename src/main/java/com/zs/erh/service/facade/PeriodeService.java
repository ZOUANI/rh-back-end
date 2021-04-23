package com.zs.erh.service.facade;

import com.zs.erh.bean.Periode;

import java.util.List;

public interface PeriodeService {
    public List<Periode> findAll();
    public Periode findByCode(String code);
}
