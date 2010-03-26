package com.google.inject.servlet;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.google.inject.scopes.ContextHolder;

public class SesstionContextHolder implements ContextHolder {

    /**
     *
     * @return an session.attribute view as a map that is valid
     * for the current session
     */
    public Map<String, Object> get() {
        HttpSession session = GuiceFilter.getRequest().getSession();
        return new SessionAttributesAsMap(session);
    }

    /**
     * Class that view the Attributes of a HttpSession as a Map
     * to homogenize an API in ContextHolder
     */
    @SuppressWarnings("serial")
    class SessionAttributesAsMap extends HashMap<String, Object> {

        private final HttpSession session;

        public SessionAttributesAsMap(HttpSession session) {
            this.session = session;
            @SuppressWarnings("unchecked")
            Enumeration<String> enumeration = session.getAttributeNames();
            while (enumeration.hasMoreElements()) {
                String key = enumeration.nextElement();
                super.put(key, session.getAttribute(key));
            }
        }

        public Object get(Object key) {
            session.getAttribute(String.valueOf(key));
            return super.get(key);
        }

        public Object put(String key, Object value) {
            session.setAttribute(key, value);
            return super.put(key, value);
        }
    }
}
