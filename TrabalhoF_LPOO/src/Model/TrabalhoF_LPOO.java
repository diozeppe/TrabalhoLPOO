/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.ClienteDAO;

/**
 *
 * @author Giuseppe
 */
public class TrabalhoF_LPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c = new Cliente("Jewzep", "Peperoni", 123456789);
        
        ClienteDAO cdao = new ClienteDAO();
        cdao.insereCliente(c);
    }
    
}
