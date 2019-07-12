package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.b.a.N;
import java.util.Map;
import support.android.asm.Edit;

@N({b.b.a.N.a.b})
public class TextScale
  extends Transition
{
  public static final String PROPNAME_SCALE = "android:textscale:scale";
  
  public TextScale() {}
  
  private void captureValues(Edit paramEdit)
  {
    Object localObject = view;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      values.put("android:textscale:scale", Float.valueOf(((View)localObject).getScaleX()));
    }
  }
  
  public void captureEndValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public Animator createAnimator(final ViewGroup paramViewGroup, Edit paramEdit1, Edit paramEdit2)
  {
    if ((paramEdit1 != null) && (paramEdit2 != null) && ((view instanceof TextView)))
    {
      paramViewGroup = view;
      if (!(paramViewGroup instanceof TextView)) {
        return null;
      }
      paramViewGroup = (TextView)paramViewGroup;
      paramEdit1 = values;
      paramEdit2 = values;
      Object localObject = paramEdit1.get("android:textscale:scale");
      float f2 = 1.0F;
      float f1;
      if (localObject != null) {
        f1 = ((Float)paramEdit1.get("android:textscale:scale")).floatValue();
      } else {
        f1 = 1.0F;
      }
      if (paramEdit2.get("android:textscale:scale") != null) {
        f2 = ((Float)paramEdit2.get("android:textscale:scale")).floatValue();
      }
      if (f1 == f2) {
        return null;
      }
      paramEdit1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
      paramEdit1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramViewGroup.setScaleX(f);
          paramViewGroup.setScaleY(f);
        }
      });
      return paramEdit1;
    }
    return null;
  }
}
