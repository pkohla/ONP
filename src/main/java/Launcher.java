import utils.ONPCalculator;

public class Launcher {

    public static void main(String[] args) {

        ONPCalculator onpCalculator = new ONPCalculator("5 1 2 + 4 x + 3 -");
        onpCalculator.solve();
        System.out.println(onpCalculator.getResult());
    }
}
