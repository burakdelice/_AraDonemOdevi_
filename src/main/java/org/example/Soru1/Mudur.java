package org.example.Soru1;

import java.util.List;

public class Mudur extends Personel implements Departman{

    private List<EnumDepartmanlar> sorumluOlunanDepartmanlar;
    private EnumDepartmanlar departman;

    @Override
    public EnumDepartmanlar getDepartman() {
        return departman;
    }

    @Override
    public void setDepartman(EnumDepartmanlar departman) {
        this.departman = departman;
    }

    public Mudur(String isim, int yas, double maas) {
        super(isim, yas, maas);
        this.departman = EnumDepartmanlar.YONETIM;
    }

    public List<EnumDepartmanlar> getSorumluOlunanDepartmanlar() {
        return sorumluOlunanDepartmanlar;
    }

    public void setSorumluOlunanDepartmanlar(List<EnumDepartmanlar> sorumluOlunanDepartmanlar) {
        this.sorumluOlunanDepartmanlar = sorumluOlunanDepartmanlar;
    }

    @Override
    public String toString() {
        return "Mudur{" +
                "sorumluOlunanDepartmanlar=" + sorumluOlunanDepartmanlar +
                ", departman=" + Departman.departman +
                "} " + super.toString();
    }

    @Override
    public void maasHesapla() {

    }
}
