package de.hsw.jee.sample.transaction;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@Inherited
@InterceptorBinding
public @interface WithTransaction {

}
