package com.github.mikephil.charting.data.realm.base;

import com.github.mikephil.charting.data.BaseDataSet;
import com.github.mikephil.charting.data.DataSet.Rounding;
import com.github.mikephil.charting.data.Entry;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;
import java.util.ArrayList;
import java.util.List;

public abstract class RealmBaseDataSet<T extends RealmObject, S extends Entry>
  extends BaseDataSet<S>
{
  public String mIndexField;
  public List<S> mValues;
  public String mValuesField;
  public float mYMax = 0.0F;
  public float mYMin = 0.0F;
  public RealmResults<T> results;
  
  public RealmBaseDataSet(RealmResults paramRealmResults, String paramString)
  {
    results = paramRealmResults;
    mValuesField = paramString;
    mValues = new ArrayList();
    paramRealmResults = mIndexField;
    if (paramRealmResults != null) {
      results.sort(paramRealmResults, Sort.ASCENDING);
    }
  }
  
  public RealmBaseDataSet(RealmResults paramRealmResults, String paramString1, String paramString2)
  {
    results = paramRealmResults;
    mValuesField = paramString1;
    mIndexField = paramString2;
    mValues = new ArrayList();
    paramRealmResults = mIndexField;
    if (paramRealmResults != null) {
      results.sort(paramRealmResults, Sort.ASCENDING);
    }
  }
  
  public boolean addEntry(Entry paramEntry)
  {
    if (paramEntry == null) {
      return false;
    }
    float f = paramEntry.getVal();
    if (mValues == null) {
      mValues = new ArrayList();
    }
    if (mValues.size() == 0)
    {
      mYMax = f;
      mYMin = f;
    }
    else
    {
      if (mYMax < f) {
        mYMax = f;
      }
      if (mYMin > f) {
        mYMin = f;
      }
    }
    mValues.add(paramEntry);
    return true;
  }
  
  public void addEntryOrdered(Entry paramEntry)
  {
    if (paramEntry == null) {
      return;
    }
    float f = paramEntry.getVal();
    if (mValues == null) {
      mValues = new ArrayList();
    }
    if (mValues.size() == 0)
    {
      mYMax = f;
      mYMin = f;
    }
    else
    {
      if (mYMax < f) {
        mYMax = f;
      }
      if (mYMin > f) {
        mYMin = f;
      }
    }
    if ((mValues.size() > 0) && (((Entry)StringBuilder.get(mValues, -1)).getXIndex() > paramEntry.getXIndex()))
    {
      int i = getEntryIndex(paramEntry.getXIndex(), DataSet.Rounding.UP);
      mValues.add(i, paramEntry);
      return;
    }
    mValues.add(paramEntry);
  }
  
  public abstract void build(RealmResults paramRealmResults);
  
  public void calcMinMax(int paramInt1, int paramInt2)
  {
    Object localObject = mValues;
    if (localObject == null) {
      return;
    }
    int j = ((List)localObject).size();
    if (j == 0) {
      return;
    }
    int i;
    if (paramInt2 != 0)
    {
      i = paramInt2;
      if (paramInt2 < j) {}
    }
    else
    {
      i = j - 1;
    }
    mYMin = Float.MAX_VALUE;
    mYMax = -3.4028235E38F;
    while (paramInt1 <= i)
    {
      localObject = (Entry)mValues.get(paramInt1);
      if ((localObject != null) && (!Float.isNaN(((Entry)localObject).getVal())))
      {
        if (((Entry)localObject).getVal() < mYMin) {
          mYMin = ((Entry)localObject).getVal();
        }
        if (((Entry)localObject).getVal() > mYMax) {
          mYMax = ((Entry)localObject).getVal();
        }
      }
      paramInt1 += 1;
    }
    if (mYMin == Float.MAX_VALUE)
    {
      mYMin = 0.0F;
      mYMax = 0.0F;
    }
  }
  
  public void clear()
  {
    mValues.clear();
    notifyDataSetChanged();
  }
  
  public int getEntryCount()
  {
    return mValues.size();
  }
  
  public Entry getEntryForIndex(int paramInt)
  {
    return (Entry)mValues.get(paramInt);
  }
  
  public Entry getEntryForXIndex(int paramInt)
  {
    return getEntryForXIndex(paramInt, DataSet.Rounding.CLOSEST);
  }
  
  public Entry getEntryForXIndex(int paramInt, DataSet.Rounding paramRounding)
  {
    paramInt = getEntryIndex(paramInt, paramRounding);
    if (paramInt > -1) {
      return (Entry)mValues.get(paramInt);
    }
    return null;
  }
  
  public int getEntryIndex(int paramInt, DataSet.Rounding paramRounding)
  {
    int k = mValues.size() - 1;
    int j = 0;
    int i = -1;
    while (j <= k)
    {
      i = (k + j) / 2;
      if (paramInt == ((Entry)mValues.get(i)).getXIndex())
      {
        while (i > 0)
        {
          j = i;
          if (((Entry)mValues.get(i - 1)).getXIndex() != paramInt) {
            break label221;
          }
          i -= 1;
        }
        return i;
      }
      if (paramInt > ((Entry)mValues.get(i)).getXIndex()) {
        j = i + 1;
      } else {
        k = i - 1;
      }
    }
    j = i;
    if (i != -1)
    {
      k = ((Entry)mValues.get(i)).getXIndex();
      if (paramRounding == DataSet.Rounding.UP)
      {
        j = i;
        if (k < paramInt)
        {
          j = i;
          if (i < mValues.size() - 1) {
            return i + 1;
          }
        }
      }
      else
      {
        j = i;
        if (paramRounding == DataSet.Rounding.DOWN)
        {
          j = i;
          if (k > paramInt)
          {
            j = i;
            if (i > 0) {
              return i - 1;
            }
          }
        }
      }
    }
    label221:
    return j;
  }
  
  public int getEntryIndex(Entry paramEntry)
  {
    return mValues.indexOf(paramEntry);
  }
  
  public String getIndexField()
  {
    return mIndexField;
  }
  
  public RealmResults getResults()
  {
    return results;
  }
  
  public List getValues()
  {
    return mValues;
  }
  
  public String getValuesField()
  {
    return mValuesField;
  }
  
  public float getYMax()
  {
    return mYMax;
  }
  
  public float getYMin()
  {
    return mYMin;
  }
  
  public float getYValForXIndex(int paramInt)
  {
    Entry localEntry = getEntryForXIndex(paramInt);
    if ((localEntry != null) && (localEntry.getXIndex() == paramInt)) {
      return localEntry.getVal();
    }
    return NaN.0F;
  }
  
  public boolean removeEntry(Entry paramEntry)
  {
    if (paramEntry == null) {
      return false;
    }
    List localList = mValues;
    if (localList == null) {
      return false;
    }
    boolean bool = localList.remove(paramEntry);
    if (bool) {
      calcMinMax(0, mValues.size());
    }
    return bool;
  }
  
  public void setIndexField(String paramString)
  {
    mIndexField = paramString;
  }
  
  public void setValuesField(String paramString)
  {
    mValuesField = paramString;
  }
}
