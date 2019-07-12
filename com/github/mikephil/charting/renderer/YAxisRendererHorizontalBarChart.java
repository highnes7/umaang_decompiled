package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.LimitLine.LimitLabelPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.components.YAxis.YAxisLabelPosition;
import com.github.mikephil.charting.utils.PointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRendererHorizontalBarChart
  extends YAxisRenderer
{
  public YAxisRendererHorizontalBarChart(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, Transformer paramTransformer)
  {
    super(paramViewPortHandler, paramYAxis, paramTransformer);
    mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
  }
  
  public void computeAxis(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (mViewPortHandler.contentHeight() > 10.0F)
    {
      f1 = paramFloat1;
      f2 = paramFloat2;
      if (!mViewPortHandler.isFullyZoomedOutX())
      {
        PointD localPointD1 = mTrans.getValuesByTouchPoint(mViewPortHandler.contentLeft(), mViewPortHandler.contentTop());
        PointD localPointD2 = mTrans.getValuesByTouchPoint(mViewPortHandler.contentRight(), mViewPortHandler.contentTop());
        if (!mYAxis.isInverted())
        {
          f1 = (float)x;
          f2 = (float)x;
        }
        else
        {
          f1 = (float)x;
          f2 = (float)x;
        }
      }
    }
    computeAxisValues(f1, f2);
  }
  
  public void drawYLabels(Canvas paramCanvas, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2)
  {
    mAxisLabelPaint.setTypeface(mYAxis.getTypeface());
    mAxisLabelPaint.setTextSize(mYAxis.getTextSize());
    mAxisLabelPaint.setColor(mYAxis.getTextColor());
    int i = 0;
    for (;;)
    {
      Object localObject = mYAxis;
      if (i >= mEntryCount) {
        break;
      }
      localObject = ((YAxis)localObject).getFormattedLabel(i);
      if ((!mYAxis.isDrawTopYLabelEntryEnabled()) && (i >= mYAxis.mEntryCount - 1)) {
        return;
      }
      paramCanvas.drawText((String)localObject, paramArrayOfFloat[(i * 2)], paramFloat1 - paramFloat2, mAxisLabelPaint);
      i += 1;
    }
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    if (mYAxis.isEnabled())
    {
      if (!mYAxis.isDrawLabelsEnabled()) {
        return;
      }
      float[] arrayOfFloat = new float[mYAxis.mEntryCount * 2];
      int i = 0;
      while (i < arrayOfFloat.length)
      {
        arrayOfFloat[i] = mYAxis.mEntries[(i / 2)];
        i += 2;
      }
      mTrans.pointValuesToPixel(arrayOfFloat);
      mAxisLabelPaint.setTypeface(mYAxis.getTypeface());
      mAxisLabelPaint.setTextSize(mYAxis.getTextSize());
      mAxisLabelPaint.setColor(mYAxis.getTextColor());
      mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
      float f2 = Utils.convertDpToPixel(2.5F);
      float f3 = Utils.calcTextHeight(mAxisLabelPaint, "Q");
      YAxis.AxisDependency localAxisDependency = mYAxis.getAxisDependency();
      YAxis.YAxisLabelPosition localYAxisLabelPosition = mYAxis.getLabelPosition();
      float f1;
      if (localAxisDependency == YAxis.AxisDependency.LEFT)
      {
        if (localYAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
          f1 = mViewPortHandler.contentTop();
        } else {
          f1 = mViewPortHandler.contentTop();
        }
        f1 -= f2;
      }
      else
      {
        if (localYAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
          f1 = mViewPortHandler.contentBottom();
        } else {
          f1 = mViewPortHandler.contentBottom();
        }
        f1 = f1 + f3 + f2;
      }
      drawYLabels(paramCanvas, f1, arrayOfFloat, mYAxis.getYOffset());
    }
  }
  
  public void renderAxisLine(Canvas paramCanvas)
  {
    if (mYAxis.isEnabled())
    {
      if (!mYAxis.isDrawAxisLineEnabled()) {
        return;
      }
      mAxisLinePaint.setColor(mYAxis.getAxisLineColor());
      mAxisLinePaint.setStrokeWidth(mYAxis.getAxisLineWidth());
      if (mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT)
      {
        paramCanvas.drawLine(mViewPortHandler.contentLeft(), mViewPortHandler.contentTop(), mViewPortHandler.contentRight(), mViewPortHandler.contentTop(), mAxisLinePaint);
        return;
      }
      paramCanvas.drawLine(mViewPortHandler.contentLeft(), mViewPortHandler.contentBottom(), mViewPortHandler.contentRight(), mViewPortHandler.contentBottom(), mAxisLinePaint);
    }
  }
  
  public void renderGridLines(Canvas paramCanvas)
  {
    if (!mYAxis.isEnabled()) {
      return;
    }
    float[] arrayOfFloat = new float[2];
    if (mYAxis.isDrawGridLinesEnabled())
    {
      mGridPaint.setColor(mYAxis.getGridColor());
      mGridPaint.setStrokeWidth(mYAxis.getGridLineWidth());
      int i = 0;
      for (;;)
      {
        YAxis localYAxis = mYAxis;
        if (i >= mEntryCount) {
          break;
        }
        arrayOfFloat[0] = mEntries[i];
        mTrans.pointValuesToPixel(arrayOfFloat);
        paramCanvas.drawLine(arrayOfFloat[0], mViewPortHandler.contentTop(), arrayOfFloat[0], mViewPortHandler.contentBottom(), mGridPaint);
        i += 1;
      }
    }
    if (mYAxis.isDrawZeroLineEnabled())
    {
      arrayOfFloat[0] = 0.0F;
      mTrans.pointValuesToPixel(arrayOfFloat);
      drawZeroLine(paramCanvas, arrayOfFloat[0] + 1.0F, arrayOfFloat[0] + 1.0F, mViewPortHandler.contentTop(), mViewPortHandler.contentBottom());
    }
  }
  
  public void renderLimitLines(Canvas paramCanvas)
  {
    List localList = mYAxis.getLimitLines();
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      float[] arrayOfFloat = new float[4];
      Path localPath = new Path();
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (LimitLine)localList.get(i);
        if (((ComponentBase)localObject).isEnabled())
        {
          arrayOfFloat[0] = ((LimitLine)localObject).getLimit();
          arrayOfFloat[2] = ((LimitLine)localObject).getLimit();
          mTrans.pointValuesToPixel(arrayOfFloat);
          arrayOfFloat[1] = mViewPortHandler.contentTop();
          arrayOfFloat[3] = mViewPortHandler.contentBottom();
          localPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
          localPath.lineTo(arrayOfFloat[2], arrayOfFloat[3]);
          mLimitLinePaint.setStyle(Paint.Style.STROKE);
          mLimitLinePaint.setColor(((LimitLine)localObject).getLineColor());
          mLimitLinePaint.setPathEffect(((LimitLine)localObject).getDashPathEffect());
          mLimitLinePaint.setStrokeWidth(((LimitLine)localObject).getLineWidth());
          paramCanvas.drawPath(localPath, mLimitLinePaint);
          localPath.reset();
          String str = ((LimitLine)localObject).getLabel();
          if ((str != null) && (!str.equals("")))
          {
            mLimitLinePaint.setStyle(((LimitLine)localObject).getTextStyle());
            mLimitLinePaint.setPathEffect(null);
            mLimitLinePaint.setColor(((ComponentBase)localObject).getTextColor());
            mLimitLinePaint.setTypeface(((ComponentBase)localObject).getTypeface());
            mLimitLinePaint.setStrokeWidth(0.5F);
            mLimitLinePaint.setTextSize(((ComponentBase)localObject).getTextSize());
            float f1 = ((LimitLine)localObject).getLineWidth();
            f1 = ((ComponentBase)localObject).getXOffset() + f1;
            float f2 = Utils.convertDpToPixel(2.0F);
            f2 = ((ComponentBase)localObject).getYOffset() + f2;
            localObject = ((LimitLine)localObject).getLabelPosition();
            float f3;
            if (localObject == LimitLine.LimitLabelPosition.RIGHT_TOP)
            {
              f3 = Utils.calcTextHeight(mLimitLinePaint, str);
              mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, arrayOfFloat[0] + f1, mViewPortHandler.contentTop() + f2 + f3, mLimitLinePaint);
            }
            else if (localObject == LimitLine.LimitLabelPosition.RIGHT_BOTTOM)
            {
              mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, arrayOfFloat[0] + f1, mViewPortHandler.contentBottom() - f2, mLimitLinePaint);
            }
            else if (localObject == LimitLine.LimitLabelPosition.LEFT_TOP)
            {
              mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
              f3 = Utils.calcTextHeight(mLimitLinePaint, str);
              paramCanvas.drawText(str, arrayOfFloat[0] - f1, mViewPortHandler.contentTop() + f2 + f3, mLimitLinePaint);
            }
            else
            {
              mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, arrayOfFloat[0] - f1, mViewPortHandler.contentBottom() - f2, mLimitLinePaint);
            }
          }
        }
        i += 1;
      }
    }
  }
}
