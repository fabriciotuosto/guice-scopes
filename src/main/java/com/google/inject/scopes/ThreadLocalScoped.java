package com.google.inject.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.ScopeAnnotation;

@ScopeAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadLocalScoped {
}
