import { getAllWallets, loadCoins } from "./script.js";
import { getCoinFromCoingecko } from "./script.js";
import { getURLParam } from "./script.js";
import { deleteCoin } from "./script.js";
import { deleteWallet } from "./script.js";

const pricesTable = document.getElementById("prices-table");
const delbutton = document.getElementById('del-button');

loadCoinTable();

delbutton.addEventListener('click', async() => {
    location.href = 'admin_add.html';
})

async function loadCoinTable(){
    var coins = await loadCoins();
    const name = getURLParam();
    pricesTable.innerHTML = "<tr> <th>Name</th> <th>Price (CHF)</th> <th class='collapsable'>Market Cap (CHF)</th> <th class='collapsable'>Change (24h CHF)</th> <th class='collapsable'>Delete</th> </tr>";

    coins.forEach((coin) => {
        if(coin.shortname != 'chf'){
            createCoinCard(coin, name);
        }
      });
}

async function createCoinCard(coin, name){
    const coingecko = await getCoinFromCoingecko(coin.coingeckoID);
    const spacer1 = document.createElement('tr');
    spacer1.className = 'spacer';
    pricesTable.appendChild(spacer1);
    const tr = document.createElement('tr');
    tr.className = 'prices-table-element';
    pricesTable.appendChild(tr);

    const nameElement = document.createElement('td');
    nameElement.className = 'prices-table-element-name';
    tr.appendChild(nameElement);
    const symbol = document.createElement('img');
    symbol.src = coingecko.image.small;
    nameElement.appendChild(symbol);
    const nameDiv = document.createElement('div');
    nameDiv.className = 'prices-table-element-name-div';
    nameElement.appendChild(nameDiv);
    const shortname = document.createElement('a');
    shortname.innerText = coin.shortname.toUpperCase();
    nameDiv.appendChild(shortname);
    var coinname = document.createElement('a');
    coinname.innerText = coin.name;
    nameDiv.appendChild(coinname);

    const price = document.createElement('td');
    price.innerText = coingecko.market_data.current_price.chf;
    tr.appendChild(price);

    const marketCap = document.createElement('td');
    marketCap.className = 'collapsable';
    marketCap.innerText = coingecko.market_data.market_cap.chf;
    tr.appendChild(marketCap);

    const change = document.createElement('td');
    change.className = 'collapsable';
    change.innerText = coingecko.market_data.price_change_24h;
    tr.appendChild(change);

    const buy = document.createElement('td');
    tr.appendChild(buy);
    const buybutton = document.createElement('button');
    buybutton.innerText = 'Delete';
    buy.appendChild(buybutton);

    buybutton.addEventListener('click', async() => {

        var resp = await fetch('http://localhost:8080/coins/id/' + coin.coingeckoID);
        var coinid = await resp.json();

        delWallet(coinid);
        delCoin(coin.shortname);
    })
}

async function delWallet(id){
    return await deleteWallet(id);
}

async function delCoin(shortname){
    var resp = await deleteCoin(shortname);
    pricesTable.innerHTML = "";
    loadCoinTable();
}