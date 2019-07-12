package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.design.R.attr;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.design.animation.AnimationUtils;
import android.support.design.internal.ThemeEnforcement;
import android.support.design.internal.ViewUtils;
import android.support.design.resources.MaterialResources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.a;
import android.support.v4.view.ViewPager.d;
import android.support.v4.view.ViewPager.e;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import b.b.a.G;
import b.b.a.N;
import b.b.a.o;
import b.b.x.n.r.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.util.Pools.Pool;
import support.android.v4.util.Pools.SimplePool;
import support.android.v4.util.Pools.SynchronizedPool;
import support.android.v4.view.ByteVector;
import support.android.v4.view.MarginLayoutParamsCompat;
import support.android.v4.view.PagerAdapter;
import support.android.v4.view.ViewCompat;
import support.android.v4.widget.f;

@ViewPager.a
public class TabLayout
  extends HorizontalScrollView
{
  public static final int ANIMATION_DURATION = 300;
  @o(unit=0)
  public static final int DEFAULT_GAP_TEXT_ICON = 8;
  @o(unit=0)
  public static final int DEFAULT_HEIGHT = 48;
  @o(unit=0)
  public static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
  @o(unit=0)
  public static final int FIXED_WRAP_GUTTER_MIN = 16;
  public static final int GRAVITY_CENTER = 1;
  public static final int GRAVITY_FILL = 0;
  public static final int INDICATOR_GRAVITY_BOTTOM = 0;
  public static final int INDICATOR_GRAVITY_CENTER = 1;
  public static final int INDICATOR_GRAVITY_STRETCH = 3;
  public static final int INDICATOR_GRAVITY_TOP = 2;
  public static final int INVALID_WIDTH = -1;
  @o(unit=0)
  public static final int MIN_INDICATOR_WIDTH = 24;
  public static final int MODE_FIXED = 1;
  public static final int MODE_SCROLLABLE = 0;
  @o(unit=0)
  public static final int TAB_MIN_WIDTH_MARGIN = 56;
  public static final r.a<Tab> tabPool = new Pools.SynchronizedPool(16);
  public AdapterChangeListener adapterChangeListener;
  public int contentInsetStart;
  public BaseOnTabSelectedListener currentVpSelectedListener;
  public boolean inlineLabel;
  public int mode;
  public TabLayoutOnPageChangeListener pageChangeListener;
  public PagerAdapter pagerAdapter;
  public DataSetObserver pagerAdapterObserver;
  public final int requestedTabMaxWidth;
  public final int requestedTabMinWidth;
  public ValueAnimator scrollAnimator;
  public final int scrollableTabMinWidth;
  public BaseOnTabSelectedListener selectedListener;
  public final ArrayList<BaseOnTabSelectedListener> selectedListeners = new ArrayList();
  public Tab selectedTab;
  public boolean setupViewPagerImplicitly;
  public final SlidingTabIndicator slidingTabIndicator;
  public final int tabBackgroundResId;
  public int tabGravity;
  public ColorStateList tabIconTint;
  public PorterDuff.Mode tabIconTintMode;
  public int tabIndicatorAnimationDuration;
  public boolean tabIndicatorFullWidth;
  public int tabIndicatorGravity;
  public int tabMaxWidth = Integer.MAX_VALUE;
  public int tabPaddingBottom;
  public int tabPaddingEnd;
  public int tabPaddingStart;
  public int tabPaddingTop;
  public ColorStateList tabRippleColorStateList;
  @G
  public Drawable tabSelectedIndicator;
  public int tabTextAppearance;
  public ColorStateList tabTextColors;
  public float tabTextMultiLineSize;
  public float tabTextSize;
  public final RectF tabViewContentBounds = new RectF();
  public final r.a<TabView> tabViewPool = new Pools.SimplePool(12);
  public final ArrayList<Tab> tabs = new ArrayList();
  public boolean unboundedRipple;
  public ViewPager viewPager;
  
  public TabLayout(Context paramContext)
  {
    this(paramContext, null, R.attr.tabStyle);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.tabStyle);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    slidingTabIndicator = new SlidingTabIndicator(paramContext);
    super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, android.support.design.R.styleable.TabLayout, paramInt, R.style.Widget_Design_TabLayout, new int[] { android.support.design.R.styleable.TabLayout_tabTextAppearance });
    slidingTabIndicator.setSelectedIndicatorHeight(localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabIndicatorHeight, -1));
    slidingTabIndicator.setSelectedIndicatorColor(localTypedArray.getColor(android.support.design.R.styleable.TabLayout_tabIndicatorColor, 0));
    setSelectedTabIndicator(MaterialResources.getDrawable(paramContext, localTypedArray, android.support.design.R.styleable.TabLayout_tabIndicator));
    setSelectedTabIndicatorGravity(localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabIndicatorGravity, 0));
    setTabIndicatorFullWidth(localTypedArray.getBoolean(android.support.design.R.styleable.TabLayout_tabIndicatorFullWidth, true));
    paramInt = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPadding, 0);
    tabPaddingBottom = paramInt;
    tabPaddingEnd = paramInt;
    tabPaddingTop = paramInt;
    tabPaddingStart = paramInt;
    tabPaddingStart = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingStart, tabPaddingStart);
    tabPaddingTop = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingTop, tabPaddingTop);
    tabPaddingEnd = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingEnd, tabPaddingEnd);
    tabPaddingBottom = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingBottom, tabPaddingBottom);
    tabTextAppearance = localTypedArray.getResourceId(android.support.design.R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
    paramAttributeSet = paramContext.obtainStyledAttributes(tabTextAppearance, android.support.v7.appcompat.R.styleable.TextAppearance);
    try
    {
      tabTextSize = paramAttributeSet.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
      tabTextColors = MaterialResources.getColorStateList(paramContext, paramAttributeSet, android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(android.support.design.R.styleable.TabLayout_tabTextColor)) {
        tabTextColors = MaterialResources.getColorStateList(paramContext, localTypedArray, android.support.design.R.styleable.TabLayout_tabTextColor);
      }
      if (localTypedArray.hasValue(android.support.design.R.styleable.TabLayout_tabSelectedTextColor))
      {
        paramInt = localTypedArray.getColor(android.support.design.R.styleable.TabLayout_tabSelectedTextColor, 0);
        tabTextColors = createColorStateList(tabTextColors.getDefaultColor(), paramInt);
      }
      tabIconTint = MaterialResources.getColorStateList(paramContext, localTypedArray, android.support.design.R.styleable.TabLayout_tabIconTint);
      tabIconTintMode = ViewUtils.parseTintMode(localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabIconTintMode, -1), null);
      tabRippleColorStateList = MaterialResources.getColorStateList(paramContext, localTypedArray, android.support.design.R.styleable.TabLayout_tabRippleColor);
      tabIndicatorAnimationDuration = localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
      requestedTabMinWidth = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMinWidth, -1);
      requestedTabMaxWidth = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMaxWidth, -1);
      tabBackgroundResId = localTypedArray.getResourceId(android.support.design.R.styleable.TabLayout_tabBackground, 0);
      contentInsetStart = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabContentStart, 0);
      mode = localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabMode, 1);
      tabGravity = localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabGravity, 0);
      inlineLabel = localTypedArray.getBoolean(android.support.design.R.styleable.TabLayout_tabInlineLabel, false);
      unboundedRipple = localTypedArray.getBoolean(android.support.design.R.styleable.TabLayout_tabUnboundedRipple, false);
      localTypedArray.recycle();
      paramContext = getResources();
      tabTextMultiLineSize = paramContext.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
      scrollableTabMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
      applyModeAndGravity();
      return;
    }
    catch (Throwable paramContext)
    {
      paramAttributeSet.recycle();
      throw paramContext;
    }
  }
  
  private void addTabFromItemView(TabItem paramTabItem)
  {
    Tab localTab = newTab();
    Object localObject = text;
    if (localObject != null) {
      localTab.setText((CharSequence)localObject);
    }
    localObject = icon;
    if (localObject != null) {
      localTab.setIcon((Drawable)localObject);
    }
    int i = customLayout;
    if (i != 0) {
      localTab.setCustomView(i);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription())) {
      localTab.setContentDescription(paramTabItem.getContentDescription());
    }
    addTab(localTab);
  }
  
  private void addTabView(Tab paramTab)
  {
    TabView localTabView = view;
    slidingTabIndicator.addView(localTabView, paramTab.getPosition(), createLayoutParamsForTabs());
  }
  
  private void addViewInternal(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      addTabFromItemView((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private void animateToTab(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (!slidingTabIndicator.childrenNeedLayout()))
    {
      int i = getScrollX();
      int j = calculateScrollXForTab(paramInt, 0.0F);
      if (i != j)
      {
        ensureScrollAnimator();
        scrollAnimator.setIntValues(new int[] { i, j });
        scrollAnimator.start();
      }
      slidingTabIndicator.animateIndicatorToPosition(paramInt, tabIndicatorAnimationDuration);
      return;
    }
    setScrollPosition(paramInt, 0.0F, true);
  }
  
  private void applyModeAndGravity()
  {
    if (mode == 0) {
      i = Math.max(0, contentInsetStart - tabPaddingStart);
    } else {
      i = 0;
    }
    ViewCompat.setPaddingRelative(slidingTabIndicator, i, 0, 0, 0);
    int i = mode;
    if (i != 0)
    {
      if (i == 1) {
        slidingTabIndicator.setGravity(1);
      }
    }
    else {
      slidingTabIndicator.setGravity(8388611);
    }
    updateTabViews(true);
  }
  
  private int calculateScrollXForTab(int paramInt, float paramFloat)
  {
    int j = mode;
    int i = 0;
    if (j == 0)
    {
      View localView2 = slidingTabIndicator.getChildAt(paramInt);
      paramInt += 1;
      View localView1;
      if (paramInt < slidingTabIndicator.getChildCount()) {
        localView1 = slidingTabIndicator.getChildAt(paramInt);
      } else {
        localView1 = null;
      }
      if (localView2 != null) {
        paramInt = localView2.getWidth();
      } else {
        paramInt = 0;
      }
      if (localView1 != null) {
        i = localView1.getWidth();
      }
      j = localView2.getLeft();
      j = paramInt / 2 + j - getWidth() / 2;
      paramInt = (int)((paramInt + i) * 0.5F * paramFloat);
      if (ViewCompat.getLayoutDirection(this) == 0) {
        return j + paramInt;
      }
      return j - paramInt;
    }
    return 0;
  }
  
  private void configureTab(Tab paramTab, int paramInt)
  {
    paramTab.setPosition(paramInt);
    tabs.add(paramInt, paramTab);
    int i = tabs.size();
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= i) {
        break;
      }
      ((Tab)tabs.get(paramInt)).setPosition(paramInt);
    }
  }
  
  public static ColorStateList createColorStateList(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { View.SELECTED_STATE_SET, View.EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private LinearLayout.LayoutParams createLayoutParamsForTabs()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    updateTabViewLayoutParams(localLayoutParams);
    return localLayoutParams;
  }
  
  private TabView createTabView(Tab paramTab)
  {
    Object localObject1 = tabViewPool;
    if (localObject1 != null) {
      localObject1 = (TabView)((Pools.Pool)localObject1).acquire();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new TabView(getContext());
    }
    ((TabView)localObject2).setTab(paramTab);
    ((View)localObject2).setFocusable(true);
    ((View)localObject2).setMinimumWidth(getTabMinWidth());
    if (TextUtils.isEmpty(contentDesc))
    {
      ((View)localObject2).setContentDescription(text);
      return localObject2;
    }
    ((View)localObject2).setContentDescription(contentDesc);
    return localObject2;
  }
  
  private void dispatchTabReselected(Tab paramTab)
  {
    int i = selectedListeners.size() - 1;
    while (i >= 0)
    {
      ((BaseOnTabSelectedListener)selectedListeners.get(i)).onTabReselected(paramTab);
      i -= 1;
    }
  }
  
  private void dispatchTabSelected(Tab paramTab)
  {
    int i = selectedListeners.size() - 1;
    while (i >= 0)
    {
      ((BaseOnTabSelectedListener)selectedListeners.get(i)).onTabSelected(paramTab);
      i -= 1;
    }
  }
  
  private void dispatchTabUnselected(Tab paramTab)
  {
    int i = selectedListeners.size() - 1;
    while (i >= 0)
    {
      ((BaseOnTabSelectedListener)selectedListeners.get(i)).onTabUnselected(paramTab);
      i -= 1;
    }
  }
  
  private void ensureScrollAnimator()
  {
    if (scrollAnimator == null)
    {
      scrollAnimator = new ValueAnimator();
      scrollAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
      scrollAnimator.setDuration(tabIndicatorAnimationDuration);
      scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
        }
      });
    }
  }
  
  private int getDefaultHeight()
  {
    int m = tabs.size();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      Tab localTab = (Tab)tabs.get(i);
      if ((localTab != null) && (localTab.getIcon() != null) && (!TextUtils.isEmpty(localTab.getText())))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if ((j != 0) && (!inlineLabel)) {
      return 72;
    }
    return 48;
  }
  
  private int getTabMinWidth()
  {
    int i = requestedTabMinWidth;
    if (i != -1) {
      return i;
    }
    if (mode == 0) {
      return scrollableTabMinWidth;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, slidingTabIndicator.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void removeTabViewAt(int paramInt)
  {
    TabView localTabView = (TabView)slidingTabIndicator.getChildAt(paramInt);
    slidingTabIndicator.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.reset();
      tabViewPool.release(localTabView);
    }
    requestLayout();
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = slidingTabIndicator.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      while (i < j)
      {
        View localView = slidingTabIndicator.getChildAt(i);
        boolean bool2 = true;
        boolean bool1;
        if (i == paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localView.setSelected(bool1);
        if (i == paramInt) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        localView.setActivated(bool1);
        i += 1;
      }
    }
  }
  
  private void setupWithViewPager(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = viewPager;
    if (localObject != null)
    {
      TabLayoutOnPageChangeListener localTabLayoutOnPageChangeListener = pageChangeListener;
      if (localTabLayoutOnPageChangeListener != null) {
        ((ViewPager)localObject).removeOnPageChangeListener(localTabLayoutOnPageChangeListener);
      }
      localObject = adapterChangeListener;
      if (localObject != null) {
        viewPager.getAdapter((ViewPager.d)localObject);
      }
    }
    localObject = currentVpSelectedListener;
    if (localObject != null)
    {
      removeOnTabSelectedListener((BaseOnTabSelectedListener)localObject);
      currentVpSelectedListener = null;
    }
    if (paramViewPager != null)
    {
      viewPager = paramViewPager;
      if (pageChangeListener == null) {
        pageChangeListener = new TabLayoutOnPageChangeListener(this);
      }
      pageChangeListener.reset();
      paramViewPager.addOnPageChangeListener(pageChangeListener);
      currentVpSelectedListener = new ViewPagerOnTabSelectedListener(paramViewPager);
      addOnTabSelectedListener(currentVpSelectedListener);
      localObject = paramViewPager.getAdapter();
      if (localObject != null) {
        setPagerAdapter((PagerAdapter)localObject, paramBoolean1);
      }
      if (adapterChangeListener == null) {
        adapterChangeListener = new AdapterChangeListener();
      }
      adapterChangeListener.setAutoRefresh(paramBoolean1);
      paramViewPager.setAdapter(adapterChangeListener);
      setScrollPosition(paramViewPager.getCurrentItem(), 0.0F, true);
    }
    else
    {
      viewPager = null;
      setPagerAdapter(null, false);
    }
    setupViewPagerImplicitly = paramBoolean2;
  }
  
  private void updateAllTabs()
  {
    int j = tabs.size();
    int i = 0;
    while (i < j)
    {
      ((Tab)tabs.get(i)).updateView();
      i += 1;
    }
  }
  
  private void updateTabViewLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((mode == 1) && (tabGravity == 0))
    {
      width = 0;
      weight = 1.0F;
      return;
    }
    width = -2;
    weight = 0.0F;
  }
  
  public void addOnTabSelectedListener(BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    if (!selectedListeners.contains(paramBaseOnTabSelectedListener)) {
      selectedListeners.add(paramBaseOnTabSelectedListener);
    }
  }
  
  public void addTab(Tab paramTab)
  {
    addTab(paramTab, tabs.isEmpty());
  }
  
  public void addTab(Tab paramTab, int paramInt)
  {
    addTab(paramTab, paramInt, tabs.isEmpty());
  }
  
  public void addTab(Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (parent == this)
    {
      configureTab(paramTab, paramInt);
      addTabView(paramTab);
      if (paramBoolean) {
        paramTab.select();
      }
    }
    else
    {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
  }
  
  public void addTab(Tab paramTab, boolean paramBoolean)
  {
    addTab(paramTab, tabs.size(), paramBoolean);
  }
  
  public void addView(View paramView)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }
  
  public void clearOnTabSelectedListeners()
  {
    selectedListeners.clear();
  }
  
  public Tab createTabFromPool()
  {
    Tab localTab2 = (Tab)tabPool.acquire();
    Tab localTab1 = localTab2;
    if (localTab2 == null) {
      localTab1 = new Tab();
    }
    return localTab1;
  }
  
  public int dpToPx(int paramInt)
  {
    return Math.round(getResourcesgetDisplayMetricsdensity * paramInt);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    Tab localTab = selectedTab;
    if (localTab != null) {
      return localTab.getPosition();
    }
    return -1;
  }
  
  public Tab getTabAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getTabCount())) {
      return (Tab)tabs.get(paramInt);
    }
    return null;
  }
  
  public int getTabCount()
  {
    return tabs.size();
  }
  
  public int getTabGravity()
  {
    return tabGravity;
  }
  
  public ColorStateList getTabIconTint()
  {
    return tabIconTint;
  }
  
  public int getTabIndicatorGravity()
  {
    return tabIndicatorGravity;
  }
  
  public int getTabMaxWidth()
  {
    return tabMaxWidth;
  }
  
  public int getTabMode()
  {
    return mode;
  }
  
  public ColorStateList getTabRippleColor()
  {
    return tabRippleColorStateList;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return tabSelectedIndicator;
  }
  
  public ColorStateList getTabTextColors()
  {
    return tabTextColors;
  }
  
  public boolean hasUnboundedRipple()
  {
    return unboundedRipple;
  }
  
  public boolean isInlineLabel()
  {
    return inlineLabel;
  }
  
  public boolean isTabIndicatorFullWidth()
  {
    return tabIndicatorFullWidth;
  }
  
  public Tab newTab()
  {
    Tab localTab = createTabFromPool();
    parent = this;
    view = createTabView(localTab);
    return localTab;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (viewPager == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        setupWithViewPager((ViewPager)localViewParent, true, true);
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (setupViewPagerImplicitly)
    {
      setupWithViewPager(null);
      setupViewPagerImplicitly = false;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < slidingTabIndicator.getChildCount())
    {
      View localView = slidingTabIndicator.getChildAt(i);
      if ((localView instanceof TabView)) {
        TabView.access$300((TabView)localView, paramCanvas);
      }
      i += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = dpToPx(getDefaultHeight());
    int j = getPaddingTop();
    i = getPaddingBottom() + (j + i);
    j = View.MeasureSpec.getMode(paramInt2);
    if (j != Integer.MIN_VALUE)
    {
      if (j == 0) {
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      }
    }
    else {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
    }
    j = View.MeasureSpec.getSize(paramInt1);
    if (View.MeasureSpec.getMode(paramInt1) != 0)
    {
      i = requestedTabMaxWidth;
      if (i <= 0) {
        i = j - dpToPx(56);
      }
      tabMaxWidth = i;
    }
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() == 1)
    {
      paramInt1 = 0;
      View localView = getChildAt(0);
      i = mode;
      if (i != 0)
      {
        if ((i != 1) || (localView.getMeasuredWidth() == getMeasuredWidth())) {}
      }
      else {
        while (localView.getMeasuredWidth() < getMeasuredWidth())
        {
          paramInt1 = 1;
          break;
        }
      }
      if (paramInt1 != 0)
      {
        paramInt1 = getPaddingTop();
        paramInt1 = ViewGroup.getChildMeasureSpec(paramInt2, getPaddingBottom() + paramInt1, getLayoutParamsheight);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
    }
  }
  
  public void populateFromPagerAdapter()
  {
    removeAllTabs();
    Object localObject = pagerAdapter;
    if (localObject != null)
    {
      int j = ((PagerAdapter)localObject).getCount();
      int i = 0;
      while (i < j)
      {
        addTab(newTab().setText(pagerAdapter.getPageTitle(i)), false);
        i += 1;
      }
      localObject = viewPager;
      if ((localObject != null) && (j > 0))
      {
        i = ((ViewPager)localObject).getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          selectTab(getTabAt(i));
        }
      }
    }
  }
  
  public boolean releaseFromTabPool(Tab paramTab)
  {
    return tabPool.release(paramTab);
  }
  
  public void removeAllTabs()
  {
    int i = slidingTabIndicator.getChildCount() - 1;
    while (i >= 0)
    {
      removeTabViewAt(i);
      i -= 1;
    }
    Iterator localIterator = tabs.iterator();
    while (localIterator.hasNext())
    {
      Tab localTab = (Tab)localIterator.next();
      localIterator.remove();
      localTab.reset();
      releaseFromTabPool(localTab);
    }
    selectedTab = null;
  }
  
  public void removeOnTabSelectedListener(BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    selectedListeners.remove(paramBaseOnTabSelectedListener);
  }
  
  public void removeTab(Tab paramTab)
  {
    if (parent == this)
    {
      removeTabAt(paramTab.getPosition());
      return;
    }
    throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
  }
  
  public void removeTabAt(int paramInt)
  {
    Tab localTab = selectedTab;
    int i;
    if (localTab != null) {
      i = localTab.getPosition();
    } else {
      i = 0;
    }
    removeTabViewAt(paramInt);
    localTab = (Tab)tabs.remove(paramInt);
    if (localTab != null)
    {
      localTab.reset();
      releaseFromTabPool(localTab);
    }
    int k = tabs.size();
    int j = paramInt;
    while (j < k)
    {
      ((Tab)tabs.get(j)).setPosition(j);
      j += 1;
    }
    if (i == paramInt)
    {
      if (tabs.isEmpty()) {
        localTab = null;
      } else {
        localTab = (Tab)tabs.get(Math.max(0, paramInt - 1));
      }
      selectTab(localTab);
    }
  }
  
  public void selectTab(Tab paramTab)
  {
    selectTab(paramTab, true);
  }
  
  public void selectTab(Tab paramTab, boolean paramBoolean)
  {
    Tab localTab = selectedTab;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        dispatchTabReselected(paramTab);
        animateToTab(paramTab.getPosition());
      }
    }
    else
    {
      int i;
      if (paramTab != null) {
        i = paramTab.getPosition();
      } else {
        i = -1;
      }
      if (paramBoolean)
      {
        if (((localTab == null) || (localTab.getPosition() == -1)) && (i != -1)) {
          setScrollPosition(i, 0.0F, true);
        } else {
          animateToTab(i);
        }
        if (i != -1) {
          setSelectedTabView(i);
        }
      }
      selectedTab = paramTab;
      if (localTab != null) {
        dispatchTabUnselected(localTab);
      }
      if (paramTab != null) {
        dispatchTabSelected(paramTab);
      }
    }
  }
  
  public void setInlineLabel(boolean paramBoolean)
  {
    if (inlineLabel != paramBoolean)
    {
      inlineLabel = paramBoolean;
      int i = 0;
      while (i < slidingTabIndicator.getChildCount())
      {
        View localView = slidingTabIndicator.getChildAt(i);
        if ((localView instanceof TabView)) {
          ((TabView)localView).updateOrientation();
        }
        i += 1;
      }
      applyModeAndGravity();
    }
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  public void setOnTabSelectedListener(BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    BaseOnTabSelectedListener localBaseOnTabSelectedListener = selectedListener;
    if (localBaseOnTabSelectedListener != null) {
      removeOnTabSelectedListener(localBaseOnTabSelectedListener);
    }
    selectedListener = paramBaseOnTabSelectedListener;
    if (paramBaseOnTabSelectedListener != null) {
      addOnTabSelectedListener(paramBaseOnTabSelectedListener);
    }
  }
  
  public void setPagerAdapter(PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    PagerAdapter localPagerAdapter = pagerAdapter;
    if (localPagerAdapter != null)
    {
      DataSetObserver localDataSetObserver = pagerAdapterObserver;
      if (localDataSetObserver != null) {
        localPagerAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    pagerAdapter = paramPagerAdapter;
    if ((paramBoolean) && (paramPagerAdapter != null))
    {
      if (pagerAdapterObserver == null) {
        pagerAdapterObserver = new PagerAdapterObserver();
      }
      paramPagerAdapter.registerDataSetObserver(pagerAdapterObserver);
    }
    populateFromPagerAdapter();
  }
  
  public void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    ensureScrollAnimator();
    scrollAnimator.addListener(paramAnimatorListener);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    setScrollPosition(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramInt + paramFloat);
    if (i >= 0)
    {
      if (i >= slidingTabIndicator.getChildCount()) {
        return;
      }
      if (paramBoolean2) {
        slidingTabIndicator.setIndicatorPositionFromTabPosition(paramInt, paramFloat);
      }
      ValueAnimator localValueAnimator = scrollAnimator;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        scrollAnimator.cancel();
      }
      scrollTo(calculateScrollXForTab(paramInt, paramFloat), 0);
      if (paramBoolean1) {
        setSelectedTabView(i);
      }
    }
  }
  
  public void setSelectedTabIndicator(int paramInt)
  {
    if (paramInt != 0)
    {
      setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), paramInt));
      return;
    }
    setSelectedTabIndicator(null);
  }
  
  public void setSelectedTabIndicator(Drawable paramDrawable)
  {
    if (tabSelectedIndicator != paramDrawable)
    {
      tabSelectedIndicator = paramDrawable;
      ViewCompat.postInvalidateOnAnimation(slidingTabIndicator);
    }
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    slidingTabIndicator.setSelectedIndicatorColor(paramInt);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (tabIndicatorGravity != paramInt)
    {
      tabIndicatorGravity = paramInt;
      ViewCompat.postInvalidateOnAnimation(slidingTabIndicator);
    }
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    slidingTabIndicator.setSelectedIndicatorHeight(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (tabGravity != paramInt)
    {
      tabGravity = paramInt;
      applyModeAndGravity();
    }
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    if (tabIconTint != paramColorStateList)
    {
      tabIconTint = paramColorStateList;
      updateAllTabs();
    }
  }
  
  public void setTabIconTintResource(int paramInt)
  {
    setTabIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    tabIndicatorFullWidth = paramBoolean;
    ViewCompat.postInvalidateOnAnimation(slidingTabIndicator);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != mode)
    {
      mode = paramInt;
      applyModeAndGravity();
    }
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    if (tabRippleColorStateList != paramColorStateList)
    {
      tabRippleColorStateList = paramColorStateList;
      int i = 0;
      while (i < slidingTabIndicator.getChildCount())
      {
        paramColorStateList = slidingTabIndicator.getChildAt(i);
        if ((paramColorStateList instanceof TabView)) {
          TabView.access$000((TabView)paramColorStateList, getContext());
        }
        i += 1;
      }
    }
  }
  
  public void setTabRippleColorResource(int paramInt)
  {
    setTabRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(createColorStateList(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (tabTextColors != paramColorStateList)
    {
      tabTextColors = paramColorStateList;
      updateAllTabs();
    }
  }
  
  public void setTabsFromPagerAdapter(PagerAdapter paramPagerAdapter)
  {
    setPagerAdapter(paramPagerAdapter, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (unboundedRipple != paramBoolean)
    {
      unboundedRipple = paramBoolean;
      int i = 0;
      while (i < slidingTabIndicator.getChildCount())
      {
        View localView = slidingTabIndicator.getChildAt(i);
        if ((localView instanceof TabView)) {
          TabView.access$000((TabView)localView, getContext());
        }
        i += 1;
      }
    }
  }
  
  public void setUnboundedRippleResource(int paramInt)
  {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    setupWithViewPager(paramViewPager, true);
  }
  
  public void setupWithViewPager(ViewPager paramViewPager, boolean paramBoolean)
  {
    setupWithViewPager(paramViewPager, paramBoolean, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }
  
  public void updateTabViews(boolean paramBoolean)
  {
    int i = 0;
    while (i < slidingTabIndicator.getChildCount())
    {
      View localView = slidingTabIndicator.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      updateTabViewLayoutParams((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
  }
  
  private class AdapterChangeListener
    implements ViewPager.d
  {
    public boolean autoRefresh;
    
    public AdapterChangeListener() {}
    
    public void onAdapterChanged(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
    {
      paramPagerAdapter1 = TabLayout.this;
      if (viewPager == paramViewPager) {
        paramPagerAdapter1.setPagerAdapter(paramPagerAdapter2, autoRefresh);
      }
    }
    
    public void setAutoRefresh(boolean paramBoolean)
    {
      autoRefresh = paramBoolean;
    }
  }
  
  public static abstract interface BaseOnTabSelectedListener<T extends TabLayout.Tab>
  {
    public abstract void onTabReselected(TabLayout.Tab paramTab);
    
    public abstract void onTabSelected(TabLayout.Tab paramTab);
    
    public abstract void onTabUnselected(TabLayout.Tab paramTab);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface Mode {}
  
  public static abstract interface OnTabSelectedListener
    extends TabLayout.BaseOnTabSelectedListener<TabLayout.Tab>
  {}
  
  private class PagerAdapterObserver
    extends DataSetObserver
  {
    public PagerAdapterObserver() {}
    
    public void onChanged()
    {
      populateFromPagerAdapter();
    }
    
    public void onInvalidated()
    {
      populateFromPagerAdapter();
    }
  }
  
  private class SlidingTabIndicator
    extends LinearLayout
  {
    public final GradientDrawable defaultSelectionIndicator;
    public ValueAnimator indicatorAnimator;
    public int indicatorLeft = -1;
    public int indicatorRight = -1;
    public int layoutDirection = -1;
    public int selectedIndicatorHeight;
    public final Paint selectedIndicatorPaint;
    public int selectedPosition = -1;
    public float selectionOffset;
    
    public SlidingTabIndicator(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      selectedIndicatorPaint = new Paint();
      defaultSelectionIndicator = new GradientDrawable();
    }
    
    private void calculateTabViewContentBounds(TabLayout.TabView paramTabView, RectF paramRectF)
    {
      int j = TabLayout.TabView.access$500(paramTabView);
      int i = j;
      if (j < dpToPx(24)) {
        i = dpToPx(24);
      }
      j = paramTabView.getLeft();
      j = (paramTabView.getRight() + j) / 2;
      i /= 2;
      paramRectF.set(j - i, 0.0F, j + i, 0.0F);
    }
    
    private void updateIndicatorPosition()
    {
      View localView = getChildAt(selectedPosition);
      int k;
      int m;
      if ((localView != null) && (localView.getWidth() > 0))
      {
        k = localView.getLeft();
        m = localView.getRight();
        TabLayout localTabLayout = TabLayout.this;
        int j = k;
        int i = m;
        if (!tabIndicatorFullWidth)
        {
          j = k;
          i = m;
          if ((localView instanceof TabLayout.TabView))
          {
            calculateTabViewContentBounds((TabLayout.TabView)localView, TabLayout.access$400(localTabLayout));
            j = (int)access$400left;
            i = (int)access$400right;
          }
        }
        k = j;
        m = i;
        if (selectionOffset > 0.0F)
        {
          k = j;
          m = i;
          if (selectedPosition < getChildCount() - 1)
          {
            localView = getChildAt(selectedPosition + 1);
            int n = localView.getLeft();
            int i1 = localView.getRight();
            localTabLayout = TabLayout.this;
            m = n;
            k = i1;
            if (!tabIndicatorFullWidth)
            {
              m = n;
              k = i1;
              if ((localView instanceof TabLayout.TabView))
              {
                calculateTabViewContentBounds((TabLayout.TabView)localView, TabLayout.access$400(localTabLayout));
                m = (int)access$400left;
                k = (int)access$400right;
              }
            }
            float f1 = selectionOffset;
            float f2 = m;
            j = (int)((1.0F - f1) * j + f2 * f1);
            f2 = k;
            m = (int)((1.0F - f1) * i + f2 * f1);
            k = j;
          }
        }
      }
      else
      {
        k = -1;
        m = -1;
      }
      setIndicatorPosition(k, m);
    }
    
    public void animateIndicatorToPosition(final int paramInt1, int paramInt2)
    {
      Object localObject = indicatorAnimator;
      if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
        indicatorAnimator.cancel();
      }
      localObject = getChildAt(paramInt1);
      if (localObject == null)
      {
        updateIndicatorPosition();
        return;
      }
      final int k = ((View)localObject).getLeft();
      final int m = ((View)localObject).getRight();
      TabLayout localTabLayout = TabLayout.this;
      final int j = k;
      final int i = m;
      if (!tabIndicatorFullWidth)
      {
        j = k;
        i = m;
        if ((localObject instanceof TabLayout.TabView))
        {
          calculateTabViewContentBounds((TabLayout.TabView)localObject, TabLayout.access$400(localTabLayout));
          j = (int)access$400left;
          i = (int)access$400right;
        }
      }
      k = indicatorLeft;
      m = indicatorRight;
      if ((k != j) || (m != i))
      {
        localObject = new ValueAnimator();
        indicatorAnimator = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            float f = paramAnonymousValueAnimator.getAnimatedFraction();
            setIndicatorPosition(AnimationUtils.lerp(k, j, f), AnimationUtils.lerp(m, i, f));
          }
        });
        ((Animator)localObject).addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramAnonymousAnimator = TabLayout.SlidingTabIndicator.this;
            selectedPosition = paramInt1;
            selectionOffset = 0.0F;
          }
        });
        ((ValueAnimator)localObject).start();
      }
    }
    
    public boolean childrenNeedLayout()
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        if (getChildAt(i).getWidth() <= 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public void draw(Canvas paramCanvas)
    {
      Object localObject = tabSelectedIndicator;
      int k = 0;
      int i;
      if (localObject != null) {
        i = ((Drawable)localObject).getIntrinsicHeight();
      } else {
        i = 0;
      }
      int j = selectedIndicatorHeight;
      if (j >= 0) {
        i = j;
      }
      int m = tabIndicatorGravity;
      if (m != 0)
      {
        if (m != 1)
        {
          j = k;
          if (m != 2) {
            if (m != 3)
            {
              i = 0;
              j = k;
            }
            else
            {
              i = getHeight();
              j = k;
            }
          }
        }
        else
        {
          j = (getHeight() - i) / 2;
          i = (getHeight() + i) / 2;
        }
      }
      else
      {
        j = getHeight() - i;
        i = getHeight();
      }
      k = indicatorLeft;
      if ((k >= 0) && (indicatorRight > k))
      {
        localObject = tabSelectedIndicator;
        if (localObject == null) {
          localObject = defaultSelectionIndicator;
        }
        localObject = DrawableCompat.wrap((Drawable)localObject);
        ((Drawable)localObject).setBounds(indicatorLeft, j, indicatorRight, i);
        Paint localPaint = selectedIndicatorPaint;
        if (localPaint != null) {
          if (Build.VERSION.SDK_INT == 21) {
            ((Drawable)localObject).setColorFilter(localPaint.getColor(), PorterDuff.Mode.SRC_IN);
          } else {
            DrawableCompat.setTint((Drawable)localObject, localPaint.getColor());
          }
        }
        ((Drawable)localObject).draw(paramCanvas);
      }
      super.draw(paramCanvas);
    }
    
    public float getIndicatorPosition()
    {
      return selectedPosition + selectionOffset;
    }
    
    public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      ValueAnimator localValueAnimator = indicatorAnimator;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
      {
        indicatorAnimator.cancel();
        long l = indicatorAnimator.getDuration();
        animateIndicatorToPosition(selectedPosition, Math.round((1.0F - indicatorAnimator.getAnimatedFraction()) * (float)l));
        return;
      }
      updateIndicatorPosition();
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
        return;
      }
      Object localObject = TabLayout.this;
      int i = mode;
      int m = 1;
      if ((i == 1) && (tabGravity == 1))
      {
        int i1 = getChildCount();
        int n = 0;
        i = 0;
        int k;
        for (int j = 0; i < i1; j = k)
        {
          localObject = getChildAt(i);
          k = j;
          if (((View)localObject).getVisibility() == 0) {
            k = Math.max(j, ((View)localObject).getMeasuredWidth());
          }
          i += 1;
        }
        if (j <= 0) {
          return;
        }
        i = dpToPx(16);
        if (j * i1 <= getMeasuredWidth() - i * 2)
        {
          i = 0;
          k = n;
          while (k < i1)
          {
            localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
            if ((width != j) || (weight != 0.0F))
            {
              width = j;
              weight = 0.0F;
              i = 1;
            }
            k += 1;
          }
        }
        else
        {
          localObject = TabLayout.this;
          tabGravity = 0;
          ((TabLayout)localObject).updateTabViews(false);
          i = m;
        }
        if (i != 0) {
          super.onMeasure(paramInt1, paramInt2);
        }
      }
    }
    
    public void onRtlPropertiesChanged(int paramInt)
    {
      super.onRtlPropertiesChanged(paramInt);
      if ((Build.VERSION.SDK_INT < 23) && (layoutDirection != paramInt))
      {
        requestLayout();
        layoutDirection = paramInt;
      }
    }
    
    public void setIndicatorPosition(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != indicatorLeft) || (paramInt2 != indicatorRight))
      {
        indicatorLeft = paramInt1;
        indicatorRight = paramInt2;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    public void setIndicatorPositionFromTabPosition(int paramInt, float paramFloat)
    {
      ValueAnimator localValueAnimator = indicatorAnimator;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        indicatorAnimator.cancel();
      }
      selectedPosition = paramInt;
      selectionOffset = paramFloat;
      updateIndicatorPosition();
    }
    
    public void setSelectedIndicatorColor(int paramInt)
    {
      if (selectedIndicatorPaint.getColor() != paramInt)
      {
        selectedIndicatorPaint.setColor(paramInt);
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    public void setSelectedIndicatorHeight(int paramInt)
    {
      if (selectedIndicatorHeight != paramInt)
      {
        selectedIndicatorHeight = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
  }
  
  public static class Tab
  {
    public static final int INVALID_POSITION = -1;
    public CharSequence contentDesc;
    public View customView;
    public Drawable icon;
    public Object mTag;
    public TabLayout parent;
    public int position = -1;
    public CharSequence text;
    public TabLayout.TabView view;
    
    public Tab() {}
    
    public CharSequence getContentDescription()
    {
      TabLayout.TabView localTabView = view;
      if (localTabView == null) {
        return null;
      }
      return localTabView.getContentDescription();
    }
    
    public View getCustomView()
    {
      return customView;
    }
    
    public Drawable getIcon()
    {
      return icon;
    }
    
    public int getPosition()
    {
      return position;
    }
    
    public Object getTag()
    {
      return mTag;
    }
    
    public CharSequence getText()
    {
      return text;
    }
    
    public boolean isSelected()
    {
      TabLayout localTabLayout = parent;
      if (localTabLayout != null) {
        return localTabLayout.getSelectedTabPosition() == position;
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public void reset()
    {
      parent = null;
      view = null;
      mTag = null;
      icon = null;
      text = null;
      contentDesc = null;
      position = -1;
      customView = null;
    }
    
    public void select()
    {
      TabLayout localTabLayout = parent;
      if (localTabLayout != null)
      {
        localTabLayout.selectTab(this);
        return;
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public Tab setContentDescription(int paramInt)
    {
      TabLayout localTabLayout = parent;
      if (localTabLayout != null) {
        return setContentDescription(localTabLayout.getResources().getText(paramInt));
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public Tab setContentDescription(CharSequence paramCharSequence)
    {
      contentDesc = paramCharSequence;
      updateView();
      return this;
    }
    
    public Tab setCustomView(int paramInt)
    {
      return setCustomView(LayoutInflater.from(view.getContext()).inflate(paramInt, view, false));
    }
    
    public Tab setCustomView(View paramView)
    {
      customView = paramView;
      updateView();
      return this;
    }
    
    public Tab setIcon(int paramInt)
    {
      TabLayout localTabLayout = parent;
      if (localTabLayout != null) {
        return setIcon(AppCompatResources.getDrawable(localTabLayout.getContext(), paramInt));
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public Tab setIcon(Drawable paramDrawable)
    {
      icon = paramDrawable;
      updateView();
      return this;
    }
    
    public void setPosition(int paramInt)
    {
      position = paramInt;
    }
    
    public Tab setTag(Object paramObject)
    {
      mTag = paramObject;
      return this;
    }
    
    public Tab setText(int paramInt)
    {
      TabLayout localTabLayout = parent;
      if (localTabLayout != null) {
        return setText(localTabLayout.getResources().getText(paramInt));
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public Tab setText(CharSequence paramCharSequence)
    {
      if ((TextUtils.isEmpty(contentDesc)) && (!TextUtils.isEmpty(paramCharSequence))) {
        view.setContentDescription(paramCharSequence);
      }
      text = paramCharSequence;
      updateView();
      return this;
    }
    
    public void updateView()
    {
      TabLayout.TabView localTabView = view;
      if (localTabView != null) {
        localTabView.update();
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface TabGravity {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface TabIndicatorGravity {}
  
  public static class TabLayoutOnPageChangeListener
    implements ViewPager.e
  {
    public int previousScrollState;
    public int scrollState;
    public final WeakReference<TabLayout> tabLayoutRef;
    
    public TabLayoutOnPageChangeListener(TabLayout paramTabLayout)
    {
      tabLayoutRef = new WeakReference(paramTabLayout);
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      previousScrollState = scrollState;
      scrollState = paramInt;
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      TabLayout localTabLayout = (TabLayout)tabLayoutRef.get();
      if (localTabLayout != null)
      {
        paramInt2 = scrollState;
        boolean bool2 = false;
        boolean bool1;
        if ((paramInt2 == 2) && (previousScrollState != 1)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if ((scrollState != 2) || (previousScrollState != 0)) {
          bool2 = true;
        }
        localTabLayout.setScrollPosition(paramInt1, paramFloat, bool1, bool2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      TabLayout localTabLayout = (TabLayout)tabLayoutRef.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount()))
      {
        int i = scrollState;
        boolean bool;
        if ((i != 0) && ((i != 2) || (previousScrollState != 0))) {
          bool = false;
        } else {
          bool = true;
        }
        localTabLayout.selectTab(localTabLayout.getTabAt(paramInt), bool);
      }
    }
    
    public void reset()
    {
      scrollState = 0;
      previousScrollState = 0;
    }
  }
  
  public class TabView
    extends LinearLayout
  {
    @G
    public Drawable baseBackgroundDrawable;
    public ImageView customIconView;
    public TextView customTextView;
    public View customView;
    public int defaultMaxLines = 2;
    public ImageView iconView;
    public TabLayout.Tab mTab;
    public TextView textView;
    
    public TabView(Context paramContext)
    {
      super();
      updateBackgroundDrawable(paramContext);
      ViewCompat.setPaddingRelative(this, tabPaddingStart, tabPaddingTop, tabPaddingEnd, tabPaddingBottom);
      setGravity(17);
      setOrientation(inlineLabel ^ true);
      setClickable(true);
      ViewCompat.a(this, ByteVector.a(getContext(), 1002));
    }
    
    private float approximateLineWidth(Layout paramLayout, int paramInt, float paramFloat)
    {
      float f = paramLayout.getLineWidth(paramInt);
      return paramFloat / paramLayout.getPaint().getTextSize() * f;
    }
    
    private void drawBackground(Canvas paramCanvas)
    {
      Drawable localDrawable = baseBackgroundDrawable;
      if (localDrawable != null)
      {
        localDrawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
        baseBackgroundDrawable.draw(paramCanvas);
      }
    }
    
    private int getContentWidth()
    {
      View[] arrayOfView = new View[3];
      Object localObject = textView;
      int k = 0;
      arrayOfView[0] = localObject;
      arrayOfView[1] = iconView;
      arrayOfView[2] = customView;
      int i3 = arrayOfView.length;
      int m = 0;
      int i = 0;
      int n;
      for (int j = 0; k < i3; j = n)
      {
        localObject = arrayOfView[k];
        int i2 = m;
        int i1 = i;
        n = j;
        if (localObject != null)
        {
          i2 = m;
          i1 = i;
          n = j;
          if (((View)localObject).getVisibility() == 0)
          {
            if (j != 0) {
              i = Math.min(i, ((View)localObject).getLeft());
            } else {
              i = ((View)localObject).getLeft();
            }
            if (j != 0) {
              j = Math.max(m, ((View)localObject).getRight());
            } else {
              j = ((View)localObject).getRight();
            }
            n = 1;
            i1 = i;
            i2 = j;
          }
        }
        k += 1;
        m = i2;
        i = i1;
      }
      return m - i;
    }
    
    private void updateBackgroundDrawable(Context paramContext)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
    }
    
    private void updateTextAndIcon(TextView paramTextView, ImageView paramImageView)
    {
      Object localObject1 = mTab;
      if ((localObject1 != null) && (((TabLayout.Tab)localObject1).getIcon() != null)) {
        localObject1 = DrawableCompat.wrap(mTab.getIcon()).mutate();
      } else {
        localObject1 = null;
      }
      Object localObject2 = mTab;
      if (localObject2 != null) {
        localObject2 = ((TabLayout.Tab)localObject2).getText();
      } else {
        localObject2 = null;
      }
      if (paramImageView != null) {
        if (localObject1 != null)
        {
          paramImageView.setImageDrawable((Drawable)localObject1);
          paramImageView.setVisibility(0);
          setVisibility(0);
        }
        else
        {
          paramImageView.setVisibility(8);
          paramImageView.setImageDrawable(null);
        }
      }
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
      if (paramTextView != null) {
        if (bool)
        {
          paramTextView.setText((CharSequence)localObject2);
          paramTextView.setVisibility(0);
          setVisibility(0);
        }
        else
        {
          paramTextView.setVisibility(8);
          paramTextView.setText(null);
        }
      }
      if (paramImageView != null)
      {
        paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
        int i;
        if ((bool) && (paramImageView.getVisibility() == 0)) {
          i = dpToPx(8);
        } else {
          i = 0;
        }
        if (inlineLabel)
        {
          if (i != MarginLayoutParamsCompat.getMarginEnd(paramTextView))
          {
            int j = Build.VERSION.SDK_INT;
            paramTextView.setMarginEnd(i);
            bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
        }
        else if (i != bottomMargin)
        {
          bottomMargin = i;
          i = Build.VERSION.SDK_INT;
          paramTextView.setMarginEnd(0);
          paramImageView.setLayoutParams(paramTextView);
          paramImageView.requestLayout();
        }
      }
      paramTextView = mTab;
      if (paramTextView != null) {
        paramTextView = contentDesc;
      } else {
        paramTextView = null;
      }
      if (bool) {
        paramTextView = null;
      }
      TooltipCompat.setTooltipText(this, paramTextView);
    }
    
    public void drawableStateChanged()
    {
      super.drawableStateChanged();
      int[] arrayOfInt = getDrawableState();
      Drawable localDrawable = baseBackgroundDrawable;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localDrawable != null)
      {
        bool1 = bool2;
        if (localDrawable.isStateful()) {
          bool1 = false | baseBackgroundDrawable.setState(arrayOfInt);
        }
      }
      if (bool1)
      {
        invalidate();
        invalidate();
      }
    }
    
    public TabLayout.Tab getTab()
    {
      return mTab;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      int j = View.MeasureSpec.getSize(paramInt1);
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = getTabMaxWidth();
      int i = paramInt1;
      if (m > 0) {
        if (k != 0)
        {
          i = paramInt1;
          if (j <= m) {}
        }
        else
        {
          i = View.MeasureSpec.makeMeasureSpec(tabMaxWidth, Integer.MIN_VALUE);
        }
      }
      super.onMeasure(i, paramInt2);
      if (textView != null)
      {
        float f2 = tabTextSize;
        j = defaultMaxLines;
        Object localObject = iconView;
        k = 1;
        float f1;
        if ((localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          paramInt1 = 1;
          f1 = f2;
        }
        else
        {
          localObject = textView;
          paramInt1 = j;
          f1 = f2;
          if (localObject != null)
          {
            paramInt1 = j;
            f1 = f2;
            if (((TextView)localObject).getLineCount() > 1)
            {
              f1 = tabTextMultiLineSize;
              paramInt1 = j;
            }
          }
        }
        f2 = textView.getTextSize();
        m = textView.getLineCount();
        j = f.getMaxLines(textView);
        if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
        {
          j = k;
          if (mode == 1)
          {
            j = k;
            if (f1 > f2)
            {
              j = k;
              if (m == 1)
              {
                localObject = textView.getLayout();
                if (localObject != null)
                {
                  j = k;
                  if (approximateLineWidth((Layout)localObject, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
                }
                else
                {
                  j = 0;
                }
              }
            }
          }
          if (j != 0)
          {
            textView.setTextSize(0, f1);
            textView.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
      }
    }
    
    public boolean performClick()
    {
      boolean bool = super.performClick();
      if (mTab != null)
      {
        if (!bool) {
          playSoundEffect(0);
        }
        mTab.select();
        return true;
      }
      return bool;
    }
    
    public void reset()
    {
      setTab(null);
      setSelected(false);
    }
    
    public void setSelected(boolean paramBoolean)
    {
      int i;
      if (isSelected() != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean)) {
        i = Build.VERSION.SDK_INT;
      }
      Object localObject = textView;
      if (localObject != null) {
        ((TextView)localObject).setSelected(paramBoolean);
      }
      localObject = iconView;
      if (localObject != null) {
        ((ImageView)localObject).setSelected(paramBoolean);
      }
      localObject = customView;
      if (localObject != null) {
        ((View)localObject).setSelected(paramBoolean);
      }
    }
    
    public void setTab(TabLayout.Tab paramTab)
    {
      if (paramTab != mTab)
      {
        mTab = paramTab;
        update();
      }
    }
    
    public final void update()
    {
      TabLayout.Tab localTab = mTab;
      PorterDuff.Mode localMode = null;
      if (localTab != null) {
        localObject1 = localTab.getCustomView();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        Object localObject2 = ((View)localObject1).getParent();
        if (localObject2 != this)
        {
          if (localObject2 != null) {
            ((ViewGroup)localObject2).removeView((View)localObject1);
          }
          addView((View)localObject1);
        }
        customView = ((View)localObject1);
        localObject2 = textView;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = iconView;
        if (localObject2 != null)
        {
          ((ImageView)localObject2).setVisibility(8);
          iconView.setImageDrawable(null);
        }
        customTextView = ((TextView)((View)localObject1).findViewById(16908308));
        localObject2 = customTextView;
        if (localObject2 != null) {
          defaultMaxLines = f.getMaxLines((TextView)localObject2);
        }
        customIconView = ((ImageView)((View)localObject1).findViewById(16908294));
      }
      else
      {
        localObject1 = customView;
        if (localObject1 != null)
        {
          removeView((View)localObject1);
          customView = null;
        }
        customTextView = null;
        customIconView = null;
      }
      Object localObject1 = customView;
      boolean bool2 = false;
      if (localObject1 == null)
      {
        if (iconView == null)
        {
          localObject1 = (ImageView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
          addView((View)localObject1, 0);
          iconView = ((ImageView)localObject1);
        }
        localObject1 = localMode;
        if (localTab != null)
        {
          localObject1 = localMode;
          if (localTab.getIcon() != null) {
            localObject1 = DrawableCompat.wrap(localTab.getIcon()).mutate();
          }
        }
        if (localObject1 != null)
        {
          DrawableCompat.setTintList((Drawable)localObject1, tabIconTint);
          localMode = tabIconTintMode;
          if (localMode != null) {
            DrawableCompat.setTintMode((Drawable)localObject1, localMode);
          }
        }
        if (textView == null)
        {
          localObject1 = (TextView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
          addView((View)localObject1);
          textView = ((TextView)localObject1);
          defaultMaxLines = f.getMaxLines(textView);
        }
        f.setTextAppearance(textView, tabTextAppearance);
        localObject1 = tabTextColors;
        if (localObject1 != null) {
          textView.setTextColor((ColorStateList)localObject1);
        }
        updateTextAndIcon(textView, iconView);
      }
      else if ((customTextView != null) || (customIconView != null))
      {
        updateTextAndIcon(customTextView, customIconView);
      }
      if ((localTab != null) && (!TextUtils.isEmpty(contentDesc))) {
        setContentDescription(contentDesc);
      }
      boolean bool1 = bool2;
      if (localTab != null)
      {
        bool1 = bool2;
        if (localTab.isSelected()) {
          bool1 = true;
        }
      }
      setSelected(bool1);
    }
    
    public final void updateOrientation()
    {
      setOrientation(inlineLabel ^ true);
      if ((customTextView == null) && (customIconView == null))
      {
        updateTextAndIcon(textView, iconView);
        return;
      }
      updateTextAndIcon(customTextView, customIconView);
    }
  }
  
  public static class ViewPagerOnTabSelectedListener
    implements TabLayout.OnTabSelectedListener
  {
    public final ViewPager viewPager;
    
    public ViewPagerOnTabSelectedListener(ViewPager paramViewPager)
    {
      viewPager = paramViewPager;
    }
    
    public void onTabReselected(TabLayout.Tab paramTab) {}
    
    public void onTabSelected(TabLayout.Tab paramTab)
    {
      viewPager.setCurrentItem(paramTab.getPosition());
    }
    
    public void onTabUnselected(TabLayout.Tab paramTab) {}
  }
}
