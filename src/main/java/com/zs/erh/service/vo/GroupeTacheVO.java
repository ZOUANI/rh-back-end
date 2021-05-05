package com.zs.erh.service.vo;

import com.zs.erh.bean.Client;

public class GroupeTacheVO {
    private Long clientId;
    private Long projetId;
    private Long lotId;
    private Client client;

    public Client getClient() {
        if (this.client == null){
            this.client = new Client();
        }
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProjetId() {
        return projetId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

}
