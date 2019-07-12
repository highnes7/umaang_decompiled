package android.support.design.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class MatrixEvaluator
  implements TypeEvaluator<Matrix>
{
  public final float[] tempEndValues = new float[9];
  public final Matrix tempMatrix = new Matrix();
  public final float[] tempStartValues = new float[9];
  
  public MatrixEvaluator() {}
  
  public Matrix evaluate(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    paramMatrix1.getValues(tempStartValues);
    paramMatrix2.getValues(tempEndValues);
    int i = 0;
    while (i < 9)
    {
      paramMatrix1 = tempEndValues;
      float f = paramMatrix1[i];
      paramMatrix2 = tempStartValues;
      paramMatrix1[i] = ((f - paramMatrix2[i]) * paramFloat + paramMatrix2[i]);
      i += 1;
    }
    tempMatrix.setValues(tempEndValues);
    return tempMatrix;
  }
}
