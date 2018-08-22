var DepartmentsPage = /** @class */ (function () {
    function DepartmentsPage() {
        var _this = this;
        this.departments = [];
        this.$content = $('#page-content');
        this.departmentUpdateModal = new DepartmentUpdateModal(this);
        $.getJSON('./api/configs/departments').then(function (res) {
            _this.departments = res;
            _this.refresh();
        });
    }
    DepartmentsPage.prototype.refresh = function () {
        var _this = this;
        this.departments = this.departments.sort(function (o1, o2) { return o1.fullPathName.localeCompare(o2.fullPathName); });
        this.$content.empty();
        if (this.departments.length < 1) {
            return;
        }
        var $table = $('<table class="table table-striped table-hover"></table>');
        var $head = $('<thead><tr><th>(' + this.departments.length + ')</th><th>名称</th></tr></thead>');
        $table.append($head);
        var $body = $('<tbody></tbody>');
        $table.append($body);
        this.departments.forEach(function (department, i) {
            var $tr = $('<tr><td>' + (i + 1) + '</td><td>' + department.fullPathName + '</td></tr>');
            $tr.on('click', function () {
                if (window.confirm('删除?')) {
                    $.ajax({
                        type: 'DELETE',
                        url: './api/configs/departments/' + department.id,
                        contentType: 'application/json',
                        dataType: 'json',
                    }).then(function () {
                        _this.departments = _this.departments.filter(function (it) { return it.id !== department.id; });
                        _this.refresh();
                    });
                }
            });
            $body.append($tr);
        });
        this.$content.append($table);
    };
    DepartmentsPage.prototype.isExist = function (department) {
        return this.departments.find(function (it) { return it.id === department.id; });
    };
    DepartmentsPage.prototype.add = function (department) {
        this.departments.unshift(department);
        this.refresh();
    };
    return DepartmentsPage;
}());
var DepartmentUpdateModal = /** @class */ (function () {
    function DepartmentUpdateModal(page) {
        var _this = this;
        this.page = page;
        this.departments = [];
        this.$modal = $('#departmentUpdateModal');
        this.$modalBody = this.$modal.find('.modal-body');
        Rx.Observable.fromEvent(this.$modal.find('input[name="search"]'), 'keyup')
            .pluck('target', 'value')
            .debounce(500)
            .distinctUntilChanged()
            .filter(function (it) { return it; })
            .subscribe(function (q) {
            console.log('test', q);
            $.getJSON('./api/oas/departments?q=' + q).then(function (res) {
                _this.departments = res.filter(function (it) { return !_this.page.isExist(it); });
                _this.refresh();
            });
        });
    }
    DepartmentUpdateModal.prototype.update = function () {
        this.refresh();
        this.$modal.modal({ moveable: true, rememberPos: true, position: 40 });
    };
    DepartmentUpdateModal.prototype.refresh = function () {
        var _this = this;
        this.$modalBody.empty();
        if (this.departments.length < 1) {
            return;
        }
        var $table = $('<table class="table table-striped table-hover"></table>');
        var $head = $('<thead><tr><th></th><th>名称</th></tr></thead>');
        $table.append($head);
        var $body = $('<tbody></tbody>');
        $table.append($body);
        this.departments.forEach(function (department, i) {
            var $tr = $('<tr><td>' + (i + 1) + '</td><td>' + department.fullPathName + '</td></tr>');
            $tr.on('click', function () {
                $.ajax({
                    type: 'PUT',
                    url: './api/configs/departments/' + department.id,
                    contentType: 'application/json',
                    dataType: 'json',
                }).then(function () {
                    $tr.toggle();
                    _this.page.add(department);
                });
            });
            $body.append($tr);
        });
        this.$modalBody.append($table);
    };
    return DepartmentUpdateModal;
}());
