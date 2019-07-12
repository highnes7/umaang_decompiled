package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;

public class ScatterBuffer
  extends AbstractBuffer<IScatterDataSet>
{
  public ScatterBuffer(int paramInt)
  {
    super(paramInt);
  }
  
  public void addForm(float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat = buffer;
    int i = index;
    index = (i + 1);
    arrayOfFloat[i] = paramFloat1;
    i = index;
    index = (i + 1);
    arrayOfFloat[i] = paramFloat2;
  }
  
  public void feed(IScatterDataSet paramIScatterDataSet)
  {
    float f1 = paramIScatterDataSet.getEntryCount();
    float f2 = phaseX;
    int i = 0;
    while (i < f1 * f2)
    {
      Entry localEntry = paramIScatterDataSet.getEntryForIndex(i);
      addForm(localEntry.getXIndex(), localEntry.getVal() * phaseY);
      i += 1;
    }
    reset();
  }
}
