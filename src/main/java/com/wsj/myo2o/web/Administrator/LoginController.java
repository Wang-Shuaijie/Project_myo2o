package com.wsj.myo2o.web.Administrator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsj.myo2o.entity.LocalAuth;
import com.wsj.myo2o.service.LocalAuthService;
import com.wsj.myo2o.util.HttpServletRequestUtil;
import com.wsj.myo2o.util.MD5;

@Controller
@RequestMapping("/administrator")
public class LoginController {
	@Autowired
	private LocalAuthService localAuthService;
	

	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> loginCheck(HttpServletRequest request){
		Map<String, Object> modelMap=new HashMap<>();
		String username = HttpServletRequestUtil.getString(request, "username");
		String password = HttpServletRequestUtil.getString(request, "password");
		if(username != null && password != null) {
			password = MD5.getMd5(password);
			LocalAuth localAuth = localAuthService
					.getLocalAuthByUsernameAndPwd(username, password);
			if (localAuth != null) {
				if (localAuth.getPersonInfo().getUserType() == 3) {
					modelMap.put("success", true);
					request.getSession().setAttribute("user",
							localAuth.getPersonInfo());
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", "非管理员没有权限访问");
				}
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "用户名或密码错误");
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名和密码均不能为空");
		}
		return modelMap;
	}
}
