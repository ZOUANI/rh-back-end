package com.zs.erh.service.vo;

import java.util.Date;

public class ProjetVO {
    private String clientId;
    private String nroId;
    private String responsableProjetId;
    private String etatProjetId;
    private String libelleProjet;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getNroId() {
        return nroId;
    }

    public void setNroId(String nroId) {
        this.nroId = nroId;
    }

    public String getResponsableProjetId() {
        return responsableProjetId;
    }

    public void setResponsableProjetId(String responsableProjetId) {
        this.responsableProjetId = responsableProjetId;
    }

    public String getEtatProjetId() {
        return etatProjetId;
    }

    public void setEtatProjetId(String etatProjetId) {
        this.etatProjetId = etatProjetId;
    }

    public String getLibelleProjet() {
        return libelleProjet;
    }

    public void setLibelleProjet(String libelleProjet) {
        this.libelleProjet = libelleProjet;
    }
}
