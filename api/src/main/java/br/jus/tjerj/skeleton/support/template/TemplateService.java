package br.jus.tjerj.skeleton.support.template;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class TemplateService {
	
	@Autowired
	private TemplateEngine templateEngine;
	
	public String getTemplate(String templateName, Map<String, Object> variables) {
		Context context = new Context();
		context.setVariables(variables);
		return templateEngine.process(templateName, context);
	}

}
