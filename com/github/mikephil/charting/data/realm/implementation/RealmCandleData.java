package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.realm.base.RealmUtils;
import io.realm.RealmResults;
import java.util.List;

public class RealmCandleData
  extends CandleData
{
  public RealmCandleData(RealmResults paramRealmResults, String paramString, List paramList)
  {
    super(RealmUtils.toXVals(paramRealmResults, paramString), paramList);
  }
}
