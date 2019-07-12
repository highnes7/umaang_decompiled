package com.google.android.android.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import com.google.android.android.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.android.measurement.AppMeasurement.EventInterceptor;
import com.google.android.android.measurement.AppMeasurement.zzb;
import com.google.android.android.tasks.Task;
import com.google.android.android.tasks.Tasks;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import support.android.v4.util.ArrayMap;

public final class zzcdw
  extends zzcdu
{
  public zzcej zziut;
  public AppMeasurement.EventInterceptor zziuu;
  public final Set<com.google.android.gms.measurement.AppMeasurement.OnEventListener> zziuv = new CopyOnWriteArraySet();
  public boolean zziuw;
  public final AtomicReference<String> zziux = new AtomicReference();
  
  public zzcdw(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  private final void add(String paramString1, String paramString2, long paramLong, Object paramObject)
  {
    zzauk().e(new zzcef(this, paramString1, paramString2, paramObject, paramLong));
  }
  
  private final void authorize(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    zzuj();
    zzwk();
    zzbp.append(paramConditionalUserProperty);
    zzbp.zzgg(mName);
    zzbp.zzgg(mOrigin);
    zzbp.append(mValue);
    if (!zziki.isEnabled())
    {
      zzaul().zzayi().append("Conditional property not sent since Firebase Analytics is disabled");
      return;
    }
    zzcft localZzcft = new zzcft(mName, mTriggeredTimestamp, mValue, mOrigin);
    try
    {
      Object localObject1 = zzauh();
      Object localObject2 = mTriggeredEventName;
      Object localObject3 = mTriggeredEventParams;
      Object localObject4 = mOrigin;
      localObject1 = ((zzcfw)localObject1).get((String)localObject2, (Bundle)localObject3, (String)localObject4, 0L, true, false);
      localObject2 = zzauh();
      localObject3 = mTimedOutEventName;
      localObject4 = mTimedOutEventParams;
      Object localObject5 = mOrigin;
      localObject2 = ((zzcfw)localObject2).get((String)localObject3, (Bundle)localObject4, (String)localObject5, 0L, true, false);
      localObject3 = zzauh();
      localObject4 = mExpiredEventName;
      localObject5 = mExpiredEventParams;
      String str = mOrigin;
      localObject3 = ((zzcfw)localObject3).get((String)localObject4, (Bundle)localObject5, str, 0L, true, false);
      paramConditionalUserProperty = new zzcav(mAppId, mOrigin, localZzcft, mCreationTimestamp, false, mTriggerEventName, (zzcbk)localObject2, mTriggerTimeout, (zzcbk)localObject1, mTimeToLive, (zzcbk)localObject3);
      zzauc().i(paramConditionalUserProperty);
      return;
    }
    catch (IllegalArgumentException paramConditionalUserProperty) {}
  }
  
  private final void e(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    set(paramString1, paramString2, zzvx().currentTimeMillis(), paramBundle, true, paramBoolean2, paramBoolean3, null);
  }
  
  private final Map getHeaders(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (zzauk().zzays())
    {
      paramString1 = zzaul().zzayd();
      paramString2 = "Cannot get user properties from analytics worker thread";
    }
    for (;;)
    {
      paramString1.append(paramString2);
      return Collections.emptyMap();
      zzauk();
      if (zzccr.zzaq())
      {
        paramString1 = zzaul().zzayd();
        paramString2 = "Cannot get user properties from main thread";
        continue;
      }
      AtomicReference localAtomicReference = new AtomicReference();
      try
      {
        zziki.zzauk().e(new zzceb(this, localAtomicReference, paramString1, paramString2, paramString3, paramBoolean));
        try
        {
          localAtomicReference.wait(5000L);
        }
        catch (InterruptedException paramString1)
        {
          zzaul().zzayf().append("Interrupted waiting for get user properties", paramString1);
        }
        paramString2 = (List)localAtomicReference.get();
        if (paramString2 == null)
        {
          paramString1 = zzaul().zzayf();
          paramString2 = "Timed out waiting for get user properties";
          continue;
        }
        paramString1 = new ArrayMap(paramString2.size());
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext())
        {
          paramString3 = (zzcft)paramString2.next();
          paramString1.put(name, paramString3.getValue());
        }
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        throw paramString1;
      }
    }
  }
  
  public static int getMaxUserProperties(String paramString)
  {
    zzbp.zzgg(paramString);
    zzcax.zzawa();
    return 25;
  }
  
  private final void getNames(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    zzbp.zzgg(paramString1);
    zzbp.zzgg(paramString2);
    zzbp.append(paramBundle);
    zzuj();
    zzwk();
    if (!zziki.isEnabled())
    {
      zzaul().zzayi().append("Event not sent since app measurement is disabled");
      return;
    }
    if (!zziuw) {
      zziuw = true;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredMethod("initialize", new Class[] { Context.class });
          localObject3 = getContext();
          ((Method)localObject1).invoke(null, new Object[] { localObject3 });
        }
        catch (Exception localException) {}
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        Object localObject3;
        boolean bool2;
        boolean bool1;
        boolean bool3;
        int i;
        int j;
        Object localObject2;
        ArrayList localArrayList;
        long l;
        Object localObject4;
        int m;
        continue;
      }
      try
      {
        zzaul().zzayf().append("Failed to invoke Tag Manager's initialize() method", localException);
      }
      catch (ClassNotFoundException localClassNotFoundException2) {}
    }
    zzaul().zzayh().append("Tag Manager is not found and thus will not be used");
    bool2 = "am".equals(paramString1);
    bool1 = bool2;
    bool3 = zzcfw.zzkd(paramString2);
    if ((paramBoolean1) && (zziuu != null) && (!bool3) && (!bool2))
    {
      zzaul().zzayi().append("Passing event to registered event handler (FE)", zzaug().zzjc(paramString2), zzaug().toString(paramBundle));
      zziuu.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
      return;
    }
    if (!zziki.zzayv()) {
      return;
    }
    i = zzauh().zzjw(paramString2);
    if (i != 0)
    {
      zzauh();
      zzcax.zzavn();
      paramString1 = zzcfw.toString(paramString2, 40, true);
      j = paramString2.length();
      zziki.zzauh().add(paramString3, i, "_ev", paramString1, j);
      return;
    }
    localObject3 = Collections.singletonList("_o");
    localObject2 = localObject3;
    localObject3 = zzauh().list(paramString2, paramBundle, (List)localObject3, paramBoolean3, true);
    localArrayList = StringBuilder.newArrayList(localObject3);
    l = zzauh().zzazy().nextLong();
    localObject4 = (String[])((Bundle)localObject3).keySet().toArray(new String[paramBundle.size()]);
    Arrays.sort((Object[])localObject4);
    m = localObject4.length;
    j = 0;
    i = 0;
    paramBundle = (Bundle)localObject2;
    while (i < m)
    {
      localObject2 = localObject4[i];
      Object localObject5 = ((Bundle)localObject3).get((String)localObject2);
      zzauh();
      localObject5 = zzcfw.zzac(localObject5);
      if (localObject5 != null)
      {
        ((Bundle)localObject3).putInt((String)localObject2, localObject5.length);
        int k = 0;
        while (k < localObject5.length)
        {
          Bundle localBundle = localObject5[k];
          localBundle = zzauh().list("_ep", localBundle, paramBundle, paramBoolean3, false);
          localBundle.putString("_en", paramString2);
          localBundle.putLong("_eid", l);
          localBundle.putString("_gn", (String)localObject2);
          localBundle.putInt("_ll", localObject5.length);
          localBundle.putInt("_i", k);
          localArrayList.add(localBundle);
          k += 1;
        }
        j = localObject5.length + j;
      }
      i += 1;
    }
    if (j != 0)
    {
      ((Bundle)localObject3).putLong("_eid", l);
      ((Bundle)localObject3).putInt("_epc", j);
    }
    zzcax.zzawk();
    localObject4 = zzaud().zzazn();
    if ((localObject4 != null) && (!((Bundle)localObject3).containsKey("_sc"))) {
      zzivx = true;
    }
    i = 0;
    while (i < localArrayList.size())
    {
      localObject3 = (Bundle)localArrayList.get(i);
      if (i != 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        localObject2 = "_ep";
      } else {
        localObject2 = paramString2;
      }
      ((Bundle)localObject3).putString("_o", paramString1);
      if (!((Bundle)localObject3).containsKey("_sc")) {
        zzcek.add((AppMeasurement.zzb)localObject4, (Bundle)localObject3);
      }
      paramBundle = (Bundle)localObject3;
      if (paramBoolean2) {
        paramBundle = zzauh().getNames((Bundle)localObject3);
      }
      zzaul().zzayi().append("Logging event (FE)", zzaug().zzjc(paramString2), zzaug().toString(paramBundle));
      localObject2 = new zzcbk((String)localObject2, new zzcbh(paramBundle), paramString1, paramLong);
      zzauc().f((zzcbk)localObject2, paramString3);
      if (!bool1)
      {
        localObject2 = zziuv.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((com.google.android.android.measurement.AppMeasurement.OnEventListener)((Iterator)localObject2).next()).onEvent(paramString1, paramString2, new Bundle(paramBundle), paramLong);
        }
      }
      i += 1;
    }
    zzcax.zzawk();
    if ((zzaud().zzazn() != null) && ("_ae".equals(paramString2)))
    {
      zzauj().zzbs(true);
      return;
    }
  }
  
  private final void saveToFile(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    long l = zzvx().currentTimeMillis();
    zzbp.append(paramConditionalUserProperty);
    zzbp.zzgg(mName);
    zzbp.zzgg(mOrigin);
    zzbp.append(mValue);
    mCreationTimestamp = l;
    String str = mName;
    Object localObject1 = mValue;
    if (zzauh().zzjy(str) != 0)
    {
      zzaul().zzayd().append("Invalid conditional user property name", zzaug().zzje(str));
      return;
    }
    if (zzauh().attribute(str, localObject1) != 0)
    {
      zzaul().zzayd().append("Invalid conditional user property value", zzaug().zzje(str), localObject1);
      return;
    }
    Object localObject2 = zzauh().valueOf(str, localObject1);
    if (localObject2 == null)
    {
      zzaul().zzayd().append("Unable to normalize conditional user property value", zzaug().zzje(str), localObject1);
      return;
    }
    mValue = localObject2;
    l = mTriggerTimeout;
    if (!TextUtils.isEmpty(mTriggerEventName))
    {
      zzcax.zzawc();
      if ((l > 15552000000L) || (l < 1L))
      {
        zzaul().zzayd().append("Invalid conditional user property timeout", zzaug().zzje(str), Long.valueOf(l));
        return;
      }
    }
    l = mTimeToLive;
    zzcax.zzawd();
    if ((l <= 15552000000L) && (l >= 1L))
    {
      zzauk().e(new zzcdy(this, paramConditionalUserProperty));
      return;
    }
    zzaul().zzayd().append("Invalid conditional user property time to live", zzaug().zzje(str), Long.valueOf(l));
  }
  
  private final void scheduleNext(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    zzuj();
    zzwk();
    zzbp.append(paramConditionalUserProperty);
    zzbp.zzgg(mName);
    if (!zziki.isEnabled())
    {
      zzaul().zzayi().append("Conditional property not cleared since Firebase Analytics is disabled");
      return;
    }
    zzcft localZzcft = new zzcft(mName, 0L, null, null);
    try
    {
      Object localObject = zzauh();
      String str1 = mExpiredEventName;
      Bundle localBundle = mExpiredEventParams;
      String str2 = mOrigin;
      long l = mCreationTimestamp;
      localObject = ((zzcfw)localObject).get(str1, localBundle, str2, l, true, false);
      paramConditionalUserProperty = new zzcav(mAppId, mOrigin, localZzcft, mCreationTimestamp, mActive, mTriggerEventName, null, mTriggerTimeout, null, mTimeToLive, (zzcbk)localObject);
      zzauc().i(paramConditionalUserProperty);
      return;
    }
    catch (IllegalArgumentException paramConditionalUserProperty) {}
  }
  
  private final void set(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    if (paramBundle == null)
    {
      paramBundle = new Bundle();
    }
    else
    {
      paramBundle = new Bundle(paramBundle);
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        Object localObject2 = paramBundle.get((String)localObject1);
        if ((localObject2 instanceof Bundle))
        {
          paramBundle.putBundle((String)localObject1, new Bundle((Bundle)localObject2));
        }
        else
        {
          boolean bool = localObject2 instanceof Parcelable[];
          int j = 0;
          int i = 0;
          if (bool)
          {
            localObject1 = (Parcelable[])localObject2;
            while (i < localObject1.length)
            {
              if ((localObject1[i] instanceof Bundle)) {
                localObject1[i] = new Bundle((Bundle)localObject1[i]);
              }
              i += 1;
            }
          }
          else if ((localObject2 instanceof ArrayList))
          {
            localObject1 = (ArrayList)localObject2;
            i = j;
            while (i < ((ArrayList)localObject1).size())
            {
              localObject2 = ((ArrayList)localObject1).get(i);
              if ((localObject2 instanceof Bundle)) {
                ((ArrayList)localObject1).set(i, new Bundle((Bundle)localObject2));
              }
              i += 1;
            }
          }
        }
      }
    }
    zzauk().e(new zzcee(this, paramString1, paramString2, paramLong, paramBundle, paramBoolean1, paramBoolean2, paramBoolean3, paramString3));
  }
  
  private final void setServer(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    long l = zzvx().currentTimeMillis();
    zzbp.zzgg(paramString2);
    AppMeasurement.ConditionalUserProperty localConditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
    mAppId = paramString1;
    mName = paramString2;
    mCreationTimestamp = l;
    if (paramString3 != null)
    {
      mExpiredEventName = paramString3;
      mExpiredEventParams = paramBundle;
    }
    zzauk().e(new zzcdz(this, localConditionalUserProperty));
  }
  
  private final List uninstall(String paramString1, String paramString2, String paramString3)
  {
    if (zzauk().zzays())
    {
      paramString1 = zzaul().zzayd();
      paramString2 = "Cannot get conditional user properties from analytics worker thread";
      paramString1.append(paramString2);
    }
    for (;;)
    {
      return Collections.emptyList();
      zzauk();
      if (zzccr.zzaq())
      {
        paramString1 = zzaul().zzayd();
        paramString2 = "Cannot get conditional user properties from main thread";
        break;
      }
      Object localObject1 = new AtomicReference();
      try
      {
        zziki.zzauk().e(new zzcea(this, (AtomicReference)localObject1, paramString1, paramString2, paramString3));
        try
        {
          localObject1.wait(5000L);
        }
        catch (InterruptedException paramString3)
        {
          zzaul().zzayf().append("Interrupted waiting for get conditional user properties", paramString1, paramString3);
        }
        localObject1 = (List)((AtomicReference)localObject1).get();
        if (localObject1 == null)
        {
          zzaul().zzayf().append("Timed out waiting for get conditional user properties", paramString1);
          continue;
        }
        paramString3 = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (zzcav)((Iterator)localObject1).next();
          AppMeasurement.ConditionalUserProperty localConditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
          mAppId = paramString1;
          mOrigin = paramString2;
          mCreationTimestamp = zzimi;
          Object localObject3 = zzimh;
          mName = name;
          mValue = ((zzcft)localObject3).getValue();
          mActive = zzimj;
          mTriggerEventName = zzimk;
          localObject3 = zziml;
          if (localObject3 != null)
          {
            mTimedOutEventName = name;
            localObject3 = zzinr;
            if (localObject3 != null) {
              mTimedOutEventParams = ((zzcbh)localObject3).zzaxz();
            }
          }
          mTriggerTimeout = zzimm;
          localObject3 = zzimn;
          if (localObject3 != null)
          {
            mTriggeredEventName = name;
            localObject3 = zzinr;
            if (localObject3 != null) {
              mTriggeredEventParams = ((zzcbh)localObject3).zzaxz();
            }
          }
          mTriggeredTimestamp = zzimh.zziwz;
          mTimeToLive = zzimo;
          localObject2 = zzimp;
          if (localObject2 != null)
          {
            mExpiredEventName = name;
            localObject2 = zzinr;
            if (localObject2 != null) {
              mExpiredEventParams = ((zzcbh)localObject2).zzaxz();
            }
          }
          paramString3.add(localConditionalUserProperty);
        }
        return paramString3;
      }
      catch (Throwable paramString1)
      {
        throw paramString1;
      }
    }
  }
  
  private final void writeValue(String paramString1, String paramString2, Object paramObject, long paramLong)
  {
    zzbp.zzgg(paramString1);
    zzbp.zzgg(paramString2);
    zzuj();
    zzatv();
    zzwk();
    if (!zziki.isEnabled())
    {
      zzaul().zzayi().append("User property not set since app measurement is disabled");
      return;
    }
    if (!zziki.zzayv()) {
      return;
    }
    zzaul().zzayi().append("Setting user property (FE)", zzaug().zzjc(paramString2), paramObject);
    paramString1 = new zzcft(paramString2, paramLong, paramObject, paramString1);
    zzauc().quote(paramString1);
  }
  
  private final void zzbp(boolean paramBoolean)
  {
    zzuj();
    zzatv();
    zzwk();
    zzaul().zzayi().append("Setting app measurement enabled (FE)", Boolean.valueOf(paramBoolean));
    zzaum().setMeasurementEnabled(paramBoolean);
    zzauc().zzazp();
  }
  
  public final void attribute(String paramString1, String paramString2, Object paramObject)
  {
    zzbp.zzgg(paramString1);
    long l = zzvx().currentTimeMillis();
    int i = zzauh().zzjy(paramString2);
    int j;
    if (i != 0)
    {
      zzauh();
      zzcax.zzavo();
      paramString1 = zzcfw.toString(paramString2, 24, true);
      j = paramString2.length();
      zziki.zzauh().append(i, "_ev", paramString1, j);
      return;
    }
    if (paramObject != null)
    {
      j = zzauh().attribute(paramString2, paramObject);
      if (j != 0)
      {
        zzauh();
        zzcax.zzavo();
        paramString1 = zzcfw.toString(paramString2, 24, true);
        i = 0;
        if (((paramObject instanceof String)) || ((paramObject instanceof CharSequence))) {
          i = String.valueOf(paramObject).length();
        }
        zziki.zzauh().append(j, "_ev", paramString1, i);
        return;
      }
      paramObject = zzauh().valueOf(paramString2, paramObject);
      if (paramObject != null) {
        add(paramString1, paramString2, l, paramObject);
      }
    }
    else
    {
      add(paramString1, paramString2, l, null);
    }
  }
  
  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzatv();
    setServer(null, paramString1, paramString2, paramBundle);
  }
  
  public final void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    zzbp.zzgg(paramString1);
    zzatu();
    setServer(paramString1, paramString2, paramString3, paramBundle);
  }
  
  public final void e(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    zzatv();
    if ((zziuu != null) && (!zzcfw.zzkd(paramString2))) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    e(paramString1, paramString2, paramBundle, true, paramBoolean, true, null);
  }
  
  public final Task getAppInstanceId()
  {
    try
    {
      Object localObject = zzaum().zzayn();
      if (localObject != null)
      {
        localObject = Tasks.forResult(localObject);
        return localObject;
      }
      localObject = zzauk().zzayt();
      localObject = Tasks.call((Executor)localObject, new zzceh(this));
      return localObject;
    }
    catch (Exception localException)
    {
      zzaul().zzayf().append("Failed to schedule task for getAppInstanceId");
      return Tasks.forException(localException);
    }
  }
  
  public final List getConditionalUserProperties(String paramString1, String paramString2)
  {
    zzatv();
    return uninstall(null, paramString1, paramString2);
  }
  
  public final List getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    zzbp.zzgg(paramString1);
    zzatu();
    return uninstall(paramString1, paramString2, paramString3);
  }
  
  public final Map getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    zzatv();
    return getHeaders(null, paramString1, paramString2, paramBoolean);
  }
  
  public final Map getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    zzbp.zzgg(paramString1);
    zzatu();
    return getHeaders(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public final void put(String paramString1, String paramString2, Bundle paramBundle)
  {
    zzatv();
    boolean bool;
    if ((zziuu != null) && (!zzcfw.zzkd(paramString2))) {
      bool = false;
    } else {
      bool = true;
    }
    e(paramString1, paramString2, paramBundle, true, bool, false, null);
  }
  
  public final void registerOnMeasurementEventListener(com.google.android.android.measurement.AppMeasurement.OnEventListener paramOnEventListener)
  {
    zzatv();
    zzwk();
    zzbp.append(paramOnEventListener);
    if (!zziuv.add(paramOnEventListener)) {
      zzaul().zzayf().append("OnEventListener already registered");
    }
  }
  
  public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    zzbp.append(paramConditionalUserProperty);
    zzatv();
    paramConditionalUserProperty = new AppMeasurement.ConditionalUserProperty(paramConditionalUserProperty);
    if (!TextUtils.isEmpty(mAppId)) {
      zzaul().zzayf().append("Package name should be null when calling setConditionalUserProperty");
    }
    mAppId = null;
    saveToFile(paramConditionalUserProperty);
  }
  
  public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty paramConditionalUserProperty)
  {
    zzbp.append(paramConditionalUserProperty);
    zzbp.zzgg(mAppId);
    zzatu();
    saveToFile(new AppMeasurement.ConditionalUserProperty(paramConditionalUserProperty));
  }
  
  public final void setEventInterceptor(AppMeasurement.EventInterceptor paramEventInterceptor)
  {
    zzuj();
    zzatv();
    zzwk();
    if (paramEventInterceptor != null)
    {
      AppMeasurement.EventInterceptor localEventInterceptor = zziuu;
      if (paramEventInterceptor != localEventInterceptor)
      {
        boolean bool;
        if (localEventInterceptor == null) {
          bool = true;
        } else {
          bool = false;
        }
        zzbp.append(bool, "EventInterceptor already set.");
      }
    }
    zziuu = paramEventInterceptor;
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean)
  {
    zzwk();
    zzatv();
    zzauk().e(new zzcdx(this, paramBoolean));
  }
  
  public final void setMinimumSessionDuration(long paramLong)
  {
    zzatv();
    zzauk().e(new zzcec(this, paramLong));
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
  {
    zzatv();
    zzauk().e(new zzced(this, paramLong));
  }
  
  public final void unregisterOnMeasurementEventListener(com.google.android.android.measurement.AppMeasurement.OnEventListener paramOnEventListener)
  {
    zzatv();
    zzwk();
    zzbp.append(paramOnEventListener);
    if (!zziuv.remove(paramOnEventListener)) {
      zzaul().zzayf().append("OnEventListener had not been registered");
    }
  }
  
  public final void updateBook(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    zzatv();
    set(paramString1, paramString2, paramLong, paramBundle, false, true, true, null);
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final String zzayn()
  {
    zzatv();
    return (String)zziux.get();
  }
  
  public final String zzbc(long paramLong)
  {
    localAtomicReference = new AtomicReference();
    try
    {
      zzauk().e(new zzcei(this, localAtomicReference));
    }
    catch (Throwable localThrowable)
    {
      label41:
      throw localThrowable;
    }
    try
    {
      localAtomicReference.wait(paramLong);
      return (String)localAtomicReference.get();
    }
    catch (InterruptedException localInterruptedException)
    {
      break label41;
    }
    zzaul().zzayf().append("Interrupted waiting for app instance id");
    return null;
  }
  
  public final List zzbq(boolean paramBoolean)
  {
    zzatv();
    zzwk();
    zzaul().zzayi().append("Fetching user attributes (FE)");
    Object localObject;
    String str1;
    if (zzauk().zzays())
    {
      localObject = zzaul().zzayd();
      str1 = "Cannot get all user properties from analytics worker thread";
    }
    for (;;)
    {
      ((zzcby)localObject).append(str1);
      return Collections.emptyList();
      zzauk();
      if (zzccr.zzaq())
      {
        localObject = zzaul().zzayd();
        str1 = "Cannot get all user properties from main thread";
        continue;
      }
      localObject = new AtomicReference();
      try
      {
        zziki.zzauk().e(new zzceg(this, (AtomicReference)localObject, paramBoolean));
        try
        {
          localObject.wait(5000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          zzaul().zzayf().append("Interrupted waiting for get user properties", localInterruptedException);
        }
        localObject = (List)((AtomicReference)localObject).get();
        if (localObject == null)
        {
          localObject = zzaul().zzayf();
          String str2 = "Timed out waiting for get user properties";
          continue;
        }
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
  }
  
  public final void zzjk(String paramString)
  {
    zziux.set(paramString);
  }
  
  public final void zzuk() {}
}
