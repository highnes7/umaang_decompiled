package f.g.c.package_8;

import java.util.Iterator;
import java.util.Set;

public final class Signature
  extends f.g.c.d.gg.g<E>
{
  public Signature(Set paramSet1, Set paramSet2, Set paramSet3)
  {
    super(null);
  }
  
  public boolean contains(Object paramObject)
  {
    return (keys.contains(paramObject)) || (values.contains(paramObject));
  }
  
  public ImmutableSet get()
  {
    return new Nb.b(4).addAll(keys).addAll(values).build();
  }
  
  public boolean isEmpty()
  {
    return (keys.isEmpty()) && (values.isEmpty());
  }
  
  public Iterator iterator()
  {
    return Iterators.unmodifiableIterator(Iterators.concat(keys.iterator(), fields.iterator()));
  }
  
  public Set set(Set paramSet)
  {
    paramSet.addAll(keys);
    paramSet.addAll(values);
    return paramSet;
  }
  
  public int size()
  {
    int i = keys.size();
    return fields.size() + i;
  }
}
