package org.example.Soru1;

public enum MesajTipleri {

    ARANAN_BULUNAMADI (100, "Aranan bulunamadı."),
    EKLEME_YAPILAMADI (200, "Ekleme yapılamadı."),
    GUNECELLEME_YAPILAMADI (601, "Günecelle yapılamadı.");


    int istisnaKodu;
    String mesaj;

    MesajTipleri(int istisnaKodu, String mesaj) {
        System.out.println();
    }

    public int getIstisnaKodu() {
        return istisnaKodu;
    }

    public String getMesaj() {
        return mesaj;
    }
}
