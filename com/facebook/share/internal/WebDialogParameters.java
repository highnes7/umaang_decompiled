package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class WebDialogParameters
{
  public WebDialogParameters() {}
  
  public static Bundle create(AppGroupCreationContent paramAppGroupCreationContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "name", paramAppGroupCreationContent.getName());
    Utility.putNonEmptyString(localBundle, "description", paramAppGroupCreationContent.getDescription());
    paramAppGroupCreationContent = paramAppGroupCreationContent.getAppGroupPrivacy();
    if (paramAppGroupCreationContent != null) {
      Utility.putNonEmptyString(localBundle, "privacy", paramAppGroupCreationContent.toString().toLowerCase(Locale.ENGLISH));
    }
    return localBundle;
  }
  
  public static Bundle create(GameRequestContent paramGameRequestContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "message", paramGameRequestContent.getMessage());
    Utility.putNonEmptyString(localBundle, "to", paramGameRequestContent.getTo());
    Utility.putNonEmptyString(localBundle, "title", paramGameRequestContent.getTitle());
    Utility.putNonEmptyString(localBundle, "data", paramGameRequestContent.getData());
    if (paramGameRequestContent.getActionType() != null) {
      Utility.putNonEmptyString(localBundle, "action_type", paramGameRequestContent.getActionType().toString().toLowerCase(Locale.ENGLISH));
    }
    Utility.putNonEmptyString(localBundle, "object_id", paramGameRequestContent.getObjectId());
    if (paramGameRequestContent.getFilters() != null) {
      Utility.putNonEmptyString(localBundle, "filters", paramGameRequestContent.getFilters().toString().toLowerCase(Locale.ENGLISH));
    }
    Utility.putCommaSeparatedStringList(localBundle, "suggestions", paramGameRequestContent.getSuggestions());
    return localBundle;
  }
  
  public static Bundle create(ShareLinkContent paramShareLinkContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putUri(localBundle, "href", paramShareLinkContent.getContentUrl());
    return localBundle;
  }
  
  public static Bundle create(ShareOpenGraphContent paramShareOpenGraphContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "action_type", paramShareOpenGraphContent.getAction().getActionType());
    try
    {
      paramShareOpenGraphContent = ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForWeb(paramShareOpenGraphContent), false);
      if (paramShareOpenGraphContent != null)
      {
        Utility.putNonEmptyString(localBundle, "action_properties", paramShareOpenGraphContent.toString());
        return localBundle;
      }
    }
    catch (JSONException paramShareOpenGraphContent)
    {
      throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", paramShareOpenGraphContent);
    }
    return localBundle;
  }
  
  public static Bundle createForFeed(ShareFeedContent paramShareFeedContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "to", paramShareFeedContent.getToId());
    Utility.putNonEmptyString(localBundle, "link", paramShareFeedContent.getLink());
    Utility.putNonEmptyString(localBundle, "picture", paramShareFeedContent.getPicture());
    Utility.putNonEmptyString(localBundle, "source", paramShareFeedContent.getMediaSource());
    Utility.putNonEmptyString(localBundle, "name", paramShareFeedContent.getLinkName());
    Utility.putNonEmptyString(localBundle, "caption", paramShareFeedContent.getLinkCaption());
    Utility.putNonEmptyString(localBundle, "description", paramShareFeedContent.getLinkDescription());
    return localBundle;
  }
  
  public static Bundle createForFeed(ShareLinkContent paramShareLinkContent)
  {
    Bundle localBundle = new Bundle();
    Utility.putNonEmptyString(localBundle, "name", paramShareLinkContent.getContentTitle());
    Utility.putNonEmptyString(localBundle, "description", paramShareLinkContent.getContentDescription());
    Utility.putNonEmptyString(localBundle, "link", Utility.getUriString(paramShareLinkContent.getContentUrl()));
    Utility.putNonEmptyString(localBundle, "picture", Utility.getUriString(paramShareLinkContent.getImageUrl()));
    return localBundle;
  }
}
