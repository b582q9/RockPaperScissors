package com.mycompany.strategy;

import com.mycompany.utilities.GameFigures;
import java.util.Map;

/**
 *
 * @param <K>
 * @param <V>
 * @param <T>
 * @param <R>
 * @since 11 июня 2019 г. 23:38:51
 * @version 0.1
 */
public interface Strategy<K extends String,V extends Integer,T extends Map<K,V>,R extends GameFigures>{

    /**
     *
     * @param c
     * @return
     */
    public R computeMove(T c);
}
