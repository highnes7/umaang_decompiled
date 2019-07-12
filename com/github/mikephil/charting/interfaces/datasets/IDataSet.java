package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.Typeface;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.DataSet.Rounding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.List;

public abstract interface IDataSet<T extends Entry>
{
  public abstract boolean addEntry(Entry paramEntry);
  
  public abstract void addEntryOrdered(Entry paramEntry);
  
  public abstract void calcMinMax(int paramInt1, int paramInt2);
  
  public abstract void clear();
  
  public abstract boolean contains(Entry paramEntry);
  
  public abstract YAxis.AxisDependency getAxisDependency();
  
  public abstract int getColor();
  
  public abstract int getColor(int paramInt);
  
  public abstract List getColors();
  
  public abstract int getEntryCount();
  
  public abstract Entry getEntryForIndex(int paramInt);
  
  public abstract Entry getEntryForXIndex(int paramInt);
  
  public abstract Entry getEntryForXIndex(int paramInt, DataSet.Rounding paramRounding);
  
  public abstract int getEntryIndex(int paramInt, DataSet.Rounding paramRounding);
  
  public abstract int getEntryIndex(Entry paramEntry);
  
  public abstract int getIndexInEntries(int paramInt);
  
  public abstract String getLabel();
  
  public abstract ValueFormatter getValueFormatter();
  
  public abstract int getValueTextColor();
  
  public abstract int getValueTextColor(int paramInt);
  
  public abstract float getValueTextSize();
  
  public abstract Typeface getValueTypeface();
  
  public abstract float getYMax();
  
  public abstract float getYMin();
  
  public abstract float getYValForXIndex(int paramInt);
  
  public abstract boolean isDrawValuesEnabled();
  
  public abstract boolean isHighlightEnabled();
  
  public abstract boolean isVisible();
  
  public abstract boolean removeEntry(int paramInt);
  
  public abstract boolean removeEntry(Entry paramEntry);
  
  public abstract boolean removeFirst();
  
  public abstract boolean removeLast();
  
  public abstract void setAxisDependency(YAxis.AxisDependency paramAxisDependency);
  
  public abstract void setDrawValues(boolean paramBoolean);
  
  public abstract void setHighlightEnabled(boolean paramBoolean);
  
  public abstract void setLabel(String paramString);
  
  public abstract void setValueFormatter(ValueFormatter paramValueFormatter);
  
  public abstract void setValueTextColor(int paramInt);
  
  public abstract void setValueTextColors(List paramList);
  
  public abstract void setValueTextSize(float paramFloat);
  
  public abstract void setValueTypeface(Typeface paramTypeface);
  
  public abstract void setVisible(boolean paramBoolean);
}
