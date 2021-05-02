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


    public int save(Client client){
        if(findByCode(client.getCode())!=null) {
            return -1;
        }else{
            Entreprise entreprise = entrepriseService.findByCode(client.getEntreprise().getCode());
            if(entreprise==null){
                return -2;
            }else {
                client.setEntreprise(entreprise);
                clientDao.save(client);
                return 1;
            }
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


    public int updateClient(Client client){
        Client client1 = findByCode(client.getCode());
        Optional<Entreprise> entreprise = entrepriseService.findById(client.getEntreprise().getId());
        if(entreprise.isPresent()){
            client1.setEntreprise(client.getEntreprise());
            client1.setLibelle(client.getLibelle());
            client1.setDescription(client.getDescription());
            clientDao.save(client1);
            return 1;
        }else {
            return -1;
        }


    }

    @Transactional
    public int deleteByCode(String code) {
        return clientDao.deleteByCode(code);
    }

    public Optional<Client> findById(Long id) {
        return clientDao.findById(id);
    }

    @Override
    public Client findByCode(String code) {
        return clientDao.findByCode(code);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private  EntrepriseService entrepriseService;
}
