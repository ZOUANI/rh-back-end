package com.zs.erh.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("chef-agence")
public class ChefAgence extends User implements Serializable {

    private String propritie;

    public String getPropritie() {
        return propritie;
    }

    public void setPropritie(String propritie) {
        this.propritie = propritie;
    }
}
