package f.fasterxml.jackson.core.jsonschema;

import f.d.a.a.f.b;
import java.lang.reflect.Type;

public abstract class TypeReference<T>
  implements Comparable<b<T>>
{
  public final Type _type;
  
  public TypeReference()
  {
    Type localType = b.class.getGenericSuperclass();
    if (!(localType instanceof Class))
    {
      _type = ((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[0];
      return;
    }
    throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
  }
  
  public int compareTo(TypeReference paramTypeReference)
  {
    return 0;
  }
  
  public Type getType()
  {
    return _type;
  }
}
