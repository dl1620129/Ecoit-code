package elegal.object;

public class SignerObject {
    private long sigId;
    private String fullName;
    
    public SignerObject() {
	}
    
    public long getSigId() {
		return sigId;
	}
    
    public String getFullName() {
		return fullName;
	}
    
    public void setSigId(long sigId) {
		this.sigId = sigId;
	}
    
    public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
