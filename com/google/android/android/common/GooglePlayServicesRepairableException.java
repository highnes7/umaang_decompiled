package com.google.android.android.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException
  extends UserRecoverableException
{
  public final int zzdxr;
  
  public GooglePlayServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    zzdxr = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return zzdxr;
  }
}
