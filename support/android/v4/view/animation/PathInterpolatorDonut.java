package support.android.v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

public class PathInterpolatorDonut
  implements Interpolator
{
  public static final float PRECISION = 0.002F;
  public final float[] mX;
  public final float[] mY;
  
  public PathInterpolatorDonut(float paramFloat1, float paramFloat2)
  {
    this(createQuad(paramFloat1, paramFloat2));
  }
  
  public PathInterpolatorDonut(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(createCubic(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public PathInterpolatorDonut(Path paramPath)
  {
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    mX = new float[j];
    mY = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      mX[i] = arrayOfFloat[0];
      mY[i] = arrayOfFloat[1];
      i += 1;
    }
  }
  
  public static Path createCubic(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    return localPath;
  }
  
  public static Path createQuad(float paramFloat1, float paramFloat2)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    return localPath;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int j = 0;
    int i = mX.length - 1;
    while (i - j > 1)
    {
      int k = (j + i) / 2;
      if (paramFloat < mX[k]) {
        i = k;
      } else {
        j = k;
      }
    }
    float[] arrayOfFloat = mX;
    float f = arrayOfFloat[i] - arrayOfFloat[j];
    if (f == 0.0F) {
      return mY[j];
    }
    paramFloat = (paramFloat - arrayOfFloat[j]) / f;
    arrayOfFloat = mY;
    f = arrayOfFloat[j];
    return StringBuilder.append(arrayOfFloat[i], f, paramFloat, f);
  }
}
