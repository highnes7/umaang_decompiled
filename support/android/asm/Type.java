package support.android.asm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Type
{
  public static final int MB = 1048576;
  public static final boolean a;
  public static final boolean b;
  public static final boolean c;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    a = true;
    c = true;
    if (i < 28) {
      bool = false;
    }
    b = bool;
  }
  
  public Type() {}
  
  public static View a(ViewGroup paramViewGroup, View paramView1, View paramView2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    Frame.a.b(paramView1, localMatrix);
    Frame.a.draw(paramViewGroup, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    localMatrix.mapRect(localRectF);
    int i = Math.round(left);
    int j = Math.round(top);
    int k = Math.round(right);
    int m = Math.round(bottom);
    paramView2 = new ImageView(paramView1.getContext());
    paramView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup = draw(paramView1, localMatrix, localRectF, paramViewGroup);
    if (paramViewGroup != null) {
      paramView2.setImageBitmap(paramViewGroup);
    }
    paramView2.measure(View.MeasureSpec.makeMeasureSpec(k - i, 1073741824), View.MeasureSpec.makeMeasureSpec(m - j, 1073741824));
    paramView2.layout(i, j, k, m);
    return paramView2;
  }
  
  public static Bitmap draw(View paramView, Matrix paramMatrix, RectF paramRectF, ViewGroup paramViewGroup)
  {
    boolean bool2 = a;
    int i = 0;
    boolean bool1;
    if (bool2)
    {
      bool1 = paramView.isAttachedToWindow() ^ true;
      if (paramViewGroup != null)
      {
        bool2 = paramViewGroup.isAttachedToWindow();
        break label43;
      }
    }
    else
    {
      bool1 = false;
    }
    bool2 = false;
    label43:
    boolean bool3 = c;
    Object localObject2 = null;
    ViewGroup localViewGroup;
    if ((bool3) && (bool1))
    {
      if (!bool2) {
        return null;
      }
      localViewGroup = (ViewGroup)paramView.getParent();
      i = localViewGroup.indexOfChild(paramView);
      paramViewGroup.getOverlay().add(paramView);
    }
    else
    {
      localViewGroup = null;
    }
    int k = Math.round(paramRectF.width());
    int j = Math.round(paramRectF.height());
    Object localObject1 = localObject2;
    if (k > 0)
    {
      localObject1 = localObject2;
      if (j > 0)
      {
        float f = Math.min(1.0F, 1048576.0F / (k * j));
        k = Math.round(k * f);
        j = Math.round(j * f);
        paramMatrix.postTranslate(-left, -top);
        paramMatrix.postScale(f, f);
        if (b)
        {
          paramRectF = new Picture();
          localObject1 = paramRectF.beginRecording(k, j);
          ((Canvas)localObject1).concat(paramMatrix);
          paramView.draw((Canvas)localObject1);
          paramRectF.endRecording();
          localObject1 = Bitmap.createBitmap(paramRectF);
        }
        else
        {
          paramRectF = Bitmap.createBitmap(k, j, Bitmap.Config.ARGB_8888);
          localObject1 = paramRectF;
          paramRectF = new Canvas(paramRectF);
          paramRectF.concat(paramMatrix);
          paramView.draw(paramRectF);
        }
      }
    }
    if ((c) && (bool1))
    {
      paramViewGroup.getOverlay().remove(paramView);
      localViewGroup.addView(paramView, i);
    }
    return localObject1;
  }
  
  public static Animator loadAnimator(Animator paramAnimator1, Animator paramAnimator2)
  {
    if (paramAnimator1 == null) {
      return paramAnimator2;
    }
    if (paramAnimator2 == null) {
      return paramAnimator1;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return localAnimatorSet;
  }
}
