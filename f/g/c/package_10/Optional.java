package f.g.c.package_10;

import f.g.c.a.b;
import java.io.Serializable;
import java.util.Set;

@b(serializable=true)
public abstract class Optional<T>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  
  public Optional() {}
  
  public static Optional absent()
  {
    return Absent.INSTANCE;
  }
  
  public static Iterable get(Iterable paramIterable)
  {
    if (paramIterable != null) {
      return new Optional.1(paramIterable);
    }
    throw new NullPointerException();
  }
  
  public static Optional of(Object paramObject)
  {
    if (paramObject != null) {
      return new Present(paramObject);
    }
    throw new NullPointerException();
  }
  
  public static Optional withType(Object paramObject)
  {
    if (paramObject == null) {
      return Absent.INSTANCE;
    }
    return new Present(paramObject);
  }
  
  public abstract Set asSet();
  
  public abstract boolean equals();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract Object get();
  
  public abstract Object get(Supplier paramSupplier);
  
  public abstract int hashCode();
  
  public abstract Optional or(Optional paramOptional);
  
  public abstract Object or(Object paramObject);
  
  public abstract Object orNull();
  
  public abstract String toString();
  
  public abstract Optional transform(Function paramFunction);
}
