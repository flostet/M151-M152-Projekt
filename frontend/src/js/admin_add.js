import { addCoin } from "./script";

const name = document.getElementById('asset-name');
const shortcode = document.getElementById('asset-shortcode');
const coingecko = document.getElementById('asset-coingecko');
const button = document.getElementById('add-asset');

button.addEventListener('click', async() => {
    addNewCoin();
})

async function addNewCoin(){
    console.log('Test');
    const resp = await addCoin(name.value, shortcode.value, coingecko.value);

    if(resp.status == 200){
        location.href('admin.html');
    }
}