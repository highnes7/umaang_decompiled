package com.google.android.android.auth.dashclock.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import b.b.a.G;
import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.auth.api.credentials.IdToken;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential
  extends zzbck
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.Credential> CREATOR = new AddressAndLabel.1();
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
  @G
  public final String mName;
  public final String zzbsx;
  @G
  public final String zzdzr;
  @G
  public final Uri zzeaa;
  public final List<IdToken> zzeab;
  @G
  public final String zzeac;
  @G
  public final String zzead;
  @G
  public final String zzeae;
  @G
  public final String zzeaf;
  @G
  public final String zzeag;
  
  public Credential(String paramString1, String paramString2, Uri paramUri, List paramList, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    zzbp.get(paramString1, "credential identifier cannot be null");
    String str = ((String)paramString1).trim();
    zzbp.format(str, "credential identifier cannot be empty");
    if ((paramString3 != null) && (TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("Password must not be empty if set");
    }
    if (paramString4 != null)
    {
      boolean bool3 = TextUtils.isEmpty(paramString4);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!bool3)
      {
        paramString1 = Uri.parse(paramString4);
        bool1 = bool2;
        if (paramString1.isAbsolute())
        {
          bool1 = bool2;
          if (paramString1.isHierarchical())
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(paramString1.getScheme())) {
              if (TextUtils.isEmpty(paramString1.getAuthority()))
              {
                bool1 = bool2;
              }
              else if (!"http".equalsIgnoreCase(paramString1.getScheme()))
              {
                bool1 = bool2;
                if (!"https".equalsIgnoreCase(paramString1.getScheme())) {}
              }
              else
              {
                bool1 = true;
              }
            }
          }
        }
      }
      if (!Boolean.valueOf(bool1).booleanValue()) {
        throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
      }
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2.trim())) {
        paramString1 = null;
      }
    }
    mName = paramString1;
    zzeaa = paramUri;
    if (paramList == null) {
      paramString1 = Collections.emptyList();
    } else {
      paramString1 = Collections.unmodifiableList(paramList);
    }
    zzeab = paramString1;
    zzbsx = str;
    zzeac = paramString3;
    zzdzr = paramString4;
    zzead = paramString5;
    zzeae = paramString6;
    zzeaf = paramString7;
    zzeag = paramString8;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Credential)) {
      return false;
    }
    paramObject = (Credential)paramObject;
    return (TextUtils.equals(zzbsx, zzbsx)) && (TextUtils.equals(mName, mName)) && (zzbf.equal(zzeaa, zzeaa)) && (TextUtils.equals(zzeac, zzeac)) && (TextUtils.equals(zzdzr, zzdzr)) && (TextUtils.equals(zzead, zzead));
  }
  
  public String getAccountType()
  {
    return zzdzr;
  }
  
  public String getFamilyName()
  {
    return zzeag;
  }
  
  public String getGeneratedPassword()
  {
    return zzead;
  }
  
  public String getGivenName()
  {
    return zzeaf;
  }
  
  public String getId()
  {
    return zzbsx;
  }
  
  public List getIdTokens()
  {
    return zzeab;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public String getPassword()
  {
    return zzeac;
  }
  
  public Uri getProfilePictureUri()
  {
    return zzeaa;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzbsx, mName, zzeaa, zzeac, zzdzr, zzead });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 1, getId(), false);
    zzbcn.append(paramParcel, 2, getName(), false);
    zzbcn.addMenuItem(paramParcel, 3, getProfilePictureUri(), paramInt, false);
    zzbcn.save(paramParcel, 4, getIdTokens(), false);
    zzbcn.append(paramParcel, 5, getPassword(), false);
    zzbcn.append(paramParcel, 6, getAccountType(), false);
    zzbcn.append(paramParcel, 7, getGeneratedPassword(), false);
    zzbcn.append(paramParcel, 8, zzeae, false);
    zzbcn.append(paramParcel, 9, getGivenName(), false);
    zzbcn.append(paramParcel, 10, getFamilyName(), false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public class Builder
  {
    public String mName;
    public String zzdzr;
    public Uri zzeaa;
    public List<IdToken> zzeab;
    public String zzeac;
    public String zzead;
    public String zzeae;
    public String zzeaf;
    public String zzeag;
    
    public Builder()
    {
      mName = Credential.getName(Credential.this);
      zzeaa = Credential.setRefreshToken(Credential.this);
      zzeab = Credential.load(Credential.this);
      zzeac = Credential.getPassword(Credential.this);
      zzdzr = Credential.getAccessToken(Credential.this);
      zzead = Credential.getUsername(Credential.this);
      zzeae = Credential.getMethod(Credential.this);
      zzeaf = Credential.getRefreshToken(Credential.this);
      zzeag = Credential.getTransport(Credential.this);
    }
    
    public Builder() {}
    
    public Credential build()
    {
      return new Credential(Credential.this, mName, zzeaa, zzeab, zzeac, zzdzr, zzead, zzeae, zzeaf, zzeag);
    }
    
    public Builder setAccountType(String paramString)
    {
      zzdzr = paramString;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      mName = paramString;
      return this;
    }
    
    public Builder setPassword(String paramString)
    {
      zzeac = paramString;
      return this;
    }
    
    public Builder setProfilePictureUri(Uri paramUri)
    {
      zzeaa = paramUri;
      return this;
    }
  }
}
