package m.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import m.a.b.c;
import m.a.javac.CommentInfo.StartConnection;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@c
public @interface NoArgsConstructor
{
  CommentInfo.StartConnection when();
}
