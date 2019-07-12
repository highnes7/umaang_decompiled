package support.android.classic.net.asm;

import android.content.ClipDescription;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;

public final class d
{
  public static final String A = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
  public static final String F = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
  public static final int N = 1;
  public static final String e = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
  public static final String g = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
  public static final String m = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
  public static final String t = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
  public static final String w = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
  
  public d() {}
  
  public static InputConnection a(InputConnection paramInputConnection, EditorInfo paramEditorInfo, a paramA)
  {
    if (paramInputConnection != null)
    {
      if (paramEditorInfo != null)
      {
        if (paramA != null)
        {
          if (Build.VERSION.SDK_INT >= 25) {
            return new MethodWriter(paramInputConnection, false, paramA);
          }
          if (ClassWriter.get(paramEditorInfo).length == 0) {
            return paramInputConnection;
          }
          return new AnnotationWriter(paramInputConnection, false, paramA);
        }
        throw new IllegalArgumentException("onCommitContentListener must be non-null");
      }
      throw new IllegalArgumentException("editorInfo must be non-null");
    }
    throw new IllegalArgumentException("inputConnection must be non-null");
  }
  
  public static boolean a(InputConnection paramInputConnection, EditorInfo paramEditorInfo, Frame paramFrame, int paramInt, Bundle paramBundle)
  {
    ClipDescription localClipDescription = paramFrame.write();
    paramEditorInfo = ClassWriter.get(paramEditorInfo);
    int j = paramEditorInfo.length;
    int i = 0;
    while (i < j)
    {
      if (localClipDescription.hasMimeType(paramEditorInfo[i]))
      {
        i = 1;
        break label55;
      }
      i += 1;
    }
    i = 0;
    label55:
    if (i == 0) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 25) {
      return paramInputConnection.commitContent((InputContentInfo)paramFrame.get(), paramInt, paramBundle);
    }
    paramEditorInfo = new Bundle();
    paramEditorInfo.putParcelable("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI", paramFrame.peek());
    paramEditorInfo.putParcelable("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION", paramFrame.write());
    paramEditorInfo.putParcelable("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI", paramFrame.add());
    paramEditorInfo.putInt("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS", paramInt);
    paramEditorInfo.putParcelable("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS", paramBundle);
    return paramInputConnection.performPrivateCommand("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", paramEditorInfo);
  }
  
  public static boolean a(String paramString, Bundle paramBundle, a paramA)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:806)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
}
