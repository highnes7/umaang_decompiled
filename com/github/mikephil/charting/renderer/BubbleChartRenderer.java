package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.Iterator;
import java.util.List;

public class BubbleChartRenderer
  extends DataRenderer
{
  public float[] _hsvBuffer = new float[3];
  public BubbleDataProvider mChart;
  public float[] pointBuffer = new float[2];
  public float[] sizeBuffer = new float[4];
  
  public BubbleChartRenderer(BubbleDataProvider paramBubbleDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    mChart = paramBubbleDataProvider;
    mRenderPaint.setStyle(Paint.Style.FILL);
    mHighlightPaint.setStyle(Paint.Style.STROKE);
    mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5F));
  }
  
  public void drawData(Canvas paramCanvas)
  {
    Iterator localIterator = mChart.getBubbleData().getDataSets().iterator();
    while (localIterator.hasNext())
    {
      IBubbleDataSet localIBubbleDataSet = (IBubbleDataSet)localIterator.next();
      if ((localIBubbleDataSet.isVisible()) && (localIBubbleDataSet.getEntryCount() > 0)) {
        drawDataSet(paramCanvas, localIBubbleDataSet);
      }
    }
  }
  
  public void drawDataSet(Canvas paramCanvas, IBubbleDataSet paramIBubbleDataSet)
  {
    Transformer localTransformer = mChart.getTransformer(paramIBubbleDataSet.getAxisDependency());
    float f1 = mAnimator.getPhaseX();
    float f2 = mAnimator.getPhaseY();
    Object localObject = (BubbleEntry)paramIBubbleDataSet.getEntryForXIndex(mMinX);
    BubbleEntry localBubbleEntry = (BubbleEntry)paramIBubbleDataSet.getEntryForXIndex(mMaxX);
    int j = Math.max(paramIBubbleDataSet.getEntryIndex((Entry)localObject), 0);
    int k = Math.min(paramIBubbleDataSet.getEntryIndex(localBubbleEntry) + 1, paramIBubbleDataSet.getEntryCount());
    localObject = sizeBuffer;
    localObject[0] = 0.0F;
    localObject[2] = 1.06535322E9F;
    localTransformer.pointValuesToPixel((float[])localObject);
    localObject = sizeBuffer;
    float f3 = Math.abs(localObject[2] - localObject[0]);
    f3 = Math.min(Math.abs(mViewPortHandler.contentBottom() - mViewPortHandler.contentTop()), f3);
    int i = j;
    while (i < k)
    {
      localObject = (BubbleEntry)paramIBubbleDataSet.getEntryForIndex(i);
      pointBuffer[0] = ((((Entry)localObject).getXIndex() - j) * f1 + j);
      pointBuffer[1] = (((Entry)localObject).getVal() * f2);
      localTransformer.pointValuesToPixel(pointBuffer);
      float f4 = getShapeSize(((BubbleEntry)localObject).getSize(), paramIBubbleDataSet.getMaxSize(), f3) / 2.0F;
      if ((mViewPortHandler.isInBoundsTop(pointBuffer[1] + f4)) && (mViewPortHandler.isInBoundsBottom(pointBuffer[1] - f4)) && (mViewPortHandler.isInBoundsLeft(pointBuffer[0] + f4)))
      {
        if (!mViewPortHandler.isInBoundsRight(pointBuffer[0] - f4)) {
          return;
        }
        int m = paramIBubbleDataSet.getColor(((Entry)localObject).getXIndex());
        mRenderPaint.setColor(m);
        localObject = pointBuffer;
        paramCanvas.drawCircle(localObject[0], localObject[1], f4, mRenderPaint);
      }
      i += 1;
    }
  }
  
  public void drawExtras(Canvas paramCanvas) {}
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    BubbleData localBubbleData = mChart.getBubbleData();
    float f1 = mAnimator.getPhaseX();
    float f2 = mAnimator.getPhaseY();
    int j = paramArrayOfHighlight.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramArrayOfHighlight[i];
      Object localObject1 = (IBubbleDataSet)localBubbleData.getDataSetByIndex(((Highlight)localObject2).getDataSetIndex());
      if ((localObject1 != null) && (((IDataSet)localObject1).isHighlightEnabled()))
      {
        BubbleEntry localBubbleEntry = (BubbleEntry)((IDataSet)localObject1).getEntryForXIndex(mMinX);
        Object localObject3 = (BubbleEntry)((IDataSet)localObject1).getEntryForXIndex(mMaxX);
        int k = ((IDataSet)localObject1).getEntryIndex(localBubbleEntry);
        int m = Math.min(((IDataSet)localObject1).getEntryIndex((Entry)localObject3) + 1, ((IDataSet)localObject1).getEntryCount());
        localBubbleEntry = (BubbleEntry)localBubbleData.getEntryForHighlight((Highlight)localObject2);
        if ((localBubbleEntry != null) && (localBubbleEntry.getXIndex() == ((Highlight)localObject2).getXIndex()))
        {
          localObject3 = mChart.getTransformer(((IDataSet)localObject1).getAxisDependency());
          float[] arrayOfFloat = sizeBuffer;
          arrayOfFloat[0] = 0.0F;
          arrayOfFloat[2] = 1.06535322E9F;
          ((Transformer)localObject3).pointValuesToPixel(arrayOfFloat);
          arrayOfFloat = sizeBuffer;
          float f3 = Math.abs(arrayOfFloat[2] - arrayOfFloat[0]);
          f3 = Math.min(Math.abs(mViewPortHandler.contentBottom() - mViewPortHandler.contentTop()), f3);
          pointBuffer[0] = ((localBubbleEntry.getXIndex() - k) * f1 + k);
          pointBuffer[1] = (localBubbleEntry.getVal() * f2);
          ((Transformer)localObject3).pointValuesToPixel(pointBuffer);
          f3 = getShapeSize(localBubbleEntry.getSize(), ((IBubbleDataSet)localObject1).getMaxSize(), f3) / 2.0F;
          if ((mViewPortHandler.isInBoundsTop(pointBuffer[1] + f3)) && (mViewPortHandler.isInBoundsBottom(pointBuffer[1] - f3)) && (mViewPortHandler.isInBoundsLeft(pointBuffer[0] + f3)))
          {
            if (!mViewPortHandler.isInBoundsRight(pointBuffer[0] - f3)) {
              return;
            }
            if ((((Highlight)localObject2).getXIndex() >= k) && (((Highlight)localObject2).getXIndex() < m))
            {
              k = ((IDataSet)localObject1).getColor(localBubbleEntry.getXIndex());
              Color.RGBToHSV(Color.red(k), Color.green(k), Color.blue(k), _hsvBuffer);
              localObject2 = _hsvBuffer;
              localObject2[2] *= 0.5F;
              k = Color.HSVToColor(Color.alpha(k), _hsvBuffer);
              mHighlightPaint.setColor(k);
              mHighlightPaint.setStrokeWidth(((IBubbleDataSet)localObject1).getHighlightCircleWidth());
              localObject1 = pointBuffer;
              paramCanvas.drawCircle(localObject1[0], localObject1[1], f3, mHighlightPaint);
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    Object localObject1 = mChart.getBubbleData();
    if (localObject1 == null) {
      return;
    }
    int i = ((ChartData)localObject1).getYValCount();
    float f1 = mChart.getMaxVisibleCount();
    if (i < (int)Math.ceil(mViewPortHandler.getScaleX() * f1))
    {
      localObject1 = ((ChartData)localObject1).getDataSets();
      float f4 = Utils.calcTextHeight(mValuePaint, "1");
      i = 0;
      while (i < ((List)localObject1).size())
      {
        IBubbleDataSet localIBubbleDataSet = (IBubbleDataSet)((List)localObject1).get(i);
        if ((localIBubbleDataSet.isDrawValuesEnabled()) && (localIBubbleDataSet.getEntryCount() != 0))
        {
          applyValueTextStyle(localIBubbleDataSet);
          float f2 = mAnimator.getPhaseX();
          float f3 = mAnimator.getPhaseY();
          Object localObject2 = (BubbleEntry)localIBubbleDataSet.getEntryForXIndex(mMinX);
          BubbleEntry localBubbleEntry = (BubbleEntry)localIBubbleDataSet.getEntryForXIndex(mMaxX);
          int k = localIBubbleDataSet.getEntryIndex((Entry)localObject2);
          int j = Math.min(localIBubbleDataSet.getEntryIndex(localBubbleEntry) + 1, localIBubbleDataSet.getEntryCount());
          localObject2 = mChart.getTransformer(localIBubbleDataSet.getAxisDependency()).generateTransformedValuesBubble(localIBubbleDataSet, f2, f3, k, j);
          f1 = f2;
          if (f2 == 1.0F) {
            f1 = f3;
          }
          j = 0;
          while (j < localObject2.length)
          {
            int m = j / 2 + k;
            int n = localIBubbleDataSet.getValueTextColor(m);
            n = Color.argb(Math.round(255.0F * f1), Color.red(n), Color.green(n), Color.blue(n));
            f2 = localObject2[j];
            f3 = localObject2[(j + 1)];
            if (!mViewPortHandler.isInBoundsRight(f2)) {
              break;
            }
            if ((mViewPortHandler.isInBoundsLeft(f2)) && (mViewPortHandler.isInBoundsY(f3)))
            {
              localBubbleEntry = (BubbleEntry)localIBubbleDataSet.getEntryForIndex(m);
              drawValue(paramCanvas, localIBubbleDataSet.getValueFormatter(), localBubbleEntry.getSize(), localBubbleEntry, i, f2, 0.5F * f4 + f3, n);
            }
            j += 2;
          }
        }
        i += 1;
      }
    }
  }
  
  public float getShapeSize(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat2 == 0.0F) {
      paramFloat1 = 1.0F;
    } else {
      paramFloat1 = (float)Math.sqrt(paramFloat1 / paramFloat2);
    }
    return paramFloat3 * paramFloat1;
  }
  
  public void initBuffers() {}
}
