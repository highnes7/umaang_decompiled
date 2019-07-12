package support.android.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import b.b.a.K;
import b.b.x.o.a.b.e;

@K(19)
public class Method
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  public final Key desc;
  
  public Method(Key paramKey)
  {
    desc = paramKey;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (b.e.class == paramObject.getClass()))
    {
      paramObject = (Method)paramObject;
      return desc.equals(desc);
    }
    return false;
  }
  
  public int hashCode()
  {
    return desc.hashCode();
  }
  
  public void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    desc.onTouchExplorationStateChanged(paramBoolean);
  }
}
