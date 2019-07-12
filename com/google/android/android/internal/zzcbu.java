package com.google.android.android.internal;

import android.os.Bundle;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.measurement.AppMeasurement.Event;
import com.google.android.android.measurement.AppMeasurement.Param;
import com.google.android.android.measurement.AppMeasurement.UserProperty;
import java.util.Iterator;
import java.util.Set;

public final class zzcbu
  extends zzcdu
{
  public static String[] zzipo = new String[AppMeasurement.Event.zzikj.length];
  public static String[] zzipp = new String[AppMeasurement.Param.zzikl.length];
  public static String[] zzipq = new String[AppMeasurement.UserProperty.zzikq.length];
  
  public zzcbu(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  public static void append(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("  ");
      i += 1;
    }
  }
  
  private final void check(StringBuilder paramStringBuilder, int paramInt, zzcgh[] paramArrayOfZzcgh)
  {
    if (paramArrayOfZzcgh == null) {
      return;
    }
    int j = paramArrayOfZzcgh.length;
    paramInt = 0;
    while (paramInt < j)
    {
      Object localObject1 = paramArrayOfZzcgh[paramInt];
      if (localObject1 != null)
      {
        append(paramStringBuilder, 2);
        paramStringBuilder.append("event {\n");
        name(paramStringBuilder, 2, "name", zzjc(name));
        name(paramStringBuilder, 2, "timestamp_millis", zziyy);
        name(paramStringBuilder, 2, "previous_timestamp_millis", zziyz);
        name(paramStringBuilder, 2, "count", count);
        localObject1 = zziyx;
        if (localObject1 != null)
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            if (localObject2 != null)
            {
              append(paramStringBuilder, 3);
              paramStringBuilder.append("param {\n");
              name(paramStringBuilder, 3, "name", zzjd(name));
              name(paramStringBuilder, 3, "string_value", zzfwo);
              name(paramStringBuilder, 3, "int_value", zzizb);
              name(paramStringBuilder, 3, "double_value", zzixc);
              append(paramStringBuilder, 3);
              paramStringBuilder.append("}\n");
            }
            i += 1;
          }
        }
        append(paramStringBuilder, 2);
        paramStringBuilder.append("}\n");
      }
      paramInt += 1;
    }
  }
  
  private final void getProperties(StringBuilder paramStringBuilder, int paramInt, zzcgg[] paramArrayOfZzcgg)
  {
    if (paramArrayOfZzcgg == null) {
      return;
    }
    int i = paramArrayOfZzcgg.length;
    paramInt = 0;
    while (paramInt < i)
    {
      zzcgg localZzcgg = paramArrayOfZzcgg[paramInt];
      if (localZzcgg != null)
      {
        append(paramStringBuilder, 2);
        paramStringBuilder.append("audience_membership {\n");
        name(paramStringBuilder, 2, "audience_id", zzixj);
        name(paramStringBuilder, 2, "new_audience", zziyv);
        toString(paramStringBuilder, 2, "current_data", zziyt);
        toString(paramStringBuilder, 2, "previous_data", zziyu);
        append(paramStringBuilder, 2);
        paramStringBuilder.append("}\n");
      }
      paramInt += 1;
    }
  }
  
  private final void getProperties(StringBuilder paramStringBuilder, int paramInt, zzcgm[] paramArrayOfZzcgm)
  {
    if (paramArrayOfZzcgm == null) {
      return;
    }
    int i = paramArrayOfZzcgm.length;
    paramInt = 0;
    while (paramInt < i)
    {
      zzcgm localZzcgm = paramArrayOfZzcgm[paramInt];
      if (localZzcgm != null)
      {
        append(paramStringBuilder, 2);
        paramStringBuilder.append("user_property {\n");
        name(paramStringBuilder, 2, "set_timestamp_millis", zzjaj);
        name(paramStringBuilder, 2, "name", zzje(name));
        name(paramStringBuilder, 2, "string_value", zzfwo);
        name(paramStringBuilder, 2, "int_value", zzizb);
        name(paramStringBuilder, 2, "double_value", zzixc);
        append(paramStringBuilder, 2);
        paramStringBuilder.append("}\n");
      }
      paramInt += 1;
    }
  }
  
  private final String getRelativePath(zzcbh paramZzcbh)
  {
    if (paramZzcbh == null) {
      return null;
    }
    if (!zzayc()) {
      return paramZzcbh.toString();
    }
    return toString(paramZzcbh.zzaxz());
  }
  
  public static void name(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    append(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
  }
  
  public static String parseElement(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    zzbp.append(paramArrayOfString1);
    zzbp.append(paramArrayOfString2);
    zzbp.append(paramArrayOfString3);
    int j = paramArrayOfString1.length;
    int k = paramArrayOfString2.length;
    boolean bool2 = true;
    int i = 0;
    boolean bool1;
    if (j == k) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzbp.zzbh(bool1);
    if (paramArrayOfString1.length == paramArrayOfString3.length) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    zzbp.zzbh(bool1);
    while (i < paramArrayOfString1.length)
    {
      if (zzcfw.zzas(paramString, paramArrayOfString1[i]))
      {
        if (paramArrayOfString3[i] == null) {}
        try
        {
          paramString = new StringBuilder();
          paramString.append(paramArrayOfString2[i]);
          paramString.append("(");
          paramString.append(paramArrayOfString1[i]);
          paramString.append(")");
          paramArrayOfString3[i] = paramString.toString();
          paramString = paramArrayOfString3[i];
          return paramString;
        }
        catch (Throwable paramString)
        {
          throw paramString;
        }
      }
      i += 1;
    }
    return paramString;
  }
  
  private final void toHtml(StringBuilder paramStringBuilder, int paramInt, zzcfz paramZzcfz)
  {
    if (paramZzcfz == null) {
      return;
    }
    append(paramStringBuilder, paramInt);
    paramStringBuilder.append("filter {\n");
    name(paramStringBuilder, paramInt, "complement", zzixv);
    name(paramStringBuilder, paramInt, "param_name", zzjd(zzixw));
    int j = paramInt + 1;
    zzcgc localZzcgc = zzixt;
    if (localZzcgc != null)
    {
      append(paramStringBuilder, j);
      paramStringBuilder.append("string_filter");
      paramStringBuilder.append(" {\n");
      Object localObject = zziyf;
      if (localObject != null)
      {
        switch (((Integer)localObject).intValue())
        {
        default: 
          localObject = "UNKNOWN_MATCH_TYPE";
          break;
        case 6: 
          localObject = "IN_LIST";
          break;
        case 5: 
          localObject = "EXACT";
          break;
        case 4: 
          localObject = "PARTIAL";
          break;
        case 3: 
          localObject = "ENDS_WITH";
          break;
        case 2: 
          localObject = "BEGINS_WITH";
          break;
        case 1: 
          localObject = "REGEXP";
        }
        name(paramStringBuilder, j, "match_type", localObject);
      }
      name(paramStringBuilder, j, "expression", zziyg);
      name(paramStringBuilder, j, "case_sensitive", zziyh);
      if (zziyi.length > 0)
      {
        append(paramStringBuilder, j + 1);
        paramStringBuilder.append("expression_list {\n");
        localObject = zziyi;
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          localZzcgc = localObject[i];
          append(paramStringBuilder, j + 2);
          paramStringBuilder.append(localZzcgc);
          paramStringBuilder.append("\n");
          i += 1;
        }
        paramStringBuilder.append("}\n");
      }
      append(paramStringBuilder, j);
      paramStringBuilder.append("}\n");
    }
    toHtml(paramStringBuilder, j, "number_filter", zzixu);
    append(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private final void toHtml(StringBuilder paramStringBuilder, int paramInt, String paramString, zzcga paramZzcga)
  {
    if (paramZzcga == null) {
      return;
    }
    append(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    paramString = zzixx;
    if (paramString != null)
    {
      int i = paramString.intValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              paramString = "UNKNOWN_COMPARISON_TYPE";
            } else {
              paramString = "BETWEEN";
            }
          }
          else {
            paramString = "EQUAL";
          }
        }
        else {
          paramString = "GREATER_THAN";
        }
      }
      else {
        paramString = "LESS_THAN";
      }
      name(paramStringBuilder, paramInt, "comparison_type", paramString);
    }
    name(paramStringBuilder, paramInt, "match_as_float", zzixy);
    name(paramStringBuilder, paramInt, "comparison_value", zzixz);
    name(paramStringBuilder, paramInt, "min_comparison_value", zziya);
    name(paramStringBuilder, paramInt, "max_comparison_value", zziyb);
    append(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  public static void toString(StringBuilder paramStringBuilder, int paramInt, String paramString, zzcgl paramZzcgl)
  {
    if (paramZzcgl == null) {
      return;
    }
    int k = paramInt + 1;
    append(paramStringBuilder, k);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    paramString = zzjah;
    int j = 0;
    int m;
    int i;
    long l;
    if (paramString != null)
    {
      append(paramStringBuilder, k + 1);
      paramStringBuilder.append("results: ");
      paramString = zzjah;
      m = paramString.length;
      i = 0;
      paramInt = 0;
      while (i < m)
      {
        l = paramString[i];
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(Long.valueOf(l));
        i += 1;
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    if (zzjag != null)
    {
      append(paramStringBuilder, k + 1);
      paramStringBuilder.append("status: ");
      paramString = zzjag;
      m = paramString.length;
      paramInt = 0;
      i = j;
      while (i < m)
      {
        l = paramString[i];
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(Long.valueOf(l));
        i += 1;
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    append(paramStringBuilder, k);
    paramStringBuilder.append("}\n");
  }
  
  private final boolean zzayc()
  {
    return zziki.zzaul().zzad(3);
  }
  
  public final String fromStream(zzcgj paramZzcgj)
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("\nbatch {\n");
    paramZzcgj = zzizc;
    if (paramZzcgj != null)
    {
      int j = paramZzcgj.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramZzcgj[i];
        if (localObject != null)
        {
          append(localStringBuilder, 1);
          localStringBuilder.append("bundle {\n");
          name(localStringBuilder, 1, "protocol_version", zzize);
          name(localStringBuilder, 1, "platform", zzizm);
          name(localStringBuilder, 1, "gmp_version", zzizq);
          name(localStringBuilder, 1, "uploading_gmp_version", zzizr);
          name(localStringBuilder, 1, "config_version", zzjad);
          name(localStringBuilder, 1, "gmp_app_id", zzilu);
          name(localStringBuilder, 1, "app_id", zzci);
          name(localStringBuilder, 1, "app_version", zzhtt);
          name(localStringBuilder, 1, "app_version_major", zzizz);
          name(localStringBuilder, 1, "firebase_instance_id", zzimc);
          name(localStringBuilder, 1, "dev_cert_hash", zzizv);
          name(localStringBuilder, 1, "app_store", zzilv);
          name(localStringBuilder, 1, "upload_timestamp_millis", zzizh);
          name(localStringBuilder, 1, "start_timestamp_millis", zzizi);
          name(localStringBuilder, 1, "end_timestamp_millis", zzizj);
          name(localStringBuilder, 1, "previous_bundle_start_timestamp_millis", zzizk);
          name(localStringBuilder, 1, "previous_bundle_end_timestamp_millis", zzizl);
          name(localStringBuilder, 1, "app_instance_id", zzizu);
          name(localStringBuilder, 1, "resettable_device_id", zzizs);
          name(localStringBuilder, 1, "device_id", zzjac);
          name(localStringBuilder, 1, "limited_ad_tracking", zzizt);
          name(localStringBuilder, 1, "os_version", zzcw);
          name(localStringBuilder, 1, "device_model", zzizn);
          name(localStringBuilder, 1, "user_default_language", zzizo);
          name(localStringBuilder, 1, "time_zone_offset_minutes", zzizp);
          name(localStringBuilder, 1, "bundle_sequential_index", zzizw);
          name(localStringBuilder, 1, "service_upload", zzizx);
          name(localStringBuilder, 1, "health_monitor", zzily);
          if (zzjae.longValue() != 0L) {
            name(localStringBuilder, 1, "android_id", zzjae);
          }
          getProperties(localStringBuilder, 1, zzizg);
          getProperties(localStringBuilder, 1, zzizy);
          check(localStringBuilder, 1, zzizf);
          append(localStringBuilder, 1);
          localStringBuilder.append("}\n");
        }
        i += 1;
      }
    }
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  public final String getAbsolutePath(zzcbf paramZzcbf)
  {
    if (paramZzcbf == null) {
      return null;
    }
    if (!zzayc()) {
      return paramZzcbf.toString();
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Event{appId='");
    localStringBuilder.append(mAppId);
    localStringBuilder.append("', name='");
    localStringBuilder.append(zzjc(mName));
    localStringBuilder.append("', params=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, getRelativePath(zzink), "}");
  }
  
  public final String getRelativePath(zzcbk paramZzcbk)
  {
    if (paramZzcbk == null) {
      return null;
    }
    if (!zzayc()) {
      return paramZzcbk.toString();
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("origin=");
    localStringBuilder.append(zzimg);
    localStringBuilder.append(",name=");
    localStringBuilder.append(zzjc(name));
    localStringBuilder.append(",params=");
    localStringBuilder.append(getRelativePath(zzinr));
    return localStringBuilder.toString();
  }
  
  public final String toHtml(zzcfy paramZzcfy)
  {
    if (paramZzcfy == null) {
      return "null";
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("\nevent_filter {\n");
    Integer localInteger = zzixn;
    int i = 0;
    name(localStringBuilder, 0, "filter_id", localInteger);
    name(localStringBuilder, 0, "event_name", zzjc(zzixo));
    toHtml(localStringBuilder, 1, "event_count_filter", zzixr);
    localStringBuilder.append("  filters {\n");
    paramZzcfy = zzixp;
    int j = paramZzcfy.length;
    while (i < j)
    {
      toHtml(localStringBuilder, 2, paramZzcfy[i]);
      i += 1;
    }
    append(localStringBuilder, 1);
    localStringBuilder.append("}\n}\n");
    return localStringBuilder.toString();
  }
  
  public final String toString(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    if (!zzayc()) {
      return paramBundle.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1;
      if (localStringBuilder.length() != 0) {
        str1 = ", ";
      } else {
        str1 = "Bundle[{";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(zzjd(str2));
      localStringBuilder.append("=");
      localStringBuilder.append(paramBundle.get(str2));
    }
    localStringBuilder.append("}]");
    return localStringBuilder.toString();
  }
  
  public final String toString(zzcgb paramZzcgb)
  {
    if (paramZzcgb == null) {
      return "null";
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("\nproperty_filter {\n");
    name(localStringBuilder, 0, "filter_id", zzixn);
    name(localStringBuilder, 0, "property_name", zzje(zziyd));
    toHtml(localStringBuilder, 1, zziye);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
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
  
  public final String zzjc(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzayc()) {
      return paramString;
    }
    return parseElement(paramString, AppMeasurement.Event.zzikk, AppMeasurement.Event.zzikj, zzipo);
  }
  
  public final String zzjd(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzayc()) {
      return paramString;
    }
    return parseElement(paramString, AppMeasurement.Param.zzikm, AppMeasurement.Param.zzikl, zzipp);
  }
  
  public final String zzje(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!zzayc()) {
      return paramString;
    }
    if (paramString.startsWith("_exp_"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("experiment_id");
      localStringBuilder.append("(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return parseElement(paramString, AppMeasurement.UserProperty.zzikr, AppMeasurement.UserProperty.zzikq, zzipq);
  }
  
  public final void zzuk() {}
}
