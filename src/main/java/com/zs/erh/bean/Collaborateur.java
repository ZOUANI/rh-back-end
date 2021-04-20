/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author MoulaYounes
 */
@Entity
public class Collaborateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String code;
    private String login;
    private String password;
    private String phone;
    private String email;

    @ManyToOne
    private EntiteAdministrative entiteAdministrative;

    private int nbrCnx = 3;
    private boolean blocked;
    private boolean mustChangePassword = true;

    @ManyToOne
    private CategorieCollaborateur categorieCollaborateur;

    @ManyToOne
    private Projet projetDefault;
    @ManyToOne
    private Lot lotDefault;
    @ManyToOne
    private GroupeTache groupeTacheDefault;

    @ManyToOne
    private Equipe equipeDefault;

    public Projet getProjetDefault() {
        if (projetDefault == null) {
            projetDefault = new Projet();
        }
        return projetDefault;
    }

    public void setProjetDefault(Projet projetDefault) {
        this.projetDefault = projetDefault;
    }

    public Lot getLotDefault() {
        if (lotDefault == null) {
            lotDefault = new Lot();
        }
        return lotDefault;
    }

    public void setLotDefault(Lot lotDefault) {
        this.lotDefault = lotDefault;
    }

    public GroupeTache getGroupeTacheDefault() {
        if (groupeTacheDefault == null) {
            groupeTacheDefault = new GroupeTache();
        }
        return groupeTacheDefault;
    }

    public void setGroupeTacheDefault(GroupeTache groupeTacheDefault) {
        this.groupeTacheDefault = groupeTacheDefault;
    }

    public Equipe getEquipeDefault() {
        if (equipeDefault == null) {
            equipeDefault = new Equipe();
        }
        return equipeDefault;
    }

    public void setEquipeDefault(Equipe equipeDefault) {
        this.equipeDefault = equipeDefault;
    }

    public boolean isMustChangePassword() {
        return mustChangePassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMustChangePassword(boolean mustChangePassword) {
        this.mustChangePassword = mustChangePassword;
    }

    public int getNbrCnx() {
        return nbrCnx;
    }

    public void setNbrCnx(int nbrCnx) {
        this.nbrCnx = nbrCnx;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EntiteAdministrative getEntiteAdministrative() {
        return entiteAdministrative;
    }

    public void setEntiteAdministrative(EntiteAdministrative entiteAdministrative) {
        this.entiteAdministrative = entiteAdministrative;
    }

    public CategorieCollaborateur getCategorieCollaborateur() {
        return categorieCollaborateur;
    }

    public void setCategorieCollaborateur(CategorieCollaborateur categorieCollaborateur) {
        this.categorieCollaborateur = categorieCollaborateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Collaborateur)) {
            return false;
        }
        Collaborateur other = (Collaborateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code;
    }
}
