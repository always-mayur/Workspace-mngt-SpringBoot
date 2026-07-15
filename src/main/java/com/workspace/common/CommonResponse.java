package com.workspace.common;

public class CommonResponse 
{
	
  private String status;
  private Object responseObject;
  private String errorMessage;
  
  public CommonResponse()
  {
	  
  }
  
  public static CommonResponse success(Object data)
  {
      CommonResponse response = new CommonResponse();

      response.setStatus("success");

      response.setResponseObject(data);
      
      response.setErrorMessage(null);

      return response;
  }
  
  public static CommonResponse failure(String errorMessage)
  {
	 CommonResponse response = new CommonResponse();
	 response.setStatus("failure");
	 response.setResponseObject(null);
	 response.setErrorMessage(errorMessage);
	 
	 return response;
  }
  
   public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
//    @Override
//    public String toString()
//    {
//        return "CommonResponse [status=" + status
//                + ", responseObject=" + responseObject
//                + ", errorMessage=" + errorMessage + "]";
//    }
}
