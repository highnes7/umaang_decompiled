package com.google.android.android.auth.dashclock.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.android.auth.dashclock.signin.internal.Artist;
import com.google.android.android.auth.dashclock.signin.internal.IonBitmapRequestBuilder;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.Api.ApiOptions.Optional;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.auth.api.signin.internal.zzn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
  extends zzbck
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.GoogleSignInOptions> CREATOR = new DownloadProgressInfo.1();
  public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  public static com.google.android.android.common.package_9.Scope SCOPE_GAMES;
  public static Comparator<com.google.android.gms.common.api.Scope> zzecc = new NamespaceStack.1();
  public static final com.google.android.android.common.package_9.Scope zzecd = new com.google.android.android.common.package_9.Scope(1, "profile");
  public static final com.google.android.android.common.package_9.Scope zzece = new com.google.android.android.common.package_9.Scope(1, "email");
  public static final com.google.android.android.common.package_9.Scope zzecf = new com.google.android.android.common.package_9.Scope(1, "openid");
  public int versionCode;
  public Account zzduz;
  public boolean zzeap;
  public String zzeaq;
  public final ArrayList<com.google.android.gms.common.api.Scope> zzecg;
  public final boolean zzech;
  public final boolean zzeci;
  public String zzecj;
  public ArrayList<zzn> zzeck;
  public Map<Integer, zzn> zzecl;
  
  static
  {
    SCOPE_GAMES = new com.google.android.android.common.package_9.Scope(1, "https://www.googleapis.com/auth/games");
    DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES, new com.google.android.android.common.package_9.Scope[0]).build();
  }
  
  public GoogleSignInOptions(int paramInt, ArrayList paramArrayList1, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList paramArrayList2)
  {
    this(paramInt, paramArrayList1, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, parse(paramArrayList2));
  }
  
  public GoogleSignInOptions(int paramInt, ArrayList paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map paramMap)
  {
    versionCode = paramInt;
    zzecg = paramArrayList;
    zzduz = paramAccount;
    zzeap = paramBoolean1;
    zzech = paramBoolean2;
    zzeci = paramBoolean3;
    zzeaq = paramString1;
    zzecj = paramString2;
    zzeck = new ArrayList(paramMap.values());
    zzecl = paramMap;
  }
  
  public static Map parse(List paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Artist localArtist = (Artist)paramList.next();
      localHashMap.put(Integer.valueOf(localArtist.getType()), localArtist);
    }
    return localHashMap;
  }
  
  private final JSONObject toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    RuntimeException localRuntimeException;
    try
    {
      Object localObject1 = new JSONArray();
      ArrayList localArrayList = zzecg;
      Object localObject2 = zzecc;
      Collections.sort(localArrayList, (Comparator)localObject2);
      localArrayList = zzecg;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        localObject2 = localArrayList.get(i);
        i += 1;
        localObject2 = (com.google.android.android.common.package_9.Scope)localObject2;
        ((JSONArray)localObject1).put(((com.google.android.android.common.package_9.Scope)localObject2).zzaft());
      }
      localJSONObject.put("scopes", localObject1);
      if (zzduz != null)
      {
        localObject1 = zzduz.name;
        localJSONObject.put("accountName", localObject1);
      }
      boolean bool = zzeap;
      localJSONObject.get("idTokenRequested", bool);
      bool = zzeci;
      localJSONObject.get("forceCodeForRefreshToken", bool);
      bool = zzech;
      localJSONObject.get("serverAuthRequested", bool);
      localObject1 = zzeaq;
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        localObject1 = zzeaq;
        localJSONObject.put("serverClientId", localObject1);
      }
      localObject1 = zzecj;
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        localObject1 = zzecj;
        localJSONObject.put("hostedDomain", localObject1);
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      localRuntimeException = new RuntimeException(localJSONException);
      throw localRuntimeException;
    }
    return localRuntimeException;
  }
  
  public static GoogleSignInOptions zzen(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new com.google.android.android.common.package_9.Scope(1, paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {
      paramString = new Account(paramString, "com.google");
    } else {
      paramString = null;
    }
    return new GoogleSignInOptions(3, new ArrayList(localHashSet), paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null), new HashMap());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      paramObject = (GoogleSignInOptions)paramObject;
      Object localObject1 = zzeck;
      int i = ((ArrayList)localObject1).size();
      if (i <= 0)
      {
        localObject1 = zzeck;
        i = ((ArrayList)localObject1).size();
        if (i > 0) {
          return false;
        }
        localObject1 = zzecg;
        i = ((ArrayList)localObject1).size();
        int j = paramObject.zzaag().size();
        if (i == j)
        {
          localObject1 = zzecg;
          boolean bool = ((ArrayList)localObject1).containsAll(paramObject.zzaag());
          if (!bool) {
            return false;
          }
          Object localObject2;
          if (zzduz == null)
          {
            if (zzduz != null) {
              break label240;
            }
          }
          else
          {
            localObject1 = zzduz;
            localObject2 = zzduz;
            bool = ((Account)localObject1).equals(localObject2);
            if (!bool) {
              break label240;
            }
          }
          localObject1 = zzeaq;
          bool = TextUtils.isEmpty((CharSequence)localObject1);
          if (bool)
          {
            localObject1 = zzeaq;
            bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (!bool) {
              break label240;
            }
          }
          else
          {
            localObject1 = zzeaq;
            localObject2 = zzeaq;
            bool = ((String)localObject1).equals(localObject2);
            if (!bool) {
              break label240;
            }
          }
          if ((zzeci == zzeci) && (zzeap == zzeap) && (zzech == zzech)) {
            return true;
          }
        }
      }
      else
      {
        return false;
      }
    }
    catch (ClassCastException paramObject) {}
    label240:
    return false;
  }
  
  public final Account getAccount()
  {
    return zzduz;
  }
  
  public com.google.android.android.common.package_9.Scope[] getScopeArray()
  {
    ArrayList localArrayList = zzecg;
    return (com.google.android.android.common.package_9.Scope[])localArrayList.toArray(new com.google.android.android.common.package_9.Scope[localArrayList.size()]);
  }
  
  public final String getServerClientId()
  {
    return zzeaq;
  }
  
  public int hashCode()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = zzecg;
    int j = localArrayList2.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList2.get(i);
      i += 1;
      localArrayList1.add(((com.google.android.android.common.package_9.Scope)localObject).zzaft());
    }
    Collections.sort(localArrayList1);
    return new IonBitmapRequestBuilder().transform(localArrayList1).transform(zzduz).transform(zzeaq).zzaq(zzeci).zzaq(zzeap).zzaq(zzech).zzaao();
  }
  
  public final boolean isIdTokenRequested()
  {
    return zzeap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.save(paramParcel, 2, zzaag(), false);
    zzbcn.addMenuItem(paramParcel, 3, zzduz, paramInt, false);
    zzbcn.onAction(paramParcel, 4, zzeap);
    zzbcn.onAction(paramParcel, 5, zzech);
    zzbcn.onAction(paramParcel, 6, zzeci);
    zzbcn.append(paramParcel, 7, zzeaq, false);
    zzbcn.append(paramParcel, 8, zzecj, false);
    zzbcn.save(paramParcel, 9, zzeck, false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public final ArrayList zzaag()
  {
    return new ArrayList(zzecg);
  }
  
  public final boolean zzaah()
  {
    return zzech;
  }
  
  public final String zzaai()
  {
    return toJsonObject().toString();
  }
  
  public final class Builder
  {
    public Account zzduz;
    public boolean zzeap;
    public String zzeaq;
    public boolean zzech;
    public boolean zzeci;
    public String zzecj;
    public Set<com.google.android.gms.common.api.Scope> zzecm = new HashSet();
    public Map<Integer, zzn> zzecn = new HashMap();
    
    public Builder() {}
    
    public Builder()
    {
      zzbp.append(this$1);
      zzecm = new HashSet(GoogleSignInOptions.getLabels(this$1));
      zzech = GoogleSignInOptions.s(this$1);
      zzeci = GoogleSignInOptions.newFromParcel(this$1);
      zzeap = GoogleSignInOptions.getArticleUrl(this$1);
      zzeaq = GoogleSignInOptions.getSoundPath(this$1);
      zzduz = GoogleSignInOptions.getTransfer(this$1);
      zzecj = GoogleSignInOptions.getDataString(this$1);
      zzecn = GoogleSignInOptions.parse(GoogleSignInOptions.thumbnailUrl(this$1));
    }
    
    private final String zzeo(String paramString)
    {
      zzbp.zzgg(paramString);
      String str = zzeaq;
      boolean bool;
      if ((str != null) && (!str.equals(paramString))) {
        bool = false;
      } else {
        bool = true;
      }
      zzbp.get(bool, "two different server client ids provided");
      return paramString;
    }
    
    public final Builder addExtension(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
    {
      Map localMap = zzecn;
      Integer localInteger = Integer.valueOf(1);
      if (!localMap.containsKey(localInteger))
      {
        zzecn.put(localInteger, new Artist(paramGoogleSignInOptionsExtension));
        return this;
      }
      throw new IllegalStateException("Only one extension per type may be added");
    }
    
    public final GoogleSignInOptions build()
    {
      if ((zzeap) && ((zzduz == null) || (!zzecm.isEmpty()))) {
        requestId();
      }
      return new GoogleSignInOptions(3, new ArrayList(zzecm), zzduz, zzeap, zzech, zzeci, zzeaq, zzecj, zzecn, null);
    }
    
    public final Builder requestEmail()
    {
      zzecm.add(GoogleSignInOptions.zzece);
      return this;
    }
    
    public final Builder requestId()
    {
      zzecm.add(GoogleSignInOptions.zzecf);
      return this;
    }
    
    public final Builder requestIdToken(String paramString)
    {
      zzeap = true;
      zzeo(paramString);
      zzeaq = paramString;
      return this;
    }
    
    public final Builder requestProfile()
    {
      zzecm.add(GoogleSignInOptions.zzecd);
      return this;
    }
    
    public final Builder requestScopes(com.google.android.android.common.package_9.Scope paramScope, com.google.android.android.common.package_9.Scope... paramVarArgs)
    {
      zzecm.add(paramScope);
      zzecm.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public final Builder requestServerAuthCode(String paramString)
    {
      return requestServerAuthCode(paramString, false);
    }
    
    public final Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      zzech = true;
      zzeo(paramString);
      zzeaq = paramString;
      zzeci = paramBoolean;
      return this;
    }
    
    public final Builder setAccountName(String paramString)
    {
      zzbp.zzgg(paramString);
      zzduz = new Account(paramString, "com.google");
      return this;
    }
    
    public final Builder setHostedDomain(String paramString)
    {
      zzbp.zzgg(paramString);
      zzecj = paramString;
      return this;
    }
  }
}
