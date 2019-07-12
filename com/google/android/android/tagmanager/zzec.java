package com.google.android.android.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.android.common.util.Clock;
import com.google.android.android.common.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzec
  implements zzcc
{
  public static final String zzdpj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] { "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time" });
  public final Context mContext;
  public Log zzasc;
  public final zzee zzjsx;
  public volatile zzbe zzjsy;
  public final zzcd zzjsz;
  public final String zzjta;
  public long zzjtb;
  public final int zzjtc;
  
  public zzec(zzcd paramZzcd, Context paramContext)
  {
    this(paramZzcd, paramContext, "gtm_urls.db", 2000);
  }
  
  public zzec(zzcd paramZzcd, Context paramContext, String paramString, int paramInt)
  {
    mContext = paramContext.getApplicationContext();
    zzjta = paramString;
    zzjsz = paramZzcd;
    zzasc = Clock.zzfyr;
    zzjsx = new zzee(this, mContext, zzjta);
    zzjsy = new zzfv(mContext, new zzed(this));
    zzjtb = 0L;
    zzjtc = 2000;
  }
  
  private final void deleteEntries(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return;
      }
      SQLiteDatabase localSQLiteDatabase = zzln("Error opening database for deleteHits.");
      if (localSQLiteDatabase == null) {
        return;
      }
      boolean bool = true;
      String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
      try
      {
        localSQLiteDatabase.delete("gtm_hits", str, paramArrayOfString);
        paramArrayOfString = zzjsz;
        int i = zzbee();
        if (i != 0) {
          bool = false;
        }
        paramArrayOfString.zzbu(bool);
        return;
      }
      catch (SQLiteException paramArrayOfString)
      {
        for (;;) {}
      }
      zzdj.zzjss.zzcr("Error deleting hits");
      return;
    }
  }
  
  private final void goTo(long paramLong)
  {
    deleteEntries(new String[] { String.valueOf(paramLong) });
  }
  
  private final void update(long paramLong1, long paramLong2)
  {
    Object localObject = zzln("Error opening database for getNumStoredHits.");
    if (localObject == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_first_send_time", Long.valueOf(paramLong2));
    try
    {
      ((SQLiteDatabase)localObject).update("gtm_hits", localContentValues, "hit_id=?", new String[] { String.valueOf(paramLong1) });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
    localObject = new StringBuilder(69);
    ((StringBuilder)localObject).append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ");
    ((StringBuilder)localObject).append(paramLong1);
    localObject = ((StringBuilder)localObject).toString();
    zzdj.zzjss.zzcr((String)localObject);
    goTo(paramLong1);
  }
  
  private final int zzbee()
  {
    Object localObject2 = zzln("Error opening database for getNumStoredHits.");
    j = 0;
    if (localObject2 == null) {
      return 0;
    }
    Object localObject1 = null;
    localObject3 = null;
    try
    {
      Cursor localCursor = ((SQLiteDatabase)localObject2).rawQuery("SELECT COUNT(*) from gtm_hits", null);
      localObject2 = localCursor;
      localObject3 = localObject2;
      localObject1 = localObject2;
      boolean bool = localCursor.moveToFirst();
      i = j;
      localObject1 = localObject2;
      if (bool)
      {
        localObject3 = localObject2;
        localObject1 = localObject2;
        long l = localCursor.getLong(0);
        i = (int)l;
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i;
        break;
        localObject3 = localThrowable;
        zzdj.zzjss.zzcr("Error getting numStoredHits");
        if (localThrowable != null) {
          i = j;
        } else {
          return 0;
        }
      }
      if (localObject3 == null) {
        break label141;
      }
      ((Cursor)localObject3).close();
      throw localThrowable;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
    localObject1.close();
    return i;
  }
  
  private final int zzbef()
  {
    Object localObject2 = zzln("Error opening database for getNumStoredHits.");
    int i = 0;
    if (localObject2 == null) {
      return 0;
    }
    Object localObject1 = null;
    localObject3 = null;
    try
    {
      Cursor localCursor = ((SQLiteDatabase)localObject2).query("gtm_hits", new String[] { "hit_id", "hit_first_send_time" }, "hit_first_send_time=0", null, null, null, null);
      localObject2 = localCursor;
      localObject3 = localObject2;
      localObject1 = localObject2;
      int j = localCursor.getCount();
      localObject1 = localObject2;
      i = j;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        break;
        localObject3 = localThrowable;
        zzdj.zzjss.zzcr("Error getting num untried hits");
        if (localThrowable == null) {
          return 0;
        }
      }
      if (localObject3 == null) {
        break label121;
      }
      ((Cursor)localObject3).close();
      throw localThrowable;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
    localObject1.close();
    return i;
  }
  
  private final List zzek(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0)
    {
      zzdj.zzjss.zzcr("Invalid maxHits specified. Skipping");
      return localArrayList;
    }
    SQLiteDatabase localSQLiteDatabase = zzln("Error opening database for peekHitIds.");
    if (localSQLiteDatabase == null) {
      return localArrayList;
    }
    Cursor localCursor3 = null;
    Cursor localCursor2 = null;
    Object localObject = localCursor2;
    Cursor localCursor1 = localCursor3;
    try
    {
      String str2 = String.format("%s ASC", new Object[] { "hit_id" });
      localObject = localCursor2;
      localCursor1 = localCursor3;
      String str3 = Integer.toString(paramInt);
      localObject = localCursor2;
      localCursor1 = localCursor3;
      localCursor3 = localSQLiteDatabase.query("gtm_hits", new String[] { "hit_id" }, null, null, null, null, str2, str3);
      localCursor2 = localCursor3;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      boolean bool = localCursor3.moveToFirst();
      localCursor1 = localCursor2;
      if (bool)
      {
        do
        {
          localObject = localCursor2;
          localCursor1 = localCursor2;
          localArrayList.add(String.valueOf(localCursor3.getLong(0)));
          localObject = localCursor2;
          localCursor1 = localCursor2;
          bool = localCursor3.moveToNext();
        } while (bool);
        localCursor1 = localCursor2;
      }
    }
    catch (Throwable localThrowable)
    {
      break label286;
    }
    catch (SQLiteException localSQLiteException)
    {
      localObject = localThrowable;
      String str1 = String.valueOf(localSQLiteException.getMessage());
      localObject = localThrowable;
      paramInt = str1.length();
      if (paramInt != 0)
      {
        localObject = localThrowable;
        str1 = "Error in peekHits fetching hitIds: ".concat(str1);
      }
      else
      {
        localObject = localThrowable;
        str1 = new String("Error in peekHits fetching hitIds: ");
      }
      localObject = localThrowable;
      zzdj.zzjss.zzcr(str1);
      if (localThrowable == null) {
        break label303;
      }
    }
    localThrowable.close();
    return localArrayList;
    label286:
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    throw localThrowable;
    label303:
    return localArrayList;
  }
  
  /* Error */
  private final List zzel(int paramInt)
  {
    // Byte code:
    //   0: new 256	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 257	java/util/ArrayList:<init>	()V
    //   7: astore 12
    //   9: aload_0
    //   10: ldc_w 302
    //   13: invokespecial 110	com/google/android/android/tagmanager/zzec:zzln	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 11
    //   18: aload 11
    //   20: ifnonnull +6 -> 26
    //   23: aload 12
    //   25: areturn
    //   26: ldc_w 263
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: ldc 31
    //   37: aastore
    //   38: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: astore 8
    //   43: bipush 40
    //   45: invokestatic 268	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   48: astore 9
    //   50: iconst_0
    //   51: istore_2
    //   52: aload 11
    //   54: ldc 29
    //   56: iconst_3
    //   57: anewarray 39	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: ldc 31
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: ldc 33
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: ldc 37
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: aload 8
    //   81: aload 9
    //   83: invokevirtual 271	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore 8
    //   88: aload 8
    //   90: astore 10
    //   92: new 256	java/util/ArrayList
    //   95: dup
    //   96: invokespecial 257	java/util/ArrayList:<init>	()V
    //   99: astore 9
    //   101: aload 8
    //   103: invokeinterface 230 1 0
    //   108: istore 5
    //   110: iload 5
    //   112: ifeq +85 -> 197
    //   115: aload 9
    //   117: new 304	com/google/android/android/tagmanager/zzbx
    //   120: dup
    //   121: aload 8
    //   123: iconst_0
    //   124: invokeinterface 234 2 0
    //   129: aload 8
    //   131: iconst_1
    //   132: invokeinterface 234 2 0
    //   137: aload 8
    //   139: iconst_2
    //   140: invokeinterface 234 2 0
    //   145: invokespecial 307	com/google/android/android/tagmanager/zzbx:<init>	(JJJ)V
    //   148: invokeinterface 277 2 0
    //   153: pop
    //   154: aload 8
    //   156: invokeinterface 280 1 0
    //   161: istore 5
    //   163: iload 5
    //   165: ifne -50 -> 115
    //   168: goto +29 -> 197
    //   171: astore 10
    //   173: aload 8
    //   175: astore 9
    //   177: aload 10
    //   179: astore 8
    //   181: goto +653 -> 834
    //   184: astore 11
    //   186: aload 9
    //   188: astore 10
    //   190: aload 8
    //   192: astore 9
    //   194: goto +568 -> 762
    //   197: aload 8
    //   199: invokeinterface 237 1 0
    //   204: ldc_w 263
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: ldc 31
    //   215: aastore
    //   216: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   219: astore 12
    //   221: bipush 40
    //   223: invokestatic 268	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   226: astore 13
    //   228: aload 11
    //   230: ldc 29
    //   232: iconst_2
    //   233: anewarray 39	java/lang/String
    //   236: dup
    //   237: iconst_0
    //   238: ldc 31
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: ldc 35
    //   245: aastore
    //   246: aconst_null
    //   247: aconst_null
    //   248: aconst_null
    //   249: aconst_null
    //   250: aload 12
    //   252: aload 13
    //   254: invokevirtual 271	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   257: astore 11
    //   259: aload 11
    //   261: astore 8
    //   263: aload 8
    //   265: astore 10
    //   267: aload 11
    //   269: invokeinterface 230 1 0
    //   274: istore 5
    //   276: iload 5
    //   278: ifeq +170 -> 448
    //   281: iconst_0
    //   282: istore_1
    //   283: aload 11
    //   285: checkcast 309	android/database/sqlite/SQLiteCursor
    //   288: astore 12
    //   290: aload 8
    //   292: astore 10
    //   294: aload 12
    //   296: invokevirtual 315	android/database/AbstractWindowedCursor:getWindow	()Landroid/database/CursorWindow;
    //   299: invokevirtual 320	android/database/CursorWindow:getNumRows	()I
    //   302: istore_3
    //   303: iload_3
    //   304: ifle +44 -> 348
    //   307: aload 8
    //   309: astore 10
    //   311: aload 9
    //   313: iload_1
    //   314: invokeinterface 324 2 0
    //   319: astore 12
    //   321: aload 12
    //   323: checkcast 304	com/google/android/android/tagmanager/zzbx
    //   326: astore 12
    //   328: aload 8
    //   330: astore 10
    //   332: aload 12
    //   334: aload 11
    //   336: iconst_1
    //   337: invokeinterface 327 2 0
    //   342: invokevirtual 330	com/google/android/android/tagmanager/zzbx:zzls	(Ljava/lang/String;)V
    //   345: goto +81 -> 426
    //   348: aload 8
    //   350: astore 10
    //   352: aload 9
    //   354: iload_1
    //   355: invokeinterface 324 2 0
    //   360: astore 12
    //   362: aload 8
    //   364: astore 10
    //   366: aload 12
    //   368: checkcast 304	com/google/android/android/tagmanager/zzbx
    //   371: astore 12
    //   373: aload 8
    //   375: astore 10
    //   377: aload 12
    //   379: invokevirtual 334	com/google/android/android/tagmanager/zzbx:zzbdr	()J
    //   382: lstore 6
    //   384: aload 8
    //   386: astore 10
    //   388: ldc_w 336
    //   391: iconst_1
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: lload 6
    //   399: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   402: aastore
    //   403: invokestatic 43	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   406: astore 12
    //   408: getstatic 150	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   411: astore 13
    //   413: aload 8
    //   415: astore 10
    //   417: aload 13
    //   419: aload 12
    //   421: invokeinterface 158 2 0
    //   426: iload_1
    //   427: iconst_1
    //   428: iadd
    //   429: istore_1
    //   430: aload 8
    //   432: astore 10
    //   434: aload 11
    //   436: invokeinterface 280 1 0
    //   441: istore 5
    //   443: iload 5
    //   445: ifne -162 -> 283
    //   448: aload 11
    //   450: invokeinterface 237 1 0
    //   455: aload 9
    //   457: areturn
    //   458: astore 11
    //   460: goto +32 -> 492
    //   463: astore 9
    //   465: aload 8
    //   467: astore 10
    //   469: aload 9
    //   471: astore 8
    //   473: goto +222 -> 695
    //   476: astore 11
    //   478: goto +14 -> 492
    //   481: astore 8
    //   483: goto +212 -> 695
    //   486: astore 11
    //   488: aload 10
    //   490: astore 8
    //   492: aload 9
    //   494: astore 12
    //   496: aload 8
    //   498: astore 10
    //   500: aload 11
    //   502: invokevirtual 285	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   505: invokestatic 288	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   508: astore 9
    //   510: aload 8
    //   512: astore 10
    //   514: aload 9
    //   516: invokevirtual 291	java/lang/String:length	()I
    //   519: istore_1
    //   520: iload_1
    //   521: ifeq +20 -> 541
    //   524: aload 8
    //   526: astore 10
    //   528: ldc_w 338
    //   531: aload 9
    //   533: invokevirtual 297	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   536: astore 9
    //   538: goto +19 -> 557
    //   541: aload 8
    //   543: astore 10
    //   545: new 39	java/lang/String
    //   548: dup
    //   549: ldc_w 338
    //   552: invokespecial 299	java/lang/String:<init>	(Ljava/lang/String;)V
    //   555: astore 9
    //   557: aload 8
    //   559: astore 10
    //   561: getstatic 150	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   564: aload 9
    //   566: invokeinterface 158 2 0
    //   571: aload 8
    //   573: astore 10
    //   575: new 256	java/util/ArrayList
    //   578: dup
    //   579: invokespecial 257	java/util/ArrayList:<init>	()V
    //   582: astore 9
    //   584: aload 8
    //   586: astore 10
    //   588: aload 12
    //   590: invokevirtual 341	java/util/ArrayList:size	()I
    //   593: istore 4
    //   595: iconst_0
    //   596: istore_1
    //   597: iload_2
    //   598: iload 4
    //   600: if_icmpge +78 -> 678
    //   603: aload 8
    //   605: astore 10
    //   607: aload 12
    //   609: iload_2
    //   610: invokevirtual 342	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   613: astore 11
    //   615: iload_2
    //   616: iconst_1
    //   617: iadd
    //   618: istore_3
    //   619: aload 8
    //   621: astore 10
    //   623: aload 11
    //   625: checkcast 304	com/google/android/android/tagmanager/zzbx
    //   628: astore 11
    //   630: aload 8
    //   632: astore 10
    //   634: aload 11
    //   636: invokevirtual 345	com/google/android/android/tagmanager/zzbx:zzbdt	()Ljava/lang/String;
    //   639: invokestatic 349	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   642: istore 5
    //   644: iload_1
    //   645: istore_2
    //   646: iload 5
    //   648: ifeq +9 -> 657
    //   651: iload_1
    //   652: ifne +26 -> 678
    //   655: iconst_1
    //   656: istore_2
    //   657: aload 8
    //   659: astore 10
    //   661: aload 9
    //   663: aload 11
    //   665: invokeinterface 277 2 0
    //   670: pop
    //   671: iload_2
    //   672: istore_1
    //   673: iload_3
    //   674: istore_2
    //   675: goto -78 -> 597
    //   678: aload 8
    //   680: ifnull +172 -> 852
    //   683: aload 8
    //   685: invokeinterface 237 1 0
    //   690: aload 9
    //   692: areturn
    //   693: astore 8
    //   695: aload 10
    //   697: ifnull +10 -> 707
    //   700: aload 10
    //   702: invokeinterface 237 1 0
    //   707: aload 8
    //   709: athrow
    //   710: astore 11
    //   712: aload 9
    //   714: astore 10
    //   716: goto +22 -> 738
    //   719: astore 10
    //   721: aload 8
    //   723: astore 9
    //   725: aload 10
    //   727: astore 8
    //   729: goto +105 -> 834
    //   732: astore 11
    //   734: aload 12
    //   736: astore 10
    //   738: aload 8
    //   740: astore 9
    //   742: goto +20 -> 762
    //   745: astore 8
    //   747: aconst_null
    //   748: astore 9
    //   750: goto +84 -> 834
    //   753: astore 11
    //   755: aconst_null
    //   756: astore 9
    //   758: aload 12
    //   760: astore 10
    //   762: aload 11
    //   764: invokevirtual 285	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   767: invokestatic 288	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   770: astore 8
    //   772: aload 8
    //   774: invokevirtual 291	java/lang/String:length	()I
    //   777: istore_1
    //   778: iload_1
    //   779: ifeq +16 -> 795
    //   782: ldc_w 293
    //   785: aload 8
    //   787: invokevirtual 297	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   790: astore 8
    //   792: goto +15 -> 807
    //   795: new 39	java/lang/String
    //   798: dup
    //   799: ldc_w 293
    //   802: invokespecial 299	java/lang/String:<init>	(Ljava/lang/String;)V
    //   805: astore 8
    //   807: getstatic 150	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   810: aload 8
    //   812: invokeinterface 158 2 0
    //   817: aload 9
    //   819: ifnull +36 -> 855
    //   822: aload 9
    //   824: invokeinterface 237 1 0
    //   829: aload 10
    //   831: areturn
    //   832: astore 8
    //   834: aload 9
    //   836: ifnull +10 -> 846
    //   839: aload 9
    //   841: invokeinterface 237 1 0
    //   846: goto +3 -> 849
    //   849: aload 8
    //   851: athrow
    //   852: aload 9
    //   854: areturn
    //   855: aload 10
    //   857: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	this	zzec
    //   0	858	1	paramInt	int
    //   51	624	2	i	int
    //   302	372	3	j	int
    //   593	8	4	k	int
    //   108	539	5	bool	boolean
    //   382	16	6	l	long
    //   41	431	8	localObject1	Object
    //   481	1	8	localThrowable1	Throwable
    //   490	194	8	localObject2	Object
    //   693	29	8	localThrowable2	Throwable
    //   727	12	8	localObject3	Object
    //   745	1	8	localThrowable3	Throwable
    //   770	41	8	str	String
    //   832	18	8	localThrowable4	Throwable
    //   48	408	9	localObject4	Object
    //   463	30	9	localThrowable5	Throwable
    //   508	345	9	localObject5	Object
    //   90	1	10	localObject6	Object
    //   171	7	10	localThrowable6	Throwable
    //   188	527	10	localObject7	Object
    //   719	7	10	localThrowable7	Throwable
    //   736	120	10	localObject8	Object
    //   16	37	11	localSQLiteDatabase	SQLiteDatabase
    //   184	45	11	localSQLiteException1	SQLiteException
    //   257	192	11	localCursor	Cursor
    //   458	1	11	localSQLiteException2	SQLiteException
    //   476	1	11	localSQLiteException3	SQLiteException
    //   486	15	11	localSQLiteException4	SQLiteException
    //   613	51	11	localObject9	Object
    //   710	1	11	localSQLiteException5	SQLiteException
    //   732	1	11	localSQLiteException6	SQLiteException
    //   753	10	11	localSQLiteException7	SQLiteException
    //   7	752	12	localObject10	Object
    //   226	192	13	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   115	163	171	java/lang/Throwable
    //   115	163	184	android/database/sqlite/SQLiteException
    //   267	276	458	android/database/sqlite/SQLiteException
    //   294	303	458	android/database/sqlite/SQLiteException
    //   311	321	458	android/database/sqlite/SQLiteException
    //   332	345	458	android/database/sqlite/SQLiteException
    //   352	362	458	android/database/sqlite/SQLiteException
    //   377	384	458	android/database/sqlite/SQLiteException
    //   388	408	458	android/database/sqlite/SQLiteException
    //   417	426	458	android/database/sqlite/SQLiteException
    //   434	443	458	android/database/sqlite/SQLiteException
    //   228	259	463	java/lang/Throwable
    //   228	259	476	android/database/sqlite/SQLiteException
    //   204	228	481	java/lang/Throwable
    //   204	228	486	android/database/sqlite/SQLiteException
    //   267	276	693	java/lang/Throwable
    //   294	303	693	java/lang/Throwable
    //   311	321	693	java/lang/Throwable
    //   332	345	693	java/lang/Throwable
    //   352	362	693	java/lang/Throwable
    //   366	373	693	java/lang/Throwable
    //   377	384	693	java/lang/Throwable
    //   388	408	693	java/lang/Throwable
    //   417	426	693	java/lang/Throwable
    //   434	443	693	java/lang/Throwable
    //   500	510	693	java/lang/Throwable
    //   514	520	693	java/lang/Throwable
    //   528	538	693	java/lang/Throwable
    //   545	557	693	java/lang/Throwable
    //   561	571	693	java/lang/Throwable
    //   575	584	693	java/lang/Throwable
    //   588	595	693	java/lang/Throwable
    //   607	615	693	java/lang/Throwable
    //   623	630	693	java/lang/Throwable
    //   634	644	693	java/lang/Throwable
    //   661	671	693	java/lang/Throwable
    //   101	110	710	android/database/sqlite/SQLiteException
    //   92	101	719	java/lang/Throwable
    //   101	110	719	java/lang/Throwable
    //   92	101	732	android/database/sqlite/SQLiteException
    //   26	50	745	java/lang/Throwable
    //   52	88	745	java/lang/Throwable
    //   26	50	753	android/database/sqlite/SQLiteException
    //   52	88	753	android/database/sqlite/SQLiteException
    //   762	778	832	java/lang/Throwable
    //   782	792	832	java/lang/Throwable
    //   795	807	832	java/lang/Throwable
    //   807	817	832	java/lang/Throwable
  }
  
  private final SQLiteDatabase zzln(String paramString)
  {
    Object localObject = zzjsx;
    try
    {
      localObject = ((zzee)localObject).getWritableDatabase();
      return localObject;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
    zzdj.zzjss.zzcr(paramString);
    return null;
  }
  
  public final void dispatch()
  {
    zzdj.zzjss.append("GTM Dispatch running...");
    if (!zzjsy.zzbdk()) {
      return;
    }
    List localList = zzel(40);
    if (localList.isEmpty())
    {
      zzdj.zzjss.append("...nothing to dispatch");
      zzjsz.zzbu(true);
      return;
    }
    zzjsy.zzai(localList);
    if (zzbef() > 0) {
      zzfo.zzbez().dispatch();
    }
  }
  
  public final void format(long paramLong, String paramString)
  {
    long l = zzasc.currentTimeMillis();
    if (l > zzjtb + 86400000L)
    {
      zzjtb = l;
      localObject1 = zzln("Error opening database for deleteStaleHits.");
      if (localObject1 != null)
      {
        ((SQLiteDatabase)localObject1).delete("gtm_hits", "HIT_TIME < ?", new String[] { Long.toString(zzasc.currentTimeMillis() - 2592000000L) });
        localObject1 = zzjsz;
        boolean bool;
        if (zzbee() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((zzcd)localObject1).zzbu(bool);
      }
    }
    int i = zzbee() - zzjtc + 1;
    Object localObject2;
    if (i > 0)
    {
      localObject1 = zzek(i);
      i = ((List)localObject1).size();
      localObject2 = new StringBuilder(51);
      ((StringBuilder)localObject2).append("Store full, deleting ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" hits to make room.");
      localObject2 = ((StringBuilder)localObject2).toString();
      zzdj.zzjss.append((String)localObject2);
      deleteEntries((String[])((List)localObject1).toArray(new String[0]));
    }
    Object localObject1 = zzln("Error opening database for putHit");
    if (localObject1 != null)
    {
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("hit_time", Long.valueOf(paramLong));
      ((ContentValues)localObject2).put("hit_url", paramString);
      ((ContentValues)localObject2).put("hit_first_send_time", Integer.valueOf(0));
      try
      {
        ((SQLiteDatabase)localObject1).insert("gtm_hits", null, (ContentValues)localObject2);
        paramString = zzjsz;
        paramString.zzbu(false);
        return;
      }
      catch (SQLiteException paramString)
      {
        for (;;) {}
      }
      zzdj.zzjss.zzcr("Error storing hit");
      return;
    }
  }
}
