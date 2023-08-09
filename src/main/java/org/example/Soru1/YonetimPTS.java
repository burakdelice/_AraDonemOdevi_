package org.example.Soru1;

import java.time.LocalDate;
import java.util.*;

public class YonetimPTS {

    public static List<Personel> personelListesi = new ArrayList<>();
    public static List<Mudur> mudurler = new ArrayList<>();
    public static GenelMudur genelMudur;
    public static List<Hizmetli> hizmetliler = new ArrayList<>();
    public static List<BuroPersoneli> buroPersonelleri = new ArrayList<>();
    public static List<InsanKaynaklariPersoneli> ikPersonelleri = new ArrayList<>();
    public static List<TeknikPersonel> teknikPersoneller = new ArrayList<>();
    public static List<MuhasebePersoneli> muhasebePersonelleri = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void personelTanimlama() {
        GenelMudur genelMudur = new GenelMudur("Burak", 50, 100000);
        personelListesi.add(genelMudur);
        Mudur mudur1 = new Mudur("Kemal", 42, 29000);
        personelListesi.add(mudur1);
        mudurler.add(mudur1);
        List<EnumDepartmanlar> mudur1sorumludepartmanlar = new ArrayList<>();
        mudur1sorumludepartmanlar.add(EnumDepartmanlar.IK);
        mudur1sorumludepartmanlar.add(EnumDepartmanlar.MUHASEBE);
        mudur1.setSorumluOlunanDepartmanlar(mudur1sorumludepartmanlar);
        Mudur mudur2 = new Mudur("Ufuk", 48, 32000);
        personelListesi.add(mudur2);
        mudurler.add(mudur2);
        List<EnumDepartmanlar> mudur2sorumludepartmanlar = new ArrayList<>();
        mudur2sorumludepartmanlar.add(EnumDepartmanlar.YONETIM);
        mudur2sorumludepartmanlar.add(EnumDepartmanlar.TEKNIK);
        mudur2.setSorumluOlunanDepartmanlar(mudur2sorumludepartmanlar);
        Mudur mudur3 = new Mudur("Neşe", 47, 35000);
        personelListesi.add(mudur3);
        mudurler.add(mudur3);
        List<EnumDepartmanlar> mudur3sorumludepartmanlar = new ArrayList<>();
        mudur3sorumludepartmanlar.add(EnumDepartmanlar.DESTEK);
        mudur3.setSorumluOlunanDepartmanlar(mudur2sorumludepartmanlar);
        Hizmetli hizmetli1 = new Hizmetli("Ahmet", 33, 18000);
        personelListesi.add(hizmetli1);
        hizmetliler.add(hizmetli1);
        InsanKaynaklariPersoneli insanKaynaklari1 = new InsanKaynaklariPersoneli("Seda", 29, 22000);
        personelListesi.add(insanKaynaklari1);
        ikPersonelleri.add(insanKaynaklari1);
        MuhasebePersoneli muhasebe1 = new MuhasebePersoneli("Ertuğ", 29, 24000);
        personelListesi.add(muhasebe1);
        muhasebePersonelleri.add(muhasebe1);
        TeknikPersonel teknik1 = new TeknikPersonel("Sinan", 39, 21000);
        personelListesi.add(teknik1);
        teknikPersoneller.add(teknik1);
    }

    public void PTSMenu() {

        int secenek;

        do {

            System.out.println("**********************************************************\n" +
                    "************** PERSONEL TAKİP SİSTEMİ ********************\n" +
                    "**********************************************************");
            System.out.println("1. Personel İşlemleri");
            System.out.println("2. Muhasebe İşlemleri");
            System.out.println("3. Raporlamalar");
            System.out.println("Çıkış Yapmak için '0' tuşlayınız.");
            System.out.print("Seçiminizi yapın: ");
            secenek = scanner.nextInt();

            switch (secenek) {
                case 1:
                    personelMenu();
                    break;
                case 2:
                    muhasebeMenu();
                    break;
                case 3:
                    raporlamaMenu();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız!");
                    break;
            }
        } while (secenek != 0);

    }

    private void personelMenu() {

        int secenek;

        do {
            System.out.println("    1.1. Personel Ekleme");
            System.out.println("    1.2. Personel Listesi");
            System.out.println("    1.3. Personel Düzenleme");
            System.out.println("    1.4  Departman Ekleme");
            System.out.println("    1.5  Departman Listesi");
            System.out.println("Çıkış Yapmak için '0' tuşlayınız.");
            System.out.print("Seçiminizi yapın: ");
            secenek = scanner.nextInt();
            scanner.nextLine();

            switch (secenek) {
                case 1:
                    personelEkle();
                    break;
                case 2:
                    personelListele();
                    break;
                case 3:
                    personelDuzenle();
                    break;
                case 4:
                    departmanEkle();
                    break;
                case 5:
                    departmanListele();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız!");
                    break;
            }
        } while (secenek != 0);

    }

    private void muhasebeMenu() {

        int secenek;

        do {
            System.out.println("    2.1 Maaş Personel tanımlama");
            System.out.println("    2.2 Ödeme Listesi");
            System.out.println("Çıkış Yapmak için '0' tuşlayınız.");
            System.out.print("Seçiminizi yapın: ");
            secenek = scanner.nextInt();

            switch (secenek) {
                case 1:
                    maasPersonelTanimla();
                    break;
                case 2:
                    odemeListesiGetir();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız!");
                    break;
            }
        } while (secenek != 0);

    }

    private void raporlamaMenu() {

        int secenek;

        do {
            System.out.println("    3.1 Departman Personel Listesi");
            System.out.println("    3.2 En Çok Personel Bulunan Departman");
            System.out.println("    3.3 Departmanlara göre maaş ortalamaları");
            System.out.println("    3.4 Müdürlerin sorumlu olduğu departman listesi");
            System.out.println("    3.5 Kayıt tarihlerine göre personellerin sıralı listesi.");
            System.out.println("    3.6 Aynı gün içinde işe başlayan personellerin listesi.");
            System.out.println("Çıkış Yapmak için '0' tuşlayınız.");
            System.out.print("Seçiminizi yapın: ");
            secenek = scanner.nextInt();

            switch (secenek) {
                case 1:
                    departmanPersonelListesi();
                    break;
                case 2:
                    enCokPersonelBulunanDepartman();
                    break;
                case 3:
                    departmanlaraGoreMaasOrtalamalari();
                    break;
                case 4:
                    mudurlerinSorumluOlduguDepartmanListesi();
                    break;
                case 5:
                    kayitTarihlerineGorePersonellerinSiraliListesi();
                    break;
                case 6:
                    ayniGunIcindeIseBaslayanPersonellerinListesi();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız!");
                    break;
            }
        } while (secenek != 0);

    }

    private void ayniGunIcindeIseBaslayanPersonellerinListesi() {
        Map<LocalDate, Set<Personel>> ayniGunBaslayanlar = new HashMap<>();

        for (int i = 0; i < personelListesi.size(); i++) {
            Personel personel = personelListesi.get(i);
            LocalDate kayitTarihi = personel.getKayitTarihi();

            if (!ayniGunBaslayanlar.containsKey(kayitTarihi)) {
                Set<Personel> personelSet = new HashSet<>();
                personelSet.add(personel);
                ayniGunBaslayanlar.put(kayitTarihi, personelSet);
            } else {
                Set<Personel> personelSet = ayniGunBaslayanlar.get(kayitTarihi);
                personelSet.add(personel);
            }
        }
        for (Map.Entry<LocalDate, Set<Personel>> entry : ayniGunBaslayanlar.entrySet()) {
            LocalDate kayitTarihi = entry.getKey();
            Set<Personel> personelSet = entry.getValue();

            System.out.println("Kayıt Tarihi: " + kayitTarihi + "\n ========================");
            for (Personel personel : personelSet) {
                System.out.println(personel.getIsim());
            }
            System.out.println();
        }
    }

    private void kayitTarihlerineGorePersonellerinSiraliListesi() {
        List<Personel> kayitaGorePersoneller = new ArrayList<>();
        kayitaGorePersoneller.addAll(personelListesi);
        kayitaGorePersoneller.sort(Comparator.comparing(Personel::getKayitTarihi));
        for (Personel personel : kayitaGorePersoneller) {
            System.out.println(personel.getIsim() + " kayıt tarihi --> " + personel.getKayitTarihi());
        }
    }

    private void mudurlerinSorumluOlduguDepartmanListesi() {
        for (int i = 0; i < mudurler.size(); i++) {
            System.out.println(mudurler.get(i).getIsim() + " müdürün sorumlu olduğu departmanlar--> " + mudurler.get(i).getSorumluOlunanDepartmanlar());
        }
    }

    private void departmanlaraGoreMaasOrtalamalari() {
        double ortalama = 0;
        for (int i = 0; i < ikPersonelleri.size(); i++) {
            double maas = ikPersonelleri.get(i).getMaas();
            ortalama += maas;
        }
        System.out.println("IK Ortalama: " + ortalama / ikPersonelleri.size());
        ortalama = 0;
        for (int i = 0; i < buroPersonelleri.size(); i++) {
            double maas = buroPersonelleri.get(i).getMaas();
            ortalama += maas;
        }
        for (int i = 0; i < mudurler.size(); i++) {
            double maas = mudurler.get(i).getMaas();
            ortalama += maas;
        }
        double maas = personelListesi.get(0).getMaas();
        ortalama += maas;
        System.out.println("YONETIM Ortalama: " + ortalama / (mudurler.size()) + buroPersonelleri.size() + 1);
        ortalama = 0;
        for (int i = 0; i < hizmetliler.size(); i++) {
            double maasHizmetli = hizmetliler.get(i).getMaas();
            ortalama += maasHizmetli;
        }
        System.out.println("DESTEK Ortalama: " + ortalama / hizmetliler.size());
        ortalama = 0;
        for (int i = 0; i < muhasebePersonelleri.size(); i++) {
            double maasDestek = muhasebePersonelleri.get(i).getMaas();
            ortalama += maasDestek / muhasebePersonelleri.size();
        }
        System.out.println("MUHASEBE Ortalama: " + ortalama / muhasebePersonelleri.size());
        ortalama = 0;
        for (int i = 0; i < teknikPersoneller.size(); i++) {
            double maasTeknik = teknikPersoneller.get(i).getMaas();
            ortalama += maasTeknik;
        }
        System.out.println("TEKNIK Ortalama: " + ortalama / teknikPersoneller.size());
    }

    private void enCokPersonelBulunanDepartman() {

        int maxCalisanDepartman = -1;
        String maxDepartman = "";

        if (ikPersonelleri.size() > maxCalisanDepartman) {
            maxCalisanDepartman = ikPersonelleri.size();
            maxDepartman = "IK Departmanı";
        }

        if (teknikPersoneller.size() > maxCalisanDepartman) {
            maxCalisanDepartman = teknikPersoneller.size();
            maxDepartman = "Teknik Departman";
        }

        if (muhasebePersonelleri.size() > maxCalisanDepartman) {
            maxCalisanDepartman = muhasebePersonelleri.size();
            maxDepartman = "Muhasebe Departmanı";
        }

        if (hizmetliler.size() > maxCalisanDepartman) {
            maxCalisanDepartman = hizmetliler.size();
            maxDepartman = "Hizmetliler Departmanı";
        }

        if ((buroPersonelleri.size() + mudurler.size()) > maxCalisanDepartman) {
            maxCalisanDepartman = buroPersonelleri.size() + mudurler.size();
            maxDepartman = "Yönetim Departmanı";
        }

        System.out.println("En çok personelin bulunduğu departman: " + maxDepartman);
        System.out.println("Personel sayısı: " + maxCalisanDepartman);
    }


    private void departmanPersonelListesi() {
        Map<EnumDepartmanlar, List<Personel>> departmanlar = new HashMap<>();

        // Departmanlara göre personel listelerini oluşturma
        departmanlar.put(EnumDepartmanlar.IK, new ArrayList<>(ikPersonelleri));
        departmanlar.put(EnumDepartmanlar.TEKNIK, new ArrayList<>(teknikPersoneller));
        departmanlar.put(EnumDepartmanlar.MUHASEBE, new ArrayList<>(muhasebePersonelleri));
        departmanlar.put(EnumDepartmanlar.DESTEK, new ArrayList<>(hizmetliler));
        departmanlar.put(EnumDepartmanlar.YONETIM, new ArrayList<>(buroPersonelleri));
        departmanlar.put(EnumDepartmanlar.YONETIM, new ArrayList<>(mudurler));

        // Departmanlara göre personelleri listeleme
        for (Map.Entry<EnumDepartmanlar, List<Personel>> entry : departmanlar.entrySet()) {
            EnumDepartmanlar departman = entry.getKey();
            List<Personel> calisanlar = entry.getValue();

            System.out.println(departman + " çalışanları:");
            for (Personel calisan : calisanlar) {
                System.out.println(calisan.getIsim());
            }
            System.out.println();
        }
    }


    private void maasPersonelTanimla() {
        System.out.println("Maaş tanımlamak istediğiniz personelin idsini giriniz.");
        int personelId = scanner.nextInt();
        scanner.nextLine();
        Personel personel = personelListesi.get(personelId);
        System.out.println("Tanımlamak istediğiniz maaşı giriniz.");
        double maas = scanner.nextDouble();
        if (maas > 0) {
            personel.setMaas(maas);
        } else {
            System.out.println("Maaş bilgisiniz yanlış girdiniz.");
        }
    }

    private void odemeListesiGetir() {
        double odeme = 0;
        for (int i = 0; i < personelListesi.size(); i++) {
            double maas = personelListesi.get(i).getMaas();
            odeme += maas;
        }
        System.out.println("Bu dönem yapılacak ödeme " + odeme + " TL'dir.");
    }

    private void departmanListele() {
        for (int i = 0; i < personelListesi.size(); i++) {
            System.out.println("PERSONEL: " + personelListesi.get(i).getIsim() + " DEPARTMAN: " + personelListesi.get(i).getDepartman());
        }
    }

    private void departmanEkle() {
        System.out.println("Departman eklemek istediğiniz personelin idsini giriniz.");
        int personelId = scanner.nextInt();
        scanner.nextLine();
        Personel personel = personelListesi.get(personelId - 1);

        System.out.println("Departman ismini giriniz. (YONETIM, DESTEK, IK, MUHASEBE, TEKNIK)");
        String departman = scanner.nextLine();
        EnumDepartmanlar enumDepartman = EnumDepartmanlar.valueOf(departman.toUpperCase());

        if (enumDepartman != null) {
            personel.setDepartman(enumDepartman);
            Object departmanObjesi = null;

            switch (enumDepartman) {
                case YONETIM:
                    Personel yonetimPersoneli = new BuroPersoneli(personelListesi.get(personelId - 1).getIsim(), personelListesi.get(personelId - 1).getYas(), personelListesi.get(personelId - 1).getMaas());
                    personelListesi.add(yonetimPersoneli);
                    personelListesi.remove(personelId - 1);
                    yonetimPersoneli.setDepartman(EnumDepartmanlar.YONETIM);
                    break;
                case DESTEK:
                    Personel destekPersoneli = new Hizmetli(personelListesi.get(personelId - 1).getIsim(), personelListesi.get(personelId - 1).getYas(), personelListesi.get(personelId - 1).getMaas());
                    personelListesi.add(destekPersoneli);
                    personelListesi.remove(personelId - 1);
                    destekPersoneli.setDepartman(EnumDepartmanlar.DESTEK);

                    break;
                case IK:
                    Personel ikPersoneli = new InsanKaynaklariPersoneli(personelListesi.get(personelId - 1).getIsim(), personelListesi.get(personelId - 1).getYas(), personelListesi.get(personelId - 1).getMaas());
                    personelListesi.add(ikPersoneli);
                    personelListesi.remove(personelId - 1);
                    ikPersoneli.setDepartman(EnumDepartmanlar.IK);

                    break;
                case MUHASEBE:
                    Personel muhasebePersoneli = new MuhasebePersoneli(personelListesi.get(personelId - 1).getIsim(), personelListesi.get(personelId - 1).getYas(), personelListesi.get(personelId - 1).getMaas());
                    personelListesi.add(muhasebePersoneli);
                    personelListesi.remove(personelId - 1);
                    muhasebePersoneli.setDepartman(EnumDepartmanlar.MUHASEBE);

                    break;
                case TEKNIK:
                    Personel teknikPersoneli = new TeknikPersonel(personelListesi.get(personelId - 1).getIsim(), personelListesi.get(personelId - 1).getYas(), personelListesi.get(personelId - 1).getMaas());
                    personelListesi.add(teknikPersoneli);
                    personelListesi.remove(personelId - 1);
                    teknikPersoneli.setDepartman(EnumDepartmanlar.TEKNIK);
                    break;
            }
            System.out.println("Departman eklendi ve ilgili sınıftan bir örnek oluşturuldu.");
        } else {
            System.out.println("Yanlış bir departman ismi girdiniz.");
        }
    }

    private void personelDuzenle() {
        System.out.println("Düzeltmek istediğiniz personelin idsini giriniz.");
        int personelId = scanner.nextInt();
        scanner.nextLine();
        Personel personel = personelListesi.get(personelId - 1);
        System.out.println("Personelin yeni adını giriniz.");
        String isim = scanner.nextLine();
        personel.setIsim(isim);
        personelListesi.set(personelId - 1, personel);
    }

    private void personelListele() {
        for (int i = 0; i < personelListesi.size(); i++) {
            Personel personel = personelListesi.get(i);
            if (personel != null) {
                System.out.println(personel.getIsim() + " ID NO: " + personel.getPersonelId() + " Kayıt Tarihi: " + personel.getKayitTarihi() + " Departman: " + personel.getDepartman());
            } else {
                break;
            }
        }
    }

    private void personelEkle() {

        System.out.println("Eklemek istediğiniz personelin adını girin");
        String isim = scanner.nextLine();
        System.out.println("Eklemek istediğiniz personelin yaşını girin");
        int yas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Eklemek istediğiniz personelin maaşını girin");
        double maas = scanner.nextDouble();
        Personel personel = new Personel(isim, yas, maas);
        personelListesi.add(personel);
    }

    public void save(Personel personel) {
        if(personel.getIsim().isEmpty()){
            throw new PTSExceptions(MesajTipleri.EKLEME_YAPILAMADI);
        }else {
            personelListesi.add(personel);
        }
    }

    public void update(int index, Personel updatedPersonel) {
        if (index < 0 || index >= personelListesi.size()) {
            throw new PTSExceptions(MesajTipleri.GUNECELLEME_YAPILAMADI);
        }
        personelListesi.set(index, updatedPersonel);
    }

    public void delete(int index) {
        if (index < 0 || index >= personelListesi.size()) {
            throw new IndexOutOfBoundsException("Geçersiz indeks: " + index);
        }
        personelListesi.remove(index);
    }

    public void findAll() {
        System.out.println("Bütün personelleri listele");
        for (int i = 0; i < personelListesi.size(); i++) {
            System.out.println(personelListesi.get(i).getIsim());
        }

    }

    public void findById() {
        System.out.println("Bulmak istediğiniz personelin ID'sini giriniz.");
        int personelId = scanner.nextInt();
        scanner.nextLine();
        if (personelListesi.get(personelId).getIsim().isEmpty()) {
            throw new PTSExceptions(MesajTipleri.ARANAN_BULUNAMADI);
        } else {
            Personel personel = personelListesi.get(personelId);
            System.out.println(personel.getPersonelId() + " idsi " + personel.getIsim() + " isimli personele ait.");
        }
    }

    public void deleteById() {
        System.out.println("Silmek istediğiniz personelin ID'sini giriniz.");
        int personelId = scanner.nextInt();
        scanner.nextLine();
        Personel personel = personelListesi.get(personelId);
        personelListesi.remove(personelId);
    }
}
