package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PieDataSet
  extends DataSet<Entry>
  implements IPieDataSet
{
  public float mShift = 18.0F;
  public float mSliceSpace = 0.0F;
  
  public PieDataSet(List paramList, String paramString)
  {
    super(paramList, paramString);
  }
  
  public DataSet copy()
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i < mYVals.size())
    {
      ((List)localObject).add(((Entry)mYVals.get(i)).copy());
      i += 1;
    }
    localObject = new PieDataSet((List)localObject, getLabel());
    mColors = mColors;
    mSliceSpace = mSliceSpace;
    mShift = mShift;
    return localObject;
  }
  
  public float getSelectionShift()
  {
    return mShift;
  }
  
  public float getSliceSpace()
  {
    return mSliceSpace;
  }
  
  public void setSelectionShift(float paramFloat)
  {
    mShift = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setSliceSpace(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 20.0F) {
      f = 20.0F;
    }
    paramFloat = f;
    if (f < 0.0F) {
      paramFloat = 0.0F;
    }
    mSliceSpace = Utils.convertDpToPixel(paramFloat);
  }
}
