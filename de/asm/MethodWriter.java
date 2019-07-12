package de.asm;

import b.b.a.N;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.TYPE})
@N({b.b.a.N.a.b})
public @interface MethodWriter
{
  boolean allowSerialization();
  
  int[] deprecatedIds();
  
  boolean ignoreParcelables();
  
  boolean isCustom();
  
  String jetifyAs();
}
