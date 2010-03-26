/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.inject.scopes;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Context for thread local scope
 * @author Fabricio Tuosto
 */
class ThreadLocalContextHolder implements ContextHolder {

    private ThreadLocal<Map<String, Object>> locals =
            new ThreadLocal<Map<String, Object>>() {

                protected Map<String, Object> initialValue() {
                    return new ConcurrentHashMap<String, Object>();
                }
            };

    public ThreadLocalContextHolder() {
        super();
    }

    public Map<String, Object> get() {
        return locals.get();
    }
}
