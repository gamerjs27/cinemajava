/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superparcialcinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author los hernandez
 */
final class bs {

    final private String brr = File.separator, ficherotjt = (System.getProperty("user.dir")) + brr + "salas", ficheros = ficherotjt + brr + "salas";
    public File ficherotj;
    String salas[][][] = new String[3][5][10];

    public bs() {
        // se crea la carpeta
        ficherotj = new File(ficherotjt);
        File fs_ex = new File(ficheros);
        System.err.println(ficherotjt);
        System.err.print("file has created \n //" + ficherotj.exists() + "\n");
        if (!ficherotj.isDirectory()) {
            ficherotj.delete();
            ficherotj = new File(ficherotjt);
            ficherotj.mkdirs();
        }
        System.err.print("\n file to directory succes");
        //reciclado de mi programa del parcial crea la carpeta  y si hay algu error la elimina y la vuelve a crear
        if (fs_ex.length() == 0) {
            for (int i = 0; i < 3; i++) {
                for (int i2 = 0; i2 < 5; i2++) {
                    for (int i3 = 0; i3 < 10; i3++) {
                        salas[i][i2][i3]="L";
                    }
                }
            }
            subirdatos(salas);
        }

    }

    String[][][] actulizardatos() throws FileNotFoundException, IOException {
        String linea;
        String linea2[];
        String linea3[];
        String linea4[];
        String linea5[];
        System.err.println("actulizardatos" + " inicio correctamente");
        try (BufferedReader actd = new BufferedReader(new FileReader(ficheros))) {
            linea = actd.readLine();
            linea2 = linea.split("#");
            linea3 = linea2[0].split("$");
            linea4 = linea2[1].split("$");
            linea5 = linea2[2].split("$");

            salas[1][0] = linea3[0].split("-");
            salas[1][1] = linea3[1].split("-");
            salas[1][2] = linea3[2].split("-");
            salas[1][3] = linea3[3].split("-");
            salas[1][4] = linea3[4].split("-");

            salas[2][0] = linea4[0].split("-");
            salas[2][1] = linea4[1].split("-");
            salas[2][2] = linea4[2].split("-");
            salas[2][3] = linea4[3].split("-");
            salas[2][4] = linea4[4].split("-");

            salas[2][0] = linea5[0].split("-");
            salas[2][1] = linea5[1].split("-");
            salas[2][2] = linea5[2].split("-");
            salas[2][3] = linea5[3].split("-");
            salas[2][4] = linea5[4].split("-");

        } catch (Exception e) {
            System.err.println(e);
        }

        return salas;
    }

    void subirdatos(String[][][] salas) {
        String lineaf = "";
        System.err.println("subirdatos" + " inicio correctamente");
        try (BufferedWriter sala = new BufferedWriter(new FileWriter(ficheros, true))) {
            for (int i = 0; i <= 3; i++) {
                for (int i2 = 0; i2 <= 5; i2++) {
                    for (int i3 = 0; i3 <= 10; i3++) {
                        if (i3 == 0) {
                            lineaf = lineaf + salas[i][i2][i3];
                        } else {
                            lineaf = lineaf + "-" + salas[i][i2][i3];
                        }
                    }
                    if (i2 != 5) {
                        lineaf = lineaf + "$";
                    }
                }
                if (i != 3) {
                    lineaf = lineaf + "#";
                }
            }
            sala.write(lineaf);
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
