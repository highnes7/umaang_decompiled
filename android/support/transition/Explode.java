package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.Map;
import support.android.asm.Edit;
import support.android.asm.R.id;
import support.android.asm.TranslationAnimationCreator;
import support.android.asm.q;

public class Explode
  extends Visibility
{
  public static final String EVENTLOG_URL = "android:explode:screenBounds";
  public static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
  public static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
  public int[] mTempLoc = new int[2];
  
  public Explode()
  {
    setPropagation(new q());
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setPropagation(new q());
  }
  
  public static float a(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat2 * paramFloat2 + paramFloat1 * paramFloat1);
  }
  
  public static float a(View paramView, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    return a(paramInt1, paramInt2);
  }
  
  private void captureValues(Edit paramEdit)
  {
    View localView = view;
    localView.getLocationOnScreen(mTempLoc);
    int[] arrayOfInt = mTempLoc;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    values.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  private void draw(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    paramView.getLocationOnScreen(mTempLoc);
    Object localObject = mTempLoc;
    int k = localObject[0];
    int m = localObject[1];
    localObject = getEpicenter();
    int i;
    int j;
    if (localObject == null)
    {
      i = paramView.getWidth() / 2;
      i = Math.round(paramView.getTranslationX()) + (i + k);
      j = paramView.getHeight() / 2;
      j = Math.round(paramView.getTranslationY()) + (j + m);
    }
    else
    {
      i = ((Rect)localObject).centerX();
      j = ((Rect)localObject).centerY();
    }
    int n = paramRect.centerX();
    int i1 = paramRect.centerY();
    float f3 = n - i;
    float f4 = i1 - j;
    float f1 = f4;
    float f2 = f3;
    if (f3 == 0.0F)
    {
      f1 = f4;
      f2 = f3;
      if (f4 == 0.0F)
      {
        f2 = (float)(Math.random() * 2.0D) - 1.0F;
        f1 = (float)(Math.random() * 2.0D) - 1.0F;
      }
    }
    f3 = a(f2, f1);
    f2 /= f3;
    f1 /= f3;
    f3 = a(paramView, i - k, j - m);
    paramArrayOfInt[0] = Math.round(f2 * f3);
    paramArrayOfInt[1] = Math.round(f3 * f1);
  }
  
  public void captureEndValues(Edit paramEdit)
  {
    super.captureEndValues(paramEdit);
    captureValues(paramEdit);
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    super.captureStartValues(paramEdit);
    captureValues(paramEdit);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, Edit paramEdit1, Edit paramEdit2)
  {
    if (paramEdit2 == null) {
      return null;
    }
    paramEdit1 = (Rect)values.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    draw(paramViewGroup, paramEdit1, mTempLoc);
    paramViewGroup = mTempLoc;
    float f3 = paramViewGroup[0];
    float f4 = paramViewGroup[1];
    return TranslationAnimationCreator.createAnimation(paramView, paramEdit2, left, top, f1 + f3, f2 + f4, f1, f2, sDecelerate);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, Edit paramEdit1, Edit paramEdit2)
  {
    if (paramEdit1 == null) {
      return null;
    }
    paramEdit2 = (Rect)values.get("android:explode:screenBounds");
    int i = left;
    int j = top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])view.getTag(R.id.transition_position);
    float f2;
    float f1;
    if (arrayOfInt != null)
    {
      f2 = arrayOfInt[0] - left + f3;
      f1 = arrayOfInt[1] - top + f4;
      paramEdit2.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    }
    else
    {
      f2 = f3;
      f1 = f4;
    }
    draw(paramViewGroup, paramEdit2, mTempLoc);
    paramViewGroup = mTempLoc;
    return TranslationAnimationCreator.createAnimation(paramView, paramEdit1, i, j, f3, f4, f2 + paramViewGroup[0], f1 + paramViewGroup[1], sAccelerate);
  }
}
