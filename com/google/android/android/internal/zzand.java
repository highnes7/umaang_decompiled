package com.google.android.android.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.HttpResponse;
import com.google.android.android.common.util.Log;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzand
  extends zzams
  implements Closeable
{
  public static final String zzdpj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  public static final String zzdpk = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[] { "hit_time", "hits2" });
  public final zzane zzdpl;
  public final zzaoz zzdpm = new zzaoz(zzvx());
  public final zzaoz zzdpn = new zzaoz(zzvx());
  
  public zzand(zzamu paramZzamu)
  {
    super(paramZzamu);
    zzdpl = new zzane(this, paramZzamu.getContext(), "google_analytics_v4.db");
  }
  
  private final long count(String paramString, String[] paramArrayOfString)
  {
    Object localObject2 = getWritableDatabase();
    Object localObject1 = null;
    paramArrayOfString = null;
    try
    {
      Cursor localCursor = ((SQLiteDatabase)localObject2).rawQuery(paramString, null);
      localObject2 = localCursor;
      paramArrayOfString = (String[])localObject2;
      localObject1 = localObject2;
      boolean bool = localCursor.moveToFirst();
      if (bool)
      {
        paramArrayOfString = (String[])localObject2;
        localObject1 = localObject2;
        long l = localCursor.getLong(0);
        localCursor.close();
        return l;
      }
      paramArrayOfString = (String[])localObject2;
      localObject1 = localObject2;
      throw new SQLiteException("Database returned empty set");
    }
    catch (Throwable paramString) {}catch (SQLiteException localSQLiteException)
    {
      paramArrayOfString = localObject1;
      a("Database error", paramString, localSQLiteException);
      paramArrayOfString = localObject1;
      throw localSQLiteException;
    }
    if (paramArrayOfString != null) {
      paramArrayOfString.close();
    }
    throw paramString;
  }
  
  private final List getAll(long paramLong)
  {
    TerminalManager.zzuj();
    zzwk();
    if (paramLong <= 0L) {
      return Collections.emptyList();
    }
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor3 = null;
    Cursor localCursor2 = null;
    Object localObject = localCursor2;
    Cursor localCursor1 = localCursor3;
    try
    {
      String str1 = String.format("%s ASC", new Object[] { "hit_id" });
      localObject = localCursor2;
      localCursor1 = localCursor3;
      String str2 = Long.toString(paramLong);
      localObject = localCursor2;
      localCursor1 = localCursor3;
      localCursor3 = localSQLiteDatabase.query("hits2", new String[] { "hit_id" }, null, null, null, null, str1, str2);
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
          localArrayList.add(Long.valueOf(localCursor3.getLong(0)));
          localObject = localCursor2;
          localCursor1 = localCursor2;
          bool = localCursor3.moveToNext();
        } while (bool);
        localCursor1 = localCursor2;
      }
    }
    catch (Throwable localThrowable)
    {
      break label226;
    }
    catch (SQLiteException localSQLiteException)
    {
      localObject = localThrowable;
      append("Error selecting hit ids", localSQLiteException);
      if (localThrowable == null) {
        break label244;
      }
    }
    localThrowable.close();
    return localArrayList;
    label226:
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    throw localThrowable;
    label244:
    return localArrayList;
  }
  
  private final long getCount(String paramString, String[] paramArrayOfString, long paramLong)
  {
    Object localObject = getWritableDatabase();
    String[] arrayOfString2 = null;
    String[] arrayOfString1 = null;
    try
    {
      localObject = ((SQLiteDatabase)localObject).rawQuery(paramString, paramArrayOfString);
      paramArrayOfString = (String[])localObject;
      arrayOfString1 = paramArrayOfString;
      arrayOfString2 = paramArrayOfString;
      boolean bool = ((Cursor)localObject).moveToFirst();
      if (bool)
      {
        arrayOfString1 = paramArrayOfString;
        arrayOfString2 = paramArrayOfString;
        paramLong = ((Cursor)localObject).getLong(0);
        ((Cursor)localObject).close();
        return paramLong;
      }
      ((Cursor)localObject).close();
      return 0L;
    }
    catch (Throwable paramString) {}catch (SQLiteException paramArrayOfString)
    {
      arrayOfString1 = arrayOfString2;
      a("Database error", paramString, paramArrayOfString);
      arrayOfString1 = arrayOfString2;
      throw paramArrayOfString;
    }
    if (arrayOfString1 != null) {
      arrayOfString1.close();
    }
    throw paramString;
  }
  
  private final Map zzdr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap(0);
    }
    try
    {
      boolean bool = paramString.startsWith("?");
      if (!bool)
      {
        int i = paramString.length();
        if (i != 0) {
          paramString = "?".concat(paramString);
        } else {
          paramString = new String("?");
        }
      }
      paramString = HttpResponse.parse(new URI(paramString), "UTF-8");
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      toString("Error parsing hit parameters", paramString);
    }
    return new HashMap(0);
  }
  
  private final Map zzds(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap(0);
    }
    try
    {
      paramString = String.valueOf(paramString);
      int i = paramString.length();
      if (i != 0) {
        paramString = "?".concat(paramString);
      } else {
        paramString = new String("?");
      }
      paramString = HttpResponse.parse(new URI(paramString), "UTF-8");
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      toString("Error parsing property parameters", paramString);
    }
    return new HashMap(0);
  }
  
  private final long zzwu()
  {
    TerminalManager.zzuj();
    zzwk();
    return count("SELECT COUNT(*) FROM hits2", null);
  }
  
  public static String zzxb()
  {
    return "google_analytics_v4.db";
  }
  
  public final void add(List paramList)
  {
    zzbp.append(paramList);
    TerminalManager.zzuj();
    zzwk();
    if (paramList.isEmpty()) {
      return;
    }
    Object localObject1 = new StringBuilder("hit_id");
    ((StringBuilder)localObject1).append(" in (");
    int i = 0;
    Object localObject2;
    while (i < paramList.size())
    {
      localObject2 = (Long)paramList.get(i);
      if ((localObject2 != null) && (((Long)localObject2).longValue() != 0L))
      {
        if (i > 0) {
          ((StringBuilder)localObject1).append(",");
        }
        ((StringBuilder)localObject1).append(localObject2);
        i += 1;
      }
      else
      {
        throw new SQLiteException("Invalid hit id");
      }
    }
    ((StringBuilder)localObject1).append(")");
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      localObject2 = getWritableDatabase();
      d("Deleting dispatched hits. count", Integer.valueOf(paramList.size()));
      i = ((SQLiteDatabase)localObject2).delete("hits2", (String)localObject1, null);
      int j = paramList.size();
      if (i != j)
      {
        warn("Deleted fewer hits then expected", Integer.valueOf(paramList.size()), Integer.valueOf(i), localObject1);
        return;
      }
    }
    catch (SQLiteException paramList)
    {
      toString("Error deleting hits", paramList);
      throw paramList;
    }
  }
  
  public final void beginTransaction()
  {
    zzwk();
    getWritableDatabase().beginTransaction();
  }
  
  public final void close()
  {
    zzane localZzane = zzdpl;
    try
    {
      localZzane.close();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      str = "Error closing database";
      toString(str, localIllegalStateException);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        String str = "Sql error closing database";
      }
    }
  }
  
  /* Error */
  public final List doInBackground(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 129	com/google/android/android/internal/zzams:zzwk	()V
    //   4: invokestatic 126	com/google/android/android/analytics/TerminalManager:zzuj	()V
    //   7: aload_0
    //   8: invokevirtual 89	com/google/android/android/internal/zzand:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 11
    //   13: aconst_null
    //   14: astore 10
    //   16: aconst_null
    //   17: astore 9
    //   19: aload 9
    //   21: astore 7
    //   23: getstatic 314	com/google/android/android/internal/zzaod:zzdrg	Lcom/google/android/android/internal/zzaoe;
    //   26: astore 12
    //   28: aload 9
    //   30: astore 7
    //   32: aload 10
    //   34: astore 8
    //   36: aload 12
    //   38: invokevirtual 320	com/google/android/android/internal/zzaoe:setDoOutput	()Ljava/lang/Object;
    //   41: astore 12
    //   43: aload 9
    //   45: astore 7
    //   47: aload 12
    //   49: checkcast 277	java/lang/Integer
    //   52: astore 12
    //   54: aload 9
    //   56: astore 7
    //   58: aload 10
    //   60: astore 8
    //   62: aload 12
    //   64: invokevirtual 323	java/lang/Integer:intValue	()I
    //   67: istore_3
    //   68: aload 9
    //   70: astore 7
    //   72: aload 10
    //   74: astore 8
    //   76: aload 11
    //   78: ldc_w 325
    //   81: iconst_5
    //   82: anewarray 34	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: ldc_w 327
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: ldc_w 329
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: ldc_w 331
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: ldc_w 333
    //   108: aastore
    //   109: dup
    //   110: iconst_4
    //   111: ldc_w 335
    //   114: aastore
    //   115: ldc_w 337
    //   118: iconst_1
    //   119: anewarray 34	java/lang/String
    //   122: dup
    //   123: iconst_0
    //   124: ldc_w 339
    //   127: aastore
    //   128: aconst_null
    //   129: aconst_null
    //   130: aconst_null
    //   131: iload_3
    //   132: invokestatic 342	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   135: invokevirtual 151	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   138: astore 10
    //   140: aload 10
    //   142: astore 9
    //   144: aload 9
    //   146: astore 7
    //   148: aload 9
    //   150: astore 8
    //   152: new 137	java/util/ArrayList
    //   155: dup
    //   156: invokespecial 139	java/util/ArrayList:<init>	()V
    //   159: astore 11
    //   161: aload 9
    //   163: astore 7
    //   165: aload 9
    //   167: astore 8
    //   169: aload 10
    //   171: invokeinterface 101 1 0
    //   176: istore 5
    //   178: iload 5
    //   180: ifeq +235 -> 415
    //   183: aload 9
    //   185: astore 7
    //   187: aload 9
    //   189: astore 8
    //   191: aload 10
    //   193: iconst_0
    //   194: invokeinterface 345 2 0
    //   199: astore 12
    //   201: aload 9
    //   203: astore 7
    //   205: aload 9
    //   207: astore 8
    //   209: aload 10
    //   211: iconst_1
    //   212: invokeinterface 345 2 0
    //   217: astore 13
    //   219: aload 9
    //   221: astore 7
    //   223: aload 9
    //   225: astore 8
    //   227: aload 10
    //   229: iconst_2
    //   230: invokeinterface 349 2 0
    //   235: istore 4
    //   237: iload 4
    //   239: ifeq +9 -> 248
    //   242: iconst_1
    //   243: istore 5
    //   245: goto +6 -> 251
    //   248: iconst_0
    //   249: istore 5
    //   251: aload 9
    //   253: astore 7
    //   255: aload 9
    //   257: astore 8
    //   259: aload 10
    //   261: iconst_3
    //   262: invokeinterface 349 2 0
    //   267: istore 4
    //   269: iload 4
    //   271: i2l
    //   272: lstore_1
    //   273: aload 9
    //   275: astore 7
    //   277: aload 9
    //   279: astore 8
    //   281: aload_0
    //   282: aload 10
    //   284: iconst_4
    //   285: invokeinterface 345 2 0
    //   290: invokespecial 351	com/google/android/android/internal/zzand:zzds	(Ljava/lang/String;)Ljava/util/Map;
    //   293: astore 14
    //   295: aload 9
    //   297: astore 7
    //   299: aload 9
    //   301: astore 8
    //   303: aload 12
    //   305: invokestatic 186	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   308: istore 6
    //   310: iload 6
    //   312: ifne +62 -> 374
    //   315: aload 9
    //   317: astore 7
    //   319: aload 9
    //   321: astore 8
    //   323: aload 13
    //   325: invokestatic 186	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   328: istore 6
    //   330: iload 6
    //   332: ifeq +6 -> 338
    //   335: goto +39 -> 374
    //   338: aload 9
    //   340: astore 7
    //   342: aload 9
    //   344: astore 8
    //   346: aload 11
    //   348: new 353	com/google/android/android/internal/zzamx
    //   351: dup
    //   352: lconst_0
    //   353: aload 12
    //   355: aload 13
    //   357: iload 5
    //   359: lload_1
    //   360: aload 14
    //   362: invokespecial 356	com/google/android/android/internal/zzamx:<init>	(JLjava/lang/String;Ljava/lang/String;ZJLjava/util/Map;)V
    //   365: invokeinterface 161 2 0
    //   370: pop
    //   371: goto +22 -> 393
    //   374: aload 9
    //   376: astore 7
    //   378: aload 9
    //   380: astore 8
    //   382: aload_0
    //   383: ldc_w 358
    //   386: aload 12
    //   388: aload 13
    //   390: invokevirtual 360	com/google/android/android/internal/zzamr:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   393: aload 9
    //   395: astore 7
    //   397: aload 9
    //   399: astore 8
    //   401: aload 10
    //   403: invokeinterface 164 1 0
    //   408: istore 5
    //   410: iload 5
    //   412: ifne -229 -> 183
    //   415: aload 9
    //   417: astore 7
    //   419: aload 9
    //   421: astore 8
    //   423: aload 11
    //   425: invokeinterface 255 1 0
    //   430: istore 4
    //   432: iload 4
    //   434: iload_3
    //   435: if_icmplt +18 -> 453
    //   438: aload 9
    //   440: astore 7
    //   442: aload 9
    //   444: astore 8
    //   446: aload_0
    //   447: ldc_w 362
    //   450: invokevirtual 365	com/google/android/android/internal/zzamr:zzdp	(Ljava/lang/String;)V
    //   453: aload 10
    //   455: invokeinterface 108 1 0
    //   460: aload 11
    //   462: areturn
    //   463: astore 8
    //   465: goto +25 -> 490
    //   468: astore 9
    //   470: aload 8
    //   472: astore 7
    //   474: aload_0
    //   475: ldc_w 367
    //   478: aload 9
    //   480: invokevirtual 221	com/google/android/android/internal/zzamr:toString	(Ljava/lang/String;Ljava/lang/Object;)V
    //   483: aload 8
    //   485: astore 7
    //   487: aload 9
    //   489: athrow
    //   490: aload 7
    //   492: ifnull +10 -> 502
    //   495: aload 7
    //   497: invokeinterface 108 1 0
    //   502: goto +3 -> 505
    //   505: aload 8
    //   507: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	zzand
    //   0	508	1	paramLong	long
    //   67	369	3	i	int
    //   235	201	4	j	int
    //   176	235	5	bool1	boolean
    //   308	23	6	bool2	boolean
    //   21	475	7	localObject1	Object
    //   34	411	8	localCursor1	Cursor
    //   463	43	8	localThrowable	Throwable
    //   17	426	9	localCursor2	Cursor
    //   468	20	9	localSQLiteException	SQLiteException
    //   14	440	10	localCursor3	Cursor
    //   11	450	11	localObject2	Object
    //   26	361	12	localObject3	Object
    //   217	172	13	str	String
    //   293	68	14	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   23	28	463	java/lang/Throwable
    //   36	43	463	java/lang/Throwable
    //   47	54	463	java/lang/Throwable
    //   62	68	463	java/lang/Throwable
    //   76	140	463	java/lang/Throwable
    //   152	161	463	java/lang/Throwable
    //   169	178	463	java/lang/Throwable
    //   191	201	463	java/lang/Throwable
    //   209	219	463	java/lang/Throwable
    //   227	237	463	java/lang/Throwable
    //   259	269	463	java/lang/Throwable
    //   281	295	463	java/lang/Throwable
    //   303	310	463	java/lang/Throwable
    //   323	330	463	java/lang/Throwable
    //   346	371	463	java/lang/Throwable
    //   382	393	463	java/lang/Throwable
    //   401	410	463	java/lang/Throwable
    //   423	432	463	java/lang/Throwable
    //   446	453	463	java/lang/Throwable
    //   474	483	463	java/lang/Throwable
    //   487	490	463	java/lang/Throwable
    //   36	43	468	android/database/sqlite/SQLiteException
    //   62	68	468	android/database/sqlite/SQLiteException
    //   76	140	468	android/database/sqlite/SQLiteException
    //   152	161	468	android/database/sqlite/SQLiteException
    //   169	178	468	android/database/sqlite/SQLiteException
    //   191	201	468	android/database/sqlite/SQLiteException
    //   209	219	468	android/database/sqlite/SQLiteException
    //   227	237	468	android/database/sqlite/SQLiteException
    //   259	269	468	android/database/sqlite/SQLiteException
    //   281	295	468	android/database/sqlite/SQLiteException
    //   303	310	468	android/database/sqlite/SQLiteException
    //   323	330	468	android/database/sqlite/SQLiteException
    //   346	371	468	android/database/sqlite/SQLiteException
    //   382	393	468	android/database/sqlite/SQLiteException
    //   401	410	468	android/database/sqlite/SQLiteException
    //   423	432	468	android/database/sqlite/SQLiteException
    //   446	453	468	android/database/sqlite/SQLiteException
  }
  
  public final void endTransaction()
  {
    zzwk();
    getWritableDatabase().endTransaction();
  }
  
  public final void export(zzaoi paramZzaoi)
  {
    zzbp.append(paramZzaoi);
    TerminalManager.zzuj();
    zzwk();
    zzbp.append(paramZzaoi);
    Object localObject1 = new Uri.Builder();
    Object localObject2 = paramZzaoi.zziy().entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      String str = (String)((Map.Entry)localObject3).getKey();
      if ((!"ht".equals(str)) && (!"qt".equals(str)) && (!"AppUID".equals(str))) {
        ((Uri.Builder)localObject1).appendQueryParameter(str, (String)((Map.Entry)localObject3).getValue());
      }
    }
    localObject2 = ((Uri.Builder)localObject1).build().getEncodedQuery();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (((String)localObject1).length() > 8192)
    {
      zzvy().append(paramZzaoi, "Hit length exceeds the maximum allowed size");
      return;
    }
    int i = ((Integer)zzaod.zzdre.setDoOutput()).intValue();
    long l = zzwu();
    if (l > i - 1)
    {
      localObject2 = getAll(l - i + 1L);
      append("Store full, deleting hits to make room, count", Integer.valueOf(((List)localObject2).size()));
      add((List)localObject2);
    }
    localObject2 = getWritableDatabase();
    Object localObject3 = new ContentValues();
    ((ContentValues)localObject3).put("hit_string", (String)localObject1);
    ((ContentValues)localObject3).put("hit_time", Long.valueOf(paramZzaoi.zzyn()));
    ((ContentValues)localObject3).put("hit_app_id", Integer.valueOf(paramZzaoi.zzyl()));
    if (paramZzaoi.zzyp()) {
      localObject1 = zzanv.zzyb();
    } else {
      localObject1 = zzanv.zzyc();
    }
    ((ContentValues)localObject3).put("hit_url", (String)localObject1);
    try
    {
      l = ((SQLiteDatabase)localObject2).insert("hits2", null, (ContentValues)localObject3);
      if (l == -1L)
      {
        zzdq("Failed to insert a hit (got -1)");
        return;
      }
      write("Hit saved to database. db-id, hit", Long.valueOf(l), paramZzaoi);
      return;
    }
    catch (SQLiteException paramZzaoi)
    {
      toString("Error storing a hit", paramZzaoi);
    }
  }
  
  public final long getSize(long paramLong, String paramString1, String paramString2)
  {
    zzbp.zzgg(paramString1);
    zzbp.zzgg(paramString2);
    zzwk();
    TerminalManager.zzuj();
    return getCount("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[] { String.valueOf(paramLong), paramString1, paramString2 }, 0L);
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    Object localObject = zzdpl;
    try
    {
      localObject = ((zzane)localObject).getWritableDatabase();
      return localObject;
    }
    catch (SQLiteException localSQLiteException)
    {
      append("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  public final boolean isEmpty()
  {
    return zzwu() == 0L;
  }
  
  public final List reload(long paramLong)
  {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbh(bool);
    TerminalManager.zzuj();
    zzwk();
    Object localObject2 = getWritableDatabase();
    Cursor localCursor3 = null;
    Cursor localCursor2 = null;
    Object localObject1 = localCursor2;
    Cursor localCursor1 = localCursor3;
    try
    {
      String str = String.format("%s ASC", new Object[] { "hit_id" });
      localObject1 = localCursor2;
      localCursor1 = localCursor3;
      Object localObject3 = Long.toString(paramLong);
      localObject1 = localCursor2;
      localCursor1 = localCursor3;
      localCursor3 = ((SQLiteDatabase)localObject2).query("hits2", new String[] { "hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id" }, null, null, null, null, str, (String)localObject3);
      localCursor2 = localCursor3;
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      localObject2 = new ArrayList();
      localObject1 = localCursor2;
      localCursor1 = localCursor2;
      bool = localCursor3.moveToFirst();
      if (bool) {
        do
        {
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          paramLong = localCursor3.getLong(0);
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          long l = localCursor3.getLong(1);
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          localObject3 = localCursor3.getString(2);
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          str = localCursor3.getString(3);
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          int i = localCursor3.getInt(4);
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          localObject3 = zzdr((String)localObject3);
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          bool = zzapd.zzed(str);
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          ((List)localObject2).add(new zzaoi(this, (Map)localObject3, l, bool, paramLong, i));
          localObject1 = localCursor2;
          localCursor1 = localCursor2;
          bool = localCursor3.moveToNext();
        } while (bool);
      }
      localCursor3.close();
      return localObject2;
    }
    catch (Throwable localThrowable) {}catch (SQLiteException localSQLiteException)
    {
      localObject1 = localThrowable;
      toString("Error loading hits from the database", localSQLiteException);
      localObject1 = localThrowable;
      throw localSQLiteException;
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    throw localThrowable;
  }
  
  public final void setTransactionSuccessful()
  {
    zzwk();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  public final void subscribe(long paramLong)
  {
    TerminalManager.zzuj();
    zzwk();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Long.valueOf(paramLong));
    d("Deleting hit, id", Long.valueOf(paramLong));
    add(localArrayList);
  }
  
  public final void zzuk() {}
  
  public final int zzwz()
  {
    TerminalManager.zzuj();
    zzwk();
    if (!zzdpm.calculate(86400000L)) {
      return 0;
    }
    zzdpm.start();
    zzdm("Deleting stale hits (if any)");
    int i = getWritableDatabase().delete("hits2", "hit_time < ?", new String[] { Long.toString(zzvx().currentTimeMillis() - 2592000000L) });
    d("Deleted stale hits, count", Integer.valueOf(i));
    return i;
  }
  
  public final long zzxa()
  {
    TerminalManager.zzuj();
    zzwk();
    return getCount(zzdpk, null, 0L);
  }
}
