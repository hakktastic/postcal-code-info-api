package nl.hakktastic.pensioenpotapi.shared.architecture.ddd;

import java.lang.annotation.*;

@Documented
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BoundedContext {

    String name() default "";

    String description() default "";
}