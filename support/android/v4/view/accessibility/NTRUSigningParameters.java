package support.android.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import b.b.x.o.a.b.c;

public class NTRUSigningParameters
  implements AccessibilityManager.AccessibilityStateChangeListener
{
  public AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat d;
  
  public NTRUSigningParameters(AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat paramAccessibilityStateChangeListenerCompat)
  {
    d = paramAccessibilityStateChangeListenerCompat;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (b.c.class == paramObject.getClass()))
    {
      paramObject = (NTRUSigningParameters)paramObject;
      return d.equals(d);
    }
    return false;
  }
  
  public int hashCode()
  {
    return d.hashCode();
  }
  
  public void onAccessibilityStateChanged(boolean paramBoolean)
  {
    d.onAccessibilityStateChanged(paramBoolean);
  }
}
