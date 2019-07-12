package com.google.android.android.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.android.common.util.Log;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public final class zzee
  extends SQLiteOpenHelper
{
  public boolean zzjte;
  public long zzjtf = 0L;
  
  public zzee(zzec paramZzec, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public static boolean tableExists(String paramString, SQLiteDatabase paramSQLiteDatabase)
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
    catch (Throwable paramString)
    {
      break label138;
      localSQLiteDatabase1 = localSQLiteDatabase2;
      paramString = String.valueOf(paramString);
      localSQLiteDatabase1 = localSQLiteDatabase2;
      int i = paramString.length();
      if (i != 0)
      {
        localSQLiteDatabase1 = localSQLiteDatabase2;
        paramString = "Error querying for table ".concat(paramString);
      }
      else
      {
        localSQLiteDatabase1 = localSQLiteDatabase2;
        paramString = new String("Error querying for table ");
      }
      localSQLiteDatabase1 = localSQLiteDatabase2;
      zzdj.zzjss.zzcr(paramString);
      if (localSQLiteDatabase2 != null)
      {
        localSQLiteDatabase2.close();
        return false;
        if (localSQLiteDatabase1 != null) {
          localSQLiteDatabase1.close();
        }
        throw paramString;
      }
    }
    catch (SQLiteException paramSQLiteDatabase)
    {
      label138:
      for (;;) {}
    }
    return false;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    if ((zzjte) && (zzjtf + 3600000L > zzec.openDatabase(zzjtd).currentTimeMillis())) {
      throw new SQLiteException("Database creation failed");
    }
    Object localObject1 = null;
    zzjte = true;
    zzjtf = zzec.openDatabase(zzjtd).currentTimeMillis();
    try
    {
      localObject2 = super.getWritableDatabase();
      localObject1 = localObject2;
    }
    catch (SQLiteException localSQLiteException)
    {
      Object localObject2;
      for (;;) {}
    }
    zzec.access$getMContext(zzjtd).getDatabasePath(zzec.exportToFile(zzjtd)).delete();
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = super.getWritableDatabase();
    }
    zzjte = false;
    return localObject2;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    zzbs.zzlr(paramSQLiteDatabase.getPath());
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = Build.VERSION.SDK_INT;
    if (!tableExists("gtm_hits", paramSQLiteDatabase))
    {
      paramSQLiteDatabase.execSQL(zzec.zzdpj);
      return;
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
    HashSet localHashSet = new HashSet();
    try
    {
      String[] arrayOfString = paramSQLiteDatabase.getColumnNames();
      i = 0;
      for (;;)
      {
        int j = arrayOfString.length;
        if (i >= j) {
          break;
        }
        localHashSet.add(arrayOfString[i]);
        i += 1;
      }
      paramSQLiteDatabase.close();
      if ((localHashSet.remove("hit_id")) && (localHashSet.remove("hit_url")) && (localHashSet.remove("hit_time")) && (localHashSet.remove("hit_first_send_time")))
      {
        if (localHashSet.isEmpty()) {
          return;
        }
        throw new SQLiteException("Database has extra columns");
      }
      throw new SQLiteException("Database column missing");
    }
    catch (Throwable localThrowable)
    {
      paramSQLiteDatabase.close();
      throw localThrowable;
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}
