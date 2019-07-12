package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphRequestBatch
  extends AbstractList<GraphRequest>
{
  public static AtomicInteger idGenerator = new AtomicInteger();
  public String batchApplicationId;
  public Handler callbackHandler;
  public List<Callback> callbacks = new ArrayList();
  public final String identifier = Integer.valueOf(idGenerator.incrementAndGet()).toString();
  public List<GraphRequest> requests = new ArrayList();
  public int timeoutInMilliseconds = 0;
  
  public GraphRequestBatch()
  {
    requests = new ArrayList();
  }
  
  public GraphRequestBatch(GraphRequestBatch paramGraphRequestBatch)
  {
    requests = new ArrayList(paramGraphRequestBatch);
    callbackHandler = callbackHandler;
    timeoutInMilliseconds = timeoutInMilliseconds;
    callbacks = new ArrayList(callbacks);
  }
  
  public GraphRequestBatch(Collection paramCollection)
  {
    requests = new ArrayList(paramCollection);
  }
  
  public GraphRequestBatch(GraphRequest... paramVarArgs)
  {
    requests = Arrays.asList(paramVarArgs);
  }
  
  public final boolean add(GraphRequest paramGraphRequest)
  {
    return requests.add(paramGraphRequest);
  }
  
  public void addCallback(Callback paramCallback)
  {
    if (!callbacks.contains(paramCallback)) {
      callbacks.add(paramCallback);
    }
  }
  
  public final void addRequest(int paramInt, GraphRequest paramGraphRequest)
  {
    requests.add(paramInt, paramGraphRequest);
  }
  
  public final void clear()
  {
    requests.clear();
  }
  
  public final GraphRequest complete(int paramInt, GraphRequest paramGraphRequest)
  {
    return (GraphRequest)requests.set(paramInt, paramGraphRequest);
  }
  
  public final List executeAndWait()
  {
    return executeAndWaitImpl();
  }
  
  public List executeAndWaitImpl()
  {
    return GraphRequest.executeBatchAndWait(this);
  }
  
  public final GraphRequestAsyncTask executeAsync()
  {
    return executeAsyncImpl();
  }
  
  public GraphRequestAsyncTask executeAsyncImpl()
  {
    return GraphRequest.executeBatchAsync(this);
  }
  
  public final GraphRequest get(int paramInt)
  {
    return (GraphRequest)requests.get(paramInt);
  }
  
  public final String getBatchApplicationId()
  {
    return batchApplicationId;
  }
  
  public final Handler getCallbackHandler()
  {
    return callbackHandler;
  }
  
  public final List getCallbacks()
  {
    return callbacks;
  }
  
  public final String getId()
  {
    return identifier;
  }
  
  public final List getRequests()
  {
    return requests;
  }
  
  public int getTimeout()
  {
    return timeoutInMilliseconds;
  }
  
  public final GraphRequest remove(int paramInt)
  {
    return (GraphRequest)requests.remove(paramInt);
  }
  
  public void removeCallback(Callback paramCallback)
  {
    callbacks.remove(paramCallback);
  }
  
  public final void setBatchApplicationId(String paramString)
  {
    batchApplicationId = paramString;
  }
  
  public final void setCallbackHandler(Handler paramHandler)
  {
    callbackHandler = paramHandler;
  }
  
  public void setTimeout(int paramInt)
  {
    if (paramInt >= 0)
    {
      timeoutInMilliseconds = paramInt;
      return;
    }
    throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
  }
  
  public final int size()
  {
    return requests.size();
  }
  
  public static abstract interface Callback
  {
    public abstract void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch);
  }
  
  public static abstract interface OnProgressCallback
    extends GraphRequestBatch.Callback
  {
    public abstract void onBatchProgress(GraphRequestBatch paramGraphRequestBatch, long paramLong1, long paramLong2);
  }
}
