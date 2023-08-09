package org.example.Soru1;

public class GenelMudur extends Personel implements Departman{

    private long yoneticiPrimi;

    @Override
    public EnumDepartmanlar getDepartman() {
        return departman;
    }

    @Override
    public void setDepartman(EnumDepartmanlar departman) {
        this.departman = departman;
    }

    private EnumDepartmanlar departman;

    public GenelMudur(String isim, int yas, double maas) {
        super(isim, yas, maas);
        this.departman = EnumDepartmanlar.YONETIM;
    }

    public long getYoneticiPrimi() {
        return yoneticiPrimi;
    }

    public void setYoneticiPrimi(long yoneticiPrimi) {
        this.yoneticiPrimi = yoneticiPrimi;
    }

    @Override
    public String toString() {
        return "GenelMudur{" +
                "yoneticiPrimi=" + yoneticiPrimi +
                ", departman=" + Departman.departman +
                "} " + super.toString();
    }

    @Override
    public void maasHesapla() {

    }
}
