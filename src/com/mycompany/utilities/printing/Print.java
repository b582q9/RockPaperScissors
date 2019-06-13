package com.mycompany.utilities.printing;

import java.util.Map;
import java.util.Optional;

public interface Print<T extends String,Q>{

    public void results(Map<?,?> results);

    public void help(Optional<T> message);

    public void errors(Q err);

    default void info(Optional<String> message){
        System.out.printf("%1$s%n",message.orElse("RockPaperScissors v0.1"));
    }
}
