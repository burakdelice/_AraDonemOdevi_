package org.example.Soru1;

public class Hizmetli extends Personel implements Departman{

    private int katNumarasi;
    private EnumDepartmanlar departman;

    @Override
    public EnumDepartmanlar getDepartman() {
        return departman;
    }

    @Override
    public void setDepartman(EnumDepartmanlar departman) {
        this.departman = departman;
    }

    public Hizmetli(String isim, int yas, double maas) {
        super(isim, yas, maas);
        this.departman = EnumDepartmanlar.DESTEK;
    }

    @Override
    public String toString() {
        return "Hizmetli{" +
                "katNumarasi=" + katNumarasi +
                ", departman=" + Departman.departman +
                "} " + super.toString();
    }

    public int getKatNumarasi() {
        return katNumarasi;
    }

    public void setKatNumarasi(int katNumarasi) {
        this.katNumarasi = katNumarasi;
    }

    @Override
    public void maasHesapla() {

    }
}
