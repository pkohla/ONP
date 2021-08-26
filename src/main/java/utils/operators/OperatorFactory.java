package utils.operators;

public class OperatorFactory {

    public Operator getOperator(String operatorSign) {

        switch (operatorSign) {
            case "+" : return new AddingOperator();
            case "-" : return new SubtractOperator();
            case "/" : return new DivideOperator();
            case "x" : return new MultiplyOperator();
            case "!" : return new FactorialOperator();
            default: {
                System.out.format("Unknown operator sign %s", operatorSign);
                return null;
            }
        }
    }
}
