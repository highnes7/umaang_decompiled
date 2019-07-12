package com.google.android.android.internal;

import com.google.android.gms.internal.zzewn;
import com.google.android.gms.internal.zzewp;
import java.io.IOException;

public final class zzevr
  extends com.google.android.gms.internal.zzevh<com.google.android.gms.internal.zzevr, com.google.android.gms.internal.zzevr.zza>
  implements zzewn
{
  public static volatile zzewp<com.google.android.gms.internal.zzevr> zzbar;
  public static final zzevr zzopb;
  public int zzopa;
  
  static
  {
    zzevr localZzevr = new zzevr();
    zzopb = localZzevr;
    localZzevr.truncate(zzevp.zzoor, null, null);
    zzooe.zzbhs();
  }
  
  public zzevr() {}
  
  private final void setValue(int paramInt)
  {
    zzopa = paramInt;
  }
  
  public static zza zzcui()
  {
    zzevr localZzevr = zzopb;
    zzevi localZzevi = (zzevi)localZzevr.truncate(zzevp.zzoot, null, null);
    localZzevi.cast(localZzevr);
    return (zza)localZzevi;
  }
  
  public static zzevr zzcuj()
  {
    return zzopb;
  }
  
  public final int getValue()
  {
    return zzopa;
  }
  
  public final Object truncate(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject = zzevs.zzbap;
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
            zzbar = new zzevj(zzopb);
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
          break label302;
        }
        try
        {
          int i = paramObject1.zzcsn();
          if (i != 0) {
            if (i != 8)
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
              i = paramObject1.zzcsq();
              zzopa = i;
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
      return zzopb;
    case 5: 
      paramObject1 = (zzevq)paramObject1;
      paramObject2 = (zzevr)paramObject2;
      if (zzopa != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramInt = zzopa;
      if (zzopa == 0) {
        bool2 = false;
      }
      zzopa = paramObject1.truncate(bool1, paramInt, bool2, zzopa);
      return this;
    case 4: 
      return new zza(null);
    case 3: 
      return null;
    case 2: 
      label302:
      return zzopb;
    }
    return new zzevr();
  }
  
  public final void writeTo(zzeuy paramZzeuy)
    throws IOException
  {
    int i = zzopa;
    if (i != 0) {
      paramZzeuy.Refresh(1, i);
    }
    zzooe.writeTo(paramZzeuy);
  }
  
  public final int zzhi()
  {
    int i = zzoof;
    if (i != -1) {
      return i;
    }
    int j = zzopa;
    i = 0;
    if (j != 0) {
      i = 0 + zzeuy.zzaa(1, j);
    }
    i = zzooe.zzhi() + i;
    zzoof = i;
    return i;
  }
  
  public final class zza
    extends com.google.android.gms.internal.zzevi<com.google.android.gms.internal.zzevr, com.google.android.gms.internal.zzevr.zza>
    implements zzewn
  {
    public zza()
    {
      super();
    }
    
    public final zza zzkn(int paramInt)
    {
      zzcud();
      zzevr.showNote((zzevr)zzooh, paramInt);
      return this;
    }
  }
}
