package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.Locale;

public class ImageRequest
{
  public static final String AUTHORITY = "graph.facebook.com";
  public static final String HEIGHT_PARAM = "height";
  public static final String MIGRATION_PARAM = "migration_overrides";
  public static final String MIGRATION_VALUE = "{october_2012:true}";
  public static final String PATH = "%s/picture";
  public static final String SCHEME = "https";
  public static final int UNSPECIFIED_DIMENSION = 0;
  public static final String WIDTH_PARAM = "width";
  public boolean allowCachedRedirects;
  public Callback callback;
  public Object callerTag;
  public Context context;
  public Uri imageUri;
  
  public ImageRequest(Builder paramBuilder)
  {
    context = context;
    imageUri = imageUrl;
    callback = callback;
    allowCachedRedirects = allowCachedRedirects;
    Object localObject = callerTag;
    paramBuilder = localObject;
    if (localObject == null) {
      paramBuilder = new Object();
    }
    callerTag = paramBuilder;
  }
  
  public static Uri getProfilePictureUri(String paramString, int paramInt1, int paramInt2)
  {
    Validate.notNullOrEmpty(paramString, "userId");
    paramInt1 = Math.max(paramInt1, 0);
    paramInt2 = Math.max(paramInt2, 0);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      throw new IllegalArgumentException("Either width or height must be greater than 0");
    }
    paramString = new Uri.Builder().scheme("https").authority("graph.facebook.com").path(String.format(Locale.US, "%s/picture", new Object[] { paramString }));
    if (paramInt2 != 0) {
      paramString.appendQueryParameter("height", String.valueOf(paramInt2));
    }
    if (paramInt1 != 0) {
      paramString.appendQueryParameter("width", String.valueOf(paramInt1));
    }
    paramString.appendQueryParameter("migration_overrides", "{october_2012:true}");
    return paramString.build();
  }
  
  public Callback getCallback()
  {
    return callback;
  }
  
  public Object getCallerTag()
  {
    return callerTag;
  }
  
  public Context getContext()
  {
    return context;
  }
  
  public Uri getImageUri()
  {
    return imageUri;
  }
  
  public boolean isCachedRedirectAllowed()
  {
    return allowCachedRedirects;
  }
  
  public static class Builder
  {
    public boolean allowCachedRedirects;
    public ImageRequest.Callback callback;
    public Object callerTag;
    public Context context;
    public Uri imageUrl;
    
    public Builder(Context paramContext, Uri paramUri)
    {
      Validate.notNull(paramUri, "imageUri");
      context = paramContext;
      imageUrl = paramUri;
    }
    
    public ImageRequest build()
    {
      return new ImageRequest(this);
    }
    
    public Builder setAllowCachedRedirects(boolean paramBoolean)
    {
      allowCachedRedirects = paramBoolean;
      return this;
    }
    
    public Builder setCallback(ImageRequest.Callback paramCallback)
    {
      callback = paramCallback;
      return this;
    }
    
    public Builder setCallerTag(Object paramObject)
    {
      callerTag = paramObject;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onCompleted(ImageResponse paramImageResponse);
  }
}
