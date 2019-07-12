package com.google.android.android.internal;

public final class zzcbm
{
  public static com.google.android.gms.internal.zzcbn<Boolean> zzint = zzcbn.init("measurement.service_enabled", true, true);
  public static com.google.android.gms.internal.zzcbn<Boolean> zzinu = zzcbn.init("measurement.service_client_enabled", true, true);
  public static com.google.android.gms.internal.zzcbn<Boolean> zzinv = zzcbn.init("measurement.log_third_party_store_events_enabled", false, false);
  public static com.google.android.gms.internal.zzcbn<Boolean> zzinw = zzcbn.init("measurement.log_installs_enabled", false, false);
  public static com.google.android.gms.internal.zzcbn<Boolean> zzinx = zzcbn.init("measurement.log_upgrades_enabled", false, false);
  public static com.google.android.gms.internal.zzcbn<Boolean> zziny = zzcbn.init("measurement.log_androidId_enabled", false, false);
  public static com.google.android.gms.internal.zzcbn<Boolean> zzinz = zzcbn.init("measurement.upload_dsid_enabled", false, false);
  public static com.google.android.gms.internal.zzcbn<Boolean> zzioa = zzcbn.init("measurement.event_sampling_enabled", false, false);
  public static com.google.android.gms.internal.zzcbn<String> zziob = zzcbn.register("measurement.log_tag", "FA", "FA-SVC");
  public static com.google.android.gms.internal.zzcbn<Long> zzioc = zzcbn.start("measurement.ad_id_cache_time", 10000L, 10000L);
  public static com.google.android.gms.internal.zzcbn<Long> zziod = zzcbn.start("measurement.monitoring.sample_period_millis", 86400000L, 86400000L);
  public static com.google.android.gms.internal.zzcbn<Long> zzioe = zzcbn.start("measurement.config.cache_time", 86400000L, 3600000L);
  public static com.google.android.gms.internal.zzcbn<String> zziof = zzcbn.register("measurement.config.url_scheme", "https", "https");
  public static com.google.android.gms.internal.zzcbn<String> zziog = zzcbn.register("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
  public static com.google.android.gms.internal.zzcbn<Integer> zzioh = zzcbn.string("measurement.upload.max_bundles", 100, 100);
  public static com.google.android.gms.internal.zzcbn<Integer> zzioi = zzcbn.string("measurement.upload.max_batch_size", 65536, 65536);
  public static com.google.android.gms.internal.zzcbn<Integer> zzioj = zzcbn.string("measurement.upload.max_bundle_size", 65536, 65536);
  public static com.google.android.gms.internal.zzcbn<Integer> zziok = zzcbn.string("measurement.upload.max_events_per_bundle", 1000, 1000);
  public static com.google.android.gms.internal.zzcbn<Integer> zziol = zzcbn.string("measurement.upload.max_events_per_day", 100000, 100000);
  public static com.google.android.gms.internal.zzcbn<Integer> zziom = zzcbn.string("measurement.upload.max_error_events_per_day", 1000, 1000);
  public static com.google.android.gms.internal.zzcbn<Integer> zzion = zzcbn.string("measurement.upload.max_public_events_per_day", 50000, 50000);
  public static com.google.android.gms.internal.zzcbn<Integer> zzioo = zzcbn.string("measurement.upload.max_conversions_per_day", 500, 500);
  public static com.google.android.gms.internal.zzcbn<Integer> zziop = zzcbn.string("measurement.upload.max_realtime_events_per_day", 10, 10);
  public static com.google.android.gms.internal.zzcbn<Integer> zzioq = zzcbn.string("measurement.store.max_stored_events_per_app", 100000, 100000);
  public static com.google.android.gms.internal.zzcbn<String> zzior = zzcbn.register("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
  public static com.google.android.gms.internal.zzcbn<Long> zzios = zzcbn.start("measurement.upload.backoff_period", 43200000L, 43200000L);
  public static com.google.android.gms.internal.zzcbn<Long> zziot = zzcbn.start("measurement.upload.window_interval", 3600000L, 3600000L);
  public static com.google.android.gms.internal.zzcbn<Long> zziou = zzcbn.start("measurement.upload.interval", 3600000L, 3600000L);
  public static com.google.android.gms.internal.zzcbn<Long> zziov = zzcbn.start("measurement.upload.realtime_upload_interval", 10000L, 10000L);
  public static com.google.android.gms.internal.zzcbn<Long> zziow = zzcbn.start("measurement.upload.debug_upload_interval", 1000L, 1000L);
  public static com.google.android.gms.internal.zzcbn<Long> zziox = zzcbn.start("measurement.upload.minimum_delay", 500L, 500L);
  public static com.google.android.gms.internal.zzcbn<Long> zzioy = zzcbn.start("measurement.alarm_manager.minimum_interval", 60000L, 60000L);
  public static com.google.android.gms.internal.zzcbn<Long> zzioz = zzcbn.start("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L);
  public static com.google.android.gms.internal.zzcbn<Long> zzipa = zzcbn.start("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L);
  public static com.google.android.gms.internal.zzcbn<Long> zzipb = zzcbn.start("measurement.upload.initial_upload_delay_time", 15000L, 15000L);
  public static com.google.android.gms.internal.zzcbn<Long> zzipc = zzcbn.start("measurement.upload.retry_time", 1800000L, 1800000L);
  public static com.google.android.gms.internal.zzcbn<Integer> zzipd = zzcbn.string("measurement.upload.retry_count", 6, 6);
  public static com.google.android.gms.internal.zzcbn<Long> zzipe = zzcbn.start("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
  public static com.google.android.gms.internal.zzcbn<Integer> zzipf = zzcbn.string("measurement.lifetimevalue.max_currency_tracked", 4, 4);
  public static com.google.android.gms.internal.zzcbn<Integer> zzipg = zzcbn.string("measurement.audience.filter_result_max_count", 200, 200);
  public static com.google.android.gms.internal.zzcbn<Long> zziph = zzcbn.start("measurement.service_client.idle_disconnect_millis", 5000L, 5000L);
}
