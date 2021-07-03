package com.zs.erh.service.vo;

import java.util.Date;

public class MessageVO {
    private Long id;
    private  String objet;
    private String corps;
    private Date dateEnvoi;
    private Long etatMessageId;
    private Date dateMax;
    private Date dateMin;

	public Date getDateMax() {
		return dateMax;
	}

	public void setDateMax(Date dateMax) {
		this.dateMax = dateMax;
	}

	public Date getDateMin() {
		return dateMin;
	}

	public void setDateMin(Date dateMin) {
		this.dateMin = dateMin;
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
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	public Long getEtatMessageId() {
		return etatMessageId;
	}
	public void setEtatMessageId(Long etatMessageId) {
		this.etatMessageId = etatMessageId;
	}
	
	
    
    

}
