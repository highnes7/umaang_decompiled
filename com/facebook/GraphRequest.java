package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest
{
  public static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
  public static final String ACCESS_TOKEN_PARAM = "access_token";
  public static final String ATTACHED_FILES_PARAM = "attached_files";
  public static final String ATTACHMENT_FILENAME_PREFIX = "file";
  public static final String BATCH_APP_ID_PARAM = "batch_app_id";
  public static final String BATCH_BODY_PARAM = "body";
  public static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
  public static final String BATCH_ENTRY_NAME_PARAM = "name";
  public static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
  public static final String BATCH_METHOD_PARAM = "method";
  public static final String BATCH_PARAM = "batch";
  public static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
  public static final String CAPTION_PARAM = "caption";
  public static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
  public static final String CONTENT_TYPE_HEADER = "Content-Type";
  public static final String DEBUG_KEY = "__debug__";
  public static final String DEBUG_MESSAGES_KEY = "messages";
  public static final String DEBUG_MESSAGE_KEY = "message";
  public static final String DEBUG_MESSAGE_LINK_KEY = "link";
  public static final String DEBUG_MESSAGE_TYPE_KEY = "type";
  public static final String DEBUG_PARAM = "debug";
  public static final String DEBUG_SEVERITY_INFO = "info";
  public static final String DEBUG_SEVERITY_WARNING = "warning";
  public static final String FIELDS_PARAM = "fields";
  public static final String FORMAT_JSON = "json";
  public static final String FORMAT_PARAM = "format";
  public static final String GRAPH_PATH_FORMAT = "%s/%s";
  public static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
  public static final int MAXIMUM_BATCH_SIZE = 50;
  public static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
  public static final String MY_FRIENDS = "me/friends";
  public static final String MY_PHOTOS = "me/photos";
  public static final String PICTURE_PARAM = "picture";
  public static final String SDK_ANDROID = "android";
  public static final String SDK_PARAM = "sdk";
  public static final String SEARCH = "search";
  public static final String SQL_UPDATE_6_4 = "me";
  public static final String USER_AGENT_BASE = "FBAndroidSDK";
  public static final String USER_AGENT_HEADER = "User-Agent";
  public static final String VIDEOS_SUFFIX = "/videos";
  public static String defaultBatchApplicationId;
  public static final String state = "GraphRequest";
  public static volatile String userAgent;
  public static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
  public AccessToken accessToken;
  public String batchEntryDependsOn;
  public String batchEntryName;
  public boolean batchEntryOmitResultOnSuccess = true;
  public Callback callback;
  public JSONObject graphObject;
  public String graphPath;
  public HttpMethod httpMethod;
  public Object mTag;
  public String overriddenURL;
  public Bundle parameters;
  public boolean skipClientToken = false;
  public String version;
  
  public GraphRequest()
  {
    this(null, null, null, null, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString)
  {
    this(paramAccessToken, paramString, null, null, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod)
  {
    this(paramAccessToken, paramString, paramBundle, paramHttpMethod, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback)
  {
    this(paramAccessToken, paramString, paramBundle, paramHttpMethod, paramCallback, null);
  }
  
  public GraphRequest(AccessToken paramAccessToken, String paramString1, Bundle paramBundle, HttpMethod paramHttpMethod, Callback paramCallback, String paramString2)
  {
    accessToken = paramAccessToken;
    graphPath = paramString1;
    version = paramString2;
    setCallback(paramCallback);
    setHttpMethod(paramHttpMethod);
    if (paramBundle != null) {
      parameters = new Bundle(paramBundle);
    } else {
      parameters = new Bundle();
    }
    if (version == null) {
      version = ServerProtocol.getAPIVersion();
    }
  }
  
  public GraphRequest(AccessToken paramAccessToken, URL paramURL)
  {
    accessToken = paramAccessToken;
    overriddenURL = paramURL.toString();
    setHttpMethod(HttpMethod.HEAD);
    parameters = new Bundle();
  }
  
  private void addCommonParameters()
  {
    String str1;
    if (accessToken != null)
    {
      if (!parameters.containsKey("access_token"))
      {
        str1 = accessToken.getToken();
        Logger.registerAccessToken(str1);
        parameters.putString("access_token", str1);
      }
    }
    else if ((!skipClientToken) && (!parameters.containsKey("access_token")))
    {
      str1 = FacebookSdk.getApplicationId();
      String str2 = FacebookSdk.getClientToken();
      if ((!Utility.isNullOrEmpty(str1)) && (!Utility.isNullOrEmpty(str2)))
      {
        str1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str1, "|", str2);
        parameters.putString("access_token", str1);
      }
      else
      {
        str1 = state;
      }
    }
    parameters.putString("sdk", "android");
    parameters.putString("format", "json");
    if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO))
    {
      parameters.putString("debug", "info");
      return;
    }
    if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
      parameters.putString("debug", "warning");
    }
  }
  
  private String appendParametersToBaseUrl(String paramString)
  {
    Uri.Builder localBuilder = new Uri.Builder().encodedPath(paramString);
    Iterator localIterator = parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = parameters.get(str);
      paramString = localObject;
      if (localObject == null) {
        paramString = "";
      }
      if (isSupportedParameterType(paramString)) {
        localBuilder.appendQueryParameter(str, parameterToString(paramString).toString());
      } else if (httpMethod == HttpMethod.HEAD) {
        throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[] { paramString.getClass().getSimpleName() }));
      }
    }
    return localBuilder.toString();
  }
  
  public static HttpURLConnection createConnection(URL paramURL)
    throws IOException
  {
    paramURL = (HttpURLConnection)paramURL.openConnection();
    paramURL.setRequestProperty("User-Agent", getUserAgent());
    paramURL.setRequestProperty("Accept-Language", Locale.getDefault().toString());
    paramURL.setChunkedStreamingMode(0);
    return paramURL;
  }
  
  public static GraphRequest createOpenGraphObject(ShareOpenGraphObject paramShareOpenGraphObject)
    throws FacebookException
  {
    Object localObject2 = paramShareOpenGraphObject.getString("type");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramShareOpenGraphObject.getString("og:type");
    }
    if (localObject1 != null) {
      try
      {
        paramShareOpenGraphObject = OpenGraphJSONUtility.toJSONValue(paramShareOpenGraphObject, new OpenGraphJSONUtility.PhotoJSONProcessor()
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
            catch (Exception paramAnonymousSharePhoto)
            {
              throw new FacebookException("Unable to attach images", paramAnonymousSharePhoto);
            }
          }
        });
        localObject2 = (JSONObject)paramShareOpenGraphObject;
        paramShareOpenGraphObject = new Bundle();
        paramShareOpenGraphObject.putString("object", ((JSONObject)localObject2).toString());
        localObject2 = Locale.ROOT;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("objects/");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject3).toString();
        localObject1 = String.format((Locale)localObject2, "%s/%s", new Object[] { "me", localObject1 });
        localObject2 = AccessToken.getCurrentAccessToken();
        localObject3 = HttpMethod.POST;
        paramShareOpenGraphObject = new GraphRequest((AccessToken)localObject2, (String)localObject1, paramShareOpenGraphObject, (HttpMethod)localObject3);
        return paramShareOpenGraphObject;
      }
      catch (JSONException paramShareOpenGraphObject)
      {
        throw new FacebookException(paramShareOpenGraphObject.getMessage());
      }
    }
    throw new FacebookException("Open graph object type cannot be null");
  }
  
  public static GraphResponse executeAndWait(GraphRequest paramGraphRequest)
  {
    paramGraphRequest = executeBatchAndWait(new GraphRequest[] { paramGraphRequest });
    if (paramGraphRequest.size() == 1) {
      return (GraphResponse)paramGraphRequest.get(0);
    }
    throw new FacebookException("invalid state: expected a single response");
  }
  
  public static List executeBatchAndWait(GraphRequestBatch paramGraphRequestBatch)
  {
    Validate.containsNoNulls(paramGraphRequestBatch, "requests");
    Validate.notEmpty(paramGraphRequestBatch, "requests");
    try
    {
      HttpURLConnection localHttpURLConnection = toHttpConnection(paramGraphRequestBatch);
      return executeConnectionAndWait(localHttpURLConnection, paramGraphRequestBatch);
    }
    catch (Exception localException)
    {
      List localList = GraphResponse.constructErrorResponses(paramGraphRequestBatch.getRequests(), null, new FacebookException(localException));
      runCallbacks(paramGraphRequestBatch, localList);
      return localList;
    }
  }
  
  public static List executeBatchAndWait(Collection paramCollection)
  {
    return executeBatchAndWait(new GraphRequestBatch(paramCollection));
  }
  
  public static List executeBatchAndWait(GraphRequest... paramVarArgs)
  {
    Validate.notNull(paramVarArgs, "requests");
    return executeBatchAndWait(Arrays.asList(paramVarArgs));
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch paramGraphRequestBatch)
  {
    Validate.containsNoNulls(paramGraphRequestBatch, "requests");
    Validate.notEmpty(paramGraphRequestBatch, "requests");
    paramGraphRequestBatch = new GraphRequestAsyncTask(null, paramGraphRequestBatch);
    paramGraphRequestBatch.executeOnExecutor(FacebookSdk.getExecutor(), null);
    return paramGraphRequestBatch;
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(Collection paramCollection)
  {
    return executeBatchAsync(new GraphRequestBatch(paramCollection));
  }
  
  public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... paramVarArgs)
  {
    Validate.notNull(paramVarArgs, "requests");
    return executeBatchAsync(Arrays.asList(paramVarArgs));
  }
  
  public static List executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    List localList = GraphResponse.fromHttpConnection(paramHttpURLConnection, paramGraphRequestBatch);
    Utility.disconnectQuietly(paramHttpURLConnection);
    int i = paramGraphRequestBatch.size();
    if (i == localList.size())
    {
      runCallbacks(paramGraphRequestBatch, localList);
      AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
      return localList;
    }
    throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i) }));
  }
  
  public static List executeConnectionAndWait(HttpURLConnection paramHttpURLConnection, Collection paramCollection)
  {
    return executeConnectionAndWait(paramHttpURLConnection, new GraphRequestBatch(paramCollection));
  }
  
  public static GraphRequestAsyncTask executeConnectionAsync(Handler paramHandler, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    Validate.notNull(paramHttpURLConnection, "connection");
    paramHttpURLConnection = new GraphRequestAsyncTask(paramHttpURLConnection, paramGraphRequestBatch);
    paramGraphRequestBatch.setCallbackHandler(paramHandler);
    paramHttpURLConnection.executeOnExecutor(FacebookSdk.getExecutor(), null);
    return paramHttpURLConnection;
  }
  
  public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    return executeConnectionAsync(null, paramHttpURLConnection, paramGraphRequestBatch);
  }
  
  public static String getBatchAppId(GraphRequestBatch paramGraphRequestBatch)
  {
    if (!Utility.isNullOrEmpty(paramGraphRequestBatch.getBatchApplicationId())) {
      return paramGraphRequestBatch.getBatchApplicationId();
    }
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext())
    {
      Object localObject = nextaccessToken;
      if (localObject != null)
      {
        localObject = ((AccessToken)localObject).getApplicationId();
        if (localObject != null) {
          return localObject;
        }
      }
    }
    if (!Utility.isNullOrEmpty(defaultBatchApplicationId)) {
      return defaultBatchApplicationId;
    }
    return FacebookSdk.getApplicationId();
  }
  
  public static final String getDefaultBatchApplicationId()
  {
    return defaultBatchApplicationId;
  }
  
  public static String getDefaultPhotoPathIfNull(String paramString)
  {
    if (paramString == null) {
      return "me/photos";
    }
    return paramString;
  }
  
  private String getGraphPathWithVersion()
  {
    if (versionPattern.matcher(graphPath).matches()) {
      return graphPath;
    }
    return String.format("%s/%s", new Object[] { version, graphPath });
  }
  
  public static String getMimeContentType()
  {
    return String.format("multipart/form-data; boundary=%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
  }
  
  public static String getUserAgent()
  {
    if (userAgent == null)
    {
      userAgent = String.format("%s.%s", new Object[] { "FBAndroidSDK", "4.6.0" });
      String str = InternalSettings.mCustomUserAgent;
      if (!Utility.isNullOrEmpty(str)) {
        userAgent = String.format(Locale.ROOT, "%s/%s", new Object[] { userAgent, str });
      }
    }
    return userAgent;
  }
  
  public static boolean hasOnProgressCallbacks(GraphRequestBatch paramGraphRequestBatch)
  {
    Iterator localIterator = paramGraphRequestBatch.getCallbacks().iterator();
    while (localIterator.hasNext()) {
      if (((GraphRequestBatch.Callback)localIterator.next() instanceof GraphRequestBatch.OnProgressCallback)) {
        return true;
      }
    }
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext()) {
      if ((((GraphRequest)paramGraphRequestBatch.next()).getCallback() instanceof OnProgressCallback)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isGzipCompressible(GraphRequestBatch paramGraphRequestBatch)
  {
    GraphRequest localGraphRequest;
    String str;
    do
    {
      paramGraphRequestBatch = paramGraphRequestBatch.iterator();
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        if (!paramGraphRequestBatch.hasNext()) {
          break;
        }
        localGraphRequest = (GraphRequest)paramGraphRequestBatch.next();
        localIterator = parameters.keySet().iterator();
      }
      str = (String)localIterator.next();
    } while (!isSupportedAttachmentType(parameters.get(str)));
    return false;
    return true;
  }
  
  public static boolean isMeRequest(String paramString)
  {
    Matcher localMatcher = versionPattern.matcher(paramString);
    if (localMatcher.matches()) {
      paramString = localMatcher.group(1);
    }
    if (!paramString.startsWith("me/")) {
      return paramString.startsWith("/me/");
    }
    return true;
  }
  
  public static boolean isSupportedAttachmentType(Object paramObject)
  {
    return ((paramObject instanceof Bitmap)) || ((paramObject instanceof byte[])) || ((paramObject instanceof Uri)) || ((paramObject instanceof ParcelFileDescriptor)) || ((paramObject instanceof ParcelableResourceWithMimeType));
  }
  
  public static boolean isSupportedParameterType(Object paramObject)
  {
    return ((paramObject instanceof String)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof Number)) || ((paramObject instanceof Date));
  }
  
  public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken paramAccessToken, Context paramContext, Callback paramCallback)
  {
    return newCustomAudienceThirdPartyIdRequest(paramAccessToken, paramContext, null, paramCallback);
  }
  
  public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken paramAccessToken, Context paramContext, String paramString, Callback paramCallback)
  {
    String str = paramString;
    if (paramString == null)
    {
      str = paramString;
      if (paramAccessToken != null) {
        str = paramAccessToken.getApplicationId();
      }
    }
    paramString = str;
    if (str == null) {
      paramString = Utility.getMetadataApplicationId(paramContext);
    }
    if (paramString != null)
    {
      str = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "/custom_audience_third_party_id");
      AttributionIdentifiers localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
      Bundle localBundle = new Bundle();
      if (paramAccessToken == null)
      {
        if (localAttributionIdentifiers.getAttributionId() != null) {
          paramString = localAttributionIdentifiers.getAttributionId();
        } else {
          paramString = localAttributionIdentifiers.getAndroidAdvertiserId();
        }
        if (localAttributionIdentifiers.getAttributionId() != null) {
          localBundle.putString("udid", paramString);
        }
      }
      if ((FacebookSdk.getLimitEventAndDataUsage(paramContext)) || (localAttributionIdentifiers.isTrackingLimited())) {
        localBundle.putString("limit_event_usage", "1");
      }
      return new GraphRequest(paramAccessToken, str, localBundle, HttpMethod.HEAD, paramCallback);
    }
    throw new FacebookException("Facebook App ID cannot be determined");
  }
  
  public static GraphRequest newDeleteObjectRequest(AccessToken paramAccessToken, String paramString, Callback paramCallback)
  {
    return new GraphRequest(paramAccessToken, paramString, null, HttpMethod.DELETE, paramCallback);
  }
  
  public static GraphRequest newGraphPathRequest(AccessToken paramAccessToken, String paramString, Callback paramCallback)
  {
    return new GraphRequest(paramAccessToken, paramString, null, null, paramCallback);
  }
  
  public static GraphRequest newMeRequest(AccessToken paramAccessToken, GraphJSONObjectCallback paramGraphJSONObjectCallback)
  {
    new GraphRequest(paramAccessToken, "me", null, null, new Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        GraphRequest.GraphJSONObjectCallback localGraphJSONObjectCallback = val$callback;
        if (localGraphJSONObjectCallback != null) {
          localGraphJSONObjectCallback.onCompleted(paramAnonymousGraphResponse.getJSONObject(), paramAnonymousGraphResponse);
        }
      }
    });
  }
  
  public static GraphRequest newMyFriendsRequest(AccessToken paramAccessToken, GraphJSONArrayCallback paramGraphJSONArrayCallback)
  {
    new GraphRequest(paramAccessToken, "me/friends", null, null, new Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (val$callback != null)
        {
          Object localObject = paramAnonymousGraphResponse.getJSONObject();
          if (localObject != null) {
            localObject = ((JSONObject)localObject).optJSONArray("data");
          } else {
            localObject = null;
          }
          val$callback.onCompleted((JSONArray)localObject, paramAnonymousGraphResponse);
        }
      }
    });
  }
  
  public static GraphRequest newPlacesSearchRequest(AccessToken paramAccessToken, Location paramLocation, int paramInt1, int paramInt2, String paramString, GraphJSONArrayCallback paramGraphJSONArrayCallback)
  {
    if ((paramLocation == null) && (Utility.isNullOrEmpty(paramString))) {
      throw new FacebookException("Either location or searchText must be specified.");
    }
    Bundle localBundle = new Bundle(5);
    localBundle.putString("type", "place");
    localBundle.putInt("limit", paramInt2);
    if (paramLocation != null)
    {
      localBundle.putString("center", String.format(Locale.US, "%f,%f", new Object[] { Double.valueOf(paramLocation.getLatitude()), Double.valueOf(paramLocation.getLongitude()) }));
      localBundle.putInt("distance", paramInt1);
    }
    if (!Utility.isNullOrEmpty(paramString)) {
      localBundle.putString("q", paramString);
    }
    paramLocation = new Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        if (val$callback != null)
        {
          Object localObject = paramAnonymousGraphResponse.getJSONObject();
          if (localObject != null) {
            localObject = ((JSONObject)localObject).optJSONArray("data");
          } else {
            localObject = null;
          }
          val$callback.onCompleted((JSONArray)localObject, paramAnonymousGraphResponse);
        }
      }
    };
    return new GraphRequest(paramAccessToken, "search", localBundle, HttpMethod.HEAD, paramLocation);
  }
  
  public static GraphRequest newPostRequest(AccessToken paramAccessToken, String paramString, JSONObject paramJSONObject, Callback paramCallback)
  {
    paramAccessToken = new GraphRequest(paramAccessToken, paramString, null, HttpMethod.POST, paramCallback);
    paramAccessToken.setGraphObject(paramJSONObject);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, Bitmap paramBitmap, String paramString2, Bundle paramBundle, Callback paramCallback)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "me/photos";
    }
    paramString1 = new Bundle();
    if (paramBundle != null) {
      paramString1.putAll(paramBundle);
    }
    paramString1.putParcelable("picture", paramBitmap);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      paramString1.putString("caption", paramString2);
    }
    return new GraphRequest(paramAccessToken, str, paramString1, HttpMethod.POST, paramCallback);
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, Uri paramUri, String paramString2, Bundle paramBundle, Callback paramCallback)
    throws FileNotFoundException
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "me/photos";
    }
    if (Utility.isFileUri(paramUri)) {
      return newUploadPhotoRequest(paramAccessToken, str, new File(paramUri.getPath()), paramString2, paramBundle, paramCallback);
    }
    if (Utility.isContentUri(paramUri))
    {
      paramString1 = new Bundle();
      if (paramBundle != null) {
        paramString1.putAll(paramBundle);
      }
      paramString1.putParcelable("picture", paramUri);
      return new GraphRequest(paramAccessToken, str, paramString1, HttpMethod.POST, paramCallback);
    }
    throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
  }
  
  public static GraphRequest newUploadPhotoRequest(AccessToken paramAccessToken, String paramString1, File paramFile, String paramString2, Bundle paramBundle, Callback paramCallback)
    throws FileNotFoundException
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "me/photos";
    }
    paramString1 = ParcelFileDescriptor.open(paramFile, 268435456);
    paramFile = new Bundle();
    if (paramBundle != null) {
      paramFile.putAll(paramBundle);
    }
    paramFile.putParcelable("picture", paramString1);
    if ((paramString2 != null) && (!paramString2.isEmpty())) {
      paramFile.putString("caption", paramString2);
    }
    return new GraphRequest(paramAccessToken, str, paramFile, HttpMethod.POST, paramCallback);
  }
  
  public static String parameterToString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((!(paramObject instanceof Boolean)) && (!(paramObject instanceof Number)))
    {
      if ((paramObject instanceof Date)) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject);
      }
      throw new IllegalArgumentException("Unsupported parameter type.");
    }
    return paramObject.toString();
  }
  
  public static void processGraphObject(JSONObject paramJSONObject, String paramString, KeyValueSerializer paramKeyValueSerializer)
    throws IOException
  {
    if (isMeRequest(paramString))
    {
      i = paramString.indexOf(":");
      int j = paramString.indexOf("?");
      if ((i > 3) && ((j == -1) || (i < j)))
      {
        i = 1;
        break label48;
      }
    }
    int i = 0;
    label48:
    paramString = paramJSONObject.keys();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      Object localObject = paramJSONObject.opt(str);
      boolean bool;
      if ((i != 0) && (str.equalsIgnoreCase("image"))) {
        bool = true;
      } else {
        bool = false;
      }
      processGraphObjectProperty(str, localObject, paramKeyValueSerializer, bool);
    }
  }
  
  public static void processGraphObjectProperty(String paramString, Object paramObject, KeyValueSerializer paramKeyValueSerializer, boolean paramBoolean)
    throws IOException
  {
    Object localObject1 = paramObject.getClass();
    Object localObject2;
    if (JSONObject.class.isAssignableFrom((Class)localObject1))
    {
      paramObject = (JSONObject)paramObject;
      if (paramBoolean)
      {
        localObject1 = paramObject.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          processGraphObjectProperty(String.format("%s[%s]", new Object[] { paramString, localObject2 }), paramObject.opt((String)localObject2), paramKeyValueSerializer, paramBoolean);
        }
      }
      if (paramObject.has("id"))
      {
        processGraphObjectProperty(paramString, paramObject.optString("id"), paramKeyValueSerializer, paramBoolean);
        return;
      }
      if (paramObject.has("url"))
      {
        processGraphObjectProperty(paramString, paramObject.optString("url"), paramKeyValueSerializer, paramBoolean);
        return;
      }
      if (paramObject.has("fbsdk:create_object")) {
        processGraphObjectProperty(paramString, paramObject.toString(), paramKeyValueSerializer, paramBoolean);
      }
    }
    else
    {
      int j;
      int i;
      if (JSONArray.class.isAssignableFrom((Class)localObject1))
      {
        paramObject = (JSONArray)paramObject;
        j = paramObject.length();
        i = 0;
      }
      while (i < j)
      {
        localObject1 = String.format(Locale.ROOT, "%s[%d]", new Object[] { paramString, Integer.valueOf(i) });
        localObject2 = paramObject.opt(i);
        try
        {
          processGraphObjectProperty((String)localObject1, localObject2, paramKeyValueSerializer, paramBoolean);
          i += 1;
        }
        catch (Throwable paramString)
        {
          throw paramString;
        }
      }
      if ((!String.class.isAssignableFrom((Class)localObject1)) && (!Number.class.isAssignableFrom((Class)localObject1)) && (!Boolean.class.isAssignableFrom((Class)localObject1)))
      {
        if (Date.class.isAssignableFrom((Class)localObject1))
        {
          paramObject = (Date)paramObject;
          paramKeyValueSerializer.writeString(paramString, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(paramObject));
        }
      }
      else
      {
        paramKeyValueSerializer.writeString(paramString, paramObject.toString());
        return;
      }
    }
  }
  
  public static void processRequest(GraphRequestBatch paramGraphRequestBatch, Logger paramLogger, int paramInt, URL paramURL, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException, JSONException
  {
    paramOutputStream = new Serializer(paramOutputStream, paramLogger, paramBoolean);
    if (paramInt == 1)
    {
      paramGraphRequestBatch = paramGraphRequestBatch.get(0);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = parameters.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = parameters.get(str);
        if (isSupportedAttachmentType(localObject)) {
          localHashMap.put(str, new Attachment(paramGraphRequestBatch, localObject));
        }
      }
      if (paramLogger != null) {
        paramLogger.append("  Parameters:\n");
      }
      serializeParameters(parameters, paramOutputStream, paramGraphRequestBatch);
      if (paramLogger != null) {
        paramLogger.append("  Attachments:\n");
      }
      serializeAttachments(localHashMap, paramOutputStream);
      paramGraphRequestBatch = graphObject;
      if (paramGraphRequestBatch != null) {
        processGraphObject(paramGraphRequestBatch, paramURL.getPath(), paramOutputStream);
      }
    }
    else
    {
      paramURL = getBatchAppId(paramGraphRequestBatch);
      if (!Utility.isNullOrEmpty(paramURL))
      {
        paramOutputStream.writeString("batch_app_id", paramURL);
        paramURL = new HashMap();
        serializeRequestsAsJSON(paramOutputStream, paramGraphRequestBatch, paramURL);
        if (paramLogger != null) {
          paramLogger.append("  Attachments:\n");
        }
        serializeAttachments(paramURL, paramOutputStream);
        return;
      }
      paramGraphRequestBatch = new FacebookException("App ID was not specified at the request or Settings.");
      throw paramGraphRequestBatch;
    }
  }
  
  public static void runCallbacks(final GraphRequestBatch paramGraphRequestBatch, List paramList)
  {
    int j = paramGraphRequestBatch.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      Callback localCallback = getcallback;
      if (localCallback != null) {
        localArrayList.add(new Pair(localCallback, paramList.get(i)));
      }
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramList = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = val$callbacks.iterator();
          while (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            ((GraphRequest.Callback)first).onCompleted((GraphResponse)second);
          }
          localIterator = paramGraphRequestBatch.getCallbacks().iterator();
          while (localIterator.hasNext()) {
            ((GraphRequestBatch.Callback)localIterator.next()).onBatchCompleted(paramGraphRequestBatch);
          }
        }
      };
      paramGraphRequestBatch = paramGraphRequestBatch.getCallbackHandler();
      if (paramGraphRequestBatch == null)
      {
        paramList.run();
        return;
      }
      paramGraphRequestBatch.post(paramList);
    }
  }
  
  public static void serializeAttachments(Map paramMap, Serializer paramSerializer)
    throws IOException
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Attachment localAttachment = (Attachment)paramMap.get(str);
      if (isSupportedAttachmentType(localAttachment.getValue())) {
        paramSerializer.writeObject(str, localAttachment.getValue(), localAttachment.getRequest());
      }
    }
  }
  
  public static void serializeParameters(Bundle paramBundle, Serializer paramSerializer, GraphRequest paramGraphRequest)
    throws IOException
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (isSupportedParameterType(localObject)) {
        paramSerializer.writeObject(str, localObject, paramGraphRequest);
      }
    }
  }
  
  public static void serializeRequestsAsJSON(Serializer paramSerializer, Collection paramCollection, Map paramMap)
    throws JSONException, IOException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      ((GraphRequest)localIterator.next()).serializeToBatch(localJSONArray, paramMap);
    }
    paramSerializer.writeRequestsAsJson("batch", localJSONArray, paramCollection);
  }
  
  private void serializeToBatch(JSONArray paramJSONArray, final Map paramMap)
    throws JSONException, IOException
  {
    JSONObject localJSONObject = new JSONObject();
    String str1 = batchEntryName;
    if (str1 != null)
    {
      localJSONObject.put("name", str1);
      localJSONObject.get("omit_response_on_success", batchEntryOmitResultOnSuccess);
    }
    str1 = batchEntryDependsOn;
    if (str1 != null) {
      localJSONObject.put("depends_on", str1);
    }
    str1 = getUrlForBatchedRequest();
    localJSONObject.put("relative_url", str1);
    localJSONObject.put("method", httpMethod);
    Object localObject1 = accessToken;
    if (localObject1 != null) {
      Logger.registerAccessToken(((AccessToken)localObject1).getToken());
    }
    localObject1 = new ArrayList();
    Iterator localIterator = parameters.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      localObject2 = parameters.get((String)localObject2);
      if (isSupportedAttachmentType(localObject2))
      {
        String str2 = String.format(Locale.ROOT, "%s%d", new Object[] { "file", Integer.valueOf(paramMap.size()) });
        ((ArrayList)localObject1).add(str2);
        paramMap.put(str2, new Attachment(this, localObject2));
      }
    }
    if (!((ArrayList)localObject1).isEmpty()) {
      localJSONObject.put("attached_files", TextUtils.join(",", (Iterable)localObject1));
    }
    if (graphObject != null)
    {
      paramMap = new ArrayList();
      processGraphObject(graphObject, str1, new KeyValueSerializer()
      {
        public void writeString(String paramAnonymousString1, String paramAnonymousString2)
          throws IOException
        {
          paramMap.add(String.format(Locale.US, "%s=%s", new Object[] { paramAnonymousString1, URLEncoder.encode(paramAnonymousString2, "UTF-8") }));
        }
      });
      localJSONObject.put("body", TextUtils.join("&", paramMap));
    }
    paramJSONArray.put(localJSONObject);
  }
  
  public static final void serializeToUrlConnection(GraphRequestBatch paramGraphRequestBatch, HttpURLConnection paramHttpURLConnection)
    throws IOException, JSONException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a14 = a13\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static void setConnectionContentType(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      paramHttpURLConnection.setRequestProperty("Content-Encoding", "gzip");
      return;
    }
    paramHttpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
  }
  
  public static final void setDefaultBatchApplicationId(String paramString)
  {
    defaultBatchApplicationId = paramString;
  }
  
  public static final boolean shouldWarnOnMissingFieldsParam(GraphRequest paramGraphRequest)
  {
    String str = paramGraphRequest.getVersion();
    paramGraphRequest = str;
    if (Utility.isNullOrEmpty(str)) {
      return true;
    }
    if (str.startsWith("v")) {
      paramGraphRequest = str.substring(1);
    }
    paramGraphRequest = paramGraphRequest.split("\\.");
    if ((paramGraphRequest.length < 2) || (Integer.parseInt(paramGraphRequest[0]) <= 2)) {
      return (Integer.parseInt(paramGraphRequest[0]) >= 2) && (Integer.parseInt(paramGraphRequest[1]) >= 4);
    }
    return true;
  }
  
  /* Error */
  public static HttpURLConnection toHttpConnection(GraphRequestBatch paramGraphRequestBatch)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 1088	com/facebook/GraphRequest:validateFieldsParamForGetRequests	(Lcom/facebook/GraphRequestBatch;)V
    //   4: aload_0
    //   5: invokevirtual 581	com/facebook/GraphRequestBatch:size	()I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +24 -> 35
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 912	com/facebook/GraphRequestBatch:get	(I)Lcom/facebook/GraphRequest;
    //   19: astore_2
    //   20: new 251	java/net/URL
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 1091	com/facebook/GraphRequest:getUrlForSingleRequest	()Ljava/lang/String;
    //   28: invokespecial 1092	java/net/URL:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: goto +14 -> 46
    //   35: new 251	java/net/URL
    //   38: dup
    //   39: invokestatic 1095	com/facebook/internal/ServerProtocol:getGraphUrlBase	()Ljava/lang/String;
    //   42: invokespecial 1092	java/net/URL:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokestatic 1097	com/facebook/GraphRequest:createConnection	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   50: astore_2
    //   51: aload_0
    //   52: aload_2
    //   53: invokestatic 1099	com/facebook/GraphRequest:serializeToUrlConnection	(Lcom/facebook/GraphRequestBatch;Ljava/net/HttpURLConnection;)V
    //   56: aload_2
    //   57: areturn
    //   58: astore_0
    //   59: new 426	com/facebook/FacebookException
    //   62: dup
    //   63: ldc_w 1101
    //   66: aload_0
    //   67: invokespecial 1104	com/facebook/FacebookException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: athrow
    //   71: astore_0
    //   72: new 426	com/facebook/FacebookException
    //   75: dup
    //   76: ldc_w 1101
    //   79: aload_0
    //   80: invokespecial 1104	com/facebook/FacebookException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: athrow
    //   84: astore_0
    //   85: new 426	com/facebook/FacebookException
    //   88: dup
    //   89: ldc_w 1106
    //   92: aload_0
    //   93: invokespecial 1104	com/facebook/FacebookException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramGraphRequestBatch	GraphRequestBatch
    //   8	4	1	i	int
    //   19	38	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	56	58	org/json/JSONException
    //   46	56	71	java/io/IOException
    //   4	9	84	java/net/MalformedURLException
    //   14	20	84	java/net/MalformedURLException
    //   20	32	84	java/net/MalformedURLException
    //   35	46	84	java/net/MalformedURLException
  }
  
  public static HttpURLConnection toHttpConnection(Collection paramCollection)
  {
    Validate.containsNoNulls(paramCollection, "requests");
    Validate.notEmpty(paramCollection, "requests");
    return toHttpConnection(new GraphRequestBatch(paramCollection));
  }
  
  public static HttpURLConnection toHttpConnection(GraphRequest... paramVarArgs)
  {
    return toHttpConnection(Arrays.asList(paramVarArgs));
  }
  
  public static final void validateFieldsParamForGetRequests(GraphRequestBatch paramGraphRequestBatch)
  {
    paramGraphRequestBatch = paramGraphRequestBatch.iterator();
    while (paramGraphRequestBatch.hasNext())
    {
      GraphRequest localGraphRequest = (GraphRequest)paramGraphRequestBatch.next();
      if ((HttpMethod.HEAD.equals(localGraphRequest.getHttpMethod())) && (shouldWarnOnMissingFieldsParam(localGraphRequest)))
      {
        Bundle localBundle = localGraphRequest.getParameters();
        if ((!localBundle.containsKey("fields")) || (Utility.isNullOrEmpty(localBundle.getString("fields")))) {
          Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", new Object[] { localGraphRequest.getGraphPath() });
        }
      }
    }
  }
  
  public final GraphResponse executeAndWait()
  {
    return executeAndWait(this);
  }
  
  public final GraphRequestAsyncTask executeAsync()
  {
    return executeBatchAsync(new GraphRequest[] { this });
  }
  
  public final AccessToken getAccessToken()
  {
    return accessToken;
  }
  
  public final String getBatchEntryDependsOn()
  {
    return batchEntryDependsOn;
  }
  
  public final String getBatchEntryName()
  {
    return batchEntryName;
  }
  
  public final boolean getBatchEntryOmitResultOnSuccess()
  {
    return batchEntryOmitResultOnSuccess;
  }
  
  public final Callback getCallback()
  {
    return callback;
  }
  
  public final JSONObject getGraphObject()
  {
    return graphObject;
  }
  
  public final String getGraphPath()
  {
    return graphPath;
  }
  
  public final HttpMethod getHttpMethod()
  {
    return httpMethod;
  }
  
  public final Bundle getParameters()
  {
    return parameters;
  }
  
  public final Object getTag()
  {
    return mTag;
  }
  
  public final String getUrlForBatchedRequest()
  {
    if (overriddenURL == null)
    {
      String str = getGraphPathWithVersion();
      addCommonParameters();
      return appendParametersToBaseUrl(str);
    }
    throw new FacebookException("Can't override URL for a batch request");
  }
  
  public final String getUrlForSingleRequest()
  {
    String str = overriddenURL;
    if (str != null) {
      return str.toString();
    }
    if (getHttpMethod() == HttpMethod.POST)
    {
      str = graphPath;
      if ((str != null) && (str.endsWith("/videos")))
      {
        str = ServerProtocol.getGraphVideoUrlBase();
        break label53;
      }
    }
    str = ServerProtocol.getGraphUrlBase();
    label53:
    str = String.format("%s/%s", new Object[] { str, getGraphPathWithVersion() });
    addCommonParameters();
    return appendParametersToBaseUrl(str);
  }
  
  public final String getVersion()
  {
    return version;
  }
  
  public final void setAccessToken(AccessToken paramAccessToken)
  {
    accessToken = paramAccessToken;
  }
  
  public final void setBatchEntryDependsOn(String paramString)
  {
    batchEntryDependsOn = paramString;
  }
  
  public final void setBatchEntryName(String paramString)
  {
    batchEntryName = paramString;
  }
  
  public final void setBatchEntryOmitResultOnSuccess(boolean paramBoolean)
  {
    batchEntryOmitResultOnSuccess = paramBoolean;
  }
  
  public final void setCallback(final Callback paramCallback)
  {
    if ((!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) && (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)))
    {
      callback = paramCallback;
      return;
    }
    callback = new Callback()
    {
      public void onCompleted(GraphResponse paramAnonymousGraphResponse)
      {
        Object localObject1 = paramAnonymousGraphResponse.getJSONObject();
        if (localObject1 != null) {
          localObject1 = ((JSONObject)localObject1).optJSONObject("__debug__");
        } else {
          localObject1 = null;
        }
        JSONArray localJSONArray;
        if (localObject1 != null) {
          localJSONArray = ((JSONObject)localObject1).optJSONArray("messages");
        } else {
          localJSONArray = null;
        }
        if (localJSONArray != null)
        {
          int i = 0;
          while (i < localJSONArray.length())
          {
            Object localObject3 = localJSONArray.optJSONObject(i);
            if (localObject3 != null) {
              localObject1 = ((JSONObject)localObject3).optString("message");
            } else {
              localObject1 = null;
            }
            Object localObject2;
            if (localObject3 != null) {
              localObject2 = ((JSONObject)localObject3).optString("type");
            } else {
              localObject2 = null;
            }
            if (localObject3 != null) {
              localObject3 = ((JSONObject)localObject3).optString("link");
            } else {
              localObject3 = null;
            }
            if ((localObject1 != null) && (localObject2 != null))
            {
              LoggingBehavior localLoggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
              if (((String)localObject2).equals("warning")) {
                localLoggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
              }
              localObject2 = localObject1;
              if (!Utility.isNullOrEmpty((String)localObject3)) {
                localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject1, " Link: ", (String)localObject3);
              }
              Logger.e(localLoggingBehavior, 3, GraphRequest.state, (String)localObject2);
            }
            i += 1;
          }
        }
        localObject1 = paramCallback;
        if (localObject1 != null) {
          ((GraphRequest.Callback)localObject1).onCompleted(paramAnonymousGraphResponse);
        }
      }
    };
  }
  
  public final void setGraphObject(JSONObject paramJSONObject)
  {
    graphObject = paramJSONObject;
  }
  
  public final void setGraphPath(String paramString)
  {
    graphPath = paramString;
  }
  
  public final void setHttpMethod(HttpMethod paramHttpMethod)
  {
    if ((overriddenURL != null) && (paramHttpMethod != HttpMethod.HEAD)) {
      throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }
    if (paramHttpMethod == null) {
      paramHttpMethod = HttpMethod.HEAD;
    }
    httpMethod = paramHttpMethod;
  }
  
  public final void setParameters(Bundle paramBundle)
  {
    parameters = paramBundle;
  }
  
  public final void setSkipClientToken(boolean paramBoolean)
  {
    skipClientToken = paramBoolean;
  }
  
  public final void setTag(Object paramObject)
  {
    mTag = paramObject;
  }
  
  public final void setVersion(String paramString)
  {
    version = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("{Request: ", " accessToken: ");
    AccessToken localAccessToken = accessToken;
    Object localObject = localAccessToken;
    if (localAccessToken == null) {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", graphPath: ");
    localStringBuilder.append(graphPath);
    localStringBuilder.append(", graphObject: ");
    localStringBuilder.append(graphObject);
    localStringBuilder.append(", httpMethod: ");
    localStringBuilder.append(httpMethod);
    localStringBuilder.append(", parameters: ");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, parameters, "}");
  }
  
  private static class Attachment
  {
    public final GraphRequest request;
    public final Object value;
    
    public Attachment(GraphRequest paramGraphRequest, Object paramObject)
    {
      request = paramGraphRequest;
      value = paramObject;
    }
    
    public GraphRequest getRequest()
    {
      return request;
    }
    
    public Object getValue()
    {
      return value;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onCompleted(GraphResponse paramGraphResponse);
  }
  
  public static abstract interface GraphJSONArrayCallback
  {
    public abstract void onCompleted(JSONArray paramJSONArray, GraphResponse paramGraphResponse);
  }
  
  public static abstract interface GraphJSONObjectCallback
  {
    public abstract void onCompleted(JSONObject paramJSONObject, GraphResponse paramGraphResponse);
  }
  
  private static abstract interface KeyValueSerializer
  {
    public abstract void writeString(String paramString1, String paramString2)
      throws IOException;
  }
  
  public static abstract interface OnProgressCallback
    extends GraphRequest.Callback
  {
    public abstract void onProgress(long paramLong1, long paramLong2);
  }
  
  public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable>
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new Parcelable.Creator()
    {
      public GraphRequest.ParcelableResourceWithMimeType createFromParcel(Parcel paramAnonymousParcel)
      {
        return new GraphRequest.ParcelableResourceWithMimeType(paramAnonymousParcel);
      }
      
      public GraphRequest.ParcelableResourceWithMimeType[] newArray(int paramAnonymousInt)
      {
        return new GraphRequest.ParcelableResourceWithMimeType[paramAnonymousInt];
      }
    };
    public final String mimeType;
    public final RESOURCE resource;
    
    public ParcelableResourceWithMimeType(Parcel paramParcel)
    {
      mimeType = paramParcel.readString();
      resource = paramParcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
    }
    
    public ParcelableResourceWithMimeType(Parcelable paramParcelable, String paramString)
    {
      mimeType = paramString;
      resource = paramParcelable;
    }
    
    public int describeContents()
    {
      return 1;
    }
    
    public String getMimeType()
    {
      return mimeType;
    }
    
    public Parcelable getResource()
    {
      return resource;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(mimeType);
      paramParcel.writeParcelable(resource, paramInt);
    }
  }
  
  private static class Serializer
    implements GraphRequest.KeyValueSerializer
  {
    public boolean firstWrite = true;
    public final Logger logger;
    public final OutputStream outputStream;
    public boolean useUrlEncode = false;
    
    public Serializer(OutputStream paramOutputStream, Logger paramLogger, boolean paramBoolean)
    {
      outputStream = paramOutputStream;
      logger = paramLogger;
      useUrlEncode = paramBoolean;
    }
    
    private RuntimeException getInvalidTypeError()
    {
      return new IllegalArgumentException("value is not a supported type.");
    }
    
    public void write(String paramString, Object... paramVarArgs)
      throws IOException
    {
      if (!useUrlEncode)
      {
        if (firstWrite)
        {
          outputStream.write("--".getBytes());
          outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
          outputStream.write("\r\n".getBytes());
          firstWrite = false;
        }
        outputStream.write(String.format(paramString, paramVarArgs).getBytes());
        return;
      }
      outputStream.write(URLEncoder.encode(String.format(Locale.US, paramString, paramVarArgs), "UTF-8").getBytes());
    }
    
    public void writeBitmap(String paramString, Bitmap paramBitmap)
      throws IOException
    {
      writeContentDisposition(paramString, paramString, "image/png");
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
      writeLine("", new Object[0]);
      writeRecordBoundary();
      paramBitmap = logger;
      if (paramBitmap != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("    ");
        localStringBuilder.append(paramString);
        paramBitmap.appendKeyValue(localStringBuilder.toString(), "<Image>");
      }
    }
    
    public void writeBytes(String paramString, byte[] paramArrayOfByte)
      throws IOException
    {
      writeContentDisposition(paramString, paramString, "content/unknown");
      outputStream.write(paramArrayOfByte);
      writeLine("", new Object[0]);
      writeRecordBoundary();
      Logger localLogger = logger;
      if (localLogger != null) {
        localLogger.appendKeyValue(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("    ", paramString), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(paramArrayOfByte.length) }));
      }
    }
    
    public void writeContentDisposition(String paramString1, String paramString2, String paramString3)
      throws IOException
    {
      if (!useUrlEncode)
      {
        write("Content-Disposition: form-data; name=\"%s\"", new Object[] { paramString1 });
        if (paramString2 != null) {
          write("; filename=\"%s\"", new Object[] { paramString2 });
        }
        writeLine("", new Object[0]);
        if (paramString3 != null) {
          writeLine("%s: %s", new Object[] { "Content-Type", paramString3 });
        }
        writeLine("", new Object[0]);
        return;
      }
      outputStream.write(String.format("%s=", new Object[] { paramString1 }).getBytes());
    }
    
    public void writeContentUri(String paramString1, Uri paramUri, String paramString2)
      throws IOException
    {
      Object localObject = paramString2;
      if (paramString2 == null) {
        localObject = "content/unknown";
      }
      writeContentDisposition(paramString1, paramString1, (String)localObject);
      paramString2 = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(paramUri);
      localObject = outputStream;
      int i;
      if ((localObject instanceof ProgressNoopOutputStream))
      {
        long l = Utility.getContentSize(paramUri);
        ((ProgressNoopOutputStream)outputStream).addProgress(l);
        i = 0;
      }
      else
      {
        i = Utility.copyAndCloseInputStream(paramString2, (OutputStream)localObject) + 0;
      }
      writeLine("", new Object[0]);
      writeRecordBoundary();
      paramUri = logger;
      if (paramUri != null) {
        paramUri.appendKeyValue(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("    ", paramString1), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
      }
    }
    
    public void writeFile(String paramString1, ParcelFileDescriptor paramParcelFileDescriptor, String paramString2)
      throws IOException
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "content/unknown";
      }
      writeContentDisposition(paramString1, paramString1, str);
      paramString2 = outputStream;
      int i;
      if ((paramString2 instanceof ProgressNoopOutputStream))
      {
        ((ProgressNoopOutputStream)paramString2).addProgress(paramParcelFileDescriptor.getStatSize());
        i = 0;
      }
      else
      {
        i = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor), outputStream) + 0;
      }
      writeLine("", new Object[0]);
      writeRecordBoundary();
      paramParcelFileDescriptor = logger;
      if (paramParcelFileDescriptor != null) {
        paramParcelFileDescriptor.appendKeyValue(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("    ", paramString1), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
      }
    }
    
    public void writeLine(String paramString, Object... paramVarArgs)
      throws IOException
    {
      write(paramString, paramVarArgs);
      if (!useUrlEncode) {
        write("\r\n", new Object[0]);
      }
    }
    
    public void writeObject(String paramString, Object paramObject, GraphRequest paramGraphRequest)
      throws IOException
    {
      OutputStream localOutputStream = outputStream;
      if ((localOutputStream instanceof RequestOutputStream)) {
        ((RequestOutputStream)localOutputStream).setCurrentRequest(paramGraphRequest);
      }
      if (GraphRequest.isSupportedParameterType(paramObject))
      {
        writeString(paramString, GraphRequest.parameterToString(paramObject));
        return;
      }
      if ((paramObject instanceof Bitmap))
      {
        writeBitmap(paramString, (Bitmap)paramObject);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        writeBytes(paramString, (byte[])paramObject);
        return;
      }
      if ((paramObject instanceof Uri))
      {
        writeContentUri(paramString, (Uri)paramObject, null);
        return;
      }
      if ((paramObject instanceof ParcelFileDescriptor))
      {
        writeFile(paramString, (ParcelFileDescriptor)paramObject, null);
        return;
      }
      if ((paramObject instanceof GraphRequest.ParcelableResourceWithMimeType))
      {
        paramGraphRequest = (GraphRequest.ParcelableResourceWithMimeType)paramObject;
        paramObject = paramGraphRequest.getResource();
        paramGraphRequest = paramGraphRequest.getMimeType();
        if ((paramObject instanceof ParcelFileDescriptor))
        {
          writeFile(paramString, (ParcelFileDescriptor)paramObject, paramGraphRequest);
          return;
        }
        if ((paramObject instanceof Uri))
        {
          writeContentUri(paramString, (Uri)paramObject, paramGraphRequest);
          return;
        }
        throw getInvalidTypeError();
      }
      throw getInvalidTypeError();
    }
    
    public void writeRecordBoundary()
      throws IOException
    {
      if (!useUrlEncode)
      {
        writeLine("--%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
        return;
      }
      outputStream.write("&".getBytes());
    }
    
    public void writeRequestsAsJson(String paramString, JSONArray paramJSONArray, Collection paramCollection)
      throws IOException, JSONException
    {
      Object localObject = outputStream;
      if (!(localObject instanceof RequestOutputStream))
      {
        writeString(paramString, paramJSONArray.toString());
        return;
      }
      localObject = (RequestOutputStream)localObject;
      writeContentDisposition(paramString, null, null);
      write("[", new Object[0]);
      paramCollection = paramCollection.iterator();
      int i = 0;
      while (paramCollection.hasNext())
      {
        GraphRequest localGraphRequest = (GraphRequest)paramCollection.next();
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        ((RequestOutputStream)localObject).setCurrentRequest(localGraphRequest);
        if (i > 0) {
          write(",%s", new Object[] { localJSONObject.toString() });
        } else {
          write("%s", new Object[] { localJSONObject.toString() });
        }
        i += 1;
      }
      write("]", new Object[0]);
      paramCollection = logger;
      if (paramCollection != null) {
        paramCollection.appendKeyValue(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("    ", paramString), paramJSONArray.toString());
      }
    }
    
    public void writeString(String paramString1, String paramString2)
      throws IOException
    {
      writeContentDisposition(paramString1, null, null);
      writeLine("%s", new Object[] { paramString2 });
      writeRecordBoundary();
      Logger localLogger = logger;
      if (localLogger != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("    ");
        localStringBuilder.append(paramString1);
        localLogger.appendKeyValue(localStringBuilder.toString(), paramString2);
      }
    }
  }
}
