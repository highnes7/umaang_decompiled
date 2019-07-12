package com.google.android.android.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.internal.zzbvm;
import com.google.android.gms.common.util.DynamiteApi;

@DynamiteApi
public class FlagProviderImpl
  extends zzbvm
{
  public boolean zzaqf = false;
  public SharedPreferences zzbfl;
  
  public FlagProviderImpl() {}
  
  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!zzaqf) {
      return paramBoolean;
    }
    return OperatorSwitch.call(zzbfl, paramString, Boolean.valueOf(paramBoolean)).booleanValue();
  }
  
  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
  {
    if (!zzaqf) {
      return paramInt1;
    }
    return InjectorImpl.2.1.call(zzbfl, paramString, Integer.valueOf(paramInt1)).intValue();
  }
  
  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
  {
    if (!zzaqf) {
      return paramLong;
    }
    return Observable.CountLongHolder.1.call(zzbfl, paramString, Long.valueOf(paramLong)).longValue();
  }
  
  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
  {
    if (!zzaqf) {
      return paramString2;
    }
    return HttpUnsuccessfulResponseHandler.handleResponse(zzbfl, paramString1, paramString2);
  }
  
  public void init(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (Context)com.google.android.android.dynamic.Integer.get(paramIObjectWrapper);
    if (zzaqf) {
      return;
    }
    try
    {
      paramIObjectWrapper = IpAddress.zzcy(paramIObjectWrapper.createPackageContext("com.google.android.gms", 0));
      zzbfl = paramIObjectWrapper;
      zzaqf = true;
      return;
    }
    catch (Exception paramIObjectWrapper)
    {
      paramIObjectWrapper = String.valueOf(paramIObjectWrapper.getMessage());
      if (paramIObjectWrapper.length() != 0)
      {
        "Could not retrieve sdk flags, continuing with defaults: ".concat(paramIObjectWrapper);
        return;
      }
      new String("Could not retrieve sdk flags, continuing with defaults: ");
      return;
    }
    catch (PackageManager.NameNotFoundException paramIObjectWrapper) {}
  }
}
