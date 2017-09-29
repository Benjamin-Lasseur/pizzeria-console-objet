package fr.utils;

import java.lang.reflect.Field;

public class StringUtils {
	public static String convert(Object o) {
		String returnedString = "";
		Class<?> classe = o.getClass();
		for (Field field : classe.getDeclaredFields()) {
			if (field.getAnnotation(ToString.class) != null) {
				field.setAccessible(true);
				if (field.getAnnotation(ToString.class).upperCase()) {
					try {
						returnedString += field.get(o).toString().toUpperCase() + " ";
					} catch (IllegalAccessException e) {
						e.getMessage();
					}
				} else {
					try {
						returnedString += field.get(o).toString() + " ";
					} catch (IllegalAccessException e) {
						e.getMessage();
					}
				}
			}
		}
		return returnedString;
	}
}
