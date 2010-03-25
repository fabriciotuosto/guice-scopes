package com.google.inject.scopes;

import com.google.inject.AbstractModule;
import com.google.inject.scopes.annotations.ThreadLocal;

public class ScopesExtensionModule extends AbstractModule {

    @Override
    protected void configure() {
        bindScope(ThreadLocal.class, ThreadLocalScope.THREAD_LOCAL);
    }
}
