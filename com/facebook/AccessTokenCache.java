package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

public class AccessTokenCache
{
  public static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
  public final SharedPreferences sharedPreferences;
  public LegacyTokenHelper tokenCachingStrategy;
  public final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;
  
  public AccessTokenCache()
  {
    this(FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new SharedPreferencesTokenCachingStrategyFactory());
  }
  
  public AccessTokenCache(SharedPreferences paramSharedPreferences, SharedPreferencesTokenCachingStrategyFactory paramSharedPreferencesTokenCachingStrategyFactory)
  {
    sharedPreferences = paramSharedPreferences;
    tokenCachingStrategyFactory = paramSharedPreferencesTokenCachingStrategyFactory;
  }
  
  private AccessToken getCachedAccessToken()
  {
    Object localObject = sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
    if (localObject != null) {}
    try
    {
      localObject = AccessToken.createFromJSONObject(new JSONObject((String)localObject));
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return null;
    return null;
  }
  
  private AccessToken getLegacyAccessToken()
  {
    Bundle localBundle = getTokenCachingStrategy().load();
    if ((localBundle != null) && (LegacyTokenHelper.hasTokenInformation(localBundle))) {
      return AccessToken.createFromLegacyCache(localBundle);
    }
    return null;
  }
  
  private LegacyTokenHelper getTokenCachingStrategy()
  {
    if (tokenCachingStrategy == null) {
      try
      {
        if (tokenCachingStrategy == null) {
          tokenCachingStrategy = tokenCachingStrategyFactory.create();
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return tokenCachingStrategy;
  }
  
  private boolean hasCachedAccessToken()
  {
    return sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken");
  }
  
  private boolean shouldCheckLegacyToken()
  {
    return FacebookSdk.isLegacyTokenUpgradeSupported;
  }
  
  public void clear()
  {
    sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
    if (FacebookSdk.isLegacyTokenUpgradeSupported) {
      getTokenCachingStrategy().clear();
    }
  }
  
  public AccessToken load()
  {
    if (hasCachedAccessToken()) {
      return getCachedAccessToken();
    }
    AccessToken localAccessToken;
    if (FacebookSdk.isLegacyTokenUpgradeSupported)
    {
      localAccessToken = getLegacyAccessToken();
      if (localAccessToken != null)
      {
        save(localAccessToken);
        getTokenCachingStrategy().clear();
        return localAccessToken;
      }
    }
    else
    {
      return null;
    }
    return localAccessToken;
  }
  
  public void save(AccessToken paramAccessToken)
  {
    Validate.notNull(paramAccessToken, "accessToken");
    try
    {
      paramAccessToken = paramAccessToken.toJSONObject();
      SharedPreferences localSharedPreferences = sharedPreferences;
      localSharedPreferences.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", paramAccessToken.toString()).apply();
      return;
    }
    catch (JSONException paramAccessToken) {}
  }
  
  public static class SharedPreferencesTokenCachingStrategyFactory
  {
    public SharedPreferencesTokenCachingStrategyFactory() {}
    
    public LegacyTokenHelper create()
    {
      return new LegacyTokenHelper(FacebookSdk.getApplicationContext(), null);
    }
  }
}
