/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Kevin Emiro Ospinal
 */
@XmlRootElement(name = "Datos")
@XmlType(propOrder = {"compania","promedio"})
public class Promedio {

    public Promedio(){ 
    }
    
    private String compañia;
    private String promedio;

    public Promedio(Double promedio) {
        this.compañia = "Federico S.A";
        this.promedio = promedio.toString();
    }

    @XmlElement
    public String getCompañia() {
        return compañia;
    }


    @XmlElement
    public String getPromedio() {
        return promedio;
    }


    
}
