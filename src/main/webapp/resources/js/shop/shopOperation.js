$(function () {
    let shopId = getQueryString('shopId');
    let isEdit = !!shopId;

    let initUrl = '/shopManagement/getShopInitInfo';
    let registerShopUrl = '/shopManagement/registerShop';
    let shopInfoUrl = '/shopManagement/getShopById?shopId=' + shopId;
    let editShopUrl = '/shopManagement/modifyShop';

    if (isEdit) {
        getShopInfo(shopId);
    } else {
        getShopInitInfo();
    }

    function getShopInfo(shopId) {
        $.getJSON(shopInfoUrl, function (data) {
            if (data.success) {
                var shop = data.shop;
                $('#shop-name').val(shop.shopName);
                $('#shop-addr').val(shop.shopAddr);
                $('#shop-phone').val(shop.phone);
                $('#shop-desc').val(shop.shopDesc);

                var shopCategory = '<option data-id="' +
                    shop.shopCategory.shopCategoryId + '" selected>' +
                    shop.shopCategory.shopCategoryName + '</option>';
                var areaHtml = '';
                data.areaList.map(function (item, index) {
                    areaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });

                $('#shop-category').html(shopCategory);
                $('#shop-category').attr('disabled', 'disabled');
                $('#shop-area').html(areaHtml);
                $('#shop-area option[data-id="' + shop.area.areaId + '"]')
                    .attr('selected', 'selected');
            }
        });
    }

    function getShopInitInfo() {
        $.getJSON(initUrl, function (data) {
            if (data.success) {
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
        if (isEdit) {
            shop.shopId = shopId;
        }

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
            areaId: $('#shop-area')
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

        $.ajax({
            url: isEdit ? editShopUrl : registerShopUrl,
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