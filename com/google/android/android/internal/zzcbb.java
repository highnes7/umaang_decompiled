package com.google.android.android.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.io.File;

public final class zzcbb
  extends SQLiteOpenHelper
{
  public zzcbb(zzcay paramZzcay, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    Object localObject = zzcay.getSpans(zzind);
    zzcax.zzawe();
    if (((zzcfq)localObject).start(3600000L)) {}
    try
    {
      localObject = super.getWritableDatabase();
      return localObject;
    }
    catch (SQLiteException localSQLiteException2)
    {
      for (;;) {}
    }
    zzcay.getSpans(zzind).start();
    zzind.zzaul().zzayd().append("Opening the database failed, dropping and recreating it");
    localObject = zzcax.zzawi();
    if (!zzind.getContext().getDatabasePath((String)localObject).delete()) {
      zzind.zzaul().zzayd().append("Failed to delete corrupted db file", localObject);
    }
    try
    {
      localObject = super.getWritableDatabase();
      zzcay localZzcay = zzind;
      zzcay.getSpans(localZzcay).clear();
      return localObject;
    }
    catch (SQLiteException localSQLiteException1)
    {
      zzind.zzaul().zzayd().append("Failed to open freshly created database", localSQLiteException1);
      throw localSQLiteException1;
    }
    throw new SQLiteException("Database open failed");
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    zzcay.saveBitmap(zzind.zzaul(), paramSQLiteDatabase);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = Build.VERSION.SDK_INT;
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzcay.zzimr);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzcay.zzims);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzcay.zzimu);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzcay.zzimt);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
    zzcay.addColumn(zzind.zzaul(), paramSQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzcay.zzimv);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}
