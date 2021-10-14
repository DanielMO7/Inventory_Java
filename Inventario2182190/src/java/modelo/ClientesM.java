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
public class ClientesM {
    
    private int idCli;
    private String dni;
    private String nomb;
    private String dir;
    private String tel;
    private String estado;
    
    
    public ClientesM(){}

    public ClientesM(int idCli, String dni, String nomb, String dir, String tel, String estado) {
        this.idCli = idCli;
        this.dni = dni;
        this.nomb = nomb;
        this.dir = dir;
        this.tel = tel;
        this.estado = estado;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
