package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;

public class LoginResult
{
  public final AccessToken accessToken;
  public final Set<String> recentlyDeniedPermissions;
  public final Set<String> recentlyGrantedPermissions;
  
  public LoginResult(AccessToken paramAccessToken, Set paramSet1, Set paramSet2)
  {
    accessToken = paramAccessToken;
    recentlyGrantedPermissions = paramSet1;
    recentlyDeniedPermissions = paramSet2;
  }
  
  public AccessToken getAccessToken()
  {
    return accessToken;
  }
  
  public Set getRecentlyDeniedPermissions()
  {
    return recentlyDeniedPermissions;
  }
  
  public Set getRecentlyGrantedPermissions()
  {
    return recentlyGrantedPermissions;
  }
}
