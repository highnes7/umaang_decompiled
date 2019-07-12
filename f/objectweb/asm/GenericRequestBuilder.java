package f.objectweb.asm;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public class GenericRequestBuilder
{
  public Object a;
  public final ValueAnimator mAnimator;
  
  public GenericRequestBuilder()
  {
    this(false);
  }
  
  public GenericRequestBuilder(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      return;
    }
    mAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  }
  
  public GenericRequestBuilder animate(int paramInt)
  {
    mAnimator.setRepeatCount(paramInt);
    return this;
  }
  
  public GenericRequestBuilder animate(long paramLong)
  {
    mAnimator.setDuration(paramLong);
    return this;
  }
  
  public GenericRequestBuilder animate(FixedStepHandler paramFixedStepHandler)
  {
    mAnimator.addUpdateListener(new HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.1(this, paramFixedStepHandler));
    return this;
  }
  
  public GenericRequestBuilder animate(Object paramObject)
  {
    a = paramObject;
    return this;
  }
  
  public ValueAnimator setDuration()
  {
    if (a != null) {
      mAnimator.addListener(new GlowPadView.2(this));
    }
    return mAnimator;
  }
  
  public GenericRequestBuilder setDuration(long paramLong)
  {
    mAnimator.setStartDelay(paramLong);
    return this;
  }
  
  public GenericRequestBuilder setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    mAnimator.setInterpolator(paramTimeInterpolator);
    return this;
  }
}
