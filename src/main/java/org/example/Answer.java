package org.example;

public class Answer {


    private Integer countTry;
    private Integer cowCounter;
    private Integer bullCounter;

    public Answer(Integer countTry, Integer cowCounter, Integer bullCounter) {
        this.countTry = countTry;
        this.cowCounter = cowCounter;
        this.bullCounter = bullCounter;
    }

    @Override
    public String toString() {
        return String.format("Коров %d  Быков %d Номер попытки = %d",cowCounter,bullCounter,countTry);
    }
}
