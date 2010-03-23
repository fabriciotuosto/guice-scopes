package com.google.inject.scopes.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.ScopeAnnotation;

@ScopeAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadLocal {

}
