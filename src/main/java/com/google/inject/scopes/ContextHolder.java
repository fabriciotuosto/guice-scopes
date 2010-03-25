package com.google.inject.scopes;

import java.util.Map;

public interface ContextHolder {

	Map<String,Object> get();
}
