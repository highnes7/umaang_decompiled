package com.google.android.android.auth.dashclock.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.android.auth.dashclock.signin.GoogleSignInAccount;
import com.google.android.android.auth.dashclock.signin.GoogleSignInOptions;
import com.google.android.android.common.internal.zzbp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public final class Phrase
{
  public static final Lock zzedl = new ReentrantLock();
  public static Phrase zzedm;
  public final Lock zzedn = new ReentrantLock();
  public final SharedPreferences zzedo;
  
  public Phrase(Context paramContext)
  {
    zzedo = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  private final void add(String paramString1, String paramString2)
  {
    zzedn.lock();
    try
    {
      zzedo.edit().putString(paramString1, paramString2).apply();
      zzedn.unlock();
      return;
    }
    catch (Throwable paramString1)
    {
      zzedn.unlock();
      throw paramString1;
    }
  }
  
  public static String getURL(String paramString1, String paramString2)
  {
    int i = String.valueOf(paramString1).length();
    return StringBuilder.append(StringBuilder.append(paramString2, ":".length() + i), paramString1, ":", paramString2);
  }
  
  public static Phrase zzbl(Context paramContext)
  {
    zzbp.append(paramContext);
    zzedl.lock();
    try
    {
      Phrase localPhrase = zzedm;
      if (localPhrase == null) {
        zzedm = new Phrase(paramContext.getApplicationContext());
      }
      paramContext = zzedm;
      zzedl.unlock();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      zzedl.unlock();
      throw paramContext;
    }
  }
  
  private final GoogleSignInAccount zzep(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = zzer(getURL("googleSignInAccount", paramString));
    if (paramString != null) {}
    try
    {
      paramString = GoogleSignInAccount.zzem(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
    return null;
  }
  
  private final GoogleSignInOptions zzeq(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = zzer(getURL("googleSignInOptions", paramString));
    if (paramString != null) {}
    try
    {
      paramString = GoogleSignInOptions.zzen(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
    return null;
  }
  
  private final String zzer(String paramString)
  {
    zzedn.lock();
    try
    {
      paramString = zzedo.getString(paramString, null);
      zzedn.unlock();
      return paramString;
    }
    catch (Throwable paramString)
    {
      zzedn.unlock();
      throw paramString;
    }
  }
  
  private final void zzes(String paramString)
  {
    zzedn.lock();
    try
    {
      zzedo.edit().remove(paramString).apply();
      zzedn.unlock();
      return;
    }
    catch (Throwable paramString)
    {
      zzedn.unlock();
      throw paramString;
    }
  }
  
  public final void trim(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzbp.append(paramGoogleSignInAccount);
    zzbp.append(paramGoogleSignInOptions);
    add("defaultGoogleSignInAccount", paramGoogleSignInAccount.zzaae());
    zzbp.append(paramGoogleSignInAccount);
    zzbp.append(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zzaae();
    add(getURL("googleSignInAccount", str), paramGoogleSignInAccount.zzaaf());
    add(getURL("googleSignInOptions", str), paramGoogleSignInOptions.zzaai());
  }
  
  public final GoogleSignInAccount zzaas()
  {
    return zzep(zzer("defaultGoogleSignInAccount"));
  }
  
  public final GoogleSignInOptions zzaat()
  {
    return zzeq(zzer("defaultGoogleSignInAccount"));
  }
  
  public final void zzaau()
  {
    String str = zzer("defaultGoogleSignInAccount");
    zzes("defaultGoogleSignInAccount");
    if (!TextUtils.isEmpty(str))
    {
      zzes(getURL("googleSignInAccount", str));
      zzes(getURL("googleSignInOptions", str));
    }
  }
}
