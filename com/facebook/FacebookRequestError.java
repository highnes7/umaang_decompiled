package com.facebook;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public final class FacebookRequestError
{
  public static final String BODY_KEY = "body";
  public static final String CODE_KEY = "code";
  public static final String ERROR_CODE_FIELD_KEY = "code";
  public static final String ERROR_CODE_KEY = "error_code";
  public static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
  public static final String ERROR_KEY = "error";
  public static final String ERROR_MESSAGE_FIELD_KEY = "message";
  public static final String ERROR_MSG_KEY = "error_msg";
  public static final String ERROR_REASON_KEY = "error_reason";
  public static final String ERROR_SUB_CODE_KEY = "error_subcode";
  public static final String ERROR_TYPE_FIELD_KEY = "type";
  public static final String ERROR_USER_MSG_KEY = "error_user_msg";
  public static final String ERROR_USER_TITLE_KEY = "error_user_title";
  public static final Range HTTP_RANGE_SUCCESS = new Range(200, 299, null);
  public static final int INVALID_ERROR_CODE = -1;
  public static final int INVALID_HTTP_STATUS_CODE = -1;
  public final Object batchRequestResult;
  public final Category category;
  public final HttpURLConnection connection;
  public final int errorCode;
  public final String errorMessage;
  public final String errorRecoveryMessage;
  public final String errorType;
  public final String errorUserMessage;
  public final String errorUserTitle;
  public final FacebookException exception;
  public final JSONObject requestResult;
  public final JSONObject requestResultBody;
  public final int requestStatusCode;
  public final int subErrorCode;
  
  public FacebookRequestError(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, JSONObject paramJSONObject1, JSONObject paramJSONObject2, Object paramObject, HttpURLConnection paramHttpURLConnection, FacebookException paramFacebookException)
  {
    requestStatusCode = paramInt1;
    errorCode = paramInt2;
    subErrorCode = paramInt3;
    errorType = paramString1;
    errorMessage = paramString2;
    requestResultBody = paramJSONObject1;
    requestResult = paramJSONObject2;
    batchRequestResult = paramObject;
    connection = paramHttpURLConnection;
    errorUserTitle = paramString3;
    errorUserMessage = paramString4;
    if (paramFacebookException != null)
    {
      exception = paramFacebookException;
      paramInt1 = 1;
    }
    else
    {
      exception = new FacebookServiceException(this, paramString2);
      paramInt1 = 0;
    }
    paramString2 = getErrorClassification();
    if (paramInt1 != 0) {
      paramString1 = Category.OTHER;
    } else {
      paramString1 = paramString2.classify(paramInt2, paramInt3, paramBoolean);
    }
    category = paramString1;
    errorRecoveryMessage = paramString2.getRecoveryMessage(category);
  }
  
  public FacebookRequestError(int paramInt, String paramString1, String paramString2)
  {
    this(-1, paramInt, -1, paramString1, paramString2, null, null, false, null, null, null, null, null);
  }
  
  public FacebookRequestError(HttpURLConnection paramHttpURLConnection, Exception paramException)
  {
    this(-1, -1, -1, null, null, null, null, false, null, null, null, paramHttpURLConnection, paramException);
  }
  
  /* Error */
  public static FacebookRequestError checkResponseAndCreateError(JSONObject paramJSONObject, Object paramObject, HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 19
    //   3: invokevirtual 156	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6: istore 7
    //   8: iload 7
    //   10: ifeq +382 -> 392
    //   13: aload_0
    //   14: ldc 19
    //   16: invokevirtual 160	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   19: istore 6
    //   21: aload_0
    //   22: ldc 16
    //   24: ldc -94
    //   26: invokestatic 168	com/facebook/internal/Utility:getStringPropertyAsJSON	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   29: astore 8
    //   31: aload 8
    //   33: ifnull +279 -> 312
    //   36: aload 8
    //   38: instanceof 152
    //   41: ifeq +271 -> 312
    //   44: aload 8
    //   46: checkcast 152	org/json/JSONObject
    //   49: astore 12
    //   51: aload 12
    //   53: ldc 29
    //   55: invokevirtual 156	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   58: istore 7
    //   60: iconst_1
    //   61: istore 5
    //   63: iload 7
    //   65: ifeq +92 -> 157
    //   68: aload 12
    //   70: ldc 29
    //   72: aconst_null
    //   73: invokestatic 168	com/facebook/internal/Utility:getStringPropertyAsJSON	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   76: astore 8
    //   78: aload 8
    //   80: checkcast 152	org/json/JSONObject
    //   83: astore 13
    //   85: aload 13
    //   87: ldc 44
    //   89: aconst_null
    //   90: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 8
    //   95: aload 13
    //   97: ldc 32
    //   99: aconst_null
    //   100: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 9
    //   105: aload 13
    //   107: ldc 19
    //   109: iconst_m1
    //   110: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   113: istore_3
    //   114: aload 13
    //   116: ldc 41
    //   118: iconst_m1
    //   119: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   122: istore 4
    //   124: aload 13
    //   126: ldc 47
    //   128: aconst_null
    //   129: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 10
    //   134: aload 13
    //   136: ldc 50
    //   138: aconst_null
    //   139: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 11
    //   144: aload 13
    //   146: ldc 26
    //   148: iconst_0
    //   149: invokevirtual 180	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   152: istore 7
    //   154: goto +122 -> 276
    //   157: aload 12
    //   159: ldc 23
    //   161: invokevirtual 156	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   164: istore 7
    //   166: iload 7
    //   168: ifne +60 -> 228
    //   171: aload 12
    //   173: ldc 35
    //   175: invokevirtual 156	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   178: istore 7
    //   180: iload 7
    //   182: ifne +46 -> 228
    //   185: aload 12
    //   187: ldc 38
    //   189: invokevirtual 156	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   192: istore 7
    //   194: iload 7
    //   196: ifeq +6 -> 202
    //   199: goto +29 -> 228
    //   202: aconst_null
    //   203: astore 8
    //   205: aconst_null
    //   206: astore 9
    //   208: aconst_null
    //   209: astore 10
    //   211: aconst_null
    //   212: astore 11
    //   214: iconst_m1
    //   215: istore_3
    //   216: iconst_m1
    //   217: istore 4
    //   219: iconst_0
    //   220: istore 5
    //   222: iconst_0
    //   223: istore 7
    //   225: goto +51 -> 276
    //   228: aload 12
    //   230: ldc 38
    //   232: aconst_null
    //   233: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   236: astore 8
    //   238: aload 12
    //   240: ldc 35
    //   242: aconst_null
    //   243: invokevirtual 172	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   246: astore 9
    //   248: aload 12
    //   250: ldc 23
    //   252: iconst_m1
    //   253: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   256: istore_3
    //   257: aload 12
    //   259: ldc 41
    //   261: iconst_m1
    //   262: invokevirtual 176	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   265: istore 4
    //   267: aconst_null
    //   268: astore 10
    //   270: aconst_null
    //   271: astore 11
    //   273: iconst_0
    //   274: istore 7
    //   276: iload 5
    //   278: ifeq +34 -> 312
    //   281: new 2	com/facebook/FacebookRequestError
    //   284: dup
    //   285: iload 6
    //   287: iload_3
    //   288: iload 4
    //   290: aload 8
    //   292: aload 9
    //   294: aload 11
    //   296: aload 10
    //   298: iload 7
    //   300: aload 12
    //   302: aload_0
    //   303: aload_1
    //   304: aload_2
    //   305: aconst_null
    //   306: invokespecial 140	com/facebook/FacebookRequestError:<init>	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Object;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)V
    //   309: astore_0
    //   310: aload_0
    //   311: areturn
    //   312: getstatic 83	com/facebook/FacebookRequestError:HTTP_RANGE_SUCCESS	Lcom/facebook/FacebookRequestError$Range;
    //   315: astore 8
    //   317: aload 8
    //   319: iload 6
    //   321: invokevirtual 184	com/facebook/FacebookRequestError$Range:contains	(I)Z
    //   324: istore 7
    //   326: iload 7
    //   328: ifne +73 -> 401
    //   331: aload_0
    //   332: ldc 16
    //   334: invokevirtual 156	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   337: istore 7
    //   339: iload 7
    //   341: ifeq +23 -> 364
    //   344: aload_0
    //   345: ldc 16
    //   347: ldc -94
    //   349: invokestatic 168	com/facebook/internal/Utility:getStringPropertyAsJSON	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   352: astore 8
    //   354: aload 8
    //   356: checkcast 152	org/json/JSONObject
    //   359: astore 8
    //   361: goto +6 -> 367
    //   364: aconst_null
    //   365: astore 8
    //   367: new 2	com/facebook/FacebookRequestError
    //   370: dup
    //   371: iload 6
    //   373: iconst_m1
    //   374: iconst_m1
    //   375: aconst_null
    //   376: aconst_null
    //   377: aconst_null
    //   378: aconst_null
    //   379: iconst_0
    //   380: aload 8
    //   382: aload_0
    //   383: aload_1
    //   384: aload_2
    //   385: aconst_null
    //   386: invokespecial 140	com/facebook/FacebookRequestError:<init>	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Object;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;)V
    //   389: astore_0
    //   390: aload_0
    //   391: areturn
    //   392: aconst_null
    //   393: areturn
    //   394: astore_0
    //   395: aconst_null
    //   396: areturn
    //   397: astore_0
    //   398: aconst_null
    //   399: areturn
    //   400: astore_0
    //   401: aconst_null
    //   402: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	paramJSONObject	JSONObject
    //   0	403	1	paramObject	Object
    //   0	403	2	paramHttpURLConnection	HttpURLConnection
    //   113	175	3	i	int
    //   122	167	4	j	int
    //   61	216	5	k	int
    //   19	353	6	m	int
    //   6	334	7	bool	boolean
    //   29	352	8	localObject	Object
    //   103	190	9	str1	String
    //   132	165	10	str2	String
    //   142	153	11	str3	String
    //   49	252	12	localJSONObject1	JSONObject
    //   83	62	13	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	8	394	org/json/JSONException
    //   13	31	394	org/json/JSONException
    //   51	60	394	org/json/JSONException
    //   68	78	397	org/json/JSONException
    //   85	154	397	org/json/JSONException
    //   157	166	397	org/json/JSONException
    //   171	180	400	org/json/JSONException
    //   185	194	400	org/json/JSONException
    //   228	267	400	org/json/JSONException
    //   281	310	400	org/json/JSONException
    //   317	326	400	org/json/JSONException
    //   331	339	400	org/json/JSONException
    //   344	354	400	org/json/JSONException
    //   367	390	400	org/json/JSONException
  }
  
  public static FacebookRequestErrorClassification getErrorClassification()
  {
    try
    {
      Object localObject = Utility.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
      if (localObject == null)
      {
        localObject = FacebookRequestErrorClassification.getDefaultErrorClassification();
        return localObject;
      }
      localObject = ((Utility.FetchedAppSettings)localObject).getErrorClassification();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Object getBatchRequestResult()
  {
    return batchRequestResult;
  }
  
  public Category getCategory()
  {
    return category;
  }
  
  public HttpURLConnection getConnection()
  {
    return connection;
  }
  
  public int getErrorCode()
  {
    return errorCode;
  }
  
  public String getErrorMessage()
  {
    String str = errorMessage;
    if (str != null) {
      return str;
    }
    return exception.getLocalizedMessage();
  }
  
  public String getErrorRecoveryMessage()
  {
    return errorRecoveryMessage;
  }
  
  public String getErrorType()
  {
    return errorType;
  }
  
  public String getErrorUserMessage()
  {
    return errorUserMessage;
  }
  
  public String getErrorUserTitle()
  {
    return errorUserTitle;
  }
  
  public FacebookException getException()
  {
    return exception;
  }
  
  public JSONObject getRequestResult()
  {
    return requestResult;
  }
  
  public JSONObject getRequestResultBody()
  {
    return requestResultBody;
  }
  
  public int getRequestStatusCode()
  {
    return requestStatusCode;
  }
  
  public int getSubErrorCode()
  {
    return subErrorCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{HttpStatus: ");
    localStringBuilder.append(requestStatusCode);
    localStringBuilder.append(", errorCode: ");
    localStringBuilder.append(errorCode);
    localStringBuilder.append(", errorType: ");
    localStringBuilder.append(errorType);
    localStringBuilder.append(", errorMessage: ");
    localStringBuilder.append(getErrorMessage());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static enum Category
  {
    LOGIN_RECOVERABLE,  OTHER,  TRANSIENT;
  }
  
  private static class Range
  {
    public final int lowerBound;
    public final int start;
    
    public Range(int paramInt1, int paramInt2)
    {
      start = paramInt1;
      lowerBound = paramInt2;
    }
    
    public boolean contains(int paramInt)
    {
      return (start <= paramInt) && (paramInt <= lowerBound);
    }
  }
}
