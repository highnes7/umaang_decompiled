package com.google.android.android.samples.vision.barcodereader.pref.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class GraphicOverlay<T extends com.google.android.gms.samples.vision.barcodereader.ui.camera.GraphicOverlay.Graphic>
  extends View
{
  public boolean drawRect;
  public int mFacing = 0;
  public Set<T> mGraphics = new HashSet();
  public float mHeightScaleFactor = 1.0F;
  public final Object mLock = new Object();
  public int mPreviewHeight;
  public int mPreviewWidth;
  public float mWidthScaleFactor = 1.0F;
  public Integer[] rectColors;
  public boolean showText;
  
  public GraphicOverlay(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void clear()
  {
    Object localObject = mLock;
    try
    {
      mGraphics.clear();
      postInvalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public List getGraphics()
  {
    Object localObject = mLock;
    try
    {
      Vector localVector = new Vector(mGraphics);
      return localVector;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public float getHeightScaleFactor()
  {
    return mHeightScaleFactor;
  }
  
  public Integer[] getRectColors()
  {
    return rectColors;
  }
  
  public float getWidthScaleFactor()
  {
    return mWidthScaleFactor;
  }
  
  public boolean isDrawRect()
  {
    return drawRect;
  }
  
  public boolean isShowText()
  {
    return showText;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = mLock;
    try
    {
      if ((mPreviewWidth != 0) && (mPreviewHeight != 0))
      {
        mWidthScaleFactor = (paramCanvas.getWidth() / mPreviewWidth);
        mHeightScaleFactor = (paramCanvas.getHeight() / mPreviewHeight);
      }
      Iterator localIterator = mGraphics.iterator();
      while (localIterator.hasNext()) {
        ((Graphic)localIterator.next()).draw(paramCanvas);
      }
      return;
    }
    catch (Throwable paramCanvas)
    {
      throw paramCanvas;
    }
  }
  
  public void remove(Graphic paramGraphic)
  {
    Object localObject = mLock;
    try
    {
      mGraphics.remove(paramGraphic);
      postInvalidate();
      return;
    }
    catch (Throwable paramGraphic)
    {
      throw paramGraphic;
    }
  }
  
  public void setCameraInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = mLock;
    try
    {
      mPreviewWidth = paramInt1;
      mPreviewHeight = paramInt2;
      mFacing = paramInt3;
      postInvalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void setDrawRect(boolean paramBoolean)
  {
    drawRect = paramBoolean;
  }
  
  public void setRectColors(Integer[] paramArrayOfInteger)
  {
    rectColors = paramArrayOfInteger;
  }
  
  public void setShowText(boolean paramBoolean)
  {
    showText = paramBoolean;
  }
  
  public void update(Graphic paramGraphic)
  {
    Object localObject = mLock;
    try
    {
      mGraphics.add(paramGraphic);
      postInvalidate();
      return;
    }
    catch (Throwable paramGraphic)
    {
      throw paramGraphic;
    }
  }
  
  public abstract class Graphic
  {
    public Graphic() {}
    
    public abstract void draw(Canvas paramCanvas);
    
    public void postInvalidate()
    {
      GraphicOverlay.this.postInvalidate();
    }
    
    public float scaleX(float paramFloat)
    {
      return GraphicOverlay.access$000(GraphicOverlay.this) * paramFloat;
    }
    
    public float scaleY(float paramFloat)
    {
      return GraphicOverlay.access$100(GraphicOverlay.this) * paramFloat;
    }
    
    public float translateX(float paramFloat)
    {
      if (GraphicOverlay.access$200(GraphicOverlay.this) == 1) {
        return getWidth() - scaleX(paramFloat);
      }
      return scaleX(paramFloat);
    }
    
    public float translateY(float paramFloat)
    {
      return scaleY(paramFloat);
    }
  }
}
