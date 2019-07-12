package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.realm.base.RealmUtils;
import io.realm.RealmResults;
import java.util.List;

public class RealmLineData
  extends LineData
{
  public RealmLineData(RealmResults paramRealmResults, String paramString, List paramList)
  {
    super(RealmUtils.toXVals(paramRealmResults, paramString), paramList);
  }
}
