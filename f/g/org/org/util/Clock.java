package f.g.org.org.util;

public final class Clock
  implements Item
{
  public Clock() {}
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}
