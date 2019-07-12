package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Nb;
import java.util.Iterator;
import java.util.Set;

@b(emulated=true, serializable=true)
public final class SingletonImmutableSet<E>
  extends Nb<E>
{
  public transient int cachedHashCode;
  public final transient E element;
  
  public SingletonImmutableSet(Object paramObject)
  {
    if (paramObject != null)
    {
      element = paramObject;
      return;
    }
    throw new NullPointerException();
  }
  
  public SingletonImmutableSet(Object paramObject, int paramInt)
  {
    element = paramObject;
    cachedHashCode = paramInt;
  }
  
  public boolean contains(Object paramObject)
  {
    return element.equals(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      return (paramObject.size() == 1) && (element.equals(paramObject.iterator().next()));
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = cachedHashCode;
    int i = j;
    if (j == 0)
    {
      i = element.hashCode();
      cachedHashCode = i;
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isHashCodeFast()
  {
    return cachedHashCode != 0;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator iterator()
  {
    return Iterators.singletonIterator(element);
  }
  
  public int size()
  {
    return 1;
  }
  
  public Object[] toArray()
  {
    return new Object[] { element };
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject;
    if (paramArrayOfObject.length == 0)
    {
      arrayOfObject = ObjectArrays.newArray(paramArrayOfObject, 1);
    }
    else
    {
      arrayOfObject = paramArrayOfObject;
      if (paramArrayOfObject.length > 1)
      {
        paramArrayOfObject[1] = null;
        arrayOfObject = paramArrayOfObject;
      }
    }
    arrayOfObject[0] = element;
    return arrayOfObject;
  }
  
  public String toString()
  {
    String str = element.toString();
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 2);
    localStringBuilder.append('[');
    localStringBuilder.append(str);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}
