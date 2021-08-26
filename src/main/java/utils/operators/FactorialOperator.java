package utils.operators;

import utils.data.CalculationData;

public class FactorialOperator implements Operator{

    @Override
    public int getResult(CalculationData calculationData) {
        int result=1;
        for (int i = 1; i <= calculationData.getB(); i++) {
            result*=i;
        }
        return result;
    }
}
