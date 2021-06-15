package com.zs.erh.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
public class MessageDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User destinataire;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateLecture;
    @ManyToOne
    private Message message;
    @ManyToOne
    private EtatMessage etatMessage;


    public User getDistinataire() {
        return destinataire;
    }

    public void setDistinataire(User distinataire) {
        this.destinataire = distinataire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(Date dateLecture) {
        this.dateLecture = dateLecture;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public EtatMessage getEtatMessage() {
        return etatMessage;
    }

    public void setEtatMessage(EtatMessage etatMessage) {
        this.etatMessage = etatMessage;
    }

    @Override
    public String toString() {
        return "MessageDetail{" +
                "id=" + id +
                ", destinataire=" + destinataire +
                ", dateLecture=" + dateLecture +
                ", message=" + message +
                ", etatMessage=" + etatMessage +
                '}';
    }
}
