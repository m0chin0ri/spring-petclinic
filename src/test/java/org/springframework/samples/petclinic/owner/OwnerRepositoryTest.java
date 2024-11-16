package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnerRepositoryTest {

	// 依存性の注入
	@Autowired
	private OwnerRepository oweRepository;

	@Test
	// countOwnersのテストメソッド
	public void testCountOwners() {
		// 想定しているオーナー数
		long expectedCount = 10;
		// 注入したoweRepositoryのcountOwnersメソッドを変数化
		long count = oweRepository.countOwners();
		// 想定しているオーナー数と比較してテスト
		Assertions.assertEquals(expectedCount, count, "オーナーの数が正しいことを確認");
	}

}
