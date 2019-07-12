package com.google.android.android.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.io.File;

@TargetApi(11)
public final class zzcbt
  extends SQLiteOpenHelper
{
  public zzcbt(zzcbs paramZzcbs, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException1)
    {
      int i = Build.VERSION.SDK_INT;
      if (!(localSQLiteException1 instanceof SQLiteDatabaseLockedException))
      {
        zzipn.zzaul().zzayd().append("Opening the local database failed, dropping and recreating it");
        Object localObject = zzcax.zzawj();
        if (!zzipn.getContext().getDatabasePath((String)localObject).delete()) {
          zzipn.zzaul().zzayd().append("Failed to delete corrupted local db file", localObject);
        }
        try
        {
          localObject = super.getWritableDatabase();
          return localObject;
        }
        catch (SQLiteException localSQLiteException2)
        {
          zzipn.zzaul().zzayd().append("Failed to open local database. Events will bypass local storage", localSQLiteException2);
          return null;
        }
      }
      throw localSQLiteException2;
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    zzcay.saveBitmap(zzipn.zzaul(), paramSQLiteDatabase);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = Build.VERSION.SDK_INT;
    zzcay.addColumn(zzipn.zzaul(), paramSQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}
