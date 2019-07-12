package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

public final class LikeStatusClient
  extends PlatformServiceClient
{
  public String objectId;
  
  public LikeStatusClient(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, 65542, 65543, 20141001, paramString1);
    objectId = paramString2;
  }
  
  public void populateRequestBundle(Bundle paramBundle)
  {
    paramBundle.putString("com.facebook.platform.extra.OBJECT_ID", objectId);
  }
}
