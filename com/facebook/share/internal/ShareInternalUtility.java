package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView.ObjectType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareInternalUtility
{
  public static final String MY_PHOTOS = "me/photos";
  public static final String MY_STAGING_RESOURCES = "me/staging_resources";
  public static final String STAGING_PARAM = "file";
  
  public ShareInternalUtility() {}
  
  public static AppCall getAppCallFromActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = NativeProtocol.getCallIdFromIntent(paramIntent);
    if (paramIntent == null) {
      return null;
    }
    return AppCall.finishPendingCall(paramIntent, paramInt1);
  }
  
  public static NativeAppCallAttachmentStore.Attachment getAttachment(UUID paramUUID, SharePhoto paramSharePhoto)
  {
    Bitmap localBitmap = paramSharePhoto.getBitmap();
    paramSharePhoto = paramSharePhoto.getImageUrl();
    if (localBitmap != null) {
      return NativeAppCallAttachmentStore.createAttachment(paramUUID, localBitmap);
    }
    if (paramSharePhoto != null) {
      return NativeAppCallAttachmentStore.createAttachment(paramUUID, paramSharePhoto);
    }
    return null;
  }
  
  public static Pair getFieldNameAndNamespaceFromFullName(String paramString)
  {
    int i = paramString.indexOf(':');
    if (i != -1)
    {
      int j = paramString.length();
      int k = i + 1;
      if (j > k)
      {
        localObject = paramString.substring(0, i);
        str = paramString.substring(k);
        paramString = (String)localObject;
        localObject = str;
        break label60;
      }
    }
    String str = null;
    Object localObject = paramString;
    paramString = str;
    label60:
    return new Pair(paramString, localObject);
  }
  
  public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType paramObjectType1, LikeView.ObjectType paramObjectType2)
  {
    if (paramObjectType1 == paramObjectType2) {
      return paramObjectType1;
    }
    LikeView.ObjectType localObjectType = LikeView.ObjectType.UNKNOWN;
    if (paramObjectType1 == localObjectType) {
      return paramObjectType2;
    }
    if (paramObjectType2 == localObjectType) {
      return paramObjectType1;
    }
    return null;
  }
  
  public static String getNativeDialogCompletionGesture(Bundle paramBundle)
  {
    if (paramBundle.containsKey("completionGesture")) {
      return paramBundle.getString("completionGesture");
    }
    return paramBundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
  }
  
  public static List getPhotoUrls(SharePhotoContent paramSharePhotoContent, UUID paramUUID)
  {
    if (paramSharePhotoContent != null)
    {
      paramSharePhotoContent = paramSharePhotoContent.getPhotos();
      if (paramSharePhotoContent != null)
      {
        paramSharePhotoContent = Utility.filter(paramSharePhotoContent, new Utility.Mapper()
        {
          public NativeAppCallAttachmentStore.Attachment apply(SharePhoto paramAnonymousSharePhoto)
          {
            return ShareInternalUtility.getAttachment(val$appCallId, paramAnonymousSharePhoto);
          }
        });
        paramUUID = Utility.filter(paramSharePhotoContent, new Utility.Mapper()
        {
          public String apply(NativeAppCallAttachmentStore.Attachment paramAnonymousAttachment)
          {
            return paramAnonymousAttachment.getAttachmentUrl();
          }
        });
        NativeAppCallAttachmentStore.addAttachments(paramSharePhotoContent);
        return paramUUID;
      }
    }
    return null;
  }
  
  public static String getShareDialogPostId(Bundle paramBundle)
  {
    if (paramBundle.containsKey("postId")) {
      return paramBundle.getString("postId");
    }
    if (paramBundle.containsKey("com.facebook.platform.extra.POST_ID")) {
      return paramBundle.getString("com.facebook.platform.extra.POST_ID");
    }
    return paramBundle.getString("post_id");
  }
  
  public static ResultProcessor getShareResultProcessor(final FacebookCallback paramFacebookCallback)
  {
    new ResultProcessor(paramFacebookCallback)
    {
      public void onCancel(AppCall paramAnonymousAppCall)
      {
        ShareInternalUtility.invokeOnCancelCallback(paramFacebookCallback);
      }
      
      public void onError(AppCall paramAnonymousAppCall, FacebookException paramAnonymousFacebookException)
      {
        ShareInternalUtility.invokeOnErrorCallback(paramFacebookCallback, paramAnonymousFacebookException);
      }
      
      public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
      {
        if (paramAnonymousBundle != null)
        {
          paramAnonymousAppCall = ShareInternalUtility.getNativeDialogCompletionGesture(paramAnonymousBundle);
          if ((paramAnonymousAppCall != null) && (!"post".equalsIgnoreCase(paramAnonymousAppCall)))
          {
            if ("cancel".equalsIgnoreCase(paramAnonymousAppCall))
            {
              ShareInternalUtility.invokeOnCancelCallback(paramFacebookCallback);
              return;
            }
            ShareInternalUtility.invokeOnErrorCallback(paramFacebookCallback, new FacebookException("UnknownError"));
            return;
          }
          paramAnonymousAppCall = ShareInternalUtility.getShareDialogPostId(paramAnonymousBundle);
          ShareInternalUtility.invokeOnSuccessCallback(paramFacebookCallback, paramAnonymousAppCall);
        }
      }
    };
  }
  
  public static String getVideoUrl(ShareVideoContent paramShareVideoContent, UUID paramUUID)
  {
    if ((paramShareVideoContent != null) && (paramShareVideoContent.getVideo() != null))
    {
      paramShareVideoContent = NativeAppCallAttachmentStore.createAttachment(paramUUID, paramShareVideoContent.getVideo().getLocalUrl());
      paramUUID = new ArrayList(1);
      paramUUID.add(paramShareVideoContent);
      NativeAppCallAttachmentStore.addAttachments(paramUUID);
      return paramShareVideoContent.getAttachmentUrl();
    }
    return null;
  }
  
  public static boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent, ResultProcessor paramResultProcessor)
  {
    AppCall localAppCall = getAppCallFromActivityResult(paramInt1, paramInt2, paramIntent);
    if (localAppCall == null) {
      return false;
    }
    NativeAppCallAttachmentStore.cleanupAttachmentsForCall(localAppCall.getCallId());
    if (paramResultProcessor == null) {
      return true;
    }
    FacebookException localFacebookException = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(paramIntent));
    if (localFacebookException != null)
    {
      if ((localFacebookException instanceof FacebookOperationCanceledException))
      {
        paramResultProcessor.onCancel(localAppCall);
        return true;
      }
      paramResultProcessor.onError(localAppCall, localFacebookException);
      return true;
    }
    paramResultProcessor.onSuccess(localAppCall, NativeProtocol.getSuccessResultsFromIntent(paramIntent));
    return true;
  }
  
  public static void invokeCallbackWithError(FacebookCallback paramFacebookCallback, String paramString)
  {
    invokeOnErrorCallback(paramFacebookCallback, paramString);
  }
  
  public static void invokeCallbackWithException(FacebookCallback paramFacebookCallback, Exception paramException)
  {
    if ((paramException instanceof FacebookException))
    {
      invokeOnErrorCallback(paramFacebookCallback, (FacebookException)paramException);
      return;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Error preparing share content: ");
    localStringBuilder.append(paramException.getLocalizedMessage());
    invokeOnErrorCallback(paramFacebookCallback, localStringBuilder.toString());
  }
  
  public static void invokeCallbackWithResults(FacebookCallback paramFacebookCallback, String paramString, GraphResponse paramGraphResponse)
  {
    Object localObject = paramGraphResponse.getError();
    if (localObject != null)
    {
      localObject = ((FacebookRequestError)localObject).getErrorMessage();
      paramString = (String)localObject;
      if (Utility.isNullOrEmpty((String)localObject)) {
        paramString = "Unexpected error sharing.";
      }
      invokeOnErrorCallback(paramFacebookCallback, paramGraphResponse, paramString);
      return;
    }
    invokeOnSuccessCallback(paramFacebookCallback, paramString);
  }
  
  public static void invokeOnCancelCallback(FacebookCallback paramFacebookCallback)
  {
    logShareResult("cancelled", null);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onCancel();
    }
  }
  
  public static void invokeOnErrorCallback(FacebookCallback paramFacebookCallback, FacebookException paramFacebookException)
  {
    logShareResult("error", paramFacebookException.getMessage());
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(paramFacebookException);
    }
  }
  
  public static void invokeOnErrorCallback(FacebookCallback paramFacebookCallback, GraphResponse paramGraphResponse, String paramString)
  {
    logShareResult("error", paramString);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(new FacebookGraphResponseException(paramGraphResponse, paramString));
    }
  }
  
  public static void invokeOnErrorCallback(FacebookCallback paramFacebookCallback, String paramString)
  {
    logShareResult("error", paramString);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(new FacebookException(paramString));
    }
  }
  
  public static void invokeOnSuccessCallback(FacebookCallback paramFacebookCallback, String paramString)
  {
    logShareResult("succeeded", null);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onSuccess(new Sharer.Result(paramString));
    }
  }
  
  public static void logShareResult(String paramString1, String paramString2)
  {
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
    paramString1 = f.sufficientlysecure.rootcommands.util.StringBuilder.put("fb_share_dialog_outcome", paramString1);
    if (paramString2 != null) {
      paramString1.putString("error_message", paramString2);
    }
    localAppEventsLogger.logSdkEvent("fb_share_dialog_result", null, paramString1);
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, Bitmap paramBitmap, GraphRequest.Callback paramCallback)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramBitmap);
    return new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, Uri paramUri, GraphRequest.Callback paramCallback)
    throws FileNotFoundException
  {
    if (Utility.isFileUri(paramUri)) {
      return newUploadStagingResourceWithImageRequest(paramAccessToken, new File(paramUri.getPath()), paramCallback);
    }
    if (Utility.isContentUri(paramUri))
    {
      paramUri = new GraphRequest.ParcelableResourceWithMimeType(paramUri, "image/png");
      Bundle localBundle = new Bundle(1);
      localBundle.putParcelable("file", paramUri);
      return new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
    }
    throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, File paramFile, GraphRequest.Callback paramCallback)
    throws FileNotFoundException
  {
    paramFile = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(paramFile, 268435456), "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramFile);
    return new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
  }
  
  public static void registerSharerCallback(int paramInt, CallbackManager paramCallbackManager, final FacebookCallback paramFacebookCallback)
  {
    if ((paramCallbackManager instanceof CallbackManagerImpl))
    {
      ((CallbackManagerImpl)paramCallbackManager).registerCallback(paramInt, new CallbackManagerImpl.Callback()
      {
        public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          return ShareInternalUtility.handleActivityResult(val$requestCode, paramAnonymousInt, paramAnonymousIntent, ShareInternalUtility.getShareResultProcessor(paramFacebookCallback));
        }
      });
      return;
    }
    throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
  }
  
  public static void registerStaticShareCallback(int paramInt)
  {
    CallbackManagerImpl.registerStaticCallback(paramInt, new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        return ShareInternalUtility.handleActivityResult(val$requestCode, paramAnonymousInt, paramAnonymousIntent, ShareInternalUtility.getShareResultProcessor(null));
      }
    });
  }
  
  public static JSONArray removeNamespacesFromOGJsonArray(JSONArray paramJSONArray, boolean paramBoolean)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.get(i);
      Object localObject1 = localObject2;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = removeNamespacesFromOGJsonArray((JSONArray)localObject2, paramBoolean);
      } else if ((localObject2 instanceof JSONObject)) {
        localObject1 = removeNamespacesFromOGJsonObject((JSONObject)localObject2, paramBoolean);
      }
      localJSONArray.put(localObject1);
      i += 1;
    }
    return localJSONArray;
  }
  
  public static JSONObject removeNamespacesFromOGJsonObject(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return null;
    }
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONArray localJSONArray = paramJSONObject.names();
      int i = 0;
      for (;;)
      {
        int j = localJSONArray.length();
        if (i >= j) {
          break;
        }
        String str = localJSONArray.getString(i);
        Object localObject2 = paramJSONObject.get(str);
        Object localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject))
        {
          localObject1 = (JSONObject)localObject2;
          localObject1 = removeNamespacesFromOGJsonObject((JSONObject)localObject1, true);
        }
        else if ((localObject2 instanceof JSONArray))
        {
          localObject1 = (JSONArray)localObject2;
          localObject1 = removeNamespacesFromOGJsonArray((JSONArray)localObject1, true);
        }
        Object localObject3 = getFieldNameAndNamespaceFromFullName(str);
        localObject2 = (String)first;
        localObject3 = (String)second;
        boolean bool;
        if (paramBoolean)
        {
          if (localObject2 != null)
          {
            bool = ((String)localObject2).equals("fbsdk");
            if (bool)
            {
              localJSONObject1.put(str, localObject1);
              break label268;
            }
          }
          if (localObject2 != null)
          {
            bool = ((String)localObject2).equals("og");
            if (!bool)
            {
              localJSONObject2.put((String)localObject3, localObject1);
              break label268;
            }
          }
          localJSONObject1.put((String)localObject3, localObject1);
        }
        else
        {
          if (localObject2 != null)
          {
            bool = ((String)localObject2).equals("fb");
            if (bool)
            {
              localJSONObject1.put(str, localObject1);
              break label268;
            }
          }
          localJSONObject1.put((String)localObject3, localObject1);
        }
        label268:
        i += 1;
      }
      i = localJSONObject2.length();
      if (i <= 0) {
        break label319;
      }
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;) {}
    }
    paramJSONObject = new FacebookException("Failed to create json object from share content");
    throw paramJSONObject;
    label319:
    return localJSONObject1;
  }
  
  public static JSONObject toJSONObjectForCall(UUID paramUUID, ShareOpenGraphContent paramShareOpenGraphContent)
    throws JSONException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent paramShareOpenGraphContent)
    throws JSONException
  {
    OpenGraphJSONUtility.toJSONObject(paramShareOpenGraphContent.getAction(), new OpenGraphJSONUtility.PhotoJSONProcessor()
    {
      public JSONObject toJSONObject(SharePhoto paramAnonymousSharePhoto)
      {
        paramAnonymousSharePhoto = paramAnonymousSharePhoto.getImageUrl();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("url", paramAnonymousSharePhoto.toString());
          return localJSONObject;
        }
        catch (JSONException paramAnonymousSharePhoto)
        {
          throw new FacebookException("Unable to attach images", paramAnonymousSharePhoto);
        }
      }
    });
  }
}
