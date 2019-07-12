package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

public abstract class MarkerView
  extends RelativeLayout
{
  public MarkerView(Context paramContext, int paramInt)
  {
    super(paramContext);
    setupLayoutResource(paramInt);
  }
  
  private void setupLayoutResource(int paramInt)
  {
    View localView = LayoutInflater.from(getContext()).inflate(paramInt, this);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    paramFloat1 += getXOffset(paramFloat1);
    paramFloat2 += getYOffset(paramFloat2);
    paramCanvas.translate(paramFloat1, paramFloat2);
    draw(paramCanvas);
    paramCanvas.translate(-paramFloat1, -paramFloat2);
  }
  
  public abstract int getXOffset(float paramFloat);
  
  public abstract int getYOffset(float paramFloat);
  
  public abstract void refreshContent(Entry paramEntry, Highlight paramHighlight);
}
