package com.google.android.android.common.package_9;

import android.text.TextUtils;
import b.b.x.n.b;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.internal.Msg;
import com.google.android.gms.common.api.internal.zzh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public class AvailabilityException
  extends Exception
{
  public final b<zzh<?>, com.google.android.gms.common.ConnectionResult> zzfgj;
  
  public AvailabilityException(ArrayMap paramArrayMap)
  {
    zzfgj = paramArrayMap;
  }
  
  public com.google.android.android.common.ConnectionResult getConnectionResult(GoogleApi paramGoogleApi)
  {
    paramGoogleApi = paramGoogleApi.zzafk();
    boolean bool;
    if (zzfgj.get(paramGoogleApi) != null) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.get(bool, "The given API was not part of the availability request.");
    return (com.google.android.android.common.ConnectionResult)zzfgj.get(paramGoogleApi);
  }
  
  public String getMessage()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = zzfgj.keySet().iterator();
    int i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Msg)((Iterator)localObject1).next();
      Object localObject3 = (com.google.android.android.common.ConnectionResult)zzfgj.get(localObject2);
      if (((com.google.android.android.common.ConnectionResult)localObject3).isSuccess()) {
        i = 0;
      }
      localObject2 = ((Msg)localObject2).zzafv();
      localObject3 = String.valueOf(localObject3);
      int j = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject2, 2);
      StringBuilder localStringBuilder = new StringBuilder(((String)localObject3).length() + j);
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(": ");
      localStringBuilder.append((String)localObject3);
      localArrayList.add(localStringBuilder.toString());
    }
    Object localObject2 = new StringBuilder();
    if (i != 0) {
      localObject1 = "None of the queried APIs are available. ";
    } else {
      localObject1 = "Some of the queried APIs are unavailable. ";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(TextUtils.join("; ", localArrayList));
    return ((StringBuilder)localObject2).toString();
  }
  
  public final ArrayMap zzafh()
  {
    return zzfgj;
  }
}
