package support.android.asm;

import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;

public final class Matrix
  extends android.graphics.Matrix
{
  public Matrix() {}
  
  public boolean postConcat(android.graphics.Matrix paramMatrix)
  {
    validate();
    return false;
  }
  
  public boolean postRotate(float paramFloat)
  {
    validate();
    return false;
  }
  
  public boolean postRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    validate();
    return false;
  }
  
  public boolean postScale(float paramFloat1, float paramFloat2)
  {
    validate();
    return false;
  }
  
  public boolean postScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    validate();
    return false;
  }
  
  public boolean postSkew(float paramFloat1, float paramFloat2)
  {
    validate();
    return false;
  }
  
  public boolean postSkew(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    validate();
    return false;
  }
  
  public boolean postTranslate(float paramFloat1, float paramFloat2)
  {
    validate();
    return false;
  }
  
  public boolean preConcat(android.graphics.Matrix paramMatrix)
  {
    validate();
    return false;
  }
  
  public boolean preRotate(float paramFloat)
  {
    validate();
    return false;
  }
  
  public boolean preRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    validate();
    return false;
  }
  
  public boolean preScale(float paramFloat1, float paramFloat2)
  {
    validate();
    return false;
  }
  
  public boolean preScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    validate();
    return false;
  }
  
  public boolean preSkew(float paramFloat1, float paramFloat2)
  {
    validate();
    return false;
  }
  
  public boolean preSkew(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    validate();
    return false;
  }
  
  public boolean preTranslate(float paramFloat1, float paramFloat2)
  {
    validate();
    return false;
  }
  
  public void reset()
  {
    validate();
  }
  
  public void set(android.graphics.Matrix paramMatrix)
  {
    validate();
  }
  
  public boolean setConcat(android.graphics.Matrix paramMatrix1, android.graphics.Matrix paramMatrix2)
  {
    validate();
    return false;
  }
  
  public boolean setPolyToPoly(float[] paramArrayOfFloat1, int paramInt1, float[] paramArrayOfFloat2, int paramInt2, int paramInt3)
  {
    validate();
    return false;
  }
  
  public boolean setRectToRect(RectF paramRectF1, RectF paramRectF2, Matrix.ScaleToFit paramScaleToFit)
  {
    validate();
    return false;
  }
  
  public void setRotate(float paramFloat)
  {
    validate();
  }
  
  public void setRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    validate();
  }
  
  public void setScale(float paramFloat1, float paramFloat2)
  {
    validate();
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    validate();
  }
  
  public void setSinCos(float paramFloat1, float paramFloat2)
  {
    validate();
  }
  
  public void setSinCos(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    validate();
  }
  
  public void setSkew(float paramFloat1, float paramFloat2)
  {
    validate();
  }
  
  public void setSkew(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    validate();
  }
  
  public void setTranslate(float paramFloat1, float paramFloat2)
  {
    validate();
  }
  
  public void setValues(float[] paramArrayOfFloat)
  {
    validate();
  }
  
  public void validate()
  {
    throw new IllegalStateException("Matrix can not be modified");
  }
}
