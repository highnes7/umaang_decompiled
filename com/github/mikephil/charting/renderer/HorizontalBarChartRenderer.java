package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.AbstractBuffer;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class HorizontalBarChartRenderer
  extends BarChartRenderer
{
  public HorizontalBarChartRenderer(BarDataProvider paramBarDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramBarDataProvider, paramChartAnimator, paramViewPortHandler);
    mValuePaint.setTextAlign(Paint.Align.LEFT);
  }
  
  public void drawDataSet(Canvas paramCanvas, IBarDataSet paramIBarDataSet, int paramInt)
  {
    Object localObject = mChart.getTransformer(paramIBarDataSet.getAxisDependency());
    mShadowPaint.setColor(paramIBarDataSet.getBarShadowColor());
    float f1 = mAnimator.getPhaseX();
    float f2 = mAnimator.getPhaseY();
    BarBuffer localBarBuffer = mBarBuffers[paramInt];
    localBarBuffer.setPhases(f1, f2);
    localBarBuffer.setBarSpace(paramIBarDataSet.getBarSpace());
    localBarBuffer.setDataSet(paramInt);
    localBarBuffer.setInverted(mChart.isInverted(paramIBarDataSet.getAxisDependency()));
    localBarBuffer.feed(paramIBarDataSet);
    ((Transformer)localObject).pointValuesToPixel(buffer);
    paramInt = 0;
    while (paramInt < localBarBuffer.size())
    {
      localObject = mViewPortHandler;
      float[] arrayOfFloat = buffer;
      int i = paramInt + 3;
      if (!((ViewPortHandler)localObject).isInBoundsTop(arrayOfFloat[i])) {
        return;
      }
      localObject = mViewPortHandler;
      arrayOfFloat = buffer;
      int j = paramInt + 1;
      if (((ViewPortHandler)localObject).isInBoundsBottom(arrayOfFloat[j]))
      {
        if (mChart.isDrawBarShadowEnabled()) {
          paramCanvas.drawRect(mViewPortHandler.contentLeft(), buffer[j], mViewPortHandler.contentRight(), buffer[i], mShadowPaint);
        }
        mRenderPaint.setColor(paramIBarDataSet.getColor(paramInt / 4));
        localObject = buffer;
        paramCanvas.drawRect(localObject[paramInt], localObject[j], localObject[(paramInt + 2)], localObject[i], mRenderPaint);
      }
      paramInt += 4;
    }
  }
  
  public void drawValue(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, int paramInt)
  {
    mValuePaint.setColor(paramInt);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, mValuePaint);
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    if (passesCheck())
    {
      List localList = mChart.getBarData().getDataSets();
      float f1 = Utils.convertDpToPixel(5.0F);
      boolean bool1 = mChart.isDrawValueAboveBarEnabled();
      int i = 0;
      while (i < mChart.getBarData().getDataSetCount())
      {
        IBarDataSet localIBarDataSet = (IBarDataSet)localList.get(i);
        if ((localIBarDataSet.isDrawValuesEnabled()) && (localIBarDataSet.getEntryCount() != 0))
        {
          boolean bool2 = mChart.isInverted(localIBarDataSet.getAxisDependency());
          applyValueTextStyle(localIBarDataSet);
          float f6 = Utils.calcTextHeight(mValuePaint, "10") / 2.0F;
          ValueFormatter localValueFormatter = localIBarDataSet.getValueFormatter();
          Object localObject2 = mChart.getTransformer(localIBarDataSet.getAxisDependency());
          Object localObject1 = localObject2;
          float[] arrayOfFloat1 = getTransformedValues((Transformer)localObject2, localIBarDataSet, i);
          localObject2 = arrayOfFloat1;
          float f2;
          float f3;
          int k;
          int m;
          float f7;
          float f8;
          float f4;
          float f5;
          if (!localIBarDataSet.isStacked())
          {
            j = 0;
            localObject1 = localObject2;
            for (;;)
            {
              f2 = j;
              f3 = localObject1.length;
              if (f2 >= mAnimator.getPhaseX() * f3) {
                break;
              }
              localObject2 = mViewPortHandler;
              k = j + 1;
              if (!((ViewPortHandler)localObject2).isInBoundsTop(localObject1[k])) {
                break;
              }
              if (mViewPortHandler.isInBoundsX(localObject1[j]))
              {
                while (!mViewPortHandler.isInBoundsBottom(localObject1[k])) {}
                m = j / 2;
                localObject2 = (BarEntry)localIBarDataSet.getEntryForIndex(m);
                f7 = ((BarEntry)localObject2).getVal();
                localObject2 = localValueFormatter.getFormattedValue(f7, (Entry)localObject2, i, mViewPortHandler);
                f8 = Utils.calcTextWidth(mValuePaint, (String)localObject2);
                if (bool1) {
                  f2 = f1;
                } else {
                  f2 = -(f8 + f1);
                }
                if (bool1) {
                  f4 = -(f8 + f1);
                } else {
                  f4 = f1;
                }
                f5 = f2;
                f3 = f4;
                if (bool2)
                {
                  f5 = -f2 - f8;
                  f3 = -f4 - f8;
                }
                f2 = localObject1[j];
                if (f7 >= 0.0F) {
                  f3 = f5;
                }
                drawValue(paramCanvas, (String)localObject2, f2 + f3, localObject1[k] + f6, localIBarDataSet.getValueTextColor(m));
              }
              j += 2;
            }
          }
          int j = 0;
          for (;;)
          {
            f2 = j;
            f3 = arrayOfFloat1.length - 1;
            if (f2 >= mAnimator.getPhaseX() * f3) {
              break;
            }
            int n = j / 2;
            BarEntry localBarEntry = (BarEntry)localIBarDataSet.getEntryForIndex(n);
            float[] arrayOfFloat2 = localBarEntry.getVals();
            if (arrayOfFloat2 == null)
            {
              localObject2 = mViewPortHandler;
              k = j + 1;
              if (!((ViewPortHandler)localObject2).isInBoundsTop(arrayOfFloat1[k])) {
                break;
              }
              if (!mViewPortHandler.isInBoundsX(arrayOfFloat1[j])) {}
              for (localObject2 = localObject1;; localObject2 = localObject1)
              {
                localObject1 = localObject2;
                break label1095;
                if (mViewPortHandler.isInBoundsBottom(arrayOfFloat1[k])) {
                  break;
                }
              }
              localObject2 = localValueFormatter.getFormattedValue(localBarEntry.getVal(), localBarEntry, i, mViewPortHandler);
              f7 = Utils.calcTextWidth(mValuePaint, (String)localObject2);
              if (bool1) {
                f2 = f1;
              } else {
                f2 = -(f7 + f1);
              }
              if (bool1) {
                f4 = -(f7 + f1);
              } else {
                f4 = f1;
              }
              f5 = f2;
              f3 = f4;
              if (bool2)
              {
                f5 = -f2 - f7;
                f3 = -f4 - f7;
              }
              f2 = arrayOfFloat1[j];
              if (localBarEntry.getVal() >= 0.0F) {
                f3 = f5;
              }
              drawValue(paramCanvas, (String)localObject2, f3 + f2, arrayOfFloat1[k] + f6, localIBarDataSet.getValueTextColor(n));
            }
            else
            {
              float[] arrayOfFloat3 = new float[arrayOfFloat2.length * 2];
              f2 = -localBarEntry.getNegativeSum();
              m = 0;
              k = 0;
              f4 = 0.0F;
              while (m < arrayOfFloat3.length)
              {
                f3 = arrayOfFloat2[k];
                if (f3 >= 0.0F)
                {
                  f3 = f4 + f3;
                  f4 = f3;
                  f5 = f3;
                  f3 = f2;
                }
                else
                {
                  f3 = f2 - f3;
                  f5 = f2;
                }
                arrayOfFloat3[m] = (mAnimator.getPhaseY() * f5);
                m += 2;
                k += 1;
                f2 = f3;
              }
              localObject1.pointValuesToPixel(arrayOfFloat3);
              k = 0;
              for (;;)
              {
                localObject2 = localObject1;
                if (k >= arrayOfFloat3.length) {
                  break;
                }
                f7 = arrayOfFloat2[(k / 2)];
                localObject2 = localValueFormatter.getFormattedValue(f7, localBarEntry, i, mViewPortHandler);
                f8 = Utils.calcTextWidth(mValuePaint, (String)localObject2);
                if (bool1) {
                  f2 = f1;
                } else {
                  f2 = -(f8 + f1);
                }
                if (bool1) {
                  f4 = -(f8 + f1);
                } else {
                  f4 = f1;
                }
                f5 = f2;
                f3 = f4;
                if (bool2)
                {
                  f5 = -f2 - f8;
                  f3 = -f4 - f8;
                }
                f2 = arrayOfFloat3[k];
                if (f7 >= 0.0F) {
                  f3 = f5;
                }
                f2 += f3;
                f3 = arrayOfFloat1[(j + 1)];
                if (!mViewPortHandler.isInBoundsTop(f3))
                {
                  localObject2 = localObject1;
                  break;
                }
                if (mViewPortHandler.isInBoundsX(f2))
                {
                  while (!mViewPortHandler.isInBoundsBottom(f3)) {}
                  drawValue(paramCanvas, (String)localObject2, f2, f3 + f6, localIBarDataSet.getValueTextColor(n));
                }
                k += 2;
              }
            }
            label1095:
            j += 2;
          }
        }
        i += 1;
      }
    }
  }
  
  public float[] getTransformedValues(Transformer paramTransformer, IBarDataSet paramIBarDataSet, int paramInt)
  {
    return paramTransformer.generateTransformedValuesHorizontalBarChart(paramIBarDataSet, paramInt, mChart.getBarData(), mAnimator.getPhaseY());
  }
  
  public void initBuffers()
  {
    BarData localBarData = mChart.getBarData();
    mBarBuffers = new HorizontalBarBuffer[localBarData.getDataSetCount()];
    int i = 0;
    while (i < mBarBuffers.length)
    {
      IBarDataSet localIBarDataSet = (IBarDataSet)localBarData.getDataSetByIndex(i);
      BarBuffer[] arrayOfBarBuffer = mBarBuffers;
      int k = localIBarDataSet.getEntryCount();
      int j;
      if (localIBarDataSet.isStacked()) {
        j = localIBarDataSet.getStackSize();
      } else {
        j = 1;
      }
      arrayOfBarBuffer[i] = new HorizontalBarBuffer(k * 4 * j, localBarData.getGroupSpace(), localBarData.getDataSetCount(), localIBarDataSet.isStacked());
      i += 1;
    }
  }
  
  public boolean passesCheck()
  {
    float f1 = mChart.getBarData().getYValCount();
    float f2 = mChart.getMaxVisibleCount();
    return f1 < mViewPortHandler.getScaleY() * f2;
  }
  
  public void prepareBarHighlight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer)
  {
    mBarRect.set(paramFloat2, paramFloat1 - 0.5F + paramFloat4, paramFloat3, paramFloat1 + 0.5F - paramFloat4);
    paramTransformer.rectValueToPixelHorizontal(mBarRect, mAnimator.getPhaseY());
  }
}
