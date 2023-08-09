package org.example.Soru2;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {
    List<Personel> personelListesi = new ArrayList<>();

    public void streamAPI() {

        Scanner scanner = new Scanner(System.in);
        personelListesi.add(new Personel("Ahmet", 30));
        personelListesi.add(new Personel("Ayşe", 25));
        personelListesi.add(new Personel("Mehmet", 35));
        personelListesi.add(new Personel("Fatma", 28));
        personelListesi.add(new Personel("Ali", 32));
        personelListesi.add(new Personel("Zeynep", 29));
        personelListesi.add(new Personel("Mustafa", 40));
        personelListesi.add(new Personel("Esra", 27));
        personelListesi.add(new Personel("Ömer", 33));
        personelListesi.add(new Personel("Gül", 26));
        personelListesi.add(new Personel("Hakan", 31));
        personelListesi.add(new Personel("Elif", 24));
        personelListesi.add(new Personel("Serkan", 38));
        personelListesi.add(new Personel("Deniz", 23));
        personelListesi.add(new Personel("Sevgi", 30));
        personelListesi.add(new Personel("Murat", 37));
        personelListesi.add(new Personel("Selin", 22));
        personelListesi.add(new Personel("Cem", 29));
        personelListesi.add(new Personel("Pınar", 36));
        personelListesi.add(new Personel("Emre", 27));

        int secenek;

        do {
            System.out.println("1. Yaşı 30'dan büyük olan personellerin sayısını bulunuz.");
            System.out.println("2. İsimleri 'A' harfiyle başlayan personellerin sayısı");
            System.out.println("3. Yaşı en büyük olan personelin adı");
            System.out.println("4. İsmi 'Ali' olan personelin yaşı");
            System.out.println("5. Yaşı en küçük olan 3 personelin isimleri");
            System.out.println("6. Yaşı 25 ile 35 arasında olan personellerin sayısı");
            System.out.println("7. İsimleri 4 harften uzun olan personellerin isimleri");
            System.out.println("8. Yaşı en büyük 2 personelin isimleri");
            System.out.println("9. İsimleri 'a' harfi ile biten personellerin isimleri, büyük harf dönüşümü yapılarak");
            System.out.println("10. İsimlerin uzunluğunun ortalaması kaçtır?");
            System.out.println("11. İsmi en uzun olan personelin yaşı kaçtır?");
            System.out.println("12. İsimlerin herhangi biri 'ahmet' mi? (boolean dönüş yapmalı)");
            System.out.println("13. İsimleri ters çevirilmiş olarak alfabetik olarak sıralanmış bir liste oluşturun.");
            System.out.println("14. İsimlerinde 'e' harfi geçen personellerin isimlerini bir listeye ekleyin.");
            System.out.println("15. Yaşı en küçük olan personelin adı ve yaşını bir Map olarak döndürün.");
            System.out.println("Çıkış Yapmak için '0' tuşlayınız.");
            System.out.print("Seçiminizi yapın: ");
            secenek = scanner.nextInt();

            switch (secenek) {
                case 1:
                    yasi30danBuyukOlanlar();
                    break;
                case 2:
                    aharfiyleBaslayanlar();
                    break;
                case 3:
                    yasiEnBuyuk();
                    break;
                case 4:
                    ismiAliOlan();
                    break;
                case 5:
                    yasiEnKucuk3personel();
                    break;
                case 6:
                    yasi25ile35ArasındaOlanlar();
                    break;
                case 7:
                    isimleri4HarftenUzunOlanlar();
                    break;
                case 8:
                    yasiEnBuyuk2Personel();
                    break;
                case 9:
                    isimleriAileBitenler();
                    break;
                case 10:
                    isimUzunlukOrtalamasi();
                    break;
                case 11:
                    ismiEnUzunOlanPersonelinaYasi();
                    break;
                case 12:
                    ahmetVarMi();
                    break;
                case 13:
                    isimleriTersSiraliListe();
                    break;
                case 14:
                    isimlerindeEOlanPersonelListesi();
                    break;
                case 15:
                    yasiEnKucukolanPersonelMapi();
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

    private void yasiEnKucukolanPersonelMapi() {

            Optional<Personel> enKucukYasli = personelListesi.stream()
                    .min(Comparator.comparingInt(Personel::getYas));

            enKucukYasli.ifPresent(x -> {
                Map<String, Integer> map = new HashMap<>();
                map.put(x.getIsim(), x.getYas());
                System.out.println(map);
            });
    }

    private void isimlerindeEOlanPersonelListesi() {
        List<Personel> eOlanPersoneller = personelListesi.stream().filter(x->x.getIsim().toLowerCase().contains("e")).collect(Collectors.toList());
        eOlanPersoneller.stream().forEach(x-> System.out.println(x.getIsim()));
    }

    private void isimleriTersSiraliListe() {
        List<String> tersIsimlerAlfabetik = personelListesi.stream()
                .map(personel -> new StringBuilder(personel.getIsim()).reverse().toString())
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());

        tersIsimlerAlfabetik.forEach(System.out::println);
    }

    private void ahmetVarMi() {
        System.out.println(personelListesi.stream().filter(x -> x.getIsim().equalsIgnoreCase("ahmet")).findAny().isPresent());
    }

    private void ismiEnUzunOlanPersonelinaYasi() {
        OptionalInt enUzunIsimYas = OptionalInt.of(personelListesi.stream()
                .max(Comparator.comparingInt(personel -> personel.getIsim().length()))
                .map(Personel::getYas)
                .orElse(0));

        System.out.println("İsmi en uzun olan personelin yaşı: " + enUzunIsimYas.getAsInt());
    }

    private void isimUzunlukOrtalamasi() {
        double ortalamaUzunluk = personelListesi.stream()
                .collect(Collectors.averagingDouble(personel -> personel.getIsim().length()));

        System.out.println("İsimlerin uzunluğunun ortalaması: " + ortalamaUzunluk);
    }

    private void isimleriAileBitenler() {
        personelListesi.stream()
                .filter(personel -> personel.getIsim().toLowerCase().endsWith("a"))
                .map(personel -> personel.getIsim())
                .forEach(System.out::println);
    }

    private void yasiEnBuyuk2Personel() {
        List<String> enBuyukYasliPersonelIsimleri = personelListesi.stream()
                .sorted(Comparator.comparingInt(Personel::getYas).reversed())
                .limit(2)
                .map(Personel::getIsim)
                .collect(Collectors.toList());

        System.out.println("Yaşı en büyük 2 personel: " + enBuyukYasliPersonelIsimleri);
    }

    private void isimleri4HarftenUzunOlanlar() {
        personelListesi.stream().filter(x -> x.getIsim().length() > 4).forEach(x -> System.out.println(x.getIsim()));
    }

    private void yasi25ile35ArasındaOlanlar() {
        List<Personel> yas25ile35arasi = personelListesi.stream().filter(x -> x.getYas() > 25 || x.getYas() < 35).collect(Collectors.toList());
        System.out.println("Yaşı 25 ile 35 işletme arasında olan " + yas25ile35arasi.size() + " personel var.");
    }

    private void yasiEnKucuk3personel() {
        List<String> enKucukYasliPersonelIsimleri = personelListesi.stream()
                .sorted(Comparator.comparingInt(Personel::getYas))
                .limit(3)
                .map(Personel::getIsim)
                .collect(Collectors.toList());

        System.out.println("Yaşı en küçük 3 personel: " + enKucukYasliPersonelIsimleri);
    }

    private void ismiAliOlan() {
        personelListesi.stream().filter(x -> x.getIsim().equals("Ali")).forEach(x -> System.out.println(x.getYas()));
    }

    private void yasiEnBuyuk() {
        Optional<Personel> enBuyukYasliPersonel = personelListesi.stream()
                .max(Comparator.comparingInt(Personel::getYas));

        if (enBuyukYasliPersonel.isPresent()) {
            Personel personel = enBuyukYasliPersonel.get();
            System.out.println("En büyük yaşlı personel: " + personel);
        } else {
            System.out.println("Personel listesi boş.");
        }
    }

    private void aharfiyleBaslayanlar() {
        personelListesi.stream().filter(x -> x.getIsim().startsWith("A")).forEach(System.out::println);
    }

    private void yasi30danBuyukOlanlar() {
        personelListesi.stream().filter(x -> x.getYas() > 30).forEach(System.out::println);
    }
}
