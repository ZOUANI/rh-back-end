package com.zs.erh.service.imple;

import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.ClientDao;
import com.zs.erh.service.facade.ClientService;
import com.zs.erh.service.facade.EntrepriseService;
import com.zs.erh.service.util.StringUtil;
import com.zs.erh.service.vo.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImple implements ClientService {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private  EntrepriseService entrepriseService;

    public List<Client> findByEntrepriseCode(String code) {
        return clientDao.findByEntrepriseCode(code);
    }

    @Transactional
    public int deleteByEntrepriseCode(String code) {
        return clientDao.deleteByEntrepriseCode(code);
    }

    public Client save(Client client){
        if(findByCode(client.getCode())!=null) {
            return null;
        }else{
            Entreprise entreprise = entrepriseService.findByCode(client.getEntreprise().getCode());
            if(entreprise==null){
                return null;
            }else {
                client.setEntreprise(entreprise);
                clientDao.save(client);
                return client;
            }
        }
    }
    public List<Client> search(ClientVO clientVO){
        String query = "SELECT c FROM Client c where 1=1";
        if(StringUtil.isNotEmpty(clientVO.getCode())){
            query+=" AND c.code LIKE '%" + clientVO.getCode() + "%'";
        }if(StringUtil.isNotEmpty(clientVO.getLibelle())){
            query+= " AND c.libelle LIKE '%" + clientVO.getLibelle() + "%'";
        }if(StringUtil.isNotEmpty(clientVO.getDescription())){
            query+=" AND c.description LIKE '%" + clientVO.getDescription() + "%'";
        }
        return  entityManager.createQuery(query).getResultList();
    }


    public Client update(Client client){
        Client client1 = findByCode(client.getCode());
        Optional<Entreprise> entreprise = entrepriseService.findById(client.getEntreprise().getId());
        if(entreprise.isPresent()){
            client1.setEntreprise(client.getEntreprise());
            client1.setLibelle(client.getLibelle());
            client1.setDescription(client.getDescription());
            clientDao.save(client1);
            return client1;
        }else {
            return null;
        }
    }

    @Transactional
    public int deleteByCode(List<Client> clients) {
        int res=0;
        for (int i = 0; i < clients.size(); i++) {
            res+=deleteByCode(clients.get(i).getCode());
        }
        return res;
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
}