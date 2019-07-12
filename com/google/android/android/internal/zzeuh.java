package com.google.android.android.internal;

import com.google.android.gms.internal.zzewn;
import com.google.android.gms.internal.zzewp;
import java.io.IOException;

public final class zzeuh
  extends com.google.android.gms.internal.zzevh<com.google.android.gms.internal.zzeuh, com.google.android.gms.internal.zzeuh.zza>
  implements zzewn
{
  public static volatile zzewp<com.google.android.gms.internal.zzeuh> zzbar;
  public static final zzeuh zzomw;
  public String zzlek = "";
  public zzeuk zzlel = zzeuk.zzomx;
  
  static
  {
    zzeuh localZzeuh = new zzeuh();
    zzomw = localZzeuh;
    localZzeuh.truncate(zzevp.zzoor, null, null);
    zzooe.zzbhs();
  }
  
  public zzeuh() {}
  
  public static zzeuh zzcse()
  {
    return zzomw;
  }
  
  public final Object truncate(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject = zzeui.zzbap;
    boolean bool2 = true;
    boolean bool1;
    switch (localObject[(paramInt - 1)])
    {
    default: 
      throw new UnsupportedOperationException();
    case 8: 
      if (zzbar == null) {
        try
        {
          if (zzbar == null) {
            zzbar = new zzevj(zzomw);
          }
        }
        catch (Throwable paramObject1)
        {
          throw paramObject1;
        }
      }
      return zzbar;
    case 6: 
      paramObject1 = (zzeut)paramObject1;
      paramInt = 0;
      for (;;)
      {
        if (paramInt != 0) {
          break label320;
        }
        try
        {
          int i = paramObject1.zzcsn();
          if (i != 0) {
            if (i != 10)
            {
              if (i != 18)
              {
                if ((i & 0x7) == 4)
                {
                  bool1 = false;
                }
                else
                {
                  paramObject2 = zzooe;
                  localObject = zzexl.zzoqy;
                  if (paramObject2 == localObject)
                  {
                    paramObject2 = new zzexl();
                    zzooe = paramObject2;
                  }
                  paramObject2 = zzooe;
                  bool1 = paramObject2.next(i, paramObject1);
                }
                if (bool1) {
                  continue;
                }
              }
              else
              {
                paramObject2 = paramObject1.zzcsv();
                zzlel = paramObject2;
              }
            }
            else
            {
              paramObject2 = paramObject1.zzcsu();
              zzlek = paramObject2;
              continue;
            }
          }
          paramInt = 1;
        }
        catch (Throwable paramObject1) {}catch (IOException paramObject1)
        {
          throw new RuntimeException(new zzevz(paramObject1.getMessage()).filter(this));
        }
        catch (zzevz paramObject1)
        {
          throw new RuntimeException(paramObject1.filter(this));
        }
      }
      throw paramObject1;
    case 7: 
      return zzomw;
    case 5: 
      paramObject1 = (zzevq)paramObject1;
      paramObject2 = (zzeuh)paramObject2;
      zzlek = paramObject1.truncate(zzlek.isEmpty() ^ true, zzlek, zzlek.isEmpty() ^ true, zzlek);
      if (zzlel != zzeuk.zzomx) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = zzlel;
      if (zzlel == zzeuk.zzomx) {
        bool2 = false;
      }
      zzlel = paramObject1.truncate(bool1, (zzeuk)localObject, bool2, zzlel);
      return this;
    case 4: 
      return new zza(null);
    case 3: 
      return null;
    case 2: 
      label320:
      return zzomw;
    }
    return new zzeuh();
  }
  
  public final void writeTo(zzeuy paramZzeuy)
    throws IOException
  {
    if (!zzlek.isEmpty()) {
      paramZzeuy.writeInt32(1, zzlek);
    }
    if (!zzlel.isEmpty()) {
      paramZzeuy.writeInt32(2, zzlel);
    }
    zzooe.writeTo(paramZzeuy);
  }
  
  public final int zzhi()
  {
    int i = zzoof;
    if (i != -1) {
      return i;
    }
    boolean bool = zzlek.isEmpty();
    i = 0;
    if (!bool) {
      i = 0 + zzeuy.Refresh(1, zzlek);
    }
    int j = i;
    if (!zzlel.isEmpty()) {
      j = i + zzeuy.getShares(2, zzlel);
    }
    i = zzooe.zzhi() + j;
    zzoof = i;
    return i;
  }
  
  public final class zza
    extends com.google.android.gms.internal.zzevi<com.google.android.gms.internal.zzeuh, com.google.android.gms.internal.zzeuh.zza>
    implements zzewn
  {
    public zza()
    {
      super();
    }
  }
}
