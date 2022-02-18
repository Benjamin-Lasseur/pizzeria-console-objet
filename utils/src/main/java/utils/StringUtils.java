package utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {
	/** LOG : Logger */
	private static final Logger LOG = LoggerFactory.getLogger(StringUtils.class);

	/**
	 * Constructeur private pour ne pas instancier cette classe
	 */
	private StringUtils() {


	}

	/**
	 * Retourne une String adaptée en fonction des annotations présentes sur les
	 * attributs d'un objet
	 * 
	 * @param o
	 * @return
	 */
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
