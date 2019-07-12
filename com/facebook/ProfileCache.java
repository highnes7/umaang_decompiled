package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

public final class ProfileCache
{
  public static final String CACHED_PROFILE_KEY = "com.facebook.ProfileManager.CachedProfile";
  public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
  public final SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
  
  public ProfileCache() {}
  
  public void clear()
  {
    sharedPreferences.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
  }
  
  public Profile load()
  {
    Object localObject = sharedPreferences.getString("com.facebook.ProfileManager.CachedProfile", null);
    if (localObject != null) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      localObject = new Profile((JSONObject)localObject);
      return localObject;
    }
    catch (JSONException localJSONException) {}
    return null;
    return null;
  }
  
  public void save(Profile paramProfile)
  {
    Validate.notNull(paramProfile, "profile");
    paramProfile = paramProfile.toJSONObject();
    if (paramProfile != null) {
      sharedPreferences.edit().putString("com.facebook.ProfileManager.CachedProfile", paramProfile.toString()).apply();
    }
  }
}
