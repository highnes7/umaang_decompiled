package com.github.mikephil.charting.data.realm.base;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import io.realm.RealmObject;
import io.realm.RealmResults;

public abstract class RealmBarLineScatterCandleBubbleDataSet<T extends RealmObject, S extends Entry>
  extends RealmBaseDataSet<T, S>
  implements IBarLineScatterCandleBubbleDataSet<S>
{
  public int mHighLightColor = Color.rgb(255, 187, 115);
  
  public RealmBarLineScatterCandleBubbleDataSet(RealmResults paramRealmResults, String paramString)
  {
    super(paramRealmResults, paramString);
  }
  
  public RealmBarLineScatterCandleBubbleDataSet(RealmResults paramRealmResults, String paramString1, String paramString2)
  {
    super(paramRealmResults, paramString1, paramString2);
  }
  
  public int getHighLightColor()
  {
    return mHighLightColor;
  }
  
  public void setHighLightColor(int paramInt)
  {
    mHighLightColor = paramInt;
  }
}
