package org.springframework.samples.petclinic.owner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST API コントローラのアノテーション
@RequestMapping("/api/owners") // 基本の URL パスを設定
public class OwnerRestController {

	private final OwnerService ownerService;

	// コンストラクタで OwnerService を注入
	public OwnerRestController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	// /api/owners/count に対する GET リクエストを処理
	@GetMapping("/count")
	public long getOwnerCount() {
		// OwnerService を使ってオーナー数を取得して返す
		return ownerService.getOwnerCount();
	}

}
