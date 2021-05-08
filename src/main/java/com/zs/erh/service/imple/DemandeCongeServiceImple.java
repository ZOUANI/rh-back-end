package com.zs.erh.service.imple;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.DemandeConge;
import com.zs.erh.bean.EtatDemandeConge;
import com.zs.erh.dao.DemandeCongeDao;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.facade.DemandeCongeService;
import com.zs.erh.service.facade.EtatDemandeCongeService;
import com.zs.erh.service.util.DateUtil;
import com.zs.erh.service.vo.DemandeCongeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeCongeServiceImple extends AbstractFacade<DemandeConge> implements DemandeCongeService {

    @Autowired
    private EntityManager entityManager;

    public Optional<DemandeConge> findById(Long id) {
        return demandeCongeDao.findById(id);
    }

    public List<DemandeConge> findByEtatDemandeCongeCode(String code) {
        return demandeCongeDao.findByEtatDemandeCongeCode(code);
    }

    public List<DemandeConge> findAll() {
        return demandeCongeDao.findAll();
    }

    public int save(DemandeConge demandeConge){
        if(demandeConge.getDateDepart().compareTo(demandeConge.getDateFin())>0){
            return -1;
        }
        EtatDemandeConge etatDemandeConge = etatDemandeCongeService.findByCode(demandeConge.getEtatDemandeConge().getCode());
        Collaborateur collaborateur= collaborateurService.findByCode(demandeConge.getCollaborateur().getCode());
        if(etatDemandeConge == null || collaborateur ==null){
            return  -2;
        }else if(!demandeConge.getEtatDemandeConge().getCode().equals("e1")){
            return -3;
        }else{
            demandeConge.setCollaborateur(collaborateur);
            demandeConge.setEtatDemandeConge(etatDemandeConge);
            demandeCongeDao.save(demandeConge);
            return  1;
        }

    }
    public int update(DemandeConge demandeConge) {
        Optional<DemandeConge> demandeConge1 = findById(demandeConge.getId());
        if (demandeConge1.isPresent()) {
            if (demandeConge.getDateDepart().compareTo(demandeConge.getDateFin()) > 0) {
                return -1;
            }
            Optional<EtatDemandeConge> etatDemandeConge = etatDemandeCongeService.findById(demandeConge.getEtatDemandeConge().getId());
            if (etatDemandeConge.isPresent()) {
                if (demandeConge.getEtatDemandeConge().getCode().equals("e1")) {
                    return -2;
                } else {
                    demandeConge1.get().setEtatDemandeConge(demandeConge.getEtatDemandeConge());
                    demandeConge1.get().setDateDepart(demandeConge.getDateDepart());
                    demandeConge1.get().setDateFin(demandeConge.getDateFin());
                    demandeConge1.get().setCommentaireValidateur(demandeConge.getCommentaireValidateur());
                    demandeCongeDao.save(demandeConge1.get());
                    return 1;
                }
            }else {
                return -3;
            }

        }else {
            return -4;
        }
    }

    public Long calcNombreJourTotal(Long collaborateurId, Date dateDebut, Date dateFin) {
        List<DemandeCongeVo> res = findByCollaborateurAndDateMinAndMax(collaborateurId, dateDebut, dateFin);
        Long sum = 0L;
        for (DemandeCongeVo demandeCongeVo : res) {
            sum += demandeCongeVo.getNbrJour();
        }
        return sum;
    }

    public List<DemandeCongeVo> findByCollaborateurAndDateMinAndMax(Long collaborateurId, Date dateDebut, Date dateFin) {
        List<DemandeConge> demandeConges = findByCriteria("collaborateur.id", collaborateurId.toString());
        List<DemandeCongeVo> res = new ArrayList();
        if (demandeConges != null) {
            for (DemandeConge dc : demandeConges) {
                if (dc.getDateFin().getTime() < dateFin.getTime() || dc.getDateDepart().getTime() > dateDebut.getTime()) {
                    Date dateMax = dc.getDateFin();
                    Date dateMin = dc.getDateDepart();
                    if (dc.getDateDepart().getTime() < dateDebut.getTime()) {
                        dateMin = dateDebut;
                    }
                    if (dateFin.getTime() < dc.getDateFin().getTime()) {
                        dateMax = dateFin;
                    }
                    DemandeCongeVo dcv = new DemandeCongeVo(dc.getDateDepart(), dc.getDateFin(), DateUtil.diffDays(dateMin, (dateMax)));
                    res.add(dcv);
                }
            }
        }
        return res;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
	public Class<DemandeConge> getEntityClass() {
		return DemandeConge.class;
	}

    @Transactional
    public void deleteById(Long id) {
        demandeCongeDao.deleteById(id);
    }

    @Autowired
    private DemandeCongeDao demandeCongeDao;
    @Autowired
    private EtatDemandeCongeService etatDemandeCongeService;
    @Autowired
    private CollaborateurService collaborateurService;

}
