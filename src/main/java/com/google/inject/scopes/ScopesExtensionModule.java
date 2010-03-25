package com.google.inject.scopes;

import com.google.inject.AbstractModule;

public class ScopesExtensionModule extends AbstractModule {

    protected void configure() {
    	ThreadLocalContextHolder threadContext = new ThreadLocalContextHolder();    	
        bindScope(ThreadLocalScoped.class, new ContextScope(threadContext));
    }
}
