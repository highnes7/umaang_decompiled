package support.android.v4.content.res;

import android.content.pm.PermissionInfo;
import android.os.Build.VERSION;

public final class EAXBlockCipher
{
  public EAXBlockCipher() {}
  
  public static int a(PermissionInfo paramPermissionInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPermissionInfo.getProtection();
    }
    return protectionLevel & 0xF;
  }
  
  public static int process(PermissionInfo paramPermissionInfo)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramPermissionInfo.getProtectionFlags();
    }
    return protectionLevel & 0xFFFFFFF0;
  }
}
