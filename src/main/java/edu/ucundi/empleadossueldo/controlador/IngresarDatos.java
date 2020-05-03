/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucundi.empelados.modelo;

import java.util.Date;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Eduard Fierro
 */
@Named(value = "ingresoDatos")
@RequestScoped
public class IngresarDatos {
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fechaN;
    private String nivel;
    private String [] idiomas;
    private int diasLaborados;
}
