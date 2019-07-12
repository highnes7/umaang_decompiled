package support.android.classic.net.asm;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

public final class MethodWriter
  extends InputConnectionWrapper
{
  public MethodWriter(InputConnection paramInputConnection, boolean paramBoolean, a paramA)
  {
    super(paramInputConnection, paramBoolean);
  }
  
  public boolean commitContent(InputContentInfo paramInputContentInfo, int paramInt, Bundle paramBundle)
  {
    if (j.a(Frame.a(paramInputContentInfo), paramInt, paramBundle)) {
      return true;
    }
    return super.commitContent(paramInputContentInfo, paramInt, paramBundle);
  }
}
