package com.facebook.internal;

import android.graphics.Bitmap;

public class ImageResponse
{
  public Bitmap bitmap;
  public Exception error;
  public boolean isCachedRedirect;
  public ImageRequest request;
  
  public ImageResponse(ImageRequest paramImageRequest, Exception paramException, boolean paramBoolean, Bitmap paramBitmap)
  {
    request = paramImageRequest;
    error = paramException;
    bitmap = paramBitmap;
    isCachedRedirect = paramBoolean;
  }
  
  public Bitmap getBitmap()
  {
    return bitmap;
  }
  
  public Exception getError()
  {
    return error;
  }
  
  public ImageRequest getRequest()
  {
    return request;
  }
  
  public boolean isCachedRedirect()
  {
    return isCachedRedirect;
  }
}
