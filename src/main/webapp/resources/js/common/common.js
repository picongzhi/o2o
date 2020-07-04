function changeVerifyCode(img) {
    img.src = '/kaptcha?' + Math.floor(Math.random() * 10000);
}

function getQueryString(name) {
    let reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)');
    var result = window.location.search.substr(1).match(reg);
    return result == null ? '' : decodeURIComponent(result[2]);
}