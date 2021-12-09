public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();

        //Test invalid move
        ticTacToe.macheZug(3, 3);

        //Test print empty field at start
        ticTacToe.zeigeSpielfeld();

        //Test set X at position (2,2)
        ticTacToe.macheZug(2, 2);
        ticTacToe.zeigeSpielfeld();

        //Test set O at position(2,0)
        ticTacToe.macheZug(2, 0);
        ticTacToe.zeigeSpielfeld();

        //Test cell already occupied
        ticTacToe.macheZug(2, 0);

        //Test reset field
        ticTacToe.reset();
        ticTacToe.zeigeSpielfeld();
    }
}
