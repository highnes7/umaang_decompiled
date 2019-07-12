package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

public class Transformer
{
  public Matrix mMBuffer1 = new Matrix();
  public Matrix mMBuffer2 = new Matrix();
  public Matrix mMatrixOffset = new Matrix();
  public Matrix mMatrixValueToPx = new Matrix();
  public ViewPortHandler mViewPortHandler;
  
  public Transformer(ViewPortHandler paramViewPortHandler)
  {
    mViewPortHandler = paramViewPortHandler;
  }
  
  public float[] generateTransformedValuesBarChart(IBarDataSet paramIBarDataSet, int paramInt, BarData paramBarData, float paramFloat)
  {
    float[] arrayOfFloat = new float[paramIBarDataSet.getEntryCount() * 2];
    int j = paramBarData.getDataSetCount();
    float f1 = paramBarData.getGroupSpace();
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      paramBarData = paramIBarDataSet.getEntryForIndex(i / 2);
      int k = paramBarData.getXIndex();
      float f2 = (j - 1) * k + paramBarData.getXIndex() + paramInt;
      float f3 = k;
      float f4 = f1 / 2.0F;
      float f5 = paramBarData.getVal();
      arrayOfFloat[i] = (f4 + (f3 * f1 + f2));
      arrayOfFloat[(i + 1)] = (f5 * paramFloat);
      i += 2;
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] generateTransformedValuesBubble(IBubbleDataSet paramIBubbleDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = (int)Math.ceil(paramInt2 - paramInt1) * 2;
    float[] arrayOfFloat = new float[i];
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      Entry localEntry = paramIBubbleDataSet.getEntryForIndex(paramInt2 / 2 + paramInt1);
      if (localEntry != null)
      {
        arrayOfFloat[paramInt2] = ((localEntry.getXIndex() - paramInt1) * paramFloat1 + paramInt1);
        arrayOfFloat[(paramInt2 + 1)] = (localEntry.getVal() * paramFloat2);
      }
      paramInt2 += 2;
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] generateTransformedValuesCandle(ICandleDataSet paramICandleDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = (int)Math.ceil((paramInt2 - paramInt1) * paramFloat1) * 2;
    float[] arrayOfFloat = new float[i];
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      CandleEntry localCandleEntry = (CandleEntry)paramICandleDataSet.getEntryForIndex(paramInt2 / 2 + paramInt1);
      if (localCandleEntry != null)
      {
        arrayOfFloat[paramInt2] = localCandleEntry.getXIndex();
        arrayOfFloat[(paramInt2 + 1)] = (localCandleEntry.getHigh() * paramFloat2);
      }
      paramInt2 += 2;
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] generateTransformedValuesHorizontalBarChart(IBarDataSet paramIBarDataSet, int paramInt, BarData paramBarData, float paramFloat)
  {
    float[] arrayOfFloat = new float[paramIBarDataSet.getEntryCount() * 2];
    int j = paramBarData.getDataSetCount();
    float f1 = paramBarData.getGroupSpace();
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      paramBarData = paramIBarDataSet.getEntryForIndex(i / 2);
      int k = paramBarData.getXIndex();
      float f2 = (j - 1) * k + k + paramInt;
      float f3 = k;
      float f4 = f1 / 2.0F;
      arrayOfFloat[i] = (paramBarData.getVal() * paramFloat);
      arrayOfFloat[(i + 1)] = (f4 + (f3 * f1 + f2));
      i += 2;
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] generateTransformedValuesLine(ILineDataSet paramILineDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = (int)Math.ceil((paramInt2 - paramInt1) * paramFloat1) * 2;
    float[] arrayOfFloat = new float[i];
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      Entry localEntry = paramILineDataSet.getEntryForIndex(paramInt2 / 2 + paramInt1);
      if (localEntry != null)
      {
        arrayOfFloat[paramInt2] = localEntry.getXIndex();
        arrayOfFloat[(paramInt2 + 1)] = (localEntry.getVal() * paramFloat2);
      }
      paramInt2 += 2;
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] generateTransformedValuesScatter(IScatterDataSet paramIScatterDataSet, float paramFloat)
  {
    float[] arrayOfFloat = new float[paramIScatterDataSet.getEntryCount() * 2];
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      Entry localEntry = paramIScatterDataSet.getEntryForIndex(i / 2);
      if (localEntry != null)
      {
        arrayOfFloat[i] = localEntry.getXIndex();
        arrayOfFloat[(i + 1)] = (localEntry.getVal() * paramFloat);
      }
      i += 2;
    }
    getValueToPixelMatrix().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public Matrix getOffsetMatrix()
  {
    return mMatrixOffset;
  }
  
  public Matrix getPixelToValueMatrix()
  {
    getValueToPixelMatrix().invert(mMBuffer2);
    return mMBuffer2;
  }
  
  public Matrix getValueMatrix()
  {
    return mMatrixValueToPx;
  }
  
  public Matrix getValueToPixelMatrix()
  {
    mMBuffer1.set(mMatrixValueToPx);
    mMBuffer1.postConcat(mViewPortHandler.mMatrixTouch);
    mMBuffer1.postConcat(mMatrixOffset);
    return mMBuffer1;
  }
  
  public PointD getValuesByTouchPoint(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    pixelsToValue(arrayOfFloat);
    return new PointD(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public void pathValueToPixel(Path paramPath)
  {
    paramPath.transform(mMatrixValueToPx);
    paramPath.transform(mViewPortHandler.getMatrixTouch());
    paramPath.transform(mMatrixOffset);
  }
  
  public void pathValuesToPixel(List paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      pathValueToPixel((Path)paramList.get(i));
      i += 1;
    }
  }
  
  public void pixelsToValue(float[] paramArrayOfFloat)
  {
    Matrix localMatrix = new Matrix();
    mMatrixOffset.invert(localMatrix);
    localMatrix.mapPoints(paramArrayOfFloat);
    mViewPortHandler.getMatrixTouch().invert(localMatrix);
    localMatrix.mapPoints(paramArrayOfFloat);
    mMatrixValueToPx.invert(localMatrix);
    localMatrix.mapPoints(paramArrayOfFloat);
  }
  
  public void pointValuesToPixel(float[] paramArrayOfFloat)
  {
    mMatrixValueToPx.mapPoints(paramArrayOfFloat);
    mViewPortHandler.getMatrixTouch().mapPoints(paramArrayOfFloat);
    mMatrixOffset.mapPoints(paramArrayOfFloat);
  }
  
  public void prepareMatrixOffset(boolean paramBoolean)
  {
    mMatrixOffset.reset();
    if (!paramBoolean)
    {
      mMatrixOffset.postTranslate(mViewPortHandler.offsetLeft(), mViewPortHandler.getChartHeight() - mViewPortHandler.offsetBottom());
      return;
    }
    mMatrixOffset.setTranslate(mViewPortHandler.offsetLeft(), -mViewPortHandler.offsetTop());
    mMatrixOffset.postScale(1.0F, -1.0F);
  }
  
  public void prepareMatrixValuePx(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f2 = mViewPortHandler.contentWidth() / paramFloat2;
    float f1 = mViewPortHandler.contentHeight() / paramFloat3;
    paramFloat2 = f2;
    if (Float.isInfinite(f2)) {
      paramFloat2 = 0.0F;
    }
    paramFloat3 = f1;
    if (Float.isInfinite(f1)) {
      paramFloat3 = 0.0F;
    }
    mMatrixValueToPx.reset();
    mMatrixValueToPx.postTranslate(-paramFloat1, -paramFloat4);
    mMatrixValueToPx.postScale(paramFloat2, -paramFloat3);
  }
  
  public void rectValueToPixel(RectF paramRectF)
  {
    mMatrixValueToPx.mapRect(paramRectF);
    mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectValueToPixel(RectF paramRectF, float paramFloat)
  {
    top *= paramFloat;
    bottom *= paramFloat;
    mMatrixValueToPx.mapRect(paramRectF);
    mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectValueToPixelHorizontal(RectF paramRectF)
  {
    mMatrixValueToPx.mapRect(paramRectF);
    mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectValueToPixelHorizontal(RectF paramRectF, float paramFloat)
  {
    left *= paramFloat;
    right *= paramFloat;
    mMatrixValueToPx.mapRect(paramRectF);
    mViewPortHandler.getMatrixTouch().mapRect(paramRectF);
    mMatrixOffset.mapRect(paramRectF);
  }
  
  public void rectValuesToPixel(List paramList)
  {
    Matrix localMatrix = getValueToPixelMatrix();
    int i = 0;
    while (i < paramList.size())
    {
      localMatrix.mapRect((RectF)paramList.get(i));
      i += 1;
    }
  }
}
