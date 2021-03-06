import { getURLParam } from "./script.js";
import { getCoinFromCoingecko } from "./script.js";
import { getAuth } from "./script.js";
import { getWalletsfromUser } from "./script.js";
import { addWallet } from "./script.js";
import { deleteWalletWithWalletID } from "./script.js";

const detailCoin = getURLParam();
const coingecko = await getCoinFromCoingecko(detailCoin);
const user = await getAuth();
var walletID;

// html-elements
const coinimage = document.getElementById("coinimage");
const coinname = document.getElementById("coin-name");
const coinshortname = document.getElementById("coin-shortname");
const pricenow = document.getElementById("price-now");
const pricechangenow = document.getElementById("price-change-now");
const alltimehigh = document.getElementById("alltimehigh");
const marketcap = document.getElementById("market-cap");
const investedmoney = document.getElementById("investedmoney");
const valuenow = document.getElementById("valuenow");
const returnoninvestment = document.getElementById("returnoninvestment");
const walletcard = document.getElementById("wallet-card");
const inputbuy = document.getElementById("buy-coinamount");
const buttonBuy = document.getElementById("buynow");

buttonBuy.addEventListener('click', async() => {
  buyCoin();
})

loadPriceWidget();

loadChart();

async function loadPriceWidget() {
  // Coin Info Card
  coinimage.src = coingecko.image.small;
  coinname.innerText = coingecko.name;
  coinshortname.innerText = coingecko.symbol.toUpperCase();
  pricenow.innerText = "CHF " + coingecko.market_data.current_price.chf;
  pricechangenow.innerText =
    "CHF " +
    coingecko.market_data.price_change_24h_in_currency.chf.toFixed(5) +
    " / " +
    coingecko.market_data.price_change_percentage_24h +
    "%";
  if (coingecko.market_data.price_change_24h_in_currency.chf >= 0) {
    pricechangenow.className = "price-up";
  } else {
    pricechangenow.className = "price-down";
  }

  alltimehigh.innerText = "CHF " + coingecko.market_data.ath.chf;
  marketcap.innerText = "CHF " + coingecko.market_data.market_cap.chf;

  // Wallet Card
  getWalletForCoin();
  //investedmoney.innerText = coinwallet.investedamount;
}

async function getWalletForCoin() {
  var wallets = await getWalletsfromUser(user.name);

  wallets.forEach((wallet) => {
    if (wallet.coin.coingeckoID == detailCoin) {
      walletID = wallet.id;

      var now = (
        wallet.coinamount * coingecko.market_data.current_price.chf
      ).toFixed(2);
      var moneyinvested = wallet.investedamount;
      var returnmoney = parseFloat(now) - parseFloat(moneyinvested);

      investedmoney.innerText = "CHF " + moneyinvested;
      valuenow.innerText = "CHF " + now;
      returnoninvestment.innerText = "CHF " + returnmoney;

      if (returnmoney >= 0) {
        returnoninvestment.className = "price-up";
      } else if (returnmoney >= 0) {
        returnoninvestment.className = "price-down";
      }
    }
  });

  if(valuenow.innerText == ''){
    walletcard.innerHTML = '';
        walletcard.className = 'hidden';
  }
}

async function loadChart() {
  var resp = await fetch(
    "https://api.coingecko.com/api/v3/coins/" +
      detailCoin +
      "/market_chart?vs_currency=chf&days=7&interval=hourly"
  );
  var market_chart = await resp.json();
  var historyprices = market_chart.prices;
  var datearray = new Array();
  var pricearray = new Array();
  var i = 0;

  historyprices.forEach((price) => {
    var date = new Date(price[0]);
    datearray[i] = (date.getDate() + '/' + date.getMonth() + '/' + date.getFullYear());
    pricearray[i] = price[1];
    i++;
  });

  const data = {
    labels: datearray,
    datasets: [
      {
        label: coingecko.name,
        backgroundColor: "rgb(255, 99, 132)",
        borderColor: "rgb(255, 99, 132)",
        data: pricearray,
      },
    ],
  };

  const config = {
    type: "line",
    data,
    options: {},
  };

  var myChart = new Chart(document.getElementById("price-chart"), config);
}

async function buyCoin(){
  var user_resp = await fetch('http://localhost:8080/user/id/' + user.name)
  var userId = await user_resp.json()
  
  var coin_resp = await fetch('http://localhost:8080/coins/id/' + detailCoin)
  var coinid = await coin_resp.json();

  var coinamount = inputbuy.value;
  console.log(coingecko.market_data.current_price.chf);
  var investedamount = (coingecko.market_data.current_price.chf * coinamount); 

  var wallets = await getWalletsfromUser(user.name);
  var existingwallet = null;

  wallets.forEach((wallet) => {
    if (wallet.coin.coingeckoID == detailCoin) {
      existingwallet = wallet;
      investedamount = ((parseFloat(investedamount) + parseFloat(wallet.investedamount)));
      coinamount = (parseFloat(coinamount) + parseFloat(wallet.coinamount));
      deleteWalletWithWalletID(wallet.id);
    }
  });
    const data = {
      "coinId": coinid,
      "userId": userId,
      "coinamount": coinamount,
      "investedamount": investedamount
    }
    addWallet(data);
}