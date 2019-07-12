package com.google.android.android.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingRequest
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.location.GeofencingRequest> CREATOR = new DownloadProgressInfo.1();
  public static final int INITIAL_TRIGGER_DWELL = 4;
  public static final int INITIAL_TRIGGER_ENTER = 1;
  public static final int INITIAL_TRIGGER_EXIT = 2;
  public final String mTag;
  public final List<com.google.android.gms.internal.zzcac> zzhxq;
  public final int zzhxr;
  
  public GeofencingRequest(List paramList, int paramInt, String paramString)
  {
    zzhxq = paramList;
    zzhxr = paramInt;
    mTag = paramString;
  }
  
  public List getGeofences()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(zzhxq);
    return localArrayList;
  }
  
  public int getInitialTrigger()
  {
    return zzhxr;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("GeofencingRequest[", "geofences=");
    localStringBuilder.append(zzhxq);
    int i = zzhxr;
    Object localObject = new StringBuilder(30);
    ((StringBuilder)localObject).append(", initialTrigger=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", ");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = String.valueOf(mTag);
    if (((String)localObject).length() != 0) {
      localObject = "tag=".concat((String)localObject);
    } else {
      localObject = new String("tag=");
    }
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, (String)localObject, "]");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.save(paramParcel, 1, zzhxq, false);
    zzbcn.setCustomVar(paramParcel, 2, getInitialTrigger());
    zzbcn.append(paramParcel, 3, mTag, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public final class Builder
  {
    public String mTag = "";
    public final List<com.google.android.gms.internal.zzcac> zzhxq = new ArrayList();
    public int zzhxr = 5;
    
    public Builder() {}
    
    public final Builder addGeofence(Geofence paramGeofence)
    {
      zzbp.get(paramGeofence, "geofence can't be null.");
      zzbp.get(paramGeofence instanceof com.google.android.android.internal.zzcac, "Geofence must be created using Geofence.Builder.");
      zzhxq.add((com.google.android.android.internal.zzcac)paramGeofence);
      return this;
    }
    
    public final Builder addGeofences(List paramList)
    {
      if (paramList != null)
      {
        if (paramList.isEmpty()) {
          return this;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Geofence localGeofence = (Geofence)paramList.next();
          if (localGeofence != null) {
            addGeofence(localGeofence);
          }
        }
      }
      return this;
    }
    
    public final GeofencingRequest build()
    {
      zzbp.get(zzhxq.isEmpty() ^ true, "No geofence has been added to this request.");
      return new GeofencingRequest(zzhxq, zzhxr, mTag);
    }
    
    public final Builder setInitialTrigger(int paramInt)
    {
      zzhxr = (paramInt & 0x7);
      return this;
    }
  }
}
