package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ja;
import java.util.NoSuchElementException;
import java.util.Queue;

@b
public abstract class ForwardingQueue<E>
  extends Ja<E>
  implements Queue<E>
{
  public ForwardingQueue() {}
  
  public abstract Queue delegate();
  
  public Object element()
  {
    return delegate().element();
  }
  
  public boolean offer(Object paramObject)
  {
    return delegate().offer(paramObject);
  }
  
  public Object peek()
  {
    return delegate().peek();
  }
  
  public Object poll()
  {
    return delegate().poll();
  }
  
  public Object remove()
  {
    return delegate().remove();
  }
  
  public boolean standardOffer(Object paramObject)
  {
    try
    {
      boolean bool = add(paramObject);
      return bool;
    }
    catch (IllegalStateException paramObject)
    {
      for (;;) {}
    }
    return false;
  }
  
  public Object standardPeek()
  {
    try
    {
      Object localObject = element();
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public Object standardPoll()
  {
    try
    {
      Object localObject = remove();
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      for (;;) {}
    }
    return null;
  }
}
