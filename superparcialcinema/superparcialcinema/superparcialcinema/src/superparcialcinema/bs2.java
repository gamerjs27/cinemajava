/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superparcialcinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;

/**
 *
 * @author los hernandez
 */
class bs2 {

    final private String brr = File.separator, ficherotjt = (System.getProperty("user.dir")) + brr + "tarjetascinemark";
    public File ficherotj;

    public bs2() {
        // se crea la carpeta
        ficherotj = new File(ficherotjt);
        System.err.println(ficherotjt);
        System.err.print("file has created \n //" + ficherotj.exists() + "\n");
        if (!ficherotj.isDirectory()) {
            ficherotj.delete();
            ficherotj = new File(ficherotjt);
            ficherotj.mkdirs();
        }
        System.err.print("\n file to directory succes");
        //reciclado de mi programa del parcial crea la carpeta  y si hay algu error la elimina y la vuelve a crear
    }

    boolean vericarnuevacdl(int cdltemp) throws IOException {
        System.err.println("vericarnuevacdl" + " inicio correctamente");
        final String ficheroa = ficherotjt + brr + "tarjetas.txt";// si no lo notaron hay que hacer parse de int a string
        boolean retorno = false;
        String linea;
        try (BufferedReader nuevatjv = new BufferedReader(new FileReader(ficheroa))) {
            while ((linea = nuevatjv.readLine()) != null) {
                String[] lineaP = linea.split("-");
                System.err.println(lineaP[0]);
                try {
                    int lineaINT = Integer.parseInt(lineaP[0]);
                    if (retorno) {
                        System.err.println("yo no se puede cambiar");
                    } else {
                        retorno = cdltemp == lineaINT;
                        //System.err.println("lo encontro");
                    }
                } catch (NumberFormatException e) {
                    System.err.println(e + "no se pudo hacer el parse");
                }
                System.err.println("leyendolinaeporlinea");
            }
        } catch (IOException e) {
            System.err.println(e + "error verificar nuevatj");

        }
        return retorno;

        //comprueba si la si esa ceduala ya esta inscrita 
    }

    public void creartarjetacinemark(String cdltemp) {
        System.err.println("creartarjetacinemark" + " inicio correctamente");
        //no hay necesidad de hacer una matriz por que es un solo dato
        final String ficheroa = ficherotjt + brr + "tarjetas.txt";
        try (BufferedWriter nuevatj = new BufferedWriter(new FileWriter(ficheroa, true))) {
            nuevatj.write(cdltemp + "-" + Integer.toString(70000) + "-0");
            nuevatj.newLine();
            nuevatj.flush();
        } catch (IOException e) {
            System.out.println("not possible to create the file ::" + ficheroa); // en ingles se ve mas chido
            System.out.println(e);
        }
    }

    void Recargar_una_tarjeta(int cdltemp) {
        System.err.println("Recargar_una_tarjeta" + " inicio correctamente");
        final String ficheroa = ficherotjt + brr + "tarjetas.txt", ficheroa2 = ficherotjt + brr + "tarjetas2.txt";// si no lo notaron hay que hacer parse de int a string
        String linea;
        int cont = 0, contf = 0;
        try (BufferedWriter nuevatj2 = new BufferedWriter(new FileWriter(ficheroa2, true)); BufferedReader nuevatjv = new BufferedReader(new FileReader(ficheroa))) {
            while ((linea = nuevatjv.readLine()) != null) {
                String[] lineaP = linea.split("-");
                System.err.println("arranco linea por linea");
                int lineaINT = Integer.parseInt(lineaP[0]);
                if (lineaINT == cdltemp) {
                    System.err.println("encontro una linea que coincide cdl");
                    nuevatj2.write(lineaP[0] + "-" + Integer.toString((Integer.parseInt(lineaP[1])) + 50000) + "-" + lineaP[2]);
                } else {
                    nuevatj2.write(lineaP[0] + "-" + lineaP[1] + "-" + lineaP[2]);
                }
                nuevatj2.newLine();
                //aqui tremina el primer el try2
            }
        } catch (NumberFormatException e) {
            System.err.println(e + "no se pudo hacer el parse");

        } catch (IOException e) {
            System.err.println(e + "error verificar nuevatj");
        }
        //borrar terjetas 1
        try {
            File eliminartj = new File(ficheroa);
            if (eliminartj.exists()) {
                eliminartj.delete();
            }
        } catch (Exception e) {
            System.err.println(e + "error verificar nuevatj");
        }
        //trascribir tarjetas2 a tarjetas1
        try (BufferedWriter nuevatj = new BufferedWriter(new FileWriter(ficheroa, true)); BufferedReader nuevatjv2 = new BufferedReader(new FileReader(ficheroa2))) {
            while ((linea = nuevatjv2.readLine()) != null) {
                nuevatj.write(linea);
                nuevatj.newLine();
            }
        } catch (IOException e) {
            System.err.println(e + "error trancribir");
        }
        //borrar tj2
        try {
            File eliminartj = new File(ficheroa2);
            if (eliminartj.exists()) {
                eliminartj.delete();
            }
        } catch (Exception e) {
            System.err.println(e + "error borrar 2txt");
        }

    }

    boolean nuevareservav(int cdltemp) {
        System.err.println("nuevareservav" + " inicio correctamente");
        final String ficheroa = ficherotjt + brr + "tarjetas.txt";// si no lo notaron hay que hacer parse de int a string
        boolean retorno = false, retorno2 = false;
        String linea;
        try (BufferedReader nuevatjv = new BufferedReader(new FileReader(ficheroa))) {
            while ((linea = nuevatjv.readLine()) != null) {
                String[] lineaP = linea.split("-");
                System.err.println(lineaP[0]);
                try {
                    int lineaINT = Integer.parseInt(lineaP[0]);
                    if (!retorno) {
                        retorno = cdltemp == lineaINT;
                        if (!retorno2){
                            retorno2 = Integer.parseInt(lineaP[2]) < 8;
                        }
                        //System.err.println("lo encontro");
                    }
                } catch (NumberFormatException e) {
                    System.err.println(e + "no se pudo hacer el parse");
                }
                System.err.println("leyendolinaeporlinea");
            }
        } catch (IOException e) {
            System.err.println(e + "error verificar nuevatj");

        }
        return retorno;

        //comprueba si la si esa ceduala ya esta inscrita 
    }

    void nuevareserva(int cdltemp) {
        System.err.println("nuevareserva" + " inicio correctamente");
        //no hay necesidad de hacer una matriz por que es un solo dato
        final String ficheroa = ficherotjt + brr + "tarjetas.txt", ficheroa2 = ficherotjt + brr + "tarjetas2.txt";// si no lo notaron hay que hacer parse de int a string
        String linea;
        int cont = 0, contf = 0;
        try (BufferedWriter nuevatj2 = new BufferedWriter(new FileWriter(ficheroa2, true)); BufferedReader nuevatjv = new BufferedReader(new FileReader(ficheroa))) {
            while ((linea = nuevatjv.readLine()) != null) {
                String[] lineaP = linea.split("-");
                System.err.println("arranco linea por linea");
                int lineaINT = Integer.parseInt(lineaP[0]);
                if (lineaINT == cdltemp) {
                    System.err.println("encontro una linea que coincide cdl");
                    nuevatj2.write(lineaP[0] + "-" + lineaP[1] + "-" + (Integer.toString(Integer.parseInt(lineaP[2])) + 1));
                } else {
                    nuevatj2.write(lineaP[0] + "-" + lineaP[1] + "-" + lineaP[2]);
                }
                nuevatj2.newLine();
                //aqui tremina el primer el try2
            }
        } catch (NumberFormatException e) {
            System.err.println(e + "no se pudo hacer el parse");

        } catch (IOException e) {
            System.err.println(e + "error verificar nuevatj");
        }
        //borrar terjetas 1
        try {
            File eliminartj = new File(ficheroa);
            if (eliminartj.exists()) {
                eliminartj.delete();
            }
        } catch (Exception e) {
            System.err.println(e + "error borrar txt");
        }
        //trascribir tarjetas2 a tarjetas1
        try (BufferedWriter nuevatj = new BufferedWriter(new FileWriter(ficheroa, true)); BufferedReader nuevatjv2 = new BufferedReader(new FileReader(ficheroa2))) {
            while ((linea = nuevatjv2.readLine()) != null) {
                nuevatj.write(linea);
                nuevatj.newLine();
            }
        } catch (IOException e) {
            System.err.println(e + "error trancribir");
        }
        //borrar tj2
        try {
            File eliminartj = new File(ficheroa2);
            if (eliminartj.exists()) {
                eliminartj.delete();
            }
        } catch (Exception e) {
            System.err.println(e + "error borrar 2txt");
        }
    }

    int comprarpuestoefectivov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//                                                                      
//                                                                      
//   $$$$$$\   $$$$$$\  $$$$$$\$$$$\   $$$$$$\   $$$$$$\   $$\  $$$$$$$\ 
//  $$  __$$\  \____$$\ $$  _$$  _$$\ $$  __$$\ $$  __$$\  \__|$$  _____|
//  $$ /  $$ | $$$$$$$ |$$ / $$ / $$ |$$$$$$$$ |$$ |  \__| $$\ \$$$$$$\  
//  $$ |  $$ |$$  __$$ |$$ | $$ | $$ |$$   ____|$$ |       $$ | \____$$\ 
//  \$$$$$$$ |\$$$$$$$ |$$ | $$ | $$ |\$$$$$$$\ $$ |       $$ |$$$$$$$  |
//   \____$$ | \_______|\__| \__| \__| \_______|\__|       $$ |\_______/ 
//  $$\   $$ |                                       $$\   $$ |          
//  \$$$$$$  |                                       \$$$$$$  |          
//   \______/                                         \______/           
