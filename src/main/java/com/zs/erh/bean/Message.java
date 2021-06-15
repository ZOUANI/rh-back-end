package com.zs.erh.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String objet;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEnvoi;
    @ManyToOne
    private  User source;
    @ManyToOne
    private EtatMessage etatMessage;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "message")
    private List<MessageDetail> messageDetails;
    private String corps;

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public List<MessageDetail> getMessageDetails() {
        return messageDetails;
    }

    public void setMessageDetails(List<MessageDetail> messageDetails) {
        this.messageDetails = messageDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public User getSource() {
        return source;
    }

    public void setSource(User source) {
        this.source = source;
    }

    public EtatMessage getEtatMessage() {
        return etatMessage;
    }

    public void setEtatMessage(EtatMessage etatMessage) {
        this.etatMessage = etatMessage;
    }
}

