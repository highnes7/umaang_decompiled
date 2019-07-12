package com.facebook.messenger;

import android.net.Uri;

public class ShareToMessengerParamsBuilder
{
  public Uri mExternalUri;
  public String mMetaData;
  public final String mMimeType;
  public final Uri mUri;
  
  public ShareToMessengerParamsBuilder(Uri paramUri, String paramString)
  {
    mUri = paramUri;
    mMimeType = paramString;
  }
  
  public ShareToMessengerParams build()
  {
    return new ShareToMessengerParams(this);
  }
  
  public Uri getExternalUri()
  {
    return mExternalUri;
  }
  
  public String getMetaData()
  {
    return mMetaData;
  }
  
  public String getMimeType()
  {
    return mMimeType;
  }
  
  public Uri getUri()
  {
    return mUri;
  }
  
  public ShareToMessengerParamsBuilder setExternalUri(Uri paramUri)
  {
    mExternalUri = paramUri;
    return this;
  }
  
  public ShareToMessengerParamsBuilder setMetaData(String paramString)
  {
    mMetaData = paramString;
    return this;
  }
}
