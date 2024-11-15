package org.springframework.samples.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private final OwnerService ownerService;

	@Autowired
	public HomeController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@GetMapping("/home")
	public String showHomePage(Model model) {
		// OwnerService を使ってオーナーの数を取得
		long ownerCount = ownerService.getOwnerCount();

		// オーナー数を model に追加してビューに渡す
		model.addAttribute("ownerCount", ownerCount);

		// home.html を表示する
		return "home";
	}

}
