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

    private String libelle;
    private String code;
    private String description;
    private BigDecimal TotalHeursCalcules;
    private BigDecimal TotalHeursFactures;
    private double montantCalcule;
    private double montantFacture;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateFacture;

    @ManyToOne
    private Client client;
    @ManyToOne
    private EtatFacture etatFacture;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateFacture() {
        return DateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        DateFacture = dateFacture;
    }

    public BigDecimal getTotalHeursCalcules() {
        return TotalHeursCalcules;
    }

    public void setTotalHeursCalcules(BigDecimal totalHeursCalcules) {
        TotalHeursCalcules = totalHeursCalcules;
    }

    public BigDecimal getTotalHeursFactures() {
        return TotalHeursFactures;
    }

    public void setTotalHeursFactures(BigDecimal totalHeursFactures) {
        TotalHeursFactures = totalHeursFactures;
    }

    public double getMontantCalcule() {
        return montantCalcule;
    }

    public void setMontantCalcule(double montantCalcule) {
        this.montantCalcule = montantCalcule;
    }

    public double getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(double montantFacture) {
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
