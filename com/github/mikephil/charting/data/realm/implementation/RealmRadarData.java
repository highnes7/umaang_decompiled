package com.github.mikephil.charting.data.realm.implementation;

import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.realm.base.RealmUtils;
import io.realm.RealmResults;
import java.util.List;

public class RealmRadarData
  extends RadarData
{
  public RealmRadarData(RealmResults paramRealmResults, String paramString, List paramList)
  {
    super(RealmUtils.toXVals(paramRealmResults, paramString), paramList);
  }
}
