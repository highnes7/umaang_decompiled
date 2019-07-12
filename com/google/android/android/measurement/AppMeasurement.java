package com.google.android.android.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.internal.zzca;
import com.google.android.android.internal.zzcan;
import com.google.android.android.internal.zzcax;
import com.google.android.android.internal.zzcbw;
import com.google.android.android.internal.zzcby;
import com.google.android.android.internal.zzccw;
import com.google.android.android.internal.zzcdw;
import com.google.android.android.internal.zzcek;
import com.google.android.android.internal.zzcft;
import com.google.android.android.internal.zzcfw;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.analytics.FirebaseAnalytics.a;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.firebase.analytics.FirebaseAnalytics.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import support.android.v4.util.ArrayMap;

@Deprecated
@Keep
public class AppMeasurement
{
  @KeepForSdk
  public static final String CRASH_ORIGIN = "crash";
  @KeepForSdk
  public static final String FCM_ORIGIN = "fcm";
  public final zzccw zziki;
  
  public AppMeasurement(zzccw paramZzccw)
  {
    zzbp.append(paramZzccw);
    zziki = paramZzccw;
  }
  
  public static AppMeasurement getInstance(Context paramContext)
  {
    return zzccw.zzdn(paramContext).zzayy();
  }
  
  public void beginAdUnitExposure(String paramString)
  {
    zziki.zzatx().beginAdUnitExposure(paramString);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
  {
    zziki.zzatz().clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  public void clearConditionalUserPropertyAs(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    zziki.zzatz().clearConditionalUserPropertyAs(paramString1, paramString2, paramString3, paramBundle);
  }
  
  public void endAdUnitExposure(String paramString)
  {
    zziki.zzatx().endAdUnitExposure(paramString);
  }
  
  public long generateEventId()
  {
    return zziki.zzauh().zzazx();
  }
  
  public String getAppInstanceId()
  {
    return zziki.zzatz().zzayn();
  }
  
  public List getConditionalUserProperties(String paramString1, String paramString2)
  {
    return zziki.zzatz().getConditionalUserProperties(paramString1, paramString2);
  }
  
  public List getConditionalUserPropertiesAs(String paramString1, String paramString2, String paramString3)
  {
    return zziki.zzatz().getConditionalUserPropertiesAs(paramString1, paramString2, paramString3);
  }
  
  public String getCurrentScreenClass()
  {
    zzb localZzb = zziki.zzaud().zzazo();
    if (localZzb != null) {
      return zziko;
    }
    return null;
  }
  
  public String getCurrentScreenName()
  {
    zzb localZzb = zziki.zzaud().zzazo();
    if (localZzb != null) {
      return zzikn;
    }
    return null;
  }
  
  public String getGmpAppId()
  {
    try
    {
      String str = zzca.zzaie();
      return str;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      zziki.zzaul().zzayd().append("getGoogleAppId failed with exception", localIllegalStateException);
    }
    return null;
  }
  
  public int getMaxUserProperties(String paramString)
  {
    zziki.zzatz();
    zzcdw.getMaxUserProperties(paramString);
    return 25;
  }
  
  public Map getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
  {
    return zziki.zzatz().getUserProperties(paramString1, paramString2, paramBoolean);
  }
  
  public Map getUserProperties(boolean paramBoolean)
  {
    Object localObject = zziki.zzatz().zzbq(paramBoolean);
    ArrayMap localArrayMap = new ArrayMap(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      zzcft localZzcft = (zzcft)((Iterator)localObject).next();
      localArrayMap.put(name, localZzcft.getValue());
    }
    return localArrayMap;
  }
  
  public Map getUserPropertiesAs(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return zziki.zzatz().getUserPropertiesAs(paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public final void logEvent(String paramString, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    zzcax.zzawk();
    if (!"_iap".equals(paramString))
    {
      int i = zziki.zzauh().zzjv(paramString);
      if (i != 0)
      {
        zziki.zzauh();
        zzcax.zzavn();
        paramBundle = zzcfw.toString(paramString, 40, true);
        int j = paramString.length();
        zziki.zzauh().append(i, "_ev", paramBundle, j);
        return;
      }
    }
    zziki.zzatz().e("app", paramString, localBundle, true);
  }
  
  public void logEventInternal(String paramString1, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    zziki.zzatz().put(paramString1, paramString2, localBundle);
  }
  
  public void logEventInternalNoInterceptor(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    zziki.zzatz().updateBook(paramString1, paramString2, localBundle, paramLong);
  }
  
  public void registerOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    zziki.zzatz().registerOnMeasurementEventListener(paramOnEventListener);
  }
  
  public void registerOnScreenChangeCallback(zza paramZza)
  {
    zziki.zzaud().registerOnScreenChangeCallback(paramZza);
  }
  
  public void setConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty)
  {
    zziki.zzatz().setConditionalUserProperty(paramConditionalUserProperty);
  }
  
  public void setConditionalUserPropertyAs(ConditionalUserProperty paramConditionalUserProperty)
  {
    zziki.zzatz().setConditionalUserPropertyAs(paramConditionalUserProperty);
  }
  
  public void setEventInterceptor(EventInterceptor paramEventInterceptor)
  {
    zziki.zzatz().setEventInterceptor(paramEventInterceptor);
  }
  
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    zziki.zzatz().setMeasurementEnabled(paramBoolean);
  }
  
  public final void setMinimumSessionDuration(long paramLong)
  {
    zziki.zzatz().setMinimumSessionDuration(paramLong);
  }
  
  public final void setSessionTimeoutDuration(long paramLong)
  {
    zziki.zzatz().setSessionTimeoutDuration(paramLong);
  }
  
  public final void setUserProperty(String paramString1, String paramString2)
  {
    int i = zziki.zzauh().zzjx(paramString1);
    if (i != 0)
    {
      zziki.zzauh();
      zzcax.zzavo();
      paramString2 = zzcfw.toString(paramString1, 24, true);
      int j = paramString1.length();
      zziki.zzauh().append(i, "_ev", paramString2, j);
      return;
    }
    setUserPropertyInternal("app", paramString1, paramString2);
  }
  
  public void setUserPropertyInternal(String paramString1, String paramString2, Object paramObject)
  {
    zziki.zzatz().attribute(paramString1, paramString2, paramObject);
  }
  
  public void unregisterOnMeasurementEventListener(OnEventListener paramOnEventListener)
  {
    zziki.zzatz().unregisterOnMeasurementEventListener(paramOnEventListener);
  }
  
  public void unregisterOnScreenChangeCallback(zza paramZza)
  {
    zziki.zzaud().unregisterOnScreenChangeCallback(paramZza);
  }
  
  public class ConditionalUserProperty
  {
    @Keep
    public boolean mActive;
    @Keep
    public String mAppId;
    @Keep
    public long mCreationTimestamp;
    @Keep
    public String mExpiredEventName;
    @Keep
    public Bundle mExpiredEventParams;
    @Keep
    public String mName;
    @Keep
    public String mOrigin;
    @Keep
    public long mTimeToLive;
    @Keep
    public String mTimedOutEventName;
    @Keep
    public Bundle mTimedOutEventParams;
    @Keep
    public String mTriggerEventName;
    @Keep
    public long mTriggerTimeout;
    @Keep
    public String mTriggeredEventName;
    @Keep
    public Bundle mTriggeredEventParams;
    @Keep
    public long mTriggeredTimestamp;
    @Keep
    public Object mValue;
    
    public ConditionalUserProperty() {}
    
    public ConditionalUserProperty()
    {
      zzbp.append(this$1);
      mAppId = mAppId;
      mOrigin = mOrigin;
      mCreationTimestamp = mCreationTimestamp;
      mName = mName;
      Object localObject = mValue;
      if (localObject != null)
      {
        mValue = zzcfw.zzad(localObject);
        if (mValue == null) {
          mValue = mValue;
        }
      }
      mValue = mValue;
      mActive = mActive;
      mTriggerEventName = mTriggerEventName;
      mTriggerTimeout = mTriggerTimeout;
      mTimedOutEventName = mTimedOutEventName;
      localObject = mTimedOutEventParams;
      if (localObject != null) {
        mTimedOutEventParams = new Bundle((Bundle)localObject);
      }
      mTriggeredEventName = mTriggeredEventName;
      localObject = mTriggeredEventParams;
      if (localObject != null) {
        mTriggeredEventParams = new Bundle((Bundle)localObject);
      }
      mTriggeredTimestamp = mTriggeredTimestamp;
      mTimeToLive = mTimeToLive;
      mExpiredEventName = mExpiredEventName;
      this$1 = mExpiredEventParams;
      if (this$1 != null) {
        mExpiredEventParams = new Bundle(this$1);
      }
    }
  }
  
  @KeepForSdk
  public final class Event
    extends FirebaseAnalytics.a
  {
    @KeepForSdk
    public static final String APP_EXCEPTION = "_ae";
    public static final String[] zzikj = { "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter" };
    public static final String[] zzikk = { "_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_vs", "_ep" };
    
    public Event() {}
    
    public static String zzil(String paramString)
    {
      return zzcfw.matchName(paramString, zzikj, zzikk);
    }
  }
  
  @KeepForSdk
  public abstract interface EventInterceptor
  {
    public abstract void interceptEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  @KeepForSdk
  public abstract interface OnEventListener
  {
    public abstract void onEvent(String paramString1, String paramString2, Bundle paramBundle, long paramLong);
  }
  
  @KeepForSdk
  public final class Param
    extends FirebaseAnalytics.b
  {
    @KeepForSdk
    public static final String FATAL = "fatal";
    @KeepForSdk
    public static final String TIMESTAMP = "timestamp";
    public static final String[] zzikl = { "firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "firebase_event_id", "firebase_extra_params_ct", "firebase_group_name", "firebase_list_length", "firebase_index", "firebase_event_name" };
    public static final String[] zzikm = { "_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en" };
    
    public Param() {}
    
    public static String zzil(String paramString)
    {
      return zzcfw.matchName(paramString, zzikl, zzikm);
    }
  }
  
  @KeepForSdk
  public final class UserProperty
    extends FirebaseAnalytics.c
  {
    @KeepForSdk
    public static final String FIREBASE_LAST_NOTIFICATION = "_ln";
    public static final String[] zzikq = { "firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install" };
    public static final String[] zzikr = { "_ln", "_fot", "_fvt", "_ldl", "_id", "_fi" };
    
    public UserProperty() {}
    
    public static String zzil(String paramString)
    {
      return zzcfw.matchName(paramString, zzikq, zzikr);
    }
  }
  
  public abstract interface zza
  {
    public abstract boolean get(AppMeasurement.zzb paramZzb1, AppMeasurement.zzb paramZzb2);
  }
  
  public class zzb
  {
    public String zzikn;
    public String zziko;
    public long zzikp;
    
    public zzb() {}
    
    public zzb()
    {
      zzikn = zzikn;
      zziko = zziko;
      zzikp = zzikp;
    }
  }
}
