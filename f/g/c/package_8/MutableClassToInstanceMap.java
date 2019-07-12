package f.g.c.package_8;

import f.g.c.d.Q;
import f.g.c.d.id;
import f.g.c.j.j;
import java.util.HashMap;
import java.util.Map;

public final class MutableClassToInstanceMap<B>
  extends f.g.c.d.nd.g<Class<? extends B>, B>
  implements Q<B>
{
  public static final id<Class<?>, Object> VALUE_CAN_BE_CAST_TO_KEY = new MapConstraint()
  {
    public void checkKeyValue(Class paramAnonymousClass, Object paramAnonymousObject)
    {
      MutableClassToInstanceMap.cast(paramAnonymousClass, paramAnonymousObject);
    }
  };
  public static final long serialVersionUID = 0L;
  
  public MutableClassToInstanceMap(Map paramMap)
  {
    super(paramMap, VALUE_CAN_BE_CAST_TO_KEY);
  }
  
  public static Object cast(Class paramClass, Object paramObject)
  {
    return j.c(paramClass).cast(paramObject);
  }
  
  public static MutableClassToInstanceMap create()
  {
    return new MutableClassToInstanceMap(new HashMap());
  }
  
  public static MutableClassToInstanceMap create(Map paramMap)
  {
    return new MutableClassToInstanceMap(paramMap);
  }
  
  public Object getInstance(Class paramClass)
  {
    return cast(paramClass, get(paramClass));
  }
  
  public void putAll(Map paramMap)
  {
    delegate.putAll(MapConstraints.checkMap(paramMap, constraint));
  }
  
  public Object putInstance(Class paramClass, Object paramObject)
  {
    return cast(paramClass, put(paramClass, paramObject));
  }
}
