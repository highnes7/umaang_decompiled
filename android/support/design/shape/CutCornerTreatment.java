package android.support.design.shape;

import android.support.design.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class CutCornerTreatment
  extends CornerTreatment
{
  public final float size;
  
  public CutCornerTreatment(float paramFloat)
  {
    size = paramFloat;
  }
  
  public void getCornerPath(float paramFloat1, float paramFloat2, ShapePath paramShapePath)
  {
    paramShapePath.reset(0.0F, size * paramFloat2);
    double d2 = paramFloat1;
    double d3 = Math.sin(d2);
    double d4 = size;
    Double.isNaN(d4);
    double d1 = paramFloat2;
    Double.isNaN(d1);
    paramFloat1 = (float)(d3 * d4 * d1);
    d2 = Math.cos(d2);
    d3 = size;
    Double.isNaN(d3);
    Double.isNaN(d1);
    paramShapePath.lineTo(paramFloat1, (float)(d2 * d3 * d1));
  }
}
