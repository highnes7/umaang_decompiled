package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AbsSavedState;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import b.b.a.G;
import java.util.ArrayList;
import java.util.List;
import support.android.v4.content.ContextCompat;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.view.AccessibilityDelegateCompat;
import support.android.v4.view.GravityCompat;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import support.android.v4.widget.AppBarLayout.1;
import support.android.v4.widget.SplashScreen.5.1;
import support.android.v4.widget.VerticalProgressBar.SavedState.1;
import support.android.v4.widget.ViewDragHelper;
import support.android.v4.widget.ViewDragHelper.Callback;

public class DrawerLayout
  extends ViewGroup
{
  public static final boolean ALLOW_EDGE_LOCK = false;
  public static final boolean CAN_HIDE_DESCENDANTS;
  public static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
  public static final int[] CameraPreference;
  public static final int DEFAULT_SCRIM_COLOR = -1728053248;
  public static final int DRAWER_ELEVATION = 10;
  public static final int[] LAYOUT_ATTRS;
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNDEFINED = 3;
  public static final int LOCK_MODE_UNLOCKED = 0;
  public static final int MIN_DRAWER_MARGIN = 64;
  public static final int MIN_FLING_VELOCITY = 400;
  public static final int PEEK_DELAY = 160;
  public static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  public static final String TAG = "DrawerLayout";
  public static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
  public final b mChildAccessibilityDelegate = new b();
  public boolean mChildrenCanceledTouch;
  public boolean mDisallowInterceptRequested;
  public boolean mDrawStatusBarBackground;
  public float mDrawerElevation;
  public int mDrawerState;
  public boolean mFirstLayout = true;
  public boolean mInLayout;
  public float mInitialMotionX;
  public float mInitialMotionY;
  public Object mLastInsets;
  public final e mLeftCallback;
  public final ViewDragHelper mLeftDragger;
  @G
  public c mListener;
  public List<c> mListeners;
  public int mLockModeEnd = 3;
  public int mLockModeLeft = 3;
  public int mLockModeRight = 3;
  public int mLockModeStart = 3;
  public int mMinDrawerMargin;
  public final ArrayList<View> mNonDrawerViews;
  public final e mRightCallback;
  public final ViewDragHelper mRightDragger;
  public int mScrimColor = -1728053248;
  public float mScrimOpacity;
  public Paint mScrimPaint = new Paint();
  public Drawable mShadowEnd = null;
  public Drawable mShadowLeft = null;
  public Drawable mShadowLeftResolved;
  public Drawable mShadowRight = null;
  public Drawable mShadowRightResolved;
  public Drawable mShadowStart = null;
  public Drawable mStatusBarBackground;
  public Rect mTempRect;
  public CharSequence mTitleLeft;
  public CharSequence mTitleRight;
  public Matrix scale;
  
  static
  {
    boolean bool = true;
    CameraPreference = new int[] { 16843828 };
    LAYOUT_ATTRS = new int[] { 16842931 };
    int i = Build.VERSION.SDK_INT;
    CAN_HIDE_DESCENDANTS = true;
    if (i < 21) {
      bool = false;
    }
    SET_DRAWER_SHADOW_FROM_ELEVATION = bool;
  }
  
  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResourcesgetDisplayMetricsdensity;
    mMinDrawerMargin = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    mLeftCallback = new e(3);
    mRightCallback = new e(5);
    mLeftDragger = ViewDragHelper.create(this, 1.0F, mLeftCallback);
    mLeftDragger.setEdgeTrackingEnabled(1);
    mLeftDragger.setMinVelocity(f2);
    mLeftCallback.setDragger(mLeftDragger);
    mRightDragger = ViewDragHelper.create(this, 1.0F, mRightCallback);
    mRightDragger.setEdgeTrackingEnabled(2);
    mRightDragger.setMinVelocity(f2);
    mRightCallback.setDragger(mRightDragger);
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility(this, 1);
    ViewCompat.setAccessibilityDelegate(this, new a());
    setMotionEventSplittingEnabled(false);
    if (ViewCompat.getFitsSystemWindows(this)) {
      if (Build.VERSION.SDK_INT >= 21)
      {
        setOnApplyWindowInsetsListener(new AppBarLayout.1(this));
        setSystemUiVisibility(1280);
        paramContext = paramContext.obtainStyledAttributes(CameraPreference);
        try
        {
          mStatusBarBackground = paramContext.getDrawable(0);
          paramContext.recycle();
        }
        catch (Throwable paramAttributeSet)
        {
          paramContext.recycle();
          throw paramAttributeSet;
        }
      }
      else
      {
        mStatusBarBackground = null;
      }
    }
    mDrawerElevation = (f1 * 10.0F);
    mNonDrawerViews = new ArrayList();
  }
  
  public static boolean filter(View paramView)
  {
    return (ViewCompat.getImportantForAccessibility(paramView) != 4) && (ViewCompat.getImportantForAccessibility(paramView) != 2);
  }
  
  public static String gravityToString(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  public static boolean hasOpaqueBackground(View paramView)
  {
    paramView = paramView.getBackground();
    return (paramView != null) && (paramView.getOpacity() == -1);
  }
  
  private boolean hasPeekingDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (getChildAtgetLayoutParamsisPeeking) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean hasVisibleDrawer()
  {
    return findVisibleDrawer() != null;
  }
  
  private boolean mirror(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (DrawableCompat.isAutoMirrored(paramDrawable)))
    {
      DrawableCompat.setLayoutDirection(paramDrawable, paramInt);
      return true;
    }
    return false;
  }
  
  private MotionEvent onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    float f1 = getScrollX() - paramView.getLeft();
    float f2 = getScrollY() - paramView.getTop();
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.offsetLocation(f1, f2);
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity())
    {
      if (scale == null) {
        scale = new Matrix();
      }
      paramView.invert(scale);
      paramMotionEvent.transform(scale);
    }
    return paramMotionEvent;
  }
  
  private boolean onInterceptTouchEvent(float paramFloat1, float paramFloat2, View paramView)
  {
    if (mTempRect == null) {
      mTempRect = new Rect();
    }
    paramView.getHitRect(mTempRect);
    return mTempRect.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  private Drawable resolveLeftShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    Drawable localDrawable;
    if (i == 0)
    {
      localDrawable = mShadowStart;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return mShadowStart;
      }
    }
    else
    {
      localDrawable = mShadowEnd;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return mShadowEnd;
      }
    }
    return mShadowLeft;
  }
  
  private Drawable resolveRightShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    Drawable localDrawable;
    if (i == 0)
    {
      localDrawable = mShadowEnd;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return mShadowEnd;
      }
    }
    else
    {
      localDrawable = mShadowStart;
      if (localDrawable != null)
      {
        mirror(localDrawable, i);
        return mShadowStart;
      }
    }
    return mShadowRight;
  }
  
  private void resolveShadowDrawables()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    mShadowLeftResolved = resolveLeftShadow();
    mShadowRightResolved = resolveRightShadow();
  }
  
  private boolean toGlobalMotionEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (!paramView.getMatrix().isIdentity())
    {
      paramMotionEvent = onInterceptTouchEvent(paramMotionEvent, paramView);
      bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
      paramMotionEvent.recycle();
      return bool;
    }
    float f1 = getScrollX() - paramView.getLeft();
    float f2 = getScrollY() - paramView.getTop();
    paramMotionEvent.offsetLocation(f1, f2);
    boolean bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-f1, -f2);
    return bool;
  }
  
  private void updateChildrenImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!isDrawerView(localView))) || ((paramBoolean) && (localView == paramView))) {
        ViewCompat.setImportantForAccessibility(localView, 1);
      } else {
        ViewCompat.setImportantForAccessibility(localView, 4);
      }
      i += 1;
    }
  }
  
  public void addDrawerListener(c paramC)
  {
    if (paramC == null) {
      return;
    }
    if (mListeners == null) {
      mListeners = new ArrayList();
    }
    mListeners.add(paramC);
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int m = getChildCount();
    int k = 0;
    int i = 0;
    int j = 0;
    View localView;
    while (i < m)
    {
      localView = getChildAt(i);
      if (isDrawerView(localView))
      {
        if (isDrawerOpen(localView))
        {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          j = 1;
        }
      }
      else {
        mNonDrawerViews.add(localView);
      }
      i += 1;
    }
    if (j == 0)
    {
      j = mNonDrawerViews.size();
      i = k;
      while (i < j)
      {
        localView = (View)mNonDrawerViews.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    mNonDrawerViews.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((findOpenDrawer() == null) && (!isDrawerView(paramView))) {
      ViewCompat.setImportantForAccessibility(paramView, 1);
    } else {
      ViewCompat.setImportantForAccessibility(paramView, 4);
    }
    if (!CAN_HIDE_DESCENDANTS) {
      ViewCompat.setAccessibilityDelegate(paramView, mChildAccessibilityDelegate);
    }
  }
  
  public void cancelChildViewTouch()
  {
    if (!mChildrenCanceledTouch)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        getChildAt(i).dispatchTouchEvent(localMotionEvent);
        i += 1;
      }
      localMotionEvent.recycle();
      mChildrenCanceledTouch = true;
    }
  }
  
  public boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt)
  {
    return (getDrawerViewAbsoluteGravity(paramView) & paramInt) == paramInt;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void closeDrawer(int paramInt)
  {
    closeDrawer(paramInt, true);
  }
  
  public void closeDrawer(int paramInt, boolean paramBoolean)
  {
    Object localObject = findDrawerWithGravity(paramInt);
    if (localObject != null)
    {
      closeDrawer((View)localObject, paramBoolean);
      return;
    }
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("No drawer view found with gravity ");
    ((StringBuilder)localObject).append(gravityToString(paramInt));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void closeDrawer(View paramView)
  {
    closeDrawer(paramView, true);
  }
  
  public void closeDrawer(View paramView, boolean paramBoolean)
  {
    if (isDrawerView(paramView))
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (mFirstLayout)
      {
        onScreen = 0.0F;
        knownOpen = 0;
      }
      else if (paramBoolean)
      {
        knownOpen |= 0x4;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
        } else {
          mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 0.0F);
        updateDrawerState(gravity, 0, paramView);
        paramView.setVisibility(4);
      }
      invalidate();
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("View ", paramView, " is not a sliding drawer"));
  }
  
  public void closeDrawers()
  {
    closeDrawers(false);
  }
  
  public void closeDrawers(boolean paramBoolean)
  {
    int m = getChildCount();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      View localView = getChildAt(i);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      k = j;
      if (isDrawerView(localView)) {
        if ((paramBoolean) && (!isPeeking))
        {
          k = j;
        }
        else
        {
          k = localView.getWidth();
          boolean bool;
          if (checkDrawerViewAbsoluteGravity(localView, 3)) {
            bool = mLeftDragger.smoothSlideViewTo(localView, -k, localView.getTop());
          } else {
            bool = mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
          }
          k = j | bool;
          isPeeking = false;
        }
      }
      i += 1;
    }
    mLeftCallback.removeCallbacks();
    mRightCallback.removeCallbacks();
    if (j != 0) {
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, getChildAtgetLayoutParamsonScreen);
      i += 1;
    }
    mScrimOpacity = f;
    boolean bool1 = mLeftDragger.continueSettling(true);
    boolean bool2 = mRightDragger.continueSettling(true);
    if ((bool1) || (bool2)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() != 10) && (mScrimOpacity > 0.0F))
    {
      int i = getChildCount();
      if (i != 0)
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        i -= 1;
        while (i >= 0)
        {
          View localView = getChildAt(i);
          if ((onInterceptTouchEvent(f1, f2, localView)) && (!isContentView(localView)) && (toGlobalMotionEvent(paramMotionEvent, localView))) {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
    return super.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public void dispatchOnDrawerClosed(View paramView)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    if ((knownOpen & 0x1) == 1)
    {
      knownOpen = 0;
      localObject = mListeners;
      if (localObject != null)
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          ((c)mListeners.get(i)).onDrawerClosed(paramView);
          i -= 1;
        }
      }
      updateChildrenImportantForAccessibility(paramView, false);
      if (hasWindowFocus())
      {
        paramView = getRootView();
        if (paramView != null) {
          paramView.sendAccessibilityEvent(32);
        }
      }
    }
  }
  
  public void dispatchOnDrawerOpened(View paramView)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    if ((knownOpen & 0x1) == 0)
    {
      knownOpen = 1;
      localObject = mListeners;
      if (localObject != null)
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          ((c)mListeners.get(i)).onDrawerOpened(paramView);
          i -= 1;
        }
      }
      updateChildrenImportantForAccessibility(paramView, true);
      if (hasWindowFocus()) {
        sendAccessibilityEvent(32);
      }
    }
  }
  
  public void dispatchOnDrawerSlide(View paramView, float paramFloat)
  {
    List localList = mListeners;
    if (localList != null)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((c)mListeners.get(i)).onDrawerSlide(paramView, paramFloat);
        i -= 1;
      }
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i3 = getHeight();
    boolean bool1 = isContentView(paramView);
    int i = getWidth();
    int i2 = paramCanvas.save();
    int k = 0;
    int j = i;
    int m;
    if (bool1)
    {
      int i4 = getChildCount();
      k = 0;
      int n;
      for (j = 0; k < i4; j = n)
      {
        View localView = getChildAt(k);
        m = i;
        n = j;
        if (localView != paramView)
        {
          m = i;
          n = j;
          if (localView.getVisibility() == 0)
          {
            m = i;
            n = j;
            if (hasOpaqueBackground(localView))
            {
              m = i;
              n = j;
              if (isDrawerView(localView)) {
                if (localView.getHeight() < i3)
                {
                  m = i;
                  n = j;
                }
                else
                {
                  int i1;
                  if (checkDrawerViewAbsoluteGravity(localView, 3))
                  {
                    i1 = localView.getRight();
                    m = i;
                    n = j;
                    if (i1 > j)
                    {
                      n = i1;
                      m = i;
                    }
                  }
                  else
                  {
                    i1 = localView.getLeft();
                    m = i;
                    n = j;
                    if (i1 < i)
                    {
                      m = i1;
                      n = j;
                    }
                  }
                }
              }
            }
          }
        }
        k += 1;
        i = m;
      }
      paramCanvas.clipRect(j, 0, i, getHeight());
      k = j;
      j = i;
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i2);
    float f = mScrimOpacity;
    if ((f > 0.0F) && (bool1))
    {
      i = mScrimColor;
      m = (int)(((0xFF000000 & i) >>> 24) * f);
      mScrimPaint.setColor(i & 0xFFFFFF | m << 24);
      paramCanvas.drawRect(k, 0.0F, j, getHeight(), mScrimPaint);
      return bool2;
    }
    if ((mShadowLeftResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 3)))
    {
      i = mShadowLeftResolved.getIntrinsicWidth();
      j = paramView.getRight();
      k = mLeftDragger.getEdgeSize();
      f = Math.max(0.0F, Math.min(j / k, 1.0F));
      mShadowLeftResolved.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
      mShadowLeftResolved.setAlpha((int)(f * 255.0F));
      mShadowLeftResolved.draw(paramCanvas);
      return bool2;
    }
    if ((mShadowRightResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 5)))
    {
      i = mShadowRightResolved.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = mRightDragger.getEdgeSize();
      f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      mShadowRightResolved.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      mShadowRightResolved.setAlpha((int)(f * 255.0F));
      mShadowRightResolved.draw(paramCanvas);
    }
    return bool2;
  }
  
  public View findDrawerWithGravity(int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((getDrawerViewAbsoluteGravity(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public View findOpenDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((getLayoutParamsknownOpen & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public View findVisibleDrawer()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((isDrawerView(localView)) && (isDrawerVisible(localView))) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public float getDrawerElevation()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return mDrawerElevation;
    }
    return 0.0F;
  }
  
  public int getDrawerLockMode(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 8388611)
        {
          if (paramInt == 8388613)
          {
            paramInt = mLockModeEnd;
            if (paramInt != 3) {
              return paramInt;
            }
            if (i == 0) {
              paramInt = mLockModeRight;
            } else {
              paramInt = mLockModeLeft;
            }
            if (paramInt != 3) {
              return paramInt;
            }
          }
        }
        else
        {
          paramInt = mLockModeStart;
          if (paramInt != 3) {
            return paramInt;
          }
          if (i == 0) {
            paramInt = mLockModeLeft;
          } else {
            paramInt = mLockModeRight;
          }
          if (paramInt != 3) {
            return paramInt;
          }
        }
      }
      else
      {
        paramInt = mLockModeRight;
        if (paramInt != 3) {
          return paramInt;
        }
        if (i == 0) {
          paramInt = mLockModeEnd;
        } else {
          paramInt = mLockModeStart;
        }
        if (paramInt != 3) {
          return paramInt;
        }
      }
    }
    else
    {
      paramInt = mLockModeLeft;
      if (paramInt != 3) {
        return paramInt;
      }
      if (i == 0) {
        paramInt = mLockModeStart;
      } else {
        paramInt = mLockModeEnd;
      }
      if (paramInt != 3) {
        return paramInt;
      }
    }
    return 0;
  }
  
  public int getDrawerLockMode(View paramView)
  {
    if (isDrawerView(paramView)) {
      return getDrawerLockMode(getLayoutParamsgravity);
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("View ", paramView, " is not a drawer"));
  }
  
  public CharSequence getDrawerTitle(int paramInt)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      return mTitleLeft;
    }
    if (paramInt == 5) {
      return mTitleRight;
    }
    return null;
  }
  
  public int getDrawerViewAbsoluteGravity(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(getLayoutParamsgravity, ViewCompat.getLayoutDirection(this));
  }
  
  public float getDrawerViewOffset(View paramView)
  {
    return getLayoutParamsonScreen;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return mStatusBarBackground;
  }
  
  public boolean isContentView(View paramView)
  {
    return getLayoutParamsgravity == 0;
  }
  
  public boolean isDrawerOpen(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {
      return isDrawerOpen(localView);
    }
    return false;
  }
  
  public boolean isDrawerOpen(View paramView)
  {
    if (isDrawerView(paramView)) {
      return (getLayoutParamsknownOpen & 0x1) == 1;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("View ", paramView, " is not a drawer"));
  }
  
  public boolean isDrawerView(View paramView)
  {
    int i = GravityCompat.getAbsoluteGravity(getLayoutParamsgravity, ViewCompat.getLayoutDirection(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  public boolean isDrawerVisible(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {
      return isDrawerVisible(localView);
    }
    return false;
  }
  
  public boolean isDrawerVisible(View paramView)
  {
    if (isDrawerView(paramView)) {
      return getLayoutParamsonScreen > 0.0F;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("View ", paramView, " is not a drawer"));
  }
  
  public void moveDrawerToOffset(View paramView, float paramFloat)
  {
    float f1 = getDrawerViewOffset(paramView);
    float f2 = paramView.getWidth();
    int i = (int)(f1 * f2);
    i = (int)(f2 * paramFloat) - i;
    if (!checkDrawerViewAbsoluteGravity(paramView, 3)) {
      i = -i;
    }
    paramView.offsetLeftAndRight(i);
    setDrawerViewOffset(paramView, paramFloat);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mFirstLayout = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    mFirstLayout = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((mDrawStatusBarBackground) && (mStatusBarBackground != null))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        Object localObject = mLastInsets;
        if (localObject != null)
        {
          i = ((WindowInsets)localObject).getSystemWindowInsetTop();
          break label49;
        }
      }
      int i = 0;
      label49:
      if (i > 0)
      {
        mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        mStatusBarBackground.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool1 = mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool2 = mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label95;
          }
        }
        else
        {
          if (!mLeftDragger.checkTouchSlop(3)) {
            break label95;
          }
          mLeftCallback.removeCallbacks();
          mRightCallback.removeCallbacks();
          break label95;
        }
      }
      closeDrawers(true);
      mDisallowInterceptRequested = false;
      mChildrenCanceledTouch = false;
      label95:
      i = 0;
    }
    else
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      mInitialMotionX = f1;
      mInitialMotionY = f2;
      if (mScrimOpacity > 0.0F)
      {
        paramMotionEvent = mLeftDragger.findTopChildUnder((int)f1, (int)f2);
        if ((paramMotionEvent != null) && (isContentView(paramMotionEvent)))
        {
          i = 1;
          break label163;
        }
      }
      i = 0;
      label163:
      mDisallowInterceptRequested = false;
      mChildrenCanceledTouch = false;
    }
    if ((!(bool1 | bool2)) && (i == 0) && (!hasPeekingDrawer())) {
      return mChildrenCanceledTouch;
    }
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (hasVisibleDrawer()))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = findVisibleDrawer();
      if ((paramKeyEvent != null) && (getDrawerLockMode(paramKeyEvent) == 0)) {
        closeDrawers();
      }
      return paramKeyEvent != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mInLayout = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i;
        int j;
        int k;
        if (isContentView(localView))
        {
          paramInt1 = leftMargin;
          i = topMargin;
          j = localView.getMeasuredWidth();
          k = topMargin;
          localView.layout(paramInt1, i, j + paramInt1, localView.getMeasuredHeight() + k);
        }
        else
        {
          int i1 = localView.getMeasuredWidth();
          int i2 = localView.getMeasuredHeight();
          float f;
          if (checkDrawerViewAbsoluteGravity(localView, 3))
          {
            paramInt1 = -i1;
            f = i1;
            i = paramInt1 + (int)(onScreen * f);
            f = (i1 + i) / f;
          }
          else
          {
            f = i1;
            i = m - (int)(onScreen * f);
            f = (m - i) / f;
          }
          if (f != onScreen) {
            j = 1;
          } else {
            j = 0;
          }
          paramInt1 = gravity & 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 80)
            {
              paramInt1 = topMargin;
              localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
            }
            else
            {
              paramInt1 = paramInt4 - paramInt2;
              localView.layout(i, paramInt1 - bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - bottomMargin);
            }
          }
          else
          {
            int i3 = paramInt4 - paramInt2;
            k = (i3 - i2) / 2;
            paramInt1 = topMargin;
            if (k >= paramInt1)
            {
              int i4 = bottomMargin;
              paramInt1 = k;
              if (k + i2 > i3 - i4) {
                paramInt1 = i3 - i4 - i2;
              }
            }
            localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
          }
          if (j != 0) {
            setDrawerViewOffset(localView, f);
          }
          if (onScreen > 0.0F) {
            paramInt1 = 0;
          } else {
            paramInt1 = 4;
          }
          if (localView.getVisibility() != paramInt1) {
            localView.setVisibility(paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    mInLayout = false;
    mFirstLayout = false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int k;
    int m;
    if (i1 == 1073741824)
    {
      k = i;
      m = j;
      if (n == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label808;
      }
      if ((i1 != Integer.MIN_VALUE) && (i1 == 0)) {
        i = 300;
      }
      if (n == Integer.MIN_VALUE)
      {
        k = i;
        m = j;
      }
      else
      {
        k = i;
        m = j;
        if (n == 0)
        {
          m = 300;
          k = i;
        }
      }
    }
    setMeasuredDimension(k, m);
    if ((mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this))) {
      n = 1;
    } else {
      n = 0;
    }
    int i3 = ViewCompat.getLayoutDirection(this);
    int i4 = getChildCount();
    i1 = 0;
    j = 0;
    i = 0;
    View localView;
    for (;;)
    {
      if (i1 >= i4) {
        return;
      }
      localView = getChildAt(i1);
      LayoutParams localLayoutParams;
      int i2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (n != 0)
        {
          i2 = GravityCompat.getAbsoluteGravity(gravity, i3);
          WindowInsets localWindowInsets;
          if (ViewCompat.getFitsSystemWindows(localView))
          {
            if (Build.VERSION.SDK_INT >= 21)
            {
              localWindowInsets = (WindowInsets)mLastInsets;
              if (i2 == 3)
              {
                localObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
              }
              else
              {
                localObject = localWindowInsets;
                if (i2 == 5) {
                  localObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
                }
              }
              localView.dispatchApplyWindowInsets((WindowInsets)localObject);
            }
          }
          else if (Build.VERSION.SDK_INT >= 21)
          {
            localWindowInsets = (WindowInsets)mLastInsets;
            if (i2 == 3)
            {
              localObject = localWindowInsets.replaceSystemWindowInsets(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), 0, localWindowInsets.getSystemWindowInsetBottom());
            }
            else
            {
              localObject = localWindowInsets;
              if (i2 == 5) {
                localObject = localWindowInsets.replaceSystemWindowInsets(0, localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
              }
            }
            leftMargin = ((WindowInsets)localObject).getSystemWindowInsetLeft();
            topMargin = ((WindowInsets)localObject).getSystemWindowInsetTop();
            rightMargin = ((WindowInsets)localObject).getSystemWindowInsetRight();
            bottomMargin = ((WindowInsets)localObject).getSystemWindowInsetBottom();
          }
        }
        if (isContentView(localView)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(k - leftMargin - rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(m - topMargin - bottomMargin, 1073741824));
        }
      }
      else
      {
        break label725;
      }
      if (!isDrawerView(localView)) {
        break;
      }
      if (SET_DRAWER_SHADOW_FROM_ELEVATION)
      {
        float f1 = ViewCompat.getElevation(localView);
        float f2 = mDrawerElevation;
        if (f1 != f2) {
          ViewCompat.setElevation(localView, f2);
        }
      }
      int i5 = getDrawerViewAbsoluteGravity(localView) & 0x7;
      if (i5 == 3) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (((i2 != 0) && (j != 0)) || ((i2 == 0) && (i != 0)))
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Child drawer has absolute gravity ");
        ((StringBuilder)localObject).append(gravityToString(i5));
        ((StringBuilder)localObject).append(" but this ");
        ((StringBuilder)localObject).append("DrawerLayout");
        ((StringBuilder)localObject).append(" already has a ");
        ((StringBuilder)localObject).append("drawer view along that edge");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      if (i2 != 0) {
        j = 1;
      } else {
        i = 1;
      }
      localView.measure(ViewGroup.getChildMeasureSpec(paramInt1, mMinDrawerMargin + leftMargin + rightMargin, width), ViewGroup.getChildMeasureSpec(paramInt2, topMargin + bottomMargin, height));
      label725:
      i1 += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Child ");
    ((StringBuilder)localObject).append(localView);
    ((StringBuilder)localObject).append(" at index ");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(" does not have a valid layout_gravity - must be Gravity.LEFT, ");
    ((StringBuilder)localObject).append("Gravity.RIGHT or Gravity.NO_GRAVITY");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
    label808:
    localObject = new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    throw ((Throwable)localObject);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    int i = openDrawerGravity;
    if (i != 0)
    {
      View localView = findDrawerWithGravity(i);
      if (localView != null) {
        openDrawer(localView);
      }
    }
    i = lockModeLeft;
    if (i != 3) {
      setDrawerLockMode(i, 3);
    }
    i = lockModeRight;
    if (i != 3) {
      setDrawerLockMode(i, 5);
    }
    i = lockModeStart;
    if (i != 3) {
      setDrawerLockMode(i, 8388611);
    }
    i = lockModeEnd;
    if (i != 3) {
      setDrawerLockMode(i, 8388613);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    resolveShadowDrawables();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int m = getChildCount();
    int i = 0;
    while (i < m)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      int j = knownOpen;
      int k = 1;
      if (j == 1) {
        j = 1;
      } else {
        j = 0;
      }
      if (knownOpen != 2) {
        k = 0;
      }
      if ((j == 0) && (k == 0)) {
        i += 1;
      } else {
        openDrawerGravity = gravity;
      }
    }
    lockModeLeft = mLockModeLeft;
    lockModeRight = mLockModeRight;
    lockModeStart = mLockModeStart;
    lockModeEnd = mLockModeEnd;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    mLeftDragger.processTouchEvent(paramMotionEvent);
    mRightDragger.processTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
        closeDrawers(true);
        mDisallowInterceptRequested = false;
        mChildrenCanceledTouch = false;
        return true;
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = mLeftDragger.findTopChildUnder((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (isContentView(paramMotionEvent)))
      {
        f2 -= mInitialMotionX;
        f1 -= mInitialMotionY;
        i = mLeftDragger.getTouchSlop();
        if (f1 * f1 + f2 * f2 < i * i)
        {
          paramMotionEvent = findOpenDrawer();
          if ((paramMotionEvent != null) && (getDrawerLockMode(paramMotionEvent) != 2))
          {
            bool = false;
            break label166;
          }
        }
      }
      boolean bool = true;
      label166:
      closeDrawers(bool);
      mDisallowInterceptRequested = false;
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    mInitialMotionX = f1;
    mInitialMotionY = f2;
    mDisallowInterceptRequested = false;
    mChildrenCanceledTouch = false;
    return true;
  }
  
  public void openDrawer(int paramInt)
  {
    openDrawer(paramInt, true);
  }
  
  public void openDrawer(int paramInt, boolean paramBoolean)
  {
    Object localObject = findDrawerWithGravity(paramInt);
    if (localObject != null)
    {
      openDrawer((View)localObject, paramBoolean);
      return;
    }
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("No drawer view found with gravity ");
    ((StringBuilder)localObject).append(gravityToString(paramInt));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void openDrawer(View paramView)
  {
    openDrawer(paramView, true);
  }
  
  public void openDrawer(View paramView, boolean paramBoolean)
  {
    if (isDrawerView(paramView))
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (mFirstLayout)
      {
        onScreen = 1.0F;
        knownOpen = 1;
        updateChildrenImportantForAccessibility(paramView, true);
      }
      else if (paramBoolean)
      {
        knownOpen |= 0x2;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
        } else {
          mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 1.0F);
        updateDrawerState(gravity, 0, paramView);
        paramView.setVisibility(0);
      }
      invalidate();
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("View ", paramView, " is not a sliding drawer"));
  }
  
  public void removeDrawerListener(c paramC)
  {
    if (paramC == null) {
      return;
    }
    List localList = mListeners;
    if (localList == null) {
      return;
    }
    localList.remove(paramC);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    mDisallowInterceptRequested = paramBoolean;
    if (paramBoolean) {
      closeDrawers(true);
    }
  }
  
  public void requestLayout()
  {
    if (!mInLayout) {
      super.requestLayout();
    }
  }
  
  public void setChildInsets(Object paramObject, boolean paramBoolean)
  {
    mLastInsets = paramObject;
    mDrawStatusBarBackground = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    setWillNotDraw(paramBoolean);
    requestLayout();
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    mDrawerElevation = paramFloat;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (isDrawerView(localView)) {
        ViewCompat.setElevation(localView, mDrawerElevation);
      }
      i += 1;
    }
  }
  
  public void setDrawerListener(c paramC)
  {
    c localC = mListener;
    if (localC != null) {
      removeDrawerListener(localC);
    }
    if (paramC != null) {
      addDrawerListener(paramC);
    }
    mListener = paramC;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    if (paramInt2 != 3)
    {
      if (paramInt2 != 5)
      {
        if (paramInt2 != 8388611)
        {
          if (paramInt2 == 8388613) {
            mLockModeEnd = paramInt1;
          }
        }
        else {
          mLockModeStart = paramInt1;
        }
      }
      else {
        mLockModeRight = paramInt1;
      }
    }
    else {
      mLockModeLeft = paramInt1;
    }
    Object localObject;
    if (paramInt1 != 0)
    {
      if (i == 3) {
        localObject = mLeftDragger;
      } else {
        localObject = mRightDragger;
      }
      ((ViewDragHelper)localObject).cancel();
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return;
      }
      localObject = findDrawerWithGravity(i);
      if (localObject != null) {
        openDrawer((View)localObject);
      }
    }
    else
    {
      localObject = findDrawerWithGravity(i);
      if (localObject != null) {
        closeDrawer((View)localObject);
      }
    }
  }
  
  public void setDrawerLockMode(int paramInt, View paramView)
  {
    if (isDrawerView(paramView))
    {
      setDrawerLockMode(paramInt, getLayoutParamsgravity);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a ");
    localStringBuilder.append("drawer with appropriate layout_gravity");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDrawerShadow(int paramInt1, int paramInt2)
  {
    setDrawerShadow(ContextCompat.getDrawable(getContext(), paramInt1), paramInt2);
  }
  
  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    if ((paramInt & 0x800003) == 8388611)
    {
      mShadowStart = paramDrawable;
    }
    else if ((paramInt & 0x800005) == 8388613)
    {
      mShadowEnd = paramDrawable;
    }
    else if ((paramInt & 0x3) == 3)
    {
      mShadowLeft = paramDrawable;
    }
    else
    {
      if ((paramInt & 0x5) != 5) {
        return;
      }
      mShadowRight = paramDrawable;
    }
    resolveShadowDrawables();
    invalidate();
  }
  
  public void setDrawerTitle(int paramInt, CharSequence paramCharSequence)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3)
    {
      mTitleLeft = paramCharSequence;
      return;
    }
    if (paramInt == 5) {
      mTitleRight = paramCharSequence;
    }
  }
  
  public void setDrawerViewOffset(View paramView, float paramFloat)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == onScreen) {
      return;
    }
    onScreen = paramFloat;
    dispatchOnDrawerSlide(paramView, paramFloat);
  }
  
  public void setScrimColor(int paramInt)
  {
    mScrimColor = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    mStatusBarBackground = localDrawable;
    invalidate();
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    mStatusBarBackground = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    mStatusBarBackground = new ColorDrawable(paramInt);
    invalidate();
  }
  
  public void updateDrawerState(int paramInt1, int paramInt2, View paramView)
  {
    int j = mLeftDragger.getViewDragState();
    int k = mRightDragger.getViewDragState();
    int i = 2;
    if ((j != 1) && (k != 1))
    {
      paramInt1 = i;
      if (j != 2) {
        if (k == 2) {
          paramInt1 = i;
        } else {
          paramInt1 = 0;
        }
      }
    }
    else
    {
      paramInt1 = 1;
    }
    if ((paramView != null) && (paramInt2 == 0))
    {
      float f = getLayoutParamsonScreen;
      if (f == 0.0F) {
        dispatchOnDrawerClosed(paramView);
      } else if (f == 1.0F) {
        dispatchOnDrawerOpened(paramView);
      }
    }
    if (paramInt1 != mDrawerState)
    {
      mDrawerState = paramInt1;
      paramView = mListeners;
      if (paramView != null)
      {
        paramInt2 = paramView.size() - 1;
        while (paramInt2 >= 0)
        {
          ((c)mListeners.get(paramInt2)).onDrawerStateChanged(paramInt1);
          paramInt2 -= 1;
        }
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final int FLAG_IS_CLOSING = 4;
    public static final int FLAG_IS_OPENED = 1;
    public static final int FLAG_IS_OPENING = 2;
    public int gravity = 0;
    public boolean isPeeking;
    public int knownOpen;
    public float onScreen;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      gravity = paramInt3;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
      gravity = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      gravity = gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new VerticalProgressBar.SavedState.1();
    public int lockModeEnd;
    public int lockModeLeft;
    public int lockModeRight;
    public int lockModeStart;
    public int openDrawerGravity = 0;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      openDrawerGravity = paramParcel.readInt();
      lockModeLeft = paramParcel.readInt();
      lockModeRight = paramParcel.readInt();
      lockModeStart = paramParcel.readInt();
      lockModeEnd = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(mSuperState, paramInt);
      paramParcel.writeInt(openDrawerGravity);
      paramParcel.writeInt(lockModeLeft);
      paramParcel.writeInt(lockModeRight);
      paramParcel.writeInt(lockModeStart);
      paramParcel.writeInt(lockModeEnd);
    }
  }
  
  public class a
    extends AccessibilityDelegateCompat
  {
    public final Rect mTmpRect = new Rect();
    
    public a() {}
    
    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, ViewGroup paramViewGroup)
    {
      int j = paramViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if (DrawerLayout.filter(localView)) {
          paramAccessibilityNodeInfoCompat.addChild(localView);
        }
        i += 1;
      }
    }
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
      paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramView = paramAccessibilityEvent.getText();
        paramAccessibilityEvent = findVisibleDrawer();
        if (paramAccessibilityEvent != null)
        {
          int i = getDrawerViewAbsoluteGravity(paramAccessibilityEvent);
          paramAccessibilityEvent = getDrawerTitle(i);
          if (paramAccessibilityEvent != null) {
            paramView.add(paramAccessibilityEvent);
          }
        }
        return true;
      }
      return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AccessibilityDelegateCompat.DEFAULT_DELEGATE.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if (DrawerLayout.CAN_HIDE_DESCENDANTS)
      {
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      }
      else
      {
        AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
        paramAccessibilityNodeInfoCompat.setSource(paramView);
        ViewParent localViewParent = ViewCompat.getParentForAccessibility(paramView);
        if ((localViewParent instanceof View)) {
          paramAccessibilityNodeInfoCompat.setParent((View)localViewParent);
        }
        copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
        localAccessibilityNodeInfoCompat.setClassName();
        addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup)paramView);
      }
      paramAccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
      paramAccessibilityNodeInfoCompat.setFocusable(false);
      paramAccessibilityNodeInfoCompat.setFocused(false);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
      paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((!DrawerLayout.CAN_HIDE_DESCENDANTS) && (!DrawerLayout.filter(paramView))) {
        return false;
      }
      return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
  }
  
  public static final class b
    extends AccessibilityDelegateCompat
  {
    public b() {}
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      if (!DrawerLayout.filter(paramView)) {
        paramAccessibilityNodeInfoCompat.setParent(null);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void onDrawerClosed(View paramView);
    
    public abstract void onDrawerOpened(View paramView);
    
    public abstract void onDrawerSlide(View paramView, float paramFloat);
    
    public abstract void onDrawerStateChanged(int paramInt);
  }
  
  public static abstract class d
    implements DrawerLayout.c
  {
    public d() {}
    
    public void onDrawerClosed(View paramView) {}
    
    public void onDrawerOpened(View paramView) {}
    
    public void onDrawerSlide(View paramView, float paramFloat) {}
    
    public void onDrawerStateChanged(int paramInt) {}
  }
  
  private class e
    extends ViewDragHelper.Callback
  {
    public final int mAbsGravity;
    public ViewDragHelper mDragger;
    public final Runnable mPeekRunnable = new SplashScreen.5.1(this);
    
    public e(int paramInt)
    {
      mAbsGravity = paramInt;
    }
    
    private void closeOtherDrawer()
    {
      int j = mAbsGravity;
      int i = 3;
      if (j == 3) {
        i = 5;
      }
      View localView = findDrawerWithGravity(i);
      if (localView != null) {
        closeDrawer(localView);
      }
    }
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
      }
      paramInt2 = getWidth();
      return Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2));
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      if (isDrawerView(paramView)) {
        return paramView.getWidth();
      }
      return 0;
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      View localView;
      if ((paramInt1 & 0x1) == 1) {
        localView = findDrawerWithGravity(3);
      } else {
        localView = findDrawerWithGravity(5);
      }
      if ((localView != null) && (getDrawerLockMode(localView) == 0)) {
        mDragger.captureChildView(localView, paramInt2);
      }
    }
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2)
    {
      postDelayed(mPeekRunnable, 160L);
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      getLayoutParamsisPeeking = false;
      closeOtherDrawer();
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      updateDrawerState(mAbsGravity, paramInt, mDragger.getCapturedView());
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
        f = paramInt1 + paramInt2;
      } else {
        f = getWidth() - paramInt1;
      }
      f /= paramInt2;
      setDrawerViewOffset(paramView, f);
      if (f == 0.0F) {
        paramInt1 = 4;
      } else {
        paramInt1 = 0;
      }
      paramView.setVisibility(paramInt1);
      invalidate();
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = getDrawerViewOffset(paramView);
      int m = paramView.getWidth();
      int i;
      if (checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        if ((paramFloat1 <= 0.0F) && ((paramFloat1 != 0.0F) || (paramFloat2 <= 0.5F))) {
          i = -m;
        } else {
          i = 0;
        }
      }
      else
      {
        int k = getWidth();
        int j = k;
        if (paramFloat1 >= 0.0F)
        {
          i = j;
          if (paramFloat1 == 0.0F)
          {
            i = j;
            if (paramFloat2 <= 0.5F) {}
          }
        }
        else
        {
          i = k - m;
        }
      }
      mDragger.settleCapturedViewAt(i, paramView.getTop());
      invalidate();
    }
    
    public void peekDrawer()
    {
      int k = mDragger.getEdgeSize();
      int i = mAbsGravity;
      int j = 0;
      if (i == 3) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject2;
      Object localObject1;
      if (i != 0)
      {
        localObject2 = findDrawerWithGravity(3);
        localObject1 = localObject2;
        if (localObject2 != null) {
          j = -((View)localObject2).getWidth();
        }
        j += k;
      }
      else
      {
        localObject1 = findDrawerWithGravity(5);
        j = getWidth() - k;
      }
      if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (getDrawerLockMode((View)localObject1) == 0))))
      {
        localObject2 = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
        mDragger.smoothSlideViewTo((View)localObject1, j, ((View)localObject1).getTop());
        isPeeking = true;
        invalidate();
        closeOtherDrawer();
        cancelChildViewTouch();
      }
    }
    
    public void removeCallbacks()
    {
      removeCallbacks(mPeekRunnable);
    }
    
    public void setDragger(ViewDragHelper paramViewDragHelper)
    {
      mDragger = paramViewDragHelper;
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      return (isDrawerView(paramView)) && (checkDrawerViewAbsoluteGravity(paramView, mAbsGravity)) && (getDrawerLockMode(paramView) == 0);
    }
  }
}
