package jp.co.sample.emp_management.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.emp_management.domain.Administrator;
import jp.co.sample.emp_management.form.InsertAdministratorForm;
import jp.co.sample.emp_management.form.LoginForm;
import jp.co.sample.emp_management.service.AdministratorService;

/**
 * 管理者情報を操作するコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
<<<<<<< .merge_file_a14784
=======
	
	
>>>>>>> .merge_file_a01920

	@Autowired
	private AdministratorService administratorService;

	@Autowired
	private HttpSession session;

	/**
	 * 使用するフォームオブジェクトをリクエストスコープに格納する.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * 使用するフォームオブジェクトをリクエストスコープに格納する.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	/////////////////////////////////////////////////////
	// ユースケース：管理者を登録する
	/////////////////////////////////////////////////////
	/**
	 * 管理者登録画面を出力します.
	 * 
	 * @return 管理者登録画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	/**
	 * 管理者情報を登録します.
	 * 
	 * @param form 管理者情報用フォーム
	 * @return ログイン画面へリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(@Validated InsertAdministratorForm form, BindingResult result, String password,
			String confirmationPass,Model model) {

		

			// エラーがあった際は入力画面へ遷移するように追記、またパスワードと確認用パスワードが相違していてもエラーになるように追記
			if(!form.getPassword().equalsIgnoreCase(confirmationPass)){
				result.rejectValue("password",null,"確認用パスワードと異なります");
				result.rejectValue("confirmationPass",null,"パスワードと異なります");
			}
		
		
		if (result.hasErrors()) {
				return "administrator/insert";
			}
		
		Administrator administrator = new Administrator();
		// フォームからドメインにプロパティ値をコピー
		BeanUtils.copyProperties(form, administrator);
		administratorService.insert(administrator);
<<<<<<< .merge_file_a14784
		/** 従業員登録後、ログイン画面へ遷移するように修正しました */
		return "administrator/login";
=======

		/**　従業員登録後、ログイン画面へ遷移するように修正しました */
		return "redirect:/";
>>>>>>> .merge_file_a01920
	}

	/////////////////////////////////////////////////////
	// ユースケース：ログインをする
	/////////////////////////////////////////////////////
	/**
	 * ログイン画面を出力します.
	 * 
	 * @return ログイン画面
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}

	/**
	 * ログインします.
	 * 
	 * @param form   管理者情報用フォーム
	 * @param result エラー情報格納用オブッジェクト
	 * @return ログイン後の従業員一覧画面
	 */
	@RequestMapping("/login")
	public String login(LoginForm form, BindingResult result, Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		if (administrator == null) {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードが不正です。");
			return toLogin();
		}
		//管理者の名前を取得し、セッションスコープに格納するように追記
		String administratorName= administrator.getName();
		session.setAttribute("administratorName", administratorName);
		
		/**
		String administratorMailAddress=administrator.getMailAddress();
		model.addAttribute("administratorMailAddress",administratorMailAddress);
		
		String administratorPassword=administrator.getPassword();
		model.addAttribute("administratorPassword", administratorPassword);
		*/
		return "forward:/employee/showList";
	}

	/////////////////////////////////////////////////////
	// ユースケース：ログアウトをする
	/////////////////////////////////////////////////////
	/**
	 * ログアウトをします. (SpringSecurityに任せるためコメントアウトしました)
	 * 
	 * @return ログイン画面
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
<<<<<<< .merge_file_a14784

=======
	
	@RequestMapping("/create")
	public String create() {
		System.out.println("エラー開始");
		System.out.println(10/2);
		System.out.println("エラー終了");
		return null;
	}
	
>>>>>>> .merge_file_a01920
}
