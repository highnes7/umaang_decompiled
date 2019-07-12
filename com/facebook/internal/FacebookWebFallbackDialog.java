package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog
  extends WebDialog
{
  public static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
  public static final String TAG = "com.facebook.internal.FacebookWebFallbackDialog";
  public boolean waitingForDialogToClose;
  
  public FacebookWebFallbackDialog(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, 16973840);
    setExpectedRedirectUrl(paramString2);
  }
  
  public void cancel()
  {
    WebView localWebView = getWebView();
    if ((isPageFinished()) && (!isListenerCalled()) && (localWebView != null) && (localWebView.isShown()))
    {
      if (waitingForDialogToClose) {
        return;
      }
      waitingForDialogToClose = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
      localWebView.loadUrl(localStringBuilder.toString());
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public void run()
        {
          FacebookWebFallbackDialog.access$001(FacebookWebFallbackDialog.this);
        }
      }, 1500L);
      return;
    }
    super.cancel();
  }
  
  public Bundle parseResponseUri(String paramString)
  {
    Bundle localBundle = Utility.parseUrlQueryString(Uri.parse(paramString).getQuery());
    paramString = localBundle.getString("bridge_args");
    localBundle.remove("bridge_args");
    if (!Utility.isNullOrEmpty(paramString)) {
      try
      {
        localBundle.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(paramString)));
      }
      catch (JSONException paramString)
      {
        Utility.logd(TAG, "Unable to parse bridge_args JSON", paramString);
      }
    }
    String str = localBundle.getString("method_results");
    paramString = str;
    localBundle.remove("method_results");
    if (!Utility.isNullOrEmpty(str))
    {
      if (Utility.isNullOrEmpty(str)) {
        paramString = "{}";
      }
      try
      {
        localBundle.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(paramString)));
      }
      catch (JSONException paramString)
      {
        Utility.logd(TAG, "Unable to parse bridge_args JSON", paramString);
      }
    }
    localBundle.remove("version");
    localBundle.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getLatestKnownVersion());
    return localBundle;
  }
}
