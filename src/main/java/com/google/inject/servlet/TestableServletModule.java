package com.google.inject.servlet;

import com.google.inject.AbstractModule;
import com.google.inject.scopes.Scopes;

/**
 * extension for javax.servlet scope binding allowing to be moddiffied
 * for testing purposes
 * 
 * @author Fabricio Tuosto
 */
public class TestableServletModule extends AbstractModule {

    protected void configure() {
        bindScope(SessionScoped.class, Scopes.SESSION);

        bindScope(RequestScoped.class, Scopes.REQUEST);
    }
}
