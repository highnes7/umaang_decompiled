package support.android.asm;

import android.animation.TypeEvaluator;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

public class UnivariatePeriodicInterpolator
  implements TypeEvaluator<float[]>
{
  public float[] period;
  
  public UnivariatePeriodicInterpolator(float[] paramArrayOfFloat)
  {
    period = paramArrayOfFloat;
  }
  
  public float[] interpolate(float paramFloat, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat2 = period;
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null) {
      arrayOfFloat1 = new float[paramArrayOfFloat1.length];
    }
    int i = 0;
    while (i < arrayOfFloat1.length)
    {
      float f = paramArrayOfFloat1[i];
      arrayOfFloat1[i] = StringBuilder.append(paramArrayOfFloat2[i], f, paramFloat, f);
      i += 1;
    }
    return arrayOfFloat1;
  }
}
