public class Artikel {
    private int artikelNummer;
    private double nettoPreis;

    Artikel(int artikelNummer, double nettoPreis){
        this.artikelNummer = artikelNummer;
        this.nettoPreis = nettoPreis;
    }

    public double getPreis(){
        return this.nettoPreis;
    }

    public int getArtikelNummer(){
        return this.artikelNummer;
    }

    public String getInfo(){
        return this.artikelNummer + " : " + String.format("%.2f", this.nettoPreis) + " Euro";
    }
    
}
