import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RendszerTest {

    @Test
    void hozzaad() {
        Rendszer rendszer = new Rendszer();
        System.out.println("--- Teszt indítása: Hozzáadási megszorítások ellenőrzése ---");


        System.out.print("1. Teszt: Null objektum elutasítása... ");
        assertThrows(IllegalArgumentException.class, () -> {
            rendszer.hozzaad(null);
        });
        System.out.println("SIKER (Hiba elkapva: Az esemény nem lehet null!)");


        System.out.print("2. Teszt: Üres név elutasítása... ");
        Esemenyek uresNevu = new Esemenyek("", "Labor", new Date());
        assertThrows(IllegalArgumentException.class, () -> {
            rendszer.hozzaad(uresNevu);
        });
        System.out.println("SIKER (Hiba elkapva: Az esemény neve nem lehet üres!)");


        System.out.print("3. Teszt: Érvényes esemény rögzítése... ");
        Esemenyek joEsemeny = new Esemenyek("Szakmai vizsga", "Aula", new Date());
        rendszer.hozzaad(joEsemeny);
        assertEquals(1, rendszer.getMindenEsemeny().size());
        System.out.println("SIKER (Esemény rögzítve: " + joEsemeny.getNev() + ")");
    }

    @Test
    void keresNevAlapjan() {
        Rendszer rendszer = new Rendszer();
        rendszer.hozzaad(new Esemenyek("Adatbázis vizsga", "Terem 1", new Date()));

        System.out.println("\n--- Teszt indítása: Keresési logika ellenőrzése ---");


        System.out.print("Keresés tesztelése: 'Adatbázis' kifejezésre... ");
        List<Esemenyek> talalatok = rendszer.keresNevAlapjan("Adatbázis");
        assertFalse(talalatok.isEmpty());
        System.out.println("SIKER (Találatok száma: " + talalatok.size() + ")");


        System.out.print("Keresés tesztelése: Nem létező eseményre... ");
        List<Esemenyek> nincsTalalat = rendszer.keresNevAlapjan("Matematika");
        assertTrue(nincsTalalat.isEmpty());
        System.out.println("SIKER (A lista üres maradt, ahogy várható volt)");
    }
}