function changeVerifyCode(img) {
    img.src = '/kaptcha?' + Math.floor(Math.random() * 10000);
}