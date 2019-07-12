package com.google.android.android.dynamite;

import android.content.Context;

public final class Directory
  implements Weather
{
  public Directory() {}
  
  public final int getLocation(Context paramContext, String paramString, boolean paramBoolean)
    throws DynamiteModule.zzc
  {
    return DynamiteModule.create(paramContext, paramString, paramBoolean);
  }
  
  public final int zzad(Context paramContext, String paramString)
  {
    return DynamiteModule.zzad(paramContext, paramString);
  }
}
