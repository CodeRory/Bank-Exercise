/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Marino García Márquez
 * 
 */

//Hereda de CuentaCorriente
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    double maximoDescubiertoPermitido;
    float tipoDeInteresPorDescubierto;
    double comisionFija;
    
    
    public CuentaCorrienteEmpresa(String nombre, String apellidos, String dni, double saldo, String numeroCuenta, String entidades, float comisionMantenimiento,
            double maximoDescubiertoPermitido, float tipoDeInteresPorDescubierto, double comisionFija){
        //Llamamos al constructor de la clase superior con super, darle sus parámetros y luego utilizaremos el de comisionMantenimiento
        super(nombre, apellidos, dni, saldo, numeroCuenta, entidades);
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;   
        this.tipoDeInteresPorDescubierto = tipoDeInteresPorDescubierto;
        this.comisionFija = comisionFija;
        
    };
    
    @Override
    public String devolverInfoString() {
            String devolverInfoString = super.devolverInfoString() + ".\nEL MAXIMO DESCUBIERTO PERMITIDO ES " + maximoDescubiertoPermitido +
                    "\n.EL TIPO DE INTERES POR DESCUBIERTO ES DE " + tipoDeInteresPorDescubierto + 
                        "\n.LA COMISION FIJA ES DE " + comisionFija ;
        return devolverInfoString;  
    }
}
