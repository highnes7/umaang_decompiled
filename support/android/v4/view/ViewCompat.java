package support.android.v4.view;

import android.content.ClipData;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnUnhandledKeyEventListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import b.b.x.o.T;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import support.android.internal.R.id;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;
import support.android.v4.view.accessibility.AccessibilityNodeProviderCompat;

public class ViewCompat
{
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
  public static final AtomicInteger BITMAP_INSTANCES = new AtomicInteger(1);
  public static Field FIELD_NAME_INDEX;
  @Deprecated
  public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
  @Deprecated
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
  @Deprecated
  public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
  public static boolean L = false;
  @Deprecated
  public static final int LAYER_TYPE_HARDWARE = 2;
  @Deprecated
  public static final int LAYER_TYPE_NONE = 0;
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int LAYOUT_DIRECTION_INHERIT = 2;
  public static final int LAYOUT_DIRECTION_LOCALE = 3;
  public static final int LAYOUT_DIRECTION_LTR = 0;
  public static final int LAYOUT_DIRECTION_RTL = 1;
  public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
  @Deprecated
  public static final int MEASURED_SIZE_MASK = 16777215;
  @Deprecated
  public static final int MEASURED_STATE_MASK = -16777216;
  @Deprecated
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  public static final int OVER_SCROLL_ALWAYS = 0;
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  public static final int OVER_SCROLL_NEVER = 2;
  @Deprecated
  public static final int SCROLL_AXIS_HORIZONTAL = 1;
  public static final int SCROLL_AXIS_NONE = 0;
  public static final int SCROLL_AXIS_VERTICAL = 2;
  public static final int SCROLL_INDICATOR_BOTTOM = 2;
  public static final int SCROLL_INDICATOR_END = 32;
  public static final int SCROLL_INDICATOR_LEFT = 4;
  public static final int SCROLL_INDICATOR_RIGHT = 8;
  @Deprecated
  public static final int SCROLL_INDICATOR_START = 16;
  public static final int SCROLL_INDICATOR_TOP = 1;
  public static final String TAG = "ViewCompat";
  public static final int TOKEN_EVENT = 1;
  public static boolean accessibilityDelegateCheckFailed = false;
  public static Field expression;
  public static WeakHashMap<View, String> h;
  public static Field mAccessibilityDelegateField;
  public static Method mDispatchFinishTemporaryDetach;
  public static Method mDispatchStartTemporaryDetach;
  public static boolean mNoCrossFade;
  public static boolean mTempDetachBound;
  public static WeakHashMap<View, T> mViewPropertyAnimatorCompatMap = null;
  public static Method sChildrenDrawingOrderMethod;
  public static ThreadLocal<Rect> sThreadLocalRect;
  public static final int system_license = 0;
  
  public ViewCompat() {}
  
  public static String a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTransitionName();
    }
    WeakHashMap localWeakHashMap = h;
    if (localWeakHashMap == null) {
      return null;
    }
    return (String)localWeakHashMap.get(paramView);
  }
  
  public static void a(View paramView, int paramInt)
  {
    if ((paramView instanceof RecyclerView))
    {
      ((RecyclerView)paramView).stopNestedScroll(paramInt);
      return;
    }
    if (paramInt == 0) {
      stopNestedScroll(paramView);
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setTransitionName(paramString);
      return;
    }
    if (h == null) {
      h = new WeakHashMap();
    }
    h.put(paramView, paramString);
  }
  
  public static void a(View paramView, ByteVector paramByteVector)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (paramByteVector != null) {
        paramByteVector = paramByteVector.read();
      } else {
        paramByteVector = null;
      }
      paramView.setPointerIcon((PointerIcon)paramByteVector);
    }
  }
  
  public static void a(View paramView, x paramX)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static boolean a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    return false;
  }
  
  public static boolean a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    if ((paramView instanceof RecyclerView)) {
      return ((RecyclerView)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
    }
    if (paramInt5 == 0) {
      return a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    }
    return false;
  }
  
  public static boolean a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    return false;
  }
  
  public static boolean a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    if ((paramView instanceof RecyclerView)) {
      return ((RecyclerView)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
    }
    if (paramInt3 == 0) {
      return a(paramView, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    }
    return false;
  }
  
  public static boolean a(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    return g.b(paramView).a(paramKeyEvent);
  }
  
  public static boolean access$lambda$0(View paramView, ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramView.startDragAndDrop(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
    }
    return paramView.startDrag(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
  }
  
  public static ViewPropertyAnimatorCompat animate(View paramView)
  {
    if (mViewPropertyAnimatorCompatMap == null) {
      mViewPropertyAnimatorCompatMap = new WeakHashMap();
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat2 = (ViewPropertyAnimatorCompat)mViewPropertyAnimatorCompatMap.get(paramView);
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat1 = localViewPropertyAnimatorCompat2;
    if (localViewPropertyAnimatorCompat2 == null)
    {
      localViewPropertyAnimatorCompat1 = new ViewPropertyAnimatorCompat(paramView);
      mViewPropertyAnimatorCompatMap.put(paramView, localViewPropertyAnimatorCompat1);
    }
    return localViewPropertyAnimatorCompat1;
  }
  
  public static void apply(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0)
    {
      float f = paramView.getTranslationY();
      paramView.setTranslationY(1.0F + f);
      paramView.setTranslationY(f);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        show((View)paramView);
      }
    }
  }
  
  public static void b(View paramView, x paramX)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = (Map)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localObject == null) {
        return;
      }
      paramX = (View.OnUnhandledKeyEventListener)((Map)localObject).get(paramX);
      if (paramX != null) {
        paramView.removeOnUnhandledKeyEventListener(paramX);
      }
    }
    else
    {
      localObject = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localObject != null)
      {
        ((ArrayList)localObject).remove(paramX);
        if (((ArrayList)localObject).size() == 0) {
          g.c(paramView);
        }
      }
    }
  }
  
  public static boolean b(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return false;
    }
    return g.b(paramView).a(paramView, paramKeyEvent);
  }
  
  public static void bindTempDetach()
  {
    try
    {
      localMethod = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
      mDispatchStartTemporaryDetach = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Method localMethod;
      label34:
      for (;;) {}
    }
    try
    {
      localMethod = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      mDispatchFinishTemporaryDetach = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      break label34;
    }
    mTempDetachBound = true;
  }
  
  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  public static boolean canScrollVertically(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }
  
  public static boolean cancel(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.isAttachedToWindow();
  }
  
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return View.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public static Rect create(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getClipBounds();
  }
  
  public static boolean describe(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.hasExplicitFocusable();
    }
    return paramView.hasFocusable();
  }
  
  public static WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindowInsetsCompat = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
      localObject = paramView.dispatchApplyWindowInsets(paramWindowInsetsCompat);
      paramView = paramWindowInsetsCompat;
      if (localObject != paramWindowInsetsCompat) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = WindowInsetsCompat.unwrap(paramView);
    }
    return localObject;
  }
  
  public static void dispatchFinishTemporaryDetach(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView.dispatchFinishTemporaryDetach();
      return;
    }
    if (!mTempDetachBound) {
      bindTempDetach();
    }
    Method localMethod = mDispatchFinishTemporaryDetach;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception paramView) {}
    paramView.onFinishTemporaryDetach();
    return;
  }
  
  public static boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    }
    return false;
  }
  
  public static boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).dispatchNestedPreFling(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public static void dispatchStartTemporaryDetach(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView.dispatchStartTemporaryDetach();
      return;
    }
    if (!mTempDetachBound) {
      bindTempDetach();
    }
    Method localMethod = mDispatchStartTemporaryDetach;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception paramView) {}
    paramView.onStartTemporaryDetach();
    return;
  }
  
  public static int generateViewId()
  {
    int i = Build.VERSION.SDK_INT;
    return View.generateViewId();
  }
  
  public static View get(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramView.requireViewById(paramInt);
    }
    paramView = paramView.findViewById(paramInt);
    if (paramView != null) {
      return paramView;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this View");
  }
  
  public static void get(View paramView, Rect paramRect)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setClipBounds(paramRect);
  }
  
  public static int getAccessibilityLiveRegion(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getAccessibilityLiveRegion();
  }
  
  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    paramView = paramView.getAccessibilityNodeProvider();
    if (paramView != null) {
      return new AccessibilityNodeProviderCompat(paramView);
    }
    return null;
  }
  
  public static float getAlpha(View paramView)
  {
    return paramView.getAlpha();
  }
  
  public static ColorStateList getBackgroundTintList(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintList();
    }
    if ((paramView instanceof TintableBackgroundView)) {
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintList();
    }
    return null;
  }
  
  public static PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getBackgroundTintMode();
    }
    if ((paramView instanceof TintableBackgroundView)) {
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintMode();
    }
    return null;
  }
  
  public static float getElevation(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getElevation();
    }
    return 0.0F;
  }
  
  public static Rect getEmptyTempRect()
  {
    if (sThreadLocalRect == null) {
      sThreadLocalRect = new ThreadLocal();
    }
    Rect localRect2 = (Rect)sThreadLocalRect.get();
    Rect localRect1 = localRect2;
    if (localRect2 == null)
    {
      localRect1 = new Rect();
      sThreadLocalRect.set(localRect1);
    }
    localRect1.setEmpty();
    return localRect1;
  }
  
  public static boolean getFitsSystemWindows(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getFitsSystemWindows();
  }
  
  public static int getImportantForAccessibility(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getImportantForAccessibility();
  }
  
  public static int getLabelFor(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getLabelFor();
  }
  
  public static int getLayerType(View paramView)
  {
    return paramView.getLayerType();
  }
  
  public static int getLayoutDirection(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getLayoutDirection();
  }
  
  public static Matrix getMatrix(View paramView)
  {
    return paramView.getMatrix();
  }
  
  public static int getMeasuredHeightAndState(View paramView)
  {
    return paramView.getMeasuredHeightAndState();
  }
  
  public static int getMeasuredState(View paramView)
  {
    return paramView.getMeasuredState();
  }
  
  public static int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidthAndState();
  }
  
  public static int getMinimumHeight(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getMinimumHeight();
  }
  
  public static int getMinimumWidth(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getMinimumWidth();
  }
  
  public static int getOverScrollMode(View paramView)
  {
    return paramView.getOverScrollMode();
  }
  
  public static int getPaddingEnd(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getPaddingEnd();
  }
  
  public static int getPaddingStart(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getPaddingStart();
  }
  
  public static ViewParent getParentForAccessibility(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getParentForAccessibility();
  }
  
  public static float getPivotX(View paramView)
  {
    return paramView.getPivotX();
  }
  
  public static float getPivotY(View paramView)
  {
    return paramView.getPivotY();
  }
  
  public static float getRotation(View paramView)
  {
    return paramView.getRotation();
  }
  
  public static float getRotationX(View paramView)
  {
    return paramView.getRotationX();
  }
  
  public static float getRotationY(View paramView)
  {
    return paramView.getRotationY();
  }
  
  public static float getScaleX(View paramView)
  {
    return paramView.getScaleX();
  }
  
  public static float getScaleY(View paramView)
  {
    return paramView.getScaleY();
  }
  
  public static int getScrollIndicators(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramView.getScrollIndicators();
    }
    return 0;
  }
  
  public static float getTranslationX(View paramView)
  {
    return paramView.getTranslationX();
  }
  
  public static float getTranslationY(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public static int getWindowSystemUiVisibility(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getWindowSystemUiVisibility();
  }
  
  public static float getX(View paramView)
  {
    return paramView.getX();
  }
  
  public static float getY(View paramView)
  {
    return paramView.getY();
  }
  
  public static boolean hasAccessibilityDelegate(View paramView)
  {
    if (accessibilityDelegateCheckFailed) {
      return false;
    }
    if (mAccessibilityDelegateField == null) {}
    try
    {
      mAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
      mAccessibilityDelegateField.setAccessible(true);
    }
    catch (Throwable paramView)
    {
      for (;;) {}
    }
    accessibilityDelegateCheckFailed = true;
    return false;
    try
    {
      paramView = mAccessibilityDelegateField.get(paramView);
      if (paramView == null) {
        break label69;
      }
      return true;
    }
    catch (Throwable paramView)
    {
      for (;;) {}
    }
    accessibilityDelegateCheckFailed = true;
    return false;
    label69:
    return false;
  }
  
  public static boolean hasNestedScrollingParent(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.hasNestedScrollingParent();
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).hasNestedScrollingParent();
    }
    return false;
  }
  
  public static boolean hasNestedScrollingParent(View paramView, int paramInt)
  {
    if ((paramView instanceof RecyclerView)) {
      ((RecyclerView)paramView).hasNestedScrollingParent(paramInt);
    } else if (paramInt == 0) {
      return hasNestedScrollingParent(paramView);
    }
    return false;
  }
  
  public static boolean hasOnClickListeners(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.hasOnClickListeners();
  }
  
  public static boolean hasOverlappingRendering(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.hasOverlappingRendering();
  }
  
  public static boolean hasTransientState(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.hasTransientState();
  }
  
  public static float init(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getZ();
    }
    return 0.0F;
  }
  
  public static boolean isLaidOut(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.isLaidOut();
  }
  
  public static boolean isNestedScrollingEnabled(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.isNestedScrollingEnabled();
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public static boolean isOpaque(View paramView)
  {
    return paramView.isOpaque();
  }
  
  public static boolean isPaddingRelative(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.isPaddingRelative();
  }
  
  public static void jumpDrawablesToCurrentState(View paramView)
  {
    paramView.jumpDrawablesToCurrentState();
  }
  
  public static int loadLayout(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.getNextClusterForwardId();
    }
    return -1;
  }
  
  public static void offsetLeftAndRight(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      paramView.offsetLeftAndRight(paramInt);
      return;
    }
    if (i >= 21)
    {
      Rect localRect = getEmptyTempRect();
      i = 0;
      ViewParent localViewParent = paramView.getParent();
      boolean bool;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
      }
      apply(paramView, paramInt);
      if ((bool) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
    }
    else
    {
      apply(paramView, paramInt);
    }
  }
  
  public static boolean offsetLeftAndRight(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.isLayoutDirectionResolved();
  }
  
  public static void offsetTopAndBottom(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      paramView.offsetTopAndBottom(paramInt);
      return;
    }
    if (i >= 21)
    {
      Rect localRect = getEmptyTempRect();
      i = 0;
      ViewParent localViewParent = paramView.getParent();
      boolean bool;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
      }
      show(paramView, paramInt);
      if ((bool) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
    }
    else
    {
      show(paramView, paramInt);
    }
  }
  
  public static boolean offsetTopAndBottom(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.isInLayout();
  }
  
  public static WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    Object localObject = paramWindowInsetsCompat;
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramWindowInsetsCompat = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
      localObject = paramView.onApplyWindowInsets(paramWindowInsetsCompat);
      paramView = paramWindowInsetsCompat;
      if (localObject != paramWindowInsetsCompat) {
        paramView = new WindowInsets((WindowInsets)localObject);
      }
      localObject = WindowInsetsCompat.unwrap(paramView);
    }
    return localObject;
  }
  
  public static boolean onCreateOptionsMenu(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.isFocusedByDefault();
    }
    return false;
  }
  
  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public static void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramView.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfoCompat.getInfo());
  }
  
  public static boolean onOptionsItemSelected(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.isKeyboardNavigationCluster();
    }
    return false;
  }
  
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public static boolean onPrepareOptionsMenu(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.isImportantForAutofill();
    }
    return true;
  }
  
  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.performAccessibilityAction(paramInt, paramBundle);
  }
  
  public static void postInvalidateOnAnimation(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.postInvalidateOnAnimation();
  }
  
  public static void postInvalidateOnAnimation(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setTranslationZ(paramFloat);
    }
  }
  
  public static void postInvalidateOnAnimation(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setNextClusterForwardId(paramInt);
    }
  }
  
  public static void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void postInvalidateOnAnimation(View paramView, View.DragShadowBuilder paramDragShadowBuilder)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramView.updateDragShadow(paramDragShadowBuilder);
    }
  }
  
  public static void postInvalidateOnAnimation(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setTooltipText(paramCharSequence);
    }
  }
  
  public static void postInvalidateOnAnimation(View paramView, Collection paramCollection, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.addKeyboardNavigationClusters(paramCollection, paramInt);
    }
  }
  
  public static void postInvalidateOnAnimation(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setKeyboardNavigationCluster(paramBoolean);
    }
  }
  
  public static void postInvalidateOnAnimation(View paramView, String... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setAutofillHints(paramVarArgs);
    }
  }
  
  public static Display postOnAnimation(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramView.getDisplay();
  }
  
  public static void postOnAnimation(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setZ(paramFloat);
    }
  }
  
  public static void postOnAnimation(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setImportantForAutofill(paramInt);
    }
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.postOnAnimation(paramRunnable);
  }
  
  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.postOnAnimationDelayed(paramRunnable, paramLong);
  }
  
  public static void requestApplyInsets(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      paramView.requestApplyInsets();
      return;
    }
    paramView.requestFitSystemWindows();
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static boolean selectItemById(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.isImportantForAccessibility();
    }
    return true;
  }
  
  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    if (paramAccessibilityDelegateCompat == null) {
      paramAccessibilityDelegateCompat = null;
    } else {
      paramAccessibilityDelegateCompat = paramAccessibilityDelegateCompat.getBridge();
    }
    paramView.setAccessibilityDelegate(paramAccessibilityDelegateCompat);
  }
  
  public static void setActivated(View paramView, boolean paramBoolean)
  {
    paramView.setActivated(paramBoolean);
  }
  
  public static void setBackground(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setAccessibilityLiveRegion(paramInt);
  }
  
  public static void setBackground(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramOnApplyWindowInsetsListener == null)
      {
        paramView.setOnApplyWindowInsetsListener(null);
        return;
      }
      paramView.setOnApplyWindowInsetsListener(new ViewCompatLollipop.1(paramOnApplyWindowInsetsListener));
    }
  }
  
  public static void setBackgroundDrawable(View paramView, Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setBackground(paramDrawable);
  }
  
  public static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramView.getBackground();
        int i;
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramColorStateList);
        }
      }
    }
    else if ((paramView instanceof TintableBackgroundView))
    {
      ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramView.getBackground();
        int i;
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramMode);
        }
      }
    }
    else if ((paramView instanceof TintableBackgroundView))
    {
      ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode);
    }
  }
  
  /* Error */
  public static void setChildrenDrawingOrderEnabled(android.view.ViewGroup paramViewGroup, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 825	support/android/v4/view/ViewCompat:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   3: ifnonnull +36 -> 39
    //   6: getstatic 831	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   9: astore_2
    //   10: ldc_w 833
    //   13: ldc_w 834
    //   16: iconst_1
    //   17: anewarray 286	java/lang/Class
    //   20: dup
    //   21: iconst_0
    //   22: aload_2
    //   23: aastore
    //   24: invokevirtual 290	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   27: astore_2
    //   28: aload_2
    //   29: putstatic 825	support/android/v4/view/ViewCompat:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   32: getstatic 825	support/android/v4/view/ViewCompat:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   35: iconst_1
    //   36: invokevirtual 835	java/lang/reflect/Method:setAccessible	(Z)V
    //   39: getstatic 825	support/android/v4/view/ViewCompat:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   42: astore_2
    //   43: aload_2
    //   44: aload_0
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_1
    //   52: invokestatic 839	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: aastore
    //   56: invokevirtual 360	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: pop
    //   60: return
    //   61: astore_2
    //   62: goto -30 -> 32
    //   65: astore_0
    //   66: return
    //   67: astore_0
    //   68: return
    //   69: astore_0
    //   70: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramViewGroup	android.view.ViewGroup
    //   0	71	1	paramBoolean	boolean
    //   9	35	2	localObject	Object
    //   61	1	2	localNoSuchMethodException	NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   10	28	61	java/lang/NoSuchMethodException
    //   43	60	65	java/lang/IllegalAccessException
    //   43	60	67	java/lang/IllegalArgumentException
    //   43	60	69	java/lang/reflect/InvocationTargetException
  }
  
  public static float setElevation(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getTranslationZ();
    }
    return 0.0F;
  }
  
  public static void setElevation(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramView.setElevation(paramFloat);
    }
  }
  
  public static void setElevation(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setFocusedByDefault(paramBoolean);
    }
  }
  
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(paramBoolean);
  }
  
  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setImportantForAccessibility(paramInt);
  }
  
  public static void setLabelFor(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setLabelFor(paramInt);
  }
  
  public static void setLayerPaint(View paramView, Paint paramPaint)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setLayerPaint(paramPaint);
  }
  
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }
  
  public static void setLayoutDirection(View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setLayoutDirection(paramInt);
  }
  
  public static void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setNestedScrollingEnabled(paramBoolean);
      return;
    }
    if ((paramView instanceof NestedScrollingChild)) {
      ((NestedScrollingChild)paramView).setNestedScrollingEnabled(paramBoolean);
    }
  }
  
  public static void setOverScrollMode(View paramView, int paramInt)
  {
    paramView.setOverScrollMode(paramInt);
  }
  
  public static void setPadding(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramView.cancelDragAndDrop();
    }
  }
  
  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setPivotX(View paramView, float paramFloat)
  {
    paramView.setPivotX(paramFloat);
  }
  
  public static void setPivotY(View paramView, float paramFloat)
  {
    paramView.setPivotY(paramFloat);
  }
  
  public static void setRotation(View paramView, float paramFloat)
  {
    paramView.setRotation(paramFloat);
  }
  
  public static void setRotationX(View paramView, float paramFloat)
  {
    paramView.setRotationX(paramFloat);
  }
  
  public static void setRotationY(View paramView, float paramFloat)
  {
    paramView.setRotationY(paramFloat);
  }
  
  public static void setSaveFromParentEnabled(View paramView, boolean paramBoolean)
  {
    paramView.setSaveFromParentEnabled(paramBoolean);
  }
  
  public static void setScaleX(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  public static void setScaleY(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  public static void setScrollIndicators(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setScrollIndicators(paramInt);
    }
  }
  
  public static void setScrollIndicators(View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramView.setScrollIndicators(paramInt1, paramInt2);
    }
  }
  
  public static void setTranslationX(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  public static void setTranslationY(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
  
  public static void setTranslationZ(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  public static void setX(View paramView, float paramFloat)
  {
    paramView.setX(paramFloat);
  }
  
  public static void setY(View paramView, float paramFloat)
  {
    paramView.setY(paramFloat);
  }
  
  public static void show(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }
  
  public static void show(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0)
    {
      float f = paramView.getTranslationY();
      paramView.setTranslationY(1.0F + f);
      paramView.setTranslationY(f);
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        show((View)paramView);
      }
    }
  }
  
  public static int start(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.getImportantForAutofill();
    }
    return 0;
  }
  
  public static void start(View paramView, boolean paramBoolean)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.setHasTransientState(paramBoolean);
  }
  
  public static boolean startNestedScroll(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.startNestedScroll(paramInt);
    }
    if ((paramView instanceof NestedScrollingChild)) {
      return ((NestedScrollingChild)paramView).startNestedScroll(paramInt);
    }
    return false;
  }
  
  public static boolean startNestedScroll(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof RecyclerView)) {
      return ((RecyclerView)paramView).startNestedScroll(paramInt1, paramInt2);
    }
    if (paramInt2 == 0) {
      return startNestedScroll(paramView, paramInt1);
    }
    return false;
  }
  
  public static void stopNestedScroll(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.stopNestedScroll();
      return;
    }
    if ((paramView instanceof NestedScrollingChild)) {
      ((NestedScrollingChild)paramView).stopNestedScroll();
    }
  }
  
  public static boolean validate(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView.restoreDefaultFocus();
    }
    return paramView.requestFocus();
  }
  
  public static View wrap(View paramView1, View paramView2, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramView1.keyboardNavigationClusterSearch(paramView2, paramInt);
    }
    return null;
  }
}
