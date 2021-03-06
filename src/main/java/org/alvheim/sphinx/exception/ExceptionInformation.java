package org.alvheim.sphinx.exception;

public class ExceptionInformation {
  public final String url;
  public final String exceptionMessage;

  public ExceptionInformation(String url, Exception exception) {
    this.url = url;
    this.exceptionMessage = exception.getLocalizedMessage();
  }
}
