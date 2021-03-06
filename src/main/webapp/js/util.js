var _J = /** @class */ (function () {
    function _J() {
    }
    _J.generateMemberTable = function (rows) {
        var $table = $('<table class="table table-striped table-hover"></table>');
        var $head = $('<thead><tr><th>员工号</th><th>姓名</th></tr></thead>');
        $table.append($head);
        var $body = $('<tbody></tbody>');
        $table.append($body);
        rows.forEach(function (ele, i) {
            var $tr = $('<tr><td>' + ele.hrId + '</td><td>' + ele.name + '</td></tr>');
            $body.append($tr);
        });
        return $table;
    };
    return _J;
}());
window['J'] = _J;
