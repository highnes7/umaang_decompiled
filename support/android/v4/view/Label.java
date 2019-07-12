package support.android.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import b.b.x.o.f;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.List;

public final class Label
{
  public final Object a;
  
  public Label(Rect paramRect, List paramList)
  {
    a = paramRect;
  }
  
  public Label(Object paramObject)
  {
    a = paramObject;
  }
  
  public static Label a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new Label(paramObject);
  }
  
  public List a()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)a).getBoundingRects();
    }
    return null;
  }
  
  public int b()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)a).getSafeInsetBottom();
    }
    return 0;
  }
  
  public int c()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)a).getSafeInsetRight();
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (f.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Label)paramObject;
      Object localObject = a;
      if (localObject == null) {
        return a == null;
      }
      return localObject.equals(a);
    }
    return false;
  }
  
  public int getColor()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)a).getSafeInsetTop();
    }
    return 0;
  }
  
  public int getOffset()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)a).getSafeInsetLeft();
    }
    return 0;
  }
  
  public int hashCode()
  {
    Object localObject = a;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public String toString()
  {
    return StringBuilder.append(StringBuilder.append("DisplayCutoutCompat{"), a, "}");
  }
}
