package com.google.android.android.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.android.internal.zzddb;
import java.util.ArrayList;
import java.util.List;

public class Element
  implements Text
{
  public zzddb zzkjq;
  
  public Element(zzddb paramZzddb)
  {
    zzkjq = paramZzddb;
  }
  
  public Rect getBoundingBox()
  {
    return Graphics.draw(this);
  }
  
  public List getComponents()
  {
    return new ArrayList();
  }
  
  public Point[] getCornerPoints()
  {
    return Graphics.draw(zzkjq.zzkkb);
  }
  
  public String getLanguage()
  {
    return zzkjq.zzkjv;
  }
  
  public String getValue()
  {
    return zzkjq.zzkke;
  }
}
