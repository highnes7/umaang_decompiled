package com.google.android.android.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.android.internal.zzdcm;

public final class Graphics
{
  public static Rect draw(Text paramText)
  {
    paramText = paramText.getCornerPoints();
    int i1 = paramText.length;
    int n = Integer.MAX_VALUE;
    int j = 0;
    int k = Integer.MAX_VALUE;
    int m = Integer.MIN_VALUE;
    int i = Integer.MIN_VALUE;
    while (j < i1)
    {
      Object localObject = paramText[j];
      n = Math.min(n, x);
      m = Math.max(m, x);
      k = Math.min(k, y);
      i = Math.max(i, y);
      j += 1;
    }
    return new Rect(n, k, m, i);
  }
  
  public static Point[] draw(zzdcm paramZzdcm)
  {
    Point[] arrayOfPoint = new Point[4];
    double d2 = Math.sin(Math.toRadians(zzkjz));
    double d1 = Math.cos(Math.toRadians(zzkjz));
    arrayOfPoint[0] = new Point(left, y);
    double d3 = left;
    int i = width;
    double d4 = i;
    Double.isNaN(d4);
    Double.isNaN(d3);
    int j = (int)(d4 * d1 + d3);
    d3 = y;
    d4 = i;
    Double.isNaN(d4);
    Double.isNaN(d3);
    arrayOfPoint[1] = new Point(j, (int)(d4 * d2 + d3));
    d3 = 1x;
    i = height;
    d4 = i;
    Double.isNaN(d4);
    Double.isNaN(d3);
    j = (int)(d3 - d4 * d2);
    d2 = 1y;
    d3 = i;
    Double.isNaN(d3);
    Double.isNaN(d2);
    arrayOfPoint[2] = new Point(j, (int)(d3 * d1 + d2));
    i = 0x;
    j = 2x;
    int k = 1x;
    int m = 0y;
    arrayOfPoint[3] = new Point(j - k + i, 2y - 1y + m);
    return arrayOfPoint;
  }
}
