package support.android.v4.hardware.fingerprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.Handler;

public final class ByteVector
{
  public final Context a;
  
  public ByteVector(Context paramContext)
  {
    a = paramContext;
  }
  
  public static FingerprintManager from(Context paramContext)
  {
    if (paramContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    return null;
  }
  
  public static ByteVector putLong(Context paramContext)
  {
    return new ByteVector(paramContext);
  }
  
  public static FingerprintManagerCompat.CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {
      return null;
    }
    if (paramCryptoObject.getCipher() != null) {
      return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getCipher());
    }
    if (paramCryptoObject.getSignature() != null) {
      return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getSignature());
    }
    if (paramCryptoObject.getMac() != null) {
      return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getMac());
    }
    return null;
  }
  
  public static FingerprintManager.AuthenticationCallback wrapCallback(FingerprintManagerCompatApi23.AuthenticationCallback paramAuthenticationCallback)
  {
    return new FingerprintManagerCompatApi23.1(paramAuthenticationCallback);
  }
  
  public static FingerprintManager.CryptoObject wrapCryptoObject(FingerprintManagerCompat.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {
      return null;
    }
    if (paramCryptoObject.getCipher() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
    }
    if (paramCryptoObject.getSignature() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
    }
    if (paramCryptoObject.getMac() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
    }
    return null;
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      FingerprintManager localFingerprintManager = from(a);
      if ((localFingerprintManager != null) && (localFingerprintManager.hasEnrolledFingerprints())) {
        return true;
      }
    }
    return false;
  }
  
  public void authenticate(FingerprintManagerCompat.CryptoObject paramCryptoObject, int paramInt, support.android.v4.app.CancellationSignal paramCancellationSignal, FingerprintManagerCompatApi23.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      FingerprintManager localFingerprintManager = from(a);
      if (localFingerprintManager != null)
      {
        if (paramCancellationSignal != null) {
          paramCancellationSignal = (android.os.CancellationSignal)paramCancellationSignal.getCancellationSignalObject();
        } else {
          paramCancellationSignal = null;
        }
        localFingerprintManager.authenticate(wrapCryptoObject(paramCryptoObject), paramCancellationSignal, paramInt, new FingerprintManagerCompatApi23.1(paramAuthenticationCallback), paramHandler);
      }
    }
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      FingerprintManager localFingerprintManager = from(a);
      if ((localFingerprintManager != null) && (localFingerprintManager.isHardwareDetected())) {
        return true;
      }
    }
    return false;
  }
}
