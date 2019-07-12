package support.android.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

public final class AccessibilityEventCompat
{
  public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
  public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
  public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
  public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
  public static final int TYPES_ALL_MASK = -1;
  public static final int TYPE_ANNOUNCEMENT = 16384;
  public static final int TYPE_GESTURE_DETECTION_END = 524288;
  public static final int TYPE_GESTURE_DETECTION_START = 262144;
  @Deprecated
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
  @Deprecated
  public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
  public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
  public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
  public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
  @Deprecated
  public static final int TYPE_VIEW_HOVER_ENTER = 128;
  @Deprecated
  public static final int TYPE_VIEW_HOVER_EXIT = 256;
  @Deprecated
  public static final int TYPE_VIEW_SCROLLED = 4096;
  @Deprecated
  public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
  public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
  @Deprecated
  public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
  public static final int addInfoNotAvailable = 4194304;
  
  public AccessibilityEventCompat() {}
  
  public static int accept(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = Build.VERSION.SDK_INT;
    return paramAccessibilityEvent.getAction();
  }
  
  public static void accept(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramAccessibilityEvent.setAction(paramInt);
  }
  
  public static void appendRecord(AccessibilityEvent paramAccessibilityEvent, AccessibilityRecordCompat paramAccessibilityRecordCompat)
  {
    paramAccessibilityEvent.appendRecord((AccessibilityRecord)paramAccessibilityRecordCompat.getImpl());
  }
  
  public static AccessibilityRecordCompat asRecord(AccessibilityEvent paramAccessibilityEvent)
  {
    return new AccessibilityRecordCompat(paramAccessibilityEvent);
  }
  
  public static int dismissDialog(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = Build.VERSION.SDK_INT;
    return paramAccessibilityEvent.getMovementGranularity();
  }
  
  public static void dismissDialog(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramAccessibilityEvent.setMovementGranularity(paramInt);
  }
  
  public static int getContentChangeTypes(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = Build.VERSION.SDK_INT;
    return paramAccessibilityEvent.getContentChangeTypes();
  }
  
  public static AccessibilityRecordCompat getRecord(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    return new AccessibilityRecordCompat(paramAccessibilityEvent.getRecord(paramInt));
  }
  
  public static int getRecordCount(AccessibilityEvent paramAccessibilityEvent)
  {
    return paramAccessibilityEvent.getRecordCount();
  }
  
  public static void setContentChangeTypes(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramAccessibilityEvent.setContentChangeTypes(paramInt);
  }
}
