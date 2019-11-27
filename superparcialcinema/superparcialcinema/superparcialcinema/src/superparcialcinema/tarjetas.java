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
    
    bs2 bs2=new bs2();
    int dinero_en_caja;
    private int a;
    private String c;
    boolean bs2_vericarnuevacdl(int cdltemp) throws IOException {
        dinero_en_caja=0;
        System.err.println("bs_vericarnuevacdl" + " inicio correctamente");
        return (bs2.vericarnuevacdl(cdltemp));
    }

    void creartarjetacinemark(int cdltemp) {
        //no hay asegurar que sea de 10 digitos
        dinero_en_caja=dinero_en_caja+70000;
        System.err.println("creartarjetacinemark" + " inicio correctamente");
        c=Integer.toString(cdltemp);
        while (c.length()==10){
           c="0"+c;
        }
        bs2.creartarjetacinemark(c);
    }
    int comprarpuestoefectivov() {
        System.err.println("comprarpuestoefectivov" + " inicio correctamente");
        return bs2.comprarpuestoefectivov();
    }

    void Recargar_una_tarjeta(int cdltemp) {
        dinero_en_caja=dinero_en_caja+50000;
        System.err.println("Recargar_una_tarjeta" + " inicio correctamente");
        bs2.Recargar_una_tarjeta(cdltemp);
    }

    boolean nuevareservatjv(int cdltemp) {
        System.err.println("nuevareservatjv" + " inicio correctamente");
        return bs2.nuevareservav(cdltemp);
    }

    void nuevareservatj(int cdltemp) {
        System.err.println("nuevareservatj" + " inicio correctamente");
        bs2.nuevareserva(cdltemp);
    }

    int comprarpuestoefectivov(int largo) {
        System.err.println("comprarpuestoefectivo" + " inicio correctamente");
        int b=0;
        if (largo<=7 && largo>=1){
            b=8000;
        }else{
            b=11000;
        }
        return b;
    }


    void comprarpuestotj() {
        System.err.println("comprarpuestotj" + " inicio correctamente");
    }

    public int getDinero_en_caja() {
        return dinero_en_caja;
    }
}
