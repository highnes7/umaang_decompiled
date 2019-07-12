package support.android.v4.widget;

import android.graphics.Rect;
import b.b.x.p.t.a;
import java.util.Comparator;

public class a<T>
  implements Comparator<T>
{
  public final Rect a = new Rect();
  public final boolean c;
  public final t.a<T> i;
  public final Rect r = new Rect();
  
  public a(boolean paramBoolean, Item paramItem)
  {
    c = paramBoolean;
    i = paramItem;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    Rect localRect1 = a;
    Rect localRect2 = r;
    i.a(paramObject1, localRect1);
    i.a(paramObject2, localRect2);
    int j = top;
    int k = top;
    if (j < k) {
      return -1;
    }
    if (j > k) {
      return 1;
    }
    j = left;
    k = left;
    if (j < k)
    {
      if (c) {
        return 1;
      }
    }
    else
    {
      if (j > k)
      {
        if (c) {
          return -1;
        }
        return 1;
      }
      j = bottom;
      k = bottom;
      if (j < k) {
        return -1;
      }
      if (j > k) {
        return 1;
      }
      j = right;
      k = right;
      if (j < k)
      {
        if (c) {
          return 1;
        }
      }
      else
      {
        if (j > k)
        {
          if (c) {
            return -1;
          }
          return 1;
        }
        return 0;
      }
    }
    return -1;
  }
}
