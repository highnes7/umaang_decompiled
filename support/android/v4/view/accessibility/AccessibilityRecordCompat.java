package support.android.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import b.b.x.o.a.e;
import java.util.List;

public class AccessibilityRecordCompat
{
  public final AccessibilityRecord IMPL;
  
  public AccessibilityRecordCompat(Object paramObject)
  {
    IMPL = ((AccessibilityRecord)paramObject);
  }
  
  public static int getMaxScrollX(AccessibilityRecord paramAccessibilityRecord)
  {
    int i = Build.VERSION.SDK_INT;
    return paramAccessibilityRecord.getMaxScrollX();
  }
  
  public static int getMaxScrollY(AccessibilityRecord paramAccessibilityRecord)
  {
    int i = Build.VERSION.SDK_INT;
    return paramAccessibilityRecord.getMaxScrollY();
  }
  
  public static AccessibilityRecordCompat obtain()
  {
    return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
  }
  
  public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat paramAccessibilityRecordCompat)
  {
    return new AccessibilityRecordCompat(AccessibilityRecord.obtain(IMPL));
  }
  
  public static void setMaxScrollX(AccessibilityRecord paramAccessibilityRecord, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramAccessibilityRecord.setMaxScrollX(paramInt);
  }
  
  public static void setMaxScrollY(AccessibilityRecord paramAccessibilityRecord, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramAccessibilityRecord.setMaxScrollY(paramInt);
  }
  
  public static void setSource(AccessibilityRecord paramAccessibilityRecord, View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramAccessibilityRecord.setSource(paramView, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (e.class != paramObject.getClass()) {
      return false;
    }
    paramObject = (AccessibilityRecordCompat)paramObject;
    AccessibilityRecord localAccessibilityRecord = IMPL;
    if (localAccessibilityRecord == null)
    {
      if (IMPL != null) {
        return false;
      }
    }
    else if (!localAccessibilityRecord.equals(IMPL)) {
      return false;
    }
    return true;
  }
  
  public int getAddedCount()
  {
    return IMPL.getAddedCount();
  }
  
  public CharSequence getBeforeText()
  {
    return IMPL.getBeforeText();
  }
  
  public CharSequence getClassName()
  {
    return IMPL.getClassName();
  }
  
  public CharSequence getContentDescription()
  {
    return IMPL.getContentDescription();
  }
  
  public int getCurrentItemIndex()
  {
    return IMPL.getCurrentItemIndex();
  }
  
  public int getFromIndex()
  {
    return IMPL.getFromIndex();
  }
  
  public Object getImpl()
  {
    return IMPL;
  }
  
  public int getItemCount()
  {
    return IMPL.getItemCount();
  }
  
  public int getMaxScrollX()
  {
    return getMaxScrollX(IMPL);
  }
  
  public int getMaxScrollY()
  {
    return getMaxScrollY(IMPL);
  }
  
  public Parcelable getParcelableData()
  {
    return IMPL.getParcelableData();
  }
  
  public int getRemovedCount()
  {
    return IMPL.getRemovedCount();
  }
  
  public int getScrollX()
  {
    return IMPL.getScrollX();
  }
  
  public int getScrollY()
  {
    return IMPL.getScrollY();
  }
  
  public AccessibilityNodeInfoCompat getSource()
  {
    return AccessibilityNodeInfoCompat.wrapNonNullInstance(IMPL.getSource());
  }
  
  public List getText()
  {
    return IMPL.getText();
  }
  
  public int getToIndex()
  {
    return IMPL.getToIndex();
  }
  
  public int getWindowId()
  {
    return IMPL.getWindowId();
  }
  
  public int hashCode()
  {
    AccessibilityRecord localAccessibilityRecord = IMPL;
    if (localAccessibilityRecord == null) {
      return 0;
    }
    return localAccessibilityRecord.hashCode();
  }
  
  public boolean isChecked()
  {
    return IMPL.isChecked();
  }
  
  public boolean isEnabled()
  {
    return IMPL.isEnabled();
  }
  
  public boolean isFullScreen()
  {
    return IMPL.isFullScreen();
  }
  
  public boolean isPassword()
  {
    return IMPL.isPassword();
  }
  
  public boolean isScrollable()
  {
    return IMPL.isScrollable();
  }
  
  public void recycle()
  {
    IMPL.recycle();
  }
  
  public void setAddedCount(int paramInt)
  {
    IMPL.setAddedCount(paramInt);
  }
  
  public void setBeforeText(CharSequence paramCharSequence)
  {
    IMPL.setBeforeText(paramCharSequence);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    IMPL.setChecked(paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(paramCharSequence);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    IMPL.setContentDescription(paramCharSequence);
  }
  
  public void setCurrentItemIndex(int paramInt)
  {
    IMPL.setCurrentItemIndex(paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    IMPL.setEnabled(paramBoolean);
  }
  
  public void setFromIndex(int paramInt)
  {
    IMPL.setFromIndex(paramInt);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    IMPL.setFullScreen(paramBoolean);
  }
  
  public void setItemCount(int paramInt)
  {
    IMPL.setItemCount(paramInt);
  }
  
  public void setMaxScrollX(int paramInt)
  {
    AccessibilityRecord localAccessibilityRecord = IMPL;
    int i = Build.VERSION.SDK_INT;
    localAccessibilityRecord.setMaxScrollX(paramInt);
  }
  
  public void setMaxScrollY(int paramInt)
  {
    AccessibilityRecord localAccessibilityRecord = IMPL;
    int i = Build.VERSION.SDK_INT;
    localAccessibilityRecord.setMaxScrollY(paramInt);
  }
  
  public void setParcelableData(Parcelable paramParcelable)
  {
    IMPL.setParcelableData(paramParcelable);
  }
  
  public void setPassword(boolean paramBoolean)
  {
    IMPL.setPassword(paramBoolean);
  }
  
  public void setRemovedCount(int paramInt)
  {
    IMPL.setRemovedCount(paramInt);
  }
  
  public void setScrollX(int paramInt)
  {
    IMPL.setScrollX(paramInt);
  }
  
  public void setScrollY(int paramInt)
  {
    IMPL.setScrollY(paramInt);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(paramBoolean);
  }
  
  public void setSource(View paramView)
  {
    IMPL.setSource(paramView);
  }
  
  public void setSource(View paramView, int paramInt)
  {
    AccessibilityRecord localAccessibilityRecord = IMPL;
    int i = Build.VERSION.SDK_INT;
    localAccessibilityRecord.setSource(paramView, paramInt);
  }
  
  public void setToIndex(int paramInt)
  {
    IMPL.setToIndex(paramInt);
  }
}
