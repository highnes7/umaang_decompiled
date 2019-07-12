package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.realm.base.RealmBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.data.realm.base.RealmBaseDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.Utils;
import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;
import java.util.List;

public class RealmBubbleDataSet<T extends RealmObject>
  extends RealmBarLineScatterCandleBubbleDataSet<T, BubbleEntry>
  implements IBubbleDataSet
{
  public float mHighlightCircleWidth = 2.5F;
  public float mMaxSize;
  public String mSizeField;
  public float mXMax;
  public float mXMin;
  
  public RealmBubbleDataSet(RealmResults paramRealmResults, String paramString1, String paramString2)
  {
    super(paramRealmResults, paramString1);
    mSizeField = paramString2;
    build(results);
    calcMinMax(0, results.size());
  }
  
  public RealmBubbleDataSet(RealmResults paramRealmResults, String paramString1, String paramString2, String paramString3)
  {
    super(paramRealmResults, paramString1, paramString2);
    mSizeField = paramString3;
    build(results);
    calcMinMax(0, results.size());
  }
  
  private float largestSize(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getSize();
  }
  
  private float xMax(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getXIndex();
  }
  
  private float xMin(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getXIndex();
  }
  
  private float yMax(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getVal();
  }
  
  private float yMin(BubbleEntry paramBubbleEntry)
  {
    return paramBubbleEntry.getVal();
  }
  
  public void build(RealmResults paramRealmResults)
  {
    DynamicRealmObject localDynamicRealmObject;
    if (mIndexField == null)
    {
      int i = 0;
      paramRealmResults = paramRealmResults.iterator();
      while (paramRealmResults.hasNext())
      {
        localDynamicRealmObject = new DynamicRealmObject((RealmObject)paramRealmResults.next());
        mValues.add(new BubbleEntry(i, localDynamicRealmObject.getFloat(mValuesField), localDynamicRealmObject.getFloat(mSizeField)));
        i += 1;
      }
    }
    paramRealmResults = paramRealmResults.iterator();
    while (paramRealmResults.hasNext())
    {
      localDynamicRealmObject = new DynamicRealmObject((RealmObject)paramRealmResults.next());
      mValues.add(new BubbleEntry(localDynamicRealmObject.getInt(mIndexField), localDynamicRealmObject.getFloat(mValuesField), localDynamicRealmObject.getFloat(mSizeField)));
    }
  }
  
  public void calcMinMax(int paramInt1, int paramInt2)
  {
    Object localObject = mValues;
    if (localObject == null) {
      return;
    }
    if (((List)localObject).size() == 0) {
      return;
    }
    int i;
    if (paramInt2 != 0)
    {
      i = paramInt2;
      if (paramInt2 < mValues.size()) {}
    }
    else
    {
      i = mValues.size() - 1;
    }
    mYMin = ((BubbleEntry)mValues.get(paramInt1)).getVal();
    mYMax = ((BubbleEntry)mValues.get(paramInt1)).getVal();
    while (paramInt1 < i)
    {
      localObject = (BubbleEntry)mValues.get(paramInt1);
      float f1 = ((Entry)localObject).getVal();
      float f2 = ((Entry)localObject).getVal();
      if (f1 < mYMin) {
        mYMin = f1;
      }
      if (f2 > mYMax) {
        mYMax = f2;
      }
      f1 = xMin((BubbleEntry)localObject);
      f2 = xMax((BubbleEntry)localObject);
      if (f1 < mXMin) {
        mXMin = f1;
      }
      if (f2 > mXMax) {
        mXMax = f2;
      }
      f1 = ((BubbleEntry)localObject).getSize();
      if (f1 > mMaxSize) {
        mMaxSize = f1;
      }
      paramInt1 += 1;
    }
  }
  
  public float getHighlightCircleWidth()
  {
    return mHighlightCircleWidth;
  }
  
  public float getMaxSize()
  {
    return mMaxSize;
  }
  
  public String getSizeField()
  {
    return mSizeField;
  }
  
  public float getXMax()
  {
    return mXMax;
  }
  
  public float getXMin()
  {
    return mXMin;
  }
  
  public void setHighlightCircleWidth(float paramFloat)
  {
    mHighlightCircleWidth = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setSizeField(String paramString)
  {
    mSizeField = paramString;
  }
}
