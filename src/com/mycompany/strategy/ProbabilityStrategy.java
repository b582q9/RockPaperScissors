package com.mycompany.strategy;

import com.mycompany.utilities.GameFigures;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @since 11 июня 2019 г. 00:10:29
 * @version 0.1
 */
public class ProbabilityStrategy implements Strategy<String,Integer,Map<String,Integer>,GameFigures>{

    @Override
    public GameFigures computeMove(Map<String,Integer> c){
        int total_inputs=c.entrySet().parallelStream().mapToInt(n->n.getValue()).sum();
        double userFigureMaxRepeatProbability=StrictMath.pow((double)Collections.max(c.entrySet(),Map.Entry.comparingByValue()).getValue()/total_inputs,2);
        var userFiguresMaxRepeatedProbabilities=c.entrySet().parallelStream()
                .map(n->Map.entry(n.getKey(),StrictMath.pow((double)n.getValue()/total_inputs,2)))
                .collect(Collectors.filtering(n->Objects.equals(n.getValue(),userFigureMaxRepeatProbability),Collectors.toList()));
        while(userFiguresMaxRepeatedProbabilities.size()>1){
            userFiguresMaxRepeatedProbabilities.remove(new SecureRandom().nextInt(userFiguresMaxRepeatedProbabilities.size()));
        }
        return GameFigures.valueOf(userFiguresMaxRepeatedProbabilities.get(0).getKey());
    }
}
