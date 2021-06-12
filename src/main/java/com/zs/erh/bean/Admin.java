/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author hzouani6
 */

@Entity
@DiscriminatorValue("admin")
public class Admin extends User implements Serializable {
    private String propritie;

    public String getPropritie() {
        return propritie;
    }

    public void setPropritie(String propritie) {
        this.propritie = propritie;
    }
}
