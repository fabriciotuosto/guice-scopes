package com.google.inject.scopes;

import org.junit.Ignore;

import com.google.inject.AbstractModule;

@Ignore
public class DummyModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Dummy.class);
	}

}
