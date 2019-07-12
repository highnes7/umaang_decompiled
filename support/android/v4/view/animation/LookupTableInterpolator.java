package support.android.v4.view.animation;

import android.view.animation.Interpolator;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

public abstract class LookupTableInterpolator
  implements Interpolator
{
  public final float mStepSize;
  public final float[] mValues;
  
  public LookupTableInterpolator(float[] paramArrayOfFloat)
  {
    mValues = paramArrayOfFloat;
    mStepSize = (1.0F / (mValues.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    float[] arrayOfFloat = mValues;
    int i = Math.min((int)((arrayOfFloat.length - 1) * paramFloat), arrayOfFloat.length - 2);
    float f1 = i;
    float f2 = mStepSize;
    paramFloat = (paramFloat - f1 * f2) / f2;
    arrayOfFloat = mValues;
    f1 = arrayOfFloat[i];
    return StringBuilder.append(arrayOfFloat[(i + 1)], arrayOfFloat[i], paramFloat, f1);
  }
}
