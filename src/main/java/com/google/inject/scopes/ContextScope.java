package com.google.inject.scopes;

import java.util.Map;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

public class ContextScope implements Scope {

    private final ContextHolder contextHolder;

	public ContextScope(ContextHolder holder) {
        super();
		this.contextHolder = holder;
    }

    public <T> Provider<T> scope(Key<T> key, final Provider<T> creator) {
        final String name = key.toString();
        return new Provider<T>() {

            public T get() {
                Map<String, Object> context = contextHolder.get() ;
                if(!context.containsKey(name)){
                    context.put(name,creator.get());
                }
                @SuppressWarnings("unchecked")
                T t = (T) context.get(name);
                return t;
            }
        };
    }
}
