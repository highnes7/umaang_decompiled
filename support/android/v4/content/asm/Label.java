package support.android.v4.content.asm;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

public abstract class Label
{
  public Label() {}
  
  public final void callbackFailAsync(int paramInt, Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new b(this, paramInt));
  }
  
  public final void callbackSuccessAsync(Typeface paramTypeface, Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new InitiationListener.1(this, paramTypeface));
  }
  
  public abstract void onFontRetrievalFailed(int paramInt);
  
  public abstract void onFontRetrieved(Typeface paramTypeface);
}
