package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.R.attr;
import android.support.design.R.layout;
import android.support.design.R.styleable;
import android.support.design.animation.AnimationUtils;
import android.support.design.internal.ThemeEnforcement;
import android.support.design.snackbar.ContentViewCallback;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import b.b.a.N;
import b.b.a.x;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import support.android.v4.view.AccessibilityDelegateCompat;
import support.android.v4.view.OnApplyWindowInsetsListener;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.WindowInsetsCompat;
import support.android.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl;
import support.android.v4.view.accessibility.AccessibilityNodeInfoCompat;
import support.android.v4.view.accessibility.Key;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  public static final int ANIMATION_DURATION = 250;
  public static final int ANIMATION_FADE_DURATION = 180;
  public static final int LENGTH_INDEFINITE = -2;
  public static final int LENGTH_LONG = 0;
  public static final int LENGTH_SHORT = -1;
  public static final int MSG_DISMISS = 1;
  public static final int MSG_SHOW = 0;
  public static final int[] SNACKBAR_STYLE_ATTR = { R.attr.snackbarStyle };
  public static final boolean USE_OFFSET_API;
  public static final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      int i = what;
      if (i != 0)
      {
        if (i != 1) {
          return false;
        }
        ((BaseTransientBottomBar)obj).hideView(arg1);
        return true;
      }
      ((BaseTransientBottomBar)obj).showView();
      return true;
    }
  });
  public final AccessibilityManager accessibilityManager;
  public Behavior behavior;
  public List<BaseCallback<B>> callbacks;
  public final ContentViewCallback contentViewCallback;
  public final Context context;
  public int duration;
  public final SnackbarManager.Callback managerCallback = new SnackbarManager.Callback()
  {
    public void dismiss(int paramAnonymousInt)
    {
      Handler localHandler = BaseTransientBottomBar.handler;
      localHandler.sendMessage(localHandler.obtainMessage(1, paramAnonymousInt, 0, BaseTransientBottomBar.this));
    }
    
    public void show()
    {
      Handler localHandler = BaseTransientBottomBar.handler;
      localHandler.sendMessage(localHandler.obtainMessage(0, BaseTransientBottomBar.this));
    }
  };
  public final ViewGroup targetParent;
  public final SnackbarBaseLayout view;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT <= 19) {
      bool = true;
    } else {
      bool = false;
    }
    USE_OFFSET_API = bool;
  }
  
  public BaseTransientBottomBar(ViewGroup paramViewGroup, View paramView, ContentViewCallback paramContentViewCallback)
  {
    if (paramViewGroup != null)
    {
      if (paramView != null)
      {
        if (paramContentViewCallback != null)
        {
          targetParent = paramViewGroup;
          contentViewCallback = paramContentViewCallback;
          context = paramViewGroup.getContext();
          ThemeEnforcement.checkAppCompatTheme(context);
          view = ((SnackbarBaseLayout)LayoutInflater.from(context).inflate(getSnackbarBaseLayoutResId(), targetParent, false));
          view.addView(paramView);
          ViewCompat.setBackground(view, 1);
          ViewCompat.setImportantForAccessibility(view, 1);
          ViewCompat.setFitsSystemWindows(view, true);
          ViewCompat.setBackground(view, new OnApplyWindowInsetsListener()
          {
            public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
            {
              paramAnonymousView.setPadding(paramAnonymousView.getPaddingLeft(), paramAnonymousView.getPaddingTop(), paramAnonymousView.getPaddingRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
              return paramAnonymousWindowInsetsCompat;
            }
          });
          ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat()
          {
            public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
            {
              super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
              paramAnonymousAccessibilityNodeInfoCompat.addAction(1048576);
              paramAnonymousAccessibilityNodeInfoCompat.addChild(true);
            }
            
            public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
            {
              if (paramAnonymousInt == 1048576)
              {
                dismiss();
                return true;
              }
              return super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
            }
          });
          accessibilityManager = ((AccessibilityManager)context.getSystemService("accessibility"));
          return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
      }
      throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    }
    throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
  }
  
  private void animateViewOut(final int paramInt)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { 0, getTranslationYBottom() });
    localValueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        onViewHidden(paramInt);
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        BaseTransientBottomBar.access$100(BaseTransientBottomBar.this).animateContentOut(0, 180);
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public int previousAnimatedIntValue = 0;
      
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.USE_OFFSET_API) {
          ViewCompat.offsetTopAndBottom(view, i - previousAnimatedIntValue);
        } else {
          view.setTranslationY(i);
        }
        previousAnimatedIntValue = i;
      }
    });
    localValueAnimator.start();
  }
  
  private int getTranslationYBottom()
  {
    int j = view.getHeight();
    ViewGroup.LayoutParams localLayoutParams = view.getLayoutParams();
    int i = j;
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      i = j + bottomMargin;
    }
    return i;
  }
  
  public BaseTransientBottomBar addCallback(BaseCallback paramBaseCallback)
  {
    if (paramBaseCallback == null) {
      return this;
    }
    if (callbacks == null) {
      callbacks = new ArrayList();
    }
    callbacks.add(paramBaseCallback);
    return this;
  }
  
  public void animateViewIn()
  {
    final int i = getTranslationYBottom();
    if (USE_OFFSET_API) {
      ViewCompat.offsetTopAndBottom(view, i);
    } else {
      view.setTranslationY(i);
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { i, 0 });
    localValueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        onViewShown();
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        BaseTransientBottomBar.access$100(BaseTransientBottomBar.this).animateContentIn(70, 180);
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public int previousAnimatedIntValue = i;
      
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.USE_OFFSET_API) {
          ViewCompat.offsetTopAndBottom(view, i - previousAnimatedIntValue);
        } else {
          view.setTranslationY(i);
        }
        previousAnimatedIntValue = i;
      }
    });
    localValueAnimator.start();
  }
  
  public void dismiss()
  {
    dispatchDismiss(3);
  }
  
  public void dispatchDismiss(int paramInt)
  {
    SnackbarManager.getInstance().dismiss(managerCallback, paramInt);
  }
  
  public Behavior getBehavior()
  {
    return behavior;
  }
  
  public Context getContext()
  {
    return context;
  }
  
  public int getDuration()
  {
    return duration;
  }
  
  public SwipeDismissBehavior getNewBehavior()
  {
    return new Behavior();
  }
  
  public int getSnackbarBaseLayoutResId()
  {
    if (hasSnackbarStyleAttr()) {
      return R.layout.mtrl_layout_snackbar;
    }
    return R.layout.design_layout_snackbar;
  }
  
  public View getView()
  {
    return view;
  }
  
  public boolean hasSnackbarStyleAttr()
  {
    TypedArray localTypedArray = context.obtainStyledAttributes(SNACKBAR_STYLE_ATTR);
    int i = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    return i != -1;
  }
  
  public final void hideView(int paramInt)
  {
    if ((shouldAnimate()) && (view.getVisibility() == 0))
    {
      animateViewOut(paramInt);
      return;
    }
    onViewHidden(paramInt);
  }
  
  public boolean isShown()
  {
    return SnackbarManager.getInstance().isCurrent(managerCallback);
  }
  
  public boolean isShownOrQueued()
  {
    return SnackbarManager.getInstance().isCurrentOrNext(managerCallback);
  }
  
  public void onViewHidden(int paramInt)
  {
    SnackbarManager.getInstance().onDismissed(managerCallback);
    Object localObject = callbacks;
    if (localObject != null)
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        ((BaseCallback)callbacks.get(i)).onDismissed(this, paramInt);
        i -= 1;
      }
    }
    localObject = view.getParent();
    if ((localObject instanceof ViewGroup)) {
      ((ViewGroup)localObject).removeView(view);
    }
  }
  
  public void onViewShown()
  {
    SnackbarManager.getInstance().onShown(managerCallback);
    List localList = callbacks;
    if (localList != null)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((BaseCallback)callbacks.get(i)).onShown(this);
        i -= 1;
      }
    }
  }
  
  public BaseTransientBottomBar removeCallback(BaseCallback paramBaseCallback)
  {
    if (paramBaseCallback == null) {
      return this;
    }
    List localList = callbacks;
    if (localList == null) {
      return this;
    }
    localList.remove(paramBaseCallback);
    return this;
  }
  
  public BaseTransientBottomBar setBehavior(Behavior paramBehavior)
  {
    behavior = paramBehavior;
    return this;
  }
  
  public BaseTransientBottomBar setDuration(int paramInt)
  {
    duration = paramInt;
    return this;
  }
  
  public boolean shouldAnimate()
  {
    List localList = accessibilityManager.getEnabledAccessibilityServiceList(1);
    return (localList != null) && (localList.isEmpty());
  }
  
  public void show()
  {
    SnackbarManager.getInstance().show(getDuration(), managerCallback);
  }
  
  public final void showView()
  {
    if (view.getParent() == null)
    {
      Object localObject = view.getLayoutParams();
      if ((localObject instanceof CoordinatorLayout.LayoutParams))
      {
        CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)localObject;
        Behavior localBehavior = behavior;
        localObject = localBehavior;
        if (localBehavior == null) {
          localObject = getNewBehavior();
        }
        if ((localObject instanceof Behavior)) {
          delegate.setBaseTransientBottomBar(this);
        }
        ((SwipeDismissBehavior)localObject).setListener(new SwipeDismissBehavior.OnDismissListener()
        {
          public void onDismiss(View paramAnonymousView)
          {
            paramAnonymousView.setVisibility(8);
            dispatchDismiss(0);
          }
          
          public void onDragStateChanged(int paramAnonymousInt)
          {
            if (paramAnonymousInt != 0)
            {
              if ((paramAnonymousInt != 1) && (paramAnonymousInt != 2)) {
                return;
              }
              SnackbarManager.getInstance().pauseTimeout(managerCallback);
              return;
            }
            SnackbarManager.getInstance().restoreTimeoutIfPaused(managerCallback);
          }
        });
        localLayoutParams.setBehavior((CoordinatorLayout.Behavior)localObject);
        insetEdge = 80;
      }
      targetParent.addView(view);
    }
    view.setOnAttachStateChangeListener(new OnAttachStateChangeListener()
    {
      public void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public void onViewDetachedFromWindow(View paramAnonymousView)
      {
        if (isShownOrQueued()) {
          BaseTransientBottomBar.handler.post(new Runnable()
          {
            public void run()
            {
              onViewHidden(3);
            }
          });
        }
      }
    });
    if (ViewCompat.isLaidOut(view))
    {
      if (shouldAnimate())
      {
        animateViewIn();
        return;
      }
      onViewShown();
      return;
    }
    view.setOnLayoutChangeListener(new OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        view.setOnLayoutChangeListener(null);
        if (shouldAnimate())
        {
          animateViewIn();
          return;
        }
        onViewShown();
      }
    });
  }
  
  public static abstract class BaseCallback<B>
  {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;
    
    public BaseCallback() {}
    
    public void onDismissed(Object paramObject, int paramInt) {}
    
    public void onShown(Object paramObject) {}
    
    @Retention(RetentionPolicy.SOURCE)
    @N({b.b.a.N.a.b})
    public static @interface DismissEvent {}
  }
  
  public static class Behavior
    extends SwipeDismissBehavior<View>
  {
    public final BaseTransientBottomBar.BehaviorDelegate delegate = new BaseTransientBottomBar.BehaviorDelegate(this);
    
    public Behavior() {}
    
    private void setBaseTransientBottomBar(BaseTransientBottomBar paramBaseTransientBottomBar)
    {
      delegate.setBaseTransientBottomBar(paramBaseTransientBottomBar);
    }
    
    public boolean canSwipeDismissView(View paramView)
    {
      return delegate.canSwipeDismissView(paramView);
    }
    
    public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      delegate.onInterceptTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
      return super.onInterceptTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
    }
  }
  
  @N({b.b.a.N.a.b})
  public static class BehaviorDelegate
  {
    public SnackbarManager.Callback managerCallback;
    
    public BehaviorDelegate(SwipeDismissBehavior paramSwipeDismissBehavior)
    {
      paramSwipeDismissBehavior.setStartAlphaSwipeDistance(0.1F);
      paramSwipeDismissBehavior.setEndAlphaSwipeDistance(0.6F);
      paramSwipeDismissBehavior.setSwipeDirection(0);
    }
    
    public boolean canSwipeDismissView(View paramView)
    {
      return paramView instanceof BaseTransientBottomBar.SnackbarBaseLayout;
    }
    
    public void onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getActionMasked();
      if (i != 0)
      {
        if ((i != 1) && (i != 3)) {
          return;
        }
        SnackbarManager.getInstance().restoreTimeoutIfPaused(managerCallback);
        return;
      }
      if (paramCoordinatorLayout.isPointInChildBounds(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        SnackbarManager.getInstance().pauseTimeout(managerCallback);
      }
    }
    
    public void setBaseTransientBottomBar(BaseTransientBottomBar paramBaseTransientBottomBar)
    {
      managerCallback = managerCallback;
    }
  }
  
  @Deprecated
  public static abstract interface ContentViewCallback
    extends ContentViewCallback
  {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  @x(from=1L)
  public static @interface Duration {}
  
  @N({b.b.a.N.a.b})
  protected static abstract interface OnAttachStateChangeListener
  {
    public abstract void onViewAttachedToWindow(View paramView);
    
    public abstract void onViewDetachedFromWindow(View paramView);
  }
  
  @N({b.b.a.N.a.b})
  protected static abstract interface OnLayoutChangeListener
  {
    public abstract void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  @N({b.b.a.N.a.b})
  protected static class SnackbarBaseLayout
    extends FrameLayout
  {
    public final AccessibilityManager accessibilityManager;
    public BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener;
    public BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener;
    public final Key touchExplorationStateChangeListener;
    
    public SnackbarBaseLayout(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SnackbarBaseLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
      if (paramAttributeSet.hasValue(R.styleable.SnackbarLayout_elevation)) {
        ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
      }
      paramAttributeSet.recycle();
      accessibilityManager = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
      touchExplorationStateChangeListener = new Key()
      {
        public void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          BaseTransientBottomBar.SnackbarBaseLayout.access$300(BaseTransientBottomBar.SnackbarBaseLayout.this, paramAnonymousBoolean);
        }
      };
      AccessibilityManagerCompat.AccessibilityManagerVersionImpl.get(accessibilityManager, touchExplorationStateChangeListener);
      setClickableOrFocusableBasedOnAccessibility(accessibilityManager.isTouchExplorationEnabled());
    }
    
    private void setClickableOrFocusableBasedOnAccessibility(boolean paramBoolean)
    {
      setClickable(paramBoolean ^ true);
      setFocusable(paramBoolean);
    }
    
    public void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      BaseTransientBottomBar.OnAttachStateChangeListener localOnAttachStateChangeListener = onAttachStateChangeListener;
      if (localOnAttachStateChangeListener != null) {
        localOnAttachStateChangeListener.onViewAttachedToWindow(this);
      }
      ViewCompat.requestApplyInsets(this);
    }
    
    public void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      BaseTransientBottomBar.OnAttachStateChangeListener localOnAttachStateChangeListener = onAttachStateChangeListener;
      if (localOnAttachStateChangeListener != null) {
        localOnAttachStateChangeListener.onViewDetachedFromWindow(this);
      }
      AccessibilityManagerCompat.AccessibilityManagerVersionImpl.isTouchExplorationEnabled(accessibilityManager, touchExplorationStateChangeListener);
    }
    
    public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      BaseTransientBottomBar.OnLayoutChangeListener localOnLayoutChangeListener = onLayoutChangeListener;
      if (localOnLayoutChangeListener != null) {
        localOnLayoutChangeListener.onLayoutChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void setOnAttachStateChangeListener(BaseTransientBottomBar.OnAttachStateChangeListener paramOnAttachStateChangeListener)
    {
      onAttachStateChangeListener = paramOnAttachStateChangeListener;
    }
    
    public void setOnLayoutChangeListener(BaseTransientBottomBar.OnLayoutChangeListener paramOnLayoutChangeListener)
    {
      onLayoutChangeListener = paramOnLayoutChangeListener;
    }
  }
}
