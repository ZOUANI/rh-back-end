package com.zs.erh.service.facade;

import com.zs.erh.bean.Entreprise;
import com.zs.erh.bean.Sro;

import java.util.List;
import java.util.Optional;

public interface SroService {
    public List<Sro> findAll();
    Optional<Sro> findById(Long id);
    public Sro findByCode(String code);
}
