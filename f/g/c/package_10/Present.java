package f.g.c.package_10;

import f.g.c.a.b;
import f.g.c.b.X;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Collections;
import java.util.Set;

@b
public final class Present<T>
  extends X<T>
{
  public static final long serialVersionUID = 0L;
  public final T reference;
  
  public Present(Object paramObject)
  {
    reference = paramObject;
  }
  
  public Set asSet()
  {
    return Collections.singleton(reference);
  }
  
  public boolean equals()
  {
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Present))
    {
      paramObject = (Present)paramObject;
      return reference.equals(reference);
    }
    return false;
  }
  
  public Object get()
  {
    return reference;
  }
  
  public Object get(Supplier paramSupplier)
  {
    if (paramSupplier != null) {
      return reference;
    }
    throw new NullPointerException();
  }
  
  public int hashCode()
  {
    return reference.hashCode() + 1502476572;
  }
  
  public Optional or(Optional paramOptional)
  {
    if (paramOptional != null) {
      return this;
    }
    throw new NullPointerException();
  }
  
  public Object or(Object paramObject)
  {
    Preconditions.checkNotNull(paramObject, "use orNull() instead of or(null)");
    return reference;
  }
  
  public Object orNull()
  {
    return reference;
  }
  
  public String toString()
  {
    return StringBuilder.append(StringBuilder.append("Optional.of("), reference, ")");
  }
  
  public Optional transform(Function paramFunction)
  {
    paramFunction = paramFunction.apply(reference);
    Preconditions.checkNotNull(paramFunction, "Transformation function cannot return null.");
    return new Present(paramFunction);
  }
}
