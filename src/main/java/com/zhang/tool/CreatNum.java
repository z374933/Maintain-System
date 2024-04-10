package com.zhang.tool;


public class CreatNum {
    public String getId(int size) {
        SnowFlake snowFlake = new SnowFlake(1, 1);
        String str = String.valueOf(snowFlake.nextId());
        int startIndex = str.length() - size;
        return str.substring(startIndex);
    }
}
