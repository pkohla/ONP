package utils;

import utils.data.CalculationData;
import utils.operators.OperatorFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;


public class ONPCalculator {

    private String expression;
    private LinkedList<Integer> buffer = new LinkedList<>();
    private List<String> operatorsListThatNeedsTwoNumeral = List.of("+", "-", "x", "/");
    private List<String> operatorsListThatNeedsOneNumeral = List.of("!");

    private List<String> operatorsList = new LinkedList<>();

    public ONPCalculator(String expression) {
        this.expression = expression;
        operatorsList.addAll(operatorsListThatNeedsTwoNumeral);
        operatorsList.addAll(operatorsListThatNeedsOneNumeral);
    }

    public void solve() {
        Stream.of(expression.split(" "))
                .forEach(elem -> {
                    if (!operatorsList.contains(elem)) {
                        buffer.add(Integer.parseInt(elem));
                    } else {
                        OperatorFactory operatorFactory = new OperatorFactory();
                        buffer.add(operatorFactory.getOperator(elem).getResult(prepareData(elem)));
                    }
                });
    }

    private CalculationData prepareData(String elem) {
        if (operatorsListThatNeedsOneNumeral.contains(elem)) {
            return new CalculationData(buffer.pollLast(), null);
        }
        return new CalculationData(buffer.pollLast(), buffer.pollLast());
    }

    public int getResult() {
        return buffer.get(0);
    }
}
