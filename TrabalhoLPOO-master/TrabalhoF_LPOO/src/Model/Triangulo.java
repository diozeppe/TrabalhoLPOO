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
public class Triangulo extends Forma{
    private double base;
    private double altura;
    private String nomeForma;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        
    }

    public String getNomeForma() {
        return nomeForma;
    }

    public void setNomeForma(String nomeForma) {
        this.nomeForma = nomeForma;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
    
    @Override
    public double area(){
        return (this.getBase() * this.getAltura()) / 2;
    }
    
}
