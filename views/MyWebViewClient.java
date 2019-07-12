package views;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient
  extends WebViewClient
{
  public boolean doClearHistory = false;
  
  public MyWebViewClient(Task.4 param4) {}
  
  private void onPageFinished(WebView paramWebView)
  {
    if (!doClearHistory)
    {
      doClearHistory = true;
      paramWebView.loadUrl("javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())");
    }
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
    if (!doClearHistory)
    {
      doClearHistory = true;
      paramWebView.loadUrl("javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())");
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (!doClearHistory)
    {
      doClearHistory = true;
      paramWebView.loadUrl("javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())");
    }
  }
}
