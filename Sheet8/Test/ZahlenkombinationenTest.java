public class ZahlenkombinationenTest {
    public static void main(String[] args) {
        Zahlenkombinationen zahlenkombinationen = new Zahlenkombinationen();
        zahlenkombinationen.initArray(7, 4, 2);
        zahlenkombinationen.printArr();
        zahlenkombinationen.loeschen();
        zahlenkombinationen.printHorizontal();
        zahlenkombinationen.printVertical();
        zahlenkombinationen.printDiagonal();
    }
}
