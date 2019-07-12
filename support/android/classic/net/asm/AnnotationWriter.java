package support.android.classic.net.asm;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

public final class AnnotationWriter
  extends InputConnectionWrapper
{
  public AnnotationWriter(InputConnection paramInputConnection, boolean paramBoolean, a paramA)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean performPrivateCommand(String paramString, Bundle paramBundle)
  {
    if (d.a(paramString, paramBundle, c)) {
      return true;
    }
    return super.performPrivateCommand(paramString, paramBundle);
  }
}
