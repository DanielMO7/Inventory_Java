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
public class ProductosM {
    private int idPro;
    private String dni;
    private String nombres;
    private double prec;
    private int stock;
    private String estado;

    public ProductosM(){}

    public ProductosM(int idPro, String dni, String nombres, double prec, int stock, String estado) 
    {
        this.idPro = idPro;
        this.dni = dni;
        this.nombres = nombres;
        this.prec = prec;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getPrec() {
        return prec;
    }

    public void setPrec(double prec) {
        this.prec = prec;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}    