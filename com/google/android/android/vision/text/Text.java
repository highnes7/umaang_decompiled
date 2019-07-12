package com.google.android.android.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.List;

public abstract interface Text
{
  public abstract Rect getBoundingBox();
  
  public abstract List getComponents();
  
  public abstract Point[] getCornerPoints();
  
  public abstract String getValue();
}
