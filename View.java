import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class View {

    private Calculator calculator;
    private String[] operations = new String[] {"+", "-", "*", "/"};
    private Logger logger;


    public View(Calculator calculator, Logger logger){
        this.calculator = calculator;
        this.logger = logger;
    }

    public void start() throws IOException{
        System.out.println("Вы открыли калькулятор комплексных чисел");
        logger.writeToLog("Запущен калькулятор комплексных чисел");
        while (true) {
            ComplexNumber firstNumber = getFirstNumber();
            String operator = getOperator();
            ComplexNumber secondNumber = getSecondNumber();

            if(operator.equals("+")){
                calculator.sum(firstNumber, secondNumber);
                logger.writeToLog("Сумма комплексных чисел: " + firstNumber + " + " + secondNumber + " = " + calculator.result());
            }

            if(operator.equals("-")){
                calculator.subtraction(firstNumber, secondNumber);
                logger.writeToLog("Разность комплексных чисел: " + firstNumber + " - " + secondNumber + " = " + calculator.result());
            }

            if(operator.equals("*")){
                calculator.multiply(firstNumber, secondNumber);
                logger.writeToLog("Произведение комплексных чисел: " + firstNumber + " * " + secondNumber + " = " + calculator.result());
            }

            if(operator.equals("/")){
                calculator.divide(firstNumber, secondNumber);
                logger.writeToLog("Частное комплексных чисел: " + firstNumber + " / " + secondNumber + " = " + calculator.result());
            }

            // calculator.result();
            calculator.clear();
            String action = nextOperation();
            if(!action.equalsIgnoreCase("yes")) {
                logger.writeToLog("Калькулятор завершил работу");
                System.exit(0);
            }
        }
        
    }

    private String getOperator(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите оператор (+, -, *, /): ");
        String operator = in.nextLine();
        while (true) {
            if (!Arrays.asList(operations).contains(operator)) {
                System.err.println("Введен неверный оператор. " + "Введите оператор (*, +, /, -): ");
                logger.writeToLog("Введен неверный оперетор");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private ComplexNumber getFirstNumber(){
        double realNumber = inputRealNamber();
        double imaginNumber = inputImaginNamber();
        return new ComplexNumber(realNumber, imaginNumber);
    }

    private ComplexNumber getSecondNumber(){
        double realNumber = inputRealNamber();
        double imaginNumber = inputImaginNamber();
        return new ComplexNumber(realNumber, imaginNumber);
    }

    private double inputRealNamber(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите действительную часть числа: ");
        double realNumber = 0;
        try{
            realNumber = in.nextDouble();
        } catch (RuntimeException e){
            System.err.println("Введено не число. Повторите попытку");
            logger.writeToLog("Введено не число");
            inputRealNamber();
        }
        return realNumber;
    }

    private double inputImaginNamber(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите мнимую часть числа: ");
        double imaginNumber = 0;
        try{
            imaginNumber = in.nextDouble();
        } catch (RuntimeException e){
            System.err.println("Введено не число. Повторите попытку");
            logger.writeToLog("Введено не число");
            inputRealNamber();
        }
        return imaginNumber;
    }

    private String nextOperation(){
        Scanner in = new Scanner(System.in);
        System.out.println("Хотите продолжить? Введите yes или no");
        return in.nextLine();
    }



    
}
