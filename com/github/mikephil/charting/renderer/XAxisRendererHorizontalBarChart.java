package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.LimitLine.LimitLabelPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRendererHorizontalBarChart
  extends XAxisRendererBarChart
{
  public XAxisRendererHorizontalBarChart(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, Transformer paramTransformer, BarChart paramBarChart)
  {
    super(paramViewPortHandler, paramXAxis, paramTransformer, paramBarChart);
  }
  
  public void computeAxis(float paramFloat, List paramList)
  {
    mAxisLabelPaint.setTypeface(mXAxis.getTypeface());
    mAxisLabelPaint.setTextSize(mXAxis.getTextSize());
    mXAxis.setValues(paramList);
    paramList = mXAxis.getLongestLabel();
    paramList = Utils.calcTextSize(mAxisLabelPaint, paramList);
    paramFloat = width;
    paramFloat = (int)(mXAxis.getXOffset() * 3.5F + paramFloat);
    float f = height;
    paramList = Utils.getSizeOfRotatedRectangleByDegrees(width, f, mXAxis.getLabelRotationAngle());
    mXAxis.mLabelWidth = Math.round(paramFloat);
    mXAxis.mLabelHeight = Math.round(f);
    XAxis localXAxis = mXAxis;
    paramFloat = width;
    mLabelRotatedWidth = ((int)(localXAxis.getXOffset() * 3.5F + paramFloat));
    mXAxis.mLabelRotatedHeight = Math.round(height);
  }
  
  public void drawLabels(Canvas paramCanvas, float paramFloat, PointF paramPointF)
  {
    float f1 = mXAxis.getLabelRotationAngle();
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    BarData localBarData = (BarData)mChart.getData();
    int j = localBarData.getDataSetCount();
    int i = mMinX;
    while (i <= mMaxX)
    {
      float f2 = i * j;
      float f3 = i;
      float f4 = localBarData.getGroupSpace();
      arrayOfFloat[1] = (localBarData.getGroupSpace() / 2.0F + (f4 * f3 + f2));
      if (j > 1)
      {
        f2 = arrayOfFloat[1];
        arrayOfFloat[1] = ((j - 1.0F) / 2.0F + f2);
      }
      mTrans.pointValuesToPixel(arrayOfFloat);
      if (mViewPortHandler.isInBoundsY(arrayOfFloat[1])) {
        drawLabel(paramCanvas, (String)mXAxis.getValues().get(i), i, paramFloat, arrayOfFloat[1], paramPointF, f1);
      }
      i += mXAxis.mAxisLabelModulus;
    }
  }
  
  public void renderAxisLabels(Canvas paramCanvas)
  {
    if (mXAxis.isEnabled())
    {
      if (!mXAxis.isDrawLabelsEnabled()) {
        return;
      }
      float f = mXAxis.getXOffset();
      mAxisLabelPaint.setTypeface(mXAxis.getTypeface());
      mAxisLabelPaint.setTextSize(mXAxis.getTextSize());
      mAxisLabelPaint.setColor(mXAxis.getTextColor());
      if (mXAxis.getPosition() == XAxis.XAxisPosition.TOP)
      {
        drawLabels(paramCanvas, mViewPortHandler.contentRight() + f, new PointF(0.0F, 0.5F));
        return;
      }
      if (mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE)
      {
        drawLabels(paramCanvas, mViewPortHandler.contentRight() - f, new PointF(1.0F, 0.5F));
        return;
      }
      if (mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM)
      {
        drawLabels(paramCanvas, mViewPortHandler.contentLeft() - f, new PointF(1.0F, 0.5F));
        return;
      }
      if (mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE)
      {
        drawLabels(paramCanvas, mViewPortHandler.contentLeft() + f, new PointF(0.0F, 0.5F));
        return;
      }
      drawLabels(paramCanvas, mViewPortHandler.contentRight() + f, new PointF(0.0F, 0.5F));
      drawLabels(paramCanvas, mViewPortHandler.contentLeft() - f, new PointF(1.0F, 0.5F));
    }
  }
  
  public void renderAxisLine(Canvas paramCanvas)
  {
    if (mXAxis.isDrawAxisLineEnabled())
    {
      if (!mXAxis.isEnabled()) {
        return;
      }
      mAxisLinePaint.setColor(mXAxis.getAxisLineColor());
      mAxisLinePaint.setStrokeWidth(mXAxis.getAxisLineWidth());
      if ((mXAxis.getPosition() == XAxis.XAxisPosition.TOP) || (mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) || (mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED)) {
        paramCanvas.drawLine(mViewPortHandler.contentRight(), mViewPortHandler.contentTop(), mViewPortHandler.contentRight(), mViewPortHandler.contentBottom(), mAxisLinePaint);
      }
      if ((mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) || (mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) || (mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED)) {
        paramCanvas.drawLine(mViewPortHandler.contentLeft(), mViewPortHandler.contentTop(), mViewPortHandler.contentLeft(), mViewPortHandler.contentBottom(), mAxisLinePaint);
      }
    }
  }
  
  public void renderGridLines(Canvas paramCanvas)
  {
    if (mXAxis.isDrawGridLinesEnabled())
    {
      if (!mXAxis.isEnabled()) {
        return;
      }
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      mGridPaint.setColor(mXAxis.getGridColor());
      mGridPaint.setStrokeWidth(mXAxis.getGridLineWidth());
      BarData localBarData = (BarData)mChart.getData();
      int j = localBarData.getDataSetCount();
      int i = mMinX;
      while (i <= mMaxX)
      {
        float f1 = i * j;
        float f2 = i;
        arrayOfFloat[1] = (localBarData.getGroupSpace() * f2 + f1 - 0.5F);
        mTrans.pointValuesToPixel(arrayOfFloat);
        if (mViewPortHandler.isInBoundsY(arrayOfFloat[1])) {
          paramCanvas.drawLine(mViewPortHandler.contentLeft(), arrayOfFloat[1], mViewPortHandler.contentRight(), arrayOfFloat[1], mGridPaint);
        }
        i += mXAxis.mAxisLabelModulus;
      }
    }
  }
  
  public void renderLimitLines(Canvas paramCanvas)
  {
    List localList = mXAxis.getLimitLines();
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      float[] arrayOfFloat = new float[2];
      Path localPath = new Path();
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (LimitLine)localList.get(i);
        if (((ComponentBase)localObject).isEnabled())
        {
          mLimitLinePaint.setStyle(Paint.Style.STROKE);
          mLimitLinePaint.setColor(((LimitLine)localObject).getLineColor());
          mLimitLinePaint.setStrokeWidth(((LimitLine)localObject).getLineWidth());
          mLimitLinePaint.setPathEffect(((LimitLine)localObject).getDashPathEffect());
          arrayOfFloat[1] = ((LimitLine)localObject).getLimit();
          mTrans.pointValuesToPixel(arrayOfFloat);
          localPath.moveTo(mViewPortHandler.contentLeft(), arrayOfFloat[1]);
          localPath.lineTo(mViewPortHandler.contentRight(), arrayOfFloat[1]);
          paramCanvas.drawPath(localPath, mLimitLinePaint);
          localPath.reset();
          String str = ((LimitLine)localObject).getLabel();
          if ((str != null) && (!str.equals("")))
          {
            mLimitLinePaint.setStyle(((LimitLine)localObject).getTextStyle());
            mLimitLinePaint.setPathEffect(null);
            mLimitLinePaint.setColor(((ComponentBase)localObject).getTextColor());
            mLimitLinePaint.setStrokeWidth(0.5F);
            mLimitLinePaint.setTextSize(((ComponentBase)localObject).getTextSize());
            float f1 = Utils.calcTextHeight(mLimitLinePaint, str);
            float f2 = Utils.convertDpToPixel(4.0F);
            f2 = ((ComponentBase)localObject).getXOffset() + f2;
            float f3 = ((LimitLine)localObject).getLineWidth();
            f3 = ((ComponentBase)localObject).getYOffset() + (f3 + f1);
            localObject = ((LimitLine)localObject).getLabelPosition();
            if (localObject == LimitLine.LimitLabelPosition.RIGHT_TOP)
            {
              mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, mViewPortHandler.contentRight() - f2, arrayOfFloat[1] - f3 + f1, mLimitLinePaint);
            }
            else if (localObject == LimitLine.LimitLabelPosition.RIGHT_BOTTOM)
            {
              mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
              paramCanvas.drawText(str, mViewPortHandler.contentRight() - f2, arrayOfFloat[1] + f3, mLimitLinePaint);
            }
            else if (localObject == LimitLine.LimitLabelPosition.LEFT_TOP)
            {
              mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, mViewPortHandler.contentLeft() + f2, arrayOfFloat[1] - f3 + f1, mLimitLinePaint);
            }
            else
            {
              mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
              paramCanvas.drawText(str, mViewPortHandler.offsetLeft() + f2, arrayOfFloat[1] + f3, mLimitLinePaint);
            }
          }
        }
        i += 1;
      }
    }
  }
}
