package bean;

public class FormsSubmitted {
	private String number;
    private String name;
    private String account;
    private String rejected;
    private String process;
    private String complete;
    private String submitted;


    public FormsSubmitted(String number, String name, String rejected, String process, String complete, String account, String submitted) {
        this.name = name;
        this.account = account;
        this.rejected = rejected;
        this.process = process;
        this.complete = complete;
        this.number = number;
        this.submitted = submitted;
    }


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRejected() {
		return rejected;
	}


	public void setRejected(String rejected) {
		this.rejected = rejected;
	}


	public String getProcess() {
		return process;
	}


	public void setProcess(String process) {
		this.process = process;
	}


	public String getComplete() {
		return complete;
	}


	public void setComplete(String complete) {
		this.complete = complete;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getSubmitted() {
		return submitted;
	}


	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}



 
  
 
 
}