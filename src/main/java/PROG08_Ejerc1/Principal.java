/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG08_Ejerc1;
import java.util.Scanner;
import banco.Banco;
import banco.Banco.*;
import validar.Validar;


/**
 *
 * @author Marino García Márquez
 */
public class Principal {
   //Establecemos la variable eleccion para elegir las distinas opciones del menú y la cuenta.
   static int eleccion = 0;
   static int eleccionCuenta;
   //Establecemos variables donde se almacenará la información de forma temporal
   static String nombreT;
   static String apellidosT;
   static String dniT;
   static double saldoT;
   static String numeroCuentaT;
   static float tipoDeInteresT;
   static String entidadesAutorizadasT;
   static float comisionMantenimientoT;
   static double maximoDescPerT;
   static float tipoDeInteresPorDescuT;
   static double comisionFijaT;
   static String ibanOpcion3;
   static String ibanOpcion4;
   static double ingresarOpcion;
   static String ibanOpcion5;
   static double retirarOpcion;
   static String ibanOpcion6;
   static String validadorIBAN;
   static String borrarIBAN;
   //Se crea un objeto de tipo miCuenta
   static Banco miCuenta = new Banco();
    public static void main (String[] args){
       
       /*Creamos un bucle do while para que se mantenga en el menú hasta que se elija salir.
       Lo primero que haremos será dar la bienvenida y luego mostrar las distintas opciones del menú. 
       */
       
       do {
           System.out.println("----------------------------\n");
           System.out.println("BIENVENIDO A NUESTRO BANCO\n");
           System.out.println("- INTRODUZCA EL SIGUIENTE NUMERO SEGUN SU PREFERENCIA. -\n"
             + "1 SI DESEA ABRIR UNA NUEVA CUENTA. \n"
             + "2 SI DESEA VER EL LISTADO DE CUENTAS DISPONIBLES. \n"
             + "3 SI DESEA OBETNER LOS DATOS DE UNA CUENTA CONCRETA. \n"
             + "4 SI DESEA REALIZAR INGRESO EN UNA CUENTA. \n"
             + "5 SI DESEA RETIRAR EFECTIVO DE UNA CUENTA. \n"
             + "6 SI DESEA CONSULTAR EL SALDO ACTUAL DE UNA CUENTA. \n"
             + "7 SI DESEA BORRAR UNA CUENTA\n"
             + "8 SI DESEA SALIR DE LA APLICACION. \n");            

            //Creamos un objeto Scanner para elegir la opción
            Scanner eleccionIntr = new Scanner(System.in);
            eleccion = eleccionIntr.nextInt();
            
            
            switch(eleccion){
                case 1: {
                    //Damos la bienvenida y empezamos a pedir datos por teclado para almacenarlos.
                    System.out.println("EMPECEMOS A CREAR UNA CUENTA\n");
                    System.out.println("¿QUÉ TIPO DE CUENTA DESEA CREAR? PULSE:\n"
                            + "1 SI QUIERE UNA CUENTA AHORRO\n"
                            + "2 SI QUIERE UNA CUENTA CORRIENTE PERSONAL\n"
                            + "3 SI QUIERE UNA CUENTA CORRIENTE DE EMPRESA\n");
                    //Creamos un Switch que nos dirija hacia un tipo de cuenta u otra.
                    Scanner eleccionCuentaIntr = new Scanner(System.in);
                    eleccionCuenta = eleccionCuentaIntr.nextInt();
                    
                    switch(eleccionCuenta){
                        case 1:{
                            System.out.println("HA ELEGIDO CREAR UNA CUENTA DE AHORRO:\n");
                            System.out.println("INTRODUZCA SU NOMBRE: \n");
                            //Creamos un objeto Scanner para elegir la opción
                            Scanner nombreIntr = new Scanner(System.in);
                            nombreT = nombreIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA SUS APELLIDOS \n");
                            Scanner apellidosIntr = new Scanner(System.in);
                            apellidosT = apellidosIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA SU DNI: \n");
                            Scanner dniIntr = new Scanner(System.in);
                            dniT = dniIntr.nextLine().toUpperCase();
                            System.out.println("INSERTE EL SALDO INICIAL:\n");
                            Scanner saldoIntr = new Scanner(System.in);
                            saldoT = saldoIntr.nextDouble();
                            
                            //Utilizamos el validador del IBAN                            
                            do {
                                try {
                                System.out.println("INSERTE EL NÚMERO DE CUENTA O IBAN QUE LE SERVIRÁ DE IDENTIFICACION: \n");
                                Scanner numeroCuentaIntr = new Scanner(System.in);
                                numeroCuentaT = numeroCuentaIntr.nextLine().toUpperCase();
                                Validar.validarIBAN(numeroCuentaT);
                                validadorIBAN = "correcto";
                                }catch (Exception e) {
                                    validadorIBAN = "incorrecto";
                                    System.out.println(e.getMessage());
                                }
                            }while (validadorIBAN == "incorrecto");   
                            System.out.println("INTRODUZCA EL TIPO DE INTERES DE REMUNERACION QUE DESEA TENER: \n");
                            Scanner tipoDeInteresIntr = new Scanner(System.in);
                            tipoDeInteresT = tipoDeInteresIntr.nextFloat();
                            //Insertamos todos los datos introducidos por teclado en el array de objetos. 
                            miCuenta.abrirCuenta(nombreT, apellidosT, dniT, saldoT, numeroCuentaT, tipoDeInteresT);
                            break;                            
                        }
                        case 2: {
                            System.out.println("HA ELEGIDO CREAR UNA CUENTA CORRIENTE PERSONAL\n");
                            System.out.println("INTRODUZCA SU NOMBRE: \n");
                            //Creamos un objeto Scanner para elegir la opción
                            Scanner nombreIntr = new Scanner(System.in);
                            nombreT = nombreIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA SUS APELLIDOS: \n");
                            Scanner apellidosIntr = new Scanner(System.in);
                            apellidosT = apellidosIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA SU DNI: \n");
                            Scanner dniIntr = new Scanner(System.in);
                            dniT = dniIntr.nextLine().toUpperCase();
                            System.out.println("INSERTE EL SALDO INICIAL:\n");
                            Scanner saldoIntr = new Scanner(System.in);
                            saldoT = saldoIntr.nextDouble();
                            System.out.println("INSERTE EL NUMERO DE CUENTA/IBAN CON EL QUE LA IDENTIFICARÁ: \n");
                            Scanner numeroCuentaIntr = new Scanner(System.in);
                            numeroCuentaT = numeroCuentaIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA LAS ENTIDADES AUTORIZADAS: \n");
                            Scanner entidadesAutIntr = new Scanner(System.in);
                            entidadesAutorizadasT = entidadesAutIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA LA COMISIÓN DE MANTENIMIENTO QUE DESEA:\n");
                            Scanner comisionMantIntr = new Scanner(System.in);
                            comisionMantenimientoT = comisionMantIntr.nextFloat();    
                            //Insertamos todos los datos introducidos por teclado en el array de objetos. 
                            miCuenta.abrirCuenta(nombreT, apellidosT, dniT, saldoT, numeroCuentaT, entidadesAutorizadasT, comisionMantenimientoT);
                            break;                            
                            
                        }
                        case 3: {
                            System.out.println("HA ELEGIDO CREAR UNA CUENTA CORRIENTE DE EMPRESA\n");
                             System.out.println("INTRODUZCA SU NOMBRE: \n");
                            //Creamos un objeto Scanner para elegir la opción
                            Scanner nombreIntr = new Scanner(System.in);
                            nombreT = nombreIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA SUS APELLIDOS: \n");
                            Scanner apellidosIntr = new Scanner(System.in);
                            apellidosT = apellidosIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA SU DNI: \n");
                            Scanner dniIntr = new Scanner(System.in);
                            dniT = dniIntr.nextLine().toUpperCase();
                            System.out.println("INSERTE EL SALDO INICIAL:\n");
                            Scanner saldoIntr = new Scanner(System.in);
                            saldoT = saldoIntr.nextDouble();
                            System.out.println("INSERTE EL NUMERO DE CUENTA/IBAN CON EL QUE LA IDENTIFICARÁ: \n");
                            Scanner numeroCuentaIntr = new Scanner(System.in);
                            numeroCuentaT = numeroCuentaIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA LAS ENTIDADES AUTORIZADAS: \n");
                            Scanner entidadesAutIntr = new Scanner(System.in);
                            entidadesAutorizadasT = entidadesAutIntr.nextLine().toUpperCase();
                            System.out.println("INTRODUZCA LA COMISIÓN DE MANTENIMIENTO QUE DESEA:\n");
                            Scanner comisionMantIntr = new Scanner(System.in);
                            comisionMantenimientoT = comisionMantIntr.nextFloat();   
                            System.out.println("INSERTE EL MÁXIMO DESCUBIERTO PERTIMIDO:\n");
                            Scanner descubiertoIntr = new Scanner(System.in);
                            maximoDescPerT = descubiertoIntr.nextFloat();
                            System.out.println("INTRODUZCA EL TIPO DE INTERÉS POR DESCUBIERTO: \n");
                            Scanner interesDescIntr = new Scanner(System.in);
                            tipoDeInteresPorDescuT = interesDescIntr.nextFloat();
                            System.out.println("INTRODUZCA LA COMISIÓN FIJA QUE DESEA: ");
                            Scanner comisionFijaIntr = new Scanner(System.in);
                            comisionFijaT = comisionFijaIntr.nextDouble();
                            //Insertamos todos los datos introducidos por teclado en el array de objetos. 
                            miCuenta.abrirCuenta(nombreT, apellidosT, dniT, saldoT, numeroCuentaT, entidadesAutorizadasT, comisionMantenimientoT,
                                    maximoDescPerT, tipoDeInteresPorDescuT, comisionFijaT);
                            break;                            
                        }
                    }
                    break;
                }
                case 2: {
                    //En esta opción imprimimos las cuentas disponibles
                    System.out.println("LAS CUENTAS DISPONIBLES SON: \n");
                    miCuenta.listadoCuentas(); 
                    break;
                    
                }
                case 3: {
                    //En este caso buscamos la cuenta por su IBAN
                    System.out.println("INTRODUZCA EL IBAN DE SU CUENTA: \n");
                    Scanner iban3Intr = new Scanner(System.in);
                    ibanOpcion3 = iban3Intr.nextLine().toUpperCase();
                    System.out.println(miCuenta.informacionCuenta(ibanOpcion3));
                    break;
                    
                }
                case 4: {
                    //En esta opción buscamos una cuenta para ingresarle dinero
                    System.out.println("¿EN QUÉ CUENTA DESEA INGRESAR?\n");
                    Scanner ibanIntr4 = new Scanner(System.in);
                    ibanOpcion4 = ibanIntr4.nextLine();
                    System.out.println("¿CUANTO DINERO DESEA INGRESAR?\n");
                    Scanner ingresarIntr = new Scanner(System.in);
                    ingresarOpcion = ingresarIntr.nextDouble();
                    System.out.println(miCuenta.ingresoCuenta(ibanOpcion4, ingresarOpcion));
                    break;
                    
                }
                case 5: {
                    //En este caso buscamos una cuenta para retirar dinero
                    System.out.println("¿EN QUÉ CUENTA DESEA RETIRAR?\n");
                    Scanner ibanIntr5 = new Scanner(System.in);
                    ibanOpcion5 = ibanIntr5.nextLine();
                    System.out.println("¿CUANTO DINERO DESEA RETIRAR? \n");
                    Scanner retirarIntr = new Scanner(System.in);
                    retirarOpcion = retirarIntr.nextDouble();
                    System.out.println(miCuenta.retiradaCuenta(ibanOpcion5, retirarOpcion));
                    break;
                }
                case 6: {
                    //Consultamos una cuenta
                    System.out.println("¿DE QUÉ CUENTA DESEA CONSULTAR EL SALDO?\n");
                    Scanner ibanIntr6 = new Scanner(System.in);
                    ibanOpcion6 = ibanIntr6.nextLine();
                    System.out.println("EL SALDO ACTUAL ES: \n");
                    System.out.println(miCuenta.obtenerSaldo(ibanOpcion6));
                    break; 
                }
                case 7:{
                    System.out.println("¿QUÉ CUENTA DESEA BORRAR? INTRODUZCA EL IBAN");
                    Scanner borrarCuentaIntr = new Scanner(System.in);
                    borrarIBAN = borrarCuentaIntr.nextLine();                   
                    if (miCuenta.borrarCuenta(borrarIBAN)) {
                        System.out.println("SE HA BORRADO CORRECTAMENTE.");                            
                    }else System.out.println("NO EXISTE LA CUENTA. ");
                        miCuenta.borrarCuenta(borrarIBAN);   
                    miCuenta.borrarCuenta(borrarIBAN);
                    break;                   
                }
                case 8: {
                    System.out.println("HASTA PRONTO!\n");
                }   break;
            }
       }while (eleccion != 8);
       
       
    }
}
