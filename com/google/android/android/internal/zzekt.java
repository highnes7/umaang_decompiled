package com.google.android.android.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import f.g.d.d;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzekt
{
  public static final AtomicReference<com.google.android.gms.internal.zzekt> zzliq = new AtomicReference();
  
  public zzekt(Context paramContext) {}
  
  public static void access$getShowSoftKeyboard(FirebaseApp paramFirebaseApp) {}
  
  public static zzekt zzcgg()
  {
    return (zzekt)zzliq.get();
  }
  
  public static Set zzcgh()
  {
    return Collections.emptySet();
  }
  
  public static zzekt zzep(Context paramContext)
  {
    zzliq.compareAndSet(null, new zzekt(paramContext));
    return (zzekt)zzliq.get();
  }
  
  public static d zzrh(String paramString)
  {
    return null;
  }
}
