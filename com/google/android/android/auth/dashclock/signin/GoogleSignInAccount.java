package com.google.android.android.auth.dashclock.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Clock;
import com.google.android.android.common.util.Log;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.GoogleSignInAccount> CREATOR = new VerticalProgressBar.SavedState.1();
  public static Log zzebv = Clock.zzfyr;
  public static Comparator<com.google.android.gms.common.api.Scope> zzecc = new Version.BuildAwareOrder();
  public int versionCode;
  public String zzbsx;
  public List<com.google.android.gms.common.api.Scope> zzdxx;
  public String zzeaf;
  public String zzeag;
  public String zzeaw;
  public String zzebw;
  public String zzebx;
  public Uri zzeby;
  public String zzebz;
  public long zzeca;
  public String zzecb;
  
  public GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List paramList, String paramString7, String paramString8)
  {
    versionCode = paramInt;
    zzbsx = paramString1;
    zzeaw = paramString2;
    zzebw = paramString3;
    zzebx = paramString4;
    zzeby = paramUri;
    zzebz = paramString5;
    zzeca = paramLong;
    zzecb = paramString6;
    zzdxx = paramList;
    zzeaf = paramString7;
    zzeag = paramString8;
  }
  
  private final JSONObject toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject1 = getId();
      if (localObject1 != null) {
        localJSONObject.put("id", getId());
      }
      localObject1 = getIdToken();
      if (localObject1 != null) {
        localJSONObject.put("tokenId", getIdToken());
      }
      localObject1 = getEmail();
      if (localObject1 != null) {
        localJSONObject.put("email", getEmail());
      }
      localObject1 = getDisplayName();
      if (localObject1 != null) {
        localJSONObject.put("displayName", getDisplayName());
      }
      localObject1 = getGivenName();
      if (localObject1 != null) {
        localJSONObject.put("givenName", getGivenName());
      }
      localObject1 = getFamilyName();
      if (localObject1 != null) {
        localJSONObject.put("familyName", getFamilyName());
      }
      localObject1 = getPhotoUrl();
      if (localObject1 != null) {
        localJSONObject.put("photoUrl", getPhotoUrl().toString());
      }
      localObject1 = getServerAuthCode();
      if (localObject1 != null) {
        localJSONObject.put("serverAuthCode", getServerAuthCode());
      }
      long l = zzeca;
      localJSONObject.get("expirationTime", l);
      localObject1 = zzecb;
      localJSONObject.put("obfuscatedIdentifier", localObject1);
      localObject1 = new JSONArray();
      Object localObject2 = zzdxx;
      Object localObject3 = zzecc;
      Collections.sort((List)localObject2, (Comparator)localObject3);
      localObject2 = zzdxx;
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject2).hasNext();
        if (!bool) {
          break;
        }
        localObject3 = ((Iterator)localObject2).next();
        localObject3 = (com.google.android.android.common.package_9.Scope)localObject3;
        ((JSONArray)localObject1).put(((com.google.android.android.common.package_9.Scope)localObject3).zzaft());
      }
      localJSONObject.put("grantedScopes", localObject1);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localJSONException);
      throw localRuntimeException;
    }
  }
  
  public static GoogleSignInAccount zzem(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {
      paramString = Uri.parse(paramString);
    } else {
      paramString = null;
    }
    long l = Long.parseLong(localJSONObject.getString("expirationTime"));
    HashSet localHashSet = new HashSet();
    Object localObject = localJSONObject.getJSONArray("grantedScopes");
    int j = ((JSONArray)localObject).length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new com.google.android.android.common.package_9.Scope(1, ((JSONArray)localObject).getString(i)));
      i += 1;
    }
    String str1 = localJSONObject.optString("id");
    String str2 = localJSONObject.optString("tokenId", null);
    String str3 = localJSONObject.optString("email", null);
    String str4 = localJSONObject.optString("displayName", null);
    String str5 = localJSONObject.optString("givenName", null);
    String str6 = localJSONObject.optString("familyName", null);
    Long localLong = Long.valueOf(l);
    localObject = localLong;
    String str7 = localJSONObject.getString("obfuscatedIdentifier");
    if (localLong == null) {
      localObject = Long.valueOf(zzebv.currentTimeMillis() / 1000L);
    }
    l = ((Long)localObject).longValue();
    zzbp.zzgg(str7);
    zzbp.append(localHashSet);
    paramString = new GoogleSignInAccount(3, str1, str2, str3, str4, paramString, null, l, str7, new ArrayList((Collection)localHashSet), str5, str6);
    zzebz = localJSONObject.optString("serverAuthCode", null);
    return paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    return ((GoogleSignInAccount)paramObject).toJsonObject().toString().equals(toJsonObject().toString());
  }
  
  public Account getAccount()
  {
    String str = zzebw;
    if (str == null) {
      return null;
    }
    return new Account(str, "com.google");
  }
  
  public String getDisplayName()
  {
    return zzebx;
  }
  
  public String getEmail()
  {
    return zzebw;
  }
  
  public String getFamilyName()
  {
    return zzeag;
  }
  
  public String getGivenName()
  {
    return zzeaf;
  }
  
  public Set getGrantedScopes()
  {
    return new HashSet(zzdxx);
  }
  
  public String getId()
  {
    return zzbsx;
  }
  
  public String getIdToken()
  {
    return zzeaw;
  }
  
  public Uri getPhotoUrl()
  {
    return zzeby;
  }
  
  public String getServerAuthCode()
  {
    return zzebz;
  }
  
  public int hashCode()
  {
    return toJsonObject().toString().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.append(paramParcel, 2, getId(), false);
    zzbcn.append(paramParcel, 3, getIdToken(), false);
    zzbcn.append(paramParcel, 4, getEmail(), false);
    zzbcn.append(paramParcel, 5, getDisplayName(), false);
    zzbcn.addMenuItem(paramParcel, 6, getPhotoUrl(), paramInt, false);
    zzbcn.append(paramParcel, 7, getServerAuthCode(), false);
    zzbcn.writeHeader(paramParcel, 8, zzeca);
    zzbcn.append(paramParcel, 9, zzecb, false);
    zzbcn.save(paramParcel, 10, zzdxx, false);
    zzbcn.append(paramParcel, 11, getGivenName(), false);
    zzbcn.append(paramParcel, 12, getFamilyName(), false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final boolean zzaad()
  {
    return zzebv.currentTimeMillis() / 1000L >= zzeca - 300L;
  }
  
  public final String zzaae()
  {
    return zzecb;
  }
  
  public final String zzaaf()
  {
    JSONObject localJSONObject = toJsonObject();
    localJSONObject.remove("serverAuthCode");
    return localJSONObject.toString();
  }
}
