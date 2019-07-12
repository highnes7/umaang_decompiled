package android.support.design.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.design.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import b.b.a.N;
import support.android.v4.view.MarginLayoutParamsCompat;
import support.android.v4.view.ViewCompat;

@N({b.b.a.N.a.b})
public class FlowLayout
  extends ViewGroup
{
  public int itemSpacing;
  public int lineSpacing;
  public boolean singleLine = false;
  
  public FlowLayout(Context paramContext)
  {
    super(paramContext, null, 0);
    loadFromAttributes(paramContext, null);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    loadFromAttributes(paramContext, paramAttributeSet);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    loadFromAttributes(paramContext, paramAttributeSet);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    loadFromAttributes(paramContext, paramAttributeSet);
  }
  
  public static int getMeasuredDimension(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != Integer.MIN_VALUE)
    {
      if (paramInt2 != 1073741824) {
        return paramInt3;
      }
      return paramInt1;
    }
    return Math.min(paramInt3, paramInt1);
  }
  
  private void loadFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout, 0, 0);
    lineSpacing = paramContext.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
    itemSpacing = paramContext.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
    paramContext.recycle();
  }
  
  public int getItemSpacing()
  {
    return itemSpacing;
  }
  
  public int getLineSpacing()
  {
    return lineSpacing;
  }
  
  public boolean isSingleLine()
  {
    return singleLine;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {
      return;
    }
    paramInt2 = ViewCompat.getLayoutDirection(this);
    int i = 1;
    if (paramInt2 != 1) {
      i = 0;
    }
    if (i != 0) {
      paramInt2 = getPaddingRight();
    } else {
      paramInt2 = getPaddingLeft();
    }
    if (i != 0) {
      j = getPaddingLeft();
    } else {
      j = getPaddingRight();
    }
    paramInt4 = getPaddingTop();
    int k = paramInt4;
    int i2 = paramInt3 - paramInt1 - j;
    paramInt1 = paramInt2;
    int j = 0;
    paramInt3 = paramInt4;
    while (j < getChildCount())
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        Object localObject = localView.getLayoutParams();
        int m;
        int n;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          m = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)localObject);
          n = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)localObject);
        }
        else
        {
          n = 0;
          m = 0;
        }
        int i3 = localView.getMeasuredWidth();
        paramInt4 = paramInt3;
        int i1 = paramInt1;
        if (!singleLine)
        {
          paramInt4 = paramInt3;
          i1 = paramInt1;
          if (i3 + (paramInt1 + m) > i2)
          {
            paramInt4 = k + lineSpacing;
            i1 = paramInt2;
          }
        }
        paramInt1 = i1 + m;
        paramInt3 = localView.getMeasuredWidth() + paramInt1;
        k = localView.getMeasuredHeight() + paramInt4;
        if (i != 0) {
          localView.layout(i2 - paramInt3, paramInt4, i2 - i1 - m, k);
        } else {
          localView.layout(paramInt1, paramInt4, paramInt3, k);
        }
        paramInt1 = localView.getMeasuredWidth() + (m + n) + itemSpacing + i1;
        paramInt3 = paramInt4;
      }
      j += 1;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i8 = View.MeasureSpec.getSize(paramInt2);
    int i9 = View.MeasureSpec.getMode(paramInt2);
    int n;
    if ((i7 != Integer.MIN_VALUE) && (i7 != 1073741824)) {
      n = Integer.MAX_VALUE;
    } else {
      n = i6;
    }
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int i10 = getPaddingRight();
    int i2 = k;
    int i1 = 0;
    int i = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      int i3;
      if (localView.getVisibility() == 8)
      {
        i3 = j;
      }
      else
      {
        measureChild(localView, paramInt1, paramInt2);
        Object localObject = localView.getLayoutParams();
        int i4;
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          i3 = leftMargin + 0;
          i4 = rightMargin + 0;
        }
        else
        {
          i3 = 0;
          i4 = 0;
        }
        int m = k;
        int i5 = j;
        if (localView.getMeasuredWidth() + (j + i3) > n - i10)
        {
          m = k;
          i5 = j;
          if (!isSingleLine())
          {
            i5 = getPaddingLeft();
            m = lineSpacing + i2;
          }
        }
        k = i5 + i3 + localView.getMeasuredWidth();
        i2 = localView.getMeasuredHeight() + m;
        j = i;
        if (k > i) {
          j = k;
        }
        i3 = localView.getMeasuredWidth() + (i3 + i4) + itemSpacing + i5;
        k = m;
        i = j;
      }
      i1 += 1;
      j = i3;
    }
    setMeasuredDimension(getMeasuredDimension(i6, i7, i), getMeasuredDimension(i8, i9, i2));
  }
  
  public void setItemSpacing(int paramInt)
  {
    itemSpacing = paramInt;
  }
  
  public void setLineSpacing(int paramInt)
  {
    lineSpacing = paramInt;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    singleLine = paramBoolean;
  }
}
