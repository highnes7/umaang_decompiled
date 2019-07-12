package f.g.c.package_8;

import f.g.c.a.b;

@b
public final class CopyOnWriteArrayList
{
  public CopyOnWriteArrayList() {}
  
  public static int get(int paramInt)
  {
    paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
}
