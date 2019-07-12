package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;

public class GraphRequestAsyncTask
  extends AsyncTask<Void, Void, List<GraphResponse>>
{
  public static final String message = "com.facebook.GraphRequestAsyncTask";
  public final HttpURLConnection connection;
  public Exception exception;
  public final GraphRequestBatch requests;
  
  public GraphRequestAsyncTask(GraphRequestBatch paramGraphRequestBatch)
  {
    this(null, paramGraphRequestBatch);
  }
  
  public GraphRequestAsyncTask(HttpURLConnection paramHttpURLConnection, GraphRequestBatch paramGraphRequestBatch)
  {
    requests = paramGraphRequestBatch;
    connection = paramHttpURLConnection;
  }
  
  public GraphRequestAsyncTask(HttpURLConnection paramHttpURLConnection, Collection paramCollection)
  {
    requests = paramCollection;
    connection = paramHttpURLConnection;
  }
  
  public GraphRequestAsyncTask(HttpURLConnection paramHttpURLConnection, GraphRequest... paramVarArgs)
  {
    requests = paramVarArgs;
    connection = paramHttpURLConnection;
  }
  
  public GraphRequestAsyncTask(Collection paramCollection)
  {
    this(null, new GraphRequestBatch(paramCollection));
  }
  
  public GraphRequestAsyncTask(GraphRequest... paramVarArgs)
  {
    this(null, new GraphRequestBatch(paramVarArgs));
  }
  
  public List doInBackground(Void... paramVarArgs)
  {
    if (connection == null) {
      paramVarArgs = requests;
    }
    try
    {
      paramVarArgs = paramVarArgs.executeAndWait();
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      GraphRequestBatch localGraphRequestBatch;
      exception = paramVarArgs;
    }
    paramVarArgs = connection;
    localGraphRequestBatch = requests;
    paramVarArgs = GraphRequest.executeConnectionAndWait(paramVarArgs, localGraphRequestBatch);
    return paramVarArgs;
    return null;
  }
  
  public final Exception getException()
  {
    return exception;
  }
  
  public final GraphRequestBatch getRequests()
  {
    return requests;
  }
  
  public void onPostExecute(List paramList)
  {
    super.onPostExecute(paramList);
    paramList = exception;
    if (paramList != null)
    {
      String str = message;
      String.format("onPostExecute: exception encountered during request: %s", new Object[] { paramList.getMessage() });
    }
  }
  
  public void onPreExecute()
  {
    super.onPreExecute();
    Object localObject;
    if (FacebookSdk.isDebugEnabled)
    {
      localObject = message;
      String.format("execute async task: %s", new Object[] { this });
    }
    if (requests.getCallbackHandler() == null)
    {
      if ((Thread.currentThread() instanceof HandlerThread)) {
        localObject = new Handler();
      } else {
        localObject = new Handler(Looper.getMainLooper());
      }
      requests.setCallbackHandler((Handler)localObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("{RequestAsyncTask: ", " connection: ");
    localStringBuilder.append(connection);
    localStringBuilder.append(", requests: ");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, requests, "}");
  }
}
