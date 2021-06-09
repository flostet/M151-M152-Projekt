export async function login(name, password){
    const data = {
        'name': name,
        'password': password
    }

    const response = await fetch("http://localhost:8080/auth/login", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })

    console.log(response);
    location.href = "/dashboard.html";
    
    if (response.status == 200){
        
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
    
    if (response.status == 200){
        login(name, password)
    }
}