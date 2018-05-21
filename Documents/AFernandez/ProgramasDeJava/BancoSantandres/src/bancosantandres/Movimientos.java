/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosantandres;

/**
 *
 * @author jerez
 */
public class Movimientos {
    String tipo;
    double saldo_ant;
    double saldo_post;

    public Movimientos(String tipo, double saldo_ant) {
        this.tipo = tipo;
        this.saldo_ant = saldo_ant;
    }

    public void setSaldo_post(double saldo_post) {
        this.saldo_post = saldo_post;
    }
    
    
    
    @Override
    public String toString() {
        return "Tipo=" + tipo + ", saldo_ant=" + saldo_ant + ", saldo_post=" + saldo_post;
    }
     
}
