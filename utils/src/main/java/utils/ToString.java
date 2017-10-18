package utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
	/**
	 * Constructeur de l'annotation ToString avec le champs upperCase
	 * 
	 * @return
	 */
	boolean upperCase() default false;
}
