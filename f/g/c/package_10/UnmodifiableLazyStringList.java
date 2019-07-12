package f.g.c.package_10;

import java.util.AbstractList;

public final class UnmodifiableLazyStringList
  extends AbstractList<Object>
{
  public UnmodifiableLazyStringList(Object[] paramArrayOfObject, Object paramObject1, Object paramObject2) {}
  
  public Object get(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return pool[(paramInt - 2)];
      }
      return current;
    }
    return list;
  }
  
  public int size()
  {
    return pool.length + 2;
  }
}
