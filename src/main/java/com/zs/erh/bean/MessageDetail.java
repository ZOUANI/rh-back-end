package com.zs.erh.bean;

import com.zs.erh.bean.EtatMessage;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MessageDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User destinataire;
    @Temporal(TemporalType.DATE)
    private Date dateLecture;
    @ManyToOne
    private Message message;
    @ManyToOne
    private EtatMessage etatMessage;

    @Transient
    private String loginDestinataire;

    public User getDistinataire() {
        return destinataire;
    }

    public void setDistinataire(User distinataire) {
        this.destinataire = distinataire;
    }


    public String getLoginDestinataire() {
		return loginDestinataire;
	}

	public void setLoginDestinataire(String loginDestinataire) {
		this.loginDestinataire = loginDestinataire;
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
