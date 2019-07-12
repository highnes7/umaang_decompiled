package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.vb;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;

@b(emulated=true, serializable=true)
public abstract class ImmutableAsList<E>
  extends vb<E>
{
  public ImmutableAsList() {}
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public boolean contains(Object paramObject)
  {
    return delegateCollection().contains(paramObject);
  }
  
  public abstract ImmutableCollection delegateCollection();
  
  public boolean isEmpty()
  {
    return delegateCollection().isEmpty();
  }
  
  public boolean isPartialView()
  {
    return delegateCollection().isPartialView();
  }
  
  public int size()
  {
    return delegateCollection().size();
  }
  
  public Object writeReplace()
  {
    return new mb.a(delegateCollection());
  }
}
