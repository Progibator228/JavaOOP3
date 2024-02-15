package org.example;

public enum GameStatus {

    INIT,START("Игра началась что бы увидеть лог напишите 'log'"),END("Вы проиграли"),WIN("Вы выйграли");

    private String description;


    GameStatus(String description) {
        this.description = description;
    }

    GameStatus() {
    }

    public String getDescription() {
        return description;
    }
}
