package f.g.c.package_10;

import f.g.c.a.b;
import f.g.c.b.J;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

@b
public final class Functions
{
  public Functions() {}
  
  public static Function compose(Function paramFunction1, Function paramFunction2)
  {
    return new FunctionComposition(paramFunction2);
  }
  
  public static Function determineStartConnection()
  {
    return CommentInfo.StartConnection.AFTER_PREVIOUS;
  }
  
  public static Function forMap(Object paramObject)
  {
    return new Range(paramObject);
  }
  
  public static Function forMap(Map paramMap)
  {
    return new FunctionForMapNoDefault();
  }
  
  public static Function forMap(Map paramMap, Object paramObject)
  {
    return new ForMapWithDefault(paramObject);
  }
  
  public static Function forPredicate(Predicate paramPredicate)
  {
    return new PredicateFunction(null);
  }
  
  public static Function forSupplier(Supplier paramSupplier)
  {
    return new SupplierFunction(null);
  }
  
  public static Function length()
  {
    return MathArrays.OrderDirection.DECREASING;
  }
  
  public class ForMapWithDefault<K, V>
    implements J<K, V>, Serializable
  {
    public static final long serialVersionUID = 0L;
    public final V defaultValue;
    
    public ForMapWithDefault(Object paramObject)
    {
      if (Functions.this != null)
      {
        defaultValue = paramObject;
        return;
      }
      throw new NullPointerException();
    }
    
    public Object apply(Object paramObject)
    {
      Object localObject = get(paramObject);
      if (localObject == null)
      {
        if (containsKey(paramObject)) {
          return localObject;
        }
        return defaultValue;
      }
      return localObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof ForMapWithDefault))
      {
        paramObject = (ForMapWithDefault)paramObject;
        if ((Functions.this.equals(map)) && (Objects.equal(defaultValue, defaultValue))) {
          return true;
        }
      }
      return false;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Object[] { Functions.this, defaultValue });
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("forMap(");
      localStringBuilder.append(Functions.this);
      localStringBuilder.append(", defaultValue=");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, defaultValue, ")");
    }
  }
  
  public class FunctionComposition<A, B, C>
    implements J<A, C>, Serializable
  {
    public static final long serialVersionUID = 0L;
    public final J<A, ? extends B> f;
    
    public FunctionComposition(Function paramFunction)
    {
      if (Functions.this != null)
      {
        if (paramFunction != null)
        {
          f = paramFunction;
          return;
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    
    public Object apply(Object paramObject)
    {
      return Functions.this.apply(f.apply(paramObject));
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof FunctionComposition))
      {
        paramObject = (FunctionComposition)paramObject;
        if ((f.equals(f)) && (Functions.this.equals(g))) {
          return true;
        }
      }
      return false;
    }
    
    public int hashCode()
    {
      return f.hashCode() ^ Functions.this.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Functions.this.toString());
      localStringBuilder.append("(");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(f, localStringBuilder, ")");
    }
  }
  
  public class FunctionForMapNoDefault<K, V>
    implements J<K, V>, Serializable
  {
    public static final long serialVersionUID = 0L;
    
    public FunctionForMapNoDefault()
    {
      if (Functions.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    public Object apply(Object paramObject)
    {
      Object localObject = get(paramObject);
      boolean bool;
      if ((localObject == null) && (!containsKey(paramObject))) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkArgument(bool, "Key '%s' not present in map", new Object[] { paramObject });
      return localObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof FunctionForMapNoDefault))
      {
        paramObject = (FunctionForMapNoDefault)paramObject;
        return Functions.this.equals(map);
      }
      return false;
    }
    
    public int hashCode()
    {
      return Functions.this.hashCode();
    }
    
    public String toString()
    {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("forMap("), Functions.this, ")");
    }
  }
  
  public class PredicateFunction<T>
    implements J<T, Boolean>, Serializable
  {
    public static final long serialVersionUID = 0L;
    
    public PredicateFunction()
    {
      if (Functions.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    public Boolean apply(Object paramObject)
    {
      return Boolean.valueOf(apply(paramObject));
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof PredicateFunction))
      {
        paramObject = (PredicateFunction)paramObject;
        return Functions.this.equals(predicate);
      }
      return false;
    }
    
    public int hashCode()
    {
      return Functions.this.hashCode();
    }
    
    public String toString()
    {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("forPredicate("), Functions.this, ")");
    }
  }
  
  public class SupplierFunction<T>
    implements J<Object, T>, Serializable
  {
    public static final long serialVersionUID = 0L;
    
    public SupplierFunction()
    {
      if (Functions.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    public Object apply(Object paramObject)
    {
      return get();
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof SupplierFunction))
      {
        paramObject = (SupplierFunction)paramObject;
        return Functions.this.equals(supplier);
      }
      return false;
    }
    
    public int hashCode()
    {
      return Functions.this.hashCode();
    }
    
    public String toString()
    {
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("forSupplier("), Functions.this, ")");
    }
  }
}
