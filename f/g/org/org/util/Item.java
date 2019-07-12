package f.g.org.org.util;

public abstract interface Item
{
  public static final Item g = new Clock();
  
  public abstract long currentTimeMillis();
}
