package f.fasterxml.jackson.core;

public abstract interface TreeNode
{
  public abstract JsonToken asToken();
  
  public abstract Daemon numberType();
  
  public abstract JsonParser traverse();
}
