package f.g.c.cache;

import f.g.c.a.b;
import f.g.c.c.j;
import f.g.c.l.a.ja;
import f.g.c.l.a.oa;
import f.g.c.package_10.Function;
import f.g.c.package_10.Supplier;
import java.io.Serializable;
import java.util.Map;

@b(emulated=true)
public abstract class CacheLoader<K, V>
{
  public CacheLoader() {}
  
  public static CacheLoader from(Function paramFunction)
  {
    return new FunctionToCacheLoader();
  }
  
  public static CacheLoader from(Supplier paramSupplier)
  {
    return new SupplierToCacheLoader();
  }
  
  public abstract Object load(Object paramObject)
    throws Exception;
  
  public Map loadAll(Iterable paramIterable)
    throws Exception
  {
    throw new UnsupportedLoadingOperationException();
  }
  
  public oa reload(Object paramObject1, Object paramObject2)
    throws Exception
  {
    return ja.b(load(paramObject1));
  }
  
  public final class FunctionToCacheLoader<K, V>
    extends j<K, V>
    implements Serializable
  {
    public static final long serialVersionUID = 0L;
    
    public FunctionToCacheLoader()
    {
      if (CacheLoader.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    public Object load(Object paramObject)
    {
      return apply(paramObject);
    }
  }
  
  public final class InvalidCacheLoadException
    extends RuntimeException
  {
    public InvalidCacheLoadException()
    {
      super();
    }
  }
  
  public final class SupplierToCacheLoader<V>
    extends j<Object, V>
    implements Serializable
  {
    public static final long serialVersionUID = 0L;
    
    public SupplierToCacheLoader()
    {
      if (CacheLoader.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    public Object load(Object paramObject)
    {
      return get();
    }
  }
  
  public final class UnsupportedLoadingOperationException
    extends UnsupportedOperationException
  {
    public UnsupportedLoadingOperationException() {}
  }
}
