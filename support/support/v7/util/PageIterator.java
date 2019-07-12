package support.support.v7.util;

import b.a.a.b.c.c;
import b.a.a.b.c.f;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class PageIterator<K, V>
  implements Iterator<Map.Entry<K, V>>, c.f<K, V>
{
  public c.c<K, V> last;
  public c.c<K, V> next;
  
  public PageIterator(Node paramNode1, Node paramNode2)
  {
    next = paramNode2;
    last = paramNode1;
  }
  
  private Node getLast()
  {
    Node localNode1 = last;
    Node localNode2 = next;
    if ((localNode1 != localNode2) && (localNode2 != null)) {
      return get(localNode1);
    }
    return null;
  }
  
  public abstract Node get(Node paramNode);
  
  public boolean hasNext()
  {
    return last != null;
  }
  
  public Map.Entry next()
  {
    Node localNode = last;
    last = getLast();
    return localNode;
  }
  
  public void next(Node paramNode)
  {
    if ((next == paramNode) && (paramNode == last))
    {
      last = null;
      next = null;
    }
    Node localNode = next;
    if (localNode == paramNode) {
      next = remove(localNode);
    }
    if (last == paramNode) {
      last = getLast();
    }
  }
  
  public abstract Node remove(Node paramNode);
}
