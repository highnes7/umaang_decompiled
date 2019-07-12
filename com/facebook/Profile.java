package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

public final class Profile
  implements Parcelable
{
  public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator()
  {
    public Profile createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Profile(paramAnonymousParcel);
    }
    
    public Profile[] newArray(int paramAnonymousInt)
    {
      return new Profile[paramAnonymousInt];
    }
  };
  public static final String FIRST_NAME_KEY = "first_name";
  public static final String ID_KEY = "id";
  public static final String LAST_NAME_KEY = "last_name";
  public static final String LINK_URI_KEY = "link_uri";
  public static final String MIDDLE_NAME_KEY = "middle_name";
  public static final String NAME_KEY = "name";
  public final String firstName;
  public final String id;
  public final String lastName;
  public final Uri linkUri;
  public final String middleName;
  public final String name;
  
  public Profile(Parcel paramParcel)
  {
    id = paramParcel.readString();
    firstName = paramParcel.readString();
    middleName = paramParcel.readString();
    lastName = paramParcel.readString();
    name = paramParcel.readString();
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      paramParcel = null;
    } else {
      paramParcel = Uri.parse(paramParcel);
    }
    linkUri = paramParcel;
  }
  
  public Profile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Uri paramUri)
  {
    Validate.notNullOrEmpty(paramString1, "id");
    id = paramString1;
    firstName = paramString2;
    middleName = paramString3;
    lastName = paramString4;
    name = paramString5;
    linkUri = paramUri;
  }
  
  public Profile(JSONObject paramJSONObject)
  {
    Object localObject = null;
    id = paramJSONObject.optString("id", null);
    firstName = paramJSONObject.optString("first_name", null);
    middleName = paramJSONObject.optString("middle_name", null);
    lastName = paramJSONObject.optString("last_name", null);
    name = paramJSONObject.optString("name", null);
    paramJSONObject = paramJSONObject.optString("link_uri", null);
    if (paramJSONObject == null) {
      paramJSONObject = localObject;
    } else {
      paramJSONObject = Uri.parse(paramJSONObject);
    }
    linkUri = paramJSONObject;
  }
  
  public static void fetchProfileForCurrentAccessToken()
  {
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    if (localAccessToken == null)
    {
      setCurrentProfile(null);
      return;
    }
    Utility.getGraphMeRequestWithCacheAsync(localAccessToken.getToken(), new Utility.GraphMeRequestWithCacheCallback()
    {
      public void onFailure(FacebookException paramAnonymousFacebookException) {}
      
      public void onSuccess(JSONObject paramAnonymousJSONObject)
      {
        String str1 = paramAnonymousJSONObject.optString("id");
        if (str1 == null) {
          return;
        }
        String str6 = paramAnonymousJSONObject.optString("link");
        String str2 = paramAnonymousJSONObject.optString("first_name");
        String str3 = paramAnonymousJSONObject.optString("middle_name");
        String str4 = paramAnonymousJSONObject.optString("last_name");
        String str5 = paramAnonymousJSONObject.optString("name");
        if (str6 != null) {
          paramAnonymousJSONObject = Uri.parse(str6);
        } else {
          paramAnonymousJSONObject = null;
        }
        Profile.setCurrentProfile(new Profile(str1, str2, str3, str4, str5, paramAnonymousJSONObject));
      }
    });
  }
  
  public static Profile getCurrentProfile()
  {
    return ProfileManager.getInstance().getCurrentProfile();
  }
  
  public static void setCurrentProfile(Profile paramProfile)
  {
    ProfileManager.getInstance().setCurrentProfile(paramProfile);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Profile)) {
      return false;
    }
    paramObject = (Profile)paramObject;
    if ((id.equals(id)) && (firstName == null)) {
      if (firstName == null) {
        return true;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            if ((!firstName.equals(firstName)) || (middleName != null)) {
              break;
            }
          } while (middleName != null);
          return true;
          if ((!middleName.equals(middleName)) || (lastName != null)) {
            break;
          }
        } while (lastName != null);
        return true;
        if ((!lastName.equals(lastName)) || (name != null)) {
          break;
        }
      } while (name != null);
      return true;
      if ((!name.equals(name)) || (linkUri != null)) {
        break;
      }
    } while (linkUri != null);
    return true;
    return linkUri.equals(linkUri);
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getLastName()
  {
    return lastName;
  }
  
  public Uri getLinkUri()
  {
    return linkUri;
  }
  
  public String getMiddleName()
  {
    return middleName;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Uri getProfilePictureUri(int paramInt1, int paramInt2)
  {
    return ImageRequest.getProfilePictureUri(id, paramInt1, paramInt2);
  }
  
  public int hashCode()
  {
    int j = id.hashCode() + 527;
    Object localObject = firstName;
    int i = j;
    if (localObject != null) {
      i = j * 31 + ((String)localObject).hashCode();
    }
    localObject = middleName;
    j = i;
    if (localObject != null) {
      j = i * 31 + ((String)localObject).hashCode();
    }
    localObject = lastName;
    i = j;
    if (localObject != null) {
      i = j * 31 + ((String)localObject).hashCode();
    }
    localObject = name;
    j = i;
    if (localObject != null) {
      j = i * 31 + ((String)localObject).hashCode();
    }
    localObject = linkUri;
    i = j;
    if (localObject != null) {
      i = j * 31 + ((Uri)localObject).hashCode();
    }
    return i;
  }
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = id;
    try
    {
      localJSONObject.put("id", localObject);
      localObject = firstName;
      localJSONObject.put("first_name", localObject);
      localObject = middleName;
      localJSONObject.put("middle_name", localObject);
      localObject = lastName;
      localJSONObject.put("last_name", localObject);
      localObject = name;
      localJSONObject.put("name", localObject);
      if (linkUri == null) {
        return localJSONObject;
      }
      localObject = linkUri;
      localJSONObject.put("link_uri", ((Uri)localObject).toString());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
      return localJSONException;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(id);
    paramParcel.writeString(firstName);
    paramParcel.writeString(middleName);
    paramParcel.writeString(lastName);
    paramParcel.writeString(name);
    Object localObject = linkUri;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Uri)localObject).toString();
    }
    paramParcel.writeString((String)localObject);
  }
}
