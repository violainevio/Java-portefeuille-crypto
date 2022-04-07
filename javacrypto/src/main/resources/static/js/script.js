const wallet = document.getElementById("btc-wallet-total");
const price = document.getElementById("btc-current-price");

const button = document.getElementById("refresh");

button.onclick=function(){

fetch("https://api.binance.com/api/v3/ticker/24hr?symbol=BTCUSDT")
  .then(response => response.json())
  .then(data => {
    price.innerHTML=data.lastPrice;
    fetch("wallet/BTC")
        .then(response2 => response2.json())
        .then(data2 => {
          wallet.innerHTML=data2.total*data.lastPrice;
        });
  }); 
  
  }


/*
Pour la version serveur */

/*fetch("wallet/BTC")
  .then(response => response.json())
  .then(data => {
    price.innerHTML=data.price;
    wallet.innerHTML=data.total*data.price;
  });

}
*/

