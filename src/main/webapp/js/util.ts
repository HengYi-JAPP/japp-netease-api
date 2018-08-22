declare var $: any;
declare var jQuery: any;
declare var moment: any;

class _J {
    static generateMemberTable(rows: any[]) {
        const $table = $('<table class="table table-striped table-hover"></table>');
        const $head = $('<thead><tr><th>员工号</th><th>姓名</th></tr></thead>');
        $table.append($head);
        const $body = $('<tbody></tbody>');
        $table.append($body);
        rows.forEach((ele, i) => {
            const $tr = $('<tr><td>' + ele.hrId + '</td><td>' + ele.name + '</td></tr>');
            $body.append($tr);
        });
        return $table;
    }
}

window['J'] = _J;