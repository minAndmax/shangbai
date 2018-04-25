package shangbai.com.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@RequestMapping(value = "/page/{pageName}")
	public ModelAndView pageUrl(@PathVariable("pageName") String pageName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(pageName);
		return mv;
	}

	@RequestMapping(value = "/page/{moduleName}/{pageName}")
	public ModelAndView pageUrl(@PathVariable("moduleName") String moduleName,
			@PathVariable("pageName") String pageName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(moduleName + "/" + pageName);
		return mv;
	}

}
