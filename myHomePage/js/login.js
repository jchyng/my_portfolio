const loginForm = document.querySelector(".login-form");
const loginInput = document.querySelector(".login-input");
const greeting = document.querySelector("#greeting");

const HIDDEN_CLASSNAME = "hidden";
const USERNAME_KEY = "username";
const savedUsername = localStorage.getItem(USERNAME_KEY);

function onLoginSubmit(){
    loginForm.classList.add(HIDDEN_CLASSNAME);
    const username = loginInput.value;
    localStorage.setItem(USERNAME_KEY,username);
    paintGreeting(username);
}
function paintGreeting(username){
    greeting.innerText = `Hi, ${username}!`;
    greeting.classList.remove(HIDDEN_CLASSNAME);
}

if(savedUsername === null){
    loginForm.classList.remove(HIDDEN_CLASSNAME);
    loginForm.addEventListener("submit", onLoginSubmit);
}   else{
    paintGreeting(savedUsername);
}