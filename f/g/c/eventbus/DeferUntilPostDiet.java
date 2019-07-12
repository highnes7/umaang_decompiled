package f.g.c.eventbus;

import f.g.c.a.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
@a
public @interface DeferUntilPostDiet {}
