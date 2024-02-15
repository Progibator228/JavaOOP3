package org.example;

import java.util.Random;
import java.util.List;


public abstract class AbstractGame implements  Game{

    private String word ;
    private GameStatus status = GameStatus.INIT;
    private Integer maxTry;


    public String generateWord(Integer size){
        StringBuilder word = new StringBuilder();
        List<String> charList = generateCharList();
        Random random = new Random();
        String bufer = "";
        for (int i = 0; i < size ; i++) {
            bufer = (charList.get(random.nextInt(charList.size())));
            word.append(bufer);
            charList.remove(bufer);
            //word.append(charList.get(random.nextInt(charList.size())));
        }
        return word.toString();
    }

    public abstract List<String> generateCharList();


    @Override
    public void start(Integer sizeWorld, Integer maxTry) {
        word = generateWord(sizeWorld);
        status = GameStatus.START;
        this.maxTry = maxTry;

    }

    @Override
    public Answer inputValue(String value) {
        if (!getGameStatus().equals(GameStatus.START)) throw new RuntimeException("Игра не в активном состоянии");
        Integer cowCounter = 0;
        Integer bullCounter= 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == value.charAt(i)) bullCounter++;
            if (word.contains(String.valueOf(value.charAt(i)))) cowCounter++;
        }
        --maxTry;
        if (bullCounter == word.length()) {
            status = GameStatus.WIN;
        }
        else if (maxTry == 0){
            status = GameStatus.END;
        }
        return new Answer(maxTry,cowCounter,bullCounter);
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }
}
