package org.example.Soru1;

public class BuroPersoneli extends Personel implements Departman{

    private EnumDepartmanlar departman;
    private String buroIsmi;

    @Override
    public EnumDepartmanlar getDepartman() {
        return departman;
    }

    @Override
    public void setDepartman(EnumDepartmanlar departman) {
        this.departman = departman;
    }

    public BuroPersoneli(String isim, int yas, double maas) {
        super(isim, yas, maas);
        this.departman = EnumDepartmanlar.YONETIM;
    }

    @Override
    public void maasHesapla() {

    }

    public String getBuroIsmi() {
        return buroIsmi;
    }

    public void setBuroIsmi(String buroIsmi) {
        this.buroIsmi = buroIsmi;
    }

    @Override
    public String toString() {
        return "BuroPersoneli{" +
                "buroIsmi='" + buroIsmi + '\'' +
                ", departman=" + Departman.departman +
                "} " + super.toString();
    }
}
