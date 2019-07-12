package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.vb;
import f.g.c.package_10.Preconditions;
import java.util.List;

@b(emulated=true, serializable=true)
public final class SingletonImmutableList<E>
  extends vb<E>
{
  public final transient E element;
  
  public SingletonImmutableList(Object paramObject)
  {
    if (paramObject != null)
    {
      element = paramObject;
      return;
    }
    throw new NullPointerException();
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
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      return (paramObject.size() == 1) && (element.equals(paramObject.get(0)));
    }
    return false;
  }
  
  public Object get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, 1, "index");
    return element;
  }
  
  public int hashCode()
  {
    return element.hashCode() + 31;
  }
  
  public int indexOf(Object paramObject)
  {
    if (element.equals(paramObject)) {
      return 0;
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator iterator()
  {
    return Iterators.singletonIterator(element);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return indexOf(paramObject);
  }
  
  public ImmutableList reverse()
  {
    return this;
  }
  
  public int size()
  {
    return 1;
  }
  
  public ImmutableList subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, 1);
    if (paramInt1 == paramInt2) {
      return ImmutableList.of();
    }
    return this;
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
