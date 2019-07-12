package f.g.c.package_8;

import f.g.c.a.b;
import java.io.Serializable;

@b
public final class Count
  implements Serializable
{
  public int value;
  
  public Count(int paramInt)
  {
    value = paramInt;
  }
  
  public int addAndGet(int paramInt)
  {
    paramInt = value + paramInt;
    value = paramInt;
    return paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Count)) && (value == value);
  }
  
  public int get()
  {
    return value;
  }
  
  public int getAndAdd(int paramInt)
  {
    int i = value;
    value = (paramInt + i);
    return i;
  }
  
  public int getAndSet(int paramInt)
  {
    int i = value;
    value = paramInt;
    return i;
  }
  
  public int hashCode()
  {
    return value;
  }
  
  public void set(int paramInt)
  {
    value = paramInt;
  }
  
  public String toString()
  {
    return Integer.toString(value);
  }
}
