package com.zs.erh.service.facade;

import com.zs.erh.bean.Nro;

import java.util.List;

public interface NroService {
    public List<Nro> findAll();

    public Nro findByCode(String Code);

    public int deleteByCode(String code);
}
