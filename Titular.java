/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosantandres;

/**
 *
 * @author DAM 6J
 */
  
public class Titular { 
    private String nombre; 
    private String apellidos; 
    private int edad; 
     
    public Titular(String nombre, String apellidos, int edad){ 
        this.nombre=nombre; 
        this.apellidos=apellidos; 
        this.edad=edad; 
    } 
     
    public String getNombre(){ 
        return this.nombre; 
    } 
    
    public String getApellidos(){ 
        return this.apellidos; 
    } 
    
    public int getEdad(){ 
        return this.edad; 
    } 
    
    @Override
    public String toString(){ 
        return "Nombre: "+this.nombre + "\nApellidos: "+this.apellidos + "\nEdad: "+ this.edad; 
    } 
} 
