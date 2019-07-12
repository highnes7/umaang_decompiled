package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class Contact
  extends zzbr
{
  public static final String prefix = zzbd.zzhk.toString();
  public final Context mContext;
  
  public Contact(Context paramContext)
  {
    super(prefix, new String[0]);
    mContext = paramContext;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    return zzgk.zzah(mContext.getPackageName());
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
