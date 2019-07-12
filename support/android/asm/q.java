package support.android.asm;

import android.graphics.Rect;
import android.support.transition.Transition;
import android.view.View;
import android.view.ViewGroup;

public class q
  extends XYPlot
{
  public float f = 3.0F;
  
  public q() {}
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(paramFloat2 * paramFloat2 + paramFloat1 * paramFloat1);
  }
  
  public long a(ViewGroup paramViewGroup, Transition paramTransition, Edit paramEdit1, Edit paramEdit2)
  {
    if ((paramEdit1 == null) && (paramEdit2 == null)) {
      return 0L;
    }
    int i;
    if ((paramEdit2 != null) && (b(paramEdit1) != 0))
    {
      i = 1;
      paramEdit1 = paramEdit2;
    }
    else
    {
      i = -1;
    }
    int m = d(paramEdit1);
    int n = c(paramEdit1);
    paramEdit1 = paramTransition.getEpicenter();
    int j;
    int k;
    if (paramEdit1 != null)
    {
      j = paramEdit1.centerX();
      k = paramEdit1.centerY();
    }
    else
    {
      paramEdit1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramEdit1);
      j = paramEdit1[0];
      f1 = paramViewGroup.getWidth() / 2 + j;
      j = Math.round(paramViewGroup.getTranslationX() + f1);
      k = paramEdit1[1];
      f1 = paramViewGroup.getHeight() / 2 + k;
      k = Math.round(paramViewGroup.getTranslationY() + f1);
    }
    float f1 = a(m, n, j, k) / a(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    long l2 = paramTransition.getDuration();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 300L;
    }
    return Math.round((float)(l1 * i) / f * f1);
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      f = paramFloat;
      return;
    }
    throw new IllegalArgumentException("propagationSpeed may not be 0");
  }
}
