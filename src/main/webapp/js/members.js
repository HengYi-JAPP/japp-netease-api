var Members = /** @class */ (function () {
    function Members() {
        var _this = this;
        this.$content = $('#page-content');
        $.getJSON('./api/test/members').then(function (rows) {
            var $table = $('<table class="table table-striped table-hover"></table>');
            var $head = $('<thead><tr><th>(' + rows.length + ')</th><th>员工号</th><th>姓名</th></tr></thead>');
            $table.append($head);
            var $body = $('<tbody></tbody>');
            $table.append($body);
            rows.forEach(function (ele, i) {
                var $tr = $('<tr><td>' + (i + 1) + '</td><td>' + ele.workcode + '</td><td>' + ele.name + '</td></tr>');
                $body.append($tr);
            });
            _this.$content.empty();
            _this.$content.append($table);
        });
    }
    return Members;
}());
