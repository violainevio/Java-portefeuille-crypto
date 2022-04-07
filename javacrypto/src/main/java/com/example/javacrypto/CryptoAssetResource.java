package com.example.javacrypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class CryptoAssetResource {

	@Autowired
	CryptoAssetRepository cryptoAssetRepository;

	@GetMapping("/{symbol}")
	CryptoAsset get(@PathVariable String symbol) {
		return cryptoAssetRepository.findById(symbol).get();

	}

}
