package support.android.text;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER})
public @interface SneakyThrows
{
  RequiresPermission value();
}
