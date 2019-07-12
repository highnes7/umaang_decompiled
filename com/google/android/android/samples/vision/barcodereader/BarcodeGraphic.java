package com.google.android.android.samples.vision.barcodereader;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.google.android.android.samples.vision.barcodereader.pref.camera.GraphicOverlay;
import com.google.android.android.samples.vision.barcodereader.pref.camera.GraphicOverlay.Graphic;
import com.google.android.android.vision.barcode.Barcode;
import support.android.v4.content.ContextCompat;

public class BarcodeGraphic
  extends GraphicOverlay.Graphic
{
  public static int mCurrentColorIndex;
  public int Id;
  public GraphicOverlay graphicOverlay;
  public volatile Barcode mBarcode;
  public Paint mRectPaint;
  public Paint mTextPaint;
  
  public BarcodeGraphic(GraphicOverlay paramGraphicOverlay)
  {
    super(paramGraphicOverlay);
    graphicOverlay = paramGraphicOverlay;
    mCurrentColorIndex = (mCurrentColorIndex + 1) % paramGraphicOverlay.getRectColors().length;
    int i = ContextCompat.getColor(paramGraphicOverlay.getContext(), paramGraphicOverlay.getRectColors()[mCurrentColorIndex].intValue());
    mRectPaint = new Paint();
    mRectPaint.setColor(i);
    mRectPaint.setStyle(Paint.Style.STROKE);
    mRectPaint.setStrokeWidth(4.0F);
    mTextPaint = new Paint();
    mTextPaint.setColor(i);
    mTextPaint.setTextSize(36.0F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Barcode localBarcode = mBarcode;
    if (localBarcode == null) {
      return;
    }
    RectF localRectF = new RectF(localBarcode.getBoundingBox());
    left = translateX(left);
    top = translateY(top);
    right = translateX(right);
    bottom = translateY(bottom);
    if (graphicOverlay.isDrawRect()) {
      paramCanvas.drawRect(localRectF, mRectPaint);
    }
    if (graphicOverlay.isShowText()) {
      paramCanvas.drawText(rawValue, left, bottom, mTextPaint);
    }
  }
  
  public Barcode getBarcode()
  {
    return mBarcode;
  }
  
  public int getId()
  {
    return Id;
  }
  
  public void setId(int paramInt)
  {
    Id = paramInt;
  }
  
  public void updateItem(Barcode paramBarcode)
  {
    mBarcode = paramBarcode;
    postInvalidate();
  }
}
