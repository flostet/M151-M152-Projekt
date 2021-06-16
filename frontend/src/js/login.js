import { login } from './script.js';
import { register } from './script.js';

const btnLogin = document.getElementById('btnLogin')
const btnRegister = document.getElementById('btnRegister')



btnLogin.addEventListener('click', () => {
    const name = document.getElementById('loginName').value;
    const password = document.getElementById('loginPwd').value;

    login(name, password);
})

btnRegister.addEventListener('click', () => {
    const email = document.getElementById('registerEmail').value;
    const name = document.getElementById('registerName').value;
    const password = document.getElementById('registerPwd').value;

    register(name, email, password);
})