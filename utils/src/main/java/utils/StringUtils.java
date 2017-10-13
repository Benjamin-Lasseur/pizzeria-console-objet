package utils;

import java.lang.reflect.Field;

public class StringUtils {
	public static String convert(Object o) {
		StringBuilder returnedString = new StringBuilder();
		Class<?> classe = o.getClass();
		for (Field field : classe.getDeclaredFields()) {
			if (field.getAnnotation(ToString.class) != null) {
				field.setAccessible(true);
				if (field.getAnnotation(ToString.class).upperCase()) {
					try {
						returnedString.append(field.get(o).toString().toUpperCase()).append(" ");
					} catch (IllegalAccessException e) {
						e.getMessage();
					}
				} else {
					try {
						returnedString.append(field.get(o).toString()).append(" ");
					} catch (IllegalAccessException e) {
						e.getMessage();
					}
				}
			}
		}
		return returnedString.toString();
	}
}
