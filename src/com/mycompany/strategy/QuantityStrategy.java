package com.mycompany.strategy;

import com.mycompany.utilities.GameFigures;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @since 11 июня 2019 г. 01:48:38
 * @version 0.1
 */
public class QuantityStrategy implements Strategy<String,Integer,Map<String,Integer>,GameFigures>{

    /**
     *
     * @param c
     * @return
     */
    @Override
    public GameFigures computeMove(Map<String,Integer> c){
        if(c.size()<=1){
            String figureMaxKey=Collections.max(c.entrySet(),Map.Entry.comparingByValue()).getKey();
            List<GameFigures> gameFiguresOfPossibleVariantsList=Arrays.stream(GameFigures.values())
                    .collect(Collectors.filtering(n->!Objects.equals(n.name(),figureMaxKey),Collectors.toList()));
            return gameFiguresOfPossibleVariantsList.get(new SecureRandom().nextInt(gameFiguresOfPossibleVariantsList.size()));
        }
        Integer figureMaxValue=Collections.max(c.entrySet(),Map.Entry.comparingByValue()).getValue();
        var userFiguresMaxKeys=c.entrySet().stream()
                .collect(Collectors.filtering(n->Objects.equals(n.getValue(),figureMaxValue),Collectors.toList()));
        while(userFiguresMaxKeys.size()>1){
            userFiguresMaxKeys.remove(new SecureRandom().nextInt(userFiguresMaxKeys.size()));
        }
        return GameFigures.valueOf(userFiguresMaxKeys.get(0).getKey());
    }
}
