package com.google.android.android.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.android.internal.zzdcm;
import com.google.android.android.internal.zzdcs;
import com.google.android.android.internal.zzddb;
import java.util.ArrayList;
import java.util.List;

public class Line
  implements Text
{
  public zzdcs zzkjr;
  public List<com.google.android.gms.vision.text.Element> zzkjs;
  
  public Line(zzdcs paramZzdcs)
  {
    zzkjr = paramZzdcs;
  }
  
  public float getAngle()
  {
    return zzkjr.zzkkb.zzkjz;
  }
  
  public Rect getBoundingBox()
  {
    return Graphics.draw(this);
  }
  
  public List getComponents()
  {
    zzddb[] arrayOfZzddb = zzkjr.zzkka;
    int j = arrayOfZzddb.length;
    int i = 0;
    if (j == 0) {
      return new ArrayList(0);
    }
    if (zzkjs == null)
    {
      zzkjs = new ArrayList(arrayOfZzddb.length);
      arrayOfZzddb = zzkjr.zzkka;
      j = arrayOfZzddb.length;
      while (i < j)
      {
        zzddb localZzddb = arrayOfZzddb[i];
        zzkjs.add(new Element(localZzddb));
        i += 1;
      }
    }
    return zzkjs;
  }
  
  public Point[] getCornerPoints()
  {
    return Graphics.draw(zzkjr.zzkkb);
  }
  
  public String getLanguage()
  {
    return zzkjr.zzkjv;
  }
  
  public String getValue()
  {
    return zzkjr.zzkke;
  }
  
  public boolean isVertical()
  {
    return zzkjr.zzkkh;
  }
}
