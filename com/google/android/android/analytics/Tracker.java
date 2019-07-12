package com.google.android.android.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import com.google.android.android.internal.zzalv;
import com.google.android.android.internal.zzamr;
import com.google.android.android.internal.zzams;
import com.google.android.android.internal.zzamu;
import com.google.android.android.internal.zzanf;
import com.google.android.android.internal.zzanm;
import com.google.android.android.internal.zzanz;
import com.google.android.android.internal.zzaol;
import com.google.android.android.internal.zzaon;
import com.google.android.android.internal.zzapc;
import com.google.android.android.internal.zzapd;
import com.google.android.android.internal.zzape;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Tracker
  extends zzams
{
  public final Map<String, String> zzbqm = new HashMap();
  public boolean zzdli;
  public final Map<String, String> zzdlj = new HashMap();
  public final zzaol zzdlk;
  public final zza zzdll;
  public ExceptionReporter zzdlm;
  public zzapc zzdln;
  
  public Tracker(zzamu paramZzamu, String paramString, zzaol paramZzaol)
  {
    super(paramZzamu);
    if (paramString != null) {
      zzbqm.put("&tid", paramString);
    }
    zzbqm.put("useSecure", "1");
    zzbqm.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
    zzdlk = new zzaol(60, 2000L, "tracking", zzvx());
    zzdll = new zza(paramZzamu);
  }
  
  public static void add(Map paramMap1, Map paramMap2)
  {
    zzbp.append(paramMap2);
    if (paramMap1 == null) {
      return;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      String str = getValue(localEntry);
      if ((str != null) && (!paramMap2.containsKey(str))) {
        paramMap2.put(str, (String)localEntry.getValue());
      }
    }
  }
  
  public static String getValue(Map.Entry paramEntry)
  {
    String str = (String)paramEntry.getKey();
    int i;
    if ((str.startsWith("&")) && (str.length() >= 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    return ((String)paramEntry.getKey()).substring(1);
  }
  
  public static void send(Map paramMap1, Map paramMap2)
  {
    zzbp.append(paramMap2);
    if (paramMap1 == null) {
      return;
    }
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap1.next();
      String str = getValue(localEntry);
      if (str != null) {
        paramMap2.put(str, (String)localEntry.getValue());
      }
    }
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    zzdli = paramBoolean;
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    zzdll.enableAutoActivityTracking(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (zzdlm != null)
        {
          bool = true;
          if (bool == paramBoolean) {
            return;
          }
          Object localObject;
          if (paramBoolean)
          {
            localObject = getContext();
            zzdlm = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), (Context)localObject);
            Thread.setDefaultUncaughtExceptionHandler(zzdlm);
            localObject = "Uncaught exceptions will be reported to Google Analytics";
            zzdm((String)localObject);
          }
          else
          {
            Thread.setDefaultUncaughtExceptionHandler(zzdlm.zztv());
            localObject = "Uncaught exceptions will not be reported to Google Analytics";
            continue;
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public String getValue(String paramString)
  {
    zzwk();
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (zzbqm.containsKey(paramString)) {
      return (String)zzbqm.get(paramString);
    }
    if (paramString.equals("&ul")) {
      return zzapd.query(Locale.getDefault());
    }
    if (paramString.equals("&cid")) {
      return zzwg().zzxp();
    }
    if (paramString.equals("&sr")) {
      return zzwj().zzyi();
    }
    if (paramString.equals("&aid")) {
      return zzwi().zzxd().getAppId();
    }
    if (paramString.equals("&an")) {
      return zzwi().zzxd().zzun();
    }
    if (paramString.equals("&av")) {
      return zzwi().zzxd().zzuo();
    }
    if (paramString.equals("&aiid")) {
      return zzwi().zzxd().zzup();
    }
    return null;
  }
  
  public void put(String paramString1, String paramString2)
  {
    zzbp.get(paramString1, "Key should be non-null");
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    zzbqm.put(paramString1, paramString2);
  }
  
  public void send(Map paramMap)
  {
    long l = zzvx().currentTimeMillis();
    if (zzwb().getAppOptOut())
    {
      zzdn("AppOptOut is set to true. Not sending Google Analytics hit");
      return;
    }
    boolean bool1 = zzwb().isDryRunEnabled();
    HashMap localHashMap = new HashMap();
    send(zzbqm, localHashMap);
    send(paramMap, localHashMap);
    boolean bool2 = zzapd.getBoolean((String)zzbqm.get("useSecure"), true);
    add(zzdlj, localHashMap);
    zzdlj.clear();
    paramMap = (String)localHashMap.get("t");
    if (TextUtils.isEmpty(paramMap))
    {
      zzvy().write(localHashMap, "Missing hit type parameter");
      return;
    }
    String str = (String)localHashMap.get("tid");
    if (TextUtils.isEmpty(str))
    {
      zzvy().write(localHashMap, "Missing tracking id parameter");
      return;
    }
    boolean bool3 = zzdli;
    try
    {
      if (("screenview".equalsIgnoreCase(paramMap)) || ("pageview".equalsIgnoreCase(paramMap)) || ("appview".equalsIgnoreCase(paramMap)) || (TextUtils.isEmpty(paramMap)))
      {
        int j = Integer.parseInt((String)zzbqm.get("&a")) + 1;
        int i = j;
        if (j >= Integer.MAX_VALUE) {
          i = 1;
        }
        zzbqm.put("&a", Integer.toString(i));
      }
      zzwa().d(new Marker.1(this, localHashMap, bool3, paramMap, l, bool1, bool2, str));
      return;
    }
    catch (Throwable paramMap)
    {
      throw paramMap;
    }
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    put("&aip", zzapd.zzaj(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    put("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    put("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    put("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    put("&av", paramString);
  }
  
  public void setCampaignParamsOnNextHit(Uri paramUri)
  {
    if (paramUri != null)
    {
      if (paramUri.isOpaque()) {
        return;
      }
      paramUri = paramUri.getQueryParameter("referrer");
      if (TextUtils.isEmpty(paramUri)) {
        return;
      }
      paramUri = String.valueOf(paramUri);
      if (paramUri.length() != 0) {
        paramUri = "http://hostname/?".concat(paramUri);
      } else {
        paramUri = new String("http://hostname/?");
      }
      paramUri = Uri.parse(paramUri);
      String str = paramUri.getQueryParameter("utm_id");
      if (str != null) {
        zzdlj.put("&ci", str);
      }
      str = paramUri.getQueryParameter("anid");
      if (str != null) {
        zzdlj.put("&anid", str);
      }
      str = paramUri.getQueryParameter("utm_campaign");
      if (str != null) {
        zzdlj.put("&cn", str);
      }
      str = paramUri.getQueryParameter("utm_content");
      if (str != null) {
        zzdlj.put("&cc", str);
      }
      str = paramUri.getQueryParameter("utm_medium");
      if (str != null) {
        zzdlj.put("&cm", str);
      }
      str = paramUri.getQueryParameter("utm_source");
      if (str != null) {
        zzdlj.put("&cs", str);
      }
      str = paramUri.getQueryParameter("utm_term");
      if (str != null) {
        zzdlj.put("&ck", str);
      }
      str = paramUri.getQueryParameter("dclid");
      if (str != null) {
        zzdlj.put("&dclid", str);
      }
      str = paramUri.getQueryParameter("gclid");
      if (str != null) {
        zzdlj.put("&gclid", str);
      }
      paramUri = paramUri.getQueryParameter("aclid");
      if (paramUri != null) {
        zzdlj.put("&aclid", paramUri);
      }
    }
  }
  
  public void setClientId(String paramString)
  {
    put("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    put("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    put("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    put("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    put("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    put("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    put("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    put("&sf", Double.toString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    put("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    put("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt2 < 0))
    {
      zzdp("Invalid width or height. The values should be non-negative.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(23);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    put("&sr", localStringBuilder.toString());
  }
  
  public void setSessionTimeout(long paramLong)
  {
    zzdll.setSessionTimeout(paramLong * 1000L);
  }
  
  public void setTitle(String paramString)
  {
    put("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    put("useSecure", zzapd.zzaj(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    put("&vp", paramString);
  }
  
  public final void track(zzapc paramZzapc)
  {
    zzdm("Loading Tracker config values");
    zzdln = paramZzapc;
    paramZzapc = zzdln.zzdjo;
    boolean bool2 = false;
    if (paramZzapc != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramZzapc = zzdln.zzdjo;
      put("&tid", paramZzapc);
      d("trackingId loaded", paramZzapc);
    }
    if (zzdln.zzdug >= 0.0D) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramZzapc = Double.toString(zzdln.zzdug);
      put("&sf", paramZzapc);
      d("Sample frequency loaded", paramZzapc);
    }
    if (zzdln.zzduh >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = zzdln.zzduh;
      setSessionTimeout(i);
      d("Session timeout loaded", Integer.valueOf(i));
    }
    int i = zzdln.zzdui;
    if (i != -1)
    {
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      enableAutoActivityTracking(bool1);
      d("Auto activity tracking loaded", Boolean.valueOf(bool1));
    }
    i = zzdln.zzduj;
    if (i != -1)
    {
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        put("&aip", "1");
      }
      d("Anonymize ip loaded", Boolean.valueOf(bool1));
    }
    boolean bool1 = bool2;
    if (zzdln.zzduk == 1) {
      bool1 = true;
    }
    enableExceptionReporting(bool1);
  }
  
  public final void zzuk()
  {
    zzdll.initialize();
    String str = zzwe().zzun();
    if (str != null) {
      put("&an", str);
    }
    str = zzwe().zzuo();
    if (str != null) {
      put("&av", str);
    }
  }
  
  public final class zza
    extends zzams
    implements GoogleAnalytics.zza
  {
    public boolean zzdlw;
    public int zzdlx;
    public long zzdly = -1L;
    public boolean zzdlz;
    public long zzdma;
    
    public zza(zzamu paramZzamu)
    {
      super();
    }
    
    private final void zzum()
    {
      if ((zzdly < 0L) && (!zzdlw))
      {
        zzwb().closeTracker(zzdll);
        return;
      }
      zzwb().getInstance(zzdll);
    }
    
    public final void enableAutoActivityTracking(boolean paramBoolean)
    {
      zzdlw = paramBoolean;
      zzum();
    }
    
    public final void setSessionTimeout(long paramLong)
    {
      zzdly = paramLong;
      zzum();
    }
    
    public final void update(Activity paramActivity)
    {
      if (zzdlx == 0)
      {
        long l1 = zzvx().elapsedRealtime();
        long l2 = zzdma;
        int i;
        if (l1 >= Math.max(1000L, zzdly) + l2) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          zzdlz = true;
        }
      }
      zzdlx += 1;
      if (zzdlw)
      {
        Object localObject = paramActivity.getIntent();
        if (localObject != null) {
          setCampaignParamsOnNextHit(((Intent)localObject).getData());
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("&t", "screenview");
        Tracker localTracker = Tracker.this;
        zzapc localZzapc = zzdln;
        if (localZzapc != null)
        {
          String str = paramActivity.getClass().getCanonicalName();
          localObject = str;
          str = (String)zzdul.get(str);
          if (str != null) {
            localObject = str;
          }
        }
        else
        {
          localObject = paramActivity.getClass().getCanonicalName();
        }
        localTracker.put("&cd", (String)localObject);
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&dr")))
        {
          zzbp.append(paramActivity);
          localObject = paramActivity.getIntent();
          paramActivity = null;
          if (localObject != null)
          {
            localObject = ((Intent)localObject).getStringExtra("android.intent.extra.REFERRER_NAME");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramActivity = (Activity)localObject;
            }
          }
          if (!TextUtils.isEmpty(paramActivity)) {
            localHashMap.put("&dr", paramActivity);
          }
        }
        send(localHashMap);
      }
    }
    
    public final void xor(Activity paramActivity)
    {
      zzdlx -= 1;
      zzdlx = Math.max(0, zzdlx);
      if (zzdlx == 0) {
        zzdma = zzvx().elapsedRealtime();
      }
    }
    
    public final void zzuk() {}
    
    public final boolean zzul()
    {
      try
      {
        boolean bool = zzdlz;
        zzdlz = false;
        return bool;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
}
