package br.jus.tjerj.skeleton.support.template;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/template")
public class TemplateResource {

	@Autowired
	private TemplateService templateService; 

	@PostMapping
	public String retrieveEnvironment(@Valid @RequestBody String message) {
		Map<String,Object> variables = new HashMap<>();
		variables.put("message", message);		
		return templateService.getTemplate("teste", variables);
	}

}
