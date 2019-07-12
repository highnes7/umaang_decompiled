package com.google.android.android.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class ExecutorDelivery
  implements ResponseDelivery
{
  public final Executor mResponsePoster;
  
  public ExecutorDelivery(Handler paramHandler)
  {
    mResponsePoster = new ExecutorDelivery.1(this, paramHandler);
  }
  
  public final void postError(Request paramRequest, zzaa paramZzaa)
  {
    paramRequest.addMarker("post-error");
    paramZzaa = new Response(paramZzaa);
    mResponsePoster.execute(new ExecutorDelivery.ResponseDeliveryRunnable(this, paramRequest, paramZzaa, null));
  }
  
  public final void postResponse(Request paramRequest, Response paramResponse)
  {
    postResponse(paramRequest, paramResponse, null);
  }
  
  public final void postResponse(Request paramRequest, Response paramResponse, Runnable paramRunnable)
  {
    paramRequest.addMarker();
    paramRequest.addMarker("post-response");
    mResponsePoster.execute(new ExecutorDelivery.ResponseDeliveryRunnable(this, paramRequest, paramResponse, paramRunnable));
  }
}
