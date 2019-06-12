package com.mycompany;

import com.mycompany.strategy.ProbabilityStrategy;
import com.mycompany.strategy.QuantityStrategy;
import com.mycompany.utilities.GameFigures;
import com.mycompany.utilities.printing.PrintData;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.mycompany.utilities.data.Entry;
import com.mycompany.utilities.GameResults;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;

/**
 *
 * @since 11 июня 2019 г. 23:38:51
 *
 * @version 0.1
 */
public class RockPaperScissors{

    public RockPaperScissors(){
        Pattern pattern_input=Pattern.compile("[rRpPsSvVhH_1-5]");
        printing=new PrintData();
        printing.info(Optional.of(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE' 'd'-'LLLL'-'u' 'HH':'mm':'ss",Locale.US))));
        printing.help(Optional.of("Wellcome to wonderful game dear user!"));
        Scanner input=new Scanner(System.in);
        userEntriesStatistic=new Entry<>(){
            private final Map<String,Integer> userEntries=new HashMap<>();

            @Override
            public boolean setEntry(String k,Integer v){
                try{
                    userEntries.merge(k,v,Integer::sum);
                }catch(UnsupportedOperationException|IllegalArgumentException|ClassCastException|NullPointerException expt0){
                    printing.errors(expt0);
                    return false;
                }
                return true;
            }

            @Override
            public Map<String,Integer> getEntries(){
                return userEntries;
            }

            @Override
            public void clear(){
                userEntries.clear();
            }
        };
        AIEntriesStatistic=new Entry<>(){
            private final Map<String,Integer> AIEntries=new HashMap<>();

            @Override
            public boolean setEntry(String k,Integer v){
                try{
                    AIEntries.merge(k,v,Integer::sum);
                }catch(UnsupportedOperationException|IllegalArgumentException|ClassCastException|NullPointerException expt0){
                    printing.errors(expt0);
                    return false;
                }
                return true;
            }

            @Override
            public Map<String,Integer> getEntries(){
                return AIEntries;
            }

            @Override
            public void clear(){
                AIEntries.clear();
            }
        };
        gameResultsStatictic=new Entry<>(){
            private final Map<GameResults,Integer> statisticEntries=new HashMap<>();

            @Override
            public boolean setEntry(GameResults k,Integer v){
                try{
                    statisticEntries.merge(k,v,Integer::sum);
                }catch(UnsupportedOperationException|IllegalArgumentException|ClassCastException|NullPointerException expt0){
                    printing.errors(expt0);
                    return false;
                }
                return true;
            }

            @Override
            public Map<GameResults,Integer> getEntries(){
                return statisticEntries;
            }

            @Override
            public void clear(){
                statisticEntries.clear();
            }
        };
        processInput(pattern_input,input);

    }

    /**
     *
     * @param p
     * @param in
     */
    protected void processInput(Pattern p,Scanner in){
        probabilytyStrg=new ProbabilityStrategy();
        quantityStrg=new QuantityStrategy();
        while(in.hasNext(p)){
            String s=in.nextLine().toLowerCase();
            switch(s.trim()){
                case "1","2","3","r","p","s"->{
                    s=GameFigures.getFigureFromUserInput(s).name();
                    userEntriesStatistic.setEntry(s,1);
                    counter++;
                    if(counter>30){
                        processResults(s,probabilytyStrg.computeMove(userEntriesStatistic.getEntries()).name());
                    }else{
                        processResults(s,quantityStrg.computeMove(userEntriesStatistic.getEntries()).name());
                    }
                }
                case "4","v"->{
                    printing.info(Optional.of("***Your statistic***"));
                    printing.results(gameResultsStatictic.getEntries());
                }
                case "5","h"->printing.help(Optional.empty());
            };
        }
    }

    /**
     *
     * @param userInput
     * @param AIturn
     * @return
     */
    protected boolean processResults(String userInput,String AIturn){
        printing.info(Optional.of("You choose:"+userInput+" <-=VS=-> AI choose:"+AIturn));
        if(userInput.equalsIgnoreCase(AIturn)){
            gameResultsStatictic.setEntry(GameResults.DRAWS,1);
            printing.info(Optional.of("This is DRAW..."));
        }else{
            if(userInput.equals("PAPER")&AIturn.equals("ROCK")){
                gameResultsStatictic.setEntry(GameResults.WINS,1);
                userEntriesStatistic.clear();
                printing.info(Optional.of("You WIN!"));
            }else{
                if(userInput.equals("SCISSORS")&AIturn.equals("PAPER")){
                    gameResultsStatictic.setEntry(GameResults.WINS,1);
                    userEntriesStatistic.clear();
                    printing.info(Optional.of("You WIN!"));
                }else{
                    if(userInput.equals("ROCK")&AIturn.equals("SCISSORS")){
                        gameResultsStatictic.setEntry(GameResults.WINS,1);
                        userEntriesStatistic.clear();
                        printing.info(Optional.of("You WIN!"));
                    }else{
                        if(userInput.equals("ROCK")&AIturn.equals("PAPER")){
                            gameResultsStatictic.setEntry(GameResults.LOSSES,1);
                            printing.info(Optional.of("You LOSE!"));
                        }else{
                            if(userInput.equals("PAPER")&AIturn.equals("SCISSORS")){
                                gameResultsStatictic.setEntry(GameResults.LOSSES,1);
                                printing.info(Optional.of("You LOSE!"));
                            }else{
                                if(userInput.equals("SCISSORS")&AIturn.equals("ROCK")){
                                    gameResultsStatictic.setEntry(GameResults.LOSSES,1);
                                    printing.info(Optional.of("You LOSE!"));
                                }
                            }
                        }
                    }
                }
            }
        }
        return AIEntriesStatistic.setEntry(AIturn,1);
    }

    /**
     *
     * @param args
     */
    public static void main(String... args){
        new RockPaperScissors();
    }
    private volatile int counter=0;
    private PrintData printing=null;
    private ProbabilityStrategy probabilytyStrg=null;
    private QuantityStrategy quantityStrg=null;
    private Entry<String,Integer,Map<String,Integer>> userEntriesStatistic=null, AIEntriesStatistic=null;
    private Entry<GameResults,Integer,Map<GameResults,Integer>> gameResultsStatictic=null;
}
