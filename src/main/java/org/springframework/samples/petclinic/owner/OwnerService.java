package org.springframework.samples.petclinic.owner;

import org.springframework.stereotype.Service;

@Service
public class OwnerService {

	// OwnerRepository 型のフィールドを宣言
	private final OwnerRepository ownerRepository;

	// コンストラクタでリポジトリを注入
	public OwnerService(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	// オーナーの件数を取得するメソッドを追加
	public long getOwnerCount() {
		return ownerRepository.countOwners(); // ここでリポジトリのメソッドを呼び出す
	}

}
