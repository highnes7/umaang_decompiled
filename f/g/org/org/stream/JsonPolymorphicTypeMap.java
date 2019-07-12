package f.g.org.org.stream;

import f.g.b.a.g.h;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
@h
public @interface JsonPolymorphicTypeMap
{
  TypeDef[] typeDefinitions();
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public @interface TypeDef
  {
    String key();
    
    Class ref();
  }
}
