package f.g.c.package_8;

import f.g.c.a.b;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

@b(emulated=true)
public final class ObjectArrays
{
  public static final Object[] EMPTY_ARRAY = new Object[0];
  
  public ObjectArrays() {}
  
  public static Object[] add(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = Platform.newArray(paramArrayOfObject, paramInt);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, Math.min(paramArrayOfObject.length, paramInt));
    return arrayOfObject;
  }
  
  public static Object[] add(Object[] paramArrayOfObject, Object paramObject)
  {
    Object[] arrayOfObject = add(paramArrayOfObject, paramArrayOfObject.length + 1);
    arrayOfObject[paramArrayOfObject.length] = paramObject;
    return arrayOfObject;
  }
  
  public static Object[] concat(Object paramObject, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = Platform.newArray(paramArrayOfObject, paramArrayOfObject.length + 1);
    arrayOfObject[0] = paramObject;
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 1, paramArrayOfObject.length);
    return arrayOfObject;
  }
  
  public static Object[] concat(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, Class paramClass)
  {
    paramClass = newArray(paramClass, paramArrayOfObject1.length + paramArrayOfObject2.length);
    System.arraycopy(paramArrayOfObject1, 0, paramClass, 0, paramArrayOfObject1.length);
    System.arraycopy(paramArrayOfObject2, 0, paramClass, paramArrayOfObject1.length, paramArrayOfObject2.length);
    return paramClass;
  }
  
  public static Object[] fillArray(Iterable paramIterable, Object[] paramArrayOfObject)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      paramArrayOfObject[i] = paramIterable.next();
      i += 1;
    }
    return paramArrayOfObject;
  }
  
  public static Object get(Object paramObject, int paramInt)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new NullPointerException(StringBuilder.toString("at index ", paramInt));
  }
  
  public static Object[] newArray(Class paramClass, int paramInt)
  {
    return (Object[])Array.newInstance(paramClass, paramInt);
  }
  
  public static Object[] newArray(Object[] paramArrayOfObject, int paramInt)
  {
    return Platform.newArray(paramArrayOfObject, paramInt);
  }
  
  public static void swap(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    Object localObject = paramArrayOfObject[paramInt1];
    paramArrayOfObject[paramInt1] = paramArrayOfObject[paramInt2];
    paramArrayOfObject[paramInt2] = localObject;
  }
  
  public static Object[] toArrayImpl(Collection paramCollection)
  {
    Object[] arrayOfObject = new Object[paramCollection.size()];
    fillArray(paramCollection, arrayOfObject);
    return arrayOfObject;
  }
  
  public static Object[] toArrayImpl(Collection paramCollection, Object[] paramArrayOfObject)
  {
    int i = paramCollection.size();
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject.length < i) {
      arrayOfObject = Platform.newArray(paramArrayOfObject, i);
    }
    fillArray(paramCollection, arrayOfObject);
    if (arrayOfObject.length > i) {
      arrayOfObject[i] = null;
    }
    return arrayOfObject;
  }
}
