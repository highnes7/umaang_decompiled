package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.vb;
import f.g.c.package_10.Preconditions;
import java.util.Collection;
import java.util.List;

@b(emulated=true, serializable=true)
public final class EmptyImmutableList
  extends vb<Object>
{
  public static final EmptyImmutableList INSTANCE = new EmptyImmutableList();
  public static final long serialVersionUID = 0L;
  
  public EmptyImmutableList() {}
  
  public boolean contains(Object paramObject)
  {
    return false;
  }
  
  public boolean containsAll(Collection paramCollection)
  {
    return paramCollection.isEmpty();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof List)) {
      return ((List)paramObject).isEmpty();
    }
    return false;
  }
  
  public Object get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, 0, "index");
    throw new AssertionError("unreachable");
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public int indexOf(Object paramObject)
  {
    return -1;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator iterator()
  {
    return listIterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return -1;
  }
  
  public UnmodifiableListIterator listIterator()
  {
    return Iterators.EMPTY_LIST_ITERATOR;
  }
  
  public UnmodifiableListIterator listIterator(int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, 0, "index");
    return Iterators.EMPTY_LIST_ITERATOR;
  }
  
  public Object readResolve()
  {
    return INSTANCE;
  }
  
  public ImmutableList reverse()
  {
    return this;
  }
  
  public int size()
  {
    return 0;
  }
  
  public ImmutableList subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, 0);
    return this;
  }
  
  public Object[] toArray()
  {
    return ObjectArrays.EMPTY_ARRAY;
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length > 0) {
      paramArrayOfObject[0] = null;
    }
    return paramArrayOfObject;
  }
  
  public String toString()
  {
    return "[]";
  }
}
