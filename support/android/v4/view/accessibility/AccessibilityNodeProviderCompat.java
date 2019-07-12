package support.android.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import b.b.a.K;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat
{
  public static final int Icode_DUP = -1;
  public final Object mProvider;
  
  public AccessibilityNodeProviderCompat()
  {
    int i = Build.VERSION.SDK_INT;
    mProvider = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl(this);
  }
  
  public AccessibilityNodeProviderCompat(Object paramObject)
  {
    mProvider = paramObject;
  }
  
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return null;
  }
  
  public List findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return null;
  }
  
  public Object getProvider()
  {
    return mProvider;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
}
