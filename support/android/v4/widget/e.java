package support.android.v4.widget;

import b.b.x.n.u;
import b.b.x.o.a.c;
import b.b.x.p.t.b;
import support.android.v4.util.SparseArrayCompat;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;

public final class e
  implements t.b<u<c>, c>
{
  public e() {}
  
  public AccessibilityNodeInfoCompat equals(SparseArrayCompat paramSparseArrayCompat, int paramInt)
  {
    return (AccessibilityNodeInfoCompat)paramSparseArrayCompat.valueAt(paramInt);
  }
  
  public int size(SparseArrayCompat paramSparseArrayCompat)
  {
    return paramSparseArrayCompat.size();
  }
}
