package com.example.javacrypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wallet")
public class CryptoAssetResource {

	@Autowired
	CryptoAssetRepository cryptoAssetRepository;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{symbol}")
	CryptoAsset get(@PathVariable String symbol) {
		CryptoAsset cryptoAsset = cryptoAssetRepository.findById(symbol).get();

		cryptoAsset.setPrice(
				restTemplate.getForObject("https://api.binance.com/api/v3/ticker/24hr?symbol=" + symbol + "USDT",
						Binanceticker.class).getLastPrice());
		return cryptoAsset;

	}

}
