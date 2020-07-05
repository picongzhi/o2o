$(function () {
    getShopList();

    function getShopList() {
        $.ajax({
            url: '/shopManagement/getShopList',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    handleShopList(data.shopList);
                    handleUser(data.user);
                }
            }
        });
    }

    function handleUser(user) {
        $('#user-name').text(user.name);
    }

    function handleShopList(shopList) {
        var html = '';
        shopList.map(function (item, index) {
            html += '<div class="row row-shop">' +
                '<div class="col-40">' + item.shopName + '</div>' +
                '<div class="col-40">' + shopStatus(item.enableStatus) + '</div>' +
                '<div class="col-20">' + goShop(item.enableStatus, item.shopId) + '</div>' +
                '</div>';
        });
        $('.shop-wrap').html(html);
    }

    function shopStatus(status) {
        if (status === 0) {
            return '审核中';
        } else if (status === -1) {
            return '店铺非法';
        } else if (status === 1) {
            return '审核通过';
        }
    }

    function goShop(status, id) {
        return status === 1 ? '<a href="/shopAdmin/shopManagement?shopId=' + id + '">进入</a>' : '';
    }
});