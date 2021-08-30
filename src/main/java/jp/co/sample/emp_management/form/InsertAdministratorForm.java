package jp.co.sample.emp_management.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message="氏名を入力してください")//名前が未入力だった場合エラー表示
	private String name;
	/** メールアドレス */
	@Email(message="Eメールの形式がふせいです")//メールアドレスが未入力だった場合またはメール形式でなければエラー表示
	@NotBlank(message="メールアドレス入力してください")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message="パスワードを入力してください")//パスワード未入力またはパスワードが1文字以上10文字以内でなければエラー表示
	@Size(min=1,max=10,message="パスワードは1文字以上10文字以内です")
	private String password;
	/** 確認用パスワード　*/
	private String confirmationPass;
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
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ ", confirmationPass=" + confirmationPass + "]";
	}

	
}
