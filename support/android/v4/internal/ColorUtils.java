package support.android.v4.internal;

import android.graphics.Color;
import java.util.Objects;

public final class ColorUtils
{
  public static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
  public static final int MIN_ALPHA_SEARCH_PRECISION = 1;
  public static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal();
  public static final double XYZ_EPSILON = 0.008856D;
  public static final double XYZ_KAPPA = 903.3D;
  public static final double XYZ_WHITE_REFERENCE_X = 95.047D;
  public static final double XYZ_WHITE_REFERENCE_Y = 100.0D;
  public static final double XYZ_WHITE_REFERENCE_Z = 108.883D;
  
  public ColorUtils() {}
  
  public static int HSLToColor(float[] paramArrayOfFloat)
  {
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    f2 = (1.0F - Math.abs(f3 * 2.0F - 1.0F)) * f2;
    f3 -= 0.5F * f2;
    float f4 = (1.0F - Math.abs(f1 / 60.0F % 2.0F - 1.0F)) * f2;
    int j;
    int i;
    int k;
    switch ((int)f1 / 60)
    {
    default: 
      j = 0;
      i = 0;
      k = 0;
      break;
    case 5: 
    case 6: 
      i = Math.round((f2 + f3) * 255.0F);
      k = Math.round(f3 * 255.0F);
      j = Math.round((f4 + f3) * 255.0F);
      break;
    case 4: 
      i = Math.round((f4 + f3) * 255.0F);
      k = Math.round(f3 * 255.0F);
      j = Math.round((f2 + f3) * 255.0F);
      break;
    case 3: 
      i = Math.round(f3 * 255.0F);
      k = Math.round((f4 + f3) * 255.0F);
      j = Math.round((f2 + f3) * 255.0F);
      break;
    case 2: 
      i = Math.round(f3 * 255.0F);
      k = Math.round((f2 + f3) * 255.0F);
      j = Math.round((f4 + f3) * 255.0F);
      break;
    case 1: 
      i = Math.round((f4 + f3) * 255.0F);
      k = Math.round((f2 + f3) * 255.0F);
      j = Math.round(f3 * 255.0F);
      break;
    case 0: 
      i = Math.round((f2 + f3) * 255.0F);
      k = Math.round((f4 + f3) * 255.0F);
      j = Math.round(f3 * 255.0F);
    }
    return Color.rgb(constrain(i, 0, 255), constrain(k, 0, 255), constrain(j, 0, 255));
  }
  
  public static int LABToColor(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double[] arrayOfDouble = getTempDouble3Array();
    LABToXYZ(paramDouble1, paramDouble2, paramDouble3, arrayOfDouble);
    return XYZToColor(arrayOfDouble[0], arrayOfDouble[1], arrayOfDouble[2]);
  }
  
  public static void LABToXYZ(double paramDouble1, double paramDouble2, double paramDouble3, double[] paramArrayOfDouble)
  {
    double d1 = (paramDouble1 + 16.0D) / 116.0D;
    double d3 = paramDouble2 / 500.0D + d1;
    double d2 = d1 - paramDouble3 / 200.0D;
    paramDouble3 = Math.pow(d3, 3.0D);
    paramDouble2 = paramDouble3;
    if (paramDouble3 <= 0.008856D) {
      paramDouble2 = (d3 * 116.0D - 16.0D) / 903.3D;
    }
    if (paramDouble1 > 7.9996247999999985D) {
      paramDouble1 = Math.pow(d1, 3.0D);
    } else {
      paramDouble1 /= 903.3D;
    }
    d1 = Math.pow(d2, 3.0D);
    paramDouble3 = d1;
    if (d1 <= 0.008856D) {
      paramDouble3 = (d2 * 116.0D - 16.0D) / 903.3D;
    }
    paramArrayOfDouble[0] = (paramDouble2 * 95.047D);
    paramArrayOfDouble[1] = (paramDouble1 * 100.0D);
    paramArrayOfDouble[2] = (paramDouble3 * 108.883D);
  }
  
  public static void RGBToHSL(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat)
  {
    float f1 = paramInt1 / 255.0F;
    float f3 = paramInt2 / 255.0F;
    float f5 = paramInt3 / 255.0F;
    float f6 = Math.max(f1, Math.max(f3, f5));
    float f7 = Math.min(f1, Math.min(f3, f5));
    float f2 = f6 - f7;
    float f4 = (f6 + f7) / 2.0F;
    if (f6 == f7)
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    else
    {
      if (f6 == f1) {
        f1 = (f3 - f5) / f2 % 6.0F;
      } else if (f6 == f3) {
        f1 = (f5 - f1) / f2 + 2.0F;
      } else {
        f1 = (f1 - f3) / f2 + 4.0F;
      }
      f2 /= (1.0F - Math.abs(2.0F * f4 - 1.0F));
    }
    f3 = f1 * 60.0F % 360.0F;
    f1 = f3;
    if (f3 < 0.0F) {
      f1 = f3 + 360.0F;
    }
    paramArrayOfFloat[0] = constrain(f1, 0.0F, 360.0F);
    paramArrayOfFloat[1] = constrain(f2, 0.0F, 1.0F);
    paramArrayOfFloat[2] = constrain(f4, 0.0F, 1.0F);
  }
  
  public static void RGBToLAB(int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfDouble)
  {
    RGBToXYZ(paramInt1, paramInt2, paramInt3, paramArrayOfDouble);
    XYZToLAB(paramArrayOfDouble[0], paramArrayOfDouble[1], paramArrayOfDouble[2], paramArrayOfDouble);
  }
  
  public static void RGBToXYZ(int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length == 3)
    {
      double d1 = paramInt1;
      Double.isNaN(d1);
      d1 /= 255.0D;
      if (d1 < 0.04045D) {
        d1 /= 12.92D;
      } else {
        d1 = Math.pow((d1 + 0.055D) / 1.055D, 2.4D);
      }
      double d2 = paramInt2;
      Double.isNaN(d2);
      d2 /= 255.0D;
      if (d2 < 0.04045D) {
        d2 /= 12.92D;
      } else {
        d2 = Math.pow((d2 + 0.055D) / 1.055D, 2.4D);
      }
      double d3 = paramInt3;
      Double.isNaN(d3);
      d3 /= 255.0D;
      if (d3 < 0.04045D) {
        d3 /= 12.92D;
      } else {
        d3 = Math.pow((d3 + 0.055D) / 1.055D, 2.4D);
      }
      paramArrayOfDouble[0] = ((0.1805D * d3 + (0.3576D * d2 + 0.4124D * d1)) * 100.0D);
      paramArrayOfDouble[1] = ((0.0722D * d3 + (0.7152D * d2 + 0.2126D * d1)) * 100.0D);
      paramArrayOfDouble[2] = ((d3 * 0.9505D + (d2 * 0.1192D + d1 * 0.0193D)) * 100.0D);
      return;
    }
    throw new IllegalArgumentException("outXyz must have a length of 3.");
  }
  
  public static int XYZToColor(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d2 = (-0.4986D * paramDouble3 + (-1.5372D * paramDouble2 + 3.2406D * paramDouble1)) / 100.0D;
    double d1 = (0.0415D * paramDouble3 + (1.8758D * paramDouble2 + -0.9689D * paramDouble1)) / 100.0D;
    paramDouble3 = (1.057D * paramDouble3 + (-0.204D * paramDouble2 + 0.0557D * paramDouble1)) / 100.0D;
    if (d2 > 0.0031308D) {
      paramDouble1 = Math.pow(d2, 0.4166666666666667D) * 1.055D - 0.055D;
    } else {
      paramDouble1 = d2 * 12.92D;
    }
    if (d1 > 0.0031308D) {
      paramDouble2 = Math.pow(d1, 0.4166666666666667D) * 1.055D - 0.055D;
    } else {
      paramDouble2 = d1 * 12.92D;
    }
    if (paramDouble3 > 0.0031308D) {
      paramDouble3 = Math.pow(paramDouble3, 0.4166666666666667D) * 1.055D - 0.055D;
    } else {
      paramDouble3 *= 12.92D;
    }
    return Color.rgb(constrain((int)Math.round(paramDouble1 * 255.0D), 0, 255), constrain((int)Math.round(paramDouble2 * 255.0D), 0, 255), constrain((int)Math.round(paramDouble3 * 255.0D), 0, 255));
  }
  
  public static void XYZToLAB(double paramDouble1, double paramDouble2, double paramDouble3, double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length == 3)
    {
      paramDouble1 = pivotXyzComponent(paramDouble1 / 95.047D);
      paramDouble2 = pivotXyzComponent(paramDouble2 / 100.0D);
      paramDouble3 = pivotXyzComponent(paramDouble3 / 108.883D);
      paramArrayOfDouble[0] = Math.max(0.0D, 116.0D * paramDouble2 - 16.0D);
      paramArrayOfDouble[1] = ((paramDouble1 - paramDouble2) * 500.0D);
      paramArrayOfDouble[2] = ((paramDouble2 - paramDouble3) * 200.0D);
      return;
    }
    throw new IllegalArgumentException("outLab must have a length of 3.");
  }
  
  public static Color add(Color paramColor1, Color paramColor2)
  {
    if (Objects.equals(paramColor1.getModel(), paramColor2.getModel()))
    {
      if (!Objects.equals(paramColor2.getColorSpace(), paramColor1.getColorSpace())) {
        paramColor1 = paramColor1.convert(paramColor2.getColorSpace());
      }
      localObject = paramColor1.getComponents();
      float[] arrayOfFloat = paramColor2.getComponents();
      float f4 = paramColor1.alpha();
      float f2 = f4;
      float f3 = (1.0F - f4) * paramColor2.alpha();
      int j = paramColor2.getComponentCount() - 1;
      arrayOfFloat[j] = (f4 + f3);
      float f1 = f3;
      if (arrayOfFloat[j] > 0.0F)
      {
        f2 = f4 / arrayOfFloat[j];
        f1 = f3 / arrayOfFloat[j];
      }
      int i = 0;
      while (i < j)
      {
        f3 = localObject[i];
        arrayOfFloat[i] = (arrayOfFloat[i] * f1 + f3 * f2);
        i += 1;
      }
      return Color.valueOf(arrayOfFloat, paramColor2.getColorSpace());
    }
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Color models must match (");
    ((StringBuilder)localObject).append(paramColor1.getModel());
    ((StringBuilder)localObject).append(" vs. ");
    ((StringBuilder)localObject).append(paramColor2.getModel());
    ((StringBuilder)localObject).append(")");
    paramColor1 = new IllegalArgumentException(((StringBuilder)localObject).toString());
    throw paramColor1;
  }
  
  public static int blendARGB(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f3 * paramFloat + f2 * f1), (int)(f5 * paramFloat + f4 * f1), (int)(f7 * paramFloat + f6 * f1), (int)(f9 * paramFloat + f8 * f1));
  }
  
  public static void blendHSL(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat, float[] paramArrayOfFloat3)
  {
    if (paramArrayOfFloat3.length == 3)
    {
      float f1 = 1.0F - paramFloat;
      paramArrayOfFloat3[0] = circularInterpolate(paramArrayOfFloat1[0], paramArrayOfFloat2[0], paramFloat);
      float f2 = paramArrayOfFloat1[1];
      paramArrayOfFloat3[1] = (paramArrayOfFloat2[1] * paramFloat + f2 * f1);
      f2 = paramArrayOfFloat1[2];
      paramArrayOfFloat3[2] = (paramArrayOfFloat2[2] * paramFloat + f2 * f1);
      return;
    }
    throw new IllegalArgumentException("result must have a length of 3.");
  }
  
  public static void blendLAB(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double paramDouble, double[] paramArrayOfDouble3)
  {
    if (paramArrayOfDouble3.length == 3)
    {
      double d1 = 1.0D - paramDouble;
      double d2 = paramArrayOfDouble1[0];
      paramArrayOfDouble3[0] = (paramArrayOfDouble2[0] * paramDouble + d2 * d1);
      d2 = paramArrayOfDouble1[1];
      paramArrayOfDouble3[1] = (paramArrayOfDouble2[1] * paramDouble + d2 * d1);
      d2 = paramArrayOfDouble1[2];
      paramArrayOfDouble3[2] = (paramArrayOfDouble2[2] * paramDouble + d2 * d1);
      return;
    }
    throw new IllegalArgumentException("outResult must have a length of 3.");
  }
  
  public static double calculateContrast(int paramInt1, int paramInt2)
  {
    if (Color.alpha(paramInt2) == 255)
    {
      int i = paramInt1;
      if (Color.alpha(paramInt1) < 255) {
        i = compositeColors(paramInt1, paramInt2);
      }
      double d1 = calculateLuminance(i) + 0.05D;
      double d2 = calculateLuminance(paramInt2) + 0.05D;
      return Math.max(d1, d2) / Math.min(d1, d2);
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("background can not be translucent: #");
    localStringBuilder.append(Integer.toHexString(paramInt2));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static double calculateLuminance(int paramInt)
  {
    double[] arrayOfDouble = getTempDouble3Array();
    colorToXYZ(paramInt, arrayOfDouble);
    return arrayOfDouble[1] / 100.0D;
  }
  
  public static int calculateMinimumAlpha(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = Color.alpha(paramInt2);
    int j = 255;
    if (i == 255)
    {
      double d1 = calculateContrast(setAlphaComponent(paramInt1, 255), paramInt2);
      double d2 = paramFloat;
      if (d1 < d2) {
        return -1;
      }
      i = 0;
      int k = 0;
      while (i <= 10)
      {
        if (j - k <= 1) {
          break label152;
        }
        int m = (k + j) / 2;
        if (calculateContrast(setAlphaComponent(paramInt1, m), paramInt2) < d2) {
          k = m;
        } else {
          j = m;
        }
        i += 1;
      }
      return j;
    }
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("background can not be translucent: #");
    ((StringBuilder)localObject).append(Integer.toHexString(paramInt2));
    localObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
    throw ((Throwable)localObject);
    label152:
    return j;
  }
  
  public static float circularInterpolate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (Math.abs(paramFloat2 - paramFloat1) > 180.0F) {
      if (paramFloat2 > paramFloat1)
      {
        f1 = paramFloat1 + 360.0F;
        f2 = paramFloat2;
      }
      else
      {
        f2 = paramFloat2 + 360.0F;
        f1 = paramFloat1;
      }
    }
    return ((f2 - f1) * paramFloat3 + f1) % 360.0F;
  }
  
  public static void colorToHSL(int paramInt, float[] paramArrayOfFloat)
  {
    RGBToHSL(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfFloat);
  }
  
  public static void colorToLAB(int paramInt, double[] paramArrayOfDouble)
  {
    RGBToLAB(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfDouble);
  }
  
  public static void colorToXYZ(int paramInt, double[] paramArrayOfDouble)
  {
    RGBToXYZ(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfDouble);
  }
  
  public static int compositeAlpha(int paramInt1, int paramInt2)
  {
    return 255 - (255 - paramInt1) * (255 - paramInt2) / 255;
  }
  
  public static int compositeColors(int paramInt1, int paramInt2)
  {
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = compositeAlpha(j, i);
    return Color.argb(k, compositeComponent(Color.red(paramInt1), j, Color.red(paramInt2), i, k), compositeComponent(Color.green(paramInt1), j, Color.green(paramInt2), i, k), compositeComponent(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
  }
  
  public static int compositeComponent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return ((255 - paramInt2) * (paramInt3 * paramInt4) + paramInt1 * 255 * paramInt2) / (paramInt5 * 255);
  }
  
  public static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public static int constrain(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static double distanceEuclidean(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double d1 = Math.pow(paramArrayOfDouble1[0] - paramArrayOfDouble2[0], 2.0D);
    double d2 = Math.pow(paramArrayOfDouble1[1] - paramArrayOfDouble2[1], 2.0D);
    return Math.sqrt(Math.pow(paramArrayOfDouble1[2] - paramArrayOfDouble2[2], 2.0D) + (d2 + d1));
  }
  
  public static double[] getTempDouble3Array()
  {
    double[] arrayOfDouble2 = (double[])TEMP_ARRAY.get();
    double[] arrayOfDouble1 = arrayOfDouble2;
    if (arrayOfDouble2 == null)
    {
      arrayOfDouble1 = new double[3];
      TEMP_ARRAY.set(arrayOfDouble1);
    }
    return arrayOfDouble1;
  }
  
  public static double pivotXyzComponent(double paramDouble)
  {
    if (paramDouble > 0.008856D) {
      return Math.pow(paramDouble, 0.3333333333333333D);
    }
    return (paramDouble * 903.3D + 16.0D) / 116.0D;
  }
  
  public static int setAlphaComponent(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 255)) {
      return paramInt1 & 0xFFFFFF | paramInt2 << 24;
    }
    throw new IllegalArgumentException("alpha must be between 0 and 255.");
  }
}
