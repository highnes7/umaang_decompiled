package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.vb;
import f.g.c.package_10.Preconditions;
import java.util.Iterator;
import java.util.List;

@b(emulated=true, serializable=true)
public class RegularImmutableList<E>
  extends vb<E>
{
  public final transient Object[] array;
  public final transient int offset;
  public final transient int size;
  
  public RegularImmutableList(Object[] paramArrayOfObject)
  {
    offset = 0;
    size = i;
    array = paramArrayOfObject;
  }
  
  public RegularImmutableList(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    offset = paramInt1;
    size = paramInt2;
    array = paramArrayOfObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    Object localObject = (List)paramObject;
    if (size() != ((List)localObject).size()) {
      return false;
    }
    int i = offset;
    if ((paramObject instanceof RegularImmutableList))
    {
      paramObject = (RegularImmutableList)paramObject;
      int j = offset;
      while (j < offset + size)
      {
        if (!array[i].equals(array[j])) {
          return false;
        }
        j += 1;
        i += 1;
      }
    }
    paramObject = ((List)localObject).iterator();
    while (paramObject.hasNext())
    {
      localObject = paramObject.next();
      if (!array[i].equals(localObject)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Object get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, size, "index");
    return array[(paramInt + offset)];
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isPartialView()
  {
    return (offset != 0) || (size != array.length);
  }
  
  public UnmodifiableListIterator listIterator(int paramInt)
  {
    return Iterators.forArray(array, offset, size, paramInt);
  }
  
  public int size()
  {
    return size;
  }
  
  public ImmutableList subListUnchecked(int paramInt1, int paramInt2)
  {
    return new RegularImmutableList(array, offset + paramInt1, paramInt2 - paramInt1);
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    System.arraycopy(array, offset, arrayOfObject, 0, size);
    return arrayOfObject;
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    int j = size;
    Object[] arrayOfObject;
    if (i < j)
    {
      arrayOfObject = ObjectArrays.newArray(paramArrayOfObject, j);
    }
    else
    {
      arrayOfObject = paramArrayOfObject;
      if (paramArrayOfObject.length > j)
      {
        paramArrayOfObject[j] = null;
        arrayOfObject = paramArrayOfObject;
      }
    }
    System.arraycopy(array, offset, arrayOfObject, 0, size);
    return arrayOfObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = Collections2.append(size());
    localStringBuilder.append('[');
    localStringBuilder.append(array[offset]);
    int i = offset;
    for (;;)
    {
      i += 1;
      if (i >= offset + size) {
        break;
      }
      localStringBuilder.append(", ");
      localStringBuilder.append(array[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}
