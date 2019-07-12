package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LegacyNativeDialogParameters
{
  public LegacyNativeDialogParameters() {}
  
  public static Bundle create(ShareLinkContent paramShareLinkContent, boolean paramBoolean)
  {
    Bundle localBundle = createBaseParameters(paramShareLinkContent, paramBoolean);
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.TITLE", paramShareLinkContent.getContentTitle());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.DESCRIPTION", paramShareLinkContent.getContentDescription());
    Utility.putUri(localBundle, "com.facebook.platform.extra.IMAGE", paramShareLinkContent.getImageUrl());
    return localBundle;
  }
  
  public static Bundle create(ShareOpenGraphContent paramShareOpenGraphContent, JSONObject paramJSONObject, boolean paramBoolean)
  {
    Bundle localBundle = createBaseParameters(paramShareOpenGraphContent, paramBoolean);
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", paramShareOpenGraphContent.getPreviewPropertyName());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.ACTION_TYPE", paramShareOpenGraphContent.getAction().getActionType());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.ACTION", paramJSONObject.toString());
    return localBundle;
  }
  
  public static Bundle create(SharePhotoContent paramSharePhotoContent, List paramList, boolean paramBoolean)
  {
    paramSharePhotoContent = createBaseParameters(paramSharePhotoContent, paramBoolean);
    paramSharePhotoContent.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(paramList));
    return paramSharePhotoContent;
  }
  
  public static Bundle create(ShareVideoContent paramShareVideoContent, boolean paramBoolean)
  {
    return null;
  }
  
  public static Bundle create(UUID paramUUID, ShareContent paramShareContent, boolean paramBoolean)
  {
    Validate.notNull(paramShareContent, "shareContent");
    Validate.notNull(paramUUID, "callId");
    if ((paramShareContent instanceof ShareLinkContent)) {
      return create((ShareLinkContent)paramShareContent, paramBoolean);
    }
    if ((paramShareContent instanceof SharePhotoContent))
    {
      paramShareContent = (SharePhotoContent)paramShareContent;
      return create(paramShareContent, ShareInternalUtility.getPhotoUrls(paramShareContent, paramUUID), paramBoolean);
    }
    if ((paramShareContent instanceof ShareVideoContent))
    {
      paramUUID = (ShareVideoContent)paramShareContent;
      return null;
    }
    if ((paramShareContent instanceof ShareOpenGraphContent))
    {
      paramShareContent = (ShareOpenGraphContent)paramShareContent;
      try
      {
        paramUUID = create(paramShareContent, ShareInternalUtility.toJSONObjectForCall(paramUUID, paramShareContent), paramBoolean);
        return paramUUID;
      }
      catch (JSONException paramUUID)
      {
        throw new FacebookException(StringBuilder.e(paramUUID, StringBuilder.append("Unable to create a JSON Object from the provided ShareOpenGraphContent: ")));
      }
    }
    return null;
  }
  
  public static Bundle createBaseParameters(ShareContent paramShareContent, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    Utility.putUri(localBundle, "com.facebook.platform.extra.LINK", paramShareContent.getContentUrl());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.PLACE", paramShareContent.getPlaceId());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.REF", paramShareContent.getRef());
    localBundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", paramBoolean);
    paramShareContent = paramShareContent.getPeopleIds();
    if (!Utility.isNullOrEmpty(paramShareContent)) {
      localBundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(paramShareContent));
    }
    return localBundle;
  }
}
