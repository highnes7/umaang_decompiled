package com.facebook;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TestUserManager
{
  public static final String LOG_TAG = "TestUserManager";
  public Map<String, JSONObject> appTestAccounts;
  public String testApplicationId;
  public String testApplicationSecret;
  
  public TestUserManager(String paramString1, String paramString2)
  {
    if ((!Utility.isNullOrEmpty(paramString2)) && (!Utility.isNullOrEmpty(paramString1)))
    {
      testApplicationSecret = paramString1;
      testApplicationId = paramString2;
      return;
    }
    throw new FacebookException("Must provide app ID and secret");
  }
  
  private JSONObject createTestAccount(List paramList, Mode paramMode, String paramString)
  {
    Bundle localBundle = f.sufficientlysecure.rootcommands.util.StringBuilder.put("installed", "true");
    localBundle.putString("permissions", getPermissionsString(paramList));
    localBundle.putString("access_token", getAppAccessToken());
    if (paramMode == Mode.SHARED) {
      localBundle.putString("name", String.format("Shared %s Testuser", new Object[] { getSharedTestAccountIdentifier(paramList, paramString) }));
    }
    paramString = new GraphRequest(null, String.format("%s/accounts/test-users", new Object[] { testApplicationId }), localBundle, HttpMethod.POST).executeAndWait();
    paramList = paramString.getError();
    paramString = paramString.getJSONObject();
    if (paramList != null) {
      return null;
    }
    if (paramMode == Mode.SHARED) {
      try
      {
        paramString.put("name", localBundle.getString("name"));
        storeTestAccount(paramString);
        return paramString;
      }
      catch (JSONException paramList)
      {
        for (;;) {}
      }
    }
    return paramString;
  }
  
  private JSONObject findOrCreateSharedTestAccount(List paramList, Mode paramMode, String paramString)
  {
    JSONObject localJSONObject = findTestAccountMatchingIdentifier(getSharedTestAccountIdentifier(paramList, paramString));
    if (localJSONObject != null) {
      return localJSONObject;
    }
    return createTestAccount(paramList, paramMode, paramString);
  }
  
  private JSONObject findTestAccountMatchingIdentifier(String paramString)
  {
    try
    {
      Iterator localIterator = appTestAccounts.values().iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject = (JSONObject)localIterator.next();
        boolean bool = localJSONObject.optString("name").contains(paramString);
        if (bool) {
          return localJSONObject;
        }
      }
      return null;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  private AccessToken getAccessTokenForUser(List paramList, Mode paramMode, String paramString)
  {
    retrieveTestAccountsForAppIfNeeded();
    List localList = paramList;
    if (Utility.isNullOrEmpty(paramList)) {
      localList = Arrays.asList(new String[] { "email", "publish_actions" });
    }
    if (paramMode == Mode.PRIVATE) {
      paramList = createTestAccount(localList, paramMode, paramString);
    } else {
      paramList = findOrCreateSharedTestAccount(localList, paramMode, paramString);
    }
    return new AccessToken(paramList.optString("access_token"), testApplicationId, paramList.optString("id"), localList, null, AccessTokenSource.TEST_USER, null, null);
  }
  
  private String getPermissionsString(List paramList)
  {
    return TextUtils.join(",", paramList);
  }
  
  private String getSharedTestAccountIdentifier(List paramList, String paramString)
  {
    long l2 = getPermissionsString(paramList).hashCode();
    long l1;
    if (paramString != null) {
      l1 = paramString.hashCode() & 0xFFFFFFFF;
    } else {
      l1 = 0L;
    }
    return validNameStringFromInteger(l1 ^ l2 & 0xFFFFFFFF);
  }
  
  /* Error */
  private void populateTestAccounts(org.json.JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: iload_3
    //   5: aload_1
    //   6: invokevirtual 233	org/json/JSONArray:length	()I
    //   9: if_icmpge +51 -> 60
    //   12: aload_1
    //   13: iload_3
    //   14: invokevirtual 237	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   17: astore 4
    //   19: aload_2
    //   20: aload 4
    //   22: ldc -57
    //   24: invokevirtual 168	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: invokevirtual 239	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   30: astore 5
    //   32: aload 4
    //   34: ldc 80
    //   36: aload 5
    //   38: ldc 80
    //   40: invokevirtual 168	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokevirtual 128	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   46: pop
    //   47: aload_0
    //   48: aload 4
    //   50: invokespecial 132	com/facebook/TestUserManager:storeTestAccount	(Lorg/json/JSONObject;)V
    //   53: iload_3
    //   54: iconst_1
    //   55: iadd
    //   56: istore_3
    //   57: goto -53 -> 4
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: goto +3 -> 69
    //   69: aload_1
    //   70: athrow
    //   71: astore 5
    //   73: goto -26 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	TestUserManager
    //   0	76	1	paramJSONArray	org.json.JSONArray
    //   0	76	2	paramJSONObject	JSONObject
    //   3	54	3	i	int
    //   17	32	4	localJSONObject1	JSONObject
    //   30	7	5	localJSONObject2	JSONObject
    //   71	1	5	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   4	32	63	java/lang/Throwable
    //   32	47	63	java/lang/Throwable
    //   47	53	63	java/lang/Throwable
    //   32	47	71	org/json/JSONException
  }
  
  private void retrieveTestAccountsForAppIfNeeded()
  {
    try
    {
      Object localObject1 = appTestAccounts;
      if (localObject1 != null) {
        return;
      }
      appTestAccounts = new HashMap();
      GraphRequest.defaultBatchApplicationId = testApplicationId;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("access_token", getAppAccessToken());
      localObject1 = new GraphRequest(null, "app/accounts/test-users", (Bundle)localObject1, null);
      ((GraphRequest)localObject1).setBatchEntryName("testUsers");
      ((GraphRequest)localObject1).setBatchEntryOmitResultOnSuccess(false);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("access_token", getAppAccessToken());
      ((Bundle)localObject2).putString("ids", "{result=testUsers:$.data.*.id}");
      ((Bundle)localObject2).putString("fields", "name");
      localObject2 = new GraphRequest(null, "", (Bundle)localObject2, null);
      ((GraphRequest)localObject2).setBatchEntryDependsOn("testUsers");
      localObject1 = GraphRequest.executeBatchAndWait(new GraphRequest[] { localObject1, localObject2 });
      if (((List)localObject1).size() == 2)
      {
        populateTestAccounts(((GraphResponse)((List)localObject1).get(0)).getJSONObject().optJSONArray("data"), ((GraphResponse)((List)localObject1).get(1)).getJSONObject());
        return;
      }
      throw new FacebookException("Unexpected number of results from TestUsers batch query");
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void storeTestAccount(JSONObject paramJSONObject)
  {
    try
    {
      appTestAccounts.put(paramJSONObject.optString("id"), paramJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      throw paramJSONObject;
    }
  }
  
  private String validNameStringFromInteger(long paramLong)
  {
    Object localObject = Long.toString(paramLong);
    StringBuilder localStringBuilder = new StringBuilder("Perm");
    localObject = ((String)localObject).toCharArray();
    int m = localObject.length;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      int k = localObject[j];
      if (k == i) {
        i = (char)(k + 10);
      } else {
        i = k;
      }
      localStringBuilder.append((char)(i + 97 - 48));
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public AccessToken getAccessTokenForPrivateUser(List paramList)
  {
    return getAccessTokenForUser(paramList, Mode.PRIVATE, null);
  }
  
  public AccessToken getAccessTokenForSharedUser(List paramList)
  {
    return getAccessTokenForSharedUser(paramList, null);
  }
  
  public AccessToken getAccessTokenForSharedUser(List paramList, String paramString)
  {
    return getAccessTokenForUser(paramList, Mode.SHARED, paramString);
  }
  
  public final String getAppAccessToken()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(testApplicationId);
    localStringBuilder.append("|");
    localStringBuilder.append(testApplicationSecret);
    return localStringBuilder.toString();
  }
  
  public String getTestApplicationId()
  {
    try
    {
      String str = testApplicationId;
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String getTestApplicationSecret()
  {
    try
    {
      String str = testApplicationSecret;
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private static enum Mode
  {
    PRIVATE,  SHARED;
  }
}
