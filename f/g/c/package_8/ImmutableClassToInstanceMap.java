package f.g.c.package_8;

import f.g.c.d.Ab;
import f.g.c.d.Q;
import f.g.c.d.Sa;
import java.util.Map;

public final class ImmutableClassToInstanceMap<B>
  extends Sa<Class<? extends B>, B>
  implements Q<B>
{
  public final Ab<Class<? extends B>, B> delegate;
  
  public ImmutableClassToInstanceMap(ImmutableMap paramImmutableMap)
  {
    delegate = paramImmutableMap;
  }
  
  public static ImmutableClassToInstanceMap copyOf(Map paramMap)
  {
    if ((paramMap instanceof ImmutableClassToInstanceMap)) {
      return (ImmutableClassToInstanceMap)paramMap;
    }
    return new pb.a().putAll(paramMap).build();
  }
  
  public static pb.a copyOf()
  {
    return new pb.a();
  }
  
  public Map delegate()
  {
    return delegate;
  }
  
  public Object getInstance(Class paramClass)
  {
    return delegate.get(paramClass);
  }
  
  public Object putInstance(Class paramClass, Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
}
