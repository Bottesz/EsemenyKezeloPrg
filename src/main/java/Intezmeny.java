import java.util.Date;

public class Intezmeny extends Esemenyek {
    public Intezmeny(String nev, String hely, java.util.Date ido){
        super(nev,hely,ido);
    }

    public void esemenyKezeles(){
        System.out.println("Intézményi adminisztráció: Adatok előkészítése megjelenítésre");
    }

    @Override
    public String toString(){
        return "****************************************\n" +
                " INTÉZMÉNYI ESEMÉNY ÉRTESÍTŐ\n" +
                "****************************************\n" +
                " Megnevezés: " + getNev() + "\n" +
                " Helyszín:   " + getHely() + "\n" +
                " Időpont:    " + getIdo() + "\n" +
                "****************************************";
    }
}