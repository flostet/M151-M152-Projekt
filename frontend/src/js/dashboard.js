import { getCoinFromCoingecko } from "./script.js";
import { getAuth } from "./script.js";
import { getWalletsfromUser } from "./script.js";

const totalAmount = document.getElementById("totalAmount");
const walletDashboard = document.getElementById("walletDashboard");
const totalChange = document.getElementById("totalChange");

checkIfAdmin();

loadWallets();

8


async function loadWallets() {
  const user  = await getAuth();
  if(user.authorities.authority == 'ADMIN'){
    location.href = 'admin.html';
  }
  var wallets  = await getWalletsfromUser(user.name);
  
  wallets.forEach((wallet) => {
    createWalletCard(wallet);
  });

  setTotalChange(user.name);
}

async function createWalletCard(wallet) {
  var walletCard = document.createElement("div");
  walletCard.className = "dashboard-currency";
  walletDashboard.appendChild(walletCard);
  var coinSymbol = document.createElement("img");
  walletCard.appendChild(coinSymbol);
  var coinName = document.createElement("a");
  walletCard.appendChild(coinName);
  var walletAmount = document.createElement("a");
  walletCard.appendChild(walletAmount);

  if(wallet.coin.shortname == 'chf'){
      coinSymbol.src = "assets/chf-icon.png";
      coinName.innerText = wallet.coin.name;
      walletAmount.innerText = wallet.coinamount.toFixed(2);
      setTotalAmount(wallet.coinamount);
  } else {
      const coingecko = await getCoinFromCoingecko(wallet.coin.coingeckoID);
      coinSymbol.src = coingecko.image.small;
      coinName.innerText = wallet.coin.name;
      walletAmount.innerText = (wallet.coinamount * coingecko.market_data.current_price.chf).toFixed(2);
      setTotalAmount(parseFloat(walletAmount.innerText));
  }
}

function setTotalAmount(newAmount){
    var amountNow = parseFloat(totalAmount.innerText);
    totalAmount.innerText = (amountNow + newAmount).toFixed(2);
}

async function setTotalChange(name){
    var wallets = await getWalletsfromUser(name);
    var change = 0;
    var portfoliovalue = totalAmount.innerText;

    wallets.forEach((wallet) => {
      change = wallet.investedamount;
    });

    totalChange.innerText = (portfoliovalue - change).toFixed(2);
}

async function checkIfAdmin(){
  const user  = await getAuth();
  if(user.authorities.authority == 'ADMIN'){
    location.href('/admin.html');
  }
}