import java.util.ArrayList;

public class Warenkorb {
    private ArrayList<Artikel> artikelListe = new ArrayList<>();
    private double totalPrice;

    public void addItem(Artikel artikel){
        this.artikelListe.add(artikel);
    }

    public void removeItem(int artikelNummer){
        for(int i = 0; i < this.artikelListe.size(); i++){
            if(this.artikelListe.get(i).getArtikelNummer() == artikelNummer){
                this.artikelListe.remove(i);
                i = this.artikelListe.size();
            }
        }
    }

    public void printContent(){
        for(Artikel artikel : artikelListe){
            System.out.println(artikel.toString() + artikel.getInfo());
        }
    }

    public void printTotalPrice(){
        if(this.totalPrice != 0){
            this.totalPrice = 0;
        }
        for (Artikel artikel : artikelListe) {
            totalPrice += artikel.getPreis();
        }
        System.out.printf("Gesamtpreis: %.2f Euro", totalPrice);
    } 
    
}
