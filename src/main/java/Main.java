import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Rendszer rendszer = new Rendszer();


        Esemenyek dolgozat = new Esemenyek("Adatbázis dolgozat", "Ákk 2-es terem", new Date());
        Esemenyek vizsga = new Esemenyek("Szakmai vizsga", "Számalk Szalézi Technikum", new Date());
        Esemenyek konferencia = new Esemenyek("Informatikai konferencia", "Aula", new Date());

        rendszer.hozzaad(dolgozat);
        rendszer.hozzaad(vizsga);
        rendszer.hozzaad(konferencia);

        rendszer.esemenyekListazasa();



        String keresettSzo = "vizsga";
        List<Esemenyek> talalatok = rendszer.keresNevAlapjan(keresettSzo);

        System.out.println("Keresés erre: '" + keresettSzo + "'");
        for (Esemenyek e : talalatok) {
            System.out.println("Találat: " + e.getNev());
        }


        System.out.println("\nMEGJELENÍTÉS INTÉZMÉNY SZERINT");



        if (!talalatok.isEmpty()) {
            Esemenyek elsoTalalat = talalatok.get(0);


            Intezmeny intezmenyView = new Intezmeny(
                    elsoTalalat.getNev(),
                    elsoTalalat.getHely(),
                    elsoTalalat.getIdo()
            );

            System.out.println(intezmenyView.toString());
        }
    }
}