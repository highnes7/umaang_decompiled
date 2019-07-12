package support.android.v4.internal;

import android.graphics.PointF;
import support.android.v4.util.Label;

public final class Handle
{
  public final PointF a;
  public final float b;
  public final PointF c;
  public final float d;
  
  public Handle(PointF paramPointF1, float paramFloat1, PointF paramPointF2, float paramFloat2)
  {
    Label.getKey(paramPointF1, "start == null");
    a = ((PointF)paramPointF1);
    b = paramFloat1;
    Label.getKey(paramPointF2, "end == null");
    c = ((PointF)paramPointF2);
    d = paramFloat2;
  }
  
  public PointF a()
  {
    return a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Handle)) {
      return false;
    }
    paramObject = (Handle)paramObject;
    return (Float.compare(b, b) == 0) && (Float.compare(d, d) == 0) && (a.equals(a)) && (c.equals(c));
  }
  
  public float getDesc()
  {
    return d;
  }
  
  public PointF getName()
  {
    return c;
  }
  
  public float getOwner()
  {
    return b;
  }
  
  public int hashCode()
  {
    int k = a.hashCode();
    float f = b;
    int j = 0;
    int i;
    if (f != 0.0F) {
      i = Float.floatToIntBits(f);
    } else {
      i = 0;
    }
    int m = c.hashCode();
    f = d;
    if (f != 0.0F) {
      j = Float.floatToIntBits(f);
    }
    return (m + (k * 31 + i) * 31) * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("PathSegment{start=");
    localStringBuilder.append(a);
    localStringBuilder.append(", startFraction=");
    localStringBuilder.append(b);
    localStringBuilder.append(", end=");
    localStringBuilder.append(c);
    localStringBuilder.append(", endFraction=");
    localStringBuilder.append(d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
