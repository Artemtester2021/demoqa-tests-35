class JavaVariables {
    public static void main(String[] args) {

        int numberZero = 3;
        int numberOne = 3;
        int numberTwo = 7;
        int numberThree = 10;
        double numberFour = 12.5;
        System.out.println();
        System.out.println("Task0");

        //Task0
        System.out.println("3 + 7 = " + (numberOne + numberTwo));
        System.out.println("10 - 3 = " + (numberThree - numberZero));
        System.out.println("10 * 7 = " + (numberThree * numberTwo));
        System.out.println("7 / 3 = " + (numberTwo / numberOne));
        System.out.println();
        System.out.println("Task1");

        //Task1
        System.out.println("(7 + 12.5) * 7 = " + ((numberTwo + numberFour) * numberTwo));
        System.out.println("(12.5 - 3) / 3 = " + ((numberFour - numberZero) / numberOne));
        System.out.println();
        System.out.println("Task2");

        //Task2
        System.out.println("3 < 12.5 =" + (numberZero < numberFour));
        System.out.println("7 > 3 = " + (numberTwo > numberOne));
        System.out.println("3 >= 3 = " + (numberOne >= numberZero));
        System.out.println("12.5 <= 7 = " + (numberFour <= numberTwo));
        System.out.println("3 == 3 = " + (numberOne == numberZero));
        System.out.println();
        System.out.println("Task3");

        //Task3
        //Получение максимальных вещественных чисел
        float maxFloat = Float.MAX_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.println("maxFloat: " + maxFloat);
        System.out.println("maxDouble: " + maxDouble);
        System.out.println("Переролнение_maxFloat: " + maxFloat * 2);
        System.out.println("Переролнение_maxDouble: " + maxDouble * 2);

        //Получение минимальных вещественных чисел
        float minFloat = Float.MIN_VALUE;
        double minDouble = Double.MIN_VALUE;
        System.out.println("minFloat: " + minFloat);
        System.out.println("minDouble: " + minDouble);
        System.out.println("Переролнение_minFloat: " + minFloat * 2);
        System.out.println("Переполненние_minDouble: " + minDouble * 2);

        //Task4
        int numberFive = Integer.MAX_VALUE;
        int numberSix = Integer.MIN_VALUE;
        System.out.println();
        System.out.println("Task4");
        System.out.println("Переполнение максимального значения: " + (numberFive + 1)); //
        System.out.println("Переполнение минимального значения: " + (numberSix - 1));  //
    }
}

