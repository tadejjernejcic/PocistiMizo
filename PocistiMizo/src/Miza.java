//Deklaracija razreda Miza
public class Miza {
    //Inicializacija spremenljivk
    private boolean jePolna;
    private boolean jeUmazana;
    private int kolicinaStvariNaMizi;
    private boolean jePrt;

    //konstruktor objekta Miza
    public Miza(boolean p, int k) {
        //Dolocimo spremenljivke
        jePolna = true;
        jeUmazana = true;
        kolicinaStvariNaMizi = k;
        jePrt = p;
    }
    //Metoda, ki vrne kolicino stvari na mizi
    public int getKolicinaStvari() throws Exception {
        //vrze izjemo, ce na mizi ni stvari
        if(kolicinaStvariNaMizi<=0) {
            throw new Exception("Na mizi ni stvari.");
        }
        return kolicinaStvariNaMizi;
    }
    //Metoda, ki vrne stanje prta
    public boolean getPrt() {
        return jePrt;
    }

    //Metoda, ki pobere vse stvari iz mize in jo sprazni
    public boolean izprazniMizo(int ks) throws Exception {
        //ce je polna
        if(jePolna) {
            //vrze izjemo, ce na mizi ni stvari
            if(kolicinaStvariNaMizi<=0) {
                throw new Exception("Na mizi ni stvari.");
            }
            //zanka, ki z vsako iteracijo odstrani 1 stvar iz mize
            for(int i = 0; i < ks; i++) {
                //sporocilo uporabniku
                System.out.println("Pobiram 1 stvar iz mize.");
                kolicinaStvariNaMizi -= 1;
            }
            //sporocilo uporabniku
            System.out.println("Miza je prazna.");
            //vrne prazno mizo
            jePolna = false;
            return jePolna;
        //ce ni polna
        } else {
            //sporocilo uporabniku
            System.out.println("Miza je prazna.");
            //vrne prazno mizo
            return jePolna;
        }
    }

    //Metoda, ki sname oz. na mizo postavi prt (toggle)
    public boolean togglePrt(boolean p) {
        //ce je na mizi prt
        if(p) {
            //sporocilo uporabniku, da snemamo prt
            System.out.println("Snemam prt z mize.");
        //ce ni na mizi prta
        } else {
            //sporocilo uporabniku, da postavljamo na mizo prt
            System.out.println("Na mizo postavljam prt.");
        }
        //vrne obratno stanje prta
        return jePrt != p;
    }

    //Metoda, ki pocisti mizo
    public boolean pocisti() {
        //sporocilo uporabniku
        System.out.println("Čistim mizo.");
        //miza ni umazana
        return jeUmazana = false;
    }
}