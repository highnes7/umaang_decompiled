package com.github.mikephil.charting.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataSet<T extends Entry>
  implements IDataSet<T>
{
  public YAxis.AxisDependency mAxisDependency = YAxis.AxisDependency.LEFT;
  public List<Integer> mColors = null;
  public boolean mDrawValues = true;
  public boolean mHighlightEnabled = true;
  public String mLabel = "DataSet";
  public List<Integer> mValueColors = null;
  public transient ValueFormatter mValueFormatter;
  public float mValueTextSize = 17.0F;
  public Typeface mValueTypeface;
  public boolean mVisible = true;
  
  public BaseDataSet()
  {
    mColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    mValueColors.add(Integer.valueOf(-16777216));
  }
  
  public BaseDataSet(String paramString)
  {
    this();
    mLabel = paramString;
  }
  
  public void addColor(int paramInt)
  {
    if (mColors == null) {
      mColors = new ArrayList();
    }
    mColors.add(Integer.valueOf(paramInt));
  }
  
  public boolean contains(Entry paramEntry)
  {
    int i = 0;
    while (i < getEntryCount())
    {
      if (getEntryForIndex(i).equals(paramEntry)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public YAxis.AxisDependency getAxisDependency()
  {
    return mAxisDependency;
  }
  
  public int getColor()
  {
    return ((Integer)mColors.get(0)).intValue();
  }
  
  public int getColor(int paramInt)
  {
    List localList = mColors;
    return ((Integer)localList.get(paramInt % localList.size())).intValue();
  }
  
  public List getColors()
  {
    return mColors;
  }
  
  public int getIndexInEntries(int paramInt)
  {
    int i = 0;
    while (i < getEntryCount())
    {
      if (paramInt == getEntryForIndex(i).getXIndex()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public String getLabel()
  {
    return mLabel;
  }
  
  public List getValueColors()
  {
    return mValueColors;
  }
  
  public ValueFormatter getValueFormatter()
  {
    ValueFormatter localValueFormatter = mValueFormatter;
    if (localValueFormatter == null) {
      return new DefaultValueFormatter(1);
    }
    return localValueFormatter;
  }
  
  public int getValueTextColor()
  {
    return ((Integer)mValueColors.get(0)).intValue();
  }
  
  public int getValueTextColor(int paramInt)
  {
    List localList = mValueColors;
    return ((Integer)localList.get(paramInt % localList.size())).intValue();
  }
  
  public float getValueTextSize()
  {
    return mValueTextSize;
  }
  
  public Typeface getValueTypeface()
  {
    return mValueTypeface;
  }
  
  public boolean isDrawValuesEnabled()
  {
    return mDrawValues;
  }
  
  public boolean isHighlightEnabled()
  {
    return mHighlightEnabled;
  }
  
  public boolean isVisible()
  {
    return mVisible;
  }
  
  public void notifyDataSetChanged()
  {
    calcMinMax(0, getEntryCount() - 1);
  }
  
  public boolean removeEntry(int paramInt)
  {
    return removeEntry(getEntryForXIndex(paramInt));
  }
  
  public boolean removeFirst()
  {
    return removeEntry(getEntryForIndex(0));
  }
  
  public boolean removeLast()
  {
    return removeEntry(getEntryForIndex(getEntryCount() - 1));
  }
  
  public void resetColors()
  {
    mColors = new ArrayList();
  }
  
  public void setAxisDependency(YAxis.AxisDependency paramAxisDependency)
  {
    mAxisDependency = paramAxisDependency;
  }
  
  public void setColor(int paramInt)
  {
    resetColors();
    mColors.add(Integer.valueOf(paramInt));
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    setColor(Color.argb(paramInt2, Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1)));
  }
  
  public void setColors(List paramList)
  {
    mColors = paramList;
  }
  
  public void setColors(int[] paramArrayOfInt)
  {
    mColors = ColorTemplate.createColors(paramArrayOfInt);
  }
  
  public void setColors(int[] paramArrayOfInt, int paramInt)
  {
    resetColors();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      addColor(Color.argb(paramInt, Color.red(k), Color.green(k), Color.blue(k)));
      i += 1;
    }
  }
  
  public void setColors(int[] paramArrayOfInt, Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      localArrayList.add(Integer.valueOf(paramContext.getResources().getColor(k)));
      i += 1;
    }
    mColors = localArrayList;
  }
  
  public void setDrawValues(boolean paramBoolean)
  {
    mDrawValues = paramBoolean;
  }
  
  public void setHighlightEnabled(boolean paramBoolean)
  {
    mHighlightEnabled = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    mLabel = paramString;
  }
  
  public void setValueFormatter(ValueFormatter paramValueFormatter)
  {
    if (paramValueFormatter == null) {
      return;
    }
    mValueFormatter = paramValueFormatter;
  }
  
  public void setValueTextColor(int paramInt)
  {
    mValueColors.clear();
    mValueColors.add(Integer.valueOf(paramInt));
  }
  
  public void setValueTextColors(List paramList)
  {
    mValueColors = paramList;
  }
  
  public void setValueTextSize(float paramFloat)
  {
    mValueTextSize = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setValueTypeface(Typeface paramTypeface)
  {
    mValueTypeface = paramTypeface;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    mVisible = paramBoolean;
  }
}
