import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RendszerTest {

    @Test
    void hozzaad() {
        Rendszer rendszer = new Rendszer();


        Esemenyek vizsga = new Esemenyek("Matek vizsga", "Labor", new Date());
        rendszer.hozzaad(vizsga);
        assertEquals(1, rendszer.getMindenEsemeny().size(), "Az eseményt sikeresen hozzá kellene adni a listához.");


        assertThrows(IllegalArgumentException.class, () -> {
            rendszer.hozzaad(null);
        }, "Null érték esetén hibát kellene dobni!");


        Esemenyek uresEsemeny = new Esemenyek("", "Helyszín", new Date());
        assertThrows(IllegalArgumentException.class, () -> {
            rendszer.hozzaad(uresEsemeny);
        }, "Üres név esetén hibát kellene dobni!");
    }

    @Test
    void keresNevAlapjan() {
        Rendszer rendszer = new Rendszer();
        Esemenyek e1 = new Esemenyek("Adatbázis vizsga", "Terem 1", new Date());
        Esemenyek e2 = new Esemenyek("Szoftver tesztelés", "Terem 2", new Date());

        rendszer.hozzaad(e1);
        rendszer.hozzaad(e2);


        List<Esemenyek> talalatok = rendszer.keresNevAlapjan("Adatbázis");
        assertFalse(talalatok.isEmpty(), "Kellene lennie találatnak az 'Adatbázis' szóra.");
        assertEquals("Adatbázis vizsga", talalatok.get(0).getNev());


        List<Esemenyek> uresTalalat = rendszer.keresNevAlapjan("Történelem");
        assertTrue(uresTalalat.isEmpty(), "Nem szabadna találatnak lennie egy nem létező eseményre.");
    }
}