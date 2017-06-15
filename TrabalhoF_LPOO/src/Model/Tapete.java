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
public class Tapete {
    private int id;
    private Forma forma;
    private Material material;

    public Tapete(Forma forma, Material material) {
        this.forma = forma;
        this.material = material;
    }
    
    public Tapete(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Forma getForma() {
        return forma;
    }

    public Material getMaterial() {
        return material;
    }
    
    public double getPreco(){
        return 0.0;
    }
    
}
