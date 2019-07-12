package f.g.org.org.util;

public final class Preconditions
{
  public Preconditions() {}
  
  public static Object append(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new NullPointerException();
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.append(paramBoolean);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkArgument(paramBoolean, paramObject);
  }
  
  public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkArgument(paramBoolean, paramString, paramVarArgs);
  }
  
  public static Object checkNotNull(Object paramObject1, Object paramObject2)
  {
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkNotNull(paramObject1, paramObject2);
    return paramObject1;
  }
  
  public static Object checkNotNull(Object paramObject, String paramString, Object... paramVarArgs)
  {
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkNotNull(paramObject, paramString, paramVarArgs);
    return paramObject;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.set(paramBoolean);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkState(paramBoolean, paramObject);
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkState(paramBoolean, paramString, paramVarArgs);
  }
}
