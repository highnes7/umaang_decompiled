package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.AbstractBuffer;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BarChartRenderer
  extends DataRenderer
{
  public BarBuffer[] mBarBuffers;
  public RectF mBarRect = new RectF();
  public BarDataProvider mChart;
  public Paint mShadowPaint;
  
  public BarChartRenderer(BarDataProvider paramBarDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    mChart = paramBarDataProvider;
    mHighlightPaint = new Paint(1);
    mHighlightPaint.setStyle(Paint.Style.FILL);
    mHighlightPaint.setColor(Color.rgb(0, 0, 0));
    mHighlightPaint.setAlpha(120);
    mShadowPaint = new Paint(1);
    mShadowPaint.setStyle(Paint.Style.FILL);
  }
  
  public void drawData(Canvas paramCanvas)
  {
    BarData localBarData = mChart.getBarData();
    int i = 0;
    while (i < localBarData.getDataSetCount())
    {
      IBarDataSet localIBarDataSet = (IBarDataSet)localBarData.getDataSetByIndex(i);
      if ((localIBarDataSet.isVisible()) && (localIBarDataSet.getEntryCount() > 0)) {
        drawDataSet(paramCanvas, localIBarDataSet, i);
      }
      i += 1;
    }
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
    boolean bool = mChart.isDrawBarShadowEnabled();
    int j = 0;
    int i = 0;
    float[] arrayOfFloat;
    if (bool)
    {
      paramInt = 0;
      while (paramInt < localBarBuffer.size())
      {
        localObject = mViewPortHandler;
        arrayOfFloat = buffer;
        int k = paramInt + 2;
        if (((ViewPortHandler)localObject).isInBoundsLeft(arrayOfFloat[k]))
        {
          if (!mViewPortHandler.isInBoundsRight(buffer[paramInt])) {
            break;
          }
          paramCanvas.drawRect(buffer[paramInt], mViewPortHandler.contentTop(), buffer[k], mViewPortHandler.contentBottom(), mShadowPaint);
        }
        paramInt += 4;
      }
    }
    if (paramIBarDataSet.getColors().size() > 1)
    {
      paramInt = i;
      while (paramInt < localBarBuffer.size())
      {
        localObject = mViewPortHandler;
        arrayOfFloat = buffer;
        i = paramInt + 2;
        if (((ViewPortHandler)localObject).isInBoundsLeft(arrayOfFloat[i]))
        {
          if (!mViewPortHandler.isInBoundsRight(buffer[paramInt])) {
            return;
          }
          mRenderPaint.setColor(paramIBarDataSet.getColor(paramInt / 4));
          localObject = buffer;
          paramCanvas.drawRect(localObject[paramInt], localObject[(paramInt + 1)], localObject[i], localObject[(paramInt + 3)], mRenderPaint);
        }
        paramInt += 4;
      }
    }
    mRenderPaint.setColor(paramIBarDataSet.getColor());
    paramInt = j;
    while (paramInt < localBarBuffer.size())
    {
      paramIBarDataSet = mViewPortHandler;
      localObject = buffer;
      i = paramInt + 2;
      if (paramIBarDataSet.isInBoundsLeft(localObject[i]))
      {
        if (!mViewPortHandler.isInBoundsRight(buffer[paramInt])) {
          return;
        }
        paramIBarDataSet = buffer;
        paramCanvas.drawRect(paramIBarDataSet[paramInt], paramIBarDataSet[(paramInt + 1)], paramIBarDataSet[i], paramIBarDataSet[(paramInt + 3)], mRenderPaint);
      }
      paramInt += 4;
    }
  }
  
  public void drawExtras(Canvas paramCanvas) {}
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    int k = mChart.getBarData().getDataSetCount();
    int i = 0;
    while (i < paramArrayOfHighlight.length)
    {
      Object localObject2 = paramArrayOfHighlight[i];
      int m = ((Highlight)localObject2).getXIndex();
      int n = ((Highlight)localObject2).getDataSetIndex();
      Object localObject1 = (IBarDataSet)mChart.getBarData().getDataSetByIndex(n);
      if ((localObject1 != null) && (((IDataSet)localObject1).isHighlightEnabled()))
      {
        float f4 = ((IBarDataSet)localObject1).getBarSpace() / 2.0F;
        Transformer localTransformer = mChart.getTransformer(((IDataSet)localObject1).getAxisDependency());
        mHighlightPaint.setColor(((IBarLineScatterCandleBubbleDataSet)localObject1).getHighLightColor());
        mHighlightPaint.setAlpha(((IBarDataSet)localObject1).getHighLightAlpha());
        if (m >= 0)
        {
          float f1 = m;
          float f2 = mChart.getXChartMax();
          if (f1 < mAnimator.getPhaseX() * f2 / k)
          {
            BarEntry localBarEntry = (BarEntry)((IDataSet)localObject1).getEntryForXIndex(m);
            if ((localBarEntry != null) && (localBarEntry.getXIndex() == m))
            {
              f2 = mChart.getBarData().getGroupSpace();
              int j;
              if (((Highlight)localObject2).getStackIndex() < 0) {
                j = 0;
              } else {
                j = 1;
              }
              float f3 = m * k + n;
              f3 = f2 * f1 + (f2 / 2.0F + f3);
              if (j != 0)
              {
                f1 = getRangefrom;
                f2 = getRangeto;
              }
              else
              {
                f1 = localBarEntry.getVal();
                f2 = 0.0F;
              }
              prepareBarHighlight(f3, f1, f2, f4, localTransformer);
              paramCanvas.drawRect(mBarRect, mHighlightPaint);
              if (mChart.isDrawHighlightArrowEnabled())
              {
                mHighlightPaint.setAlpha(255);
                float f5 = mAnimator.getPhaseY();
                localObject2 = new float[9];
                localTransformer.getPixelToValueMatrix().getValues((float[])localObject2);
                f4 = Math.abs(localObject2[4] / localObject2[0]);
                f2 = ((IBarDataSet)localObject1).getBarSpace() / 2.0F;
                f4 *= f2;
                float f6 = mAnimator.getPhaseY();
                localObject1 = new Path();
                f3 += 0.4F;
                f1 = f6 * f1 + f5 * 0.07F;
                ((Path)localObject1).moveTo(f3, f1);
                f2 = f3 + f2;
                ((Path)localObject1).lineTo(f2, f1 - f4);
                ((Path)localObject1).lineTo(f2, f1 + f4);
                localTransformer.pathValueToPixel((Path)localObject1);
                paramCanvas.drawPath((Path)localObject1, mHighlightPaint);
              }
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    if (passesCheck())
    {
      List localList = mChart.getBarData().getDataSets();
      float f7 = Utils.convertDpToPixel(4.5F);
      boolean bool1 = mChart.isDrawValueAboveBarEnabled();
      int i = 0;
      while (i < mChart.getBarData().getDataSetCount())
      {
        IBarDataSet localIBarDataSet = (IBarDataSet)localList.get(i);
        if ((localIBarDataSet.isDrawValuesEnabled()) && (localIBarDataSet.getEntryCount() != 0))
        {
          applyValueTextStyle(localIBarDataSet);
          boolean bool2 = mChart.isInverted(localIBarDataSet.getAxisDependency());
          float f5 = Utils.calcTextHeight(mValuePaint, "8");
          float f3;
          if (bool1) {
            f3 = -f7;
          } else {
            f3 = f5 + f7;
          }
          float f4;
          if (bool1) {
            f4 = f5 + f7;
          } else {
            f4 = -f7;
          }
          float f2 = f3;
          float f1 = f4;
          if (bool2)
          {
            f2 = -f3 - f5;
            f1 = -f4 - f5;
          }
          Object localObject2 = mChart.getTransformer(localIBarDataSet.getAxisDependency());
          Object localObject1 = localObject2;
          Object localObject3 = getTransformedValues((Transformer)localObject2, localIBarDataSet, i);
          localObject2 = localObject3;
          int k;
          int m;
          float f6;
          if (!localIBarDataSet.isStacked())
          {
            j = 0;
            localObject1 = localObject2;
            for (;;)
            {
              f3 = j;
              f4 = localObject1.length;
              if ((f3 >= mAnimator.getPhaseX() * f4) || (!mViewPortHandler.isInBoundsRight(localObject1[j]))) {
                break;
              }
              localObject2 = mViewPortHandler;
              k = j + 1;
              if ((((ViewPortHandler)localObject2).isInBoundsY(localObject1[k])) && (mViewPortHandler.isInBoundsLeft(localObject1[j])))
              {
                m = j / 2;
                localObject2 = (BarEntry)localIBarDataSet.getEntryForIndex(m);
                f4 = ((BarEntry)localObject2).getVal();
                localObject3 = localIBarDataSet.getValueFormatter();
                f5 = localObject1[j];
                f6 = localObject1[k];
                if (f4 >= 0.0F) {
                  f3 = f2;
                } else {
                  f3 = f1;
                }
                drawValue(paramCanvas, (ValueFormatter)localObject3, f4, (Entry)localObject2, i, f5, f6 + f3, localIBarDataSet.getValueTextColor(m));
              }
              j += 2;
            }
          }
          int j = 0;
          for (;;)
          {
            f3 = j;
            f4 = localObject3.length - 1;
            if (f3 >= mAnimator.getPhaseX() * f4) {
              break;
            }
            k = j / 2;
            BarEntry localBarEntry = (BarEntry)localIBarDataSet.getEntryForIndex(k);
            float[] arrayOfFloat1 = localBarEntry.getVals();
            localObject2 = arrayOfFloat1;
            if (arrayOfFloat1 == null)
            {
              if (!mViewPortHandler.isInBoundsRight(localObject3[j])) {
                break;
              }
              localObject2 = mViewPortHandler;
              m = j + 1;
              if ((((ViewPortHandler)localObject2).isInBoundsY(localObject3[m])) && (mViewPortHandler.isInBoundsLeft(localObject3[j])))
              {
                localObject2 = localIBarDataSet.getValueFormatter();
                f4 = localBarEntry.getVal();
                f5 = localObject3[j];
                f6 = localObject3[m];
                if (localBarEntry.getVal() >= 0.0F) {
                  f3 = f2;
                } else {
                  f3 = f1;
                }
                drawValue(paramCanvas, (ValueFormatter)localObject2, f4, localBarEntry, i, f5, f6 + f3, localIBarDataSet.getValueTextColor(k));
              }
            }
            else
            {
              int n = localIBarDataSet.getValueTextColor(k);
              float[] arrayOfFloat2 = new float[arrayOfFloat1.length * 2];
              f3 = -localBarEntry.getNegativeSum();
              m = 0;
              k = 0;
              f5 = 0.0F;
              while (m < arrayOfFloat2.length)
              {
                f4 = arrayOfFloat1[k];
                if (f4 >= 0.0F)
                {
                  f5 += f4;
                  f6 = f5;
                  f4 = f3;
                }
                else
                {
                  f4 = f3 - f4;
                  f6 = f3;
                }
                arrayOfFloat2[(m + 1)] = (mAnimator.getPhaseY() * f6);
                m += 2;
                k += 1;
                f3 = f4;
              }
              localObject1.pointValuesToPixel(arrayOfFloat2);
              k = 0;
              while (k < arrayOfFloat2.length)
              {
                f4 = localObject3[j];
                f5 = arrayOfFloat2[(k + 1)];
                m = k / 2;
                if (localObject2[m] >= 0.0F) {
                  f3 = f2;
                } else {
                  f3 = f1;
                }
                f3 = f5 + f3;
                if (!mViewPortHandler.isInBoundsRight(f4)) {
                  break;
                }
                if ((mViewPortHandler.isInBoundsY(f3)) && (mViewPortHandler.isInBoundsLeft(f4))) {
                  drawValue(paramCanvas, localIBarDataSet.getValueFormatter(), localObject2[m], localBarEntry, i, f4, f3, n);
                }
                k += 2;
              }
            }
            j += 2;
          }
        }
        i += 1;
      }
    }
  }
  
  public float[] getTransformedValues(Transformer paramTransformer, IBarDataSet paramIBarDataSet, int paramInt)
  {
    return paramTransformer.generateTransformedValuesBarChart(paramIBarDataSet, paramInt, mChart.getBarData(), mAnimator.getPhaseY());
  }
  
  public void initBuffers()
  {
    BarData localBarData = mChart.getBarData();
    mBarBuffers = new BarBuffer[localBarData.getDataSetCount()];
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
      arrayOfBarBuffer[i] = new BarBuffer(k * 4 * j, localBarData.getGroupSpace(), localBarData.getDataSetCount(), localIBarDataSet.isStacked());
      i += 1;
    }
  }
  
  public boolean passesCheck()
  {
    float f1 = mChart.getBarData().getYValCount();
    float f2 = mChart.getMaxVisibleCount();
    return f1 < mViewPortHandler.getScaleX() * f2;
  }
  
  public void prepareBarHighlight(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Transformer paramTransformer)
  {
    mBarRect.set(paramFloat1 - 0.5F + paramFloat4, paramFloat2, paramFloat1 + 0.5F - paramFloat4, paramFloat3);
    paramTransformer.rectValueToPixel(mBarRect, mAnimator.getPhaseY());
  }
}
