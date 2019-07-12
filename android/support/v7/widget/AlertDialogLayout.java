package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.id;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import b.b.a.N;
import support.android.v4.view.GravityCompat;
import support.android.v4.view.ViewCompat;

@N({b.b.a.N.a.b})
public class AlertDialogLayout
  extends LinearLayoutCompat
{
  public AlertDialogLayout(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public AlertDialogLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)localView.getLayoutParams();
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
  
  public static int resolveMinimumHeight(View paramView)
  {
    int i = ViewCompat.getMinimumHeight(paramView);
    if (i > 0) {
      return i;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getChildCount() == 1) {
        return resolveMinimumHeight(paramView.getChildAt(0));
      }
    }
    return 0;
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  private boolean tryOnMeasure(int paramInt1, int paramInt2)
  {
    int i5 = getChildCount();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    View localView;
    while (i < i5)
    {
      localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        j = localView.getId();
        if (j == R.id.topPanel)
        {
          localObject3 = localView;
        }
        else if (j == R.id.buttonPanel)
        {
          localObject2 = localView;
        }
        else
        {
          if ((j != R.id.contentPanel) && (j != R.id.customPanel)) {
            return false;
          }
          if (localObject1 != null) {
            return false;
          }
          localObject1 = localView;
        }
      }
      i += 1;
    }
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    i = getPaddingTop();
    int k = getPaddingBottom() + i;
    if (localObject3 != null)
    {
      localObject3.measure(paramInt1, 0);
      k += localObject3.getMeasuredHeight();
      j = View.combineMeasuredStates(0, localObject3.getMeasuredState());
    }
    else
    {
      j = 0;
    }
    int i1;
    if (localObject2 != null)
    {
      localObject2.measure(paramInt1, 0);
      m = resolveMinimumHeight(localObject2);
      i = m;
      i1 = localObject2.getMeasuredHeight() - m;
      k += m;
      j = View.combineMeasuredStates(j, localObject2.getMeasuredState());
    }
    else
    {
      i = 0;
      i1 = 0;
    }
    int i2;
    if (localObject1 != null)
    {
      if (i7 == 0) {
        m = 0;
      } else {
        m = View.MeasureSpec.makeMeasureSpec(Math.max(0, n - k), i7);
      }
      localObject1.measure(paramInt1, m);
      m = localObject1.getMeasuredHeight();
      i2 = m;
      k += m;
      j = View.combineMeasuredStates(j, localObject1.getMeasuredState());
    }
    else
    {
      i2 = 0;
    }
    int i4 = n - k;
    n = k;
    int m = j;
    int i3 = i4;
    if (localObject2 != null)
    {
      i1 = Math.min(i4, i1);
      m = i4;
      n = i;
      if (i1 > 0)
      {
        m = i4 - i1;
        n = i + i1;
      }
      localObject2.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
      n = k - i + localObject2.getMeasuredHeight();
      i = View.combineMeasuredStates(j, localObject2.getMeasuredState());
      i3 = m;
      m = i;
    }
    int j = n;
    i = m;
    if (localObject1 != null)
    {
      j = n;
      i = m;
      if (i3 > 0)
      {
        localObject1.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i2 + i3, i7));
        j = n - i2 + localObject1.getMeasuredHeight();
        i = View.combineMeasuredStates(m, localObject1.getMeasuredState());
      }
    }
    m = 0;
    for (k = 0; m < i5; k = n)
    {
      localView = getChildAt(m);
      n = k;
      if (localView.getVisibility() != 8) {
        n = Math.max(k, localView.getMeasuredWidth());
      }
      m += 1;
    }
    m = getPaddingLeft();
    setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + m + k, paramInt1, i), View.resolveSizeAndState(j, paramInt2, 0));
    if (i6 != 1073741824) {
      forceUniformWidth(i5, paramInt2);
    }
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int k = paramInt3 - paramInt1;
    int m = getPaddingRight();
    int n = getPaddingRight();
    paramInt1 = getMeasuredHeight();
    int i1 = getChildCount();
    int i2 = getGravity();
    paramInt3 = i2 & 0x70;
    if (paramInt3 != 16)
    {
      if (paramInt3 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - paramInt1;
      }
    }
    else
    {
      paramInt3 = getPaddingTop();
      paramInt1 = (paramInt4 - paramInt2 - paramInt1) / 2 + paramInt3;
    }
    Object localObject = getDividerDrawable();
    if (localObject == null) {
      paramInt2 = 0;
    } else {
      paramInt2 = ((Drawable)localObject).getIntrinsicHeight();
    }
    paramInt3 = 0;
    while (paramInt3 < i1)
    {
      localObject = getChildAt(paramInt3);
      paramInt4 = paramInt1;
      if (localObject != null)
      {
        paramInt4 = paramInt1;
        if (((View)localObject).getVisibility() != 8)
        {
          int i3 = ((View)localObject).getMeasuredWidth();
          int i4 = ((View)localObject).getMeasuredHeight();
          LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)((View)localObject).getLayoutParams();
          int i = gravity;
          paramInt4 = i;
          if (i < 0) {
            paramInt4 = i2 & 0x800007;
          }
          paramInt4 = GravityCompat.getAbsoluteGravity(paramInt4, ViewCompat.getLayoutDirection(this)) & 0x7;
          if (paramInt4 != 1)
          {
            if (paramInt4 != 5)
            {
              paramInt4 = leftMargin + j;
              break label308;
            }
            paramInt4 = k - m - i3;
            i = rightMargin;
          }
          else
          {
            paramInt4 = (k - j - n - i3) / 2 + j + leftMargin;
            i = rightMargin;
          }
          paramInt4 -= i;
          label308:
          i = paramInt1;
          if (hasDividerBeforeChildAt(paramInt3)) {
            i = paramInt1 + paramInt2;
          }
          paramInt1 = i + topMargin;
          setChildFrame((View)localObject, paramInt4, paramInt1, i3, i4);
          paramInt4 = i4 + bottomMargin + paramInt1;
        }
      }
      paramInt3 += 1;
      paramInt1 = paramInt4;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (!tryOnMeasure(paramInt1, paramInt2))
    {
      if (mOrientation == 1)
      {
        measureVertical(paramInt1, paramInt2);
        return;
      }
      measureHorizontal(paramInt1, paramInt2);
    }
  }
}
