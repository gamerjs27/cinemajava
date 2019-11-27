/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superparcialcinema;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.*;
import javax.imageio.ImageIO;

/**
 *
 * @author los hernandez
 */
class mn {

    final private String brr = File.separator, ficheroimg = (System.getProperty("user.dir")) + brr + "src" + brr + "superparcialcinema" + brr + "questionimage.jpg";//src\superparcialcinema\questionimage.jpg

    salas sl = new salas();
    int largo, sala, puesto;
    tarjetas tj = new tarjetas();
    //bs bs=new bs();//base de dat(os para las salas
    //bs2 bs2=new bs2();//base de datos tarjetas
    boolean i = false;
    static int cdltemp, sldtemp;
    ImageIcon icon, img;

    public mn() {
        img = new ImageIcon((ficheroimg));
        icon = new ImageIcon(img.getImage().getScaledInstance(img.getIconWidth() * 1 / 5, img.getIconHeight() * 1 / 5, 2));
    }

    void menucinemark() throws IOException {
        System.err.println(System.getProperty("user.dir"));
        System.err.println("el menu" + " inicio correctamente");
        String[] op = {"Seleccioneuna de las opciones(salir)", "Crear una nueva tarjeta", "2. Recargar una tarjeta", "3. Crear una reserva", "4. Eliminar la reserva actual",
            "5. Pagar una reserva en efectivo", "6. Pagar la reserva con tarjeta CINEMAS", "7. Visualizar disponibilidad", "8. Visualizar el dinero en caja", "9. Generar reportes*"};
        int salir = JOptionPane.NO_OPTION;
        while (salir == JOptionPane.NO_OPTION) {
            Object opcion2 = JOptionPane.showInputDialog(null, "menu", "Elige", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
            if (opcion2 == "Seleccioneuna de las opciones(salir)") {
                salir = JOptionPane.YES_OPTION;
                JOptionPane.showMessageDialog(null, "gracias por usar nuestro software");
            } else if (opcion2 == "Crear una nueva tarjeta") {
                //opcion=1;
                crear_una_nueva_tarjeta();
            } else if (opcion2 == "2. Recargar una tarjeta") {
                //opcion=2;
                Recargar_una_tarjeta();
            } else if (opcion2 == "3. Crear una reserva") {
                //opcion=3;
                Crear_una_reserva();
            } else if (opcion2 == "4. Eliminar la reserva actual") {
                //opcion=4;
                Eliminar_la_reserva_actual();
            } else if (opcion2 == "5. Pagar una reserva en efectivo") {
                //opcion=5;
                Pagar_una_reserva_en_efectivo();
            } else if (opcion2 == "6. Pagar la reserva con tarjeta CINEMAS") {
                //opcion=5;
                Pagar_la_reserva_con_tarjeta_CINEMAS();
            } else if (opcion2 == "7. Visualizar disponibilidad") {
                //opcion=5;
                Visualizar_disponibilidad();
            } else if (opcion2 == "8. Visualizar el dinero en caja") {
                //opcion=5;
                Visualizar_el_dinero_en_caja();
            } else if (opcion2 == "9. Generar reportes*") {
                //opcion=5;
                Generar_reportes();
            } else {
                //opcion=777;
            }
        }

    }

    private void crear_una_nueva_tarjeta() throws IOException {
        System.err.println("crear_una_nueva_tarjeta" + " inicio correctamente");
        System.err.println(icon);
        //pedir la cedula y solicitar el pago de la recarga inicial 70k
        //hacer un ciclo para que solo reciba cedulas validas
        //tambien hay que pregunatar si algue
        cdltemp = Integer.parseInt(JOptionPane.showInputDialog(null, "si dease obtener su tarjeta cinemark por\n" + "favor ingrese su cedula y  recuerda que \n" + "obtines 70000 pesos de saldo ", "01"));
        if (tj.bs2_vericarnuevacdl(cdltemp)) {
            i = true;
            System.err.println("lo encontro menu");
        } else {
            System.err.println("no encontro menu");
            i = false;
        }
        if (10 >= Integer.toString(cdltemp).length() && cdltemp != 0 && !i) {
            JOptionPane.showMessageDialog(null, "cedula valida", "cinemark", JOptionPane.ERROR_MESSAGE, icon);
            tj.creartarjetacinemark(cdltemp);
        } else {
            JOptionPane.showMessageDialog(null, "no se pudo crear intenta otravez", "error 23", JOptionPane.ERROR_MESSAGE, icon);
        }
        //si todo eso salio bien se creo todo uwuw

        //totalmente finalizado
    }

    private void Recargar_una_tarjeta() throws IOException {
        System.err.println("Recargar_una_tarjeta" + " inicio correctamente");
        //pedir la cedula 
        Icon icono = null;
        try {
            icono = new ImageIcon(getClass().getResource(ficheroimg));
        } catch (Exception e) {
            System.err.println(e + "no encontro la imagen");
        }
        cdltemp = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cedula"));
        //pedir saldo sldtemp esto va casi directo pala base de datos
        if (tj.bs2_vericarnuevacdl(cdltemp)) {
            JOptionPane.showConfirmDialog(null, "desea recargar los 50k \n es la unica recarga posible", "recarga cinemark", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono);
            tj.Recargar_una_tarjeta(cdltemp);
        } else {
            JOptionPane.showMessageDialog(null, "hubo un error no se encontro la tarjeta", "error cedula", JOptionPane.ERROR_MESSAGE, icono);
        }
        //preguntar si desea recargar lo 50k de la recarga
    }

    private void Crear_una_reserva() throws IOException {
        System.err.println("Crear_una_reserva" + " inicio correctamente");//terminado
        //pedir cedula
        //preguntarle por que pelicula desea ver y el puesto
        //ver si esta disponible
        //cambiar el estado del puesto a reservada
        //mostrar si si se pudo
        //hay hacer dos programas para la reservaa
        cdltemp = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cedula"));
        if (tj.nuevareservatjv(cdltemp)) {
            tj.nuevareservatj(cdltemp);
            graficar();
            pedirdatosala();
            if (sl.verificarnuevareserva(sala, puesto, largo)) {
                sl.nuevasreservas(sala, puesto, largo);
            } else {
                System.err.println("no se pudo hacer la reserva");
            }
        }

    }

    private void Eliminar_la_reserva_actual() throws IOException {//terminado
        System.err.println("Eliminar_la_reserva_actual" + " inicio correctamente");
        //cambiar con la ubicacion actual el estdo de la siilla a libre
        //no va notar si esta pagada o no
        //mostrar si si se pudo
        sl.eliminarreserva();

    }

    private void Pagar_una_reserva_en_efectivo() throws IOException {
        System.err.println("Eliminar_la_reserva_actual" + " inicio correctamente");
        pedirdatosala();
        //mostrar costo 
        int costo = tj.averiguarcosto(largo);
        if (sl.estareservada(sala, puesto, largo)) {//averigua 
            if (1 == JOptionPane.showConfirmDialog(null, "desea recargar pagar", "recarga cinemark", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                tj.comprarpuestoefectivo(cdltemp, costo);
                sl.cambiarsalaapagada(sala, puesto, largo);
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo");
            }
        }
        //cambiar el estado del puesto a pagada
        //mostrar si si se pudo
    }

    private void Pagar_la_reserva_con_tarjeta_CINEMAS() throws IOException {
        System.err.println("Pagar_la_reserva_con_tarjeta_CINEMAS" + " inicio correctamente");
        pedirdatosala();
        int costo = tj.averiguarcosto(largo);
        if (sl.estareservada(sala, puesto, largo)) {
            if (1 == JOptionPane.showConfirmDialog(null, "desea recargar pagar", "recarga cinemark", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                tj.comprarpuestotj(cdltemp, costo);
                sl.cambiarsalaapagada(sala, puesto, largo);
            } else {
                JOptionPane.showMessageDialog(null, "no se pudo");
            }
        }
        //pedir cedula
        //averiguar si tiene tarjeta cinemax
        //preguntarle por que pelicula desea ver y el puesto
        //ver si esta disponible
        //ver si tiene sufieciente saldo
        //cambiar el estado del puesto a pagada
        //mostrar si si se pudo
    }

    private void Visualizar_disponibilidad() throws IOException {
        System.err.println("Visualizar_disponibilidad" + " inicio correctamente");
        graficar();
        //preguntar la sala y ejecutar el grafico
    }

    private void Visualizar_el_dinero_en_caja() {
        System.err.println("Visualizar_el_dinero_en_caja" + " inicio correctamente");
        JOptionPane.showMessageDialog(null, "dinero en caja:" + tj.getDinero_en_caja());
        //mostrar el contador de la plata para el cajero
    }

    private void Generar_reportes() throws IOException {
        System.err.println("Generar_reportes" + " inicio correctamente");
        //organizar cuentas y graficarlas 
        organizargraficar();
        //contador boletas vendidas
        //comntador boletas con la tarjeta
        //contador boletas con efectivo
        JOptionPane.showMessageDialog(null, "boletas vendiadas:" + tj.getBoletasvendidas()
                + "/n boletas con la tarjeta: " + tj.getBoletastj()
                + "/n boletas en efectivo" + tj.getBoletasef());

    }

    private void graficar() throws IOException {
        System.err.println("graficar" + " inicio correctamente");
        String salas[][][] = new String[3][5][10];
        salas = sl.graficar();
        int a, a2, a3;
        for (a = 0; a <3; a++) {
            for (a2 = 0; a2 <5; a2++) {
                for (a3 = 0; a3 <10; a3++) {
                    System.err.print(salas[a][a2][a3]);
                }
                System.err.print("/n");
            }
            System.err.print("/n");
        }

    }

    private void pedirdatosala() {

        sala = Integer.parseInt(JOptionPane.showInputDialog(null, "eliga una pelicula /n"
                + "1=avartar /n"
                + "2=Scott Pilgrim vs. los ex de la chica de sus sueños /n"
                + "3=El recuerdo de Marnie"));
        sala--;
        puesto = Integer.parseInt(JOptionPane.showInputDialog(null, "elige un puesto del un al 5"));
        puesto--; //los menos es por la matices enpiezan en 0
        String sublargo = JOptionPane.showInputDialog(null, "elige una fila a ala j");
        if (null != sublargo) {
            switch (sublargo) {
                case "a":
                    largo = 1;
                    break;
                case "b":
                    largo = 2;
                    break;
                case "c":
                    largo = 3;
                    break;
                case "d":
                    largo = 4;
                    break;
                case "e":
                    largo = 5;
                    break;
                case "f":
                    largo = 6;
                    break;
                case "g":
                    largo = 7;
                    break;
                case "h":
                    largo = 8;
                    break;
                case "i":
                    largo = 9;
                    break;
                case "j":
                    largo = 10;
                    break;
                default:
                    break;
            }
            largo--;
        }
    }

    private void organizargraficar() throws IOException {
        System.err.println("organizargraficar" + " inicio correctamente");
        String cuentasorg[] = tj.organizargraficar();
        for (String cuentasorg1 : cuentasorg) {
            JOptionPane.showMessageDialog(null, "::" + cuentasorg1,"cuntas",JOptionPane.DEFAULT_OPTION, icon);
        }
    }

}
