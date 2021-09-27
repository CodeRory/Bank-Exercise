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
public class CuentaCorrientePersonal extends CuentaCorriente {
    float comisionMantenimiento;
    
    public CuentaCorrientePersonal(String nombre, String apellidos, String dni, double saldo, String numeroCuenta, String entidades, float comisionMantenimiento){
        //Llamamos al constructor de la clase superior con super, darle sus parámetros y luego utilizaremos el de comisionMantenimiento
        super(nombre, apellidos, dni, saldo, numeroCuenta, entidades);
        this.comisionMantenimiento = comisionMantenimiento;        
        
    };
    
    //Personalizamos nuestro devolverInfoString    
    @Override
    public String devolverInfoString() {
            String devolverInfoString = super.devolverInfoString() +  ".\nLA COMISION DE MANTENIMIENTO ES "  + comisionMantenimiento;
        return devolverInfoString;  
    }
}
