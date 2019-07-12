package f.g.c.package_10;

import f.g.c.a.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@b
public final class Objects
{
  public Objects() {}
  
  public static boolean equal(Object paramObject1, Object paramObject2)
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
  
  public static ToStringHelper toStringHelper(Class paramClass)
  {
    return new ToStringHelper(simpleName(paramClass));
  }
  
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(simpleName(paramObject.getClass()));
  }
  
  public static ToStringHelper toStringHelper(String paramString)
  {
    return new ToStringHelper();
  }
  
  public final class ToStringHelper
  {
    public boolean omitNullValues = false;
    public final List<f.g.c.b.U.a.a> valueHolders = new LinkedList();
    
    public ToStringHelper()
    {
      if (Objects.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    private StringBuilder add(String paramString)
    {
      if (paramString != null)
      {
        StringBuilder localStringBuilder = addHolderbuilder;
        localStringBuilder.append(paramString);
        localStringBuilder.append('=');
        return localStringBuilder;
      }
      throw new NullPointerException();
    }
    
    private U.a.a addHolder()
    {
      U.a.a localA = new U.a.a();
      valueHolders.add(localA);
      return localA;
    }
    
    private U.a.a addHolder(Object paramObject)
    {
      U.a.a localA = addHolder();
      boolean bool;
      if (paramObject == null) {
        bool = true;
      } else {
        bool = false;
      }
      isNull = bool;
      return localA;
    }
    
    public ToStringHelper add(String paramString, char paramChar)
    {
      add(paramString).append(paramChar);
      return this;
    }
    
    public ToStringHelper add(String paramString, double paramDouble)
    {
      add(paramString).append(paramDouble);
      return this;
    }
    
    public ToStringHelper add(String paramString, float paramFloat)
    {
      add(paramString).append(paramFloat);
      return this;
    }
    
    public ToStringHelper add(String paramString, int paramInt)
    {
      add(paramString).append(paramInt);
      return this;
    }
    
    public ToStringHelper add(String paramString, long paramLong)
    {
      add(paramString).append(paramLong);
      return this;
    }
    
    public ToStringHelper add(String paramString, Object paramObject)
    {
      if (paramString != null)
      {
        StringBuilder localStringBuilder = addHolderbuilder;
        localStringBuilder.append(paramString);
        localStringBuilder.append('=');
        localStringBuilder.append(paramObject);
        return this;
      }
      throw new NullPointerException();
    }
    
    public ToStringHelper add(String paramString, boolean paramBoolean)
    {
      add(paramString).append(paramBoolean);
      return this;
    }
    
    public ToStringHelper addValue(char paramChar)
    {
      addHolderbuilder.append(paramChar);
      return this;
    }
    
    public ToStringHelper addValue(double paramDouble)
    {
      addHolderbuilder.append(paramDouble);
      return this;
    }
    
    public ToStringHelper addValue(float paramFloat)
    {
      addHolderbuilder.append(paramFloat);
      return this;
    }
    
    public ToStringHelper addValue(int paramInt)
    {
      addHolderbuilder.append(paramInt);
      return this;
    }
    
    public ToStringHelper addValue(long paramLong)
    {
      addHolderbuilder.append(paramLong);
      return this;
    }
    
    public ToStringHelper addValue(Object paramObject)
    {
      addHolderbuilder.append(paramObject);
      return this;
    }
    
    public ToStringHelper addValue(boolean paramBoolean)
    {
      addHolderbuilder.append(paramBoolean);
      return this;
    }
    
    public ToStringHelper omitNullValues()
    {
      omitNullValues = true;
      return this;
    }
    
    public String toString()
    {
      boolean bool = omitNullValues;
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append(Objects.this);
      localStringBuilder.append('{');
      Iterator localIterator = valueHolders.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        U.a.a localA = (U.a.a)localIterator.next();
        if ((!bool) || (!isNull))
        {
          if (i != 0) {
            localStringBuilder.append(", ");
          } else {
            i = 1;
          }
          localStringBuilder.append(builder);
        }
      }
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}
