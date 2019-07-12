package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;
import b.b.a.N;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import support.android.v4.view.GravityCompat;
import support.android.v4.view.ViewCompat;

public class LinearLayoutCompat
  extends ViewGroup
{
  public static final int HORIZONTAL = 0;
  public static final int INDEX_BOTTOM = 2;
  public static final int INDEX_CENTER_VERTICAL = 0;
  public static final int INDEX_FILL = 3;
  public static final int INDEX_TOP = 1;
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  public static final int SHOW_DIVIDER_END = 4;
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  public static final int SHOW_DIVIDER_NONE = 0;
  public static final int VERTICAL = 1;
  public static final int VERTICAL_GRAVITY_COUNT = 4;
  public boolean mBaselineAligned = true;
  public int mBaselineAlignedChildIndex = -1;
  public int mBaselineChildTop = 0;
  public Drawable mDivider;
  public int mDividerHeight;
  public int mDividerPadding;
  public int mDividerWidth;
  public int mGravity = 8388659;
  public int[] mMaxAscent;
  public int[] mMaxDescent;
  public int mOrientation;
  public int mShowDividers;
  public int mTotalLength;
  public boolean mUseLargestChild;
  public float mWeightSum;
  
  public LinearLayoutCompat(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    paramInt = paramContext.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramContext.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramContext.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    mWeightSum = paramContext.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    mBaselineAlignedChildIndex = paramContext.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    mUseLargestChild = paramContext.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(paramContext.getDrawable(R.styleable.LinearLayoutCompat_divider));
    mShowDividers = paramContext.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    mDividerPadding = paramContext.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    paramContext.recycle();
  }
  
  private void forceUniformHeight(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (height == -1)
        {
          int k = width;
          width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, j, 0);
          width = k;
        }
      }
      i += 1;
    }
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (width == -1)
        {
          int k = height;
          height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, j, 0, paramInt2, 0);
          height = k;
        }
      }
      i += 1;
    }
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void drawDividersHorizontal(Canvas paramCanvas)
  {
    int k = getVirtualChildCount();
    boolean bool = ViewUtils.isLayoutRtl(this);
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    int j;
    while (i < k)
    {
      localView = getVirtualChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (bool) {
          j = localView.getRight() + rightMargin;
        } else {
          j = localView.getLeft() - leftMargin - mDividerWidth;
        }
        drawVerticalDivider(paramCanvas, j);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(k))
    {
      localView = getVirtualChildAt(k - 1);
      if (localView == null)
      {
        if (bool)
        {
          i = getPaddingLeft();
          break label216;
        }
        i = getWidth() - getPaddingRight();
        j = mDividerWidth;
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!bool) {
          break label204;
        }
        i = localView.getLeft() - leftMargin;
        j = mDividerWidth;
      }
      i -= j;
      break label216;
      label204:
      i = localView.getRight() + rightMargin;
      label216:
      drawVerticalDivider(paramCanvas, i);
    }
  }
  
  public void drawDividersVertical(Canvas paramCanvas)
  {
    int j = getVirtualChildCount();
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (i < j)
    {
      localView = getVirtualChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        drawHorizontalDivider(paramCanvas, localView.getTop() - topMargin - mDividerHeight);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(j))
    {
      localView = getVirtualChildAt(j - 1);
      if (localView == null)
      {
        i = getHeight() - getPaddingBottom() - mDividerHeight;
      }
      else
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i = localView.getBottom() + bottomMargin;
      }
      drawHorizontalDivider(paramCanvas, i);
    }
  }
  
  public void drawHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    mDivider.setBounds(getPaddingLeft() + mDividerPadding, paramInt, getWidth() - getPaddingRight() - mDividerPadding, mDividerHeight + paramInt);
    mDivider.draw(paramCanvas);
  }
  
  public void drawVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    mDivider.setBounds(paramInt, getPaddingTop() + mDividerPadding, mDividerWidth + paramInt, getHeight() - getPaddingBottom() - mDividerPadding);
    mDivider.draw(paramCanvas);
  }
  
  public LayoutParams generateDefaultLayoutParams()
  {
    int i = mOrientation;
    if (i == 0) {
      return new LayoutParams(-2, -2);
    }
    if (i == 1) {
      return new LayoutParams(-1, -2);
    }
    return null;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    if (mBaselineAlignedChildIndex < 0) {
      return super.getBaseline();
    }
    int i = getChildCount();
    int j = mBaselineAlignedChildIndex;
    if (i > j)
    {
      View localView = getChildAt(j);
      int k = localView.getBaseline();
      if (k == -1)
      {
        if (mBaselineAlignedChildIndex == 0) {
          return -1;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      }
      j = mBaselineChildTop;
      i = j;
      if (mOrientation == 1)
      {
        int m = mGravity & 0x70;
        i = j;
        if (m != 48) {
          if (m != 16)
          {
            if (m != 80) {
              i = j;
            } else {
              i = getBottom() - getTop() - getPaddingBottom() - mTotalLength;
            }
          }
          else {
            i = j + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - mTotalLength) / 2;
          }
        }
      }
      return i + getLayoutParamstopMargin + k;
    }
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return mBaselineAlignedChildIndex;
  }
  
  public int getChildrenSkipCount(View paramView, int paramInt)
  {
    return 0;
  }
  
  public Drawable getDividerDrawable()
  {
    return mDivider;
  }
  
  public int getDividerPadding()
  {
    return mDividerPadding;
  }
  
  public int getDividerWidth()
  {
    return mDividerWidth;
  }
  
  public int getGravity()
  {
    return mGravity;
  }
  
  public int getLocationOffset(View paramView)
  {
    return 0;
  }
  
  public int getNextLocationOffset(View paramView)
  {
    return 0;
  }
  
  public int getOrientation()
  {
    return mOrientation;
  }
  
  public int getShowDividers()
  {
    return mShowDividers;
  }
  
  public View getVirtualChildAt(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  public int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return mWeightSum;
  }
  
  public boolean hasDividerBeforeChildAt(int paramInt)
  {
    if (paramInt == 0)
    {
      if ((mShowDividers & 0x1) != 0) {
        return true;
      }
    }
    else if (paramInt == getChildCount())
    {
      if ((mShowDividers & 0x4) != 0) {
        return true;
      }
    }
    else if ((mShowDividers & 0x2) != 0)
    {
      paramInt -= 1;
      while (paramInt >= 0)
      {
        if (getChildAt(paramInt).getVisibility() != 8) {
          return true;
        }
        paramInt -= 1;
      }
    }
    return false;
  }
  
  public boolean isBaselineAligned()
  {
    return mBaselineAligned;
  }
  
  public boolean isMeasureWithLargestChildEnabled()
  {
    return mUseLargestChild;
  }
  
  public void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.isLayoutRtl(this);
    int k = getPaddingTop();
    int n = paramInt4 - paramInt2;
    int i1 = getPaddingBottom();
    int i2 = getPaddingBottom();
    int i3 = getVirtualChildCount();
    int i4 = mGravity;
    boolean bool2 = mBaselineAligned;
    int[] arrayOfInt1 = mMaxAscent;
    int[] arrayOfInt2 = mMaxDescent;
    paramInt2 = GravityCompat.getAbsoluteGravity(0x800007 & i4, ViewCompat.getLayoutDirection(this));
    if (paramInt2 != 1)
    {
      if (paramInt2 != 5) {
        paramInt1 = getPaddingLeft();
      } else {
        paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - mTotalLength;
      }
    }
    else {
      paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - mTotalLength) / 2;
    }
    int i;
    if (bool1)
    {
      i = i3 - 1;
      paramInt4 = -1;
    }
    else
    {
      i = 0;
      paramInt4 = 1;
    }
    paramInt2 = 0;
    for (paramInt3 = paramInt1; paramInt2 < i3; paramInt3 = paramInt1)
    {
      int i5 = paramInt4 * paramInt2 + i;
      View localView = getVirtualChildAt(i5);
      int j;
      if (localView == null)
      {
        paramInt1 = measureNullChild(i5) + paramInt3;
        j = paramInt2;
      }
      else
      {
        j = paramInt2;
        paramInt1 = paramInt3;
        if (localView.getVisibility() != 8)
        {
          int i6 = localView.getMeasuredWidth();
          int i7 = localView.getMeasuredHeight();
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if ((bool2) && (height != -1)) {
            j = localView.getBaseline();
          } else {
            j = -1;
          }
          int m = gravity;
          paramInt1 = m;
          if (m < 0) {
            paramInt1 = i4 & 0x70;
          }
          paramInt1 &= 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 48)
            {
              if (paramInt1 != 80) {
                paramInt1 = k;
              }
              for (;;)
              {
                break;
                m = n - i1 - i7 - bottomMargin;
                paramInt1 = m;
                if (j != -1)
                {
                  paramInt1 = localView.getMeasuredHeight();
                  paramInt1 = m - (arrayOfInt2[2] - (paramInt1 - j));
                }
              }
            }
            paramInt1 = topMargin + k;
            if (j != -1) {
              paramInt1 = arrayOfInt1[1] - j + paramInt1;
            }
          }
          else
          {
            paramInt1 = (n - k - i2 - i7) / 2 + k + topMargin - bottomMargin;
          }
          j = paramInt3;
          if (hasDividerBeforeChildAt(i5)) {
            j = paramInt3 + mDividerWidth;
          }
          paramInt3 = leftMargin + j;
          setChildFrame(localView, getLocationOffset(localView) + paramInt3, paramInt1, i6, i7);
          paramInt1 = rightMargin;
          paramInt1 = getNextLocationOffset(localView) + (i6 + paramInt1) + paramInt3;
          j = getChildrenSkipCount(localView, i5) + paramInt2;
        }
      }
      paramInt2 = j + 1;
    }
  }
  
  public void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    int n = getVirtualChildCount();
    int i1 = mGravity;
    paramInt1 = i1 & 0x70;
    if (paramInt1 != 16)
    {
      if (paramInt1 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - mTotalLength;
      }
    }
    else {
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - mTotalLength) / 2;
    }
    paramInt2 = 0;
    while (paramInt2 < n)
    {
      View localView = getVirtualChildAt(paramInt2);
      if (localView == null)
      {
        paramInt3 = measureNullChild(paramInt2) + paramInt1;
        paramInt4 = paramInt2;
      }
      else
      {
        paramInt3 = paramInt1;
        paramInt4 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          int i3 = localView.getMeasuredWidth();
          int i2 = localView.getMeasuredHeight();
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          paramInt4 = gravity;
          paramInt3 = paramInt4;
          if (paramInt4 < 0) {
            paramInt3 = i1 & 0x800007;
          }
          paramInt3 = GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(this)) & 0x7;
          if (paramInt3 != 1) {
            if (paramInt3 != 5) {
              paramInt3 = leftMargin + i;
            }
          }
          for (;;)
          {
            break;
            paramInt3 = j - k - i3;
            paramInt4 = rightMargin;
            break label274;
            paramInt3 = (j - i - m - i3) / 2 + i + leftMargin;
            paramInt4 = rightMargin;
            label274:
            paramInt3 -= paramInt4;
          }
          paramInt4 = paramInt1;
          if (hasDividerBeforeChildAt(paramInt2)) {
            paramInt4 = paramInt1 + mDividerHeight;
          }
          paramInt1 = paramInt4 + topMargin;
          setChildFrame(localView, paramInt3, getLocationOffset(localView) + paramInt1, i3, i2);
          paramInt3 = bottomMargin;
          paramInt3 = getNextLocationOffset(localView) + (i2 + paramInt3) + paramInt1;
          paramInt4 = paramInt2 + getChildrenSkipCount(localView, paramInt2);
        }
      }
      paramInt2 = paramInt4 + 1;
      paramInt1 = paramInt3;
    }
  }
  
  public void measureChildBeforeLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void measureHorizontal(int paramInt1, int paramInt2)
  {
    mTotalLength = 0;
    int i11 = getVirtualChildCount();
    int i13 = View.MeasureSpec.getMode(paramInt1);
    int i12 = View.MeasureSpec.getMode(paramInt2);
    if ((mMaxAscent == null) || (mMaxDescent == null))
    {
      mMaxAscent = new int[4];
      mMaxDescent = new int[4];
    }
    int[] arrayOfInt1 = mMaxAscent;
    int[] arrayOfInt2 = mMaxDescent;
    arrayOfInt1[3] = -1;
    arrayOfInt1[2] = -1;
    arrayOfInt1[1] = -1;
    arrayOfInt1[0] = -1;
    arrayOfInt2[3] = -1;
    arrayOfInt2[2] = -1;
    arrayOfInt2[1] = -1;
    arrayOfInt2[0] = -1;
    boolean bool1 = mBaselineAligned;
    boolean bool2 = mUseLargestChild;
    int i7;
    if (i13 == 1073741824) {
      i7 = 1;
    } else {
      i7 = 0;
    }
    float f1 = 0.0F;
    int k = 0;
    int i2 = 0;
    int m = 0;
    int j = 0;
    int i1 = 0;
    int i3 = 0;
    int i4 = 0;
    int i = 1;
    int n = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (k < i11)
    {
      localView = getVirtualChildAt(k);
      if (localView == null)
      {
        i5 = mTotalLength;
        mTotalLength = (measureNullChild(k) + i5);
      }
      for (;;)
      {
        break;
        if (localView.getVisibility() == 8)
        {
          k += getChildrenSkipCount(localView, k);
        }
        else
        {
          if (hasDividerBeforeChildAt(k)) {
            mTotalLength += mDividerWidth;
          }
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          f1 += weight;
          if ((i13 == 1073741824) && (width == 0) && (weight > 0.0F))
          {
            if (i7 != 0)
            {
              i5 = mTotalLength;
              mTotalLength = (leftMargin + rightMargin + i5);
            }
            else
            {
              i5 = mTotalLength;
              mTotalLength = Math.max(i5, leftMargin + i5 + rightMargin);
            }
            if (bool1)
            {
              i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
              localView.measure(i5, i5);
              i5 = i2;
              i6 = i3;
            }
            else
            {
              i6 = 1;
              i5 = i2;
            }
          }
          else
          {
            if ((width == 0) && (weight > 0.0F))
            {
              width = -2;
              i5 = 0;
            }
            else
            {
              i5 = Integer.MIN_VALUE;
            }
            if (f1 == 0.0F) {
              i6 = mTotalLength;
            } else {
              i6 = 0;
            }
            measureChildBeforeLayout(localView, k, paramInt1, i6, paramInt2, 0);
            if (i5 != Integer.MIN_VALUE) {
              width = i5;
            }
            i8 = localView.getMeasuredWidth();
            if (i7 != 0)
            {
              i5 = mTotalLength;
              i6 = leftMargin;
              i9 = rightMargin;
              mTotalLength = (getNextLocationOffset(localView) + (i6 + i8 + i9) + i5);
            }
            else
            {
              i5 = mTotalLength;
              i6 = leftMargin;
              i9 = rightMargin;
              mTotalLength = Math.max(i5, getNextLocationOffset(localView) + (i5 + i8 + i6 + i9));
            }
            i5 = i2;
            i6 = i3;
            if (bool2)
            {
              i5 = Math.max(i8, i2);
              i6 = i3;
            }
          }
          i8 = k;
          if ((i12 != 1073741824) && (height == -1))
          {
            k = 1;
            n = 1;
          }
          else
          {
            k = 0;
          }
          i2 = topMargin + bottomMargin;
          i3 = localView.getMeasuredHeight() + i2;
          int i9 = View.combineMeasuredStates(i4, localView.getMeasuredState());
          if (bool1)
          {
            int i14 = localView.getBaseline();
            if (i14 != -1)
            {
              int i10 = gravity;
              i4 = i10;
              if (i10 < 0) {
                i4 = mGravity;
              }
              i4 = ((i4 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              arrayOfInt1[i4] = Math.max(arrayOfInt1[i4], i14);
              arrayOfInt2[i4] = Math.max(arrayOfInt2[i4], i3 - i14);
            }
          }
          m = Math.max(m, i3);
          if ((i != 0) && (height == -1)) {
            i = 1;
          } else {
            i = 0;
          }
          if (weight > 0.0F)
          {
            if (k == 0) {
              i2 = i3;
            }
            i1 = Math.max(i1, i2);
          }
          else
          {
            if (k != 0) {
              i3 = i2;
            }
            j = Math.max(j, i3);
          }
          k = getChildrenSkipCount(localView, i8) + i8;
          i4 = i9;
          i3 = i6;
          i2 = i5;
        }
      }
      k += 1;
    }
    if ((mTotalLength > 0) && (hasDividerBeforeChildAt(i11))) {
      mTotalLength += mDividerWidth;
    }
    if ((arrayOfInt1[1] == -1) && (arrayOfInt1[0] == -1) && (arrayOfInt1[2] == -1) && (arrayOfInt1[3] == -1)) {
      break label1009;
    }
    k = Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2])));
    m = Math.max(m, Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))) + k);
    label1009:
    int i5 = m;
    if (bool2) {
      if (i13 != Integer.MIN_VALUE)
      {
        i5 = m;
        if (i13 != 0) {}
      }
      else
      {
        mTotalLength = 0;
        k = 0;
        for (;;)
        {
          i5 = m;
          if (k >= i11) {
            break;
          }
          localView = getVirtualChildAt(k);
          if (localView == null)
          {
            i5 = mTotalLength;
            mTotalLength = (measureNullChild(k) + i5);
          }
          else
          {
            if (localView.getVisibility() != 8) {
              break label1115;
            }
            k += getChildrenSkipCount(localView, k);
          }
          for (;;)
          {
            break;
            label1115:
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (i7 != 0)
            {
              i5 = mTotalLength;
              i6 = leftMargin;
              i8 = rightMargin;
              mTotalLength = (getNextLocationOffset(localView) + (i6 + i2 + i8) + i5);
            }
            else
            {
              i5 = mTotalLength;
              i6 = leftMargin;
              i8 = rightMargin;
              mTotalLength = Math.max(i5, getNextLocationOffset(localView) + (i5 + i2 + i6 + i8));
            }
          }
          k += 1;
        }
      }
    }
    k = mTotalLength;
    m = getPaddingLeft();
    mTotalLength = (getPaddingRight() + m + k);
    int i8 = View.resolveSizeAndState(Math.max(mTotalLength, getSuggestedMinimumWidth()), paramInt1, 0);
    int i6 = (0xFFFFFF & i8) - mTotalLength;
    if ((i3 == 0) && ((i6 == 0) || (f1 <= 0.0F)))
    {
      m = Math.max(j, i1);
      if ((bool2) && (i13 != 1073741824))
      {
        j = 0;
        while (j < i11)
        {
          localView = getVirtualChildAt(j);
          if ((localView != null) && (localView.getVisibility() != 8) && (getLayoutParamsweight > 0.0F)) {
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
          }
          j += 1;
        }
      }
      k = i5;
      j = m;
    }
    else
    {
      float f2 = mWeightSum;
      if (f2 > 0.0F) {
        f1 = f2;
      }
      arrayOfInt1[3] = -1;
      arrayOfInt1[2] = -1;
      arrayOfInt1[1] = -1;
      arrayOfInt1[0] = -1;
      arrayOfInt2[3] = -1;
      arrayOfInt2[2] = -1;
      arrayOfInt2[1] = -1;
      arrayOfInt2[0] = -1;
      mTotalLength = 0;
      i1 = -1;
      i2 = 0;
      k = i;
      m = j;
      j = i6;
      i = i4;
      while (i2 < i11)
      {
        localView = getVirtualChildAt(i2);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          f2 = weight;
          if (f2 > 0.0F)
          {
            i4 = (int)(j * f2 / f1);
            f1 -= f2;
            i3 = j - i4;
            j = getPaddingTop();
            i5 = ViewGroup.getChildMeasureSpec(paramInt2, getPaddingBottom() + j + topMargin + bottomMargin, height);
            if ((width == 0) && (i13 == 1073741824))
            {
              if (i4 > 0) {
                j = i4;
              } else {
                j = 0;
              }
              localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), i5);
            }
            else
            {
              i4 = localView.getMeasuredWidth() + i4;
              j = i4;
              if (i4 < 0) {
                j = 0;
              }
              localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), i5);
            }
            i = View.combineMeasuredStates(i, localView.getMeasuredState() & 0xFF000000);
            j = i3;
          }
          if (i7 != 0)
          {
            i3 = mTotalLength;
            i4 = localView.getMeasuredWidth();
            i5 = leftMargin;
            i6 = rightMargin;
            mTotalLength = (getNextLocationOffset(localView) + (i4 + i5 + i6) + i3);
          }
          else
          {
            i3 = mTotalLength;
            i4 = localView.getMeasuredWidth();
            i5 = leftMargin;
            i6 = rightMargin;
            mTotalLength = Math.max(i3, getNextLocationOffset(localView) + (i4 + i3 + i5 + i6));
          }
          if ((i12 != 1073741824) && (height == -1)) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          i6 = topMargin + bottomMargin;
          i5 = localView.getMeasuredHeight() + i6;
          i4 = Math.max(i1, i5);
          if (i3 != 0) {
            i1 = i6;
          } else {
            i1 = i5;
          }
          i3 = Math.max(m, i1);
          if ((k != 0) && (height == -1)) {
            k = 1;
          } else {
            k = 0;
          }
          if (bool1)
          {
            i6 = localView.getBaseline();
            if (i6 != -1)
            {
              i1 = gravity;
              m = i1;
              if (i1 < 0) {
                m = mGravity;
              }
              m = ((m & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
              arrayOfInt1[m] = Math.max(arrayOfInt1[m], i6);
              arrayOfInt2[m] = Math.max(arrayOfInt2[m], i5 - i6);
            }
          }
          i1 = i4;
          m = i3;
        }
        i2 += 1;
      }
      j = mTotalLength;
      i2 = getPaddingLeft();
      mTotalLength = (getPaddingRight() + i2 + j);
      if ((arrayOfInt1[1] == -1) && (arrayOfInt1[0] == -1) && (arrayOfInt1[2] == -1) && (arrayOfInt1[3] == -1))
      {
        j = i1;
      }
      else
      {
        j = Math.max(arrayOfInt1[3], Math.max(arrayOfInt1[0], Math.max(arrayOfInt1[1], arrayOfInt1[2])));
        j = Math.max(i1, Math.max(arrayOfInt2[3], Math.max(arrayOfInt2[0], Math.max(arrayOfInt2[1], arrayOfInt2[2]))) + j);
      }
      i4 = i;
      i = k;
      k = j;
      j = m;
    }
    if ((i != 0) || (i12 == 1073741824)) {
      j = k;
    }
    i = getPaddingTop();
    setMeasuredDimension(i8 | i4 & 0xFF000000, View.resolveSizeAndState(Math.max(getPaddingBottom() + i + j, getSuggestedMinimumHeight()), paramInt2, i4 << 16));
    if (n != 0) {
      forceUniformHeight(i11, paramInt1);
    }
  }
  
  public int measureNullChild(int paramInt)
  {
    return 0;
  }
  
  public void measureVertical(int paramInt1, int paramInt2)
  {
    mTotalLength = 0;
    int i2 = getVirtualChildCount();
    int i10 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i11 = mBaselineAlignedChildIndex;
    boolean bool = mUseLargestChild;
    float f1 = 0.0F;
    int i5 = 0;
    int i = 0;
    int i3 = 0;
    int i6 = 0;
    int k = 0;
    int m = 0;
    int i4 = 0;
    int j = 1;
    int n = 0;
    View localView;
    LayoutParams localLayoutParams;
    int i12;
    for (;;)
    {
      i7 = i6;
      if (m >= i2) {
        break;
      }
      localView = getVirtualChildAt(m);
      if (localView == null)
      {
        i7 = mTotalLength;
        mTotalLength = (measureNullChild(m) + i7);
      }
      for (;;)
      {
        i7 = m;
        break label685;
        if (localView.getVisibility() != 8) {
          break;
        }
        m += getChildrenSkipCount(localView, m);
      }
      if (hasDividerBeforeChildAt(m)) {
        mTotalLength += mDividerHeight;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      f1 += weight;
      if ((i1 == 1073741824) && (height == 0) && (weight > 0.0F))
      {
        i4 = mTotalLength;
        mTotalLength = Math.max(i4, topMargin + i4 + bottomMargin);
        i6 = 1;
        i8 = i;
        i = i3;
      }
      else
      {
        if ((height == 0) && (weight > 0.0F))
        {
          height = -2;
          i6 = 0;
        }
        else
        {
          i6 = Integer.MIN_VALUE;
        }
        if (f1 == 0.0F) {
          i8 = mTotalLength;
        } else {
          i8 = 0;
        }
        i9 = i;
        measureChildBeforeLayout(localView, m, paramInt1, 0, paramInt2, i8);
        if (i6 != Integer.MIN_VALUE) {
          height = i6;
        }
        i12 = localView.getMeasuredHeight();
        i = mTotalLength;
        i6 = topMargin;
        i8 = bottomMargin;
        mTotalLength = Math.max(i, getNextLocationOffset(localView) + (i + i12 + i6 + i8));
        i8 = i9;
        i = i3;
        i6 = i4;
        if (bool)
        {
          i = Math.max(i12, i3);
          i8 = i9;
          i6 = i4;
        }
      }
      i9 = m;
      if ((i11 >= 0) && (i11 == i9 + 1)) {
        mBaselineChildTop = mTotalLength;
      }
      if ((i9 < i11) && (weight > 0.0F)) {
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
      }
      if ((i10 != 1073741824) && (width == -1))
      {
        m = 1;
        n = 1;
      }
      else
      {
        m = 0;
      }
      i3 = leftMargin + rightMargin;
      i4 = localView.getMeasuredWidth() + i3;
      i8 = Math.max(i8, i4);
      i5 = View.combineMeasuredStates(i5, localView.getMeasuredState());
      if ((j != 0) && (width == -1)) {
        j = 1;
      } else {
        j = 0;
      }
      if (weight > 0.0F)
      {
        if (m == 0) {
          i3 = i4;
        }
        m = Math.max(i7, i3);
      }
      else
      {
        if (m == 0) {
          i3 = i4;
        }
        k = Math.max(k, i3);
        m = i7;
      }
      i4 = getChildrenSkipCount(localView, i9);
      i3 = m;
      m = i5;
      i7 = i4 + i9;
      i5 = i8;
      i4 = i6;
      i6 = i3;
      i3 = i;
      i = i5;
      i5 = m;
      label685:
      m = i7 + 1;
    }
    m = i;
    if ((mTotalLength > 0) && (hasDividerBeforeChildAt(i2))) {
      mTotalLength += mDividerHeight;
    }
    int i7 = i2;
    if ((bool) && ((i1 == Integer.MIN_VALUE) || (i1 == 0)))
    {
      mTotalLength = 0;
      i = 0;
      while (i < i7)
      {
        localView = getVirtualChildAt(i);
        if (localView == null)
        {
          i2 = mTotalLength;
          mTotalLength = (measureNullChild(i) + i2);
        }
        else if (localView.getVisibility() == 8)
        {
          i += getChildrenSkipCount(localView, i);
        }
        else
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          i2 = mTotalLength;
          i8 = topMargin;
          i9 = bottomMargin;
          mTotalLength = Math.max(i2, getNextLocationOffset(localView) + (i2 + i3 + i8 + i9));
        }
        i += 1;
      }
    }
    int i8 = i1;
    i = mTotalLength;
    i1 = getPaddingTop();
    mTotalLength = (getPaddingBottom() + i1 + i);
    int i9 = View.resolveSizeAndState(Math.max(mTotalLength, getSuggestedMinimumHeight()), paramInt2, 0);
    i1 = (0xFFFFFF & i9) - mTotalLength;
    if ((i4 == 0) && ((i1 == 0) || (f1 <= 0.0F)))
    {
      k = Math.max(k, i6);
      if ((bool) && (i8 != 1073741824))
      {
        i = 0;
        while (i < i7)
        {
          localView = getVirtualChildAt(i);
          if ((localView != null) && (localView.getVisibility() != 8) && (getLayoutParamsweight > 0.0F)) {
            localView.measure(View.MeasureSpec.makeMeasureSpec(localView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
          }
          i += 1;
        }
      }
      i = k;
    }
    else
    {
      float f2 = mWeightSum;
      if (f2 > 0.0F) {
        f1 = f2;
      }
      mTotalLength = 0;
      i2 = 0;
      i = i5;
      while (i2 < i7)
      {
        localView = getVirtualChildAt(i2);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          f2 = weight;
          if (f2 > 0.0F)
          {
            i4 = (int)(i1 * f2 / f1);
            i3 = i1 - i4;
            i1 = getPaddingLeft();
            i5 = getPaddingRight();
            i6 = leftMargin;
            i11 = rightMargin;
            i12 = width;
            f1 -= f2;
            i5 = ViewGroup.getChildMeasureSpec(paramInt1, i5 + i1 + i6 + i11, i12);
            if ((height == 0) && (i8 == 1073741824))
            {
              if (i4 > 0) {
                i1 = i4;
              } else {
                i1 = 0;
              }
              localView.measure(i5, View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
            }
            else
            {
              i4 = localView.getMeasuredHeight() + i4;
              i1 = i4;
              if (i4 < 0) {
                i1 = 0;
              }
              localView.measure(i5, View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
            }
            i = View.combineMeasuredStates(i, localView.getMeasuredState() & 0xFF00);
            i1 = i3;
          }
          i4 = leftMargin + rightMargin;
          i5 = localView.getMeasuredWidth() + i4;
          i3 = Math.max(m, i5);
          if ((i10 != 1073741824) && (width == -1)) {
            m = 1;
          } else {
            m = 0;
          }
          if (m != 0) {
            m = i4;
          } else {
            m = i5;
          }
          k = Math.max(k, m);
          if ((j != 0) && (width == -1)) {
            j = 1;
          } else {
            j = 0;
          }
          m = mTotalLength;
          i4 = localView.getMeasuredHeight();
          i5 = topMargin;
          i6 = bottomMargin;
          mTotalLength = Math.max(m, getNextLocationOffset(localView) + (i4 + m + i5 + i6));
          m = i3;
        }
        i2 += 1;
      }
      i1 = mTotalLength;
      i2 = getPaddingTop();
      mTotalLength = (getPaddingBottom() + i2 + i1);
      i5 = i;
      i = k;
    }
    if ((j != 0) || (i10 == 1073741824)) {
      i = m;
    }
    j = getPaddingLeft();
    setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + j + i, getSuggestedMinimumWidth()), paramInt1, i5), i9);
    if (n != 0) {
      forceUniformWidth(i7, paramInt2);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (mDivider == null) {
      return;
    }
    if (mOrientation == 1)
    {
      drawDividersVertical(paramCanvas);
      return;
    }
    drawDividersHorizontal(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (mOrientation == 1)
    {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (mOrientation == 1)
    {
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    mBaselineAligned = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount()))
    {
      mBaselineAlignedChildIndex = paramInt;
      return;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("base aligned child index out of range (0, ");
    localStringBuilder.append(getChildCount());
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == mDivider) {
      return;
    }
    mDivider = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null)
    {
      mDividerWidth = paramDrawable.getIntrinsicWidth();
      mDividerHeight = paramDrawable.getIntrinsicHeight();
    }
    else
    {
      mDividerWidth = 0;
      mDividerHeight = 0;
    }
    if (paramDrawable == null) {
      bool = true;
    }
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt)
  {
    mDividerPadding = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (mGravity != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    paramInt &= 0x800007;
    int i = mGravity;
    if ((0x800007 & i) != paramInt)
    {
      mGravity = (paramInt | 0xFF7FFFF8 & i);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    mUseLargestChild = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (mOrientation != paramInt)
    {
      mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != mShowDividers) {
      requestLayout();
    }
    mShowDividers = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    int i = mGravity;
    if ((i & 0x70) != paramInt)
    {
      mGravity = (paramInt | i & 0xFFFFFF8F);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    mWeightSum = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface DividerMode {}
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = -1;
    public float weight;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      weight = 0.0F;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, float paramFloat)
    {
      super(paramInt2);
      weight = paramFloat;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
      weight = paramContext.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      gravity = paramContext.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      weight = weight;
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
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface OrientationMode {}
}
