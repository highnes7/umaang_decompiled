package com.google.android.android.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.android.analytics.CampaignTrackingReceiver;
import com.google.android.android.analytics.MyLog;
import com.google.android.android.analytics.PingManager;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzang
  extends zzams
{
  public boolean mStarted;
  public final zzand zzdpp;
  public final zzaop zzdpq;
  public final zzaoo zzdpr;
  public final zzamy zzdps;
  public long zzdpt;
  public final zzanx zzdpu;
  public final zzanx zzdpv;
  public final zzaoz zzdpw;
  public long zzdpx;
  public boolean zzdpy;
  
  public zzang(zzamu paramZzamu, zzamw paramZzamw)
  {
    super(paramZzamu);
    zzbp.append(paramZzamw);
    zzdpt = Long.MIN_VALUE;
    zzdpr = new zzaoo(paramZzamu);
    zzdpp = new zzand(paramZzamu);
    zzdpq = new zzaop(paramZzamu);
    zzdps = new zzamy(paramZzamu);
    zzdpw = new zzaoz(zzvx());
    zzdpu = new zzanh(this, paramZzamu);
    zzdpv = new zzani(this, paramZzamu);
  }
  
  private final void saveCache(zzamx paramZzamx, zzalw paramZzalw)
  {
    zzbp.append(paramZzamx);
    zzbp.append(paramZzalw);
    Object localObject1 = new MyLog(zzvw());
    ((MyLog)localObject1).zzcw(paramZzamx.zzws());
    ((MyLog)localObject1).enableAdvertisingIdCollection(paramZzamx.zzwt());
    localObject1 = ((MyLog)localObject1).zzts();
    zzame localZzame = (zzame)((PingManager)localObject1).getInstance(com.google.android.gms.internal.zzame.class);
    localZzame.zzdh("data");
    localZzame.zzai(true);
    ((PingManager)localObject1).init(paramZzalw);
    zzalz localZzalz = (zzalz)((PingManager)localObject1).getInstance(com.google.android.gms.internal.zzalz.class);
    zzalv localZzalv = (zzalv)((PingManager)localObject1).getInstance(com.google.android.gms.internal.zzalv.class);
    Iterator localIterator = paramZzamx.zziy().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ("an".equals(str)) {
        localZzalv.setAppName((String)localObject2);
      } else if ("av".equals(str)) {
        localZzalv.setAppVersion((String)localObject2);
      } else if ("aid".equals(str)) {
        localZzalv.setAppId((String)localObject2);
      } else if ("aiid".equals(str)) {
        localZzalv.setAppInstallerId((String)localObject2);
      } else if ("uid".equals(str)) {
        localZzame.setUserId((String)localObject2);
      } else {
        localZzalz.write(str, (String)localObject2);
      }
    }
    write("Sending installation campaign to", paramZzamx.zzws(), paramZzalw);
    ((PingManager)localObject1).ping(zzwf().zzzb());
    ((PingManager)localObject1).zzua();
  }
  
  private final boolean zzdt(String paramString)
  {
    return zzbed.zzcr(getContext()).checkCallingOrSelfPermission(paramString) == 0;
  }
  
  private final long zzxa()
  {
    TerminalManager.zzuj();
    zzwk();
    zzand localZzand = zzdpp;
    try
    {
      long l = localZzand.zzxa();
      return l;
    }
    catch (SQLiteException localSQLiteException)
    {
      toString("Failed to get min/max hit times from local store", localSQLiteException);
    }
    return 0L;
  }
  
  private final void zzxf()
  {
    Refresh(new zzank(this));
  }
  
  private final void zzxg()
  {
    zzand localZzand = zzdpp;
    try
    {
      localZzand.zzwz();
      zzxk();
    }
    catch (SQLiteException localSQLiteException)
    {
      append("Failed to delete stale hits", localSQLiteException);
    }
    zzdpv.updateTimer(86400000L);
  }
  
  private final void zzxh()
  {
    if (zzdpy) {
      return;
    }
    if (!zzanv.zzxv()) {
      return;
    }
    if (zzdps.isConnected()) {
      return;
    }
    long l = ((Long)zzaod.zzdsn.setDoOutput()).longValue();
    if (zzdpw.calculate(l))
    {
      zzdpw.start();
      zzdm("Connecting to service");
      if (zzdps.connect())
      {
        zzdm("Connected to service");
        zzdpw.clear();
        onServiceConnected();
      }
    }
  }
  
  /* Error */
  private final boolean zzxi()
  {
    // Byte code:
    //   0: invokestatic 271	com/google/android/android/analytics/TerminalManager:zzuj	()V
    //   3: aload_0
    //   4: invokevirtual 274	com/google/android/android/internal/zzams:zzwk	()V
    //   7: aload_0
    //   8: ldc_w 363
    //   11: invokevirtual 347	com/google/android/android/internal/zzamr:zzdm	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 58	com/google/android/android/internal/zzang:zzdps	Lcom/google/android/android/internal/zzamy;
    //   18: invokevirtual 319	com/google/android/android/internal/zzamy:isConnected	()Z
    //   21: istore_1
    //   22: aload_0
    //   23: getfield 53	com/google/android/android/internal/zzang:zzdpq	Lcom/google/android/android/internal/zzaop;
    //   26: invokevirtual 366	com/google/android/android/internal/zzaop:zzyx	()Z
    //   29: istore_2
    //   30: iload_1
    //   31: iconst_1
    //   32: ixor
    //   33: ifeq +18 -> 51
    //   36: iload_2
    //   37: iconst_1
    //   38: ixor
    //   39: ifeq +12 -> 51
    //   42: aload_0
    //   43: ldc_w 368
    //   46: invokevirtual 347	com/google/android/android/internal/zzamr:zzdm	(Ljava/lang/String;)V
    //   49: iconst_0
    //   50: ireturn
    //   51: invokestatic 371	com/google/android/android/internal/zzanv:zzxz	()I
    //   54: invokestatic 374	com/google/android/android/internal/zzanv:zzya	()I
    //   57: invokestatic 380	java/lang/Math:max	(II)I
    //   60: i2l
    //   61: lstore 7
    //   63: new 382	java/util/ArrayList
    //   66: dup
    //   67: invokespecial 384	java/util/ArrayList:<init>	()V
    //   70: astore 9
    //   72: lconst_0
    //   73: lstore 5
    //   75: aload_0
    //   76: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   79: invokevirtual 387	com/google/android/android/internal/zzand:beginTransaction	()V
    //   82: aload 9
    //   84: invokeinterface 390 1 0
    //   89: aload_0
    //   90: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   93: astore 10
    //   95: aload 10
    //   97: lload 7
    //   99: invokevirtual 394	com/google/android/android/internal/zzand:reload	(J)Ljava/util/List;
    //   102: astore 10
    //   104: aload 10
    //   106: invokeinterface 397 1 0
    //   111: istore_1
    //   112: iload_1
    //   113: ifeq +55 -> 168
    //   116: aload_0
    //   117: ldc_w 399
    //   120: invokevirtual 347	com/google/android/android/internal/zzamr:zzdm	(Ljava/lang/String;)V
    //   123: aload_0
    //   124: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   127: aload_0
    //   128: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   131: astore 9
    //   133: aload 9
    //   135: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   138: aload_0
    //   139: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   142: astore 9
    //   144: aload 9
    //   146: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   149: iconst_0
    //   150: ireturn
    //   151: astore 9
    //   153: aload_0
    //   154: ldc_w 410
    //   157: aload 9
    //   159: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   162: aload_0
    //   163: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   166: iconst_0
    //   167: ireturn
    //   168: aload_0
    //   169: ldc_w 412
    //   172: aload 10
    //   174: invokeinterface 415 1 0
    //   179: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: invokevirtual 424	com/google/android/android/internal/zzamr:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   185: aload 10
    //   187: invokeinterface 425 1 0
    //   192: astore 11
    //   194: aload 11
    //   196: invokeinterface 176 1 0
    //   201: istore_1
    //   202: iload_1
    //   203: ifeq +91 -> 294
    //   206: aload 11
    //   208: invokeinterface 180 1 0
    //   213: checkcast 427	com/google/android/android/internal/zzaoi
    //   216: invokevirtual 430	com/google/android/android/internal/zzaoi:zzym	()J
    //   219: lstore_3
    //   220: lload_3
    //   221: lload 5
    //   223: lcmp
    //   224: ifne -30 -> 194
    //   227: aload_0
    //   228: ldc_w 432
    //   231: lload 5
    //   233: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   236: aload 10
    //   238: invokeinterface 415 1 0
    //   243: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: invokevirtual 438	com/google/android/android/internal/zzamr:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   249: aload_0
    //   250: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   253: aload_0
    //   254: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   257: astore 9
    //   259: aload 9
    //   261: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   264: aload_0
    //   265: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   268: astore 9
    //   270: aload 9
    //   272: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   275: iconst_0
    //   276: ireturn
    //   277: astore 9
    //   279: aload_0
    //   280: ldc_w 410
    //   283: aload 9
    //   285: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   288: aload_0
    //   289: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   292: iconst_0
    //   293: ireturn
    //   294: aload_0
    //   295: getfield 58	com/google/android/android/internal/zzang:zzdps	Lcom/google/android/android/internal/zzamy;
    //   298: invokevirtual 319	com/google/android/android/internal/zzamy:isConnected	()Z
    //   301: istore_1
    //   302: lload 5
    //   304: lstore_3
    //   305: iload_1
    //   306: ifeq +177 -> 483
    //   309: aload_0
    //   310: ldc_w 440
    //   313: invokevirtual 347	com/google/android/android/internal/zzamr:zzdm	(Ljava/lang/String;)V
    //   316: aload 10
    //   318: invokeinterface 397 1 0
    //   323: istore_1
    //   324: lload 5
    //   326: lstore_3
    //   327: iload_1
    //   328: ifne +155 -> 483
    //   331: aload 10
    //   333: iconst_0
    //   334: invokeinterface 444 2 0
    //   339: checkcast 427	com/google/android/android/internal/zzaoi
    //   342: astore 11
    //   344: aload_0
    //   345: getfield 58	com/google/android/android/internal/zzang:zzdps	Lcom/google/android/android/internal/zzamy;
    //   348: aload 11
    //   350: invokevirtual 448	com/google/android/android/internal/zzamy:ready	(Lcom/google/android/android/internal/zzaoi;)Z
    //   353: istore_1
    //   354: lload 5
    //   356: lstore_3
    //   357: iload_1
    //   358: ifeq +125 -> 483
    //   361: lload 5
    //   363: aload 11
    //   365: invokevirtual 430	com/google/android/android/internal/zzaoi:zzym	()J
    //   368: invokestatic 451	java/lang/Math:max	(JJ)J
    //   371: lstore 5
    //   373: aload 10
    //   375: aload 11
    //   377: invokeinterface 454 2 0
    //   382: pop
    //   383: aload_0
    //   384: ldc_w 456
    //   387: aload 11
    //   389: invokevirtual 459	com/google/android/android/internal/zzamr:add	(Ljava/lang/String;Ljava/lang/Object;)V
    //   392: aload_0
    //   393: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   396: astore 12
    //   398: aload 12
    //   400: aload 11
    //   402: invokevirtual 430	com/google/android/android/internal/zzaoi:zzym	()J
    //   405: invokevirtual 462	com/google/android/android/internal/zzand:subscribe	(J)V
    //   408: aload 9
    //   410: aload 11
    //   412: invokevirtual 430	com/google/android/android/internal/zzaoi:zzym	()J
    //   415: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   418: invokeinterface 464 2 0
    //   423: pop
    //   424: goto -108 -> 316
    //   427: astore 9
    //   429: aload_0
    //   430: ldc_w 466
    //   433: aload 9
    //   435: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   438: aload_0
    //   439: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   442: aload_0
    //   443: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   446: astore 9
    //   448: aload 9
    //   450: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   453: aload_0
    //   454: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   457: astore 9
    //   459: aload 9
    //   461: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   464: iconst_0
    //   465: ireturn
    //   466: astore 9
    //   468: aload_0
    //   469: ldc_w 410
    //   472: aload 9
    //   474: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   477: aload_0
    //   478: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   481: iconst_0
    //   482: ireturn
    //   483: aload_0
    //   484: getfield 53	com/google/android/android/internal/zzang:zzdpq	Lcom/google/android/android/internal/zzaop;
    //   487: invokevirtual 366	com/google/android/android/internal/zzaop:zzyx	()Z
    //   490: istore_1
    //   491: lload_3
    //   492: lstore 5
    //   494: iload_1
    //   495: ifeq +141 -> 636
    //   498: aload_0
    //   499: getfield 53	com/google/android/android/internal/zzang:zzdpq	Lcom/google/android/android/internal/zzaop;
    //   502: aload 10
    //   504: invokevirtual 469	com/google/android/android/internal/zzaop:calculate	(Ljava/util/List;)Ljava/util/List;
    //   507: astore 10
    //   509: aload 10
    //   511: invokeinterface 425 1 0
    //   516: astore 11
    //   518: aload 11
    //   520: invokeinterface 176 1 0
    //   525: istore_1
    //   526: iload_1
    //   527: ifeq +24 -> 551
    //   530: lload_3
    //   531: aload 11
    //   533: invokeinterface 180 1 0
    //   538: checkcast 332	java/lang/Long
    //   541: invokevirtual 335	java/lang/Long:longValue	()J
    //   544: invokestatic 451	java/lang/Math:max	(JJ)J
    //   547: lstore_3
    //   548: goto -30 -> 518
    //   551: aload_0
    //   552: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   555: astore 11
    //   557: aload 11
    //   559: aload 10
    //   561: invokevirtual 472	com/google/android/android/internal/zzand:add	(Ljava/util/List;)V
    //   564: aload 9
    //   566: aload 10
    //   568: invokeinterface 476 2 0
    //   573: pop
    //   574: lload_3
    //   575: lstore 5
    //   577: goto +59 -> 636
    //   580: astore 9
    //   582: aload_0
    //   583: ldc_w 478
    //   586: aload 9
    //   588: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   591: aload_0
    //   592: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   595: aload_0
    //   596: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   599: astore 9
    //   601: aload 9
    //   603: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   606: aload_0
    //   607: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   610: astore 9
    //   612: aload 9
    //   614: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   617: iconst_0
    //   618: ireturn
    //   619: astore 9
    //   621: aload_0
    //   622: ldc_w 410
    //   625: aload 9
    //   627: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   630: aload_0
    //   631: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   634: iconst_0
    //   635: ireturn
    //   636: aload 9
    //   638: invokeinterface 397 1 0
    //   643: istore_1
    //   644: iload_1
    //   645: ifeq +44 -> 689
    //   648: aload_0
    //   649: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   652: astore 9
    //   654: aload 9
    //   656: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   659: aload_0
    //   660: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   663: astore 9
    //   665: aload 9
    //   667: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   670: iconst_0
    //   671: ireturn
    //   672: astore 9
    //   674: aload_0
    //   675: ldc_w 410
    //   678: aload 9
    //   680: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   683: aload_0
    //   684: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   687: iconst_0
    //   688: ireturn
    //   689: aload_0
    //   690: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   693: astore 10
    //   695: aload 10
    //   697: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   700: aload_0
    //   701: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   704: astore 10
    //   706: aload 10
    //   708: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   711: goto -636 -> 75
    //   714: astore 9
    //   716: aload_0
    //   717: ldc_w 410
    //   720: aload 9
    //   722: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   725: aload_0
    //   726: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   729: iconst_0
    //   730: ireturn
    //   731: astore 9
    //   733: aload_0
    //   734: ldc_w 480
    //   737: aload 9
    //   739: invokevirtual 301	com/google/android/android/internal/zzamr:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   742: aload_0
    //   743: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   746: aload_0
    //   747: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   750: astore 9
    //   752: aload 9
    //   754: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   757: aload_0
    //   758: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   761: astore 9
    //   763: aload 9
    //   765: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   768: iconst_0
    //   769: ireturn
    //   770: astore 9
    //   772: aload_0
    //   773: ldc_w 410
    //   776: aload 9
    //   778: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   781: aload_0
    //   782: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   785: iconst_0
    //   786: ireturn
    //   787: astore 9
    //   789: aload_0
    //   790: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   793: astore 10
    //   795: aload 10
    //   797: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   800: aload_0
    //   801: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   804: astore 10
    //   806: aload 10
    //   808: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   811: aload 9
    //   813: athrow
    //   814: astore 9
    //   816: aload_0
    //   817: ldc_w 410
    //   820: aload 9
    //   822: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   825: aload_0
    //   826: invokespecial 402	com/google/android/android/internal/zzang:zzxm	()V
    //   829: iconst_0
    //   830: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	831	0	this	zzang
    //   21	624	1	bool1	boolean
    //   29	10	2	bool2	boolean
    //   219	356	3	l1	long
    //   73	503	5	l2	long
    //   61	37	7	l3	long
    //   70	75	9	localObject1	Object
    //   151	7	9	localSQLiteException1	SQLiteException
    //   257	14	9	localZzand1	zzand
    //   277	132	9	localSQLiteException2	SQLiteException
    //   427	7	9	localSQLiteException3	SQLiteException
    //   446	14	9	localZzand2	zzand
    //   466	99	9	localSQLiteException4	SQLiteException
    //   580	7	9	localSQLiteException5	SQLiteException
    //   599	14	9	localZzand3	zzand
    //   619	18	9	localSQLiteException6	SQLiteException
    //   652	14	9	localZzand4	zzand
    //   672	7	9	localSQLiteException7	SQLiteException
    //   714	7	9	localSQLiteException8	SQLiteException
    //   731	7	9	localSQLiteException9	SQLiteException
    //   750	14	9	localZzand5	zzand
    //   770	7	9	localSQLiteException10	SQLiteException
    //   787	25	9	localThrowable	Throwable
    //   814	7	9	localSQLiteException11	SQLiteException
    //   93	714	10	localObject2	Object
    //   192	366	11	localObject3	Object
    //   396	3	12	localZzand6	zzand
    // Exception table:
    //   from	to	target	type
    //   133	138	151	android/database/sqlite/SQLiteException
    //   144	149	151	android/database/sqlite/SQLiteException
    //   259	264	277	android/database/sqlite/SQLiteException
    //   270	275	277	android/database/sqlite/SQLiteException
    //   398	424	427	android/database/sqlite/SQLiteException
    //   448	453	466	android/database/sqlite/SQLiteException
    //   459	464	466	android/database/sqlite/SQLiteException
    //   557	574	580	android/database/sqlite/SQLiteException
    //   601	606	619	android/database/sqlite/SQLiteException
    //   612	617	619	android/database/sqlite/SQLiteException
    //   654	659	672	android/database/sqlite/SQLiteException
    //   665	670	672	android/database/sqlite/SQLiteException
    //   695	700	714	android/database/sqlite/SQLiteException
    //   706	711	714	android/database/sqlite/SQLiteException
    //   95	112	731	android/database/sqlite/SQLiteException
    //   116	127	731	android/database/sqlite/SQLiteException
    //   168	185	731	android/database/sqlite/SQLiteException
    //   752	757	770	android/database/sqlite/SQLiteException
    //   763	768	770	android/database/sqlite/SQLiteException
    //   75	89	787	java/lang/Throwable
    //   95	112	787	java/lang/Throwable
    //   116	127	787	java/lang/Throwable
    //   168	185	787	java/lang/Throwable
    //   185	194	787	java/lang/Throwable
    //   194	202	787	java/lang/Throwable
    //   206	220	787	java/lang/Throwable
    //   227	253	787	java/lang/Throwable
    //   294	302	787	java/lang/Throwable
    //   309	316	787	java/lang/Throwable
    //   316	324	787	java/lang/Throwable
    //   331	354	787	java/lang/Throwable
    //   361	392	787	java/lang/Throwable
    //   398	424	787	java/lang/Throwable
    //   429	442	787	java/lang/Throwable
    //   483	491	787	java/lang/Throwable
    //   498	518	787	java/lang/Throwable
    //   518	526	787	java/lang/Throwable
    //   530	548	787	java/lang/Throwable
    //   557	574	787	java/lang/Throwable
    //   582	595	787	java/lang/Throwable
    //   636	644	787	java/lang/Throwable
    //   733	746	787	java/lang/Throwable
    //   795	800	814	android/database/sqlite/SQLiteException
    //   806	811	814	android/database/sqlite/SQLiteException
  }
  
  private final void zzxl()
  {
    zzaoa localZzaoa = zzwd();
    if (!localZzaoa.zzyj()) {
      return;
    }
    if (!localZzaoa.zzdp())
    {
      long l = zzxa();
      if ((l != 0L) && (Math.abs(zzvx().currentTimeMillis() - l) <= ((Long)zzaod.zzdrm.setDoOutput()).longValue()))
      {
        d("Dispatch alarm scheduled (ms)", Long.valueOf(zzanv.zzxy()));
        localZzaoa.schedule();
      }
    }
  }
  
  private final void zzxm()
  {
    if (zzdpu.zzdp()) {
      zzdm("All hits dispatched or no network/service. Going to power save mode");
    }
    zzdpu.cancel();
    zzaoa localZzaoa = zzwd();
    if (localZzaoa.zzdp()) {
      localZzaoa.cancel();
    }
  }
  
  private final long zzxn()
  {
    long l = zzdpt;
    if (l != Long.MIN_VALUE) {
      return l;
    }
    l = ((Long)zzaod.zzdrh.setDoOutput()).longValue();
    zzape localZzape = zzwe();
    localZzape.zzwk();
    if (zzdun)
    {
      localZzape = zzwe();
      localZzape.zzwk();
      l = zzdsu * 1000L;
    }
    return l;
  }
  
  private final void zzxo()
  {
    zzwk();
    TerminalManager.zzuj();
    zzdpy = true;
    zzdps.disconnect();
    zzxk();
  }
  
  public final void Refresh(zzaob paramZzaob)
  {
    long l2 = zzdpx;
    TerminalManager.zzuj();
    zzwk();
    long l1 = zzwf().zzzd();
    if (l1 != 0L) {
      l1 = Math.abs(zzvx().currentTimeMillis() - l1);
    } else {
      l1 = -1L;
    }
    add("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(l1));
    zzxh();
    try
    {
      zzxi();
      zzwf().zzze();
      zzxk();
      if (paramZzaob != null) {
        paramZzaob.downloadDatabase(null);
      }
      l1 = zzdpx;
      if (l1 != l2)
      {
        zzdpr.zzyw();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      toString("Local dispatch failed", localThrowable);
      zzwf().zzze();
      zzxk();
      if (paramZzaob != null) {
        paramZzaob.downloadDatabase(localThrowable);
      }
    }
  }
  
  public final void beep(long paramLong)
  {
    TerminalManager.zzuj();
    zzwk();
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    zzdpt = l;
    zzxk();
  }
  
  public final void getThreadId(zzamx paramZzamx)
  {
    TerminalManager.zzuj();
    add("Sending first hit to property", paramZzamx.zzws());
    if (zzwf().zzzc().calculate(zzanv.zzyf())) {
      return;
    }
    Object localObject = zzwf().zzzf();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    localObject = zzapd.loadFile(zzvy(), (String)localObject);
    add("Found relevant installation campaign", localObject);
    saveCache(paramZzamx, (zzalw)localObject);
  }
  
  /* Error */
  public final long insert(zzamx paramZzamx, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 34	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 274	com/google/android/android/internal/zzams:zzwk	()V
    //   9: invokestatic 271	com/google/android/android/analytics/TerminalManager:zzuj	()V
    //   12: aload_0
    //   13: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   16: astore 9
    //   18: aload 9
    //   20: invokevirtual 387	com/google/android/android/internal/zzand:beginTransaction	()V
    //   23: aload_0
    //   24: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   27: astore 9
    //   29: aload_1
    //   30: invokevirtual 610	com/google/android/android/internal/zzamx:zzwr	()J
    //   33: lstore 5
    //   35: aload_1
    //   36: invokevirtual 613	com/google/android/android/internal/zzamx:zzve	()Ljava/lang/String;
    //   39: astore 10
    //   41: aload 10
    //   43: invokestatic 617	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   46: pop
    //   47: aload 9
    //   49: invokevirtual 274	com/google/android/android/internal/zzams:zzwk	()V
    //   52: invokestatic 271	com/google/android/android/analytics/TerminalManager:zzuj	()V
    //   55: aload 9
    //   57: invokevirtual 621	com/google/android/android/internal/zzand:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   60: astore 11
    //   62: iconst_1
    //   63: istore_3
    //   64: aload 11
    //   66: ldc_w 623
    //   69: ldc_w 625
    //   72: iconst_2
    //   73: anewarray 187	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: lload 5
    //   80: invokestatic 628	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: aload 10
    //   88: aastore
    //   89: invokevirtual 634	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   92: istore 4
    //   94: iload 4
    //   96: ifle +16 -> 112
    //   99: aload 9
    //   101: ldc_w 636
    //   104: iload 4
    //   106: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: invokevirtual 424	com/google/android/android/internal/zzamr:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   112: aload_0
    //   113: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   116: astore 9
    //   118: aload 9
    //   120: aload_1
    //   121: invokevirtual 610	com/google/android/android/internal/zzamx:zzwr	()J
    //   124: aload_1
    //   125: invokevirtual 613	com/google/android/android/internal/zzamx:zzve	()Ljava/lang/String;
    //   128: aload_1
    //   129: invokevirtual 109	com/google/android/android/internal/zzamx:zzws	()Ljava/lang/String;
    //   132: invokevirtual 640	com/google/android/android/internal/zzand:getSize	(JLjava/lang/String;Ljava/lang/String;)J
    //   135: lstore 5
    //   137: aload_1
    //   138: lconst_1
    //   139: lload 5
    //   141: ladd
    //   142: invokevirtual 643	com/google/android/android/internal/zzamx:writeInt	(J)V
    //   145: aload_0
    //   146: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   149: astore 11
    //   151: aload_1
    //   152: invokestatic 34	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload 11
    //   158: invokevirtual 274	com/google/android/android/internal/zzams:zzwk	()V
    //   161: invokestatic 271	com/google/android/android/analytics/TerminalManager:zzuj	()V
    //   164: aload 11
    //   166: invokevirtual 621	com/google/android/android/internal/zzand:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   169: astore 12
    //   171: aload_1
    //   172: invokevirtual 159	com/google/android/android/internal/zzamx:zziy	()Ljava/util/Map;
    //   175: astore 10
    //   177: aload 10
    //   179: invokestatic 34	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: new 645	android/net/Uri$Builder
    //   186: dup
    //   187: invokespecial 646	android/net/Uri$Builder:<init>	()V
    //   190: astore 9
    //   192: aload 10
    //   194: invokeinterface 165 1 0
    //   199: invokeinterface 171 1 0
    //   204: astore 10
    //   206: aload 10
    //   208: invokeinterface 176 1 0
    //   213: istore_2
    //   214: iload_2
    //   215: ifeq +64 -> 279
    //   218: aload 10
    //   220: invokeinterface 180 1 0
    //   225: astore 13
    //   227: aload 13
    //   229: checkcast 182	java/util/Map$Entry
    //   232: astore 14
    //   234: aload 14
    //   236: invokeinterface 185 1 0
    //   241: astore 13
    //   243: aload 13
    //   245: checkcast 187	java/lang/String
    //   248: astore 13
    //   250: aload 14
    //   252: invokeinterface 190 1 0
    //   257: astore 14
    //   259: aload 14
    //   261: checkcast 187	java/lang/String
    //   264: astore 14
    //   266: aload 9
    //   268: aload 13
    //   270: aload 14
    //   272: invokevirtual 650	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   275: pop
    //   276: goto -70 -> 206
    //   279: aload 9
    //   281: invokevirtual 654	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   284: invokevirtual 659	android/net/Uri:getEncodedQuery	()Ljava/lang/String;
    //   287: astore 10
    //   289: aload 10
    //   291: astore 9
    //   293: aload 10
    //   295: ifnonnull +8 -> 303
    //   298: ldc_w 661
    //   301: astore 9
    //   303: new 663	android/content/ContentValues
    //   306: dup
    //   307: invokespecial 664	android/content/ContentValues:<init>	()V
    //   310: astore 10
    //   312: aload 10
    //   314: ldc_w 666
    //   317: aload_1
    //   318: invokevirtual 610	com/google/android/android/internal/zzamx:zzwr	()J
    //   321: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   324: invokevirtual 670	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   327: aload 10
    //   329: ldc_w 672
    //   332: aload_1
    //   333: invokevirtual 613	com/google/android/android/internal/zzamx:zzve	()Ljava/lang/String;
    //   336: invokevirtual 674	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload 10
    //   341: ldc_w 676
    //   344: aload_1
    //   345: invokevirtual 109	com/google/android/android/internal/zzamx:zzws	()Ljava/lang/String;
    //   348: invokevirtual 674	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload_1
    //   352: invokevirtual 117	com/google/android/android/internal/zzamx:zzwt	()Z
    //   355: istore_2
    //   356: iload_2
    //   357: ifeq +6 -> 363
    //   360: goto +5 -> 365
    //   363: iconst_0
    //   364: istore_3
    //   365: aload 10
    //   367: ldc_w 678
    //   370: iload_3
    //   371: invokestatic 421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: invokevirtual 681	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   377: aload 10
    //   379: ldc_w 683
    //   382: aload_1
    //   383: invokevirtual 686	com/google/android/android/internal/zzamx:zzwu	()J
    //   386: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   389: invokevirtual 670	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   392: aload 10
    //   394: ldc_w 688
    //   397: aload 9
    //   399: invokevirtual 674	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: aload 12
    //   404: ldc_w 623
    //   407: aconst_null
    //   408: aload 10
    //   410: iconst_5
    //   411: invokevirtual 692	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   414: lstore 7
    //   416: lload 7
    //   418: ldc2_w 550
    //   421: lcmp
    //   422: ifne +24 -> 446
    //   425: aload 11
    //   427: ldc_w 694
    //   430: invokevirtual 697	com/google/android/android/internal/zzamr:zzdq	(Ljava/lang/String;)V
    //   433: goto +13 -> 446
    //   436: astore_1
    //   437: aload 11
    //   439: ldc_w 699
    //   442: aload_1
    //   443: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   446: aload_0
    //   447: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   450: astore_1
    //   451: aload_1
    //   452: invokevirtual 405	com/google/android/android/internal/zzand:setTransactionSuccessful	()V
    //   455: aload_0
    //   456: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   464: lload 5
    //   466: lreturn
    //   467: astore_1
    //   468: aload_0
    //   469: ldc_w 701
    //   472: aload_1
    //   473: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   476: lload 5
    //   478: lreturn
    //   479: astore_1
    //   480: goto +38 -> 518
    //   483: astore_1
    //   484: aload_0
    //   485: ldc_w 703
    //   488: aload_1
    //   489: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   492: aload_0
    //   493: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   496: astore_1
    //   497: aload_1
    //   498: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   501: ldc2_w 550
    //   504: lreturn
    //   505: astore_1
    //   506: aload_0
    //   507: ldc_w 701
    //   510: aload_1
    //   511: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   514: ldc2_w 550
    //   517: lreturn
    //   518: aload_0
    //   519: getfield 48	com/google/android/android/internal/zzang:zzdpp	Lcom/google/android/android/internal/zzand;
    //   522: astore 9
    //   524: aload 9
    //   526: invokevirtual 408	com/google/android/android/internal/zzand:endTransaction	()V
    //   529: goto +14 -> 543
    //   532: astore 9
    //   534: aload_0
    //   535: ldc_w 701
    //   538: aload 9
    //   540: invokevirtual 282	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   543: goto +3 -> 546
    //   546: aload_1
    //   547: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	this	zzang
    //   0	548	1	paramZzamx	zzamx
    //   0	548	2	paramBoolean	boolean
    //   63	308	3	i	int
    //   92	13	4	j	int
    //   33	444	5	l1	long
    //   414	3	7	l2	long
    //   16	509	9	localObject1	Object
    //   532	7	9	localSQLiteException	SQLiteException
    //   39	370	10	localObject2	Object
    //   60	378	11	localObject3	Object
    //   169	234	12	localSQLiteDatabase	SQLiteDatabase
    //   225	44	13	localObject4	Object
    //   232	39	14	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   402	416	436	android/database/sqlite/SQLiteException
    //   425	433	436	android/database/sqlite/SQLiteException
    //   460	464	467	android/database/sqlite/SQLiteException
    //   12	18	479	java/lang/Throwable
    //   18	23	479	java/lang/Throwable
    //   23	29	479	java/lang/Throwable
    //   29	62	479	java/lang/Throwable
    //   64	94	479	java/lang/Throwable
    //   99	112	479	java/lang/Throwable
    //   118	137	479	java/lang/Throwable
    //   137	145	479	java/lang/Throwable
    //   145	151	479	java/lang/Throwable
    //   151	183	479	java/lang/Throwable
    //   183	206	479	java/lang/Throwable
    //   206	214	479	java/lang/Throwable
    //   218	227	479	java/lang/Throwable
    //   227	234	479	java/lang/Throwable
    //   234	243	479	java/lang/Throwable
    //   243	250	479	java/lang/Throwable
    //   250	259	479	java/lang/Throwable
    //   266	276	479	java/lang/Throwable
    //   279	289	479	java/lang/Throwable
    //   303	356	479	java/lang/Throwable
    //   365	402	479	java/lang/Throwable
    //   402	416	479	java/lang/Throwable
    //   425	433	479	java/lang/Throwable
    //   437	446	479	java/lang/Throwable
    //   451	455	479	java/lang/Throwable
    //   484	492	479	java/lang/Throwable
    //   18	23	483	android/database/sqlite/SQLiteException
    //   29	62	483	android/database/sqlite/SQLiteException
    //   64	94	483	android/database/sqlite/SQLiteException
    //   99	112	483	android/database/sqlite/SQLiteException
    //   118	137	483	android/database/sqlite/SQLiteException
    //   137	145	483	android/database/sqlite/SQLiteException
    //   151	183	483	android/database/sqlite/SQLiteException
    //   183	206	483	android/database/sqlite/SQLiteException
    //   206	214	483	android/database/sqlite/SQLiteException
    //   218	227	483	android/database/sqlite/SQLiteException
    //   234	243	483	android/database/sqlite/SQLiteException
    //   250	259	483	android/database/sqlite/SQLiteException
    //   266	276	483	android/database/sqlite/SQLiteException
    //   279	289	483	android/database/sqlite/SQLiteException
    //   303	356	483	android/database/sqlite/SQLiteException
    //   365	402	483	android/database/sqlite/SQLiteException
    //   437	446	483	android/database/sqlite/SQLiteException
    //   451	455	483	android/database/sqlite/SQLiteException
    //   497	501	505	android/database/sqlite/SQLiteException
    //   524	529	532	android/database/sqlite/SQLiteException
  }
  
  public final void onServiceConnected()
  {
    TerminalManager.zzuj();
    TerminalManager.zzuj();
    zzwk();
    if (!zzanv.zzxv()) {
      zzdp("Service client disabled. Can't dispatch local hits to device AnalyticsService");
    }
    if (!zzdps.isConnected())
    {
      zzdm("Service not connected");
      return;
    }
    if (!zzdpp.isEmpty())
    {
      zzdm("Dispatching local hits to device AnalyticsService");
      for (;;)
      {
        Object localObject = zzdpp;
        try
        {
          int i = zzanv.zzxz();
          long l = i;
          localObject = ((zzand)localObject).reload(l);
          boolean bool = ((List)localObject).isEmpty();
          if (bool)
          {
            zzxk();
            return;
          }
          while (!((List)localObject).isEmpty())
          {
            zzaoi localZzaoi = (zzaoi)((List)localObject).get(0);
            if (!zzdps.ready(localZzaoi))
            {
              zzxk();
              return;
            }
            ((List)localObject).remove(localZzaoi);
            zzand localZzand = zzdpp;
            try
            {
              localZzand.subscribe(localZzaoi.zzym());
            }
            catch (SQLiteException localSQLiteException1)
            {
              toString("Failed to remove hit that was send for delivery", localSQLiteException1);
              zzxm();
              return;
            }
          }
          return;
        }
        catch (SQLiteException localSQLiteException2)
        {
          toString("Failed to read hits from store", localSQLiteException2);
          zzxm();
        }
      }
    }
  }
  
  public final void pack(zzaoi paramZzaoi)
  {
    zzbp.append(paramZzaoi);
    TerminalManager.zzuj();
    zzwk();
    if (zzdpy) {
      zzdn("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
    } else {
      d("Delivering hit", paramZzaoi);
    }
    if (TextUtils.isEmpty(paramZzaoi.zzyr()))
    {
      Object localObject2 = zzwf().zzzg().zzzi();
      if (localObject2 != null)
      {
        localObject1 = (Long)second;
        localObject2 = (String)first;
        localObject1 = String.valueOf(localObject1);
        localObject1 = StringBuilder.append(StringBuilder.append(localObject2, ((String)localObject1).length() + 1), (String)localObject1, ":", (String)localObject2);
        localObject2 = new HashMap(paramZzaoi.zziy());
        ((Map)localObject2).put("_m", localObject1);
        paramZzaoi = new zzaoi(this, (Map)localObject2, paramZzaoi.zzyn(), paramZzaoi.zzyp(), paramZzaoi.zzym(), paramZzaoi.zzyl(), paramZzaoi.zzyo());
      }
    }
    zzxh();
    if (zzdps.ready(paramZzaoi))
    {
      zzdn("Hit sent to the device AnalyticsService for delivery");
      return;
    }
    Object localObject1 = zzdpp;
    try
    {
      ((zzand)localObject1).export(paramZzaoi);
      zzxk();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      toString("Delivery failed to save hit to a database", localSQLiteException);
      zzvy().append(paramZzaoi, "deliver: failed to insert hit to database");
    }
  }
  
  public final void start()
  {
    zzwk();
    zzbp.append(mStarted ^ true, "Analytics backend already started");
    mStarted = true;
    zzwa().d(new zzanj(this));
  }
  
  public final void zzdu(String paramString)
  {
    zzbp.zzgg(paramString);
    TerminalManager.zzuj();
    zzalw localZzalw = zzapd.loadFile(zzvy(), paramString);
    if (localZzalw == null)
    {
      append("Parsing failed. Ignoring invalid campaign data", paramString);
      return;
    }
    String str = zzwf().zzzf();
    if (paramString.equals(str))
    {
      zzdp("Ignoring duplicate install campaign");
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      a("Ignoring multiple install campaigns. original, new", str, paramString);
      return;
    }
    zzwf().zzdx(paramString);
    if (zzwf().zzzc().calculate(zzanv.zzyf()))
    {
      append("Campaign received too late, ignoring", localZzalw);
      return;
    }
    add("Received installation campaign", localZzalw);
    paramString = zzdpp.doInBackground(0L).iterator();
    while (paramString.hasNext()) {
      saveCache((zzamx)paramString.next(), localZzalw);
    }
  }
  
  public final void zzuk()
  {
    zzdpp.initialize();
    zzdpq.initialize();
    zzdps.initialize();
  }
  
  public final void zzvr()
  {
    TerminalManager.zzuj();
    zzwk();
    zzdm("Delete all hits from local store");
    zzand localZzand = zzdpp;
    try
    {
      TerminalManager.zzuj();
      localZzand.zzwk();
      localZzand.getWritableDatabase().delete("hits2", null, null);
      localZzand = zzdpp;
      TerminalManager.zzuj();
      localZzand.zzwk();
      localZzand.getWritableDatabase().delete("properties", null, null);
      zzxk();
    }
    catch (SQLiteException localSQLiteException)
    {
      append("Failed to delete hits from store", localSQLiteException);
    }
    zzxh();
    if (zzdps.zzwv()) {
      zzdm("Device service unavailable. Can't clear hits stored on the device service.");
    }
  }
  
  public final void zzvv()
  {
    TerminalManager.zzuj();
    zzdpx = zzvx().currentTimeMillis();
  }
  
  public final void zzxe()
  {
    zzwk();
    TerminalManager.zzuj();
    Context localContext = zzvw().getContext();
    if (!zzaou.zzbe(localContext)) {
      zzdp("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
    } else if (!zzaov.zzbi(localContext)) {
      zzdq("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
    }
    if (!CampaignTrackingReceiver.zzbe(localContext)) {
      zzdp("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
    }
    zzwf().zzzb();
    if (!zzdt("android.permission.ACCESS_NETWORK_STATE"))
    {
      zzdq("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzxo();
    }
    if (!zzdt("android.permission.INTERNET"))
    {
      zzdq("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzxo();
    }
    if (zzaov.zzbi(getContext())) {
      zzdm("AnalyticsService registered in the app manifest and enabled");
    } else {
      zzdp("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
    }
    if ((!zzdpy) && (!zzdpp.isEmpty())) {
      zzxh();
    }
    zzxk();
  }
  
  public final void zzxj()
  {
    TerminalManager.zzuj();
    zzwk();
    zzdn("Sync dispatching local hits");
    long l1 = zzdpx;
    zzxh();
    try
    {
      zzxi();
      zzwf().zzze();
      zzxk();
      long l2 = zzdpx;
      if (l2 != l1)
      {
        zzdpr.zzyw();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      toString("Sync local dispatch failed", localThrowable);
      zzxk();
    }
  }
  
  public final void zzxk()
  {
    TerminalManager.zzuj();
    zzwk();
    boolean bool2 = zzdpy;
    boolean bool1 = true;
    int i;
    if ((!bool2) && (zzxn() > 0L)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      zzdpr.unregister();
      zzxm();
      return;
    }
    if (zzdpp.isEmpty())
    {
      zzdpr.unregister();
      zzxm();
      return;
    }
    if (!((Boolean)zzaod.zzdsi.setDoOutput()).booleanValue())
    {
      zzdpr.zzyu();
      bool1 = zzdpr.isConnected();
    }
    if (bool1)
    {
      zzxl();
      long l2 = zzxn();
      long l1 = zzwf().zzzd();
      if (l1 != 0L)
      {
        l1 = l2 - Math.abs(zzvx().currentTimeMillis() - l1);
        if (l1 > 0L) {}
      }
      else
      {
        l1 = Math.min(zzanv.zzxx(), l2);
      }
      d("Dispatch scheduled (ms)", Long.valueOf(l1));
      if (zzdpu.zzdp())
      {
        l1 = Math.max(1L, zzdpu.zzyg() + l1);
        zzdpu.update(l1);
        return;
      }
      zzdpu.updateTimer(l1);
      return;
    }
    zzxm();
    zzxl();
  }
}
