package com.google.android.android.internal;

import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import support.android.v4.util.ArrayMap;

public final class zzcau
  extends zzcdu
{
  public zzcau(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  /* Error */
  public static Boolean apply(BigDecimal paramBigDecimal, zzcga paramZzcga, double paramDouble)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 19	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_1
    //   6: getfield 25	com/google/android/android/internal/zzcga:zzixx	Ljava/lang/Integer;
    //   9: astore 10
    //   11: aload 10
    //   13: ifnull +411 -> 424
    //   16: aload 10
    //   18: invokevirtual 31	java/lang/Integer:intValue	()I
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: aload_1
    //   27: getfield 25	com/google/android/android/internal/zzcga:zzixx	Ljava/lang/Integer;
    //   30: invokevirtual 31	java/lang/Integer:intValue	()I
    //   33: iconst_4
    //   34: if_icmpne +19 -> 53
    //   37: aload_1
    //   38: getfield 35	com/google/android/android/internal/zzcga:zziya	Ljava/lang/String;
    //   41: ifnull +389 -> 430
    //   44: aload_1
    //   45: getfield 38	com/google/android/android/internal/zzcga:zziyb	Ljava/lang/String;
    //   48: ifnonnull +14 -> 62
    //   51: aconst_null
    //   52: areturn
    //   53: aload_1
    //   54: getfield 41	com/google/android/android/internal/zzcga:zzixz	Ljava/lang/String;
    //   57: ifnonnull +5 -> 62
    //   60: aconst_null
    //   61: areturn
    //   62: aload_1
    //   63: getfield 25	com/google/android/android/internal/zzcga:zzixx	Ljava/lang/Integer;
    //   66: invokevirtual 31	java/lang/Integer:intValue	()I
    //   69: istore 4
    //   71: aload_1
    //   72: getfield 25	com/google/android/android/internal/zzcga:zzixx	Ljava/lang/Integer;
    //   75: invokevirtual 31	java/lang/Integer:intValue	()I
    //   78: iconst_4
    //   79: if_icmpne +68 -> 147
    //   82: aload_1
    //   83: getfield 35	com/google/android/android/internal/zzcga:zziya	Ljava/lang/String;
    //   86: invokestatic 47	com/google/android/android/internal/zzcfw:zzkf	(Ljava/lang/String;)Z
    //   89: ifeq +56 -> 145
    //   92: aload_1
    //   93: getfield 38	com/google/android/android/internal/zzcga:zziyb	Ljava/lang/String;
    //   96: invokestatic 47	com/google/android/android/internal/zzcfw:zzkf	(Ljava/lang/String;)Z
    //   99: ifne +5 -> 104
    //   102: aconst_null
    //   103: areturn
    //   104: aload_1
    //   105: getfield 35	com/google/android/android/internal/zzcga:zziya	Ljava/lang/String;
    //   108: astore 10
    //   110: new 49	java/math/BigDecimal
    //   113: dup
    //   114: aload 10
    //   116: invokespecial 52	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   119: astore 10
    //   121: aload_1
    //   122: getfield 38	com/google/android/android/internal/zzcga:zziyb	Ljava/lang/String;
    //   125: astore_1
    //   126: new 49	java/math/BigDecimal
    //   129: dup
    //   130: aload_1
    //   131: invokespecial 52	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   134: astore 11
    //   136: aload 10
    //   138: astore_1
    //   139: aconst_null
    //   140: astore 10
    //   142: goto +37 -> 179
    //   145: aconst_null
    //   146: areturn
    //   147: aload_1
    //   148: getfield 41	com/google/android/android/internal/zzcga:zzixz	Ljava/lang/String;
    //   151: invokestatic 47	com/google/android/android/internal/zzcfw:zzkf	(Ljava/lang/String;)Z
    //   154: ifne +5 -> 159
    //   157: aconst_null
    //   158: areturn
    //   159: aload_1
    //   160: getfield 41	com/google/android/android/internal/zzcga:zzixz	Ljava/lang/String;
    //   163: astore_1
    //   164: new 49	java/math/BigDecimal
    //   167: dup
    //   168: aload_1
    //   169: invokespecial 52	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   172: astore 10
    //   174: aconst_null
    //   175: astore_1
    //   176: aconst_null
    //   177: astore 11
    //   179: iload 4
    //   181: iconst_4
    //   182: if_icmpne +9 -> 191
    //   185: aload_1
    //   186: ifnonnull +10 -> 196
    //   189: aconst_null
    //   190: areturn
    //   191: aload 10
    //   193: ifnull +237 -> 430
    //   196: iconst_0
    //   197: istore 7
    //   199: iconst_0
    //   200: istore 5
    //   202: iconst_0
    //   203: istore 8
    //   205: iconst_0
    //   206: istore 9
    //   208: iconst_0
    //   209: istore 6
    //   211: iload 4
    //   213: iconst_1
    //   214: if_icmpeq +187 -> 401
    //   217: iload 4
    //   219: iconst_2
    //   220: if_icmpeq +158 -> 378
    //   223: iload 4
    //   225: iconst_3
    //   226: if_icmpeq +47 -> 273
    //   229: iload 4
    //   231: iconst_4
    //   232: if_icmpeq +5 -> 237
    //   235: aconst_null
    //   236: areturn
    //   237: iload 6
    //   239: istore 5
    //   241: aload_0
    //   242: aload_1
    //   243: invokevirtual 56	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   246: iconst_m1
    //   247: if_icmpeq +20 -> 267
    //   250: iload 6
    //   252: istore 5
    //   254: aload_0
    //   255: aload 11
    //   257: invokevirtual 56	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   260: iconst_1
    //   261: if_icmpeq +6 -> 267
    //   264: iconst_1
    //   265: istore 5
    //   267: iload 5
    //   269: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   272: areturn
    //   273: dload_2
    //   274: dconst_0
    //   275: dcmpl
    //   276: ifeq +84 -> 360
    //   279: iload 7
    //   281: istore 5
    //   283: aload_0
    //   284: aload 10
    //   286: new 49	java/math/BigDecimal
    //   289: dup
    //   290: dload_2
    //   291: invokespecial 65	java/math/BigDecimal:<init>	(D)V
    //   294: new 49	java/math/BigDecimal
    //   297: dup
    //   298: iconst_2
    //   299: invokespecial 68	java/math/BigDecimal:<init>	(I)V
    //   302: invokevirtual 72	java/math/BigDecimal:multiply	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   305: invokevirtual 75	java/math/BigDecimal:subtract	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   308: invokevirtual 56	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   311: iconst_1
    //   312: if_icmpne +42 -> 354
    //   315: iload 7
    //   317: istore 5
    //   319: aload_0
    //   320: aload 10
    //   322: new 49	java/math/BigDecimal
    //   325: dup
    //   326: dload_2
    //   327: invokespecial 65	java/math/BigDecimal:<init>	(D)V
    //   330: new 49	java/math/BigDecimal
    //   333: dup
    //   334: iconst_2
    //   335: invokespecial 68	java/math/BigDecimal:<init>	(I)V
    //   338: invokevirtual 72	java/math/BigDecimal:multiply	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   341: invokevirtual 78	java/math/BigDecimal:add	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   344: invokevirtual 56	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   347: iconst_m1
    //   348: if_icmpne +6 -> 354
    //   351: iconst_1
    //   352: istore 5
    //   354: iload 5
    //   356: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   359: areturn
    //   360: aload_0
    //   361: aload 10
    //   363: invokevirtual 56	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   366: ifne +6 -> 372
    //   369: iconst_1
    //   370: istore 5
    //   372: iload 5
    //   374: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   377: areturn
    //   378: iload 8
    //   380: istore 5
    //   382: aload_0
    //   383: aload 10
    //   385: invokevirtual 56	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   388: iconst_1
    //   389: if_icmpne +6 -> 395
    //   392: iconst_1
    //   393: istore 5
    //   395: iload 5
    //   397: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   400: areturn
    //   401: iload 9
    //   403: istore 5
    //   405: aload_0
    //   406: aload 10
    //   408: invokevirtual 56	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   411: iconst_m1
    //   412: if_icmpne +6 -> 418
    //   415: iconst_1
    //   416: istore 5
    //   418: iload 5
    //   420: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   423: areturn
    //   424: aconst_null
    //   425: areturn
    //   426: astore_0
    //   427: aconst_null
    //   428: areturn
    //   429: astore_0
    //   430: aconst_null
    //   431: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramBigDecimal	BigDecimal
    //   0	432	1	paramZzcga	zzcga
    //   0	432	2	paramDouble	double
    //   69	164	4	i	int
    //   200	219	5	bool1	boolean
    //   209	42	6	bool2	boolean
    //   197	119	7	bool3	boolean
    //   203	176	8	bool4	boolean
    //   206	196	9	bool5	boolean
    //   9	398	10	localObject	Object
    //   134	122	11	localBigDecimal	BigDecimal
    // Exception table:
    //   from	to	target	type
    //   110	121	426	java/lang/NumberFormatException
    //   126	136	426	java/lang/NumberFormatException
    //   164	174	429	java/lang/NumberFormatException
  }
  
  private final Boolean create(String paramString1, int paramInt, boolean paramBoolean, String paramString2, List paramList, String paramString3)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramInt == 6)
    {
      if (paramList == null) {
        break label240;
      }
      if (paramList.size() == 0) {
        return null;
      }
    }
    else if (paramString2 == null)
    {
      return null;
    }
    String str = paramString1;
    if (!paramBoolean) {
      if (paramInt == 1) {
        str = paramString1;
      } else {
        str = paramString1.toUpperCase(Locale.ENGLISH);
      }
    }
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      paramBoolean = paramList.contains(str);
    case 5: 
    case 4: 
    case 3: 
    case 2: 
      for (;;)
      {
        return Boolean.valueOf(paramBoolean);
        paramBoolean = str.equals(paramString2);
        continue;
        paramBoolean = str.contains(paramString2);
        continue;
        paramBoolean = str.endsWith(paramString2);
        continue;
        paramBoolean = str.startsWith(paramString2);
      }
    }
    if (paramBoolean) {
      paramInt = 0;
    } else {
      paramInt = 66;
    }
    try
    {
      paramBoolean = Pattern.compile(paramString3, paramInt).matcher(str).matches();
      return Boolean.valueOf(paramBoolean);
    }
    catch (PatternSyntaxException paramString1)
    {
      for (;;) {}
    }
    zzaul().zzayf().append("Invalid regular expression in REGEXP audience filter. expression", paramString3);
    return null;
    label240:
    return null;
  }
  
  private final Boolean create(String paramString, zzcgc paramZzcgc)
  {
    zzbp.append(paramZzcgc);
    if (paramString == null) {
      return null;
    }
    Object localObject1 = zziyf;
    if (localObject1 != null)
    {
      if (((Integer)localObject1).intValue() == 0) {
        return null;
      }
      if (zziyf.intValue() == 6)
      {
        localObject1 = zziyi;
        if (localObject1 == null) {
          break label260;
        }
        if (localObject1.length == 0) {
          return null;
        }
      }
      else if (zziyg == null)
      {
        return null;
      }
      int j = zziyf.intValue();
      localObject1 = zziyh;
      int i = 0;
      boolean bool;
      if ((localObject1 != null) && (((Boolean)localObject1).booleanValue())) {
        bool = true;
      } else {
        bool = false;
      }
      if ((!bool) && (j != 1) && (j != 6)) {
        localObject1 = zziyg.toUpperCase(Locale.ENGLISH);
      } else {
        localObject1 = zziyg;
      }
      Object localObject2 = zziyi;
      if (localObject2 == null)
      {
        paramZzcgc = null;
      }
      else if (bool)
      {
        paramZzcgc = Arrays.asList((Object[])localObject2);
      }
      else
      {
        paramZzcgc = new ArrayList();
        int k = localObject2.length;
        while (i < k)
        {
          paramZzcgc.add(localObject2[i].toUpperCase(Locale.ENGLISH));
          i += 1;
        }
      }
      if (j == 1) {
        localObject2 = localObject1;
      } else {
        localObject2 = null;
      }
      return create(paramString, j, bool, (String)localObject1, (List)paramZzcgc, (String)localObject2);
    }
    label260:
    return null;
  }
  
  private final Boolean get(double paramDouble, zzcga paramZzcga)
  {
    try
    {
      paramZzcga = apply(new BigDecimal(paramDouble), paramZzcga, Math.ulp(paramDouble));
      return paramZzcga;
    }
    catch (NumberFormatException paramZzcga)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Boolean get(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return null;
    }
    return Boolean.valueOf(paramBoolean.booleanValue() ^ paramBoolean1);
  }
  
  private final Boolean next(long paramLong, zzcga paramZzcga)
  {
    try
    {
      paramZzcga = apply(new BigDecimal(paramLong), paramZzcga, 0.0D);
      return paramZzcga;
    }
    catch (NumberFormatException paramZzcga)
    {
      for (;;) {}
    }
    return null;
  }
  
  private final Boolean next(String paramString, zzcga paramZzcga)
  {
    if (!zzcfw.zzkf(paramString)) {
      return null;
    }
    try
    {
      paramString = apply(new BigDecimal(paramString), paramZzcga, 0.0D);
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private final Boolean serialize(zzcfy paramZzcfy, zzcgh paramZzcgh, long paramLong)
  {
    Object localObject1 = zzixr;
    int j = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    if (localObject1 != null)
    {
      localObject1 = next(paramLong, (zzcga)localObject1);
      if (localObject1 == null) {
        return null;
      }
      if (!((Boolean)localObject1).booleanValue()) {
        return localBoolean;
      }
    }
    Object localObject2 = new HashSet();
    localObject1 = zzixp;
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      localArrayMap = localObject1[i];
      if (TextUtils.isEmpty(zzixw))
      {
        zzaul().zzayf().append("null or empty param name in filter. event", zzaug().zzjc(name));
        return null;
      }
      ((Set)localObject2).add(zzixw);
      i += 1;
    }
    ArrayMap localArrayMap = new ArrayMap();
    Object localObject3 = zziyx;
    k = localObject3.length;
    i = 0;
    zzcgc localZzcgc;
    while (i < k)
    {
      localZzcgc = localObject3[i];
      if (((Set)localObject2).contains(name))
      {
        localObject1 = zzizb;
        if (localObject1 != null) {}
        do
        {
          do
          {
            localArrayMap.put(name, localObject1);
            break;
            localObject1 = zzixc;
          } while (localObject1 != null);
          localObject1 = zzfwo;
        } while (localObject1 != null);
        zzaul().zzayf().append("Unknown value for param. event, param", zzaug().zzjc(name), zzaug().zzjd(name));
        return null;
      }
      i += 1;
    }
    localObject1 = zzixp;
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      paramZzcfy = localObject1[i];
      boolean bool = Boolean.TRUE.equals(zzixv);
      localObject2 = zzixw;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        zzaul().zzayf().append("Event has empty param name. event", zzaug().zzjc(name));
        return null;
      }
      localObject3 = localArrayMap.get(localObject2);
      if ((localObject3 instanceof Long))
      {
        if (zzixu == null)
        {
          zzaul().zzayf().append("No number filter for long param. event, param", zzaug().zzjc(name), zzaug().zzjd((String)localObject2));
          return null;
        }
        paramZzcfy = next(((Long)localObject3).longValue(), zzixu);
        if (paramZzcfy == null) {
          return null;
        }
        if ((true ^ paramZzcfy.booleanValue() ^ bool)) {
          return localBoolean;
        }
      }
      else if ((localObject3 instanceof Double))
      {
        if (zzixu == null)
        {
          zzaul().zzayf().append("No number filter for double param. event, param", zzaug().zzjc(name), zzaug().zzjd((String)localObject2));
          return null;
        }
        paramZzcfy = get(((Double)localObject3).doubleValue(), zzixu);
        if (paramZzcfy == null) {
          return null;
        }
        if ((true ^ paramZzcfy.booleanValue() ^ bool)) {
          return localBoolean;
        }
      }
      else
      {
        if (!(localObject3 instanceof String)) {
          break label735;
        }
        localZzcgc = zzixt;
        if (localZzcgc != null)
        {
          paramZzcfy = create((String)localObject3, localZzcgc);
        }
        else
        {
          if (zzixu == null) {
            break label700;
          }
          localObject3 = (String)localObject3;
          if (!zzcfw.zzkf((String)localObject3)) {
            break label665;
          }
          paramZzcfy = next((String)localObject3, zzixu);
        }
        if (paramZzcfy == null) {
          return null;
        }
        if ((true ^ paramZzcfy.booleanValue() ^ bool)) {
          return localBoolean;
        }
      }
      i += 1;
      continue;
      label665:
      zzaul().zzayf().append("Invalid param value for number filter. event, param", zzaug().zzjc(name), zzaug().zzjd((String)localObject2));
      return null;
      label700:
      zzaul().zzayf().append("No filter for String param. event, param", zzaug().zzjc(name), zzaug().zzjd((String)localObject2));
      return null;
      label735:
      if (localObject3 == null)
      {
        zzaul().zzayj().append("Missing param for filter. event, param", zzaug().zzjc(name), zzaug().zzjd((String)localObject2));
        return localBoolean;
      }
      zzaul().zzayf().append("Unknown param type. event, param", zzaug().zzjc(name), zzaug().zzjd((String)localObject2));
      return null;
    }
    return Boolean.valueOf(true);
  }
  
  public final zzcgg[] getNames(String paramString, zzcgh[] paramArrayOfZzcgh, zzcgm[] paramArrayOfZzcgm)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public final void zzuk() {}
}
