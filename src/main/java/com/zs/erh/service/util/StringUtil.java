/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.service.util;

/**
 *
 * @author MoulaYounes
 */
public class StringUtil {
    
    public static boolean isEmpty(String value){
         return value==null || value.isEmpty();
     }

    public static boolean isNotEmpty(String value){
        return !isEmpty(value);
    }

    public static String selfOrEmpty(String value,String defaultValue) {
        return (isEmpty(value)?defaultValue:value);
    }
    public static String selfOrEmpty(String value) {
        return selfOrEmpty(value, "");
    }
}
