package support.android.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;
import b.b.a.N;
import b.b.x.o.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AccessibilityNodeInfoCompat
{
  public static final int ACCOUNT_COLUMN = 1;
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  public static final int ACTION_CLEAR_FOCUS = 2;
  public static final int ACTION_CLEAR_SELECTION = 8;
  public static final String ACTION_CLICK = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
  public static final int ACTION_COLLAPSE = 524288;
  public static final int ACTION_COPY = 16384;
  public static final int ACTION_CUT = 65536;
  public static final int ACTION_DISMISS = 1048576;
  public static final String ACTION_ERROR = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
  public static final int ACTION_EXPAND = 262144;
  public static final int ACTION_FOCUS = 1;
  public static final int ACTION_LONG_CLICK = 2;
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  public static final int ACTION_PASTE = 32768;
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  public static final int ACTION_SCROLL_FORWARD = 4096;
  public static final int ACTION_SELECT = 4;
  public static final int ACTION_SET_SELECTION = 131072;
  public static final int ACTION_SET_TEXT = 2097152;
  public static final String ACTION_UPDATE_ALL = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
  public static final int ALIGN_PRICE_UPDATE_INTERVAL = 16;
  public static final String CANCEL_MENU = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
  public static final String EVENTLOG_URL = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
  public static final int EVENT_INDEX_ALL_DAY = 4;
  public static final String EXTRA_FILE_EXTENSIONS = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
  public static final String EXTRA_OUTPUT = "ACTION_ARGUMENT_MOVE_WINDOW_X";
  public static final String EXTRA_SEARCH_TERM = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
  public static final int FOCUS_ACCESSIBILITY = 2;
  public static final int FOCUS_INPUT = 1;
  public static final String MODULE_PACKAGE = "AccessibilityNodeInfo.roleDescription";
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  public static final String PAGE_KEY = "android.view.accessibility.action.ARGUMENT_ROW_INT";
  public static final int TAG_AUDIO = 32;
  public final AccessibilityNodeInfo IMPL;
  @N({b.b.a.N.a.b})
  public int top = -1;
  
  public AccessibilityNodeInfoCompat(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    IMPL = paramAccessibilityNodeInfo;
  }
  
  public AccessibilityNodeInfoCompat(Object paramObject)
  {
    IMPL = ((AccessibilityNodeInfo)paramObject);
  }
  
  private boolean equals(int paramInt)
  {
    Bundle localBundle = getExtras();
    if (localBundle == null) {
      return false;
    }
    return (localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & paramInt) == paramInt;
  }
  
  public static String getActionSymbolicName(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        switch (paramInt)
        {
        default: 
          return "ACTION_UNKNOWN";
        case 131072: 
          return "ACTION_SET_SELECTION";
        case 65536: 
          return "ACTION_CUT";
        case 32768: 
          return "ACTION_PASTE";
        case 16384: 
          return "ACTION_COPY";
        case 8192: 
          return "ACTION_SCROLL_BACKWARD";
        case 4096: 
          return "ACTION_SCROLL_FORWARD";
        case 2048: 
          return "ACTION_PREVIOUS_HTML_ELEMENT";
        case 1024: 
          return "ACTION_NEXT_HTML_ELEMENT";
        case 512: 
          return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        case 256: 
          return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        case 128: 
          return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        case 64: 
          return "ACTION_ACCESSIBILITY_FOCUS";
        case 32: 
          return "ACTION_LONG_CLICK";
        case 16: 
          return "ACTION_CLICK";
        case 8: 
          return "ACTION_CLEAR_SELECTION";
        }
        return "ACTION_SELECT";
      }
      return "ACTION_CLEAR_FOCUS";
    }
    return "ACTION_FOCUS";
  }
  
  public static AccessibilityNodeInfoCompat obtain()
  {
    return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView)
  {
    return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(paramView));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    return wrapNonNullInstance(AccessibilityNodeInfo.obtain(paramView, paramInt));
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(IMPL));
  }
  
  private void put(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = getExtras();
    if (localBundle != null)
    {
      int j = localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
      int i;
      if (paramBoolean) {
        i = paramInt;
      } else {
        i = 0;
      }
      localBundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | j & paramInt);
    }
  }
  
  public static AccessibilityNodeInfoCompat wrapNonNullInstance(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new AccessibilityNodeInfoCompat(paramAccessibilityNodeInfo);
  }
  
  public static AccessibilityNodeInfoCompat wrapNonNullInstance(Object paramObject)
  {
    if (paramObject != null) {
      return new AccessibilityNodeInfoCompat(paramObject);
    }
    return null;
  }
  
  public boolean accept()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return IMPL.isShowingHintText();
    }
    return equals(4);
  }
  
  public void addAction(int paramInt)
  {
    IMPL.addAction(paramInt);
  }
  
  public int addChild()
  {
    return IMPL.getChildCount();
  }
  
  public void addChild(View paramView)
  {
    IMPL.addChild(paramView);
  }
  
  public void addChild(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.addChild(paramView, paramInt);
  }
  
  public void addChild(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setDismissable(paramBoolean);
  }
  
  public void apply(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      IMPL.setImportantForAccessibility(paramBoolean);
    }
  }
  
  public boolean canOpenPopup()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.canOpenPopup();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (c.class != paramObject.getClass()) {
      return false;
    }
    paramObject = (AccessibilityNodeInfoCompat)paramObject;
    AccessibilityNodeInfo localAccessibilityNodeInfo = IMPL;
    if (localAccessibilityNodeInfo == null)
    {
      if (IMPL != null) {
        return false;
      }
    }
    else if (!localAccessibilityNodeInfo.equals(IMPL)) {
      return false;
    }
    return true;
  }
  
  public void extend(CharSequence paramCharSequence)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", paramCharSequence);
  }
  
  public List findAccessibilityNodeInfosByText(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = IMPL.findAccessibilityNodeInfosByText(paramString);
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new AccessibilityNodeInfoCompat((AccessibilityNodeInfo)paramString.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public List findAccessibilityNodeInfosByViewId(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = IMPL.findAccessibilityNodeInfosByViewId(paramString);
    paramString = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add(new AccessibilityNodeInfoCompat((AccessibilityNodeInfo)((Iterator)localObject).next()));
    }
    return paramString;
  }
  
  public Object focusSearch()
  {
    return IMPL;
  }
  
  public AccessibilityNodeInfoCompat focusSearch(int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    return wrapNonNullInstance(IMPL.focusSearch(paramInt));
  }
  
  public CharSequence get()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return IMPL.getPaneTitle();
    }
    return IMPL.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY");
  }
  
  public List getActionList()
  {
    List localList;
    if (Build.VERSION.SDK_INT >= 21) {
      localList = IMPL.getActionList();
    } else {
      localList = null;
    }
    if (localList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new AccessibilityActionCompat(localList.get(i)));
        i += 1;
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  public int getActions()
  {
    return IMPL.getActions();
  }
  
  public void getBoundsInParent(Rect paramRect)
  {
    IMPL.getBoundsInParent(paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    IMPL.getBoundsInScreen(paramRect);
  }
  
  public AccessibilityNodeInfoCompat getChild()
  {
    if (Build.VERSION.SDK_INT >= 22) {
      return wrapNonNullInstance(IMPL.getTraversalBefore());
    }
    return null;
  }
  
  public AccessibilityNodeInfoCompat getChild(int paramInt)
  {
    return wrapNonNullInstance(IMPL.getChild(paramInt));
  }
  
  public void getChild(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      IMPL.setHeading(paramBoolean);
      return;
    }
    put(2, paramBoolean);
  }
  
  public CharSequence getClassName()
  {
    return IMPL.getClassName();
  }
  
  public CollectionInfoCompat getCollectionInfo()
  {
    int i = Build.VERSION.SDK_INT;
    AccessibilityNodeInfo.CollectionInfo localCollectionInfo = IMPL.getCollectionInfo();
    if (localCollectionInfo != null) {
      return new CollectionInfoCompat(localCollectionInfo);
    }
    return null;
  }
  
  public CollectionItemInfoCompat getCollectionItemInfo()
  {
    int i = Build.VERSION.SDK_INT;
    AccessibilityNodeInfo.CollectionItemInfo localCollectionItemInfo = IMPL.getCollectionItemInfo();
    if (localCollectionItemInfo != null) {
      return new CollectionItemInfoCompat(localCollectionItemInfo);
    }
    return null;
  }
  
  public CharSequence getContentDescription()
  {
    return IMPL.getContentDescription();
  }
  
  public CharSequence getError()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return IMPL.getError();
    }
    return null;
  }
  
  public Bundle getExtras()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.getExtras();
  }
  
  public AccessibilityNodeInfo getInfo()
  {
    return IMPL;
  }
  
  public int getInputType()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.getInputType();
  }
  
  public AccessibilityNodeInfoCompat getLabelFor()
  {
    int i = Build.VERSION.SDK_INT;
    return wrapNonNullInstance(IMPL.getLabelFor());
  }
  
  public AccessibilityNodeInfoCompat getLabeledBy()
  {
    int i = Build.VERSION.SDK_INT;
    return wrapNonNullInstance(IMPL.getLabeledBy());
  }
  
  public int getLiveRegion()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.getLiveRegion();
  }
  
  public int getMaxTextLength()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return IMPL.getMaxTextLength();
    }
    return -1;
  }
  
  public CharSequence getMessage()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return IMPL.getTooltipText();
    }
    return IMPL.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
  }
  
  public int getMovementGranularities()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.getMovementGranularities();
  }
  
  public CharSequence getPackageName()
  {
    return IMPL.getPackageName();
  }
  
  public AccessibilityNodeInfoCompat getParent()
  {
    return wrapNonNullInstance(IMPL.getParent());
  }
  
  public RangeInfoCompat getRangeInfo()
  {
    int i = Build.VERSION.SDK_INT;
    AccessibilityNodeInfo.RangeInfo localRangeInfo = IMPL.getRangeInfo();
    if (localRangeInfo != null) {
      return new RangeInfoCompat(localRangeInfo);
    }
    return null;
  }
  
  public CharSequence getText()
  {
    return IMPL.getText();
  }
  
  public int getTextSelectionEnd()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.getTextSelectionEnd();
  }
  
  public int getTextSelectionStart()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.getTextSelectionStart();
  }
  
  public AccessibilityNodeInfoCompat getTraversalAfter()
  {
    if (Build.VERSION.SDK_INT >= 22) {
      return wrapNonNullInstance(IMPL.getTraversalAfter());
    }
    return null;
  }
  
  public String getViewIdResourceName()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.getViewIdResourceName();
  }
  
  public AccessibilityWindowInfoCompat getWindow()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow());
    }
    return null;
  }
  
  public int getWindowId()
  {
    return IMPL.getWindowId();
  }
  
  public int hashCode()
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = IMPL;
    if (localAccessibilityNodeInfo == null) {
      return 0;
    }
    return localAccessibilityNodeInfo.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.isAccessibilityFocused();
  }
  
  public boolean isCheckable()
  {
    return IMPL.isCheckable();
  }
  
  public boolean isChecked()
  {
    return IMPL.isChecked();
  }
  
  public boolean isClickable()
  {
    return IMPL.isClickable();
  }
  
  public boolean isContentInvalid()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.isContentInvalid();
  }
  
  public boolean isDismissable()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.isDismissable();
  }
  
  public boolean isEditable()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.isEditable();
  }
  
  public boolean isEnabled()
  {
    return IMPL.isEnabled();
  }
  
  public boolean isFocusable()
  {
    return IMPL.isFocusable();
  }
  
  public boolean isFocused()
  {
    return IMPL.isFocused();
  }
  
  public boolean isLongClickable()
  {
    return IMPL.isLongClickable();
  }
  
  public boolean isMultiLine()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.isMultiLine();
  }
  
  public boolean isPassword()
  {
    return IMPL.isPassword();
  }
  
  public boolean isScrollable()
  {
    return IMPL.isScrollable();
  }
  
  public boolean isSelected()
  {
    return IMPL.isSelected();
  }
  
  public boolean isVisibleToUser()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.isVisibleToUser();
  }
  
  public void newInstance(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      IMPL.setTooltipText(paramCharSequence);
      return;
    }
    IMPL.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY", paramCharSequence);
  }
  
  public AccessibilityNodeInfoCompat obtain(int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    return wrapNonNullInstance(IMPL.findFocus(paramInt));
  }
  
  public void obtain(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      IMPL.setScreenReaderFocusable(paramBoolean);
      return;
    }
    put(1, paramBoolean);
  }
  
  public CharSequence onActivityCreated()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.getExtras().getCharSequence("AccessibilityNodeInfo.roleDescription");
  }
  
  public boolean performAction()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return IMPL.isHeading();
    }
    if (equals(2)) {
      return true;
    }
    CollectionItemInfoCompat localCollectionItemInfoCompat = getCollectionItemInfo();
    return (localCollectionItemInfoCompat != null) && (localCollectionItemInfoCompat.isHeading());
  }
  
  public boolean performAction(int paramInt)
  {
    return IMPL.performAction(paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.performAction(paramInt, paramBundle);
  }
  
  public int recycle()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return IMPL.getDrawingOrder();
    }
    return 0;
  }
  
  public boolean refresh()
  {
    int i = Build.VERSION.SDK_INT;
    return IMPL.refresh();
  }
  
  public boolean removeAction()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return IMPL.isScreenReaderFocusable();
    }
    return equals(1);
  }
  
  public boolean removeAction(AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return IMPL.removeAction((AccessibilityNodeInfo.AccessibilityAction)mInfo);
    }
    return false;
  }
  
  public boolean removeChild()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return IMPL.isContextClickable();
    }
    return false;
  }
  
  public boolean removeChild(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return IMPL.removeChild(paramView);
    }
    return false;
  }
  
  public boolean removeChild(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return IMPL.removeChild(paramView, paramInt);
    }
    return false;
  }
  
  public void setAccessibilityFocused(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setAccessibilityFocused(paramBoolean);
  }
  
  public void setBoundsInParent(Rect paramRect)
  {
    IMPL.setBoundsInParent(paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect)
  {
    IMPL.setBoundsInScreen(paramRect);
  }
  
  public void setCanOpenPopup(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setCanOpenPopup(paramBoolean);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    IMPL.setCheckable(paramBoolean);
  }
  
  public void setClassName()
  {
    IMPL.recycle();
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    IMPL.setClickable(paramBoolean);
  }
  
  public void setCollectionInfo(Object paramObject)
  {
    int i = Build.VERSION.SDK_INT;
    AccessibilityNodeInfo localAccessibilityNodeInfo = IMPL;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = (AccessibilityNodeInfo.CollectionInfo)mInfo;
    }
    localAccessibilityNodeInfo.setCollectionInfo(paramObject);
  }
  
  public void setCollectionItemInfo(Object paramObject)
  {
    int i = Build.VERSION.SDK_INT;
    AccessibilityNodeInfo localAccessibilityNodeInfo = IMPL;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = (AccessibilityNodeInfo.CollectionItemInfo)mInfo;
    }
    localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    IMPL.setContentDescription(paramCharSequence);
  }
  
  public void setContentInvalid(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setContentInvalid(paramBoolean);
  }
  
  public void setEditable(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setEditable(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    IMPL.setEnabled(paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    IMPL.setText(paramCharSequence);
  }
  
  public void setError(boolean paramBoolean)
  {
    IMPL.setChecked(paramBoolean);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    IMPL.setFocusable(paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean)
  {
    IMPL.setFocused(paramBoolean);
  }
  
  public void setInputType(int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setInputType(paramInt);
  }
  
  public void setLabelFor(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setLabelFor(paramView, paramInt);
  }
  
  public void setLabeledBy(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setLabeledBy(paramView);
  }
  
  public void setLabeledBy(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setLabeledBy(paramView, paramInt);
  }
  
  public void setLiveRegion(int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setLiveRegion(paramInt);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    IMPL.setLongClickable(paramBoolean);
  }
  
  public void setMovementGranularities(int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setMovementGranularities(paramInt);
  }
  
  public void setMultiLine(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setMultiLine(paramBoolean);
  }
  
  public void setPackageName(CharSequence paramCharSequence)
  {
    IMPL.setPackageName(paramCharSequence);
  }
  
  public CharSequence setParent()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return IMPL.getHintText();
    }
    return IMPL.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY");
  }
  
  public void setParent(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL.setMaxTextLength(paramInt);
    }
  }
  
  public void setParent(View paramView)
  {
    IMPL.setParent(paramView);
  }
  
  public void setParent(View paramView, int paramInt)
  {
    top = paramInt;
    int i = Build.VERSION.SDK_INT;
    IMPL.setParent(paramView, paramInt);
  }
  
  public void setParent(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL.setError(paramCharSequence);
    }
  }
  
  public void setParent(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setViewIdResourceName(paramString);
  }
  
  public void setParent(RangeInfoCompat paramRangeInfoCompat)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setRangeInfo((AccessibilityNodeInfo.RangeInfo)mInfo);
  }
  
  public void setParent(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      IMPL.setContextClickable(paramBoolean);
    }
  }
  
  public void setPassword(boolean paramBoolean)
  {
    IMPL.setPassword(paramBoolean);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(paramBoolean);
  }
  
  public void setSelected(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      IMPL.setDrawingOrder(paramInt);
    }
  }
  
  public void setSelected(int paramInt1, int paramInt2)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setTextSelection(paramInt1, paramInt2);
  }
  
  public void setSelected(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setLabelFor(paramView);
  }
  
  public void setSelected(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      IMPL.setTraversalAfter(paramView, paramInt);
    }
  }
  
  public void setSelected(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      IMPL.setPaneTitle(paramCharSequence);
      return;
    }
    IMPL.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", paramCharSequence);
  }
  
  public void setSelected(AccessibilityActionCompat paramAccessibilityActionCompat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL.addAction((AccessibilityNodeInfo.AccessibilityAction)mInfo);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    IMPL.setSelected(paramBoolean);
  }
  
  public boolean setSelected()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return IMPL.isImportantForAccessibility();
    }
    return true;
  }
  
  public void setSource(View paramView)
  {
    IMPL.setSource(paramView);
  }
  
  public void setSource(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setSource(paramView, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL.setHintText(paramCharSequence);
      return;
    }
    IMPL.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", paramCharSequence);
  }
  
  public void setText(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL.setShowingHintText(paramBoolean);
      return;
    }
    put(4, paramBoolean);
  }
  
  public void setTraversalAfter(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      IMPL.setTraversalAfter(paramView);
    }
  }
  
  public void setTraversalBefore(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      IMPL.setTraversalBefore(paramView);
    }
  }
  
  public void setTraversalBefore(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      IMPL.setTraversalBefore(paramView, paramInt);
    }
  }
  
  public void setVisibleToUser(boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    IMPL.setVisibleToUser(paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; boundsInParent: ");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    getBoundsInScreen((Rect)localObject);
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; boundsInScreen: ");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("; packageName: ");
    localStringBuilder1.append(getPackageName());
    localStringBuilder1.append("; className: ");
    localStringBuilder1.append(getClassName());
    localStringBuilder1.append("; text: ");
    localStringBuilder1.append(getText());
    localStringBuilder1.append("; contentDescription: ");
    localStringBuilder1.append(getContentDescription());
    localStringBuilder1.append("; viewId: ");
    localStringBuilder1.append(getViewIdResourceName());
    localStringBuilder1.append("; checkable: ");
    localStringBuilder1.append(isCheckable());
    localStringBuilder1.append("; checked: ");
    localStringBuilder1.append(isChecked());
    localStringBuilder1.append("; focusable: ");
    localStringBuilder1.append(isFocusable());
    localStringBuilder1.append("; focused: ");
    localStringBuilder1.append(isFocused());
    localStringBuilder1.append("; selected: ");
    localStringBuilder1.append(isSelected());
    localStringBuilder1.append("; clickable: ");
    localStringBuilder1.append(isClickable());
    localStringBuilder1.append("; longClickable: ");
    localStringBuilder1.append(isLongClickable());
    localStringBuilder1.append("; enabled: ");
    localStringBuilder1.append(isEnabled());
    localStringBuilder1.append("; password: ");
    localStringBuilder1.append(isPassword());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("; scrollable: ");
    ((StringBuilder)localObject).append(isScrollable());
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localStringBuilder1.append("; [");
    int i = getActions();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & k;
      localStringBuilder1.append(getActionSymbolicName(k));
      i = j;
      if (j != 0)
      {
        localStringBuilder1.append(", ");
        i = j;
      }
    }
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  public class AccessibilityActionCompat
  {
    public static final AccessibilityActionCompat $VALUES;
    public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
    public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    public static final AccessibilityActionCompat ACTION_CLICK;
    public static final AccessibilityActionCompat ACTION_COLLAPSE;
    public static final AccessibilityActionCompat ACTION_COPY;
    public static final AccessibilityActionCompat ACTION_CUT;
    public static final AccessibilityActionCompat ACTION_DISMISS;
    public static final AccessibilityActionCompat ACTION_EXPAND;
    public static final AccessibilityActionCompat ACTION_FOCUS;
    public static final AccessibilityActionCompat ACTION_LONG_CLICK;
    public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    public static final AccessibilityActionCompat ACTION_PASTE;
    public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    public static final AccessibilityActionCompat ACTION_SELECT;
    public static final AccessibilityActionCompat ACTION_SET_SELECTION;
    public static final AccessibilityActionCompat ACTION_SET_TEXT;
    public static final AccessibilityActionCompat CLOUDS_BROKEN;
    public static final AccessibilityActionCompat CLOUDS_OVERCAST;
    public static final AccessibilityActionCompat COLD;
    public static final AccessibilityActionCompat HAIL;
    public static final AccessibilityActionCompat HOT;
    public static final AccessibilityActionCompat HURRICANE;
    public static final AccessibilityActionCompat TORNADO;
    public static final AccessibilityActionCompat TROPICAL_STORM;
    public static final AccessibilityActionCompat WINDY;
    public static final AccessibilityActionCompat mSelectedDay;
    
    static
    {
      Object localObject2 = null;
      ACTION_FOCUS = new AccessibilityActionCompat(1, null);
      ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
      ACTION_EXPAND = new AccessibilityActionCompat(4, null);
      ACTION_COLLAPSE = new AccessibilityActionCompat(8, null);
      mSelectedDay = new AccessibilityActionCompat(16, null);
      ACTION_DISMISS = new AccessibilityActionCompat(32, null);
      ACTION_SET_TEXT = new AccessibilityActionCompat(64, null);
      ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(128, null);
      ACTION_COPY = new AccessibilityActionCompat(256, null);
      ACTION_PASTE = new AccessibilityActionCompat(512, null);
      ACTION_CUT = new AccessibilityActionCompat(1024, null);
      ACTION_SET_SELECTION = new AccessibilityActionCompat(2048, null);
      ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
      ACTION_SELECT = new AccessibilityActionCompat(8192, null);
      ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(16384, null);
      ACTION_CLICK = new AccessibilityActionCompat(32768, null);
      ACTION_LONG_CLICK = new AccessibilityActionCompat(65536, null);
      ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(131072, null);
      ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(262144, null);
      ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(524288, null);
      ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(1048576, null);
      ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(2097152, null);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
      } else {
        localObject1 = null;
      }
      ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
      } else {
        localObject1 = null;
      }
      CLOUDS_BROKEN = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
      } else {
        localObject1 = null;
      }
      CLOUDS_OVERCAST = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
      } else {
        localObject1 = null;
      }
      TORNADO = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
      } else {
        localObject1 = null;
      }
      TROPICAL_STORM = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
      } else {
        localObject1 = null;
      }
      HURRICANE = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 23) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
      } else {
        localObject1 = null;
      }
      COLD = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 24) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
      } else {
        localObject1 = null;
      }
      HOT = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
      } else {
        localObject1 = null;
      }
      WINDY = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT >= 28) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
      } else {
        localObject1 = null;
      }
      HAIL = new AccessibilityActionCompat(localObject1);
      Object localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 28) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
      }
      $VALUES = new AccessibilityActionCompat(localObject1);
    }
    
    public AccessibilityActionCompat(CharSequence paramCharSequence) {}
    
    public AccessibilityActionCompat() {}
    
    public int getId()
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return ((AccessibilityNodeInfo.AccessibilityAction)AccessibilityNodeInfoCompat.this).getId();
      }
      return 0;
    }
    
    public CharSequence getLabel()
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return ((AccessibilityNodeInfo.AccessibilityAction)AccessibilityNodeInfoCompat.this).getLabel();
      }
      return null;
    }
  }
  
  public class CollectionInfoCompat
  {
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_SINGLE = 1;
    
    public CollectionInfoCompat() {}
    
    public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = Build.VERSION.SDK_INT;
      return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean));
    }
    
    public static CollectionInfoCompat obtain(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean, paramInt3));
      }
      return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean));
    }
    
    public int getColumnCount()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.CollectionInfo)AccessibilityNodeInfoCompat.this).getColumnCount();
    }
    
    public int getRowCount()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.CollectionInfo)AccessibilityNodeInfoCompat.this).getRowCount();
    }
    
    public boolean isHierarchical()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.CollectionInfo)AccessibilityNodeInfoCompat.this).isHierarchical();
    }
    
    public int obtain()
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return ((AccessibilityNodeInfo.CollectionInfo)AccessibilityNodeInfoCompat.this).getSelectionMode();
      }
      return 0;
    }
  }
  
  public class CollectionItemInfoCompat
  {
    public CollectionItemInfoCompat() {}
    
    public static CollectionItemInfoCompat obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int i = Build.VERSION.SDK_INT;
      return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
    }
    
    public static CollectionItemInfoCompat obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
      }
      return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1));
    }
    
    public int getColumnIndex()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.CollectionItemInfo)AccessibilityNodeInfoCompat.this).getColumnIndex();
    }
    
    public int getColumnSpan()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.CollectionItemInfo)AccessibilityNodeInfoCompat.this).getColumnSpan();
    }
    
    public int getRowIndex()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.CollectionItemInfo)AccessibilityNodeInfoCompat.this).getRowIndex();
    }
    
    public int getRowSpan()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.CollectionItemInfo)AccessibilityNodeInfoCompat.this).getRowSpan();
    }
    
    public boolean isHeading()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.CollectionItemInfo)AccessibilityNodeInfoCompat.this).isHeading();
    }
    
    public boolean isSelected()
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return ((AccessibilityNodeInfo.CollectionItemInfo)AccessibilityNodeInfoCompat.this).isSelected();
      }
      return false;
    }
  }
  
  public class RangeInfoCompat
  {
    public static final int RANGE_TYPE_FLOAT = 1;
    public static final int RANGE_TYPE_INT = 0;
    public static final int RANGE_TYPE_PERCENT = 2;
    
    public RangeInfoCompat() {}
    
    public static RangeInfoCompat a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      int i = Build.VERSION.SDK_INT;
      return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(paramInt, paramFloat1, paramFloat2, paramFloat3));
    }
    
    public float getCurrent()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.RangeInfo)AccessibilityNodeInfoCompat.this).getCurrent();
    }
    
    public float getMax()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.RangeInfo)AccessibilityNodeInfoCompat.this).getMax();
    }
    
    public float getMin()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.RangeInfo)AccessibilityNodeInfoCompat.this).getMin();
    }
    
    public int getType()
    {
      int i = Build.VERSION.SDK_INT;
      return ((AccessibilityNodeInfo.RangeInfo)AccessibilityNodeInfoCompat.this).getType();
    }
  }
}
