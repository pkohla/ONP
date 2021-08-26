package utils.operators;

import utils.data.CalculationData;

public class DivideOperator implements Operator{

    @Override
    public int getResult(CalculationData calculationData) {
        return calculationData.getB() > 0 ? calculationData.getA()/calculationData.getB() : 0;
    }
}
