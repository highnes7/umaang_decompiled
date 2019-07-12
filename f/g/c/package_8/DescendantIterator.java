package f.g.c.package_8;

import f.g.c.d.th;
import java.util.Iterator;
import java.util.Map.Entry;

public class DescendantIterator
  extends th<Map.Entry<K, V>>
{
  public Iterator<V> iterator;
  public K nextIterator;
  
  public DescendantIterator(Ib.c paramC, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return ((nextIterator != null) && (iterator.hasNext())) || (current.hasNext());
  }
  
  public Map.Entry next()
  {
    if ((nextIterator == null) || (!iterator.hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)current.next();
      nextIterator = localEntry.getKey();
      iterator = ((ImmutableCollection)localEntry.getValue()).iterator();
    }
    return Maps.immutableEntry(nextIterator, iterator.next());
  }
}
