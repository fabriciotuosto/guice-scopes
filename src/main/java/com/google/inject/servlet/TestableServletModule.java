package com.google.inject.servlet;

import com.google.inject.AbstractModule;
import com.google.inject.scopes.ContextScope;

public class TestableServletModule extends AbstractModule{

	@Override
	protected void configure() {
		SesstionContextHolder sessionContext = new SesstionContextHolder();
		bindScope(SessionScoped.class, new ContextScope(sessionContext));
		
		RequestContextHolder requestContext = new RequestContextHolder();
		bindScope(RequestScoped.class,new ContextScope(requestContext));
	}

}
