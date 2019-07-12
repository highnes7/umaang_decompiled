package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.th;
import java.util.ListIterator;

@b
public abstract class UnmodifiableListIterator<E>
  extends th<E>
  implements ListIterator<E>
{
  public UnmodifiableListIterator() {}
  
  public final void add(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void set(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
}
