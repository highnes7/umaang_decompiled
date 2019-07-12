package com.google.android.android.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Clock;
import com.google.android.android.common.util.Log;
import com.google.android.android.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import support.android.v4.util.ArrayMap;

public class zzccw
{
  public static volatile zzccw zzisr;
  public final Context mContext;
  public final Log zzasc;
  public final boolean zzdoe;
  public final zzcax zziss;
  public final zzcch zzist;
  public final zzcbw zzisu;
  public final zzccr zzisv;
  public final zzcfl zzisw;
  public final zzccq zzisx;
  public final AppMeasurement zzisy;
  public final FirebaseAnalytics zzisz;
  public final zzcfw zzita;
  public final zzcbu zzitb;
  public final zzcay zzitc;
  public final zzcbs zzitd;
  public final zzcca zzite;
  public final zzcek zzitf;
  public final zzceo zzitg;
  public final zzcbe zzith;
  public final zzcdw zziti;
  public final zzcbr zzitj;
  public final zzccf zzitk;
  public final zzcfr zzitl;
  public final zzcau zzitm;
  public final zzcan zzitn;
  public boolean zzito;
  public Boolean zzitp;
  public long zzitq;
  public FileLock zzitr;
  public FileChannel zzits;
  public List<Long> zzitt;
  public List<Runnable> zzitu;
  public int zzitv;
  public int zzitw;
  public long zzitx;
  public long zzity;
  public boolean zzitz;
  public boolean zziua;
  public boolean zziub;
  public final long zziuc;
  
  public zzccw(zzcdv paramZzcdv)
  {
    zzbp.append(paramZzcdv);
    mContext = mContext;
    zzitx = -1L;
    zzasc = Clock.zzfyr;
    zziuc = zzasc.currentTimeMillis();
    zziss = new zzcax(this);
    paramZzcdv = new zzcch(this);
    paramZzcdv.initialize();
    zzist = paramZzcdv;
    paramZzcdv = new zzcbw(this);
    paramZzcdv.initialize();
    zzisu = paramZzcdv;
    paramZzcdv = zzaul().zzayh();
    zzcax.zzauv();
    paramZzcdv.append("App measurement is starting up, version", Long.valueOf(11400L));
    zzcax.zzawk();
    zzaul().zzayh().append("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
    paramZzcdv = new zzcfw(this);
    paramZzcdv.initialize();
    zzita = paramZzcdv;
    paramZzcdv = new zzcbu(this);
    paramZzcdv.initialize();
    zzitb = paramZzcdv;
    paramZzcdv = new zzcbe(this);
    paramZzcdv.initialize();
    zzith = paramZzcdv;
    paramZzcdv = new zzcbr(this);
    paramZzcdv.initialize();
    zzitj = paramZzcdv;
    zzcax.zzawk();
    paramZzcdv = paramZzcdv.getAppId();
    Object localObject;
    if (zzauh().zzke(paramZzcdv))
    {
      localObject = zzaul().zzayh();
      paramZzcdv = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
    }
    else
    {
      localObject = zzaul().zzayh();
      paramZzcdv = String.valueOf(paramZzcdv);
      if (paramZzcdv.length() != 0) {
        paramZzcdv = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(paramZzcdv);
      } else {
        paramZzcdv = new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
      }
    }
    ((zzcby)localObject).append(paramZzcdv);
    zzaul().zzayi().append("Debug-level message logging enabled");
    paramZzcdv = new zzcay(this);
    paramZzcdv.initialize();
    zzitc = paramZzcdv;
    paramZzcdv = new zzcbs(this);
    paramZzcdv.initialize();
    zzitd = paramZzcdv;
    paramZzcdv = new zzcau(this);
    paramZzcdv.initialize();
    zzitm = paramZzcdv;
    zzitn = new zzcan(this);
    paramZzcdv = new zzcca(this);
    paramZzcdv.initialize();
    zzite = paramZzcdv;
    paramZzcdv = new zzcek(this);
    paramZzcdv.initialize();
    zzitf = paramZzcdv;
    paramZzcdv = new zzceo(this);
    paramZzcdv.initialize();
    zzitg = paramZzcdv;
    paramZzcdv = new zzcdw(this);
    paramZzcdv.initialize();
    zziti = paramZzcdv;
    paramZzcdv = new zzcfr(this);
    paramZzcdv.initialize();
    zzitl = paramZzcdv;
    zzitk = new zzccf(this);
    zzisy = new AppMeasurement(this);
    zzisz = new FirebaseAnalytics(this);
    paramZzcdv = new zzcfl(this);
    paramZzcdv.initialize();
    zzisw = paramZzcdv;
    paramZzcdv = new zzccq(this);
    paramZzcdv.initialize();
    zzisx = paramZzcdv;
    paramZzcdv = new zzccr(this);
    paramZzcdv.initialize();
    zzisv = paramZzcdv;
    if (zzitv != zzitw) {
      zzaul().zzayd().append("Not all components initialized", Integer.valueOf(zzitv), Integer.valueOf(zzitw));
    }
    zzdoe = true;
    zzcax.zzawk();
    if ((mContext.getApplicationContext() instanceof Application))
    {
      paramZzcdv = zzatz();
      if (!(paramZzcdv.getContext().getApplicationContext() instanceof Application)) {
        break label698;
      }
      localObject = (Application)paramZzcdv.getContext().getApplicationContext();
      if (zziut == null) {
        zziut = new zzcej(paramZzcdv, null);
      }
      ((Application)localObject).unregisterActivityLifecycleCallbacks(zziut);
      ((Application)localObject).registerActivityLifecycleCallbacks(zziut);
      paramZzcdv = paramZzcdv.zzaul().zzayj();
      localObject = "Registered activity lifecycle callback";
    }
    else
    {
      paramZzcdv = zzaul().zzayf();
      localObject = "Application context is not an Application";
    }
    paramZzcdv.append((String)localObject);
    label698:
    zzisv.e(new zzccx(this));
  }
  
  public static void dispatchEvent(zzcdu paramZzcdu)
  {
    if (paramZzcdu != null)
    {
      if (paramZzcdu.isInitialized()) {
        return;
      }
      throw new IllegalStateException("Component not initialized");
    }
    throw new IllegalStateException("Component not created");
  }
  
  private final zzcgg[] getJSONObject(String paramString, zzcgm[] paramArrayOfZzcgm, zzcgh[] paramArrayOfZzcgh)
  {
    zzbp.zzgg(paramString);
    return zzaty().getNames(paramString, paramArrayOfZzcgh, paramArrayOfZzcgm);
  }
  
  private final void getThreadId(zzcar paramZzcar)
  {
    zzauk().zzuj();
    if (TextUtils.isEmpty(paramZzcar.getGmpAppId()))
    {
      deleteMessages(paramZzcar.getAppId(), 204, null, null, null);
      return;
    }
    Object localObject1 = paramZzcar.getGmpAppId();
    String str1 = paramZzcar.getAppInstanceId();
    Object localObject2 = new Uri.Builder();
    Object localObject3 = ((Uri.Builder)localObject2).scheme((String)zzcbm.zziof.get0()).encodedAuthority((String)zzcbm.zziog.get0());
    localObject1 = String.valueOf(localObject1);
    if (((String)localObject1).length() != 0) {
      localObject1 = "config/app/".concat((String)localObject1);
    } else {
      localObject1 = new String("config/app/");
    }
    ((Uri.Builder)localObject3).path((String)localObject1).appendQueryParameter("app_instance_id", str1).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "11400");
    str1 = ((Uri.Builder)localObject2).build().toString();
    try
    {
      localObject2 = new URL(str1);
      zzaul().zzayj().append("Fetching remote configuration", paramZzcar.getAppId());
      localObject1 = zzaui().zzjn(paramZzcar.getAppId());
      localObject3 = zzaui().zzjo(paramZzcar.getAppId());
      if (localObject1 != null)
      {
        boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
        if (!bool)
        {
          localObject1 = new ArrayMap();
          ((Map)localObject1).put("If-Modified-Since", localObject3);
          break label249;
        }
      }
      localObject1 = null;
      label249:
      zzitz = true;
      localObject3 = zzaza();
      String str2 = paramZzcar.getAppId();
      zzcda localZzcda = new zzcda(this);
      ((zzcca)localObject3).zzuj();
      ((zzcdu)localObject3).zzwk();
      zzbp.append(localObject2);
      zzbp.append(localZzcda);
      zzccr localZzccr = ((zzcca)localObject3).zzauk();
      localZzccr.enqueue(new zzcce((zzcca)localObject3, str2, (URL)localObject2, null, (Map)localObject1, localZzcda));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;) {}
    }
    zzaul().zzayd().append("Failed to parse config URL. Not fetching. appId", zzcbw.zzjf(paramZzcar.getAppId()), str1);
  }
  
  /* Error */
  private final boolean saveData(String arg1, long arg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   4: invokevirtual 552	com/google/android/android/internal/zzcay:beginTransaction	()V
    //   7: aconst_null
    //   8: astore_1
    //   9: new 6	com/google/android/android/internal/zzccw$zza
    //   12: dup
    //   13: aload_0
    //   14: aconst_null
    //   15: invokespecial 555	com/google/android/android/internal/zzccw$zza:<init>	(Lcom/google/android/android/internal/zzccw;Lcom/google/android/android/internal/zzccx;)V
    //   18: astore 22
    //   20: aload_0
    //   21: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   24: astore 23
    //   26: aload_0
    //   27: getfield 101	com/google/android/android/internal/zzccw:zzitx	J
    //   30: lstore 11
    //   32: aload 22
    //   34: invokestatic 92	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: pop
    //   38: aload 23
    //   40: invokevirtual 558	com/google/android/android/internal/zzcdt:zzuj	()V
    //   43: aload 23
    //   45: invokevirtual 522	com/google/android/android/internal/zzcdu:zzwk	()V
    //   48: aload 23
    //   50: invokevirtual 562	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: astore 24
    //   55: aconst_null
    //   56: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: istore 13
    //   61: ldc_w 564
    //   64: astore 17
    //   66: iload 13
    //   68: ifeq +244 -> 312
    //   71: lload 11
    //   73: ldc2_w 98
    //   76: lcmp
    //   77: ifeq +46 -> 123
    //   80: iconst_2
    //   81: anewarray 210	java/lang/String
    //   84: astore 18
    //   86: aload 18
    //   88: iconst_0
    //   89: lload 11
    //   91: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   94: aastore
    //   95: aload 18
    //   97: iconst_1
    //   98: lload_2
    //   99: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   102: aastore
    //   103: aload 18
    //   105: astore_1
    //   106: goto +29 -> 135
    //   109: astore 17
    //   111: goto +3245 -> 3356
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_1
    //   117: aconst_null
    //   118: astore 19
    //   120: goto +979 -> 1099
    //   123: iconst_1
    //   124: anewarray 210	java/lang/String
    //   127: astore_1
    //   128: aload_1
    //   129: iconst_0
    //   130: lload_2
    //   131: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   134: aastore
    //   135: lload 11
    //   137: ldc2_w 98
    //   140: lcmp
    //   141: ifeq +8 -> 149
    //   144: ldc_w 569
    //   147: astore 17
    //   149: aload 17
    //   151: invokevirtual 217	java/lang/String:length	()I
    //   154: istore 4
    //   156: new 571	java/lang/StringBuilder
    //   159: dup
    //   160: iload 4
    //   162: sipush 148
    //   165: iadd
    //   166: invokespecial 574	java/lang/StringBuilder:<init>	(I)V
    //   169: astore 18
    //   171: aload 18
    //   173: ldc_w 576
    //   176: invokevirtual 579	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 18
    //   182: aload 17
    //   184: invokevirtual 579	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 18
    //   190: ldc_w 581
    //   193: invokevirtual 579	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 24
    //   199: aload 18
    //   201: invokevirtual 582	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: aload_1
    //   205: invokevirtual 588	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   208: astore 19
    //   210: aload 19
    //   212: astore 17
    //   214: aload 17
    //   216: astore_1
    //   217: aload 17
    //   219: astore 18
    //   221: aload 19
    //   223: invokeinterface 593 1 0
    //   228: istore 13
    //   230: iload 13
    //   232: ifne +13 -> 245
    //   235: aload 17
    //   237: invokeinterface 596 1 0
    //   242: goto +892 -> 1134
    //   245: aload 17
    //   247: astore_1
    //   248: aload 17
    //   250: astore 18
    //   252: aload 19
    //   254: iconst_0
    //   255: invokeinterface 600 2 0
    //   260: astore 20
    //   262: aload 20
    //   264: astore 18
    //   266: aload 17
    //   268: astore_1
    //   269: aload 19
    //   271: iconst_1
    //   272: invokeinterface 600 2 0
    //   277: astore 21
    //   279: aload 17
    //   281: astore_1
    //   282: aload 19
    //   284: invokeinterface 596 1 0
    //   289: aload 19
    //   291: astore 17
    //   293: aload 20
    //   295: astore 18
    //   297: aload 21
    //   299: astore 19
    //   301: goto +193 -> 494
    //   304: astore_1
    //   305: aload 19
    //   307: astore 17
    //   309: goto -189 -> 120
    //   312: lload 11
    //   314: ldc2_w 98
    //   317: lcmp
    //   318: ifeq +23 -> 341
    //   321: iconst_2
    //   322: anewarray 210	java/lang/String
    //   325: astore_1
    //   326: aload_1
    //   327: iconst_0
    //   328: aconst_null
    //   329: aastore
    //   330: aload_1
    //   331: iconst_1
    //   332: lload 11
    //   334: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   337: aastore
    //   338: goto +12 -> 350
    //   341: iconst_1
    //   342: anewarray 210	java/lang/String
    //   345: astore_1
    //   346: aload_1
    //   347: iconst_0
    //   348: aconst_null
    //   349: aastore
    //   350: lload 11
    //   352: ldc2_w 98
    //   355: lcmp
    //   356: ifeq +8 -> 364
    //   359: ldc_w 602
    //   362: astore 17
    //   364: aload 17
    //   366: invokevirtual 217	java/lang/String:length	()I
    //   369: istore 4
    //   371: new 571	java/lang/StringBuilder
    //   374: dup
    //   375: iload 4
    //   377: bipush 84
    //   379: iadd
    //   380: invokespecial 574	java/lang/StringBuilder:<init>	(I)V
    //   383: astore 18
    //   385: aload 18
    //   387: ldc_w 604
    //   390: invokevirtual 579	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 18
    //   396: aload 17
    //   398: invokevirtual 579	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 18
    //   404: ldc_w 606
    //   407: invokevirtual 579	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 24
    //   413: aload 18
    //   415: invokevirtual 582	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: aload_1
    //   419: invokevirtual 588	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   422: astore 19
    //   424: aload 19
    //   426: astore 17
    //   428: aload 17
    //   430: astore_1
    //   431: aload 17
    //   433: astore 18
    //   435: aload 19
    //   437: invokeinterface 593 1 0
    //   442: istore 13
    //   444: iload 13
    //   446: ifne +6 -> 452
    //   449: goto -214 -> 235
    //   452: aload 17
    //   454: astore_1
    //   455: aload 17
    //   457: astore 18
    //   459: aload 19
    //   461: iconst_0
    //   462: invokeinterface 600 2 0
    //   467: astore 20
    //   469: aload 17
    //   471: astore_1
    //   472: aload 17
    //   474: astore 18
    //   476: aload 19
    //   478: invokeinterface 596 1 0
    //   483: aload 19
    //   485: astore 17
    //   487: aload 20
    //   489: astore 19
    //   491: aconst_null
    //   492: astore 18
    //   494: aload 24
    //   496: ldc_w 608
    //   499: iconst_1
    //   500: anewarray 210	java/lang/String
    //   503: dup
    //   504: iconst_0
    //   505: ldc_w 610
    //   508: aastore
    //   509: ldc_w 612
    //   512: iconst_2
    //   513: anewarray 210	java/lang/String
    //   516: dup
    //   517: iconst_0
    //   518: aload 18
    //   520: aastore
    //   521: dup
    //   522: iconst_1
    //   523: aload 19
    //   525: aastore
    //   526: aconst_null
    //   527: aconst_null
    //   528: ldc_w 614
    //   531: ldc_w 616
    //   534: invokevirtual 620	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   537: astore_1
    //   538: aload_1
    //   539: invokeinterface 593 1 0
    //   544: istore 13
    //   546: iload 13
    //   548: ifne +47 -> 595
    //   551: aload 23
    //   553: invokevirtual 621	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   556: invokevirtual 312	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   559: ldc_w 623
    //   562: aload 18
    //   564: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   567: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   570: aload_1
    //   571: invokeinterface 596 1 0
    //   576: goto +558 -> 1134
    //   579: astore 17
    //   581: goto +2775 -> 3356
    //   584: astore 19
    //   586: aload_1
    //   587: astore 17
    //   589: aload 19
    //   591: astore_1
    //   592: goto -472 -> 120
    //   595: aload_1
    //   596: iconst_0
    //   597: invokeinterface 627 2 0
    //   602: astore 17
    //   604: aload 17
    //   606: arraylength
    //   607: istore 4
    //   609: aload 17
    //   611: iconst_0
    //   612: iload 4
    //   614: invokestatic 632	com/google/android/android/internal/zzeye:getBlob	([BII)Lcom/google/android/android/internal/zzeye;
    //   617: astore 17
    //   619: new 634	com/google/android/android/internal/zzcgk
    //   622: dup
    //   623: invokespecial 635	com/google/android/android/internal/zzcgk:<init>	()V
    //   626: astore 20
    //   628: aload 20
    //   630: aload 17
    //   632: invokevirtual 639	com/google/android/android/internal/zzcgk:digest	(Lcom/google/android/android/internal/zzeye;)Lcom/google/android/android/internal/zzeyn;
    //   635: pop
    //   636: aload_1
    //   637: invokeinterface 642 1 0
    //   642: istore 13
    //   644: iload 13
    //   646: ifeq +22 -> 668
    //   649: aload 23
    //   651: invokevirtual 621	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   654: invokevirtual 364	com/google/android/android/internal/zzcbw:zzayf	()Lcom/google/android/android/internal/zzcby;
    //   657: ldc_w 644
    //   660: aload 18
    //   662: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   665: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   668: aload_1
    //   669: invokeinterface 596 1 0
    //   674: aload 22
    //   676: aload 20
    //   678: invokeinterface 650 2 0
    //   683: lload 11
    //   685: ldc2_w 98
    //   688: lcmp
    //   689: ifeq +38 -> 727
    //   692: iconst_3
    //   693: anewarray 210	java/lang/String
    //   696: astore 17
    //   698: aload 17
    //   700: iconst_0
    //   701: aload 18
    //   703: aastore
    //   704: aload 17
    //   706: iconst_1
    //   707: aload 19
    //   709: aastore
    //   710: aload 17
    //   712: iconst_2
    //   713: lload 11
    //   715: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   718: aastore
    //   719: ldc_w 652
    //   722: astore 20
    //   724: goto +26 -> 750
    //   727: ldc_w 612
    //   730: astore 20
    //   732: iconst_2
    //   733: anewarray 210	java/lang/String
    //   736: astore 17
    //   738: aload 17
    //   740: iconst_0
    //   741: aload 18
    //   743: aastore
    //   744: aload 17
    //   746: iconst_1
    //   747: aload 19
    //   749: aastore
    //   750: aload_1
    //   751: astore 19
    //   753: aload 24
    //   755: ldc_w 654
    //   758: iconst_4
    //   759: anewarray 210	java/lang/String
    //   762: dup
    //   763: iconst_0
    //   764: ldc_w 614
    //   767: aastore
    //   768: dup
    //   769: iconst_1
    //   770: ldc_w 656
    //   773: aastore
    //   774: dup
    //   775: iconst_2
    //   776: ldc_w 658
    //   779: aastore
    //   780: dup
    //   781: iconst_3
    //   782: ldc_w 660
    //   785: aastore
    //   786: aload 20
    //   788: aload 17
    //   790: aconst_null
    //   791: aconst_null
    //   792: ldc_w 614
    //   795: aconst_null
    //   796: invokevirtual 620	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   799: astore 17
    //   801: aload 17
    //   803: invokeinterface 593 1 0
    //   808: istore 13
    //   810: iload 13
    //   812: ifne +32 -> 844
    //   815: aload 23
    //   817: invokevirtual 621	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   820: invokevirtual 364	com/google/android/android/internal/zzcbw:zzayf	()Lcom/google/android/android/internal/zzcby;
    //   823: ldc_w 662
    //   826: aload 18
    //   828: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   831: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   834: aload 17
    //   836: invokeinterface 596 1 0
    //   841: goto +293 -> 1134
    //   844: aload 17
    //   846: iconst_0
    //   847: invokeinterface 666 2 0
    //   852: lstore_2
    //   853: aload 17
    //   855: iconst_3
    //   856: invokeinterface 627 2 0
    //   861: astore_1
    //   862: aload_1
    //   863: arraylength
    //   864: istore 4
    //   866: aload_1
    //   867: iconst_0
    //   868: iload 4
    //   870: invokestatic 632	com/google/android/android/internal/zzeye:getBlob	([BII)Lcom/google/android/android/internal/zzeye;
    //   873: astore 19
    //   875: new 668	com/google/android/android/internal/zzcgh
    //   878: dup
    //   879: invokespecial 669	com/google/android/android/internal/zzcgh:<init>	()V
    //   882: astore_1
    //   883: aload_1
    //   884: aload 19
    //   886: invokevirtual 670	com/google/android/android/internal/zzcgh:digest	(Lcom/google/android/android/internal/zzeye;)Lcom/google/android/android/internal/zzeyn;
    //   889: pop
    //   890: aload 17
    //   892: iconst_1
    //   893: invokeinterface 600 2 0
    //   898: astore 19
    //   900: aload_1
    //   901: aload 19
    //   903: putfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   906: aload 17
    //   908: iconst_2
    //   909: invokeinterface 666 2 0
    //   914: lstore 11
    //   916: aload_1
    //   917: lload 11
    //   919: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   922: putfield 677	com/google/android/android/internal/zzcgh:zziyy	Ljava/lang/Long;
    //   925: aload 22
    //   927: lload_2
    //   928: aload_1
    //   929: invokeinterface 681 4 0
    //   934: istore 13
    //   936: iload 13
    //   938: ifne +27 -> 965
    //   941: goto -107 -> 834
    //   944: astore_1
    //   945: aload 23
    //   947: invokevirtual 621	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   950: invokevirtual 312	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   953: ldc_w 683
    //   956: aload 18
    //   958: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   961: aload_1
    //   962: invokevirtual 322	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   965: aload 17
    //   967: invokeinterface 642 1 0
    //   972: istore 13
    //   974: iload 13
    //   976: ifne -132 -> 844
    //   979: goto -145 -> 834
    //   982: astore 18
    //   984: aload 17
    //   986: astore_1
    //   987: aload 18
    //   989: astore 17
    //   991: goto +2365 -> 3356
    //   994: astore_1
    //   995: goto -875 -> 120
    //   998: astore 17
    //   1000: aload_1
    //   1001: astore 19
    //   1003: aload 23
    //   1005: invokevirtual 621	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   1008: invokevirtual 312	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   1011: ldc_w 685
    //   1014: aload 18
    //   1016: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   1019: aload 17
    //   1021: invokevirtual 322	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1024: aload_1
    //   1025: invokeinterface 596 1 0
    //   1030: goto +104 -> 1134
    //   1033: astore 19
    //   1035: goto +10 -> 1045
    //   1038: astore 17
    //   1040: goto +2316 -> 3356
    //   1043: astore 19
    //   1045: aload_1
    //   1046: astore 17
    //   1048: aload 19
    //   1050: astore_1
    //   1051: goto -931 -> 120
    //   1054: astore 18
    //   1056: aload 17
    //   1058: astore_1
    //   1059: aload 18
    //   1061: astore 17
    //   1063: goto +2293 -> 3356
    //   1066: astore_1
    //   1067: goto -947 -> 120
    //   1070: astore_1
    //   1071: aconst_null
    //   1072: astore 19
    //   1074: aload 18
    //   1076: astore 17
    //   1078: aload 19
    //   1080: astore 18
    //   1082: goto -962 -> 120
    //   1085: astore 17
    //   1087: aconst_null
    //   1088: astore_1
    //   1089: goto +2267 -> 3356
    //   1092: astore_1
    //   1093: aconst_null
    //   1094: astore 17
    //   1096: aconst_null
    //   1097: astore 18
    //   1099: aload 17
    //   1101: astore 19
    //   1103: aload 23
    //   1105: invokevirtual 621	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   1108: invokevirtual 312	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   1111: ldc_w 687
    //   1114: aload 18
    //   1116: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   1119: aload_1
    //   1120: invokevirtual 322	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1123: aload 17
    //   1125: ifnull +9 -> 1134
    //   1128: aload 17
    //   1130: astore_1
    //   1131: goto -107 -> 1024
    //   1134: aload 22
    //   1136: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1139: astore_1
    //   1140: aload_1
    //   1141: ifnull +29 -> 1170
    //   1144: aload 22
    //   1146: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1149: invokeinterface 694 1 0
    //   1154: istore 13
    //   1156: iload 13
    //   1158: ifeq +6 -> 1164
    //   1161: goto +9 -> 1170
    //   1164: iconst_0
    //   1165: istore 4
    //   1167: goto +6 -> 1173
    //   1170: iconst_1
    //   1171: istore 4
    //   1173: iload 4
    //   1175: ifne +2160 -> 3335
    //   1178: aload 22
    //   1180: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   1183: astore 18
    //   1185: aload 18
    //   1187: aload 22
    //   1189: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1192: invokeinterface 701 1 0
    //   1197: anewarray 668	com/google/android/android/internal/zzcgh
    //   1200: putfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   1203: iconst_0
    //   1204: istore 5
    //   1206: iconst_0
    //   1207: istore 4
    //   1209: iconst_0
    //   1210: istore 13
    //   1212: aload 22
    //   1214: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1217: invokeinterface 701 1 0
    //   1222: istore 6
    //   1224: iload 5
    //   1226: iload 6
    //   1228: if_icmpge +1471 -> 2699
    //   1231: aload_0
    //   1232: invokevirtual 491	com/google/android/android/internal/zzccw:zzaui	()Lcom/google/android/android/internal/zzccq;
    //   1235: aload 22
    //   1237: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   1240: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   1243: aload 22
    //   1245: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1248: iload 5
    //   1250: invokeinterface 712 2 0
    //   1255: checkcast 668	com/google/android/android/internal/zzcgh
    //   1258: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   1261: invokevirtual 716	com/google/android/android/internal/zzccq:zzao	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1264: istore 14
    //   1266: iload 14
    //   1268: ifeq +210 -> 1478
    //   1271: aload_0
    //   1272: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   1275: invokevirtual 364	com/google/android/android/internal/zzcbw:zzayf	()Lcom/google/android/android/internal/zzcby;
    //   1278: ldc_w 718
    //   1281: aload 22
    //   1283: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   1286: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   1289: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   1292: aload_0
    //   1293: invokevirtual 722	com/google/android/android/internal/zzccw:zzaug	()Lcom/google/android/android/internal/zzcbu;
    //   1296: aload 22
    //   1298: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1301: iload 5
    //   1303: invokeinterface 712 2 0
    //   1308: checkcast 668	com/google/android/android/internal/zzcgh
    //   1311: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   1314: invokevirtual 725	com/google/android/android/internal/zzcbu:zzjc	(Ljava/lang/String;)Ljava/lang/String;
    //   1317: invokevirtual 322	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1320: aload_0
    //   1321: invokevirtual 202	com/google/android/android/internal/zzccw:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   1324: aload 22
    //   1326: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   1329: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   1332: invokevirtual 728	com/google/android/android/internal/zzcfw:zzkg	(Ljava/lang/String;)Z
    //   1335: istore 14
    //   1337: iload 14
    //   1339: ifne +34 -> 1373
    //   1342: aload_0
    //   1343: invokevirtual 202	com/google/android/android/internal/zzccw:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   1346: aload 22
    //   1348: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   1351: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   1354: invokevirtual 731	com/google/android/android/internal/zzcfw:zzkh	(Ljava/lang/String;)Z
    //   1357: istore 14
    //   1359: iload 14
    //   1361: ifeq +6 -> 1367
    //   1364: goto +9 -> 1373
    //   1367: iconst_0
    //   1368: istore 7
    //   1370: goto +6 -> 1376
    //   1373: iconst_1
    //   1374: istore 7
    //   1376: iload 13
    //   1378: istore 15
    //   1380: iload 4
    //   1382: istore 6
    //   1384: iload 7
    //   1386: ifne +1296 -> 2682
    //   1389: ldc_w 733
    //   1392: aload 22
    //   1394: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1397: iload 5
    //   1399: invokeinterface 712 2 0
    //   1404: checkcast 668	com/google/android/android/internal/zzcgh
    //   1407: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   1410: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1413: istore 14
    //   1415: iload 13
    //   1417: istore 15
    //   1419: iload 4
    //   1421: istore 6
    //   1423: iload 14
    //   1425: ifne +1257 -> 2682
    //   1428: aload_0
    //   1429: invokevirtual 202	com/google/android/android/internal/zzccw:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   1432: aload 22
    //   1434: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   1437: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   1440: bipush 11
    //   1442: ldc_w 739
    //   1445: aload 22
    //   1447: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1450: iload 5
    //   1452: invokeinterface 712 2 0
    //   1457: checkcast 668	com/google/android/android/internal/zzcgh
    //   1460: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   1463: iconst_0
    //   1464: invokevirtual 743	com/google/android/android/internal/zzcfw:add	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V
    //   1467: iload 13
    //   1469: istore 15
    //   1471: iload 4
    //   1473: istore 6
    //   1475: goto +1207 -> 2682
    //   1478: aload_0
    //   1479: invokevirtual 491	com/google/android/android/internal/zzccw:zzaui	()Lcom/google/android/android/internal/zzccq;
    //   1482: aload 22
    //   1484: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   1487: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   1490: aload 22
    //   1492: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1495: iload 5
    //   1497: invokeinterface 712 2 0
    //   1502: checkcast 668	com/google/android/android/internal/zzcgh
    //   1505: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   1508: invokevirtual 746	com/google/android/android/internal/zzccq:zzap	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1511: istore 16
    //   1513: iload 16
    //   1515: ifne +40 -> 1555
    //   1518: aload_0
    //   1519: invokevirtual 202	com/google/android/android/internal/zzccw:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   1522: pop
    //   1523: aload 22
    //   1525: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1528: iload 5
    //   1530: invokeinterface 712 2 0
    //   1535: checkcast 668	com/google/android/android/internal/zzcgh
    //   1538: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   1541: invokestatic 749	com/google/android/android/internal/zzcfw:zzki	(Ljava/lang/String;)Z
    //   1544: istore 14
    //   1546: iload 13
    //   1548: istore 15
    //   1550: iload 14
    //   1552: ifeq +1101 -> 2653
    //   1555: aload 22
    //   1557: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1560: iload 5
    //   1562: invokeinterface 712 2 0
    //   1567: checkcast 668	com/google/android/android/internal/zzcgh
    //   1570: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   1573: astore_1
    //   1574: aload_1
    //   1575: ifnonnull +25 -> 1600
    //   1578: aload 22
    //   1580: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1583: iload 5
    //   1585: invokeinterface 712 2 0
    //   1590: checkcast 668	com/google/android/android/internal/zzcgh
    //   1593: iconst_0
    //   1594: anewarray 755	com/google/android/android/internal/zzcgi
    //   1597: putfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   1600: aload 22
    //   1602: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1605: iload 5
    //   1607: invokeinterface 712 2 0
    //   1612: checkcast 668	com/google/android/android/internal/zzcgh
    //   1615: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   1618: astore_1
    //   1619: aload_1
    //   1620: arraylength
    //   1621: istore 10
    //   1623: iconst_0
    //   1624: istore 7
    //   1626: iconst_0
    //   1627: istore 8
    //   1629: iconst_0
    //   1630: istore 6
    //   1632: iload 7
    //   1634: iload 10
    //   1636: if_icmpge +93 -> 1729
    //   1639: aload_1
    //   1640: iload 7
    //   1642: aaload
    //   1643: astore 17
    //   1645: ldc_w 757
    //   1648: aload 17
    //   1650: getfield 758	com/google/android/android/internal/zzcgi:name	Ljava/lang/String;
    //   1653: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1656: istore 14
    //   1658: iload 14
    //   1660: ifeq +18 -> 1678
    //   1663: aload 17
    //   1665: lconst_1
    //   1666: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1669: putfield 761	com/google/android/android/internal/zzcgi:zzizb	Ljava/lang/Long;
    //   1672: iconst_1
    //   1673: istore 9
    //   1675: goto +41 -> 1716
    //   1678: ldc_w 763
    //   1681: aload 17
    //   1683: getfield 758	com/google/android/android/internal/zzcgi:name	Ljava/lang/String;
    //   1686: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1689: istore 14
    //   1691: iload 8
    //   1693: istore 9
    //   1695: iload 14
    //   1697: ifeq +19 -> 1716
    //   1700: aload 17
    //   1702: lconst_1
    //   1703: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1706: putfield 761	com/google/android/android/internal/zzcgi:zzizb	Ljava/lang/Long;
    //   1709: iconst_1
    //   1710: istore 6
    //   1712: iload 8
    //   1714: istore 9
    //   1716: iload 7
    //   1718: iconst_1
    //   1719: iadd
    //   1720: istore 7
    //   1722: iload 9
    //   1724: istore 8
    //   1726: goto -94 -> 1632
    //   1729: iload 8
    //   1731: ifne +155 -> 1886
    //   1734: iload 16
    //   1736: ifeq +150 -> 1886
    //   1739: aload_0
    //   1740: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   1743: invokevirtual 359	com/google/android/android/internal/zzcbw:zzayj	()Lcom/google/android/android/internal/zzcby;
    //   1746: ldc_w 765
    //   1749: aload_0
    //   1750: invokevirtual 722	com/google/android/android/internal/zzccw:zzaug	()Lcom/google/android/android/internal/zzcbu;
    //   1753: aload 22
    //   1755: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1758: iload 5
    //   1760: invokeinterface 712 2 0
    //   1765: checkcast 668	com/google/android/android/internal/zzcgh
    //   1768: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   1771: invokevirtual 725	com/google/android/android/internal/zzcbu:zzjc	(Ljava/lang/String;)Ljava/lang/String;
    //   1774: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1777: aload 22
    //   1779: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1782: iload 5
    //   1784: invokeinterface 712 2 0
    //   1789: checkcast 668	com/google/android/android/internal/zzcgh
    //   1792: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   1795: astore_1
    //   1796: aload 22
    //   1798: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1801: iload 5
    //   1803: invokeinterface 712 2 0
    //   1808: checkcast 668	com/google/android/android/internal/zzcgh
    //   1811: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   1814: arraylength
    //   1815: istore 7
    //   1817: aload_1
    //   1818: iload 7
    //   1820: iconst_1
    //   1821: iadd
    //   1822: invokestatic 771	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   1825: checkcast 772	[Lcom/google/android/android/internal/zzcgi;
    //   1828: astore_1
    //   1829: new 755	com/google/android/android/internal/zzcgi
    //   1832: dup
    //   1833: invokespecial 773	com/google/android/android/internal/zzcgi:<init>	()V
    //   1836: astore 17
    //   1838: aload 17
    //   1840: ldc_w 757
    //   1843: putfield 758	com/google/android/android/internal/zzcgi:name	Ljava/lang/String;
    //   1846: aload 17
    //   1848: lconst_1
    //   1849: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1852: putfield 761	com/google/android/android/internal/zzcgi:zzizb	Ljava/lang/Long;
    //   1855: aload_1
    //   1856: arraylength
    //   1857: istore 7
    //   1859: aload_1
    //   1860: iload 7
    //   1862: iconst_1
    //   1863: isub
    //   1864: aload 17
    //   1866: aastore
    //   1867: aload 22
    //   1869: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1872: iload 5
    //   1874: invokeinterface 712 2 0
    //   1879: checkcast 668	com/google/android/android/internal/zzcgh
    //   1882: aload_1
    //   1883: putfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   1886: iload 6
    //   1888: ifne +150 -> 2038
    //   1891: aload_0
    //   1892: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   1895: invokevirtual 359	com/google/android/android/internal/zzcbw:zzayj	()Lcom/google/android/android/internal/zzcby;
    //   1898: ldc_w 775
    //   1901: aload_0
    //   1902: invokevirtual 722	com/google/android/android/internal/zzccw:zzaug	()Lcom/google/android/android/internal/zzcbu;
    //   1905: aload 22
    //   1907: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1910: iload 5
    //   1912: invokeinterface 712 2 0
    //   1917: checkcast 668	com/google/android/android/internal/zzcgh
    //   1920: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   1923: invokevirtual 725	com/google/android/android/internal/zzcbu:zzjc	(Ljava/lang/String;)Ljava/lang/String;
    //   1926: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1929: aload 22
    //   1931: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1934: iload 5
    //   1936: invokeinterface 712 2 0
    //   1941: checkcast 668	com/google/android/android/internal/zzcgh
    //   1944: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   1947: astore_1
    //   1948: aload 22
    //   1950: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   1953: iload 5
    //   1955: invokeinterface 712 2 0
    //   1960: checkcast 668	com/google/android/android/internal/zzcgh
    //   1963: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   1966: arraylength
    //   1967: istore 6
    //   1969: aload_1
    //   1970: iload 6
    //   1972: iconst_1
    //   1973: iadd
    //   1974: invokestatic 771	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   1977: checkcast 772	[Lcom/google/android/android/internal/zzcgi;
    //   1980: astore_1
    //   1981: new 755	com/google/android/android/internal/zzcgi
    //   1984: dup
    //   1985: invokespecial 773	com/google/android/android/internal/zzcgi:<init>	()V
    //   1988: astore 17
    //   1990: aload 17
    //   1992: ldc_w 763
    //   1995: putfield 758	com/google/android/android/internal/zzcgi:name	Ljava/lang/String;
    //   1998: aload 17
    //   2000: lconst_1
    //   2001: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2004: putfield 761	com/google/android/android/internal/zzcgi:zzizb	Ljava/lang/Long;
    //   2007: aload_1
    //   2008: arraylength
    //   2009: istore 6
    //   2011: aload_1
    //   2012: iload 6
    //   2014: iconst_1
    //   2015: isub
    //   2016: aload 17
    //   2018: aastore
    //   2019: aload 22
    //   2021: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   2024: iload 5
    //   2026: invokeinterface 712 2 0
    //   2031: checkcast 668	com/google/android/android/internal/zzcgh
    //   2034: aload_1
    //   2035: putfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2038: aload_0
    //   2039: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   2042: aload_0
    //   2043: invokespecial 778	com/google/android/android/internal/zzccw:zzazf	()J
    //   2046: aload 22
    //   2048: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2051: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2054: iconst_0
    //   2055: iconst_0
    //   2056: iconst_0
    //   2057: iconst_0
    //   2058: iconst_1
    //   2059: invokevirtual 782	com/google/android/android/internal/zzcay:findAll	(JLjava/lang/String;ZZZZZ)Lcom/google/android/android/internal/zzcaz;
    //   2062: getfield 787	com/google/android/android/internal/zzcaz:zzinc	J
    //   2065: lstore_2
    //   2066: aload_0
    //   2067: getfield 124	com/google/android/android/internal/zzccw:zziss	Lcom/google/android/android/internal/zzcax;
    //   2070: aload 22
    //   2072: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2075: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2078: invokevirtual 791	com/google/android/android/internal/zzcax:zzis	(Ljava/lang/String;)I
    //   2081: i2l
    //   2082: lstore 11
    //   2084: lload_2
    //   2085: lload 11
    //   2087: lcmp
    //   2088: ifle +162 -> 2250
    //   2091: aload 22
    //   2093: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   2096: iload 5
    //   2098: invokeinterface 712 2 0
    //   2103: checkcast 668	com/google/android/android/internal/zzcgh
    //   2106: astore_1
    //   2107: iconst_0
    //   2108: istore 6
    //   2110: aload_1
    //   2111: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2114: arraylength
    //   2115: istore 7
    //   2117: iload 13
    //   2119: istore 14
    //   2121: iload 6
    //   2123: iload 7
    //   2125: if_icmpge +128 -> 2253
    //   2128: ldc_w 763
    //   2131: aload_1
    //   2132: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2135: iload 6
    //   2137: aaload
    //   2138: getfield 758	com/google/android/android/internal/zzcgi:name	Ljava/lang/String;
    //   2141: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2144: istore 14
    //   2146: iload 14
    //   2148: ifeq +93 -> 2241
    //   2151: aload_1
    //   2152: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2155: astore 19
    //   2157: aload 19
    //   2159: arraylength
    //   2160: istore 7
    //   2162: iload 7
    //   2164: iconst_1
    //   2165: isub
    //   2166: anewarray 755	com/google/android/android/internal/zzcgi
    //   2169: astore 17
    //   2171: iload 6
    //   2173: ifle +14 -> 2187
    //   2176: aload 19
    //   2178: iconst_0
    //   2179: aload 17
    //   2181: iconst_0
    //   2182: iload 6
    //   2184: invokestatic 797	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2187: aload 17
    //   2189: arraylength
    //   2190: istore 7
    //   2192: iload 6
    //   2194: iload 7
    //   2196: if_icmpge +32 -> 2228
    //   2199: aload_1
    //   2200: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2203: astore 19
    //   2205: aload 17
    //   2207: arraylength
    //   2208: istore 7
    //   2210: aload 19
    //   2212: iload 6
    //   2214: iconst_1
    //   2215: iadd
    //   2216: aload 17
    //   2218: iload 6
    //   2220: iload 7
    //   2222: iload 6
    //   2224: isub
    //   2225: invokestatic 797	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2228: aload_1
    //   2229: aload 17
    //   2231: putfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2234: iload 13
    //   2236: istore 14
    //   2238: goto +15 -> 2253
    //   2241: iload 6
    //   2243: iconst_1
    //   2244: iadd
    //   2245: istore 6
    //   2247: goto -137 -> 2110
    //   2250: iconst_1
    //   2251: istore 14
    //   2253: aload 22
    //   2255: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   2258: iload 5
    //   2260: invokeinterface 712 2 0
    //   2265: checkcast 668	com/google/android/android/internal/zzcgh
    //   2268: getfield 673	com/google/android/android/internal/zzcgh:name	Ljava/lang/String;
    //   2271: invokestatic 800	com/google/android/android/internal/zzcfw:zzju	(Ljava/lang/String;)Z
    //   2274: istore 13
    //   2276: iload 14
    //   2278: istore 15
    //   2280: iload 13
    //   2282: ifeq +371 -> 2653
    //   2285: iload 14
    //   2287: istore 15
    //   2289: iload 16
    //   2291: ifeq +362 -> 2653
    //   2294: aload_0
    //   2295: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   2298: aload_0
    //   2299: invokespecial 778	com/google/android/android/internal/zzccw:zzazf	()J
    //   2302: aload 22
    //   2304: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2307: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2310: iconst_0
    //   2311: iconst_0
    //   2312: iconst_1
    //   2313: iconst_0
    //   2314: iconst_0
    //   2315: invokevirtual 782	com/google/android/android/internal/zzcay:findAll	(JLjava/lang/String;ZZZZZ)Lcom/google/android/android/internal/zzcaz;
    //   2318: getfield 803	com/google/android/android/internal/zzcaz:zzina	J
    //   2321: lstore_2
    //   2322: aload_0
    //   2323: getfield 124	com/google/android/android/internal/zzccw:zziss	Lcom/google/android/android/internal/zzcax;
    //   2326: aload 22
    //   2328: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2331: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2334: getstatic 806	com/google/android/android/internal/zzcbm:zzioo	Lcom/google/android/android/internal/zzcbn;
    //   2337: invokevirtual 810	com/google/android/android/internal/zzcax:next	(Ljava/lang/String;Lcom/google/android/android/internal/zzcbn;)I
    //   2340: i2l
    //   2341: lstore 11
    //   2343: iload 14
    //   2345: istore 15
    //   2347: lload_2
    //   2348: lload 11
    //   2350: lcmp
    //   2351: ifle +302 -> 2653
    //   2354: aload_0
    //   2355: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   2358: invokevirtual 364	com/google/android/android/internal/zzcbw:zzayf	()Lcom/google/android/android/internal/zzcby;
    //   2361: ldc_w 812
    //   2364: aload 22
    //   2366: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2369: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2372: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   2375: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2378: aload 22
    //   2380: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   2383: iload 5
    //   2385: invokeinterface 712 2 0
    //   2390: checkcast 668	com/google/android/android/internal/zzcgh
    //   2393: astore 19
    //   2395: aload 19
    //   2397: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2400: astore 20
    //   2402: aload 20
    //   2404: arraylength
    //   2405: istore 8
    //   2407: iconst_0
    //   2408: istore 6
    //   2410: iconst_0
    //   2411: istore 7
    //   2413: aconst_null
    //   2414: astore_1
    //   2415: iload 6
    //   2417: iload 8
    //   2419: if_icmpge +70 -> 2489
    //   2422: aload 20
    //   2424: iload 6
    //   2426: aaload
    //   2427: astore 17
    //   2429: ldc_w 757
    //   2432: aload 17
    //   2434: getfield 758	com/google/android/android/internal/zzcgi:name	Ljava/lang/String;
    //   2437: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2440: istore 13
    //   2442: iload 13
    //   2444: ifeq +6 -> 2450
    //   2447: goto +30 -> 2477
    //   2450: ldc_w 733
    //   2453: aload 17
    //   2455: getfield 758	com/google/android/android/internal/zzcgi:name	Ljava/lang/String;
    //   2458: invokevirtual 737	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2461: istore 13
    //   2463: aload_1
    //   2464: astore 17
    //   2466: iload 13
    //   2468: ifeq +9 -> 2477
    //   2471: iconst_1
    //   2472: istore 7
    //   2474: aload_1
    //   2475: astore 17
    //   2477: iload 6
    //   2479: iconst_1
    //   2480: iadd
    //   2481: istore 6
    //   2483: aload 17
    //   2485: astore_1
    //   2486: goto -71 -> 2415
    //   2489: iload 7
    //   2491: ifeq +103 -> 2594
    //   2494: aload_1
    //   2495: ifnull +99 -> 2594
    //   2498: aload 19
    //   2500: getfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2503: astore 17
    //   2505: aload 17
    //   2507: arraylength
    //   2508: istore 6
    //   2510: iload 6
    //   2512: iconst_1
    //   2513: isub
    //   2514: anewarray 755	com/google/android/android/internal/zzcgi
    //   2517: astore 20
    //   2519: aload 17
    //   2521: arraylength
    //   2522: istore 9
    //   2524: iconst_0
    //   2525: istore 6
    //   2527: iconst_0
    //   2528: istore 7
    //   2530: iload 6
    //   2532: iload 9
    //   2534: if_icmpge +46 -> 2580
    //   2537: aload 17
    //   2539: iload 6
    //   2541: aaload
    //   2542: astore 21
    //   2544: iload 7
    //   2546: istore 8
    //   2548: aload 21
    //   2550: aload_1
    //   2551: if_acmpeq +16 -> 2567
    //   2554: aload 20
    //   2556: iload 7
    //   2558: aload 21
    //   2560: aastore
    //   2561: iload 7
    //   2563: iconst_1
    //   2564: iadd
    //   2565: istore 8
    //   2567: iload 6
    //   2569: iconst_1
    //   2570: iadd
    //   2571: istore 6
    //   2573: iload 8
    //   2575: istore 7
    //   2577: goto -47 -> 2530
    //   2580: aload 19
    //   2582: aload 20
    //   2584: putfield 753	com/google/android/android/internal/zzcgh:zziyx	[Lcom/google/android/android/internal/zzcgi;
    //   2587: iload 14
    //   2589: istore 15
    //   2591: goto +62 -> 2653
    //   2594: aload_1
    //   2595: ifnull +27 -> 2622
    //   2598: aload_1
    //   2599: ldc_w 733
    //   2602: putfield 758	com/google/android/android/internal/zzcgi:name	Ljava/lang/String;
    //   2605: aload_1
    //   2606: ldc2_w 813
    //   2609: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2612: putfield 761	com/google/android/android/internal/zzcgi:zzizb	Ljava/lang/Long;
    //   2615: iload 14
    //   2617: istore 15
    //   2619: goto +34 -> 2653
    //   2622: aload_0
    //   2623: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   2626: invokevirtual 312	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   2629: ldc_w 816
    //   2632: aload 22
    //   2634: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2637: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2640: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   2643: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2646: iload 14
    //   2648: istore 15
    //   2650: goto +3 -> 2653
    //   2653: aload 18
    //   2655: getfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   2658: iload 4
    //   2660: aload 22
    //   2662: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   2665: iload 5
    //   2667: invokeinterface 712 2 0
    //   2672: checkcast 668	com/google/android/android/internal/zzcgh
    //   2675: aastore
    //   2676: iload 4
    //   2678: iconst_1
    //   2679: iadd
    //   2680: istore 6
    //   2682: iload 5
    //   2684: iconst_1
    //   2685: iadd
    //   2686: istore 5
    //   2688: iload 15
    //   2690: istore 13
    //   2692: iload 6
    //   2694: istore 4
    //   2696: goto -1484 -> 1212
    //   2699: aload 22
    //   2701: getfield 690	com/google/android/android/internal/zzccw$zza:zzaoc	Ljava/util/List;
    //   2704: invokeinterface 701 1 0
    //   2709: istore 5
    //   2711: iload 4
    //   2713: iload 5
    //   2715: if_icmpge +21 -> 2736
    //   2718: aload 18
    //   2720: aload 18
    //   2722: getfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   2725: iload 4
    //   2727: invokestatic 771	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   2730: checkcast 817	[Lcom/google/android/android/internal/zzcgh;
    //   2733: putfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   2736: aload 18
    //   2738: aload_0
    //   2739: aload 22
    //   2741: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2744: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2747: aload 22
    //   2749: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2752: getfield 821	com/google/android/android/internal/zzcgk:zzizg	[Lcom/google/android/android/internal/zzcgm;
    //   2755: aload 18
    //   2757: getfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   2760: invokespecial 823	com/google/android/android/internal/zzccw:getJSONObject	(Ljava/lang/String;[Lcom/google/android/android/internal/zzcgm;[Lcom/google/android/android/internal/zzcgh;)[Lcom/google/android/android/internal/zzcgg;
    //   2763: putfield 827	com/google/android/android/internal/zzcgk:zzizy	[Lcom/google/android/android/internal/zzcgg;
    //   2766: aload 18
    //   2768: ldc2_w 828
    //   2771: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2774: putfield 832	com/google/android/android/internal/zzcgk:zzizi	Ljava/lang/Long;
    //   2777: aload 18
    //   2779: ldc2_w 833
    //   2782: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2785: putfield 837	com/google/android/android/internal/zzcgk:zzizj	Ljava/lang/Long;
    //   2788: iconst_0
    //   2789: istore 4
    //   2791: aload 18
    //   2793: getfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   2796: astore_1
    //   2797: aload_1
    //   2798: arraylength
    //   2799: istore 5
    //   2801: iload 4
    //   2803: iload 5
    //   2805: if_icmpge +85 -> 2890
    //   2808: aload_1
    //   2809: iload 4
    //   2811: aaload
    //   2812: astore_1
    //   2813: aload_1
    //   2814: getfield 677	com/google/android/android/internal/zzcgh:zziyy	Ljava/lang/Long;
    //   2817: invokevirtual 840	java/lang/Long:longValue	()J
    //   2820: lstore_2
    //   2821: aload 18
    //   2823: getfield 832	com/google/android/android/internal/zzcgk:zzizi	Ljava/lang/Long;
    //   2826: invokevirtual 840	java/lang/Long:longValue	()J
    //   2829: lstore 11
    //   2831: lload_2
    //   2832: lload 11
    //   2834: lcmp
    //   2835: ifge +12 -> 2847
    //   2838: aload 18
    //   2840: aload_1
    //   2841: getfield 677	com/google/android/android/internal/zzcgh:zziyy	Ljava/lang/Long;
    //   2844: putfield 832	com/google/android/android/internal/zzcgk:zzizi	Ljava/lang/Long;
    //   2847: aload_1
    //   2848: getfield 677	com/google/android/android/internal/zzcgh:zziyy	Ljava/lang/Long;
    //   2851: invokevirtual 840	java/lang/Long:longValue	()J
    //   2854: lstore_2
    //   2855: aload 18
    //   2857: getfield 837	com/google/android/android/internal/zzcgk:zzizj	Ljava/lang/Long;
    //   2860: invokevirtual 840	java/lang/Long:longValue	()J
    //   2863: lstore 11
    //   2865: lload_2
    //   2866: lload 11
    //   2868: lcmp
    //   2869: ifle +12 -> 2881
    //   2872: aload 18
    //   2874: aload_1
    //   2875: getfield 677	com/google/android/android/internal/zzcgh:zziyy	Ljava/lang/Long;
    //   2878: putfield 837	com/google/android/android/internal/zzcgk:zzizj	Ljava/lang/Long;
    //   2881: iload 4
    //   2883: iconst_1
    //   2884: iadd
    //   2885: istore 4
    //   2887: goto -96 -> 2791
    //   2890: aload 22
    //   2892: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2895: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2898: astore 19
    //   2900: aload_0
    //   2901: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   2904: aload 19
    //   2906: invokevirtual 844	com/google/android/android/internal/zzcay:zziw	(Ljava/lang/String;)Lcom/google/android/android/internal/zzcar;
    //   2909: astore 17
    //   2911: aload 17
    //   2913: ifnonnull +30 -> 2943
    //   2916: aload_0
    //   2917: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   2920: invokevirtual 312	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   2923: ldc_w 846
    //   2926: aload 22
    //   2928: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   2931: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   2934: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   2937: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2940: goto +156 -> 3096
    //   2943: aload 18
    //   2945: getfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   2948: arraylength
    //   2949: istore 4
    //   2951: iload 4
    //   2953: ifle +143 -> 3096
    //   2956: aload 17
    //   2958: invokevirtual 849	com/google/android/android/internal/zzcar:zzaus	()J
    //   2961: lstore 11
    //   2963: lload 11
    //   2965: lstore_2
    //   2966: lload 11
    //   2968: lconst_0
    //   2969: lcmp
    //   2970: ifeq +12 -> 2982
    //   2973: lload 11
    //   2975: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2978: astore_1
    //   2979: goto +5 -> 2984
    //   2982: aconst_null
    //   2983: astore_1
    //   2984: aload 18
    //   2986: aload_1
    //   2987: putfield 852	com/google/android/android/internal/zzcgk:zzizl	Ljava/lang/Long;
    //   2990: aload 17
    //   2992: invokevirtual 855	com/google/android/android/internal/zzcar:zzaur	()J
    //   2995: lstore 11
    //   2997: lload 11
    //   2999: lconst_0
    //   3000: lcmp
    //   3001: ifne +6 -> 3007
    //   3004: goto +6 -> 3010
    //   3007: lload 11
    //   3009: lstore_2
    //   3010: lload_2
    //   3011: lconst_0
    //   3012: lcmp
    //   3013: ifeq +11 -> 3024
    //   3016: lload_2
    //   3017: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3020: astore_1
    //   3021: goto +5 -> 3026
    //   3024: aconst_null
    //   3025: astore_1
    //   3026: aload 18
    //   3028: aload_1
    //   3029: putfield 858	com/google/android/android/internal/zzcgk:zzizk	Ljava/lang/Long;
    //   3032: aload 17
    //   3034: invokevirtual 861	com/google/android/android/internal/zzcar:zzavb	()V
    //   3037: aload 18
    //   3039: aload 17
    //   3041: invokevirtual 864	com/google/android/android/internal/zzcar:zzauy	()J
    //   3044: l2i
    //   3045: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3048: putfield 868	com/google/android/android/internal/zzcgk:zzizw	Ljava/lang/Integer;
    //   3051: aload 17
    //   3053: aload 18
    //   3055: getfield 832	com/google/android/android/internal/zzcgk:zzizi	Ljava/lang/Long;
    //   3058: invokevirtual 840	java/lang/Long:longValue	()J
    //   3061: invokevirtual 872	com/google/android/android/internal/zzcar:zzal	(J)V
    //   3064: aload 17
    //   3066: aload 18
    //   3068: getfield 837	com/google/android/android/internal/zzcgk:zzizj	Ljava/lang/Long;
    //   3071: invokevirtual 840	java/lang/Long:longValue	()J
    //   3074: invokevirtual 875	com/google/android/android/internal/zzcar:zzam	(J)V
    //   3077: aload 18
    //   3079: aload 17
    //   3081: invokevirtual 878	com/google/android/android/internal/zzcar:zzavj	()Ljava/lang/String;
    //   3084: putfield 881	com/google/android/android/internal/zzcgk:zzily	Ljava/lang/String;
    //   3087: aload_0
    //   3088: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3091: aload 17
    //   3093: invokevirtual 884	com/google/android/android/internal/zzcay:insertMessage	(Lcom/google/android/android/internal/zzcar;)V
    //   3096: aload 18
    //   3098: getfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   3101: arraylength
    //   3102: istore 4
    //   3104: iload 4
    //   3106: ifle +117 -> 3223
    //   3109: invokestatic 169	com/google/android/android/internal/zzcax:zzawk	()Z
    //   3112: pop
    //   3113: aload_0
    //   3114: invokevirtual 491	com/google/android/android/internal/zzccw:zzaui	()Lcom/google/android/android/internal/zzccq;
    //   3117: aload 22
    //   3119: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   3122: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   3125: invokevirtual 495	com/google/android/android/internal/zzccq:zzjn	(Ljava/lang/String;)Lcom/google/android/android/internal/zzcge;
    //   3128: astore_1
    //   3129: aload_1
    //   3130: ifnull +29 -> 3159
    //   3133: aload_1
    //   3134: getfield 889	com/google/android/android/internal/zzcge:zziym	Ljava/lang/Long;
    //   3137: astore 17
    //   3139: aload 17
    //   3141: astore_1
    //   3142: aload 17
    //   3144: ifnonnull +6 -> 3150
    //   3147: goto +12 -> 3159
    //   3150: aload 18
    //   3152: aload_1
    //   3153: putfield 892	com/google/android/android/internal/zzcgk:zzjad	Ljava/lang/Long;
    //   3156: goto +55 -> 3211
    //   3159: aload 22
    //   3161: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   3164: getfield 895	com/google/android/android/internal/zzcgk:zzilu	Ljava/lang/String;
    //   3167: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3170: istore 14
    //   3172: iload 14
    //   3174: ifeq +13 -> 3187
    //   3177: ldc2_w 98
    //   3180: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3183: astore_1
    //   3184: goto -34 -> 3150
    //   3187: aload_0
    //   3188: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   3191: invokevirtual 364	com/google/android/android/internal/zzcbw:zzayf	()Lcom/google/android/android/internal/zzcby;
    //   3194: ldc_w 897
    //   3197: aload 22
    //   3199: getfield 698	com/google/android/android/internal/zzccw$zza:zziue	Lcom/google/android/android/internal/zzcgk;
    //   3202: getfield 708	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   3205: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   3208: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   3211: aload_0
    //   3212: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3215: aload 18
    //   3217: iload 13
    //   3219: invokevirtual 901	com/google/android/android/internal/zzcay:saveToFile	(Lcom/google/android/android/internal/zzcgk;Z)Z
    //   3222: pop
    //   3223: aload_0
    //   3224: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3227: aload 22
    //   3229: getfield 904	com/google/android/android/internal/zzccw$zza:zziuf	Ljava/util/List;
    //   3232: invokevirtual 908	com/google/android/android/internal/zzcay:zzae	(Ljava/util/List;)V
    //   3235: aload_0
    //   3236: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3239: astore_1
    //   3240: aload_1
    //   3241: invokevirtual 562	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   3244: astore 17
    //   3246: iconst_1
    //   3247: istore 13
    //   3249: aload 17
    //   3251: ldc_w 910
    //   3254: iconst_2
    //   3255: anewarray 210	java/lang/String
    //   3258: dup
    //   3259: iconst_0
    //   3260: aload 19
    //   3262: aastore
    //   3263: dup
    //   3264: iconst_1
    //   3265: aload 19
    //   3267: aastore
    //   3268: invokevirtual 914	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   3271: goto +28 -> 3299
    //   3274: astore 17
    //   3276: goto +3 -> 3279
    //   3279: aload_1
    //   3280: invokevirtual 621	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   3283: invokevirtual 312	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   3286: ldc_w 916
    //   3289: aload 19
    //   3291: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   3294: aload 17
    //   3296: invokevirtual 322	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   3299: aload_0
    //   3300: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3303: invokevirtual 919	com/google/android/android/internal/zzcay:setTransactionSuccessful	()V
    //   3306: aload 18
    //   3308: getfield 705	com/google/android/android/internal/zzcgk:zzizf	[Lcom/google/android/android/internal/zzcgh;
    //   3311: arraylength
    //   3312: istore 4
    //   3314: iload 4
    //   3316: ifle +6 -> 3322
    //   3319: goto +6 -> 3325
    //   3322: iconst_0
    //   3323: istore 13
    //   3325: aload_0
    //   3326: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3329: invokevirtual 922	com/google/android/android/internal/zzcay:endTransaction	()V
    //   3332: iload 13
    //   3334: ireturn
    //   3335: aload_0
    //   3336: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3339: invokevirtual 919	com/google/android/android/internal/zzcay:setTransactionSuccessful	()V
    //   3342: aload_0
    //   3343: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3346: invokevirtual 922	com/google/android/android/internal/zzcay:endTransaction	()V
    //   3349: iconst_0
    //   3350: ireturn
    //   3351: astore 17
    //   3353: aload 19
    //   3355: astore_1
    //   3356: aload_1
    //   3357: ifnull +9 -> 3366
    //   3360: aload_1
    //   3361: invokeinterface 596 1 0
    //   3366: aload 17
    //   3368: athrow
    //   3369: astore_1
    //   3370: aload_0
    //   3371: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   3374: invokevirtual 922	com/google/android/android/internal/zzcay:endTransaction	()V
    //   3377: goto +3 -> 3380
    //   3380: aload_1
    //   3381: athrow
    // Exception table:
    //   from	to	target	type
    //   80	86	109	java/lang/Throwable
    //   221	230	109	java/lang/Throwable
    //   252	262	109	java/lang/Throwable
    //   269	279	109	java/lang/Throwable
    //   282	289	109	java/lang/Throwable
    //   435	444	109	java/lang/Throwable
    //   459	469	109	java/lang/Throwable
    //   476	483	109	java/lang/Throwable
    //   269	279	304	android/database/sqlite/SQLiteException
    //   282	289	304	android/database/sqlite/SQLiteException
    //   551	570	579	java/lang/Throwable
    //   649	668	579	java/lang/Throwable
    //   692	698	579	java/lang/Throwable
    //   551	570	584	android/database/sqlite/SQLiteException
    //   649	668	584	android/database/sqlite/SQLiteException
    //   883	890	944	java/io/IOException
    //   801	810	982	java/lang/Throwable
    //   815	834	982	java/lang/Throwable
    //   844	862	982	java/lang/Throwable
    //   862	866	982	java/lang/Throwable
    //   866	875	982	java/lang/Throwable
    //   875	883	982	java/lang/Throwable
    //   883	890	982	java/lang/Throwable
    //   890	900	982	java/lang/Throwable
    //   900	906	982	java/lang/Throwable
    //   906	916	982	java/lang/Throwable
    //   925	936	982	java/lang/Throwable
    //   945	965	982	java/lang/Throwable
    //   965	974	982	java/lang/Throwable
    //   801	810	994	android/database/sqlite/SQLiteException
    //   815	834	994	android/database/sqlite/SQLiteException
    //   844	862	994	android/database/sqlite/SQLiteException
    //   866	875	994	android/database/sqlite/SQLiteException
    //   875	883	994	android/database/sqlite/SQLiteException
    //   883	890	994	android/database/sqlite/SQLiteException
    //   890	900	994	android/database/sqlite/SQLiteException
    //   906	916	994	android/database/sqlite/SQLiteException
    //   925	936	994	android/database/sqlite/SQLiteException
    //   945	965	994	android/database/sqlite/SQLiteException
    //   965	974	994	android/database/sqlite/SQLiteException
    //   628	636	998	java/io/IOException
    //   753	801	1033	android/database/sqlite/SQLiteException
    //   1003	1024	1033	android/database/sqlite/SQLiteException
    //   538	546	1038	java/lang/Throwable
    //   595	604	1038	java/lang/Throwable
    //   604	609	1038	java/lang/Throwable
    //   609	619	1038	java/lang/Throwable
    //   619	628	1038	java/lang/Throwable
    //   628	636	1038	java/lang/Throwable
    //   636	644	1038	java/lang/Throwable
    //   668	683	1038	java/lang/Throwable
    //   732	738	1038	java/lang/Throwable
    //   538	546	1043	android/database/sqlite/SQLiteException
    //   595	604	1043	android/database/sqlite/SQLiteException
    //   609	619	1043	android/database/sqlite/SQLiteException
    //   619	628	1043	android/database/sqlite/SQLiteException
    //   628	636	1043	android/database/sqlite/SQLiteException
    //   636	644	1043	android/database/sqlite/SQLiteException
    //   668	683	1043	android/database/sqlite/SQLiteException
    //   494	538	1054	java/lang/Throwable
    //   494	538	1066	android/database/sqlite/SQLiteException
    //   221	230	1070	android/database/sqlite/SQLiteException
    //   252	262	1070	android/database/sqlite/SQLiteException
    //   435	444	1070	android/database/sqlite/SQLiteException
    //   459	469	1070	android/database/sqlite/SQLiteException
    //   476	483	1070	android/database/sqlite/SQLiteException
    //   48	61	1085	java/lang/Throwable
    //   123	128	1085	java/lang/Throwable
    //   149	156	1085	java/lang/Throwable
    //   156	210	1085	java/lang/Throwable
    //   321	326	1085	java/lang/Throwable
    //   341	346	1085	java/lang/Throwable
    //   364	371	1085	java/lang/Throwable
    //   371	424	1085	java/lang/Throwable
    //   48	61	1092	android/database/sqlite/SQLiteException
    //   149	156	1092	android/database/sqlite/SQLiteException
    //   156	210	1092	android/database/sqlite/SQLiteException
    //   364	371	1092	android/database/sqlite/SQLiteException
    //   371	424	1092	android/database/sqlite/SQLiteException
    //   3249	3271	3274	android/database/sqlite/SQLiteException
    //   753	801	3351	java/lang/Throwable
    //   1003	1024	3351	java/lang/Throwable
    //   1103	1123	3351	java/lang/Throwable
    //   9	48	3369	java/lang/Throwable
    //   235	242	3369	java/lang/Throwable
    //   570	576	3369	java/lang/Throwable
    //   834	841	3369	java/lang/Throwable
    //   1024	1030	3369	java/lang/Throwable
    //   1134	1140	3369	java/lang/Throwable
    //   1144	1156	3369	java/lang/Throwable
    //   1178	1203	3369	java/lang/Throwable
    //   1212	1224	3369	java/lang/Throwable
    //   1231	1266	3369	java/lang/Throwable
    //   1271	1337	3369	java/lang/Throwable
    //   1342	1359	3369	java/lang/Throwable
    //   1389	1415	3369	java/lang/Throwable
    //   1428	1467	3369	java/lang/Throwable
    //   1478	1513	3369	java/lang/Throwable
    //   1518	1546	3369	java/lang/Throwable
    //   1555	1574	3369	java/lang/Throwable
    //   1578	1600	3369	java/lang/Throwable
    //   1600	1623	3369	java/lang/Throwable
    //   1645	1658	3369	java/lang/Throwable
    //   1663	1672	3369	java/lang/Throwable
    //   1678	1691	3369	java/lang/Throwable
    //   1700	1709	3369	java/lang/Throwable
    //   1739	1817	3369	java/lang/Throwable
    //   1817	1859	3369	java/lang/Throwable
    //   1867	1886	3369	java/lang/Throwable
    //   1891	1969	3369	java/lang/Throwable
    //   1969	2011	3369	java/lang/Throwable
    //   2019	2038	3369	java/lang/Throwable
    //   2038	2084	3369	java/lang/Throwable
    //   2091	2107	3369	java/lang/Throwable
    //   2110	2117	3369	java/lang/Throwable
    //   2128	2146	3369	java/lang/Throwable
    //   2151	2162	3369	java/lang/Throwable
    //   2162	2171	3369	java/lang/Throwable
    //   2176	2187	3369	java/lang/Throwable
    //   2187	2192	3369	java/lang/Throwable
    //   2199	2205	3369	java/lang/Throwable
    //   2205	2210	3369	java/lang/Throwable
    //   2210	2228	3369	java/lang/Throwable
    //   2228	2234	3369	java/lang/Throwable
    //   2253	2276	3369	java/lang/Throwable
    //   2294	2343	3369	java/lang/Throwable
    //   2354	2407	3369	java/lang/Throwable
    //   2429	2442	3369	java/lang/Throwable
    //   2450	2463	3369	java/lang/Throwable
    //   2498	2510	3369	java/lang/Throwable
    //   2510	2524	3369	java/lang/Throwable
    //   2580	2587	3369	java/lang/Throwable
    //   2598	2615	3369	java/lang/Throwable
    //   2622	2646	3369	java/lang/Throwable
    //   2653	2676	3369	java/lang/Throwable
    //   2699	2711	3369	java/lang/Throwable
    //   2718	2736	3369	java/lang/Throwable
    //   2736	2788	3369	java/lang/Throwable
    //   2791	2801	3369	java/lang/Throwable
    //   2813	2831	3369	java/lang/Throwable
    //   2838	2847	3369	java/lang/Throwable
    //   2847	2865	3369	java/lang/Throwable
    //   2872	2881	3369	java/lang/Throwable
    //   2890	2911	3369	java/lang/Throwable
    //   2916	2940	3369	java/lang/Throwable
    //   2943	2951	3369	java/lang/Throwable
    //   2956	2963	3369	java/lang/Throwable
    //   2973	2979	3369	java/lang/Throwable
    //   2984	2997	3369	java/lang/Throwable
    //   3016	3021	3369	java/lang/Throwable
    //   3026	3096	3369	java/lang/Throwable
    //   3096	3104	3369	java/lang/Throwable
    //   3109	3129	3369	java/lang/Throwable
    //   3133	3139	3369	java/lang/Throwable
    //   3150	3156	3369	java/lang/Throwable
    //   3159	3172	3369	java/lang/Throwable
    //   3177	3184	3369	java/lang/Throwable
    //   3187	3211	3369	java/lang/Throwable
    //   3211	3223	3369	java/lang/Throwable
    //   3223	3246	3369	java/lang/Throwable
    //   3249	3271	3369	java/lang/Throwable
    //   3279	3299	3369	java/lang/Throwable
    //   3299	3314	3369	java/lang/Throwable
    //   3335	3342	3369	java/lang/Throwable
    //   3360	3366	3369	java/lang/Throwable
    //   3366	3369	3369	java/lang/Throwable
  }
  
  public static void toJsonString(zzcdt paramZzcdt)
  {
    if (paramZzcdt != null) {
      return;
    }
    throw new IllegalStateException("Component not created");
  }
  
  private final int transferTo(FileChannel paramFileChannel)
  {
    zzauk().zzuj();
    if ((paramFileChannel != null) && (paramFileChannel.isOpen()))
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      try
      {
        paramFileChannel.position(0L);
        int i = paramFileChannel.read(localByteBuffer);
        if (i != 4)
        {
          if (i == -1) {
            break label109;
          }
          zzaul().zzayf().append("Unexpected data length. Bytes read", Integer.valueOf(i));
          return 0;
        }
        localByteBuffer.flip();
        i = localByteBuffer.getInt();
        return i;
      }
      catch (IOException paramFileChannel)
      {
        zzaul().zzayd().append("Failed to read from channel", paramFileChannel);
        return 0;
      }
    }
    zzaul().zzayd().append("Bad chanel to read from");
    label109:
    return 0;
  }
  
  private final void trim(zzcbf paramZzcbf, zzcas paramZzcas)
  {
    zzauk().zzuj();
    zzwk();
    zzbp.append(paramZzcbf);
    zzbp.append(paramZzcas);
    zzbp.zzgg(mAppId);
    zzbp.zzbh(mAppId.equals(packageName));
    zzcgk localZzcgk = new zzcgk();
    boolean bool1 = true;
    zzize = Integer.valueOf(1);
    zzizm = "android";
    zzci = packageName;
    zzilv = zzilv;
    zzhtt = zzhtt;
    long l = zzimb;
    if (l == -2147483648L) {
      localObject1 = null;
    } else {
      localObject1 = Integer.valueOf((int)l);
    }
    zzizz = ((Integer)localObject1);
    zzizq = Long.valueOf(zzilw);
    zzilu = zzilu;
    l = zzilx;
    if (l == 0L) {
      localObject1 = null;
    } else {
      localObject1 = Long.valueOf(l);
    }
    zzizv = ((Long)localObject1);
    Object localObject1 = zzaum().zzjh(packageName);
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)first)))
    {
      zzizs = ((String)first);
      zzizt = ((Boolean)second);
    }
    else if (!zzaub().zzdm(mContext))
    {
      String str = Settings.Secure.getString(mContext.getContentResolver(), "android_id");
      localObject1 = str;
      if (str == null)
      {
        zzaul().zzayf().append("null secure ID. appId", zzcbw.zzjf(zzci));
        localObject2 = "null";
      }
      else
      {
        localObject2 = localObject1;
        if (str.isEmpty())
        {
          zzaul().zzayf().append("empty secure ID. appId", zzcbw.zzjf(zzci));
          localObject2 = localObject1;
        }
      }
      zzjac = ((String)localObject2);
    }
    zzaub().zzwk();
    zzizn = Build.MODEL;
    zzaub().zzwk();
    zzcw = Build.VERSION.RELEASE;
    zzizp = Integer.valueOf((int)zzaub().zzaxw());
    zzizo = zzaub().zzaxx();
    zzizr = null;
    zzizh = null;
    zzizi = null;
    zzizj = null;
    zzjae = Long.valueOf(zzimd);
    if ((isEnabled()) && (zzcax.zzaxh()))
    {
      zzaua();
      zzjaf = null;
    }
    Object localObject2 = zzauf().zziw(packageName);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new zzcar(this, packageName);
      ((zzcar)localObject1).zzim(zzaua().zzaya());
      ((zzcar)localObject1).zzip(zzimc);
      ((zzcar)localObject1).zzin(zzilu);
      ((zzcar)localObject1).zzio(zzaum().zzji(packageName));
      ((zzcar)localObject1).zzaq(0L);
      ((zzcar)localObject1).zzal(0L);
      ((zzcar)localObject1).zzam(0L);
      ((zzcar)localObject1).setAppVersion(zzhtt);
      ((zzcar)localObject1).zzan(zzimb);
      ((zzcar)localObject1).zziq(zzilv);
      ((zzcar)localObject1).zzao(zzilw);
      ((zzcar)localObject1).zzap(zzilx);
      ((zzcar)localObject1).setMeasurementEnabled(zzilz);
      ((zzcar)localObject1).zzaz(zzimd);
      zzauf().insertMessage((zzcar)localObject1);
    }
    zzizu = ((zzcar)localObject1).getAppInstanceId();
    zzimc = ((zzcar)localObject1).zzauq();
    paramZzcas = zzauf().zziv(packageName);
    zzizg = new zzcgm[paramZzcas.size()];
    int i = 0;
    while (i < paramZzcas.size())
    {
      localObject1 = new zzcgm();
      zzizg[i] = localObject1;
      name = getmName;
      zzjaj = Long.valueOf(getzzixd);
      zzauh().trim((zzcgm)localObject1, getmValue);
      i += 1;
    }
    try
    {
      l = zzauf().insertMessage(localZzcgk);
      paramZzcas = zzauf();
      localObject1 = zzink;
      if (localObject1 != null)
      {
        localObject1 = ((zzcbh)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          if ("_r".equals((String)((Iterator)localObject1).next())) {
            break label932;
          }
        }
        boolean bool2 = zzaui().zzap(mAppId, mName);
        localObject1 = zzauf().findAll(zzazf(), mAppId, false, false, false, false, false);
        if ((bool2) && (zzinc < zziss.zzis(mAppId))) {}
      }
      else
      {
        bool1 = false;
      }
      label932:
      if (paramZzcas.persist(paramZzcbf, l, bool1))
      {
        zzity = 0L;
        return;
      }
    }
    catch (IOException paramZzcbf)
    {
      zzaul().zzayd().append("Data loss. Failed to insert raw event metadata. appId", zzcbw.zzjf(zzci), paramZzcbf);
    }
  }
  
  private final void update(zzcbk paramZzcbk, zzcas paramZzcas)
  {
    zzbp.append(paramZzcas);
    zzbp.zzgg(packageName);
    long l2 = System.nanoTime();
    zzauk().zzuj();
    zzwk();
    String str = packageName;
    zzauh();
    if (!zzcfw.d(paramZzcbk, paramZzcas)) {
      return;
    }
    if (!zzilz)
    {
      updateDatabase(paramZzcas);
      return;
    }
    boolean bool1 = zzaui().zzao(str, name);
    int i = 0;
    long l1;
    if (bool1)
    {
      zzaul().zzayf().append("Dropping blacklisted event. appId", zzcbw.zzjf(str), zzaug().zzjc(name));
      if ((zzauh().zzkg(str)) || (zzauh().zzkh(str))) {
        i = 1;
      }
      if ((i == 0) && (!"_err".equals(name))) {
        zzauh().add(str, 11, "_ev", name, 0);
      }
      if (i != 0)
      {
        paramZzcbk = zzauf().zziw(str);
        if (paramZzcbk != null)
        {
          l1 = Math.max(paramZzcbk.zzava(), paramZzcbk.zzauz());
          if (Math.abs(zzasc.currentTimeMillis() - l1) > zzcax.zzawo())
          {
            zzaul().zzayi().append("Fetching config for blacklisted app");
            getThreadId(paramZzcbk);
          }
        }
      }
    }
    else
    {
      if (zzaul().zzad(2)) {
        zzaul().zzayj().append("Logging event", zzaug().getRelativePath(paramZzcbk));
      }
      zzauf().beginTransaction();
      try
      {
        Bundle localBundle = zzinr.zzaxz();
        updateDatabase(paramZzcas);
        bool1 = "_iap".equals(name);
        if (!bool1)
        {
          bool1 = "ecommerce_purchase".equals(name);
          if (bool1) {}
        }
        for (;;)
        {
          break;
          localObject1 = localBundle.getString("currency");
          bool1 = "ecommerce_purchase".equals(name);
          if (bool1)
          {
            double d1 = localBundle.getDouble("value");
            double d2 = d1 * 1000000.0D;
            d1 = d2;
            if (d2 == 0.0D)
            {
              l1 = localBundle.getLong("value");
              d1 = l1;
              Double.isNaN(d1);
              d1 *= 1000000.0D;
            }
            if ((d1 <= 9.223372036854776E18D) && (d1 >= -9.223372036854776E18D))
            {
              l1 = Math.round(d1);
            }
            else
            {
              zzaul().zzayf().append("Data lost. Currency value is too big. appId", zzcbw.zzjf(str), Double.valueOf(d1));
              zzauf().setTransactionSuccessful();
              zzauf().endTransaction();
            }
          }
          else
          {
            l1 = localBundle.getLong("value");
          }
          bool1 = TextUtils.isEmpty((CharSequence)localObject1);
          if (!bool1)
          {
            localObject1 = ((String)localObject1).toUpperCase(Locale.US);
            bool1 = ((String)localObject1).matches("[A-Z]{3}");
            if (bool1)
            {
              i = ((String)localObject1).length();
              if (i != 0) {
                localObject1 = "_ltv_".concat((String)localObject1);
              } else {
                localObject1 = new String("_ltv_");
              }
              Object localObject2 = zzauf().zzah(str, (String)localObject1);
              if (localObject2 != null)
              {
                localObject2 = mValue;
                bool1 = localObject2 instanceof Long;
                if (bool1)
                {
                  l3 = ((Long)localObject2).longValue();
                  localObject2 = zzimg;
                  long l4 = zzasc.currentTimeMillis();
                  localObject1 = new zzcfv(str, (String)localObject2, (String)localObject1, l4, Long.valueOf(l3 + l1));
                  break label800;
                }
              }
              zzcay localZzcay = zzauf();
              i = zziss.next(str, zzcbm.zzipf);
              zzbp.zzgg(str);
              localZzcay.zzuj();
              localZzcay.zzwk();
              try
              {
                localObject2 = localZzcay.getWritableDatabase();
                try
                {
                  ((SQLiteDatabase)localObject2).execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[] { str, str, String.valueOf(i - 1) });
                }
                catch (SQLiteException localSQLiteException1) {}
                localZzcay.zzaul().zzayd().append("Error pruning currencies. appId", zzcbw.zzjf(str), localSQLiteException2);
              }
              catch (SQLiteException localSQLiteException2) {}
              localObject1 = new zzcfv(str, zzimg, (String)localObject1, zzasc.currentTimeMillis(), Long.valueOf(l1));
              label800:
              bool1 = zzauf().add((zzcfv)localObject1);
              if (!bool1)
              {
                zzaul().zzayd().attribute("Too many unique user properties are set. Ignoring user property. appId", zzcbw.zzjf(str), zzaug().zzje(mName), mValue);
                zzauh().add(str, 9, null, null, 0);
              }
            }
          }
        }
        bool1 = zzcfw.zzju(name);
        boolean bool2 = "_err".equals(name);
        Object localObject1 = zzauf().findAll(zzazf(), str, true, bool1, false, bool2, false);
        l1 = zzimz;
        long l3 = zzcax.zzavw();
        l1 -= l3;
        if (l1 > 0L)
        {
          if (l1 % 1000L == 1L) {
            zzaul().zzayd().append("Data loss. Too many events logged. appId, count", zzcbw.zzjf(str), Long.valueOf(zzimz));
          }
          zzauf().setTransactionSuccessful();
          zzauf().endTransaction();
          return;
        }
        if (bool1)
        {
          l1 = zzimy;
          l3 = zzcax.zzavx();
          l1 -= l3;
          if (l1 > 0L)
          {
            if (l1 % 1000L == 1L) {
              zzaul().zzayd().append("Data loss. Too many public events logged. appId, count", zzcbw.zzjf(str), Long.valueOf(zzimy));
            }
            zzauh().add(str, 16, "_ev", name, 0);
            zzauf().setTransactionSuccessful();
            zzauf().endTransaction();
            return;
          }
        }
        if (bool2)
        {
          l1 = zzinb;
          l3 = Math.max(0, Math.min(1000000, zziss.next(packageName, zzcbm.zziom)));
          l1 -= l3;
          if (l1 > 0L)
          {
            if (l1 == 1L) {
              zzaul().zzayd().append("Too many error events logged. appId, count", zzcbw.zzjf(str), Long.valueOf(zzinb));
            }
            zzauf().setTransactionSuccessful();
            zzauf().endTransaction();
            return;
          }
        }
        localObject1 = zzauh();
        Object localObject3 = zzimg;
        ((zzcfw)localObject1).add(localBundle, "_o", localObject3);
        bool1 = zzauh().zzke(str);
        if (bool1)
        {
          zzauh().add(localBundle, "_dbg", Long.valueOf(1L));
          zzauh().add(localBundle, "_r", Long.valueOf(1L));
        }
        l1 = zzauf().zzix(str);
        if (l1 > 0L) {
          zzaul().zzayf().append("Data lost. Too many events stored on disk, deleted. appId", zzcbw.zzjf(str), Long.valueOf(l1));
        }
        paramZzcbk = new zzcbf(this, zzimg, str, name, zzins, 0L, localBundle);
        localObject3 = zzauf().zzaf(str, mName);
        if (localObject3 == null)
        {
          l1 = zzauf().zzja(str);
          zzcax.zzavv();
          if (l1 >= 500L)
          {
            paramZzcas = zzaul().zzayd();
            localObject1 = zzcbw.zzjf(str);
            paramZzcbk = zzaug().zzjc(mName);
            zzcax.zzavv();
            paramZzcas.attribute("Too many event names used, ignoring event. appId, name, supported count", localObject1, paramZzcbk, Integer.valueOf(500));
            zzauh().add(str, 8, null, null, 0);
            zzauf().endTransaction();
            return;
          }
          localObject1 = new zzcbg(str, mName, 0L, 0L, zzfdc);
        }
        else
        {
          localObject1 = paramZzcbk.getSharedPreferences(this, zzinn);
          paramZzcbk = (zzcbk)localObject1;
          localObject1 = ((zzcbg)localObject3).zzbb(zzfdc);
        }
        zzauf().insertMessage((zzcbg)localObject1);
        trim(paramZzcbk, paramZzcas);
        zzauf().setTransactionSuccessful();
        bool1 = zzaul().zzad(2);
        if (bool1) {
          zzaul().zzayj().append("Event recorded", zzaug().getAbsolutePath(paramZzcbk));
        }
        zzauf().endTransaction();
        zzazi();
        zzaul().zzayj().append("Background event processing time, ms", Long.valueOf((System.nanoTime() - l2 + 500000L) / 1000000L));
        return;
      }
      catch (Throwable paramZzcbk)
      {
        zzauf().endTransaction();
        throw paramZzcbk;
      }
    }
  }
  
  private final void updateDatabase(zzcas paramZzcas)
  {
    zzauk().zzuj();
    zzwk();
    zzbp.append(paramZzcas);
    zzbp.zzgg(packageName);
    Object localObject2 = zzauf().zziw(packageName);
    Object localObject1 = localObject2;
    String str = zzaum().zzji(packageName);
    if (localObject2 == null)
    {
      localObject1 = new zzcar(this, packageName);
      ((zzcar)localObject1).zzim(zzaua().zzaya());
      ((zzcar)localObject1).zzio(str);
    }
    for (;;)
    {
      j = 1;
      break label134;
      if (str.equals(((zzcar)localObject2).zzaup())) {
        break;
      }
      ((zzcar)localObject2).zzio(str);
      ((zzcar)localObject2).zzim(zzaua().zzaya());
    }
    int j = 0;
    label134:
    int i = j;
    if (!TextUtils.isEmpty(zzilu))
    {
      i = j;
      if (!zzilu.equals(((zzcar)localObject1).getGmpAppId()))
      {
        ((zzcar)localObject1).zzin(zzilu);
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(zzimc))
    {
      j = i;
      if (!zzimc.equals(((zzcar)localObject1).zzauq()))
      {
        ((zzcar)localObject1).zzip(zzimc);
        j = 1;
      }
    }
    long l = zzilw;
    i = j;
    if (l != 0L)
    {
      i = j;
      if (l != ((zzcar)localObject1).zzauv())
      {
        ((zzcar)localObject1).zzao(zzilw);
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(zzhtt))
    {
      j = i;
      if (!zzhtt.equals(((zzcar)localObject1).zzuo()))
      {
        ((zzcar)localObject1).setAppVersion(zzhtt);
        j = 1;
      }
    }
    if (zzimb != ((zzcar)localObject1).zzaut())
    {
      ((zzcar)localObject1).zzan(zzimb);
      j = 1;
    }
    localObject2 = zzilv;
    i = j;
    if (localObject2 != null)
    {
      i = j;
      if (!((String)localObject2).equals(((zzcar)localObject1).zzauu()))
      {
        ((zzcar)localObject1).zziq(zzilv);
        i = 1;
      }
    }
    if (zzilx != ((zzcar)localObject1).zzauw())
    {
      ((zzcar)localObject1).zzap(zzilx);
      i = 1;
    }
    if (zzilz != ((zzcar)localObject1).zzaux())
    {
      ((zzcar)localObject1).setMeasurementEnabled(zzilz);
      i = 1;
    }
    j = i;
    if (!TextUtils.isEmpty(zzily))
    {
      j = i;
      if (!zzily.equals(((zzcar)localObject1).zzavi()))
      {
        ((zzcar)localObject1).zzir(zzily);
        j = 1;
      }
    }
    if (zzimd != ((zzcar)localObject1).zzavk())
    {
      ((zzcar)localObject1).zzaz(zzimd);
      j = 1;
    }
    if (j != 0) {
      zzauf().insertMessage((zzcar)localObject1);
    }
  }
  
  private final boolean write(int paramInt, FileChannel paramFileChannel)
  {
    zzauk().zzuj();
    if ((paramFileChannel != null) && (paramFileChannel.isOpen()))
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.putInt(paramInt);
      localByteBuffer.flip();
      try
      {
        paramFileChannel.truncate(0L);
        paramFileChannel.write(localByteBuffer);
        paramFileChannel.force(true);
        long l = paramFileChannel.size();
        if (l == 4L) {
          break label125;
        }
        zzaul().zzayd().append("Error writing to channel. Bytes written", Long.valueOf(paramFileChannel.size()));
        return true;
      }
      catch (IOException paramFileChannel)
      {
        zzaul().zzayd().append("Failed to write to channel", paramFileChannel);
        return false;
      }
    }
    else
    {
      zzaul().zzayd().append("Bad chanel to read from");
      return false;
    }
    label125:
    return true;
  }
  
  public static void zzatu()
  {
    zzcax.zzawk();
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  private final zzccf zzazb()
  {
    zzccf localZzccf = zzitk;
    if (localZzccf != null) {
      return localZzccf;
    }
    throw new IllegalStateException("Network broadcast receiver not created");
  }
  
  private final zzcfr zzazc()
  {
    dispatchEvent(zzitl);
    return zzitl;
  }
  
  private final boolean zzazd()
  {
    zzauk().zzuj();
    Object localObject = zzcax.zzawi();
    localObject = new File(mContext.getFilesDir(), (String)localObject);
    zzcby localZzcby;
    try
    {
      localObject = new RandomAccessFile((File)localObject, "rw").getChannel();
      zzits = ((FileChannel)localObject);
      localObject = zzits;
      localObject = ((FileChannel)localObject).tryLock();
      zzitr = ((FileLock)localObject);
      if (zzitr != null)
      {
        zzaul().zzayj().append("Storage concurrent access okay");
        return true;
      }
      zzaul().zzayd().append("Storage concurrent data access panic");
    }
    catch (IOException localIOException)
    {
      localZzcby = zzaul().zzayd();
      localObject = "Failed to access storage lock file";
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localZzcby = zzaul().zzayd();
      localObject = "Failed to acquire storage lock";
    }
    localZzcby.append((String)localObject, localFileNotFoundException);
    return false;
  }
  
  private final long zzazf()
  {
    long l3 = zzasc.currentTimeMillis();
    zzcch localZzcch = zzaum();
    localZzcch.zzwk();
    localZzcch.zzuj();
    long l2 = zziqt.lastModified();
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = localZzcch.zzauh().zzazy().nextInt(86400000) + 1;
      zziqt.setDefaultAccount(l1);
    }
    return (l3 + l1) / 1000L / 60L / 60L / 24L;
  }
  
  private final boolean zzazh()
  {
    zzauk().zzuj();
    zzwk();
    return (zzauf().zzaxn()) || (!TextUtils.isEmpty(zzauf().zzaxi()));
  }
  
  private final void zzazi()
  {
    zzauk().zzuj();
    zzwk();
    if (!zzazl()) {
      return;
    }
    long l1;
    if (zzity > 0L)
    {
      l1 = 3600000L - Math.abs(zzasc.elapsedRealtime() - zzity);
      if (l1 > 0L)
      {
        zzaul().zzayj().append("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(l1));
        zzazb().unregister();
        zzazc().cancel();
        return;
      }
      zzity = 0L;
    }
    if ((zzayv()) && (zzazh()))
    {
      long l3 = zzasc.currentTimeMillis();
      long l2 = zzcax.zzaxd();
      int i;
      if ((!zzauf().zzaxo()) && (!zzauf().zzaxj())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        String str = zziss.zzaxg();
        if ((!TextUtils.isEmpty(str)) && (!".none.".equals(str))) {
          l1 = zzcax.zzawz();
        } else {
          l1 = zzcax.zzawy();
        }
      }
      else
      {
        l1 = zzcax.zzawx();
      }
      long l6 = zzaumzziqp.lastModified();
      long l4 = zzaumzziqq.lastModified();
      long l5 = Math.max(zzauf().zzaxl(), zzauf().zzaxm());
      if (l5 == 0L) {}
      for (;;)
      {
        l1 = 0L;
        break;
        l5 = l3 - Math.abs(l5 - l3);
        l6 = Math.abs(l6 - l3);
        l4 = l3 - Math.abs(l4 - l3);
        l6 = Math.max(l3 - l6, l4);
        l3 = l2 + l5;
        l2 = l3;
        if (i != 0)
        {
          l2 = l3;
          if (l6 > 0L) {
            l2 = Math.min(l5, l6) + l1;
          }
        }
        if (!zzauh().evaluate(l6, l1)) {
          l2 = l6 + l1;
        }
        l1 = l2;
        if (l4 == 0L) {
          break;
        }
        l1 = l2;
        if (l4 < l5) {
          break;
        }
        i = 0;
        while (i < zzcax.zzaxf())
        {
          l1 = 1 << i;
          l1 = l2 + zzcax.zzaxe() * l1;
          if (l1 > l4) {
            break label429;
          }
          i += 1;
          l2 = l1;
        }
      }
      label429:
      if (l1 == 0L)
      {
        zzaul().zzayj().append("Next upload time is 0");
        zzazb().unregister();
        zzazc().cancel();
        return;
      }
      if (!zzaza().zzyx())
      {
        zzaul().zzayj().append("No network");
        zzazb().zzyu();
        zzazc().cancel();
        return;
      }
      l3 = zzaumzziqr.lastModified();
      l4 = zzcax.zzaww();
      l2 = l1;
      if (!zzauh().evaluate(l3, l4)) {
        l2 = Math.max(l1, l3 + l4);
      }
      zzazb().unregister();
      l2 -= zzasc.currentTimeMillis();
      l1 = l2;
      if (l2 <= 0L)
      {
        l1 = zzcax.zzaxa();
        zzaumzziqp.setDefaultAccount(zzasc.currentTimeMillis());
      }
      zzaul().zzayj().append("Upload scheduled in approximately ms", Long.valueOf(l1));
      zzazc().setAlarm(l1);
      return;
    }
    zzaul().zzayj().append("Nothing to upload or uploading impossible");
    zzazb().unregister();
    zzazc().cancel();
  }
  
  private final boolean zzazl()
  {
    zzauk().zzuj();
    zzwk();
    return zzito;
  }
  
  private final void zzazm()
  {
    zzauk().zzuj();
    if ((!zzitz) && (!zziua) && (!zziub))
    {
      zzaul().zzayj().append("Stopping uploading service(s)");
      Object localObject = zzitu;
      if (localObject == null) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
      zzitu.clear();
      return;
    }
    zzaul().zzayj().attribute("Not stopping services. fetch, network, upload", Boolean.valueOf(zzitz), Boolean.valueOf(zziua), Boolean.valueOf(zziub));
  }
  
  public static zzccw zzdn(Context paramContext)
  {
    zzbp.append(paramContext);
    zzbp.append(paramContext.getApplicationContext());
    if (zzisr == null) {
      try
      {
        if (zzisr == null) {
          zzisr = new zzccw(new zzcdv(paramContext));
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return zzisr;
  }
  
  private final zzcas zzjr(String paramString)
  {
    zzcar localZzcar = zzauf().zziw(paramString);
    Object localObject;
    if ((localZzcar != null) && (!TextUtils.isEmpty(localZzcar.zzuo()))) {
      localObject = mContext;
    }
    try
    {
      localObject = zzbed.zzcr((Context)localObject).getPackageInfo(paramString, 0);
      localObject = versionName;
      String str = localZzcar.zzuo();
      if (str != null)
      {
        boolean bool = localZzcar.zzuo().equals(localObject);
        if (!bool)
        {
          zzaul().zzayf().append("App version does not match; dropping. appId", zzcbw.zzjf(paramString));
          return null;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    return new zzcas(paramString, localZzcar.getGmpAppId(), localZzcar.zzuo(), localZzcar.zzaut(), localZzcar.zzauu(), localZzcar.zzauv(), localZzcar.zzauw(), null, localZzcar.zzaux(), false, localZzcar.zzauq(), localZzcar.zzavk(), 0L, 0);
    zzaul().zzayi().append("No app data available; dropping", paramString);
    return null;
  }
  
  public final void addPackage(zzcas paramZzcas)
  {
    zzauk().zzuj();
    zzwk();
    zzbp.zzgg(packageName);
    updateDatabase(paramZzcas);
  }
  
  public final void addPackage(zzcav paramZzcav)
  {
    zzcas localZzcas = zzjr(packageName);
    if (localZzcas != null) {
      readMessage(paramZzcav, localZzcas);
    }
  }
  
  public final void deleteMessages(zzcav paramZzcav)
  {
    zzcas localZzcas = zzjr(packageName);
    if (localZzcas != null) {
      deleteMessages(paramZzcav, localZzcas);
    }
  }
  
  public final void deleteMessages(zzcav paramZzcav, zzcas paramZzcas)
  {
    zzbp.append(paramZzcav);
    zzbp.zzgg(packageName);
    zzbp.append(zzimh);
    zzbp.zzgg(zzimh.name);
    zzauk().zzuj();
    zzwk();
    if (TextUtils.isEmpty(zzilu)) {
      return;
    }
    if (!zzilz)
    {
      updateDatabase(paramZzcas);
      return;
    }
    zzauf().beginTransaction();
    try
    {
      updateDatabase(paramZzcas);
      zzcav localZzcav = zzauf().zzai(packageName, zzimh.name);
      if (localZzcav != null)
      {
        zzaul().zzayi().append("Removing conditional user property", packageName, zzaug().zzje(zzimh.name));
        zzauf().zzaj(packageName, zzimh.name);
        boolean bool = zzimj;
        if (bool) {
          zzauf().zzag(packageName, zzimh.name);
        }
        Object localObject = zzimp;
        if (localObject != null)
        {
          Bundle localBundle = null;
          zzcbh localZzcbh = zzinr;
          if (localZzcbh != null) {
            localBundle = zzinr.zzaxz();
          }
          localObject = zzauh();
          paramZzcav = zzimp;
          update(((zzcfw)localObject).get(name, localBundle, zzimg, zzins, true, false), paramZzcas);
        }
      }
      else
      {
        zzaul().zzayf().append("Conditional user property doesn't exist", zzcbw.zzjf(packageName), zzaug().zzje(zzimh.name));
      }
      zzauf().setTransactionSuccessful();
      zzauf().endTransaction();
      return;
    }
    catch (Throwable paramZzcav)
    {
      zzauf().endTransaction();
      throw paramZzcav;
    }
  }
  
  public final void deleteMessages(zzcft paramZzcft, zzcas paramZzcas)
  {
    zzauk().zzuj();
    zzwk();
    if (TextUtils.isEmpty(zzilu)) {
      return;
    }
    if (!zzilz)
    {
      updateDatabase(paramZzcas);
      return;
    }
    zzaul().zzayi().append("Removing user property", zzaug().zzje(name));
    zzauf().beginTransaction();
    try
    {
      updateDatabase(paramZzcas);
      zzauf().zzag(packageName, name);
      zzauf().setTransactionSuccessful();
      zzaul().zzayi().append("User property removed", zzaug().zzje(name));
      zzauf().endTransaction();
      return;
    }
    catch (Throwable paramZzcft)
    {
      zzauf().endTransaction();
      throw paramZzcft;
    }
  }
  
  /* Error */
  public final void deleteMessages(String paramString, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte, Map paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 407	com/google/android/android/internal/zzccw:zzauk	()Lcom/google/android/android/internal/zzccr;
    //   4: invokevirtual 410	com/google/android/android/internal/zzccr:zzuj	()V
    //   7: aload_0
    //   8: invokevirtual 961	com/google/android/android/internal/zzccw:zzwk	()V
    //   11: aload_1
    //   12: invokestatic 391	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   15: pop
    //   16: aload 4
    //   18: astore 9
    //   20: aload 4
    //   22: ifnonnull +8 -> 30
    //   25: iconst_0
    //   26: newarray byte
    //   28: astore 9
    //   30: aload_0
    //   31: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   34: invokevirtual 359	com/google/android/android/internal/zzcbw:zzayj	()Lcom/google/android/android/internal/zzcby;
    //   37: ldc_w 1833
    //   40: aload 9
    //   42: arraylength
    //   43: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   49: aload_0
    //   50: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   53: invokevirtual 552	com/google/android/android/internal/zzcay:beginTransaction	()V
    //   56: aload_0
    //   57: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   60: aload_1
    //   61: invokevirtual 844	com/google/android/android/internal/zzcay:zziw	(Ljava/lang/String;)Lcom/google/android/android/internal/zzcar;
    //   64: astore 4
    //   66: iconst_1
    //   67: istore 7
    //   69: iload_2
    //   70: sipush 200
    //   73: if_icmpeq +17 -> 90
    //   76: iload_2
    //   77: sipush 204
    //   80: if_icmpeq +10 -> 90
    //   83: iload_2
    //   84: sipush 304
    //   87: if_icmpne +13 -> 100
    //   90: aload_3
    //   91: ifnonnull +9 -> 100
    //   94: iconst_1
    //   95: istore 6
    //   97: goto +6 -> 103
    //   100: iconst_0
    //   101: istore 6
    //   103: aload 4
    //   105: ifnonnull +23 -> 128
    //   108: aload_0
    //   109: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   112: invokevirtual 364	com/google/android/android/internal/zzcbw:zzayf	()Lcom/google/android/android/internal/zzcby;
    //   115: ldc_w 1835
    //   118: aload_1
    //   119: invokestatic 537	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   122: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   125: goto +393 -> 518
    //   128: iload 6
    //   130: ifne +140 -> 270
    //   133: iload_2
    //   134: sipush 404
    //   137: if_icmpne +6 -> 143
    //   140: goto +130 -> 270
    //   143: aload 4
    //   145: aload_0
    //   146: getfield 109	com/google/android/android/internal/zzccw:zzasc	Lcom/google/android/android/common/util/Log;
    //   149: invokeinterface 115 1 0
    //   154: invokevirtual 1838	com/google/android/android/internal/zzcar:zzas	(J)V
    //   157: aload_0
    //   158: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   161: aload 4
    //   163: invokevirtual 884	com/google/android/android/internal/zzcay:insertMessage	(Lcom/google/android/android/internal/zzcar;)V
    //   166: aload_0
    //   167: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   170: invokevirtual 359	com/google/android/android/internal/zzcbw:zzayj	()Lcom/google/android/android/internal/zzcby;
    //   173: ldc_w 1840
    //   176: iload_2
    //   177: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aload_3
    //   181: invokevirtual 322	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   184: aload_0
    //   185: invokevirtual 491	com/google/android/android/internal/zzccw:zzaui	()Lcom/google/android/android/internal/zzccq;
    //   188: aload_1
    //   189: invokevirtual 1843	com/google/android/android/internal/zzccq:zzjp	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: invokevirtual 1014	com/google/android/android/internal/zzccw:zzaum	()Lcom/google/android/android/internal/zzcch;
    //   196: getfield 1669	com/google/android/android/internal/zzcch:zziqq	Lcom/google/android/android/internal/zzcck;
    //   199: aload_0
    //   200: getfield 109	com/google/android/android/internal/zzccw:zzasc	Lcom/google/android/android/common/util/Log;
    //   203: invokeinterface 115 1 0
    //   208: invokevirtual 1604	com/google/android/android/internal/zzcck:setDefaultAccount	(J)V
    //   211: iload 7
    //   213: istore 6
    //   215: iload_2
    //   216: sipush 503
    //   219: if_icmpeq +20 -> 239
    //   222: iload_2
    //   223: sipush 429
    //   226: if_icmpne +10 -> 236
    //   229: iload 7
    //   231: istore 6
    //   233: goto +6 -> 239
    //   236: iconst_0
    //   237: istore 6
    //   239: iload 6
    //   241: ifeq +22 -> 263
    //   244: aload_0
    //   245: invokevirtual 1014	com/google/android/android/internal/zzccw:zzaum	()Lcom/google/android/android/internal/zzcch;
    //   248: getfield 1700	com/google/android/android/internal/zzcch:zziqr	Lcom/google/android/android/internal/zzcck;
    //   251: aload_0
    //   252: getfield 109	com/google/android/android/internal/zzccw:zzasc	Lcom/google/android/android/common/util/Log;
    //   255: invokeinterface 115 1 0
    //   260: invokevirtual 1604	com/google/android/android/internal/zzcck:setDefaultAccount	(J)V
    //   263: aload_0
    //   264: invokespecial 1473	com/google/android/android/internal/zzccw:zzazi	()V
    //   267: goto +251 -> 518
    //   270: aload 5
    //   272: ifnull +20 -> 292
    //   275: aload 5
    //   277: ldc_w 1845
    //   280: invokeinterface 1847 2 0
    //   285: checkcast 692	java/util/List
    //   288: astore_3
    //   289: goto +5 -> 294
    //   292: aconst_null
    //   293: astore_3
    //   294: aload_3
    //   295: ifnull +30 -> 325
    //   298: aload_3
    //   299: invokeinterface 701 1 0
    //   304: istore 6
    //   306: iload 6
    //   308: ifle +17 -> 325
    //   311: aload_3
    //   312: iconst_0
    //   313: invokeinterface 712 2 0
    //   318: checkcast 210	java/lang/String
    //   321: astore_3
    //   322: goto +5 -> 327
    //   325: aconst_null
    //   326: astore_3
    //   327: iload_2
    //   328: sipush 404
    //   331: if_icmpeq +50 -> 381
    //   334: iload_2
    //   335: sipush 304
    //   338: if_icmpne +6 -> 344
    //   341: goto +40 -> 381
    //   344: aload_0
    //   345: invokevirtual 491	com/google/android/android/internal/zzccw:zzaui	()Lcom/google/android/android/internal/zzccq;
    //   348: aload_1
    //   349: aload 9
    //   351: aload_3
    //   352: invokevirtual 1851	com/google/android/android/internal/zzccq:putAll	(Ljava/lang/String;[BLjava/lang/String;)Z
    //   355: istore 8
    //   357: iload 8
    //   359: ifne +60 -> 419
    //   362: aload_0
    //   363: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   366: astore_1
    //   367: aload_1
    //   368: invokevirtual 922	com/google/android/android/internal/zzcay:endTransaction	()V
    //   371: aload_0
    //   372: iconst_0
    //   373: putfield 511	com/google/android/android/internal/zzccw:zzitz	Z
    //   376: aload_0
    //   377: invokespecial 1853	com/google/android/android/internal/zzccw:zzazm	()V
    //   380: return
    //   381: aload_0
    //   382: invokevirtual 491	com/google/android/android/internal/zzccw:zzaui	()Lcom/google/android/android/internal/zzccq;
    //   385: aload_1
    //   386: invokevirtual 495	com/google/android/android/internal/zzccq:zzjn	(Ljava/lang/String;)Lcom/google/android/android/internal/zzcge;
    //   389: astore_3
    //   390: aload_3
    //   391: ifnonnull +28 -> 419
    //   394: aload_0
    //   395: invokevirtual 491	com/google/android/android/internal/zzccw:zzaui	()Lcom/google/android/android/internal/zzccq;
    //   398: aload_1
    //   399: aconst_null
    //   400: aconst_null
    //   401: invokevirtual 1851	com/google/android/android/internal/zzccq:putAll	(Ljava/lang/String;[BLjava/lang/String;)Z
    //   404: istore 8
    //   406: iload 8
    //   408: ifne +11 -> 419
    //   411: aload_0
    //   412: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   415: astore_1
    //   416: goto -49 -> 367
    //   419: aload 4
    //   421: aload_0
    //   422: getfield 109	com/google/android/android/internal/zzccw:zzasc	Lcom/google/android/android/common/util/Log;
    //   425: invokeinterface 115 1 0
    //   430: invokevirtual 1856	com/google/android/android/internal/zzcar:zzar	(J)V
    //   433: aload_0
    //   434: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   437: aload 4
    //   439: invokevirtual 884	com/google/android/android/internal/zzcay:insertMessage	(Lcom/google/android/android/internal/zzcar;)V
    //   442: iload_2
    //   443: sipush 404
    //   446: if_icmpne +20 -> 466
    //   449: aload_0
    //   450: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   453: invokevirtual 1859	com/google/android/android/internal/zzcbw:zzayg	()Lcom/google/android/android/internal/zzcby;
    //   456: ldc_w 1861
    //   459: aload_1
    //   460: invokevirtual 165	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   463: goto +26 -> 489
    //   466: aload_0
    //   467: invokevirtual 143	com/google/android/android/internal/zzccw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   470: invokevirtual 359	com/google/android/android/internal/zzcbw:zzayj	()Lcom/google/android/android/internal/zzcby;
    //   473: ldc_w 1863
    //   476: iload_2
    //   477: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   480: aload 9
    //   482: arraylength
    //   483: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   486: invokevirtual 322	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   489: aload_0
    //   490: invokevirtual 515	com/google/android/android/internal/zzccw:zzaza	()Lcom/google/android/android/internal/zzcca;
    //   493: invokevirtual 1692	com/google/android/android/internal/zzcca:zzyx	()Z
    //   496: istore 8
    //   498: iload 8
    //   500: ifeq -237 -> 263
    //   503: aload_0
    //   504: invokespecial 1640	com/google/android/android/internal/zzccw:zzazh	()Z
    //   507: istore 8
    //   509: iload 8
    //   511: ifeq -248 -> 263
    //   514: aload_0
    //   515: invokevirtual 1866	com/google/android/android/internal/zzccw:zzazg	()V
    //   518: aload_0
    //   519: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   522: invokevirtual 919	com/google/android/android/internal/zzcay:setTransactionSuccessful	()V
    //   525: aload_0
    //   526: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   529: astore_1
    //   530: goto -163 -> 367
    //   533: astore_1
    //   534: aload_0
    //   535: invokevirtual 549	com/google/android/android/internal/zzccw:zzauf	()Lcom/google/android/android/internal/zzcay;
    //   538: invokevirtual 922	com/google/android/android/internal/zzcay:endTransaction	()V
    //   541: aload_1
    //   542: athrow
    //   543: astore_1
    //   544: aload_0
    //   545: iconst_0
    //   546: putfield 511	com/google/android/android/internal/zzccw:zzitz	Z
    //   549: aload_0
    //   550: invokespecial 1853	com/google/android/android/internal/zzccw:zzazm	()V
    //   553: goto +3 -> 556
    //   556: aload_1
    //   557: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	zzccw
    //   0	558	1	paramString	String
    //   0	558	2	paramInt	int
    //   0	558	3	paramThrowable	Throwable
    //   0	558	4	paramArrayOfByte	byte[]
    //   0	558	5	paramMap	Map
    //   95	212	6	i	int
    //   67	163	7	j	int
    //   355	155	8	bool	boolean
    //   18	463	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   56	66	533	java/lang/Throwable
    //   108	125	533	java/lang/Throwable
    //   143	211	533	java/lang/Throwable
    //   244	263	533	java/lang/Throwable
    //   263	267	533	java/lang/Throwable
    //   275	289	533	java/lang/Throwable
    //   298	306	533	java/lang/Throwable
    //   311	322	533	java/lang/Throwable
    //   344	357	533	java/lang/Throwable
    //   381	390	533	java/lang/Throwable
    //   394	406	533	java/lang/Throwable
    //   419	442	533	java/lang/Throwable
    //   449	463	533	java/lang/Throwable
    //   466	489	533	java/lang/Throwable
    //   489	498	533	java/lang/Throwable
    //   503	509	533	java/lang/Throwable
    //   514	518	533	java/lang/Throwable
    //   518	525	533	java/lang/Throwable
    //   25	30	543	java/lang/Throwable
    //   30	56	543	java/lang/Throwable
    //   362	367	543	java/lang/Throwable
    //   367	371	543	java/lang/Throwable
    //   411	416	543	java/lang/Throwable
    //   525	530	543	java/lang/Throwable
    //   534	543	543	java/lang/Throwable
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public final void getDialog(zzcbk paramZzcbk, String paramString)
  {
    zzcar localZzcar = zzauf().zziw(paramString);
    Object localObject;
    if ((localZzcar != null) && (!TextUtils.isEmpty(localZzcar.zzuo()))) {
      localObject = mContext;
    }
    try
    {
      localObject = zzbed.zzcr((Context)localObject).getPackageInfo(paramString, 0);
      localObject = versionName;
      String str = localZzcar.zzuo();
      if (str == null) {
        break label129;
      }
      boolean bool = localZzcar.zzuo().equals(localObject);
      if (bool) {
        break label129;
      }
      zzaul().zzayf().append("App version does not match; dropping event. appId", zzcbw.zzjf(paramString));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    if (!"_ui".equals(name)) {
      zzaul().zzayf().append("Could not find package. appId", zzcbw.zzjf(paramString));
    }
    label129:
    getInstalledApps(paramZzcbk, new zzcas(paramString, localZzcar.getGmpAppId(), localZzcar.zzuo(), localZzcar.zzaut(), localZzcar.zzauu(), localZzcar.zzauv(), localZzcar.zzauw(), null, localZzcar.zzaux(), false, localZzcar.zzauq(), localZzcar.zzavk(), 0L, 0));
    return;
    zzaul().zzayi().append("No app data available; dropping event", paramString);
  }
  
  public final void getInstalledApps(zzcbk paramZzcbk, zzcas paramZzcas)
  {
    zzbp.append(paramZzcas);
    zzbp.zzgg(packageName);
    zzauk().zzuj();
    zzwk();
    Object localObject2 = packageName;
    long l = zzins;
    zzauh();
    if (!zzcfw.d(paramZzcbk, paramZzcas)) {
      return;
    }
    if (!zzilz)
    {
      updateDatabase(paramZzcas);
      return;
    }
    zzauf().beginTransaction();
    try
    {
      Object localObject1 = zzauf();
      zzbp.zzgg((String)localObject2);
      ((zzcdt)localObject1).zzuj();
      ((zzcdu)localObject1).zzwk();
      if (l < 0L)
      {
        ((zzcdt)localObject1).zzaul().zzayf().append("Invalid time querying timed out conditional properties", zzcbw.zzjf((String)localObject2), Long.valueOf(l));
        localObject1 = Collections.emptyList();
      }
      else
      {
        localObject1 = ((zzcay)localObject1).load("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[] { localObject2, String.valueOf(l) });
      }
      localObject1 = ((List)localObject1).iterator();
      boolean bool;
      Object localObject4;
      for (;;)
      {
        bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        localObject3 = (zzcav)((Iterator)localObject1).next();
        if (localObject3 != null)
        {
          zzaul().zzayi().attribute("User property timed out", packageName, zzaug().zzje(zzimh.name), zzimh.getValue());
          localObject4 = zziml;
          if (localObject4 != null) {
            update(new zzcbk((zzcbk)localObject4, l), paramZzcas);
          }
          zzauf().zzaj((String)localObject2, zzimh.name);
        }
      }
      localObject1 = zzauf();
      zzbp.zzgg((String)localObject2);
      ((zzcdt)localObject1).zzuj();
      ((zzcdu)localObject1).zzwk();
      if (l < 0L)
      {
        ((zzcdt)localObject1).zzaul().zzayf().append("Invalid time querying expired conditional properties", zzcbw.zzjf((String)localObject2), Long.valueOf(l));
        localObject1 = Collections.emptyList();
      }
      else
      {
        localObject1 = ((zzcay)localObject1).load("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[] { localObject2, String.valueOf(l) });
      }
      Object localObject3 = new ArrayList(((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      Object localObject5;
      for (;;)
      {
        bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        localObject4 = (zzcav)((Iterator)localObject1).next();
        if (localObject4 != null)
        {
          zzaul().zzayi().attribute("User property expired", packageName, zzaug().zzje(zzimh.name), zzimh.getValue());
          zzauf().zzag((String)localObject2, zzimh.name);
          localObject5 = zzimp;
          if (localObject5 != null) {
            ((List)localObject3).add(localObject5);
          }
          zzauf().zzaj((String)localObject2, zzimh.name);
        }
      }
      int j = ((ArrayList)localObject3).size();
      int i = 0;
      while (i < j)
      {
        localObject1 = ((ArrayList)localObject3).get(i);
        i += 1;
        update(new zzcbk((zzcbk)localObject1, l), paramZzcas);
      }
      localObject1 = zzauf();
      localObject3 = name;
      zzbp.zzgg((String)localObject2);
      zzbp.zzgg((String)localObject3);
      ((zzcdt)localObject1).zzuj();
      ((zzcdu)localObject1).zzwk();
      if (l < 0L)
      {
        ((zzcdt)localObject1).zzaul().zzayf().attribute("Invalid time querying triggered conditional properties", zzcbw.zzjf((String)localObject2), ((zzcdt)localObject1).zzaug().zzjc((String)localObject3), Long.valueOf(l));
        localObject1 = Collections.emptyList();
      }
      else
      {
        localObject1 = ((zzcay)localObject1).load("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[] { localObject2, localObject3, String.valueOf(l) });
      }
      ArrayList localArrayList = new ArrayList(((List)localObject1).size());
      Iterator localIterator = ((List)localObject1).iterator();
      for (;;)
      {
        bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        zzcav localZzcav = (zzcav)localIterator.next();
        if (localZzcav != null)
        {
          localObject1 = zzimh;
          zzcfv localZzcfv = new zzcfv(packageName, zzimg, name, l, ((zzcft)localObject1).getValue());
          bool = zzauf().add(localZzcfv);
          if (bool)
          {
            localObject2 = zzaul().zzayi();
            localObject1 = "User property triggered";
            localObject3 = packageName;
            localObject4 = zzaug().zzje(mName);
          }
          for (localObject5 = mValue;; localObject5 = mValue)
          {
            ((zzcby)localObject2).attribute((String)localObject1, localObject3, localObject4, localObject5);
            break;
            localObject2 = zzaul().zzayd();
            localObject1 = "Too many active user properties, ignoring";
            localObject3 = zzcbw.zzjf(packageName);
            localObject4 = zzaug().zzje(mName);
          }
          localObject1 = zzimn;
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          zzimh = new zzcft(localZzcfv);
          zzimj = true;
          zzauf().insertMessage(localZzcav);
        }
      }
      update(paramZzcbk, paramZzcas);
      j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        paramZzcbk = localArrayList.get(i);
        i += 1;
        update(new zzcbk((zzcbk)paramZzcbk, l), paramZzcas);
      }
      zzauf().setTransactionSuccessful();
      zzauf().endTransaction();
      return;
    }
    catch (Throwable paramZzcbk)
    {
      zzauf().endTransaction();
      throw paramZzcbk;
    }
  }
  
  public final void intersect(zzcdu paramZzcdu)
  {
    zzitv += 1;
  }
  
  public final boolean isEnabled()
  {
    zzauk().zzuj();
    zzwk();
    boolean bool2 = zziss.zzawl();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Boolean localBoolean = zziss.zzit("firebase_analytics_collection_enabled");
    if (localBoolean != null) {
      bool1 = localBoolean.booleanValue();
    } else if (!zzcax.zzaif()) {
      bool1 = true;
    }
    return zzaum().zzbn(bool1);
  }
  
  public final void queueEvent(Runnable paramRunnable)
  {
    zzauk().zzuj();
    if (zzitu == null) {
      zzitu = new ArrayList();
    }
    zzitu.add(paramRunnable);
  }
  
  public final void readMessage(zzcas paramZzcas)
  {
    zzauk().zzuj();
    zzwk();
    zzbp.append(paramZzcas);
    zzbp.zzgg(packageName);
    if (TextUtils.isEmpty(zzilu)) {
      return;
    }
    Object localObject1 = zzauf().zziw(packageName);
    if ((localObject1 != null) && (TextUtils.isEmpty(((zzcar)localObject1).getGmpAppId())) && (!TextUtils.isEmpty(zzilu)))
    {
      ((zzcar)localObject1).zzar(0L);
      zzauf().insertMessage((zzcar)localObject1);
      zzaui().zzjq(packageName);
    }
    if (!zzilz)
    {
      updateDatabase(paramZzcas);
      return;
    }
    long l2 = zzime;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = zzasc.currentTimeMillis();
    }
    int j = zzimf;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        zzaul().zzayf().append("Incorrect app type, assuming installed app. appId, appType", zzcbw.zzjf(packageName), Integer.valueOf(j));
        i = 0;
      }
    }
    zzauf().beginTransaction();
    try
    {
      Object localObject5 = zzauf().zziw(packageName);
      Object localObject4 = localObject5;
      localObject1 = localObject4;
      boolean bool;
      if (localObject5 != null)
      {
        Object localObject6 = ((zzcar)localObject5).getGmpAppId();
        localObject1 = localObject4;
        if (localObject6 != null)
        {
          bool = ((zzcar)localObject5).getGmpAppId().equals(zzilu);
          localObject1 = localObject4;
          if (!bool)
          {
            zzaul().zzayf().append("New GMP App Id passed in. Removing cached database data. appId", zzcbw.zzjf(((zzcar)localObject5).getAppId()));
            localObject1 = zzauf();
            localObject4 = ((zzcar)localObject5).getAppId();
            ((zzcdu)localObject1).zzwk();
            ((zzcdt)localObject1).zzuj();
            zzbp.zzgg((String)localObject4);
            try
            {
              localObject5 = ((zzcay)localObject1).getWritableDatabase();
              localObject6 = new String[1];
              localObject6[0] = localObject4;
              j = ((SQLiteDatabase)localObject5).delete("events", "app_id=?", (String[])localObject6);
              int k = ((SQLiteDatabase)localObject5).delete("user_attributes", "app_id=?", (String[])localObject6);
              int m = ((SQLiteDatabase)localObject5).delete("conditional_properties", "app_id=?", (String[])localObject6);
              int n = ((SQLiteDatabase)localObject5).delete("apps", "app_id=?", (String[])localObject6);
              int i1 = ((SQLiteDatabase)localObject5).delete("raw_events", "app_id=?", (String[])localObject6);
              int i2 = ((SQLiteDatabase)localObject5).delete("raw_events_metadata", "app_id=?", (String[])localObject6);
              int i3 = ((SQLiteDatabase)localObject5).delete("event_filters", "app_id=?", (String[])localObject6);
              int i4 = ((SQLiteDatabase)localObject5).delete("property_filters", "app_id=?", (String[])localObject6);
              int i5 = ((SQLiteDatabase)localObject5).delete("audience_filter_values", "app_id=?", (String[])localObject6);
              j = j + 0 + k + m + n + i1 + i2 + i3 + i4 + i5;
              if (j > 0) {
                ((zzcdt)localObject1).zzaul().zzayj().append("Deleted application data. app, records", localObject4, Integer.valueOf(j));
              }
            }
            catch (SQLiteException localSQLiteException)
            {
              ((zzcdt)localObject1).zzaul().zzayd().append("Error deleting application data. appId, error", zzcbw.zzjf((String)localObject4), localSQLiteException);
            }
            localObject1 = null;
          }
        }
      }
      if (localObject1 != null)
      {
        localObject4 = ((zzcar)localObject1).zzuo();
        if (localObject4 != null)
        {
          bool = ((zzcar)localObject1).zzuo().equals(zzhtt);
          if (!bool)
          {
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("_pv", ((zzcar)localObject1).zzuo());
            getInstalledApps(new zzcbk("_au", new zzcbh((Bundle)localObject4), "auto", l1), paramZzcas);
          }
        }
      }
      updateDatabase(paramZzcas);
      if (i == 0)
      {
        localObject4 = zzauf();
        localObject1 = packageName;
      }
      for (String str = "_f";; str = "_v")
      {
        localObject1 = ((zzcay)localObject4).zzaf((String)localObject1, str);
        break label699;
        if (i != 1) {
          break;
        }
        localObject4 = zzauf();
        localObject1 = packageName;
      }
      localObject1 = null;
      label699:
      if (localObject1 == null)
      {
        l2 = (l1 / 3600000L + 1L) * 3600000L;
        if (i == 0)
        {
          readMessage(new zzcft("_fot", l1, Long.valueOf(l2), "auto"), paramZzcas);
          zzauk().zzuj();
          zzwk();
          localObject4 = new Bundle();
          ((Bundle)localObject4).putLong("_c", 1L);
          ((Bundle)localObject4).putLong("_r", 1L);
          ((Bundle)localObject4).putLong("_uwa", 0L);
          ((Bundle)localObject4).putLong("_pfo", 0L);
          ((Bundle)localObject4).putLong("_sys", 0L);
          ((Bundle)localObject4).putLong("_sysu", 0L);
          localObject1 = mContext.getPackageManager();
          if (localObject1 == null)
          {
            zzaul().zzayd().append("PackageManager is null, first open report might be inaccurate. appId", zzcbw.zzjf(packageName));
          }
          else
          {
            localObject1 = mContext;
            try
            {
              localObject1 = zzbed.zzcr((Context)localObject1);
              str = packageName;
              try
              {
                localObject1 = ((zzbec)localObject1).getPackageInfo(str, 0);
              }
              catch (PackageManager.NameNotFoundException localNameNotFoundException1) {}
              zzaul().zzayd().append("Package info is null, first open report might be inaccurate. appId", zzcbw.zzjf(packageName), localNameNotFoundException2);
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
            Object localObject2 = null;
            if (localObject2 != null)
            {
              l2 = firstInstallTime;
              if (l2 != 0L)
              {
                long l3 = lastUpdateTime;
                if (l2 != l3)
                {
                  ((Bundle)localObject4).putLong("_uwa", 1L);
                  i = 0;
                }
                else
                {
                  i = 1;
                }
                if (i != 0) {
                  l2 = 1L;
                } else {
                  l2 = 0L;
                }
                readMessage(new zzcft("_fi", l1, Long.valueOf(l2), "auto"), paramZzcas);
              }
            }
            localObject2 = mContext;
            try
            {
              localObject2 = zzbed.zzcr((Context)localObject2);
              str = packageName;
              localObject2 = ((zzbec)localObject2).getApplicationInfo(str, 0);
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException3)
            {
              zzaul().zzayd().append("Application info is null, first open report might be inaccurate. appId", zzcbw.zzjf(packageName), localNameNotFoundException3);
              localObject3 = null;
            }
            if (localObject3 != null)
            {
              i = flags;
              if ((i & 0x1) != 0) {
                ((Bundle)localObject4).putLong("_sys", 1L);
              }
              i = flags;
              if ((i & 0x80) != 0) {
                ((Bundle)localObject4).putLong("_sysu", 1L);
              }
            }
          }
          localObject3 = zzauf();
          str = packageName;
          zzbp.zzgg(str);
          ((zzcdt)localObject3).zzuj();
          ((zzcdu)localObject3).zzwk();
          l2 = ((zzcay)localObject3).zzam(str, "first_open_count");
          if (l2 >= 0L) {
            ((Bundle)localObject4).putLong("_pfo", l2);
          }
        }
        for (localObject3 = new zzcbk("_f", new zzcbh((Bundle)localObject4), "auto", l1);; localObject3 = new zzcbk("_v", new zzcbh((Bundle)localObject3), "auto", l1))
        {
          getInstalledApps((zzcbk)localObject3, paramZzcas);
          break;
          if (i != 1) {
            break;
          }
          readMessage(new zzcft("_fvt", l1, Long.valueOf(l2), "auto"), paramZzcas);
          zzauk().zzuj();
          zzwk();
          localObject3 = new Bundle();
          ((Bundle)localObject3).putLong("_c", 1L);
          ((Bundle)localObject3).putLong("_r", 1L);
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putLong("_et", 1L);
      }
      for (Object localObject3 = new zzcbk("_e", new zzcbh((Bundle)localObject3), "auto", l1);; localObject3 = new zzcbk("_cd", new zzcbh(new Bundle()), "auto", l1))
      {
        getInstalledApps((zzcbk)localObject3, paramZzcas);
        break;
        bool = zzima;
        if (!bool) {
          break;
        }
      }
      zzauf().setTransactionSuccessful();
      zzauf().endTransaction();
      return;
    }
    catch (Throwable paramZzcas)
    {
      zzauf().endTransaction();
      throw paramZzcas;
    }
  }
  
  public final void readMessage(zzcav paramZzcav, zzcas paramZzcas)
  {
    zzbp.append(paramZzcav);
    zzbp.zzgg(packageName);
    zzbp.append(zzimg);
    zzbp.append(zzimh);
    zzbp.zzgg(zzimh.name);
    zzauk().zzuj();
    zzwk();
    if (TextUtils.isEmpty(zzilu)) {
      return;
    }
    if (!zzilz)
    {
      updateDatabase(paramZzcas);
      return;
    }
    zzcav localZzcav = new zzcav(paramZzcav);
    int i = 0;
    zzimj = false;
    zzauf().beginTransaction();
    try
    {
      paramZzcav = zzauf().zzai(packageName, zzimh.name);
      if (paramZzcav != null)
      {
        bool = zzimg.equals(zzimg);
        if (!bool) {
          zzaul().zzayf().attribute("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzaug().zzje(zzimh.name), zzimg, zzimg);
        }
      }
      if (paramZzcav != null)
      {
        bool = zzimj;
        if (bool)
        {
          zzimg = zzimg;
          zzimi = zzimi;
          zzimm = zzimm;
          zzimk = zzimk;
          zzimn = zzimn;
          zzimj = bool;
          zzimh = new zzcft(zzimh.name, zzimh.zziwz, zzimh.getValue(), zzimh.zzimg);
          break label357;
        }
      }
      boolean bool = TextUtils.isEmpty(zzimk);
      if (bool)
      {
        zzimh = new zzcft(zzimh.name, zzimi, zzimh.getValue(), zzimh.zzimg);
        zzimj = true;
        i = 1;
      }
      label357:
      bool = zzimj;
      Object localObject2;
      Object localObject1;
      if (bool)
      {
        paramZzcav = zzimh;
        Object localObject4 = new zzcfv(packageName, zzimg, name, zziwz, paramZzcav.getValue());
        bool = zzauf().add((zzcfv)localObject4);
        if (bool)
        {
          localObject2 = zzaul().zzayi();
          paramZzcav = "User property updated immediately";
          localObject3 = packageName;
          localObject1 = zzaug().zzje(mName);
        }
        for (localObject4 = mValue;; localObject4 = mValue)
        {
          ((zzcby)localObject2).attribute(paramZzcav, localObject3, localObject1, localObject4);
          break;
          localObject2 = zzaul().zzayd();
          paramZzcav = "(2)Too many active user properties, ignoring";
          localObject3 = zzcbw.zzjf(packageName);
          localObject1 = zzaug().zzje(mName);
        }
        if (i != 0)
        {
          paramZzcav = zzimn;
          if (paramZzcav != null) {
            update(new zzcbk(zzimn, zzimi), paramZzcas);
          }
        }
      }
      bool = zzauf().insertMessage(localZzcav);
      if (bool)
      {
        localObject1 = zzaul().zzayi();
        paramZzcav = "Conditional property added";
        localObject2 = packageName;
        paramZzcas = zzaug().zzje(zzimh.name);
      }
      for (Object localObject3 = zzimh.getValue();; localObject3 = zzimh.getValue())
      {
        ((zzcby)localObject1).attribute(paramZzcav, localObject2, paramZzcas, localObject3);
        break;
        localObject1 = zzaul().zzayd();
        paramZzcav = "Too many conditional properties, ignoring";
        localObject2 = zzcbw.zzjf(packageName);
        paramZzcas = zzaug().zzje(zzimh.name);
      }
      zzauf().setTransactionSuccessful();
      zzauf().endTransaction();
      return;
    }
    catch (Throwable paramZzcav)
    {
      zzauf().endTransaction();
      throw paramZzcav;
    }
  }
  
  public final void readMessage(zzcft paramZzcft, zzcas paramZzcas)
  {
    zzauk().zzuj();
    zzwk();
    if (TextUtils.isEmpty(zzilu)) {
      return;
    }
    if (!zzilz)
    {
      updateDatabase(paramZzcas);
      return;
    }
    int j = zzauh().zzjy(name);
    int i;
    if (j != 0)
    {
      zzauh();
      localObject = name;
      zzcax.zzavo();
      localObject = zzcfw.toString((String)localObject, 24, true);
      paramZzcft = name;
      if (paramZzcft != null) {
        i = paramZzcft.length();
      } else {
        i = 0;
      }
      zzauh().add(packageName, j, "_ev", (String)localObject, i);
      return;
    }
    j = zzauh().attribute(name, paramZzcft.getValue());
    if (j != 0)
    {
      zzauh();
      localObject = name;
      zzcax.zzavo();
      localObject = zzcfw.toString((String)localObject, 24, true);
      paramZzcft = paramZzcft.getValue();
      if ((paramZzcft != null) && (((paramZzcft instanceof String)) || ((paramZzcft instanceof CharSequence)))) {
        i = String.valueOf(paramZzcft).length();
      } else {
        i = 0;
      }
      zzauh().add(packageName, j, "_ev", (String)localObject, i);
      return;
    }
    Object localObject = zzauh().valueOf(name, paramZzcft.getValue());
    if (localObject == null) {
      return;
    }
    paramZzcft = new zzcfv(packageName, zzimg, name, zziwz, localObject);
    zzaul().zzayi().append("Setting user property", zzaug().zzje(mName), localObject);
    zzauf().beginTransaction();
    try
    {
      updateDatabase(paramZzcas);
      boolean bool = zzauf().add(paramZzcft);
      zzauf().setTransactionSuccessful();
      if (bool)
      {
        zzaul().zzayi().append("User property set", zzaug().zzje(mName), mValue);
      }
      else
      {
        zzaul().zzayd().append("Too many unique user properties are set. Ignoring user property", zzaug().zzje(mName), mValue);
        zzauh().add(packageName, 9, null, null, 0);
      }
      zzauf().endTransaction();
      return;
    }
    catch (Throwable paramZzcft)
    {
      zzauf().endTransaction();
      throw paramZzcft;
    }
  }
  
  public final byte[] removeAccount(zzcbk paramZzcbk, String paramString)
  {
    zzwk();
    zzauk().zzuj();
    zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void start()
  {
    zzauk().zzuj();
    zzauf().zzaxk();
    if (zzaumzziqp.lastModified() == 0L) {
      zzaumzziqp.setDefaultAccount(zzasc.currentTimeMillis());
    }
    if (Long.valueOf(zzaumzziqu.lastModified()).longValue() == 0L)
    {
      zzaul().zzayj().append("Persisting first open", Long.valueOf(zziuc));
      zzaumzziqu.setDefaultAccount(zziuc);
    }
    if (!zzayv())
    {
      if (isEnabled())
      {
        if (!zzauh().zzdt("android.permission.INTERNET")) {
          zzaul().zzayd().append("App is missing INTERNET permission");
        }
        if (!zzauh().zzdt("android.permission.ACCESS_NETWORK_STATE")) {
          zzaul().zzayd().append("App is missing ACCESS_NETWORK_STATE permission");
        }
        zzcax.zzawk();
        if (!zzbed.zzcr(mContext).zzalq())
        {
          if (!zzccn.listen(mContext, false)) {
            zzaul().zzayd().append("AppMeasurementReceiver not registered/enabled");
          }
          if (!zzcfh.load(mContext, false)) {
            zzaul().zzayd().append("AppMeasurementService not registered/enabled");
          }
        }
        zzaul().zzayd().append("Uploading is not possible. App measurement disabled");
      }
    }
    else
    {
      zzcax.zzawk();
      Object localObject;
      if (!TextUtils.isEmpty(zzaua().getGmpAppId()))
      {
        localObject = zzaum().zzaym();
        if (localObject == null)
        {
          zzaum().zzjj(zzaua().getGmpAppId());
        }
        else if (!((String)localObject).equals(zzaua().getGmpAppId()))
        {
          zzaul().zzayh().append("Rechecking which service to use due to a GMP App Id change");
          zzaum().zzayp();
          zzitg.disconnect();
          zzitg.zzxh();
          zzaum().zzjj(zzaua().getGmpAppId());
          zzaumzziqu.setDefaultAccount(zziuc);
          zzaumzziqv.zzjl(null);
        }
      }
      zzatz().zzjk(zzaumzziqv.zzayr());
      zzcax.zzawk();
      if (!TextUtils.isEmpty(zzaua().getGmpAppId()))
      {
        localObject = zzatz();
        ((zzcdw)localObject).zzuj();
        ((zzcdw)localObject).zzatv();
        ((zzcdu)localObject).zzwk();
        if (zziki.zzayv())
        {
          ((zzcdw)localObject).zzauc().zzazq();
          String str = ((zzcdw)localObject).zzaum().zzayq();
          if (!TextUtils.isEmpty(str))
          {
            ((zzcdw)localObject).zzaub().zzwk();
            if (!str.equals(Build.VERSION.RELEASE))
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("_po", str);
              ((zzcdw)localObject).put("auto", "_ou", localBundle);
            }
          }
        }
        zzauc().Refresh(new AtomicReference());
      }
    }
    zzazi();
  }
  
  public final void trim(int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte)
  {
    zzauk().zzuj();
    zzwk();
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {}
    try
    {
      localObject = new byte[0];
      paramArrayOfByte = zzitt;
      zzitt = null;
      int j = 1;
      if (((paramInt == 200) || (paramInt == 204)) && (paramThrowable == null)) {
        try
        {
          paramThrowable = zzaum();
          paramThrowable = zziqp;
          Log localLog = zzasc;
          paramThrowable.setDefaultAccount(localLog.currentTimeMillis());
          paramThrowable = zzaum();
          paramThrowable = zziqq;
          paramThrowable.setDefaultAccount(0L);
          zzazi();
          paramThrowable = zzaul().zzayj();
          i = localObject.length;
          paramThrowable.append("Successful upload. Got network response. code, size", Integer.valueOf(paramInt), Integer.valueOf(i));
          zzauf().beginTransaction();
          try
          {
            paramArrayOfByte = paramArrayOfByte.iterator();
            for (;;)
            {
              bool = paramArrayOfByte.hasNext();
              if (bool)
              {
                localObject = (Long)paramArrayOfByte.next();
                paramThrowable = zzauf();
                long l = ((Long)localObject).longValue();
                paramThrowable.zzuj();
                paramThrowable.zzwk();
                localObject = paramThrowable.getWritableDatabase();
                try
                {
                  paramInt = ((SQLiteDatabase)localObject).delete("queue", "rowid=?", new String[] { String.valueOf(l) });
                  if (paramInt != 1) {
                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                  }
                }
                catch (SQLiteException paramArrayOfByte)
                {
                  paramThrowable.zzaul().zzayd().append("Failed to delete a bundle in a queue table", paramArrayOfByte);
                  throw paramArrayOfByte;
                }
              }
            }
            zzauf().setTransactionSuccessful();
            zzauf().endTransaction();
            boolean bool = zzaza().zzyx();
            if (bool)
            {
              bool = zzazh();
              if (bool)
              {
                zzazg();
                break label310;
              }
            }
            zzitx = -1L;
            zzazi();
            label310:
            zzity = 0L;
          }
          catch (Throwable paramThrowable)
          {
            zzauf().endTransaction();
            throw paramThrowable;
          }
          zzaul().zzayj().append("Network upload failed. Will retry later. code, error", Integer.valueOf(paramInt), paramThrowable);
        }
        catch (SQLiteException paramThrowable)
        {
          zzaul().zzayd().append("Database error while trying to delete uploaded bundles", paramThrowable);
          zzity = zzasc.elapsedRealtime();
          zzaul().zzayj().append("Disable upload, time", Long.valueOf(zzity));
        }
      }
      zzaumzziqq.setDefaultAccount(zzasc.currentTimeMillis());
      int i = j;
      if (paramInt != 503) {
        if (paramInt == 429) {
          i = j;
        } else {
          i = 0;
        }
      }
      if (i != 0) {
        zzaumzziqr.setDefaultAccount(zzasc.currentTimeMillis());
      }
      zzazi();
      zziua = false;
      zzazm();
      return;
    }
    catch (Throwable paramThrowable)
    {
      zziua = false;
      zzazm();
      throw paramThrowable;
    }
  }
  
  public final zzcan zzatx()
  {
    toJsonString(zzitn);
    return zzitn;
  }
  
  public final zzcau zzaty()
  {
    dispatchEvent(zzitm);
    return zzitm;
  }
  
  public final zzcdw zzatz()
  {
    dispatchEvent(zziti);
    return zziti;
  }
  
  public final zzcbr zzaua()
  {
    dispatchEvent(zzitj);
    return zzitj;
  }
  
  public final zzcbe zzaub()
  {
    dispatchEvent(zzith);
    return zzith;
  }
  
  public final zzceo zzauc()
  {
    dispatchEvent(zzitg);
    return zzitg;
  }
  
  public final zzcek zzaud()
  {
    dispatchEvent(zzitf);
    return zzitf;
  }
  
  public final zzcbs zzaue()
  {
    dispatchEvent(zzitd);
    return zzitd;
  }
  
  public final zzcay zzauf()
  {
    dispatchEvent(zzitc);
    return zzitc;
  }
  
  public final zzcbu zzaug()
  {
    toJsonString(zzitb);
    return zzitb;
  }
  
  public final zzcfw zzauh()
  {
    toJsonString(zzita);
    return zzita;
  }
  
  public final zzccq zzaui()
  {
    dispatchEvent(zzisx);
    return zzisx;
  }
  
  public final zzcfl zzauj()
  {
    dispatchEvent(zzisw);
    return zzisw;
  }
  
  public final zzccr zzauk()
  {
    dispatchEvent(zzisv);
    return zzisv;
  }
  
  public final zzcbw zzaul()
  {
    dispatchEvent(zzisu);
    return zzisu;
  }
  
  public final zzcch zzaum()
  {
    toJsonString(zzist);
    return zzist;
  }
  
  public final zzcax zzaun()
  {
    return zziss;
  }
  
  public final boolean zzayv()
  {
    zzwk();
    zzauk().zzuj();
    Boolean localBoolean = zzitp;
    if ((localBoolean == null) || (zzitq == 0L) || ((localBoolean != null) && (!localBoolean.booleanValue()) && (Math.abs(zzasc.elapsedRealtime() - zzitq) > 1000L)))
    {
      zzitq = zzasc.elapsedRealtime();
      zzcax.zzawk();
      boolean bool3 = zzauh().zzdt("android.permission.INTERNET");
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (zzauh().zzdt("android.permission.ACCESS_NETWORK_STATE")) {
          if (!zzbed.zzcr(mContext).zzalq())
          {
            bool1 = bool2;
            if (zzccn.listen(mContext, false))
            {
              bool1 = bool2;
              if (!zzcfh.load(mContext, false)) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
      zzitp = Boolean.valueOf(bool1);
      if (zzitp.booleanValue()) {
        zzitp = Boolean.valueOf(zzauh().zzkb(zzaua().getGmpAppId()));
      }
    }
    return zzitp.booleanValue();
  }
  
  public final zzcbw zzayw()
  {
    zzcbw localZzcbw = zzisu;
    if ((localZzcbw != null) && (localZzcbw.isInitialized())) {
      return zzisu;
    }
    return null;
  }
  
  public final zzccr zzayx()
  {
    return zzisv;
  }
  
  public final AppMeasurement zzayy()
  {
    return zzisy;
  }
  
  public final FirebaseAnalytics zzayz()
  {
    return zzisz;
  }
  
  public final zzcca zzaza()
  {
    dispatchEvent(zzite);
    return zzite;
  }
  
  public final long zzaze()
  {
    Long localLong = Long.valueOf(zzaumzziqu.lastModified());
    if (localLong.longValue() == 0L) {
      return zziuc;
    }
    return Math.min(zziuc, localLong.longValue());
  }
  
  public final void zzazg()
  {
    zzauk().zzuj();
    zzwk();
    zziub = true;
    for (;;)
    {
      try
      {
        zzcax.zzawk();
        localObject1 = zzaum().zzayo();
        if (localObject1 == null)
        {
          localObject1 = zzaul().zzayf();
          localObject2 = "Upload data called on the client side before use of service was decided";
          ((zzcby)localObject1).append((String)localObject2);
          zziub = false;
          zzazm();
          return;
        }
        bool = ((Boolean)localObject1).booleanValue();
        if (bool)
        {
          localObject1 = zzaul().zzayd();
          localObject2 = "Upload called in the client side when service should be used";
          continue;
        }
        l1 = zzity;
        if (l1 > 0L)
        {
          zzazi();
          continue;
        }
        zzauk().zzuj();
        localObject1 = zzitt;
        if (localObject1 != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localObject1 = zzaul().zzayj();
          localObject2 = "Uploading requested multiple times";
          continue;
        }
        bool = zzaza().zzyx();
        if (!bool)
        {
          zzaul().zzayj().append("Network not connected, ignoring upload request");
          continue;
        }
        l1 = zzasc.currentTimeMillis();
        l2 = zzcax.zzawv();
        arrayOfByte = null;
        saveData(null, l1 - l2);
        l2 = zzaumzziqp.lastModified();
        if (l2 != 0L)
        {
          localObject1 = zzaul().zzayi();
          ((zzcby)localObject1).append("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(l1 - l2)));
        }
        str = zzauf().zzaxi();
        bool = TextUtils.isEmpty(str);
        if (!bool)
        {
          l2 = zzitx;
          if (l2 == -1L) {
            zzitx = zzauf().zzaxp();
          }
          i = zziss.next(str, zzcbm.zzioh);
          int j = Math.max(0, zziss.next(str, zzcbm.zzioi));
          localObject4 = zzauf().getAll(str, i, j);
          localObject1 = localObject4;
          bool = ((List)localObject4).isEmpty();
          if (bool) {
            continue;
          }
          localObject2 = ((List)localObject4).iterator();
          bool = ((Iterator)localObject2).hasNext();
          if (bool)
          {
            localObject3 = (zzcgk)nextfirst;
            bool = TextUtils.isEmpty(zzizs);
            if (bool) {
              continue;
            }
            localObject3 = zzizs;
          }
          else
          {
            localObject3 = null;
          }
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            i = 0;
            j = ((List)localObject4).size();
            localObject2 = localObject1;
            if (i < j)
            {
              localObject2 = (zzcgk)getfirst;
              bool = TextUtils.isEmpty(zzizs);
              if (!bool)
              {
                bool = zzizs.equals(localObject3);
                if (!bool)
                {
                  localObject2 = ((List)localObject4).subList(0, i);
                  continue;
                }
              }
              i += 1;
              continue;
            }
          }
          localObject4 = new zzcgj();
          zzizc = new zzcgk[((List)localObject2).size()];
          localArrayList = new ArrayList(((List)localObject2).size());
          bool = zzcax.zzaxh();
          if (bool)
          {
            bool = zziss.zziu(str);
            if (bool)
            {
              i = 1;
              continue;
            }
          }
          i = 0;
          j = 0;
          int k = zzizc.length;
          if (j < k)
          {
            zzizc[j] = ((zzcgk)getfirst);
            localArrayList.add((Long)getsecond);
            localObject1 = zzizc[j];
            zzcax.zzauv();
            zzizr = Long.valueOf(11400L);
            zzizc[j].zzizh = Long.valueOf(l1);
            localObject1 = zzizc[j];
            zzcax.zzawk();
            zzizx = Boolean.valueOf(false);
            if (i == 0) {
              zzizc[j].zzjaf = null;
            }
            j += 1;
            continue;
          }
          bool = zzaul().zzad(2);
          localObject1 = arrayOfByte;
          if (bool) {
            localObject1 = zzaug().fromStream((zzcgj)localObject4);
          }
          arrayOfByte = zzauh().operate((zzcgj)localObject4);
          localObject3 = zzcax.zzawu();
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        long l1;
        int i;
        long l2;
        byte[] arrayOfByte;
        String str;
        Object localObject4;
        Object localObject3;
        ArrayList localArrayList;
        URL localURL;
        zziub = false;
        zzazm();
        throw localThrowable;
      }
      try
      {
        localURL = new URL((String)localObject3);
        bool = localArrayList.isEmpty();
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        }
        zzbp.zzbh(bool);
        localObject2 = zzitt;
        if (localObject2 != null)
        {
          zzaul().zzayd().append("Set uploading progress before finishing the previous upload");
        }
        else
        {
          localObject2 = new ArrayList(localArrayList);
          zzitt = ((List)localObject2);
        }
        localObject2 = zzaum();
        localObject2 = zziqq;
        ((zzcck)localObject2).setDefaultAccount(l1);
        localObject2 = "?";
        i = zzizc.length;
        if (i > 0) {
          localObject2 = zzizc[0].zzci;
        }
        localObject4 = zzaul().zzayj();
        i = arrayOfByte.length;
        ((zzcby)localObject4).attribute("Uploading data. app, uncompressed size, data", localObject2, Integer.valueOf(i), localObject1);
        zziua = true;
        localObject1 = zzaza();
        localObject2 = new zzccz(this);
        ((zzcca)localObject1).zzuj();
        ((zzcdu)localObject1).zzwk();
        zzbp.append(localURL);
        zzbp.append(arrayOfByte);
        zzbp.append(localObject2);
        localObject4 = ((zzcca)localObject1).zzauk();
        ((zzccr)localObject4).enqueue(new zzcce((zzcca)localObject1, str, localURL, arrayOfByte, null, (zzccc)localObject2));
      }
      catch (MalformedURLException localMalformedURLException)
      {
        continue;
      }
      zzaul().zzayd().append("Failed to parse upload URL. Not uploading. appId", zzcbw.zzjf(str), localObject3);
      continue;
      zzitx = -1L;
      localObject1 = zzauf();
      l2 = zzcax.zzawv();
      localObject1 = ((zzcay)localObject1).zzba(l1 - l2);
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        localObject1 = zzauf().zziw((String)localObject1);
        if (localObject1 != null) {
          getThreadId((zzcar)localObject1);
        }
      }
    }
  }
  
  public final void zzazj()
  {
    zzitw += 1;
  }
  
  public final void zzazk()
  {
    zzauk().zzuj();
    zzwk();
    if (!zzito)
    {
      zzaul().zzayh().append("This instance being marked as an uploader");
      zzauk().zzuj();
      zzwk();
      if ((zzazl()) && (zzazd()))
      {
        int i = transferTo(zzits);
        int j = zzaua().zzayb();
        zzauk().zzuj();
        zzcby localZzcby;
        Integer localInteger1;
        Integer localInteger2;
        String str;
        if (i > j)
        {
          localZzcby = zzaul().zzayd();
          localInteger1 = Integer.valueOf(i);
          localInteger2 = Integer.valueOf(j);
          str = "Panic: can't downgrade version. Previous, current version";
        }
        for (;;)
        {
          localZzcby.append(str, localInteger1, localInteger2);
          break;
          if (i >= j) {
            break;
          }
          if (write(j, zzits))
          {
            localZzcby = zzaul().zzayj();
            localInteger1 = Integer.valueOf(i);
            localInteger2 = Integer.valueOf(j);
            str = "Storage version upgraded. Previous, current version";
          }
          else
          {
            localZzcby = zzaul().zzayd();
            localInteger1 = Integer.valueOf(i);
            localInteger2 = Integer.valueOf(j);
            str = "Storage version upgrade failed. Previous, current version";
          }
        }
      }
      zzito = true;
      zzazi();
    }
  }
  
  public final void zzbo(boolean paramBoolean)
  {
    zzazi();
  }
  
  public final String zzjs(String paramString)
  {
    Object localObject = zzauk().getFromLocationName(new zzccy(this, paramString));
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    try
    {
      localObject = ((Future)localObject).get(30000L, localTimeUnit);
      return (String)localObject;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}catch (TimeoutException localTimeoutException) {}
    zzaul().zzayd().append("Failed to get app instance id. appId", zzcbw.zzjf(paramString), localTimeoutException);
    return null;
  }
  
  public final Log zzvx()
  {
    return zzasc;
  }
  
  public final void zzwk()
  {
    if (zzdoe) {
      return;
    }
    throw new IllegalStateException("AppMeasurement is not initialized");
  }
  
  public final class zza
    implements zzcba
  {
    public List<com.google.android.gms.internal.zzcgh> zzaoc;
    public zzcgk zziue;
    public List<Long> zziuf;
    public long zziug;
    
    public zza() {}
    
    public static long equalTo(zzcgh paramZzcgh)
    {
      return zziyy.longValue() / 1000L / 60L / 60L;
    }
    
    public final boolean contains(long paramLong, zzcgh paramZzcgh)
    {
      zzbp.append(paramZzcgh);
      if (zzaoc == null) {
        zzaoc = new ArrayList();
      }
      if (zziuf == null) {
        zziuf = new ArrayList();
      }
      if ((zzaoc.size() > 0) && (equalTo((zzcgh)zzaoc.get(0)) != equalTo(paramZzcgh))) {
        return false;
      }
      long l = zziug + paramZzcgh.zzhi();
      if (l >= zzcax.zzawr()) {
        return false;
      }
      zziug = l;
      zzaoc.add(paramZzcgh);
      zziuf.add(Long.valueOf(paramLong));
      return zzaoc.size() < zzcax.zzaws();
    }
    
    public final void printStackTrace(zzcgk paramZzcgk)
    {
      zzbp.append(paramZzcgk);
      zziue = paramZzcgk;
    }
  }
}
