package com.facebook.messenger;

import android.net.Uri;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ShareToMessengerParams
{
  public static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
  public static final Set<String> VALID_MIME_TYPES;
  public static final Set<String> VALID_URI_SCHEMES;
  public final Uri externalUri;
  public final String metaData;
  public final String mimeType;
  public final Uri tempFile;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("image/*");
    localHashSet.add("image/jpeg");
    localHashSet.add("image/png");
    localHashSet.add("image/gif");
    localHashSet.add("image/webp");
    localHashSet.add("video/*");
    localHashSet.add("video/mp4");
    localHashSet.add("audio/*");
    localHashSet.add("audio/mpeg");
    VALID_MIME_TYPES = Collections.unmodifiableSet(localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("content");
    localHashSet.add("android.resource");
    localHashSet.add("file");
    VALID_URI_SCHEMES = Collections.unmodifiableSet(localHashSet);
    localHashSet = new HashSet();
    localHashSet.add("http");
    localHashSet.add("https");
    VALID_EXTERNAL_URI_SCHEMES = Collections.unmodifiableSet(localHashSet);
  }
  
  public ShareToMessengerParams(ShareToMessengerParamsBuilder paramShareToMessengerParamsBuilder)
  {
    tempFile = paramShareToMessengerParamsBuilder.getUri();
    mimeType = paramShareToMessengerParamsBuilder.getMimeType();
    metaData = paramShareToMessengerParamsBuilder.getMetaData();
    externalUri = paramShareToMessengerParamsBuilder.getExternalUri();
    paramShareToMessengerParamsBuilder = tempFile;
    if (paramShareToMessengerParamsBuilder != null)
    {
      if (mimeType != null)
      {
        if (VALID_URI_SCHEMES.contains(paramShareToMessengerParamsBuilder.getScheme()))
        {
          if (VALID_MIME_TYPES.contains(mimeType))
          {
            paramShareToMessengerParamsBuilder = externalUri;
            if (paramShareToMessengerParamsBuilder != null)
            {
              if (VALID_EXTERNAL_URI_SCHEMES.contains(paramShareToMessengerParamsBuilder.getScheme())) {
                return;
              }
              paramShareToMessengerParamsBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unsupported external uri scheme: ");
              paramShareToMessengerParamsBuilder.append(externalUri.getScheme());
              throw new IllegalArgumentException(paramShareToMessengerParamsBuilder.toString());
            }
          }
          else
          {
            paramShareToMessengerParamsBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unsupported mime-type: ");
            paramShareToMessengerParamsBuilder.append(mimeType);
            throw new IllegalArgumentException(paramShareToMessengerParamsBuilder.toString());
          }
        }
        else
        {
          paramShareToMessengerParamsBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unsupported URI scheme: ");
          paramShareToMessengerParamsBuilder.append(tempFile.getScheme());
          throw new IllegalArgumentException(paramShareToMessengerParamsBuilder.toString());
        }
      }
      else {
        throw new NullPointerException("Must provide mimeType");
      }
    }
    else {
      throw new NullPointerException("Must provide non-null uri");
    }
  }
  
  public static ShareToMessengerParamsBuilder newBuilder(Uri paramUri, String paramString)
  {
    return new ShareToMessengerParamsBuilder(paramUri, paramString);
  }
}
