package support.android.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;
import support.android.v4.view.accessibility.AccessibilityNodeProviderCompat;

public class AccessibilityDelegateCompat
{
  public static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
  public final View.AccessibilityDelegate mBridge = new AccessibilityDelegateCompatJellyBean.1(this);
  
  public AccessibilityDelegateCompat() {}
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return DEFAULT_DELEGATE.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    paramView = DEFAULT_DELEGATE.getAccessibilityNodeProvider(paramView);
    if (paramView != null) {
      return new AccessibilityNodeProviderCompat(paramView);
    }
    return null;
  }
  
  public View.AccessibilityDelegate getBridge()
  {
    return mBridge;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    DEFAULT_DELEGATE.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.getInfo());
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return DEFAULT_DELEGATE.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    return DEFAULT_DELEGATE.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    DEFAULT_DELEGATE.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
}
