package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class ProfileInformationCache
{
  public static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap();
  
  public ProfileInformationCache() {}
  
  public static JSONObject getProfileInformation(String paramString)
  {
    return (JSONObject)infoCache.get(paramString);
  }
  
  public static void putProfileInformation(String paramString, JSONObject paramJSONObject)
  {
    infoCache.put(paramString, paramJSONObject);
  }
}
