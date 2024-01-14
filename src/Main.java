package com.itproger;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;


    public class Main {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String trim = input.trim();

            if(!(trim.contains("+") || trim.contains("-") || trim.contains("*") || trim.contains("/"))) {
                throw new Exception("можно выбрать только онду из этих операций (+, -, /, *)");
            }

            String[] split = trim.split("[-+*/]");
            ArrayList<Integer> numbers = new ArrayList<>();
            for(String s:split) {
                try {
                    int i = Integer.parseInt(s.trim());
                    numbers.add(i);
                } catch (NumberFormatException e) {
                    throw new Exception("строка не является математической операцией");
                }
            }

            if (numbers.size() != 2) {
                throw new Exception("вы в вели больше 2ух чисел");
            }

            checkNumber(numbers.get(0));
            checkNumber(numbers.get(1));
            int indexOfOperation = getOperation(trim);
            char operation = trim.charAt(indexOfOperation);


            int result;
            switch (operation){
                case '+':
                    result = numbers.get(0) + numbers.get(1);
                    break;
                case '-':
                    result = numbers.get(0) - numbers.get(1);
                    break;
                case '*':
                    result = numbers.get(0) * numbers.get(1);
                    break;
                case '/':
                    result = numbers.get(0) / numbers.get(1);
                    break;
                default:
                    throw new Exception("что-то пошло не так");
            }
            out.println("Результат: " + result);



        }

        private static void checkNumber(Integer number) throws Exception {
            if (1 > number || number > 10) {
                throw new Exception("вы в вели число меньше 1 или больше 10 либо деление на 0 ");
            }
        }

        private static int getOperation(String s) {
            String[] operations = {"+","-","*","/"};
            int indexOfOperation = 0;
            for (String operation : operations) {
                if (s.contains(operation)) {
                    indexOfOperation = s.indexOf(operation);
                }
            }
            return indexOfOperation;
        }
    }






