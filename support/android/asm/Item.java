package support.android.asm;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

public class Item<T>
  extends Property<T, Float>
{
  public final Property<T, PointF> a;
  public final float b;
  public final PathMeasure c;
  public final PointF d = new PointF();
  public float value;
  public final float[] x = new float[2];
  
  public Item(Property paramProperty, Path paramPath)
  {
    super(Float.class, paramProperty.getName());
    a = paramProperty;
    c = new PathMeasure(paramPath, false);
    b = c.getLength();
  }
  
  public Float get(Object paramObject)
  {
    return Float.valueOf(value);
  }
  
  public void set(Object paramObject, Float paramFloat)
  {
    value = paramFloat.floatValue();
    Object localObject = c;
    float f = b;
    ((PathMeasure)localObject).getPosTan(paramFloat.floatValue() * f, x, null);
    paramFloat = d;
    localObject = x;
    x = localObject[0];
    y = localObject[1];
    a.set(paramObject, paramFloat);
  }
}
