package android.support.design.widget;

import android.content.Context;
import android.support.v7.appcompat.R.attr;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.widget.Checkable;
import android.widget.ImageView;
import b.b.a.N;
import support.android.v4.view.AccessibilityDelegateCompat;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;

@N({b.b.a.N.a.b})
public class CheckableImageButton
  extends AppCompatImageButton
  implements Checkable
{
  public static final int[] DRAWABLE_STATE_CHECKED = { 16842912 };
  public boolean checked;
  
  public CheckableImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AccessibilityDelegateCompat.DEFAULT_DELEGATE.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        paramAnonymousAccessibilityEvent.setChecked(isChecked());
      }
      
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        paramAnonymousAccessibilityNodeInfoCompat.setCheckable(true);
        paramAnonymousAccessibilityNodeInfoCompat.setError(isChecked());
      }
    });
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat()
    {
      public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AccessibilityDelegateCompat.DEFAULT_DELEGATE.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        paramAnonymousAccessibilityEvent.setChecked(isChecked());
      }
      
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
      {
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
        paramAnonymousAccessibilityNodeInfoCompat.setCheckable(true);
        paramAnonymousAccessibilityNodeInfoCompat.setError(isChecked());
      }
    });
  }
  
  public boolean isChecked()
  {
    return checked;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (checked) {
      return View.mergeDrawableStates(super.onCreateDrawableState(paramInt + DRAWABLE_STATE_CHECKED.length), DRAWABLE_STATE_CHECKED);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (checked != paramBoolean)
    {
      checked = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void toggle()
  {
    setChecked(checked ^ true);
  }
}
