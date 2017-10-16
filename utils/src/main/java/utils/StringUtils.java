package utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {
	private static final Logger LOG = LoggerFactory.getLogger(StringUtils.class);

	private StringUtils() {

	}

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
						LOG.error(e.getMessage(), e);
					}
				} else {
					try {
						returnedString.append(field.get(o).toString()).append(" ");
					} catch (IllegalAccessException e) {
						LOG.error(e.getMessage(), e);
					}
				}
			}
		}
		return returnedString.toString();
	}
}
