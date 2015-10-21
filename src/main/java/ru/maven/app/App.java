package ru.maven.app;

public class App {
    private int first;
    private int second;
    private char operation;
    
    public App(int first, int second, char operation) {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }

    public int getResult(){
        if (operation=='+')
            return first + second;
        else if (operation=='-')
            return first - second;
        else if (operation=='*')
            return first * second;
        else if (operation=='/')
            return first / second;
        else
            return 0;
    }
}