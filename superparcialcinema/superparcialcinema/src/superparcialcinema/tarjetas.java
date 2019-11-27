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
class tarjetas {

    bs2 bs2 = new bs2();
    int dinero_en_caja,boletasvendidas,boletastj,boletasef;
    private int a;
    private String c;

    boolean bs2_vericarnuevacdl(int cdltemp) throws IOException { //terminado
        dinero_en_caja = 0;
        System.err.println("bs_vericarnuevacdl" + " inicio correctamente");
        return (bs2.vericarnuevacdl(cdltemp));
    }

    void creartarjetacinemark(int cdltemp) { //terminado
        //no hay asegurar que sea de 10 digitos
        dinero_en_caja = dinero_en_caja + 70000;
        System.err.println("creartarjetacinemark" + " inicio correctamente");
        c = Integer.toString(cdltemp);
        while (c.length() == 10) {
            c = "0" + c;
        }
        bs2.creartarjetacinemark(c);
    }

    void Recargar_una_tarjeta(int cdltemp) {
        dinero_en_caja = dinero_en_caja + 50000;
        System.err.println("Recargar_una_tarjeta" + " inicio correctamente");
        bs2.Recargar_una_tarjeta(cdltemp);
    }

    boolean nuevareservatjv(int cdltemp) {
        System.err.println("nuevareservatjv" + " inicio correctamente");
        return bs2.nuevareservav(cdltemp);
    }

    public void nuevareservatj(int cdltemp) {
        System.err.println("nuevareservatj" + " inicio correctamente");
        bs2.nuevareserva(cdltemp);
    }

    public void  comprarpuestoefectivo(int cdltemp,int costo) {
        System.err.println("comprarpuestoefectivo" + " inicio correctamente");
        bs2.comprarpuestoEF(cdltemp);
        dinero_en_caja+=costo; 
        boletasvendidas++;
        boletasef++;
    }

    void comprarpuestotj(int cdltemp,int costo) {
        System.err.println("comprarpuestotj" + " inicio correctamente");
        bs2.comprarpuestoTJ(cdltemp,costo);
        dinero_en_caja+=costo;
        boletasvendidas++;
        boletastj++;
    }

    

    int averiguarcosto(int largo) {
        if (largo >= 0 && largo <= 6) {
            return 8000;
        }else if (largo>= 7&&largo<=10){
            return 11000;   
        }else{
            return 0;
        }
    }
    public int getDinero_en_caja() {
        return dinero_en_caja;
    }

    public int getBoletasvendidas() {
        return boletasvendidas;
    }

    public int getBoletastj() {
        return boletastj;
    }

    public int getBoletasef() {
        return boletasef;
    }

    String[] organizargraficar() throws IOException {
        System.err.println("organizargraficar" + " inicio correctamente");
        return bs2.organizargraficar();
    }

   
}
