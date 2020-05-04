/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucundi.empleadossueldo.modelo;

import edu.ucundi.empleadossueldo.controlador.IngresarDatos;

/**
 *
 * @author Eduard Fierro, Arley Rivera
 */
public class CalcularSueldo {

    private int sueldo;
    //Variable que guarda los idiomas del usuario
    private String idiomas;
    //Variable que guarda el valor del pago por nivel educativo del usuario
    private int pagoNivel;
    //Variable tipo ingresarDatos 
    private IngresarDatos ingresodaDatos;

    public CalcularSueldo(IngresarDatos ingreso) {
        this.ingresodaDatos = ingreso;
        hallarPagoNivel();
        concatenarIdiomas();
        calculaSueldo();
    }

    /**
     * Metodo que establece el valor de las profesiones
     */
    public void hallarPagoNivel() {
        if (ingresodaDatos.getNivel().equals("Primaria")) {
            setPagoNivel(0);
        }
        if (ingresodaDatos.getNivel().equals("Secundaria")) {
            setPagoNivel(0);
        }
        if (ingresodaDatos.getNivel().equals("Tecnico")) {
            setPagoNivel(5000);
        }
        if (ingresodaDatos.getNivel().equals("Tecnologo")) {
            setPagoNivel(15000);
        }
        if (ingresodaDatos.getNivel().equals("Profesional")) {
            setPagoNivel(30000);
        }
        if (ingresodaDatos.getNivel().equals("Magister")) {
            setPagoNivel(40000);
        }
    }

    /**
     * Valida que los dias de trabajo sean mayores a 0
     *
     * @return
     */
    public boolean validarDiasTrabajados() {
        if (ingresodaDatos.getDiasLaborados() <= 0) {
            setSueldo(0);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Metodo que calcula el sueldo del usuario
     */
    public void calculaSueldo() {
        if (validarDiasTrabajados()) {
            int subSueldo = 0;
            subSueldo = getPagoNivel()+(30000 * ingresodaDatos.getDiasLaborados()) ;
            for (String s : ingresodaDatos.getIdiomas()) {
                if (s.equals("Español")) {
                    subSueldo = subSueldo + 0;
                }
                if (s.equals("Ingles")) {
                    subSueldo = subSueldo + 10000;
                }
                if (s.equals("Frances")) {
                    subSueldo = subSueldo + 10000;
                }
                if (s.equals("Aleman")) {
                    subSueldo = subSueldo + 10000;
                }
            }
            
            setSueldo(subSueldo);
        }
    }

    /**
     * Metodo que une todos los idiomas que el usuario sabe
     */
    public void concatenarIdiomas() {
        String subidioma = "";
        for (String s : ingresodaDatos.getIdiomas()) {
            subidioma = subidioma + s + ", ";
        }
        setIdiomas(subidioma);
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public int getPagoNivel() {
        return pagoNivel;
    }

    public void setPagoNivel(int pagoNivel) {
        this.pagoNivel = pagoNivel;
    }

}
