package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import support.android.v4.content.ContextCompat;
import support.android.v4.view.DashboardFragment.1;
import support.android.v4.view.FilenameDialog.1;

public class PagerTabStrip
  extends PagerTitleStrip
{
  public static final int FULL_UNDERLINE_HEIGHT = 1;
  public static final int INDICATOR_HEIGHT = 3;
  public static final int MIN_PADDING_BOTTOM = 6;
  public static final int MIN_STRIP_HEIGHT = 32;
  public static final int MIN_TEXT_SPACING = 64;
  public static final int TAB_PADDING = 16;
  public static final int TAB_SPACING = 32;
  public static final String TAG = "PagerTabStrip";
  public boolean mDrawFullUnderline = false;
  public boolean mDrawFullUnderlineSet = false;
  public int mFullUnderlineHeight;
  public boolean mIgnoreTap;
  public int mIndicatorColor = mTextColor;
  public int mIndicatorHeight;
  public float mInitialMotionX;
  public float mInitialMotionY;
  public int mMinPaddingBottom;
  public int mMinStripHeight;
  public int mMinTextSpacing;
  public int mTabAlpha = 255;
  public int mTabPadding;
  public final Paint mTabPaint = new Paint();
  public final Rect mTempRect = new Rect();
  public int mTouchSlop;
  
  public PagerTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mTabPaint.setColor(mIndicatorColor);
    float f = getResourcesgetDisplayMetricsdensity;
    mIndicatorHeight = ((int)(3.0F * f + 0.5F));
    mMinPaddingBottom = ((int)(6.0F * f + 0.5F));
    mMinTextSpacing = ((int)(64.0F * f));
    mTabPadding = ((int)(16.0F * f + 0.5F));
    mFullUnderlineHeight = ((int)(1.0F * f + 0.5F));
    mMinStripHeight = ((int)(f * 32.0F + 0.5F));
    mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    mPrevText.setFocusable(true);
    mPrevText.setOnClickListener(new DashboardFragment.1(this));
    mNextText.setFocusable(true);
    mNextText.setOnClickListener(new FilenameDialog.1(this));
    if (getBackground() == null) {
      mDrawFullUnderline = true;
    }
  }
  
  public boolean getDrawFullUnderline()
  {
    return mDrawFullUnderline;
  }
  
  public int getMinHeight()
  {
    return Math.max(super.getMinHeight(), mMinStripHeight);
  }
  
  public int getTabIndicatorColor()
  {
    return mIndicatorColor;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = mCurrText.getLeft();
    int k = mTabPadding;
    int m = mCurrText.getRight();
    int n = mTabPadding;
    int i1 = mIndicatorHeight;
    mTabPaint.setColor(mTabAlpha << 24 | mIndicatorColor & 0xFFFFFF);
    float f1 = j - k;
    float f2 = i - i1;
    float f3 = m + n;
    float f4 = i;
    paramCanvas.drawRect(f1, f2, f3, f4, mTabPaint);
    if (mDrawFullUnderline)
    {
      mTabPaint.setColor(0xFF000000 | mIndicatorColor & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - mFullUnderlineHeight, getWidth() - getPaddingRight(), f4, mTabPaint);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (mIgnoreTap)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        if ((Math.abs(f1 - mInitialMotionX) > mTouchSlop) || (Math.abs(f2 - mInitialMotionY) > mTouchSlop))
        {
          mIgnoreTap = true;
          return true;
        }
      }
      else
      {
        if (f1 < mCurrText.getLeft() - mTabPadding)
        {
          paramMotionEvent = mPager;
          paramMotionEvent.setCurrentItem(paramMotionEvent.getCurrentItem() - 1);
          return true;
        }
        if (f1 > mCurrText.getRight() + mTabPadding)
        {
          paramMotionEvent = mPager;
          paramMotionEvent.setCurrentItem(paramMotionEvent.getCurrentItem() + 1);
          return true;
        }
      }
    }
    else
    {
      mInitialMotionX = f1;
      mInitialMotionY = f2;
      mIgnoreTap = false;
    }
    return true;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!mDrawFullUnderlineSet)
    {
      boolean bool;
      if ((paramInt & 0xFF000000) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      mDrawFullUnderline = bool;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!mDrawFullUnderlineSet)
    {
      boolean bool;
      if (paramDrawable == null) {
        bool = true;
      } else {
        bool = false;
      }
      mDrawFullUnderline = bool;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!mDrawFullUnderlineSet)
    {
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      mDrawFullUnderline = bool;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    mDrawFullUnderline = paramBoolean;
    mDrawFullUnderlineSet = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = mMinPaddingBottom;
    int i = paramInt4;
    if (paramInt4 < j) {
      i = j;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    mIndicatorColor = paramInt;
    mTabPaint.setColor(mIndicatorColor);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int j = mMinTextSpacing;
    int i = paramInt;
    if (paramInt < j) {
      i = j;
    }
    mScaledTextSpacing = i;
    requestLayout();
  }
  
  public void updateTextPositions(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = mTempRect;
    int i = getHeight();
    int j = mCurrText.getLeft();
    int k = mTabPadding;
    int m = mCurrText.getRight();
    int n = mTabPadding;
    int i1 = i - mIndicatorHeight;
    localRect.set(j - k, i1, m + n, i);
    super.updateTextPositions(paramInt, paramFloat, paramBoolean);
    mTabAlpha = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(mCurrText.getLeft() - mTabPadding, i1, mCurrText.getRight() + mTabPadding, i);
    invalidate(localRect);
  }
}
