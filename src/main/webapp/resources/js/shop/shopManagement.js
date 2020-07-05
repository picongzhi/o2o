$(function () {
    var shopId = getQueryString('shopId');
    var shopInfoUrl = '/shopManagement/getShopManagementInfo?shopId=' + shopId;
    $.getJSON(shopInfoUrl, function (data) {
        if (data.redirect) {
            window.location.href = data.url;
        } else {
            if (data.shopId !== undefined && data.shopId !== null) {
                shopId = data.shopId;
            }

            $('#shop-info').attr('href', '/shopAdmin/shopOperation?shopId=' + shopId);
        }
    });
});