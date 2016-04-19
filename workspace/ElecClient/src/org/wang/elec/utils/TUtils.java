package org.wang.elec.utils;

import java.lang.reflect.ParameterizedType;

public class TUtils {

	@SuppressWarnings("rawtypes")
	public static Class getActualType(Class entity) {
		ParameterizedType parameterizedType = (ParameterizedType) entity
				.getGenericSuperclass();
		Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
		return entityClass;
	}

}
