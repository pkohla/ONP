package utils.operators;

import utils.data.CalculationData;

public class SubtractOperator implements Operator{

    @Override
    public int getResult(CalculationData calculationData) {
        return calculationData.getA()-calculationData.getB();
    }
}
