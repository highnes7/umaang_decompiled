package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.CollectionMapper.Collection;
import com.facebook.internal.CollectionMapper.OnErrorListener;
import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import com.facebook.internal.CollectionMapper.OnMapperCompleteListener;
import com.facebook.internal.CollectionMapper.ValueMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareApi
{
  public static final String DEFAULT_CHARSET = "UTF-8";
  public static final String DEFAULT_GRAPH_NODE = "me";
  public static final String GRAPH_PATH_FORMAT = "%s/%s";
  public static final String PAGE_KEY = "ShareApi";
  public static final String PHOTOS_EDGE = "photos";
  public String graphNode;
  public String message;
  public final ShareContent shareContent;
  
  public ShareApi(ShareContent paramShareContent)
  {
    shareContent = paramShareContent;
    graphNode = "me";
  }
  
  private void addCommonParameters(Bundle paramBundle, ShareContent paramShareContent)
  {
    List localList = paramShareContent.getPeopleIds();
    if (!Utility.isNullOrEmpty(localList)) {
      paramBundle.putString("tags", TextUtils.join(", ", localList));
    }
    if (!Utility.isNullOrEmpty(paramShareContent.getPlaceId())) {
      paramBundle.putString("place", paramShareContent.getPlaceId());
    }
    if (!Utility.isNullOrEmpty(paramShareContent.getRef())) {
      paramBundle.putString("ref", paramShareContent.getRef());
    }
  }
  
  private String getGraphPath(String paramString)
  {
    Locale localLocale = Locale.ROOT;
    try
    {
      String str = URLEncoder.encode(getGraphNode(), "UTF-8");
      paramString = String.format(localLocale, "%s/%s", new Object[] { str, paramString });
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static void handleImagesOnAction(Bundle paramBundle)
  {
    String str = paramBundle.getString("image");
    if (str != null) {
      try
      {
        JSONArray localJSONArray = new JSONArray(str);
        int i = 0;
        for (;;)
        {
          int j = localJSONArray.length();
          if (i >= j) {
            break;
          }
          Object localObject = localJSONArray.optJSONObject(i);
          if (localObject != null)
          {
            putImageInBundleWithArrayFormat(paramBundle, i, (JSONObject)localObject);
          }
          else
          {
            localObject = localJSONArray.getString(i);
            Locale localLocale = Locale.ROOT;
            paramBundle.putString(String.format(localLocale, "image[%d][url]", new Object[] { Integer.valueOf(i) }), (String)localObject);
          }
          i += 1;
        }
        paramBundle.remove("image");
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          try
          {
            putImageInBundleWithArrayFormat(paramBundle, 0, new JSONObject(str));
            paramBundle.remove("image");
            return;
          }
          catch (JSONException paramBundle) {}
          localJSONException = localJSONException;
        }
      }
    }
  }
  
  public static void putImageInBundleWithArrayFormat(Bundle paramBundle, int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramBundle.putString(String.format(Locale.ROOT, "image[%d][%s]", new Object[] { Integer.valueOf(paramInt), str }), paramJSONObject.get(str).toString());
    }
  }
  
  public static void share(ShareContent paramShareContent, FacebookCallback paramFacebookCallback)
  {
    new ShareApi(paramShareContent).share(paramFacebookCallback);
  }
  
  private void shareLinkContent(ShareLinkContent paramShareLinkContent, final FacebookCallback paramFacebookCallback)
  {
    paramFacebookCallback = new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        Object localObject = paramAnonymousGraphResponse.getJSONObject();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((JSONObject)localObject).optString("id");
        }
        ShareInternalUtility.invokeCallbackWithResults(paramFacebookCallback, (String)localObject, paramAnonymousGraphResponse);
      }
    };
    Bundle localBundle = new Bundle();
    addCommonParameters(localBundle, paramShareLinkContent);
    localBundle.putString("message", getMessage());
    localBundle.putString("link", Utility.getUriString(paramShareLinkContent.getContentUrl()));
    localBundle.putString("picture", Utility.getUriString(paramShareLinkContent.getImageUrl()));
    localBundle.putString("name", paramShareLinkContent.getContentTitle());
    localBundle.putString("description", paramShareLinkContent.getContentDescription());
    localBundle.putString("ref", paramShareLinkContent.getRef());
    new GraphRequest(AccessToken.getCurrentAccessToken(), getGraphPath("feed"), localBundle, HttpMethod.POST, paramFacebookCallback).executeAsync();
  }
  
  private void shareOpenGraphContent(ShareOpenGraphContent paramShareOpenGraphContent, final FacebookCallback paramFacebookCallback)
  {
    final GraphRequest.Callback local1 = new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        Object localObject = paramAnonymousGraphResponse.getJSONObject();
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((JSONObject)localObject).optString("id");
        }
        ShareInternalUtility.invokeCallbackWithResults(paramFacebookCallback, (String)localObject, paramAnonymousGraphResponse);
      }
    };
    final ShareOpenGraphAction localShareOpenGraphAction = paramShareOpenGraphContent.getAction();
    final Bundle localBundle = localShareOpenGraphAction.getBundle();
    addCommonParameters(localBundle, paramShareOpenGraphContent);
    if (!Utility.isNullOrEmpty(getMessage())) {
      localBundle.putString("message", getMessage());
    }
    stageOpenGraphAction(localBundle, new CollectionMapper.OnMapperCompleteListener()
    {
      public void onComplete()
      {
        Object localObject1 = localBundle;
        try
        {
          ShareApi.handleImagesOnAction((Bundle)localObject1);
          localObject1 = AccessToken.getCurrentAccessToken();
          Object localObject2 = ShareApi.this;
          Object localObject3 = localShareOpenGraphAction;
          localObject2 = ShareApi.access$100((ShareApi)localObject2, URLEncoder.encode(((ShareOpenGraphAction)localObject3).getActionType(), "UTF-8"));
          localObject3 = localBundle;
          HttpMethod localHttpMethod = HttpMethod.POST;
          GraphRequest.Callback localCallback = local1;
          new GraphRequest((AccessToken)localObject1, (String)localObject2, (Bundle)localObject3, localHttpMethod, localCallback).executeAsync();
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ShareInternalUtility.invokeCallbackWithException(paramFacebookCallback, localUnsupportedEncodingException);
        }
      }
      
      public void onError(FacebookException paramAnonymousFacebookException)
      {
        ShareInternalUtility.invokeCallbackWithException(paramFacebookCallback, paramAnonymousFacebookException);
      }
    });
  }
  
  private void sharePhotoContent(SharePhotoContent paramSharePhotoContent, final FacebookCallback paramFacebookCallback)
  {
    final Mutable localMutable = new Mutable(Integer.valueOf(0));
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    ArrayList localArrayList = new ArrayList();
    GraphRequest.Callback local3 = new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        Object localObject = paramAnonymousGraphResponse.getJSONObject();
        if (localObject != null) {
          val$results.add(localObject);
        }
        if (paramAnonymousGraphResponse.getError() != null) {
          val$errorResponses.add(paramAnonymousGraphResponse);
        }
        localObject = localMutable;
        value = Integer.valueOf(((Integer)value).intValue() - 1);
        if (((Integer)localMutablevalue).intValue() == 0)
        {
          if (!val$errorResponses.isEmpty())
          {
            ShareInternalUtility.invokeCallbackWithResults(paramFacebookCallback, null, (GraphResponse)val$errorResponses.get(0));
            return;
          }
          if (!val$results.isEmpty())
          {
            localObject = ((JSONObject)val$results.get(0)).optString("id");
            ShareInternalUtility.invokeCallbackWithResults(paramFacebookCallback, (String)localObject, paramAnonymousGraphResponse);
          }
        }
      }
    };
    try
    {
      Iterator localIterator = paramSharePhotoContent.getPhotos().iterator();
      boolean bool;
      Object localObject;
      for (;;)
      {
        bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        paramSharePhotoContent = localIterator.next();
        SharePhoto localSharePhoto = (SharePhoto)paramSharePhotoContent;
        Bitmap localBitmap = localSharePhoto.getBitmap();
        Uri localUri = localSharePhoto.getImageUrl();
        localObject = localSharePhoto.getCaption();
        paramSharePhotoContent = (SharePhotoContent)localObject;
        if (localObject == null) {
          paramSharePhotoContent = getMessage();
        }
        if (localBitmap != null) {
          localArrayList.add(GraphRequest.newUploadPhotoRequest(localAccessToken, getGraphPath("photos"), localBitmap, paramSharePhotoContent, localSharePhoto.getParameters(), local3));
        } else if (localUri != null) {
          localArrayList.add(GraphRequest.newUploadPhotoRequest(localAccessToken, getGraphPath("photos"), localUri, paramSharePhotoContent, localSharePhoto.getParameters(), local3));
        }
      }
      paramSharePhotoContent = (Integer)value;
      int i = paramSharePhotoContent.intValue();
      int j = localArrayList.size();
      value = Integer.valueOf(i + j);
      paramSharePhotoContent = localArrayList.iterator();
      for (;;)
      {
        bool = paramSharePhotoContent.hasNext();
        if (!bool) {
          break;
        }
        localObject = paramSharePhotoContent.next();
        localObject = (GraphRequest)localObject;
        ((GraphRequest)localObject).executeAsync();
      }
      return;
    }
    catch (FileNotFoundException paramSharePhotoContent)
    {
      ShareInternalUtility.invokeCallbackWithException(paramFacebookCallback, (Exception)paramSharePhotoContent);
    }
  }
  
  private void shareVideoContent(ShareVideoContent paramShareVideoContent, FacebookCallback paramFacebookCallback)
  {
    try
    {
      VideoUploader.uploadAsync(paramShareVideoContent, getGraphNode(), paramFacebookCallback);
      return;
    }
    catch (FileNotFoundException paramShareVideoContent)
    {
      ShareInternalUtility.invokeCallbackWithException(paramFacebookCallback, paramShareVideoContent);
    }
  }
  
  private void stageArrayList(final ArrayList paramArrayList, final CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener)
  {
    final JSONArray localJSONArray = new JSONArray();
    stageCollectionValues(new CollectionMapper.Collection()new CollectionMapper.OnMapperCompleteListener
    {
      public Object get(Integer paramAnonymousInteger)
      {
        return paramArrayList.get(paramAnonymousInteger.intValue());
      }
      
      public Iterator keyIterator()
      {
        final int i = paramArrayList.size();
        new Iterator()
        {
          public boolean hasNext()
          {
            return ((Integer)val$current.value).intValue() < i;
          }
          
          public Integer next()
          {
            Mutable localMutable = val$current;
            Object localObject = value;
            Integer localInteger = (Integer)localObject;
            value = Integer.valueOf(((Integer)localObject).intValue() + 1);
            return localInteger;
          }
          
          public void remove() {}
        };
      }
      
      public void put(Integer paramAnonymousInteger, Object paramAnonymousObject, CollectionMapper.OnErrorListener paramAnonymousOnErrorListener)
      {
        JSONArray localJSONArray = localJSONArray;
        try
        {
          localJSONArray.put(paramAnonymousInteger.intValue(), paramAnonymousObject);
          return;
        }
        catch (JSONException paramAnonymousInteger)
        {
          paramAnonymousObject = paramAnonymousInteger.getLocalizedMessage();
          paramAnonymousInteger = paramAnonymousObject;
          if (paramAnonymousObject == null) {
            paramAnonymousInteger = "Error staging object.";
          }
          paramAnonymousOnErrorListener.onError(new FacebookException(paramAnonymousInteger));
        }
      }
    }, new CollectionMapper.OnMapperCompleteListener()
    {
      public void onComplete()
      {
        paramOnMapValueCompleteListener.onComplete(localJSONArray);
      }
      
      public void onError(FacebookException paramAnonymousFacebookException)
      {
        paramOnMapValueCompleteListener.onError(paramAnonymousFacebookException);
      }
    });
  }
  
  private void stageCollectionValues(CollectionMapper.Collection paramCollection, CollectionMapper.OnMapperCompleteListener paramOnMapperCompleteListener)
  {
    CollectionMapper.iterate(paramCollection, new CollectionMapper.ValueMapper()
    {
      public void mapValue(Object paramAnonymousObject, CollectionMapper.OnMapValueCompleteListener paramAnonymousOnMapValueCompleteListener)
      {
        if ((paramAnonymousObject instanceof ArrayList))
        {
          ShareApi.access$200(ShareApi.this, (ArrayList)paramAnonymousObject, paramAnonymousOnMapValueCompleteListener);
          return;
        }
        if ((paramAnonymousObject instanceof ShareOpenGraphObject))
        {
          ShareApi.access$300(ShareApi.this, (ShareOpenGraphObject)paramAnonymousObject, paramAnonymousOnMapValueCompleteListener);
          return;
        }
        if ((paramAnonymousObject instanceof SharePhoto))
        {
          ShareApi.access$400(ShareApi.this, (SharePhoto)paramAnonymousObject, paramAnonymousOnMapValueCompleteListener);
          return;
        }
        paramAnonymousOnMapValueCompleteListener.onComplete(paramAnonymousObject);
      }
    }, paramOnMapperCompleteListener);
  }
  
  private void stageOpenGraphAction(final Bundle paramBundle, CollectionMapper.OnMapperCompleteListener paramOnMapperCompleteListener)
  {
    stageCollectionValues(new CollectionMapper.Collection()
    {
      public void d(String paramAnonymousString, Object paramAnonymousObject, CollectionMapper.OnErrorListener paramAnonymousOnErrorListener)
      {
        if (!Utility.putJSONValueInBundle(paramBundle, paramAnonymousString, paramAnonymousObject))
        {
          paramAnonymousString = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unexpected value: ");
          paramAnonymousString.append(paramAnonymousObject.toString());
          paramAnonymousOnErrorListener.onError(new FacebookException(paramAnonymousString.toString()));
        }
      }
      
      public Object internalGet(String paramAnonymousString)
      {
        return paramBundle.get(paramAnonymousString);
      }
      
      public Iterator keyIterator()
      {
        return paramBundle.keySet().iterator();
      }
    }, paramOnMapperCompleteListener);
  }
  
  private void stageOpenGraphObject(final ShareOpenGraphObject paramShareOpenGraphObject, final CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener)
  {
    Object localObject2 = paramShareOpenGraphObject.getString("type");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramShareOpenGraphObject.getString("og:type");
    }
    if (localObject1 == null)
    {
      paramOnMapValueCompleteListener.onError(new FacebookException("Open Graph objects must contain a type value."));
      return;
    }
    localObject2 = new JSONObject();
    stageCollectionValues(new CollectionMapper.Collection()new CollectionMapper.OnMapperCompleteListener
    {
      public void commit(String paramAnonymousString, Object paramAnonymousObject, CollectionMapper.OnErrorListener paramAnonymousOnErrorListener)
      {
        JSONObject localJSONObject = val$stagedObject;
        try
        {
          localJSONObject.put(paramAnonymousString, paramAnonymousObject);
          return;
        }
        catch (JSONException paramAnonymousString)
        {
          paramAnonymousObject = paramAnonymousString.getLocalizedMessage();
          paramAnonymousString = paramAnonymousObject;
          if (paramAnonymousObject == null) {
            paramAnonymousString = "Error staging object.";
          }
          paramAnonymousOnErrorListener.onError(new FacebookException(paramAnonymousString));
        }
      }
      
      public Object get(String paramAnonymousString)
      {
        return paramShareOpenGraphObject.getProperty(paramAnonymousString);
      }
      
      public Iterator keyIterator()
      {
        return paramShareOpenGraphObject.keySet().iterator();
      }
    }, new CollectionMapper.OnMapperCompleteListener()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        Object localObject = paramAnonymousGraphResponse.getError();
        if (localObject != null)
        {
          String str = ((FacebookRequestError)localObject).getErrorMessage();
          localObject = str;
          if (str == null) {
            localObject = "Error staging Open Graph object.";
          }
          paramOnMapValueCompleteListener.onError(new FacebookGraphResponseException(paramAnonymousGraphResponse, (String)localObject));
          return;
        }
        localObject = paramAnonymousGraphResponse.getJSONObject();
        if (localObject == null)
        {
          paramOnMapValueCompleteListener.onError(new FacebookGraphResponseException(paramAnonymousGraphResponse, "Error staging Open Graph object."));
          return;
        }
        localObject = ((JSONObject)localObject).optString("id");
        if (localObject == null)
        {
          paramOnMapValueCompleteListener.onError(new FacebookGraphResponseException(paramAnonymousGraphResponse, "Error staging Open Graph object."));
          return;
        }
        paramOnMapValueCompleteListener.onComplete(localObject);
      }
    }
    {
      public void onComplete()
      {
        Bundle localBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.put("object", val$stagedObject.toString());
        try
        {
          localObject2 = AccessToken.getCurrentAccessToken();
          Object localObject3 = ShareApi.this;
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("objects/");
          Object localObject5 = val$ogType;
          ((StringBuilder)localObject4).append(URLEncoder.encode((String)localObject5, "UTF-8"));
          localObject3 = ShareApi.access$100((ShareApi)localObject3, ((StringBuilder)localObject4).toString());
          localObject4 = HttpMethod.POST;
          localObject5 = val$requestCallback;
          new GraphRequest((AccessToken)localObject2, (String)localObject3, localBundle, (HttpMethod)localObject4, (GraphRequest.Callback)localObject5).executeAsync();
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Object localObject2 = localUnsupportedEncodingException.getLocalizedMessage();
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "Error staging Open Graph object.";
          }
          paramOnMapValueCompleteListener.onError(new FacebookException((String)localObject1));
        }
      }
      
      public void onError(FacebookException paramAnonymousFacebookException)
      {
        paramOnMapValueCompleteListener.onError(paramAnonymousFacebookException);
      }
    });
  }
  
  private void stagePhoto(final SharePhoto paramSharePhoto, final CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener)
  {
    Object localObject = paramSharePhoto.getBitmap();
    Uri localUri = paramSharePhoto.getImageUrl();
    if ((localObject == null) && (localUri == null))
    {
      paramOnMapValueCompleteListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
      return;
    }
    paramSharePhoto = new GraphRequest.Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        Object localObject = paramAnonymousGraphResponse.getError();
        if (localObject != null)
        {
          String str = ((FacebookRequestError)localObject).getErrorMessage();
          localObject = str;
          if (str == null) {
            localObject = "Error staging photo.";
          }
          paramOnMapValueCompleteListener.onError(new FacebookGraphResponseException(paramAnonymousGraphResponse, (String)localObject));
          return;
        }
        paramAnonymousGraphResponse = paramAnonymousGraphResponse.getJSONObject();
        if (paramAnonymousGraphResponse == null)
        {
          paramOnMapValueCompleteListener.onError(new FacebookException("Error staging photo."));
          return;
        }
        localObject = paramAnonymousGraphResponse.optString("uri");
        if (localObject == null)
        {
          paramOnMapValueCompleteListener.onError(new FacebookException("Error staging photo."));
          return;
        }
        paramAnonymousGraphResponse = new JSONObject();
        try
        {
          paramAnonymousGraphResponse.put("url", localObject);
          localObject = paramSharePhoto;
          paramAnonymousGraphResponse.get("user_generated", ((SharePhoto)localObject).getUserGenerated());
          paramOnMapValueCompleteListener.onComplete(paramAnonymousGraphResponse);
          return;
        }
        catch (JSONException paramAnonymousGraphResponse)
        {
          localObject = paramAnonymousGraphResponse.getLocalizedMessage();
          paramAnonymousGraphResponse = (GraphResponse)localObject;
          if (localObject == null) {
            paramAnonymousGraphResponse = "Error staging photo.";
          }
          paramOnMapValueCompleteListener.onError(new FacebookException(paramAnonymousGraphResponse));
        }
      }
    };
    if (localObject != null)
    {
      ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), (Bitmap)localObject, paramSharePhoto).executeAsync();
      return;
    }
    try
    {
      ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), localUri, paramSharePhoto).executeAsync();
      return;
    }
    catch (FileNotFoundException paramSharePhoto)
    {
      localObject = paramSharePhoto.getLocalizedMessage();
      paramSharePhoto = (SharePhoto)localObject;
      if (localObject == null) {
        paramSharePhoto = "Error staging photo.";
      }
      paramOnMapValueCompleteListener.onError(new FacebookException(paramSharePhoto));
    }
  }
  
  public boolean canShare()
  {
    if (getShareContent() == null) {
      return false;
    }
    Object localObject = AccessToken.getCurrentAccessToken();
    if (localObject == null) {
      return false;
    }
    localObject = ((AccessToken)localObject).getPermissions();
    if (localObject != null) {
      ((Set)localObject).contains("publish_actions");
    }
    return true;
  }
  
  public String getGraphNode()
  {
    return graphNode;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public ShareContent getShareContent()
  {
    return shareContent;
  }
  
  public void setGraphNode(String paramString)
  {
    graphNode = paramString;
  }
  
  public void setMessage(String paramString)
  {
    message = paramString;
  }
  
  public void share(FacebookCallback paramFacebookCallback)
  {
    if (!canShare())
    {
      ShareInternalUtility.invokeOnErrorCallback(paramFacebookCallback, "Insufficient permissions for sharing content via Api.");
      return;
    }
    ShareContent localShareContent = getShareContent();
    try
    {
      ShareContentValidation.validateForApiShare(localShareContent);
      if ((localShareContent instanceof ShareLinkContent))
      {
        shareLinkContent((ShareLinkContent)localShareContent, paramFacebookCallback);
        return;
      }
      if ((localShareContent instanceof SharePhotoContent))
      {
        sharePhotoContent((SharePhotoContent)localShareContent, paramFacebookCallback);
        return;
      }
      if ((localShareContent instanceof ShareVideoContent))
      {
        shareVideoContent((ShareVideoContent)localShareContent, paramFacebookCallback);
        return;
      }
      if ((localShareContent instanceof ShareOpenGraphContent))
      {
        shareOpenGraphContent((ShareOpenGraphContent)localShareContent, paramFacebookCallback);
        return;
      }
    }
    catch (FacebookException localFacebookException)
    {
      ShareInternalUtility.invokeCallbackWithException(paramFacebookCallback, localFacebookException);
    }
  }
}
