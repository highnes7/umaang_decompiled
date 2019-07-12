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

public class YAxisRenderer
  extends AxisRenderer
{
  public YAxis mYAxis;
  public Paint mZeroLinePaint;
  
  public YAxisRenderer(ViewPortHandler paramViewPortHandler, YAxis paramYAxis, Transformer paramTransformer)
  {
    super(paramViewPortHandler, paramTransformer);
    mYAxis = paramYAxis;
    mAxisLabelPaint.setColor(-16777216);
    mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0F));
    mZeroLinePaint = new Paint(1);
    mZeroLinePaint.setColor(-7829368);
    mZeroLinePaint.setStrokeWidth(1.0F);
    mZeroLinePaint.setStyle(Paint.Style.STROKE);
  }
  
  public void computeAxis(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1;
    float f2 = paramFloat2;
    if (mViewPortHandler.contentWidth() > 10.0F)
    {
      f1 = paramFloat1;
      f2 = paramFloat2;
      if (!mViewPortHandler.isFullyZoomedOutY())
      {
        PointD localPointD1 = mTrans.getValuesByTouchPoint(mViewPortHandler.contentLeft(), mViewPortHandler.contentTop());
        PointD localPointD2 = mTrans.getValuesByTouchPoint(mViewPortHandler.contentLeft(), mViewPortHandler.contentBottom());
        if (!mYAxis.isInverted())
        {
          f1 = (float)y;
          f2 = (float)y;
        }
        else
        {
          f1 = (float)y;
          f2 = (float)y;
        }
      }
    }
    computeAxisValues(f1, f2);
  }
  
  public void computeAxisValues(float paramFloat1, float paramFloat2)
  {
    int j = mYAxis.getLabelCount();
    double d3 = Math.abs(paramFloat2 - paramFloat1);
    if ((j != 0) && (d3 > 0.0D))
    {
      double d1 = j;
      Double.isNaN(d3);
      Double.isNaN(d1);
      double d2 = Utils.roundToNextSignificant(d3 / d1);
      d1 = d2;
      if (mYAxis.isGranularityEnabled())
      {
        d1 = d2;
        if (d2 < mYAxis.getGranularity()) {
          d1 = mYAxis.getGranularity();
        }
      }
      double d4 = Utils.roundToNextSignificant(Math.pow(10.0D, (int)Math.log10(d1)));
      Double.isNaN(d4);
      d2 = d1;
      if ((int)(d1 / d4) > 5)
      {
        Double.isNaN(d4);
        d2 = Math.floor(d4 * 10.0D);
      }
      int i;
      if (mYAxis.isForceLabelsEnabled())
      {
        paramFloat2 = (float)d3 / (j - 1);
        localObject = mYAxis;
        mEntryCount = j;
        if (mEntries.length < j) {
          mEntries = new float[j];
        }
        i = 0;
        while (i < j)
        {
          mYAxis.mEntries[i] = paramFloat1;
          paramFloat1 += paramFloat2;
          i += 1;
        }
      }
      if (mYAxis.isShowOnlyMinMaxEnabled())
      {
        localObject = mYAxis;
        mEntryCount = 2;
        mEntries = new float[2];
        localObject = mEntries;
        localObject[0] = paramFloat1;
        localObject[1] = paramFloat2;
      }
      else
      {
        d1 = paramFloat1;
        Double.isNaN(d1);
        d1 = Math.ceil(d1 / d2) * d2;
        d3 = paramFloat2;
        Double.isNaN(d3);
        d4 = Utils.nextUp(Math.floor(d3 / d2) * d2);
        d3 = d1;
        i = 0;
        while (d3 <= d4)
        {
          i += 1;
          d3 += d2;
        }
        localObject = mYAxis;
        mEntryCount = i;
        if (mEntries.length < i) {
          mEntries = new float[i];
        }
        j = 0;
        while (j < i)
        {
          d3 = d1;
          if (d1 == 0.0D) {
            d3 = 0.0D;
          }
          mYAxis.mEntries[j] = ((float)d3);
          d1 = d3 + d2;
          j += 1;
        }
      }
      if (d2 < 1.0D)
      {
        mYAxis.mDecimals = ((int)Math.ceil(-Math.log10(d2)));
        return;
      }
      mYAxis.mDecimals = 0;
      return;
    }
    Object localObject = mYAxis;
    mEntries = new float[0];
    mEntryCount = 0;
  }
  
  public void drawYLabels(Canvas paramCanvas, float paramFloat1, float[] paramArrayOfFloat, float paramFloat2)
  {
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
      paramCanvas.drawText((String)localObject, paramFloat1, paramArrayOfFloat[(i * 2 + 1)] + paramFloat2, mAxisLabelPaint);
      i += 1;
    }
  }
  
  public void drawZeroLine(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    mZeroLinePaint.setColor(mYAxis.getZeroLineColor());
    mZeroLinePaint.setStrokeWidth(mYAxis.getZeroLineWidth());
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat3);
    localPath.lineTo(paramFloat2, paramFloat4);
    paramCanvas.drawPath(localPath, mZeroLinePaint);
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
        arrayOfFloat[(i + 1)] = mYAxis.mEntries[(i / 2)];
        i += 2;
      }
      mTrans.pointValuesToPixel(arrayOfFloat);
      mAxisLabelPaint.setTypeface(mYAxis.getTypeface());
      mAxisLabelPaint.setTextSize(mYAxis.getTextSize());
      mAxisLabelPaint.setColor(mYAxis.getTextColor());
      float f4 = mYAxis.getXOffset();
      float f2 = Utils.calcTextHeight(mAxisLabelPaint, "A") / 2.5F;
      float f3 = mYAxis.getYOffset();
      YAxis.AxisDependency localAxisDependency = mYAxis.getAxisDependency();
      YAxis.YAxisLabelPosition localYAxisLabelPosition = mYAxis.getLabelPosition();
      if (localAxisDependency == YAxis.AxisDependency.LEFT)
      {
        if (localYAxisLabelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        {
          mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
          f1 = mViewPortHandler.offsetLeft();
          break label285;
        }
        mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
        f1 = mViewPortHandler.offsetLeft();
      }
      else
      {
        if (localYAxisLabelPosition != YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
          break label267;
        }
        mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
        f1 = mViewPortHandler.contentRight();
      }
      f1 += f4;
      break label290;
      label267:
      mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
      float f1 = mViewPortHandler.contentRight();
      label285:
      f1 -= f4;
      label290:
      drawYLabels(paramCanvas, f1, arrayOfFloat, f3 + f2);
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
        paramCanvas.drawLine(mViewPortHandler.contentLeft(), mViewPortHandler.contentTop(), mViewPortHandler.contentLeft(), mViewPortHandler.contentBottom(), mAxisLinePaint);
        return;
      }
      paramCanvas.drawLine(mViewPortHandler.contentRight(), mViewPortHandler.contentTop(), mViewPortHandler.contentRight(), mViewPortHandler.contentBottom(), mAxisLinePaint);
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
      mGridPaint.setPathEffect(mYAxis.getGridDashPathEffect());
      Path localPath = new Path();
      int i = 0;
      for (;;)
      {
        YAxis localYAxis = mYAxis;
        if (i >= mEntryCount) {
          break;
        }
        arrayOfFloat[1] = mEntries[i];
        mTrans.pointValuesToPixel(arrayOfFloat);
        localPath.moveTo(mViewPortHandler.offsetLeft(), arrayOfFloat[1]);
        localPath.lineTo(mViewPortHandler.contentRight(), arrayOfFloat[1]);
        paramCanvas.drawPath(localPath, mGridPaint);
        localPath.reset();
        i += 1;
      }
    }
    if (mYAxis.isDrawZeroLineEnabled())
    {
      arrayOfFloat[1] = 0.0F;
      mTrans.pointValuesToPixel(arrayOfFloat);
      drawZeroLine(paramCanvas, mViewPortHandler.offsetLeft(), mViewPortHandler.contentRight(), arrayOfFloat[1] - 1.0F, arrayOfFloat[1] - 1.0F);
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
            mLimitLinePaint.setTypeface(((ComponentBase)localObject).getTypeface());
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
