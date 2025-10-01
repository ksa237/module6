package ru.netology.module6.junittesting;

public class Calculator {

    public int add(int a, int b) {
        return a+b;

    }

    public int substract(int a, int b){
        return a-b;
    }

    public int divide(int a, int b) {
        if(b==0){
            throw new ArithmeticException("Division by zero is impossible!");
        }
        return a/b;

    }
}
