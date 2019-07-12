package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.LimitLine.LimitLabelPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class XAxisRenderer
  extends AxisRenderer
{
  public Path mLimitLinePath = new Path();
  public float[] mLimitLineSegmentsBuffer = new float[4];
  public XAxis mXAxis;
  
  public XAxisRenderer(ViewPortHandler paramViewPortHandler, XAxis paramXAxis, Transformer paramTransformer)
  {
    super(paramViewPortHandler, paramTransformer);
    mXAxis = paramXAxis;
    mAxisLabelPaint.setColor(-16777216);
    mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
    mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0F));
  }
  
  public void computeAxis(float paramFloat, List paramList)
  {
    mAxisLabelPaint.setTypeface(mXAxis.getTypeface());
    mAxisLabelPaint.setTextSize(mXAxis.getTextSize());
    Object localObject1 = new StringBuilder();
    int k = Math.round(paramFloat);
    int j = 0;
    int i = 0;
    while (i < k)
    {
      ((StringBuilder)localObject1).append('h');
      i += 1;
    }
    paramFloat = calcTextSizemAxisLabelPaint, ((StringBuilder)localObject1).toString()).width;
    float f = Utils.calcTextHeight(mAxisLabelPaint, "Q");
    localObject1 = Utils.getSizeOfRotatedRectangleByDegrees(paramFloat, f, mXAxis.getLabelRotationAngle());
    Object localObject2 = new StringBuilder();
    k = mXAxis.getSpaceBetweenLabels();
    i = j;
    while (i < k)
    {
      ((StringBuilder)localObject2).append('h');
      i += 1;
    }
    localObject2 = Utils.calcTextSize(mAxisLabelPaint, ((StringBuilder)localObject2).toString());
    mXAxis.mLabelWidth = Math.round(paramFloat + width);
    mXAxis.mLabelHeight = Math.round(f);
    mXAxis.mLabelRotatedWidth = Math.round(width + width);
    mXAxis.mLabelRotatedHeight = Math.round(height);
    mXAxis.setValues(paramList);
  }
  
  public void drawLabel(Canvas paramCanvas, String paramString, int paramInt, float paramFloat1, float paramFloat2, PointF paramPointF, float paramFloat3)
  {
    Utils.drawText(paramCanvas, mXAxis.getValueFormatter().getXValue(paramString, paramInt, mViewPortHandler), paramFloat1, paramFloat2, mAxisLabelPaint, paramPointF, paramFloat3);
  }
  
  public void drawLabels(Canvas paramCanvas, float paramFloat, PointF paramPointF)
  {
    float f1 = mXAxis.getLabelRotationAngle();
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    int i = mMinX;
    while (i <= mMaxX)
    {
      arrayOfFloat[0] = i;
      mTrans.pointValuesToPixel(arrayOfFloat);
      if (mViewPortHandler.isInBoundsX(arrayOfFloat[0]))
      {
        String str = (String)mXAxis.getValues().get(i);
        if (mXAxis.isAvoidFirstLastClippingEnabled())
        {
          float f2;
          if ((i == mXAxis.getValues().size() - 1) && (mXAxis.getValues().size() > 1))
          {
            f2 = Utils.calcTextWidth(mAxisLabelPaint, str);
            if ((f2 > mViewPortHandler.offsetRight() * 2.0F) && (arrayOfFloat[0] + f2 > mViewPortHandler.getChartWidth())) {
              arrayOfFloat[0] -= f2 / 2.0F;
            }
          }
          else if (i == 0)
          {
            f2 = Utils.calcTextWidth(mAxisLabelPaint, str);
            float f3 = arrayOfFloat[0];
            arrayOfFloat[0] = (f2 / 2.0F + f3);
          }
        }
        drawLabel(paramCanvas, str, i, arrayOfFloat[0], paramFloat, paramPointF, f1);
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
      float f = mXAxis.getYOffset();
      mAxisLabelPaint.setTypeface(mXAxis.getTypeface());
      mAxisLabelPaint.setTextSize(mXAxis.getTextSize());
      mAxisLabelPaint.setColor(mXAxis.getTextColor());
      if (mXAxis.getPosition() == XAxis.XAxisPosition.TOP)
      {
        drawLabels(paramCanvas, mViewPortHandler.contentTop() - f, new PointF(0.5F, 1.0F));
        return;
      }
      if (mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE)
      {
        drawLabels(paramCanvas, mViewPortHandler.contentTop() + f + mXAxis.mLabelRotatedHeight, new PointF(0.5F, 1.0F));
        return;
      }
      if (mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM)
      {
        drawLabels(paramCanvas, mViewPortHandler.contentBottom() + f, new PointF(0.5F, 0.0F));
        return;
      }
      if (mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE)
      {
        drawLabels(paramCanvas, mViewPortHandler.contentBottom() - f - mXAxis.mLabelRotatedHeight, new PointF(0.5F, 0.0F));
        return;
      }
      drawLabels(paramCanvas, mViewPortHandler.contentTop() - f, new PointF(0.5F, 1.0F));
      drawLabels(paramCanvas, mViewPortHandler.contentBottom() + f, new PointF(0.5F, 0.0F));
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
        paramCanvas.drawLine(mViewPortHandler.contentLeft(), mViewPortHandler.contentTop(), mViewPortHandler.contentRight(), mViewPortHandler.contentTop(), mAxisLinePaint);
      }
      if ((mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) || (mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) || (mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED)) {
        paramCanvas.drawLine(mViewPortHandler.contentLeft(), mViewPortHandler.contentBottom(), mViewPortHandler.contentRight(), mViewPortHandler.contentBottom(), mAxisLinePaint);
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
      Object localObject = mGridPaint;
      XAxis localXAxis = mXAxis;
      XAxisRenderer localXAxisRenderer = this;
      ((Paint)localObject).setPathEffect(localXAxis.getGridDashPathEffect());
      localObject = new Path();
      int i = mMinX;
      while (i <= mMaxX)
      {
        arrayOfFloat[0] = i;
        mTrans.pointValuesToPixel(arrayOfFloat);
        if ((arrayOfFloat[0] >= mViewPortHandler.offsetLeft()) && (arrayOfFloat[0] <= mViewPortHandler.getChartWidth()))
        {
          ((Path)localObject).moveTo(arrayOfFloat[0], mViewPortHandler.contentBottom());
          ((Path)localObject).lineTo(arrayOfFloat[0], mViewPortHandler.contentTop());
          paramCanvas.drawPath((Path)localObject, mGridPaint);
        }
        ((Path)localObject).reset();
        localXAxis = mXAxis;
        i += mAxisLabelModulus;
      }
    }
  }
  
  public void renderLimitLineLabel(Canvas paramCanvas, LimitLine paramLimitLine, float[] paramArrayOfFloat, float paramFloat)
  {
    String str = paramLimitLine.getLabel();
    if ((str != null) && (!str.equals("")))
    {
      mLimitLinePaint.setStyle(paramLimitLine.getTextStyle());
      mLimitLinePaint.setPathEffect(null);
      mLimitLinePaint.setColor(paramLimitLine.getTextColor());
      mLimitLinePaint.setStrokeWidth(0.5F);
      mLimitLinePaint.setTextSize(paramLimitLine.getTextSize());
      float f1 = paramLimitLine.getLineWidth();
      f1 = paramLimitLine.getXOffset() + f1;
      paramLimitLine = paramLimitLine.getLabelPosition();
      float f2;
      if (paramLimitLine == LimitLine.LimitLabelPosition.RIGHT_TOP)
      {
        f2 = Utils.calcTextHeight(mLimitLinePaint, str);
        mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(str, paramArrayOfFloat[0] + f1, mViewPortHandler.contentTop() + paramFloat + f2, mLimitLinePaint);
        return;
      }
      if (paramLimitLine == LimitLine.LimitLabelPosition.RIGHT_BOTTOM)
      {
        mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(str, paramArrayOfFloat[0] + f1, mViewPortHandler.contentBottom() - paramFloat, mLimitLinePaint);
        return;
      }
      if (paramLimitLine == LimitLine.LimitLabelPosition.LEFT_TOP)
      {
        mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
        f2 = Utils.calcTextHeight(mLimitLinePaint, str);
        paramCanvas.drawText(str, paramArrayOfFloat[0] - f1, mViewPortHandler.contentTop() + paramFloat + f2, mLimitLinePaint);
        return;
      }
      mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
      paramCanvas.drawText(str, paramArrayOfFloat[0] - f1, mViewPortHandler.contentBottom() - paramFloat, mLimitLinePaint);
    }
  }
  
  public void renderLimitLineLine(Canvas paramCanvas, LimitLine paramLimitLine, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = mLimitLineSegmentsBuffer;
    arrayOfFloat[0] = paramArrayOfFloat[0];
    arrayOfFloat[1] = mViewPortHandler.contentTop();
    arrayOfFloat = mLimitLineSegmentsBuffer;
    arrayOfFloat[2] = paramArrayOfFloat[0];
    arrayOfFloat[3] = mViewPortHandler.contentBottom();
    mLimitLinePath.reset();
    paramArrayOfFloat = mLimitLinePath;
    arrayOfFloat = mLimitLineSegmentsBuffer;
    paramArrayOfFloat.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    paramArrayOfFloat = mLimitLinePath;
    arrayOfFloat = mLimitLineSegmentsBuffer;
    paramArrayOfFloat.lineTo(arrayOfFloat[2], arrayOfFloat[3]);
    mLimitLinePaint.setStyle(Paint.Style.STROKE);
    mLimitLinePaint.setColor(paramLimitLine.getLineColor());
    mLimitLinePaint.setStrokeWidth(paramLimitLine.getLineWidth());
    mLimitLinePaint.setPathEffect(paramLimitLine.getDashPathEffect());
    paramCanvas.drawPath(mLimitLinePath, mLimitLinePaint);
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
      int i = 0;
      while (i < localList.size())
      {
        LimitLine localLimitLine = (LimitLine)localList.get(i);
        if (localLimitLine.isEnabled())
        {
          arrayOfFloat[0] = localLimitLine.getLimit();
          arrayOfFloat[1] = 0.0F;
          mTrans.pointValuesToPixel(arrayOfFloat);
          renderLimitLineLine(paramCanvas, localLimitLine, arrayOfFloat);
          renderLimitLineLabel(paramCanvas, localLimitLine, arrayOfFloat, localLimitLine.getYOffset() + 2.0F);
        }
        i += 1;
      }
    }
  }
}
