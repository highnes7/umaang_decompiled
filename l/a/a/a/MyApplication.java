package l.a.a.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

public class MyApplication
  extends ContextWrapper
{
  public final String TAG;
  public final String context;
  
  public MyApplication(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    TAG = paramString1;
    context = paramString2;
  }
  
  public File getCacheDir()
  {
    return new File(super.getCacheDir(), context);
  }
  
  public File getDatabasePath(String paramString)
  {
    File localFile = new File(super.getDatabasePath(paramString).getParentFile(), context);
    localFile.mkdirs();
    return new File(localFile, paramString);
  }
  
  public File getExternalCacheDir()
  {
    return new File(super.getExternalCacheDir(), context);
  }
  
  public File getExternalFilesDir(String paramString)
  {
    return new File(super.getExternalFilesDir(paramString), context);
  }
  
  public File getFilesDir()
  {
    return new File(super.getFilesDir(), context);
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return super.getSharedPreferences(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), TAG, ":", paramString), paramInt);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString), paramCursorFactory);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(paramString).getPath(), paramCursorFactory, paramDatabaseErrorHandler);
  }
}
