package com.zs.erh.service.vo;

import java.util.Date;

public class ProjetVO {
    private Long clientId;
    private Long agenceId;
    private Long responsableProjetId;
    private Long etatProjetId;
    private String libelleProjet;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getResponsableProjetId() {
        return responsableProjetId;
    }

    public void setResponsableProjetId(Long responsableProjetId) {
        this.responsableProjetId = responsableProjetId;
    }

    public Long getEtatProjetId() {
        return etatProjetId;
    }

    public void setEtatProjetId(Long etatProjetId) {
        this.etatProjetId = etatProjetId;
    }

    public String getLibelleProjet() {
        return libelleProjet;
    }

    public void setLibelleProjet(String libelleProjet) {
        this.libelleProjet = libelleProjet;
    }

    public Long getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Long agenceId) {
        this.agenceId = agenceId;
    }
}
