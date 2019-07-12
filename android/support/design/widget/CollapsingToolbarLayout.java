package android.support.design.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.R.id;
import android.support.design.R.styleable;
import android.support.design.animation.AnimationUtils;
import android.support.design.internal.ThemeEnforcement;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import support.android.v4.content.ContextCompat;
import support.android.v4.graphics.MathUtils;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.util.LatLong;
import support.android.v4.view.OnApplyWindowInsetsListener;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.WindowInsetsCompat;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  public static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
  public final CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
  public boolean collapsingTitleEnabled;
  public Drawable contentScrim;
  public int currentOffset;
  public boolean drawCollapsingTitle;
  public View dummyView;
  public int expandedMarginBottom;
  public int expandedMarginEnd;
  public int expandedMarginStart;
  public int expandedMarginTop;
  public WindowInsetsCompat lastInsets;
  public AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
  public boolean refreshToolbar = true;
  public int scrimAlpha;
  public long scrimAnimationDuration;
  public ValueAnimator scrimAnimator;
  public int scrimVisibleHeightTrigger = -1;
  public boolean scrimsAreShown;
  public Drawable statusBarScrim;
  public final Rect tmpRect = new Rect();
  public Toolbar toolbar;
  public View toolbarDirectChild;
  public int toolbarId;
  
  public CollapsingToolbarLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.CollapsingToolbarLayout, paramInt, android.support.design.R.style.Widget_Design_CollapsingToolbar, new int[0]);
    collapsingTextHelper.setExpandedTextGravity(paramContext.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    collapsingTextHelper.setCollapsedTextGravity(paramContext.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    paramInt = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
    expandedMarginBottom = paramInt;
    expandedMarginEnd = paramInt;
    expandedMarginTop = paramInt;
    expandedMarginStart = paramInt;
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
      expandedMarginStart = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
      expandedMarginEnd = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
      expandedMarginTop = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
      expandedMarginBottom = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
    }
    collapsingTitleEnabled = paramContext.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(paramContext.getText(R.styleable.CollapsingToolbarLayout_title));
    collapsingTextHelper.setExpandedTextAppearance(android.support.design.R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
    collapsingTextHelper.setCollapsedTextAppearance(android.support.v7.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
      collapsingTextHelper.setExpandedTextAppearance(paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
    }
    if (paramContext.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
      collapsingTextHelper.setCollapsedTextAppearance(paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
    }
    scrimVisibleHeightTrigger = paramContext.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
    scrimAnimationDuration = paramContext.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
    setContentScrim(paramContext.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(paramContext.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
    toolbarId = paramContext.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    ViewCompat.setBackground(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        return onWindowInsetChanged(paramAnonymousWindowInsetsCompat);
      }
    });
  }
  
  private void animateScrim(int paramInt)
  {
    ensureToolbar();
    Object localObject = scrimAnimator;
    if (localObject == null)
    {
      scrimAnimator = new ValueAnimator();
      scrimAnimator.setDuration(scrimAnimationDuration);
      ValueAnimator localValueAnimator = scrimAnimator;
      if (paramInt > scrimAlpha) {
        localObject = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
      } else {
        localObject = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
      }
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          setScrimAlpha(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
      });
    }
    else if (((ValueAnimator)localObject).isRunning())
    {
      scrimAnimator.cancel();
    }
    scrimAnimator.setIntValues(new int[] { scrimAlpha, paramInt });
    scrimAnimator.start();
  }
  
  private void ensureToolbar()
  {
    if (!refreshToolbar) {
      return;
    }
    Object localObject2 = null;
    toolbar = null;
    toolbarDirectChild = null;
    int i = toolbarId;
    Object localObject1;
    if (i != -1)
    {
      toolbar = ((Toolbar)findViewById(i));
      localObject1 = toolbar;
      if (localObject1 != null) {
        toolbarDirectChild = findDirectChild((View)localObject1);
      }
    }
    if (toolbar == null)
    {
      int j = getChildCount();
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        localObject1 = getChildAt(i);
        if ((localObject1 instanceof Toolbar))
        {
          localObject1 = (Toolbar)localObject1;
          break;
        }
        i += 1;
      }
      toolbar = ((Toolbar)localObject1);
    }
    updateDummyView();
    refreshToolbar = false;
  }
  
  private View findDirectChild(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    return localView;
  }
  
  public static int getHeightWithMargins(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      return paramView.getHeight() + topMargin + bottomMargin;
    }
    return paramView.getHeight();
  }
  
  public static ViewOffsetHelper getViewOffsetHelper(View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper2 = (ViewOffsetHelper)paramView.getTag(R.id.view_offset_helper);
    ViewOffsetHelper localViewOffsetHelper1 = localViewOffsetHelper2;
    if (localViewOffsetHelper2 == null)
    {
      localViewOffsetHelper1 = new ViewOffsetHelper(paramView);
      paramView.setTag(R.id.view_offset_helper, localViewOffsetHelper1);
    }
    return localViewOffsetHelper1;
  }
  
  private boolean isToolbarChild(View paramView)
  {
    View localView = toolbarDirectChild;
    if ((localView != null) && (localView != this))
    {
      if (paramView == localView) {
        return true;
      }
    }
    else if (paramView == toolbar) {
      return true;
    }
    return false;
  }
  
  private void updateContentDescriptionFromTitle()
  {
    setContentDescription(getTitle());
  }
  
  private void updateDummyView()
  {
    if (!collapsingTitleEnabled)
    {
      Object localObject = dummyView;
      if (localObject != null)
      {
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(dummyView);
        }
      }
    }
    if ((collapsingTitleEnabled) && (toolbar != null))
    {
      if (dummyView == null) {
        dummyView = new View(getContext());
      }
      if (dummyView.getParent() == null) {
        toolbar.addView(dummyView, -1, -1);
      }
    }
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    ensureToolbar();
    Object localObject;
    if (toolbar == null)
    {
      localObject = contentScrim;
      if ((localObject != null) && (scrimAlpha > 0))
      {
        ((Drawable)localObject).mutate().setAlpha(scrimAlpha);
        contentScrim.draw(paramCanvas);
      }
    }
    if ((collapsingTitleEnabled) && (drawCollapsingTitle)) {
      collapsingTextHelper.draw(paramCanvas);
    }
    if ((statusBarScrim != null) && (scrimAlpha > 0))
    {
      localObject = lastInsets;
      int i;
      if (localObject != null) {
        i = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      if (i > 0)
      {
        statusBarScrim.setBounds(0, -currentOffset, getWidth(), i - currentOffset);
        statusBarScrim.mutate().setAlpha(scrimAlpha);
        statusBarScrim.draw(paramCanvas);
      }
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i;
    if ((contentScrim != null) && (scrimAlpha > 0) && (isToolbarChild(paramView)))
    {
      contentScrim.mutate().setAlpha(scrimAlpha);
      contentScrim.draw(paramCanvas);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (!super.drawChild(paramCanvas, paramView, paramLong)) {
      return i != 0;
    }
    return true;
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Object localObject = statusBarScrim;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Drawable)localObject).isStateful()) {
        bool1 = false | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = contentScrim;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((Drawable)localObject).isStateful()) {
        bool2 = bool1 | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = collapsingTextHelper;
    bool1 = bool2;
    if (localObject != null) {
      bool1 = bool2 | ((CollapsingTextHelper)localObject).setState(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCollapsedTitleGravity()
  {
    return collapsingTextHelper.getCollapsedTextGravity();
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    return collapsingTextHelper.getCollapsedTypeface();
  }
  
  public Drawable getContentScrim()
  {
    return contentScrim;
  }
  
  public int getExpandedTitleGravity()
  {
    return collapsingTextHelper.getExpandedTextGravity();
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return expandedMarginBottom;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return expandedMarginEnd;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return expandedMarginStart;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return expandedMarginTop;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    return collapsingTextHelper.getExpandedTypeface();
  }
  
  public final int getMaxOffsetForPinChild(View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper = getViewOffsetHelper(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - localViewOffsetHelper.getLayoutTop() - paramView.getHeight() - bottomMargin;
  }
  
  public int getScrimAlpha()
  {
    return scrimAlpha;
  }
  
  public long getScrimAnimationDuration()
  {
    return scrimAnimationDuration;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    int i = scrimVisibleHeightTrigger;
    if (i >= 0) {
      return i;
    }
    WindowInsetsCompat localWindowInsetsCompat = lastInsets;
    if (localWindowInsetsCompat != null) {
      i = localWindowInsetsCompat.getSystemWindowInsetTop();
    } else {
      i = 0;
    }
    int j = ViewCompat.getMinimumHeight(this);
    if (j > 0) {
      return Math.min(j * 2 + i, getHeight());
    }
    return getHeight() / 3;
  }
  
  public Drawable getStatusBarScrim()
  {
    return statusBarScrim;
  }
  
  public CharSequence getTitle()
  {
    if (collapsingTitleEnabled) {
      return collapsingTextHelper.getText();
    }
    return null;
  }
  
  public boolean isTitleEnabled()
  {
    return collapsingTitleEnabled;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View)localViewParent));
      if (onOffsetChangedListener == null) {
        onOffsetChangedListener = new OffsetUpdateListener();
      }
      ((AppBarLayout)localViewParent).addOnOffsetChangedListener(onOffsetChangedListener);
      ViewCompat.requestApplyInsets(this);
    }
  }
  
  public void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    AppBarLayout.OnOffsetChangedListener localOnOffsetChangedListener = onOffsetChangedListener;
    if ((localOnOffsetChangedListener != null) && ((localViewParent instanceof AppBarLayout))) {
      ((AppBarLayout)localViewParent).removeOnOffsetChangedListener(localOnOffsetChangedListener);
    }
    super.onDetachedFromWindow();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = lastInsets;
    int m = 0;
    int j;
    int k;
    int i;
    if (localObject != null)
    {
      j = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
      k = getChildCount();
      i = 0;
      while (i < k)
      {
        localObject = getChildAt(i);
        if ((!ViewCompat.getFitsSystemWindows((View)localObject)) && (((View)localObject).getTop() < j)) {
          ViewCompat.offsetTopAndBottom((View)localObject, j);
        }
        i += 1;
      }
    }
    if (collapsingTitleEnabled)
    {
      localObject = dummyView;
      if (localObject != null)
      {
        paramBoolean = ViewCompat.cancel((View)localObject);
        i = 1;
        if ((paramBoolean) && (dummyView.getVisibility() == 0)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        drawCollapsingTitle = paramBoolean;
        if (drawCollapsingTitle)
        {
          if (ViewCompat.getLayoutDirection(this) != 1) {
            i = 0;
          }
          localObject = toolbarDirectChild;
          if (localObject == null) {
            localObject = toolbar;
          }
          int n = getMaxOffsetForPinChild((View)localObject);
          DescendantOffsetUtils.getDescendantRect(this, dummyView, tmpRect);
          localObject = collapsingTextHelper;
          int i1 = tmpRect.left;
          if (i != 0) {
            j = toolbar.getTitleMarginEnd();
          } else {
            j = toolbar.getTitleMarginStart();
          }
          int i2 = tmpRect.top;
          int i3 = toolbar.getTitleMarginTop();
          int i4 = tmpRect.right;
          if (i != 0) {
            k = toolbar.getTitleMarginStart();
          } else {
            k = toolbar.getTitleMarginEnd();
          }
          ((CollapsingTextHelper)localObject).setCollapsedBounds(i1 + j, i3 + (i2 + n), i4 + k, tmpRect.bottom + n - toolbar.getTitleMarginBottom());
          localObject = collapsingTextHelper;
          if (i != 0) {
            j = expandedMarginEnd;
          } else {
            j = expandedMarginStart;
          }
          k = tmpRect.top;
          n = expandedMarginTop;
          if (i != 0) {
            i = expandedMarginStart;
          } else {
            i = expandedMarginEnd;
          }
          ((CollapsingTextHelper)localObject).setExpandedBounds(j, k + n, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - expandedMarginBottom);
          collapsingTextHelper.recalculate();
        }
      }
    }
    paramInt2 = getChildCount();
    paramInt1 = m;
    while (paramInt1 < paramInt2)
    {
      getViewOffsetHelper(getChildAt(paramInt1)).onViewLayout();
      paramInt1 += 1;
    }
    if (toolbar != null)
    {
      if ((collapsingTitleEnabled) && (TextUtils.isEmpty(collapsingTextHelper.getText()))) {
        setTitle(toolbar.getTitle());
      }
      localObject = toolbarDirectChild;
      if ((localObject != null) && (localObject != this)) {
        setMinimumHeight(getHeightWithMargins((View)localObject));
      } else {
        setMinimumHeight(getHeightWithMargins(toolbar));
      }
    }
    updateScrimVisibility();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    ensureToolbar();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    WindowInsetsCompat localWindowInsetsCompat = lastInsets;
    if (localWindowInsetsCompat != null) {
      paramInt2 = localWindowInsetsCompat.getSystemWindowInsetTop();
    } else {
      paramInt2 = 0;
    }
    if ((i == 0) && (paramInt2 > 0)) {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + paramInt2, 1073741824));
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = contentScrim;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat paramWindowInsetsCompat)
  {
    WindowInsetsCompat localWindowInsetsCompat;
    if (ViewCompat.getFitsSystemWindows(this)) {
      localWindowInsetsCompat = paramWindowInsetsCompat;
    } else {
      localWindowInsetsCompat = null;
    }
    if (!LatLong.equals(lastInsets, localWindowInsetsCompat))
    {
      lastInsets = localWindowInsetsCompat;
      requestLayout();
    }
    return paramWindowInsetsCompat.consumeSystemWindowInsets();
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    collapsingTextHelper.setCollapsedTextGravity(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    collapsingTextHelper.setCollapsedTextAppearance(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    collapsingTextHelper.setCollapsedTextColor(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    collapsingTextHelper.setCollapsedTypeface(paramTypeface);
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2 = contentScrim;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      contentScrim = localDrawable1;
      paramDrawable = contentScrim;
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, getWidth(), getHeight());
        contentScrim.setCallback(this);
        contentScrim.setAlpha(scrimAlpha);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    collapsingTextHelper.setExpandedTextGravity(paramInt);
  }
  
  public void setExpandedTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    expandedMarginStart = paramInt1;
    expandedMarginTop = paramInt2;
    expandedMarginEnd = paramInt3;
    expandedMarginBottom = paramInt4;
    requestLayout();
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    expandedMarginBottom = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    expandedMarginEnd = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    expandedMarginStart = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    expandedMarginTop = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    collapsingTextHelper.setExpandedTextAppearance(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    collapsingTextHelper.setExpandedTextColor(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    collapsingTextHelper.setExpandedTypeface(paramTypeface);
  }
  
  public void setScrimAlpha(int paramInt)
  {
    if (paramInt != scrimAlpha)
    {
      if (contentScrim != null)
      {
        Toolbar localToolbar = toolbar;
        if (localToolbar != null) {
          ViewCompat.postInvalidateOnAnimation(localToolbar);
        }
      }
      scrimAlpha = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    scrimAnimationDuration = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (scrimVisibleHeightTrigger != paramInt)
    {
      scrimVisibleHeightTrigger = paramInt;
      updateScrimVisibility();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    boolean bool;
    if ((ViewCompat.isLaidOut(this)) && (!isInEditMode())) {
      bool = true;
    } else {
      bool = false;
    }
    setScrimsShown(paramBoolean, bool);
  }
  
  public void setScrimsShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (scrimsAreShown != paramBoolean1)
    {
      int i = 255;
      if (paramBoolean2)
      {
        if (!paramBoolean1) {
          i = 0;
        }
        animateScrim(i);
      }
      else
      {
        if (!paramBoolean1) {
          i = 0;
        }
        setScrimAlpha(i);
      }
      scrimsAreShown = paramBoolean1;
    }
  }
  
  public void setStatusBarScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2 = statusBarScrim;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      statusBarScrim = localDrawable1;
      paramDrawable = statusBarScrim;
      if (paramDrawable != null)
      {
        if (paramDrawable.isStateful()) {
          statusBarScrim.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(statusBarScrim, ViewCompat.getLayoutDirection(this));
        paramDrawable = statusBarScrim;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        statusBarScrim.setCallback(this);
        statusBarScrim.setAlpha(scrimAlpha);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    collapsingTextHelper.setText(paramCharSequence);
    updateContentDescriptionFromTitle();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != collapsingTitleEnabled)
    {
      collapsingTitleEnabled = paramBoolean;
      updateContentDescriptionFromTitle();
      updateDummyView();
      requestLayout();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = statusBarScrim;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      statusBarScrim.setVisible(bool, false);
    }
    localDrawable = contentScrim;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      contentScrim.setVisible(bool, false);
    }
  }
  
  public final void updateScrimVisibility()
  {
    if ((contentScrim != null) || (statusBarScrim != null))
    {
      boolean bool;
      if (getHeight() + currentOffset < getScrimVisibleHeightTrigger()) {
        bool = true;
      } else {
        bool = false;
      }
      setScrimsShown(bool);
    }
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == contentScrim) || (paramDrawable == statusBarScrim);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    public static final int COLLAPSE_MODE_OFF = 0;
    public static final int COLLAPSE_MODE_PARALLAX = 2;
    public static final int COLLAPSE_MODE_PIN = 1;
    public static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5F;
    public int collapseMode = 0;
    public float parallaxMult = 0.5F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2, paramInt3);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CollapsingToolbarLayout_Layout);
      collapseMode = paramContext.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
      setParallaxMultiplier(paramContext.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F));
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(FrameLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public int getCollapseMode()
    {
      return collapseMode;
    }
    
    public float getParallaxMultiplier()
    {
      return parallaxMult;
    }
    
    public void setCollapseMode(int paramInt)
    {
      collapseMode = paramInt;
    }
    
    public void setParallaxMultiplier(float paramFloat)
    {
      parallaxMult = paramFloat;
    }
  }
  
  private class OffsetUpdateListener
    implements AppBarLayout.OnOffsetChangedListener
  {
    public OffsetUpdateListener() {}
    
    public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      paramAppBarLayout = CollapsingToolbarLayout.this;
      currentOffset = paramInt;
      paramAppBarLayout = lastInsets;
      int i;
      if (paramAppBarLayout != null) {
        i = paramAppBarLayout.getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      Object localObject1 = CollapsingToolbarLayout.this;
      paramAppBarLayout = this;
      int k = ((ViewGroup)localObject1).getChildCount();
      int j = 0;
      while (j < k)
      {
        Object localObject2 = this$0;
        localObject1 = paramAppBarLayout;
        localObject2 = ((ViewGroup)localObject2).getChildAt(j);
        CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ViewOffsetHelper localViewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper((View)localObject2);
        int m = collapseMode;
        if (m != 1)
        {
          if (m == 2) {
            localViewOffsetHelper.setTopAndBottomOffset(Math.round(-paramInt * parallaxMult));
          }
        }
        else {
          localViewOffsetHelper.setTopAndBottomOffset(MathUtils.constrain(-paramInt, 0, this$0.getMaxOffsetForPinChild((View)localObject2)));
        }
        j += 1;
      }
      this$0.updateScrimVisibility();
      localObject1 = this$0;
      if ((statusBarScrim != null) && (i > 0)) {
        ViewCompat.postInvalidateOnAnimation((View)localObject1);
      }
      j = this$0.getHeight();
      k = ViewCompat.getMinimumHeight(this$0);
      this$0.collapsingTextHelper.setExpansionFraction(Math.abs(paramInt) / (j - k - i));
    }
  }
}
