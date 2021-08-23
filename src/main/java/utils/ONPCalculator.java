package utils;

import java.util.LinkedList;
import java.util.List;


public class ONPCalculator {

    private String expression;
    private LinkedList<Integer> buffer = new LinkedList<>();
    private List<String> operatorsList = List.of("+", "-", "x", "/");
    private List<String> expressionElements;

    public ONPCalculator() {
    }

    public ONPCalculator(String expression) {
        this.expression = expression;
        convertExpression();
    }

    public List<String> getExpressionElements() {
        return expressionElements;
    }

    private void convertExpression() {
        expressionElements = List.of(expression.split(" "));
    }

    public void solve() {
        for (String elem: expressionElements) {
            if (!operatorsList.contains(elem)) {
                buffer.add(Integer.parseInt(elem));
            } else {
                int b = buffer.pollLast();
                int a = buffer.pollLast();

                calculate(elem, b, a);
            }
        }
    }

    protected void calculate(String elem, int b, int a) {
        switch (elem) {
            case "+" : {
              buffer.add(a + b);
              break;
            }
            case "-" : {
                buffer.add(a - b);
                break;
            }
            case "x" : {
                buffer.add(a * b);
                break;
            }
            case "/" : {
                buffer.add(a / b);
                break;
            }
        }
    }

    public int getResult() {
        return buffer.get(0);
    }
}
