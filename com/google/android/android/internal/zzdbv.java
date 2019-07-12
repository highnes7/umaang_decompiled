package com.google.android.android.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzdbv
{
  public final List<com.google.android.gms.internal.zzdbq> zzkee = new ArrayList();
  public final List<com.google.android.gms.internal.zzdbq> zzkef = new ArrayList();
  public final List<com.google.android.gms.internal.zzdbq> zzkeg = new ArrayList();
  public final List<com.google.android.gms.internal.zzdbq> zzkeh = new ArrayList();
  public final List<com.google.android.gms.internal.zzdbq> zzkfm = new ArrayList();
  public final List<com.google.android.gms.internal.zzdbq> zzkfn = new ArrayList();
  public final List<String> zzkfo = new ArrayList();
  public final List<String> zzkfp = new ArrayList();
  public final List<String> zzkfq = new ArrayList();
  public final List<String> zzkfr = new ArrayList();
  
  public zzdbv() {}
  
  public final zzdbv addUrls(zzdbq paramZzdbq)
  {
    zzkeg.add(paramZzdbq);
    return this;
  }
  
  public final zzdbv command(zzdbq paramZzdbq)
  {
    zzkfm.add(paramZzdbq);
    return this;
  }
  
  public final zzdbv delete(zzdbq paramZzdbq)
  {
    zzkee.add(paramZzdbq);
    return this;
  }
  
  public final zzdbv exists(zzdbq paramZzdbq)
  {
    zzkfn.add(paramZzdbq);
    return this;
  }
  
  public final zzdbv join(zzdbq paramZzdbq)
  {
    zzkef.add(paramZzdbq);
    return this;
  }
  
  public final zzdbv set(zzdbq paramZzdbq)
  {
    zzkeh.add(paramZzdbq);
    return this;
  }
  
  public final zzdbu zzbic()
  {
    return new zzdbu(zzkee, zzkef, zzkeg, zzkeh, zzkfm, zzkfn, zzkfo, zzkfp, zzkfq, zzkfr);
  }
  
  public final zzdbv zznl(String paramString)
  {
    zzkfq.add(paramString);
    return this;
  }
  
  public final zzdbv zznm(String paramString)
  {
    zzkfr.add(paramString);
    return this;
  }
  
  public final zzdbv zznn(String paramString)
  {
    zzkfo.add(paramString);
    return this;
  }
  
  public final zzdbv zzno(String paramString)
  {
    zzkfp.add(paramString);
    return this;
  }
}
