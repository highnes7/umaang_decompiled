package f.g.org.org.codehaus.libs.objectweb.asm.asm;

import f.g.b.a.e.a.a.a.a.b;
import java.util.Arrays;

@b
public final class Objects
{
  public Objects() {}
  
  public static h c(String paramString)
  {
    return new h(paramString);
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static Object firstNonNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1;
    }
    if (paramObject2 != null) {
      return paramObject2;
    }
    throw new NullPointerException();
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static String simpleName(Class paramClass)
  {
    paramClass = paramClass.getName().replaceAll("\\$[0-9]+", "\\$");
    int j = paramClass.lastIndexOf('$');
    int i = j;
    if (j == -1) {
      i = paramClass.lastIndexOf('.');
    }
    return paramClass.substring(i + 1);
  }
  
  public static h toStringHelper(Class paramClass)
  {
    return new h(simpleName(paramClass));
  }
  
  public static h toStringHelper(Object paramObject)
  {
    return new h(simpleName(paramObject.getClass()));
  }
}
