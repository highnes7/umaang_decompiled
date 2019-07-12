package f.g.c.cache;

import f.g.c.package_8.Iterators;
import java.util.AbstractQueue;
import java.util.Iterator;

public final class LinkedBlockingQueue
  extends AbstractQueue<Object>
{
  public LinkedBlockingQueue() {}
  
  public Iterator iterator()
  {
    return Iterators.EMPTY_LIST_ITERATOR;
  }
  
  public boolean offer(Object paramObject)
  {
    return true;
  }
  
  public Object peek()
  {
    return null;
  }
  
  public Object poll()
  {
    return null;
  }
  
  public int size()
  {
    return 0;
  }
}
