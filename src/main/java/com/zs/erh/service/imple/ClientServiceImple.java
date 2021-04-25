package com.zs.erh.service.imple;

import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.ClientDao;
import com.zs.erh.service.facade.ClientService;
import com.zs.erh.vo.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImple implements ClientService {
    public List<Client> findByEntrepriseLibelle(String libelle) {
        return clientDao.findByEntrepriseLibelle(libelle);
    }

    @Transactional
    public int deleteByEntrepriseLibelle(String libelle) {
        return clientDao.deleteByEntrepriseLibelle(libelle);
    }

    public void save(Entreprise entreprise, List<Client> clients) {
        for (Client client : clients) {
            client.setEntreprise(entreprise);
            clientDao.save(client);
        }
    }
    public List<Client> search(ClientVO clientVO){
        String query = "SELECT c FROM Client c where 1=1";
        if(clientVO.getLibelle() != null){
            query+= " AND c.libelle LIKE '%" + clientVO.getLibelle() + "%'";
        }if(clientVO.getCode()!=null){
            query+=" AND c.code LIKE '%" + clientVO.getCode() + "%'";
        }if(clientVO.getDescription()!=null){
            query+=" AND c.description LIKE '%" + clientVO.getDescription() + "%'";
        }
        return  entityManager.createQuery(query).getResultList();
    }

    @Transactional
    public int deleteByLibelle(String libelle) {
        return clientDao.deleteByLibelle(libelle);
    }

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }
}
