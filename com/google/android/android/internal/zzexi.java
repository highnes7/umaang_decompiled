package com.google.android.android.internal;

import com.google.android.gms.internal.zzewn;
import com.google.android.gms.internal.zzewp;
import java.io.IOException;

public final class zzexi
  extends com.google.android.gms.internal.zzevh<com.google.android.gms.internal.zzexi, com.google.android.gms.internal.zzexi.zza>
  implements zzewn
{
  public static volatile zzewp<com.google.android.gms.internal.zzexi> zzbar;
  public static final zzexi zzoqw;
  public long zzoqu;
  public int zzoqv;
  
  static
  {
    zzexi localZzexi = new zzexi();
    zzoqw = localZzexi;
    localZzexi.truncate(zzevp.zzoor, null, null);
    zzooe.zzbhs();
  }
  
  public zzexi() {}
  
  private final void setNanos(int paramInt)
  {
    zzoqv = paramInt;
  }
  
  public static zza zzcvl()
  {
    zzexi localZzexi = zzoqw;
    zzevi localZzevi = (zzevi)localZzexi.truncate(zzevp.zzoot, null, null);
    localZzevi.cast(localZzexi);
    return (zza)localZzevi;
  }
  
  public static zzexi zzcvm()
  {
    return zzoqw;
  }
  
  private final void zzdd(long paramLong)
  {
    zzoqu = paramLong;
  }
  
  public final int getNanos()
  {
    return zzoqv;
  }
  
  public final Object truncate(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject = zzexj.zzbap;
    boolean bool3 = true;
    boolean bool1;
    long l;
    switch (localObject[(paramInt - 1)])
    {
    default: 
      throw new UnsupportedOperationException();
    case 8: 
      if (zzbar == null) {
        try
        {
          if (zzbar == null) {
            zzbar = new zzevj(zzoqw);
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
          break label324;
        }
        try
        {
          int i = paramObject1.zzcsn();
          if (i != 0) {
            if (i != 8)
            {
              if (i != 16)
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
                zzoqv = i;
              }
            }
            else
            {
              l = paramObject1.zzcsp();
              zzoqu = l;
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
      return zzoqw;
    case 5: 
      paramObject1 = (zzevq)paramObject1;
      paramObject2 = (zzexi)paramObject2;
      if (zzoqu != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      l = zzoqu;
      boolean bool2;
      if (zzoqu != 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      zzoqu = paramObject1.truncate(bool1, l, bool2, zzoqu);
      if (zzoqv != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramInt = zzoqv;
      if (zzoqv != 0) {
        bool2 = bool3;
      } else {
        bool2 = false;
      }
      zzoqv = paramObject1.truncate(bool1, paramInt, bool2, zzoqv);
      return this;
    case 4: 
      return new zza(null);
    case 3: 
      return null;
    case 2: 
      label324:
      return zzoqw;
    }
    return new zzexi();
  }
  
  public final void writeTo(zzeuy paramZzeuy)
    throws IOException
  {
    long l = zzoqu;
    if (l != 0L) {
      paramZzeuy.writeLong(1, l);
    }
    int i = zzoqv;
    if (i != 0) {
      paramZzeuy.Refresh(2, i);
    }
    zzooe.writeTo(paramZzeuy);
  }
  
  public final long zzcca()
  {
    return zzoqu;
  }
  
  public final int zzhi()
  {
    int i = zzoof;
    if (i != -1) {
      return i;
    }
    long l = zzoqu;
    i = 0;
    if (l != 0L) {
      i = 0 + zzeuy.Refresh(1, l);
    }
    int k = zzoqv;
    int j = i;
    if (k != 0) {
      j = i + zzeuy.zzaa(2, k);
    }
    i = zzooe.zzhi() + j;
    zzoof = i;
    return i;
  }
  
  public final class zza
    extends com.google.android.gms.internal.zzevi<com.google.android.gms.internal.zzexi, com.google.android.gms.internal.zzexi.zza>
    implements zzewn
  {
    public zza()
    {
      super();
    }
    
    public final zza zzde(long paramLong)
    {
      zzcud();
      zzexi.parseSequence((zzexi)zzooh, paramLong);
      return this;
    }
    
    public final zza zzkx(int paramInt)
    {
      zzcud();
      zzexi.showNote((zzexi)zzooh, paramInt);
      return this;
    }
  }
}
