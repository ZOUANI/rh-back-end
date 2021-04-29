package com.zs.erh.service.imple;

import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.ClientDao;
import com.zs.erh.service.facade.ClientService;
import com.zs.erh.service.facade.EntrepriseService;
import com.zs.erh.service.vo.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImple implements ClientService {
    public List<Client> findByEntrepriseCode(String code) {
        return clientDao.findByEntrepriseCode(code);
    }

    @Transactional
    public int deleteByEntrepriseCode(String code) {
        return clientDao.deleteByEntrepriseCode(code);
    }

    public void save(Entreprise entreprise, List<Client> clients) {
        for (Client client : clients) {
            client.setEntreprise(entreprise);
            clientDao.save(client);
        }
    }
    public List<Client> search(ClientVO clientVO){
        String query = "SELECT c FROM Client c where 1=1";
        if(clientVO.getCode()!=null){
            query+=" AND c.code LIKE '%" + clientVO.getCode() + "%'";
        }if(clientVO.getLibelle() != null){
            query+= " AND c.libelle LIKE '%" + clientVO.getLibelle() + "%'";
        }if(clientVO.getDescription()!=null){
            query+=" AND c.description LIKE '%" + clientVO.getDescription() + "%'";
        }
        return  entityManager.createQuery(query).getResultList();
    }


    @Transactional
    public int deleteByCode(String code) {
        return clientDao.deleteByCode(code);
    }

    public Optional<Client> findById(Long id) {
        return clientDao.findById(id);
    }

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> findByEntrepriseLibelle(String libelle) {
        return clientDao.findByEntrepriseLibelle(libelle);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public int deleteByEntrepriseLibelle(String libelle) {
        return clientDao.deleteByEntrepriseLibelle(libelle);
    }

    @Autowired
    private EntrepriseService entrepriseService;
}
