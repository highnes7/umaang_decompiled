package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mb;
import f.g.c.d.rb;
import f.g.c.d.vb;
import java.util.List;

@b
public class RegularImmutableAsList<E>
  extends mb<E>
{
  public final rb<E> delegate;
  public final vb<? extends E> delegateList;
  
  public RegularImmutableAsList(ImmutableCollection paramImmutableCollection, ImmutableList paramImmutableList)
  {
    delegate = paramImmutableCollection;
    delegateList = paramImmutableList;
  }
  
  public RegularImmutableAsList(ImmutableCollection paramImmutableCollection, Object[] paramArrayOfObject)
  {
    delegate = paramImmutableCollection;
    delegateList = paramArrayOfObject;
  }
  
  public ImmutableCollection delegateCollection()
  {
    return delegate;
  }
  
  public ImmutableList delegateList()
  {
    return delegateList;
  }
  
  public boolean equals(Object paramObject)
  {
    return delegateList.equals(paramObject);
  }
  
  public Object get(int paramInt)
  {
    return delegateList.get(paramInt);
  }
  
  public int hashCode()
  {
    return delegateList.hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return delegateList.indexOf(paramObject);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return delegateList.lastIndexOf(paramObject);
  }
  
  public UnmodifiableListIterator listIterator(int paramInt)
  {
    return delegateList.listIterator(paramInt);
  }
  
  public Object[] toArray()
  {
    return delegateList.toArray();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return delegateList.toArray(paramArrayOfObject);
  }
}
