package com.mycompany.utilities;

/**
 *
 * @since 11 июня 2019 г. 20:20:56
 * @version 0.1
 */
public enum GameFigures{
    ROCK, PAPER, SCISSORS;

    public static GameFigures getFigureFromUserInput(String v){
        return switch(v){
            case "1","r"->ROCK;
            case "2","p"->PAPER;
            case "3","s"->SCISSORS;
            default->ROCK;
        };
    }
}
