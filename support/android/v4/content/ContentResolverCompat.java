package support.android.v4.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;

public final class ContentResolverCompat
{
  public ContentResolverCompat() {}
  
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, support.android.v4.app.CancellationSignal paramCancellationSignal)
  {
    int i = Build.VERSION.SDK_INT;
    if (paramCancellationSignal != null) {
      try
      {
        paramCancellationSignal = paramCancellationSignal.getCancellationSignalObject();
      }
      catch (Exception paramContentResolver)
      {
        break label50;
      }
    } else {
      paramCancellationSignal = null;
    }
    paramCancellationSignal = (android.os.CancellationSignal)paramCancellationSignal;
    paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramCancellationSignal);
    return paramContentResolver;
    label50:
    if ((paramContentResolver instanceof android.os.OperationCanceledException)) {
      throw new support.android.v4.app.OperationCanceledException(null);
    }
    throw paramContentResolver;
  }
}
