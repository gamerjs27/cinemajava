/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superparcialcinema;

import java.io.IOException;

/**
 *
 * @author los hernandez
 */
class salas {
    bs bs=new bs();
    String salas[][][]=new String [3][5][10];
    int sala, puesto, largo;
    boolean i=false;
    String[][][] graficar() throws IOException {//terminado
        System.err.println("graficar" + " inicio correctamente");
        actualizardatos();
        return salas;
    }

    boolean verificarnuevareserva(int sala, int puesto, int largo) throws IOException {//terminado
        System.err.println("verificarnuevareserva" + " inicio correctamente");
        actualizardatos();
        return "l".equals(salas[sala][puesto][largo]);
    }

    void nuevasreservas(int salat, int puestot, int largot) throws IOException {//terminado
        System.err.println("nuevasreservasl" + " inicio correctamente");
        actualizardatos();
        salas[salat][puestot][largot]="r";
        bs.subirdatos(salas);
        setSala(salat);
        setPuesto(puestot);
        setLargo(largot);

    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    private void actualizardatos() throws IOException {//terminado
        System.err.println("actualizardatos" + " inicio correctamente");
        salas=bs.actulizardatos();
    }

    void eliminarreserva() throws IOException {//terminado
        System.err.println("eliminarreserva" + " inicio correctamente");
        salas=bs.actulizardatos();
        salas[sala][puesto][largo]="l";
        
    }

    void cambiarsalaapagada(int salat, int puestot, int largot) throws IOException {//terminado
        System.err.println("cambiarsalaapagada" + " inicio correctamente");
        actualizardatos();
        salas[salat][puestot][largot]="p";
        bs.subirdatos(salas);
    }

    boolean estareservada(int sala, int puesto, int largo) throws IOException {//terminado
        System.err.println("estareservada" + " inicio correctamente");
        System.err.println("verificarnuevareserva" + " inicio correctamente");
        actualizardatos();
        return "r".equals(salas[sala][puesto][largo]);
    }

    
}
