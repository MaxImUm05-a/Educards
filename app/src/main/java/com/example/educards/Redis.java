package com.example.educards;

import redis.clients.jedis.UnifiedJedis;

public class Redis {
    UnifiedJedis jedis = new UnifiedJedis("redis://localhost:6379");

    public String setVariable(String Name, String Data) {return jedis.set(Name, Data);}

    public String getVariable(String Name){return jedis.get(Name);}

    public long setHash(String Name, String Object, String Data){return jedis.hset(Name, Object, Data);}

    public String getHash(String Name, String Object){return jedis.hget(Name, Object);}
}
