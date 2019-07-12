package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class AxisRenderer
  extends Renderer
{
  public Paint mAxisLabelPaint;
  public Paint mAxisLinePaint;
  public Paint mGridPaint;
  public Paint mLimitLinePaint;
  public Transformer mTrans;
  
  public AxisRenderer(ViewPortHandler paramViewPortHandler, Transformer paramTransformer)
  {
    super(paramViewPortHandler);
    mTrans = paramTransformer;
    mAxisLabelPaint = new Paint(1);
    mGridPaint = new Paint();
    mGridPaint.setColor(-7829368);
    mGridPaint.setStrokeWidth(1.0F);
    mGridPaint.setStyle(Paint.Style.STROKE);
    mGridPaint.setAlpha(90);
    mAxisLinePaint = new Paint();
    mAxisLinePaint.setColor(-16777216);
    mAxisLinePaint.setStrokeWidth(1.0F);
    mAxisLinePaint.setStyle(Paint.Style.STROKE);
    mLimitLinePaint = new Paint(1);
    mLimitLinePaint.setStyle(Paint.Style.STROKE);
  }
  
  public Paint getPaintAxisLabels()
  {
    return mAxisLabelPaint;
  }
  
  public Paint getPaintAxisLine()
  {
    return mAxisLinePaint;
  }
  
  public Paint getPaintGrid()
  {
    return mGridPaint;
  }
  
  public Transformer getTransformer()
  {
    return mTrans;
  }
  
  public abstract void renderAxisLabels(Canvas paramCanvas);
  
  public abstract void renderAxisLine(Canvas paramCanvas);
  
  public abstract void renderGridLines(Canvas paramCanvas);
  
  public abstract void renderLimitLines(Canvas paramCanvas);
}
