//Vkljucimo paket za delo z I/O napravami
import java.io.*;
//Vkljucimo paket za delo s pripomocki
import java.util.*;
//uvozimo paket Swing
import javax.swing.*;
//uvozimo knjiznico za delo z dogodki
import java.awt.event.*;
//uvozimo paket za delo s tabelami
import javax.swing.table.*;

// deklariramo javni razred, ki implementira vmesnik ActionListener
public class PocistiMizo implements ActionListener {


    //deklariramo staticno lastnost za vnos iz konzole
    private static BufferedReader in;
    private static BufferedReader in2;
    //deklariramo staticen seznam
    private static ArrayList<Miza> pocisceneMize;
    //definiramo atribute in lastnosti za GUI
    private JFrame okno;
    private JPanel povrsina;
    private JLabel besedilo;
    private JButton gumb;
    private JTextField polje;
    private JTable tabela;
    private DefaultTableModel modelTabele;
    private JRadioButton radio;
    private String[] moznosti;
    private SpinnerListModel spinnerModel;
    private JSpinner spinner;

    // Definiramo glavno metodo
    public static void main(String[] args) {
        //inicializacija lastnosti
        in = new BufferedReader(new InputStreamReader(System.in));
        int kolicinaStvariNaMizi = 0;
        pocisceneMize = new ArrayList<Miza>();
        String kolicinaNaMizi2 = "";
        //poskusimo vprasati, koliko stvari je na mizi
        try {
            System.out.println("Vnesite stevilo stvari na mizi: ");
            kolicinaStvariNaMizi = Integer.parseInt(in.readLine());
        }
        //ce bi bila sporocena izjema
        catch(Exception e) {
            System.err.println("Napaka: " + e);
        }

        //deklariramo in zazenemo GUI
        PocistiMizo gui = new PocistiMizo("Cistilec Miz");
        //deklariramo in inicializiramo nova objekta tipa Miza
        Miza mizaPrt = new Miza(true,kolicinaStvariNaMizi);
        Miza mizaNoPrt = new Miza(false,5);

        //nov objekt podrazreda PisarniskaMiza
        PisarniskaMiza mizaPisarna = new PisarniskaMiza(false,3,true);
        //nov objekt podrazreda KuhinjskaMiza
        KuhinjskaMiza mizaKuhinja = new KuhinjskaMiza(true,3,true);

        //MIZA S PRTOM
        try {
            //za mizo s prtom izpisemo kolicino stvari na mizi
            System.out.print("Na mizi s prtom je ");
            System.out.println(mizaPrt.getKolicinaStvari() + " stvari.");
            //sporocilo uporabniku, da se je ciscenje zacelo
            System.out.println("Pri�enjam s �i��enjem...");
            //izpraznimo mizo stvari
            mizaPrt.izprazniMizo(mizaPrt.getKolicinaStvari());
            //snamemo prt
            mizaPrt.togglePrt(mizaPrt.getPrt());
            //pocistimo prazno mizo
            mizaPrt.pocisti();
            //sporocilo uporabniku, da je miza cista
            System.out.println("Miza je �ista.");
        }
        catch(Exception e) {
            System.err.println("Napaka: " + e);
        }




        //MIZA BREZ PRTA
        try {
            System.out.println("---------------------------------------------");
            //za mizo brez prta izpisemo kolicino stvari na mizi
            System.out.print("Na mizi brez prta je ");
            System.out.println(mizaNoPrt.getKolicinaStvari() + " stvari.");
            //sporocilo uporabniku, da se je ciscenje zacelo
            System.out.println("Pri�enjam s �i��enjem...");
            //izpraznimo mizo stvari
            mizaNoPrt.izprazniMizo(mizaNoPrt.getKolicinaStvari());
            //pocistimo prazno mizo
            mizaNoPrt.pocisti();
            //sporocilo uporabniku, da je miza cista
            System.out.println("Miza je �ista.");
            //na mizo postavimo prt
            mizaNoPrt.togglePrt(mizaNoPrt.getPrt());
        }
        catch(Exception e) {
            System.err.println("Napaka: " + e);
        }

        //PISARNISKA MIZA
        try {
            System.out.println("---------------------------------------------");
            //za pisarnisko mizo izpisemo kolicino stvari na mizi
            System.out.print("Na pisarniski mizi je ");
            System.out.println(mizaPisarna.getKolicinaStvari() + " stvari.");
            //sporocilo uporabniku, da se je ciscenje zacelo
            System.out.println("Pricenjam s ciscenjem...");
            //izpraznimo mizo stvari
            mizaPisarna.izprazniMizo(mizaPisarna.getKolicinaStvari());
            //pocistimo prazno mizo
            mizaPisarna.pocisti();
            //sporocilo uporabniku, da je miza cista
            System.out.println("Miza je �ista.");
        }
        catch(Exception e) {
            System.err.println("Napaka: " + e);
        }

        //KUHINJSKA MIZA
        try {
        System.out.println("---------------------------------------------");
        //za kuhinjsko mizo izpisemo kolicino stvari na mizi
        System.out.print("Na kuhinjski mizi je ");
        System.out.println(mizaKuhinja.getKolicinaStvari() + " stvari.");
        //sporocilo uporabniku, da se je ciscenje zacelo
        System.out.println("Pricenjam s ciscenjem...");
        //izpraznimo mizo stvari
        mizaKuhinja.izprazniMizo(mizaKuhinja.getKolicinaStvari());
        //snamemo prt
        mizaKuhinja.togglePrt(mizaKuhinja.getPrt());
        //pocistimo prazno mizo
        mizaKuhinja.pocisti();
        //sporocilo uporabniku, da je miza cista
        System.out.println("Miza je cista.");
        }
        catch(Exception e) {
            System.err.println("Napaka: " + e);
        }

        //dodamo mize na seznam
        pocisceneMize.add(mizaPrt);
        pocisceneMize.add(mizaNoPrt);
        pocisceneMize.add(mizaPisarna);
        pocisceneMize.add(mizaKuhinja);

        //izpisemo seznam pociscenih miz
        for(int c=0; c<4; c++) {
            try {
                System.out.println(c + ". pociscena miza je bila " + pocisceneMize.get(c).getClass().getName() + ".");
            }
            catch(Exception e) {
                System.err.println("Napaka: " + e);
            }
        }



        // //VAJA 33
        // //neskoncna zanka, ki ustavi v primeru praznega vnosa
        // while(true) {
        //     //poskusimo dodati novo mizo na seznam pociscenih
        //     try {
        //         System.out.println("Dodajam novo mizo na seznam. Koliko stvari je na tej mizi? ");
        //         //nov uporabniski vnos
        //         in2 = new BufferedReader(new InputStreamReader(System.in));
        //         kolicinaNaMizi2 = in2.readLine();
        //         //ce je vnos prazen
        //         if(kolicinaNaMizi2.equals("") || kolicinaNaMizi2.equals(" ")) {
        //             //ustavi zanko
        //             break;
        //         }
        //         //dodaj nov objekt na seznam
        //         pocisceneMize.add(new Miza(true,Integer.parseInt(kolicinaNaMizi2)));

        //     }
        //     //ujamemo napako
        //     catch(Exception e) {
        //         System.err.println("Napaka: " + e);
        //     }

        // }


    }


    //Konstruktor
    public PocistiMizo(String naslov) {
        //inicializiramo okno
        okno = new JFrame(naslov);
        //ustvarimo povrsino
        povrsina = new JPanel();
        //ustvarimo okence z besedilom
        besedilo = new JLabel("Koliko stvari je na mizi?");
        //ustvarimo gumb
        gumb = new JButton("Klikni");
        //gumbu dolocimo poslusalca dogodkov
        gumb.addActionListener(this);
        //ustvarimo vnosno polje
        polje = new JTextField(10);
        //ustvarimo model tabele
        modelTabele = new DefaultTableModel();
        //modelu tabele dodamo stolpec
        modelTabele.addColumn("Vrsta mize");
        //modelu tabele dodamo stolpec
        modelTabele.addColumn("Ima prt?");
        //modelu tabele dodamo stolpec
        modelTabele.addColumn("Kolicina stvari na mizi");
        // //dodamo vrstico v model tabele
        modelTabele.addRow(new Object[]{"Vrsta mize","Ima prt?","St. stvari na mizi"});
        //ustvarimo tabelo na podlagi modela
        tabela = new JTable(modelTabele);
        
        //dolocimo vrednosti radio gumba
        radio = new JRadioButton("Prt");
        //dolocimo vrednosti spinner gumba
        moznosti = new String[]{"Miza","KuhinjskaMiza","PisarniskaMiza"};
        spinnerModel = new SpinnerListModel(moznosti);
        spinner = new JSpinner(spinnerModel);


        //dodamo okence na povrsino
        povrsina.add(besedilo);
        //dodamo vnosno polje na povrsino
        povrsina.add(polje);
        //dodamo radio gumb na povrsino
        povrsina.add(radio);
        //dodamo spinner gumb na povrsino
        povrsina.add(spinner);
        //dodamo gumb na povrsino
        povrsina.add(gumb);
        //dodamo tabelo na povrsino
        povrsina.add(tabela);

        //dodamo povrsino v okno
        okno.add(povrsina);
        //metoda, ki okno prikaze
        okno.setVisible(true);
        //nastavimo velikost okna
        okno.setSize(800,600);
        //Nasstavimo delovanje, da se ob zapiranju okna ustavi izvajanje aplikacije
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //implementiramo metodo, ki jo predpisuje vmesnik
    public void actionPerformed(ActionEvent e) {
        // //Pripravimo seznam objektov (lokalna) za vnos vrstice z uporabniskimi vrednostmi
        Object[] vrstica = new Object[]{spinner.getValue(), radio.isSelected(),Integer.parseInt(polje.getText())};
        
        //ce je spinner gumb izbral Miza
        if(spinner.getValue() == "Miza") {
            //nov objekt tipa Miza
            Miza m = new Miza(radio.isSelected(),Integer.parseInt(polje.getText()));
            //dodaj na seznam pociscenih
            pocisceneMize.add(m);
        //ce je spinner gumb izbral PisarniskaMiza
        } else if(spinner.getValue() == "PisarniskaMiza") {
            //nov objekt tipa Pisarniska miza
            PisarniskaMiza m = new PisarniskaMiza(radio.isSelected(),Integer.parseInt(polje.getText()),false);
            //dodaj na seznam pociscenih
            pocisceneMize.add(m);
        //ce je spinner gumb izbral KuhinjskaMiza
        } else if(spinner.getValue() == "KuhinjskaMiza") {
            //nov objekt tipa Kuhinjska miza
            KuhinjskaMiza m = new KuhinjskaMiza(radio.isSelected(),Integer.parseInt(polje.getText()),false);
            //dodaj na seznam pociscenih
            pocisceneMize.add(m);
        }
        // //dodamo vrstico v model tabele
        modelTabele.addRow(vrstica);

        // //Pocistimo vnosno polje
        polje.setText("");

        //izpisemo seznam pociscenih miz
        for(int c=0; c<pocisceneMize.size(); c++) {
            //poskusimo izpisati podatke o kolicini stvari na vsakem elementu iz seznama
            try {
                System.out.println(c + ". pociscena miza je imela " + pocisceneMize.get(c).getKolicinaStvari() + " stvari.");
            }
            //ujamemo napako
            catch(Exception f) {
                System.err.println(c + ". pociscena miza nima vec stvari.");
            }
        }

    }
}//konec