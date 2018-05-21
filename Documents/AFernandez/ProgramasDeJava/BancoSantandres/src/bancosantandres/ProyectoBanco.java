/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancosantandres;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *}

 * @author DAM 6J
 */

public class ProyectoBanco {
    static Scanner tec = new Scanner (System.in);
    static TreeSet<Cuenta> t = new TreeSet();
    static FileWriter fw;
    static BufferedWriter bw;

    public static void main(String[] args) {
        cargarTreeSet();
        
//        System.out.println("1.- Crear Cliente");
//        System.out.println("2.- Usar cliente existente");
//        int opc = 0;
//        switch(opc){
//            case 1:
//        }
//        
//        
//        
//        System.out.println("1.- Crear cuenta");
//        System.out.println("2.- Usar cuenta existente");
//        int opcion = 0;
//        switch(opcion){
//            case 1:
//                
//        }
        
        
        
        
        
        
        
        System.out.print("Introduce nombre de Titular: ");
        String nombre = tec.nextLine();
        System.out.print("Introduce apellido: ");
        String apellido = tec.nextLine();
        System.out.print("Introduce edad de Titular: ");
        int edad = tec.nextInt();
        tec.nextLine();
        System.out.print("Introduce numero de cuenta: ");
        String ncuenta = tec.nextLine();
        Titular titular = new Titular(nombre, apellido, edad);
        Cuenta c = new Cuenta(titular,ncuenta);
        int op = 0;
        
        while(op!=6) {
            System.out.println("1.-Ingresar");
            System.out.println("2.-Retirar");
            System.out.println("3.-Transferencia");
            System.out.println("4.-Ver saldo");
            System.out.println("5.-Ver movimientos");
            System.out.println("6.-Salir");
            
            
            op = tec.nextInt();
            switch(op){
                case 1:
                    Ingreso(c);
                    break;
                case 2:
                    Reintegro(c);
                    break;   
                case 3:
                    Transferencia(c);
                    break;
                case 4:
                    System.out.println(c.getSaldo());
                    break;
                case 5:
                    c.verMovimientos();
                    break;
            }
        }
    }
    
    public static void Ingreso(Cuenta c){
        System.out.print("Introduce cantidad a ingresar: ");
        double cant = tec.nextDouble();
        c.ingresar(cant);
        System.out.println("Operación exitosa");
    }
    public static void Reintegro(Cuenta c){
        System.out.print("Introduce cantidad a retirar: ");
        double cant = tec.nextDouble();
        
        if(cant >c.getSaldo()){
            System.out.println("La cuenta no dispone de suficiente dinero");
        }else{
            c.reintegro(cant);
            System.out.println("Operación exitosa");
        }
    }
    
    public static void Transferencia(Cuenta c){
        tec.nextLine();
        try {
            System.out.print("Introduce el numero de cuenta destino:");
            String ndest = tec.nextLine();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.print("Introduce cantidad a transferir: ");
        int cant = tec.nextInt();
        
        if (cant>c.getSaldo()) {
            System.out.println("No dispones de suficiente saldo");
        }else{
            //transferir(c, a, cant);
        }
        
                
        
        
    }
    
    public static void crearFichero(TreeSet<Cuenta> t){
        File f = new File("Cuentas.txt");
        for (Cuenta p : t){
        try {
            if (f.exists()){
                MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream("Cuentas.txt", true));
                oos.writeObject(p);
                System.out.println("Guardado.");
                System.out.println(p);
                oos.close();
            }else{
                ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream("Cuentas.txt", true));
                oos.writeObject(p);
                System.out.println("Guardado.");
                oos.close();
            }           
        } catch (IOException e) {
            System.out.println("Error");
        }
        }
    }
    
    public static void cargarTreeSet(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Cuentas.txt"));
            Object aux = ois.readObject();
            while(aux!= null){
                if(aux instanceof Cuenta){
                    t.add((Cuenta) aux);
                }
            }
        } catch (Exception e) {
        }
    }
}