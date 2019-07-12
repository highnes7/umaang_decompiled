package com.google.android.android.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.android.internal.zzcac;
import com.google.android.gms.location.Geofence;
import java.util.ArrayList;
import java.util.List;

public class GeofencingEvent
{
  public final int mErrorCode;
  public final int zzhxn;
  public final List<Geofence> zzhxo;
  public final Location zzhxp;
  
  public GeofencingEvent(int paramInt1, int paramInt2, List paramList, Location paramLocation)
  {
    mErrorCode = paramInt1;
    zzhxn = paramInt2;
    zzhxo = paramList;
    zzhxp = paramLocation;
  }
  
  public static GeofencingEvent fromIntent(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent == null) {
      return null;
    }
    int j = -1;
    int m = paramIntent.getIntExtra("gms_error_code", -1);
    int k = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
    int i = j;
    if (k != -1) {
      if ((k != 1) && (k != 2))
      {
        i = j;
        if (k != 4) {}
      }
      else
      {
        i = k;
      }
    }
    ArrayList localArrayList2 = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
    if (localArrayList2 != null)
    {
      ArrayList localArrayList1 = new ArrayList(localArrayList2.size());
      k = localArrayList2.size();
      j = 0;
      for (;;)
      {
        localObject = localArrayList1;
        if (j >= k) {
          break;
        }
        localObject = localArrayList2.get(j);
        j += 1;
        localArrayList1.add(zzcac.obtain((byte[])localObject));
      }
    }
    return new GeofencingEvent(m, i, localObject, (Location)paramIntent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
  }
  
  public int getErrorCode()
  {
    return mErrorCode;
  }
  
  public int getGeofenceTransition()
  {
    return zzhxn;
  }
  
  public List getTriggeringGeofences()
  {
    return zzhxo;
  }
  
  public Location getTriggeringLocation()
  {
    return zzhxp;
  }
  
  public boolean hasError()
  {
    return mErrorCode != -1;
  }
}
