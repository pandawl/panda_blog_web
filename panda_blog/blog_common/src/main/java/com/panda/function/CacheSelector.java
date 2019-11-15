package com.panda.function;

@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
