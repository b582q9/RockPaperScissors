package com.mycompany.utilities.data;

import java.util.Map;

/**
 *
 * @param <K>
 * @param <V>
 * @param <R>
 * @since 11 июня 2019 г. 19:56:57
 * @version 0.1
 */
public interface Entry<K,V,R extends Map<?,?>>{

    /**
     *
     * @param k
     * @param v
     * @return
     */
    public boolean setEntry(K k,V v);

    /**
     *
     * @return
     */
    public R getEntries();

    public void clear();
}
