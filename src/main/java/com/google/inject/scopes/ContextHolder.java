package com.google.inject.scopes;

import java.util.Map;

/**
 * Interface that defines under which circumstances a new context will
 * be created for a given context implementation allowing to control or
 * modiffied for testing any given scope
 *
 * @author Fabricio Tuosto
 */
public interface ContextHolder {

    /**
     * 
     * @return a map that represents the scope of the context
     *   it must never return a null map
     */
    Map<String, Object> get();
}
