package com.google.android.android.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import support.android.v4.util.ArrayMap;

public final class zzcay
  extends zzcdu
{
  public static final Map<String, String> zzimr;
  public static final Map<String, String> zzims;
  public static final Map<String, String> zzimt;
  public static final Map<String, String> zzimu;
  public static final Map<String, String> zzimv;
  public final zzcbb zzimw;
  public final zzcfq zzimx = new zzcfq(zzvx());
  
  static
  {
    ArrayMap localArrayMap = new ArrayMap(1);
    zzimr = localArrayMap;
    localArrayMap.put("origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;");
    localArrayMap = new ArrayMap(18);
    zzims = localArrayMap;
    localArrayMap.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
    zzims.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
    zzims.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
    zzims.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
    zzims.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
    zzims.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
    zzims.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
    zzims.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
    zzims.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
    zzims.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
    zzims.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
    zzims.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
    zzims.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
    zzims.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
    zzims.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
    zzims.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    zzims.put("daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;");
    zzims.put("health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;");
    zzims.put("android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;");
    localArrayMap = new ArrayMap(1);
    zzimt = localArrayMap;
    localArrayMap.put("realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;");
    localArrayMap = new ArrayMap(1);
    zzimu = localArrayMap;
    localArrayMap.put("has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;");
    localArrayMap = new ArrayMap(1);
    zzimv = localArrayMap;
    localArrayMap.put("previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;");
  }
  
  public zzcay(zzccw paramZzccw)
  {
    super(paramZzccw);
    paramZzccw = zzcax.zzawi();
    zzimw = new zzcbb(this, getContext(), paramZzccw);
  }
  
  public static void addColumn(zzcbw paramZzcbw, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, Map paramMap)
    throws SQLiteException
  {
    if (paramZzcbw != null)
    {
      if (!tableExists(paramZzcbw, paramSQLiteDatabase, paramString1)) {
        paramSQLiteDatabase.execSQL(paramString2);
      }
      try
      {
        write(paramZzcbw, paramSQLiteDatabase, paramString1, paramString3, paramMap);
        return;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        paramZzcbw.zzayd().append("Failed to verify columns on table that was just created", paramString1);
        throw paramSQLiteDatabase;
      }
    }
    throw new IllegalArgumentException("Monitor must not be null");
  }
  
  private final long count(String paramString, String[] paramArrayOfString)
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
        long l = ((Cursor)localObject).getLong(0);
        ((Cursor)localObject).close();
        return l;
      }
      arrayOfString1 = paramArrayOfString;
      arrayOfString2 = paramArrayOfString;
      throw new SQLiteException("Database returned empty set");
    }
    catch (Throwable paramString) {}catch (SQLiteException paramArrayOfString)
    {
      arrayOfString1 = arrayOfString2;
      zzaul().zzayd().append("Database error", paramString, paramArrayOfString);
      arrayOfString1 = arrayOfString2;
      throw paramArrayOfString;
    }
    if (arrayOfString1 != null) {
      arrayOfString1.close();
    }
    throw paramString;
  }
  
  private final long count(String paramString, String[] paramArrayOfString, long paramLong)
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
      return paramLong;
    }
    catch (Throwable paramString) {}catch (SQLiteException paramArrayOfString)
    {
      arrayOfString1 = arrayOfString2;
      zzaul().zzayd().append("Database error", paramString, paramArrayOfString);
      arrayOfString1 = arrayOfString2;
      throw paramArrayOfString;
    }
    if (arrayOfString1 != null) {
      arrayOfString1.close();
    }
    throw paramString;
  }
  
  private final Object format(Cursor paramCursor, int paramInt)
  {
    int i = paramCursor.getType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              zzaul().zzayd().append("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
              return null;
            }
            zzaul().zzayd().append("Loaded invalid blob type value, ignoring it");
            return null;
          }
          return paramCursor.getString(paramInt);
        }
        return Double.valueOf(paramCursor.getDouble(paramInt));
      }
      return Long.valueOf(paramCursor.getLong(paramInt));
    }
    zzaul().zzayd().append("Loaded invalid null value from database");
    return null;
  }
  
  public static Set getValues(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    HashSet localHashSet = new HashSet();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 22), "SELECT * FROM ", paramString, " LIMIT 0"), null);
    try
    {
      Collections.addAll(localHashSet, paramSQLiteDatabase.getColumnNames());
      paramSQLiteDatabase.close();
      return localHashSet;
    }
    catch (Throwable paramString)
    {
      paramSQLiteDatabase.close();
      throw paramString;
    }
  }
  
  public static void put(ContentValues paramContentValues, String paramString, Object paramObject)
  {
    zzbp.zzgg(paramString);
    zzbp.append(paramObject);
    if ((paramObject instanceof String))
    {
      paramContentValues.put(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramContentValues.put(paramString, (Long)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramContentValues.put(paramString, (Double)paramObject);
      return;
    }
    throw new IllegalArgumentException("Invalid value type");
  }
  
  public static void saveBitmap(zzcbw paramZzcbw, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramZzcbw != null)
    {
      paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
      if (!paramSQLiteDatabase.setReadable(false, false)) {
        paramZzcbw.zzayf().append("Failed to turn off database read permission");
      }
      if (!paramSQLiteDatabase.setWritable(false, false)) {
        paramZzcbw.zzayf().append("Failed to turn off database write permission");
      }
      if (!paramSQLiteDatabase.setReadable(true, true)) {
        paramZzcbw.zzayf().append("Failed to turn on database read permission for owner");
      }
      if (!paramSQLiteDatabase.setWritable(true, true)) {
        paramZzcbw.zzayf().append("Failed to turn on database write permission for owner");
      }
    }
    else
    {
      throw new IllegalArgumentException("Monitor must not be null");
    }
  }
  
  private final boolean saveToFile(String paramString, int paramInt, zzcfy paramZzcfy)
  {
    zzwk();
    zzuj();
    zzbp.zzgg(paramString);
    zzbp.append(paramZzcfy);
    if (TextUtils.isEmpty(zzixo))
    {
      zzaul().zzayf().attribute("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzcbw.zzjf(paramString), Integer.valueOf(paramInt), String.valueOf(zzixn));
      return false;
    }
    try
    {
      int i = paramZzcfy.zzhi();
      byte[] arrayOfByte = new byte[i];
      i = arrayOfByte.length;
      Object localObject = zzeyf.toString(arrayOfByte, 0, i);
      paramZzcfy.multiply((zzeyf)localObject);
      ((zzeyf)localObject).zzctn();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramString);
      ((ContentValues)localObject).put("audience_id", Integer.valueOf(paramInt));
      ((ContentValues)localObject).put("filter_id", zzixn);
      ((ContentValues)localObject).put("event_name", zzixo);
      ((ContentValues)localObject).put("data", arrayOfByte);
      try
      {
        long l = getWritableDatabase().insertWithOnConflict("event_filters", null, (ContentValues)localObject, 5);
        if (l == -1L) {
          zzaul().zzayd().append("Failed to insert event filter (got -1). appId", zzcbw.zzjf(paramString));
        }
        return true;
      }
      catch (SQLiteException paramZzcfy)
      {
        zzaul().zzayd().append("Error storing event filter. appId", zzcbw.zzjf(paramString), paramZzcfy);
        return false;
      }
      return false;
    }
    catch (IOException paramZzcfy)
    {
      zzaul().zzayd().append("Configuration loss. Failed to serialize event filter. appId", zzcbw.zzjf(paramString), paramZzcfy);
    }
  }
  
  private final boolean saveToFile(String paramString, int paramInt, zzcgb paramZzcgb)
  {
    zzwk();
    zzuj();
    zzbp.zzgg(paramString);
    zzbp.append(paramZzcgb);
    if (TextUtils.isEmpty(zziyd))
    {
      zzaul().zzayf().attribute("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzcbw.zzjf(paramString), Integer.valueOf(paramInt), String.valueOf(zzixn));
      return false;
    }
    try
    {
      int i = paramZzcgb.zzhi();
      byte[] arrayOfByte = new byte[i];
      i = arrayOfByte.length;
      Object localObject = zzeyf.toString(arrayOfByte, 0, i);
      paramZzcgb.multiply((zzeyf)localObject);
      ((zzeyf)localObject).zzctn();
      localObject = new ContentValues();
      ((ContentValues)localObject).put("app_id", paramString);
      ((ContentValues)localObject).put("audience_id", Integer.valueOf(paramInt));
      ((ContentValues)localObject).put("filter_id", zzixn);
      ((ContentValues)localObject).put("property_name", zziyd);
      ((ContentValues)localObject).put("data", arrayOfByte);
      try
      {
        long l = getWritableDatabase().insertWithOnConflict("property_filters", null, (ContentValues)localObject, 5);
        if (l == -1L)
        {
          zzaul().zzayd().append("Failed to insert property filter (got -1). appId", zzcbw.zzjf(paramString));
          return false;
        }
        return true;
      }
      catch (SQLiteException paramZzcgb)
      {
        zzaul().zzayd().append("Error storing property filter. appId", zzcbw.zzjf(paramString), paramZzcgb);
        return false;
      }
      return false;
    }
    catch (IOException paramZzcgb)
    {
      zzaul().zzayd().append("Configuration loss. Failed to serialize property filter. appId", zzcbw.zzjf(paramString), paramZzcgb);
    }
  }
  
  public static boolean tableExists(zzcbw paramZzcbw, SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (paramZzcbw != null)
    {
      SQLiteDatabase localSQLiteDatabase2 = null;
      SQLiteDatabase localSQLiteDatabase1 = null;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.query("SQLITE_MASTER", new String[] { "name" }, "name=?", new String[] { paramString }, null, null, null);
        localSQLiteDatabase2 = paramSQLiteDatabase;
        localSQLiteDatabase1 = localSQLiteDatabase2;
        boolean bool = paramSQLiteDatabase.moveToFirst();
        paramSQLiteDatabase.close();
        return bool;
      }
      catch (Throwable paramZzcbw) {}catch (SQLiteException paramSQLiteDatabase)
      {
        localSQLiteDatabase1 = localSQLiteDatabase2;
        paramZzcbw.zzayf().append("Error querying for table", paramString, paramSQLiteDatabase);
        if (localSQLiteDatabase2 == null) {
          break label123;
        }
      }
      localSQLiteDatabase2.close();
      return false;
      if (localSQLiteDatabase1 != null) {
        localSQLiteDatabase1.close();
      }
      throw paramZzcbw;
    }
    throw new IllegalArgumentException("Monitor must not be null");
    label123:
    return false;
  }
  
  private final boolean trim(String paramString, List paramList)
  {
    zzbp.zzgg(paramString);
    zzwk();
    zzuj();
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    try
    {
      long l = count("select count(1) from audience_filter_values where app_id=?", new String[] { paramString });
      int j = Math.max(0, Math.min(2000, zzaun().next(paramString, zzcbm.zzipg)));
      if (l <= j) {
        return false;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        Integer localInteger = (Integer)paramList.get(i);
        if (localInteger != null)
        {
          localArrayList.add(Integer.toString(localInteger.intValue()));
          i += 1;
        }
        else
        {
          return false;
        }
      }
      paramList = TextUtils.join(",", localArrayList);
      paramList = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramList, 2), "(", paramList, ")");
      return localSQLiteDatabase.delete("audience_filter_values", f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramList, 140), "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", paramList, " order by rowid desc limit -1 offset ?)"), new String[] { paramString, Integer.toString(j) }) > 0;
    }
    catch (SQLiteException paramList)
    {
      zzaul().zzayd().append("Database error querying filters. appId", zzcbw.zzjf(paramString), paramList);
    }
    return false;
  }
  
  public static void write(zzcbw paramZzcbw, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, Map paramMap)
    throws SQLiteException
  {
    if (paramZzcbw != null)
    {
      Set localSet = getValues(paramSQLiteDatabase, paramString1);
      String[] arrayOfString = paramString2.split(",");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = arrayOfString[i];
        if (localSet.remove(paramString2))
        {
          i += 1;
        }
        else
        {
          paramZzcbw = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString2, f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString1, 35)));
          paramZzcbw.append("Table ");
          paramZzcbw.append(paramString1);
          paramZzcbw.append(" is missing required column: ");
          paramZzcbw.append(paramString2);
          throw new SQLiteException(paramZzcbw.toString());
        }
      }
      if (paramMap != null)
      {
        paramString2 = paramMap.entrySet().iterator();
        while (paramString2.hasNext())
        {
          paramMap = (Map.Entry)paramString2.next();
          if (!localSet.remove(paramMap.getKey())) {
            paramSQLiteDatabase.execSQL((String)paramMap.getValue());
          }
        }
      }
      if (!localSet.isEmpty()) {
        paramZzcbw.zzayf().append("Table has extra columns. table, columns", paramString1, TextUtils.join(", ", localSet));
      }
    }
    else
    {
      paramZzcbw = new IllegalArgumentException("Monitor must not be null");
      throw paramZzcbw;
    }
  }
  
  private final boolean zzaxq()
  {
    return getContext().getDatabasePath(zzcax.zzawi()).exists();
  }
  
  public final boolean add(zzcfv paramZzcfv)
  {
    zzbp.append(paramZzcfv);
    zzuj();
    zzwk();
    long l;
    if (zzah(mAppId, mName) == null) {
      if (zzcfw.zzju(mName))
      {
        l = count("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[] { mAppId });
        zzcax.zzavy();
        if (l >= 25L) {
          return false;
        }
      }
      else
      {
        l = count("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[] { mAppId, mOrigin });
        zzcax.zzawa();
        if (l >= 25L) {
          return false;
        }
      }
    }
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("app_id", mAppId);
    ((ContentValues)localObject).put("origin", mOrigin);
    ((ContentValues)localObject).put("name", mName);
    ((ContentValues)localObject).put("set_timestamp", Long.valueOf(zzixd));
    put((ContentValues)localObject, "value", mValue);
    try
    {
      l = getWritableDatabase().insertWithOnConflict("user_attributes", null, (ContentValues)localObject, 5);
      if (l == -1L)
      {
        localObject = zzaul().zzayd();
        String str = mAppId;
        ((zzcby)localObject).append("Failed to insert/update user property (got -1). appId", zzcbw.zzjf(str));
        return true;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      zzaul().zzayd().append("Error storing user property. appId", zzcbw.zzjf(mAppId), localSQLiteException);
    }
    return true;
  }
  
  public final void beginTransaction()
  {
    zzwk();
    getWritableDatabase().beginTransaction();
  }
  
  public final List create(String paramString1, String paramString2, String paramString3)
  {
    zzbp.zzgg(paramString1);
    zzuj();
    zzwk();
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(paramString1);
    paramString1 = new StringBuilder("app_id=?");
    if (!TextUtils.isEmpty(paramString2))
    {
      localArrayList.add(paramString2);
      paramString1.append(" and origin=?");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localArrayList.add(String.valueOf(paramString3).concat("*"));
      paramString1.append(" and name glob ?");
    }
    paramString2 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return load(paramString1.toString(), paramString2);
  }
  
  /* Error */
  public final List doInBackground(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   9: aload_0
    //   10: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   13: new 513	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 514	java/util/ArrayList:<init>	()V
    //   20: astore 12
    //   22: aconst_null
    //   23: astore 9
    //   25: new 513	java/util/ArrayList
    //   28: dup
    //   29: iconst_3
    //   30: invokespecial 683	java/util/ArrayList:<init>	(I)V
    //   33: astore 11
    //   35: aload 11
    //   37: aload_1
    //   38: invokeinterface 532 2 0
    //   43: pop
    //   44: new 567	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 685
    //   51: invokespecial 686	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: astore 10
    //   56: aload_2
    //   57: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: istore 5
    //   62: iload 5
    //   64: ifne +24 -> 88
    //   67: aload 11
    //   69: aload_2
    //   70: invokeinterface 532 2 0
    //   75: pop
    //   76: aload 10
    //   78: ldc_w 688
    //   81: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: goto +3 -> 88
    //   88: aload_2
    //   89: astore 8
    //   91: aload_3
    //   92: invokestatic 383	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: istore 5
    //   97: iload 5
    //   99: ifne +30 -> 129
    //   102: aload 11
    //   104: aload_3
    //   105: invokestatic 396	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   108: ldc_w 690
    //   111: invokevirtual 693	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   114: invokeinterface 532 2 0
    //   119: pop
    //   120: aload 10
    //   122: ldc_w 695
    //   125: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 11
    //   131: invokeinterface 519 1 0
    //   136: istore 4
    //   138: iload 4
    //   140: anewarray 322	java/lang/String
    //   143: astore 13
    //   145: aload 11
    //   147: aload 13
    //   149: invokeinterface 699 2 0
    //   154: astore 11
    //   156: aload 11
    //   158: checkcast 701	[Ljava/lang/String;
    //   161: astore 11
    //   163: aload_0
    //   164: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   167: astore 13
    //   169: aload 10
    //   171: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 10
    //   176: invokestatic 709	com/google/android/android/internal/zzcax:zzavz	()I
    //   179: pop
    //   180: aload 13
    //   182: ldc_w 673
    //   185: iconst_4
    //   186: anewarray 322	java/lang/String
    //   189: dup
    //   190: iconst_0
    //   191: ldc_w 474
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: ldc_w 659
    //   200: aastore
    //   201: dup
    //   202: iconst_2
    //   203: ldc_w 665
    //   206: aastore
    //   207: dup
    //   208: iconst_3
    //   209: ldc 27
    //   211: aastore
    //   212: aload 10
    //   214: aload 11
    //   216: aconst_null
    //   217: aconst_null
    //   218: ldc_w 711
    //   221: ldc_w 713
    //   224: invokevirtual 716	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   227: astore 11
    //   229: aload 11
    //   231: astore_2
    //   232: aload 8
    //   234: astore 10
    //   236: aload 11
    //   238: invokeinterface 222 1 0
    //   243: istore 5
    //   245: iload 5
    //   247: ifne +13 -> 260
    //   250: aload 11
    //   252: invokeinterface 229 1 0
    //   257: aload 12
    //   259: areturn
    //   260: aload 8
    //   262: astore 9
    //   264: aload 9
    //   266: astore 10
    //   268: aload 12
    //   270: invokeinterface 519 1 0
    //   275: istore 4
    //   277: aload 9
    //   279: astore 10
    //   281: invokestatic 709	com/google/android/android/internal/zzcax:zzavz	()I
    //   284: pop
    //   285: iload 4
    //   287: sipush 1000
    //   290: if_icmplt +43 -> 333
    //   293: aload 9
    //   295: astore 10
    //   297: aload_0
    //   298: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   301: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   304: astore_3
    //   305: aload 9
    //   307: astore 10
    //   309: invokestatic 709	com/google/android/android/internal/zzcax:zzavz	()I
    //   312: pop
    //   313: aload 9
    //   315: astore 10
    //   317: aload_3
    //   318: ldc_w 718
    //   321: sipush 1000
    //   324: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   327: invokevirtual 197	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   330: goto +131 -> 461
    //   333: aload 9
    //   335: astore 10
    //   337: aload 11
    //   339: iconst_0
    //   340: invokeinterface 264 2 0
    //   345: astore 13
    //   347: aload 9
    //   349: astore 10
    //   351: aload 11
    //   353: iconst_1
    //   354: invokeinterface 226 2 0
    //   359: lstore 6
    //   361: aload_2
    //   362: astore 8
    //   364: aload_0
    //   365: aload 11
    //   367: iconst_2
    //   368: invokespecial 720	com/google/android/android/internal/zzcay:format	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   371: astore 14
    //   373: aload_2
    //   374: astore 8
    //   376: aload 11
    //   378: iconst_3
    //   379: invokeinterface 264 2 0
    //   384: astore 10
    //   386: aload 14
    //   388: ifnonnull +29 -> 417
    //   391: aload_2
    //   392: astore 8
    //   394: aload_0
    //   395: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   398: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   401: ldc_w 722
    //   404: aload_1
    //   405: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   408: aload 10
    //   410: aload_3
    //   411: invokevirtual 400	com/google/android/android/internal/zzcby:attribute	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   414: goto +30 -> 444
    //   417: aload_2
    //   418: astore 8
    //   420: aload 12
    //   422: new 626	com/google/android/android/internal/zzcfv
    //   425: dup
    //   426: aload_1
    //   427: aload 10
    //   429: aload 13
    //   431: lload 6
    //   433: aload 14
    //   435: invokespecial 725	com/google/android/android/internal/zzcfv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   438: invokeinterface 532 2 0
    //   443: pop
    //   444: aload_2
    //   445: astore 8
    //   447: aload 11
    //   449: invokeinterface 728 1 0
    //   454: istore 5
    //   456: iload 5
    //   458: ifne +13 -> 471
    //   461: aload 11
    //   463: invokeinterface 229 1 0
    //   468: aload 12
    //   470: areturn
    //   471: aload 10
    //   473: astore 8
    //   475: goto -215 -> 260
    //   478: astore_3
    //   479: aload_2
    //   480: astore 11
    //   482: aload 10
    //   484: astore_2
    //   485: goto +46 -> 531
    //   488: astore_3
    //   489: aload_2
    //   490: astore 11
    //   492: aload 9
    //   494: astore_2
    //   495: goto +36 -> 531
    //   498: astore_1
    //   499: goto +73 -> 572
    //   502: astore_3
    //   503: aload_2
    //   504: astore 11
    //   506: aload 10
    //   508: astore_2
    //   509: goto +22 -> 531
    //   512: astore_3
    //   513: goto +15 -> 528
    //   516: astore_3
    //   517: goto +11 -> 528
    //   520: astore_1
    //   521: aload 9
    //   523: astore_2
    //   524: goto +48 -> 572
    //   527: astore_3
    //   528: aconst_null
    //   529: astore 11
    //   531: aload 11
    //   533: astore 8
    //   535: aload_0
    //   536: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   539: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   542: ldc_w 730
    //   545: aload_1
    //   546: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   549: aload_2
    //   550: aload_3
    //   551: invokevirtual 400	com/google/android/android/internal/zzcby:attribute	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   554: aload 11
    //   556: ifnull +31 -> 587
    //   559: aload 11
    //   561: invokeinterface 229 1 0
    //   566: aconst_null
    //   567: areturn
    //   568: astore_1
    //   569: aload 8
    //   571: astore_2
    //   572: aload_2
    //   573: ifnull +9 -> 582
    //   576: aload_2
    //   577: invokeinterface 229 1 0
    //   582: goto +3 -> 585
    //   585: aload_1
    //   586: athrow
    //   587: aconst_null
    //   588: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	zzcay
    //   0	589	1	paramString1	String
    //   0	589	2	paramString2	String
    //   0	589	3	paramString3	String
    //   136	155	4	i	int
    //   60	397	5	bool	boolean
    //   359	73	6	l	long
    //   89	481	8	localObject1	Object
    //   23	499	9	localObject2	Object
    //   54	453	10	localObject3	Object
    //   33	527	11	localObject4	Object
    //   20	449	12	localArrayList	ArrayList
    //   143	287	13	localObject5	Object
    //   371	63	14	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   394	414	478	android/database/sqlite/SQLiteException
    //   420	444	478	android/database/sqlite/SQLiteException
    //   447	456	478	android/database/sqlite/SQLiteException
    //   364	373	488	android/database/sqlite/SQLiteException
    //   376	386	488	android/database/sqlite/SQLiteException
    //   236	245	498	java/lang/Throwable
    //   268	277	498	java/lang/Throwable
    //   281	285	498	java/lang/Throwable
    //   297	305	498	java/lang/Throwable
    //   309	313	498	java/lang/Throwable
    //   317	330	498	java/lang/Throwable
    //   337	347	498	java/lang/Throwable
    //   351	361	498	java/lang/Throwable
    //   236	245	502	android/database/sqlite/SQLiteException
    //   268	277	502	android/database/sqlite/SQLiteException
    //   281	285	502	android/database/sqlite/SQLiteException
    //   297	305	502	android/database/sqlite/SQLiteException
    //   309	313	502	android/database/sqlite/SQLiteException
    //   317	330	502	android/database/sqlite/SQLiteException
    //   337	347	502	android/database/sqlite/SQLiteException
    //   351	361	502	android/database/sqlite/SQLiteException
    //   67	85	512	android/database/sqlite/SQLiteException
    //   91	97	512	android/database/sqlite/SQLiteException
    //   102	129	512	android/database/sqlite/SQLiteException
    //   129	138	512	android/database/sqlite/SQLiteException
    //   145	156	512	android/database/sqlite/SQLiteException
    //   163	169	512	android/database/sqlite/SQLiteException
    //   169	229	512	android/database/sqlite/SQLiteException
    //   35	44	516	android/database/sqlite/SQLiteException
    //   44	62	516	android/database/sqlite/SQLiteException
    //   25	35	520	java/lang/Throwable
    //   35	44	520	java/lang/Throwable
    //   44	62	520	java/lang/Throwable
    //   67	85	520	java/lang/Throwable
    //   91	97	520	java/lang/Throwable
    //   102	129	520	java/lang/Throwable
    //   129	138	520	java/lang/Throwable
    //   138	145	520	java/lang/Throwable
    //   145	156	520	java/lang/Throwable
    //   156	163	520	java/lang/Throwable
    //   163	169	520	java/lang/Throwable
    //   169	229	520	java/lang/Throwable
    //   25	35	527	android/database/sqlite/SQLiteException
    //   364	373	568	java/lang/Throwable
    //   376	386	568	java/lang/Throwable
    //   394	414	568	java/lang/Throwable
    //   420	444	568	java/lang/Throwable
    //   447	456	568	java/lang/Throwable
    //   535	554	568	java/lang/Throwable
  }
  
  public final void endTransaction()
  {
    zzwk();
    getWritableDatabase().endTransaction();
  }
  
  public final zzcaz findAll(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    zzbp.zzgg(paramString);
    zzuj();
    zzwk();
    zzcaz localZzcaz = new zzcaz();
    Cursor localCursor3 = null;
    Cursor localCursor2 = null;
    Object localObject = localCursor2;
    Cursor localCursor1 = localCursor3;
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localObject = localCursor2;
      localCursor1 = localCursor3;
      localCursor3 = localSQLiteDatabase.query("apps", new String[] { "day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count" }, "app_id=?", new String[] { paramString }, null, null, null);
      localCursor2 = localCursor3;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      boolean bool = localCursor3.moveToFirst();
      if (!bool)
      {
        localObject = localCursor2;
        localCursor1 = localCursor2;
        zzaul().zzayf().append("Not updating daily counts, app is not known. appId", zzcbw.zzjf(paramString));
        localCursor3.close();
        return localZzcaz;
      }
      localObject = localCursor2;
      localCursor1 = localCursor2;
      long l = localCursor3.getLong(0);
      if (l == paramLong)
      {
        localObject = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(1);
        localObject = localCursor2;
        zzimz = l;
        localObject = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(2);
        localObject = localCursor2;
        zzimy = l;
        localObject = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(3);
        localObject = localCursor2;
        zzina = l;
        localObject = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(4);
        localObject = localCursor2;
        zzinb = l;
        localObject = localCursor2;
        localCursor1 = localCursor2;
        l = localCursor3.getLong(5);
        localObject = localCursor2;
        zzinc = l;
      }
      if (paramBoolean1)
      {
        localObject = localCursor2;
        l = zzimz;
        localObject = localCursor2;
        zzimz = (l + 1L);
      }
      if (paramBoolean2)
      {
        localObject = localCursor2;
        l = zzimy;
        localObject = localCursor2;
        zzimy = (l + 1L);
      }
      if (paramBoolean3)
      {
        localObject = localCursor2;
        l = zzina;
        localObject = localCursor2;
        zzina = (l + 1L);
      }
      if (paramBoolean4)
      {
        localObject = localCursor2;
        l = zzinb;
        localObject = localCursor2;
        zzinb = (l + 1L);
      }
      if (paramBoolean5)
      {
        localObject = localCursor2;
        l = zzinc;
        localObject = localCursor2;
        zzinc = (l + 1L);
      }
      localObject = localCursor2;
      localCursor1 = localCursor2;
      ContentValues localContentValues = new ContentValues();
      localObject = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("day", Long.valueOf(paramLong));
      localObject = localCursor2;
      paramLong = zzimy;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_public_events_count", Long.valueOf(paramLong));
      localObject = localCursor2;
      paramLong = zzimz;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_events_count", Long.valueOf(paramLong));
      localObject = localCursor2;
      paramLong = zzina;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_conversions_count", Long.valueOf(paramLong));
      localObject = localCursor2;
      paramLong = zzinb;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_error_events_count", Long.valueOf(paramLong));
      paramLong = zzinc;
      localObject = localCursor2;
      localCursor1 = localCursor2;
      localContentValues.put("daily_realtime_events_count", Long.valueOf(paramLong));
      localObject = localCursor2;
      localCursor1 = localCursor2;
      localSQLiteDatabase.update("apps", localContentValues, "app_id=?", new String[] { paramString });
      localCursor3.close();
      return localZzcaz;
    }
    catch (Throwable paramString) {}catch (SQLiteException localSQLiteException)
    {
      localObject = localCursor1;
      zzaul().zzayd().append("Error updating daily counts. appId", zzcbw.zzjf(paramString), localSQLiteException);
      if (localCursor1 == null) {
        break label760;
      }
    }
    localCursor1.close();
    return localZzcaz;
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    throw paramString;
    label760:
    return localZzcaz;
  }
  
  public final List getAll(String paramString, int paramInt1, int paramInt2)
  {
    zzuj();
    zzwk();
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbh(bool);
    if (paramInt2 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbh(bool);
    zzbp.zzgg(paramString);
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      Object localObject5 = getWritableDatabase();
      localObject1 = localObject3;
      localObject2 = localObject4;
      Cursor localCursor = ((SQLiteDatabase)localObject5).query("queue", new String[] { "rowid", "data" }, "app_id=?", new String[] { paramString }, null, null, "rowid", String.valueOf(paramInt1));
      localObject3 = localCursor;
      localObject1 = localObject3;
      localObject2 = localObject3;
      bool = localCursor.moveToFirst();
      if (!bool)
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject3 = Collections.emptyList();
        localCursor.close();
        return localObject3;
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      ArrayList localArrayList = new ArrayList();
      paramInt1 = 0;
      int i;
      do
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        long l = localCursor.getLong(0);
        localObject1 = localObject3;
        localObject2 = localObject3;
        try
        {
          localObject4 = localCursor.getBlob(1);
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject4 = zzauh().decompress((byte[])localObject4);
          localObject1 = localObject3;
          localObject2 = localObject3;
          bool = localArrayList.isEmpty();
          if (!bool)
          {
            localObject1 = localObject3;
            i = localObject4.length;
            if (i + paramInt1 > paramInt2) {
              break;
            }
          }
          localObject1 = localObject3;
          i = localObject4.length;
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject5 = zzeye.getBlob((byte[])localObject4, 0, i);
          localObject1 = localObject3;
          localObject2 = localObject3;
          localObject6 = new zzcgk();
          localObject1 = localObject3;
          localObject2 = localObject3;
          try
          {
            ((zzcgk)localObject6).digest((zzeye)localObject5);
            localObject1 = localObject3;
            i = localObject4.length;
            i = paramInt1 + i;
            localObject1 = localObject3;
            localObject2 = localObject3;
            localArrayList.add(Pair.create(localObject6, Long.valueOf(l)));
          }
          catch (IOException localIOException1)
          {
            localObject1 = localObject3;
            localObject2 = localObject3;
            localObject6 = zzaul().zzayd();
            localObject4 = "Failed to merge queued bundle. appId";
            localObject1 = localObject3;
            localObject2 = localObject3;
            localObject7 = zzcbw.zzjf(paramString);
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            localObject1 = localObject3;
            localObject2 = localObject3;
            Object localObject6 = zzaul().zzayd();
            localObject4 = "Failed to unzip queued bundle. appId";
            localObject1 = localObject3;
            localObject2 = localObject3;
            Object localObject7 = zzcbw.zzjf(paramString);
          }
        }
        localObject1 = localObject3;
        localObject2 = localObject3;
        ((zzcby)localObject6).append((String)localObject4, localObject7, localIOException1);
        i = paramInt1;
        localObject1 = localObject3;
        localObject2 = localObject3;
        bool = localCursor.moveToNext();
        if (!bool) {
          break;
        }
        paramInt1 = i;
      } while (i <= paramInt2);
      localCursor.close();
      return localArrayList;
    }
    catch (Throwable paramString) {}catch (SQLiteException localSQLiteException)
    {
      localObject1 = localObject2;
      zzaul().zzayd().append("Error querying bundles. appId", zzcbw.zzjf(paramString), localSQLiteException);
      localObject1 = localObject2;
      paramString = Collections.emptyList();
      if (localObject2 == null) {
        return paramString;
      }
    }
    localObject2.close();
    return paramString;
    if (localObject1 != null) {
      localObject1.close();
    }
    throw paramString;
    return paramString;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    zzuj();
    Object localObject = zzimw;
    try
    {
      localObject = ((zzcbb)localObject).getWritableDatabase();
      return localObject;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzaul().zzayf().append("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  /* Error */
  public final long insertMessage(zzcgk paramZzcgk)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   4: aload_0
    //   5: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   8: aload_1
    //   9: invokestatic 320	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   12: pop
    //   13: aload_1
    //   14: getfield 821	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   17: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   20: pop
    //   21: aload_1
    //   22: invokevirtual 406	com/google/android/android/internal/zzeyn:zzhi	()I
    //   25: istore_2
    //   26: iload_2
    //   27: newarray byte
    //   29: astore 5
    //   31: aload 5
    //   33: arraylength
    //   34: istore_2
    //   35: aload 5
    //   37: iconst_0
    //   38: iload_2
    //   39: invokestatic 412	com/google/android/android/internal/zzeyf:toString	([BII)Lcom/google/android/android/internal/zzeyf;
    //   42: astore 6
    //   44: aload_1
    //   45: aload 6
    //   47: invokevirtual 822	com/google/android/android/internal/zzcgk:multiply	(Lcom/google/android/android/internal/zzeyf;)V
    //   50: aload 6
    //   52: invokevirtual 419	com/google/android/android/internal/zzeyf:zzctn	()V
    //   55: aload_0
    //   56: invokevirtual 785	com/google/android/android/internal/zzcdt:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   59: astore 6
    //   61: aload 5
    //   63: invokestatic 320	com/google/android/android/common/internal/zzbp:append	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload 6
    //   69: invokevirtual 823	com/google/android/android/internal/zzcfw:zzuj	()V
    //   72: ldc_w 825
    //   75: invokestatic 829	com/google/android/android/internal/zzcfw:zzec	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   78: astore 7
    //   80: aload 7
    //   82: ifnonnull +22 -> 104
    //   85: aload 6
    //   87: invokevirtual 830	com/google/android/android/internal/zzcfw:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   90: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   93: ldc_w 832
    //   96: invokevirtual 260	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   99: lconst_0
    //   100: lstore_3
    //   101: goto +14 -> 115
    //   104: aload 7
    //   106: aload 5
    //   108: invokevirtual 836	java/security/MessageDigest:digest	([B)[B
    //   111: invokestatic 839	com/google/android/android/internal/zzcfw:update	([B)J
    //   114: lstore_3
    //   115: new 324	android/content/ContentValues
    //   118: dup
    //   119: invokespecial 420	android/content/ContentValues:<init>	()V
    //   122: astore 6
    //   124: aload 6
    //   126: ldc_w 422
    //   129: aload_1
    //   130: getfield 821	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   133: invokevirtual 327	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 6
    //   138: ldc_w 841
    //   141: lload_3
    //   142: invokestatic 278	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   145: invokevirtual 330	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   148: aload 6
    //   150: ldc_w 843
    //   153: aload 5
    //   155: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   158: aload_0
    //   159: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   162: ldc_w 845
    //   165: aconst_null
    //   166: aload 6
    //   168: iconst_4
    //   169: invokevirtual 442	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   172: pop2
    //   173: lload_3
    //   174: lreturn
    //   175: astore 5
    //   177: aload_0
    //   178: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   181: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   184: ldc_w 847
    //   187: aload_1
    //   188: getfield 821	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   191: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   194: aload 5
    //   196: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   199: aload 5
    //   201: athrow
    //   202: astore 5
    //   204: aload_0
    //   205: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   208: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   211: ldc_w 849
    //   214: aload_1
    //   215: getfield 821	com/google/android/android/internal/zzcgk:zzci	Ljava/lang/String;
    //   218: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   221: aload 5
    //   223: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   226: aload 5
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	zzcay
    //   0	229	1	paramZzcgk	zzcgk
    //   25	14	2	i	int
    //   100	74	3	l	long
    //   29	125	5	arrayOfByte	byte[]
    //   175	25	5	localSQLiteException	SQLiteException
    //   202	25	5	localIOException	IOException
    //   42	125	6	localObject	Object
    //   78	27	7	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   158	173	175	android/database/sqlite/SQLiteException
    //   21	26	202	java/io/IOException
    //   35	55	202	java/io/IOException
  }
  
  public final void insertMessage(zzcar paramZzcar)
  {
    zzbp.append(paramZzcar);
    zzuj();
    zzwk();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_id", paramZzcar.getAppId());
    localContentValues.put("app_instance_id", paramZzcar.getAppInstanceId());
    localContentValues.put("gmp_app_id", paramZzcar.getGmpAppId());
    localContentValues.put("resettable_device_id_hash", paramZzcar.zzaup());
    localContentValues.put("last_bundle_index", Long.valueOf(paramZzcar.zzauy()));
    localContentValues.put("last_bundle_start_timestamp", Long.valueOf(paramZzcar.zzaur()));
    localContentValues.put("last_bundle_end_timestamp", Long.valueOf(paramZzcar.zzaus()));
    localContentValues.put("app_version", paramZzcar.zzuo());
    localContentValues.put("app_store", paramZzcar.zzauu());
    localContentValues.put("gmp_version", Long.valueOf(paramZzcar.zzauv()));
    localContentValues.put("dev_cert_hash", Long.valueOf(paramZzcar.zzauw()));
    localContentValues.put("measurement_enabled", Boolean.valueOf(paramZzcar.zzaux()));
    localContentValues.put("day", Long.valueOf(paramZzcar.zzavc()));
    localContentValues.put("daily_public_events_count", Long.valueOf(paramZzcar.zzavd()));
    localContentValues.put("daily_events_count", Long.valueOf(paramZzcar.zzave()));
    localContentValues.put("daily_conversions_count", Long.valueOf(paramZzcar.zzavf()));
    localContentValues.put("config_fetched_time", Long.valueOf(paramZzcar.zzauz()));
    localContentValues.put("failed_config_fetch_time", Long.valueOf(paramZzcar.zzava()));
    localContentValues.put("app_version_int", Long.valueOf(paramZzcar.zzaut()));
    localContentValues.put("firebase_instance_id", paramZzcar.zzauq());
    localContentValues.put("daily_error_events_count", Long.valueOf(paramZzcar.zzavh()));
    localContentValues.put("daily_realtime_events_count", Long.valueOf(paramZzcar.zzavg()));
    localContentValues.put("health_monitor_sample", paramZzcar.zzavi());
    localContentValues.put("android_id", Long.valueOf(paramZzcar.zzavk()));
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      String str = paramZzcar.getAppId();
      int i = localSQLiteDatabase.update("apps", localContentValues, "app_id = ?", new String[] { str });
      if (i == 0L)
      {
        long l = localSQLiteDatabase.insertWithOnConflict("apps", null, localContentValues, 5);
        if (l == -1L)
        {
          zzaul().zzayd().append("Failed to insert/update app (got -1). appId", zzcbw.zzjf(paramZzcar.getAppId()));
          return;
        }
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      zzaul().zzayd().append("Error storing app. appId", zzcbw.zzjf(paramZzcar.getAppId()), localSQLiteException);
    }
  }
  
  public final void insertMessage(zzcbg paramZzcbg)
  {
    zzbp.append(paramZzcbg);
    zzuj();
    zzwk();
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("app_id", mAppId);
    ((ContentValues)localObject).put("name", mName);
    ((ContentValues)localObject).put("lifetime_count", Long.valueOf(zzinl));
    ((ContentValues)localObject).put("current_bundle_count", Long.valueOf(zzinm));
    ((ContentValues)localObject).put("last_fire_timestamp", Long.valueOf(zzinn));
    try
    {
      long l = getWritableDatabase().insertWithOnConflict("events", null, (ContentValues)localObject, 5);
      if (l == -1L)
      {
        localObject = zzaul().zzayd();
        String str = mAppId;
        ((zzcby)localObject).append("Failed to insert/update event aggregates (got -1). appId", zzcbw.zzjf(str));
        return;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      zzaul().zzayd().append("Error storing event aggregates. appId", zzcbw.zzjf(mAppId), localSQLiteException);
    }
  }
  
  public final boolean insertMessage(zzcav paramZzcav)
  {
    zzbp.append(paramZzcav);
    zzuj();
    zzwk();
    long l;
    if (zzah(packageName, zzimh.name) == null)
    {
      l = count("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[] { packageName });
      zzcax.zzawb();
      if (l >= 1000L) {
        return false;
      }
    }
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("app_id", packageName);
    ((ContentValues)localObject).put("origin", zzimg);
    ((ContentValues)localObject).put("name", zzimh.name);
    put((ContentValues)localObject, "value", zzimh.getValue());
    ((ContentValues)localObject).put("active", Boolean.valueOf(zzimj));
    ((ContentValues)localObject).put("trigger_event_name", zzimk);
    ((ContentValues)localObject).put("trigger_timeout", Long.valueOf(zzimm));
    zzauh();
    ((ContentValues)localObject).put("timed_out_event", zzcfw.marshall(zziml));
    ((ContentValues)localObject).put("creation_timestamp", Long.valueOf(zzimi));
    zzauh();
    ((ContentValues)localObject).put("triggered_event", zzcfw.marshall(zzimn));
    ((ContentValues)localObject).put("triggered_timestamp", Long.valueOf(zzimh.zziwz));
    ((ContentValues)localObject).put("time_to_live", Long.valueOf(zzimo));
    zzauh();
    ((ContentValues)localObject).put("expired_event", zzcfw.marshall(zzimp));
    try
    {
      l = getWritableDatabase().insertWithOnConflict("conditional_properties", null, (ContentValues)localObject, 5);
      if (l == -1L)
      {
        localObject = zzaul().zzayd();
        String str = packageName;
        ((zzcby)localObject).append("Failed to insert/update conditional user property (got -1)", zzcbw.zzjf(str));
        return true;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      zzaul().zzayd().append("Error storing conditional user property", zzcbw.zzjf(packageName), localSQLiteException);
    }
    return true;
  }
  
  public final List load(String paramString, String[] paramArrayOfString)
  {
    zzuj();
    zzwk();
    ArrayList localArrayList = new ArrayList();
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str1 = str2;
    try
    {
      Object localObject3 = getWritableDatabase();
      localObject1 = localObject2;
      str1 = str2;
      zzcax.zzawb();
      localObject1 = localObject2;
      str1 = str2;
      paramArrayOfString = ((SQLiteDatabase)localObject3).query("conditional_properties", new String[] { "app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event" }, paramString, paramArrayOfString, null, null, "rowid", "1001");
      paramString = paramArrayOfString;
      localObject1 = paramString;
      str1 = paramString;
      boolean bool = paramArrayOfString.moveToFirst();
      if (!bool)
      {
        paramArrayOfString.close();
        return localArrayList;
      }
      do
      {
        localObject1 = paramString;
        str1 = paramString;
        int i = localArrayList.size();
        localObject1 = paramString;
        str1 = paramString;
        zzcax.zzawb();
        if (i >= 1000)
        {
          localObject1 = paramString;
          str1 = paramString;
          localObject2 = zzaul().zzayd();
          localObject1 = paramString;
          str1 = paramString;
          zzcax.zzawb();
          localObject1 = paramString;
          str1 = paramString;
          ((zzcby)localObject2).append("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
          break;
        }
        bool = false;
        localObject1 = paramString;
        str1 = paramString;
        localObject2 = paramArrayOfString.getString(0);
        localObject1 = paramString;
        str1 = paramString;
        str2 = paramArrayOfString.getString(1);
        localObject1 = paramString;
        str1 = paramString;
        Object localObject4 = paramArrayOfString.getString(2);
        localObject1 = paramString;
        str1 = paramString;
        Object localObject5 = format(paramArrayOfString, 3);
        localObject1 = paramString;
        str1 = paramString;
        i = paramArrayOfString.getInt(4);
        if (i != 0) {
          bool = true;
        }
        localObject1 = paramString;
        str1 = paramString;
        localObject3 = paramArrayOfString.getString(5);
        localObject1 = paramString;
        str1 = paramString;
        long l1 = paramArrayOfString.getLong(6);
        localObject1 = paramString;
        str1 = paramString;
        Object localObject6 = zzauh();
        localObject1 = paramString;
        str1 = paramString;
        Object localObject7 = paramArrayOfString.getBlob(7);
        localObject1 = paramString;
        Object localObject8 = zzcbk.CREATOR;
        localObject1 = paramString;
        str1 = paramString;
        localObject6 = ((zzcfw)localObject6).unmarshall((byte[])localObject7, (Parcelable.Creator)localObject8);
        localObject1 = paramString;
        localObject6 = (zzcbk)localObject6;
        localObject1 = paramString;
        str1 = paramString;
        long l2 = paramArrayOfString.getLong(8);
        localObject1 = paramString;
        str1 = paramString;
        localObject7 = zzauh();
        localObject1 = paramString;
        str1 = paramString;
        localObject8 = paramArrayOfString.getBlob(9);
        localObject1 = paramString;
        Object localObject9 = zzcbk.CREATOR;
        localObject1 = paramString;
        str1 = paramString;
        localObject7 = ((zzcfw)localObject7).unmarshall((byte[])localObject8, (Parcelable.Creator)localObject9);
        localObject1 = paramString;
        localObject7 = (zzcbk)localObject7;
        localObject1 = paramString;
        str1 = paramString;
        long l3 = paramArrayOfString.getLong(10);
        localObject1 = paramString;
        str1 = paramString;
        long l4 = paramArrayOfString.getLong(11);
        localObject1 = paramString;
        str1 = paramString;
        localObject8 = zzauh();
        localObject1 = paramString;
        str1 = paramString;
        localObject9 = paramArrayOfString.getBlob(12);
        localObject1 = paramString;
        Parcelable.Creator localCreator = zzcbk.CREATOR;
        localObject1 = paramString;
        str1 = paramString;
        localObject8 = ((zzcfw)localObject8).unmarshall((byte[])localObject9, localCreator);
        localObject1 = paramString;
        localObject8 = (zzcbk)localObject8;
        localObject1 = paramString;
        str1 = paramString;
        localObject4 = new zzcft((String)localObject4, l3, localObject5, str2);
        localObject1 = paramString;
        str1 = paramString;
        localArrayList.add(new zzcav((String)localObject2, str2, (zzcft)localObject4, l2, bool, (String)localObject3, (zzcbk)localObject6, l1, (zzcbk)localObject7, l4, (zzcbk)localObject8));
        localObject1 = paramString;
        str1 = paramString;
        bool = paramArrayOfString.moveToNext();
      } while (bool);
      paramArrayOfString.close();
      return localArrayList;
    }
    catch (Throwable paramString) {}catch (SQLiteException paramString)
    {
      localObject1 = str1;
      zzaul().zzayd().append("Error querying conditional user property value", paramString);
      localObject1 = str1;
      paramString = Collections.emptyList();
      if (str1 == null) {
        return paramString;
      }
    }
    str1.close();
    return paramString;
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    throw paramString;
    return paramString;
  }
  
  public final boolean persist(zzcbf paramZzcbf, long paramLong, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final boolean saveToFile(zzcgk paramZzcgk, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final void setTransactionSuccessful()
  {
    zzwk();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  public final void trim(String paramString, zzcfx[] paramArrayOfZzcfx)
  {
    zzwk();
    zzuj();
    zzbp.zzgg(paramString);
    zzbp.append(paramArrayOfZzcfx);
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      zzwk();
      zzuj();
      zzbp.zzgg(paramString);
      Object localObject1 = getWritableDatabase();
      int n = 0;
      ((SQLiteDatabase)localObject1).delete("property_filters", "app_id=?", new String[] { paramString });
      ((SQLiteDatabase)localObject1).delete("event_filters", "app_id=?", new String[] { paramString });
      int i1 = paramArrayOfZzcfx.length;
      int j = 0;
      while (j < i1)
      {
        localObject1 = paramArrayOfZzcfx[j];
        zzwk();
        zzuj();
        zzbp.zzgg(paramString);
        zzbp.append(localObject1);
        zzbp.append(zzixl);
        zzbp.append(zzixk);
        Object localObject2 = zzixj;
        if (localObject2 == null) {
          zzaul().zzayf().append("Audience with no ID. appId", zzcbw.zzjf(paramString));
        }
        for (;;)
        {
          break;
          int i2 = ((Integer)localObject2).intValue();
          localObject2 = zzixl;
          int k = localObject2.length;
          i = 0;
          Object localObject3;
          String str;
          for (;;)
          {
            if (i >= k) {
              break label269;
            }
            localObject3 = zzixn;
            if (localObject3 == null)
            {
              localObject2 = zzaul().zzayf();
              str = "Event filter with no ID. Audience definition ignored. appId, audienceId";
              localObject3 = zzcbw.zzjf(paramString);
              localObject1 = zzixj;
              ((zzcby)localObject2).append(str, localObject3, localObject1);
              break;
            }
            i += 1;
          }
          label269:
          localObject2 = zzixk;
          k = localObject2.length;
          i = 0;
          for (;;)
          {
            if (i >= k) {
              break label340;
            }
            localObject3 = zzixn;
            if (localObject3 == null)
            {
              localObject2 = zzaul().zzayf();
              str = "Property filter with no ID. Audience definition ignored. appId, audienceId";
              localObject3 = zzcbw.zzjf(paramString);
              localObject1 = zzixj;
              break;
            }
            i += 1;
          }
          label340:
          localObject2 = zzixl;
          k = localObject2.length;
          i = 0;
          boolean bool;
          while (i < k)
          {
            bool = saveToFile(paramString, i2, localObject2[i]);
            if (!bool)
            {
              i = 0;
              break label392;
            }
            i += 1;
          }
          i = 1;
          label392:
          int m = i;
          if (i != 0)
          {
            localObject1 = zzixk;
            int i3 = localObject1.length;
            k = 0;
            for (;;)
            {
              m = i;
              if (k >= i3) {
                break;
              }
              bool = saveToFile(paramString, i2, localObject1[k]);
              if (!bool)
              {
                m = 0;
                break;
              }
              k += 1;
            }
          }
          if (m == 0)
          {
            zzwk();
            zzuj();
            zzbp.zzgg(paramString);
            localObject1 = getWritableDatabase();
            ((SQLiteDatabase)localObject1).delete("property_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(i2) });
            ((SQLiteDatabase)localObject1).delete("event_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(i2) });
          }
        }
        j += 1;
      }
      localObject1 = new ArrayList();
      j = paramArrayOfZzcfx.length;
      int i = n;
      while (i < j)
      {
        ((List)localObject1).add(zzixj);
        i += 1;
      }
      trim(paramString, (List)localObject1);
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      return;
    }
    catch (Throwable paramString)
    {
      localSQLiteDatabase.endTransaction();
      throw paramString;
    }
  }
  
  public final void zzae(List paramList)
  {
    zzbp.append(paramList);
    zzuj();
    zzwk();
    StringBuilder localStringBuilder = new StringBuilder("rowid in (");
    int i = 0;
    while (i < paramList.size())
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(((Long)paramList.get(i)).longValue());
      i += 1;
    }
    localStringBuilder.append(")");
    i = getWritableDatabase().delete("raw_events", localStringBuilder.toString(), null);
    if (i != paramList.size()) {
      zzaul().zzayd().append("Deleted fewer rows from raw events table than expected", Integer.valueOf(i), Integer.valueOf(paramList.size()));
    }
  }
  
  /* Error */
  public final zzcbg zzaf(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   14: aload_0
    //   15: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   18: aload_0
    //   19: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 10
    //   24: aload 10
    //   26: ldc_w 971
    //   29: iconst_3
    //   30: anewarray 322	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 956
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc_w 961
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: ldc_w 966
    //   50: aastore
    //   51: ldc_w 1139
    //   54: iconst_2
    //   55: anewarray 322	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: aload_1
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_2
    //   65: aastore
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokevirtual 480	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 12
    //   74: aload 12
    //   76: astore 11
    //   78: aload 11
    //   80: astore 10
    //   82: aload 12
    //   84: invokeinterface 222 1 0
    //   89: istore_3
    //   90: iload_3
    //   91: ifne +12 -> 103
    //   94: aload 12
    //   96: invokeinterface 229 1 0
    //   101: aconst_null
    //   102: areturn
    //   103: aload 11
    //   105: astore 10
    //   107: aload 12
    //   109: iconst_0
    //   110: invokeinterface 226 2 0
    //   115: lstore 4
    //   117: aload 11
    //   119: astore 10
    //   121: aload 12
    //   123: iconst_1
    //   124: invokeinterface 226 2 0
    //   129: lstore 6
    //   131: aload 11
    //   133: astore 10
    //   135: aload 12
    //   137: iconst_2
    //   138: invokeinterface 226 2 0
    //   143: lstore 8
    //   145: aload 11
    //   147: astore 10
    //   149: new 952	com/google/android/android/internal/zzcbg
    //   152: dup
    //   153: aload_1
    //   154: aload_2
    //   155: lload 4
    //   157: lload 6
    //   159: lload 8
    //   161: invokespecial 1142	com/google/android/android/internal/zzcbg:<init>	(Ljava/lang/String;Ljava/lang/String;JJJ)V
    //   164: astore 13
    //   166: aload 11
    //   168: astore 10
    //   170: aload 12
    //   172: invokeinterface 728 1 0
    //   177: istore_3
    //   178: iload_3
    //   179: ifeq +24 -> 203
    //   182: aload 11
    //   184: astore 10
    //   186: aload_0
    //   187: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   190: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   193: ldc_w 1144
    //   196: aload_1
    //   197: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   200: invokevirtual 197	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   203: aload 12
    //   205: invokeinterface 229 1 0
    //   210: aload 13
    //   212: areturn
    //   213: astore 12
    //   215: goto +15 -> 230
    //   218: astore_1
    //   219: aconst_null
    //   220: astore 10
    //   222: goto +54 -> 276
    //   225: astore 12
    //   227: aconst_null
    //   228: astore 11
    //   230: aload 11
    //   232: astore 10
    //   234: aload_0
    //   235: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   238: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   241: ldc_w 1146
    //   244: aload_1
    //   245: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   248: aload_0
    //   249: invokevirtual 1150	com/google/android/android/internal/zzcdt:zzaug	()Lcom/google/android/android/internal/zzcbu;
    //   252: aload_2
    //   253: invokevirtual 1155	com/google/android/android/internal/zzcbu:zzjc	(Ljava/lang/String;)Ljava/lang/String;
    //   256: aload 12
    //   258: invokevirtual 400	com/google/android/android/internal/zzcby:attribute	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   261: aload 11
    //   263: ifnull +27 -> 290
    //   266: aload 11
    //   268: invokeinterface 229 1 0
    //   273: aconst_null
    //   274: areturn
    //   275: astore_1
    //   276: aload 10
    //   278: ifnull +10 -> 288
    //   281: aload 10
    //   283: invokeinterface 229 1 0
    //   288: aload_1
    //   289: athrow
    //   290: aconst_null
    //   291: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	zzcay
    //   0	292	1	paramString1	String
    //   0	292	2	paramString2	String
    //   89	90	3	bool	boolean
    //   115	41	4	l1	long
    //   129	29	6	l2	long
    //   143	17	8	l3	long
    //   22	260	10	localObject	Object
    //   76	191	11	localCursor1	Cursor
    //   72	132	12	localCursor2	Cursor
    //   213	1	12	localSQLiteException1	SQLiteException
    //   225	32	12	localSQLiteException2	SQLiteException
    //   164	47	13	localZzcbg	zzcbg
    // Exception table:
    //   from	to	target	type
    //   82	90	213	android/database/sqlite/SQLiteException
    //   107	117	213	android/database/sqlite/SQLiteException
    //   121	131	213	android/database/sqlite/SQLiteException
    //   135	145	213	android/database/sqlite/SQLiteException
    //   149	166	213	android/database/sqlite/SQLiteException
    //   170	178	213	android/database/sqlite/SQLiteException
    //   186	203	213	android/database/sqlite/SQLiteException
    //   18	24	218	java/lang/Throwable
    //   24	74	218	java/lang/Throwable
    //   18	24	225	android/database/sqlite/SQLiteException
    //   24	74	225	android/database/sqlite/SQLiteException
    //   82	90	275	java/lang/Throwable
    //   107	117	275	java/lang/Throwable
    //   121	131	275	java/lang/Throwable
    //   135	145	275	java/lang/Throwable
    //   149	166	275	java/lang/Throwable
    //   170	178	275	java/lang/Throwable
    //   186	203	275	java/lang/Throwable
    //   234	261	275	java/lang/Throwable
  }
  
  public final void zzag(String paramString1, String paramString2)
  {
    zzbp.zzgg(paramString1);
    zzbp.zzgg(paramString2);
    zzuj();
    zzwk();
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      int i = localSQLiteDatabase.delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      zzaul().zzayj().append("Deleted user attribute rows", Integer.valueOf(i));
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzaul().zzayd().attribute("Error deleting user attribute. appId", zzcbw.zzjf(paramString1), zzaug().zzje(paramString2), localSQLiteException);
    }
  }
  
  /* Error */
  public final zzcfv zzah(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   14: aload_0
    //   15: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   18: aload_0
    //   19: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 6
    //   24: aload 6
    //   26: ldc_w 673
    //   29: iconst_3
    //   30: anewarray 322	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 659
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc_w 665
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: ldc 27
    //   49: aastore
    //   50: ldc_w 1139
    //   53: iconst_2
    //   54: anewarray 322	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload_2
    //   64: aastore
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 480	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 8
    //   73: aload 8
    //   75: astore 6
    //   77: aload 8
    //   79: invokeinterface 222 1 0
    //   84: istore_3
    //   85: iload_3
    //   86: ifne +12 -> 98
    //   89: aload 8
    //   91: invokeinterface 229 1 0
    //   96: aconst_null
    //   97: areturn
    //   98: aload 8
    //   100: iconst_0
    //   101: invokeinterface 226 2 0
    //   106: lstore 4
    //   108: aload 6
    //   110: astore 7
    //   112: aload_0
    //   113: aload 8
    //   115: iconst_1
    //   116: invokespecial 720	com/google/android/android/internal/zzcay:format	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   119: astore 9
    //   121: aload 6
    //   123: astore 7
    //   125: aload 8
    //   127: iconst_2
    //   128: invokeinterface 264 2 0
    //   133: astore 10
    //   135: aload 6
    //   137: astore 7
    //   139: new 626	com/google/android/android/internal/zzcfv
    //   142: dup
    //   143: aload_1
    //   144: aload 10
    //   146: aload_2
    //   147: lload 4
    //   149: aload 9
    //   151: invokespecial 725	com/google/android/android/internal/zzcfv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   154: astore 9
    //   156: aload 6
    //   158: astore 7
    //   160: aload 8
    //   162: invokeinterface 728 1 0
    //   167: istore_3
    //   168: iload_3
    //   169: ifeq +24 -> 193
    //   172: aload 6
    //   174: astore 7
    //   176: aload_0
    //   177: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   180: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   183: ldc_w 1168
    //   186: aload_1
    //   187: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   190: invokevirtual 197	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   193: aload 8
    //   195: invokeinterface 229 1 0
    //   200: aload 9
    //   202: areturn
    //   203: astore 8
    //   205: goto +24 -> 229
    //   208: astore_1
    //   209: goto +70 -> 279
    //   212: astore 8
    //   214: goto +15 -> 229
    //   217: astore_1
    //   218: aconst_null
    //   219: astore 6
    //   221: goto +58 -> 279
    //   224: astore 8
    //   226: aconst_null
    //   227: astore 6
    //   229: aload 6
    //   231: astore 7
    //   233: aload_0
    //   234: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   237: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   240: ldc_w 1170
    //   243: aload_1
    //   244: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   247: aload_0
    //   248: invokevirtual 1150	com/google/android/android/internal/zzcdt:zzaug	()Lcom/google/android/android/internal/zzcbu;
    //   251: aload_2
    //   252: invokevirtual 1166	com/google/android/android/internal/zzcbu:zzje	(Ljava/lang/String;)Ljava/lang/String;
    //   255: aload 8
    //   257: invokevirtual 400	com/google/android/android/internal/zzcby:attribute	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   260: aload 6
    //   262: ifnull +31 -> 293
    //   265: aload 6
    //   267: invokeinterface 229 1 0
    //   272: aconst_null
    //   273: areturn
    //   274: astore_1
    //   275: aload 7
    //   277: astore 6
    //   279: aload 6
    //   281: ifnull +10 -> 291
    //   284: aload 6
    //   286: invokeinterface 229 1 0
    //   291: aload_1
    //   292: athrow
    //   293: aconst_null
    //   294: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	zzcay
    //   0	295	1	paramString1	String
    //   0	295	2	paramString2	String
    //   84	85	3	bool	boolean
    //   106	42	4	l	long
    //   22	263	6	localObject1	Object
    //   110	166	7	localObject2	Object
    //   71	123	8	localCursor	Cursor
    //   203	1	8	localSQLiteException1	SQLiteException
    //   212	1	8	localSQLiteException2	SQLiteException
    //   224	32	8	localSQLiteException3	SQLiteException
    //   119	82	9	localObject3	Object
    //   133	12	10	str	String
    // Exception table:
    //   from	to	target	type
    //   112	121	203	android/database/sqlite/SQLiteException
    //   125	135	203	android/database/sqlite/SQLiteException
    //   139	156	203	android/database/sqlite/SQLiteException
    //   160	168	203	android/database/sqlite/SQLiteException
    //   176	193	203	android/database/sqlite/SQLiteException
    //   77	85	208	java/lang/Throwable
    //   98	108	208	java/lang/Throwable
    //   77	85	212	android/database/sqlite/SQLiteException
    //   98	108	212	android/database/sqlite/SQLiteException
    //   18	24	217	java/lang/Throwable
    //   24	73	217	java/lang/Throwable
    //   18	24	224	android/database/sqlite/SQLiteException
    //   24	73	224	android/database/sqlite/SQLiteException
    //   112	121	274	java/lang/Throwable
    //   125	135	274	java/lang/Throwable
    //   139	156	274	java/lang/Throwable
    //   160	168	274	java/lang/Throwable
    //   176	193	274	java/lang/Throwable
    //   233	260	274	java/lang/Throwable
  }
  
  /* Error */
  public final zzcav zzai(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   14: aload_0
    //   15: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   18: aload_0
    //   19: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 13
    //   24: aload 13
    //   26: ldc_w 1053
    //   29: bipush 11
    //   31: anewarray 322	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 27
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc_w 665
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: ldc_w 1002
    //   50: aastore
    //   51: dup
    //   52: iconst_3
    //   53: ldc_w 1008
    //   56: aastore
    //   57: dup
    //   58: iconst_4
    //   59: ldc_w 1013
    //   62: aastore
    //   63: dup
    //   64: iconst_5
    //   65: ldc_w 1018
    //   68: aastore
    //   69: dup
    //   70: bipush 6
    //   72: ldc_w 1028
    //   75: aastore
    //   76: dup
    //   77: bipush 7
    //   79: ldc_w 1033
    //   82: aastore
    //   83: dup
    //   84: bipush 8
    //   86: ldc_w 1038
    //   89: aastore
    //   90: dup
    //   91: bipush 9
    //   93: ldc_w 1043
    //   96: aastore
    //   97: dup
    //   98: bipush 10
    //   100: ldc_w 1048
    //   103: aastore
    //   104: ldc_w 1139
    //   107: iconst_2
    //   108: anewarray 322	java/lang/String
    //   111: dup
    //   112: iconst_0
    //   113: aload_1
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: aload_2
    //   118: aastore
    //   119: aconst_null
    //   120: aconst_null
    //   121: aconst_null
    //   122: invokevirtual 480	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   125: astore 15
    //   127: aload 15
    //   129: astore 13
    //   131: aload 15
    //   133: invokeinterface 222 1 0
    //   138: istore 4
    //   140: iload 4
    //   142: ifne +12 -> 154
    //   145: aload 15
    //   147: invokeinterface 229 1 0
    //   152: aconst_null
    //   153: areturn
    //   154: aload 15
    //   156: iconst_0
    //   157: invokeinterface 264 2 0
    //   162: astore 16
    //   164: aload 13
    //   166: astore 14
    //   168: aload_0
    //   169: aload 15
    //   171: iconst_1
    //   172: invokespecial 720	com/google/android/android/internal/zzcay:format	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   175: astore 18
    //   177: aload 13
    //   179: astore 14
    //   181: aload 15
    //   183: iconst_2
    //   184: invokeinterface 1062 2 0
    //   189: istore_3
    //   190: iload_3
    //   191: ifeq +9 -> 200
    //   194: iconst_1
    //   195: istore 4
    //   197: goto +6 -> 203
    //   200: iconst_0
    //   201: istore 4
    //   203: aload 13
    //   205: astore 14
    //   207: aload 15
    //   209: iconst_3
    //   210: invokeinterface 264 2 0
    //   215: astore 17
    //   217: aload 13
    //   219: astore 14
    //   221: aload 15
    //   223: iconst_4
    //   224: invokeinterface 226 2 0
    //   229: lstore 5
    //   231: aload 13
    //   233: astore 14
    //   235: aload_0
    //   236: invokevirtual 785	com/google/android/android/internal/zzcdt:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   239: astore 19
    //   241: aload 13
    //   243: astore 14
    //   245: aload 15
    //   247: iconst_5
    //   248: invokeinterface 781 2 0
    //   253: astore 20
    //   255: aload 13
    //   257: astore 14
    //   259: getstatic 1068	com/google/android/android/internal/zzcbk:CREATOR	Landroid/os/Parcelable$Creator;
    //   262: astore 21
    //   264: aload 13
    //   266: astore 14
    //   268: aload 19
    //   270: aload 20
    //   272: aload 21
    //   274: invokevirtual 1072	com/google/android/android/internal/zzcfw:unmarshall	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   277: astore 19
    //   279: aload 13
    //   281: astore 14
    //   283: aload 19
    //   285: checkcast 1064	com/google/android/android/internal/zzcbk
    //   288: astore 19
    //   290: aload 13
    //   292: astore 14
    //   294: aload 15
    //   296: bipush 6
    //   298: invokeinterface 226 2 0
    //   303: lstore 7
    //   305: aload 13
    //   307: astore 14
    //   309: aload_0
    //   310: invokevirtual 785	com/google/android/android/internal/zzcdt:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   313: astore 20
    //   315: aload 13
    //   317: astore 14
    //   319: aload 15
    //   321: bipush 7
    //   323: invokeinterface 781 2 0
    //   328: astore 21
    //   330: aload 13
    //   332: astore 14
    //   334: getstatic 1068	com/google/android/android/internal/zzcbk:CREATOR	Landroid/os/Parcelable$Creator;
    //   337: astore 22
    //   339: aload 13
    //   341: astore 14
    //   343: aload 20
    //   345: aload 21
    //   347: aload 22
    //   349: invokevirtual 1072	com/google/android/android/internal/zzcfw:unmarshall	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   352: astore 20
    //   354: aload 13
    //   356: astore 14
    //   358: aload 20
    //   360: checkcast 1064	com/google/android/android/internal/zzcbk
    //   363: astore 20
    //   365: aload 13
    //   367: astore 14
    //   369: aload 15
    //   371: bipush 8
    //   373: invokeinterface 226 2 0
    //   378: lstore 9
    //   380: aload 13
    //   382: astore 14
    //   384: aload 15
    //   386: bipush 9
    //   388: invokeinterface 226 2 0
    //   393: lstore 11
    //   395: aload 13
    //   397: astore 14
    //   399: aload_0
    //   400: invokevirtual 785	com/google/android/android/internal/zzcdt:zzauh	()Lcom/google/android/android/internal/zzcfw;
    //   403: astore 21
    //   405: aload 13
    //   407: astore 14
    //   409: aload 15
    //   411: bipush 10
    //   413: invokeinterface 781 2 0
    //   418: astore 22
    //   420: aload 13
    //   422: astore 14
    //   424: getstatic 1068	com/google/android/android/internal/zzcbk:CREATOR	Landroid/os/Parcelable$Creator;
    //   427: astore 23
    //   429: aload 13
    //   431: astore 14
    //   433: aload 21
    //   435: aload 22
    //   437: aload 23
    //   439: invokevirtual 1072	com/google/android/android/internal/zzcfw:unmarshall	([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   442: astore 21
    //   444: aload 13
    //   446: astore 14
    //   448: aload 21
    //   450: checkcast 1064	com/google/android/android/internal/zzcbk
    //   453: astore 21
    //   455: aload 13
    //   457: astore 14
    //   459: new 987	com/google/android/android/internal/zzcft
    //   462: dup
    //   463: aload_2
    //   464: lload 9
    //   466: aload 18
    //   468: aload 16
    //   470: invokespecial 1075	com/google/android/android/internal/zzcft:<init>	(Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   473: astore 18
    //   475: aload 13
    //   477: astore 14
    //   479: new 978	com/google/android/android/internal/zzcav
    //   482: dup
    //   483: aload_1
    //   484: aload 16
    //   486: aload 18
    //   488: lload 7
    //   490: iload 4
    //   492: aload 17
    //   494: aload 19
    //   496: lload 5
    //   498: aload 20
    //   500: lload 11
    //   502: aload 21
    //   504: invokespecial 1078	com/google/android/android/internal/zzcav:<init>	(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/android/internal/zzcft;JZLjava/lang/String;Lcom/google/android/android/internal/zzcbk;JLcom/google/android/android/internal/zzcbk;JLcom/google/android/android/internal/zzcbk;)V
    //   507: astore 16
    //   509: aload 13
    //   511: astore 14
    //   513: aload 15
    //   515: invokeinterface 728 1 0
    //   520: istore 4
    //   522: iload 4
    //   524: ifeq +32 -> 556
    //   527: aload 13
    //   529: astore 14
    //   531: aload_0
    //   532: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   535: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   538: ldc_w 1174
    //   541: aload_1
    //   542: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   545: aload_0
    //   546: invokevirtual 1150	com/google/android/android/internal/zzcdt:zzaug	()Lcom/google/android/android/internal/zzcbu;
    //   549: aload_2
    //   550: invokevirtual 1166	com/google/android/android/internal/zzcbu:zzje	(Ljava/lang/String;)Ljava/lang/String;
    //   553: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   556: aload 15
    //   558: invokeinterface 229 1 0
    //   563: aload 16
    //   565: areturn
    //   566: astore 15
    //   568: goto +24 -> 592
    //   571: astore_1
    //   572: goto +70 -> 642
    //   575: astore 15
    //   577: goto +15 -> 592
    //   580: astore_1
    //   581: aconst_null
    //   582: astore 13
    //   584: goto +58 -> 642
    //   587: astore 15
    //   589: aconst_null
    //   590: astore 13
    //   592: aload 13
    //   594: astore 14
    //   596: aload_0
    //   597: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   600: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   603: ldc_w 1176
    //   606: aload_1
    //   607: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   610: aload_0
    //   611: invokevirtual 1150	com/google/android/android/internal/zzcdt:zzaug	()Lcom/google/android/android/internal/zzcbu;
    //   614: aload_2
    //   615: invokevirtual 1166	com/google/android/android/internal/zzcbu:zzje	(Ljava/lang/String;)Ljava/lang/String;
    //   618: aload 15
    //   620: invokevirtual 400	com/google/android/android/internal/zzcby:attribute	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   623: aload 13
    //   625: ifnull +31 -> 656
    //   628: aload 13
    //   630: invokeinterface 229 1 0
    //   635: aconst_null
    //   636: areturn
    //   637: astore_1
    //   638: aload 14
    //   640: astore 13
    //   642: aload 13
    //   644: ifnull +10 -> 654
    //   647: aload 13
    //   649: invokeinterface 229 1 0
    //   654: aload_1
    //   655: athrow
    //   656: aconst_null
    //   657: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	658	0	this	zzcay
    //   0	658	1	paramString1	String
    //   0	658	2	paramString2	String
    //   189	2	3	i	int
    //   138	385	4	bool	boolean
    //   229	268	5	l1	long
    //   303	186	7	l2	long
    //   378	87	9	l3	long
    //   393	108	11	l4	long
    //   22	626	13	localObject1	Object
    //   166	473	14	localObject2	Object
    //   125	432	15	localCursor	Cursor
    //   566	1	15	localSQLiteException1	SQLiteException
    //   575	1	15	localSQLiteException2	SQLiteException
    //   587	32	15	localSQLiteException3	SQLiteException
    //   162	402	16	localObject3	Object
    //   215	278	17	str	String
    //   175	312	18	localObject4	Object
    //   239	256	19	localObject5	Object
    //   253	246	20	localObject6	Object
    //   262	241	21	localObject7	Object
    //   337	99	22	localObject8	Object
    //   427	11	23	localCreator	Parcelable.Creator
    // Exception table:
    //   from	to	target	type
    //   168	177	566	android/database/sqlite/SQLiteException
    //   181	190	566	android/database/sqlite/SQLiteException
    //   207	217	566	android/database/sqlite/SQLiteException
    //   221	231	566	android/database/sqlite/SQLiteException
    //   235	241	566	android/database/sqlite/SQLiteException
    //   245	255	566	android/database/sqlite/SQLiteException
    //   268	279	566	android/database/sqlite/SQLiteException
    //   294	305	566	android/database/sqlite/SQLiteException
    //   309	315	566	android/database/sqlite/SQLiteException
    //   319	330	566	android/database/sqlite/SQLiteException
    //   343	354	566	android/database/sqlite/SQLiteException
    //   369	380	566	android/database/sqlite/SQLiteException
    //   384	395	566	android/database/sqlite/SQLiteException
    //   399	405	566	android/database/sqlite/SQLiteException
    //   409	420	566	android/database/sqlite/SQLiteException
    //   433	444	566	android/database/sqlite/SQLiteException
    //   459	475	566	android/database/sqlite/SQLiteException
    //   479	509	566	android/database/sqlite/SQLiteException
    //   513	522	566	android/database/sqlite/SQLiteException
    //   531	556	566	android/database/sqlite/SQLiteException
    //   131	140	571	java/lang/Throwable
    //   154	164	571	java/lang/Throwable
    //   131	140	575	android/database/sqlite/SQLiteException
    //   154	164	575	android/database/sqlite/SQLiteException
    //   18	24	580	java/lang/Throwable
    //   24	127	580	java/lang/Throwable
    //   18	24	587	android/database/sqlite/SQLiteException
    //   24	127	587	android/database/sqlite/SQLiteException
    //   168	177	637	java/lang/Throwable
    //   181	190	637	java/lang/Throwable
    //   207	217	637	java/lang/Throwable
    //   221	231	637	java/lang/Throwable
    //   235	241	637	java/lang/Throwable
    //   245	255	637	java/lang/Throwable
    //   259	264	637	java/lang/Throwable
    //   268	279	637	java/lang/Throwable
    //   283	290	637	java/lang/Throwable
    //   294	305	637	java/lang/Throwable
    //   309	315	637	java/lang/Throwable
    //   319	330	637	java/lang/Throwable
    //   334	339	637	java/lang/Throwable
    //   343	354	637	java/lang/Throwable
    //   358	365	637	java/lang/Throwable
    //   369	380	637	java/lang/Throwable
    //   384	395	637	java/lang/Throwable
    //   399	405	637	java/lang/Throwable
    //   409	420	637	java/lang/Throwable
    //   424	429	637	java/lang/Throwable
    //   433	444	637	java/lang/Throwable
    //   448	455	637	java/lang/Throwable
    //   459	475	637	java/lang/Throwable
    //   479	509	637	java/lang/Throwable
    //   513	522	637	java/lang/Throwable
    //   531	556	637	java/lang/Throwable
    //   596	623	637	java/lang/Throwable
  }
  
  public final int zzaj(String paramString1, String paramString2)
  {
    zzbp.zzgg(paramString1);
    zzbp.zzgg(paramString2);
    zzuj();
    zzwk();
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      int i = localSQLiteDatabase.delete("conditional_properties", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzaul().zzayd().attribute("Error deleting conditional property", zzcbw.zzjf(paramString1), zzaug().zzje(paramString2), localSQLiteException);
    }
    return 0;
  }
  
  public final Map zzak(String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a17 = a16\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public final Map zzal(String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a17 = a16\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  /* Error */
  public final long zzam(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   14: aload_0
    //   15: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   18: aload_0
    //   19: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 9
    //   24: aload 9
    //   26: invokevirtual 680	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   29: aload_2
    //   30: invokestatic 396	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: invokevirtual 1190	java/lang/String:length	()I
    //   36: istore_3
    //   37: new 567	java/lang/StringBuilder
    //   40: dup
    //   41: iload_3
    //   42: bipush 32
    //   44: iadd
    //   45: invokespecial 568	java/lang/StringBuilder:<init>	(I)V
    //   48: astore 8
    //   50: aload 8
    //   52: ldc_w 1192
    //   55: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 8
    //   61: aload_2
    //   62: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 8
    //   68: ldc_w 1194
    //   71: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 8
    //   77: invokevirtual 577	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 8
    //   82: aload_0
    //   83: aload 8
    //   85: iconst_1
    //   86: anewarray 322	java/lang/String
    //   89: dup
    //   90: iconst_0
    //   91: aload_1
    //   92: aastore
    //   93: ldc2_w 443
    //   96: invokespecial 1196	com/google/android/android/internal/zzcay:count	(Ljava/lang/String;[Ljava/lang/String;J)J
    //   99: lstore 6
    //   101: lload 6
    //   103: lstore 4
    //   105: lload 6
    //   107: ldc2_w 443
    //   110: lcmp
    //   111: ifne +97 -> 208
    //   114: new 324	android/content/ContentValues
    //   117: dup
    //   118: invokespecial 420	android/content/ContentValues:<init>	()V
    //   121: astore 8
    //   123: aload 8
    //   125: ldc_w 422
    //   128: aload_1
    //   129: invokevirtual 327	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload 8
    //   134: ldc_w 1198
    //   137: iconst_0
    //   138: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: invokevirtual 427	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   144: aload 8
    //   146: ldc -127
    //   148: iconst_0
    //   149: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokevirtual 427	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   155: aload 9
    //   157: ldc_w 1200
    //   160: aconst_null
    //   161: aload 8
    //   163: iconst_5
    //   164: invokevirtual 442	android/database/sqlite/SQLiteDatabase:insertWithOnConflict	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    //   167: lstore 4
    //   169: lload 4
    //   171: ldc2_w 443
    //   174: lcmp
    //   175: ifne +30 -> 205
    //   178: aload_0
    //   179: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   182: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   185: ldc_w 1202
    //   188: aload_1
    //   189: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   192: aload_2
    //   193: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   196: aload 9
    //   198: invokevirtual 733	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   201: ldc2_w 443
    //   204: lreturn
    //   205: lconst_0
    //   206: lstore 4
    //   208: new 324	android/content/ContentValues
    //   211: dup
    //   212: invokespecial 420	android/content/ContentValues:<init>	()V
    //   215: astore 8
    //   217: aload 8
    //   219: ldc_w 422
    //   222: aload_1
    //   223: invokevirtual 327	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 8
    //   228: aload_2
    //   229: lconst_1
    //   230: lload 4
    //   232: ladd
    //   233: invokestatic 278	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   236: invokevirtual 330	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   239: aload 9
    //   241: ldc_w 1200
    //   244: aload 8
    //   246: ldc_w 945
    //   249: iconst_1
    //   250: anewarray 322	java/lang/String
    //   253: dup
    //   254: iconst_0
    //   255: aload_1
    //   256: aastore
    //   257: invokevirtual 761	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   260: istore_3
    //   261: iload_3
    //   262: i2l
    //   263: lconst_0
    //   264: lcmp
    //   265: ifne +30 -> 295
    //   268: aload_0
    //   269: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   272: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   275: ldc_w 1204
    //   278: aload_1
    //   279: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   282: aload_2
    //   283: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   286: aload 9
    //   288: invokevirtual 733	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   291: ldc2_w 443
    //   294: lreturn
    //   295: aload 9
    //   297: invokevirtual 1093	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   300: goto +42 -> 342
    //   303: astore 8
    //   305: goto +17 -> 322
    //   308: astore 8
    //   310: goto +9 -> 319
    //   313: astore_1
    //   314: goto +37 -> 351
    //   317: astore 8
    //   319: lconst_0
    //   320: lstore 4
    //   322: aload_0
    //   323: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   326: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   329: ldc_w 1206
    //   332: aload_1
    //   333: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   336: aload_2
    //   337: aload 8
    //   339: invokevirtual 400	com/google/android/android/internal/zzcby:attribute	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   342: aload 9
    //   344: invokevirtual 733	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   347: lload 4
    //   349: lreturn
    //   350: astore_1
    //   351: aload 9
    //   353: invokevirtual 733	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   356: aload_1
    //   357: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	zzcay
    //   0	358	1	paramString1	String
    //   0	358	2	paramString2	String
    //   36	226	3	i	int
    //   103	245	4	l1	long
    //   99	7	6	l2	long
    //   48	197	8	localObject	Object
    //   303	1	8	localSQLiteException1	SQLiteException
    //   308	1	8	localSQLiteException2	SQLiteException
    //   317	21	8	localSQLiteException3	SQLiteException
    //   22	330	9	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   208	226	303	android/database/sqlite/SQLiteException
    //   226	239	303	android/database/sqlite/SQLiteException
    //   239	261	303	android/database/sqlite/SQLiteException
    //   268	286	303	android/database/sqlite/SQLiteException
    //   295	300	303	android/database/sqlite/SQLiteException
    //   82	101	308	android/database/sqlite/SQLiteException
    //   114	169	308	android/database/sqlite/SQLiteException
    //   178	196	308	android/database/sqlite/SQLiteException
    //   29	37	313	java/lang/Throwable
    //   37	82	313	java/lang/Throwable
    //   29	37	317	android/database/sqlite/SQLiteException
    //   37	82	317	android/database/sqlite/SQLiteException
    //   82	101	350	java/lang/Throwable
    //   114	169	350	java/lang/Throwable
    //   178	196	350	java/lang/Throwable
    //   208	226	350	java/lang/Throwable
    //   226	239	350	java/lang/Throwable
    //   239	261	350	java/lang/Throwable
    //   268	286	350	java/lang/Throwable
    //   295	300	350	java/lang/Throwable
    //   322	342	350	java/lang/Throwable
  }
  
  /* Error */
  public final String zzaxi()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_2
    //   5: aload_2
    //   6: ldc_w 1209
    //   9: aconst_null
    //   10: invokevirtual 216	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload_3
    //   19: astore_2
    //   20: aload 4
    //   22: invokeinterface 222 1 0
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +25 -> 54
    //   32: aload_3
    //   33: astore_2
    //   34: aload 4
    //   36: iconst_0
    //   37: invokeinterface 264 2 0
    //   42: astore 5
    //   44: aload 4
    //   46: invokeinterface 229 1 0
    //   51: aload 5
    //   53: areturn
    //   54: aload 4
    //   56: invokeinterface 229 1 0
    //   61: aconst_null
    //   62: areturn
    //   63: astore 4
    //   65: goto +16 -> 81
    //   68: astore_2
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_2
    //   72: astore 4
    //   74: goto +40 -> 114
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_3
    //   82: astore_2
    //   83: aload_0
    //   84: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   87: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   90: ldc_w 1211
    //   93: aload 4
    //   95: invokevirtual 197	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   98: aload_3
    //   99: ifnull +28 -> 127
    //   102: aload_3
    //   103: invokeinterface 229 1 0
    //   108: aconst_null
    //   109: areturn
    //   110: astore 4
    //   112: aload_2
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +9 -> 124
    //   118: aload_3
    //   119: invokeinterface 229 1 0
    //   124: aload 4
    //   126: athrow
    //   127: aconst_null
    //   128: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	zzcay
    //   27	2	1	bool	boolean
    //   4	30	2	localObject1	Object
    //   68	4	2	localThrowable1	Throwable
    //   82	31	2	localObject2	Object
    //   17	102	3	localObject3	Object
    //   13	42	4	localCursor	Cursor
    //   63	1	4	localSQLiteException1	SQLiteException
    //   72	1	4	localThrowable2	Throwable
    //   77	17	4	localSQLiteException2	SQLiteException
    //   110	15	4	localThrowable3	Throwable
    //   42	10	5	str	String
    // Exception table:
    //   from	to	target	type
    //   20	28	63	android/database/sqlite/SQLiteException
    //   34	44	63	android/database/sqlite/SQLiteException
    //   5	15	68	java/lang/Throwable
    //   5	15	77	android/database/sqlite/SQLiteException
    //   20	28	110	java/lang/Throwable
    //   34	44	110	java/lang/Throwable
    //   83	98	110	java/lang/Throwable
  }
  
  public final boolean zzaxj()
  {
    return count("select count(1) > 0 from queue where has_realtime = 1", null) != 0L;
  }
  
  public final void zzaxk()
  {
    zzuj();
    zzwk();
    if (!zzaxq()) {
      return;
    }
    long l1 = zzaumzziqs.lastModified();
    long l2 = zzvx().elapsedRealtime();
    if (Math.abs(l2 - l1) > zzcax.zzawn())
    {
      zzaumzziqs.setDefaultAccount(l2);
      zzuj();
      zzwk();
      if (zzaxq())
      {
        int i = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(zzvx().currentTimeMillis()), String.valueOf(zzcax.zzawm()) });
        if (i > 0) {
          zzaul().zzayj().append("Deleted stale rows. rowsDeleted", Integer.valueOf(i));
        }
      }
    }
  }
  
  public final long zzaxl()
  {
    return count("select max(bundle_end_timestamp) from queue", null, 0L);
  }
  
  public final long zzaxm()
  {
    return count("select max(timestamp) from raw_events", null, 0L);
  }
  
  public final boolean zzaxn()
  {
    return count("select count(1) > 0 from raw_events", null) != 0L;
  }
  
  public final boolean zzaxo()
  {
    return count("select count(1) > 0 from raw_events where realtime = 1", null) != 0L;
  }
  
  public final long zzaxp()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      Cursor localCursor2 = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
      Cursor localCursor1 = localCursor2;
      localObject1 = localCursor1;
      localObject2 = localCursor1;
      boolean bool = localCursor2.moveToFirst();
      if (!bool)
      {
        localCursor2.close();
        return -1L;
      }
      localObject1 = localCursor1;
      localObject2 = localCursor1;
      long l = localCursor2.getLong(0);
      localCursor2.close();
      return l;
    }
    catch (Throwable localThrowable) {}catch (SQLiteException localSQLiteException)
    {
      localObject1 = localThrowable;
      zzaul().zzayd().append("Error querying raw events", localSQLiteException);
      if (localThrowable == null) {
        break label137;
      }
    }
    localThrowable.close();
    return -1L;
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    throw localThrowable;
    label137:
    return -1L;
  }
  
  /* Error */
  public final String zzba(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   4: aload_0
    //   5: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   8: aload_0
    //   9: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 4
    //   14: aload 4
    //   16: ldc_w 1281
    //   19: iconst_1
    //   20: anewarray 322	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: lload_1
    //   26: invokestatic 1256	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   29: aastore
    //   30: invokevirtual 216	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 6
    //   35: aload 6
    //   37: astore 5
    //   39: aload 5
    //   41: astore 4
    //   43: aload 6
    //   45: invokeinterface 222 1 0
    //   50: istore_3
    //   51: iload_3
    //   52: ifne +29 -> 81
    //   55: aload 5
    //   57: astore 4
    //   59: aload_0
    //   60: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   63: invokevirtual 1159	com/google/android/android/internal/zzcbw:zzayj	()Lcom/google/android/android/internal/zzcby;
    //   66: ldc_w 1283
    //   69: invokevirtual 260	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;)V
    //   72: aload 6
    //   74: invokeinterface 229 1 0
    //   79: aconst_null
    //   80: areturn
    //   81: aload 5
    //   83: astore 4
    //   85: aload 6
    //   87: iconst_0
    //   88: invokeinterface 264 2 0
    //   93: astore 7
    //   95: aload 6
    //   97: invokeinterface 229 1 0
    //   102: aload 7
    //   104: areturn
    //   105: astore 6
    //   107: goto +16 -> 123
    //   110: astore 5
    //   112: aconst_null
    //   113: astore 4
    //   115: goto +43 -> 158
    //   118: astore 6
    //   120: aconst_null
    //   121: astore 5
    //   123: aload 5
    //   125: astore 4
    //   127: aload_0
    //   128: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   131: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   134: ldc_w 1285
    //   137: aload 6
    //   139: invokevirtual 197	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   142: aload 5
    //   144: ifnull +29 -> 173
    //   147: aload 5
    //   149: invokeinterface 229 1 0
    //   154: aconst_null
    //   155: areturn
    //   156: astore 5
    //   158: aload 4
    //   160: ifnull +10 -> 170
    //   163: aload 4
    //   165: invokeinterface 229 1 0
    //   170: aload 5
    //   172: athrow
    //   173: aconst_null
    //   174: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	zzcay
    //   0	175	1	paramLong	long
    //   50	2	3	bool	boolean
    //   12	152	4	localObject1	Object
    //   37	45	5	localCursor1	Cursor
    //   110	1	5	localThrowable1	Throwable
    //   121	27	5	localObject2	Object
    //   156	15	5	localThrowable2	Throwable
    //   33	63	6	localCursor2	Cursor
    //   105	1	6	localSQLiteException1	SQLiteException
    //   118	20	6	localSQLiteException2	SQLiteException
    //   93	10	7	str	String
    // Exception table:
    //   from	to	target	type
    //   43	51	105	android/database/sqlite/SQLiteException
    //   59	72	105	android/database/sqlite/SQLiteException
    //   85	95	105	android/database/sqlite/SQLiteException
    //   8	14	110	java/lang/Throwable
    //   14	35	110	java/lang/Throwable
    //   8	14	118	android/database/sqlite/SQLiteException
    //   14	35	118	android/database/sqlite/SQLiteException
    //   43	51	156	java/lang/Throwable
    //   59	72	156	java/lang/Throwable
    //   85	95	156	java/lang/Throwable
    //   127	142	156	java/lang/Throwable
  }
  
  /* Error */
  public final List zziv(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   9: aload_0
    //   10: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   13: new 513	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 514	java/util/ArrayList:<init>	()V
    //   20: astore 10
    //   22: aload_0
    //   23: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 5
    //   28: invokestatic 709	com/google/android/android/internal/zzcax:zzavz	()I
    //   31: pop
    //   32: aload 5
    //   34: ldc_w 673
    //   37: iconst_4
    //   38: anewarray 322	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc_w 474
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc 27
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 659
    //   57: aastore
    //   58: dup
    //   59: iconst_3
    //   60: ldc_w 665
    //   63: aastore
    //   64: ldc_w 685
    //   67: iconst_1
    //   68: anewarray 322	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: aconst_null
    //   76: aconst_null
    //   77: ldc_w 711
    //   80: sipush 1000
    //   83: invokestatic 773	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   86: invokevirtual 716	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   89: astore 8
    //   91: aload 8
    //   93: astore 6
    //   95: aload 6
    //   97: astore 5
    //   99: aload 8
    //   101: invokeinterface 222 1 0
    //   106: istore_2
    //   107: iload_2
    //   108: ifne +13 -> 121
    //   111: aload 8
    //   113: invokeinterface 229 1 0
    //   118: aload 10
    //   120: areturn
    //   121: aload 6
    //   123: astore 5
    //   125: aload 8
    //   127: iconst_0
    //   128: invokeinterface 264 2 0
    //   133: astore 11
    //   135: aload 6
    //   137: astore 5
    //   139: aload 8
    //   141: iconst_1
    //   142: invokeinterface 264 2 0
    //   147: astore 9
    //   149: aload 9
    //   151: astore 7
    //   153: aload 9
    //   155: ifnonnull +8 -> 163
    //   158: ldc_w 1289
    //   161: astore 7
    //   163: aload 6
    //   165: astore 5
    //   167: aload 8
    //   169: iconst_2
    //   170: invokeinterface 226 2 0
    //   175: lstore_3
    //   176: aload 6
    //   178: astore 5
    //   180: aload_0
    //   181: aload 8
    //   183: iconst_3
    //   184: invokespecial 720	com/google/android/android/internal/zzcay:format	(Landroid/database/Cursor;I)Ljava/lang/Object;
    //   187: astore 9
    //   189: aload 9
    //   191: ifnonnull +27 -> 218
    //   194: aload 6
    //   196: astore 5
    //   198: aload_0
    //   199: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   202: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   205: ldc_w 1291
    //   208: aload_1
    //   209: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   212: invokevirtual 197	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   215: goto +30 -> 245
    //   218: aload 6
    //   220: astore 5
    //   222: aload 10
    //   224: new 626	com/google/android/android/internal/zzcfv
    //   227: dup
    //   228: aload_1
    //   229: aload 7
    //   231: aload 11
    //   233: lload_3
    //   234: aload 9
    //   236: invokespecial 725	com/google/android/android/internal/zzcfv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   239: invokeinterface 532 2 0
    //   244: pop
    //   245: aload 6
    //   247: astore 5
    //   249: aload 8
    //   251: invokeinterface 728 1 0
    //   256: istore_2
    //   257: iload_2
    //   258: ifne -137 -> 121
    //   261: aload 8
    //   263: invokeinterface 229 1 0
    //   268: aload 10
    //   270: areturn
    //   271: astore 7
    //   273: goto +15 -> 288
    //   276: astore_1
    //   277: aconst_null
    //   278: astore 5
    //   280: goto +46 -> 326
    //   283: astore 7
    //   285: aconst_null
    //   286: astore 6
    //   288: aload 6
    //   290: astore 5
    //   292: aload_0
    //   293: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   296: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   299: ldc_w 1293
    //   302: aload_1
    //   303: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   306: aload 7
    //   308: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   311: aload 6
    //   313: ifnull +30 -> 343
    //   316: aload 6
    //   318: invokeinterface 229 1 0
    //   323: aconst_null
    //   324: areturn
    //   325: astore_1
    //   326: aload 5
    //   328: ifnull +10 -> 338
    //   331: aload 5
    //   333: invokeinterface 229 1 0
    //   338: goto +3 -> 341
    //   341: aload_1
    //   342: athrow
    //   343: aconst_null
    //   344: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	zzcay
    //   0	345	1	paramString	String
    //   106	152	2	bool	boolean
    //   175	59	3	l	long
    //   26	306	5	localObject1	Object
    //   93	224	6	localCursor1	Cursor
    //   151	79	7	localObject2	Object
    //   271	1	7	localSQLiteException1	SQLiteException
    //   283	24	7	localSQLiteException2	SQLiteException
    //   89	173	8	localCursor2	Cursor
    //   147	88	9	localObject3	Object
    //   20	249	10	localArrayList	ArrayList
    //   133	99	11	str	String
    // Exception table:
    //   from	to	target	type
    //   99	107	271	android/database/sqlite/SQLiteException
    //   125	135	271	android/database/sqlite/SQLiteException
    //   139	149	271	android/database/sqlite/SQLiteException
    //   167	176	271	android/database/sqlite/SQLiteException
    //   180	189	271	android/database/sqlite/SQLiteException
    //   198	215	271	android/database/sqlite/SQLiteException
    //   222	245	271	android/database/sqlite/SQLiteException
    //   249	257	271	android/database/sqlite/SQLiteException
    //   22	28	276	java/lang/Throwable
    //   28	91	276	java/lang/Throwable
    //   22	28	283	android/database/sqlite/SQLiteException
    //   28	91	283	android/database/sqlite/SQLiteException
    //   99	107	325	java/lang/Throwable
    //   125	135	325	java/lang/Throwable
    //   139	149	325	java/lang/Throwable
    //   167	176	325	java/lang/Throwable
    //   180	189	325	java/lang/Throwable
    //   198	215	325	java/lang/Throwable
    //   222	245	325	java/lang/Throwable
    //   249	257	325	java/lang/Throwable
    //   292	311	325	java/lang/Throwable
  }
  
  /* Error */
  public final zzcar zziw(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   9: aload_0
    //   10: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   13: aload_0
    //   14: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 7
    //   19: iconst_1
    //   20: istore_3
    //   21: aload 7
    //   23: ldc_w 740
    //   26: bipush 23
    //   28: anewarray 322	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc_w 857
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc_w 862
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc_w 867
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc_w 872
    //   54: aastore
    //   55: dup
    //   56: iconst_4
    //   57: ldc 59
    //   59: aastore
    //   60: dup
    //   61: iconst_5
    //   62: ldc_w 881
    //   65: aastore
    //   66: dup
    //   67: bipush 6
    //   69: ldc 39
    //   71: aastore
    //   72: dup
    //   73: bipush 7
    //   75: ldc 43
    //   77: aastore
    //   78: dup
    //   79: bipush 8
    //   81: ldc 47
    //   83: aastore
    //   84: dup
    //   85: bipush 9
    //   87: ldc 51
    //   89: aastore
    //   90: dup
    //   91: bipush 10
    //   93: ldc 55
    //   95: aastore
    //   96: dup
    //   97: bipush 11
    //   99: ldc 63
    //   101: aastore
    //   102: dup
    //   103: bipush 12
    //   105: ldc 67
    //   107: aastore
    //   108: dup
    //   109: bipush 13
    //   111: ldc 71
    //   113: aastore
    //   114: dup
    //   115: bipush 14
    //   117: ldc 75
    //   119: aastore
    //   120: dup
    //   121: bipush 15
    //   123: ldc 83
    //   125: aastore
    //   126: dup
    //   127: bipush 16
    //   129: ldc 87
    //   131: aastore
    //   132: dup
    //   133: bipush 17
    //   135: ldc 91
    //   137: aastore
    //   138: dup
    //   139: bipush 18
    //   141: ldc 95
    //   143: aastore
    //   144: dup
    //   145: bipush 19
    //   147: ldc 99
    //   149: aastore
    //   150: dup
    //   151: bipush 20
    //   153: ldc 103
    //   155: aastore
    //   156: dup
    //   157: bipush 21
    //   159: ldc 107
    //   161: aastore
    //   162: dup
    //   163: bipush 22
    //   165: ldc 111
    //   167: aastore
    //   168: ldc_w 685
    //   171: iconst_1
    //   172: anewarray 322	java/lang/String
    //   175: dup
    //   176: iconst_0
    //   177: aload_1
    //   178: aastore
    //   179: aconst_null
    //   180: aconst_null
    //   181: aconst_null
    //   182: invokevirtual 480	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   185: astore 9
    //   187: aload 9
    //   189: astore 7
    //   191: aload 9
    //   193: invokeinterface 222 1 0
    //   198: istore 4
    //   200: iload 4
    //   202: ifne +12 -> 214
    //   205: aload 9
    //   207: invokeinterface 229 1 0
    //   212: aconst_null
    //   213: areturn
    //   214: aload_0
    //   215: getfield 1299	com/google/android/android/internal/zzcdt:zziki	Lcom/google/android/android/internal/zzccw;
    //   218: astore 10
    //   220: aload 7
    //   222: astore 8
    //   224: new 852	com/google/android/android/internal/zzcar
    //   227: dup
    //   228: aload 10
    //   230: aload_1
    //   231: invokespecial 1302	com/google/android/android/internal/zzcar:<init>	(Lcom/google/android/android/internal/zzccw;Ljava/lang/String;)V
    //   234: astore 10
    //   236: aload 7
    //   238: astore 8
    //   240: aload 10
    //   242: aload 9
    //   244: iconst_0
    //   245: invokeinterface 264 2 0
    //   250: invokevirtual 1305	com/google/android/android/internal/zzcar:zzim	(Ljava/lang/String;)V
    //   253: aload 7
    //   255: astore 8
    //   257: aload 10
    //   259: aload 9
    //   261: iconst_1
    //   262: invokeinterface 264 2 0
    //   267: invokevirtual 1308	com/google/android/android/internal/zzcar:zzin	(Ljava/lang/String;)V
    //   270: aload 7
    //   272: astore 8
    //   274: aload 10
    //   276: aload 9
    //   278: iconst_2
    //   279: invokeinterface 264 2 0
    //   284: invokevirtual 1311	com/google/android/android/internal/zzcar:zzio	(Ljava/lang/String;)V
    //   287: aload 7
    //   289: astore 8
    //   291: aload 10
    //   293: aload 9
    //   295: iconst_3
    //   296: invokeinterface 226 2 0
    //   301: invokevirtual 1314	com/google/android/android/internal/zzcar:zzaq	(J)V
    //   304: aload 7
    //   306: astore 8
    //   308: aload 10
    //   310: aload 9
    //   312: iconst_4
    //   313: invokeinterface 226 2 0
    //   318: invokevirtual 1316	com/google/android/android/internal/zzcar:zzal	(J)V
    //   321: aload 7
    //   323: astore 8
    //   325: aload 10
    //   327: aload 9
    //   329: iconst_5
    //   330: invokeinterface 226 2 0
    //   335: invokevirtual 1318	com/google/android/android/internal/zzcar:zzam	(J)V
    //   338: aload 7
    //   340: astore 8
    //   342: aload 10
    //   344: aload 9
    //   346: bipush 6
    //   348: invokeinterface 264 2 0
    //   353: invokevirtual 1321	com/google/android/android/internal/zzcar:setAppVersion	(Ljava/lang/String;)V
    //   356: aload 7
    //   358: astore 8
    //   360: aload 10
    //   362: aload 9
    //   364: bipush 7
    //   366: invokeinterface 264 2 0
    //   371: invokevirtual 1324	com/google/android/android/internal/zzcar:zziq	(Ljava/lang/String;)V
    //   374: aload 7
    //   376: astore 8
    //   378: aload 10
    //   380: aload 9
    //   382: bipush 8
    //   384: invokeinterface 226 2 0
    //   389: invokevirtual 1327	com/google/android/android/internal/zzcar:zzao	(J)V
    //   392: aload 7
    //   394: astore 8
    //   396: aload 10
    //   398: aload 9
    //   400: bipush 9
    //   402: invokeinterface 226 2 0
    //   407: invokevirtual 1330	com/google/android/android/internal/zzcar:zzap	(J)V
    //   410: aload 7
    //   412: astore 8
    //   414: aload 9
    //   416: bipush 10
    //   418: invokeinterface 1334 2 0
    //   423: istore 4
    //   425: iload 4
    //   427: ifeq +8 -> 435
    //   430: iconst_1
    //   431: istore_2
    //   432: goto +17 -> 449
    //   435: aload 7
    //   437: astore 8
    //   439: aload 9
    //   441: bipush 10
    //   443: invokeinterface 1062 2 0
    //   448: istore_2
    //   449: iload_2
    //   450: ifeq +6 -> 456
    //   453: goto +5 -> 458
    //   456: iconst_0
    //   457: istore_3
    //   458: aload 7
    //   460: astore 8
    //   462: aload 10
    //   464: iload_3
    //   465: invokevirtual 1337	com/google/android/android/internal/zzcar:setMeasurementEnabled	(Z)V
    //   468: aload 7
    //   470: astore 8
    //   472: aload 10
    //   474: aload 9
    //   476: bipush 11
    //   478: invokeinterface 226 2 0
    //   483: invokevirtual 1340	com/google/android/android/internal/zzcar:zzat	(J)V
    //   486: aload 7
    //   488: astore 8
    //   490: aload 10
    //   492: aload 9
    //   494: bipush 12
    //   496: invokeinterface 226 2 0
    //   501: invokevirtual 1343	com/google/android/android/internal/zzcar:zzau	(J)V
    //   504: aload 7
    //   506: astore 8
    //   508: aload 10
    //   510: aload 9
    //   512: bipush 13
    //   514: invokeinterface 226 2 0
    //   519: invokevirtual 1346	com/google/android/android/internal/zzcar:zzav	(J)V
    //   522: aload 7
    //   524: astore 8
    //   526: aload 10
    //   528: aload 9
    //   530: bipush 14
    //   532: invokeinterface 226 2 0
    //   537: invokevirtual 1349	com/google/android/android/internal/zzcar:zzaw	(J)V
    //   540: aload 7
    //   542: astore 8
    //   544: aload 10
    //   546: aload 9
    //   548: bipush 15
    //   550: invokeinterface 226 2 0
    //   555: invokevirtual 1352	com/google/android/android/internal/zzcar:zzar	(J)V
    //   558: aload 7
    //   560: astore 8
    //   562: aload 10
    //   564: aload 9
    //   566: bipush 16
    //   568: invokeinterface 226 2 0
    //   573: invokevirtual 1355	com/google/android/android/internal/zzcar:zzas	(J)V
    //   576: aload 7
    //   578: astore 8
    //   580: aload 9
    //   582: bipush 17
    //   584: invokeinterface 1334 2 0
    //   589: istore_3
    //   590: iload_3
    //   591: ifeq +11 -> 602
    //   594: ldc2_w 1356
    //   597: lstore 5
    //   599: goto +21 -> 620
    //   602: aload 7
    //   604: astore 8
    //   606: aload 9
    //   608: bipush 17
    //   610: invokeinterface 1062 2 0
    //   615: istore_2
    //   616: iload_2
    //   617: i2l
    //   618: lstore 5
    //   620: aload 7
    //   622: astore 8
    //   624: aload 10
    //   626: lload 5
    //   628: invokevirtual 1360	com/google/android/android/internal/zzcar:zzan	(J)V
    //   631: aload 7
    //   633: astore 8
    //   635: aload 10
    //   637: aload 9
    //   639: bipush 18
    //   641: invokeinterface 264 2 0
    //   646: invokevirtual 1363	com/google/android/android/internal/zzcar:zzip	(Ljava/lang/String;)V
    //   649: aload 7
    //   651: astore 8
    //   653: aload 10
    //   655: aload 9
    //   657: bipush 19
    //   659: invokeinterface 226 2 0
    //   664: invokevirtual 1366	com/google/android/android/internal/zzcar:zzay	(J)V
    //   667: aload 7
    //   669: astore 8
    //   671: aload 10
    //   673: aload 9
    //   675: bipush 20
    //   677: invokeinterface 226 2 0
    //   682: invokevirtual 1369	com/google/android/android/internal/zzcar:zzax	(J)V
    //   685: aload 7
    //   687: astore 8
    //   689: aload 10
    //   691: aload 9
    //   693: bipush 21
    //   695: invokeinterface 264 2 0
    //   700: invokevirtual 1372	com/google/android/android/internal/zzcar:zzir	(Ljava/lang/String;)V
    //   703: aload 7
    //   705: astore 8
    //   707: aload 9
    //   709: bipush 22
    //   711: invokeinterface 1334 2 0
    //   716: istore_3
    //   717: iload_3
    //   718: ifeq +9 -> 727
    //   721: lconst_0
    //   722: lstore 5
    //   724: goto +18 -> 742
    //   727: aload 7
    //   729: astore 8
    //   731: aload 9
    //   733: bipush 22
    //   735: invokeinterface 226 2 0
    //   740: lstore 5
    //   742: aload 7
    //   744: astore 8
    //   746: aload 10
    //   748: lload 5
    //   750: invokevirtual 1375	com/google/android/android/internal/zzcar:zzaz	(J)V
    //   753: aload 7
    //   755: astore 8
    //   757: aload 10
    //   759: invokevirtual 1378	com/google/android/android/internal/zzcar:zzauo	()V
    //   762: aload 7
    //   764: astore 8
    //   766: aload 9
    //   768: invokeinterface 728 1 0
    //   773: istore_3
    //   774: iload_3
    //   775: ifeq +24 -> 799
    //   778: aload 7
    //   780: astore 8
    //   782: aload_0
    //   783: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   786: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   789: ldc_w 1380
    //   792: aload_1
    //   793: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   796: invokevirtual 197	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   799: aload 9
    //   801: invokeinterface 229 1 0
    //   806: aload 10
    //   808: areturn
    //   809: astore 9
    //   811: goto +24 -> 835
    //   814: astore_1
    //   815: goto +62 -> 877
    //   818: astore 9
    //   820: goto +15 -> 835
    //   823: astore_1
    //   824: aconst_null
    //   825: astore 7
    //   827: goto +50 -> 877
    //   830: astore 9
    //   832: aconst_null
    //   833: astore 7
    //   835: aload 7
    //   837: astore 8
    //   839: aload_0
    //   840: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   843: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   846: ldc_w 1382
    //   849: aload_1
    //   850: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   853: aload 9
    //   855: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   858: aload 7
    //   860: ifnull +31 -> 891
    //   863: aload 7
    //   865: invokeinterface 229 1 0
    //   870: aconst_null
    //   871: areturn
    //   872: astore_1
    //   873: aload 8
    //   875: astore 7
    //   877: aload 7
    //   879: ifnull +10 -> 889
    //   882: aload 7
    //   884: invokeinterface 229 1 0
    //   889: aload_1
    //   890: athrow
    //   891: aconst_null
    //   892: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	893	0	this	zzcay
    //   0	893	1	paramString	String
    //   431	186	2	i	int
    //   20	755	3	bool1	boolean
    //   198	228	4	bool2	boolean
    //   597	152	5	l	long
    //   17	866	7	localObject1	Object
    //   222	652	8	localObject2	Object
    //   185	615	9	localCursor	Cursor
    //   809	1	9	localSQLiteException1	SQLiteException
    //   818	1	9	localSQLiteException2	SQLiteException
    //   830	24	9	localSQLiteException3	SQLiteException
    //   218	589	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   224	236	809	android/database/sqlite/SQLiteException
    //   240	253	809	android/database/sqlite/SQLiteException
    //   257	270	809	android/database/sqlite/SQLiteException
    //   274	287	809	android/database/sqlite/SQLiteException
    //   291	304	809	android/database/sqlite/SQLiteException
    //   308	321	809	android/database/sqlite/SQLiteException
    //   325	338	809	android/database/sqlite/SQLiteException
    //   342	356	809	android/database/sqlite/SQLiteException
    //   360	374	809	android/database/sqlite/SQLiteException
    //   378	392	809	android/database/sqlite/SQLiteException
    //   396	410	809	android/database/sqlite/SQLiteException
    //   414	425	809	android/database/sqlite/SQLiteException
    //   439	449	809	android/database/sqlite/SQLiteException
    //   462	468	809	android/database/sqlite/SQLiteException
    //   472	486	809	android/database/sqlite/SQLiteException
    //   490	504	809	android/database/sqlite/SQLiteException
    //   508	522	809	android/database/sqlite/SQLiteException
    //   526	540	809	android/database/sqlite/SQLiteException
    //   544	558	809	android/database/sqlite/SQLiteException
    //   562	576	809	android/database/sqlite/SQLiteException
    //   580	590	809	android/database/sqlite/SQLiteException
    //   606	616	809	android/database/sqlite/SQLiteException
    //   624	631	809	android/database/sqlite/SQLiteException
    //   635	649	809	android/database/sqlite/SQLiteException
    //   653	667	809	android/database/sqlite/SQLiteException
    //   671	685	809	android/database/sqlite/SQLiteException
    //   689	703	809	android/database/sqlite/SQLiteException
    //   707	717	809	android/database/sqlite/SQLiteException
    //   731	742	809	android/database/sqlite/SQLiteException
    //   746	753	809	android/database/sqlite/SQLiteException
    //   757	762	809	android/database/sqlite/SQLiteException
    //   766	774	809	android/database/sqlite/SQLiteException
    //   782	799	809	android/database/sqlite/SQLiteException
    //   191	200	814	java/lang/Throwable
    //   191	200	818	android/database/sqlite/SQLiteException
    //   13	19	823	java/lang/Throwable
    //   21	187	823	java/lang/Throwable
    //   13	19	830	android/database/sqlite/SQLiteException
    //   21	187	830	android/database/sqlite/SQLiteException
    //   224	236	872	java/lang/Throwable
    //   240	253	872	java/lang/Throwable
    //   257	270	872	java/lang/Throwable
    //   274	287	872	java/lang/Throwable
    //   291	304	872	java/lang/Throwable
    //   308	321	872	java/lang/Throwable
    //   325	338	872	java/lang/Throwable
    //   342	356	872	java/lang/Throwable
    //   360	374	872	java/lang/Throwable
    //   378	392	872	java/lang/Throwable
    //   396	410	872	java/lang/Throwable
    //   414	425	872	java/lang/Throwable
    //   439	449	872	java/lang/Throwable
    //   462	468	872	java/lang/Throwable
    //   472	486	872	java/lang/Throwable
    //   490	504	872	java/lang/Throwable
    //   508	522	872	java/lang/Throwable
    //   526	540	872	java/lang/Throwable
    //   544	558	872	java/lang/Throwable
    //   562	576	872	java/lang/Throwable
    //   580	590	872	java/lang/Throwable
    //   606	616	872	java/lang/Throwable
    //   624	631	872	java/lang/Throwable
    //   635	649	872	java/lang/Throwable
    //   653	667	872	java/lang/Throwable
    //   671	685	872	java/lang/Throwable
    //   689	703	872	java/lang/Throwable
    //   707	717	872	java/lang/Throwable
    //   731	742	872	java/lang/Throwable
    //   746	753	872	java/lang/Throwable
    //   757	762	872	java/lang/Throwable
    //   766	774	872	java/lang/Throwable
    //   782	799	872	java/lang/Throwable
    //   839	858	872	java/lang/Throwable
  }
  
  public final long zzix(String paramString)
  {
    zzbp.zzgg(paramString);
    zzuj();
    zzwk();
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      zzcax localZzcax = zzaun();
      zzcbn localZzcbn = zzcbm.zzioq;
      int i = Math.max(0, Math.min(1000000, localZzcax.next(paramString, localZzcbn)));
      i = localSQLiteDatabase.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[] { paramString, String.valueOf(i) });
      return i;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzaul().zzayd().append("Error deleting over the limit events. appId", zzcbw.zzjf(paramString), localSQLiteException);
    }
    return 0L;
  }
  
  /* Error */
  public final byte[] zziy(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   9: aload_0
    //   10: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   13: aload_0
    //   14: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore_3
    //   18: aload_3
    //   19: ldc_w 740
    //   22: iconst_1
    //   23: anewarray 322	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: ldc 79
    //   30: aastore
    //   31: ldc_w 685
    //   34: iconst_1
    //   35: anewarray 322	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aastore
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 480	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 5
    //   50: aload 5
    //   52: astore 4
    //   54: aload 4
    //   56: astore_3
    //   57: aload 5
    //   59: invokeinterface 222 1 0
    //   64: istore_2
    //   65: iload_2
    //   66: ifne +12 -> 78
    //   69: aload 5
    //   71: invokeinterface 229 1 0
    //   76: aconst_null
    //   77: areturn
    //   78: aload 4
    //   80: astore_3
    //   81: aload 5
    //   83: iconst_0
    //   84: invokeinterface 781 2 0
    //   89: astore 6
    //   91: aload 4
    //   93: astore_3
    //   94: aload 5
    //   96: invokeinterface 728 1 0
    //   101: istore_2
    //   102: iload_2
    //   103: ifeq +23 -> 126
    //   106: aload 4
    //   108: astore_3
    //   109: aload_0
    //   110: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   113: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   116: ldc_w 1396
    //   119: aload_1
    //   120: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   123: invokevirtual 197	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   126: aload 5
    //   128: invokeinterface 229 1 0
    //   133: aload 6
    //   135: areturn
    //   136: astore 5
    //   138: goto +14 -> 152
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_3
    //   144: goto +45 -> 189
    //   147: astore 5
    //   149: aconst_null
    //   150: astore 4
    //   152: aload 4
    //   154: astore_3
    //   155: aload_0
    //   156: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   159: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   162: ldc_w 1398
    //   165: aload_1
    //   166: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   169: aload 5
    //   171: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   174: aload 4
    //   176: ifnull +25 -> 201
    //   179: aload 4
    //   181: invokeinterface 229 1 0
    //   186: aconst_null
    //   187: areturn
    //   188: astore_1
    //   189: aload_3
    //   190: ifnull +9 -> 199
    //   193: aload_3
    //   194: invokeinterface 229 1 0
    //   199: aload_1
    //   200: athrow
    //   201: aconst_null
    //   202: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	zzcay
    //   0	203	1	paramString	String
    //   64	39	2	bool	boolean
    //   17	177	3	localObject	Object
    //   52	128	4	localCursor1	Cursor
    //   48	79	5	localCursor2	Cursor
    //   136	1	5	localSQLiteException1	SQLiteException
    //   147	23	5	localSQLiteException2	SQLiteException
    //   89	45	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   57	65	136	android/database/sqlite/SQLiteException
    //   81	91	136	android/database/sqlite/SQLiteException
    //   94	102	136	android/database/sqlite/SQLiteException
    //   109	126	136	android/database/sqlite/SQLiteException
    //   13	18	141	java/lang/Throwable
    //   18	50	141	java/lang/Throwable
    //   13	18	147	android/database/sqlite/SQLiteException
    //   18	50	147	android/database/sqlite/SQLiteException
    //   57	65	188	java/lang/Throwable
    //   81	91	188	java/lang/Throwable
    //   94	102	188	java/lang/Throwable
    //   109	126	188	java/lang/Throwable
    //   155	174	188	java/lang/Throwable
  }
  
  /* Error */
  public final Map zziz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 368	com/google/android/android/internal/zzcdu:zzwk	()V
    //   4: aload_0
    //   5: invokevirtual 371	com/google/android/android/internal/zzcdt:zzuj	()V
    //   8: aload_1
    //   9: invokestatic 317	com/google/android/android/common/internal/zzbp:zzgg	(Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual 212	com/google/android/android/internal/zzcay:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 5
    //   19: aload 5
    //   21: ldc_w 544
    //   24: iconst_2
    //   25: anewarray 322	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc_w 424
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc_w 1402
    //   39: aastore
    //   40: ldc_w 685
    //   43: iconst_1
    //   44: anewarray 322	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: aastore
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: invokevirtual 480	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore 7
    //   59: aload 7
    //   61: astore 6
    //   63: aload 6
    //   65: astore 5
    //   67: aload 7
    //   69: invokeinterface 222 1 0
    //   74: istore 4
    //   76: iload 4
    //   78: ifne +12 -> 90
    //   81: aload 7
    //   83: invokeinterface 229 1 0
    //   88: aconst_null
    //   89: areturn
    //   90: aload 6
    //   92: astore 5
    //   94: new 19	support/android/v4/util/ArrayMap
    //   97: dup
    //   98: invokespecial 1403	support/android/v4/util/ArrayMap:<init>	()V
    //   101: astore 8
    //   103: aload 6
    //   105: astore 5
    //   107: aload 7
    //   109: iconst_0
    //   110: invokeinterface 1062 2 0
    //   115: istore_2
    //   116: aload 6
    //   118: astore 5
    //   120: aload 7
    //   122: iconst_1
    //   123: invokeinterface 781 2 0
    //   128: astore 9
    //   130: aload 6
    //   132: astore 5
    //   134: aload 9
    //   136: arraylength
    //   137: istore_3
    //   138: aload 6
    //   140: astore 5
    //   142: aload 9
    //   144: iconst_0
    //   145: iload_3
    //   146: invokestatic 795	com/google/android/android/internal/zzeye:getBlob	([BII)Lcom/google/android/android/internal/zzeye;
    //   149: astore 9
    //   151: aload 6
    //   153: astore 5
    //   155: new 1405	com/google/android/android/internal/zzcgl
    //   158: dup
    //   159: invokespecial 1406	com/google/android/android/internal/zzcgl:<init>	()V
    //   162: astore 10
    //   164: aload 6
    //   166: astore 5
    //   168: aload 10
    //   170: aload 9
    //   172: invokevirtual 1407	com/google/android/android/internal/zzcgl:digest	(Lcom/google/android/android/internal/zzeye;)Lcom/google/android/android/internal/zzeyn;
    //   175: pop
    //   176: aload 6
    //   178: astore 5
    //   180: aload 8
    //   182: iload_2
    //   183: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aload 10
    //   188: invokeinterface 35 3 0
    //   193: pop
    //   194: goto +32 -> 226
    //   197: astore 9
    //   199: aload 6
    //   201: astore 5
    //   203: aload_0
    //   204: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   207: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   210: ldc_w 1409
    //   213: aload_1
    //   214: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   217: iload_2
    //   218: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aload 9
    //   223: invokevirtual 400	com/google/android/android/internal/zzcby:attribute	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   226: aload 6
    //   228: astore 5
    //   230: aload 7
    //   232: invokeinterface 728 1 0
    //   237: istore 4
    //   239: iload 4
    //   241: ifne -138 -> 103
    //   244: aload 7
    //   246: invokeinterface 229 1 0
    //   251: aload 8
    //   253: areturn
    //   254: astore 7
    //   256: goto +15 -> 271
    //   259: astore_1
    //   260: aconst_null
    //   261: astore 5
    //   263: goto +46 -> 309
    //   266: astore 7
    //   268: aconst_null
    //   269: astore 6
    //   271: aload 6
    //   273: astore 5
    //   275: aload_0
    //   276: invokevirtual 236	com/google/android/android/internal/zzcdt:zzaul	()Lcom/google/android/android/internal/zzcbw;
    //   279: invokevirtual 189	com/google/android/android/internal/zzcbw:zzayd	()Lcom/google/android/android/internal/zzcby;
    //   282: ldc_w 1411
    //   285: aload_1
    //   286: invokestatic 389	com/google/android/android/internal/zzcbw:zzjf	(Ljava/lang/String;)Ljava/lang/Object;
    //   289: aload 7
    //   291: invokevirtual 241	com/google/android/android/internal/zzcby:append	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   294: aload 6
    //   296: ifnull +30 -> 326
    //   299: aload 6
    //   301: invokeinterface 229 1 0
    //   306: aconst_null
    //   307: areturn
    //   308: astore_1
    //   309: aload 5
    //   311: ifnull +10 -> 321
    //   314: aload 5
    //   316: invokeinterface 229 1 0
    //   321: goto +3 -> 324
    //   324: aload_1
    //   325: athrow
    //   326: aconst_null
    //   327: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	zzcay
    //   0	328	1	paramString	String
    //   115	103	2	i	int
    //   137	9	3	j	int
    //   74	166	4	bool	boolean
    //   17	298	5	localObject1	Object
    //   61	239	6	localCursor1	Cursor
    //   57	188	7	localCursor2	Cursor
    //   254	1	7	localSQLiteException1	SQLiteException
    //   266	24	7	localSQLiteException2	SQLiteException
    //   101	151	8	localArrayMap	ArrayMap
    //   128	43	9	localObject2	Object
    //   197	25	9	localIOException	IOException
    //   162	25	10	localZzcgl	zzcgl
    // Exception table:
    //   from	to	target	type
    //   168	176	197	java/io/IOException
    //   67	76	254	android/database/sqlite/SQLiteException
    //   94	103	254	android/database/sqlite/SQLiteException
    //   107	116	254	android/database/sqlite/SQLiteException
    //   120	130	254	android/database/sqlite/SQLiteException
    //   142	151	254	android/database/sqlite/SQLiteException
    //   155	164	254	android/database/sqlite/SQLiteException
    //   168	176	254	android/database/sqlite/SQLiteException
    //   180	194	254	android/database/sqlite/SQLiteException
    //   203	226	254	android/database/sqlite/SQLiteException
    //   230	239	254	android/database/sqlite/SQLiteException
    //   19	59	259	java/lang/Throwable
    //   19	59	266	android/database/sqlite/SQLiteException
    //   67	76	308	java/lang/Throwable
    //   94	103	308	java/lang/Throwable
    //   107	116	308	java/lang/Throwable
    //   120	130	308	java/lang/Throwable
    //   134	138	308	java/lang/Throwable
    //   142	151	308	java/lang/Throwable
    //   155	164	308	java/lang/Throwable
    //   168	176	308	java/lang/Throwable
    //   180	194	308	java/lang/Throwable
    //   203	226	308	java/lang/Throwable
    //   230	239	308	java/lang/Throwable
    //   275	294	308	java/lang/Throwable
  }
  
  public final long zzja(String paramString)
  {
    zzbp.zzgg(paramString);
    return count("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[] { paramString }, 0L);
  }
  
  public final void zzuk() {}
}
