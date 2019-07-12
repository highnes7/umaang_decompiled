package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet.Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.FillFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class LineChartRenderer
  extends LineRadarRenderer
{
  public Path cubicFillPath = new Path();
  public Path cubicPath = new Path();
  public Canvas mBitmapCanvas;
  public Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
  public LineDataProvider mChart;
  public Paint mCirclePaintInner;
  public WeakReference<Bitmap> mDrawBitmap;
  public float[] mLineBuffer = new float[4];
  
  public LineChartRenderer(LineDataProvider paramLineDataProvider, ChartAnimator paramChartAnimator, ViewPortHandler paramViewPortHandler)
  {
    super(paramChartAnimator, paramViewPortHandler);
    mChart = paramLineDataProvider;
    mCirclePaintInner = new Paint(1);
    mCirclePaintInner.setStyle(Paint.Style.FILL);
    mCirclePaintInner.setColor(-1);
  }
  
  private Path generateFilledPath(ILineDataSet paramILineDataSet, int paramInt1, int paramInt2)
  {
    float f1 = paramILineDataSet.getFillFormatter().getFillLinePosition(paramILineDataSet, mChart);
    float f2 = mAnimator.getPhaseX();
    float f3 = mAnimator.getPhaseY();
    boolean bool = paramILineDataSet.isDrawSteppedEnabled();
    Path localPath = new Path();
    Entry localEntry1 = paramILineDataSet.getEntryForIndex(paramInt1);
    localPath.moveTo(localEntry1.getXIndex(), f1);
    localPath.lineTo(localEntry1.getXIndex(), localEntry1.getVal() * f3);
    int i = paramInt1 + 1;
    double d = (paramInt2 - paramInt1) * f2 + paramInt1;
    paramInt2 = (int)Math.ceil(d);
    paramInt1 = i;
    while (paramInt1 < paramInt2)
    {
      localEntry1 = paramILineDataSet.getEntryForIndex(paramInt1);
      if (bool)
      {
        Entry localEntry2 = paramILineDataSet.getEntryForIndex(paramInt1 - 1);
        if (localEntry2 != null) {
          localPath.lineTo(localEntry1.getXIndex(), localEntry2.getVal() * f3);
        }
      }
      else
      {
        localPath.lineTo(localEntry1.getXIndex(), localEntry1.getVal() * f3);
      }
      paramInt1 += 1;
    }
    localPath.lineTo(paramILineDataSet.getEntryForIndex(Math.max(Math.min((int)Math.ceil(d) - 1, paramILineDataSet.getEntryCount() - 1), 0)).getXIndex(), f1);
    localPath.close();
    return localPath;
  }
  
  public void drawCircles(Canvas paramCanvas)
  {
    mRenderPaint.setStyle(Paint.Style.FILL);
    float f1 = mAnimator.getPhaseX();
    float f2 = mAnimator.getPhaseY();
    float[] arrayOfFloat = new float[2];
    List localList = mChart.getLineData().getDataSets();
    int i = 0;
    while (i < localList.size())
    {
      ILineDataSet localILineDataSet = (ILineDataSet)localList.get(i);
      if ((localILineDataSet.isVisible()) && (localILineDataSet.isDrawCirclesEnabled()) && (localILineDataSet.getEntryCount() != 0))
      {
        mCirclePaintInner.setColor(localILineDataSet.getCircleHoleColor());
        Transformer localTransformer = mChart.getTransformer(localILineDataSet.getAxisDependency());
        int m = localILineDataSet.getEntryCount();
        int k = mMinX;
        int j = k;
        if (k < 0) {
          j = 0;
        }
        Entry localEntry1 = localILineDataSet.getEntryForXIndex(j, DataSet.Rounding.DOWN);
        Entry localEntry2 = localILineDataSet.getEntryForXIndex(mMaxX, DataSet.Rounding.UP);
        if (localEntry1 == localEntry2) {
          j = 1;
        } else {
          j = 0;
        }
        k = Math.max(localILineDataSet.getEntryIndex(localEntry1) - j, 0);
        j = k;
        m = Math.min(Math.max(k + 2, localILineDataSet.getEntryIndex(localEntry2) + 1), m);
        float f3 = localILineDataSet.getCircleRadius() / 2.0F;
        k = (int)Math.ceil((m - k) * f1 + k);
        while (j < k)
        {
          localEntry1 = localILineDataSet.getEntryForIndex(j);
          if (localEntry1 == null) {
            break;
          }
          arrayOfFloat[0] = localEntry1.getXIndex();
          arrayOfFloat[1] = (localEntry1.getVal() * f2);
          localTransformer.pointValuesToPixel(arrayOfFloat);
          if (!mViewPortHandler.isInBoundsRight(arrayOfFloat[0])) {
            break;
          }
          if ((mViewPortHandler.isInBoundsLeft(arrayOfFloat[0])) && (mViewPortHandler.isInBoundsY(arrayOfFloat[1])))
          {
            m = localILineDataSet.getCircleColor(j);
            mRenderPaint.setColor(m);
            paramCanvas.drawCircle(arrayOfFloat[0], arrayOfFloat[1], localILineDataSet.getCircleRadius(), mRenderPaint);
            if ((localILineDataSet.isDrawCircleHoleEnabled()) && (m != mCirclePaintInner.getColor())) {
              paramCanvas.drawCircle(arrayOfFloat[0], arrayOfFloat[1], f3, mCirclePaintInner);
            } else {}
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public void drawCubic(Canvas paramCanvas, ILineDataSet paramILineDataSet)
  {
    paramCanvas = mChart.getTransformer(paramILineDataSet.getAxisDependency());
    int k = paramILineDataSet.getEntryCount();
    int j = mMinX;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Entry localEntry1 = paramILineDataSet.getEntryForXIndex(i, DataSet.Rounding.DOWN);
    Entry localEntry2 = paramILineDataSet.getEntryForXIndex(mMaxX, DataSet.Rounding.UP);
    if (localEntry1 == localEntry2) {
      i = 1;
    } else {
      i = 0;
    }
    int m = Math.max(paramILineDataSet.getEntryIndex(localEntry1) - i, 0);
    i = Math.min(Math.max(m + 2, paramILineDataSet.getEntryIndex(localEntry2) + 1), k);
    float f3 = mAnimator.getPhaseX();
    float f1 = mAnimator.getPhaseY();
    float f2 = paramILineDataSet.getCubicIntensity();
    cubicPath.reset();
    int n = (int)Math.ceil((i - m) * f3 + m);
    if (n - m >= 2)
    {
      localEntry1 = paramILineDataSet.getEntryForIndex(m);
      i = m + 1;
      paramILineDataSet.getEntryForIndex(i);
      cubicPath.moveTo(localEntry1.getXIndex(), localEntry1.getVal() * f1);
      int i1 = k - 1;
      int i2 = Math.min(n, i1);
      Entry localEntry3;
      float f4;
      float f5;
      float f6;
      float f7;
      float f8;
      while (i < i2)
      {
        if (i == 1) {
          j = 0;
        } else {
          j = i - 2;
        }
        localEntry1 = paramILineDataSet.getEntryForIndex(j);
        localEntry2 = paramILineDataSet.getEntryForIndex(i - 1);
        localEntry3 = paramILineDataSet.getEntryForIndex(i);
        i += 1;
        Entry localEntry4 = paramILineDataSet.getEntryForIndex(i);
        f3 = localEntry3.getXIndex() - localEntry1.getXIndex();
        f4 = localEntry3.getVal();
        f5 = localEntry1.getVal();
        f6 = localEntry4.getXIndex() - localEntry2.getXIndex();
        f7 = localEntry4.getVal();
        f8 = localEntry2.getVal();
        cubicPath.cubicTo(localEntry2.getXIndex() + f3 * f2, (localEntry2.getVal() + (f4 - f5) * f2) * f1, localEntry3.getXIndex() - f6 * f2, (localEntry3.getVal() - (f7 - f8) * f2) * f1, localEntry3.getXIndex(), localEntry3.getVal() * f1);
      }
      if (n > i1)
      {
        if (k >= 3) {
          i = k - 3;
        } else {
          i = k - 2;
        }
        localEntry1 = paramILineDataSet.getEntryForIndex(i);
        localEntry2 = paramILineDataSet.getEntryForIndex(k - 2);
        localEntry3 = paramILineDataSet.getEntryForIndex(i1);
        f3 = localEntry3.getXIndex() - localEntry1.getXIndex();
        f4 = localEntry3.getVal();
        f5 = localEntry1.getVal();
        f6 = localEntry3.getXIndex() - localEntry2.getXIndex();
        f7 = localEntry3.getVal();
        f8 = localEntry2.getVal();
        cubicPath.cubicTo(localEntry2.getXIndex() + f3 * f2, (localEntry2.getVal() + (f4 - f5) * f2) * f1, localEntry3.getXIndex() - f6 * f2, (localEntry3.getVal() - (f7 - f8) * f2) * f1, localEntry3.getXIndex(), localEntry3.getVal() * f1);
      }
    }
    if (paramILineDataSet.isDrawFilledEnabled())
    {
      cubicFillPath.reset();
      cubicFillPath.addPath(cubicPath);
      drawCubicFill(mBitmapCanvas, paramILineDataSet, cubicFillPath, paramCanvas, m, n);
    }
    mRenderPaint.setColor(paramILineDataSet.getColor());
    mRenderPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.pathValueToPixel(cubicPath);
    mBitmapCanvas.drawPath(cubicPath, mRenderPaint);
    mRenderPaint.setPathEffect(null);
  }
  
  public void drawCubicFill(Canvas paramCanvas, ILineDataSet paramILineDataSet, Path paramPath, Transformer paramTransformer, int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 <= 1) {
      return;
    }
    float f3 = paramILineDataSet.getFillFormatter().getFillLinePosition(paramILineDataSet, mChart);
    Entry localEntry1 = paramILineDataSet.getEntryForIndex(paramInt2 - 1);
    Entry localEntry2 = paramILineDataSet.getEntryForIndex(paramInt1);
    float f2 = 0.0F;
    float f1;
    if (localEntry1 == null) {
      f1 = 0.0F;
    } else {
      f1 = localEntry1.getXIndex();
    }
    if (localEntry2 != null) {
      f2 = localEntry2.getXIndex();
    }
    paramPath.lineTo(f1, f3);
    paramPath.lineTo(f2, f3);
    paramPath.close();
    paramTransformer.pathValueToPixel(paramPath);
    paramTransformer = paramILineDataSet.getFillDrawable();
    if (paramTransformer != null)
    {
      drawFilledPath(paramCanvas, paramPath, paramTransformer);
      return;
    }
    drawFilledPath(paramCanvas, paramPath, paramILineDataSet.getFillColor(), paramILineDataSet.getFillAlpha());
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
        mDrawBitmap = new WeakReference(Bitmap.createBitmap(i, j, mBitmapConfig));
        mBitmapCanvas = new Canvas((Bitmap)mDrawBitmap.get());
      }
    }
    else
    {
      ((Bitmap)mDrawBitmap.get()).eraseColor(0);
      localObject = mChart.getLineData().getDataSets().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ILineDataSet localILineDataSet = (ILineDataSet)((Iterator)localObject).next();
        if ((localILineDataSet.isVisible()) && (localILineDataSet.getEntryCount() > 0)) {
          drawDataSet(paramCanvas, localILineDataSet);
        }
      }
      paramCanvas.drawBitmap((Bitmap)mDrawBitmap.get(), 0.0F, 0.0F, mRenderPaint);
    }
  }
  
  public void drawDataSet(Canvas paramCanvas, ILineDataSet paramILineDataSet)
  {
    if (paramILineDataSet.getEntryCount() < 1) {
      return;
    }
    mRenderPaint.setStrokeWidth(paramILineDataSet.getLineWidth());
    mRenderPaint.setPathEffect(paramILineDataSet.getDashPathEffect());
    if (paramILineDataSet.isDrawCubicEnabled()) {
      drawCubic(paramCanvas, paramILineDataSet);
    } else {
      drawLinear(paramCanvas, paramILineDataSet);
    }
    mRenderPaint.setPathEffect(null);
  }
  
  public void drawExtras(Canvas paramCanvas)
  {
    drawCircles(paramCanvas);
  }
  
  public void drawHighlighted(Canvas paramCanvas, Highlight[] paramArrayOfHighlight)
  {
    int i = 0;
    while (i < paramArrayOfHighlight.length)
    {
      ILineDataSet localILineDataSet = (ILineDataSet)mChart.getLineData().getDataSetByIndex(paramArrayOfHighlight[i].getDataSetIndex());
      if ((localILineDataSet != null) && (localILineDataSet.isHighlightEnabled()))
      {
        int j = paramArrayOfHighlight[i].getXIndex();
        float f1 = j;
        float f2 = mChart.getXChartMax();
        if (f1 <= mAnimator.getPhaseX() * f2)
        {
          f2 = localILineDataSet.getYValForXIndex(j);
          if (f2 != NaN.0F)
          {
            float f3 = mAnimator.getPhaseY();
            float[] arrayOfFloat = new float[2];
            arrayOfFloat[0] = f1;
            arrayOfFloat[1] = (f3 * f2);
            mChart.getTransformer(localILineDataSet.getAxisDependency()).pointValuesToPixel(arrayOfFloat);
            drawHighlightLines(paramCanvas, arrayOfFloat, localILineDataSet);
          }
        }
      }
      i += 1;
    }
  }
  
  public void drawLinear(Canvas paramCanvas, ILineDataSet paramILineDataSet)
  {
    int i1 = paramILineDataSet.getEntryCount();
    boolean bool2 = paramILineDataSet.isDrawSteppedEnabled();
    boolean bool1 = bool2;
    int j;
    if (bool2) {
      j = 4;
    } else {
      j = 2;
    }
    Transformer localTransformer = mChart.getTransformer(paramILineDataSet.getAxisDependency());
    float f1 = mAnimator.getPhaseX();
    float f2 = mAnimator.getPhaseY();
    mRenderPaint.setStyle(Paint.Style.STROKE);
    Canvas localCanvas;
    if (paramILineDataSet.isDashedLineEnabled()) {
      localCanvas = mBitmapCanvas;
    } else {
      localCanvas = paramCanvas;
    }
    int k = mMinX;
    int i = k;
    if (k < 0) {
      i = 0;
    }
    Object localObject1 = paramILineDataSet.getEntryForXIndex(i, DataSet.Rounding.DOWN);
    Object localObject2 = paramILineDataSet.getEntryForXIndex(mMaxX, DataSet.Rounding.UP);
    if (localObject1 == localObject2) {
      i = 1;
    } else {
      i = 0;
    }
    k = Math.max(paramILineDataSet.getEntryIndex((Entry)localObject1) - i, 0);
    int i2 = Math.min(Math.max(k + 2, paramILineDataSet.getEntryIndex((Entry)localObject2) + 1), i1);
    int i3 = (int)Math.ceil((i2 - k) * f1 + k);
    if (paramILineDataSet.getColors().size() > 1)
    {
      i = mLineBuffer.length;
      j *= 2;
      if (i != j) {
        mLineBuffer = new float[j];
      }
      i = k;
      while ((i < i3) && ((i3 <= 1) || (i != i3 - 1)))
      {
        localObject1 = paramILineDataSet.getEntryForIndex(i);
        if (localObject1 != null)
        {
          mLineBuffer[0] = ((Entry)localObject1).getXIndex();
          mLineBuffer[1] = (((Entry)localObject1).getVal() * f2);
          m = i + 1;
          if (m < i3)
          {
            localObject1 = paramILineDataSet.getEntryForIndex(m);
            if (localObject1 == null) {
              break;
            }
            if (bool2)
            {
              mLineBuffer[2] = ((Entry)localObject1).getXIndex();
              localObject2 = mLineBuffer;
              localObject2[3] = localObject2[1];
              localObject2[4] = localObject2[2];
              localObject2[5] = localObject2[3];
              localObject2[6] = ((Entry)localObject1).getXIndex();
              mLineBuffer[7] = (((Entry)localObject1).getVal() * f2);
            }
            else
            {
              mLineBuffer[2] = ((Entry)localObject1).getXIndex();
              mLineBuffer[3] = (((Entry)localObject1).getVal() * f2);
            }
          }
          else
          {
            localObject1 = mLineBuffer;
            localObject1[2] = localObject1[0];
            localObject1[3] = localObject1[1];
          }
          localTransformer.pointValuesToPixel(mLineBuffer);
          if (!mViewPortHandler.isInBoundsRight(mLineBuffer[0])) {
            break;
          }
          if ((mViewPortHandler.isInBoundsLeft(mLineBuffer[2])) && ((mViewPortHandler.isInBoundsTop(mLineBuffer[1])) || (mViewPortHandler.isInBoundsBottom(mLineBuffer[3]))) && ((mViewPortHandler.isInBoundsTop(mLineBuffer[1])) || (mViewPortHandler.isInBoundsBottom(mLineBuffer[3]))))
          {
            mRenderPaint.setColor(paramILineDataSet.getColor(i));
            localCanvas.drawLines(mLineBuffer, 0, j, mRenderPaint);
          }
        }
        i += 1;
      }
    }
    i = mLineBuffer.length;
    int m = (i1 - 1) * j;
    if (i != Math.max(m, j) * 2) {
      mLineBuffer = new float[Math.max(m, j) * 2];
    }
    if (paramILineDataSet.getEntryForIndex(k) != null)
    {
      if (i3 > 1) {
        i = k + 1;
      } else {
        i = k;
      }
      m = 0;
      while (i < i3)
      {
        int n;
        if (i == 0) {
          n = 0;
        } else {
          n = i - 1;
        }
        localObject2 = paramILineDataSet.getEntryForIndex(n);
        localObject1 = paramILineDataSet.getEntryForIndex(i);
        if ((localObject2 != null) && (localObject1 != null))
        {
          float[] arrayOfFloat = mLineBuffer;
          n = m + 1;
          arrayOfFloat[m] = ((Entry)localObject2).getXIndex();
          arrayOfFloat = mLineBuffer;
          m = n + 1;
          arrayOfFloat[n] = (((Entry)localObject2).getVal() * f2);
          if (bool1)
          {
            arrayOfFloat = mLineBuffer;
            n = m + 1;
            arrayOfFloat[m] = ((Entry)localObject1).getXIndex();
            arrayOfFloat = mLineBuffer;
            m = n + 1;
            arrayOfFloat[n] = (((Entry)localObject2).getVal() * f2);
            arrayOfFloat = mLineBuffer;
            n = m + 1;
            arrayOfFloat[m] = ((Entry)localObject1).getXIndex();
            arrayOfFloat = mLineBuffer;
            m = n + 1;
            arrayOfFloat[n] = (((Entry)localObject2).getVal() * f2);
          }
          localObject2 = mLineBuffer;
          n = m + 1;
          localObject2[m] = ((Entry)localObject1).getXIndex();
          mLineBuffer[n] = (((Entry)localObject1).getVal() * f2);
          m = n + 1;
        }
        i += 1;
      }
      localTransformer.pointValuesToPixel(mLineBuffer);
      i = Math.max((i3 - k - 1) * j, j);
      mRenderPaint.setColor(paramILineDataSet.getColor());
      localCanvas.drawLines(mLineBuffer, 0, i * 2, mRenderPaint);
    }
    mRenderPaint.setPathEffect(null);
    if ((paramILineDataSet.isDrawFilledEnabled()) && (i1 > 0)) {
      drawLinearFill(paramCanvas, paramILineDataSet, k, i2, localTransformer);
    }
  }
  
  public void drawLinearFill(Canvas paramCanvas, ILineDataSet paramILineDataSet, int paramInt1, int paramInt2, Transformer paramTransformer)
  {
    Path localPath = generateFilledPath(paramILineDataSet, paramInt1, paramInt2);
    paramTransformer.pathValueToPixel(localPath);
    paramTransformer = paramILineDataSet.getFillDrawable();
    if (paramTransformer != null)
    {
      drawFilledPath(paramCanvas, localPath, paramTransformer);
      return;
    }
    drawFilledPath(paramCanvas, localPath, paramILineDataSet.getFillColor(), paramILineDataSet.getFillAlpha());
  }
  
  public void drawValues(Canvas paramCanvas)
  {
    float f1 = mChart.getLineData().getYValCount();
    float f2 = mChart.getMaxVisibleCount();
    if (f1 < mViewPortHandler.getScaleX() * f2)
    {
      List localList = mChart.getLineData().getDataSets();
      int i = 0;
      while (i < localList.size())
      {
        ILineDataSet localILineDataSet = (ILineDataSet)localList.get(i);
        if ((localILineDataSet.isDrawValuesEnabled()) && (localILineDataSet.getEntryCount() != 0))
        {
          applyValueTextStyle(localILineDataSet);
          Object localObject = mChart.getTransformer(localILineDataSet.getAxisDependency());
          int k = (int)(localILineDataSet.getCircleRadius() * 1.75F);
          int j = k;
          if (!localILineDataSet.isDrawCirclesEnabled()) {
            j = k / 2;
          }
          int n = localILineDataSet.getEntryCount();
          int m = mMinX;
          k = m;
          if (m < 0) {
            k = 0;
          }
          Entry localEntry1 = localILineDataSet.getEntryForXIndex(k, DataSet.Rounding.DOWN);
          Entry localEntry2 = localILineDataSet.getEntryForXIndex(mMaxX, DataSet.Rounding.UP);
          if (localEntry1 == localEntry2) {
            k = 1;
          } else {
            k = 0;
          }
          m = Math.max(localILineDataSet.getEntryIndex(localEntry1) - k, 0);
          k = Math.min(Math.max(m + 2, localILineDataSet.getEntryIndex(localEntry2) + 1), n);
          localObject = ((Transformer)localObject).generateTransformedValuesLine(localILineDataSet, mAnimator.getPhaseX(), mAnimator.getPhaseY(), m, k);
          k = 0;
          while (k < localObject.length)
          {
            f1 = localObject[k];
            f2 = localObject[(k + 1)];
            if (!mViewPortHandler.isInBoundsRight(f1)) {
              break;
            }
            if ((mViewPortHandler.isInBoundsLeft(f1)) && (mViewPortHandler.isInBoundsY(f2)))
            {
              n = k / 2;
              localEntry1 = localILineDataSet.getEntryForIndex(n + m);
              drawValue(paramCanvas, localILineDataSet.getValueFormatter(), localEntry1.getVal(), localEntry1, i, f1, f2 - j, localILineDataSet.getValueTextColor(n));
            }
            k += 2;
          }
        }
        i += 1;
      }
    }
  }
  
  public Bitmap.Config getBitmapConfig()
  {
    return mBitmapConfig;
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
  
  public void setBitmapConfig(Bitmap.Config paramConfig)
  {
    mBitmapConfig = paramConfig;
    releaseBitmap();
  }
}
