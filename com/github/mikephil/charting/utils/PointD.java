package com.github.mikephil.charting.utils;

public class PointD
{
  public double x;
  public double y;
  
  public PointD(double paramDouble1, double paramDouble2)
  {
    x = paramDouble1;
    y = paramDouble2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("PointD, x: ");
    localStringBuilder.append(x);
    localStringBuilder.append(", y: ");
    localStringBuilder.append(y);
    return localStringBuilder.toString();
  }
}
