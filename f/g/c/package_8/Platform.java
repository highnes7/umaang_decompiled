package f.g.c.package_8;

import f.g.c.a.b;
import java.lang.reflect.Array;

@b(emulated=true)
public class Platform
{
  public Platform() {}
  
  public static Object[] clone(Object[] paramArrayOfObject)
  {
    return (Object[])paramArrayOfObject.clone();
  }
  
  public static Object[] newArray(Object[] paramArrayOfObject, int paramInt)
  {
    return (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), paramInt);
  }
  
  public static MapMaker tryWeakKeys(MapMaker paramMapMaker)
  {
    return paramMapMaker.weakKeys();
  }
}
