package f.g.c.package_10;

import f.g.c.a.b;
import f.g.c.b.C;
import f.g.c.b.ca;
import java.io.Serializable;
import java.util.Arrays;
import m.a.h;

@b
public abstract class Equivalence<T>
{
  public Equivalence() {}
  
  public static Equivalence equals()
  {
    return Equals.INSTANCE;
  }
  
  public static Equivalence identity()
  {
    return Identity.INSTANCE;
  }
  
  public abstract boolean doEquivalent(Object paramObject1, Object paramObject2);
  
  public abstract int doHash(Object paramObject);
  
  public final boolean equivalent(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if ((paramObject1 != null) && (paramObject2 != null)) {
      return doEquivalent(paramObject1, paramObject2);
    }
    return false;
  }
  
  public final Predicate equivalentTo(Object paramObject)
  {
    return new EquivalentToPredicate(paramObject);
  }
  
  public final int hash(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return doHash(paramObject);
  }
  
  public final Equivalence onResultOf(Function paramFunction)
  {
    return new FunctionalEquivalence(paramFunction, this);
  }
  
  public final Equivalence pairwise()
  {
    return new PairwiseEquivalence(this);
  }
  
  public final Wrapper wrap(Object paramObject)
  {
    return new Wrapper(paramObject);
  }
  
  public final class Equals
    extends C<Object>
    implements Serializable
  {
    public static final Equals INSTANCE = new Equals();
    public static final long serialVersionUID = 1L;
    
    public Equals() {}
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public boolean doEquivalent(Object paramObject1, Object paramObject2)
    {
      return paramObject1.equals(paramObject2);
    }
    
    public int doHash(Object paramObject)
    {
      return paramObject.hashCode();
    }
  }
  
  public final class EquivalentToPredicate<T>
    implements ca<T>, Serializable
  {
    public static final long serialVersionUID = 0L;
    @h
    public final T target;
    
    public EquivalentToPredicate(Object paramObject)
    {
      if (Equivalence.this != null)
      {
        target = paramObject;
        return;
      }
      throw new NullPointerException();
    }
    
    public boolean apply(Object paramObject)
    {
      return equivalent(paramObject, target);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof EquivalentToPredicate))
      {
        paramObject = (EquivalentToPredicate)paramObject;
        return (Equivalence.this.equals(equivalence)) && (Objects.equal(target, target));
      }
      return false;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Object[] { Equivalence.this, target });
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Equivalence.this);
      localStringBuilder.append(".equivalentTo(");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, target, ")");
    }
  }
  
  public final class Identity
    extends C<Object>
    implements Serializable
  {
    public static final Identity INSTANCE = new Identity();
    public static final long serialVersionUID = 1L;
    
    public Identity() {}
    
    private Object readResolve()
    {
      return INSTANCE;
    }
    
    public boolean doEquivalent(Object paramObject1, Object paramObject2)
    {
      return false;
    }
    
    public int doHash(Object paramObject)
    {
      return System.identityHashCode(paramObject);
    }
  }
  
  public final class Wrapper<T>
    implements Serializable
  {
    public static final long serialVersionUID = 0L;
    @h
    public final T reference;
    
    public Wrapper(Object paramObject)
    {
      if (Equivalence.this != null)
      {
        reference = paramObject;
        return;
      }
      throw new NullPointerException();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if ((paramObject instanceof Wrapper))
      {
        paramObject = (Wrapper)paramObject;
        Equivalence localEquivalence = Equivalence.this;
        return (localEquivalence.equals(equivalence)) && (localEquivalence.equivalent(reference, reference));
      }
      return false;
    }
    
    public Object get()
    {
      return reference;
    }
    
    public int hashCode()
    {
      return hash(reference);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Equivalence.this);
      localStringBuilder.append(".wrap(");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, reference, ")");
    }
  }
}
