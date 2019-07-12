package support.android.v4.widget;

import android.graphics.Rect;
import b.b.x.o.a.c;
import b.b.x.p.t.a;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;

public final class LayoutManager
  implements t.a<c>
{
  public LayoutManager() {}
  
  public void format(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, Rect paramRect)
  {
    paramAccessibilityNodeInfoCompat.getBoundsInParent(paramRect);
  }
}
