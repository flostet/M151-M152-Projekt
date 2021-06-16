export async function login(name, password){
    const data = {
        'name': name,
        'password': password
    }

    const response = await fetch("http://localhost:8080/auth/login", {
        method: 'POST',
        credentials: 'include',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })


    if (response.status == 200){
        location.href = "dashboard.html";
    }
}

export async function register(name, email, password){
    const data = {
        'name': name,
        'email': email,
        'password': password
    }

    const response = await fetch("http://localhost:8080/auth/register", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })

    var inhalt = await response.json();
    console.log(inhalt);
    
    if (response.status == 200){
        login(name, password)
    }
}

export function getURLParam(){
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    return urlParams.get('coin');
}

export async function getCoinFromCoingecko(coingeckoId){
    const response = await fetch('https://api.coingecko.com/api/v3/coins/' + coingeckoId);
    return await response.json();
}

export async function loadCoins(){
    const response = await fetch("http://localhost:8080/coins/");
    var resp = await response.json();
    return resp;
}

export async function getWalletsfromUser(username){
    const response = await fetch("http://localhost:8080/wallets/user/" + username);
    return await response.json();
}

export async function getAuth(){
    const response = await fetch('http://localhost:8080/auth/info', {
        method: 'GET',
        credentials: 'include'})

    const body = await response.json()
    return body;
}

export async function deleteCoin(name){
    const response = await fetch('http://localhost:8080/coins/delete/' + name, {
        method: 'DELETE',
    });
    return response.status;
}