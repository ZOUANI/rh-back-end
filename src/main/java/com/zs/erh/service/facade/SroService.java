package com.zs.erh.service.facade;

import com.zs.erh.bean.Sro;

import java.util.List;

public interface SroService {
    public List<Sro> findAll();

    public Sro findByCode(String code);
}
