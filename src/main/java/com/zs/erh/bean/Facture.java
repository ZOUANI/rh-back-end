package com.zs.erh.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Facture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String libelle;
    private String description;
    private BigDecimal totalHeursCalcules;
    private BigDecimal totalHeursFactures;
    private BigDecimal montantCalcule;
    private BigDecimal montantFacture;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFacture;

    @ManyToOne
    private Client client;
    @ManyToOne
    private EtatFacture etatFacture;
    @ManyToOne
    private Agence agence;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalHeursCalcules() {
        return totalHeursCalcules;
    }

    public void setTotalHeursCalcules(BigDecimal totalHeursCalcules) {
        this.totalHeursCalcules = totalHeursCalcules;
    }

    public BigDecimal getTotalHeursFactures() {
        return totalHeursFactures;
    }

    public void setTotalHeursFactures(BigDecimal totalHeursFactures) {
        this.totalHeursFactures = totalHeursFactures;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public BigDecimal getMontantCalcule() {
        return montantCalcule;
    }

    public void setMontantCalcule(BigDecimal montantCalcule) {
        this.montantCalcule = montantCalcule;
    }

    public BigDecimal getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(BigDecimal montantFacture) {
        this.montantFacture = montantFacture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EtatFacture getEtatFacture() {
        return etatFacture;
    }

    public void setEtatFacture(EtatFacture etatFacture) {
        this.etatFacture = etatFacture;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
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
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
