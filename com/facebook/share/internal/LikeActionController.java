package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.package_7.Fragment;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.widget.LikeView.ObjectType;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import support.android.v4.content.LocalBroadcastManager;

public class LikeActionController
{
  public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
  public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
  public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
  public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
  public static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
  public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
  public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
  public static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
  public static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
  public static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
  public static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
  public static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
  public static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
  public static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
  public static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
  public static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
  public static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
  public static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
  public static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
  public static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
  public static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
  public static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
  public static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
  public static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
  public static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
  public static final int MAX_CACHE_SIZE = 128;
  public static final int MAX_OBJECT_SUFFIX = 1000;
  public static AccessTokenTracker accessTokenTracker;
  public static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap();
  public static FileLruCache controllerDiskCache;
  public static WorkQueue diskIOWorkQueue = new WorkQueue(1);
  public static Handler handler;
  public static boolean isInitialized = false;
  public static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
  public static String objectIdForPendingController;
  public static volatile int objectSuffix = 0;
  public static final String val$uri = "LikeActionController";
  public AppEventsLogger appEventsLogger;
  public Bundle facebookDialogAnalyticsBundle;
  public boolean isObjectLiked;
  public boolean isObjectLikedOnServer;
  public boolean isPendingLikeOrUnlike;
  public String likeCountStringWithLike;
  public String likeCountStringWithoutLike;
  public String objectId;
  public boolean objectIsPage;
  public LikeView.ObjectType objectType;
  public String socialSentenceWithLike;
  public String socialSentenceWithoutLike;
  public String unlikeToken;
  public String verifiedObjectId;
  
  public LikeActionController(String paramString, LikeView.ObjectType paramObjectType)
  {
    objectId = paramString;
    objectType = paramObjectType;
  }
  
  public static void broadcastAction(LikeActionController paramLikeActionController, String paramString)
  {
    broadcastAction(paramLikeActionController, paramString, null);
  }
  
  public static void broadcastAction(LikeActionController paramLikeActionController, String paramString, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramString);
    paramString = paramBundle;
    if (paramLikeActionController != null)
    {
      paramString = paramBundle;
      if (paramBundle == null) {
        paramString = new Bundle();
      }
      paramString.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", paramLikeActionController.getObjectId());
    }
    if (paramString != null) {
      localIntent.putExtras(paramString);
    }
    LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(localIntent);
  }
  
  private boolean canUseOGPublish()
  {
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    return (!objectIsPage) && (verifiedObjectId != null) && (localAccessToken != null) && (localAccessToken.getPermissions() != null) && (localAccessToken.getPermissions().contains("publish_actions"));
  }
  
  private void clearState()
  {
    facebookDialogAnalyticsBundle = null;
    storeObjectIdForPendingController(null);
  }
  
  public static void createControllerForObjectIdAndType(String paramString, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    Object localObject = getControllerFromInMemoryCache(paramString);
    if (localObject != null)
    {
      verifyControllerAndInvokeCallback((LikeActionController)localObject, paramObjectType, paramCreationCallback);
      return;
    }
    LikeActionController localLikeActionController = deserializeFromDiskSynchronously(paramString);
    localObject = localLikeActionController;
    if (localLikeActionController == null)
    {
      localObject = new LikeActionController(paramString, paramObjectType);
      serializeToDiskAsync((LikeActionController)localObject);
    }
    putControllerInMemoryCache(paramString, (LikeActionController)localObject);
    handler.post(new Runnable()
    {
      public void run()
      {
        LikeActionController.access$200(val$controllerToRefresh);
      }
    });
    invokeCallbackWithController(paramCreationCallback, (LikeActionController)localObject, null);
  }
  
  /* Error */
  public static LikeActionController deserializeFromDiskSynchronously(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokestatic 445	com/facebook/share/internal/LikeActionController:getCacheKeyForObjectId	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_0
    //   10: getstatic 335	com/facebook/share/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
    //   13: astore_2
    //   14: aload_2
    //   15: aload_0
    //   16: invokevirtual 451	com/facebook/internal/FileLruCache:getFile	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore 5
    //   21: aload 5
    //   23: astore_0
    //   24: aload 4
    //   26: astore_2
    //   27: aload 5
    //   29: ifnull +39 -> 68
    //   32: aload_0
    //   33: astore_2
    //   34: aload 5
    //   36: invokestatic 457	com/facebook/internal/Utility:readStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   39: astore 6
    //   41: aload_0
    //   42: astore_2
    //   43: aload 6
    //   45: invokestatic 461	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   48: istore_1
    //   49: aload 4
    //   51: astore_2
    //   52: iload_1
    //   53: ifne +15 -> 68
    //   56: aload_0
    //   57: astore_2
    //   58: aload 6
    //   60: invokestatic 464	com/facebook/share/internal/LikeActionController:deserializeFromJson	(Ljava/lang/String;)Lcom/facebook/share/internal/LikeActionController;
    //   63: astore 4
    //   65: aload 4
    //   67: astore_2
    //   68: aload 5
    //   70: ifnull +33 -> 103
    //   73: aload_0
    //   74: invokestatic 468	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   77: aload_2
    //   78: areturn
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_2
    //   82: goto +24 -> 106
    //   85: aconst_null
    //   86: astore_0
    //   87: aload_0
    //   88: astore_2
    //   89: getstatic 239	com/facebook/share/internal/LikeActionController:val$uri	Ljava/lang/String;
    //   92: astore 4
    //   94: aload_0
    //   95: ifnull +32 -> 127
    //   98: aload_3
    //   99: astore_2
    //   100: goto -27 -> 73
    //   103: aload_2
    //   104: areturn
    //   105: astore_0
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokestatic 468	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   114: goto +3 -> 117
    //   117: aload_0
    //   118: athrow
    //   119: astore_0
    //   120: goto -35 -> 85
    //   123: astore_2
    //   124: goto -37 -> 87
    //   127: aconst_null
    //   128: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramString	String
    //   48	5	1	bool	boolean
    //   13	98	2	localObject1	Object
    //   123	1	2	localIOException	IOException
    //   1	98	3	localObject2	Object
    //   3	90	4	localObject3	Object
    //   19	50	5	localInputStream	java.io.InputStream
    //   39	20	6	str	String
    // Exception table:
    //   from	to	target	type
    //   5	10	79	java/lang/Throwable
    //   14	21	79	java/lang/Throwable
    //   34	41	105	java/lang/Throwable
    //   43	49	105	java/lang/Throwable
    //   58	65	105	java/lang/Throwable
    //   89	94	105	java/lang/Throwable
    //   5	10	119	java/io/IOException
    //   14	21	119	java/io/IOException
    //   34	41	123	java/io/IOException
    //   43	49	123	java/io/IOException
    //   58	65	123	java/io/IOException
  }
  
  public static LikeActionController deserializeFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("com.facebook.share.internal.LikeActionController.version", -1);
      if (i != 3) {
        return null;
      }
      Object localObject1 = paramString.getString("object_id");
      Object localObject2 = LikeView.ObjectType.UNKNOWN;
      i = paramString.optInt("object_type", ((LikeView.ObjectType)localObject2).getValue());
      localObject1 = new LikeActionController((String)localObject1, LikeView.ObjectType.fromInt(i));
      localObject2 = paramString.optString("like_count_string_with_like", null);
      likeCountStringWithLike = ((String)localObject2);
      localObject2 = paramString.optString("like_count_string_without_like", null);
      likeCountStringWithoutLike = ((String)localObject2);
      localObject2 = paramString.optString("social_sentence_with_like", null);
      socialSentenceWithLike = ((String)localObject2);
      localObject2 = paramString.optString("social_sentence_without_like", null);
      socialSentenceWithoutLike = ((String)localObject2);
      boolean bool = paramString.optBoolean("is_object_liked");
      isObjectLiked = bool;
      localObject2 = paramString.optString("unlike_token", null);
      unlikeToken = ((String)localObject2);
      paramString = paramString.optJSONObject("facebook_dialog_analytics_bundle");
      if (paramString != null)
      {
        paramString = BundleJSONConverter.convertToBundle(paramString);
        facebookDialogAnalyticsBundle = paramString;
      }
      return localObject1;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
    paramString = val$uri;
    return null;
  }
  
  private void fetchVerifiedObjectId(final RequestCompletionCallback paramRequestCompletionCallback)
  {
    if (!Utility.isNullOrEmpty(verifiedObjectId))
    {
      if (paramRequestCompletionCallback != null) {
        paramRequestCompletionCallback.onComplete();
      }
    }
    else
    {
      final GetOGObjectIdRequestWrapper localGetOGObjectIdRequestWrapper = new GetOGObjectIdRequestWrapper(objectId, objectType);
      final GetPageIdRequestWrapper localGetPageIdRequestWrapper = new GetPageIdRequestWrapper(objectId, objectType);
      GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
      localGetOGObjectIdRequestWrapper.addToBatch(localGraphRequestBatch);
      localGetPageIdRequestWrapper.addToBatch(localGraphRequestBatch);
      localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
      {
        public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
        {
          LikeActionController.access$1602(LikeActionController.this, localGetOGObjectIdRequestWrapperverifiedObjectId);
          if (Utility.isNullOrEmpty(LikeActionController.access$1600(LikeActionController.this)))
          {
            LikeActionController.access$1602(LikeActionController.this, localGetPageIdRequestWrapperverifiedObjectId);
            LikeActionController.access$2302(LikeActionController.this, localGetPageIdRequestWrapperobjectIsPage);
          }
          if (Utility.isNullOrEmpty(LikeActionController.access$1600(LikeActionController.this)))
          {
            Logger.logError(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.val$uri, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", new Object[] { LikeActionController.access$2200(LikeActionController.this) });
            LikeActionController localLikeActionController = LikeActionController.this;
            if (localGetPageIdRequestWrapper.getError() != null) {
              paramAnonymousGraphRequestBatch = localGetPageIdRequestWrapper.getError();
            } else {
              paramAnonymousGraphRequestBatch = localGetOGObjectIdRequestWrapper.getError();
            }
            LikeActionController.access$2400(localLikeActionController, "get_verified_id", paramAnonymousGraphRequestBatch);
          }
          paramAnonymousGraphRequestBatch = paramRequestCompletionCallback;
          if (paramAnonymousGraphRequestBatch != null) {
            paramAnonymousGraphRequestBatch.onComplete();
          }
        }
      });
      localGraphRequestBatch.executeAsync();
    }
  }
  
  private AppEventsLogger getAppEventsLogger()
  {
    if (appEventsLogger == null) {
      appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
    }
    return appEventsLogger;
  }
  
  public static String getCacheKeyForObjectId(String paramString)
  {
    Object localObject1 = AccessToken.getCurrentAccessToken();
    if (localObject1 != null) {
      localObject1 = ((AccessToken)localObject1).getToken();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = Utility.md5hash((String)localObject1);
    }
    return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[] { paramString, Utility.coerceValueIfNullOrEmpty((String)localObject2, ""), Integer.valueOf(objectSuffix) });
  }
  
  public static void getControllerForObjectId(String paramString, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    if (!isInitialized) {
      performFirstInitialize();
    }
    LikeActionController localLikeActionController = getControllerFromInMemoryCache(paramString);
    if (localLikeActionController != null)
    {
      verifyControllerAndInvokeCallback(localLikeActionController, paramObjectType, paramCreationCallback);
      return;
    }
    diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(paramString, paramObjectType, paramCreationCallback));
  }
  
  public static LikeActionController getControllerFromInMemoryCache(String paramString)
  {
    paramString = getCacheKeyForObjectId(paramString);
    LikeActionController localLikeActionController = (LikeActionController)cache.get(paramString);
    if (localLikeActionController != null) {
      mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(paramString, false));
    }
    return localLikeActionController;
  }
  
  private ResultProcessor getResultProcessor(final Bundle paramBundle)
  {
    new ResultProcessor(null)
    {
      public void onCancel(AppCall paramAnonymousAppCall)
      {
        onError(paramAnonymousAppCall, new FacebookOperationCanceledException());
      }
      
      public void onError(AppCall paramAnonymousAppCall, FacebookException paramAnonymousFacebookException)
      {
        Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Like Dialog failed with error : %s", new Object[] { paramAnonymousFacebookException });
        Bundle localBundle2 = paramBundle;
        Bundle localBundle1 = localBundle2;
        if (localBundle2 == null) {
          localBundle1 = new Bundle();
        }
        localBundle1.putString("call_id", paramAnonymousAppCall.getCallId().toString());
        LikeActionController.access$1400(LikeActionController.this, "present_dialog", localBundle1);
        LikeActionController.broadcastAction(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", NativeProtocol.createBundleForException(paramAnonymousFacebookException));
      }
      
      public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousBundle != null)
        {
          if (!paramAnonymousBundle.containsKey("object_is_liked")) {
            return;
          }
          boolean bool = paramAnonymousBundle.getBoolean("object_is_liked");
          Object localObject1 = LikeActionController.access$700(LikeActionController.this);
          String str1 = LikeActionController.access$800(LikeActionController.this);
          if (paramAnonymousBundle.containsKey("like_count_string"))
          {
            str1 = paramAnonymousBundle.getString("like_count_string");
            localObject1 = str1;
          }
          Object localObject2 = LikeActionController.access$900(LikeActionController.this);
          String str2 = LikeActionController.access$1000(LikeActionController.this);
          if (paramAnonymousBundle.containsKey("social_sentence"))
          {
            str2 = paramAnonymousBundle.getString("social_sentence");
            localObject2 = str2;
          }
          if (paramAnonymousBundle.containsKey("object_is_liked")) {
            paramAnonymousBundle = paramAnonymousBundle.getString("unlike_token");
          } else {
            paramAnonymousBundle = LikeActionController.access$1100(LikeActionController.this);
          }
          Bundle localBundle2 = paramBundle;
          Bundle localBundle1 = localBundle2;
          if (localBundle2 == null) {
            localBundle1 = new Bundle();
          }
          localBundle1.putString("call_id", paramAnonymousAppCall.getCallId().toString());
          LikeActionController.access$1200(LikeActionController.this).logSdkEvent("fb_like_control_dialog_did_succeed", null, localBundle1);
          LikeActionController.access$1300(LikeActionController.this, bool, (String)localObject1, str1, (String)localObject2, str2, paramAnonymousBundle);
        }
      }
    };
  }
  
  public static boolean handleOnActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    if (Utility.isNullOrEmpty(objectIdForPendingController)) {
      objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
    }
    if (Utility.isNullOrEmpty(objectIdForPendingController)) {
      return false;
    }
    getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new CreationCallback()
    {
      public void onComplete(LikeActionController paramAnonymousLikeActionController, FacebookException paramAnonymousFacebookException)
      {
        if (paramAnonymousFacebookException == null)
        {
          LikeActionController.access$000(paramAnonymousLikeActionController, val$requestCode, paramInt2, paramIntent);
          return;
        }
        Utility.logd(LikeActionController.val$uri, paramAnonymousFacebookException);
      }
    });
    return true;
  }
  
  public static void invokeCallbackWithController(CreationCallback paramCreationCallback, final LikeActionController paramLikeActionController, final FacebookException paramFacebookException)
  {
    if (paramCreationCallback == null) {
      return;
    }
    handler.post(new Runnable()
    {
      public void run()
      {
        val$callback.onComplete(paramLikeActionController, paramFacebookException);
      }
    });
  }
  
  private void logAppEventForError(String paramString, Bundle paramBundle)
  {
    paramBundle = new Bundle(paramBundle);
    paramBundle.putString("object_id", objectId);
    paramBundle.putString("object_type", objectType.toString());
    paramBundle.putString("current_action", paramString);
    getAppEventsLogger().logSdkEvent("fb_like_control_error", null, paramBundle);
  }
  
  private void logAppEventForError(String paramString, FacebookRequestError paramFacebookRequestError)
  {
    Bundle localBundle = new Bundle();
    if (paramFacebookRequestError != null)
    {
      paramFacebookRequestError = paramFacebookRequestError.getRequestResult();
      if (paramFacebookRequestError != null) {
        localBundle.putString("error", paramFacebookRequestError.toString());
      }
    }
    logAppEventForError(paramString, localBundle);
  }
  
  private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ShareInternalUtility.handleActivityResult(paramInt1, paramInt2, paramIntent, getResultProcessor(facebookDialogAnalyticsBundle));
    clearState();
  }
  
  public static void performFirstInitialize()
  {
    try
    {
      boolean bool = isInitialized;
      if (bool) {
        return;
      }
      handler = new Handler(Looper.getMainLooper());
      objectSuffix = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
      controllerDiskCache = new FileLruCache(val$uri, new FileLruCache.Limits());
      registerAccessTokenTracker();
      CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), new CallbackManagerImpl.Callback()
      {
        public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          return LikeActionController.handleOnActivityResult(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), paramAnonymousInt, paramAnonymousIntent);
        }
      });
      isInitialized = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void presentLikeDialog(Activity paramActivity, Fragment paramFragment, Bundle paramBundle)
  {
    Object localObject;
    if (LikeDialog.canShowNativeDialog())
    {
      localObject = "fb_like_control_did_present_dialog";
    }
    else if (LikeDialog.canShowWebFallback())
    {
      localObject = "fb_like_control_did_present_fallback_dialog";
    }
    else
    {
      logAppEventForError("present_dialog", paramBundle);
      Utility.logd(val$uri, "Cannot show the Like Dialog on this device.");
      broadcastAction(null, "com.facebook.sdk.LikeActionController.UPDATED", null);
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = objectType;
      if (localObject != null) {
        localObject = ((LikeView.ObjectType)localObject).toString();
      } else {
        localObject = LikeView.ObjectType.UNKNOWN.toString();
      }
      localObject = new LikeContent.Builder().setObjectId(objectId).setObjectType((String)localObject).build();
      if (paramFragment != null) {
        new LikeDialog(paramFragment).show(localObject);
      } else {
        new LikeDialog(paramActivity).show(localObject);
      }
      storeObjectIdForPendingController(objectId);
      facebookDialogAnalyticsBundle = paramBundle;
      serializeToDiskAsync(this);
      getAppEventsLogger().logSdkEvent("fb_like_control_did_present_dialog", null, paramBundle);
    }
  }
  
  private void publishAgainIfNeeded(Bundle paramBundle)
  {
    boolean bool = isObjectLiked;
    if ((bool != isObjectLikedOnServer) && (!publishLikeOrUnlikeAsync(bool, paramBundle))) {
      publishDidError(isObjectLiked ^ true);
    }
  }
  
  private void publishDidError(boolean paramBoolean)
  {
    updateLikeState(paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
    broadcastAction(this, "com.facebook.sdk.LikeActionController.DID_ERROR", localBundle);
  }
  
  private void publishLikeAsync(final Bundle paramBundle)
  {
    isPendingLikeOrUnlike = true;
    fetchVerifiedObjectId(new RequestCompletionCallback()
    {
      public void onComplete()
      {
        if (Utility.isNullOrEmpty(LikeActionController.access$1600(LikeActionController.this)))
        {
          localObject1 = StringBuilder.put("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
          LikeActionController.broadcastAction(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", (Bundle)localObject1);
          return;
        }
        Object localObject1 = new GraphRequestBatch();
        Object localObject2 = LikeActionController.this;
        localObject2 = new LikeActionController.PublishLikeRequestWrapper((LikeActionController)localObject2, LikeActionController.access$1600((LikeActionController)localObject2), LikeActionController.access$1700(LikeActionController.this));
        ((LikeActionController.AbstractRequestWrapper)localObject2).addToBatch((GraphRequestBatch)localObject1);
        ((GraphRequestBatch)localObject1).addCallback(new GraphRequestBatch.Callback()
        {
          public void onBatchCompleted(GraphRequestBatch paramAnonymous2GraphRequestBatch)
          {
            LikeActionController.access$1802(LikeActionController.this, false);
            if (val$likeRequest.getError() != null)
            {
              LikeActionController.access$1900(LikeActionController.this, false);
              return;
            }
            LikeActionController.access$1102(LikeActionController.this, Utility.coerceValueIfNullOrEmpty(val$likeRequest.unlikeToken, null));
            LikeActionController.access$2002(LikeActionController.this, true);
            LikeActionController.access$1200(LikeActionController.this).logSdkEvent("fb_like_control_did_like", null, val$analyticsParameters);
            paramAnonymous2GraphRequestBatch = LikeActionController.7.this;
            LikeActionController.access$2100(this$0, val$analyticsParameters);
          }
        });
        ((GraphRequestBatch)localObject1).executeAsync();
      }
    });
  }
  
  private boolean publishLikeOrUnlikeAsync(boolean paramBoolean, Bundle paramBundle)
  {
    if (canUseOGPublish())
    {
      if (paramBoolean)
      {
        isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new RequestCompletionCallback()
        {
          public void onComplete()
          {
            if (Utility.isNullOrEmpty(LikeActionController.access$1600(LikeActionController.this)))
            {
              localObject1 = StringBuilder.put("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
              LikeActionController.broadcastAction(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", (Bundle)localObject1);
              return;
            }
            Object localObject1 = new GraphRequestBatch();
            Object localObject2 = LikeActionController.this;
            localObject2 = new LikeActionController.PublishLikeRequestWrapper((LikeActionController)localObject2, LikeActionController.access$1600((LikeActionController)localObject2), LikeActionController.access$1700(LikeActionController.this));
            ((LikeActionController.AbstractRequestWrapper)localObject2).addToBatch((GraphRequestBatch)localObject1);
            ((GraphRequestBatch)localObject1).addCallback(new GraphRequestBatch.Callback()
            {
              public void onBatchCompleted(GraphRequestBatch paramAnonymous2GraphRequestBatch)
              {
                LikeActionController.access$1802(LikeActionController.this, false);
                if (val$likeRequest.getError() != null)
                {
                  LikeActionController.access$1900(LikeActionController.this, false);
                  return;
                }
                LikeActionController.access$1102(LikeActionController.this, Utility.coerceValueIfNullOrEmpty(val$likeRequest.unlikeToken, null));
                LikeActionController.access$2002(LikeActionController.this, true);
                LikeActionController.access$1200(LikeActionController.this).logSdkEvent("fb_like_control_did_like", null, val$analyticsParameters);
                paramAnonymous2GraphRequestBatch = LikeActionController.7.this;
                LikeActionController.access$2100(this$0, val$analyticsParameters);
              }
            });
            ((GraphRequestBatch)localObject1).executeAsync();
          }
        });
        return true;
      }
      if (!Utility.isNullOrEmpty(unlikeToken))
      {
        publishUnlikeAsync(paramBundle);
        return true;
      }
    }
    return false;
  }
  
  private void publishUnlikeAsync(final Bundle paramBundle)
  {
    isPendingLikeOrUnlike = true;
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
    final PublishUnlikeRequestWrapper localPublishUnlikeRequestWrapper = new PublishUnlikeRequestWrapper(unlikeToken);
    localPublishUnlikeRequestWrapper.addToBatch(localGraphRequestBatch);
    localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        LikeActionController.access$1802(LikeActionController.this, false);
        if (localPublishUnlikeRequestWrapper.getError() != null)
        {
          LikeActionController.access$1900(LikeActionController.this, true);
          return;
        }
        LikeActionController.access$1102(LikeActionController.this, null);
        LikeActionController.access$2002(LikeActionController.this, false);
        LikeActionController.access$1200(LikeActionController.this).logSdkEvent("fb_like_control_did_unlike", null, paramBundle);
        LikeActionController.access$2100(LikeActionController.this, paramBundle);
      }
    });
    localGraphRequestBatch.executeAsync();
  }
  
  public static void putControllerInMemoryCache(String paramString, LikeActionController paramLikeActionController)
  {
    paramString = getCacheKeyForObjectId(paramString);
    mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(paramString, true));
    cache.put(paramString, paramLikeActionController);
  }
  
  private void refreshStatusAsync()
  {
    if (AccessToken.getCurrentAccessToken() == null)
    {
      refreshStatusViaService();
      return;
    }
    fetchVerifiedObjectId(new RequestCompletionCallback()
    {
      public void onComplete()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a2 = a1\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
      }
    });
  }
  
  private void refreshStatusViaService()
  {
    LikeStatusClient localLikeStatusClient = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), objectId);
    if (!localLikeStatusClient.start()) {
      return;
    }
    localLikeStatusClient.setCompletedListener(new PlatformServiceClient.CompletedListener()
    {
      public void completed(Bundle paramAnonymousBundle)
      {
        if (paramAnonymousBundle != null)
        {
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
            return;
          }
          boolean bool = paramAnonymousBundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
          String str1;
          if (paramAnonymousBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE")) {
            str1 = paramAnonymousBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
          } else {
            str1 = LikeActionController.access$700(LikeActionController.this);
          }
          String str2;
          if (paramAnonymousBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
            str2 = paramAnonymousBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
          } else {
            str2 = LikeActionController.access$800(LikeActionController.this);
          }
          String str3;
          if (paramAnonymousBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
            str3 = paramAnonymousBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
          } else {
            str3 = LikeActionController.access$900(LikeActionController.this);
          }
          String str4;
          if (paramAnonymousBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
            str4 = paramAnonymousBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
          } else {
            str4 = LikeActionController.access$1000(LikeActionController.this);
          }
          if (paramAnonymousBundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
            paramAnonymousBundle = paramAnonymousBundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
          } else {
            paramAnonymousBundle = LikeActionController.access$1100(LikeActionController.this);
          }
          LikeActionController.access$1300(LikeActionController.this, bool, str1, str2, str3, str4, paramAnonymousBundle);
        }
      }
    });
  }
  
  public static void registerAccessTokenTracker()
  {
    accessTokenTracker = new AccessTokenTracker()
    {
      public void onCurrentAccessTokenChanged(AccessToken paramAnonymousAccessToken1, AccessToken paramAnonymousAccessToken2)
      {
        paramAnonymousAccessToken1 = FacebookSdk.getApplicationContext();
        if (paramAnonymousAccessToken2 == null)
        {
          LikeActionController.objectSuffix = (LikeActionController.objectSuffix + 1) % 1000;
          paramAnonymousAccessToken1.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", LikeActionController.objectSuffix).apply();
          LikeActionController.cache.clear();
          LikeActionController.controllerDiskCache.clearCache();
        }
        LikeActionController.broadcastAction(null, "com.facebook.sdk.LikeActionController.DID_RESET", null);
      }
    };
  }
  
  private void saveState(Bundle paramBundle)
  {
    storeObjectIdForPendingController(objectId);
    facebookDialogAnalyticsBundle = paramBundle;
    serializeToDiskAsync(this);
  }
  
  public static void serializeToDiskAsync(LikeActionController paramLikeActionController)
  {
    String str = serializeToJson(paramLikeActionController);
    paramLikeActionController = getCacheKeyForObjectId(objectId);
    if ((!Utility.isNullOrEmpty(str)) && (!Utility.isNullOrEmpty(paramLikeActionController))) {
      diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(paramLikeActionController, str));
    }
  }
  
  public static void serializeToDiskSynchronously(String paramString1, String paramString2)
  {
    str1 = null;
    str2 = null;
    Object localObject = controllerDiskCache;
    try
    {
      localObject = ((FileLruCache)localObject).openPutStream(paramString1);
      paramString1 = (String)localObject;
      str2 = paramString1;
      str1 = paramString1;
      ((OutputStream)localObject).write(paramString2.getBytes());
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        break;
        str2 = str1;
        paramString1 = val$uri;
        if (str1 != null) {
          paramString1 = str1;
        } else {
          return;
        }
      }
      if (str2 == null) {
        break label66;
      }
      Utility.closeQuietly(str2);
      throw paramString1;
    }
    catch (IOException paramString1)
    {
      for (;;) {}
    }
    Utility.closeQuietly(paramString1);
  }
  
  public static String serializeToJson(LikeActionController paramLikeActionController)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.get("com.facebook.share.internal.LikeActionController.version", 3);
      Object localObject = objectId;
      localJSONObject.put("object_id", localObject);
      localObject = objectType;
      localJSONObject.get("object_type", ((LikeView.ObjectType)localObject).getValue());
      localObject = likeCountStringWithLike;
      localJSONObject.put("like_count_string_with_like", localObject);
      localObject = likeCountStringWithoutLike;
      localJSONObject.put("like_count_string_without_like", localObject);
      localObject = socialSentenceWithLike;
      localJSONObject.put("social_sentence_with_like", localObject);
      localObject = socialSentenceWithoutLike;
      localJSONObject.put("social_sentence_without_like", localObject);
      boolean bool = isObjectLiked;
      localJSONObject.get("is_object_liked", bool);
      localObject = unlikeToken;
      localJSONObject.put("unlike_token", localObject);
      paramLikeActionController = facebookDialogAnalyticsBundle;
      if (paramLikeActionController != null) {
        localJSONObject.put("facebook_dialog_analytics_bundle", BundleJSONConverter.convertToJSON(paramLikeActionController));
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramLikeActionController)
    {
      for (;;) {}
    }
    paramLikeActionController = val$uri;
    return null;
  }
  
  public static void storeObjectIdForPendingController(String paramString)
  {
    objectIdForPendingController = paramString;
    FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", objectIdForPendingController).apply();
  }
  
  private void updateLikeState(boolean paramBoolean)
  {
    updateState(paramBoolean, likeCountStringWithLike, likeCountStringWithoutLike, socialSentenceWithLike, socialSentenceWithoutLike, unlikeToken);
  }
  
  private void updateState(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = Utility.coerceValueIfNullOrEmpty(paramString1, null);
    paramString2 = Utility.coerceValueIfNullOrEmpty(paramString2, null);
    paramString3 = Utility.coerceValueIfNullOrEmpty(paramString3, null);
    paramString4 = Utility.coerceValueIfNullOrEmpty(paramString4, null);
    paramString5 = Utility.coerceValueIfNullOrEmpty(paramString5, null);
    int i;
    if ((paramBoolean == isObjectLiked) && (Utility.areObjectsEqual(paramString1, likeCountStringWithLike)) && (Utility.areObjectsEqual(paramString2, likeCountStringWithoutLike)) && (Utility.areObjectsEqual(paramString3, socialSentenceWithLike)) && (Utility.areObjectsEqual(paramString4, socialSentenceWithoutLike)) && (Utility.areObjectsEqual(paramString5, unlikeToken))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return;
    }
    isObjectLiked = paramBoolean;
    likeCountStringWithLike = paramString1;
    likeCountStringWithoutLike = paramString2;
    socialSentenceWithLike = paramString3;
    socialSentenceWithoutLike = paramString4;
    unlikeToken = paramString5;
    serializeToDiskAsync(this);
    broadcastAction(this, "com.facebook.sdk.LikeActionController.UPDATED", null);
  }
  
  public static void verifyControllerAndInvokeCallback(LikeActionController paramLikeActionController, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    LikeView.ObjectType localObjectType = ShareInternalUtility.getMostSpecificObjectType(paramObjectType, objectType);
    if (localObjectType == null)
    {
      paramLikeActionController = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", new Object[] { objectId, objectType.toString(), paramObjectType.toString() });
      paramObjectType = null;
    }
    else
    {
      objectType = localObjectType;
      localObjectType = null;
      paramObjectType = paramLikeActionController;
      paramLikeActionController = localObjectType;
    }
    invokeCallbackWithController(paramCreationCallback, paramObjectType, paramLikeActionController);
  }
  
  public String getLikeCountString()
  {
    if (isObjectLiked) {
      return likeCountStringWithLike;
    }
    return likeCountStringWithoutLike;
  }
  
  public String getObjectId()
  {
    return objectId;
  }
  
  public String getSocialSentence()
  {
    if (isObjectLiked) {
      return socialSentenceWithLike;
    }
    return socialSentenceWithoutLike;
  }
  
  public boolean isObjectLiked()
  {
    return isObjectLiked;
  }
  
  public boolean shouldEnableView()
  {
    if (!LikeDialog.canShowNativeDialog())
    {
      if (LikeDialog.canShowWebFallback()) {
        return true;
      }
      if (!objectIsPage)
      {
        if (objectType == LikeView.ObjectType.PAGE) {
          return false;
        }
        AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
        return (localAccessToken != null) && (localAccessToken.getPermissions() != null) && (localAccessToken.getPermissions().contains("publish_actions"));
      }
      return false;
    }
    return true;
  }
  
  public void toggleLike(Activity paramActivity, Fragment paramFragment, Bundle paramBundle)
  {
    boolean bool2 = isObjectLiked;
    boolean bool1 = true;
    bool2 ^= true;
    if (canUseOGPublish())
    {
      updateLikeState(bool2);
      if (isPendingLikeOrUnlike)
      {
        getAppEventsLogger().logSdkEvent("fb_like_control_did_undo_quickly", null, paramBundle);
        return;
      }
      if (!publishLikeOrUnlikeAsync(bool2, paramBundle))
      {
        if (bool2) {
          bool1 = false;
        }
        updateLikeState(bool1);
        presentLikeDialog(paramActivity, paramFragment, paramBundle);
      }
    }
    else
    {
      presentLikeDialog(paramActivity, paramFragment, paramBundle);
    }
  }
  
  private abstract class AbstractRequestWrapper
    implements LikeActionController.RequestWrapper
  {
    public FacebookRequestError error;
    public String objectId;
    public LikeView.ObjectType objectType;
    public GraphRequest request;
    
    public AbstractRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      objectId = paramString;
      objectType = paramObjectType;
    }
    
    public void addToBatch(GraphRequestBatch paramGraphRequestBatch)
    {
      paramGraphRequestBatch.add(request);
    }
    
    public FacebookRequestError getError()
    {
      return error;
    }
    
    public void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Error running request for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
    }
    
    public abstract void processSuccess(GraphResponse paramGraphResponse);
    
    public void setRequest(GraphRequest paramGraphRequest)
    {
      request = paramGraphRequest;
      paramGraphRequest.setVersion("v2.4");
      paramGraphRequest.setCallback(new GraphRequest.Callback()
      {
        public void onCompleted(GraphResponse paramAnonymousGraphResponse)
        {
          error = paramAnonymousGraphResponse.getError();
          LikeActionController.AbstractRequestWrapper localAbstractRequestWrapper = LikeActionController.AbstractRequestWrapper.this;
          FacebookRequestError localFacebookRequestError = error;
          if (localFacebookRequestError != null)
          {
            localAbstractRequestWrapper.processError(localFacebookRequestError);
            return;
          }
          localAbstractRequestWrapper.processSuccess(paramAnonymousGraphResponse);
        }
      });
    }
  }
  
  private static class CreateLikeActionControllerWorkItem
    implements Runnable
  {
    public LikeActionController.CreationCallback callback;
    public String objectId;
    public LikeView.ObjectType objectType;
    
    public CreateLikeActionControllerWorkItem(String paramString, LikeView.ObjectType paramObjectType, LikeActionController.CreationCallback paramCreationCallback)
    {
      objectId = paramString;
      objectType = paramObjectType;
      callback = paramCreationCallback;
    }
    
    public void run()
    {
      LikeActionController.createControllerForObjectIdAndType(objectId, objectType, callback);
    }
  }
  
  public static abstract interface CreationCallback
  {
    public abstract void onComplete(LikeActionController paramLikeActionController, FacebookException paramFacebookException);
  }
  
  private class GetEngagementRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    public String likeCountStringWithLike = LikeActionController.access$700(LikeActionController.this);
    public String likeCountStringWithoutLike = LikeActionController.access$800(LikeActionController.this);
    public String socialSentenceStringWithLike = LikeActionController.access$900(LikeActionController.this);
    public String socialSentenceStringWithoutLike = LikeActionController.access$1000(LikeActionController.this);
    
    public GetEngagementRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      this$1 = StringBuilder.put("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, LikeActionController.this, HttpMethod.HEAD));
    }
    
    public void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Error fetching engagement for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "get_engagement", paramFacebookRequestError);
    }
    
    public void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), "engagement");
      if (paramGraphResponse != null)
      {
        likeCountStringWithLike = paramGraphResponse.optString("count_string_with_like", likeCountStringWithLike);
        likeCountStringWithoutLike = paramGraphResponse.optString("count_string_without_like", likeCountStringWithoutLike);
        socialSentenceStringWithLike = paramGraphResponse.optString("social_sentence_with_like", socialSentenceStringWithLike);
        socialSentenceStringWithoutLike = paramGraphResponse.optString("social_sentence_without_like", socialSentenceStringWithoutLike);
      }
    }
  }
  
  private class GetOGObjectIdRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    public String verifiedObjectId;
    
    public GetOGObjectIdRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      this$1 = new Bundle();
      putString("fields", "og_object.fields(id)");
      putString("ids", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", LikeActionController.this, HttpMethod.HEAD));
    }
    
    public void processError(FacebookRequestError paramFacebookRequestError)
    {
      if (paramFacebookRequestError.getErrorMessage().contains("og_object"))
      {
        error = null;
        return;
      }
      Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
    }
    
    public void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), objectId);
      if (paramGraphResponse != null)
      {
        paramGraphResponse = paramGraphResponse.optJSONObject("og_object");
        if (paramGraphResponse != null) {
          verifiedObjectId = paramGraphResponse.optString("id");
        }
      }
    }
  }
  
  private class GetOGObjectLikesRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
    implements LikeActionController.LikeRequestWrapper
  {
    public final String objectId;
    public boolean objectIsLiked = LikeActionController.access$2500(LikeActionController.this);
    public final LikeView.ObjectType objectType;
    public String unlikeToken;
    
    public GetOGObjectLikesRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      objectId = paramString;
      objectType = paramObjectType;
      this$1 = StringBuilder.put("fields", "id,application");
      putString("object", objectId);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", LikeActionController.this, HttpMethod.HEAD));
    }
    
    public String getUnlikeToken()
    {
      return unlikeToken;
    }
    
    public boolean isObjectLiked()
    {
      return objectIsLiked;
    }
    
    public void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Error fetching like status for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "get_og_object_like", paramFacebookRequestError);
    }
    
    public void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
      if (paramGraphResponse != null)
      {
        int i = 0;
        while (i < paramGraphResponse.length())
        {
          JSONObject localJSONObject1 = paramGraphResponse.optJSONObject(i);
          if (localJSONObject1 != null)
          {
            objectIsLiked = true;
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject("application");
            AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
            if ((localJSONObject2 != null) && (localAccessToken != null) && (Utility.areObjectsEqual(localAccessToken.getApplicationId(), localJSONObject2.optString("id")))) {
              unlikeToken = localJSONObject1.optString("id");
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private class GetPageIdRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    public boolean objectIsPage;
    public String verifiedObjectId;
    
    public GetPageIdRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      this$1 = new Bundle();
      putString("fields", "id");
      putString("ids", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", LikeActionController.this, HttpMethod.HEAD));
    }
    
    public void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
    }
    
    public void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), objectId);
      if (paramGraphResponse != null)
      {
        verifiedObjectId = paramGraphResponse.optString("id");
        objectIsPage = (Utility.isNullOrEmpty(verifiedObjectId) ^ true);
      }
    }
  }
  
  private class GetPageLikesRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
    implements LikeActionController.LikeRequestWrapper
  {
    public boolean objectIsLiked = LikeActionController.access$2500(LikeActionController.this);
    public String pageId;
    
    public GetPageLikesRequestWrapper(String paramString)
    {
      super(paramString, LikeView.ObjectType.PAGE);
      pageId = paramString;
      this$1 = StringBuilder.put("fields", "id");
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), StringBuilder.toString("me/likes/", paramString), LikeActionController.this, HttpMethod.HEAD));
    }
    
    public String getUnlikeToken()
    {
      return null;
    }
    
    public boolean isObjectLiked()
    {
      return objectIsLiked;
    }
    
    public void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Error fetching like status for page id '%s': %s", new Object[] { pageId, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "get_page_like", paramFacebookRequestError);
    }
    
    public void processSuccess(GraphResponse paramGraphResponse)
    {
      paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
      if ((paramGraphResponse != null) && (paramGraphResponse.length() > 0)) {
        objectIsLiked = true;
      }
    }
  }
  
  private static abstract interface LikeRequestWrapper
    extends LikeActionController.RequestWrapper
  {
    public abstract String getUnlikeToken();
    
    public abstract boolean isObjectLiked();
  }
  
  private static class MRUCacheWorkItem
    implements Runnable
  {
    public static ArrayList<String> mruCachedItems = new ArrayList();
    public String cacheItem;
    public boolean shouldTrim;
    
    public MRUCacheWorkItem(String paramString, boolean paramBoolean)
    {
      cacheItem = paramString;
      shouldTrim = paramBoolean;
    }
    
    public void run()
    {
      Object localObject = cacheItem;
      if (localObject != null)
      {
        mruCachedItems.remove(localObject);
        mruCachedItems.add(0, cacheItem);
      }
      if ((shouldTrim) && (mruCachedItems.size() >= 128)) {
        while (64 < mruCachedItems.size())
        {
          localObject = mruCachedItems;
          localObject = (String)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
          LikeActionController.cache.remove(localObject);
        }
      }
    }
  }
  
  private class PublishLikeRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    public String unlikeToken;
    
    public PublishLikeRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      this$1 = StringBuilder.put("object", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", LikeActionController.this, HttpMethod.POST));
    }
    
    public void processError(FacebookRequestError paramFacebookRequestError)
    {
      if (paramFacebookRequestError.getErrorCode() == 3501)
      {
        error = null;
        return;
      }
      Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Error liking object '%s' with type '%s' : %s", new Object[] { objectId, objectType, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "publish_like", paramFacebookRequestError);
    }
    
    public void processSuccess(GraphResponse paramGraphResponse)
    {
      unlikeToken = Utility.safeGetStringFromResponse(paramGraphResponse.getJSONObject(), "id");
    }
  }
  
  private class PublishUnlikeRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    public String unlikeToken;
    
    public PublishUnlikeRequestWrapper(String paramString)
    {
      super(null, null);
      unlikeToken = paramString;
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, null, HttpMethod.DELETE));
    }
    
    public void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.logError(LoggingBehavior.REQUESTS, LikeActionController.val$uri, "Error unliking object with unlike token '%s' : %s", new Object[] { unlikeToken, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "publish_unlike", paramFacebookRequestError);
    }
    
    public void processSuccess(GraphResponse paramGraphResponse) {}
  }
  
  private static abstract interface RequestCompletionCallback
  {
    public abstract void onComplete();
  }
  
  private static abstract interface RequestWrapper
  {
    public abstract void addToBatch(GraphRequestBatch paramGraphRequestBatch);
    
    public abstract FacebookRequestError getError();
  }
  
  private static class SerializeToDiskWorkItem
    implements Runnable
  {
    public String cacheKey;
    public String controllerJson;
    
    public SerializeToDiskWorkItem(String paramString1, String paramString2)
    {
      cacheKey = paramString1;
      controllerJson = paramString2;
    }
    
    public void run()
    {
      LikeActionController.serializeToDiskSynchronously(cacheKey, controllerJson);
    }
  }
}
