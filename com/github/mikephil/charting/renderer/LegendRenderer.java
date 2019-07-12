package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendDirection;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LegendRenderer
  extends Renderer
{
  public Legend mLegend;
  public Paint mLegendFormPaint;
  public Paint mLegendLabelPaint;
  
  public LegendRenderer(ViewPortHandler paramViewPortHandler, Legend paramLegend)
  {
    super(paramViewPortHandler);
    mLegend = paramLegend;
    mLegendLabelPaint = new Paint(1);
    mLegendLabelPaint.setTextSize(Utils.convertDpToPixel(9.0F));
    mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
    mLegendFormPaint = new Paint(1);
    mLegendFormPaint.setStyle(Paint.Style.FILL);
    mLegendFormPaint.setStrokeWidth(3.0F);
  }
  
  public void computeLegend(ChartData paramChartData)
  {
    if (!mLegend.isLegendCustom())
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int k = 0;
      int i = 0;
      int j;
      while (i < paramChartData.getDataSetCount())
      {
        Object localObject1 = paramChartData.getDataSetByIndex(i);
        List localList = ((IDataSet)localObject1).getColors();
        int m = ((IDataSet)localObject1).getEntryCount();
        Object localObject2;
        if ((localObject1 instanceof IBarDataSet))
        {
          localObject2 = (IBarDataSet)localObject1;
          if (((IBarDataSet)localObject2).isStacked())
          {
            localObject1 = ((IBarDataSet)localObject2).getStackLabels();
            j = 0;
            while ((j < localList.size()) && (j < ((IBarDataSet)localObject2).getStackSize()))
            {
              localArrayList1.add(localObject1[(j % localObject1.length)]);
              localArrayList2.add(localList.get(j));
              j += 1;
            }
            if (((IDataSet)localObject2).getLabel() == null) {
              break label518;
            }
            localArrayList2.add(Integer.valueOf(1122868));
            localArrayList1.add(((IDataSet)localObject2).getLabel());
            break label518;
          }
        }
        if ((localObject1 instanceof IPieDataSet))
        {
          localObject2 = paramChartData.getXVals();
          localObject1 = (IPieDataSet)localObject1;
          j = 0;
          while ((j < localList.size()) && (j < m) && (j < ((List)localObject2).size()))
          {
            localArrayList1.add(((List)localObject2).get(j));
            localArrayList2.add(localList.get(j));
            j += 1;
          }
          if (((IDataSet)localObject1).getLabel() != null)
          {
            localArrayList2.add(Integer.valueOf(1122868));
            localArrayList1.add(((IDataSet)localObject1).getLabel());
          }
        }
        else
        {
          if ((localObject1 instanceof ICandleDataSet))
          {
            localObject2 = (ICandleDataSet)localObject1;
            if (((ICandleDataSet)localObject2).getDecreasingColor() != 1122867)
            {
              localArrayList2.add(Integer.valueOf(((ICandleDataSet)localObject2).getDecreasingColor()));
              localArrayList2.add(Integer.valueOf(((ICandleDataSet)localObject2).getIncreasingColor()));
              localArrayList1.add(null);
              localArrayList1.add(((IDataSet)localObject1).getLabel());
              break label518;
            }
          }
          j = 0;
          while ((j < localList.size()) && (j < m))
          {
            if ((j < localList.size() - 1) && (j < m - 1)) {
              localArrayList1.add(null);
            } else {
              localArrayList1.add(paramChartData.getDataSetByIndex(i).getLabel());
            }
            localArrayList2.add(localList.get(j));
            j += 1;
          }
        }
        label518:
        i += 1;
      }
      if ((mLegend.getExtraColors() != null) && (mLegend.getExtraLabels() != null))
      {
        paramChartData = mLegend.getExtraColors();
        j = paramChartData.length;
        i = k;
        while (i < j)
        {
          localArrayList2.add(Integer.valueOf(paramChartData[i]));
          i += 1;
        }
        Collections.addAll(localArrayList1, mLegend.getExtraLabels());
      }
      mLegend.setComputedColors(localArrayList2);
      mLegend.setComputedLabels(localArrayList1);
    }
    paramChartData = mLegend.getTypeface();
    if (paramChartData != null) {
      mLegendLabelPaint.setTypeface(paramChartData);
    }
    mLegendLabelPaint.setTextSize(mLegend.getTextSize());
    mLegendLabelPaint.setColor(mLegend.getTextColor());
    mLegend.calculateDimensions(mLegendLabelPaint, mViewPortHandler);
  }
  
  public void drawForm(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt, Legend paramLegend)
  {
    if (paramLegend.getColors()[paramInt] == 1122868) {
      return;
    }
    mLegendFormPaint.setColor(paramLegend.getColors()[paramInt]);
    float f1 = paramLegend.getFormSize();
    float f2 = f1 / 2.0F;
    paramInt = paramLegend.getForm().ordinal();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramCanvas.drawLine(paramFloat1, paramFloat2, paramFloat1 + f1, paramFloat2, mLegendFormPaint);
        return;
      }
      paramCanvas.drawCircle(paramFloat1 + f2, paramFloat2, f2, mLegendFormPaint);
      return;
    }
    paramCanvas.drawRect(paramFloat1, paramFloat2 - f2, paramFloat1 + f1, paramFloat2 + f2, mLegendFormPaint);
  }
  
  public void drawLabel(Canvas paramCanvas, float paramFloat1, float paramFloat2, String paramString)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, mLegendLabelPaint);
  }
  
  public Paint getFormPaint()
  {
    return mLegendFormPaint;
  }
  
  public Paint getLabelPaint()
  {
    return mLegendLabelPaint;
  }
  
  public void renderLegend(Canvas paramCanvas)
  {
    if (!mLegend.isEnabled()) {
      return;
    }
    Object localObject1 = mLegend.getTypeface();
    if (localObject1 != null) {
      mLegendLabelPaint.setTypeface((Typeface)localObject1);
    }
    mLegendLabelPaint.setTextSize(mLegend.getTextSize());
    mLegendLabelPaint.setColor(mLegend.getTextColor());
    float f9 = Utils.getLineHeight(mLegendLabelPaint);
    float f1 = Utils.getLineSpacing(mLegendLabelPaint);
    float f10 = mLegend.getYEntrySpace() + f1;
    float f11 = f9 - Utils.calcTextHeight(mLegendLabelPaint, "ABC") / 2.0F;
    String[] arrayOfString = mLegend.getLabels();
    int[] arrayOfInt = mLegend.getColors();
    float f5 = mLegend.getFormToTextSpace();
    float f8 = mLegend.getXEntrySpace();
    Legend.LegendDirection localLegendDirection = mLegend.getDirection();
    Object localObject2 = localLegendDirection;
    float f12 = mLegend.getFormSize();
    float f7 = mLegend.getStackSpace();
    float f4 = mLegend.getYOffset();
    float f3 = f4;
    float f2 = mLegend.getXOffset();
    f1 = f2;
    Legend.LegendPosition localLegendPosition = mLegend.getPosition();
    localObject1 = localLegendPosition;
    float f6;
    int i;
    label612:
    int j;
    switch (localLegendPosition.ordinal())
    {
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 12: 
      if (localLegendPosition == Legend.LegendPosition.PIECHART_CENTER)
      {
        f2 = mViewPortHandler.getChartWidth() / 2.0F;
        if (localLegendDirection == Legend.LegendDirection.LEFT_TO_RIGHT) {
          f1 = -mLegend.mTextWidthMax;
        } else {
          f1 = mLegend.mTextWidthMax;
        }
        f1 /= 2.0F;
        f3 = mViewPortHandler.getChartHeight() / 2.0F;
        localObject1 = mLegend;
        f4 = mNeededHeight / 2.0F;
        f6 = ((ComponentBase)localObject1).getYOffset();
        f1 = f2 + f1;
        f3 = f6 + (f3 - f4);
      }
      else
      {
        if ((localLegendPosition != Legend.LegendPosition.RIGHT_OF_CHART) && (localLegendPosition != Legend.LegendPosition.RIGHT_OF_CHART_CENTER) && (localLegendPosition != Legend.LegendPosition.RIGHT_OF_CHART_INSIDE)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0)
        {
          f2 = mViewPortHandler.getChartWidth() - f2;
          f1 = f2;
          if (localLegendDirection == Legend.LegendDirection.LEFT_TO_RIGHT) {
            f1 = f2 - mLegend.mTextWidthMax;
          }
        }
        else if (localLegendDirection == Legend.LegendDirection.RIGHT_TO_LEFT)
        {
          f1 = f2 + mLegend.mTextWidthMax;
        }
        if ((localLegendPosition != Legend.LegendPosition.RIGHT_OF_CHART) && (localLegendPosition != Legend.LegendPosition.LEFT_OF_CHART))
        {
          if ((localLegendPosition != Legend.LegendPosition.RIGHT_OF_CHART_CENTER) && (localLegendPosition != Legend.LegendPosition.LEFT_OF_CHART_CENTER))
          {
            f2 = mViewPortHandler.contentTop();
          }
          else
          {
            f3 = mViewPortHandler.getChartHeight() / 2.0F - mLegend.mNeededHeight / 2.0F;
            break label612;
          }
        }
        else {
          f2 = mViewPortHandler.contentTop();
        }
        f3 = f4 + f2;
      }
      i = 0;
      f4 = 0.0F;
      j = 0;
      localObject1 = localObject2;
    }
    while (i < arrayOfString.length)
    {
      boolean bool;
      if (arrayOfInt[i] != 1122868) {
        bool = true;
      } else {
        bool = false;
      }
      localObject2 = Boolean.valueOf(bool);
      if (((Boolean)localObject2).booleanValue())
      {
        if (localObject1 == Legend.LegendDirection.LEFT_TO_RIGHT) {
          f2 = f1 + f4;
        } else {
          f2 = f1 - (f12 - f4);
        }
        drawForm(paramCanvas, f2, f3 + f11, i, mLegend);
        if (localObject1 == Legend.LegendDirection.LEFT_TO_RIGHT) {
          f2 += f12;
        }
      }
      else
      {
        f2 = f1;
      }
      f6 = f2;
      f2 = f1;
      if (arrayOfString[i] != null)
      {
        if ((((Boolean)localObject2).booleanValue()) && (j == 0))
        {
          if (localObject1 == Legend.LegendDirection.LEFT_TO_RIGHT) {
            f1 = f5;
          } else {
            f1 = -f5;
          }
          f1 = f6 + f1;
        }
        else
        {
          f1 = f6;
          if (j != 0) {
            f1 = f2;
          }
        }
        f4 = f1;
        if (localObject1 == Legend.LegendDirection.RIGHT_TO_LEFT) {
          f4 = f1 - Utils.calcTextWidth(mLegendLabelPaint, arrayOfString[i]);
        }
        if (j == 0)
        {
          drawLabel(paramCanvas, f4, f3 + f9, arrayOfString[i]);
        }
        else
        {
          f3 = f9 + f10 + f3;
          drawLabel(paramCanvas, f4, f3 + f9, arrayOfString[i]);
        }
        f3 = f9 + f10 + f3;
        f4 = 0.0F;
      }
      else
      {
        f4 = f12 + f7 + f4;
        j = 1;
      }
      i += 1;
      f1 = f2;
      continue;
      f6 = mViewPortHandler.contentWidth();
      if ((localLegendPosition != Legend.LegendPosition.BELOW_CHART_LEFT) && (localLegendPosition != Legend.LegendPosition.ABOVE_CHART_LEFT))
      {
        if ((localLegendPosition != Legend.LegendPosition.BELOW_CHART_RIGHT) && (localLegendPosition != Legend.LegendPosition.ABOVE_CHART_RIGHT))
        {
          f1 = mViewPortHandler.contentLeft();
          f2 = f6 / 2.0F;
        }
        else
        {
          f2 = mViewPortHandler.contentRight() - f2;
          f1 = f2;
          if (localLegendDirection != Legend.LegendDirection.LEFT_TO_RIGHT) {
            break label1039;
          }
          f1 = f2 - mLegend.mNeededWidth;
          break label1039;
        }
      }
      else
      {
        f2 = mViewPortHandler.contentLeft() + f2;
        f1 = f2;
        if (localLegendDirection != Legend.LegendDirection.RIGHT_TO_LEFT) {
          break label1039;
        }
        f1 = mLegend.mNeededWidth;
      }
      f1 = f2 + f1;
      label1039:
      localObject2 = mLegend.getCalculatedLineSizes();
      FSize[] arrayOfFSize = mLegend.getCalculatedLabelSizes();
      Boolean[] arrayOfBoolean = mLegend.getCalculatedLabelBreakPoints();
      f2 = f3;
      if (localLegendPosition != Legend.LegendPosition.ABOVE_CHART_LEFT)
      {
        f2 = f3;
        if (localLegendPosition != Legend.LegendPosition.ABOVE_CHART_RIGHT) {
          if (localLegendPosition == Legend.LegendPosition.ABOVE_CHART_CENTER) {
            f2 = f3;
          } else {
            f2 = mViewPortHandler.getChartHeight() - f4 - mLegend.mNeededHeight;
          }
        }
      }
      int n = arrayOfString.length;
      f6 = f2;
      f2 = f1;
      i = 0;
      for (int k = 0; i < n; k = j)
      {
        f3 = f2;
        f4 = f6;
        if (i < arrayOfBoolean.length)
        {
          f3 = f2;
          f4 = f6;
          if (arrayOfBoolean[i].booleanValue())
          {
            f4 = f9 + f10 + f6;
            f3 = f1;
          }
        }
        f2 = f3;
        j = k;
        if (f3 == f1) {
          if (localObject1 != Legend.LegendPosition.BELOW_CHART_CENTER)
          {
            f2 = f3;
            j = k;
            if (localObject1 != Legend.LegendPosition.ABOVE_CHART_CENTER) {}
          }
          else
          {
            f2 = f3;
            j = k;
            if (k < localObject2.length)
            {
              if (localLegendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                f2 = width;
              } else {
                f2 = -width;
              }
              f2 = f2 / 2.0F + f3;
              j = k + 1;
            }
          }
        }
        if (arrayOfInt[i] != 1122868) {
          k = 1;
        } else {
          k = 0;
        }
        int m;
        if (arrayOfString[i] == null) {
          m = 1;
        } else {
          m = 0;
        }
        if (k != 0)
        {
          f3 = f2;
          if (localLegendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
            f3 = f2 - f12;
          }
          drawForm(paramCanvas, f3, f4 + f11, i, mLegend);
          f2 = f3;
          if (localLegendDirection == Legend.LegendDirection.LEFT_TO_RIGHT) {
            f2 = f3 + f12;
          }
        }
        if (m == 0)
        {
          f3 = f2;
          if (k != 0)
          {
            if (localLegendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
              f3 = -f5;
            } else {
              f3 = f5;
            }
            f3 = f2 + f3;
          }
          f2 = f3;
          if (localLegendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
            f2 = f3 - width;
          }
          f3 = f2;
          drawLabel(paramCanvas, f2, f4 + f9, arrayOfString[i]);
          if (localLegendDirection == Legend.LegendDirection.LEFT_TO_RIGHT) {
            f3 = f2 + width;
          }
          if (localLegendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
            f2 = -f8;
          } else {
            f2 = f8;
          }
          f2 = f3 + f2;
        }
        else
        {
          if (localLegendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
            f3 = -f7;
          } else {
            f3 = f7;
          }
          f2 += f3;
        }
        i += 1;
        f6 = f4;
      }
    }
  }
}
