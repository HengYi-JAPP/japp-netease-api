var CompaniesPage = /** @class */ (function () {
    function CompaniesPage() {
        var _this = this;
        this.$content = $('#page-content');
        this.companyUpdateModal = new CompanyUpdateModal(this);
        $.getJSON('./api/configs/companies').then(function (res) {
            _this.companies = res;
            _this.refresh();
        });
    }
    CompaniesPage.prototype.refresh = function () {
        var _this = this;
        var $table = $('<table class="table table-striped table-hover"></table>');
        var $head = $('<thead><tr><th>(' + this.companies.length + ')</th><th>名称</th></tr></thead>');
        $table.append($head);
        var $body = $('<tbody></tbody>');
        $table.append($body);
        this.companies.forEach(function (company, i) {
            var $tr = $('<tr><td>' + (i + 1) + '</td><td>' + company.subcompanyname + '</td></tr>');
            $tr.on('click', function () {
                if (window.confirm('删除?')) {
                    $.ajax({
                        type: 'DELETE',
                        url: './api/configs/companies/' + company.id,
                        contentType: 'application/json',
                        dataType: 'json',
                    }).then(function () {
                        _this.companies = _this.companies.filter(function (it) { return it.id !== company.id; });
                        _this.refresh();
                    });
                }
            });
            $body.append($tr);
        });
        this.$content.empty();
        this.$content.append($table);
    };
    CompaniesPage.prototype.isExist = function (company) {
        return this.companies.find(function (it) { return it.id === company.id; });
    };
    CompaniesPage.prototype.add = function (company) {
        this.companies.unshift(company);
        this.refresh();
    };
    return CompaniesPage;
}());
var CompanyUpdateModal = /** @class */ (function () {
    function CompanyUpdateModal(page) {
        this.page = page;
        this.$modal = $('#companyUpdateModal');
        this.$modalBody = this.$modal.find('.modal-body');
    }
    CompanyUpdateModal.prototype.update = function () {
        var _this = this;
        $.getJSON('./api/oas/companies').then(function (res) {
            _this.companies = res.filter(function (it) { return !_this.page.isExist(it); });
            _this.$modalBody.empty();
            _this.$modalBody.append(_this.generateTable());
            _this.$modal.modal({ moveable: true, rememberPos: true });
        });
    };
    CompanyUpdateModal.prototype.generateTable = function () {
        var _this = this;
        var $table = $('<table class="table table-striped table-hover"></table>');
        var $head = $('<thead><tr><th></th><th>名称</th></tr></thead>');
        $table.append($head);
        var $body = $('<tbody></tbody>');
        $table.append($body);
        this.companies.forEach(function (company, i) {
            var $tr = $('<tr><td>' + (i + 1) + '</td><td>' + company.subcompanyname + '</td></tr>');
            $tr.on('click', function () {
                $.ajax({
                    type: 'PUT',
                    url: './api/configs/companies/' + company.id,
                    contentType: 'application/json',
                    dataType: 'json',
                }).then(function () {
                    $tr.toggle();
                    _this.page.add(company);
                });
            });
            $body.append($tr);
        });
        return $table;
    };
    return CompanyUpdateModal;
}());
