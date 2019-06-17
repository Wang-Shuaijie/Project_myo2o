package com.wsj.myo2o.web.Administrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/administrator", method = { RequestMethod.GET,RequestMethod.POST })
public class AdministratorContorller {
	/*@RequestMapping(value = "/bbb", method = RequestMethod.GET)
	private String register() {
		return "shop/bbb";
	}*/

	@RequestMapping(value = "/areamanage", method = RequestMethod.GET)
	private String areaManagement() {
		return "administrator/areamanage";
	}

	@RequestMapping(value = "/headlinemanage", method = RequestMethod.GET)
	private String headLineManagement() {
		return "administrator/headlinemanage";
	}

	@RequestMapping(value = "/shopcategorymanage", method = RequestMethod.GET)
	private String shopCategoryManage() {
		return "administrator/shopcategorymanage";
	}

	@RequestMapping(value = "/shopmanage", method = RequestMethod.GET)
	private String shopManage() {
		return "administrator/shopmanage";
	}

	@RequestMapping(value = "/personinfomanage", method = RequestMethod.GET)
	private String personInfoManage() {
		return "administrator/personinfomanage";
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	private String main() {
		return "administrator/main";
	}
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	private String top() {
		return "administrator/top";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String login() {
		return "administrator/login";
	}
}
