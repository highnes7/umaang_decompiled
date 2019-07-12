package com.facebook.internal;

import com.facebook.FacebookRequestError.Category;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FacebookRequestErrorClassification
{
  public static final int EC_APP_TOO_MANY_CALLS = 4;
  public static final int EC_INVALID_SESSION = 102;
  public static final int EC_INVALID_TOKEN = 190;
  public static final int EC_RATE = 9;
  public static final int EC_SERVICE_UNAVAILABLE = 2;
  public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
  public static final int EC_USER_TOO_MANY_CALLS = 17;
  public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
  public static final String KEY_NAME = "name";
  public static final String KEY_OTHER = "other";
  public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
  public static final String KEY_TRANSIENT = "transient";
  public static FacebookRequestErrorClassification defaultInstance;
  public final Map<Integer, Set<Integer>> loginRecoverableErrors;
  public final String loginRecoverableRecoveryMessage;
  public final Map<Integer, Set<Integer>> otherErrors;
  public final String otherRecoveryMessage;
  public final Map<Integer, Set<Integer>> transientErrors;
  public final String transientRecoveryMessage;
  
  public FacebookRequestErrorClassification(Map paramMap1, Map paramMap2, Map paramMap3, String paramString1, String paramString2, String paramString3)
  {
    otherErrors = paramMap1;
    transientErrors = paramMap2;
    loginRecoverableErrors = paramMap3;
    otherRecoveryMessage = paramString1;
    transientRecoveryMessage = paramString2;
    loginRecoverableRecoveryMessage = paramString3;
  }
  
  public static FacebookRequestErrorClassification createFromJSON(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int i = 0;
    Object localObject4 = null;
    Object localObject3 = null;
    Map localMap = null;
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = null;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      if (localJSONObject == null)
      {
        localObject5 = localObject4;
        localObject6 = localObject3;
        localObject7 = localObject2;
        localObject8 = localObject1;
      }
      else
      {
        String str2 = localJSONObject.optString("name");
        if (str2 == null)
        {
          localObject5 = localObject4;
          localObject6 = localObject3;
          localObject7 = localObject2;
          localObject8 = localObject1;
        }
        else if (str2.equalsIgnoreCase("other"))
        {
          localObject7 = localJSONObject.optString("recovery_message", null);
          localObject5 = parseJSONDefinition(localJSONObject);
          localObject6 = localObject3;
          localObject8 = localObject1;
        }
        else if (str2.equalsIgnoreCase("transient"))
        {
          localObject8 = localJSONObject.optString("recovery_message", null);
          localObject6 = parseJSONDefinition(localJSONObject);
          localObject5 = localObject4;
          localObject7 = localObject2;
        }
        else
        {
          localObject5 = localObject4;
          localObject6 = localObject3;
          localObject7 = localObject2;
          localObject8 = localObject1;
          if (str2.equalsIgnoreCase("login_recoverable"))
          {
            str1 = localJSONObject.optString("recovery_message", null);
            localMap = parseJSONDefinition(localJSONObject);
            localObject8 = localObject1;
            localObject7 = localObject2;
            localObject6 = localObject3;
            localObject5 = localObject4;
          }
        }
      }
      i += 1;
      localObject4 = localObject5;
      localObject3 = localObject6;
      localObject2 = localObject7;
      localObject1 = localObject8;
    }
    return new FacebookRequestErrorClassification(localObject4, localObject3, localMap, localObject2, localObject1, str1);
  }
  
  public static FacebookRequestErrorClassification getDefaultErrorClassification()
  {
    try
    {
      if (defaultInstance == null) {
        defaultInstance = getDefaultErrorClassificationImpl();
      }
      FacebookRequestErrorClassification localFacebookRequestErrorClassification = defaultInstance;
      return localFacebookRequestErrorClassification;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static FacebookRequestErrorClassification getDefaultErrorClassificationImpl()
  {
    new FacebookRequestErrorClassification(null, new HashMap()new HashMap {}, new HashMap() {}, null, null, null);
  }
  
  public static Map parseJSONDefinition(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("items");
    if (localJSONArray1.length() == 0) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < localJSONArray1.length())
    {
      paramJSONObject = localJSONArray1.optJSONObject(i);
      if (paramJSONObject != null)
      {
        int k = paramJSONObject.optInt("code");
        if (k != 0)
        {
          JSONArray localJSONArray2 = paramJSONObject.optJSONArray("subcodes");
          if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
          {
            HashSet localHashSet = new HashSet();
            int j = 0;
            for (;;)
            {
              paramJSONObject = localHashSet;
              if (j >= localJSONArray2.length()) {
                break;
              }
              int m = localJSONArray2.optInt(j);
              if (m != 0) {
                localHashSet.add(Integer.valueOf(m));
              }
              j += 1;
            }
          }
          paramJSONObject = null;
          localHashMap.put(Integer.valueOf(k), paramJSONObject);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public FacebookRequestError.Category classify(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return FacebookRequestError.Category.TRANSIENT;
    }
    Object localObject = otherErrors;
    if ((localObject != null) && (((Map)localObject).containsKey(Integer.valueOf(paramInt1))))
    {
      localObject = (Set)otherErrors.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((Set)localObject).contains(Integer.valueOf(paramInt2)))) {
        return FacebookRequestError.Category.OTHER;
      }
    }
    localObject = loginRecoverableErrors;
    if ((localObject != null) && (((Map)localObject).containsKey(Integer.valueOf(paramInt1))))
    {
      localObject = (Set)loginRecoverableErrors.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((Set)localObject).contains(Integer.valueOf(paramInt2)))) {
        return FacebookRequestError.Category.LOGIN_RECOVERABLE;
      }
    }
    localObject = transientErrors;
    if ((localObject != null) && (((Map)localObject).containsKey(Integer.valueOf(paramInt1))))
    {
      localObject = (Set)transientErrors.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((Set)localObject).contains(Integer.valueOf(paramInt2)))) {
        return FacebookRequestError.Category.TRANSIENT;
      }
    }
    return FacebookRequestError.Category.OTHER;
  }
  
  public Map getLoginRecoverableErrors()
  {
    return loginRecoverableErrors;
  }
  
  public Map getOtherErrors()
  {
    return otherErrors;
  }
  
  public String getRecoveryMessage(FacebookRequestError.Category paramCategory)
  {
    int i = paramCategory.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        return transientRecoveryMessage;
      }
      return otherRecoveryMessage;
    }
    return loginRecoverableRecoveryMessage;
  }
  
  public Map getTransientErrors()
  {
    return transientErrors;
  }
}
