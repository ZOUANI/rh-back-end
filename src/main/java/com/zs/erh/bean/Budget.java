package com.zs.erh.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;
    private BigDecimal montant;
    private String messageDemmande;
    private String messageReponse;

    @Temporal(TemporalType.DATE)
    private Date dateDemmande;
    @Temporal(TemporalType.DATE)
    private Date dateReponse;

    @ManyToOne
    private EtatBudget etatBudget;

    @ManyToOne
    private Agence Agence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public EtatBudget getEtatBudget() {
        return etatBudget;
    }

    public void setEtatBudget(EtatBudget etatBudget) {
        this.etatBudget = etatBudget;
    }

    public Agence getAgence() {
        return Agence;
    }

    public void setAgence(Agence agence) {
        Agence = agence;
    }

    public Date getDateDemmande() {
        return dateDemmande;
    }

    public void setDateDemmande(Date dateDemmande) {
        this.dateDemmande = dateDemmande;
    }

    public Date getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(Date dateReponse) {
        this.dateReponse = dateReponse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Budget{" +
                "libelle='" + libelle + '\'' +
                ", code='" + code + '\'' +
                ", montant=" + montant +
                ", messageDemmande='" + messageDemmande + '\'' +
                ", messageReponse='" + messageReponse + '\'' +
                ", dateDemmande=" + dateDemmande +
                ", dateReponse=" + dateReponse +
                ", etatBudget=" + etatBudget +
                ", Agence=" + Agence +
                '}';
    }
}
