package com.google.android.android.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.android.internal.zzdcm;
import com.google.android.android.internal.zzdcs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class TextBlock
  implements Text
{
  public Point[] cornerPoints;
  public zzdcs[] zzkjt;
  public List<com.google.android.gms.vision.text.Line> zzkju;
  public String zzkjv;
  public Rect zzkjw;
  
  public TextBlock(SparseArray paramSparseArray)
  {
    zzkjt = new zzdcs[paramSparseArray.size()];
    int i = 0;
    for (;;)
    {
      zzdcs[] arrayOfZzdcs = zzkjt;
      if (i >= arrayOfZzdcs.length) {
        break;
      }
      arrayOfZzdcs[i] = ((zzdcs)paramSparseArray.valueAt(i));
      i += 1;
    }
  }
  
  public static Point[] draw(int paramInt1, int paramInt2, int paramInt3, int paramInt4, zzdcm paramZzdcm)
  {
    int j = left;
    int k = y;
    double d1 = Math.sin(Math.toRadians(zzkjz));
    double d2 = Math.cos(Math.toRadians(zzkjz));
    paramZzdcm = new Point[4];
    Point localPoint = new Point(paramInt1, paramInt2);
    int i = 0;
    paramZzdcm[0] = localPoint;
    paramZzdcm[1] = new Point(paramInt3, paramInt2);
    paramZzdcm[2] = new Point(paramInt3, paramInt4);
    paramZzdcm[3] = new Point(paramInt1, paramInt4);
    paramInt1 = i;
    while (paramInt1 < 4)
    {
      double d3 = x;
      Double.isNaN(d3);
      double d4 = y;
      Double.isNaN(d4);
      paramInt2 = (int)(d3 * d2 - d4 * d1);
      d3 = x;
      Double.isNaN(d3);
      d4 = y;
      Double.isNaN(d4);
      paramInt3 = (int)(d4 * d2 + d3 * d1);
      x = paramInt2;
      y = paramInt3;
      paramZzdcm[paramInt1].offset(j, k);
      paramInt1 += 1;
    }
    return paramZzdcm;
  }
  
  public Rect getBoundingBox()
  {
    if (zzkjw == null) {
      zzkjw = Graphics.draw(this);
    }
    return zzkjw;
  }
  
  public List getComponents()
  {
    zzdcs[] arrayOfZzdcs = zzkjt;
    int j = arrayOfZzdcs.length;
    int i = 0;
    if (j == 0) {
      return new ArrayList(0);
    }
    if (zzkju == null)
    {
      zzkju = new ArrayList(arrayOfZzdcs.length);
      arrayOfZzdcs = zzkjt;
      j = arrayOfZzdcs.length;
      while (i < j)
      {
        zzdcs localZzdcs = arrayOfZzdcs[i];
        zzkju.add(new Line(localZzdcs));
        i += 1;
      }
    }
    return zzkju;
  }
  
  public Point[] getCornerPoints()
  {
    if (cornerPoints == null) {
      if (zzkjt.length == 0)
      {
        cornerPoints = new Point[0];
      }
      else
      {
        int j = Integer.MAX_VALUE;
        int i = 0;
        int k = Integer.MAX_VALUE;
        int m = Integer.MIN_VALUE;
        int n = Integer.MIN_VALUE;
        Object localObject;
        for (;;)
        {
          localObject = zzkjt;
          if (i >= localObject.length) {
            break;
          }
          zzdcm localZzdcm = zzkkb;
          localObject = 0zzkkb;
          int i1 = -left;
          int i2 = -y;
          double d1 = Math.sin(Math.toRadians(zzkjz));
          double d2 = Math.cos(Math.toRadians(zzkjz));
          localObject = new Point[4];
          localObject[0] = new Point(left, y);
          localObject[0].offset(i1, i2);
          double d3 = 0x;
          Double.isNaN(d3);
          double d4 = 0y;
          Double.isNaN(d4);
          i1 = (int)(d4 * d1 + d3 * d2);
          d3 = -0x;
          Double.isNaN(d3);
          d4 = 0y;
          Double.isNaN(d4);
          i2 = (int)(d4 * d2 + d3 * d1);
          0x = i1;
          0y = i2;
          localObject[1] = new Point(width + i1, i2);
          localObject[2] = new Point(width + i1, height + i2);
          localObject[3] = new Point(i1, i2 + height);
          i1 = 0;
          while (i1 < 4)
          {
            localZzdcm = localObject[i1];
            j = Math.min(j, x);
            m = Math.max(m, x);
            k = Math.min(k, y);
            n = Math.max(n, y);
            i1 += 1;
          }
          i += 1;
        }
        cornerPoints = draw(j, k, m, n, 0zzkkb);
      }
    }
    return cornerPoints;
  }
  
  public String getLanguage()
  {
    Object localObject = zzkjv;
    if (localObject != null) {
      return localObject;
    }
    localObject = new HashMap();
    zzdcs[] arrayOfZzdcs = zzkjt;
    int k = arrayOfZzdcs.length;
    int i = 0;
    while (i < k)
    {
      zzdcs localZzdcs = arrayOfZzdcs[i];
      int j;
      if (((HashMap)localObject).containsKey(zzkjv)) {
        j = ((Integer)((HashMap)localObject).get(zzkjv)).intValue();
      } else {
        j = 0;
      }
      ((HashMap)localObject).put(zzkjv, Integer.valueOf(j + 1));
      i += 1;
    }
    zzkjv = ((String)((Map.Entry)Collections.max(((HashMap)localObject).entrySet(), new DetailArret.1(this))).getKey());
    localObject = zzkjv;
    if ((localObject == null) || (((String)localObject).isEmpty())) {
      zzkjv = "und";
    }
    return zzkjv;
  }
  
  public String getValue()
  {
    Object localObject = zzkjt;
    if (localObject.length == 0) {
      return "";
    }
    localObject = new StringBuilder(0zzkke);
    int i = 1;
    while (i < zzkjt.length)
    {
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(zzkjt[i].zzkke);
      i += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
}
