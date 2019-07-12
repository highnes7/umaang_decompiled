package com.github.mikephil.charting.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

public abstract class Utils
{
  public static final double DEG2RAD = 0.017453292519943295D;
  public static final float FDEG2RAD = 0.017453292F;
  public static final int[] POW_10 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  public static Rect mDrawTextRectBuffer = new Rect();
  public static Paint.FontMetrics mFontMetricsBuffer = new Paint.FontMetrics();
  public static int mMaximumFlingVelocity;
  public static DisplayMetrics mMetrics;
  public static int mMinimumFlingVelocity;
  
  public Utils() {}
  
  public static int calcTextHeight(Paint paramPaint, String paramString)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.height();
  }
  
  public static FSize calcTextSize(Paint paramPaint, String paramString)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return new FSize(localRect.width(), localRect.height());
  }
  
  public static int calcTextWidth(Paint paramPaint, String paramString)
  {
    return (int)paramPaint.measureText(paramString);
  }
  
  public static float convertDpToPixel(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = mMetrics;
    if (localDisplayMetrics == null) {
      return paramFloat;
    }
    return densityDpi / 160.0F * paramFloat;
  }
  
  public static int[] convertIntegers(List paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static float convertPixelsToDp(float paramFloat)
  {
    DisplayMetrics localDisplayMetrics = mMetrics;
    if (localDisplayMetrics == null) {
      return paramFloat;
    }
    return paramFloat / (densityDpi / 160.0F);
  }
  
  public static String[] convertStrings(List paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    return arrayOfString;
  }
  
  public static void drawMultilineText(Canvas paramCanvas, StaticLayout paramStaticLayout, float paramFloat1, float paramFloat2, TextPaint paramTextPaint, PointF paramPointF, float paramFloat3)
  {
    float f1 = paramTextPaint.getFontMetrics(mFontMetricsBuffer);
    float f5 = paramStaticLayout.getWidth();
    float f6 = paramStaticLayout.getLineCount() * f1;
    float f4 = 0.0F - mDrawTextRectBufferleft;
    float f3 = f6 + 0.0F;
    Paint.Align localAlign = paramTextPaint.getTextAlign();
    paramTextPaint.setTextAlign(Paint.Align.LEFT);
    if (paramFloat3 != 0.0F)
    {
      float f2;
      if (x == 0.5F)
      {
        f2 = paramFloat1;
        f1 = paramFloat2;
        if (y == 0.5F) {}
      }
      else
      {
        FSize localFSize = getSizeOfRotatedRectangleByDegrees(f5, f6, paramFloat3);
        f1 = width;
        f2 = paramFloat1 - (x - 0.5F) * f1;
        paramFloat1 = height;
        f1 = paramFloat2 - (y - 0.5F) * paramFloat1;
      }
      paramCanvas.save();
      paramCanvas.translate(f2, f1);
      paramCanvas.rotate(paramFloat3);
      paramCanvas.translate(f4 - f5 * 0.5F, f3 - f6 * 0.5F);
      paramStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
    }
    else
    {
      if (x == 0.0F)
      {
        f1 = f4;
        paramFloat3 = f3;
        if (y == 0.0F) {}
      }
      else
      {
        f1 = f4 - f5 * x;
        paramFloat3 = f3 - f6 * y;
      }
      paramCanvas.save();
      paramCanvas.translate(f1 + paramFloat1, paramFloat3 + paramFloat2);
      paramStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramTextPaint.setTextAlign(localAlign);
  }
  
  public static void drawMultilineText(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, TextPaint paramTextPaint, FSize paramFSize, PointF paramPointF, float paramFloat3)
  {
    drawMultilineText(paramCanvas, new StaticLayout(paramString, 0, paramString.length(), paramTextPaint, (int)Math.max(Math.ceil(width), 1.0D), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false), paramFloat1, paramFloat2, paramTextPaint, paramPointF, paramFloat3);
  }
  
  public static void drawText(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint, PointF paramPointF, float paramFloat3)
  {
    paramPaint.getTextBounds(paramString, 0, paramString.length(), mDrawTextRectBuffer);
    float f5 = mDrawTextRectBuffer.height();
    float f4 = 0.0F - mDrawTextRectBufferleft;
    float f3 = f5 + 0.0F;
    Paint.Align localAlign = paramPaint.getTextAlign();
    paramPaint.setTextAlign(Paint.Align.LEFT);
    float f1;
    if (paramFloat3 != 0.0F)
    {
      float f6 = mDrawTextRectBuffer.width();
      float f2;
      if (x == 0.5F)
      {
        f2 = paramFloat1;
        f1 = paramFloat2;
        if (y == 0.5F) {}
      }
      else
      {
        FSize localFSize = getSizeOfRotatedRectangleByDegrees(mDrawTextRectBuffer.width(), f5, paramFloat3);
        f1 = width;
        f2 = paramFloat1 - (x - 0.5F) * f1;
        paramFloat1 = height;
        f1 = paramFloat2 - (y - 0.5F) * paramFloat1;
      }
      paramCanvas.save();
      paramCanvas.translate(f2, f1);
      paramCanvas.rotate(paramFloat3);
      paramCanvas.drawText(paramString, f4 - f6 * 0.5F, f3 - f5 * 0.5F, paramPaint);
      paramCanvas.restore();
    }
    else
    {
      if (x == 0.0F)
      {
        f1 = f4;
        paramFloat3 = f3;
        if (y == 0.0F) {}
      }
      else
      {
        f1 = f4 - mDrawTextRectBuffer.width() * x;
        paramFloat3 = f3 - f5 * y;
      }
      paramCanvas.drawText(paramString, f1 + paramFloat1, paramFloat3 + paramFloat2, paramPaint);
    }
    paramPaint.setTextAlign(localAlign);
  }
  
  public static String formatNumber(float paramFloat, int paramInt, boolean paramBoolean)
  {
    return formatNumber(paramFloat, paramInt, paramBoolean, '.');
  }
  
  public static String formatNumber(float paramFloat, int paramInt, boolean paramBoolean, char paramChar)
  {
    float f = paramFloat;
    char[] arrayOfChar = new char[35];
    if (paramFloat == 0.0F) {
      return "0";
    }
    int i1 = 0;
    int m;
    if ((paramFloat < 1.0F) && (paramFloat > -1.0F)) {
      m = 1;
    } else {
      m = 0;
    }
    int k;
    if (paramFloat < 0.0F)
    {
      f = -paramFloat;
      k = 1;
    }
    else
    {
      k = 0;
    }
    int[] arrayOfInt = POW_10;
    int j = paramInt;
    if (paramInt > arrayOfInt.length) {
      j = arrayOfInt.length - 1;
    }
    long l = Math.round(f * POW_10[j]);
    int i = arrayOfChar.length - 1;
    int n = 0;
    paramInt = i1;
    for (;;)
    {
      if ((l == 0L) && (paramInt >= j + 1))
      {
        j = paramInt;
        n = i;
        if (m != 0)
        {
          arrayOfChar[i] = '0';
          j = paramInt + 1;
          n = i - 1;
        }
        paramInt = j;
        if (k != 0)
        {
          arrayOfChar[n] = '-';
          paramInt = j + 1;
        }
        paramInt = arrayOfChar.length - paramInt;
        return String.valueOf(arrayOfChar, paramInt, arrayOfChar.length - paramInt);
      }
      int i2 = (int)(l % 10L);
      l /= 10L;
      i1 = i - 1;
      arrayOfChar[i] = ((char)(i2 + 48));
      paramInt += 1;
      if (paramInt == j)
      {
        i = i1 - 1;
        arrayOfChar[i1] = ',';
        paramInt += 1;
        n = 1;
      }
      else
      {
        if ((paramBoolean) && (l != 0L) && (paramInt > j))
        {
          if (n != 0)
          {
            if ((paramInt - j) % 4 != 0) {
              break label344;
            }
            i = i1 - 1;
            arrayOfChar[i1] = paramChar;
          }
          else
          {
            if ((paramInt - j) % 4 != 3) {
              break label344;
            }
            i = i1 - 1;
            arrayOfChar[i1] = paramChar;
          }
          paramInt += 1;
          continue;
        }
        label344:
        i = i1;
      }
    }
  }
  
  public static int getClosestDataSetIndex(List paramList, float paramFloat, YAxis.AxisDependency paramAxisDependency)
  {
    int j = -2147483647;
    float f1 = Float.MAX_VALUE;
    int i = 0;
    while (i < paramList.size())
    {
      SelectionDetail localSelectionDetail = (SelectionDetail)paramList.get(i);
      int k;
      float f2;
      if (paramAxisDependency != null)
      {
        k = j;
        f2 = f1;
        if (dataSet.getAxisDependency() != paramAxisDependency) {}
      }
      else
      {
        float f3 = Math.abs(val - paramFloat);
        k = j;
        f2 = f1;
        if (f3 < f1)
        {
          k = getdataSetIndex;
          f2 = f3;
        }
      }
      i += 1;
      j = k;
      f1 = f2;
    }
    return j;
  }
  
  public static int getDecimals(float paramFloat)
  {
    return (int)Math.ceil(-Math.log10(roundToNextSignificant(paramFloat))) + 2;
  }
  
  public static float getLineHeight(Paint paramPaint)
  {
    paramPaint = paramPaint.getFontMetrics();
    return descent - ascent;
  }
  
  public static float getLineSpacing(Paint paramPaint)
  {
    paramPaint = paramPaint.getFontMetrics();
    return ascent - top + bottom;
  }
  
  public static int getMaximumFlingVelocity()
  {
    return mMaximumFlingVelocity;
  }
  
  public static float getMinimumDistance(List paramList, float paramFloat, YAxis.AxisDependency paramAxisDependency)
  {
    float f1 = Float.MAX_VALUE;
    int i = 0;
    while (i < paramList.size())
    {
      SelectionDetail localSelectionDetail = (SelectionDetail)paramList.get(i);
      float f2 = f1;
      if (dataSet.getAxisDependency() == paramAxisDependency)
      {
        float f3 = Math.abs(val - paramFloat);
        f2 = f1;
        if (f3 < f1) {
          f2 = f3;
        }
      }
      i += 1;
      f1 = f2;
    }
    return f1;
  }
  
  public static int getMinimumFlingVelocity()
  {
    return mMinimumFlingVelocity;
  }
  
  public static float getNormalizedAngle(float paramFloat)
  {
    while (paramFloat < 0.0F) {
      paramFloat += 360.0F;
    }
    return paramFloat % 360.0F;
  }
  
  public static PointF getPosition(PointF paramPointF, float paramFloat1, float paramFloat2)
  {
    double d3 = x;
    double d1 = paramFloat1;
    double d2 = paramFloat2;
    double d4 = Math.cos(Math.toRadians(d2));
    Double.isNaN(d1);
    Double.isNaN(d3);
    paramFloat1 = (float)(d4 * d1 + d3);
    d3 = y;
    d2 = Math.sin(Math.toRadians(d2));
    Double.isNaN(d1);
    Double.isNaN(d3);
    return new PointF(paramFloat1, (float)(d2 * d1 + d3));
  }
  
  public static int getSDKInt()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static FSize getSizeOfRotatedRectangleByDegrees(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return getSizeOfRotatedRectangleByRadians(paramFloat1, paramFloat2, paramFloat3 * 0.017453292F);
  }
  
  public static FSize getSizeOfRotatedRectangleByDegrees(FSize paramFSize, float paramFloat)
  {
    return getSizeOfRotatedRectangleByRadians(width, height, paramFloat * 0.017453292F);
  }
  
  public static FSize getSizeOfRotatedRectangleByRadians(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double d = paramFloat3;
    paramFloat3 = Math.abs((float)Math.cos(d) * paramFloat1);
    float f = Math.abs((float)Math.sin(d) * paramFloat2);
    paramFloat1 = Math.abs(paramFloat1 * (float)Math.sin(d));
    return new FSize(f + paramFloat3, Math.abs(paramFloat2 * (float)Math.cos(d)) + paramFloat1);
  }
  
  public static FSize getSizeOfRotatedRectangleByRadians(FSize paramFSize, float paramFloat)
  {
    return getSizeOfRotatedRectangleByRadians(width, height, paramFloat);
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext == null)
    {
      mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
      mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
      return;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    mMinimumFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    mMaximumFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    mMetrics = paramContext.getResources().getDisplayMetrics();
  }
  
  public static void init(Resources paramResources)
  {
    mMetrics = paramResources.getDisplayMetrics();
    mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
    mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
  }
  
  public static boolean needsDefaultFormatter(ValueFormatter paramValueFormatter)
  {
    if (paramValueFormatter == null) {
      return true;
    }
    return (paramValueFormatter instanceof DefaultValueFormatter);
  }
  
  public static double nextUp(double paramDouble)
  {
    if (paramDouble == Double.POSITIVE_INFINITY) {
      return paramDouble;
    }
    paramDouble += 0.0D;
    long l2 = Double.doubleToRawLongBits(paramDouble);
    long l1;
    if (paramDouble >= 0.0D) {
      l1 = 1L;
    } else {
      l1 = -1L;
    }
    return Double.longBitsToDouble(l2 + l1);
  }
  
  public static void postInvalidateOnAnimation(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    paramView.postInvalidateOnAnimation();
  }
  
  public static float roundToNextSignificant(double paramDouble)
  {
    if (paramDouble < 0.0D) {
      d = -paramDouble;
    } else {
      d = paramDouble;
    }
    float f = (float)Math.pow(10.0D, 1 - (int)(float)Math.ceil((float)Math.log10(d)));
    double d = f;
    Double.isNaN(d);
    return (float)Math.round(paramDouble * d) / f;
  }
  
  public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent paramMotionEvent, VelocityTracker paramVelocityTracker)
  {
    paramVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
    int j = paramMotionEvent.getActionIndex();
    int i = paramMotionEvent.getPointerId(j);
    float f1 = paramVelocityTracker.getXVelocity(i);
    float f2 = paramVelocityTracker.getYVelocity(i);
    int k = paramMotionEvent.getPointerCount();
    i = 0;
    while (i < k)
    {
      if (i != j)
      {
        int m = paramMotionEvent.getPointerId(i);
        float f3 = paramVelocityTracker.getXVelocity(m);
        if (paramVelocityTracker.getYVelocity(m) * f2 + f3 * f1 < 0.0F)
        {
          paramVelocityTracker.clear();
          return;
        }
      }
      i += 1;
    }
  }
}
