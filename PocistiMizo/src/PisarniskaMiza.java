//Deklaracija razreda, ki razsiri razred Miza
public class PisarniskaMiza extends Miza {
    //deklaracija novih lastnosti
    private boolean imaRacunalnik;

    //deklaracija konstruktorja
    //Vhod: je racunalnik na mizi ali ne
    public PisarniskaMiza(boolean p, int k, boolean  r) {
        //konstruktor nadrazreda
        super(p,k);

        //ostale lastnosti
        imaRacunalnik = r;
    }
}