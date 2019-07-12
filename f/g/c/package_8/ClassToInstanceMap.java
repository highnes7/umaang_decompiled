package f.g.c.package_8;

import f.g.c.a.b;
import java.util.Map;

@b
public abstract interface ClassToInstanceMap<B>
  extends Map<Class<? extends B>, B>
{
  public abstract Object getInstance(Class paramClass);
  
  public abstract Object putInstance(Class paramClass, Object paramObject);
}
