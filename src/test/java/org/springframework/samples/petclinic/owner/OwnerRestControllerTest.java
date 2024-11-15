package org.springframework.samples.petclinic.owner;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//特定のコントローラーだけをテスト
@WebMvcTest(OwnerRestController.class)
public class OwnerRestControllerTest {

	// OwnerServiceをモック(模擬)化
	@MockBean
	private OwnerService ownerService;

	// 依存性の注入
	@Autowired
	private MockMvc mockMvc; // Web レイヤーを HTTP サーバーを起動せずにテスト

	@Test
	public void testGetOwnerCountEndpoint() throws Exception {
		// サービス層のモック(返り値を設定)設定
		Mockito.when(ownerService.getOwnerCount()).thenReturn(10L);

		// エンドポイント呼び出しとレスポンスの検証
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/owners/count"))
			.andExpect(status().isOk())
			.andExpect(content().string("10"));

	}

}