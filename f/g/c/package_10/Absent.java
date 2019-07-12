package f.g.c.package_10;

import f.g.c.a.b;
import f.g.c.b.X;
import java.util.Collections;
import java.util.Set;

@b
public final class Absent
  extends X<Object>
{
  public static final Absent INSTANCE = new Absent();
  public static final long serialVersionUID = 0L;
  
  public Absent() {}
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public Set asSet()
  {
    return Collections.emptySet();
  }
  
  public boolean equals()
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
  
  public Object get()
  {
    throw new IllegalStateException("value is absent");
  }
  
  public Object get(Supplier paramSupplier)
  {
    paramSupplier = paramSupplier.get();
    Preconditions.checkNotNull(paramSupplier, "use orNull() instead of a Supplier that returns null");
    return paramSupplier;
  }
  
  public int hashCode()
  {
    return 1502476572;
  }
  
  public Optional or(Optional paramOptional)
  {
    if (paramOptional != null) {
      return paramOptional;
    }
    throw new NullPointerException();
  }
  
  public Object or(Object paramObject)
  {
    Preconditions.checkNotNull(paramObject, "use orNull() instead of or(null)");
    return paramObject;
  }
  
  public Object orNull()
  {
    return null;
  }
  
  public String toString()
  {
    return "Optional.absent()";
  }
  
  public Optional transform(Function paramFunction)
  {
    if (paramFunction != null) {
      return INSTANCE;
    }
    throw new NullPointerException();
  }
}
