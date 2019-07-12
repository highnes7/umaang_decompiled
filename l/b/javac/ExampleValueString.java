package l.b.javac;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import l.b.b.e;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
public @interface ExampleValueString
{
  @e
  public static final String ACTION_ERROR = "io.reactivex:single";
  public static final String CANCEL_MENU = "io.reactivex:trampoline";
  public static final String CODE_CUSTOM = "custom";
  public static final String EVENTLOG_URL = "io.reactivex:io";
  public static final String MODULE_PACKAGE = "io.reactivex:new-thread";
  public static final String PAGE_KEY = "io.reactivex:computation";
  public static final String TYPE_NONE = "none";
  
  String value();
}
