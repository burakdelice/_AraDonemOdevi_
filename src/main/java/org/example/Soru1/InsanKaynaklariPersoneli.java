package org.example.Soru1;

public class InsanKaynaklariPersoneli extends Personel implements Departman{

   private int gorusmeSayisi;

   private EnumDepartmanlar departman;

    @Override
    public EnumDepartmanlar getDepartman() {
        return departman;
    }

    @Override
    public void setDepartman(EnumDepartmanlar departman) {
        this.departman = departman;
    }

    public InsanKaynaklariPersoneli(String isim, int yas, double maas) {
        super(isim, yas, maas);
        setDepartman(EnumDepartmanlar.IK);
    }

    public int getGorusmeSayisi() {
        return gorusmeSayisi;
    }

    public void setGorusmeSayisi(int gorusmeSayisi) {
        this.gorusmeSayisi = gorusmeSayisi;
    }

    @Override
    public String toString() {
        return "InsanKaynaklariPersoneli{" +
                "gorusmeSayisi=" + gorusmeSayisi +
                ", departman=" + Departman.departman +
                "} " + super.toString();
    }

    @Override
    public void maasHesapla() {

    }
}
