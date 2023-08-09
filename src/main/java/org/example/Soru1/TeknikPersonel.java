package org.example.Soru1;

public class TeknikPersonel extends Personel implements Departman{

    private String bilgisayar;
    private EnumDepartmanlar departman;

    @Override
    public EnumDepartmanlar getDepartman() {
        return departman;
    }

    @Override
    public void setDepartman(EnumDepartmanlar departman) {
        this.departman = departman;
    }

    public TeknikPersonel(String isim, int yas, double maas) {
        super(isim, yas, maas);
        this.departman = EnumDepartmanlar.TEKNIK;
    }

    public String getBilgisayar() {
        return bilgisayar;
    }

    public void setBilgisayar(String bilgisayar) {
        this.bilgisayar = bilgisayar;
    }

    @Override
    public String toString() {
        return "TeknikPersonel{" +
                "bilgisayar='" + bilgisayar + '\'' +
                ", departman=" + Departman.departman +
                "} " + super.toString();
    }

    @Override
    public void maasHesapla() {

    }
}
