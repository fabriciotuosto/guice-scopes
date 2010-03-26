package com.google.inject.scopes;

import com.google.inject.AbstractModule;

/**
 * Module that will configure any scope that is related to java only
 * applications
 * @author Fabricio Tuosto
 */
public class ScopesExtensionModule extends AbstractModule {

    protected void configure() {
        bindScope(ThreadLocalScoped.class, Scopes.THREAD_LOCAL);
    }
}
