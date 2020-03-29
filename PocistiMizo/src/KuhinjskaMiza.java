//Deklaracija razreda, ki razsiri razred Miza
public class KuhinjskaMiza extends Miza {
    //deklaracija novih lastnosti
    private boolean imaVazo;

    //deklaracija konstruktorja
    //Vhod: je vaza na mizi ali ne
    public KuhinjskaMiza(boolean p, int k, boolean  v) {
        //konstruktor nadrazreda
        super(p,k);

        //ostale lastnosti
        imaVazo = v;
    }


}