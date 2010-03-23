package com.google.inject.scopes;


import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ThreadLocalScope implements Scope {

    private ConcurrentMap<String, Object> context = new ConcurrentHashMap<String, Object>();

    private ThreadLocalScope() {
        super();
    }
    /**
     * Thread Local scope.
     */
    public static final Scope THREAD_LOCAL = new ThreadLocalScope();

    /** A sentinel attribute value representing null. */
    private enum NullObject {

        INSTANCE
    }

    @Override
    public <T> Provider<T> scope(Key<T> key, final Provider<T> creator) {
        final String name = key.toString();
        return new Provider<T>() {

            @SuppressWarnings("unchecked")
            @Override
            public T get() {
                Object obj = context.get(name);
                if (NullObject.INSTANCE == obj) {
                    return null;
                }
                ThreadLocal threadLocal = (ThreadLocal) obj;
                if (threadLocal == null) {
                    threadLocal = new ThreadLocal();
                }
                T t = (T) threadLocal.get();
                if (t == null) {
                    t = creator.get();
                    threadLocal.set(t);
                    context.put(name, (t != null) ? threadLocal
                            : NullObject.INSTANCE);
                }
                return t;
            }
        };
    }
}
