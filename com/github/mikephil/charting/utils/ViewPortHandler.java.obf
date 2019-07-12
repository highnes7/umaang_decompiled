package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler
{
  public float mChartHeight = 0.0F;
  public float mChartWidth = 0.0F;
  public RectF mContentRect = new RectF();
  public final Matrix mMatrixTouch = new Matrix();
  public float mMaxScaleX = Float.MAX_VALUE;
  public float mMaxScaleY = Float.MAX_VALUE;
  public float mMinScaleX = 1.0F;
  public float mMinScaleY = 1.0F;
  public float mScaleX = 1.0F;
  public float mScaleY = 1.0F;
  public float mTransOffsetX = 0.0F;
  public float mTransOffsetY = 0.0F;
  public float mTransX = 0.0F;
  public float mTransY = 0.0F;
  public final float[] matrixBuffer = new float[9];
  
  public ViewPortHandler() {}
  
  public boolean canZoomInMoreX()
  {
    return mScaleX < mMaxScaleX;
  }
  
  public boolean canZoomInMoreY()
  {
    return mScaleY < mMaxScaleY;
  }
  
  public boolean canZoomOutMoreX()
  {
    return mScaleX > mMinScaleX;
  }
  
  public boolean canZoomOutMoreY()
  {
    return mScaleY > mMinScaleY;
  }
  
  public void centerViewPort(float[] paramArrayOfFloat, View paramView)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    float f1 = paramArrayOfFloat[0];
    float f2 = offsetLeft();
    float f3 = paramArrayOfFloat[1];
    float f4 = offsetTop();
    localMatrix.postTranslate(-(f1 - f2), -(f3 - f4));
    refresh(localMatrix, paramView, true);
  }
  
  public float contentBottom()
  {
    return mContentRect.bottom;
  }
  
  public float contentHeight()
  {
    return mContentRect.height();
  }
  
  public float contentLeft()
  {
    return mContentRect.left;
  }
  
  public float contentRight()
  {
    return mContentRect.right;
  }
  
  public float contentTop()
  {
    return mContentRect.top;
  }
  
  public float contentWidth()
  {
    return mContentRect.width();
  }
  
  public Matrix fitScreen()
  {
    mMinScaleX = 1.0F;
    mMinScaleY = 1.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    float[] arrayOfFloat = new float[9];
    localMatrix.getValues(arrayOfFloat);
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[4] = 1.0F;
    localMatrix.setValues(arrayOfFloat);
    return localMatrix;
  }
  
  public float getChartHeight()
  {
    return mChartHeight;
  }
  
  public float getChartWidth()
  {
    return mChartWidth;
  }
  
  public PointF getContentCenter()
  {
    return new PointF(mContentRect.centerX(), mContentRect.centerY());
  }
  
  public RectF getContentRect()
  {
    return mContentRect;
  }
  
  public Matrix getMatrixTouch()
  {
    return mMatrixTouch;
  }
  
  public float getMaxScaleX()
  {
    return mMaxScaleX;
  }
  
  public float getMaxScaleY()
  {
    return mMaxScaleY;
  }
  
  public float getMinScaleX()
  {
    return mMinScaleX;
  }
  
  public float getMinScaleY()
  {
    return mMinScaleY;
  }
  
  public float getScaleX()
  {
    return mScaleX;
  }
  
  public float getScaleY()
  {
    return mScaleY;
  }
  
  public float getTransX()
  {
    return mTransX;
  }
  
  public float getTransY()
  {
    return mTransY;
  }
  
  public boolean hasChartDimens()
  {
    return (mChartHeight > 0.0F) && (mChartWidth > 0.0F);
  }
  
  public boolean hasNoDragOffset()
  {
    return (mTransOffsetX <= 0.0F) && (mTransOffsetY <= 0.0F);
  }
  
  public boolean isFullyZoomedOut()
  {
    return (isFullyZoomedOutX()) && (isFullyZoomedOutY());
  }
  
  public boolean isFullyZoomedOutX()
  {
    float f1 = mScaleX;
    float f2 = mMinScaleX;
    return (f1 <= f2) && (f2 <= 1.0F);
  }
  
  public boolean isFullyZoomedOutY()
  {
    float f1 = mScaleY;
    float f2 = mMinScaleY;
    return (f1 <= f2) && (f2 <= 1.0F);
  }
  
  public boolean isInBounds(float paramFloat1, float paramFloat2)
  {
    return (isInBoundsX(paramFloat1)) && (isInBoundsY(paramFloat2));
  }
  
  public boolean isInBoundsBottom(float paramFloat)
  {
    paramFloat = (int)(paramFloat * 100.0F) / 100.0F;
    return mContentRect.bottom >= paramFloat;
  }
  
  public boolean isInBoundsLeft(float paramFloat)
  {
    return mContentRect.left <= paramFloat;
  }
  
  public boolean isInBoundsRight(float paramFloat)
  {
    paramFloat = (int)(paramFloat * 100.0F) / 100.0F;
    return mContentRect.right >= paramFloat;
  }
  
  public boolean isInBoundsTop(float paramFloat)
  {
    return mContentRect.top <= paramFloat;
  }
  
  public boolean isInBoundsX(float paramFloat)
  {
    return (isInBoundsLeft(paramFloat)) && (isInBoundsRight(paramFloat));
  }
  
  public boolean isInBoundsY(float paramFloat)
  {
    return (isInBoundsTop(paramFloat)) && (isInBoundsBottom(paramFloat));
  }
  
  public void limitTransAndScale(Matrix paramMatrix, RectF paramRectF)
  {
    paramMatrix.getValues(matrixBuffer);
    float[] arrayOfFloat = matrixBuffer;
    float f3 = arrayOfFloat[2];
    float f1 = arrayOfFloat[0];
    float f4 = arrayOfFloat[5];
    float f2 = arrayOfFloat[4];
    mScaleX = Math.min(Math.max(mMinScaleX, f1), mMaxScaleX);
    mScaleY = Math.min(Math.max(mMinScaleY, f2), mMaxScaleY);
    f2 = 0.0F;
    if (paramRectF != null)
    {
      f2 = paramRectF.width();
      f1 = paramRectF.height();
    }
    else
    {
      f1 = 0.0F;
    }
    f2 = -f2;
    mTransX = Math.min(Math.max(f3, (mScaleX - 1.0F) * f2 - mTransOffsetX), mTransOffsetX);
    mTransY = Math.max(Math.min(f4, (mScaleY - 1.0F) * f1 + mTransOffsetY), -mTransOffsetY);
    paramRectF = matrixBuffer;
    paramRectF[2] = mTransX;
    paramRectF[0] = mScaleX;
    paramRectF[5] = mTransY;
    paramRectF[4] = mScaleY;
    paramMatrix.setValues(paramRectF);
  }
  
  public float offsetBottom()
  {
    return mChartHeight - mContentRect.bottom;
  }
  
  public float offsetLeft()
  {
    return mContentRect.left;
  }
  
  public float offsetRight()
  {
    return mChartWidth - mContentRect.right;
  }
  
  public float offsetTop()
  {
    return mContentRect.top;
  }
  
  public Matrix refresh(Matrix paramMatrix, View paramView, boolean paramBoolean)
  {
    mMatrixTouch.set(paramMatrix);
    limitTransAndScale(mMatrixTouch, mContentRect);
    if (paramBoolean) {
      paramView.invalidate();
    }
    paramMatrix.set(mMatrixTouch);
    return paramMatrix;
  }
  
  public void restrainViewPort(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    mContentRect.set(paramFloat1, paramFloat2, mChartWidth - paramFloat3, mChartHeight - paramFloat4);
  }
  
  public void setChartDimens(float paramFloat1, float paramFloat2)
  {
    float f1 = offsetLeft();
    float f2 = offsetTop();
    float f3 = offsetRight();
    float f4 = offsetBottom();
    mChartHeight = paramFloat2;
    mChartWidth = paramFloat1;
    restrainViewPort(f1, f2, f3, f4);
  }
  
  public void setDragOffsetX(float paramFloat)
  {
    mTransOffsetX = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setDragOffsetY(float paramFloat)
  {
    mTransOffsetY = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setMaximumScaleX(float paramFloat)
  {
    mMaxScaleX = paramFloat;
    limitTransAndScale(mMatrixTouch, mContentRect);
  }
  
  public void setMaximumScaleY(float paramFloat)
  {
    mMaxScaleY = paramFloat;
    limitTransAndScale(mMatrixTouch, mContentRect);
  }
  
  public void setMinMaxScaleX(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 < 1.0F) {
      f = 1.0F;
    }
    mMinScaleX = f;
    mMaxScaleX = paramFloat2;
    limitTransAndScale(mMatrixTouch, mContentRect);
  }
  
  public void setMinimumScaleX(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 1.0F) {
      f = 1.0F;
    }
    mMinScaleX = f;
    limitTransAndScale(mMatrixTouch, mContentRect);
  }
  
  public void setMinimumScaleY(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 1.0F) {
      f = 1.0F;
    }
    mMinScaleY = f;
    limitTransAndScale(mMatrixTouch, mContentRect);
  }
  
  public Matrix setZoom(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    localMatrix.setScale(paramFloat1, paramFloat2);
    return localMatrix;
  }
  
  public Matrix setZoom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    localMatrix.setScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return localMatrix;
  }
  
  public Matrix translate(float[] paramArrayOfFloat)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    float f1 = paramArrayOfFloat[0];
    float f2 = offsetLeft();
    float f3 = paramArrayOfFloat[1];
    float f4 = offsetTop();
    localMatrix.postTranslate(-(f1 - f2), -(f3 - f4));
    return localMatrix;
  }
  
  public Matrix zoom(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    localMatrix.postScale(paramFloat1, paramFloat2);
    return localMatrix;
  }
  
  public Matrix zoom(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    localMatrix.postScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return localMatrix;
  }
  
  public Matrix zoomIn(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    localMatrix.postScale(1.4F, 1.4F, paramFloat1, paramFloat2);
    return localMatrix;
  }
  
  public Matrix zoomOut(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(mMatrixTouch);
    localMatrix.postScale(0.7F, 0.7F, paramFloat1, paramFloat2);
    return localMatrix;
  }
}
