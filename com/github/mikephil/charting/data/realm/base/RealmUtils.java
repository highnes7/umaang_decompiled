package com.github.mikephil.charting.data.realm.base;

import io.realm.DynamicRealmObject;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RealmUtils
{
  public RealmUtils() {}
  
  public static List toXVals(RealmResults paramRealmResults, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramRealmResults = paramRealmResults.iterator();
    while (paramRealmResults.hasNext()) {
      localArrayList.add(new DynamicRealmObject((RealmObject)paramRealmResults.next()).getString(paramString));
    }
    return localArrayList;
  }
}
