package jp.co.sample.emp_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import jp.co.sample.emp_management.domain.Employee;
import jp.co.sample.emp_management.form.findByNameForm;
import jp.co.sample.emp_management.repository.EmployeeRepository;

/**
 * 従業員情報を操作するサービス.
 * 
 * @author igamasayuki
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * 従業員情報を全件取得します.
	 * 
	 * @return　従業員情報一覧
	 */
	public List<Employee> showList() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	/**
	 * 従業員情報を取得します.
	 * 
	 * @param id ID
	 * @return 従業員情報
	 * @throws org.springframework.dao.DataAccessException 検索されない場合は例外が発生します
	 */
	public Employee showDetail(Integer id) {
		Employee employee = employeeRepository.load(id);
		return employee;
	}
	
	/**
	 * 従業員情報を更新します.
	 * 
	 * @param employee 更新した従業員情報
	 */
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}
	
	/**
	 * 従業員の氏名を曖昧検索する
	 * 
　	 * @param form　従業員のフォームクラス
	 * @return　検索結果
	 */
	public List<Employee>findByName(findByNameForm form){
		
		List<Employee>employeeAllList=employeeRepository.findAll();
		
		//検索フォームに何も入力されなかったら全件検索結果を表示
		if(form.getName().isEmpty()) {
			System.out.println("検索フォームに何も検索されなかった"+employeeAllList);
			return employeeAllList;
			//曖昧検索が該当すればその検索結果を表示
		}else {
			List<Employee>employeeNameList=employeeRepository.findByName(form.getName());
			System.out.println("検索フォームに入力された"+form.getName()+employeeNameList);
			//model.addAttribute("model","1件も見つかりませんでした");
			
			return employeeNameList;
		}		
		
	}
}
