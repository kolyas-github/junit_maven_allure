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

    public AppTest(String operand1, String operand2, String operation, String resultat) {
        this.operand1 = Integer.parseInt(operand1);
        this.operand2 = Integer.parseInt(operand2);
        this.operation = operation.charAt(0);
        this.resultat = Integer.parseInt(resultat);
    }

    @Test
    public void checkApp() {
        App app = new App(operand1,operand2,operation);
        int result = app.getResult();
        assertEquals(resultat, result);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        Collection<Object[]> arr = new ArrayList<Object[]>();
        try{
            FileInputStream fstream = new FileInputStream("file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int i=0;
            while ((strLine = br.readLine()) != null){
                String[] str_mass = strLine.split(";");
                arr.add(str_mass);
                i+=1;
           }
        }catch (IOException e){
          System.out.println("Ошибка"+e);
        }
        return arr;
    }
}

