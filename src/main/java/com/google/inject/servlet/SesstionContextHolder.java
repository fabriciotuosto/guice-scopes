package com.google.inject.servlet;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.google.inject.scopes.ContextHolder;

public class SesstionContextHolder implements ContextHolder {

	public Map<String, Object> get() {
		HttpSession session = GuiceFilter.getRequest().getSession();
		return new SessionAttributesAsMap(session);
	}

	@SuppressWarnings("serial")
	class SessionAttributesAsMap extends HashMap<String, Object>{

		private final HttpSession session;

		public SessionAttributesAsMap(HttpSession session) {
			this.session = session;
			@SuppressWarnings("unchecked")
			Enumeration<String> enumeration = session.getAttributeNames();
			while(enumeration.hasMoreElements()){
				String key = enumeration.nextElement();
				super.put(key, session.getAttribute(key));
			}
		}

		@Override
		public Object get(Object key) {
			session.getAttribute(String.valueOf(key));
			return super.get(key);
		}

		@Override
		public Object put(String key, Object value) {
			session.setAttribute(key, value);
			return super.put(key, value);
		}	
	}
}
