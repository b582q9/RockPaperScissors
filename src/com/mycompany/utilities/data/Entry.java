package com.mycompany.utilities.data;

import java.util.Map;

public interface Entry<K,V,R extends Map<?,?>>{

    public boolean setEntry(K k,V v);

    public R getEntries();

    public void clear();
}
