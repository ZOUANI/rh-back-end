package com.zs.erh.service.vo;
import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.EtatEquipe;

public class EquipeVO {
    private String libelle;
    private Collaborateur responsable;
    private Long responsableId;
    private EtatEquipe etatEquipe;
    private Long etatId;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collaborateur getResponsable() {
        if(this.responsable==null){
            this.responsable=new Collaborateur();
        }
        return responsable;
    }

    public void setResponsable(Collaborateur responsable) {
        this.responsable = responsable;
    }

    public Long getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Long responsableId) {
        this.responsableId = responsableId;
    }

    public EtatEquipe getEtatEquipe() {
        if(this.etatEquipe==null){
            this.etatEquipe=new EtatEquipe();
        }
        return etatEquipe;
    }

    public void setEtatEquipe(EtatEquipe etatEquipe) {
        this.etatEquipe = etatEquipe;
    }

    public Long getEtatId() {
        return etatId;
    }

    public void setEtatId(Long etatId) {
        this.etatId = etatId;
    }
}
