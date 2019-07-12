package com.github.mikephil.charting.utils;

public final class FSize
{
  public final float height;
  public final float width;
  
  public FSize(float paramFloat1, float paramFloat2)
  {
    width = paramFloat1;
    height = paramFloat2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof FSize))
    {
      paramObject = (FSize)paramObject;
      if ((width == width) && (height == height)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(width) ^ Float.floatToIntBits(height);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(width);
    localStringBuilder.append("x");
    localStringBuilder.append(height);
    return localStringBuilder.toString();
  }
}
