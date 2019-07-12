package com.google.android.android.internal;

import com.google.android.gms.internal.zzewn;
import com.google.android.gms.internal.zzewp;
import java.io.IOException;
import java.util.List;

public final class zzezb
  extends com.google.android.gms.internal.zzevh<com.google.android.gms.internal.zzezb, com.google.android.gms.internal.zzezb.zza>
  implements zzewn
{
  public static volatile zzewp<com.google.android.gms.internal.zzezb> zzbar;
  public static final zzezb zzovw;
  public int zzlfc;
  public int zzovt;
  public String zzovu = "";
  public com.google.android.gms.internal.zzevy<com.google.android.gms.internal.zzeuh> zzovv = zzewr.zzopr;
  
  static
  {
    zzezb localZzezb = new zzezb();
    zzovw = localZzezb;
    localZzezb.truncate(zzevp.zzoor, null, null);
    zzooe.zzbhs();
  }
  
  public zzezb() {}
  
  public static zzezb zzcwj()
  {
    return zzovw;
  }
  
  public final int getCode()
  {
    return zzovt;
  }
  
  public final String getMessage()
  {
    return zzovu;
  }
  
  public final Object truncate(int paramInt, Object paramObject1, Object paramObject2)
  {
    int i = zzezc.zzbap[(paramInt - 1)];
    boolean bool2 = false;
    paramInt = 0;
    boolean bool1;
    Object localObject1;
    switch (i)
    {
    default: 
      throw new UnsupportedOperationException();
    case 8: 
      if (zzbar == null) {
        try
        {
          if (zzbar == null) {
            zzbar = new zzevj(zzovw);
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
      paramObject2 = (zzevd)paramObject2;
      for (;;)
      {
        if (paramInt != 0) {
          break label399;
        }
        try
        {
          i = paramObject1.zzcsn();
          if (i != 0) {
            if (i != 8)
            {
              if (i != 18)
              {
                if (i != 26)
                {
                  bool1 = next(i, paramObject1);
                  if (bool1) {
                    continue;
                  }
                }
                else
                {
                  localObject1 = zzovv;
                  bool1 = ((zzevy)localObject1).zzcsc();
                  if (!bool1)
                  {
                    localObject1 = zzovv;
                    i = ((List)localObject1).size();
                    if (i == 0) {
                      i = 10;
                    } else {
                      i <<= 1;
                    }
                    localObject1 = ((zzevy)localObject1).zzks(i);
                    zzovv = ((zzevy)localObject1);
                  }
                  localObject1 = zzovv;
                  Object localObject2 = zzeuh.zzomw;
                  localObject2 = paramObject1.items((zzevh)localObject2, paramObject2);
                  localObject2 = (zzeuh)localObject2;
                  ((List)localObject1).add(localObject2);
                }
              }
              else
              {
                localObject1 = paramObject1.zzcsu();
                zzovu = ((String)localObject1);
              }
            }
            else
            {
              i = paramObject1.zzcsq();
              zzovt = i;
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
      return zzovw;
    case 5: 
      localObject1 = (zzevq)paramObject1;
      paramObject2 = (zzezb)paramObject2;
      if (zzovt != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramInt = zzovt;
      if (zzovt != 0) {
        bool2 = true;
      }
      zzovt = ((zzevq)localObject1).truncate(bool1, paramInt, bool2, zzovt);
      zzovu = ((zzevq)localObject1).truncate(zzovu.isEmpty() ^ true, zzovu, true ^ zzovu.isEmpty(), zzovu);
      zzovv = ((zzevq)localObject1).decrypt(zzovv, zzovv);
      paramObject1 = this;
      if (localObject1 == zzevo.zzoon)
      {
        zzlfc |= zzlfc;
        return this;
      }
      break;
    case 4: 
      return new zza(null);
    case 3: 
      zzovv.zzbhs();
      return null;
    case 2: 
      return zzovw;
    case 1: 
      label399:
      paramObject1 = new zzezb();
    }
    return paramObject1;
  }
  
  public final void writeTo(zzeuy paramZzeuy)
    throws IOException
  {
    int i = zzovt;
    if (i != 0) {
      paramZzeuy.Refresh(1, i);
    }
    if (!zzovu.isEmpty()) {
      paramZzeuy.writeInt32(2, zzovu);
    }
    i = 0;
    while (i < zzovv.size())
    {
      paramZzeuy.writeMessage(3, (zzewl)zzovv.get(i));
      i += 1;
    }
    zzooe.writeTo(paramZzeuy);
  }
  
  public final int zzhi()
  {
    int i = zzoof;
    if (i != -1) {
      return i;
    }
    i = zzovt;
    int m = 0;
    if (i != 0) {
      i = zzeuy.zzaa(1, i) + 0;
    } else {
      i = 0;
    }
    int k = m;
    int j = i;
    if (!zzovu.isEmpty())
    {
      j = i + zzeuy.Refresh(2, zzovu);
      k = m;
    }
    while (k < zzovv.size())
    {
      j += zzeuy.getShares(3, (zzewl)zzovv.get(k));
      k += 1;
    }
    i = zzooe.zzhi() + j;
    zzoof = i;
    return i;
  }
  
  public final class zza
    extends com.google.android.gms.internal.zzevi<com.google.android.gms.internal.zzezb, com.google.android.gms.internal.zzezb.zza>
    implements zzewn
  {
    public zza()
    {
      super();
    }
  }
}
