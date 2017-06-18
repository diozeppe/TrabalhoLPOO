/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Giuseppe
 */
public class Pedido {

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
    
    private int id;
    private int cpf;
    private String forma;
    private String material;
    private double tamanho;
    private double custo;

    public Pedido(int cpf, String forma, String material,double tamanho ,double custo) {
        this.cpf = cpf;
        this.forma = forma;
        this.material = material;
        this.tamanho = tamanho;
        this.custo = custo;
    }
    
    
    
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Pedido(int id) {
        this.id = id;
    }
    public Pedido(){
        
    }

    public void setCusto(double valor) {
        this.custo = valor;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public double getCusto() {
        return custo;
    }
    
}
