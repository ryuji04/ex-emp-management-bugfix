package jp.co.sample.emp_management.domain;

/**
 * 管理者情報を表すドメイン.
 * 
 * @author igamasayuki
 * 
 */
public class Administrator {
	/** id(主キー) */
	private Integer id;
	/** 名前 */
	private String name;
	/** メールアドレス */
	private String mailAddress;
	/** パスワード */
	private String password;
	/** 確認用パスワード */
	private String confirmationPass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmationPass() {
		return confirmationPass;
	}
	public void setConfirmationPass(String confirmationPass) {
		this.confirmationPass = confirmationPass;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ ", confirmationPass=" + confirmationPass + "]";
	}

	
}
