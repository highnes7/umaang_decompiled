package m.a.javac;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Documented
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface RequiredArgsConstructor {}
