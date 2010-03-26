package com.google.inject.servlet;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.inject.scopes.ContextHolder;

public class RequestContextHolder implements ContextHolder {

        /**
     *
     * @return an request.attribute view as a map that is valid
     * for the current request
     */
    public Map<String, Object> get() {
        HttpServletRequest request = GuiceFilter.getRequest();
        return new RequestAttributesAsMap(request);
    }

    @SuppressWarnings("serial")
    class RequestAttributesAsMap extends HashMap<String, Object> {

        private final HttpServletRequest request;

        public RequestAttributesAsMap(HttpServletRequest request) {
            this.request = request;
            @SuppressWarnings("unchecked")
            Enumeration<String> enumeration = request.getAttributeNames();
            while (enumeration.hasMoreElements()) {
                String key = enumeration.nextElement();
                super.put(key, request.getAttribute(key));
            }
        }

        @Override
        public Object get(Object key) {
            request.getAttribute(String.valueOf(key));
            return super.get(key);
        }

        @Override
        public Object put(String key, Object value) {
            request.setAttribute(key, value);
            return super.put(key, value);
        }
    }
}
