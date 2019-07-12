package com.github.clans.fab;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import f.commons.data.general.ButtonFloat.1;
import f.commons.data.general.DayFragment.1;
import f.commons.data.general.EventInfoFragment.1;
import f.commons.data.general.FloatingActionMenu.1;
import f.commons.data.general.FloatingActionMenu.2;
import f.commons.data.general.FloatingActionMenu.3;
import f.commons.data.general.FloatingActionMenu.5;
import f.commons.data.general.FloatingActionMenu.7;
import f.commons.data.general.LogBrokerMonitor.2;
import f.commons.data.general.R.anim;
import f.commons.data.general.R.dimen;
import f.commons.data.general.R.drawable;
import f.commons.data.general.R.id;
import f.commons.data.general.R.styleable;
import f.commons.data.general.Util;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloatingActionMenu
  extends ViewGroup
{
  public static final int ANIMATION_DURATION = 300;
  public static final float CLOSED_PLUS_ROTATION = 0.0F;
  public static final int LABELS_POSITION_LEFT = 0;
  public static final int LABELS_POSITION_RIGHT = 1;
  public static final float OPENED_PLUS_ROTATION_LEFT = -135.0F;
  public static final float OPENED_PLUS_ROTATION_RIGHT = 135.0F;
  public static final int OPEN_DOWN = 1;
  public static final int QUIET_HOURS_DEFAULT_START_MINUTE = 0;
  public boolean fab_label;
  public Animation fadeIn;
  public int mAnimationDelayPerItem;
  public int mBackgroundColor;
  public int mButtonSpacing = Util.dpToPx(getContext(), 0.0F);
  public int mButtonsCount;
  public AnimatorSet mCloseAnimatorSet = new AnimatorSet();
  public Interpolator mCloseInterpolator;
  public Animation mHideAnimation;
  public ValueAnimator mHideBackgroundAnimator;
  public Drawable mIcon;
  public boolean mIconAnimated = true;
  public AnimatorSet mIconToggleSet;
  public ImageView mImageToggle;
  public boolean mIsAnimated = true;
  public boolean mIsMenuButtonAnimationRunning;
  public boolean mIsMenuOpening;
  public boolean mIsSetClosedOnTouchOutside;
  public String mLabelText;
  public int mLabelsColorNormal;
  public int mLabelsColorPressed;
  public int mLabelsColorRipple;
  public Context mLabelsContext;
  public int mLabelsCornerRadius = Util.dpToPx(getContext(), 3.0F);
  public int mLabelsEllipsize;
  public int mLabelsHideAnimation;
  public int mLabelsMargin = Util.dpToPx(getContext(), 0.0F);
  public int mLabelsMaxLines;
  public int mLabelsPaddingBottom = Util.dpToPx(getContext(), 4.0F);
  public int mLabelsPaddingLeft = Util.dpToPx(getContext(), 8.0F);
  public int mLabelsPaddingRight = Util.dpToPx(getContext(), 8.0F);
  public int mLabelsPaddingTop = Util.dpToPx(getContext(), 4.0F);
  public int mLabelsPosition;
  public int mLabelsShowAnimation;
  public boolean mLabelsShowShadow;
  public boolean mLabelsSingleLine;
  public int mLabelsStyle;
  public ColorStateList mLabelsTextColor;
  public float mLabelsTextSize;
  public int mLabelsVerticalOffset = Util.dpToPx(getContext(), 0.0F);
  public int mMaxButtonWidth;
  public FloatingActionButton mMenuButton;
  public Animation mMenuButtonHideAnimation;
  public Animation mMenuButtonShowAnimation;
  public int mMenuColorNormal;
  public int mMenuColorPressed;
  public int mMenuColorRipple;
  public int mMenuFabSize;
  public boolean mMenuOpened;
  public int mMenuShadowColor;
  public float mMenuShadowRadius = 4.0F;
  public float mMenuShadowXOffset = 1.0F;
  public float mMenuShadowYOffset = 3.0F;
  public boolean mMenuShowShadow;
  public AnimatorSet mOpenAnimatorSet = new AnimatorSet();
  public int mOpenDirection;
  public Interpolator mOpenInterpolator;
  public ValueAnimator mShowBackgroundAnimator;
  public a mToggleListener;
  public Handler mUiHandler = new Handler();
  public Typeface t;
  
  public FloatingActionMenu(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FloatingActionMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingActionMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void addLabel(FloatingActionButton paramFloatingActionButton)
  {
    String str = paramFloatingActionButton.getLabelText();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Label localLabel = new Label(mLabelsContext);
    localLabel.setClickable(true);
    localLabel.setFab(paramFloatingActionButton);
    localLabel.setShowAnimation(AnimationUtils.loadAnimation(getContext(), mLabelsShowAnimation));
    localLabel.setHideAnimation(AnimationUtils.loadAnimation(getContext(), mLabelsHideAnimation));
    if (mLabelsStyle > 0)
    {
      localLabel.setTextAppearance(getContext(), mLabelsStyle);
      localLabel.setShowShadow(false);
      localLabel.setUsingStyle(true);
    }
    else
    {
      localLabel.setColors(mLabelsColorNormal, mLabelsColorPressed, mLabelsColorRipple);
      localLabel.setShowShadow(mLabelsShowShadow);
      localLabel.setCornerRadius(mLabelsCornerRadius);
      if (mLabelsEllipsize > 0) {
        setLabelEllipsize(localLabel);
      }
      localLabel.setMaxLines(mLabelsMaxLines);
      localLabel.updateBackground();
      localLabel.setTextSize(0, mLabelsTextSize);
      localLabel.setTextColor(mLabelsTextColor);
      int m = mLabelsPaddingLeft;
      int k = mLabelsPaddingTop;
      int j = m;
      int i = k;
      if (mLabelsShowShadow)
      {
        i = paramFloatingActionButton.getShadowRadius();
        j = m + (Math.abs(paramFloatingActionButton.getShadowXOffset()) + i);
        i = paramFloatingActionButton.getShadowRadius();
        i = k + (Math.abs(paramFloatingActionButton.getShadowYOffset()) + i);
      }
      localLabel.setPadding(j, i, mLabelsPaddingLeft, mLabelsPaddingTop);
      if ((mLabelsMaxLines < 0) || (mLabelsSingleLine)) {
        localLabel.setSingleLine(mLabelsSingleLine);
      }
    }
    Typeface localTypeface = t;
    if (localTypeface != null) {
      localLabel.setTypeface(localTypeface);
    }
    localLabel.setText(str);
    localLabel.setOnClickListener(paramFloatingActionButton.getOnClickListener());
    addView(localLabel);
    paramFloatingActionButton.setTag(R.id.fab_label, localLabel);
  }
  
  private int adjustForOvershoot(int paramInt)
  {
    double d = paramInt;
    Double.isNaN(d);
    Double.isNaN(d);
    return (int)(0.03D * d + d);
  }
  
  private void createDefaultIconAnimation()
  {
    int i = mOpenDirection;
    float f3 = 135.0F;
    float f1;
    float f2;
    if (i == 0)
    {
      if (mLabelsPosition == 0) {
        f1 = -135.0F;
      } else {
        f1 = 135.0F;
      }
      f2 = f1;
      if (mLabelsPosition == 0) {
        f2 = f1;
      }
    }
    else
    {
      do
      {
        f3 = -135.0F;
        break;
        if (mLabelsPosition == 0) {
          f1 = 135.0F;
        } else {
          f1 = -135.0F;
        }
        f2 = f1;
      } while (mLabelsPosition != 0);
      f2 = f1;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(mImageToggle, "rotation", new float[] { f2, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(mImageToggle, "rotation", new float[] { 0.0F, f3 });
    mOpenAnimatorSet.play(localObjectAnimator2);
    mCloseAnimatorSet.play(localObjectAnimator1);
    mOpenAnimatorSet.setInterpolator(mOpenInterpolator);
    mCloseAnimatorSet.setInterpolator(mCloseInterpolator);
    mOpenAnimatorSet.setDuration(300L);
    mCloseAnimatorSet.setDuration(300L);
  }
  
  private void createLabels()
  {
    int i = 0;
    while (i < mButtonsCount)
    {
      if (getChildAt(i) != mImageToggle)
      {
        FloatingActionButton localFloatingActionButton1 = (FloatingActionButton)getChildAt(i);
        if (localFloatingActionButton1.getTag(R.id.fab_label) == null)
        {
          addLabel(localFloatingActionButton1);
          FloatingActionButton localFloatingActionButton2 = mMenuButton;
          if (localFloatingActionButton1 == localFloatingActionButton2) {
            localFloatingActionButton2.setOnClickListener(new FloatingActionMenu.3(this));
          }
        }
      }
      i += 1;
    }
  }
  
  private void createMenuButton()
  {
    mMenuButton = new FloatingActionButton(getContext());
    FloatingActionButton localFloatingActionButton = mMenuButton;
    boolean bool = mMenuShowShadow;
    mShowShadow = bool;
    if (bool)
    {
      mShadowRadius = Util.dpToPx(getContext(), mMenuShadowRadius);
      mMenuButton.mShadowXOffset = Util.dpToPx(getContext(), mMenuShadowXOffset);
      mMenuButton.mShadowYOffset = Util.dpToPx(getContext(), mMenuShadowYOffset);
    }
    mMenuButton.setColors(mMenuColorNormal, mMenuColorPressed, mMenuColorRipple);
    localFloatingActionButton = mMenuButton;
    mShadowColor = mMenuShadowColor;
    mFabSize = mMenuFabSize;
    localFloatingActionButton.updateBackground();
    mMenuButton.setLabelText(mLabelText);
    mImageToggle = new ImageView(getContext());
    mImageToggle.setImageDrawable(mIcon);
    addView(mMenuButton, super.generateDefaultLayoutParams());
    addView(mImageToggle);
    createDefaultIconAnimation();
  }
  
  private void hideMenuButtonWithImage(boolean paramBoolean)
  {
    if (!isMenuButtonHidden())
    {
      mMenuButton.hide(paramBoolean);
      if (paramBoolean) {
        mImageToggle.startAnimation(mMenuButtonHideAnimation);
      }
      mImageToggle.setVisibility(4);
      mIsMenuButtonAnimationRunning = false;
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionMenu, 0, 0);
    mButtonSpacing = paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_buttonSpacing, mButtonSpacing);
    mLabelsMargin = paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_margin, mLabelsMargin);
    mLabelsPosition = paramAttributeSet.getInt(R.styleable.FloatingActionMenu_menu_labels_position, 0);
    int j = R.styleable.FloatingActionMenu_menu_labels_showAnimation;
    int i;
    if (mLabelsPosition == 0) {
      i = R.anim.fab_slide_in_from_right;
    } else {
      i = R.anim.fab_slide_in_from_left;
    }
    mLabelsShowAnimation = paramAttributeSet.getResourceId(j, i);
    j = R.styleable.FloatingActionMenu_menu_labels_hideAnimation;
    if (mLabelsPosition == 0) {
      i = R.anim.fab_slide_out_to_right;
    } else {
      i = R.anim.fab_slide_out_to_left;
    }
    mLabelsHideAnimation = paramAttributeSet.getResourceId(j, i);
    mLabelsPaddingTop = paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingTop, mLabelsPaddingTop);
    mLabelsPaddingRight = paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingRight, mLabelsPaddingRight);
    mLabelsPaddingBottom = paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingBottom, mLabelsPaddingBottom);
    mLabelsPaddingLeft = paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_paddingLeft, mLabelsPaddingLeft);
    mLabelsTextColor = paramAttributeSet.getColorStateList(R.styleable.FloatingActionMenu_menu_labels_textColor);
    if (mLabelsTextColor == null) {
      mLabelsTextColor = ColorStateList.valueOf(-1);
    }
    mLabelsTextSize = paramAttributeSet.getDimension(R.styleable.FloatingActionMenu_menu_labels_textSize, getResources().getDimension(R.dimen.labels_text_size));
    mLabelsCornerRadius = paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_cornerRadius, mLabelsCornerRadius);
    mLabelsShowShadow = paramAttributeSet.getBoolean(R.styleable.FloatingActionMenu_menu_labels_showShadow, true);
    mLabelsColorNormal = paramAttributeSet.getColor(R.styleable.FloatingActionMenu_menu_labels_colorNormal, -13421773);
    mLabelsColorPressed = paramAttributeSet.getColor(R.styleable.FloatingActionMenu_menu_labels_colorPressed, -12303292);
    mLabelsColorRipple = paramAttributeSet.getColor(R.styleable.FloatingActionMenu_menu_labels_colorRipple, 1728053247);
    mMenuShowShadow = paramAttributeSet.getBoolean(R.styleable.FloatingActionMenu_menu_showShadow, true);
    mMenuShadowColor = paramAttributeSet.getColor(R.styleable.FloatingActionMenu_menu_shadowColor, 1711276032);
    mMenuShadowRadius = paramAttributeSet.getDimension(R.styleable.FloatingActionMenu_menu_shadowRadius, mMenuShadowRadius);
    mMenuShadowXOffset = paramAttributeSet.getDimension(R.styleable.FloatingActionMenu_menu_shadowXOffset, mMenuShadowXOffset);
    mMenuShadowYOffset = paramAttributeSet.getDimension(R.styleable.FloatingActionMenu_menu_shadowYOffset, mMenuShadowYOffset);
    mMenuColorNormal = paramAttributeSet.getColor(R.styleable.FloatingActionMenu_menu_colorNormal, -2473162);
    mMenuColorPressed = paramAttributeSet.getColor(R.styleable.FloatingActionMenu_menu_colorPressed, -1617853);
    mMenuColorRipple = paramAttributeSet.getColor(R.styleable.FloatingActionMenu_menu_colorRipple, -1711276033);
    mAnimationDelayPerItem = paramAttributeSet.getInt(R.styleable.FloatingActionMenu_menu_animationDelayPerItem, 50);
    mIcon = paramAttributeSet.getDrawable(R.styleable.FloatingActionMenu_menu_icon);
    if (mIcon == null) {
      mIcon = getResources().getDrawable(R.drawable.fab_add);
    }
    mLabelsSingleLine = paramAttributeSet.getBoolean(R.styleable.FloatingActionMenu_menu_labels_singleLine, false);
    mLabelsEllipsize = paramAttributeSet.getInt(R.styleable.FloatingActionMenu_menu_labels_ellipsize, 0);
    mLabelsMaxLines = paramAttributeSet.getInt(R.styleable.FloatingActionMenu_menu_labels_maxLines, -1);
    mMenuFabSize = paramAttributeSet.getInt(R.styleable.FloatingActionMenu_menu_fab_size, 0);
    mLabelsStyle = paramAttributeSet.getResourceId(R.styleable.FloatingActionMenu_menu_labels_style, 0);
    paramContext = paramAttributeSet.getString(R.styleable.FloatingActionMenu_menu_labels_customFont);
    try
    {
      boolean bool = TextUtils.isEmpty(paramContext);
      if (!bool) {
        t = Typeface.createFromAsset(getContext().getAssets(), paramContext);
      }
      mOpenDirection = paramAttributeSet.getInt(R.styleable.FloatingActionMenu_menu_openDirection, 0);
      mBackgroundColor = paramAttributeSet.getColor(R.styleable.FloatingActionMenu_menu_backgroundColor, 0);
      if (paramAttributeSet.hasValue(R.styleable.FloatingActionMenu_menu_fab_label))
      {
        fab_label = true;
        mLabelText = paramAttributeSet.getString(R.styleable.FloatingActionMenu_menu_fab_label);
      }
      if (paramAttributeSet.hasValue(R.styleable.FloatingActionMenu_menu_labels_padding)) {
        initPadding(paramAttributeSet.getDimensionPixelSize(R.styleable.FloatingActionMenu_menu_labels_padding, 0));
      }
      mOpenInterpolator = new OvershootInterpolator();
      mCloseInterpolator = new AnticipateInterpolator();
      mLabelsContext = new ContextThemeWrapper(getContext(), mLabelsStyle);
      initBackgroundDimAnimation();
      createMenuButton();
      initMenuButtonAnimations(paramAttributeSet);
      paramAttributeSet.recycle();
      return;
    }
    catch (RuntimeException paramAttributeSet)
    {
      throw new IllegalArgumentException(StringBuilder.toString("Unable to load specified custom font: ", paramContext), paramAttributeSet);
    }
  }
  
  private void initBackgroundDimAnimation()
  {
    int i = Color.alpha(mBackgroundColor);
    int j = Color.red(mBackgroundColor);
    int k = Color.green(mBackgroundColor);
    int m = Color.blue(mBackgroundColor);
    mShowBackgroundAnimator = ValueAnimator.ofInt(new int[] { 0, i });
    mShowBackgroundAnimator.setDuration(300L);
    mShowBackgroundAnimator.addUpdateListener(new FloatingActionMenu.1(this, j, k, m));
    mHideBackgroundAnimator = ValueAnimator.ofInt(new int[] { i, 0 });
    mHideBackgroundAnimator.setDuration(300L);
    mHideBackgroundAnimator.addUpdateListener(new FloatingActionMenu.2(this, j, k, m));
  }
  
  private void initMenuButtonAnimations(TypedArray paramTypedArray)
  {
    int i = paramTypedArray.getResourceId(R.styleable.FloatingActionMenu_menu_fab_show_animation, R.anim.fab_scale_up);
    setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getContext(), i));
    mMenuButtonShowAnimation = AnimationUtils.loadAnimation(getContext(), i);
    i = paramTypedArray.getResourceId(R.styleable.FloatingActionMenu_menu_fab_hide_animation, R.anim.fab_scale_down);
    setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getContext(), i));
    mMenuButtonHideAnimation = AnimationUtils.loadAnimation(getContext(), i);
  }
  
  private void initPadding(int paramInt)
  {
    mLabelsPaddingTop = paramInt;
    mLabelsPaddingRight = paramInt;
    mLabelsPaddingBottom = paramInt;
    mLabelsPaddingLeft = paramInt;
  }
  
  private boolean isBackgroundEnabled()
  {
    return mBackgroundColor != 0;
  }
  
  private void setLabelEllipsize(Label paramLabel)
  {
    int i = mLabelsEllipsize;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          paramLabel.setEllipsize(TextUtils.TruncateAt.MARQUEE);
          return;
        }
        paramLabel.setEllipsize(TextUtils.TruncateAt.END);
        return;
      }
      paramLabel.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      return;
    }
    paramLabel.setEllipsize(TextUtils.TruncateAt.START);
  }
  
  private void showMenuButtonWithImage(boolean paramBoolean)
  {
    if (isMenuButtonHidden())
    {
      mMenuButton.show(paramBoolean);
      if (paramBoolean) {
        mImageToggle.startAnimation(mMenuButtonShowAnimation);
      }
      mImageToggle.setVisibility(0);
    }
  }
  
  public void addMenuButton(FloatingActionButton paramFloatingActionButton)
  {
    addView(paramFloatingActionButton, mButtonsCount - 2);
    mButtonsCount += 1;
    addLabel(paramFloatingActionButton);
  }
  
  public void addMenuButton(FloatingActionButton paramFloatingActionButton, int paramInt)
  {
    int j = mButtonsCount - 2;
    int i;
    if (paramInt < 0)
    {
      i = 0;
    }
    else
    {
      i = paramInt;
      if (paramInt > j) {
        i = j;
      }
    }
    addView(paramFloatingActionButton, i);
    mButtonsCount += 1;
    addLabel(paramFloatingActionButton);
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ViewGroup.MarginLayoutParams;
  }
  
  public void close()
  {
    close(true);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != mMenuButton) && (localView != mImageToggle) && ((localView instanceof FloatingActionButton))) {
        ((List)localObject).add((FloatingActionButton)localView);
      }
      i += 1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      removeMenuButton((FloatingActionButton)((Iterator)localObject).next());
    }
  }
  
  public void close(boolean paramBoolean)
  {
    if (isOpened())
    {
      if (isBackgroundEnabled()) {
        mHideBackgroundAnimator.start();
      }
      Object localObject;
      if (mIconAnimated)
      {
        localObject = mIconToggleSet;
        if (localObject != null)
        {
          ((AnimatorSet)localObject).start();
        }
        else
        {
          mCloseAnimatorSet.start();
          mOpenAnimatorSet.cancel();
        }
      }
      int j = 0;
      mIsMenuOpening = false;
      int m = 0;
      int k;
      for (int i = 0; j < getChildCount(); i = k)
      {
        localObject = getChildAt(j);
        int n = m;
        k = i;
        if ((localObject instanceof FloatingActionButton))
        {
          n = m;
          k = i;
          if (((View)localObject).getVisibility() != 8)
          {
            n = m + 1;
            localObject = (FloatingActionButton)localObject;
            mUiHandler.postDelayed(new FloatingActionMenu.7(this, (FloatingActionButton)localObject, paramBoolean), i);
            k = i + mAnimationDelayPerItem;
          }
        }
        j += 1;
        m = n;
      }
      mUiHandler.postDelayed(new EventInfoFragment.1(this), (m + 1) * mAnimationDelayPerItem);
    }
  }
  
  public ViewGroup.MarginLayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-2, -2);
  }
  
  public ViewGroup.MarginLayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.MarginLayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  public int getAnimationDelayPerItem()
  {
    return mAnimationDelayPerItem;
  }
  
  public AnimatorSet getIconToggleAnimatorSet()
  {
    return mIconToggleSet;
  }
  
  public int getMenuButtonColorNormal()
  {
    return mMenuColorNormal;
  }
  
  public int getMenuButtonColorPressed()
  {
    return mMenuColorPressed;
  }
  
  public int getMenuButtonColorRipple()
  {
    return mMenuColorRipple;
  }
  
  public String getMenuButtonLabelText()
  {
    return mLabelText;
  }
  
  public ImageView getMenuIconView()
  {
    return mImageToggle;
  }
  
  public void hideMenu(boolean paramBoolean)
  {
    if ((!open()) && (!mIsMenuButtonAnimationRunning))
    {
      mIsMenuButtonAnimationRunning = true;
      if (isOpened())
      {
        close(paramBoolean);
        mUiHandler.postDelayed(new LogBrokerMonitor.2(this, paramBoolean), mAnimationDelayPerItem * mButtonsCount);
        return;
      }
      if (paramBoolean) {
        startAnimation(mHideAnimation);
      }
      setVisibility(4);
      mIsMenuButtonAnimationRunning = false;
    }
  }
  
  public void hideMenuButton(boolean paramBoolean)
  {
    if ((!isMenuButtonHidden()) && (!mIsMenuButtonAnimationRunning))
    {
      mIsMenuButtonAnimationRunning = true;
      if (isOpened())
      {
        close(paramBoolean);
        mUiHandler.postDelayed(new ButtonFloat.1(this, paramBoolean), mAnimationDelayPerItem * mButtonsCount);
        return;
      }
      hideMenuButtonWithImage(paramBoolean);
    }
  }
  
  public void init(boolean paramBoolean)
  {
    if (open())
    {
      if (paramBoolean) {
        startAnimation(fadeIn);
      }
      setVisibility(0);
    }
  }
  
  public boolean isAnimated()
  {
    return mIsAnimated;
  }
  
  public boolean isIconAnimated()
  {
    return mIconAnimated;
  }
  
  public boolean isMenuButtonHidden()
  {
    return mMenuButton.isHidden();
  }
  
  public boolean isOpened()
  {
    return mMenuOpened;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    bringChildToFront(mMenuButton);
    bringChildToFront(mImageToggle);
    mButtonsCount = getChildCount();
    createLabels();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (mLabelsPosition == 0)
    {
      paramInt3 = paramInt3 - paramInt1 - mMaxButtonWidth / 2 - getPaddingRight();
    }
    else
    {
      paramInt1 = mMaxButtonWidth / 2;
      paramInt3 = getPaddingLeft() + paramInt1;
    }
    int i;
    if (mOpenDirection == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramInt1 = paramInt4 - paramInt2 - mMenuButton.getMeasuredHeight() - getPaddingBottom();
    } else {
      paramInt1 = getPaddingTop();
    }
    paramInt2 = paramInt3 - mMenuButton.getMeasuredWidth() / 2;
    Object localObject = mMenuButton;
    ((View)localObject).layout(paramInt2, paramInt1, ((View)localObject).getMeasuredWidth() + paramInt2, mMenuButton.getMeasuredHeight() + paramInt1);
    paramInt2 = paramInt3 - mImageToggle.getMeasuredWidth() / 2;
    paramInt4 = mMenuButton.getMeasuredHeight() / 2 + paramInt1 - mImageToggle.getMeasuredHeight() / 2;
    localObject = mImageToggle;
    ((View)localObject).layout(paramInt2, paramInt4, ((View)localObject).getMeasuredWidth() + paramInt2, mImageToggle.getMeasuredHeight() + paramInt4);
    paramInt2 = paramInt1;
    if (i != 0)
    {
      paramInt2 = mMenuButton.getMeasuredHeight();
      paramInt2 = mButtonSpacing + (paramInt2 + paramInt1);
    }
    paramInt4 = mButtonsCount - 1;
    paramInt1 = paramInt2;
    while (paramInt4 >= 0)
    {
      localObject = getChildAt(paramInt4);
      if (localObject != mImageToggle)
      {
        FloatingActionButton localFloatingActionButton = (FloatingActionButton)localObject;
        if (localFloatingActionButton.getVisibility() != 8)
        {
          paramInt2 = paramInt3 - localFloatingActionButton.getMeasuredWidth() / 2;
          int j = paramInt1;
          if (i != 0) {
            j = paramInt1 - localFloatingActionButton.getMeasuredHeight() - mButtonSpacing;
          }
          if (localFloatingActionButton != mMenuButton)
          {
            localFloatingActionButton.layout(paramInt2, j, localFloatingActionButton.getMeasuredWidth() + paramInt2, localFloatingActionButton.getMeasuredHeight() + j);
            if (!mIsMenuOpening) {
              localFloatingActionButton.hide(false);
            }
          }
          View localView = (View)localFloatingActionButton.getTag(R.id.fab_label);
          if (localView != null)
          {
            if (fab_label) {
              paramInt1 = mMaxButtonWidth;
            } else {
              paramInt1 = localFloatingActionButton.getMeasuredWidth();
            }
            paramInt1 = paramInt1 / 2 + mLabelsMargin;
            if (mLabelsPosition == 0) {
              paramInt1 = paramInt3 - paramInt1;
            } else {
              paramInt1 += paramInt3;
            }
            if (mLabelsPosition == 0) {
              paramInt2 = paramInt1 - localView.getMeasuredWidth();
            } else {
              paramInt2 = localView.getMeasuredWidth() + paramInt1;
            }
            int k;
            if (mLabelsPosition == 0) {
              k = paramInt2;
            } else {
              k = paramInt1;
            }
            if (mLabelsPosition != 0) {
              paramInt1 = paramInt2;
            }
            paramInt2 = mLabelsVerticalOffset;
            paramInt2 = (localFloatingActionButton.getMeasuredHeight() - localView.getMeasuredHeight()) / 2 + (j - paramInt2);
            localView.layout(k, paramInt2, paramInt1, localView.getMeasuredHeight() + paramInt2);
            if (!mIsMenuOpening) {
              localView.setVisibility(4);
            }
          }
          if (i != 0)
          {
            paramInt1 = j - mButtonSpacing;
          }
          else
          {
            paramInt1 = ((View)localObject).getMeasuredHeight();
            paramInt1 = mButtonSpacing + (paramInt1 + j);
          }
        }
      }
      paramInt4 -= 1;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    mMaxButtonWidth = 0;
    measureChildWithMargins(mImageToggle, paramInt1, 0, paramInt2, 0);
    int i = 0;
    View localView;
    while (i < mButtonsCount)
    {
      localView = getChildAt(i);
      if ((localView.getVisibility() != 8) && (localView != mImageToggle))
      {
        measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
        mMaxButtonWidth = Math.max(mMaxButtonWidth, localView.getMeasuredWidth());
      }
      i += 1;
    }
    int k = 0;
    i = 0;
    int j = 0;
    for (;;)
    {
      m = mButtonsCount;
      int i2 = 1;
      if (i >= m) {
        break;
      }
      localView = getChildAt(i);
      n = j;
      m = k;
      if (localView.getVisibility() != 8) {
        if (localView == mImageToggle)
        {
          n = j;
          m = k;
        }
        else
        {
          int i3 = localView.getMeasuredWidth();
          int i1 = localView.getMeasuredHeight() + k;
          Label localLabel = (Label)localView.getTag(R.id.fab_label);
          n = j;
          m = i1;
          if (localLabel != null)
          {
            m = mMaxButtonWidth;
            n = localView.getMeasuredWidth();
            if (fab_label) {
              k = i2;
            } else {
              k = 2;
            }
            k = (m - n) / k;
            m = localView.getMeasuredWidth();
            measureChildWithMargins(localLabel, paramInt1, localLabel.calculateShadowWidth() + m + mLabelsMargin + k, paramInt2, 0);
            n = Math.max(j, localLabel.getMeasuredWidth() + (i3 + 0) + k);
            m = i1;
          }
        }
      }
      i += 1;
      j = n;
      k = m;
    }
    i = Math.max(mMaxButtonWidth, j + mLabelsMargin);
    j = getPaddingLeft();
    i = getPaddingRight() + (j + i);
    j = mButtonSpacing;
    int m = mButtonsCount;
    int n = getPaddingTop();
    j = adjustForOvershoot(getPaddingBottom() + (n + (m - 1) * j) + k);
    if (getLayoutParamswidth == -1) {
      i = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    }
    paramInt1 = j;
    if (getLayoutParamsheight == -1) {
      paramInt1 = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mIsSetClosedOnTouchOutside)
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1) {
          return false;
        }
        close(mIsAnimated);
        return true;
      }
      return isOpened();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void open(boolean paramBoolean)
  {
    if (!isOpened())
    {
      if (isBackgroundEnabled()) {
        mShowBackgroundAnimator.start();
      }
      Object localObject;
      if (mIconAnimated)
      {
        localObject = mIconToggleSet;
        if (localObject != null)
        {
          ((AnimatorSet)localObject).start();
        }
        else
        {
          mCloseAnimatorSet.cancel();
          mOpenAnimatorSet.start();
        }
      }
      mIsMenuOpening = true;
      int j = getChildCount() - 1;
      int m = 0;
      int k;
      for (int i = 0; j >= 0; i = k)
      {
        localObject = getChildAt(j);
        int n = m;
        k = i;
        if ((localObject instanceof FloatingActionButton))
        {
          n = m;
          k = i;
          if (((View)localObject).getVisibility() != 8)
          {
            n = m + 1;
            localObject = (FloatingActionButton)localObject;
            mUiHandler.postDelayed(new FloatingActionMenu.5(this, (FloatingActionButton)localObject, paramBoolean), i);
            k = i + mAnimationDelayPerItem;
          }
        }
        j -= 1;
        m = n;
      }
      mUiHandler.postDelayed(new DayFragment.1(this), (m + 1) * mAnimationDelayPerItem);
    }
  }
  
  public boolean open()
  {
    return getVisibility() == 4;
  }
  
  public void removeMenuButton(FloatingActionButton paramFloatingActionButton)
  {
    removeView(paramFloatingActionButton.getLabelView());
    removeView(paramFloatingActionButton);
    mButtonsCount -= 1;
  }
  
  public void setAnimated(boolean paramBoolean)
  {
    mIsAnimated = paramBoolean;
    AnimatorSet localAnimatorSet = mOpenAnimatorSet;
    long l2 = 300L;
    long l1;
    if (paramBoolean) {
      l1 = 300L;
    } else {
      l1 = 0L;
    }
    localAnimatorSet.setDuration(l1);
    localAnimatorSet = mCloseAnimatorSet;
    if (paramBoolean) {
      l1 = l2;
    } else {
      l1 = 0L;
    }
    localAnimatorSet.setDuration(l1);
  }
  
  public void setAnimationDelayPerItem(int paramInt)
  {
    mAnimationDelayPerItem = paramInt;
  }
  
  public void setClosedOnTouchOutside(boolean paramBoolean)
  {
    mIsSetClosedOnTouchOutside = paramBoolean;
  }
  
  public void setIconAnimated(boolean paramBoolean)
  {
    mIconAnimated = paramBoolean;
  }
  
  public void setIconAnimationCloseInterpolator(Interpolator paramInterpolator)
  {
    mCloseAnimatorSet.setInterpolator(paramInterpolator);
  }
  
  public void setIconAnimationInterpolator(Interpolator paramInterpolator)
  {
    mOpenAnimatorSet.setInterpolator(paramInterpolator);
    mCloseAnimatorSet.setInterpolator(paramInterpolator);
  }
  
  public void setIconAnimationOpenInterpolator(Interpolator paramInterpolator)
  {
    mOpenAnimatorSet.setInterpolator(paramInterpolator);
  }
  
  public void setIconToggleAnimatorSet(AnimatorSet paramAnimatorSet)
  {
    mIconToggleSet = paramAnimatorSet;
  }
  
  public void setMenuButtonColorNormal(int paramInt)
  {
    mMenuColorNormal = paramInt;
    mMenuButton.setColorNormal(paramInt);
  }
  
  public void setMenuButtonColorNormalResId(int paramInt)
  {
    mMenuColorNormal = getResources().getColor(paramInt);
    mMenuButton.setColorNormalResId(paramInt);
  }
  
  public void setMenuButtonColorPressed(int paramInt)
  {
    mMenuColorPressed = paramInt;
    mMenuButton.setColorPressed(paramInt);
  }
  
  public void setMenuButtonColorPressedResId(int paramInt)
  {
    mMenuColorPressed = getResources().getColor(paramInt);
    mMenuButton.setColorPressedResId(paramInt);
  }
  
  public void setMenuButtonColorRipple(int paramInt)
  {
    mMenuColorRipple = paramInt;
    mMenuButton.setColorRipple(paramInt);
  }
  
  public void setMenuButtonColorRippleResId(int paramInt)
  {
    mMenuColorRipple = getResources().getColor(paramInt);
    mMenuButton.setColorRippleResId(paramInt);
  }
  
  public void setMenuButtonHideAnimation(Animation paramAnimation)
  {
    mHideAnimation = paramAnimation;
    mMenuButton.setHideAnimation(paramAnimation);
  }
  
  public void setMenuButtonLabelText(String paramString)
  {
    mMenuButton.setLabelText(paramString);
  }
  
  public void setMenuButtonShowAnimation(Animation paramAnimation)
  {
    fadeIn = paramAnimation;
    mMenuButton.setShowAnimation(paramAnimation);
  }
  
  public void setOnMenuButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    mMenuButton.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuButtonLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    mMenuButton.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public void setOnMenuToggleListener(a paramA)
  {
    mToggleListener = paramA;
  }
  
  public void showMenuButton(boolean paramBoolean)
  {
    if (isMenuButtonHidden()) {
      showMenuButtonWithImage(paramBoolean);
    }
  }
  
  public void toggle(boolean paramBoolean)
  {
    if (isOpened())
    {
      close(paramBoolean);
      return;
    }
    open(paramBoolean);
  }
  
  public void toggleMenu(boolean paramBoolean)
  {
    if (open())
    {
      init(paramBoolean);
      return;
    }
    hideMenu(paramBoolean);
  }
  
  public void toggleMenuButton(boolean paramBoolean)
  {
    if (isMenuButtonHidden())
    {
      showMenuButton(paramBoolean);
      return;
    }
    hideMenuButton(paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void getMediaCount(boolean paramBoolean);
  }
}
