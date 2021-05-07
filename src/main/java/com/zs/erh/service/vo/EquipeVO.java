package com.zs.erh.service.vo;
import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.EtatEquipe;

public class EquipeVO {
    private String libelle;
    private Collaborateur responsable;
    private String nomResponsable;
    private String PrenomResponsable;
    private EtatEquipe etatEquipe;
    private String libelleEtat;

    public String getLibelleEtat() {
        return libelleEtat;
    }

    public void setLibelleEtat(String libelleEtat) {
        this.libelleEtat = libelleEtat;
    }

    public EtatEquipe getEtatEquipe() {
        if(this.etatEquipe==null){
            this.etatEquipe = new EtatEquipe();
        }
        return etatEquipe;
    }

    public void setEtatEquipe(EtatEquipe etatEquipe) {
        this.etatEquipe = etatEquipe;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public String getPrenomResponsable() {
        return PrenomResponsable;
    }

    public void setPrenomResponsable(String prenomResponsable) {
        PrenomResponsable = prenomResponsable;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collaborateur getResponsable() {
        if (this.responsable == null){
            this.responsable = new Collaborateur();
        }
        return responsable;
    }

    public void setResponsable(Collaborateur responsable) {
        this.responsable = responsable;
    }
}
