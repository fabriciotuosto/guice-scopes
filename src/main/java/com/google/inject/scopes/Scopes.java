/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.google.inject.scopes;

import com.google.inject.Scope;
import com.google.inject.servlet.RequestContextHolder;
import com.google.inject.servlet.SesstionContextHolder;

/**
 *
 * @author Fabricio Tuosto
 */
public interface Scopes{

    public final Scope THREAD_LOCAL = new ContextScope(new ThreadLocalContextHolder());
    public final Scope SESSION = new ContextScope(new RequestContextHolder());
    public final Scope REQUEST = new ContextScope(new SesstionContextHolder());

}
