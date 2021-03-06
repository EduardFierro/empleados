/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucundi.empleadossueldo.controlador;

import edu.ucundi.empleadossueldo.modelo.CalcularSueldo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import javax.inject.Named;

/**
 *
 * @author Eduard Fierro, Arley Rivera
 */
@Named(value = "mostrarDatos")
@RequestScoped 
public class MostrarDatos implements Serializable {

    private double sueldo;
    //Variable que guarda los idiomas del usuario
    private String idiomasConcatenados;
    //La inyeccion de los datos que ingreso el usuario
    @Inject
    private IngresarDatos ingresoDatos;

    /**
     * Metodo que calcula el sueldo y que se ejecuta despues del constructor
     */
    @PostConstruct
    public void calculaSueldo() {
        CalcularSueldo calcula = new CalcularSueldo(ingresoDatos);
        setSueldo(calcula.getSueldo());
        setIdiomasConcatenados(calcula.getIdiomas());
    }
    
    public double getSueldo() {
        return sueldo;
    }
    /**
     * 
     * @param sueldo 
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getIdiomasConcatenados() {
        return idiomasConcatenados;
    }
    /**
     * 
     * @param idiomasConcatenados 
     */
    public void setIdiomasConcatenados(String idiomasConcatenados) {
        this.idiomasConcatenados = idiomasConcatenados;
    }

    public IngresarDatos getIngresoDatos() {
        return ingresoDatos;
    }
    /**
     * 
     * @param ingresoDatos 
     */
    public void setIngresoDatos(IngresarDatos ingresoDatos) {
        this.ingresoDatos = ingresoDatos;
    }

}
