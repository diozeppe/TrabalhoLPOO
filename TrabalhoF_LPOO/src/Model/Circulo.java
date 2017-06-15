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
public class Circulo extends Forma{
    public double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }
    
    @Override
    public double area(){
        return 2 * this.getRaio() * 3.14;
    }
}
