package com.myproduct.util.exception;

public class NotAuthenticationException extends RuntimeException{
  public NotAuthenticationException(String message){
    super(message);
  }
}
