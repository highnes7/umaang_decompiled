package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Transformer;

public class BarHighlighter
  extends ChartHighlighter<BarDataProvider>
{
  public BarHighlighter(BarDataProvider paramBarDataProvider)
  {
    super(paramBarDataProvider);
  }
  
  public float getBase(float paramFloat)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat;
    ((BarDataProvider)mChart).getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(arrayOfFloat);
    paramFloat = arrayOfFloat[0];
    float f = ((BarDataProvider)mChart).getBarData().getDataSetCount();
    int i = (int)(paramFloat / (((BarDataProvider)mChart).getBarData().getGroupSpace() + f));
    return paramFloat - ((BarDataProvider)mChart).getBarData().getGroupSpace() * i;
  }
  
  public int getClosestStackIndex(Range[] paramArrayOfRange, float paramFloat)
  {
    if (paramArrayOfRange != null)
    {
      if (paramArrayOfRange.length == 0) {
        return 0;
      }
      int k = paramArrayOfRange.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        if (paramArrayOfRange[i].contains(paramFloat)) {
          return j;
        }
        j += 1;
        i += 1;
      }
      i = Math.max(paramArrayOfRange.length - 1, 0);
      if (paramFloat > to) {
        return i;
      }
    }
    return 0;
  }
  
  public int getDataSetIndex(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (!((BarDataProvider)mChart).getBarData().isGrouped()) {
      return 0;
    }
    paramFloat1 = getBase(paramFloat1);
    paramInt = ((BarDataProvider)mChart).getBarData().getDataSetCount();
    int i = (int)paramFloat1 % paramInt;
    if (i < 0) {
      return 0;
    }
    if (i >= paramInt) {
      return paramInt - 1;
    }
    return i;
  }
  
  public Highlight getHighlight(float paramFloat1, float paramFloat2)
  {
    Highlight localHighlight = super.getHighlight(paramFloat1, paramFloat2);
    if (localHighlight == null) {
      return localHighlight;
    }
    IBarDataSet localIBarDataSet = (IBarDataSet)((BarDataProvider)mChart).getBarData().getDataSetByIndex(localHighlight.getDataSetIndex());
    Object localObject = localHighlight;
    if (localIBarDataSet.isStacked())
    {
      localObject = new float[2];
      localObject[1] = paramFloat2;
      ((BarDataProvider)mChart).getTransformer(localIBarDataSet.getAxisDependency()).pixelsToValue((float[])localObject);
      localObject = getStackedHighlight(localHighlight, localIBarDataSet, localHighlight.getXIndex(), localHighlight.getDataSetIndex(), localObject[1]);
    }
    return localObject;
  }
  
  public Range[] getRanges(BarEntry paramBarEntry)
  {
    float[] arrayOfFloat = paramBarEntry.getVals();
    int i = 0;
    if ((arrayOfFloat != null) && (arrayOfFloat.length != 0))
    {
      Range[] arrayOfRange = new Range[arrayOfFloat.length];
      float f2 = -paramBarEntry.getNegativeSum();
      float f1 = 0.0F;
      while (i < arrayOfRange.length)
      {
        float f3 = arrayOfFloat[i];
        if (f3 < 0.0F)
        {
          arrayOfRange[i] = new Range(f2, Math.abs(f3) + f2);
          f2 = Math.abs(f3) + f2;
        }
        else
        {
          f3 += f1;
          arrayOfRange[i] = new Range(f1, f3);
          f1 = f3;
        }
        i += 1;
      }
      return arrayOfRange;
    }
    return new Range[0];
  }
  
  public Highlight getStackedHighlight(Highlight paramHighlight, IBarDataSet paramIBarDataSet, int paramInt1, int paramInt2, double paramDouble)
  {
    paramIBarDataSet = (BarEntry)paramIBarDataSet.getEntryForXIndex(paramInt1);
    if (paramIBarDataSet != null)
    {
      if (paramIBarDataSet.getVals() == null) {
        return paramHighlight;
      }
      paramHighlight = getRanges(paramIBarDataSet);
      int i = getClosestStackIndex(paramHighlight, (float)paramDouble);
      if (paramHighlight.length > 0) {
        return new Highlight(paramInt1, paramInt2, i, paramHighlight[i]);
      }
      return null;
    }
    return paramHighlight;
  }
  
  public int getXIndex(float paramFloat)
  {
    if (!((BarDataProvider)mChart).getBarData().isGrouped()) {
      return super.getXIndex(paramFloat);
    }
    paramFloat = getBase(paramFloat);
    int i = ((BarDataProvider)mChart).getBarData().getDataSetCount();
    int j = (int)paramFloat / i;
    int k = ((BarDataProvider)mChart).getData().getXValCount();
    if (j < 0) {
      return 0;
    }
    i = j;
    if (j >= k) {
      i = k - 1;
    }
    return i;
  }
}
