/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Marino García Márquez
 */

//Creamos la clase cuenta bancaria que será una super clase de CuentaAhorro y CuentaCorriente
public abstract class CuentaBancaria implements Imprimible{
    //Creamos las variables que se pediran en las cuentas
    protected Persona titular;
    protected double saldo;
    protected String numeroCuenta;
    
    //Creamos el constructor CuentaBancaria. Pasamos por parámetros también los del objeto persona    
    public CuentaBancaria(String nombre, String apellidos, String dni, double saldo, String numeroCuenta) {
        //Creamos dentro un objeto de persona
        this.titular = new Persona(nombre, apellidos, dni);
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }
    
    //Creamos un constructor vacío, tenemos que tenerlo para que pueda heredar
    //public CuentaBancaria(){};
    
    //Devolvemos una nueva copia del objeto persona, que no es la misma de la clase Persona.java
    public Persona getTitular(){        
        return new Persona(this.titular.getNombre(), this.titular.getApellidos(), this.titular.getDni());        
    }
    
    //Creamos los get and set
     public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    @Override
    public String devolverInfoString() {
            String devolverInfoString = "EL IBAN ES " + getNumeroCuenta() + ".\nEL NOMBRE DEL TITULAR ES " +
            getTitular().getNombre() + " CON APELLIDOS "+ getTitular().getApellidos() + ".\nCON DNI " + getTitular().getDni() +
            ". \nEL SALDO DISPONIBLE ES " + getSaldo() ;
        return devolverInfoString;  
    }
    
}
