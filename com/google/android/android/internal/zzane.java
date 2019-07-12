package com.google.android.android.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public final class zzane
  extends SQLiteOpenHelper
{
  public zzane(zzand paramZzand, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public static void execute(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = get(paramSQLiteDatabase, "properties");
    int i = 0;
    while (i < 6)
    {
      String str = new String[] { "app_uid", "cid", "tid", "params", "adid", "hits_count" }[i];
      if (!paramSQLiteDatabase.remove(str))
      {
        paramSQLiteDatabase = String.valueOf(str);
        if (paramSQLiteDatabase.length() != 0) {
          paramSQLiteDatabase = "Database properties is missing required column: ".concat(paramSQLiteDatabase);
        } else {
          paramSQLiteDatabase = new String("Database properties is missing required column: ");
        }
        throw new SQLiteException(paramSQLiteDatabase);
      }
      i += 1;
    }
    if (paramSQLiteDatabase.isEmpty()) {
      return;
    }
    paramSQLiteDatabase = new SQLiteException("Database properties table has extra columns");
    throw paramSQLiteDatabase;
  }
  
  public static Set get(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    HashSet localHashSet = new HashSet();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(StringBuilder.append(StringBuilder.append(paramString, 22), "SELECT * FROM ", paramString, " LIMIT 0"), null);
    try
    {
      paramString = paramSQLiteDatabase.getColumnNames();
      int i = 0;
      for (;;)
      {
        int j = paramString.length;
        if (i >= j) {
          break;
        }
        localHashSet.add(paramString[i]);
        i += 1;
      }
      paramSQLiteDatabase.close();
      return localHashSet;
    }
    catch (Throwable paramString)
    {
      paramSQLiteDatabase.close();
      throw paramString;
    }
  }
  
  private final boolean tableExists(SQLiteDatabase paramSQLiteDatabase, String paramString)
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
    catch (Throwable paramSQLiteDatabase) {}catch (SQLiteException paramSQLiteDatabase)
    {
      localSQLiteDatabase1 = localSQLiteDatabase2;
      zzdpo.append("Error querying for table", paramString, paramSQLiteDatabase);
      if (localSQLiteDatabase2 == null) {
        break label105;
      }
    }
    localSQLiteDatabase2.close();
    return false;
    if (localSQLiteDatabase1 != null) {
      localSQLiteDatabase1.close();
    }
    throw paramSQLiteDatabase;
    label105:
    return false;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    if (zzand.getSpans(zzdpo).calculate(3600000L)) {}
    try
    {
      localObject = super.getWritableDatabase();
      return localObject;
    }
    catch (SQLiteException localSQLiteException2)
    {
      Object localObject;
      for (;;) {}
    }
    zzand.getSpans(zzdpo).start();
    zzdpo.zzdq("Opening the database failed, dropping the table and recreating it");
    localObject = zzand.getVersion(zzdpo);
    zzdpo.getContext().getDatabasePath((String)localObject).delete();
    try
    {
      localObject = super.getWritableDatabase();
      zzand localZzand = zzdpo;
      zzand.getSpans(localZzand).clear();
      return localObject;
    }
    catch (SQLiteException localSQLiteException1)
    {
      zzdpo.toString("Failed to open freshly created database", localSQLiteException1);
      throw localSQLiteException1;
    }
    throw new SQLiteException("Database open failed");
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.getPath();
    if (zzaoc.version() >= 9)
    {
      paramSQLiteDatabase = new File(paramSQLiteDatabase);
      paramSQLiteDatabase.setReadable(false, false);
      paramSQLiteDatabase.setWritable(false, false);
      paramSQLiteDatabase.setReadable(true, true);
      paramSQLiteDatabase.setWritable(true, true);
    }
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = Build.VERSION.SDK_INT;
    if (!tableExists(paramSQLiteDatabase, "hits2")) {}
    for (Object localObject = zzand.zzdpj;; localObject = "ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER")
    {
      paramSQLiteDatabase.execSQL((String)localObject);
      break;
      localObject = get(paramSQLiteDatabase, "hits2");
      i = 0;
      while (i < 4)
      {
        String str = new String[] { "hit_id", "hit_string", "hit_time", "hit_url" }[i];
        if (!((Set)localObject).remove(str))
        {
          paramSQLiteDatabase = String.valueOf(str);
          if (paramSQLiteDatabase.length() != 0) {
            paramSQLiteDatabase = "Database hits2 is missing required column: ".concat(paramSQLiteDatabase);
          } else {
            paramSQLiteDatabase = new String("Database hits2 is missing required column: ");
          }
          throw new SQLiteException(paramSQLiteDatabase);
        }
        i += 1;
      }
      boolean bool = ((Set)localObject).remove("hit_app_id");
      if (!((Set)localObject).isEmpty()) {
        break label187;
      }
      if (!(bool ^ true)) {
        break;
      }
    }
    if (!tableExists(paramSQLiteDatabase, "properties"))
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
      return;
    }
    execute(paramSQLiteDatabase);
    return;
    label187:
    paramSQLiteDatabase = new SQLiteException("Database hits2 has extra columns");
    throw paramSQLiteDatabase;
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}
