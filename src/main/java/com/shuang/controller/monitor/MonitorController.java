package com.shuang.controller.monitor;

import com.shuang.service.monitor.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/")
@Controller
@ApiIgnore
public class MonitorController {

	@Autowired
	private MonitorService monitorService;

	/**
	 * 新版心跳程序，通过servcie从数据库抓取当前时间
	 *
	 * @return JSON
	 * @author xuan.zhou
	 */
	@RequestMapping(value = {"/test/monitor/ping.do"}, method = {RequestMethod.GET,
			RequestMethod.POST})
	public @ResponseBody
	Map<String, Object> databaseheartbeat(HttpServletRequest request,
	                                      HttpServletResponse response,
	                                      Map<String, Object> modelMap) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", "");
        Date date =monitorService.getDataBaseCurrentTime();
        try {
			if (date != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				result.put("success", "true");
				result.put("data", sdf.format(date));
			} else {
				result.put("success", "false");
			}
		} catch (Exception e) {
			result.put("success", "false");
		}
		return result;
	}


	/**
	 * 新版心跳程序，通过servcie从数据库抓取当前时间
	 *
	 * @return JSON
	 * @author xuan.zhou
	 */
	@RequestMapping(value = {"/test/threadSafety.do"}, method = {RequestMethod.GET,
			RequestMethod.POST})
	public @ResponseBody
	Map<String, Object> threadSafety(HttpServletRequest request,
										  HttpServletResponse response,
										  Map<String, Object> modelMap) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		return result;
	}
}
