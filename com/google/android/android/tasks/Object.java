package com.google.android.android.tasks;

public abstract interface Object<TResult>
{
  public abstract void cancel();
  
  public abstract void onComplete(Task paramTask);
}
