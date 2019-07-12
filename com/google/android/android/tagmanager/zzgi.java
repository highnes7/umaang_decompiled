package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbp;
import java.util.Map;

public abstract class zzgi
  extends zzbr
{
  public zzgi(String paramString, String... paramVarArgs)
  {
    super(paramString, paramVarArgs);
  }
  
  public abstract void doInBackground(Map paramMap);
  
  public zzbp evaluate(Map paramMap)
  {
    doInBackground(paramMap);
    return zzgk.zzjwp;
  }
  
  public boolean zzbcj()
  {
    return false;
  }
}
