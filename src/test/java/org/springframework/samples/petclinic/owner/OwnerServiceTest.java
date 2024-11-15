package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class OwnerServiceTest {

	// OwnerRepositoryをモック(模擬)化
	@MockBean
	private OwnerRepository ownerRepository;

	// 依存性の注入
	@Autowired
	private OwnerService ownerService;

	@Test
	public void testgetownercount() {
		// モックの動作を設定
		// OwnerRepositoryのcountOwners()メソッドが呼び出され
		// 10L（long 型の10）を返すよう設定
		// 参考程度：OngoingStubbing<Long> testcount =
		// Mockito.when(ownerRepository.countOwners()).thenReturn(10L);
		Mockito.when(ownerRepository.countOwners()).thenReturn(10L);
		// 実際にテスト対象のメソッドを呼び出し
		long count = ownerService.getOwnerCount();

		// 結果を検証
		Assertions.assertEquals(10L, count);
	}

}
