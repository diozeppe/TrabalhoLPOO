/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Giuseppe
 */
public class Retangulo extends Forma{
    private double ladoA;
    private double ladoB;
    private String nomeForma;
    

    public Retangulo(double ladoA, double ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        
    }

    public String getNomeForma() {
        return nomeForma;
    }

    public void setNomeForma(String nomeForma) {
        this.nomeForma = nomeForma;
    }

    public double getLadoA() {
        return ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }
    
    @Override
    public double area(){
        return this.getLadoA() * this.getLadoB();
    }
    
}
