package com.google.android.android.internal;

import com.google.android.gms.internal.zzeud;
import java.io.IOException;

public class zzevi<MessageType extends com.google.android.gms.internal.zzevh<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.zzevi<MessageType, BuilderType>>
  extends zzeud<MessageType, BuilderType>
{
  public final MessageType zzoog;
  public MessageType zzooh;
  public boolean zzooi;
  
  public zzevi(zzevh paramZzevh)
  {
    zzoog = paramZzevh;
    zzooh = ((zzevh)paramZzevh.truncate(zzevp.zzoos, null, null));
    zzooi = false;
  }
  
  private final zzevi createClient(zzeut paramZzeut, zzevd paramZzevd)
    throws IOException
  {
    zzcud();
    try
    {
      zzevh localZzevh = zzooh;
      int i = zzevp.zzooq;
      localZzevh.truncate(i, paramZzeut, paramZzevd);
      return this;
    }
    catch (RuntimeException paramZzeut)
    {
      if ((paramZzeut.getCause() instanceof IOException)) {
        throw ((IOException)paramZzeut.getCause());
      }
      throw paramZzeut;
    }
  }
  
  public static void truncate(zzevh paramZzevh1, zzevh paramZzevh2)
  {
    zzevo localZzevo = zzevo.zzoon;
    paramZzevh1.truncate(zzevp.zzoop, localZzevo, paramZzevh2);
    zzooe = localZzevo.truncate(zzooe, zzooe);
  }
  
  public final zzevi cast(zzevh paramZzevh)
  {
    zzcud();
    truncate(zzooh, paramZzevh);
    return this;
  }
  
  public final boolean isInitialized()
  {
    return zzooh.truncate(zzevp.zzooo, Boolean.valueOf(false), null) != null;
  }
  
  public final void zzcud()
  {
    if (zzooi)
    {
      zzevh localZzevh = (zzevh)zzooh.truncate(zzevp.zzoos, null, null);
      truncate(localZzevh, zzooh);
      zzooh = localZzevh;
      zzooi = false;
    }
  }
  
  public final zzevh zzcue()
  {
    if (zzooi) {
      return zzooh;
    }
    zzevh localZzevh = zzooh;
    localZzevh.truncate(zzevp.zzoor, null, null);
    zzooe.zzbhs();
    zzooi = true;
    return zzooh;
  }
  
  public final zzevh zzcuf()
  {
    boolean bool = zzooi;
    int i = 1;
    if (!bool)
    {
      localZzevh = zzooh;
      localZzevh.truncate(zzevp.zzoor, null, null);
      zzooe.zzbhs();
      zzooi = true;
    }
    zzevh localZzevh = zzooh;
    if (localZzevh.truncate(zzevp.zzooo, Boolean.TRUE, null) == null) {
      i = 0;
    }
    if (i != 0) {
      return localZzevh;
    }
    throw new zzexk(localZzevh);
  }
}
