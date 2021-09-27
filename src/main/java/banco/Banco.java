/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Objects;
import java.util.*;

/**
 *
 * @author Marino García Márquez
 */
public class Banco {
    //Va a tener una relación de composición
    //Creamos el array de cuentas bancarias  
    // private CuentaBancaria[] miCuenta = new CuentaBancaria[100];   
     
    //Creamos nuestro ArrayList
     ArrayList <CuentaBancaria> miCuenta = new ArrayList<CuentaBancaria>();
     
    //A continuación, creamos el contadorCuentas que cada vez que se cree una cuenta se incremente
    private int contadorCuentas = 0;
     
    //Creamos el constructor vacío, además del que autogenera Java
    public Banco(){}     
   
    
    /* Creamos un método para crear nuevas cuentas, que recibe por parámetro un objeto CuentaBancaria
    y lo almacena en la estructura. Devuelve true o false indicando si la operación se realizó con éxito.
    Vamos a utilizar la sobrecarga para crear un método para según que cuenta.
    */    
    public boolean abrirCuenta(CuentaBancaria nuevaCuenta){
        boolean exito;
        if (contadorCuentas >= 100 && Objects.isNull(nuevaCuenta)){
            exito = false;
            System.out.println("No se realizó con éxito la operación.");
            return exito;  
        }else {
             exito = true;
             miCuenta.add(nuevaCuenta);
             //this.miCuenta[this.contadorCuentas] = nuevaCuenta;
             System.out.println("Se realizó con éxito.");
             contadorCuentas++;                          
             return exito;
        }
    }
    
    //Método para cuenta ahorro    
    public boolean abrirCuenta(String nombre, String apellidos, String dni, double saldo, String numeroCuenta, float tipoDeInteres){
        CuentaBancaria cuentaAhorro = new CuentaAhorro(nombre, apellidos, dni, saldo, numeroCuenta, tipoDeInteres); 
        return this.abrirCuenta(cuentaAhorro);  
    }
    
   //Método para cuenta corriente empresa
    public boolean abrirCuenta(String nombre, String apellidos, String dni, double saldo, String numeroCuenta, String entidades, 
            float comisionMantenimiento, double maximoDescubiertoPermitido, float tipoDeInteresDescubierto, double comisionFija){
        CuentaBancaria cuentaCorrienteEmpresa = new CuentaCorrienteEmpresa(nombre, apellidos, dni, saldo, numeroCuenta, entidades, 
                comisionMantenimiento, maximoDescubiertoPermitido, tipoDeInteresDescubierto, comisionFija); 
        return this.abrirCuenta(cuentaCorrienteEmpresa);  
    }
    
    //Método para cuenta corriente personal
     public boolean abrirCuenta(String nombre, String apellidos, String dni, double saldo, String numeroCuenta, String entidades, 
             float comisionMantenimiento){
        CuentaBancaria cuentaCorrientePersonal = new CuentaCorrientePersonal(nombre, apellidos, dni, saldo, 
                numeroCuenta, entidades, comisionMantenimiento); 
        return this.abrirCuenta(cuentaCorrientePersonal);  
    }
    
    //Vamos a crear un método que busque cuentas
     public CuentaBancaria buscaCuenta(String numeroCuenta){
         for(int i=0; i<miCuenta.size(); i++){
             if (numeroCuenta.equals(miCuenta.get(i).getNumeroCuenta())){
                 return miCuenta.get(i);
             }             
         }
         return null;
     }
    
     /*Creamos listadoCuentas, que no recibe parámetro y devuelve un array donde
     cada elemento es una cadena que representa la información de una cuenta
     */
    public void listadoCuentas(){
        for (int i=0; i<miCuenta.size(); i++){
            System.out.println("-----------");
            System.out.println("EL NOMBRE ES " + miCuenta.get(i).getTitular().getNombre());
            System.out.println("LOS APELLIDOS SON " + miCuenta.get(i).getTitular().getApellidos());
            System.out.println("EL NUMERO DE CUENTA ES " + miCuenta.get(i).getNumeroCuenta());
            System.out.println("EL SALDO ES "+ miCuenta.get(i).getSaldo());
        }
    }

    /* Creamos informacionCuenta que recibe un IBAN por parámetro y devuelve una cadena
    con la información de la cuenta o  null si la cuenta no existe
    */
    public String informacionCuenta(String numeroCuenta){
        String error = "NO SE HA ENCONTRADO SU CUENTA.";
        
        for (int i=0; i<miCuenta.size(); i++){   
            if (numeroCuenta.equals(miCuenta.get(i).getNumeroCuenta())){
                return miCuenta.get(i).devolverInfoString();}
            }
        return error;
    }
    
    /*Creamos ingresoCuenta que recibe numeroCuenta(IBAN) por parámetro y 
    una cantidad, e ingresa cantidad a la cuenta. 
    
    */
    public boolean ingresoCuenta(String numeroCuenta, double ingresar){
        boolean exito = true;
        
        CuentaBancaria miCuenta = this.buscaCuenta(numeroCuenta);
        if (Objects.nonNull(miCuenta)){
            miCuenta.setSaldo(miCuenta.getSaldo() + ingresar);
            return exito;            
        }else {
            exito = false;
            return exito;
        }
    }
    
    /* Creamos un método que recibe un IBAN por parámetro y una cantidad
    y trata de retirar la cantidad de la cuenta
    */
    
    public boolean retiradaCuenta(String numeroCuenta, double ingresar){
        boolean exito = true;
        
        CuentaBancaria miCuenta = this.buscaCuenta(numeroCuenta);
        if (Objects.nonNull(miCuenta)){
            miCuenta.setSaldo(miCuenta.getSaldo() - ingresar);
            return exito;            
        }else {
            exito = false;
            return exito;
        }
    }
    
    public double obtenerSaldo(String numeroCuenta){
        
        for (int i=0; i<miCuenta.size(); i++){   
            if (numeroCuenta.equals(miCuenta.get(i).getNumeroCuenta())){
                return miCuenta.get(i).getSaldo();}
            }
        return -1;
        
    }
    
    //Creamos un método para borrar vehículos
    public boolean borrarCuenta(String numeroCuenta){
        boolean borradoCorrecto = false;
        for (int i=0; i<miCuenta.size(); i++){
            if (numeroCuenta.equals(miCuenta.get(i).getNumeroCuenta())){
                miCuenta.remove(buscaCuenta(numeroCuenta));
                borradoCorrecto = true;
            }else{
                borradoCorrecto = false;
            }            
        }return borradoCorrecto;
    }
    
    
    
    
    
    
    
    //Métodos get y set
    public ArrayList<CuentaBancaria> getMiCuenta() {
        return miCuenta;
    }

    public int getContadorCuentas() {
        return contadorCuentas;
    }

    public void setMiCuenta(ArrayList<CuentaBancaria> miCuenta) {
        this.miCuenta = miCuenta;
    }

    public void setContadorCuentas(int contadorCuentas) {
        this.contadorCuentas = contadorCuentas;
    }
        
    
}
