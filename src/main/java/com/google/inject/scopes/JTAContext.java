
package com.google.inject.scopes;

import java.util.Map;

/**
 * Este contexto esta basado en el tiempo de vida de la transaccion en curso.
 * TODO: De no existir transaccion, deberia crearla?
 * 
 * @author sebasjm at computer dot org
 */
public class JTAContext implements ContextHolder{



    public Map<String, Object> get() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
