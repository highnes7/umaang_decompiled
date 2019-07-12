package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.realm.base.RealmBaseDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.Iterator;
import java.util.List;

public class RealmPieDataSet<T extends RealmObject>
  extends RealmBaseDataSet<T, Entry>
  implements IPieDataSet
{
  public float mShift = 18.0F;
  public float mSliceSpace = 0.0F;
  
  public RealmPieDataSet(RealmResults paramRealmResults, String paramString)
  {
    super(paramRealmResults, paramString);
    build(results);
    calcMinMax(0, results.size());
  }
  
  public RealmPieDataSet(RealmResults paramRealmResults, String paramString1, String paramString2)
  {
    super(paramRealmResults, paramString1, paramString2);
    build(results);
    calcMinMax(0, results.size());
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
        mValues.add(new Entry(localDynamicRealmObject.getFloat(mValuesField), i));
        i += 1;
      }
    }
    paramRealmResults = paramRealmResults.iterator();
    while (paramRealmResults.hasNext())
    {
      localDynamicRealmObject = new DynamicRealmObject((RealmObject)paramRealmResults.next());
      mValues.add(new Entry(localDynamicRealmObject.getFloat(mValuesField), localDynamicRealmObject.getInt(mIndexField)));
    }
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
