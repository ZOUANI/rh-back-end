/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.imple;

import com.zs.erh.service.util.DateUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author hicha
 */
public abstract class AbstractFacade<T> {


    public String addConstraint(String criteria, Object value) {
        if (value != null && !value.toString().isEmpty()) {
            return " AND " + criteria + "='" + value + "'";
        }
        return "";
    }

    public String addConstraint(String criteria, Object value, String op) {
        if (value != null) {
            if (op.equals("LIKE")) {
                return " AND " + criteria + " LIKE '%" + value + "%'";
            }
            return " AND " + criteria + " " + op + "'" + value + "'";
        }
        return "";

    }

    public String addConstraint(String beanAbrev, String atributeName, String operator, Object value) {
        boolean condition = value != null;
        if (value != null && value.getClass().getSimpleName().equals("String")) {
            condition = condition && !value.equals("");
        }
        if (condition && !atributeName.equals("")) {
            return " AND " + beanAbrev + "." + atributeName + " " + operator + " '" + value + "'";
        }
        return "";
    }

    public String initQuery() {
        return "SELECT item FROM " + getEntityClass().getSimpleName() + " item WHERE 1=1";
    }

    public String initDistinctQuery() {
        return "SELECT distinct item FROM " + getEntityClass().getSimpleName() + " item WHERE 1=1";
    }

    public List<T> findByCriteria(String name, String value) {
        return getEntityManager().createQuery("SELECT item FROM " + getEntityClass().getSimpleName() + " item WHERE item." + name + "='" + value + "'").getResultList();
    }

    public T findSingleByCriteria(String name, String value) {
        return extractSingle(findByCriteria(name, value));
    }

    public List<T> findByCriteria(String name, String value, String orderBy) {
        return getEntityManager().createQuery("SELECT item FROM " + getEntityClass().getSimpleName() + " item WHERE item." + name + "='" + value + "' " + orderBy).getResultList();
    }

    public List<T> findMultipleResult(String query) {
        return getEntityManager().createQuery(query).getResultList();
    }

    public T findSingleResult(String query) {
        List<T> list = findMultipleResult(query);
        return list == null || list.isEmpty() ? null : list.get(0);
    }

    public T extractSingle(List<T> list) {
        return list == null || list.isEmpty() ? null : list.get(0);
    }

    public int execUpdate(String query) {
        return getEntityManager().createQuery(query).executeUpdate();
    }

    public int deleteByCriteria(String name, String value) {
        return getEntityManager().createQuery("DELETE  FROM " + getEntityClass().getSimpleName() + " item WHERE item." + name + "='" + value + "'").executeUpdate();
    }

    public String addConstraintOr(String beanAbrev, String atributeName, String operator, Object value) {
        boolean condition = value != null;
        if (value != null && value.getClass().getSimpleName().equals("String")) {
            condition = condition && !value.equals("");
        }
        if (condition) {
            return " OR " + beanAbrev + "." + atributeName + " " + operator + " '" + value + "'";
        }
        return "";
    }

    public String addConstraintOr(String beanAbrev, String atributeName, String operator, List values) {
        String query = " AND ( 1=0 ";
        if (values != null && !values.isEmpty()) {
            for (Object value : values) {
                query += addConstraintOr(beanAbrev, atributeName, operator, value);
            }
            return query + ")";
        }
        return "";
    }

    public String addConstraintMinMax(String beanAbrev, String atributeName, Object valueMin, Object valueMax) {
        String requette = "";
        if (valueMin != null) {
            requette += " AND " + beanAbrev + "." + atributeName + " >= '" + valueMin + "'";
        }
        if (valueMax != null) {
            requette += " AND " + beanAbrev + "." + atributeName + " <= '" + valueMax + "'";
        }
        return requette;
    }

    public String addConstraintMinMaxStrict(String beanAbrev, String atributeName, Object valueMin, Object valueMax) {
        String requette = "";
        if (valueMin != null) {
            requette += " AND " + beanAbrev + "." + atributeName + " > '" + valueMin + "'";
        }
        if (valueMax != null) {
            requette += " AND " + beanAbrev + "." + atributeName + " < '" + valueMax + "'";
        }
        return requette;
    }

    public String addConstraintDate(String beanAbrev, String atributeName, String operator, Date value) {
        return addConstraint(beanAbrev, atributeName, operator, DateUtil.convertFormUtilToSql(value));
    }

    public String addConstraintDate(String atributeName, Date value) {
        return addConstraint("item", atributeName, "=", DateUtil.convertFormUtilToSql(value));
    }

    public String addConstraintMinMaxDate(String beanAbrev, String atributeName
            , Date valueMin, Date valueMax) {
        return addConstraintMinMax(beanAbrev, atributeName, DateUtil.convertFormUtilToSql(valueMin),
                DateUtil.convertFormUtilToSql(valueMax));
    }

    public String supprimerCleEtranger(String beanAbrev, String atributeName, String condition, Object value) {
        String requet = "";
        if (value != null) {
            requet = "UPDATE " + beanAbrev + " SET " + atributeName + " = NULL WHERE " + condition + " = " + value;
        }
        return requet;
    }

    // méthode pour ajouter une liste des contraintes dans une requete
    public String findByAllString(String abreviationBean, List<String> attributes, List<String> data) {
        String requete = "";
        if (!abreviationBean.equals("") && !attributes.isEmpty() && attributes.size() == data.size()) {
            for (int i = 0; i < attributes.size(); i++) {
                requete += addConstraint(abreviationBean, attributes.get(i), "=", data.get(i));
            }
        }
        return requete;
    }
    

    protected abstract EntityManager getEntityManager();

    public abstract Class<T> getEntityClass();
}
