package org.example.Soru1;

public class MuhasebePersoneli extends Personel implements Departman {

    private String muhasebeProgrami;
    private EnumDepartmanlar departman;

    @Override
    public EnumDepartmanlar getDepartman() {
        return departman;
    }

    @Override
    public void setDepartman(EnumDepartmanlar departman) {
        this.departman = departman;
    }

    public MuhasebePersoneli(String isim, int yas, double maas) {
        super(isim, yas, maas);
        this.departman = EnumDepartmanlar.MUHASEBE;
    }

    public String getMuhasebeProgrami() {
        return muhasebeProgrami;
    }

    public void setMuhasebeProgrami(String muhasebeProgrami) {
        this.muhasebeProgrami = muhasebeProgrami;
    }

    @Override
    public String toString() {
        return "MuhasebePersoneli{" +
                "muhasebeProgrami='" + muhasebeProgrami + '\'' +
                ", departman=" + Departman.departman +
                "} " + super.toString();
    }

    @Override
    public void maasHesapla() {

    }
}
