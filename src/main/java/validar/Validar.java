/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Marino García Márquez
 * 
 */

//Esta clase la usaremos para validar el IBAN
public class Validar {
    public static void validarIBAN(String numeroCuenta) throws Exception {
        Pattern patternDni = Pattern.compile("ES[0-9]{20}");
        Matcher matcherDni = patternDni.matcher(numeroCuenta);
        if (matcherDni.matches()) {
            System.out.println("EL FORMATO DE IBAN ES CORRECTO");
        } else {
            throw new Exception("EL FORMATO DE IBAN NO ES CORRECTO");
        }
    }
    
}
