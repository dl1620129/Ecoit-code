package com.ecoit.captcha.object;

public class CaptchaObject {
	private String captchaId;
    private String captchaCode;
    
    public CaptchaObject() {
		
	}
    
    public String getCaptchaId() {
		return captchaId;
	}
    
    public String getCaptchaCode() {
		return captchaCode;
	}
    
    public void setCaptchaId(String captchaId) {
		this.captchaId = captchaId;
	}
    
    public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}
}
