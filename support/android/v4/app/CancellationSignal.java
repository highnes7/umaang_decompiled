package support.android.v4.app;

import android.os.Build.VERSION;

public final class CancellationSignal
{
  public boolean mCancelInProgress;
  public Object mCancellationSignalObj;
  public boolean mIsCanceled;
  public OnCancelListener mOnCancelListener;
  
  public CancellationSignal() {}
  
  private void waitForCancelFinishedLocked()
  {
    while (mCancelInProgress) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	support/android/v4/app/CancellationSignal:mIsCanceled	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 31	support/android/v4/app/CancellationSignal:mIsCanceled	Z
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 23	support/android/v4/app/CancellationSignal:mCancelInProgress	Z
    //   22: aload_0
    //   23: getfield 33	support/android/v4/app/CancellationSignal:mOnCancelListener	Lsupport/android/v4/app/CancellationSignal$OnCancelListener;
    //   26: astore_2
    //   27: aload_0
    //   28: getfield 35	support/android/v4/app/CancellationSignal:mCancellationSignalObj	Ljava/lang/Object;
    //   31: astore_3
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: ifnull +16 -> 51
    //   38: aload_2
    //   39: invokeinterface 38 1 0
    //   44: goto +7 -> 51
    //   47: astore_2
    //   48: goto +21 -> 69
    //   51: aload_3
    //   52: ifnull +37 -> 89
    //   55: getstatic 44	android/os/Build$VERSION:SDK_INT	I
    //   58: istore_1
    //   59: aload_3
    //   60: checkcast 46	android/os/CancellationSignal
    //   63: invokevirtual 48	android/os/CancellationSignal:cancel	()V
    //   66: goto +23 -> 89
    //   69: aload_0
    //   70: monitorenter
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 23	support/android/v4/app/CancellationSignal:mCancelInProgress	Z
    //   76: aload_0
    //   77: invokevirtual 51	java/lang/Object:notifyAll	()V
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_2
    //   83: athrow
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    //   89: aload_0
    //   90: monitorenter
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 23	support/android/v4/app/CancellationSignal:mCancelInProgress	Z
    //   96: aload_0
    //   97: invokevirtual 51	java/lang/Object:notifyAll	()V
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: astore_2
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    //   108: astore_2
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	CancellationSignal
    //   58	1	1	i	int
    //   26	13	2	localOnCancelListener	OnCancelListener
    //   47	36	2	localThrowable1	Throwable
    //   84	4	2	localThrowable2	Throwable
    //   103	4	2	localThrowable3	Throwable
    //   108	4	2	localThrowable4	Throwable
    //   31	29	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	44	47	java/lang/Throwable
    //   55	66	47	java/lang/Throwable
    //   71	82	84	java/lang/Throwable
    //   85	87	84	java/lang/Throwable
    //   91	102	103	java/lang/Throwable
    //   104	106	103	java/lang/Throwable
    //   2	11	108	java/lang/Throwable
    //   12	34	108	java/lang/Throwable
    //   109	111	108	java/lang/Throwable
  }
  
  public Object getCancellationSignalObject()
  {
    int i = Build.VERSION.SDK_INT;
    try
    {
      if (mCancellationSignalObj == null)
      {
        mCancellationSignalObj = new android.os.CancellationSignal();
        if (mIsCanceled) {
          ((android.os.CancellationSignal)mCancellationSignalObj).cancel();
        }
      }
      Object localObject = mCancellationSignalObj;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean isCanceled()
  {
    try
    {
      boolean bool = mIsCanceled;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void setOnCancelListener(OnCancelListener paramOnCancelListener)
  {
    try
    {
      waitForCancelFinishedLocked();
      if (mOnCancelListener == paramOnCancelListener) {
        return;
      }
      mOnCancelListener = paramOnCancelListener;
      if ((mIsCanceled) && (paramOnCancelListener != null))
      {
        paramOnCancelListener.onCancel();
        return;
      }
      return;
    }
    catch (Throwable paramOnCancelListener)
    {
      throw paramOnCancelListener;
    }
  }
  
  public void throwIfCanceled()
  {
    if (!isCanceled()) {
      return;
    }
    throw new OperationCanceledException(null);
  }
  
  public abstract interface OnCancelListener
  {
    public abstract void onCancel();
  }
}
