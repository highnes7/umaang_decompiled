package com.github.mikephil.charting.matrix;

public final class Vector3
{
  public static final Vector3 UNIT_X = new Vector3(1.0F, 0.0F, 0.0F);
  public static final Vector3 UNIT_Y = new Vector3(0.0F, 1.0F, 0.0F);
  public static final Vector3 UNIT_Z = new Vector3(0.0F, 0.0F, 1.0F);
  public static final Vector3 ZERO = new Vector3(0.0F, 0.0F, 0.0F);
  public float x;
  public float y;
  public float z;
  
  public Vector3() {}
  
  public Vector3(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    set(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public Vector3(Vector3 paramVector3)
  {
    set(paramVector3);
  }
  
  public Vector3(float[] paramArrayOfFloat)
  {
    set(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]);
  }
  
  public final void add(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    z += paramFloat1;
    x += paramFloat2;
    y += paramFloat3;
  }
  
  public final void add(Vector3 paramVector3)
  {
    z += z;
    x += x;
    y += y;
  }
  
  public final Vector3 cross(Vector3 paramVector3)
  {
    float f1 = x;
    float f2 = y;
    float f3 = y;
    float f4 = x;
    float f5 = z;
    float f6 = z;
    return new Vector3(f1 * f2 - f3 * f4, f3 * f5 - f2 * f6, f6 * f4 - f1 * f5);
  }
  
  public final float distance2(Vector3 paramVector3)
  {
    float f1 = z - z;
    float f2 = x - x;
    float f3 = y - y;
    return f3 * f3 + (f2 * f2 + f1 * f1);
  }
  
  public final void divide(float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      z /= paramFloat;
      x /= paramFloat;
      y /= paramFloat;
    }
  }
  
  public final float dot(Vector3 paramVector3)
  {
    float f1 = z;
    float f2 = z;
    float f3 = x;
    float f4 = x;
    return y * y + (f3 * f4 + f1 * f2);
  }
  
  public final float length()
  {
    return (float)Math.sqrt(length2());
  }
  
  public final float length2()
  {
    float f1 = z;
    float f2 = x;
    float f3 = y;
    return f3 * f3 + (f2 * f2 + f1 * f1);
  }
  
  public final void multiply(float paramFloat)
  {
    z *= paramFloat;
    x *= paramFloat;
    y *= paramFloat;
  }
  
  public final void multiply(Vector3 paramVector3)
  {
    z *= z;
    x *= x;
    y *= y;
  }
  
  public final float normalize()
  {
    float f = length();
    if (f != 0.0F)
    {
      z /= f;
      x /= f;
      y /= f;
    }
    return f;
  }
  
  public final boolean pointsInSameDirection(Vector3 paramVector3)
  {
    return dot(paramVector3) > 0.0F;
  }
  
  public final void set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    z = paramFloat1;
    x = paramFloat2;
    y = paramFloat3;
  }
  
  public final void set(Vector3 paramVector3)
  {
    z = z;
    x = x;
    y = y;
  }
  
  public final void subtract(Vector3 paramVector3)
  {
    z -= z;
    x -= x;
    y -= y;
  }
  
  public final void subtractMultiple(Vector3 paramVector3, float paramFloat)
  {
    z -= z * paramFloat;
    x -= x * paramFloat;
    y -= y * paramFloat;
  }
  
  public final void zero()
  {
    set(0.0F, 0.0F, 0.0F);
  }
}
