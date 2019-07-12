package f.g.c.package_10;

import f.g.c.a.b;

@b(emulated=true)
public final class Platform
{
  public static final ThreadLocal<char[]> DEST_TL = new BitmapHunter.1();
  
  public Platform() {}
  
  public static h c(h paramH)
  {
    return paramH.c();
  }
  
  public static char[] charBufferFromThreadLocal()
  {
    return (char[])DEST_TL.get();
  }
  
  public static long systemNanoTime()
  {
    return System.nanoTime();
  }
}
