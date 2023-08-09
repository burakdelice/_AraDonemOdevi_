package org.example.Soru1;

import java.time.LocalDate;

public class Personel extends PersonelAbstract {

    private int personelId;
    private String isim;
    private int yas;
    private double maas;
    private static int sayac;
    private EnumDepartmanlar departman;
    LocalDate kayitTarihi;

    public Personel(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
    }

    public Personel(String isim, int yas, double maas) {
        sayac++;
        this.isim = isim;
        this.yas = yas;
        this.maas = maas;
        this.personelId = sayac;
        this.kayitTarihi = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Personel{" +
                "isim='" + isim + '\'' +
                ", yas=" + yas +
                ", maas=" + maas +
                ", personelId=" + personelId +
                ", kayitTarihi=" + kayitTarihi +
                '}';
    }

    public LocalDate getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDate kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public EnumDepartmanlar getDepartman() {
        return departman;
    }

    public void setDepartman(EnumDepartmanlar departman) {
        this.departman = departman;
    }

    @Override
    public void maasHesapla() {

    }
}
