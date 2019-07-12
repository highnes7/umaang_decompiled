package f.g.org.org.util;

public class f
{
  public int a = 500;
  public double b = 0.5D;
  public double e = 1.5D;
  public NanoClock f = NanoClock.SYSTEM;
  public int g = 900000;
  public int q = 60000;
  
  public f() {}
  
  public final int a()
  {
    return g;
  }
  
  public f a(double paramDouble)
  {
    e = paramDouble;
    return this;
  }
  
  public f a(int paramInt)
  {
    g = paramInt;
    return this;
  }
  
  public f a(NanoClock paramNanoClock)
  {
    if (paramNanoClock != null)
    {
      f = paramNanoClock;
      return this;
    }
    throw new NullPointerException();
  }
  
  public f b(int paramInt)
  {
    a = paramInt;
    return this;
  }
  
  public ExponentialBackOff build()
  {
    return new ExponentialBackOff(this);
  }
  
  public final int c()
  {
    return a;
  }
  
  public final int d()
  {
    return q;
  }
  
  public final double e()
  {
    return e;
  }
  
  public f e(int paramInt)
  {
    q = paramInt;
    return this;
  }
  
  public final NanoClock f()
  {
    return f;
  }
  
  public f f(double paramDouble)
  {
    b = paramDouble;
    return this;
  }
  
  public final double g()
  {
    return b;
  }
}
