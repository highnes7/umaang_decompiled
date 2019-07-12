package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;
import support.android.v4.view.ViewCompat;
import support.android.v4.widget.PopupWindowCompat;

public class ListPopupWindow
  implements ShowableListMenu
{
  public static final boolean DEBUG = false;
  public static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  public static final int MATCH_PARENT = -1;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  public static final String TAG = "ListPopupWindow";
  public static final int WRAP_CONTENT = -2;
  public static Method sClipToWindowEnabledMethod;
  public static Method sGetMaxAvailableHeightMethod;
  public static Method sSetEpicenterBoundsMethod;
  public ListAdapter mAdapter;
  public Context mContext;
  public boolean mDropDownAlwaysVisible = false;
  public View mDropDownAnchorView;
  public int mDropDownGravity = 0;
  public int mDropDownHeight = -2;
  public int mDropDownHorizontalOffset;
  public DropDownListView mDropDownList;
  public Drawable mDropDownListHighlight;
  public int mDropDownVerticalOffset;
  public boolean mDropDownVerticalOffsetSet;
  public int mDropDownWidth = -2;
  public int mDropDownWindowLayoutType = 1002;
  public Rect mEpicenterBounds;
  public boolean mForceIgnoreOutsideTouch = false;
  public final Handler mHandler;
  public final ListSelectorHider mHideSelector = new ListSelectorHider();
  public boolean mIsAnimatedFromAnchor = true;
  public AdapterView.OnItemClickListener mItemClickListener;
  public AdapterView.OnItemSelectedListener mItemSelectedListener;
  public int mListItemExpandMaximum = Integer.MAX_VALUE;
  public boolean mModal;
  public DataSetObserver mObserver;
  public boolean mOverlapAnchor;
  public boolean mOverlapAnchorSet;
  public PopupWindow mPopup;
  public int mPromptPosition = 0;
  public View mPromptView;
  public final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable();
  public final PopupScrollListener mScrollListener = new PopupScrollListener();
  public Runnable mShowDropDownRunnable;
  public final Rect mTempRect = new Rect();
  public final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
  
  static
  {
    Object localObject = Boolean.TYPE;
    try
    {
      localObject = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { localObject });
      sClipToWindowEnabledMethod = (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          Class localClass;
          localObject = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, localObject, localClass });
          sGetMaxAvailableHeightMethod = (Method)localObject;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          continue;
        }
        try
        {
          localObject = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
          sSetEpicenterBoundsMethod = (Method)localObject;
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException3) {}
        localNoSuchMethodException1 = localNoSuchMethodException1;
      }
    }
    localObject = Integer.TYPE;
    localClass = Boolean.TYPE;
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    mContext = paramContext;
    mHandler = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    mDropDownHorizontalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    mDropDownVerticalOffset = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (mDropDownVerticalOffset != 0) {
      mDropDownVerticalOffsetSet = true;
    }
    localTypedArray.recycle();
    mPopup = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    mPopup.setInputMethodMode(1);
  }
  
  private int buildDropDown()
  {
    Object localObject1 = mDropDownList;
    boolean bool = true;
    Object localObject2;
    int i;
    int j;
    if (localObject1 == null)
    {
      localObject1 = mContext;
      mShowDropDownRunnable = new Runnable()
      {
        public void run()
        {
          View localView = getAnchorView();
          if ((localView != null) && (localView.getWindowToken() != null)) {
            show();
          }
        }
      };
      mDropDownList = createDropDownListView((Context)localObject1, mModal ^ true);
      localObject2 = mDropDownListHighlight;
      if (localObject2 != null) {
        mDropDownList.setSelector((Drawable)localObject2);
      }
      mDropDownList.setAdapter(mAdapter);
      mDropDownList.setOnItemClickListener(mItemClickListener);
      mDropDownList.setFocusable(true);
      mDropDownList.setFocusableInTouchMode(true);
      mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (paramAnonymousInt != -1)
          {
            paramAnonymousAdapterView = mDropDownList;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousAdapterView.setListSelectionHidden(false);
            }
          }
        }
        
        public void onNothingSelected(AdapterView paramAnonymousAdapterView) {}
      });
      mDropDownList.setOnScrollListener(mScrollListener);
      localObject2 = mItemSelectedListener;
      if (localObject2 != null) {
        mDropDownList.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
      }
      localObject2 = mDropDownList;
      View localView = mPromptView;
      if (localView != null)
      {
        localObject1 = new LinearLayout((Context)localObject1);
        ((LinearLayout)localObject1).setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        i = mPromptPosition;
        if (i != 0)
        {
          if (i != 1)
          {
            localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Invalid hint position ");
            ((StringBuilder)localObject2).append(mPromptPosition);
            ((StringBuilder)localObject2).toString();
          }
          else
          {
            ((ViewGroup)localObject1).addView((View)localObject2, localLayoutParams);
            ((ViewGroup)localObject1).addView(localView);
          }
        }
        else
        {
          ((ViewGroup)localObject1).addView(localView);
          ((ViewGroup)localObject1).addView((View)localObject2, localLayoutParams);
        }
        i = mDropDownWidth;
        if (i >= 0)
        {
          j = Integer.MIN_VALUE;
        }
        else
        {
          i = 0;
          j = 0;
        }
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, j), 0);
        localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        i = localView.getMeasuredHeight() + topMargin + bottomMargin;
      }
      else
      {
        i = 0;
        localObject1 = localObject2;
      }
      mPopup.setContentView((View)localObject1);
    }
    else
    {
      localObject1 = (ViewGroup)mPopup.getContentView();
      localObject1 = mPromptView;
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = ((View)localObject1).getMeasuredHeight();
        j = topMargin;
        i = bottomMargin + (i + j);
      }
      else
      {
        i = 0;
      }
    }
    localObject1 = mPopup.getBackground();
    int k;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(mTempRect);
      localObject1 = mTempRect;
      m = top;
      j = bottom + m;
      k = j;
      if (!mDropDownVerticalOffsetSet)
      {
        mDropDownVerticalOffset = (-m);
        k = j;
      }
    }
    else
    {
      mTempRect.setEmpty();
      k = 0;
    }
    if (mPopup.getInputMethodMode() != 2) {
      bool = false;
    }
    int m = getMaxAvailableHeight(getAnchorView(), mDropDownVerticalOffset, bool);
    if ((!mDropDownAlwaysVisible) && (mDropDownHeight != -1))
    {
      j = mDropDownWidth;
      if (j != -2)
      {
        if (j != -1)
        {
          j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        }
        else
        {
          j = mContext.getResources().getDisplayMetrics().widthPixels;
          localObject1 = mTempRect;
          j = View.MeasureSpec.makeMeasureSpec(j - (left + right), 1073741824);
        }
      }
      else
      {
        j = mContext.getResources().getDisplayMetrics().widthPixels;
        localObject1 = mTempRect;
        j = View.MeasureSpec.makeMeasureSpec(j - (left + right), Integer.MIN_VALUE);
      }
      m = mDropDownList.measureHeightOfChildrenCompat(j, 0, -1, m - i, -1);
      j = i;
      if (m > 0)
      {
        j = mDropDownList.getPaddingTop();
        j = i + (mDropDownList.getPaddingBottom() + j + k);
      }
      return m + j;
    }
    return m + k;
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Object localObject = sGetMaxAvailableHeightMethod;
    PopupWindow localPopupWindow;
    if (localObject != null) {
      localPopupWindow = mPopup;
    }
    try
    {
      localObject = ((Method)localObject).invoke(localPopupWindow, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      localObject = (Integer)localObject;
      int i = ((Integer)localObject).intValue();
      return i;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return mPopup.getMaxAvailableHeight(paramView, paramInt);
  }
  
  public static boolean isConfirmKey(int paramInt)
  {
    return (paramInt == 66) || (paramInt == 23);
  }
  
  private void removePromptView()
  {
    Object localObject = mPromptView;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(mPromptView);
      }
    }
  }
  
  private void setPopupClipToScreenEnabled(boolean paramBoolean)
  {
    Method localMethod = sClipToWindowEnabledMethod;
    if (localMethod != null)
    {
      PopupWindow localPopupWindow = mPopup;
      try
      {
        localMethod.invoke(localPopupWindow, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public void clearListSelection()
  {
    DropDownListView localDropDownListView = mDropDownList;
    if (localDropDownListView != null)
    {
      localDropDownListView.setListSelectionHidden(true);
      localDropDownListView.requestLayout();
    }
  }
  
  public View.OnTouchListener createDragToOpenListener(View paramView)
  {
    new ForwardingListener(paramView)
    {
      public ListPopupWindow getPopup()
      {
        return ListPopupWindow.this;
      }
    };
  }
  
  public DropDownListView createDropDownListView(Context paramContext, boolean paramBoolean)
  {
    return new DropDownListView(paramContext, paramBoolean);
  }
  
  public void dismiss()
  {
    mPopup.dismiss();
    removePromptView();
    mPopup.setContentView(null);
    mDropDownList = null;
    mHandler.removeCallbacks(mResizePopupRunnable);
  }
  
  public View getAnchorView()
  {
    return mDropDownAnchorView;
  }
  
  public int getAnimationStyle()
  {
    return mPopup.getAnimationStyle();
  }
  
  public Drawable getBackground()
  {
    return mPopup.getBackground();
  }
  
  public int getHeight()
  {
    return mDropDownHeight;
  }
  
  public int getHorizontalOffset()
  {
    return mDropDownHorizontalOffset;
  }
  
  public int getInputMethodMode()
  {
    return mPopup.getInputMethodMode();
  }
  
  public ListView getListView()
  {
    return mDropDownList;
  }
  
  public int getPromptPosition()
  {
    return mPromptPosition;
  }
  
  public Object getSelectedItem()
  {
    if (!isShowing()) {
      return null;
    }
    return mDropDownList.getSelectedItem();
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {
      return Long.MIN_VALUE;
    }
    return mDropDownList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {
      return -1;
    }
    return mDropDownList.getSelectedItemPosition();
  }
  
  public View getSelectedView()
  {
    if (!isShowing()) {
      return null;
    }
    return mDropDownList.getSelectedView();
  }
  
  public int getSoftInputMode()
  {
    return mPopup.getSoftInputMode();
  }
  
  public int getVerticalOffset()
  {
    if (!mDropDownVerticalOffsetSet) {
      return 0;
    }
    return mDropDownVerticalOffset;
  }
  
  public int getWidth()
  {
    return mDropDownWidth;
  }
  
  public boolean isDropDownAlwaysVisible()
  {
    return mDropDownAlwaysVisible;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    return mPopup.getInputMethodMode() == 2;
  }
  
  public boolean isModal()
  {
    return mModal;
  }
  
  public boolean isShowing()
  {
    return mPopup.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((isShowing()) && (paramInt != 62) && ((mDropDownList.getSelectedItemPosition() >= 0) || (!isConfirmKey(paramInt))))
    {
      int k = mDropDownList.getSelectedItemPosition();
      boolean bool1 = mPopup.isAboveAnchor() ^ true;
      ListAdapter localListAdapter = mAdapter;
      int i = Integer.MAX_VALUE;
      int j;
      if (localListAdapter != null)
      {
        boolean bool2 = localListAdapter.areAllItemsEnabled();
        if (bool2) {
          i = 0;
        } else {
          i = mDropDownList.lookForSelectablePosition(0, true);
        }
        if (bool2) {
          j = localListAdapter.getCount() - 1;
        } else {
          j = mDropDownList.lookForSelectablePosition(localListAdapter.getCount() - 1, false);
        }
      }
      else
      {
        j = Integer.MIN_VALUE;
      }
      if (((bool1) && (paramInt == 19) && (k <= i)) || ((!bool1) && (paramInt == 20) && (k >= j)))
      {
        clearListSelection();
        mPopup.setInputMethodMode(1);
        show();
        return true;
      }
      mDropDownList.setListSelectionHidden(false);
      if (mDropDownList.onKeyDown(paramInt, paramKeyEvent))
      {
        mPopup.setInputMethodMode(2);
        mDropDownList.requestFocusFromTouch();
        show();
        if (paramInt != 19)
        {
          if ((paramInt != 20) && (paramInt != 23) && (paramInt != 66)) {
            return false;
          }
        }
        else {
          return true;
        }
      }
      else
      {
        if ((bool1) && (paramInt == 20))
        {
          if (k != j) {
            break label303;
          }
          return true;
        }
        if ((bool1) || (paramInt != 19) || (k != i)) {
          break label303;
        }
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
    label303:
    return false;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (isShowing()))
    {
      Object localObject = mDropDownAnchorView;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localObject = ((View)localObject).getKeyDispatcherState();
        if (localObject == null) {
          break label92;
        }
        ((KeyEvent.DispatcherState)localObject).startTracking(paramKeyEvent, this);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localObject = ((View)localObject).getKeyDispatcherState();
        if (localObject != null) {
          ((KeyEvent.DispatcherState)localObject).handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          dismiss();
          return true;
        }
      }
    }
    return false;
    label92:
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((isShowing()) && (mDropDownList.getSelectedItemPosition() >= 0))
    {
      bool = mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if ((bool) && (isConfirmKey(paramInt)))
      {
        dismiss();
        return bool;
      }
    }
    else
    {
      return false;
    }
    return bool;
  }
  
  public boolean performItemClick(int paramInt)
  {
    if (isShowing())
    {
      if (mItemClickListener != null)
      {
        DropDownListView localDropDownListView = mDropDownList;
        View localView = localDropDownListView.getChildAt(paramInt - localDropDownListView.getFirstVisiblePosition());
        ListAdapter localListAdapter = localDropDownListView.getAdapter();
        mItemClickListener.onItemClick(localDropDownListView, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
      return true;
    }
    return false;
  }
  
  public void postShow()
  {
    mHandler.post(mShowDropDownRunnable);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = mObserver;
    if (localDataSetObserver == null)
    {
      mObserver = new PopupDataSetObserver();
    }
    else
    {
      ListAdapter localListAdapter = mAdapter;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    mAdapter = paramListAdapter;
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(mObserver);
    }
    paramListAdapter = mDropDownList;
    if (paramListAdapter != null) {
      paramListAdapter.setAdapter(mAdapter);
    }
  }
  
  public void setAnchorView(View paramView)
  {
    mDropDownAnchorView = paramView;
  }
  
  public void setAnimationStyle(int paramInt)
  {
    mPopup.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Object localObject = mPopup.getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(mTempRect);
      localObject = mTempRect;
      mDropDownWidth = (left + right + paramInt);
      return;
    }
    setWidth(paramInt);
  }
  
  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    mDropDownAlwaysVisible = paramBoolean;
  }
  
  public void setDropDownGravity(int paramInt)
  {
    mDropDownGravity = paramInt;
  }
  
  public void setEpicenterBounds(Rect paramRect)
  {
    mEpicenterBounds = paramRect;
  }
  
  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    mForceIgnoreOutsideTouch = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    if ((paramInt < 0) && (-2 != paramInt) && (-1 != paramInt)) {
      throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }
    mDropDownHeight = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    mPopup.setInputMethodMode(paramInt);
  }
  
  public void setListItemExpandMax(int paramInt)
  {
    mListItemExpandMaximum = paramInt;
  }
  
  public void setListSelector(Drawable paramDrawable)
  {
    mDropDownListHighlight = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean)
  {
    mModal = paramBoolean;
    mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    mItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    mItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setOverlapAnchor(boolean paramBoolean)
  {
    mOverlapAnchorSet = true;
    mOverlapAnchor = paramBoolean;
  }
  
  public void setPromptPosition(int paramInt)
  {
    mPromptPosition = paramInt;
  }
  
  public void setPromptView(View paramView)
  {
    boolean bool = isShowing();
    if (bool) {
      removePromptView();
    }
    mPromptView = paramView;
    if (bool) {
      show();
    }
  }
  
  public void setSelection(int paramInt)
  {
    DropDownListView localDropDownListView = mDropDownList;
    if ((isShowing()) && (localDropDownListView != null))
    {
      localDropDownListView.setListSelectionHidden(false);
      localDropDownListView.setSelection(paramInt);
      if (localDropDownListView.getChoiceMode() != 0) {
        localDropDownListView.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setSoftInputMode(int paramInt)
  {
    mPopup.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt)
  {
    mDropDownVerticalOffset = paramInt;
    mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt)
  {
    mDropDownWidth = paramInt;
  }
  
  public void setWindowLayoutType(int paramInt)
  {
    mDropDownWindowLayoutType = paramInt;
  }
  
  public void show()
  {
    int j = buildDropDown();
    boolean bool2 = isInputMethodNotNeeded();
    PopupWindowCompat.setWindowLayoutType(mPopup, mDropDownWindowLayoutType);
    boolean bool3 = mPopup.isShowing();
    boolean bool1 = true;
    int i;
    Object localObject2;
    if (bool3)
    {
      if (!ViewCompat.cancel(getAnchorView())) {
        return;
      }
      k = mDropDownWidth;
      if (k == -1)
      {
        i = -1;
      }
      else
      {
        i = k;
        if (k == -2) {
          i = getAnchorView().getWidth();
        }
      }
      k = mDropDownHeight;
      if (k == -1)
      {
        if (!bool2) {
          j = -1;
        }
        if (bool2)
        {
          localObject1 = mPopup;
          if (mDropDownWidth == -1) {
            k = -1;
          } else {
            k = 0;
          }
          ((PopupWindow)localObject1).setWidth(k);
          mPopup.setHeight(0);
        }
        else
        {
          localObject1 = mPopup;
          if (mDropDownWidth == -1) {
            k = -1;
          } else {
            k = 0;
          }
          ((PopupWindow)localObject1).setWidth(k);
          mPopup.setHeight(-1);
        }
      }
      else if (k != -2)
      {
        j = k;
      }
      localObject1 = mPopup;
      if ((mForceIgnoreOutsideTouch) || (mDropDownAlwaysVisible)) {
        bool1 = false;
      }
      ((PopupWindow)localObject1).setOutsideTouchable(bool1);
      localObject1 = mPopup;
      localObject2 = getAnchorView();
      int m = mDropDownHorizontalOffset;
      int n = mDropDownVerticalOffset;
      k = i;
      if (i < 0) {
        k = -1;
      }
      i = j;
      if (j < 0) {
        i = -1;
      }
      ((PopupWindow)localObject1).update((View)localObject2, m, n, k, i);
      return;
    }
    int k = mDropDownWidth;
    if (k == -1)
    {
      i = -1;
    }
    else
    {
      i = k;
      if (k == -2) {
        i = getAnchorView().getWidth();
      }
    }
    k = mDropDownHeight;
    if (k == -1) {
      j = -1;
    } else if (k != -2) {
      j = k;
    }
    mPopup.setWidth(i);
    mPopup.setHeight(j);
    setPopupClipToScreenEnabled(true);
    Object localObject1 = mPopup;
    if ((!mForceIgnoreOutsideTouch) && (!mDropDownAlwaysVisible)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((PopupWindow)localObject1).setOutsideTouchable(bool1);
    mPopup.setTouchInterceptor(mTouchInterceptor);
    if (mOverlapAnchorSet) {
      PopupWindowCompat.init(mPopup, mOverlapAnchor);
    }
    localObject1 = sSetEpicenterBoundsMethod;
    Rect localRect;
    if (localObject1 != null)
    {
      localObject2 = mPopup;
      localRect = mEpicenterBounds;
    }
    try
    {
      ((Method)localObject1).invoke(localObject2, new Object[] { localRect });
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    PopupWindowCompat.showAsDropDown(mPopup, getAnchorView(), mDropDownHorizontalOffset, mDropDownVerticalOffset, mDropDownGravity);
    mDropDownList.setSelection(-1);
    if ((!mModal) || (mDropDownList.isInTouchMode())) {
      clearListSelection();
    }
    if (!mModal)
    {
      mHandler.post(mHideSelector);
      return;
    }
  }
  
  private class ListSelectorHider
    implements Runnable
  {
    public ListSelectorHider() {}
    
    public void run()
    {
      clearListSelection();
    }
  }
  
  private class PopupDataSetObserver
    extends DataSetObserver
  {
    public PopupDataSetObserver() {}
    
    public void onChanged()
    {
      if (isShowing()) {
        show();
      }
    }
    
    public void onInvalidated()
    {
      dismiss();
    }
  }
  
  private class PopupScrollListener
    implements AbsListView.OnScrollListener
  {
    public PopupScrollListener() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!isInputMethodNotNeeded()) && (mPopup.getContentView() != null))
      {
        paramAbsListView = ListPopupWindow.this;
        mHandler.removeCallbacks(mResizePopupRunnable);
        mResizePopupRunnable.run();
      }
    }
  }
  
  private class PopupTouchInterceptor
    implements View.OnTouchListener
  {
    public PopupTouchInterceptor() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if (i == 0)
      {
        paramView = mPopup;
        if ((paramView != null) && (paramView.isShowing()) && (j >= 0) && (j < mPopup.getWidth()) && (k >= 0) && (k < mPopup.getHeight()))
        {
          paramView = ListPopupWindow.this;
          mHandler.postDelayed(mResizePopupRunnable, 250L);
          break label126;
        }
      }
      if (i == 1)
      {
        paramView = ListPopupWindow.this;
        mHandler.removeCallbacks(mResizePopupRunnable);
      }
      label126:
      return false;
    }
  }
  
  private class ResizePopupRunnable
    implements Runnable
  {
    public ResizePopupRunnable() {}
    
    public void run()
    {
      Object localObject = mDropDownList;
      if ((localObject != null) && (ViewCompat.cancel((View)localObject)) && (mDropDownList.getCount() > mDropDownList.getChildCount()))
      {
        int i = mDropDownList.getChildCount();
        localObject = ListPopupWindow.this;
        if (i <= mListItemExpandMaximum)
        {
          mPopup.setInputMethodMode(2);
          show();
        }
      }
    }
  }
}
