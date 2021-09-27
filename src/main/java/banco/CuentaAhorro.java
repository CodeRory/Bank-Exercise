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
public class CuentaAhorro extends CuentaBancaria {
    float tipoDeInteres;
    
    public CuentaAhorro(String nombre, String apellidos, String dni, double saldo, String numeroCuenta, float tipoDeInteres) {
        //Creamos dentro un objeto de persona
        super(nombre, apellidos, dni, saldo, numeroCuenta);
        this.tipoDeInteres = tipoDeInteres;
    }
    
    //Personalizamos nuestro devolverInfoString    
    @Override
    public String devolverInfoString() {
            String devolverInfoString = super.devolverInfoString() +  ".\nEL TIPO DE INTERES ES "  + tipoDeInteres;
        return devolverInfoString;  
    }
}
