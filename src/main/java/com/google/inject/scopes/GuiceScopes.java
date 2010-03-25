/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.inject.scopes;

import java.util.Map;
import java.util.WeakHashMap;

/**
 *
 * @author Fabricio Tuosto
 */
class GuiceScopes {

    private static ThreadLocal<Map<String, Object>> locals = new ThreadLocal<Map<String, Object>>();

    public static Map<String, Object> getThreadLocalContext() {
        Map<String, Object> context = locals.get();
        if (context == null) {
            context = new WeakHashMap<String, Object>();
            locals.set(context);
        }
        return context;
    }
}
