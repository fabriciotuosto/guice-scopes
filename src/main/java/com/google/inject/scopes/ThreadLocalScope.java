package com.google.inject.scopes;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;
import java.util.Map;

public class ThreadLocalScope implements Scope {

    private ThreadLocalScope() {
        super();
    }
    /**
     * Thread Local scope.
     */
    public static final Scope THREAD_LOCAL = new ThreadLocalScope();

    @Override
    public <T> Provider<T> scope(Key<T> key, final Provider<T> creator) {
        final String name = key.toString();
        return new Provider<T>() {

            @Override
            public T get() {
                Map<String, Object> context = GuiceScopes.getThreadLocalContext();
                if(!context.containsKey(name)){
                    context.put(name,creator.get());
                }
                return (T) context.get(name);
            }
        };
    }
}
