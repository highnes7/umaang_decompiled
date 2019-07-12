package m.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import m.a.b.e;
import m.a.javac.CommentInfo.StartConnection;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@o("RegEx")
@e
public @interface FieldDefaults
{
  CommentInfo.StartConnection when();
}
