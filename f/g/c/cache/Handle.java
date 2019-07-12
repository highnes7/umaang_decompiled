package f.g.c.cache;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Objects.ToStringHelper;
import f.g.c.package_10.Preconditions;
import java.util.Arrays;

@a
@b
public final class Handle
{
  public final long a;
  public final long b;
  public final long c;
  public final long d;
  public final long f;
  public final long v;
  
  public Handle(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong2 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong3 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong4 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong5 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong6 >= 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    f = paramLong1;
    b = paramLong2;
    c = paramLong3;
    d = paramLong4;
    a = paramLong5;
    v = paramLong6;
  }
  
  public double a()
  {
    long l = getValue();
    if (l == 0L) {
      return 1.0D;
    }
    double d1 = f;
    double d2 = l;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public Handle a(Handle paramHandle)
  {
    return new Handle(Math.max(0L, f - f), Math.max(0L, b - b), Math.max(0L, c - c), Math.max(0L, d - d), Math.max(0L, a - a), Math.max(0L, v - v));
  }
  
  public double distance()
  {
    long l2 = c;
    long l1 = d;
    l2 += l1;
    if (l2 == 0L) {
      return 0.0D;
    }
    double d1 = l1;
    double d2 = l2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public long equals()
  {
    return c + d;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Handle))
    {
      paramObject = (Handle)paramObject;
      if ((f == f) && (b == b) && (c == c) && (d == d) && (a == a) && (v == v)) {
        return true;
      }
    }
    return false;
  }
  
  public double eval()
  {
    long l = c + d;
    if (l == 0L) {
      return 0.0D;
    }
    double d1 = a;
    double d2 = l;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public long getDesc()
  {
    return d;
  }
  
  public long getName()
  {
    return c;
  }
  
  public long getOwner()
  {
    return b;
  }
  
  public long getValue()
  {
    return f + b;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(f), Long.valueOf(b), Long.valueOf(c), Long.valueOf(d), Long.valueOf(a), Long.valueOf(v) });
  }
  
  public double inverseCumulativeProbability()
  {
    long l = getValue();
    if (l == 0L) {
      return 0.0D;
    }
    double d1 = b;
    double d2 = l;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public long loadSuccessCount()
  {
    return a;
  }
  
  public long missCount()
  {
    return f;
  }
  
  public Handle toString(Handle paramHandle)
  {
    return new Handle(f + f, b + b, c + c, d + d, a + a, v + v);
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("hitCount", f).add("missCount", b).add("loadSuccessCount", c).add("loadExceptionCount", d).add("totalLoadTime", a).add("evictionCount", v).toString();
  }
  
  public long values()
  {
    return v;
  }
}
