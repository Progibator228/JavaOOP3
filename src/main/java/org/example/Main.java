package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        try {
            FileWriter fstream1 = new FileWriter("Log.txt");
            BufferedWriter out1 = new BufferedWriter(fstream1);
            out1.write("");
            out1.close();
        } catch (Exception ex) {
            System.out.println("Все пропало");
            ;
        }

        File myFile = new File("Log.txt");
        FileReader reader = new FileReader("Log.txt");

        AbstractGame nGame = new NumberGame();
        Scanner scanner = new Scanner(System.in);

        nGame.start(2, 3);
        System.out.println("Что бы увидеть лог напишите 'log'");
        while (nGame.getGameStatus().equals(GameStatus.START)) {
            System.out.println("Ваш ход");
            String value = scanner.nextLine();

            try {
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
                if (value.equals("log")) {
                    nGame.start(2, 3);
                } else {
                    writer.println(value);
                    writer.close();
                }
            } catch (IOException ex) {
                System.out.println("Все пропало");
                ;
            }

            if (value.equals("log")) {
                int i;
                while ((i = reader.read()) != -1) {
                    System.out.print((char) i);
                }
            } else {
                Answer answer = nGame.inputValue(value);
                System.out.println(answer);
            }

        }
        System.out.println(nGame.getGameStatus().getDescription());


    }

}
