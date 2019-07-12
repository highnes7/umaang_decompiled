package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.data.BarEntry;

public abstract interface IBarDataSet
  extends IBarLineScatterCandleBubbleDataSet<BarEntry>
{
  public abstract int getBarShadowColor();
  
  public abstract float getBarSpace();
  
  public abstract int getHighLightAlpha();
  
  public abstract String[] getStackLabels();
  
  public abstract int getStackSize();
  
  public abstract boolean isStacked();
}
