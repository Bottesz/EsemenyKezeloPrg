import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Esemenyek {
    private final Date ido;
    private final String hely;
    private final String nev;

    public List<Esemenyek> EsemenyekLista = new ArrayList<>();

    public Esemenyek(String nev, String hely, Date ido) {
        this.ido = ido;
        this.hely = hely;
        this.nev = nev;
    }

    public void esemenyekLetrehoz(){
        System.out.println("valamilyen esemeny");
    }

    public void add(Esemenyek esemeny){
        this.EsemenyekLista.add(esemeny);
    }

    public Date getIdo() {
        return ido;
    }

    public String getHely() {
        return hely;
    }

    public String getNev() {
        return nev;
    }




    public List<Esemenyek> getEsemenyekLista() {
        return EsemenyekLista;
    }
}

