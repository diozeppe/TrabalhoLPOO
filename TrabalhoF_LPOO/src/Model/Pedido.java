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
    
    private int id;
    private List<Tapete> tapetes;
    private double valor;

    public Pedido(int id) {
        this.id = id;
    }

    public void setTapetes(List<Tapete> tapetes) {
        this.tapetes = tapetes;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Tapete> getTapetes() {
        return tapetes;
    }
    
    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }
    
}
