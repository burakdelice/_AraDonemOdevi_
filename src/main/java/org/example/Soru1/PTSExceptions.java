package org.example.Soru1;

public class PTSExceptions extends RuntimeException {
    public PTSExceptions(MesajTipleri mesaj) {
        System.out.println(mesaj);
    }
}

