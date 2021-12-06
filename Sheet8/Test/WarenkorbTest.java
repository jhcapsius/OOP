public class WarenkorbTest {
    public static void main(String[] args) {
        Warenkorb warenkorb = new Warenkorb();
        warenkorb.addItem(new Buch("Timothy Zahn", "Erben des Imperiums", 1991, 100001, 15));
        warenkorb.addItem(new Buch("Timothy Zahn", "Star Wars: Die dunkle Seite der Macht", 1992, 100002, 20));
        warenkorb.addItem(new Buch("Timothy Zahn", "Das letzte Kommando", 1993, 100003, 25));
        warenkorb.addItem(new DVD("Star Wars: Episode IV - Eine neue Hoffnung", 121, 200001, 30));
        warenkorb.addItem(new DVD("Star Wars: Episode V - Das Imperium schlägt zurück", 124, 200002, 28));
        warenkorb.addItem(new DVD("Star Wars: Episode VI - Die Rückkehr der Jedi-Ritter", 131, 200003, 29));
        warenkorb.addItem(new Kleidung("T-Shirt", "blau", "M", 300003, 10));
        warenkorb.printContent();
        warenkorb.printTotalPrice();
    }
    
}
