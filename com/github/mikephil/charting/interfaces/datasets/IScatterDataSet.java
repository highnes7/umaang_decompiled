package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.charts.ScatterChart.ScatterShape;
import com.github.mikephil.charting.data.Entry;

public abstract interface IScatterDataSet
  extends ILineScatterCandleRadarDataSet<Entry>
{
  public abstract ScatterChart.ScatterShape getScatterShape();
  
  public abstract int getScatterShapeHoleColor();
  
  public abstract float getScatterShapeHoleRadius();
  
  public abstract float getScatterShapeSize();
}
