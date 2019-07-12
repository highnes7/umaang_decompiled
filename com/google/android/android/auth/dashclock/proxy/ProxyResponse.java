package com.google.android.android.auth.dashclock.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdkWithMembers
public class ProxyResponse
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.proxy.ProxyResponse> CREATOR = new VerticalProgressBar.SavedState.1();
  public static final int STATUS_CODE_NO_CONNECTION = -1;
  public final byte[] body;
  public final int googlePlayServicesStatusCode;
  public final PendingIntent recoveryAction;
  public final int statusCode;
  public int versionCode;
  public Bundle zzebn;
  
  public ProxyResponse(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, int paramInt3, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    versionCode = paramInt1;
    googlePlayServicesStatusCode = paramInt2;
    statusCode = paramInt3;
    zzebn = paramBundle;
    body = paramArrayOfByte;
    recoveryAction = paramPendingIntent;
  }
  
  public ProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this(1, paramInt1, paramPendingIntent, paramInt2, paramBundle, paramArrayOfByte);
  }
  
  public ProxyResponse(int paramInt, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this(1, 0, null, paramInt, paramBundle, paramArrayOfByte);
  }
  
  public ProxyResponse(int paramInt, Map paramMap, byte[] paramArrayOfByte)
  {
    this(paramInt, add(paramMap), paramArrayOfByte);
  }
  
  public static Bundle add(Map paramMap)
  {
    Bundle localBundle = new Bundle();
    if (paramMap == null) {
      return localBundle;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localBundle;
  }
  
  public static ProxyResponse createErrorProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Map paramMap, byte[] paramArrayOfByte)
  {
    return new ProxyResponse(1, paramInt1, paramPendingIntent, paramInt2, add(paramMap), paramArrayOfByte);
  }
  
  public Map getHeaders()
  {
    if (zzebn == null) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzebn.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, zzebn.getString(str));
    }
    return localHashMap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, googlePlayServicesStatusCode);
    zzbcn.addMenuItem(paramParcel, 2, recoveryAction, paramInt, false);
    zzbcn.setCustomVar(paramParcel, 3, statusCode);
    zzbcn.writeString(paramParcel, 4, zzebn, false);
    zzbcn.writeString(paramParcel, 5, body, false);
    zzbcn.setCustomVar(paramParcel, 1000, versionCode);
    zzbcn.zzah(paramParcel, i);
  }
}
