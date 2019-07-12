package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import support.android.asm.Edit;
import support.android.asm.Frame;
import support.android.asm.R.styleable;
import support.android.asm.l;
import support.android.asm.t;
import support.android.v4.content.asm.TypedArrayUtils;
import support.android.v4.view.ViewCompat;

public class Fade
  extends Visibility
{
  public static final String EVENTLOG_URL = "android:fade:transitionAlpha";
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final String LOG_TAG = "Fade";
  public static final int WEEKS_BUFFER = 1;
  
  public Fade() {}
  
  public Fade(int paramInt)
  {
    a(paramInt);
  }
  
  public Fade(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextAppearance);
    a(TypedArrayUtils.getString(paramContext, (XmlResourceParser)paramAttributeSet, "fadingMode", 0, next()));
    paramContext.recycle();
  }
  
  public static float a(Edit paramEdit, float paramFloat)
  {
    float f = paramFloat;
    if (paramEdit != null)
    {
      paramEdit = (Float)values.get("android:fade:transitionAlpha");
      f = paramFloat;
      if (paramEdit != null) {
        f = paramEdit.floatValue();
      }
    }
    return f;
  }
  
  private Animator createAnimation(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 == paramFloat2) {
      return null;
    }
    Frame.a.a(paramView, paramFloat1);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, Frame.c, new float[] { paramFloat2 });
    localObjectAnimator.addListener(new a(paramView));
    addListener(new t(this, paramView));
    return localObjectAnimator;
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    super.captureStartValues(paramEdit);
    values.put("android:fade:transitionAlpha", Float.valueOf(Frame.d(view)));
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, Edit paramEdit1, Edit paramEdit2)
  {
    float f1 = 0.0F;
    float f2 = a(paramEdit1, 0.0F);
    if (f2 != 1.0F) {
      f1 = f2;
    }
    return createAnimation(paramView, f1, 1.0F);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, Edit paramEdit1, Edit paramEdit2)
  {
    Frame.a.b(paramView);
    return createAnimation(paramView, a(paramEdit1, 1.0F), 0.0F);
  }
  
  private static class a
    extends AnimatorListenerAdapter
  {
    public boolean mCanceled = false;
    public final View this$0;
    
    public a(View paramView)
    {
      this$0 = paramView;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = this$0;
      Frame.a.a(paramAnimator, 1.0F);
      if (mCanceled) {
        this$0.setLayerType(0, null);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if ((ViewCompat.hasOverlappingRendering(this$0)) && (this$0.getLayerType() == 0))
      {
        mCanceled = true;
        this$0.setLayerType(2, null);
      }
    }
  }
}
