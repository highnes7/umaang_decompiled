package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

public class CandleStickChartRenderer
  extends LineScatterCandleRadarRenderer
{
  public float[] mBodyBuffers = new float[4];
  public CandleDataProvider mChart;
  public float[] mCloseBuffers = new float[4];
  public float[] mOpenBuffers = new float[4];
  public float[] mRangeBuffers = new float[4];
  public float[] mShadowBuffers = new float[8];
  
  public CandleStickChartRenderer(CandleDataProvider paramCandleDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    mChart = paramCandleDataProvider;
  }
  
  public void drawData(Canvas paramCanvas)
  {
    Iterator localIterator = mChart.getCandleData().getDataSets().iterator();
    while (localIterator.hasNext())
    {
      ICandleDataSet localICandleDataSet = (ICandleDataSet)localIterator.next();
      if ((localICandleDataSet.isVisible()) && (localICandleDataSet.getEntryCount() > 0)) {
        drawDataSet(paramCanvas, localICandleDataSet);
      }
    }
  }
  
  public void drawDataSet(Canvas paramCanvas, ICandleDataSet paramICandleDataSet)
  {
    Transformer localTransformer = mChart.getTransformer(paramICandleDataSet.getAxisDependency());
    float f3 = mAnimator.getPhaseX();
    float f1 = mAnimator.getPhaseY();
    float f2 = paramICandleDataSet.getBarSpace();
    boolean bool = paramICandleDataSet.getShowCandleBar();
    int k = Math.max(mMinX, 0);
    int m = Math.min(mMaxX + 1, paramICandleDataSet.getEntryCount());
    mRenderPaint.setStrokeWidth(paramICandleDataSet.getShadowWidth());
    int n = (int)Math.ceil((m - k) * f3 + k);
    int j = k;
    while (j < n)
    {
      Object localObject = (CandleEntry)paramICandleDataSet.getEntryForIndex(j);
      int i = ((Entry)localObject).getXIndex();
      if ((i >= k) && (i < m))
      {
        f3 = ((CandleEntry)localObject).getOpen();
        float f4 = ((CandleEntry)localObject).getClose();
        float f6 = ((CandleEntry)localObject).getHigh();
        float f7 = ((CandleEntry)localObject).getLow();
        float f5;
        if (bool)
        {
          localObject = mShadowBuffers;
          f5 = i;
          localObject[0] = f5;
          localObject[2] = f5;
          localObject[4] = f5;
          localObject[6] = f5;
          if (f3 > f4)
          {
            localObject[1] = (f6 * f1);
            localObject[3] = (f3 * f1);
            localObject[5] = (f7 * f1);
            localObject[7] = (f4 * f1);
          }
          else if (f3 < f4)
          {
            localObject[1] = (f6 * f1);
            localObject[3] = (f4 * f1);
            localObject[5] = (f7 * f1);
            localObject[7] = (f3 * f1);
          }
          else
          {
            localObject[1] = (f6 * f1);
            localObject[3] = (f3 * f1);
            localObject[5] = (f7 * f1);
            localObject[7] = localObject[3];
          }
          localTransformer.pointValuesToPixel(mShadowBuffers);
          if (paramICandleDataSet.getShadowColorSameAsCandle())
          {
            if (f3 > f4)
            {
              localObject = mRenderPaint;
              if (paramICandleDataSet.getDecreasingColor() == 1122867) {
                i = paramICandleDataSet.getColor(j);
              } else {
                i = paramICandleDataSet.getDecreasingColor();
              }
              ((Paint)localObject).setColor(i);
            }
            else if (f3 < f4)
            {
              localObject = mRenderPaint;
              if (paramICandleDataSet.getIncreasingColor() == 1122867) {
                i = paramICandleDataSet.getColor(j);
              } else {
                i = paramICandleDataSet.getIncreasingColor();
              }
              ((Paint)localObject).setColor(i);
            }
            else
            {
              localObject = mRenderPaint;
              if (paramICandleDataSet.getNeutralColor() == 1122867) {
                i = paramICandleDataSet.getColor(j);
              } else {
                i = paramICandleDataSet.getNeutralColor();
              }
              ((Paint)localObject).setColor(i);
            }
          }
          else
          {
            localObject = mRenderPaint;
            if (paramICandleDataSet.getShadowColor() == 1122867) {
              i = paramICandleDataSet.getColor(j);
            } else {
              i = paramICandleDataSet.getShadowColor();
            }
            ((Paint)localObject).setColor(i);
          }
          mRenderPaint.setStyle(Paint.Style.STROKE);
          paramCanvas.drawLines(mShadowBuffers, mRenderPaint);
          localObject = mBodyBuffers;
          localObject[0] = (f5 - 0.5F + f2);
          localObject[1] = (f4 * f1);
          localObject[2] = (f5 + 0.5F - f2);
          localObject[3] = (f3 * f1);
          localTransformer.pointValuesToPixel((float[])localObject);
          if (f3 > f4)
          {
            if (paramICandleDataSet.getDecreasingColor() == 1122867) {
              mRenderPaint.setColor(paramICandleDataSet.getColor(j));
            } else {
              mRenderPaint.setColor(paramICandleDataSet.getDecreasingColor());
            }
            mRenderPaint.setStyle(paramICandleDataSet.getDecreasingPaintStyle());
            localObject = mBodyBuffers;
            paramCanvas.drawRect(localObject[0], localObject[3], localObject[2], localObject[1], mRenderPaint);
          }
          else if (f3 < f4)
          {
            if (paramICandleDataSet.getIncreasingColor() == 1122867) {
              mRenderPaint.setColor(paramICandleDataSet.getColor(j));
            } else {
              mRenderPaint.setColor(paramICandleDataSet.getIncreasingColor());
            }
            mRenderPaint.setStyle(paramICandleDataSet.getIncreasingPaintStyle());
            localObject = mBodyBuffers;
            paramCanvas.drawRect(localObject[0], localObject[1], localObject[2], localObject[3], mRenderPaint);
          }
          else
          {
            if (paramICandleDataSet.getNeutralColor() == 1122867) {
              mRenderPaint.setColor(paramICandleDataSet.getColor(j));
            } else {
              mRenderPaint.setColor(paramICandleDataSet.getNeutralColor());
            }
            localObject = mBodyBuffers;
            paramCanvas.drawLine(localObject[0], localObject[1], localObject[2], localObject[3], mRenderPaint);
          }
        }
        else
        {
          localObject = mRangeBuffers;
          f5 = i;
          localObject[0] = f5;
          localObject[1] = (f6 * f1);
          localObject[2] = f5;
          localObject[3] = (f7 * f1);
          float[] arrayOfFloat = mOpenBuffers;
          arrayOfFloat[0] = (f5 - 0.5F + f2);
          f6 = f3 * f1;
          arrayOfFloat[1] = f6;
          arrayOfFloat[2] = f5;
          arrayOfFloat[3] = f6;
          arrayOfFloat = mCloseBuffers;
          arrayOfFloat[0] = (f5 + 0.5F - f2);
          f6 = f4 * f1;
          arrayOfFloat[1] = f6;
          arrayOfFloat[2] = f5;
          arrayOfFloat[3] = f6;
          localTransformer.pointValuesToPixel((float[])localObject);
          localTransformer.pointValuesToPixel(mOpenBuffers);
          localTransformer.pointValuesToPixel(mCloseBuffers);
          if (f3 > f4)
          {
            if (paramICandleDataSet.getDecreasingColor() == 1122867) {
              i = paramICandleDataSet.getColor(j);
            } else {
              i = paramICandleDataSet.getDecreasingColor();
            }
          }
          else if (f3 < f4)
          {
            if (paramICandleDataSet.getIncreasingColor() == 1122867) {
              i = paramICandleDataSet.getColor(j);
            } else {
              i = paramICandleDataSet.getIncreasingColor();
            }
          }
          else if (paramICandleDataSet.getNeutralColor() == 1122867) {
            i = paramICandleDataSet.getColor(j);
          } else {
            i = paramICandleDataSet.getNeutralColor();
          }
          mRenderPaint.setColor(i);
          localObject = mRangeBuffers;
          paramCanvas.drawLine(localObject[0], localObject[1], localObject[2], localObject[3], mRenderPaint);
          localObject = mOpenBuffers;
          paramCanvas.drawLine(localObject[0], localObject[1], localObject[2], localObject[3], mRenderPaint);
          localObject = mCloseBuffers;
          paramCanvas.drawLine(localObject[0], localObject[1], localObject[2], localObject[3], mRenderPaint);
        }
      }
      j += 1;
    }
  }
  
  public void drawExtras(Canvas paramCanvas) {}
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    int i = 0;
    while (i < paramArrayOfHighlight.length)
    {
      int j = paramArrayOfHighlight[i].getXIndex();
      ICandleDataSet localICandleDataSet = (ICandleDataSet)mChart.getCandleData().getDataSetByIndex(paramArrayOfHighlight[i].getDataSetIndex());
      if ((localICandleDataSet != null) && (localICandleDataSet.isHighlightEnabled()))
      {
        Object localObject = (CandleEntry)localICandleDataSet.getEntryForXIndex(j);
        if ((localObject != null) && (((Entry)localObject).getXIndex() == j))
        {
          float f1 = ((CandleEntry)localObject).getLow();
          float f2 = mAnimator.getPhaseY();
          float f3 = ((CandleEntry)localObject).getHigh();
          f1 = (mAnimator.getPhaseY() * f3 + f2 * f1) / 2.0F;
          mChart.getYChartMin();
          mChart.getYChartMax();
          localObject = new float[2];
          localObject[0] = j;
          localObject[1] = f1;
          mChart.getTransformer(localICandleDataSet.getAxisDependency()).pointValuesToPixel((float[])localObject);
          drawHighlightLines(paramCanvas, (float[])localObject, localICandleDataSet);
        }
      }
      i += 1;
    }
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    float f1 = mChart.getCandleData().getYValCount();
    float f2 = mChart.getMaxVisibleCount();
    if (f1 < mViewPortHandler.getScaleX() * f2)
    {
      List localList = mChart.getCandleData().getDataSets();
      int i = 0;
      while (i < localList.size())
      {
        ICandleDataSet localICandleDataSet = (ICandleDataSet)localList.get(i);
        if ((localICandleDataSet.isDrawValuesEnabled()) && (localICandleDataSet.getEntryCount() != 0))
        {
          applyValueTextStyle(localICandleDataSet);
          Object localObject = mChart.getTransformer(localICandleDataSet.getAxisDependency());
          int k = Math.max(mMinX, 0);
          int j = Math.min(mMaxX + 1, localICandleDataSet.getEntryCount());
          localObject = ((Transformer)localObject).generateTransformedValuesCandle(localICandleDataSet, mAnimator.getPhaseX(), mAnimator.getPhaseY(), k, j);
          f1 = Utils.convertDpToPixel(5.0F);
          j = 0;
          while (j < localObject.length)
          {
            f2 = localObject[j];
            float f3 = localObject[(j + 1)];
            if (!mViewPortHandler.isInBoundsRight(f2)) {
              break;
            }
            if ((mViewPortHandler.isInBoundsLeft(f2)) && (mViewPortHandler.isInBoundsY(f3)))
            {
              int m = j / 2;
              CandleEntry localCandleEntry = (CandleEntry)localICandleDataSet.getEntryForIndex(m + k);
              drawValue(paramCanvas, localICandleDataSet.getValueFormatter(), localCandleEntry.getHigh(), localCandleEntry, i, f2, f3 - f1, localICandleDataSet.getValueTextColor(m));
            }
            j += 2;
          }
        }
        i += 1;
      }
    }
  }
  
  public void initBuffers() {}
}
