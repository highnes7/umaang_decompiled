package org.reactivestreams;

public abstract interface Publisher<T>
{
  public abstract void subscribe(Subscriber paramSubscriber);
}
