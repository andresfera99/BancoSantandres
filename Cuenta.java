/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosantandres;

import java.util.ArrayList;

/**
 *
 * @author DAM 6J
 */
public class Cuenta { 
    private Titular titular; 
    private String numCuenta; 
    private double saldo;
    ArrayList<Movimientos> mov=new ArrayList();
    
    public Cuenta(Titular titular, String numCuenta){ 
        this.titular=titular; 
        this.numCuenta=numCuenta; 
        this.saldo=0; 
    } 
    
    public Titular getTitular(){ 
        return this.titular; 
    } 
    public String getNumCuenta(){ 
        return this.numCuenta; 
    } 
    public double getSaldo(){ 
        return this.saldo; 
    } 
    public void setSaldo(double saldo){ 
        this.saldo=saldo; 
    }
    public void verMovimientos(){
        for (Movimientos i : mov){
            System.out.println(i.toString());
        }
    }
    
    public void ingresar(double ingreso){
        Movimientos movimiento= new Movimientos("Ingreso",this.saldo);
        this.saldo+=ingreso;
        movimiento.setSaldo_post(this.saldo);
        mov.add(movimiento);
    } 
    
    public void reintegro(double salida){ 
        Movimientos movimiento= new Movimientos("Reintegro",this.saldo);
        this.saldo-=salida;
        movimiento.setSaldo_post(this.saldo);
        mov.add(movimiento);
    }
    
    public void transferir(Cuenta a, Cuenta b, int cant){
        Movimientos movimiento= new Movimientos("Transferencia",this.saldo);
        a.saldo-=cant;
        b.saldo+=cant;
        mov.add(movimiento);
    }
    
    @Override
    public String toString(){ 
        return "Titular:"+ this.titular.toString()+ "\nNumero de cuenta: "+this.numCuenta + "\nSaldo: "+ this.saldo; 
    } 
    
    public boolean cuentasIguales(Cuenta cuenta){ 
        boolean iguales=false; 
        if(this.numCuenta.equals(cuenta.getNumCuenta())){ 
            iguales=true; 
        } 
        return iguales; 
    } 
     
} 
