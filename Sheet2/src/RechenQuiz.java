/**
 * The program generates random operands and operators and creates a calculation task from them. If the result of the
 * calculation task is negative or zero, new operands and operators are generated until the result is greater than or
 * equal to one.
 *
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class RechenQuiz {
    private int result;

    /**
     * The method first sets the bounds for the operands and the operator. Then a randomly generated number is assigned
     * to the operand and operator. Depending on which number was assigned to the operator, an addition, division,
     * multiplication or division. If the result is invalid, the procedure is repeated.
     */
    public void getExercise() {
        int minOperands = 1;
        int maxOperands = 20;
        int minOperator = 1;
        int maxOperator = 4;
        int rdmOp1;
        int rdmOp2;
        int rdmOperator;
        do {
            //randomly generated number between 1-20
            rdmOp1 = (int) (Math.random() * (maxOperands - minOperands + 1) + minOperands);
            rdmOp2 = (int) (Math.random() * (maxOperands - minOperands + 1) + minOperands);

            //randomly generated number between 1-4
            rdmOperator = (int) (Math.random() * (maxOperator - minOperator + 1) + minOperator);

            //depending on the number in rdmOperator an addition, division, multiplication or division results.
            switch (rdmOperator){
                case 1:
                    if (rdmOp1 + rdmOp2 > 0){
                        this.result = rdmOp1 + rdmOp2;
                        System.out.println(rdmOp1 + " + " + rdmOp2 + " = ?");
                    }
                    break;
                case 2:
                    if (rdmOp1 - rdmOp2 > 0){
                        this.result = rdmOp1 - rdmOp2;
                        System.out.println(rdmOp1 + " - " + rdmOp2 + " = ?");
                    }
                    break;
                case 3:
                    if (rdmOp1 * rdmOp2 > 0){
                        this.result = rdmOp1 * rdmOp2;
                        System.out.println(rdmOp1 + " * " + rdmOp2 + " = ?");
                    }
                    break;
                case 4:
                    if (rdmOp1 / rdmOp2 > 0){
                        this.result = rdmOp1 / rdmOp2;
                        System.out.println(rdmOp1 + " / " + rdmOp2 + " = ?");
                    }
            }

            //ends the loop as soon as the result is greater than or equal to one
        }while (this.result <= 0);
    }

    /**
     *
     * @return returns the result
     */
    public int getResult() {
        return this.result;
    }

}
