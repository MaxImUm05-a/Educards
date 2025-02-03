package com.example.educards;

import redis.clients.jedis.UnifiedJedis;

public class Redis {
    private static Redis instance;
    private final UnifiedJedis jedis;

    public Redis() {
        this.jedis = new UnifiedJedis("redis://localhost:6379");
    }
    public static synchronized Redis getInstance() {
        if (instance == null) {
            instance = new Redis();
        }
        return instance;
    }
    public String setVariable(String Name, String Data) {
        return jedis.set(Name, Data);
    }

    public String getVariable(String Name) {
        return jedis.get(Name);
    }

    public long setHash(String Name, String Object, String Data) {
        return jedis.hset(Name, Object, Data);
    }

    public String getHash(String Name, String Object) {
        return jedis.hget(Name, Object);
    }

// Новый метод для закрытия соединения
    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
