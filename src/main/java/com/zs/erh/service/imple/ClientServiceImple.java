package com.zs.erh.service.imple;

import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.ClientDao;
import com.zs.erh.service.facade.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Transactional
    public int deleteByLibelle(String libelle) {
        return clientDao.deleteByLibelle(libelle);
    }

    @Autowired
    private ClientDao clientDao;
}
