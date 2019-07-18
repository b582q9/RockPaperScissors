package com.mycompany.strategy;

import com.mycompany.utilities.GameFigures;
import java.util.Map;

public interface Strategy<K extends String,V extends Integer,T extends Map<K,V>,R extends GameFigures>{

    public R computeMove(T c);
}
