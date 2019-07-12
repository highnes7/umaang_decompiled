package android.support.design.bottomappbar;

import android.support.design.shape.EdgeTreatment;
import android.support.design.shape.ShapePath;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

public class BottomAppBarTopEdgeTreatment
  extends EdgeTreatment
{
  public static final int ANGLE_LEFT = 180;
  public static final int ANGLE_UP = 270;
  public static final int ARC_HALF = 180;
  public static final int ARC_QUARTER = 90;
  public float cradleVerticalOffset;
  public float fabDiameter;
  public float fabMargin;
  public float horizontalOffset;
  public float roundedCornerRadius;
  
  public BottomAppBarTopEdgeTreatment(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    fabMargin = paramFloat1;
    roundedCornerRadius = paramFloat2;
    cradleVerticalOffset = paramFloat3;
    if (paramFloat3 >= 0.0F)
    {
      horizontalOffset = 0.0F;
      return;
    }
    throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
  }
  
  public float getCradleVerticalOffset()
  {
    return cradleVerticalOffset;
  }
  
  public void getEdgePath(float paramFloat1, float paramFloat2, ShapePath paramShapePath)
  {
    float f1 = fabDiameter;
    if (f1 == 0.0F)
    {
      paramShapePath.lineTo(paramFloat1, 0.0F);
      return;
    }
    f1 = (fabMargin * 2.0F + f1) / 2.0F;
    float f2 = paramFloat2 * roundedCornerRadius;
    float f3 = paramFloat1 / 2.0F + horizontalOffset;
    paramFloat2 = StringBuilder.append(1.0F, paramFloat2, f1, cradleVerticalOffset * paramFloat2);
    if (paramFloat2 / f1 >= 1.0F)
    {
      paramShapePath.lineTo(paramFloat1, 0.0F);
      return;
    }
    float f4 = f1 + f2;
    float f6 = paramFloat2 + f2;
    float f7 = (float)Math.sqrt(f4 * f4 - f6 * f6);
    f4 = f3 - f7;
    float f5 = f3 + f7;
    f6 = (float)Math.toDegrees(Math.atan(f7 / f6));
    f7 = 90.0F - f6;
    float f8 = f4 - f2;
    paramShapePath.lineTo(f8, 0.0F);
    float f9 = f2 * 2.0F;
    paramShapePath.addArc(f8, 0.0F, f4 + f2, f9, 270.0F, f6);
    paramShapePath.addArc(f3 - f1, -f1 - paramFloat2, f3 + f1, f1 - paramFloat2, 180.0F - f7, f7 * 2.0F - 180.0F);
    paramShapePath.addArc(f5 - f2, 0.0F, f5 + f2, f9, 270.0F - f6, f6);
    paramShapePath.lineTo(paramFloat1, 0.0F);
  }
  
  public float getFabCradleMargin()
  {
    return fabMargin;
  }
  
  public float getFabCradleRoundedCornerRadius()
  {
    return roundedCornerRadius;
  }
  
  public float getFabDiameter()
  {
    return fabDiameter;
  }
  
  public float getHorizontalOffset()
  {
    return horizontalOffset;
  }
  
  public void setCradleVerticalOffset(float paramFloat)
  {
    cradleVerticalOffset = paramFloat;
  }
  
  public void setFabCradleMargin(float paramFloat)
  {
    fabMargin = paramFloat;
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    roundedCornerRadius = paramFloat;
  }
  
  public void setFabDiameter(float paramFloat)
  {
    fabDiameter = paramFloat;
  }
  
  public void setHorizontalOffset(float paramFloat)
  {
    horizontalOffset = paramFloat;
  }
}
