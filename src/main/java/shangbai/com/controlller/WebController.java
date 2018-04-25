package shangbai.com.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("page")
public class WebController {
	
	@RequestMapping(value = "{pageName}")
	public ModelAndView pageUrl(@PathVariable("pageName") String pageName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(pageName);
		return mv;
	}

	@RequestMapping(value = "{moduleName}/{pageName}")
	public ModelAndView pageUrl(@PathVariable("moduleName") String moduleName,
			@PathVariable("pageName") String pageName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(moduleName + "/" + pageName);
		return mv;
	}

}
