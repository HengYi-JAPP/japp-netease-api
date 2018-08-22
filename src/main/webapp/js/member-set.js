var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var MemberSet = /** @class */ (function () {
    function MemberSet() {
        this.$content = $('#page-content');
    }
    MemberSet.prototype.fillData = function (res) {
        var _this = this;
        var $navTabs = $('<ul class="nav nav-tabs"></ul>');
        var $tabContents = $('<div class="tab-content"></div>');
        res.forEach(function (sheet, i) {
            var tabContentId = 'tabContent' + i;
            var $navTab = $('<li><a href="javascript;" data-target="#' + tabContentId + '" data-toggle="tab">' + sheet.sheetName + '</a></li>');
            $navTabs.append($navTab);
            var $tabContent = $('<div class="tab-pane fade" id="' + tabContentId + '"></div>');
            $tabContent.append(_this.generateMemberTable(sheet.rows));
            $tabContents.append($tabContent);
            if (i === 0) {
                $navTab.addClass('active');
                $tabContent.addClass('active in');
            }
        });
        this.$content.empty();
        this.$content.append($navTabs);
        this.$content.append($tabContents);
    };
    MemberSet.prototype.generateMemberTable = function (rows) {
        var $table = $('<table class="table table-striped table-hover"></table>');
        var $head = $('<thead></thead>');
        $table.append($head);
        var $body = $('<tbody></tbody>');
        $table.append($body);
        rows.forEach(function (ele, i) {
            if (i === 0) {
                var $tr = $('<tr><th>' + ele.hrId + '</th><th>' + ele.name + '</th></tr>');
                $head.append($tr);
            }
            else {
                var $tr = $('<tr><td>' + ele.hrId + '</td><td>' + ele.name + '</td></tr>');
                $body.append($tr);
            }
        });
        return $table;
    };
    return MemberSet;
}());
var WhiteSetPage = /** @class */ (function (_super) {
    __extends(WhiteSetPage, _super);
    function WhiteSetPage() {
        var _this = _super.call(this) || this;
        $('#uploader-white-set').uploader({
            autoUpload: true,
            url: './api/uploads/whiteSet',
            responseHandler: function (res) { return _this.fillData(JSON.parse(res.response)); }
        });
        $.getJSON('./api/uploads/whiteSet').then(function (res) { return _this.fillData(res); });
        return _this;
    }
    return WhiteSetPage;
}(MemberSet));
var BlackSetPage = /** @class */ (function (_super) {
    __extends(BlackSetPage, _super);
    function BlackSetPage() {
        var _this = _super.call(this) || this;
        $('#uploader-black-set').uploader({
            autoUpload: true,
            url: './api/uploads/blackSet',
            responseHandler: function (res) { return _this.fillData(JSON.parse(res.response)); }
        });
        $.getJSON('./api/uploads/blackSet').then(function (res) { return _this.fillData(res); });
        return _this;
    }
    return BlackSetPage;
}(MemberSet));
