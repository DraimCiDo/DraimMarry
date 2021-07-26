package me.draimgoose.misc;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class Cooldown<T> {
    private final Cache<T, Boolean> cache;

    public Cooldown(long cooldownTime, TimeUnit unit) {
        this.cache = CacheBuilder.newBuilder().expireAfterWrite(cooldownTime, unit).build();
    }

    public boolean isCached(T key) {
        return cache.getIfPresent(key) != null;
    }

    public void set(T key) {
        cache.put(key, false);
    }

    public boolean performCheck(T key) {
        if(isCached(key)) return false;
        set(key);
        return true;
    }
}
