/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dani0
 */
public class Movimiento {
    int idM;
    int item;
    int idC;
    int idE;
    int idP;
    String numSerie;
    String descr;
    String fecha;
    int cant;
    double subt;
    double monto;
    String estado;
    
    public Movimiento(){}
    
    public Movimiento(int idM, int item, int idC, int idE, int idP, String numSerie, String descr, String fecha, 
            int cant, double subt, double monto, String estado) {
        this.idM = idM;
        this.item = item;
        this.idC = idC;
        this.idE = idE;
        this.idP = idP;
        this.numSerie = numSerie;
        this.descr = descr;
        this.fecha = fecha;
        this.cant = cant;
        this.subt = subt;
        this.monto = monto;
        this.estado = estado;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getSubt() {
        return subt;
    }

    public void setSubt(double subt) {
        this.subt = subt;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
