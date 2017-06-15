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
public class Material {
    
    private int id;
    private double precoMetroQuadrado;
    private Modelo ModeloMaterial;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public Material(double precoMetroQuadrado, Modelo ModeloMaterial) {
        this.precoMetroQuadrado = precoMetroQuadrado;
        this.ModeloMaterial = ModeloMaterial;
    }
    
    public Material(int id) {
        this.id = id;
    }

    public void setPrecoMetroQuadrado(double precoMetroQuadrado) {
        this.precoMetroQuadrado = precoMetroQuadrado;
    }

    public void setModeloMaterial(Modelo ModeloMaterial) {
        this.ModeloMaterial = ModeloMaterial;
    }
    
    public double getPrecoMetroQuadrado() {
        return precoMetroQuadrado;
    }

    public Modelo getModeloMaterial() {
        return ModeloMaterial;
    }
    
}
