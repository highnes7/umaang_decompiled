package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Nb;
import f.g.c.d.rb;
import java.util.Collection;

@b(emulated=true)
public abstract class TransformedImmutableSet<D, E>
  extends Nb<E>
{
  public final int hashCode;
  public final rb<D> source;
  
  public TransformedImmutableSet(ImmutableCollection paramImmutableCollection)
  {
    source = paramImmutableCollection;
    hashCode = Sets.hashCodeImpl(this);
  }
  
  public TransformedImmutableSet(ImmutableCollection paramImmutableCollection, int paramInt)
  {
    source = paramImmutableCollection;
    hashCode = paramInt;
  }
  
  public final int hashCode()
  {
    return hashCode;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean isHashCodeFast()
  {
    return true;
  }
  
  public UnmodifiableIterator iterator()
  {
    return new Iterables.10.1(this, source.iterator());
  }
  
  public int size()
  {
    return source.size();
  }
  
  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return ObjectArrays.toArrayImpl(this, paramArrayOfObject);
  }
  
  public abstract Object transform(Object paramObject);
}
