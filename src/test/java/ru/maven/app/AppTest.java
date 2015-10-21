package ru.maven.app;

import static junit.framework.Assert.*;
import org.junit.*;
import org.junit.runners.*;
import org.junit.runner.*;
import ru.yandex.qatools.allure.annotations.*;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.*;


@RunWith(Parameterized.class)
public class AppTest {

    public int operand1;
    public int operand2;
    public char operation;
    public int resultat;

    public AppTest(int operand1, int operand2, char operation, int resultat) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.resultat = resultat;
    }

    @Test
    public void checkApp() {
        App app = new App(operand1, operand2, operation);
        int result = app.getResult();
        assertEquals(resultat, result);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        //Реализовать метод создания массива из файла
        return Arrays.asList(new Object[][] { 
        {2, 2,'+',4}, {2, 0,'-',2}, {-1, 2,'*', -2}, {0, 2,'/', 0}
        });
    }
}

