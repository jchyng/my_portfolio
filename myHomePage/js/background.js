const imgs = ["1.jpg","2.jpg","3.jpg"];
const img = imgs[Math.floor(Math.random() * imgs.length)] ;

document.querySelector("body").style.backgroundImage = `url(img/${img})`;
