package com.mycompany.utilities.printing;

import java.util.Map;
import java.util.Optional;

/**
 *
 * @param <T>
 * @param <Q>
 * @since 11 июня 2019 г. 20:50:33
 * @version 0.1
 */
public interface Print<T extends String,Q>{

    /**
     *
     * @param results
     */
    public void results(Map<?,?> results);

    /**
     *
     * @param message
     */
    public void help(Optional<T> message);

    /**
     *
     * @param err
     */
    public void errors(Q err);

    /**
     *
     * @param message
     */
    default void info(Optional<String> message){
        System.out.printf("%1$s%n",message.orElse("RockPaperScissors v0.1"));
    }
}
