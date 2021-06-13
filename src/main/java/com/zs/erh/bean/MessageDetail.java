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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "messageDetail")
     private List<Collaborateur> distinataires;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateLecture;
    @ManyToOne
    private Message message;
    @ManyToOne
    private EtatMessage etatMessage;



    public List<Collaborateur> getDistinataires() {
        return distinataires;
    }

    public void setDistinataires(List<Collaborateur> distinataires) {
        this.distinataires = distinataires;
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
}
