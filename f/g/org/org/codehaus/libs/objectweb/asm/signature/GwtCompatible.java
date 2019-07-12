package f.g.org.org.codehaus.libs.objectweb.asm.signature;

import f.g.b.a.e.a.a.a.a.b;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
@b
public @interface GwtCompatible
{
  boolean emulated();
  
  boolean serializable();
}
