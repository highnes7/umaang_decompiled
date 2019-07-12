package android.support.design.shape;

import android.support.design.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class TriangleEdgeTreatment
  extends EdgeTreatment
{
  public final boolean inside;
  public final float size;
  
  public TriangleEdgeTreatment(float paramFloat, boolean paramBoolean)
  {
    size = paramFloat;
    inside = paramBoolean;
  }
  
  public void getEdgePath(float paramFloat1, float paramFloat2, ShapePath paramShapePath)
  {
    float f2 = paramFloat1 / 2.0F;
    paramShapePath.lineTo(f2 - size * paramFloat2, 0.0F);
    float f1;
    if (inside) {
      f1 = size;
    } else {
      f1 = -size;
    }
    paramShapePath.lineTo(f2, f1 * paramFloat2);
    paramShapePath.lineTo(size * paramFloat2 + f2, 0.0F);
    paramShapePath.lineTo(paramFloat1, 0.0F);
  }
}
