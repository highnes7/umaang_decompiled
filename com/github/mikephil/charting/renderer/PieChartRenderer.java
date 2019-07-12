package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class PieChartRenderer
  extends DataRenderer
{
  public Canvas mBitmapCanvas;
  public RectF mCenterTextLastBounds = new RectF();
  public CharSequence mCenterTextLastValue;
  public StaticLayout mCenterTextLayout;
  public TextPaint mCenterTextPaint;
  public PieChart mChart;
  public WeakReference<Bitmap> mDrawBitmap;
  public Path mHoleCirclePath = new Path();
  public Paint mHolePaint;
  public RectF mInnerRectBuffer = new RectF();
  public Path mPathBuffer = new Path();
  public RectF[] mRectBuffer = { new RectF(), new RectF(), new RectF() };
  public Paint mTransparentCirclePaint;
  
  public PieChartRenderer(PieChart paramPieChart, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    mChart = paramPieChart;
    mHolePaint = new Paint(1);
    mHolePaint.setColor(-1);
    mHolePaint.setStyle(Paint.Style.FILL);
    mTransparentCirclePaint = new Paint(1);
    mTransparentCirclePaint.setColor(-1);
    mTransparentCirclePaint.setStyle(Paint.Style.FILL);
    mTransparentCirclePaint.setAlpha(105);
    mCenterTextPaint = new TextPaint(1);
    mCenterTextPaint.setColor(-16777216);
    mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0F));
    mValuePaint.setTextSize(Utils.convertDpToPixel(13.0F));
    mValuePaint.setColor(-1);
    mValuePaint.setTextAlign(Paint.Align.CENTER);
  }
  
  public float calculateMinimumRadiusForSpacedSlice(PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = paramFloat6 / 2.0F;
    float f2 = x;
    double d1 = (paramFloat5 + paramFloat6) * 0.017453292F;
    paramFloat6 = (float)Math.cos(d1) * paramFloat1 + f2;
    f2 = y;
    f2 = (float)Math.sin(d1) * paramFloat1 + f2;
    float f3 = x;
    d1 = (f1 + paramFloat5) * 0.017453292F;
    paramFloat5 = (float)Math.cos(d1);
    f1 = y;
    float f4 = (float)Math.sin(d1);
    d1 = Math.pow(paramFloat6 - paramFloat3, 2.0D);
    d1 = Math.sqrt(Math.pow(f2 - paramFloat4, 2.0D) + d1) / 2.0D;
    double d2 = paramFloat2;
    Double.isNaN(d2);
    d1 = paramFloat1 - (float)(Math.tan((180.0D - d2) / 2.0D * 0.017453292519943295D) * d1);
    d2 = Math.pow(paramFloat5 * paramFloat1 + f3 - (paramFloat6 + paramFloat3) / 2.0F, 2.0D);
    d2 = Math.sqrt(Math.pow(f4 * paramFloat1 + f1 - (f2 + paramFloat4) / 2.0F, 2.0D) + d2);
    Double.isNaN(d1);
    return (float)(d1 - d2);
  }
  
  public void drawCenterText(Canvas paramCanvas)
  {
    Object localObject = mChart.getCenterText();
    if ((mChart.isDrawCenterTextEnabled()) && (localObject != null))
    {
      PointF localPointF = mChart.getCenterCircleBox();
      if ((mChart.isDrawHoleEnabled()) && (!mChart.isDrawSlicesUnderHoleEnabled()))
      {
        f1 = mChart.getRadius();
        f1 = mChart.getHoleRadius() / 100.0F * f1;
      }
      else
      {
        f1 = mChart.getRadius();
      }
      RectF[] arrayOfRectF = mRectBuffer;
      RectF localRectF = arrayOfRectF[0];
      float f2 = x;
      left = (f2 - f1);
      float f3 = y;
      top = (f3 - f1);
      right = (f2 + f1);
      bottom = (f3 + f1);
      localPointF = arrayOfRectF[1];
      localPointF.set(localRectF);
      float f1 = mChart.getCenterTextRadiusPercent() / 100.0F;
      if (f1 > 0.0D) {
        localPointF.inset((localPointF.width() - localPointF.width() * f1) / 2.0F, (localPointF.height() - localPointF.height() * f1) / 2.0F);
      }
      if ((!localObject.equals(mCenterTextLastValue)) || (!localPointF.equals(mCenterTextLastBounds)))
      {
        mCenterTextLastBounds.set(localPointF);
        mCenterTextLastValue = ((CharSequence)localObject);
        f1 = mCenterTextLastBounds.width();
        mCenterTextLayout = new StaticLayout((CharSequence)localObject, 0, ((CharSequence)localObject).length(), mCenterTextPaint, (int)Math.max(Math.ceil(f1), 1.0D), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      }
      f1 = mCenterTextLayout.getHeight();
      paramCanvas.save();
      int i = Build.VERSION.SDK_INT;
      localObject = new Path();
      ((Path)localObject).addOval(localRectF, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject);
      f2 = left;
      f3 = top;
      paramCanvas.translate(f2, (localPointF.height() - f1) / 2.0F + f3);
      mCenterTextLayout.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public void drawData(Canvas paramCanvas)
  {
    int i = (int)mViewPortHandler.getChartWidth();
    int j = (int)mViewPortHandler.getChartHeight();
    Object localObject = mDrawBitmap;
    if ((localObject == null) || (((Bitmap)((WeakReference)localObject).get()).getWidth() != i) || (((Bitmap)mDrawBitmap.get()).getHeight() != j))
    {
      if ((i > 0) && (j > 0))
      {
        mDrawBitmap = new WeakReference(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444));
        mBitmapCanvas = new Canvas((Bitmap)mDrawBitmap.get());
      }
    }
    else
    {
      ((Bitmap)mDrawBitmap.get()).eraseColor(0);
      localObject = ((PieData)mChart.getData()).getDataSets().iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPieDataSet localIPieDataSet = (IPieDataSet)((Iterator)localObject).next();
        if ((localIPieDataSet.isVisible()) && (localIPieDataSet.getEntryCount() > 0)) {
          drawDataSet(paramCanvas, localIPieDataSet);
        }
      }
    }
  }
  
  public void drawDataSet(Canvas paramCanvas, IPieDataSet paramIPieDataSet)
  {
    float f9 = mChart.getRotationAngle();
    float f10 = mAnimator.getPhaseX();
    float f11 = mAnimator.getPhaseY();
    RectF localRectF = mChart.getCircleBox();
    int n = paramIPieDataSet.getEntryCount();
    float[] arrayOfFloat = mChart.getDrawAngles();
    paramCanvas = mChart.getCenterCircleBox();
    float f1 = mChart.getRadius();
    float f2 = f1;
    int i;
    if ((mChart.isDrawHoleEnabled()) && (!mChart.isDrawSlicesUnderHoleEnabled())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      f1 = mChart.getHoleRadius() / 100.0F * f1;
    } else {
      f1 = 0.0F;
    }
    int k = 0;
    int m;
    for (int j = 0; k < n; j = m)
    {
      m = j;
      if (Math.abs(paramIPieDataSet.getEntryForIndex(k).getVal()) > 1.0E-6D) {
        m = j + 1;
      }
      k += 1;
    }
    float f3;
    if (j <= 1) {
      f3 = 0.0F;
    } else {
      f3 = paramIPieDataSet.getSliceSpace();
    }
    k = 0;
    float f4 = 0.0F;
    for (;;)
    {
      Object localObject1 = paramIPieDataSet;
      if (k >= n) {
        break;
      }
      float f12 = arrayOfFloat[k];
      Object localObject2 = ((IDataSet)localObject1).getEntryForIndex(k);
      if ((Math.abs(((Entry)localObject2).getVal()) > 1.0E-6D) && (!mChart.needsHighlight(((Entry)localObject2).getXIndex(), ((PieData)mChart.getData()).getIndexOfDataSet((IDataSet)localObject1))))
      {
        if ((f3 > 0.0F) && (f12 <= 180.0F)) {
          m = 1;
        } else {
          m = 0;
        }
        mRenderPaint.setColor(((IDataSet)localObject1).getColor(k));
        if (j == 1) {
          f5 = 0.0F;
        } else {
          f5 = f3 / (f2 * 0.017453292F);
        }
        float f14 = (f5 / 2.0F + f4) * f11 + f9;
        float f5 = (f12 - f5) * f11;
        float f6 = f5;
        if (f5 < 0.0F) {
          f6 = 0.0F;
        }
        mPathBuffer.reset();
        float f13 = f6 % 360.0F;
        float f8;
        float f7;
        double d;
        if (f13 == 0.0F)
        {
          mPathBuffer.addCircle(x, y, f2, Path.Direction.CW);
          f8 = 0.0F;
          f7 = 0.0F;
        }
        else
        {
          f5 = x;
          d = f14 * 0.017453292F;
          f8 = (float)Math.cos(d) * f2 + f5;
          f5 = y;
          f7 = (float)Math.sin(d) * f2 + f5;
          mPathBuffer.moveTo(f8, f7);
          mPathBuffer.arcTo(localRectF, f14, f6);
        }
        f5 = f2;
        localObject1 = mInnerRectBuffer;
        f2 = x;
        float f15 = y;
        ((RectF)localObject1).set(f2 - f1, f15 - f1, f2 + f1, f15 + f1);
        if ((i != 0) && ((f1 > 0.0F) || (m != 0)))
        {
          if (m != 0)
          {
            f6 = calculateMinimumRadiusForSpacedSlice(paramCanvas, f5, f12 * f11, f8, f7, f14, f6);
            f2 = f6;
            if (f6 < 0.0F) {
              f2 = -f6;
            }
            f2 = Math.max(f1, f2);
          }
          else
          {
            f2 = f1;
          }
          f6 = f2;
          localObject1 = paramCanvas;
          if ((j != 1) && (f6 != 0.0F)) {
            f2 = f3 / (f6 * 0.017453292F);
          } else {
            f2 = 0.0F;
          }
          f8 = f2 / 2.0F;
          f7 = (f12 - f2) * f11;
          f2 = f7;
          if (f7 < 0.0F) {
            f2 = 0.0F;
          }
          f7 = (f8 + f4) * f11 + f9 + f2;
          if (f13 == 0.0F)
          {
            mPathBuffer.addCircle(x, y, f6, Path.Direction.CCW);
          }
          else
          {
            localObject2 = mPathBuffer;
            f8 = x;
            d = f7 * 0.017453292F;
            f13 = (float)Math.cos(d);
            f14 = y;
            ((Path)localObject2).lineTo(f13 * f6 + f8, f6 * (float)Math.sin(d) + f14);
            mPathBuffer.arcTo(mInnerRectBuffer, f7, -f2);
          }
        }
        else if (f13 != 0.0F)
        {
          if (m != 0)
          {
            f2 = f6 / 2.0F;
            f6 = calculateMinimumRadiusForSpacedSlice(paramCanvas, f5, f12 * f11, f8, f7, f14, f6);
            f7 = x;
            d = (f2 + f14) * 0.017453292F;
            f2 = (float)Math.cos(d);
            f8 = y;
            f13 = (float)Math.sin(d);
            mPathBuffer.lineTo(f2 * f6 + f7, f6 * f13 + f8);
          }
          else
          {
            mPathBuffer.lineTo(x, y);
          }
        }
        f2 = f5;
        mPathBuffer.close();
        mBitmapCanvas.drawPath(mPathBuffer, mRenderPaint);
      }
      f4 = f12 * f10 + f4;
      k += 1;
    }
  }
  
  public void drawExtras(Canvas paramCanvas)
  {
    drawHole(paramCanvas);
    paramCanvas.drawBitmap((Bitmap)mDrawBitmap.get(), 0.0F, 0.0F, null);
    drawCenterText(paramCanvas);
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    float f7 = mAnimator.getPhaseX();
    float f8 = mAnimator.getPhaseY();
    float f9 = mChart.getRotationAngle();
    float[] arrayOfFloat1 = mChart.getDrawAngles();
    float[] arrayOfFloat2 = mChart.getAbsoluteAngles();
    PointF localPointF = mChart.getCenterCircleBox();
    float f10 = mChart.getRadius();
    int i;
    if ((mChart.isDrawHoleEnabled()) && (!mChart.isDrawSlicesUnderHoleEnabled())) {
      i = 1;
    } else {
      i = 0;
    }
    float f1;
    if (i != 0) {
      f1 = mChart.getHoleRadius() / 100.0F * f10;
    } else {
      f1 = 0.0F;
    }
    RectF localRectF = new RectF();
    int j = 0;
    for (;;)
    {
      paramCanvas = paramArrayOfHighlight;
      if (j >= paramCanvas.length) {
        break;
      }
      int i1 = paramCanvas[j].getXIndex();
      if (i1 < arrayOfFloat1.length)
      {
        paramCanvas = ((PieData)mChart.getData()).getDataSetByIndex(paramCanvas[j].getDataSetIndex());
        if ((paramCanvas != null) && (paramCanvas.isHighlightEnabled()))
        {
          int i2 = paramCanvas.getEntryCount();
          int m = 0;
          int n;
          for (int k = 0; m < i2; k = n)
          {
            n = k;
            if (Math.abs(paramCanvas.getEntryForIndex(m).getVal()) > 1.0E-6D) {
              n = k + 1;
            }
            m += 1;
          }
          float f3;
          if (i1 == 0) {
            f3 = 0.0F;
          } else {
            f3 = arrayOfFloat2[(i1 - 1)] * f7;
          }
          float f4;
          if (k <= 1) {
            f4 = 0.0F;
          } else {
            f4 = paramCanvas.getSliceSpace();
          }
          float f11 = arrayOfFloat1[i1];
          float f2 = paramCanvas.getSelectionShift();
          float f13 = f10 + f2;
          localRectF.set(mChart.getCircleBox());
          f2 = -f2;
          localRectF.inset(f2, f2);
          if ((f4 > 0.0F) && (f11 <= 180.0F)) {
            m = 1;
          } else {
            m = 0;
          }
          mRenderPaint.setColor(paramCanvas.getColor(i1));
          if (k == 1) {
            f5 = 0.0F;
          } else {
            f5 = f4 / (f10 * 0.017453292F);
          }
          if (k == 1) {
            f2 = 0.0F;
          } else {
            f2 = f4 / (f13 * 0.017453292F);
          }
          float f12 = (f5 / 2.0F + f3) * f8 + f9;
          float f6 = (f11 - f5) * f8;
          float f5 = f6;
          if (f6 < 0.0F) {
            f5 = 0.0F;
          }
          float f14 = (f2 / 2.0F + f3) * f8 + f9;
          f6 = (f11 - f2) * f8;
          f2 = f6;
          if (f6 < 0.0F) {
            f2 = 0.0F;
          }
          mPathBuffer.reset();
          f6 = f5 % 360.0F;
          double d;
          if (f6 == 0.0F)
          {
            mPathBuffer.addCircle(x, y, f13, Path.Direction.CW);
          }
          else
          {
            paramCanvas = mPathBuffer;
            float f15 = x;
            d = f14 * 0.017453292F;
            float f16 = (float)Math.cos(d);
            float f17 = y;
            paramCanvas.moveTo(f16 * f13 + f15, f13 * (float)Math.sin(d) + f17);
            mPathBuffer.arcTo(localRectF, f14, f2);
          }
          if (m != 0)
          {
            f2 = x;
            d = f12 * 0.017453292F;
            f13 = (float)Math.cos(d);
            f14 = y;
            f2 = calculateMinimumRadiusForSpacedSlice(localPointF, f10, f11 * f8, f13 * f10 + f2, (float)Math.sin(d) * f10 + f14, f12, f5);
          }
          else
          {
            f2 = 0.0F;
          }
          paramCanvas = mInnerRectBuffer;
          f13 = x;
          f14 = y;
          paramCanvas.set(f13 - f1, f14 - f1, f13 + f1, f14 + f1);
          if ((i != 0) && ((f1 > 0.0F) || (m != 0)))
          {
            if (m != 0)
            {
              f5 = f2;
              if (f2 < 0.0F) {
                f5 = -f2;
              }
              f2 = Math.max(f1, f5);
            }
            else
            {
              f2 = f1;
            }
            if ((k != 1) && (f2 != 0.0F)) {
              f4 /= f2 * 0.017453292F;
            } else {
              f4 = 0.0F;
            }
            f12 = f4 / 2.0F;
            f5 = (f11 - f4) * f8;
            f4 = f5;
            if (f5 < 0.0F) {
              f4 = 0.0F;
            }
            f3 = (f12 + f3) * f8 + f9 + f4;
            if (f6 == 0.0F)
            {
              mPathBuffer.addCircle(x, y, f2, Path.Direction.CCW);
            }
            else
            {
              paramCanvas = mPathBuffer;
              f5 = x;
              d = f3 * 0.017453292F;
              f6 = (float)Math.cos(d);
              f11 = y;
              paramCanvas.lineTo(f6 * f2 + f5, f2 * (float)Math.sin(d) + f11);
              mPathBuffer.arcTo(mInnerRectBuffer, f3, -f4);
            }
          }
          else if (f6 != 0.0F)
          {
            if (m != 0)
            {
              f4 = f5 / 2.0F;
              f3 = x;
              d = (f4 + f12) * 0.017453292F;
              f4 = (float)Math.cos(d);
              f5 = y;
              f6 = (float)Math.sin(d);
              mPathBuffer.lineTo(f4 * f2 + f3, f2 * f6 + f5);
            }
            else
            {
              mPathBuffer.lineTo(x, y);
            }
          }
          mPathBuffer.close();
          mBitmapCanvas.drawPath(mPathBuffer, mRenderPaint);
        }
      }
      j += 1;
    }
  }
  
  public void drawHole(Canvas paramCanvas)
  {
    if (mChart.isDrawHoleEnabled())
    {
      float f1 = mChart.getRadius();
      float f2 = mChart.getHoleRadius() / 100.0F * f1;
      paramCanvas = mChart.getCenterCircleBox();
      if (Color.alpha(mHolePaint.getColor()) > 0) {
        mBitmapCanvas.drawCircle(x, y, f2, mHolePaint);
      }
      if ((Color.alpha(mTransparentCirclePaint.getColor()) > 0) && (mChart.getTransparentCircleRadius() > mChart.getHoleRadius()))
      {
        int i = mTransparentCirclePaint.getAlpha();
        float f3 = mChart.getTransparentCircleRadius() / 100.0F;
        Paint localPaint = mTransparentCirclePaint;
        float f4 = i;
        float f5 = mAnimator.getPhaseX();
        localPaint.setAlpha((int)(mAnimator.getPhaseY() * (f5 * f4)));
        mHoleCirclePath.reset();
        mHoleCirclePath.addCircle(x, y, f3 * f1, Path.Direction.CW);
        mHoleCirclePath.addCircle(x, y, f2, Path.Direction.CCW);
        mBitmapCanvas.drawPath(mHoleCirclePath, mTransparentCirclePaint);
        mTransparentCirclePaint.setAlpha(i);
      }
    }
  }
  
  public void drawRoundedSlices(Canvas paramCanvas)
  {
    if (!mChart.isDrawRoundedSlicesEnabled()) {
      return;
    }
    paramCanvas = ((PieData)mChart.getData()).getDataSet();
    if (!paramCanvas.isVisible()) {
      return;
    }
    float f2 = mAnimator.getPhaseX();
    float f3 = mAnimator.getPhaseY();
    PointF localPointF = mChart.getCenterCircleBox();
    float f4 = mChart.getRadius();
    float f5 = (f4 - mChart.getHoleRadius() * f4 / 100.0F) / 2.0F;
    float[] arrayOfFloat = mChart.getDrawAngles();
    float f1 = mChart.getRotationAngle();
    int i = 0;
    while (i < paramCanvas.getEntryCount())
    {
      float f6 = arrayOfFloat[i];
      if (Math.abs(paramCanvas.getEntryForIndex(i).getVal()) > 1.0E-6D)
      {
        double d1 = f4 - f5;
        double d2 = (f1 + f6) * f3;
        double d3 = Math.cos(Math.toRadians(d2));
        Double.isNaN(d1);
        double d4 = x;
        Double.isNaN(d4);
        float f7 = (float)(d4 + d3 * d1);
        d2 = Math.sin(Math.toRadians(d2));
        Double.isNaN(d1);
        d3 = y;
        Double.isNaN(d3);
        float f8 = (float)(d2 * d1 + d3);
        mRenderPaint.setColor(paramCanvas.getColor(i));
        mBitmapCanvas.drawCircle(f7, f8, f5, mRenderPaint);
      }
      f1 = f6 * f2 + f1;
      i += 1;
    }
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    PointF localPointF = mChart.getCenterCircleBox();
    float f2 = mChart.getRadius();
    float f3 = mChart.getRotationAngle();
    float[] arrayOfFloat1 = mChart.getDrawAngles();
    float[] arrayOfFloat2 = mChart.getAbsoluteAngles();
    float f4 = mAnimator.getPhaseX();
    mAnimator.getPhaseY();
    float f1 = f2 / 10.0F * 3.6F;
    if (mChart.isDrawHoleEnabled())
    {
      f1 = f2 / 100.0F;
      f1 = (f2 - mChart.getHoleRadius() * f1) / 2.0F;
    }
    f1 = f2 - f1;
    PieData localPieData = (PieData)mChart.getData();
    List localList = localPieData.getDataSets();
    float f5 = localPieData.getYValueSum();
    boolean bool1 = mChart.isDrawSliceTextEnabled();
    int j = 0;
    int k = 0;
    while (k < localList.size())
    {
      IPieDataSet localIPieDataSet = (IPieDataSet)localList.get(k);
      if ((localIPieDataSet.isDrawValuesEnabled()) || (bool1))
      {
        applyValueTextStyle(localIPieDataSet);
        f2 = Utils.calcTextHeight(mValuePaint, "Q");
        float f6 = Utils.convertDpToPixel(4.0F) + f2;
        int i = localIPieDataSet.getEntryCount();
        int m = Math.min((int)Math.ceil(i * f4), i);
        i = 0;
        while (i < m)
        {
          Entry localEntry = localIPieDataSet.getEntryForIndex(i);
          if (j == 0) {
            f2 = 0.0F;
          } else {
            f2 = arrayOfFloat2[(j - 1)] * f4;
          }
          float f7 = (arrayOfFloat1[j] - localIPieDataSet.getSliceSpace() / (0.017453292F * f1) / 2.0F) / 2.0F;
          double d1 = f1;
          double d2 = f7 + f2 + f3;
          double d3 = Math.cos(Math.toRadians(d2));
          Double.isNaN(d1);
          double d4 = x;
          Double.isNaN(d4);
          f7 = (float)(d3 * d1 + d4);
          d2 = Math.sin(Math.toRadians(d2));
          Double.isNaN(d1);
          d3 = y;
          Double.isNaN(d3);
          float f8 = (float)(d2 * d1 + d3);
          if (mChart.isUsePercentValuesEnabled()) {
            f2 = localEntry.getVal() / f5 * 100.0F;
          } else {
            f2 = localEntry.getVal();
          }
          ValueFormatter localValueFormatter = localIPieDataSet.getValueFormatter();
          boolean bool2 = localIPieDataSet.isDrawValuesEnabled();
          if ((bool1) && (bool2))
          {
            drawValue(paramCanvas, localValueFormatter, f2, localEntry, 0, f7, f8, localIPieDataSet.getValueTextColor(i));
            if (i < localPieData.getXValCount()) {
              paramCanvas.drawText((String)localPieData.getXVals().get(i), f7, f8 + f6, mValuePaint);
            }
          }
          else
          {
            if (!bool1) {
              break label617;
            }
            if (i < localPieData.getXValCount())
            {
              mValuePaint.setColor(localIPieDataSet.getValueTextColor(i));
              paramCanvas.drawText((String)localPieData.getXVals().get(i), f7, f6 / 2.0F + f8, mValuePaint);
              break label655;
            }
          }
          break label655;
          label617:
          if (bool2) {
            drawValue(paramCanvas, localValueFormatter, f2, localEntry, 0, f7, f8 + f6 / 2.0F, localIPieDataSet.getValueTextColor(i));
          }
          label655:
          j += 1;
          i += 1;
        }
      }
      k += 1;
    }
  }
  
  public TextPaint getPaintCenterText()
  {
    return mCenterTextPaint;
  }
  
  public Paint getPaintHole()
  {
    return mHolePaint;
  }
  
  public Paint getPaintTransparentCircle()
  {
    return mTransparentCirclePaint;
  }
  
  public void initBuffers() {}
  
  public void releaseBitmap()
  {
    WeakReference localWeakReference = mDrawBitmap;
    if (localWeakReference != null)
    {
      ((Bitmap)localWeakReference.get()).recycle();
      mDrawBitmap.clear();
      mDrawBitmap = null;
    }
  }
}
