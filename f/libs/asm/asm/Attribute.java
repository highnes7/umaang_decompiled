package f.libs.asm.asm;

import l.a.a.a.a.c.a.g;

public class Attribute
{
  public static final long MAX_SIZE = 1000000L;
  public g a;
  public long b;
  
  public Attribute(g paramG)
  {
    if (paramG != null)
    {
      a = paramG;
      return;
    }
    throw new NullPointerException("retryState must not be null");
  }
  
  public void a()
  {
    b = 0L;
    a = a.e();
  }
  
  public boolean a(long paramLong)
  {
    long l = a.c();
    return paramLong - b >= l * 1000000L;
  }
  
  public void b(long paramLong)
  {
    b = paramLong;
    a = a.f();
  }
}
