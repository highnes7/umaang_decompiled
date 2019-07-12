package f.g.org.org.codehaus.libs.objectweb.asm.asm;

import f.g.b.a.e.a.a.a.a.b;

@b
public final class Preconditions
{
  public Preconditions() {}
  
  public static void append(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static String badElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < 0) {
      return format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 >= 0) {
      return format("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("negative size: ", paramInt2));
  }
  
  public static String badPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 < 0) {
      return format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 >= 0) {
      return format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("negative size: ", paramInt2));
  }
  
  public static String badPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt3))
    {
      if ((paramInt2 >= 0) && (paramInt2 <= paramInt3)) {
        return format("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      }
      return badPositionIndex(paramInt2, paramInt3, "end index");
    }
    return badPositionIndex(paramInt1, paramInt3, "start index");
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(format(paramString, paramVarArgs));
  }
  
  public static int checkElementIndex(int paramInt1, int paramInt2)
  {
    checkElementIndex(paramInt1, paramInt2, "index");
    return paramInt1;
  }
  
  public static int checkElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 >= 0) && (paramInt1 < paramInt2)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException(badElementIndex(paramInt1, paramInt2, paramString));
  }
  
  public static Object checkNotNull(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new NullPointerException();
  }
  
  public static Object checkNotNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1;
    }
    throw new NullPointerException(String.valueOf(paramObject2));
  }
  
  public static Object checkNotNull(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new NullPointerException(format(paramString, paramVarArgs));
  }
  
  public static int checkPositionIndex(int paramInt1, int paramInt2)
  {
    checkPositionIndex(paramInt1, paramInt2, "index");
    return paramInt1;
  }
  
  public static int checkPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException(badPositionIndex(paramInt1, paramInt2, paramString));
  }
  
  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 <= paramInt3)) {
      return;
    }
    throw new IndexOutOfBoundsException(badPositionIndexes(paramInt1, paramInt2, paramInt3));
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(format(paramString, paramVarArgs));
  }
  
  public static String format(String paramString, Object... paramVarArgs)
  {
    paramString = String.valueOf(paramString);
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 16 + i);
    i = 0;
    int j = 0;
    while (i < paramVarArgs.length)
    {
      int k = paramString.indexOf("%s", j);
      if (k == -1) {
        break;
      }
      localStringBuilder.append(paramString.substring(j, k));
      localStringBuilder.append(paramVarArgs[i]);
      j = k + 2;
      i += 1;
    }
    localStringBuilder.append(paramString.substring(j));
    if (i < paramVarArgs.length)
    {
      localStringBuilder.append(" [");
      j = i + 1;
      localStringBuilder.append(paramVarArgs[i]);
      i = j;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
      localStringBuilder.append(']');
    }
    return localStringBuilder.toString();
  }
  
  public static void set(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
}
