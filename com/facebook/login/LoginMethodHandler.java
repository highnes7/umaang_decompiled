package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class LoginMethodHandler
  implements Parcelable
{
  public LoginClient loginClient;
  public Map<String, String> methodLoggingExtras;
  
  public LoginMethodHandler(Parcel paramParcel)
  {
    methodLoggingExtras = Utility.readStringMapFromParcel(paramParcel);
  }
  
  public LoginMethodHandler(LoginClient paramLoginClient)
  {
    loginClient = paramLoginClient;
  }
  
  public static AccessToken createAccessTokenFromNativeLogin(Bundle paramBundle, AccessTokenSource paramAccessTokenSource, String paramString)
  {
    Date localDate = Utility.getBundleLongAsDate(paramBundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
    ArrayList localArrayList = paramBundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
    String str = paramBundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
    if (Utility.isNullOrEmpty(str)) {
      return null;
    }
    return new AccessToken(str, paramString, paramBundle.getString("com.facebook.platform.extra.USER_ID"), localArrayList, null, paramAccessTokenSource, localDate, new Date());
  }
  
  public static AccessToken createAccessTokenFromWebBundle(Collection paramCollection, Bundle paramBundle, AccessTokenSource paramAccessTokenSource, String paramString)
    throws FacebookException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a8 = a7\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public static String getUserIDFromSignedRequest(String paramString)
    throws FacebookException
  {
    if ((paramString != null) && (!paramString.isEmpty())) {}
    try
    {
      paramString = paramString.split("\\.");
      if (paramString.length == 2)
      {
        paramString = paramString[1];
        paramString = Base64.decode(paramString, 0);
        paramString = new String(paramString, "UTF-8");
        paramString = new JSONObject(paramString).getString("user_id");
        return paramString;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
    throw new FacebookException("Failed to retrieve user_id from signed_request");
    throw new FacebookException("Authorization response does not contain the signed_request");
  }
  
  public void addLoggingExtra(String paramString, Object paramObject)
  {
    if (methodLoggingExtras == null) {
      methodLoggingExtras = new HashMap();
    }
    Map localMap = methodLoggingExtras;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = paramObject.toString();
    }
    localMap.put(paramString, paramObject);
  }
  
  public void cancel() {}
  
  public abstract String getNameForLogging();
  
  public void logWebLoginCompleted(String paramString)
  {
    String str = loginClient.getPendingRequest().getApplicationId();
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(loginClient.getActivity(), str);
    paramString = StringBuilder.put("fb_web_login_e2e", paramString);
    paramString.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
    paramString.putString("app_id", str);
    localAppEventsLogger.logSdkEvent("fb_dialogs_web_login_dialog_complete", null, paramString);
  }
  
  public boolean needsInternetPermission()
  {
    return false;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public void setLoginClient(LoginClient paramLoginClient)
  {
    if (loginClient == null)
    {
      loginClient = paramLoginClient;
      return;
    }
    throw new FacebookException("Can't set LoginClient if it is already set.");
  }
  
  public abstract boolean tryAuthorize(LoginClient.Request paramRequest);
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Utility.writeStringMapToParcel(paramParcel, methodLoggingExtras);
  }
}
