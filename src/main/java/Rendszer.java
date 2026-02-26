import java.util.ArrayList;
import java.util.List;


public class Rendszer {


    private List<Esemenyek> esemenyLista = new ArrayList<>();


    public void hozzaad(Esemenyek e) {
        if (e == null) {
            throw new IllegalArgumentException("Az esemény nem lehet null!");
        }
        if (e.getNev() == null || e.getNev().isEmpty()) {
            throw new IllegalArgumentException("Az esemény neve nem lehet üres!");
        }
        esemenyLista.add(e);
    }


    public void esemenyekListazasa() {
        System.out.println("A rendszer összes eseményének listázása");
        for (Esemenyek e : esemenyLista) {

            System.out.println("- " + e.getNev() + "Helyszín: " + e.getHely());
        }
    }


    public List<Esemenyek> keresNevAlapjan(String keresettNev) {
        List<Esemenyek> talalatok = new ArrayList<>();
        for (Esemenyek e : esemenyLista) {
            if (e.getNev().toLowerCase().contains(keresettNev.toLowerCase())) {
                talalatok.add(e);
            }
        }
        return talalatok;
    }

    // 2. Lekérdezési szempont: Keresés helyszín alapján
    public List<Esemenyek> keresHelyAlapjan(String keresettHely) {
        List<Esemenyek> talalatok = new ArrayList<>();
        for (Esemenyek e : esemenyLista) {
            if (e.getHely().contains(keresettHely)) {
                talalatok.add(e);
            }
        }
        return talalatok;
    }


    public List<Esemenyek> getMindenEsemeny() {
        return esemenyLista;
    }
}