package support.android.asm;

import android.graphics.Rect;
import android.support.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import support.android.v4.view.ViewCompat;

public class Plot
  extends XYPlot
{
  public float d = 3.0F;
  public int g = 80;
  
  public Plot() {}
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int j = g;
    int k = 1;
    int i = 1;
    if (j == 8388611)
    {
      if (ViewCompat.getLayoutDirection(paramView) != 1) {
        i = 0;
      }
      if (i != 0)
      {
        i = 5;
        break label87;
      }
    }
    for (;;)
    {
      i = 3;
      break label87;
      i = j;
      if (j != 8388613) {
        break label87;
      }
      if (ViewCompat.getLayoutDirection(paramView) == 1) {
        i = k;
      } else {
        i = 0;
      }
      if (i == 0) {
        break;
      }
    }
    label87:
    if (i != 3)
    {
      if (i != 5)
      {
        if (i != 48)
        {
          if (i != 80) {
            return 0;
          }
          return Math.abs(paramInt3 - paramInt1) + (paramInt2 - paramInt6);
        }
        return Math.abs(paramInt3 - paramInt1) + (paramInt8 - paramInt2);
      }
      return Math.abs(paramInt4 - paramInt2) + (paramInt1 - paramInt5);
    }
    return Math.abs(paramInt4 - paramInt2) + (paramInt7 - paramInt1);
  }
  
  private int a(ViewGroup paramViewGroup)
  {
    int i = g;
    if ((i != 3) && (i != 5) && (i != 8388611) && (i != 8388613)) {
      return paramViewGroup.getHeight();
    }
    return paramViewGroup.getWidth();
  }
  
  public long a(ViewGroup paramViewGroup, Transition paramTransition, Edit paramEdit1, Edit paramEdit2)
  {
    Edit localEdit = paramEdit1;
    if ((paramEdit1 == null) && (paramEdit2 == null)) {
      return 0L;
    }
    Rect localRect = paramTransition.getEpicenter();
    int i;
    if ((paramEdit2 != null) && (b(paramEdit1) != 0))
    {
      i = 1;
    }
    else
    {
      i = -1;
      paramEdit2 = localEdit;
    }
    int m = d(paramEdit2);
    int n = c(paramEdit2);
    paramEdit1 = new int[2];
    paramViewGroup.getLocationOnScreen(paramEdit1);
    int i1 = paramEdit1[0] + Math.round(paramViewGroup.getTranslationX());
    int j = paramEdit1[1];
    int i2 = Math.round(paramViewGroup.getTranslationY()) + j;
    int i3 = paramViewGroup.getWidth() + i1;
    int i4 = paramViewGroup.getHeight() + i2;
    int k;
    if (localRect != null)
    {
      j = localRect.centerX();
      k = localRect.centerY();
    }
    else
    {
      j = (i1 + i3) / 2;
      k = (i2 + i4) / 2;
    }
    float f = a(paramViewGroup, m, n, j, k, i1, i2, i3, i4) / a(paramViewGroup);
    long l2 = paramTransition.getDuration();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 300L;
    }
    return Math.round((float)(l1 * i) / d * f);
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      d = paramFloat;
      return;
    }
    throw new IllegalArgumentException("propagationSpeed may not be 0");
  }
  
  public void setParent(int paramInt)
  {
    g = paramInt;
  }
}
