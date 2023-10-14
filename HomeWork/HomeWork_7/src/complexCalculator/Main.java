package complexCalculator;

import java.util.logging.Logger;

public class Main {
    static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Калькулятор комплексных чисел\n");
        CalculatorView view = new CalculatorView(new Calculator());
        view.run();
    }


}
