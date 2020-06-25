$(function () {
    let initUrl = '/shopManagement/getShopInitInfo';
    let registerShopUrl = '/shopManagement/registerShop';

    getShopInitInfo();

    function getShopInitInfo() {
        $.getJSON(initUrl, function (data) {
            if (data.success) {
                console.log(data);
                var tempCategoryHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function (item, index) {
                    tempCategoryHtml += '<option data-id="' + item.shopCategoryId + '">' +
                        item.shopCategoryName + '</option>';
                });
                data.areaList.map(function (item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">' +
                        item.areaName + '</option>';
                });

                $('#shop-category').html(tempCategoryHtml);
                $('#shop-area').html(tempAreaHtml);
            }
        });
    }

    $('#submit').click(function () {
        var shop = {};
        shop.shopName = $('#shop-name').val();
        shop.shopAddr = $('#shop-addr').val();
        shop.phone = $('#shop-phone').val();
        shop.shopDesc = $('#shop-desc').val();
        shop.shopCategory = {
            shopCategoryId: $('#shop-category')
                .find('option')
                .not(function () {
                    return !this.selected;
                })
                .data('id')
        };
        shop.area = {
            shopId: $('#shop-area')
                .find('option')
                .not(function () {
                    return !this.selected;
                })
                .data('id')
        };

        var verifyCode = $('#captcha').val();
        if (!verifyCode) {
            $.toast('请输入验证码');
            return;
        }

        console.log(shop);

        var shopImg = $('#shop-img')[0].files[0];
        var formData = new FormData();
        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));
        formData.append('verifyCode', verifyCode);

        console.log(formData);

        $.ajax({
            url: registerShopUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    $.toast('提交成功!');
                } else {
                    $.toast('提交失败!' + data.errMsg);
                }
                $('#captcha-img').click();
            }
        });
    });
});