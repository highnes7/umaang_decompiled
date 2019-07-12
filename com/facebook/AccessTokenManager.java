package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import support.android.v4.content.LocalBroadcastManager;

public final class AccessTokenManager
{
  public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
  public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
  public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
  public static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
  public static final String PAGE_KEY = "AccessTokenManager";
  public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
  public static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
  public static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
  public static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
  public static volatile AccessTokenManager instance;
  public final AccessTokenCache accessTokenCache;
  public AccessToken currentAccessToken;
  public Date lastAttemptedTokenExtendDate = new Date(0L);
  public final LocalBroadcastManager localBroadcastManager;
  public AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);
  
  public AccessTokenManager(LocalBroadcastManager paramLocalBroadcastManager, AccessTokenCache paramAccessTokenCache)
  {
    Validate.notNull(paramLocalBroadcastManager, "localBroadcastManager");
    Validate.notNull(paramAccessTokenCache, "accessTokenCache");
    localBroadcastManager = paramLocalBroadcastManager;
    accessTokenCache = paramAccessTokenCache;
  }
  
  public static GraphRequest createExtendAccessTokenRequest(AccessToken paramAccessToken, GraphRequest.Callback paramCallback)
  {
    return new GraphRequest(paramAccessToken, "oauth/access_token", StringBuilder.put("grant_type", "fb_extend_sso_token"), HttpMethod.HEAD, paramCallback);
  }
  
  public static GraphRequest createGrantedPermissionsRequest(AccessToken paramAccessToken, GraphRequest.Callback paramCallback)
  {
    return new GraphRequest(paramAccessToken, "me/permissions", new Bundle(), HttpMethod.HEAD, paramCallback);
  }
  
  public static AccessTokenManager getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new AccessTokenManager(LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()), new AccessTokenCache());
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return instance;
  }
  
  private void refreshCurrentAccessTokenImpl()
  {
    final AccessToken localAccessToken = currentAccessToken;
    if (localAccessToken == null) {
      return;
    }
    if (!tokenRefreshInProgress.compareAndSet(false, true)) {
      return;
    }
    Validate.runningOnUiThread();
    lastAttemptedTokenExtendDate = new Date();
    final HashSet localHashSet1 = new HashSet();
    final HashSet localHashSet2 = new HashSet();
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    final RefreshResult localRefreshResult = new RefreshResult(null);
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch(new GraphRequest[] { createGrantedPermissionsRequest(localAccessToken, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null) {
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.optJSONArray("data");
        if (paramAnonymousGraphResponse == null) {
          return;
        }
        localAtomicBoolean.set(true);
        int i = 0;
        while (i < paramAnonymousGraphResponse.length())
        {
          Object localObject = paramAnonymousGraphResponse.optJSONObject(i);
          if (localObject != null)
          {
            String str = ((JSONObject)localObject).optString("permission");
            localObject = ((JSONObject)localObject).optString("status");
            if ((!Utility.isNullOrEmpty(str)) && (!Utility.isNullOrEmpty((String)localObject)))
            {
              localObject = ((String)localObject).toLowerCase(Locale.US);
              if (((String)localObject).equals("granted")) {
                localHashSet1.add(str);
              } else if (((String)localObject).equals("declined")) {
                localHashSet2.add(str);
              } else {
                StringBuilder.get("Unexpected status: ", (String)localObject);
              }
            }
          }
          i += 1;
        }
      }
    }), createExtendAccessTokenRequest(localAccessToken, new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null) {
          return;
        }
        localRefreshResultaccessToken = paramAnonymousGraphResponse.optString("access_token");
        localRefreshResultexpiresAt = paramAnonymousGraphResponse.optInt("expires_at");
      }
    }) });
    localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        if (AccessTokenManager.getInstance().getCurrentAccessToken() != null)
        {
          if (AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != localAccessToken.getUserId()) {
            return;
          }
          try
          {
            boolean bool = localAtomicBoolean.get();
            if (!bool)
            {
              paramAnonymousGraphRequestBatch = localRefreshResultaccessToken;
              if (paramAnonymousGraphRequestBatch == null)
              {
                i = localRefreshResultexpiresAt;
                if (i == 0)
                {
                  AccessTokenManager.access$200(AccessTokenManager.this).set(false);
                  return;
                }
              }
            }
            paramAnonymousGraphRequestBatch = localRefreshResultaccessToken;
            if (paramAnonymousGraphRequestBatch != null) {
              paramAnonymousGraphRequestBatch = localRefreshResultaccessToken;
            } else {
              paramAnonymousGraphRequestBatch = localAccessToken.getToken();
            }
            String str1 = localAccessToken.getApplicationId();
            String str2 = localAccessToken.getUserId();
            bool = localAtomicBoolean.get();
            Set localSet1;
            if (bool) {
              localSet1 = localHashSet1;
            } else {
              localSet1 = localAccessToken.getPermissions();
            }
            bool = localAtomicBoolean.get();
            Set localSet2;
            if (bool) {
              localSet2 = localHashSet2;
            } else {
              localSet2 = localAccessToken.getDeclinedPermissions();
            }
            AccessTokenSource localAccessTokenSource = localAccessToken.getSource();
            int i = localRefreshResultexpiresAt;
            Date localDate;
            if (i != 0)
            {
              long l = localRefreshResultexpiresAt;
              localDate = new Date(l * 1000L);
            }
            else
            {
              localDate = localAccessToken.getExpires();
            }
            paramAnonymousGraphRequestBatch = new AccessToken(paramAnonymousGraphRequestBatch, str1, str2, localSet1, localSet2, localAccessTokenSource, localDate, new Date());
            AccessTokenManager.getInstance().setCurrentAccessToken(paramAnonymousGraphRequestBatch);
            AccessTokenManager.access$200(AccessTokenManager.this).set(false);
            return;
          }
          catch (Throwable paramAnonymousGraphRequestBatch)
          {
            AccessTokenManager.access$200(AccessTokenManager.this).set(false);
            throw paramAnonymousGraphRequestBatch;
          }
        }
      }
    });
    localGraphRequestBatch.executeAsync();
  }
  
  private void sendCurrentAccessTokenChangedBroadcast(AccessToken paramAccessToken1, AccessToken paramAccessToken2)
  {
    Intent localIntent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
    localIntent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", paramAccessToken1);
    localIntent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", paramAccessToken2);
    localBroadcastManager.sendBroadcast(localIntent);
  }
  
  private void setCurrentAccessToken(AccessToken paramAccessToken, boolean paramBoolean)
  {
    AccessToken localAccessToken = currentAccessToken;
    currentAccessToken = paramAccessToken;
    tokenRefreshInProgress.set(false);
    lastAttemptedTokenExtendDate = new Date(0L);
    if (paramBoolean) {
      if (paramAccessToken != null)
      {
        accessTokenCache.save(paramAccessToken);
      }
      else
      {
        accessTokenCache.clear();
        Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
      }
    }
    if (!Utility.areObjectsEqual(localAccessToken, paramAccessToken)) {
      sendCurrentAccessTokenChangedBroadcast(localAccessToken, paramAccessToken);
    }
  }
  
  private boolean shouldExtendAccessToken()
  {
    if (currentAccessToken == null) {
      return false;
    }
    Long localLong = Long.valueOf(new Date().getTime());
    return (currentAccessToken.getSource().canExtendToken()) && (localLong.longValue() - lastAttemptedTokenExtendDate.getTime() > 3600000L) && (localLong.longValue() - currentAccessToken.getLastRefresh().getTime() > 86400000L);
  }
  
  public void extendAccessTokenIfNeeded()
  {
    if (!shouldExtendAccessToken()) {
      return;
    }
    refreshCurrentAccessToken();
  }
  
  public AccessToken getCurrentAccessToken()
  {
    return currentAccessToken;
  }
  
  public boolean loadCurrentAccessToken()
  {
    AccessToken localAccessToken = accessTokenCache.load();
    if (localAccessToken != null)
    {
      setCurrentAccessToken(localAccessToken, false);
      return true;
    }
    return false;
  }
  
  public void refreshCurrentAccessToken()
  {
    if (Looper.getMainLooper().equals(Looper.myLooper()))
    {
      refreshCurrentAccessTokenImpl();
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AccessTokenManager.access$000(AccessTokenManager.this);
      }
    });
  }
  
  public void setCurrentAccessToken(AccessToken paramAccessToken)
  {
    setCurrentAccessToken(paramAccessToken, true);
  }
  
  private static class RefreshResult
  {
    public String accessToken;
    public int expiresAt;
    
    public RefreshResult() {}
  }
}
