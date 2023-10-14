package complexCalculator;

import java.util.logging.Logger;

public class Main {
    static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("КАЛЬКУЛЯТОР КОМПЛЕКСНЫХ ЧИСЕЛ\n");
        CalculatorView view = new CalculatorView(new Calculator());
        view.run();
    }


}
