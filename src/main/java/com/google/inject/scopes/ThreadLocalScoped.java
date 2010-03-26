package com.google.inject.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.google.inject.ScopeAnnotation;

/**
 * Annotation to be used instead of
 * <code>
 *  bind(Foo.class).to(FooImpl.class).inScope(Scopes.THREAD_LOCAL.get());
 * </code>
 * @author Fabricio Tuosto
 */
@ScopeAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadLocalScoped {
}
