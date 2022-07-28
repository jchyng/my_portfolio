const API_KEY = "e02689edddc8b04bc8562886efb51154";

function onGeok(position){
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${API_KEY}&units=metric`;
    // console.log(url);
    fetch(url)
        .then((response) => response.json())
        .then((data) => {
            const city = document.querySelector("#weather .location");
            const weather = document.querySelector("#weather .weather");
            const temp = document.querySelector("#weather .temperature");
            city.innerText = data.name;
            weather.setAttribute('src',`img/icons/${data.weather[0].icon}.png`);
            temp.innerText = data.main.temp.toFixed(1)+"°C";
        });
}

function onError(){
    alert("Can't find you. No weather for you.");
}

navigator.geolocation.getCurrentPosition(onGeok,onError);

