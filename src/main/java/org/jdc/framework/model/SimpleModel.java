package org.jdc.framework.model;

import java.util.HashMap;
import java.util.Map;

public class SimpleModel implements Model{
    private Map<String,String> map = new HashMap<>();
    @Override
    public void set(String s1, String s2) {
        map.put(s1,s2);
    }

    @Override
    public String get(String s1) {
        return map.get(s1);
    }
}
