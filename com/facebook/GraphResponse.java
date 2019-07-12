package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GraphResponse
{
  public static final String BODY_KEY = "body";
  public static final String CODE_KEY = "code";
  public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
  public static final String RESPONSE_LOG_TAG = "Response";
  public static final String SUCCESS_KEY = "success";
  public final HttpURLConnection connection;
  public final FacebookRequestError error;
  public final JSONObject graphObject;
  public final JSONArray graphObjectArray;
  public final String rawResponse;
  public final GraphRequest request;
  
  public GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, FacebookRequestError paramFacebookRequestError)
  {
    this(paramGraphRequest, paramHttpURLConnection, null, null, null, paramFacebookRequestError);
  }
  
  public GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONArray paramJSONArray)
  {
    this(paramGraphRequest, paramHttpURLConnection, paramString, null, paramJSONArray, null);
  }
  
  public GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONObject paramJSONObject)
  {
    this(paramGraphRequest, paramHttpURLConnection, paramString, paramJSONObject, null, null);
  }
  
  public GraphResponse(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, String paramString, JSONObject paramJSONObject, JSONArray paramJSONArray, FacebookRequestError paramFacebookRequestError)
  {
    request = paramGraphRequest;
    connection = paramHttpURLConnection;
    rawResponse = paramString;
    graphObject = paramJSONObject;
    graphObjectArray = paramJSONArray;
    error = paramFacebookRequestError;
  }
  
  public static List constructErrorResponses(List paramList, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new GraphResponse((GraphRequest)paramList.get(i), paramHttpURLConnection, new FacebookRequestError(paramHttpURLConnection, paramFacebookException)));
      i += 1;
    }
    return localArrayList;
  }
  
  public static GraphResponse createResponseFromObject(GraphRequest paramGraphRequest, HttpURLConnection paramHttpURLConnection, Object paramObject1, Object paramObject2)
    throws JSONException
  {
    Object localObject = paramObject1;
    if ((paramObject1 instanceof JSONObject))
    {
      paramObject1 = (JSONObject)paramObject1;
      paramObject2 = FacebookRequestError.checkResponseAndCreateError(paramObject1, paramObject2, paramHttpURLConnection);
      if (paramObject2 != null)
      {
        if ((paramObject2.getErrorCode() == 190) && (Utility.isCurrentAccessToken(paramGraphRequest.getAccessToken()))) {
          AccessToken.setCurrentAccessToken(null);
        }
        return new GraphResponse(paramGraphRequest, paramHttpURLConnection, paramObject2);
      }
      paramObject1 = Utility.getStringPropertyAsJSON(paramObject1, "body", "FACEBOOK_NON_JSON_RESULT");
      if ((paramObject1 instanceof JSONObject)) {
        return new GraphResponse(paramGraphRequest, paramHttpURLConnection, paramObject1.toString(), (JSONObject)paramObject1);
      }
      if ((paramObject1 instanceof JSONArray)) {
        return new GraphResponse(paramGraphRequest, paramHttpURLConnection, paramObject1.toString(), (JSONArray)paramObject1);
      }
      localObject = JSONObject.NULL;
    }
    if (localObject == JSONObject.NULL) {
      return new GraphResponse(paramGraphRequest, paramHttpURLConnection, localObject.toString(), null);
    }
    paramGraphRequest = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Got unexpected object type in response, class: ");
    paramGraphRequest.append(localObject.getClass().getSimpleName());
    throw new FacebookException(paramGraphRequest.toString());
  }
  
  public static List createResponsesFromObject(HttpURLConnection paramHttpURLConnection, List paramList, Object paramObject)
    throws FacebookException, JSONException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a12 = a11\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static List createResponsesFromStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
    throws FacebookException, JSONException, IOException
  {
    paramInputStream = Utility.readStreamToString(paramInputStream);
    Logger.logError(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[] { Integer.valueOf(paramInputStream.length()), paramInputStream });
    return createResponsesFromString(paramInputStream, paramHttpURLConnection, paramGraphRequestBatch);
  }
  
  public static List createResponsesFromString(String paramString, HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
    throws FacebookException, JSONException, IOException
  {
    paramHttpURLConnection = createResponsesFromObject(paramHttpURLConnection, paramGraphRequestBatch, new JSONTokener(paramString).nextValue());
    Logger.logError(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[] { paramGraphRequestBatch.getId(), Integer.valueOf(paramString.length()), paramHttpURLConnection });
    return paramHttpURLConnection;
  }
  
  public static List fromHttpConnection(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    List localList = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    InputStream localInputStream = null;
    Object localObject1 = localInputStream;
    Object localObject2 = localList;
    Object localObject3 = localObject6;
    Object localObject4 = localObject7;
    Object localObject5 = localObject8;
    try
    {
      int i = paramHttpURLConnection.getResponseCode();
      if (i >= 400)
      {
        localObject1 = localInputStream;
        localObject2 = localList;
        localObject3 = localObject6;
        localObject4 = localObject7;
        localObject5 = localObject8;
        localInputStream = paramHttpURLConnection.getErrorStream();
      }
      else
      {
        localObject1 = localInputStream;
        localObject2 = localList;
        localObject3 = localObject6;
        localObject4 = localObject7;
        localObject5 = localObject8;
        localInputStream = paramHttpURLConnection.getInputStream();
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      localObject3 = localInputStream;
      localObject4 = localInputStream;
      localObject5 = localInputStream;
      localList = createResponsesFromStream(localInputStream, paramHttpURLConnection, paramGraphRequestBatch);
      Utility.closeQuietly(localInputStream);
      return localList;
    }
    catch (Throwable paramHttpURLConnection) {}catch (SecurityException localSecurityException)
    {
      localObject1 = localObject2;
      Logger.logError(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] { localSecurityException });
      localObject1 = localObject2;
      paramHttpURLConnection = constructErrorResponses(paramGraphRequestBatch, paramHttpURLConnection, new FacebookException(localSecurityException));
      Utility.closeQuietly((Closeable)localObject2);
      return paramHttpURLConnection;
    }
    catch (IOException localIOException)
    {
      localObject1 = localObject3;
      Logger.logError(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] { localIOException });
      localObject1 = localObject3;
      paramHttpURLConnection = constructErrorResponses(paramGraphRequestBatch, paramHttpURLConnection, new FacebookException(localIOException));
      Utility.closeQuietly((Closeable)localObject3);
      return paramHttpURLConnection;
    }
    catch (JSONException localJSONException)
    {
      localObject1 = localObject4;
      Logger.logError(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] { localJSONException });
      localObject1 = localObject4;
      paramHttpURLConnection = constructErrorResponses(paramGraphRequestBatch, paramHttpURLConnection, new FacebookException(localJSONException));
      Utility.closeQuietly((Closeable)localObject4);
      return paramHttpURLConnection;
    }
    catch (FacebookException localFacebookException)
    {
      localObject1 = localObject5;
      Logger.logError(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[] { localFacebookException });
      localObject1 = localObject5;
      paramHttpURLConnection = constructErrorResponses(paramGraphRequestBatch, paramHttpURLConnection, localFacebookException);
      Utility.closeQuietly((Closeable)localObject5);
      return paramHttpURLConnection;
    }
    Utility.closeQuietly((Closeable)localObject1);
    throw paramHttpURLConnection;
  }
  
  public final HttpURLConnection getConnection()
  {
    return connection;
  }
  
  public final FacebookRequestError getError()
  {
    return error;
  }
  
  public final JSONArray getJSONArray()
  {
    return graphObjectArray;
  }
  
  public final JSONObject getJSONObject()
  {
    return graphObject;
  }
  
  public String getRawResponse()
  {
    return rawResponse;
  }
  
  public GraphRequest getRequest()
  {
    return request;
  }
  
  public GraphRequest getRequestForPagedResults(PagingDirection paramPagingDirection)
  {
    Object localObject = graphObject;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONObject("paging");
      if (localObject != null)
      {
        if (paramPagingDirection == PagingDirection.NEXT)
        {
          paramPagingDirection = ((JSONObject)localObject).optString("next");
          break label52;
        }
        paramPagingDirection = ((JSONObject)localObject).optString("previous");
        break label52;
      }
    }
    paramPagingDirection = null;
    label52:
    if (Utility.isNullOrEmpty(paramPagingDirection)) {
      return null;
    }
    if ((paramPagingDirection != null) && (paramPagingDirection.equals(request.getUrlForSingleRequest()))) {
      return null;
    }
    localObject = request;
    try
    {
      localObject = ((GraphRequest)localObject).getAccessToken();
      paramPagingDirection = new GraphRequest((AccessToken)localObject, new URL(paramPagingDirection));
      return paramPagingDirection;
    }
    catch (MalformedURLException paramPagingDirection) {}
    return null;
  }
  
  public String toString()
  {
    Object localObject1 = Locale.US;
    if (connection != null) {
      localObject2 = connection;
    }
    try
    {
      int i = ((HttpURLConnection)localObject2).getResponseCode();
      break label28;
      i = 200;
      label28:
      localObject1 = String.format((Locale)localObject1, "%d", new Object[] { Integer.valueOf(i) });
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    localObject1 = "unknown";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{Response: ");
    ((StringBuilder)localObject2).append(" responseCode: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", graphObject: ");
    ((StringBuilder)localObject2).append(graphObject);
    ((StringBuilder)localObject2).append(", error: ");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject2, error, "}");
  }
  
  public static enum PagingDirection
  {
    NEXT,  PREVIOUS;
  }
}
