package com.google.android.android.internal;

public final class zzaod
{
  public static com.google.android.gms.internal.zzaoe<Boolean> zzdqz = zzaoe.init("analytics.service_enabled", false, false);
  public static com.google.android.gms.internal.zzaoe<Boolean> zzdra = zzaoe.init("analytics.service_client_enabled", true, true);
  public static com.google.android.gms.internal.zzaoe<String> zzdrb = zzaoe.selectStatement("analytics.log_tag", "GAv4", "GAv4-SVC");
  public static com.google.android.gms.internal.zzaoe<Long> zzdrc = zzaoe.start("analytics.max_tokens", 60L, 60L);
  public static com.google.android.gms.internal.zzaoe<Float> zzdrd = zzaoe.create("analytics.tokens_per_sec", 0.5F, 0.5F);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdre = zzaoe.start("analytics.max_stored_hits", 2000, 20000);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdrf = zzaoe.start("analytics.max_stored_hits_per_app", 2000, 2000);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdrg = zzaoe.start("analytics.max_stored_properties_per_app", 100, 100);
  public static com.google.android.gms.internal.zzaoe<Long> zzdrh = zzaoe.start("analytics.local_dispatch_millis", 1800000L, 120000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdri = zzaoe.start("analytics.initial_local_dispatch_millis", 5000L, 5000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdrj = zzaoe.start("analytics.min_local_dispatch_millis", 120000L, 120000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdrk = zzaoe.start("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdrl = zzaoe.start("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdrm = zzaoe.start("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdrn = zzaoe.start("analytics.max_hits_per_dispatch", 20, 20);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdro = zzaoe.start("analytics.max_hits_per_batch", 20, 20);
  public static com.google.android.gms.internal.zzaoe<String> zzdrp = zzaoe.selectStatement("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
  public static com.google.android.gms.internal.zzaoe<String> zzdrq = zzaoe.selectStatement("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
  public static com.google.android.gms.internal.zzaoe<String> zzdrr = zzaoe.selectStatement("analytics.simple_endpoint", "/collect", "/collect");
  public static com.google.android.gms.internal.zzaoe<String> zzdrs = zzaoe.selectStatement("analytics.batching_endpoint", "/batch", "/batch");
  public static com.google.android.gms.internal.zzaoe<Integer> zzdrt = zzaoe.start("analytics.max_get_length", 2036, 2036);
  public static com.google.android.gms.internal.zzaoe<String> zzdru = zzaoe.selectStatement("analytics.batching_strategy.k", zzanl.zzdqe.name(), zzanl.zzdqe.name());
  public static com.google.android.gms.internal.zzaoe<String> zzdrv;
  public static com.google.android.gms.internal.zzaoe<Integer> zzdrw = zzaoe.start("analytics.max_hits_per_request.k", 20, 20);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdrx = zzaoe.start("analytics.max_hit_length.k", 8192, 8192);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdry = zzaoe.start("analytics.max_post_length.k", 8192, 8192);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdrz = zzaoe.start("analytics.max_batch_post_length", 8192, 8192);
  public static com.google.android.gms.internal.zzaoe<String> zzdsa = zzaoe.selectStatement("analytics.fallback_responses.k", "404,502", "404,502");
  public static com.google.android.gms.internal.zzaoe<Integer> zzdsb = zzaoe.start("analytics.batch_retry_interval.seconds.k", 3600, 3600);
  public static com.google.android.gms.internal.zzaoe<Long> zzdsc = zzaoe.start("analytics.service_monitor_interval", 86400000L, 86400000L);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdsd = zzaoe.start("analytics.http_connection.connect_timeout_millis", 60000, 60000);
  public static com.google.android.gms.internal.zzaoe<Integer> zzdse = zzaoe.start("analytics.http_connection.read_timeout_millis", 61000, 61000);
  public static com.google.android.gms.internal.zzaoe<Long> zzdsf = zzaoe.start("analytics.campaigns.time_limit", 86400000L, 86400000L);
  public static com.google.android.gms.internal.zzaoe<String> zzdsg = zzaoe.selectStatement("analytics.first_party_experiment_id", "", "");
  public static com.google.android.gms.internal.zzaoe<Integer> zzdsh = zzaoe.start("analytics.first_party_experiment_variant", 0, 0);
  public static com.google.android.gms.internal.zzaoe<Boolean> zzdsi = zzaoe.init("analytics.test.disable_receiver", false, false);
  public static com.google.android.gms.internal.zzaoe<Long> zzdsj = zzaoe.start("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdsk = zzaoe.start("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdsl = zzaoe.start("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdsm = zzaoe.start("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdsn = zzaoe.start("analytics.service_client.reconnect_throttle_millis", 1800000L, 1800000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdso = zzaoe.start("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
  public static com.google.android.gms.internal.zzaoe<Long> zzdsp = zzaoe.start("analytics.initialization_warning_threshold", 5000L, 5000L);
  
  static
  {
    String str = zzanr.zzdql.name();
    zzdrv = zzaoe.selectStatement("analytics.compression_strategy.k", str, str);
  }
}
