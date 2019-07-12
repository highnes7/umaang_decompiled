package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R.dimen;
import android.support.design.R.styleable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.b.a.N;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import support.android.v4.graphics.MathUtils;
import support.android.v4.view.ViewCompat;
import support.android.v4.widget.ViewDragHelper;
import support.android.v4.widget.ViewDragHelper.Callback;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  public static final float HIDE_FRICTION = 0.1F;
  public static final float HIDE_THRESHOLD = 0.5F;
  public static final int PEEK_HEIGHT_AUTO = -1;
  public static final int STATE_COLLAPSED = 4;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_EXPANDED = 3;
  public static final int STATE_HALF_EXPANDED = 6;
  public static final int STATE_HIDDEN = 5;
  public static final int STATE_SETTLING = 2;
  public int activePointerId;
  public BottomSheetCallback callback;
  public int collapsedOffset;
  public final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback()
  {
    public int clampViewPositionHorizontal(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getLeft();
    }
    
    public int clampViewPositionVertical(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      int i = BottomSheetBehavior.access$100(BottomSheetBehavior.this);
      paramAnonymousView = BottomSheetBehavior.this;
      if (hideable) {
        paramAnonymousInt2 = parentHeight;
      } else {
        paramAnonymousInt2 = collapsedOffset;
      }
      return MathUtils.constrain(paramAnonymousInt1, i, paramAnonymousInt2);
    }
    
    public int getViewVerticalDragRange(View paramAnonymousView)
    {
      paramAnonymousView = BottomSheetBehavior.this;
      if (hideable) {
        return parentHeight;
      }
      return collapsedOffset;
    }
    
    public void onViewDragStateChanged(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 1) {
        setStateInternal(1);
      }
    }
    
    public void onViewPositionChanged(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      dispatchOnSlide(paramAnonymousInt2);
    }
    
    public void onViewReleased(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int j = 4;
      BottomSheetBehavior localBottomSheetBehavior;
      if (paramAnonymousFloat2 < 0.0F)
      {
        localBottomSheetBehavior = BottomSheetBehavior.this;
        if (fitToContents) {
          i = fitToContentsOffset;
        }
      }
      for (;;)
      {
        j = 3;
        break label333;
        j = paramAnonymousView.getTop();
        i = halfExpandedOffset;
        if (j > i)
        {
          j = 6;
          break label333;
        }
        label65:
        i = 0;
        continue;
        localBottomSheetBehavior = BottomSheetBehavior.this;
        if ((hideable) && (localBottomSheetBehavior.shouldHide(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > collapsedOffset) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
        {
          i = parentHeight;
          j = 5;
          break label333;
        }
        if ((paramAnonymousFloat2 != 0.0F) && (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)))
        {
          i = collapsedOffset;
          break label333;
        }
        i = paramAnonymousView.getTop();
        localBottomSheetBehavior = BottomSheetBehavior.this;
        if (!fitToContents) {
          break label240;
        }
        if (Math.abs(i - fitToContentsOffset) >= Math.abs(i - collapsedOffset)) {
          break;
        }
        i = fitToContentsOffset;
      }
      for (int i = collapsedOffset;; i = collapsedOffset)
      {
        break label333;
        label240:
        int k = halfExpandedOffset;
        if (i < k)
        {
          if (i < Math.abs(i - collapsedOffset)) {
            break label65;
          }
          i = halfExpandedOffset;
          break label318;
        }
        if (Math.abs(i - k) < Math.abs(i - collapsedOffset))
        {
          i = halfExpandedOffset;
          label318:
          break;
        }
      }
      label333:
      if (viewDragHelper.settleCapturedViewAt(paramAnonymousView.getLeft(), i))
      {
        setStateInternal(2);
        ViewCompat.postOnAnimation(paramAnonymousView, new BottomSheetBehavior.SettleRunnable(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
      }
      setStateInternal(j);
    }
    
    public boolean tryCaptureView(View paramAnonymousView, int paramAnonymousInt)
    {
      Object localObject = BottomSheetBehavior.this;
      int i = state;
      if (i == 1) {
        return false;
      }
      if (touchingScrollingChild) {
        return false;
      }
      if ((i == 3) && (activePointerId == paramAnonymousInt))
      {
        localObject = (View)nestedScrollingChildRef.get();
        if ((localObject != null) && (((View)localObject).canScrollVertically(-1))) {
          return false;
        }
      }
      localObject = viewRef;
      return (localObject != null) && (((WeakReference)localObject).get() == paramAnonymousView);
    }
  };
  public boolean fitToContents = true;
  public int fitToContentsOffset;
  public int halfExpandedOffset;
  public boolean hideable;
  public boolean ignoreEvents;
  public Map<View, Integer> importantForAccessibilityMap;
  public int initialY;
  public int lastNestedScrollDy;
  public int lastPeekHeight;
  public float maximumVelocity;
  public boolean nestedScrolled;
  public WeakReference<View> nestedScrollingChildRef;
  public int parentHeight;
  public int peekHeight;
  public boolean peekHeightAuto;
  public int peekHeightMin;
  public boolean skipCollapsed;
  public int state = 4;
  public boolean touchingScrollingChild;
  public VelocityTracker velocityTracker;
  public ViewDragHelper viewDragHelper;
  public WeakReference<V> viewRef;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
    if (localTypedValue != null)
    {
      int i = data;
      if (i == -1)
      {
        setPeekHeight(i);
        break label82;
      }
    }
    setPeekHeight(paramAttributeSet.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    label82:
    setHideable(paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
    setFitToContents(paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
    setSkipCollapsed(paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
    paramAttributeSet.recycle();
    maximumVelocity = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private void calculateCollapsedOffset()
  {
    if (fitToContents)
    {
      collapsedOffset = Math.max(parentHeight - lastPeekHeight, fitToContentsOffset);
      return;
    }
    collapsedOffset = (parentHeight - lastPeekHeight);
  }
  
  public static BottomSheetBehavior from(View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof CoordinatorLayout.LayoutParams))
    {
      paramView = ((CoordinatorLayout.LayoutParams)paramView).getBehavior();
      if ((paramView instanceof BottomSheetBehavior)) {
        return (BottomSheetBehavior)paramView;
      }
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  private int getExpandedOffset()
  {
    if (fitToContents) {
      return fitToContentsOffset;
    }
    return 0;
  }
  
  private float getYVelocity()
  {
    VelocityTracker localVelocityTracker = velocityTracker;
    if (localVelocityTracker == null) {
      return 0.0F;
    }
    localVelocityTracker.computeCurrentVelocity(1000, maximumVelocity);
    return velocityTracker.getYVelocity(activePointerId);
  }
  
  private void reset()
  {
    activePointerId = -1;
    VelocityTracker localVelocityTracker = velocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      velocityTracker = null;
    }
  }
  
  private void updateImportantForAccessibility(boolean paramBoolean)
  {
    Object localObject = viewRef;
    if (localObject == null) {
      return;
    }
    localObject = ((View)((WeakReference)localObject).get()).getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int j = ((ViewGroup)localObject).getChildCount();
    int i = Build.VERSION.SDK_INT;
    if (paramBoolean) {
      if (importantForAccessibilityMap == null) {
        importantForAccessibilityMap = new HashMap(j);
      } else {
        return;
      }
    }
    i = 0;
    while (i < j)
    {
      View localView = ((ViewGroup)localObject).getChildAt(i);
      if (localView != viewRef.get()) {
        if (!paramBoolean)
        {
          Map localMap = importantForAccessibilityMap;
          if ((localMap != null) && (localMap.containsKey(localView))) {
            ViewCompat.setImportantForAccessibility(localView, ((Integer)importantForAccessibilityMap.get(localView)).intValue());
          }
        }
        else
        {
          int k = Build.VERSION.SDK_INT;
          importantForAccessibilityMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          ViewCompat.setImportantForAccessibility(localView, 4);
        }
      }
      i += 1;
    }
    if (!paramBoolean) {
      importantForAccessibilityMap = null;
    }
  }
  
  public void dispatchOnSlide(int paramInt)
  {
    View localView = (View)viewRef.get();
    if (localView != null)
    {
      BottomSheetCallback localBottomSheetCallback = callback;
      if (localBottomSheetCallback != null)
      {
        int i = collapsedOffset;
        if (paramInt > i)
        {
          localBottomSheetCallback.onSlide(localView, (i - paramInt) / (parentHeight - i));
          return;
        }
        localBottomSheetCallback.onSlide(localView, (i - paramInt) / (i - getExpandedOffset()));
      }
    }
  }
  
  public View findScrollingChild(View paramView)
  {
    if (ViewCompat.isNestedScrollingEnabled(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      int j = paramView.getChildCount();
      while (i < j)
      {
        View localView = findScrollingChild(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public final int getPeekHeight()
  {
    if (peekHeightAuto) {
      return -1;
    }
    return peekHeight;
  }
  
  public int getPeekHeightMin()
  {
    return peekHeightMin;
  }
  
  public boolean getSkipCollapsed()
  {
    return skipCollapsed;
  }
  
  public final int getState()
  {
    return state;
  }
  
  public boolean isFitToContents()
  {
    return fitToContents;
  }
  
  public boolean isHideable()
  {
    return hideable;
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.isShown())
    {
      ignoreEvents = true;
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      reset();
    }
    if (velocityTracker == null) {
      velocityTracker = VelocityTracker.obtain();
    }
    velocityTracker.addMovement(paramMotionEvent);
    Object localObject2 = null;
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        touchingScrollingChild = false;
        activePointerId = -1;
        if (ignoreEvents)
        {
          ignoreEvents = false;
          return false;
        }
      }
    }
    else
    {
      int j = (int)paramMotionEvent.getX();
      initialY = ((int)paramMotionEvent.getY());
      localObject1 = nestedScrollingChildRef;
      if (localObject1 != null) {
        localObject1 = (View)((WeakReference)localObject1).get();
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (paramCoordinatorLayout.isPointInChildBounds((View)localObject1, j, initialY)))
      {
        activePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        touchingScrollingChild = true;
      }
      boolean bool;
      if ((activePointerId == -1) && (!paramCoordinatorLayout.isPointInChildBounds(paramView, j, initialY))) {
        bool = true;
      } else {
        bool = false;
      }
      ignoreEvents = bool;
    }
    if (!ignoreEvents)
    {
      paramView = viewDragHelper;
      if ((paramView != null) && (paramView.shouldInterceptTouchEvent(paramMotionEvent))) {
        return true;
      }
    }
    Object localObject1 = nestedScrollingChildRef;
    paramView = localObject2;
    if (localObject1 != null) {
      paramView = (View)((WeakReference)localObject1).get();
    }
    return (i == 2) && (paramView != null) && (!ignoreEvents) && (state != 1) && (!paramCoordinatorLayout.isPointInChildBounds(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (viewDragHelper != null) && (Math.abs(initialY - paramMotionEvent.getY()) > viewDragHelper.getTouchSlop());
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    if ((ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramView))) {
      paramView.setFitsSystemWindows(true);
    }
    int i = paramView.getTop();
    paramCoordinatorLayout.onLayoutChild(paramView, paramInt);
    parentHeight = paramCoordinatorLayout.getHeight();
    if (peekHeightAuto)
    {
      if (peekHeightMin == 0) {
        peekHeightMin = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
      }
      lastPeekHeight = Math.max(peekHeightMin, parentHeight - paramCoordinatorLayout.getWidth() * 9 / 16);
    }
    else
    {
      lastPeekHeight = peekHeight;
    }
    fitToContentsOffset = Math.max(0, parentHeight - paramView.getHeight());
    halfExpandedOffset = (parentHeight / 2);
    calculateCollapsedOffset();
    paramInt = state;
    if (paramInt == 3)
    {
      ViewCompat.offsetTopAndBottom(paramView, getExpandedOffset());
    }
    else if (paramInt == 6)
    {
      ViewCompat.offsetTopAndBottom(paramView, halfExpandedOffset);
    }
    else if ((hideable) && (paramInt == 5))
    {
      ViewCompat.offsetTopAndBottom(paramView, parentHeight);
    }
    else
    {
      paramInt = state;
      if (paramInt == 4) {
        ViewCompat.offsetTopAndBottom(paramView, collapsedOffset);
      } else if ((paramInt == 1) || (paramInt == 2)) {
        ViewCompat.offsetTopAndBottom(paramView, i - paramView.getTop());
      }
    }
    if (viewDragHelper == null) {
      viewDragHelper = ViewDragHelper.create(paramCoordinatorLayout, dragCallback);
    }
    viewRef = new WeakReference(paramView);
    nestedScrollingChildRef = new WeakReference(findScrollingChild(paramView));
    return true;
  }
  
  public boolean onNestedPreFling(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2)
  {
    return (paramView2 == nestedScrollingChildRef.get()) && (state != 3);
  }
  
  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {
      return;
    }
    if (paramView2 != (View)nestedScrollingChildRef.get()) {
      return;
    }
    paramInt1 = paramView1.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0)
    {
      if (paramInt3 < getExpandedOffset())
      {
        paramArrayOfInt[1] = (paramInt1 - getExpandedOffset());
        ViewCompat.offsetTopAndBottom(paramView1, -paramArrayOfInt[1]);
        setStateInternal(3);
      }
      else
      {
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramView1, -paramInt2);
        setStateInternal(1);
      }
    }
    else if ((paramInt2 < 0) && (!paramView2.canScrollVertically(-1)))
    {
      int i = collapsedOffset;
      if ((paramInt3 > i) && (!hideable))
      {
        paramArrayOfInt[1] = (paramInt1 - i);
        ViewCompat.offsetTopAndBottom(paramView1, -paramArrayOfInt[1]);
        setStateInternal(4);
      }
      else
      {
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramView1, -paramInt2);
        setStateInternal(1);
      }
    }
    dispatchOnSlide(paramView1.getTop());
    lastNestedScrollDy = paramInt2;
    nestedScrolled = true;
  }
  
  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, View paramView, Parcelable paramParcelable)
  {
    paramCoordinatorLayout = (SavedState)paramParcelable;
    paramCoordinatorLayout.getSuperState();
    int i = state;
    if ((i != 1) && (i != 2))
    {
      state = i;
      return;
    }
    state = 4;
  }
  
  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    return new SavedState(android.view.AbsSavedState.EMPTY_STATE, state);
  }
  
  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    lastNestedScrollDy = 0;
    nestedScrolled = false;
    return (paramInt1 & 0x2) != 0;
  }
  
  public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt)
  {
    paramInt = paramView1.getTop();
    int j = getExpandedOffset();
    int i = 3;
    if (paramInt == j)
    {
      setStateInternal(3);
      return;
    }
    if (paramView2 == nestedScrollingChildRef.get())
    {
      if (!nestedScrolled) {
        return;
      }
      if (lastNestedScrollDy > 0)
      {
        paramInt = getExpandedOffset();
      }
      else if ((hideable) && (shouldHide(paramView1, getYVelocity())))
      {
        paramInt = parentHeight;
        i = 5;
      }
      else
      {
        if (lastNestedScrollDy == 0)
        {
          paramInt = paramView1.getTop();
          if (fitToContents)
          {
            if (Math.abs(paramInt - fitToContentsOffset) < Math.abs(paramInt - collapsedOffset))
            {
              paramInt = fitToContentsOffset;
              break label250;
            }
            paramInt = collapsedOffset;
          }
          else
          {
            j = halfExpandedOffset;
            if (paramInt < j)
            {
              if (paramInt < Math.abs(paramInt - collapsedOffset))
              {
                paramInt = 0;
                break label250;
              }
              paramInt = halfExpandedOffset;
            }
            else
            {
              if (Math.abs(paramInt - j) >= Math.abs(paramInt - collapsedOffset)) {
                break label232;
              }
              paramInt = halfExpandedOffset;
            }
            i = 6;
            break label250;
            label232:
            paramInt = collapsedOffset;
          }
        }
        else
        {
          paramInt = collapsedOffset;
        }
        i = 4;
      }
      label250:
      if (viewDragHelper.smoothSlideViewTo(paramView1, paramView1.getLeft(), paramInt))
      {
        setStateInternal(2);
        ViewCompat.postOnAnimation(paramView1, new SettleRunnable(paramView1, i));
      }
      else
      {
        setStateInternal(i);
      }
      nestedScrolled = false;
    }
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    if (!paramView.isShown()) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if ((state == 1) && (i == 0)) {
      return true;
    }
    paramCoordinatorLayout = viewDragHelper;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
    }
    if (i == 0) {
      reset();
    }
    if (velocityTracker == null) {
      velocityTracker = VelocityTracker.obtain();
    }
    velocityTracker.addMovement(paramMotionEvent);
    if ((i == 2) && (!ignoreEvents) && (Math.abs(initialY - paramMotionEvent.getY()) > viewDragHelper.getTouchSlop())) {
      viewDragHelper.captureChildView(paramView, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    return ignoreEvents ^ true;
  }
  
  public void setBottomSheetCallback(BottomSheetCallback paramBottomSheetCallback)
  {
    callback = paramBottomSheetCallback;
  }
  
  public void setFitToContents(boolean paramBoolean)
  {
    if (fitToContents == paramBoolean) {
      return;
    }
    fitToContents = paramBoolean;
    if (viewRef != null) {
      calculateCollapsedOffset();
    }
    int i;
    if ((fitToContents) && (state == 6)) {
      i = 3;
    } else {
      i = state;
    }
    setStateInternal(i);
  }
  
  public void setHideable(boolean paramBoolean)
  {
    hideable = paramBoolean;
  }
  
  public final void setPeekHeight(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (!peekHeightAuto)
      {
        peekHeightAuto = true;
        paramInt = i;
        break label73;
      }
    }
    else {
      if ((peekHeightAuto) || (peekHeight != paramInt)) {
        break label47;
      }
    }
    paramInt = 0;
    break label73;
    label47:
    peekHeightAuto = false;
    peekHeight = Math.max(0, paramInt);
    collapsedOffset = (parentHeight - paramInt);
    paramInt = i;
    label73:
    if ((paramInt != 0) && (state == 4))
    {
      Object localObject = viewRef;
      if (localObject != null)
      {
        localObject = (View)((WeakReference)localObject).get();
        if (localObject != null) {
          ((View)localObject).requestLayout();
        }
      }
    }
  }
  
  public void setSkipCollapsed(boolean paramBoolean)
  {
    skipCollapsed = paramBoolean;
  }
  
  public final void setState(final int paramInt)
  {
    if (paramInt == state) {
      return;
    }
    Object localObject = viewRef;
    if (localObject == null)
    {
      if ((paramInt == 4) || (paramInt == 3) || (paramInt == 6) || ((hideable) && (paramInt == 5))) {
        state = paramInt;
      }
    }
    else
    {
      localObject = (View)((WeakReference)localObject).get();
      if (localObject == null) {
        return;
      }
      ViewParent localViewParent = ((View)localObject).getParent();
      if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (ViewCompat.cancel((View)localObject)))
      {
        ((View)localObject).post(new Runnable()
        {
          public void run()
          {
            startSettlingAnimation(val$child, paramInt);
          }
        });
        return;
      }
      startSettlingAnimation((View)localObject, paramInt);
    }
  }
  
  public void setStateInternal(int paramInt)
  {
    if (state == paramInt) {
      return;
    }
    state = paramInt;
    if ((paramInt != 6) && (paramInt != 3))
    {
      if ((paramInt == 5) || (paramInt == 4)) {
        updateImportantForAccessibility(false);
      }
    }
    else {
      updateImportantForAccessibility(true);
    }
    View localView = (View)viewRef.get();
    if (localView != null)
    {
      BottomSheetCallback localBottomSheetCallback = callback;
      if (localBottomSheetCallback != null) {
        localBottomSheetCallback.onStateChanged(localView, paramInt);
      }
    }
  }
  
  public boolean shouldHide(View paramView, float paramFloat)
  {
    if (skipCollapsed) {
      return true;
    }
    if (paramView.getTop() < collapsedOffset) {
      return false;
    }
    return Math.abs(paramFloat * 0.1F + paramView.getTop() - collapsedOffset) / peekHeight > 0.5F;
  }
  
  public void startSettlingAnimation(View paramView, int paramInt)
  {
    int i;
    int j;
    if (paramInt == 4)
    {
      i = collapsedOffset;
      j = paramInt;
    }
    else if (paramInt == 6)
    {
      int m = halfExpandedOffset;
      i = m;
      j = paramInt;
      if (fitToContents)
      {
        int k = fitToContentsOffset;
        i = m;
        j = paramInt;
        if (m <= k)
        {
          j = 3;
          i = k;
        }
      }
    }
    else if (paramInt == 3)
    {
      i = getExpandedOffset();
      j = paramInt;
    }
    else
    {
      if ((!hideable) || (paramInt != 5)) {
        break label149;
      }
      i = parentHeight;
      j = paramInt;
    }
    if (viewDragHelper.smoothSlideViewTo(paramView, paramView.getLeft(), i))
    {
      setStateInternal(2);
      ViewCompat.postOnAnimation(paramView, new SettleRunnable(paramView, j));
      return;
    }
    setStateInternal(j);
    return;
    label149:
    throw new IllegalArgumentException(StringBuilder.toString("Illegal state argument: ", paramInt));
  }
  
  public static abstract class BottomSheetCallback
  {
    public BottomSheetCallback() {}
    
    public abstract void onSlide(View paramView, float paramFloat);
    
    public abstract void onStateChanged(View paramView, int paramInt);
  }
  
  protected static class SavedState
    extends android.support.v4.view.AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public BottomSheetBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BottomSheetBehavior.SavedState(paramAnonymousParcel, null);
      }
      
      public BottomSheetBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new BottomSheetBehavior.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public BottomSheetBehavior.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomSheetBehavior.SavedState[paramAnonymousInt];
      }
    };
    public final int state;
    
    public SavedState(Parcel paramParcel)
    {
      super(null);
      state = paramParcel.readInt();
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      state = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      state = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(mSuperState, paramInt);
      paramParcel.writeInt(state);
    }
  }
  
  private class SettleRunnable
    implements Runnable
  {
    public final int targetState;
    public final View view;
    
    public SettleRunnable(View paramView, int paramInt)
    {
      view = paramView;
      targetState = paramInt;
    }
    
    public void run()
    {
      ViewDragHelper localViewDragHelper = viewDragHelper;
      if ((localViewDragHelper != null) && (localViewDragHelper.continueSettling(true)))
      {
        ViewCompat.postOnAnimation(view, this);
        return;
      }
      setStateInternal(targetState);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface State {}
}
