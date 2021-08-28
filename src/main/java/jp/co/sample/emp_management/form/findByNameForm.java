package jp.co.sample.emp_management.form;
/**
 * 従業員の名前を曖昧検索するフォームクラス
 * 
 * @author adachiryuji
 *
 */
public class findByNameForm {
	/** 従業員の名前 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "nameSearchEmployee [name=" + name + "]";
	}
}
