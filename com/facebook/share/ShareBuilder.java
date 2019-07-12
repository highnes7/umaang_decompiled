package com.facebook.share;

public abstract interface ShareBuilder<P, E extends ShareBuilder>
{
  public abstract Object build();
}
