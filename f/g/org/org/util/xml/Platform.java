package f.g.org.org.util.xml;

public final class Platform
{
  public static final ThreadLocal<char[]> DEST_TL = new BitmapHunter.1();
  
  public Platform() {}
  
  public static char[] charBufferFromThreadLocal()
  {
    return (char[])DEST_TL.get();
  }
}
