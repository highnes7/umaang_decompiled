package com.google.android.android.auth.dashclock.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@KeepForSdkWithMembers
public class ProxyRequest
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.proxy.ProxyRequest> CREATOR = new DiscreteSeekBar.CustomState.1();
  public static final int HTTP_METHOD_DELETE;
  public static final int HTTP_METHOD_GET = 0;
  public static final int HTTP_METHOD_HEAD;
  public static final int HTTP_METHOD_OPTIONS;
  public static final int HTTP_METHOD_PATCH = 7;
  public static final int HTTP_METHOD_POST = 1;
  public static final int HTTP_METHOD_PUT = 2;
  public static final int HTTP_METHOD_TRACE;
  public static final int LAST_CODE = 7;
  public static final int VERSION_CODE = 2;
  public final byte[] body;
  public final int httpMethod;
  public final String returnType;
  public final long timeoutMillis;
  public int versionCode;
  public Bundle zzebn;
  
  static
  {
    HTTP_METHOD_DELETE = 3;
    HTTP_METHOD_HEAD = 4;
    HTTP_METHOD_OPTIONS = 5;
    HTTP_METHOD_TRACE = 6;
  }
  
  public ProxyRequest(int paramInt1, String paramString, int paramInt2, long paramLong, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    versionCode = paramInt1;
    returnType = paramString;
    httpMethod = paramInt2;
    timeoutMillis = paramLong;
    body = paramArrayOfByte;
    zzebn = paramBundle;
  }
  
  public Map getHeaderMap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(zzebn.size());
    Iterator localIterator = zzebn.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedHashMap.put(str, zzebn.getString(str));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  public String toString()
  {
    String str = returnType;
    int i = httpMethod;
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, 42));
    localStringBuilder.append("ProxyRequest[ url: ");
    localStringBuilder.append(str);
    localStringBuilder.append(", method: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 1, returnType, false);
    zzbcn.setCustomVar(paramParcel, 2, httpMethod);
    zzbcn.writeHeader(paramParcel, 3, timeoutMillis);
    zzbcn.writeString(paramParcel, 4, body, false);
    zzbcn.writeString(paramParcel, 5, zzebn, false);
    zzbcn.setCustomVar(paramParcel, 1000, versionCode);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  @KeepForSdkWithMembers
  public class Builder
  {
    public long zzcwo = 3000L;
    public int zzebp = ProxyRequest.HTTP_METHOD_GET;
    public byte[] zzebq = null;
    public Bundle zzebr = new Bundle();
    
    public Builder()
    {
      zzbp.zzgg(ProxyRequest.this);
      if (Patterns.WEB_URL.matcher(ProxyRequest.this).matches()) {
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(ProxyRequest.this, 51), "The supplied url [ ", ProxyRequest.this, "] is not match Patterns.WEB_URL!"));
    }
    
    public ProxyRequest build()
    {
      if (zzebq == null) {
        zzebq = new byte[0];
      }
      return new ProxyRequest(2, ProxyRequest.this, zzebp, zzcwo, zzebq, zzebr);
    }
    
    public Builder putHeader(String paramString1, String paramString2)
    {
      zzbp.format(paramString1, "Header name cannot be null or empty!");
      Bundle localBundle = zzebr;
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localBundle.putString(paramString1, str);
      return this;
    }
    
    public Builder setBody(byte[] paramArrayOfByte)
    {
      zzebq = paramArrayOfByte;
      return this;
    }
    
    public Builder setHttpMethod(int paramInt)
    {
      boolean bool;
      if ((paramInt >= 0) && (paramInt <= ProxyRequest.LAST_CODE)) {
        bool = true;
      } else {
        bool = false;
      }
      zzbp.get(bool, "Unrecognized http method code.");
      zzebp = paramInt;
      return this;
    }
    
    public Builder setTimeoutMillis(long paramLong)
    {
      boolean bool;
      if (paramLong >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      zzbp.get(bool, "The specified timeout must be non-negative.");
      zzcwo = paramLong;
      return this;
    }
  }
}
