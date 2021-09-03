package org.ada.school.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health")
public class HealthController {

    private static final String HEALTH_MESSAGE = "API Working OK!";

	@GetMapping
	public String all() {

		return HEALTH_MESSAGE;
	}

}
