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

//Hereda de CuentaBancaria
public abstract class CuentaCorriente extends CuentaBancaria {
    String entidades;
    
    //Creamos el constructor
    public CuentaCorriente(String nombre, String apellidos, String dni, double saldo, String numeroCuenta, String entidades){
        //Utilizamos super para que llame al constructor vacío de la clase padre, aunque java lo llama automáticamente        
        super(nombre, apellidos, dni, saldo, numeroCuenta);
        this.entidades = entidades;
    }

    //Creamos get and set
    public String getEntidades() {
        return entidades;
    }

    public void setEntidades(String entidades) {
        this.entidades = entidades;
    }
    
     //Personalizamos nuestro devolverInfoString    
    @Override
    public String devolverInfoString() {
            String devolverInfoString = super.devolverInfoString() + ".\nLAS ENTIDADES AUTORIZADAS SON: " + entidades;
        return devolverInfoString;  
    }
    
    
    
}
