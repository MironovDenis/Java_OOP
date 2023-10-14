package complexCalculator;

import java.util.Scanner;

import static complexCalculator.Main.logger;

public class CalculatorView {
    Calculable calculator;

    public CalculatorView(Calculator calc) {
        calculator = calc;
    }

    public void run() {
        while (true) {
            try {
                ComplexNumber numberA = new ComplexNumber(getValue("Действительная часть числа А: "), getValue("Мнимая часть числа А: "));
                logger.info("Комплексное число А " + numberA);
                System.out.println();
                ComplexNumber numberB = new ComplexNumber(getValue("Действительная часть числа В: "), getValue("Мнимая часть числа В: "));
                logger.info("Комплексное число В " + numberB);
                System.out.println();
                String command = prompt("\nВведите команду: +, *, / или exit ");
                if (command.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                switch (command) {
                    case "+":
                        logger.info("Сложение комплесных чисел: " + numberA + " и " + numberB);
                        System.out.println();
                        ComplexNumber sumResult = calculator.sum(numberA, numberB);
                        logger.info("Результат: " + sumResult);
                        break;
                    case "*":
                        logger.info("Умножение комплесных чисел: " + numberA + " и " + numberB);
                        System.out.println();
                        ComplexNumber multiResult = calculator.multiply(numberA, numberB);
                        logger.info("Результат: " + multiResult);
                        break;
                    case "/":
                        logger.info("Деление комплесных чисел: " + numberA + " и " + numberB);
                        System.out.println();
                        ComplexNumber divResult = calculator.multiply(numberA, numberB);
                        logger.info("Результат: " + divResult);
                        break;
                }
                String cmd = prompt("Еще посчитать (Y/N)?");
                if (cmd.equalsIgnoreCase("Y")) {
                    continue;
                }
                break;

            } catch (RuntimeException e) {
                logger.info(e.getMessage());
            }

        }
    }

    public double getValue(String value) {
        Scanner in = new Scanner(System.in);
        System.out.printf("%s", value);
        return in.nextDouble();
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
